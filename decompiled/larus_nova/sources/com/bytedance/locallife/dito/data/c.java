package com.bytedance.locallife.dito.data;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/dito/data/c;", "", "", "viewStub", "Z", "f", "()Z", "mergeDisable", "d", "mergeOldDataWhenEmpty", "e", "", "loadStrategy", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setLoadStrategy", "(Ljava/lang/String;)V", "isScroll", RXScreenCaptureService.KEY_INDEX, "enablePresetSizeCache", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setEnablePresetSizeCache", "(Ljava/lang/Boolean;)V", "isPreloadInBody", "h", "setPreloadInBody", "isFloat", ce.f26391f, "customCardVisibility", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCustomCardVisibility", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("customCardVisibility")
    private String customCardVisibility;

    @SerializedName("enablePresetSizeCache")
    private Boolean enablePresetSizeCache;

    @SerializedName("isFloat")
    private final Boolean isFloat;

    @SerializedName("isPreloadInBody")
    private Boolean isPreloadInBody;

    @SerializedName("isScroll")
    private final boolean isScroll;

    @SerializedName("loadStrategy")
    private String loadStrategy;

    @SerializedName("mergeDisable")
    private final boolean mergeDisable;

    @SerializedName("mergeOldDataWhenEmpty")
    private final boolean mergeOldDataWhenEmpty;

    @SerializedName("viewStub")
    private final boolean viewStub;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.viewStub == r101.viewStub) goto L12;
        return false;
    L12:
        if (this.mergeDisable == r101.mergeDisable) goto L15;
        return false;
    L15:
        if (this.mergeOldDataWhenEmpty == r101.mergeOldDataWhenEmpty) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.loadStrategy, r101.loadStrategy) == true) goto L21;
        return false;
    L21:
        if (this.isScroll == r101.isScroll) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enablePresetSizeCache, r101.enablePresetSizeCache) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isPreloadInBody, r101.isPreloadInBody) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isFloat, r101.isFloat) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.customCardVisibility, r101.customCardVisibility) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.viewStub == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.mergeDisable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.mergeOldDataWhenEmpty == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        String r107 = this.loadStrategy;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        if (this.isScroll == true) goto L22;
        r100 = 1237;
    L22:
        int r111 = (r110 + r100) * 31;
        Boolean r112 = this.enablePresetSizeCache;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r111 + r113) * 31;
        Boolean r115 = this.isPreloadInBody;
        if (r115 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.isFloat;
        if (r118 != null) goto L33;
        int r119 = 0;
    L34:
        int r120 = (r117 + r119) * 31;
        String r121 = this.customCardVisibility;
        if (r121 == null) goto L39;
        r108 = r121.hashCode();
    L39:
        return r120 + r108;
    L33:
        r119 = r118.hashCode();
        goto L34
    L29:
        r116 = r115.hashCode();
        goto L30
    L25:
        r113 = r112.hashCode();
        goto L26
    L17:
        r109 = r107.hashCode();
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "Config(viewStub=" + this.viewStub + ", mergeDisable=" + this.mergeDisable + ", mergeOldDataWhenEmpty=" + this.mergeOldDataWhenEmpty + ", loadStrategy=" + this.loadStrategy + ", isScroll=" + this.isScroll + ", enablePresetSizeCache=" + this.enablePresetSizeCache + ", isPreloadInBody=" + this.isPreloadInBody + ", isFloat=" + this.isFloat + ", customCardVisibility=" + this.customCardVisibility + ')';
    }

    public c() {
        this.viewStub = false;
        this.mergeDisable = false;
        this.mergeOldDataWhenEmpty = false;
        this.loadStrategy = null;
        this.isScroll = false;
        this.enablePresetSizeCache = null;
        this.isPreloadInBody = null;
        this.isFloat = null;
        this.customCardVisibility = "";
    }

    public final String a() {
        return this.customCardVisibility;
    }

    public final Boolean b() {
        return this.enablePresetSizeCache;
    }

    public final String c() {
        return this.loadStrategy;
    }

    public final boolean d() {
        return this.mergeDisable;
    }

    public final boolean e() {
        return this.mergeOldDataWhenEmpty;
    }

    public final boolean f() {
        return this.viewStub;
    }

    public final Boolean g() {
        return this.isFloat;
    }

    public final Boolean h() {
        return this.isPreloadInBody;
    }

    public final boolean i() {
        return this.isScroll;
    }
}
