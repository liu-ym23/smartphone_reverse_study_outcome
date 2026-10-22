package com.bytedance.locallife.groupon.struct.bubble.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.locallife.groupon.struct.FrequencyInfo;
import com.bytedance.locallife.groupon.struct.bubble.RedDotAnimationStruct;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003JS\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/bytedance/locallife/groupon/struct/bubble/model/GrouponRedDotStruct;", "", "dotText", "", "jumpUrl", "trackParams", "", GXTemplateKey.GAIAX_ANIMATION, "Lcom/bytedance/locallife/groupon/struct/bubble/RedDotAnimationStruct;", "frequencyData", "Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/locallife/groupon/struct/bubble/RedDotAnimationStruct;Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;)V", "getAnimation", "()Lcom/bytedance/locallife/groupon/struct/bubble/RedDotAnimationStruct;", "dotHasClick", "", "getDotHasClick", "()Z", "setDotHasClick", "(Z)V", "getDotText", "()Ljava/lang/String;", "getFrequencyData", "()Lcom/bytedance/locallife/groupon/struct/FrequencyInfo;", "isShowing", "setShowing", "getJumpUrl", "getTrackParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponRedDotStruct {

    @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
    private final RedDotAnimationStruct animation;
    private boolean dotHasClick;

    @SerializedName("dot_text")
    private final String dotText;

    @SerializedName("frequency_data")
    private final FrequencyInfo frequencyData;
    private boolean isShowing;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("track_params")
    private final Map<String, Object> trackParams;

    public GrouponRedDotStruct() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GrouponRedDotStruct copy$default(GrouponRedDotStruct r100, String r101, String r102, Map r103, RedDotAnimationStruct r104, FrequencyInfo r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.dotText;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.jumpUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.trackParams;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.animation;
    L14:
        RedDotAnimationStruct r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.frequencyData;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.dotText;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final Map<String, Object> component3() {
        return this.trackParams;
    }

    public final RedDotAnimationStruct component4() {
        return this.animation;
    }

    public final FrequencyInfo component5() {
        return this.frequencyData;
    }

    public final GrouponRedDotStruct copy(String r100, String r101, Map<String, ? extends Object> r110, RedDotAnimationStruct r111, FrequencyInfo r112) {
        return new GrouponRedDotStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponRedDotStruct) == true) goto L8;
        return false;
    L8:
        GrouponRedDotStruct r101 = (GrouponRedDotStruct) r100;
        if (Intrinsics.areEqual(this.dotText, r101.dotText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.animation, r101.animation) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.frequencyData, r101.frequencyData) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.dotText;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.trackParams;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        RedDotAnimationStruct r110 = this.animation;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        FrequencyInfo r113 = this.frequencyData;
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
        return "GrouponRedDotStruct(dotText=" + this.dotText + ", jumpUrl=" + this.jumpUrl + ", trackParams=" + this.trackParams + ", animation=" + this.animation + ", frequencyData=" + this.frequencyData + ')';
    }

    public final RedDotAnimationStruct getAnimation() {
        return this.animation;
    }

    public final boolean getDotHasClick() {
        return this.dotHasClick;
    }

    public final String getDotText() {
        return this.dotText;
    }

    public final FrequencyInfo getFrequencyData() {
        return this.frequencyData;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void setDotHasClick(boolean r100) {
        this.dotHasClick = r100;
    }

    public final void setShowing(boolean r100) {
        this.isShowing = r100;
    }

    public GrouponRedDotStruct(String r100, String r101, Map<String, ? extends Object> r102, RedDotAnimationStruct r103, FrequencyInfo r104) {
        this.dotText = r100;
        this.jumpUrl = r101;
        this.trackParams = r102;
        this.animation = r103;
        this.frequencyData = r104;
    }

    public /* synthetic */ GrouponRedDotStruct(String r100, String r101, Map r102, RedDotAnimationStruct r103, FrequencyInfo r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = "";
    L5:
        FrequencyInfo r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        Map r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        RedDotAnimationStruct r108 = null;
    L18:
        if ((r105 & 16) != 0) goto L21;
        r106 = r104;
    L21:
        this(r100, r111, r107, r108, r106);
        return;
    L16:
        r108 = r103;
        goto L18
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
