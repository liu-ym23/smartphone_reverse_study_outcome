package com.bytedance.locallife.poi.dito.poi.component;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.locallife.model.poi.resp.PoiDistanceModel;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/z;", "", "", "lynxUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "Lcom/google/gson/JsonElement;", "data", "Lcom/google/gson/JsonElement;", "b", "()Lcom/google/gson/JsonElement;", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "topOffset", "Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "h", "()Lcom/bytedance/locallife/model/poi/resp/PoiDistanceModel;", "", "scrollRestoreDelayMs", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "topBoundary", ce.f26391f, "bottomBoundary", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/locallife/poi/dito/poi/component/b0;", "leftScrollAnimation", "Lcom/bytedance/locallife/poi/dito/poi/component/b0;", "c", "()Lcom/bytedance/locallife/poi/dito/poi/component/b0;", "rightScrollAnimation", "e", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("bottom_boundary")
    private final PoiDistanceModel bottomBoundary;

    @SerializedName("data")
    private final JsonElement data;

    @SerializedName("left_scroll_animation")
    private final b0 leftScrollAnimation;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;

    @SerializedName("right_scroll_animation")
    private final b0 rightScrollAnimation;

    @SerializedName("scroll_restore_delay_ms")
    private final Long scrollRestoreDelayMs;

    @SerializedName("top_boundary")
    private final PoiDistanceModel topBoundary;

    @SerializedName("top_offset")
    private final PoiDistanceModel topOffset;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.topOffset, r101.topOffset) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scrollRestoreDelayMs, r101.scrollRestoreDelayMs) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.topBoundary, r101.topBoundary) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bottomBoundary, r101.bottomBoundary) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.leftScrollAnimation, r101.leftScrollAnimation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.rightScrollAnimation, r101.rightScrollAnimation) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lynxUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.data;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PoiDistanceModel r107 = this.topOffset;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.scrollRestoreDelayMs;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PoiDistanceModel r113 = this.topBoundary;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        PoiDistanceModel r116 = this.bottomBoundary;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        b0 r119 = this.leftScrollAnimation;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        b0 r122 = this.rightScrollAnimation;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
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
        return "PoiLiveFloatCardData(lynxUrl=" + this.lynxUrl + ", data=" + this.data + ", topOffset=" + this.topOffset + ", scrollRestoreDelayMs=" + this.scrollRestoreDelayMs + ", topBoundary=" + this.topBoundary + ", bottomBoundary=" + this.bottomBoundary + ", leftScrollAnimation=" + this.leftScrollAnimation + ", rightScrollAnimation=" + this.rightScrollAnimation + ')';
    }

    public z() {
        this.lynxUrl = null;
        this.data = null;
        this.topOffset = null;
        this.scrollRestoreDelayMs = null;
        this.topBoundary = null;
        this.bottomBoundary = null;
        this.leftScrollAnimation = null;
        this.rightScrollAnimation = null;
    }

    public final PoiDistanceModel a() {
        return this.bottomBoundary;
    }

    public final JsonElement b() {
        return this.data;
    }

    public final b0 c() {
        return this.leftScrollAnimation;
    }

    public final String d() {
        return this.lynxUrl;
    }

    public final b0 e() {
        return this.rightScrollAnimation;
    }

    public final Long f() {
        return this.scrollRestoreDelayMs;
    }

    public final PoiDistanceModel g() {
        return this.topBoundary;
    }

    public final PoiDistanceModel h() {
        return this.topOffset;
    }
}
