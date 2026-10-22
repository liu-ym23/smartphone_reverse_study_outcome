package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: classes16.dex */
public class NotSupportProcessor extends AbsProcessor {
    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        return IProcessor.Result.failAndInterrupt(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW));
    }

    public NotSupportProcessor(ProcessorContext r100) {
        super(r100);
    }
}
