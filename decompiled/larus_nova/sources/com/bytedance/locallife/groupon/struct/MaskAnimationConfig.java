package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010#J\u0096\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0014¨\u00068"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;", "Ljava/io/Serializable;", "targetId", "", "guideImgUrl", "", "backgroundColorAlpha", "", "backgroundColor", "highLightColorArr", "borderWidth", "borderRadius", "scanTimes", "", "stayDuration", "", "maskAnimDurationConfig", "Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBackgroundColorAlpha", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getBorderRadius", "getBorderWidth", "getGuideImgUrl", "()Ljava/util/List;", "getHighLightColorArr", "getMaskAnimDurationConfig", "()Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;", "getScanTimes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStayDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTargetId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Long;Lcom/bytedance/locallife/groupon/struct/MaskAnimDurationConfig;)Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;", "equals", "", "other", "", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class MaskAnimationConfig implements Serializable {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("background_color_alpha")
    private final Float backgroundColorAlpha;

    @SerializedName("border_radius")
    private final Float borderRadius;

    @SerializedName("border_width")
    private final Float borderWidth;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    private final List<String> guideImgUrl;

    @SerializedName("high_light_color_arr")
    private final List<String> highLightColorArr;

    @SerializedName("mask_anim_duration_config")
    private final MaskAnimDurationConfig maskAnimDurationConfig;

    @SerializedName("scan_times")
    private final Integer scanTimes;

    @SerializedName("stay_duration")
    private final Long stayDuration;

    @SerializedName("target_id")
    private final String targetId;

    public MaskAnimationConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaskAnimationConfig copy$default(MaskAnimationConfig r110, String r111, List r112, Float r113, String r114, List r115, Float r116, Float r117, Integer r118, Long r210, MaskAnimDurationConfig r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.targetId;
    L7:
        if ((r212 & 2) == 0) goto L9;
        List r101 = r110.guideImgUrl;
    L11:
        if ((r212 & 4) == 0) goto L13;
        Float r102 = r110.backgroundColorAlpha;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.backgroundColor;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r104 = r110.highLightColorArr;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Float r105 = r110.borderWidth;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Float r106 = r110.borderRadius;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r107 = r110.scanTimes;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Long r119 = r110.stayDuration;
    L39:
        if ((r212 & 512) == 0) goto L41;
        MaskAnimDurationConfig r108 = r110.maskAnimDurationConfig;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.targetId;
    }

    public final MaskAnimDurationConfig component10() {
        return this.maskAnimDurationConfig;
    }

    public final List<String> component2() {
        return this.guideImgUrl;
    }

    public final Float component3() {
        return this.backgroundColorAlpha;
    }

    public final String component4() {
        return this.backgroundColor;
    }

    public final List<String> component5() {
        return this.highLightColorArr;
    }

    public final Float component6() {
        return this.borderWidth;
    }

    public final Float component7() {
        return this.borderRadius;
    }

    public final Integer component8() {
        return this.scanTimes;
    }

    public final Long component9() {
        return this.stayDuration;
    }

    public final MaskAnimationConfig copy(String r110, List<String> r111, Float r112, String r113, List<String> r114, Float r115, Float r116, Integer r210, Long r211, MaskAnimDurationConfig r212) {
        return new MaskAnimationConfig(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MaskAnimationConfig) == true) goto L8;
        return false;
    L8:
        MaskAnimationConfig r101 = (MaskAnimationConfig) r100;
        if (Intrinsics.areEqual(this.targetId, r101.targetId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideImgUrl, r101.guideImgUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColorAlpha, r101.backgroundColorAlpha) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.highLightColorArr, r101.highLightColorArr) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.borderWidth, r101.borderWidth) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.scanTimes, r101.scanTimes) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.stayDuration, r101.stayDuration) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.maskAnimDurationConfig, r101.maskAnimDurationConfig) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.targetId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.guideImgUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.backgroundColorAlpha;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backgroundColor;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.highLightColorArr;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.borderWidth;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Float r119 = this.borderRadius;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.scanTimes;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.stayDuration;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        MaskAnimDurationConfig r128 = this.maskAnimDurationConfig;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
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

    public String toString() {
        return "MaskAnimationConfig(targetId=" + this.targetId + ", guideImgUrl=" + this.guideImgUrl + ", backgroundColorAlpha=" + this.backgroundColorAlpha + ", backgroundColor=" + this.backgroundColor + ", highLightColorArr=" + this.highLightColorArr + ", borderWidth=" + this.borderWidth + ", borderRadius=" + this.borderRadius + ", scanTimes=" + this.scanTimes + ", stayDuration=" + this.stayDuration + ", maskAnimDurationConfig=" + this.maskAnimDurationConfig + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Float getBackgroundColorAlpha() {
        return this.backgroundColorAlpha;
    }

    public final Float getBorderRadius() {
        return this.borderRadius;
    }

    public final Float getBorderWidth() {
        return this.borderWidth;
    }

    public final List<String> getGuideImgUrl() {
        return this.guideImgUrl;
    }

    public final List<String> getHighLightColorArr() {
        return this.highLightColorArr;
    }

    public final MaskAnimDurationConfig getMaskAnimDurationConfig() {
        return this.maskAnimDurationConfig;
    }

    public final Integer getScanTimes() {
        return this.scanTimes;
    }

    public final Long getStayDuration() {
        return this.stayDuration;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public MaskAnimationConfig(String r100, List<String> r101, Float r102, String r103, List<String> r104, Float r105, Float r106, Integer r107, Long r108, MaskAnimDurationConfig r110) {
        this.targetId = r100;
        this.guideImgUrl = r101;
        this.backgroundColorAlpha = r102;
        this.backgroundColor = r103;
        this.highLightColorArr = r104;
        this.borderWidth = r105;
        this.borderRadius = r106;
        this.scanTimes = r107;
        this.stayDuration = r108;
        this.maskAnimDurationConfig = r110;
    }

    public /* synthetic */ MaskAnimationConfig(String r110, List r111, Float r210, String r211, List r212, Float r213, Float r214, Integer r215, Long r216, MaskAnimDurationConfig r217, int r218, DefaultConstructorMarker r219) {
        Long r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        Float r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Float r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Float r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r218 & 256) != 0) goto L39;
        r100 = r216;
    L39:
        if ((r218 & 512) == 0) goto L41;
        MaskAnimDurationConfig r109 = new MaskAnimDurationConfig(null, null, null, null, null, 31, null);
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100, r109);
        return;
    L41:
        r109 = r217;
        goto L42
    L33:
        r108 = r215;
        goto L35
    L29:
        r107 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r105 = r212;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
