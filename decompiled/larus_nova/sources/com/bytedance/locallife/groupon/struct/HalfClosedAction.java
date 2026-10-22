package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/HalfClosedAction;", "", "bubbleAction", "Lcom/bytedance/locallife/groupon/struct/NearbyUnderTakeBubbleStruct;", "maskLayerAction", "Lcom/bytedance/locallife/groupon/struct/NearbyMaskLayerStruct;", "tabPopGuideConfig", "Lcom/bytedance/locallife/groupon/struct/TabPopGuideConfigStruct;", "closeAnimation", "Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "refreshConfig", "Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "(Lcom/bytedance/locallife/groupon/struct/NearbyUnderTakeBubbleStruct;Lcom/bytedance/locallife/groupon/struct/NearbyMaskLayerStruct;Lcom/bytedance/locallife/groupon/struct/TabPopGuideConfigStruct;Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;Lcom/bytedance/locallife/groupon/struct/RefreshConfig;)V", "getBubbleAction", "()Lcom/bytedance/locallife/groupon/struct/NearbyUnderTakeBubbleStruct;", "getCloseAnimation", "()Lcom/bytedance/locallife/groupon/struct/CloseAnimationConfig;", "getMaskLayerAction", "()Lcom/bytedance/locallife/groupon/struct/NearbyMaskLayerStruct;", "getRefreshConfig", "()Lcom/bytedance/locallife/groupon/struct/RefreshConfig;", "getTabPopGuideConfig", "()Lcom/bytedance/locallife/groupon/struct/TabPopGuideConfigStruct;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HalfClosedAction {

    @SerializedName("bubble")
    private final NearbyUnderTakeBubbleStruct bubbleAction;

    @SerializedName("close_animation")
    private final CloseAnimationConfig closeAnimation;

    @SerializedName("mask_layer")
    private final NearbyMaskLayerStruct maskLayerAction;

    @SerializedName("refresh_config")
    private final RefreshConfig refreshConfig;

    @SerializedName("tab_pop_guide_config")
    private final TabPopGuideConfigStruct tabPopGuideConfig;

    public HalfClosedAction() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ HalfClosedAction copy$default(HalfClosedAction r100, NearbyUnderTakeBubbleStruct r101, NearbyMaskLayerStruct r102, TabPopGuideConfigStruct r103, CloseAnimationConfig r104, RefreshConfig r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bubbleAction;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maskLayerAction;
    L8:
        NearbyMaskLayerStruct r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.tabPopGuideConfig;
    L11:
        TabPopGuideConfigStruct r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.closeAnimation;
    L14:
        CloseAnimationConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.refreshConfig;
    L17:
        NearbyUnderTakeBubbleStruct r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final NearbyUnderTakeBubbleStruct component1() {
        return this.bubbleAction;
    }

    public final NearbyMaskLayerStruct component2() {
        return this.maskLayerAction;
    }

    public final TabPopGuideConfigStruct component3() {
        return this.tabPopGuideConfig;
    }

    public final CloseAnimationConfig component4() {
        return this.closeAnimation;
    }

    public final RefreshConfig component5() {
        return this.refreshConfig;
    }

    public final HalfClosedAction copy(NearbyUnderTakeBubbleStruct r100, NearbyMaskLayerStruct r101, TabPopGuideConfigStruct r110, CloseAnimationConfig r111, RefreshConfig r112) {
        return new HalfClosedAction(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HalfClosedAction) == true) goto L8;
        return false;
    L8:
        HalfClosedAction r101 = (HalfClosedAction) r100;
        if (Intrinsics.areEqual(this.bubbleAction, r101.bubbleAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maskLayerAction, r101.maskLayerAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabPopGuideConfig, r101.tabPopGuideConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.closeAnimation, r101.closeAnimation) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refreshConfig, r101.refreshConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        NearbyUnderTakeBubbleStruct r100 = this.bubbleAction;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        NearbyMaskLayerStruct r104 = this.maskLayerAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        TabPopGuideConfigStruct r107 = this.tabPopGuideConfig;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        CloseAnimationConfig r110 = this.closeAnimation;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        RefreshConfig r113 = this.refreshConfig;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "HalfClosedAction(bubbleAction=" + this.bubbleAction + ", maskLayerAction=" + this.maskLayerAction + ", tabPopGuideConfig=" + this.tabPopGuideConfig + ", closeAnimation=" + this.closeAnimation + ", refreshConfig=" + this.refreshConfig + ')';
    }

    public final NearbyUnderTakeBubbleStruct getBubbleAction() {
        return this.bubbleAction;
    }

    public final CloseAnimationConfig getCloseAnimation() {
        return this.closeAnimation;
    }

    public final NearbyMaskLayerStruct getMaskLayerAction() {
        return this.maskLayerAction;
    }

    public final RefreshConfig getRefreshConfig() {
        return this.refreshConfig;
    }

    public final TabPopGuideConfigStruct getTabPopGuideConfig() {
        return this.tabPopGuideConfig;
    }

    public HalfClosedAction(NearbyUnderTakeBubbleStruct r100, NearbyMaskLayerStruct r101, TabPopGuideConfigStruct r102, CloseAnimationConfig r103, RefreshConfig r104) {
        this.bubbleAction = r100;
        this.maskLayerAction = r101;
        this.tabPopGuideConfig = r102;
        this.closeAnimation = r103;
        this.refreshConfig = r104;
    }

    public /* synthetic */ HalfClosedAction(NearbyUnderTakeBubbleStruct r100, NearbyMaskLayerStruct r101, TabPopGuideConfigStruct r102, CloseAnimationConfig r103, RefreshConfig r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        NearbyUnderTakeBubbleStruct r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        NearbyMaskLayerStruct r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        TabPopGuideConfigStruct r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        CloseAnimationConfig r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        RefreshConfig r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
