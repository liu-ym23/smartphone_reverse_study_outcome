package com.bytedance.common.wschannel.channel.impl.ok.ws;

import com.bytedance.common.utility.Logger;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes15.dex */
final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.a maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    int opcode;
    private final long readLimitLength;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int r100, String r101);

        void onReadMessage(String r100) throws IOException;

        void onReadMessage(ByteString r100) throws IOException;

        void onReadPing(ByteString r100);

        void onReadPong(ByteString r100);
    }

    private void readControlFrame() throws IOException {
        long r100 = this.frameLength;
        if (r100 <= 0) goto L7;
        this.source.readFully(this.controlFrameBuffer, r100);
        if (this.isClient == true) goto L7;
        this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.b(0);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L7:
        int r101 = this.opcode;
        if (r101 != 9) goto L11;
        this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
        return;
    L11:
        if (r101 != 10) goto L14;
        this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
        return;
    L14:
        if (r101 != 8) goto L30;
        long r102 = this.controlFrameBuffer.size();
        if (r102 == 1) goto L28;
        if (r102 == 0) goto L24;
        short r103 = this.controlFrameBuffer.readShort();
        String r104 = this.controlFrameBuffer.readUtf8();
        String r105 = WebSocketProtocol.closeCodeExceptionMessage(r103);
        if (r105 != null) goto L23;
    L25:
        this.frameCallback.onReadClose(r103, r104);
        this.closed = true;
        return;
    L23:
        throw new ProtocolException(r105);
    L24:
        r103 = 1005;
        r104 = "";
        goto L25
    L28:
        throw new ProtocolException("Malformed close payload length of 1.");
    L30:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
    }

    private void readHeader() throws IOException {
        if (this.closed == true) goto L73;
        long r100 = this.source.timeout().i();
        this.source.timeout().c();
        int r101 = this.source.readByte() & UByte.MAX_VALUE;
        this.source.timeout().h(r100, TimeUnit.NANOSECONDS);
        this.opcode = r101 & 15;
        boolean r102 = true;
        if ((r101 & 128) == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isFinalFrame = r103;
        if ((r101 & 8) == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isControlFrame = r104;
        if (r104 == false) goto L21;
        if (r103 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r101 & 64) == 0) goto L23;
        boolean r105 = true;
    L25:
        if ((r101 & 32) == 0) goto L27;
        boolean r106 = true;
    L29:
        if ((r101 & 16) == 0) goto L31;
        boolean r107 = true;
    L32:
        if (r105 == true) goto L68;
        if (r106 == true) goto L68;
        if (r107 == true) goto L68;
        int r108 = this.source.readByte() & UByte.MAX_VALUE;
        if ((r108 & 128) != 0) goto L40;
        r102 = false;
    L40:
        if (r102 == this.isClient) goto L42;
        long r109 = r108 & 127;
        this.frameLength = r109;
        if (r109 != 126) goto L51;
        this.frameLength = ((long) this.source.readShort()) & 65535;
    L58:
        if (this.isControlFrame == true) goto L60;
    L64:
        if (r102 == false) goto L76;
        this.source.readFully(this.maskKey);
        return;
    L76:
        return;
    L60:
        if (this.frameLength <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r109 != 127) goto L58;
        long r110 = this.source.readLong();
        this.frameLength = r110;
        if (r110 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.isClient == false) goto L44;
        String r111 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r111);
    L44:
        r111 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r107 = false;
        goto L32
    L27:
        r106 = false;
        goto L29
    L23:
        r105 = false;
        goto L25
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
    L69:
        th = move-exception;
        this.source.timeout().h(r100, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    private void readMessage() throws IOException {
    L3:
        if (this.closed == true) goto L18;
        long r100 = this.frameLength;
        if (r100 <= 0) goto L10;
        this.source.readFully(this.messageFrameBuffer, r100);
        if (this.isClient == true) goto L10;
        this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.b(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
    L11:
        return;
    L18:
        throw new IOException(PTYSocketStateCallback.CLOSED);
    }

    private void readMessageFrame() throws IOException {
        int r100 = this.opcode;
        if (r100 != 1) goto L5;
    L9:
        readMessage();
        if (r100 != 1) goto L12;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L12:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r100));
    }

    private void readUntilNonControlFrame() throws IOException {
    L3:
        if (this.closed == true) goto L12;
        readHeader();
        if (this.frameLength > this.readLimitLength) goto L6;
        if (this.isControlFrame == false) goto L16;
        readControlFrame();
        goto L3
    L16:
        return;
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        throwFrame(this.frameLength);
        return;
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.frameLength <= this.readLimitLength) goto L7;
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        throwFrame(this.frameLength);
        return;
    L7:
        if (this.isControlFrame == false) goto L9;
        readControlFrame();
        return;
    L9:
        readMessageFrame();
    }

    private void throwFrame(long r100) {
        this.source.skip(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public WebSocketReader(boolean r100, BufferedSource r101, FrameCallback r102, long r103) {
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        if (r101 == null) goto L18;
        if (r102 == null) goto L16;
        this.isClient = r100;
        this.source = r101;
        this.frameCallback = r102;
        this.readLimitLength = r103;
        Buffer.a r104 = null;
        if (r100 == false) goto L8;
        byte[] r105 = null;
    L9:
        this.maskKey = r105;
        if (r100 == true) goto L13;
        r104 = new Buffer.a();
    L13:
        this.maskCursor = r104;
        return;
    L8:
        r105 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }
}
