package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsProcessor implements IProcessor {
    protected static final String TAG = "DrivePlatform_Processor";
    private final ProcessorContext context;
    private volatile boolean isShutdown;
    private final Object lock;

    public abstract IProcessor.Result onProcess() throws Throwable;

    public abstract void onShutdown();

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor
    public IProcessor.Result process() {
        Object r1 = this.lock;
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L9;
        tt5.a.k(TAG, "download task has shutdown, do not perform ".concat(getClass().getSimpleName()));     // Catch: Throwable -> L17
        IProcessor.Result r0 = IProcessor.Result.failAndContinue(new DriveException(ErrCode.DEFAULT, "processor is shutdown"));     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r0;
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L17
        tt5.a.h(TAG, getClass().getSimpleName() + " start, current previewEntity: " + getProcessorContext().getPreviewEntity());
        savePreviewMessage();
        IProcessor.Result r2 = onProcess();     // Catch: Throwable -> L13
    L15:
        tt5.a.h(TAG, getClass().getSimpleName() + " finish, current previewEntity: " + getProcessorContext().getPreviewEntity());
        return r2;
    L13:
        th = move-exception;
        tt5.a.e(TAG, getClass().getSimpleName().concat(" throw exception during execution. "), th, false);
        r2 = IProcessor.Result.failAndContinue(new DriveException(ErrCode.DEFAULT, th));
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor
    public void shutdown() {
        tt5.a.h(TAG, "shutdown processor, current previewEntity: " + getProcessorContext().getPreviewEntity());
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        this.isShutdown = true;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        onShutdown();
    }

    private void savePreviewMessage() {
        if (getProcessorContext().getPreviewEntity() == null) goto L6;
        getProcessorContext().getFileModel().x(getProcessorContext().getPreviewEntity());
        return;
    L6:
        if (getProcessorContext() != null) goto L8;
    L12:
        int r0 = -1;
    L13:
        getProcessorContext().getFileModel().x(new w75.d.a(r0, getProcessorContext().getFileModel().I()));
        return;
    L8:
        if (getProcessorContext().getFileModel() == null) goto L12;
        if (getProcessorContext().getFileModel().getDetails() == null) goto L12;
        r0 = getProcessorContext().getFileModel().getDetails().e;
        goto L13
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public ProcessorContext getProcessorContext() {
        return this.context;
    }

    public boolean isShutdown() {
        return this.isShutdown;
    }

    public AbsProcessor(ProcessorContext r2) {
        this.lock = new Object();
        this.isShutdown = false;
        this.context = r2;
    }
}
