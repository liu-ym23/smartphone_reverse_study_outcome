package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsProcessor implements IProcessor {
    protected static final String TAG = "DrivePlatform_Processor";
    private final ProcessorContext context;
    private volatile boolean isShutdown;
    private final Object lock;

    public abstract IProcessor.Result onProcess() throws Throwable;

    public abstract void onShutdown();

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor
    public IProcessor.Result process() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L9;
        tt5.a.k(TAG, "download task has shutdown, do not perform ".concat(getClass().getSimpleName()));     // Catch: Throwable -> L17
        IProcessor.Result r101 = IProcessor.Result.failAndContinue(new DriveException(ErrCode.DEFAULT, "processor is shutdown"));     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
        return r101;
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L17
        tt5.a.h(TAG, getClass().getSimpleName() + " start, current previewEntity: " + getProcessorContext().getPreviewEntity());
        savePreviewMessage();
        IProcessor.Result r102 = onProcess();     // Catch: Throwable -> L13
    L15:
        tt5.a.h(TAG, getClass().getSimpleName() + " finish, current previewEntity: " + getProcessorContext().getPreviewEntity());
        return r102;
    L13:
        th = move-exception;
        tt5.a.e(TAG, getClass().getSimpleName().concat(" throw exception during execution. "), th, false);
        r102 = IProcessor.Result.failAndContinue(new DriveException(ErrCode.DEFAULT, th));
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.IProcessor
    public void shutdown() {
        tt5.a.h(TAG, "shutdown processor, current previewEntity: " + getProcessorContext().getPreviewEntity());
        Object r100 = this.lock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.isShutdown == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L8:
        this.isShutdown = true;     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        onShutdown();
    }

    private void savePreviewMessage() {
        if (getProcessorContext().getPreviewEntity() == null) goto L6;
        getProcessorContext().getFileModel().x(getProcessorContext().getPreviewEntity());
        return;
    L6:
        if (getProcessorContext() != null) goto L8;
    L12:
        int r100 = -1;
    L13:
        getProcessorContext().getFileModel().x(new w75.d.a(r100, getProcessorContext().getFileModel().I()));
        return;
    L8:
        if (getProcessorContext().getFileModel() == null) goto L12;
        if (getProcessorContext().getFileModel().getDetails() == null) goto L12;
        r100 = getProcessorContext().getFileModel().getDetails().f558536e;
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

    public AbsProcessor(ProcessorContext r100) {
        this.lock = new Object();
        this.isShutdown = false;
        this.context = r100;
    }
}
