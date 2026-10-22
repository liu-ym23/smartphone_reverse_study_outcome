package com.bytedance.android.window.shop.home.tab.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/common/CategoryRequestParamKey;", "Lcom/bytedance/android/window/shop/home/tab/common/WindowTabRequestParamKey;", "categoryId", "", "tabType", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCategoryId", "()Ljava/lang/String;", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/window/shop/home/tab/common/CategoryRequestParamKey;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryRequestParamKey implements WindowTabRequestParamKey {
    private final String categoryId;
    private final Integer tabType;

    public static /* synthetic */ CategoryRequestParamKey copy$default(CategoryRequestParamKey r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.categoryId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tabType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.categoryId;
    }

    public final Integer component2() {
        return this.tabType;
    }

    public final CategoryRequestParamKey copy(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "categoryId");
        return new CategoryRequestParamKey(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CategoryRequestParamKey) == false) goto L10;
        CategoryRequestParamKey r4 = (CategoryRequestParamKey) r3;
        if (Intrinsics.areEqual(this.categoryId, r4.categoryId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabType, r4.tabType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.categoryId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.tabType;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CategoryRequestParamKey(categoryId=" + this.categoryId + ", tabType=" + this.tabType + ")";
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public CategoryRequestParamKey(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "categoryId");
        this.categoryId = r2;
        this.tabType = r3;
    }

    public /* synthetic */ CategoryRequestParamKey(String r1, Integer r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
