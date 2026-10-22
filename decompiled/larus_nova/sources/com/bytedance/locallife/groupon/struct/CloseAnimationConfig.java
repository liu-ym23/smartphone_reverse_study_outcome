package com.bytedance.locallife.groupon.struct;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00017BM\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b*\u0010)RF\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "Ljava/io/Serializable;", "", "component1", "", "component2", "()Ljava/lang/Long;", "Lcom/bytedance/locallife/groupon/struct/AnimationConfig;", "component3", "Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;", "component4", "", "component5", "component6", ReportConstant.COMMON_ACTION_TYPE, "toolIconStayDuration", "animationConfig", "maskAnimationConfig", EventConstant.Key.MODULE, "targetId", "copy", "(ILjava/lang/Long;Lcom/bytedance/locallife/groupon/struct/AnimationConfig;Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "toString", "hashCode", "", "other", "", "equals", "I", "getActionType", "()I", "Ljava/lang/Long;", "getToolIconStayDuration", "Lcom/bytedance/locallife/groupon/struct/AnimationConfig;", "getAnimationConfig", "()Lcom/bytedance/locallife/groupon/struct/AnimationConfig;", "Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;", "getMaskAnimationConfig", "()Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "getTargetId", "Lkotlin/Pair;", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "value", "animControlInfo", "Lkotlin/Pair;", "getAnimControlInfo", "()Lkotlin/Pair;", "setAnimControlInfo", "(Lkotlin/Pair;)V", "<init>", "(ILjava/lang/Long;Lcom/bytedance/locallife/groupon/struct/AnimationConfig;Lcom/bytedance/locallife/groupon/struct/MaskAnimationConfig;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class CloseAnimationConfig implements Serializable {
    public static final int ACTION_TYPE_CLOSE_TO_ENTRANCE = 0;
    public static final int ACTION_TYPE_MASK_HIGHLIGHT_ENTRANCE = 1;
    public static final a Companion = null;

    @SerializedName("action_type")
    private final int actionType;
    private Pair<Boolean, FrequencyInfo> animControlInfo;

    @SerializedName("animation_config")
    private final AnimationConfig animationConfig;

    @SerializedName("mask_animation_config")
    private final MaskAnimationConfig maskAnimationConfig;

    @SerializedName("module_id")
    private final String module;

    @SerializedName("target_id")
    private final String targetId;

    @SerializedName("tool_icon_stay_duration")
    private final Long toolIconStayDuration;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CloseAnimationConfig() {
        this(0, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CloseAnimationConfig copy$default(CloseAnimationConfig r100, int r101, Long r102, AnimationConfig r103, MaskAnimationConfig r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.actionType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.toolIconStayDuration;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.animationConfig;
    L11:
        AnimationConfig r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.maskAnimationConfig;
    L14:
        MaskAnimationConfig r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.module;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.targetId;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.actionType;
    }

    public final Long component2() {
        return this.toolIconStayDuration;
    }

    public final AnimationConfig component3() {
        return this.animationConfig;
    }

    public final MaskAnimationConfig component4() {
        return this.maskAnimationConfig;
    }

    public final String component5() {
        return this.module;
    }

    public final String component6() {
        return this.targetId;
    }

    public final CloseAnimationConfig copy(int r100, Long r110, AnimationConfig r111, MaskAnimationConfig r112, String r113, String r114) {
        return new CloseAnimationConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CloseAnimationConfig) == true) goto L8;
        return false;
    L8:
        CloseAnimationConfig r101 = (CloseAnimationConfig) r100;
        if (this.actionType == r101.actionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toolIconStayDuration, r101.toolIconStayDuration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.animationConfig, r101.animationConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maskAnimationConfig, r101.maskAnimationConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.module, r101.module) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetId, r101.targetId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.actionType * 31;
        Long r101 = this.toolIconStayDuration;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        AnimationConfig r105 = this.animationConfig;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        MaskAnimationConfig r108 = this.maskAnimationConfig;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.module;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.targetId;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CloseAnimationConfig(actionType=" + this.actionType + ", toolIconStayDuration=" + this.toolIconStayDuration + ", animationConfig=" + this.animationConfig + ", maskAnimationConfig=" + this.maskAnimationConfig + ", module=" + this.module + ", targetId=" + this.targetId + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final Pair<Boolean, FrequencyInfo> getAnimControlInfo() {
        return this.animControlInfo;
    }

    public final AnimationConfig getAnimationConfig() {
        return this.animationConfig;
    }

    public final MaskAnimationConfig getMaskAnimationConfig() {
        return this.maskAnimationConfig;
    }

    public final String getModule() {
        return this.module;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final Long getToolIconStayDuration() {
        return this.toolIconStayDuration;
    }

    public final void setAnimControlInfo(Pair<Boolean, FrequencyInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.animControlInfo.getFirst().booleanValue() == true) goto L6;
        this.animControlInfo = r100;
        return;
    }

    public CloseAnimationConfig(int r100, Long r101, AnimationConfig r102, MaskAnimationConfig r103, String r104, String r105) {
        this.actionType = r100;
        this.toolIconStayDuration = r101;
        this.animationConfig = r102;
        this.maskAnimationConfig = r103;
        this.module = r104;
        this.targetId = r105;
        this.animControlInfo = new Pair(Boolean.FALSE, null);
    }

    public /* synthetic */ CloseAnimationConfig(int r100, Long r101, AnimationConfig r102, MaskAnimationConfig r103, String r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r105 = null;
        if ((r111 & 2) == 0) goto L8;
        Long r113 = null;
    L10:
        if ((r111 & 4) == 0) goto L12;
        AnimationConfig r106 = null;
    L14:
        if ((r111 & 8) == 0) goto L16;
        MaskAnimationConfig r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r108 = null;
    L22:
        if ((r111 & 32) != 0) goto L25;
        r105 = r110;
    L25:
        this(r100, r113, r106, r107, r108, r105);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
