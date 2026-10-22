package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import c85.e;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.RustCallback;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SourceFileProcessor extends AbsProcessor {
    private final e.a cacheJudgment;

    public static /* synthetic */ boolean a(SourceFileProcessor r0, com.bytedance.ee.bear.drive.config.strategy.d r1, f85.a r2) {
        return r0.lambda$new$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() {
        w75.c r2 = getProcessorContext().getFileModel();
        e r0 = getProcessorContext().getResourceHolder().getCacheHandler();
        IApiExecutor r7 = getProcessorContext().getResourceHolder().getApiExecutor();
        IDownloader.ICallback r8 = getProcessorContext().getCallback();
        DriveBizScene r1 = getProcessorContext().getDownloadOptions().getDriveBizScene();
        DriveWatermarkScene r3 = getProcessorContext().getDownloadOptions().getDriveWatermarkScene();
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.g("admin.watermark.filewatermark.remaining");
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName() + " [watermark] driveBizScene = " + r1 + ", driveWatermarkScene = " + r3);
        if (r4 == false) goto L12;
        if (r1 == null) goto L12;
        if (r3 == null) goto L12;
        if (r1 == DriveBizScene.DriveBizScene_UNKNOWN) goto L12;
        if (r3 == DriveWatermarkScene.DriveWatermarkScene_NONE) goto L12;
        r0.b(r2);
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName().concat("[watermark] drive biz scene or watermark scene means need watermark, just try download"));
    L16:
        String r5 = r7.downloadByToken(r2, r2.getFileSize(), RustCallback.wrap(r8), new DownloadParams.Builder().saveToLocalFilePath(true).priority(getProcessorContext().getResourceHolder().getDownloadStrategy().downloadPriority()).downloadType(DownloadRequestInfo.DownloadType.DRIVE).driveBizScene(r1).driveWatermarkScene(r3).build());
        if (r7.isDownloadSuccess(r5) == true) goto L20;
        tt5.a.d("DrivePlatform_Processor", getClass().getSimpleName().concat(" submit rust failure, return rust key: -1"));
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.RUST_SUBMIT_ERROR, "Rust internal error, return key is -1"));
    L20:
        r8.onSubmit(r5);
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName() + " submit rust success, return rust key: " + r5);
        return IProcessor.Result.success();
    L12:
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName().concat("[watermark] drive biz scene or watermark scene means don't need watermark, try use cache"));
        if (r0.c(r2, this.cacheJudgment) == false) goto L16;
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName().concat(" hit cache successfully, end procedure."));
        r8.onHitCache(r2);
        return IProcessor.Result.success();
    }

    public SourceFileProcessor(ProcessorContext r1) {
        super(r1);
        this.cacheJudgment = new c(this);
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
}
