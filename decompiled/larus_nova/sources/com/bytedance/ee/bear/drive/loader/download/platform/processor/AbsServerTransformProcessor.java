package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.PGErrorParser;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsServerTransformProcessor extends AbsTransDowngradeProcessor {
    public abstract boolean checkReadyResult(IPreviewGetModel r100);

    public IProcessor.Result hookPreviewGetData(IPreviewGetModel r100) {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        IPreviewGetModel r100 = null;
        Throwable r101 = null;
        r100 = getPreviewGetData();     // Catch: Throwable -> L5
    L7:
        IProcessor.Result r102 = hookPreviewGetData(r100);
        if (r102 == null) goto L10;
        return r102;
    L10:
        if (r100 != null) goto L12;
    L17:
        DriveException r103 = PGErrorParser.parseErr(r100, this.fileModel, r101, isShutdown());
        if (r103.getErrorCode() == ErrCode.REQUEST_TRANSFORM_CANCEL_EXP) goto L23;
        if (r103.getErrorCode() == ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP) goto L23;
        this.transformRecorder.recordFail();
    L23:
        if (r103.getErrorCode() != ErrCode.DRIVE_FILE_ZERO_SIZE) goto L27;
        return IProcessor.Result.failAndInterrupt(r103);
    L27:
        return IProcessor.Result.failAndContinue(r103);
    L12:
        if (isResultReady(r100) == false) goto L17;
        this.transformRecorder.recordComplete();
        boolean r104 = checkReadyResult(r100);
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName() + " checkReadyResult, check through: " + r104);
        if (r104 == false) goto L17;
        this.callback.onServerTransform(this.fileModel);
        return IProcessor.Result.success();
    L5:
        th = move-exception;
        tt5.a.e("DrivePlatform_Processor", "ServerTransformProcessor getPreviewGetData fail. ", th, false);
        r101 = th.getCause();
        goto L7
    }

    public AbsServerTransformProcessor(ProcessorContext r100) {
        super(r100);
    }
}
