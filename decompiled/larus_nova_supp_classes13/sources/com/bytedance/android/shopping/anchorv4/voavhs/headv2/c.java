package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/c;", "", "", "maskColor", "Ljava/lang/String;", "getMaskColor", "()Ljava/lang/String;", "", "blur", "F", "getBlur", "()F", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("blur")
    private final float blur;

    @SerializedName("mask_color")
    private final String maskColor;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.maskColor, r4.maskColor) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.blur, r4.blur) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.maskColor;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + Float.floatToIntBits(this.blur);
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "EffectConfig(maskColor=" + this.maskColor + ", blur=" + this.blur + ")";
    }
}
