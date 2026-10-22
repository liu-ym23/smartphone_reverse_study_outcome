package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lw8.j;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/larus/business/markdown/api/model/ListStyle;", "", "Llw8/j;", "component1", "", "component2", "symbolStrategy", "enableListInLooseListMargin", "copy", "", "toString", "", "hashCode", "other", "equals", "Llw8/j;", "getSymbolStrategy", "()Llw8/j;", "Z", "getEnableListInLooseListMargin", "()Z", "<init>", "(Llw8/j;Z)V", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final class ListStyle {
    private final boolean enableListInLooseListMargin;
    private final j symbolStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public ListStyle() {
        j r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ListStyle copy$default(ListStyle r100, j r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.symbolStrategy;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableListInLooseListMargin;
    L9:
        return r100.copy(r101, r102);
    }

    public final j component1() {
        return this.symbolStrategy;
    }

    public final boolean component2() {
        return this.enableListInLooseListMargin;
    }

    public final ListStyle copy(j r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "symbolStrategy");
        return new ListStyle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ListStyle) == true) goto L8;
        return false;
    L8:
        ListStyle r101 = (ListStyle) r100;
        if (Intrinsics.areEqual(this.symbolStrategy, r101.symbolStrategy) == true) goto L12;
        return false;
    L12:
        if (this.enableListInLooseListMargin == r101.enableListInLooseListMargin) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int r100 = this.symbolStrategy.hashCode() * 31;
        boolean r101 = this.enableListInLooseListMargin;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public String toString() {
        return "ListStyle(symbolStrategy=" + this.symbolStrategy + ", enableListInLooseListMargin=" + this.enableListInLooseListMargin + ')';
    }

    public final boolean getEnableListInLooseListMargin() {
        return this.enableListInLooseListMargin;
    }

    public final j getSymbolStrategy() {
        return this.symbolStrategy;
    }

    public ListStyle(j r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "symbolStrategy");
        this.symbolStrategy = r100;
        this.enableListInLooseListMargin = r101;
    }

    public /* synthetic */ ListStyle(j r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new j.a();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
