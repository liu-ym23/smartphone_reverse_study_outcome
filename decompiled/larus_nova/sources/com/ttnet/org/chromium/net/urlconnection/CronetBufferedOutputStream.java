package com.ttnet.org.chromium.net.urlconnection;

import androidx.collection.SieveCacheKt;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
final class CronetBufferedOutputStream extends CronetOutputStream {
    private static final int INITIAL_BUFFER_SIZE = 16384;
    private ByteBuffer mBuffer;
    private boolean mConnected;
    private final CronetHttpURLConnection mConnection;
    private final int mInitialContentLength;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetBufferedOutputStream$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetBufferedOutputStream this$0;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            if (CronetBufferedOutputStream.access$100(this.this$0) != (-1)) goto L11;
            if (CronetBufferedOutputStream.access$200(this.this$0) == false) goto L7;
            int r100 = CronetBufferedOutputStream.access$300(this.this$0).limit();
        L9:
            return r100;
        L7:
            r100 = CronetBufferedOutputStream.access$300(this.this$0).position();
            goto L9
        L11:
            return CronetBufferedOutputStream.access$100(this.this$0);
        }

        private UploadDataProviderImpl(CronetBufferedOutputStream r100) {
            this.this$0 = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) {
            CronetBufferedOutputStream.access$300(this.this$0).position(0);
            r100.onRewindSucceeded();
        }

        public /* synthetic */ UploadDataProviderImpl(CronetBufferedOutputStream r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) {
            int r102 = r101.remaining();
            if (r102 >= CronetBufferedOutputStream.access$300(this.this$0).remaining()) goto L5;
            r101.put(CronetBufferedOutputStream.access$300(this.this$0).array(), CronetBufferedOutputStream.access$300(this.this$0).position(), r102);
            CronetBufferedOutputStream.access$300(this.this$0).position(CronetBufferedOutputStream.access$300(this.this$0).position() + r102);
        L6:
            r100.onReadSucceeded(false);
            return;
        L5:
            r101.put(CronetBufferedOutputStream.access$300(this.this$0));
            goto L6
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() throws IOException {
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() throws IOException {
        this.mConnected = true;
        if (this.mBuffer.position() < this.mInitialContentLength) goto L7;
        this.mBuffer.flip();
        return;
    L7:
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r100) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r100 == null) goto L6;
        this.mConnection = r100;
        this.mInitialContentLength = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
        return;
    L6:
        throw null;
    }

    public static /* synthetic */ int access$100(CronetBufferedOutputStream r100) {
        return r100.mInitialContentLength;
    }

    public static /* synthetic */ boolean access$200(CronetBufferedOutputStream r100) {
        return r100.mConnected;
    }

    public static /* synthetic */ ByteBuffer access$300(CronetBufferedOutputStream r100) {
        return r100.mBuffer;
    }

    private void ensureCanWrite(int r100) throws IOException {
        if (this.mInitialContentLength == (-1)) goto L10;
        if ((this.mBuffer.position() + r100) <= this.mInitialContentLength) goto L10;
        throw new ProtocolException("exceeded content-length limit of " + this.mInitialContentLength + " bytes");
    L10:
        if (this.mConnected == true) goto L20;
        if (this.mInitialContentLength == (-1)) goto L15;
        return;
    L15:
        if ((this.mBuffer.limit() - this.mBuffer.position()) <= r100) goto L17;
        return;
    L17:
        ByteBuffer r101 = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + r100));
        this.mBuffer.flip();
        r101.put(this.mBuffer);
        this.mBuffer = r101;
        return;
    L20:
        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for writing after connect");
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        checkNotClosed();
        ensureCanWrite(1);
        this.mBuffer.put((byte) r100);
    }

    public CronetBufferedOutputStream(CronetHttpURLConnection r100, long r101) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r100 == null) goto L15;
        if (r101 > SieveCacheKt.NodeLinkMask) goto L13;
        if (r101 < 0) goto L11;
        this.mConnection = r100;
        int r102 = (int) r101;
        this.mInitialContentLength = r102;
        this.mBuffer = ByteBuffer.allocate(r102);
        return;
    L11:
        throw new IllegalArgumentException("Content length < 0.");
    L13:
        throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
    L15:
        throw new NullPointerException("Argument connection cannot be null.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        checkNotClosed();
        ensureCanWrite(r102);
        this.mBuffer.put(r100, r101, r102);
    }
}
