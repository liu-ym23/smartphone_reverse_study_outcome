package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/a1;", "", "Lcom/bytedance/android/window/shop/repository/dto/b1;", "sectionStyleData", "Lcom/bytedance/android/window/shop/repository/dto/b1;", "b", "()Lcom/bytedance/android/window/shop/repository/dto/b1;", "", "Lcom/bytedance/android/window/shop/repository/dto/c;", "items", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "splitConfigType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("items")
    private final List<c> items;

    @SerializedName("section_style")
    private final b1 sectionStyleData;

    @SerializedName("split_config_type")
    private final Integer splitConfigType;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a1) == false) goto L12;
        a1 r4 = (a1) r3;
        if (Intrinsics.areEqual(this.sectionStyleData, r4.sectionStyleData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.items, r4.items) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.splitConfigType, r4.splitConfigType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        b1 r0 = this.sectionStyleData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<c> r4 = this.items;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.splitConfigType;
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
        return "WindowSectionDTO(sectionStyleData=" + this.sectionStyleData + ", items=" + this.items + ", splitConfigType=" + this.splitConfigType + ")";
    }

    public final List<c> a() {
        return this.items;
    }

    public final b1 b() {
        return this.sectionStyleData;
    }

    public final Integer c() {
        return this.splitConfigType;
    }
}
