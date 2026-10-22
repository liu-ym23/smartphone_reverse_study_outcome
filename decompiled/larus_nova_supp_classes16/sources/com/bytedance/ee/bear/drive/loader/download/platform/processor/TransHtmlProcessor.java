package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import c85.e;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.PGErrorParser;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.RustCallback;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import i75.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TransHtmlProcessor extends AbsTransDowngradeProcessor {
    private static final String TAG = "TransHtmlProcessor";
    private final e.a cacheJudgment;

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        if (this.cacheHandler.c(this.fileModel, this.cacheJudgment) == false) goto L6;
        tt5.a.h(TAG, getClass().getSimpleName().concat(" hit cache successfully, end procedure."));
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
        tt5.a.e(TAG, "TransHtmlProcessor getPreviewGetData fail. ", th, false);
        r1 = th.getCause();
        goto L11
    }

    public TransHtmlProcessor(ProcessorContext r1) {
        super(r1);
        this.cacheJudgment = new AnonymousClass1(this);
    }

    private IProcessor.Result handleTransSuccess(IPreviewGetModel r9) {
        String r1 = "";
        if (isPreviewSubExcel(r9) == false) goto L11;
        tt5.a.h(TAG, "preview sub excel, no download");
        this.transformRecorder.recordComplete();
        w75.c r0 = getProcessorContext().getFileModel();
        r0.c(r9.getPreviewSubUrl());
        String r10 = r9.getExtra();
        if (r10 == null) goto L8;
        r1 = r10;
    L8:
        r0.o(r1);
        getProcessorContext().getCallback().onServerTransform(r0);
        return IProcessor.Result.success();
    L11:
        if (isOversize(r9) == false) goto L14;
        tt5.a.h(TAG, "trans html failed, html file is oversize: " + r9.getPreviewFileSize());
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_OVER_SIZE));
    L14:
        tt5.a.h(TAG, "download file directly");
        this.transformRecorder.recordComplete();
        w75.c r2 = this.fileModel;
        String r3 = r9.getPreviewUrl();
        if (r3 == null) goto L18;
        r1 = r3;
    L18:
        r2.c(r1);
        String r11 = this.apiExecutor.downloadByPreviewUrl(this.fileModel, r9.getPreviewFileSize(), RustCallback.wrap(this.callback), this.priority);
        if (this.apiExecutor.isDownloadSuccess(r11) == false) goto L21;
        this.callback.onSubmit(r11);
        return IProcessor.Result.success();
    L21:
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.RUST_SUBMIT_ERROR, "Rust internal error, return key is -1"));
    }

    private boolean isOversize(IPreviewGetModel r7) {
        if (getProcessorContext().getFileModel().A() != null) goto L7;
        tt5.a.d(TAG, "previewEntity is null");
        return false;
    L7:
        if (r7.getPreviewFileSize() <= (getProcessorContext().getResourceHolder().getDriveConfig().a().getRender_html_file_max_size() * 1024)) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isPreviewSubExcel(IPreviewGetModel r3) {
        w75.d.a r0 = getProcessorContext().getFileModel().A();
        if (r0 != null) goto L5;
    L9:
        tt5.a.d(TAG, "previewEntity is null or extra is empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r3.getExtra()) == true) goto L9;
        return h.c(getProcessorContext().getResourceHolder().getMimeTypeManager(), getProcessorContext().getFileModel().I(), r0.b);
    }

    private IProcessor.Result handleTransFailed(IPreviewGetModel r3, Throwable r4) {
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
