package com.bytedance.android.window.shop.home.tab.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/common/TabTypeRequestParamKey;", "Lcom/bytedance/android/window/shop/home/tab/common/WindowTabRequestParamKey;", "tabType", "", "(I)V", "getTabType", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabTypeRequestParamKey implements WindowTabRequestParamKey {
    private final int tabType;

    public static /* synthetic */ TabTypeRequestParamKey copy$default(TabTypeRequestParamKey r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.tabType;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.tabType;
    }

    public final TabTypeRequestParamKey copy(int r2) {
        return new TabTypeRequestParamKey(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof TabTypeRequestParamKey) == true) goto L6;
        return false;
    L6:
        if (this.tabType == ((TabTypeRequestParamKey) r2).tabType) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.tabType;
    }

    public String toString() {
        return "TabTypeRequestParamKey(tabType=" + this.tabType + ")";
    }

    public final int getTabType() {
        return this.tabType;
    }

    public TabTypeRequestParamKey(int r1) {
        this.tabType = r1;
    }
}
