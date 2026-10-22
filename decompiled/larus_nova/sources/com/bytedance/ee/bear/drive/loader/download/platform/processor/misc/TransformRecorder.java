package com.bytedance.ee.bear.drive.loader.download.platform.processor.misc;

import android.os.SystemClock;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
public class TransformRecorder {
    private boolean generating;
    private long generatingStartTime;
    private ProcessorContext processorContext;

    public void recordStart() {
        this.generating = true;
        this.generatingStartTime = SystemClock.uptimeMillis();
        c r100 = this.processorContext.getFileModel();
        this.processorContext.getResourceHolder().getDevReport().h(1, 0, r100.getFileToken(), r100.I(), r100.getFileSize());
        this.processorContext.getCallback().onTransStatusChanged(IDownloader.TransStatus.TRANSFORMING);
    }

    public void recordComplete() {
        if (this.generating == false) goto L6;
        c r100 = this.processorContext.getFileModel();
        this.processorContext.getResourceHolder().getDevReport().h(3, SystemClock.uptimeMillis() - this.generatingStartTime, r100.getFileToken(), r100.I(), r100.getFileSize());
        this.processorContext.getCallback().onTransStatusChanged(IDownloader.TransStatus.TRANSFORM_COMPLETED);
        this.generating = false;
        return;
    }

    public void recordFail() {
        if (this.generating == false) goto L6;
        c r100 = this.processorContext.getFileModel();
        this.processorContext.getResourceHolder().getDevReport().h(4, SystemClock.uptimeMillis() - this.generatingStartTime, r100.getFileToken(), r100.I(), r100.getFileSize());
        this.processorContext.getCallback().onTransStatusChanged(IDownloader.TransStatus.TRANSFORM_FAILED);
        this.generating = false;
        return;
    }

    public TransformRecorder(ProcessorContext r100) {
        this.generating = false;
        this.processorContext = r100;
    }
}
