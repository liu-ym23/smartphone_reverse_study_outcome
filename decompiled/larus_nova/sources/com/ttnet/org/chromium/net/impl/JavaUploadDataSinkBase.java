package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public abstract class JavaUploadDataSinkBase extends UploadDataSink {
    public static final int DEFAULT_UPLOAD_BUFFER_SIZE = 8192;
    private ByteBuffer mBuffer;
    private final Executor mExecutor;
    private final AtomicInteger mSinkState;
    private long mTotalBytes;
    private final UploadDataProvider mUploadProvider;
    private final Executor mUserUploadExecutor;
    private long mWrittenBytes;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    public abstract void finish() throws IOException;

    public abstract Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r100);

    public abstract Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r100);

    public abstract void initializeRead() throws IOException;

    public abstract void initializeStart(long r100);

    public abstract int processSuccessfulRead(ByteBuffer r100) throws IOException;

    public abstract void processUploadError(Throwable r100);

    private void startRead() {
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass3(this)));
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindSucceeded() {
        if (this.mSinkState.compareAndSet(1, 2) == false) goto L7;
        startRead();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.mSinkState.get());
    }

    public static /* synthetic */ ByteBuffer access$000(JavaUploadDataSinkBase r100) {
        return r100.mBuffer;
    }

    public static /* synthetic */ long access$100(JavaUploadDataSinkBase r100) {
        return r100.mTotalBytes;
    }

    public static /* synthetic */ long access$200(JavaUploadDataSinkBase r100) {
        return r100.mWrittenBytes;
    }

    public static /* synthetic */ AtomicInteger access$300(JavaUploadDataSinkBase r100) {
        return r100.mSinkState;
    }

    public static /* synthetic */ UploadDataProvider access$400(JavaUploadDataSinkBase r100) {
        return r100.mUploadProvider;
    }

    public static /* synthetic */ void access$600(JavaUploadDataSinkBase r100) {
        r100.startRead();
    }

    private void executeOnUploadExecutor(JavaUrlRequestUtils.CheckedRunnable r100) {
        this.mUserUploadExecutor.execute(getUploadErrorSettingRunnable(r100));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        processUploadError(e);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadError(Exception r100) {
        processUploadError(r100);
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onReadSucceeded(final boolean r100) {
        if (this.mSinkState.compareAndSet(0, 2) == false) goto L7;
        this.mExecutor.execute(getErrorSettingRunnable(new AnonymousClass2(this, r100)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.mSinkState.get());
    }

    @Override // com.ttnet.org.chromium.net.UploadDataSink
    public void onRewindError(Exception r100) {
        processUploadError(r100);
    }

    public void start(final boolean r100) {
        executeOnUploadExecutor(new AnonymousClass4(this, r100));
    }

    public static /* synthetic */ ByteBuffer access$002(JavaUploadDataSinkBase r100, ByteBuffer r101) {
        r100.mBuffer = r101;
        return r101;
    }

    public static /* synthetic */ long access$102(JavaUploadDataSinkBase r100, long r101) {
        r100.mTotalBytes = r101;
        return r101;
    }

    public static /* synthetic */ long access$214(JavaUploadDataSinkBase r100, long r101) {
        long r102 = r100.mWrittenBytes + r101;
        r100.mWrittenBytes = r102;
        return r102;
    }

    public static /* synthetic */ void access$500(JavaUploadDataSinkBase r100, JavaUrlRequestUtils.CheckedRunnable r101) {
        r100.executeOnUploadExecutor(r101);
    }

    public JavaUploadDataSinkBase(final Executor r100, Executor r101, UploadDataProvider r102) {
        this.mSinkState = new AtomicInteger(3);
        this.mUserUploadExecutor = new AnonymousClass1(this, r100);
        this.mExecutor = r101;
        this.mUploadProvider = r102;
    }
}
