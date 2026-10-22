package com.bytedance.common.wschannel.channel.impl.ok.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.j0;

/* JADX INFO: loaded from: classes15.dex */
final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer;
    final FrameSink frameSink;
    final boolean isClient;
    private final Buffer.a maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    public final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;
        final /* synthetic */ WebSocketWriter this$0;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r100 = this.this$0;
            r100.writeMessageFrame(this.formatOpcode, r100.buffer.size(), this.isFirstFrame, true);
            this.closed = true;
            this.this$0.activeWriter = false;
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed == true) goto L7;
            WebSocketWriter r100 = this.this$0;
            r100.writeMessageFrame(this.formatOpcode, r100.buffer.size(), this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L7:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }

        @Override // okio.Sink
        public j0 timeout() {
            return this.this$0.sink.timeout();
        }

        public FrameSink(WebSocketWriter r100) {
            this.this$0 = r100;
        }

        @Override // okio.Sink
        public void write(Buffer r100, long r101) throws IOException {
            if (this.closed == true) goto L18;
            this.this$0.buffer.write(r100, r101);
            if (this.isFirstFrame == true) goto L7;
        L11:
            boolean r102 = false;
        L12:
            long r103 = this.this$0.buffer.completeSegmentByteCount();
            if (r103 <= 0) goto L19;
            if (r102 == true) goto L20;
            this.this$0.writeMessageFrame(this.formatOpcode, r103, this.isFirstFrame, false);
            this.isFirstFrame = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.contentLength == (-1)) goto L11;
            if (this.this$0.buffer.size() <= (this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r102 = true;
            goto L12
        L18:
            throw new IOException(PTYSocketStateCallback.CLOSED);
        }
    }

    public void writePing(ByteString r100) throws IOException {
        writeControlFrame(9, r100);
    }

    public void writePong(ByteString r100) throws IOException {
        writeControlFrame(10, r100);
    }

    private void writeControlFrame(int r100, ByteString r101) throws IOException {
        if (this.writerClosed == true) goto L17;
        int r102 = r101.size();
        if (r102 > 125) goto L15;
        this.sinkBuffer.writeByte(r100 | 128);
        if (this.isClient == false) goto L11;
        this.sinkBuffer.writeByte(r102 | 128);
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (r102 <= 0) goto L12;
        long r103 = this.sinkBuffer.size();
        this.sinkBuffer.write(r101);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.b(r103);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L12:
        this.sink.flush();
        return;
    L11:
        this.sinkBuffer.writeByte(r102);
        this.sinkBuffer.write(r101);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    public Sink newMessageSink(int r100, long r101) {
        if (this.activeWriter == true) goto L7;
        this.activeWriter = true;
        FrameSink r102 = this.frameSink;
        r102.formatOpcode = r100;
        r102.contentLength = r101;
        r102.isFirstFrame = true;
        r102.closed = false;
        return r102;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void writeClose(int r100, ByteString r101) throws IOException {
        ByteString r102 = ByteString.EMPTY;
        if (r100 != 0) goto L5;
        if (r101 != null) goto L5;
    L18:
        writeControlFrame(8, r102);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r100 == 0) goto L7;
        WebSocketProtocol.validateCloseCode(r100);
    L7:
        Buffer r103 = new Buffer();
        r103.writeShort(r100);
        if (r101 == null) goto L10;
        r103.write(r101);
    L10:
        r102 = r103.readByteString();
        goto L18
    }

    public WebSocketWriter(boolean r100, BufferedSink r101, Random r102) {
        this.buffer = new Buffer();
        this.frameSink = new FrameSink(this);
        if (r101 == null) goto L17;
        if (r102 == null) goto L15;
        this.isClient = r100;
        this.sink = r101;
        this.sinkBuffer = r101.buffer();
        this.random = r102;
        Buffer.a r103 = null;
        if (r100 == false) goto L8;
        byte[] r104 = new byte[4];
    L9:
        this.maskKey = r104;
        if (r100 == false) goto L12;
        r103 = new Buffer.a();
    L12:
        this.maskCursor = r103;
        return;
    L8:
        r104 = null;
        goto L9
    L15:
        throw new NullPointerException("random == null");
    L17:
        throw new NullPointerException("sink == null");
    }

    public void writeMessageFrame(int r100, long r101, boolean r102, boolean r103) throws IOException {
        if (this.writerClosed == true) goto L29;
        int r104 = 0;
        if (r102 == true) goto L8;
        r100 = 0;
    L8:
        if (r103 == false) goto L10;
        r100 = r100 | 128;
    L10:
        this.sinkBuffer.writeByte(r100);
        if (this.isClient == false) goto L14;
        r104 = 128;
    L14:
        if (r101 > 125) goto L17;
        Buffer r105 = this.sinkBuffer;
        r105.writeByte(((int) r101) | r104);
    L21:
        if (this.isClient == false) goto L25;
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (r101 <= 0) goto L26;
        long r106 = this.sinkBuffer.size();
        this.sinkBuffer.write(this.buffer, r101);
        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.b(r106);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L26:
        this.sink.emit();
        return;
    L25:
        this.sinkBuffer.write(this.buffer, r101);
        goto L26
    L17:
        if (r101 > 65535) goto L19;
        Buffer r107 = this.sinkBuffer;
        r107.writeByte(r104 | 126);
        this.sinkBuffer.writeShort((int) r101);
        goto L21
    L19:
        Buffer r108 = this.sinkBuffer;
        r108.writeByte(r104 | 127);
        this.sinkBuffer.writeLong(r101);
        goto L21
    L29:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }
}
