package com.bytedance.locallife.poi.dito.poi.component;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/b0;", "", "", "offsetDp", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "startAlpha", "d", "endAlpha", "b", "", "durationMs", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("duration_ms")
    private final Long durationMs;

    @SerializedName("end_alpha")
    private final Float endAlpha;

    @SerializedName("offset_dp")
    private final Float offsetDp;

    @SerializedName("start_alpha")
    private final Float startAlpha;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.offsetDp, r101.offsetDp) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startAlpha, r101.startAlpha) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endAlpha, r101.endAlpha) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.durationMs, r101.durationMs) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Float r100 = this.offsetDp;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.startAlpha;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.endAlpha;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.durationMs;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "PoiLiveFloatCardScrollAnimationData(offsetDp=" + this.offsetDp + ", startAlpha=" + this.startAlpha + ", endAlpha=" + this.endAlpha + ", durationMs=" + this.durationMs + ')';
    }

    public b0() {
        this.offsetDp = null;
        this.startAlpha = null;
        this.endAlpha = null;
        this.durationMs = null;
    }

    public final Long a() {
        return this.durationMs;
    }

    public final Float b() {
        return this.endAlpha;
    }

    public final Float c() {
        return this.offsetDp;
    }

    public final Float d() {
        return this.startAlpha;
    }
}
