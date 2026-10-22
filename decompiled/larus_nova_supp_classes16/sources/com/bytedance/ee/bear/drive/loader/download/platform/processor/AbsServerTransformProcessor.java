package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.PGErrorParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsServerTransformProcessor extends AbsTransDowngradeProcessor {
    public abstract boolean checkReadyResult(IPreviewGetModel r1);

    public IProcessor.Result hookPreviewGetData(IPreviewGetModel r1) {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        IPreviewGetModel r1 = null;
        Throwable r2 = null;
        r1 = getPreviewGetData();     // Catch: Throwable -> L5
    L7:
        IProcessor.Result r3 = hookPreviewGetData(r1);
        if (r3 == null) goto L10;
        return r3;
    L10:
        if (r1 != null) goto L12;
    L17:
        DriveException r0 = PGErrorParser.parseErr(r1, this.fileModel, r2, isShutdown());
        if (r0.getErrorCode() == ErrCode.REQUEST_TRANSFORM_CANCEL_EXP) goto L23;
        if (r0.getErrorCode() == ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP) goto L23;
        this.transformRecorder.recordFail();
    L23:
        if (r0.getErrorCode() != ErrCode.DRIVE_FILE_ZERO_SIZE) goto L27;
        return IProcessor.Result.failAndInterrupt(r0);
    L27:
        return IProcessor.Result.failAndContinue(r0);
    L12:
        if (isResultReady(r1) == false) goto L17;
        this.transformRecorder.recordComplete();
        boolean r4 = checkReadyResult(r1);
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName() + " checkReadyResult, check through: " + r4);
        if (r4 == false) goto L17;
        this.callback.onServerTransform(this.fileModel);
        return IProcessor.Result.success();
    L5:
        th = move-exception;
        tt5.a.e("DrivePlatform_Processor", "ServerTransformProcessor getPreviewGetData fail. ", th, false);
        r2 = th.getCause();
        goto L7
    }

    public AbsServerTransformProcessor(ProcessorContext r1) {
        super(r1);
    }
}
