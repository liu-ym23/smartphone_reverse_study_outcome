package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/k;", "", "", "targetTabType", "Ljava/lang/String;", "getTargetTabType", "()Ljava/lang/String;", "targetCategory", "c", "targetSubCategory", "d", "", "sortType", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "bottomText", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("bottom_text")
    private final String bottomText;

    @SerializedName("sort_type")
    private final Long sortType;

    @SerializedName("target_category")
    private final String targetCategory;

    @SerializedName("target_sub_category")
    private final String targetSubCategory;

    @SerializedName("target_tab_type")
    private final String targetTabType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L16;
        k r4 = (k) r3;
        if (Intrinsics.areEqual(this.targetTabType, r4.targetTabType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetCategory, r4.targetCategory) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.targetSubCategory, r4.targetSubCategory) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sortType, r4.sortType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bottomText, r4.bottomText) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.targetTabType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.targetCategory;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.targetSubCategory;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.sortType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bottomText;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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
        return "WindowAnchorItemDTO(targetTabType=" + this.targetTabType + ", targetCategory=" + this.targetCategory + ", targetSubCategory=" + this.targetSubCategory + ", sortType=" + this.sortType + ", bottomText=" + this.bottomText + ")";
    }

    public k() {
        this.targetTabType = null;
        this.targetCategory = null;
        this.targetSubCategory = null;
        this.sortType = null;
        this.bottomText = null;
    }

    public final String a() {
        return this.bottomText;
    }

    public final Long b() {
        return this.sortType;
    }

    public final String c() {
        return this.targetCategory;
    }

    public final String d() {
        return this.targetSubCategory;
    }
}
