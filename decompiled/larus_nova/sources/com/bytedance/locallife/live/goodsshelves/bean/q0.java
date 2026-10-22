package com.bytedance.locallife.live.goodsshelves.bean;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/q0;", "", "", "amount", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "", "prefix", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "longText", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("amount")
    private final float amount;

    @SerializedName("long_text")
    private final String longText;

    @SerializedName("prefix")
    private final String prefix;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (Float.compare(this.amount, r101.amount) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefix, r101.prefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.longText, r101.longText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.amount) * 31;
        String r101 = this.prefix;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.longText;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProductCompositePriceExpressionData(amount=" + this.amount + ", prefix=" + this.prefix + ", longText=" + this.longText + ')';
    }

    public q0() {
        this.amount = 0.0f;
        this.prefix = null;
        this.longText = null;
    }

    public final float a() {
        return this.amount;
    }

    public final String b() {
        return this.longText;
    }

    public final String c() {
        return this.prefix;
    }
}
