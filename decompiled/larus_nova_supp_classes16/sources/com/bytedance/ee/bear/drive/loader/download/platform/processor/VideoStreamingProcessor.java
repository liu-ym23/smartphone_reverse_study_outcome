package com.bytedance.ee.bear.drive.loader.download.platform.processor;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.ProcessorContext;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IPreviewGetModel;
import com.bytedance.ee.bear.drive.loader.model.DriveException;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0016J\u0014\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\rH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0016Jf\u0010\u0015\u001a\u0004\u0018\u00010\u00162Z\u0010\u0017\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b\u0018\u00010\u0018j*\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001b\u0018\u0001`\u001cH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/VideoStreamingProcessor;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/AbsServerTransformProcessor;", "context", "Lcom/bytedance/ee/bear/drive/loader/download/platform/ProcessorContext;", "<init>", "(Lcom/bytedance/ee/bear/drive/loader/download/platform/ProcessorContext;)V", "isLittleRateEnabled", "", "isPlayOriginEnabled", "isDropOriginVideoPreviewLimitation", "hookPreviewGetData", "Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/IProcessor$Result;", "previewGetData", "Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/IPreviewGetModel;", "checkReadyResult", TipCallBackData.RESULT, "isSupportDowngrade", "previewStatus", "", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/IFileModel;", "findVideoMetaInfo", "Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/VideoStreamingProcessor$VideoMetaInfo;", "streams", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "VideoMetaInfo", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoStreamingProcessor extends AbsServerTransformProcessor {
    private boolean isDropOriginVideoPreviewLimitation;
    private boolean isLittleRateEnabled;
    private boolean isPlayOriginEnabled;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/VideoStreamingProcessor$VideoMetaInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "codecName", "", "getCodecName", "()Ljava/lang/String;", "setCodecName", "(Ljava/lang/String;)V", "codecType", "getCodecType", "setCodecType", "codecTagString", "getCodecTagString", "setCodecTagString", "bitRate", "", "getBitRate", "()I", "setBitRate", "(I)V", "width", "getWidth", "setWidth", "height", "getHeight", "setHeight", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VideoMetaInfo implements NonProguard {
        public static final Companion Companion = null;
        public static final String VIDEO_CODE_TYPE_VALUE = "video";
        private int bitRate;
        private String codecName;
        private String codecTagString;
        private String codecType;
        private int height;
        private int width;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J2\u0010\t\u001a\u0004\u0018\u00010\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/VideoStreamingProcessor$VideoMetaInfo$Companion;", "", "<init>", "()V", "VIDEO_CODE_TYPE_VALUE", "", "parseInteger", "", "data", "fromStringHashMap", "Lcom/bytedance/ee/bear/drive/loader/download/platform/processor/VideoStreamingProcessor$VideoMetaInfo;", "dataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private final int parseInteger(String r5) {
                if (r5 != null) goto L5;
            L8:
                boolean r1 = true;
            L10:
                if (r1 == false) goto L18;
                tt5.a.k("DrivePlatform_Processor", "parseInteger data is empty");
                return 0;
            L18:
                return CastIntegerProtector.parseInt(r5);
            L15:
                e = move-exception;
                tt5.a.k("DrivePlatform_Processor", "parseInteger fail: " + e);
                return 0;
            L5:
                if (r5.length() == 0) goto L8;
                r1 = false;
                goto L10
            }

            @JvmStatic
            public final VideoMetaInfo fromStringHashMap(HashMap<String, String> r5) {
                if (r5 != null) goto L4;
            L7:
                boolean r0 = true;
            L9:
                if (r0 == false) goto L16;
                return null;
            L16:
                VideoMetaInfo r1 = new VideoMetaInfo();     // Catch: Exception -> L13
                r1.setCodecName(r5.get("codec_name"));     // Catch: Exception -> L13
                r1.setCodecType(r5.get("codec_type"));     // Catch: Exception -> L13
                r1.setCodecTagString(r5.get("codec_tag_string"));     // Catch: Exception -> L13
                Companion r2 = VideoMetaInfo.Companion;     // Catch: Exception -> L13
                r1.setBitRate(r2.parseInteger(r5.get("bit_rate")));     // Catch: Exception -> L13
                r1.setWidth(r2.parseInteger(r5.get("width")));     // Catch: Exception -> L13
                r1.setHeight(r2.parseInteger(r5.get("height")));     // Catch: Exception -> L13
                return r1;
            L13:
                e = move-exception;
                tt5.a.d("DrivePlatform_Processor", "fromStringMap fail: " + e);
                return null;
            L4:
                if (r5.isEmpty() == true) goto L7;
                r0 = false;
                goto L9
            }
        }

        static {
            Companion = new Companion(null);
        }

        public VideoMetaInfo() {
        }

        @JvmStatic
        public static final VideoMetaInfo fromStringHashMap(HashMap<String, String> r1) {
            return Companion.fromStringHashMap(r1);
        }

        public final int getBitRate() {
            return this.bitRate;
        }

        public final String getCodecName() {
            return this.codecName;
        }

        public final String getCodecTagString() {
            return this.codecTagString;
        }

        public final String getCodecType() {
            return this.codecType;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public final void setBitRate(int r1) {
            this.bitRate = r1;
        }

        public final void setCodecName(String r1) {
            this.codecName = r1;
        }

        public final void setCodecTagString(String r1) {
            this.codecTagString = r1;
        }

        public final void setCodecType(String r1) {
            this.codecType = r1;
        }

        public final void setHeight(int r1) {
            this.height = r1;
        }

        public final void setWidth(int r1) {
            this.width = r1;
        }
    }

    public VideoStreamingProcessor(ProcessorContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.isLittleRateEnabled = r3.h("ccm.drive.mobile.video_little_rate");
        this.isPlayOriginEnabled = r3.h("ccm.drive.mobile.play_origin_video");
        this.isDropOriginVideoPreviewLimitation = r3.h("ccm.drive.mobile.drop_origin_video_preview_limitation");
        tt5.a.h("DrivePlatform_Processor", "VideoStreamingProcessor isLittleRateEnabled= " + this.isLittleRateEnabled + ", isPlayOriginEnabled= " + this.isPlayOriginEnabled + ", isDropOriginVideoPreviewLimitation= " + this.isDropOriginVideoPreviewLimitation);
    }

    private final VideoMetaInfo findVideoMetaInfo(ArrayList<HashMap<String, String>> r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        tt5.a.k("DrivePlatform_Processor", "findVideoMetaInfo fail, streams is empty");
        return null;
    L12:
        tt5.a.h("DrivePlatform_Processor", "findVideoMetaInfo running, streams=" + du5.b.f(r6));
        Iterator<HashMap<String, String>> r7 = r6.iterator();     // Catch: Exception -> L23
    L14:
        if (r7.hasNext() == false) goto L32;
        VideoMetaInfo r1 = VideoMetaInfo.Companion.fromStringHashMap(r7.next());     // Catch: Exception -> L23
        if (r1 == null) goto L19;
        String r4 = r1.getCodecType();     // Catch: Exception -> L23
    L21:
        if (TextUtils.equals(VideoMetaInfo.VIDEO_CODE_TYPE_VALUE, r4) == false) goto L14;
        return r1;
    L19:
        r4 = null;
        goto L21
    L32:
        return null;
    L23:
        e = move-exception;
        tt5.a.d("DrivePlatform_Processor", "findVideoMetaInfo fail: " + e);
        return null;
    L4:
        if (r6.isEmpty() == true) goto L7;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public boolean checkReadyResult(IPreviewGetModel<?> r2) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        Map<String, String> r0 = r2.getVideoTranscodeUrls();
        if (hu5.a.e(r2.getVideoTranscodeUrls()) == true) goto L7;
        if (r0 == null) goto L9;
        getProcessorContext().getFileModel().s(r0);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsServerTransformProcessor
    public IProcessor.Result hookPreviewGetData(IPreviewGetModel<?> r3) {
        if (this.fileModel.n() != 3) goto L7;
        this.transformRecorder.recordComplete();
        tt5.a.h("DrivePlatform_Processor", "VideoStreamingProcessor hookPreviewGetData, video source preview");
        this.callback.onServerTransform(this.fileModel);
        return IProcessor.Result.success();
    L7:
        if (this.fileModel.n() != 4) goto L10;
        this.transformRecorder.recordComplete();
        tt5.a.h("DrivePlatform_Processor", "VideoStreamingProcessor hookPreviewGetData, video user source preview");
        return IProcessor.Result.failAndInterrupt(new DriveException(ErrCode.PREVIEW_DOWNGRADE_TO_SIMILAR, "User use similar preview"));
    L10:
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsTransDowngradeProcessor
    public boolean isSupportDowngrade(int r18, w75.c<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "fileModel");
        String r2 = r19.I();
        if (this.isLittleRateEnabled == true) goto L5;
    L70:
        return false;
    L5:
        if (r18 != 1) goto L70;
        if (TextUtils.isEmpty(r2) == true) goto L70;
        boolean r5 = ((g85.b) this.mimeTypeManager).l(r2);
        ArrayList<HashMap<String, String>> r7 = null;
        boolean r6 = ((g85.b) this.mimeTypeManager).o(r2, null);
        if (this.isDowngraded == true) goto L69;
        if (r5 == false) goto L69;
        if (r6 == false) goto L69;
        if (r19.n() != 4) goto L18;
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade=false!! previewMode is PREVIEW_MODE_SIMILAR_FILE");
        return false;
    L18:
        DrivePreviewConfig r8 = o75.b.a().getDriveConfig().a();
        int r9 = r8.getLittleBitRate();
        int r10 = r8.getSmallVideoSize();
        long r11 = r19.getFileSize();
        if ((r11 / ((long) 1024)) > r10) goto L21;
        boolean r12 = true;
    L22:
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade start, extension=" + r2 + ", isSmallVideo=" + r12 + ", littleBitRate=" + r9 + ", smallVideoSize=" + r10 + ", fileSize=" + r11);
        if (r12 == false) goto L27;
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade success, type=isSmallVideo");
        this.isDowngraded = true;
        return true;
    L27:
        if (this.isPlayOriginEnabled == true) goto L30;
        return false;
    L30:
        if (this.isDropOriginVideoPreviewLimitation == false) goto L33;
        this.isDowngraded = true;
        r19.K(3);
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade success, type=littleBitRate");
        return true;
    L33:
        String[] r3 = r8.getVideoSupportSourcePreviewType();
        if (r3 != null) goto L36;
    L67:
        tt5.a.k("DrivePlatform_Processor", "isSupportDowngrade fail, type is empty");
        return false;
    L36:
        if (r3.length != 0) goto L38;
        boolean r13 = true;
    L39:
        if (r13 == true) goto L67;
        PreviewMeta r14 = r19.t(17);
        if (r14 == null) goto L46;
        PreviewMeta.MetaInfo r16 = r14.getMetaInfo();
        if (r16 == null) goto L46;
        r7 = r16.streams;
    L46:
        VideoMetaInfo r17 = findVideoMetaInfo(r7);
        if (r17 != null) goto L50;
        tt5.a.k("DrivePlatform_Processor", "isSupportDowngrade fail, videoMetaInfo not found");
        return false;
    L50:
        String r20 = r17.getCodecName();
        if (r20 == null) goto L54;
        String r21 = r20.toLowerCase(Locale.ROOT);
        if (r21 == null) goto L54;
    L56:
        if (ArraysKt.contains(r3, r21) == false) goto L65;
        int r4 = r17.getBitRate();
        if (1 > r4) goto L61;
        if (r4 >= r9) goto L61;
        boolean r22 = true;
    L62:
        if (r22 == false) goto L65;
        this.isDowngraded = true;
        r19.K(3);
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade success, type=littleBitRate");
        return true;
    L61:
        r22 = false;
    L65:
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade fail, no hit source preview");
        return false;
    L54:
        r21 = "";
        goto L56
    L38:
        r13 = false;
        goto L39
    L21:
        r12 = false;
    L69:
        tt5.a.h("DrivePlatform_Processor", "isSupportDowngrade=false!! isDowngraded=" + this.isDowngraded + ", localSupport=" + r5 + ", isVideo=" + r6);
        goto L70
    }
}
