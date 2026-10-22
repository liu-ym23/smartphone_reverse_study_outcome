package oq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b;\b\u0086\b\u0018\u0000 P2\u00020\u0001:\u0001PBå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jì\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u000bHÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001d¨\u0006Q"}, d2 = {"Lcom/larus/platform/model/camera/EduCameraConfig;", "", "captureGeneralTipTitle", "", "captureGeneralTipSubTitle", "captureCalculationTipTitle", "captureCalculationTipSubTitle", "captureArticleTipTitle", "captureArticleTipSubTitle", "clipToast", "clipImageQuality", "", "cloudClipTimeoutMs", "", "imageReportSampleRate", "", "captureArticleImageCount", "captureGeneralIconTip", "captureArticleIconTip", "captureGaokaoIconTip", "captureCalculationIconTip", "enableMultiQuestion", "", "captureHomeworkTipTitle", "captureHomeworkTipSubTitle", "captureHomeworkIconTip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJFLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCaptureGeneralTipTitle", "()Ljava/lang/String;", "getCaptureGeneralTipSubTitle", "getCaptureCalculationTipTitle", "getCaptureCalculationTipSubTitle", "getCaptureArticleTipTitle", "getCaptureArticleTipSubTitle", "getClipToast", "getClipImageQuality", "()I", "getCloudClipTimeoutMs", "()J", "getImageReportSampleRate", "()F", "getCaptureArticleImageCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCaptureGeneralIconTip", "getCaptureArticleIconTip", "getCaptureGaokaoIconTip", "getCaptureCalculationIconTip", "getEnableMultiQuestion", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCaptureHomeworkTipTitle", "getCaptureHomeworkTipSubTitle", "getCaptureHomeworkIconTip", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJFLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/camera/EduCameraConfig;", "equals", "other", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("capture_article_icon_tip")
    private final String captureArticleIconTip;

    @SerializedName("capture_article_image_count")
    private final Integer captureArticleImageCount;

    @SerializedName("capture_article_tip_sub_title")
    private final String captureArticleTipSubTitle;

    @SerializedName("capture_article_tip_title")
    private final String captureArticleTipTitle;

    @SerializedName("capture_calculation_icon_tip")
    private final String captureCalculationIconTip;

    @SerializedName("capture_calculation_tip_sub_title")
    private final String captureCalculationTipSubTitle;

    @SerializedName("capture_calculation_tip_title")
    private final String captureCalculationTipTitle;

    @SerializedName("capture_gaokao_icon_tip")
    private final String captureGaokaoIconTip;

    @SerializedName("capture_general_icon_tip")
    private final String captureGeneralIconTip;

    @SerializedName("capture_tip_sub_title")
    private final String captureGeneralTipSubTitle;

    @SerializedName("capture_tip_title")
    private final String captureGeneralTipTitle;

    @SerializedName("capture_homework_icon_tip")
    private final String captureHomeworkIconTip;

    @SerializedName("capture_homework_tip_sub_title")
    private final String captureHomeworkTipSubTitle;

    @SerializedName("capture_homework_tip_title")
    private final String captureHomeworkTipTitle;

    @SerializedName("clip_image_quality")
    private final int clipImageQuality;

    @SerializedName("clip_toast")
    private final String clipToast;

    @SerializedName("cloud_clip_timeout_ms")
    private final long cloudClipTimeoutMs;

    @SerializedName("enable_multi_question")
    private final Boolean enableMultiQuestion;

    @SerializedName("image_report_sample_rate")
    private final float imageReportSampleRate;

    public static final class a {
    }

    static {
    }

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.captureGeneralTipTitle, r101.captureGeneralTipTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.captureGeneralTipSubTitle, r101.captureGeneralTipSubTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.captureCalculationTipTitle, r101.captureCalculationTipTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.captureCalculationTipSubTitle, r101.captureCalculationTipSubTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.captureArticleTipTitle, r101.captureArticleTipTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.captureArticleTipSubTitle, r101.captureArticleTipSubTitle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.clipToast, r101.clipToast) == true) goto L30;
        return false;
    L30:
        if (this.clipImageQuality == r101.clipImageQuality) goto L33;
        return false;
    L33:
        if (this.cloudClipTimeoutMs == r101.cloudClipTimeoutMs) goto L36;
        return false;
    L36:
        if (Float.compare(this.imageReportSampleRate, r101.imageReportSampleRate) == 0) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.captureArticleImageCount, r101.captureArticleImageCount) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.captureGeneralIconTip, r101.captureGeneralIconTip) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.captureArticleIconTip, r101.captureArticleIconTip) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.captureGaokaoIconTip, r101.captureGaokaoIconTip) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.captureCalculationIconTip, r101.captureCalculationIconTip) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.enableMultiQuestion, r101.enableMultiQuestion) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.captureHomeworkTipTitle, r101.captureHomeworkTipTitle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.captureHomeworkTipSubTitle, r101.captureHomeworkTipSubTitle) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.captureHomeworkIconTip, r101.captureHomeworkIconTip) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        String r100 = this.captureGeneralTipTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.captureGeneralTipSubTitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.captureCalculationTipTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.captureCalculationTipSubTitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.captureArticleTipTitle;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.captureArticleTipSubTitle;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.clipToast;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.clipImageQuality) * 31;
        long r122 = this.cloudClipTimeoutMs;
        int r123 = (((r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31) + Float.floatToIntBits(this.imageReportSampleRate)) * 31;
        Integer r124 = this.captureArticleImageCount;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.captureGeneralIconTip;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.captureArticleIconTip;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.captureGaokaoIconTip;
        if (r133 != null) goto L45;
        int r134 = 0;
    L46:
        int r135 = (r132 + r134) * 31;
        String r136 = this.captureCalculationIconTip;
        if (r136 != null) goto L49;
        int r137 = 0;
    L50:
        int r138 = (r135 + r137) * 31;
        Boolean r139 = this.enableMultiQuestion;
        if (r139 != null) goto L53;
        int r140 = 0;
    L54:
        int r141 = (r138 + r140) * 31;
        String r142 = this.captureHomeworkTipTitle;
        if (r142 != null) goto L57;
        int r143 = 0;
    L58:
        int r144 = (r141 + r143) * 31;
        String r145 = this.captureHomeworkTipSubTitle;
        if (r145 != null) goto L61;
        int r146 = 0;
    L62:
        int r147 = (r144 + r146) * 31;
        String r148 = this.captureHomeworkIconTip;
        if (r148 == null) goto L67;
        r101 = r148.hashCode();
    L67:
        return r147 + r101;
    L61:
        r146 = r145.hashCode();
        goto L62
    L57:
        r143 = r142.hashCode();
        goto L58
    L53:
        r140 = r139.hashCode();
        goto L54
    L49:
        r137 = r136.hashCode();
        goto L50
    L45:
        r134 = r133.hashCode();
        goto L46
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EduCameraConfig(captureGeneralTipTitle=" + this.captureGeneralTipTitle + ", captureGeneralTipSubTitle=" + this.captureGeneralTipSubTitle + ", captureCalculationTipTitle=" + this.captureCalculationTipTitle + ", captureCalculationTipSubTitle=" + this.captureCalculationTipSubTitle + ", captureArticleTipTitle=" + this.captureArticleTipTitle + ", captureArticleTipSubTitle=" + this.captureArticleTipSubTitle + ", clipToast=" + this.clipToast + ", clipImageQuality=" + this.clipImageQuality + ", cloudClipTimeoutMs=" + this.cloudClipTimeoutMs + ", imageReportSampleRate=" + this.imageReportSampleRate + ", captureArticleImageCount=" + this.captureArticleImageCount + ", captureGeneralIconTip=" + this.captureGeneralIconTip + ", captureArticleIconTip=" + this.captureArticleIconTip + ", captureGaokaoIconTip=" + this.captureGaokaoIconTip + ", captureCalculationIconTip=" + this.captureCalculationIconTip + ", enableMultiQuestion=" + this.enableMultiQuestion + ", captureHomeworkTipTitle=" + this.captureHomeworkTipTitle + ", captureHomeworkTipSubTitle=" + this.captureHomeworkTipSubTitle + ", captureHomeworkIconTip=" + this.captureHomeworkIconTip + ')';
    }

    public final String a() {
        return this.captureArticleIconTip;
    }

    public final Integer b() {
        return this.captureArticleImageCount;
    }

    public final String c() {
        return this.captureArticleTipSubTitle;
    }

    public final String d() {
        return this.captureArticleTipTitle;
    }

    public final String e() {
        return this.captureCalculationIconTip;
    }

    public final String f() {
        return this.captureCalculationTipSubTitle;
    }

    public final String g() {
        return this.captureCalculationTipTitle;
    }

    public final String h() {
        return this.captureGaokaoIconTip;
    }

    public final String i() {
        return this.captureGeneralIconTip;
    }

    public final String j() {
        return this.captureGeneralTipSubTitle;
    }

    public final String k() {
        return this.captureGeneralTipTitle;
    }

    public final String l() {
        return this.captureHomeworkIconTip;
    }

    public final String m() {
        return this.captureHomeworkTipSubTitle;
    }

    public final String n() {
        return this.captureHomeworkTipTitle;
    }

    public final int o() {
        return this.clipImageQuality;
    }

    public final String p() {
        return this.clipToast;
    }

    public final long q() {
        return this.cloudClipTimeoutMs;
    }

    public final Boolean r() {
        return this.enableMultiQuestion;
    }

    public final float s() {
        return this.imageReportSampleRate;
    }

    public /* synthetic */ h(int r210) {
        this(null, null, null, null, null, null, null, 70, 800, 0.0f, 5, null, null, null, null, Boolean.FALSE, null, null, null);
    }

    public h(String r100, String r101, String r102, String r103, String r104, String r105, String r110, int r111, long r112, float r113, Integer r114, String r115, String r116, String r117, String r118, Boolean r210, String r211, String r212, String r213) {
        this.captureGeneralTipTitle = r100;
        this.captureGeneralTipSubTitle = r101;
        this.captureCalculationTipTitle = r102;
        this.captureCalculationTipSubTitle = r103;
        this.captureArticleTipTitle = r104;
        this.captureArticleTipSubTitle = r105;
        this.clipToast = r110;
        this.clipImageQuality = r111;
        this.cloudClipTimeoutMs = r112;
        this.imageReportSampleRate = r113;
        this.captureArticleImageCount = r114;
        this.captureGeneralIconTip = r115;
        this.captureArticleIconTip = r116;
        this.captureGaokaoIconTip = r117;
        this.captureCalculationIconTip = r118;
        this.enableMultiQuestion = r210;
        this.captureHomeworkTipTitle = r211;
        this.captureHomeworkTipSubTitle = r212;
        this.captureHomeworkIconTip = r213;
    }
}
