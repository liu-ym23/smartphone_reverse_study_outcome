package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetChunkedOutputStream$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetChunkedOutputStream this$0;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return -1;
        }

        private UploadDataProviderImpl(CronetChunkedOutputStream r100) {
            this.this$0 = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) {
            r100.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ UploadDataProviderImpl(CronetChunkedOutputStream r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) {
            if (r101.remaining() < CronetChunkedOutputStream.access$100(this.this$0).remaining()) goto L7;
            r101.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).clear();
            r100.onReadSucceeded(CronetChunkedOutputStream.access$200(this.this$0));
            if (CronetChunkedOutputStream.access$200(this.this$0) == true) goto L9;
            CronetChunkedOutputStream.access$300(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r102 = CronetChunkedOutputStream.access$100(this.this$0).limit();
            CronetChunkedOutputStream.access$100(this.this$0).limit(CronetChunkedOutputStream.access$100(this.this$0).position() + r101.remaining());
            r101.put(CronetChunkedOutputStream.access$100(this.this$0));
            CronetChunkedOutputStream.access$100(this.this$0).limit(r102);
            r100.onReadSucceeded(false);
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() throws IOException {
    }

    private void ensureBufferHasRemaining() throws IOException {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        uploadBufferInternal();
        return;
    }

    private void uploadBufferInternal() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        executeMessageLoop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.mLastChunk == true) goto L6;
        this.mLastChunk = true;
        this.mBuffer.flip();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    public static /* synthetic */ ByteBuffer access$100(CronetChunkedOutputStream r100) {
        return r100.mBuffer;
    }

    public static /* synthetic */ boolean access$200(CronetChunkedOutputStream r100) {
        return r100.mLastChunk;
    }

    public static /* synthetic */ MessageLoop access$300(CronetChunkedOutputStream r100) {
        return r100.mMessageLoop;
    }

    private void executeMessageLoop(int r100) throws IOException {
        this.mMessageLoop.loop(r100);     // Catch: Exception -> L4 SocketTimeoutException -> L8
    L17:
        return;
    L8:
        CronetHttpURLConnection r101 = this.mConnection;
        if (r101 == null) goto L16;
        r101.onUploadTimeout();
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r100 / 2);
        return;
    L16:
        return;
    L4:
        e = move-exception;
        CronetHttpURLConnection r102 = this.mConnection;
        if (r102 == null) goto L14;
        r102.cancelWithException("Unexpected request usage, caught in CronetChunkedOutputStream", e);
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r100 / 2);
        return;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r100);
    }

    public CronetChunkedOutputStream(CronetHttpURLConnection r100, int r101, MessageLoop r102) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r100 == null) goto L9;
        if (r101 <= 0) goto L8;
        this.mBuffer = ByteBuffer.allocate(r101);
        this.mConnection = r100;
        this.mMessageLoop = r102;
        return;
    L8:
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    L9:
        throw null;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        checkNotClosed();
        if ((r100.length - r101) < r102) goto L11;
        if (r101 < 0) goto L11;
        if (r102 < 0) goto L11;
        int r103 = r102;
    L7:
        if (r103 <= 0) goto L9;
        int r104 = Math.min(r103, this.mBuffer.remaining());
        this.mBuffer.put(r100, (r101 + r102) - r103, r104);
        r103 = r103 - r104;
        ensureBufferHasRemaining();
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }
}
