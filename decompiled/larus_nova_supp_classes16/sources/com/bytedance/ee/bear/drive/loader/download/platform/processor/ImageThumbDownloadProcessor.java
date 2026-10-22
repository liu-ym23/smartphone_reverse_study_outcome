package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import c85.e;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.config.fg.DriveImageThumbConfig;
import com.bytedance.ee.bear.drive.loader.download.platform.IResourceHolder;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.model.DownloadParams;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.misc.RustCallback;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import g85.f;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageThumbDownloadProcessor extends AbsProcessor {
    private final e.a cacheJudgment;

    public static /* synthetic */ boolean a(ImageThumbDownloadProcessor r0, com.bytedance.ee.bear.drive.config.strategy.d r1, f85.a r2) {
        return r0.lambda$new$0(r1, r2);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public void onShutdown() {
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor
    public IProcessor.Result onProcess() throws Throwable {
        ProcessorContext r0 = getProcessorContext();
        w75.c r2 = r0.getFileModel();
        IDownloader.ICallback r7 = r0.getCallback();
        IResourceHolder r1 = r0.getResourceHolder();
        f r3 = r1.getMimeTypeManager();
        e r4 = r1.getCacheHandler();
        IApiExecutor r8 = r1.getApiExecutor();
        if (((ya5.b) org.koin.java.a.a(ya5.b.class)).a() == true) goto L7;
        tt5.a.h("DrivePlatform_Processor", "Image Thumb run fail: ka-31 close");
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, "Image Thumb run fail: ka-31 close"));
    L7:
        if ("6".equals(r1.getDownloadStrategy().getPreviewFileSourceType()) == true) goto L9;
        q75.a r5 = o75.b.a().getDriveConfig();
        if (r5.k != null) goto L13;
        tt5.a.k("DriveConfig", "getDriveImageThumbConfig() mDriveImageThumbConfig is null, return empty value.");
        DriveImageThumbConfig r6 = new DriveImageThumbConfig();
    L14:
        if (r6 != null) goto L16;
    L61:
        tt5.a.h("DrivePlatform_Processor", "Image Thumb run fail: config.enable = false");
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, "Image Thumb run fail: config.enable = false"));
    L16:
        if (r6.enable.booleanValue() == false) goto L61;
        w75.a r10 = r2.getDetails();
        w75.b r9 = r10.c();
        if (r9 != null) goto L23;
        tt5.a.d("DrivePlatform_Processor", "Image Thumb run fail: data empty");
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, "Image Thumb run fail: data empty"));
    L23:
        if (((g85.b) r3).l(r10.f) == false) goto L25;
        r10.g(false);
        String r11 = r8.getAppId();
        String[] r12 = r6.supportAppId;
        if (r12 != null) goto L29;
    L59:
        String r13 = "Image Thumb run fail: appId can't support -> " + r11;
        tt5.a.h("DrivePlatform_Processor", r13);
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, r13));
    L29:
        if (Arrays.asList(r12).contains(r11) == false) goto L59;
        long r14 = r9.c;
        Long r16 = r6.minSize;
        if (r16 != null) goto L34;
    L57:
        String r17 = "Image Thumb run fail: less than minSize(fileSize=" + r14 + ", minSize=" + r6.minSize + ")";
        tt5.a.h("DrivePlatform_Processor", r17);
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, r17));
    L34:
        if (r16.longValue() > r14) goto L57;
        String r18 = r9.k;
        Map<String, Long> r19 = r6.typesConfig;
        if (r19 == null) goto L54;
        if (r18 == null) goto L54;
        Long r20 = r19.get(r18.toUpperCase());
        if (r20 != null) goto L42;
    L55:
        String r21 = "Image Thumb run fail: fileSize over limit(fileExt=" + r18 + ", configSize=" + r20 + ", fileSize=" + r14 + ")";
        tt5.a.h("DrivePlatform_Processor", r21);
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, r21));
    L42:
        if (r20.longValue() < r14) goto L55;
        r10.g(true);
        r10.x = true;
        if (r4.c(r2, this.cacheJudgment) == false) goto L48;
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName().concat(" hit cache successfully, end procedure."));
        r7.onHitCache(r2);
        return IProcessor.Result.success();
    L48:
        String r22 = r8.downloadByToken(r2, 0, RustCallback.wrap(r7), new DownloadParams.Builder().saveToLocalFilePath(false).priority(getProcessorContext().getResourceHolder().getDownloadStrategy().downloadPriority()).downloadType(DownloadRequestInfo.DownloadType.COVER).driveBizScene(getProcessorContext().getDownloadOptions().getDriveBizScene()).driveWatermarkScene(getProcessorContext().getDownloadOptions().getDriveWatermarkScene()).build());
        if (r8.isDownloadSuccess(r22) == true) goto L52;
        tt5.a.d("DrivePlatform_Processor", getClass().getSimpleName().concat(" submit rust failure, return rust key: -1"));
        r10.g(false);
        r10.x = false;
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.RUST_SUBMIT_ERROR, "Rust internal error, return key is -1"));
    L52:
        r7.onSubmit(r22);
        tt5.a.h("DrivePlatform_Processor", getClass().getSimpleName() + " submit rust success, return rust key: " + r22);
        return IProcessor.Result.success();
    L54:
        r20 = null;
        goto L55
    L25:
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, "Image Thumb run fail: local can't support -> " + r10.f));
    L13:
        r6 = r5.k;
        goto L14
    L9:
        return IProcessor.Result.failAndContinue(new DriveException(ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW, "Image Thumb run fail: manual can't support"));
    }

    public ImageThumbDownloadProcessor(ProcessorContext r1) {
        super(r1);
        this.cacheJudgment = new a(this);
    }

    private /* synthetic */ boolean lambda$new$0(com.bytedance.ee.bear.drive.config.strategy.d r1, w75.a r2) {
        DriveFilePath r3 = r2.b();
        if (r3.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (z75.b.d(r3, getProcessorContext().getUserSession()) == false) goto L7;
        return true;
    }
}
