package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/w;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "scoreIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "scoreIconHalf", "d", "scoreIconEmpty", "c", "", "fontColor", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("font_color")
    private final String fontColor;

    @SerializedName("score_icon")
    private final ECUrlModel scoreIcon;

    @SerializedName("score_icon_empty")
    private final ECUrlModel scoreIconEmpty;

    @SerializedName("score_icon_half")
    private final ECUrlModel scoreIconHalf;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w) == false) goto L14;
        w r4 = (w) r3;
        if (Intrinsics.areEqual(this.scoreIcon, r4.scoreIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scoreIconHalf, r4.scoreIconHalf) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scoreIconEmpty, r4.scoreIconEmpty) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r0 = this.scoreIcon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.scoreIconHalf;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.scoreIconEmpty;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.fontColor;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopScoreInfo(scoreIcon=" + this.scoreIcon + ", scoreIconHalf=" + this.scoreIconHalf + ", scoreIconEmpty=" + this.scoreIconEmpty + ", fontColor=" + this.fontColor + ")";
    }

    public w() {
        this.scoreIcon = null;
        this.scoreIconHalf = null;
        this.scoreIconEmpty = null;
        this.fontColor = null;
    }

    public final String a() {
        return this.fontColor;
    }

    public final ECUrlModel b() {
        return this.scoreIcon;
    }

    public final ECUrlModel c() {
        return this.scoreIconEmpty;
    }

    public final ECUrlModel d() {
        return this.scoreIconHalf;
    }
}
