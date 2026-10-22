package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import c85.e;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.PGErrorParser;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.RustCallback;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TransDownloadProcessor extends AbsTransDowngradeProcessor {
    private final e.a cacheJudgment;

    public static /* synthetic */ boolean a(TransDownloadProcessor r0, com.bytedance.ee.bear.drive.config.strategy.d r1, f85.a r2) {
        return r0.lambda$new$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        if (this.cacheHandler.c(this.fileModel, this.cacheJudgment) == false) goto L6;
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName().concat(" hit cache successfully, end procedure."));
        getProcessorContext().getCallback().onHitCache(this.fileModel);
        return IProcessor.Result.success();
    L6:
        IPreviewGetModel r0 = null;
        Throwable r1 = null;
        r0 = getPreviewGetData();     // Catch: Throwable -> L9
    L11:
        if (r0 == null) goto L19;
        if (isResultReady(r0) == false) goto L19;
        if (TextUtils.isEmpty(r0.getPreviewUrl()) == true) goto L19;
        return handleTransSuccess(r0);
    L19:
        return handleTransFailed(r0, r1);
    L9:
        th = move-exception;
        tt5.a.e("DrivePlatform_Processor", "TransDownloadProcessor getPreviewGetData fail. ", th, false);
        r1 = th.getCause();
        goto L11
    }

    public TransDownloadProcessor(ProcessorContext r1) {
        super(r1);
        this.cacheJudgment = new d(this);
    }

    public IProcessor.Result handleTransSuccess(IPreviewGetModel r10) {
        this.transformRecorder.recordComplete();
        w75.c r0 = this.fileModel;
        String r1 = r10.getExtra();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.o(r1);
        w75.c r3 = this.fileModel;
        String r4 = r10.getPreviewUrl();
        if (r4 == null) goto L9;
        r2 = r4;
    L9:
        r3.c(r2);
        String r11 = this.apiExecutor.downloadByPreviewUrl(this.fileModel, r10.getPreviewFileSize(), RustCallback.wrap(this.callback), this.priority);
        if (this.apiExecutor.isDownloadSuccess(r11) == false) goto L12;
        this.callback.onSubmit(r11);
        return IProcessor.Result.success();
    L12:
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.RUST_SUBMIT_ERROR, "Rust internal error, return key is -1"));
    }

    private /* synthetic */ boolean lambda$new$0(com.bytedance.ee.bear.drive.config.strategy.d r1, w75.a r2) {
        DriveFilePath r3 = r2.a();
        if (r3.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (z75.b.d(r3, getProcessorContext().getUserSession()) == false) goto L7;
        return true;
    }

    public IProcessor.Result handleTransFailed(IPreviewGetModel r3, Throwable r4) {
        DriveException r5 = PGErrorParser.parseErr(r3, this.fileModel, r4, isShutdown());
        if (r5.getErrorCode() == ErrCode.REQUEST_TRANSFORM_CANCEL_EXP) goto L8;
        if (r5.getErrorCode() == ErrCode.REQUEST_TRANSFORM_SHUTDOWN_EXP) goto L8;
        this.transformRecorder.recordFail();
    L8:
        if (r5.getErrorCode() != ErrCode.DRIVE_FILE_ZERO_SIZE) goto L12;
        return IProcessor.Result.failAndInterrupt(r5);
    L12:
        return IProcessor.Result.failAndContinue(r5);
    }
}
