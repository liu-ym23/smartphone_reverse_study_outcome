package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("cronet")
public final class CronetUploadDataStream extends UploadDataSink {
    private static final String TAG = null;
    private ByteBuffer mByteBuffer;
    private long mByteBufferLimit;
    private volatile boolean mClosed;
    private final VersionSafeCallbacks.UploadDataProviderWrapper mDataProvider;
    private boolean mDestroyAdapterPostponed;
    private final Executor mExecutor;
    private int mInWhichUserCallback;
    private long mLength;
    private final Object mLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private final Runnable mReadTask;
    private long mRemainingLength;
    private final CronetUrlRequest mRequest;
    private long mUploadDataStreamAdapter;

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        long attachUploadDataToRequest(CronetUploadDataStream r100, long r101, long r102);

        long createAdapterForTesting(CronetUploadDataStream r100);

        long createUploadDataStreamForTesting(CronetUploadDataStream r100, long r101, long r102);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void destroy(long r100);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onReadSucceeded(long r100, CronetUploadDataStream r101, int r102, boolean r103);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onRewindSucceeded(long r100, CronetUploadDataStream r101);
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    static {
        TAG = "CronetUploadDataStream";
    }

    private void checkCallingThread() {
        this.mRequest.checkCallingThread();
    }

    private void destroyAdapter() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback != 0) goto L10;
        this.mDestroyAdapterPostponed = true;     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L10:
        if (this.mUploadDataStreamAdapter != 0) goto L13;
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L13:
        CronetUploadDataStreamJni.get().destroy(this.mUploadDataStreamAdapter);     // Catch: Throwable -> L19
        this.mUploadDataStreamAdapter = 0;     // Catch: Throwable -> L19
        Runnable r101 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L19
        if (r101 == null) goto L16;
        r101.run();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L19
        postTaskToExecutor(new AnonymousClass3(this));
    }

    private void destroyAdapterIfPostponed() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mInWhichUserCallback == 0) goto L12;
        if (this.mDestroyAdapterPostponed == false) goto L9;
        destroyAdapter();     // Catch: Throwable -> L13
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L12:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L13
    }

    public long createUploadDataStreamForTesting() throws IOException {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().createAdapterForTesting(this);     // Catch: Throwable -> L7
        long r101 = this.mDataProvider.getLength();     // Catch: Throwable -> L7
        this.mLength = r101;     // Catch: Throwable -> L7
        this.mRemainingLength = r101;     // Catch: Throwable -> L7
        long r102 = CronetUploadDataStreamJni.get().createUploadDataStreamForTesting(this, this.mLength, this.mUploadDataStreamAdapter);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void initializeWithRequest() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mInWhichUserCallback = 2;     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        this.mRequest.checkCallingThread();     // Catch: Throwable -> L9
        long r101 = this.mDataProvider.getLength();     // Catch: Throwable -> L9
        this.mLength = r101;     // Catch: Throwable -> L9
        this.mRemainingLength = r101;     // Catch: Throwable -> L9
    L11:
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        onError(th);
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkState(1);     // Catch: Throwable -> L12
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L12
        this.mRemainingLength = this.mLength;     // Catch: Throwable -> L12
        if (this.mUploadDataStreamAdapter != 0) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L9:
        CronetUploadDataStreamJni.get().onRewindSucceeded(this.mUploadDataStreamAdapter, this);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void rewind() {
        postTaskToExecutor(new AnonymousClass2(this));
    }

    public static /* synthetic */ String access$900() {
        return TAG;
    }

    public void onUploadDataStreamDestroyed() {
        destroyAdapter();
    }

    public static /* synthetic */ Object access$000(CronetUploadDataStream r100) {
        return r100.mLock;
    }

    public static /* synthetic */ long access$100(CronetUploadDataStream r100) {
        return r100.mUploadDataStreamAdapter;
    }

    public static /* synthetic */ ByteBuffer access$300(CronetUploadDataStream r100) {
        return r100.mByteBuffer;
    }

    public static /* synthetic */ void access$500(CronetUploadDataStream r100) {
        r100.checkCallingThread();
    }

    public static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$600(CronetUploadDataStream r100) {
        return r100.mDataProvider;
    }

    public static /* synthetic */ boolean access$800(CronetUploadDataStream r100) {
        return r100.mClosed;
    }

    private void checkState(int r100) {
        if (this.mInWhichUserCallback != r100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r100 + ", but was " + this.mInWhichUserCallback);
    }

    private void onError(Throwable r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        int r102 = this.mInWhichUserCallback;     // Catch: Throwable -> L21
        if (r102 == 3) goto L20;
        if (r102 != 2) goto L9;
        boolean r103 = true;
    L10:
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L21
        this.mByteBuffer = null;     // Catch: Throwable -> L21
        destroyAdapterIfPostponed();     // Catch: Throwable -> L21
        monitor-exit(r101);     // Catch: Throwable -> L21
        if (r103 == true) goto L24;
    L17:
        this.mRequest.onUploadException(r100);
        return;
    L24:
        this.mDataProvider.close();     // Catch: Exception -> L15
        this.mClosed = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(TAG, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r103 = false;
        goto L10
    L20:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public void attachNativeAdapterToRequest(long r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mUploadDataStreamAdapter = CronetUploadDataStreamJni.get().attachUploadDataToRequest(this, r100, this.mLength);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkState(0);     // Catch: Throwable -> L8
        onError(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(boolean r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkState(0);     // Catch: Throwable -> L30
        if (this.mByteBufferLimit != this.mByteBuffer.limit()) goto L29;
        if (r110 == true) goto L10;
    L14:
        int r101 = this.mByteBuffer.position();     // Catch: Throwable -> L30
        long r102 = this.mRemainingLength - ((long) r101);     // Catch: Throwable -> L30
        this.mRemainingLength = r102;     // Catch: Throwable -> L30
        if (r102 < 0) goto L17;
    L21:
        this.mByteBuffer.position(0);     // Catch: Throwable -> L30
        this.mByteBuffer = null;     // Catch: Throwable -> L30
        this.mInWhichUserCallback = 3;     // Catch: Throwable -> L30
        destroyAdapterIfPostponed();     // Catch: Throwable -> L30
        if (this.mUploadDataStreamAdapter != 0) goto L25;
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L25:
        CronetUploadDataStreamJni.get().onReadSucceeded(this.mUploadDataStreamAdapter, this, r101, r110);     // Catch: Throwable -> L30
        monitor-exit(r100);     // Catch: Throwable -> L30
        return;
    L17:
        if (this.mLength < 0) goto L21;
        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(this.mLength - this.mRemainingLength), Long.valueOf(this.mLength)}));     // Catch: Throwable -> L30
    L10:
        if (this.mLength < 0) goto L14;
        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("ByteBuffer limit changed");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkState(1);     // Catch: Throwable -> L8
        onError(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void postTaskToExecutor(Runnable r100) {
        this.mExecutor.execute(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CronetUrlRequest r101 = this.mRequest;
        if (r101 == null) goto L10;
        r101.onUploadException(th);
        return;
    L10:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }

    public void readData(ByteBuffer r100) {
        this.mByteBuffer = r100;
        this.mByteBufferLimit = r100.limit();
        postTaskToExecutor(this.mReadTask);
    }

    public void setOnDestroyedCallbackForTesting(Runnable r100) {
        this.mOnDestroyedCallbackForTesting = r100;
    }

    public static /* synthetic */ void access$200(CronetUploadDataStream r100, int r101) {
        r100.checkState(r101);
    }

    public static /* synthetic */ int access$402(CronetUploadDataStream r100, int r101) {
        r100.mInWhichUserCallback = r101;
        return r101;
    }

    public static /* synthetic */ void access$700(CronetUploadDataStream r100, Throwable r101) {
        r100.onError(r101);
    }

    public CronetUploadDataStream(UploadDataProvider r100, Executor r101, CronetUrlRequest r102) {
        this.mReadTask = new AnonymousClass1(this);
        this.mLock = new Object();
        this.mInWhichUserCallback = 3;
        this.mExecutor = r101;
        this.mDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r100);
        this.mRequest = r102;
        this.mClosed = false;
    }
}
