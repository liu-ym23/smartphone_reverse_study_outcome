package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/u;", "", "", "strokeColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "useLocalGradientBorder", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "searchTextColor", "a", "searchTextColorCollapse", "getSearchTextColorCollapse", "searchBtnBgColor", "getSearchBtnBgColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("btn_bg_color")
    private final String searchBtnBgColor;

    @SerializedName("text_color")
    private final String searchTextColor;

    @SerializedName("collapse_text_color")
    private final String searchTextColorCollapse;

    @SerializedName("border_color")
    private final String strokeColor;

    @SerializedName("use_local_gradient_border")
    private final Integer useLocalGradientBorder;

    public u() {
        this.strokeColor = null;
        this.useLocalGradientBorder = 0;
        this.searchTextColor = null;
        this.searchTextColorCollapse = null;
        this.searchBtnBgColor = null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L16;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.strokeColor, r4.strokeColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.useLocalGradientBorder, r4.useLocalGradientBorder) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchTextColor, r4.searchTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchTextColorCollapse, r4.searchTextColorCollapse) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.searchBtnBgColor, r4.searchBtnBgColor) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.strokeColor;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.useLocalGradientBorder;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.searchTextColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.searchTextColorCollapse;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.searchBtnBgColor;
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
        return "SearchBarConfig(strokeColor=" + this.strokeColor + ", useLocalGradientBorder=" + this.useLocalGradientBorder + ", searchTextColor=" + this.searchTextColor + ", searchTextColorCollapse=" + this.searchTextColorCollapse + ", searchBtnBgColor=" + this.searchBtnBgColor + ")";
    }

    public final String a() {
        return this.searchTextColor;
    }

    public final String b() {
        return this.strokeColor;
    }

    public final Integer c() {
        return this.useLocalGradientBorder;
    }
}
