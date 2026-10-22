package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/y;", "", "", "textColor", "Ljava/lang/String;", "getTextColor", "()Ljava/lang/String;", "frameColor", "getFrameColor", "bgColor", "getBgColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("frame_color")
    private final String frameColor;

    @SerializedName("text_color")
    private final String textColor;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y) == false) goto L12;
        y r4 = (y) r3;
        if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.frameColor, r4.frameColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r4.bgColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.textColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.frameColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.bgColor;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopTextStyle(textColor=" + this.textColor + ", frameColor=" + this.frameColor + ", bgColor=" + this.bgColor + ")";
    }

    public y() {
        this.textColor = null;
        this.frameColor = null;
        this.bgColor = null;
    }
}
