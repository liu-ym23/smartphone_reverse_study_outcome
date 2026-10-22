package com.larus.community.impl.quickmenu;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o29.b;
import o29.c;
import o29.j;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/community/impl/quickmenu/QuickMenuConfig;", "", "title", "", "menuItems", "", "Lcom/larus/community/impl/quickmenu/QuickMenuItem;", "onItemClickListener", "Lcom/larus/community/impl/quickmenu/OnQuickMenuItemClickListener;", "onDismissListener", "Lcom/larus/community/impl/quickmenu/OnQuickMenuDismissListener;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/larus/community/impl/quickmenu/OnQuickMenuItemClickListener;Lcom/larus/community/impl/quickmenu/OnQuickMenuDismissListener;)V", "getTitle", "()Ljava/lang/String;", "getMenuItems", "()Ljava/util/List;", "getOnItemClickListener", "()Lcom/larus/community/impl/quickmenu/OnQuickMenuItemClickListener;", "getOnDismissListener", "()Lcom/larus/community/impl/quickmenu/OnQuickMenuDismissListener;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickMenuConfig {
    private final List<j> menuItems;
    private final b onDismissListener;
    private final c onItemClickListener;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuickMenuConfig copy$default(QuickMenuConfig r100, String r101, List r102, c r103, b r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.menuItems;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.onItemClickListener;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.onDismissListener;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final List<j> component2() {
        return this.menuItems;
    }

    public final c component3() {
        return this.onItemClickListener;
    }

    public final b component4() {
        return this.onDismissListener;
    }

    public final QuickMenuConfig copy(String r100, List<j> r101, c r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "menuItems");
        return new QuickMenuConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuickMenuConfig) == true) goto L8;
        return false;
    L8:
        QuickMenuConfig r101 = (QuickMenuConfig) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.menuItems, r101.menuItems) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onItemClickListener, r101.onItemClickListener) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.onDismissListener, r101.onDismissListener) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.menuItems.hashCode()) * 31;
        c r104 = this.onItemClickListener;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.onDismissListener;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "QuickMenuConfig(title=" + this.title + ", menuItems=" + this.menuItems + ", onItemClickListener=" + this.onItemClickListener + ", onDismissListener=" + this.onDismissListener + ')';
    }

    public final List<j> getMenuItems() {
        return this.menuItems;
    }

    public final b getOnDismissListener() {
        return this.onDismissListener;
    }

    public final c getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final String getTitle() {
        return this.title;
    }

    public QuickMenuConfig(String r100, List<j> r101, c r102, b r103) {
        Intrinsics.checkNotNullParameter(r101, "menuItems");
        this.title = r100;
        this.menuItems = r101;
        this.onItemClickListener = r102;
        this.onDismissListener = r103;
    }

    public /* synthetic */ QuickMenuConfig(String r100, List r101, c r102, b r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }
}
