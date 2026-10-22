package com.bytedance.ee.bear.drive.loader.download.platform;

import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
class DownloadTask {
    private static final String TAG = "DrivePlatform_DownloadTask";
    private final IDownloader.ICallback mCallback;
    private DriveException mCurrentExp;
    private final List<IProcessor> mProcessors;
    private final IResourceHolder mResourceHolder;

    public static /* synthetic */ void a(DownloadTask r0) {
        r0.lambda$execute$0();
    }

    private void log(List<IProcessor> r1) {
    }

    private void shutDown() {
        tt5.a.h(TAG, "shutdown processor");
        Iterator<IProcessor> r0 = this.mProcessors.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().shutdown();
        goto L4
    }

    public Flowable<Boolean> execute() {
        log(this.mProcessors);
        return Flowable.create(new AnonymousClass1(this), BackpressureStrategy.BUFFER).doOnCancel(new a(this));
    }

    private /* synthetic */ void lambda$execute$0() throws Exception {
        shutDown();
    }

    public static /* synthetic */ List access$000(DownloadTask r0) {
        return r0.mProcessors;
    }

    public static /* synthetic */ DriveException access$100(DownloadTask r0) {
        return r0.mCurrentExp;
    }

    private void finishTask(FlowableEmitter<Boolean> r3) {
        if (r3.isCancelled() == true) goto L9;
        DriveException r0 = this.mCurrentExp;
        if (r0 == null) goto L7;
        this.mCallback.onFailure(r0);
    L7:
        r3.onNext(Boolean.TRUE);
        r3.onComplete();
        return;
    }

    public static /* synthetic */ DriveException access$102(DownloadTask r0, DriveException r1) {
        r0.mCurrentExp = r1;
        return r1;
    }

    public static /* synthetic */ void access$200(DownloadTask r0, FlowableEmitter r1) {
        r0.finishTask(r1);
    }

    public DownloadTask(List<IProcessor> r2, IDownloader.ICallback r3, IResourceHolder r4) {
        this.mCurrentExp = null;
        this.mProcessors = r2;
        this.mCallback = r3;
        this.mResourceHolder = r4;
    }
}
