package com.larus.home.impl.main.side_bar.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/SideBarRefreshPayload;", "", "needPull", "", "sidebarLayout", "Lcom/larus/home/impl/main/side_bar/data/SideBarLayout;", "<init>", "(ZLcom/larus/home/impl/main/side_bar/data/SideBarLayout;)V", "getNeedPull", "()Z", "getSidebarLayout", "()Lcom/larus/home/impl/main/side_bar/data/SideBarLayout;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z0 {

    @SerializedName("need_pull")
    private final boolean needPull;

    @SerializedName("sidebar_layout")
    private final k0 sidebarLayout;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (this.needPull == r101.needPull) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sidebarLayout, r101.sidebarLayout) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.needPull == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        k0 r102 = this.sidebarLayout;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SideBarRefreshPayload(needPull=" + this.needPull + ", sidebarLayout=" + this.sidebarLayout + ')';
    }

    public z0() {
        this.needPull = false;
        this.sidebarLayout = null;
    }

    public final boolean a() {
        return this.needPull;
    }

    public final k0 b() {
        return this.sidebarLayout;
    }
}
