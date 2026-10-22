package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;

/* JADX INFO: loaded from: classes16.dex */
public class NoDownloadProcessor extends AbsProcessor {
    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        getProcessorContext().getCallback().onNoDownload(getProcessorContext().getFileModel());
        return IProcessor.Result.success();
    }

    public NoDownloadProcessor(ProcessorContext r100) {
        super(r100);
    }
}
