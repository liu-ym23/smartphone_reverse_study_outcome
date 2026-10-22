package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class CronetFixedModeOutputStream extends CronetOutputStream {
    private static int sDefaultBufferLength = 16384;
    private final ByteBuffer mBuffer;
    private long mBytesWritten;
    private final CronetHttpURLConnection mConnection;
    private final long mContentLength;
    private boolean mIsRewinding;
    private final MessageLoop mMessageLoop;
    private boolean mSupportRewind;
    private final UploadDataProvider mUploadDataProvider;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.urlconnection.CronetFixedModeOutputStream$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class UploadDataProviderImpl extends UploadDataProvider {
        final /* synthetic */ CronetFixedModeOutputStream this$0;

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return CronetFixedModeOutputStream.access$100(this.this$0);
        }

        private UploadDataProviderImpl(CronetFixedModeOutputStream r100) {
            this.this$0 = r100;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r100) {
            if (CronetFixedModeOutputStream.access$500(this.this$0) == false) goto L5;
            CronetFixedModeOutputStream.access$302(this.this$0, true);
            CronetFixedModeOutputStream.access$200(this.this$0).rewind();
            r100.onRewindSucceeded();
            return;
        L5:
            r100.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }

        public /* synthetic */ UploadDataProviderImpl(CronetFixedModeOutputStream r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r100, ByteBuffer r101) {
            if (r101.remaining() < CronetFixedModeOutputStream.access$200(this.this$0).remaining()) goto L7;
            r101.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).clear();
            r100.onReadSucceeded(false);
            if (CronetFixedModeOutputStream.access$300(this.this$0) == true) goto L9;
            CronetFixedModeOutputStream.access$400(this.this$0).quit();
            return;
        L9:
            return;
        L7:
            int r102 = CronetFixedModeOutputStream.access$200(this.this$0).limit();
            CronetFixedModeOutputStream.access$200(this.this$0).limit(CronetFixedModeOutputStream.access$200(this.this$0).position() + r101.remaining());
            r101.put(CronetFixedModeOutputStream.access$200(this.this$0));
            CronetFixedModeOutputStream.access$200(this.this$0).limit(r102);
            r100.onReadSucceeded(false);
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() throws IOException {
    }

    private void ensureBufferHasRemaining() throws IOException {
        if (this.mBuffer.hasRemaining() == true) goto L6;
        this.mSupportRewind = false;
        uploadBufferInternal();
        return;
    }

    private void uploadIfComplete() throws IOException {
        if (this.mBytesWritten != this.mContentLength) goto L6;
        uploadBufferInternal();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() throws IOException {
        if (this.mBytesWritten < this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("Content received is less than Content-Length.");
    }

    private void uploadBufferInternal() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        executeMessageLoop(this.mConnection.getReadTimeout());
        checkNoException();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    public static /* synthetic */ long access$100(CronetFixedModeOutputStream r100) {
        return r100.mContentLength;
    }

    public static /* synthetic */ ByteBuffer access$200(CronetFixedModeOutputStream r100) {
        return r100.mBuffer;
    }

    public static /* synthetic */ boolean access$300(CronetFixedModeOutputStream r100) {
        return r100.mIsRewinding;
    }

    public static /* synthetic */ MessageLoop access$400(CronetFixedModeOutputStream r100) {
        return r100.mMessageLoop;
    }

    public static /* synthetic */ boolean access$500(CronetFixedModeOutputStream r100) {
        return r100.mSupportRewind;
    }

    private void checkNotExceedContentLength(int r100) throws ProtocolException {
        if ((this.mBytesWritten + ((long) r100)) > this.mContentLength) goto L6;
        return;
    L6:
        throw new ProtocolException("expected " + (this.mContentLength - this.mBytesWritten) + " bytes but received " + r100);
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
        r102.cancelWithException("Unexpected request usage, caught in CronetFixedModeOutputStream", e);
        this.mMessageLoop.reset();
        this.mMessageLoop.loop(r100 / 2);
        return;
    }

    public static void setDefaultBufferLengthForTesting(int r100) {
        sDefaultBufferLength = r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        checkNotClosed();
        checkNotExceedContentLength(1);
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) r100);
        this.mBytesWritten++;
        uploadIfComplete();
    }

    public static /* synthetic */ boolean access$302(CronetFixedModeOutputStream r100, boolean r101) {
        r100.mIsRewinding = r101;
        return r101;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        checkNotClosed();
        if ((r100.length - r101) < r102) goto L12;
        if (r101 < 0) goto L12;
        if (r102 < 0) goto L12;
        checkNotExceedContentLength(r102);
        int r103 = r102;
    L7:
        if (r103 <= 0) goto L9;
        ensureBufferHasRemaining();
        int r104 = Math.min(r103, this.mBuffer.remaining());
        this.mBuffer.put(r100, (r101 + r102) - r103, r104);
        r103 = r103 - r104;
        goto L7
    L9:
        this.mBytesWritten += (long) r102;
        uploadIfComplete();
        return;
    L12:
        throw new IndexOutOfBoundsException();
    }

    public CronetFixedModeOutputStream(CronetHttpURLConnection r100, long r101, int r102, MessageLoop r103) {
        this.mUploadDataProvider = new UploadDataProviderImpl(this, null);
        if (r100 != null) goto L5;
        throw null;
    L5:
        if (r101 < 0) goto L9;
        this.mContentLength = r101;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(r101, Math.max(sDefaultBufferLength, r102)));
        this.mConnection = r100;
        this.mMessageLoop = r103;
        this.mBytesWritten = 0;
        this.mSupportRewind = true;
        this.mIsRewinding = false;
        return;
    L9:
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }
}
