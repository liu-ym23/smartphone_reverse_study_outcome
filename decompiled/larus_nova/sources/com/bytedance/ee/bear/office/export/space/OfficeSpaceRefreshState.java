package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceRefreshState;", "Ljava/io/Serializable;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "refreshing", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Z)V", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getRefreshing", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceRefreshState implements Serializable {
    private final boolean refreshing;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    private final OfficeSpaceTab f235473tab;

    public static /* synthetic */ OfficeSpaceRefreshState copy$default(OfficeSpaceRefreshState r100, OfficeSpaceTab r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f235473tab;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.refreshing;
    L9:
        return r100.copy(r101, r102);
    }

    public final OfficeSpaceTab component1() {
        return this.f235473tab;
    }

    public final boolean component2() {
        return this.refreshing;
    }

    public final OfficeSpaceRefreshState copy(OfficeSpaceTab r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        return new OfficeSpaceRefreshState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceRefreshState) == true) goto L8;
        return false;
    L8:
        OfficeSpaceRefreshState r101 = (OfficeSpaceRefreshState) r100;
        if (this.f235473tab == r101.f235473tab) goto L12;
        return false;
    L12:
        if (this.refreshing == r101.refreshing) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.f235473tab.hashCode() * 31;
        if (this.refreshing == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "OfficeSpaceRefreshState(tab=" + this.f235473tab + ", refreshing=" + this.refreshing + ')';
    }

    public final boolean getRefreshing() {
        return this.refreshing;
    }

    public final OfficeSpaceTab getTab() {
        return this.f235473tab;
    }

    public OfficeSpaceRefreshState(OfficeSpaceTab r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.f235473tab = r100;
        this.refreshing = r101;
    }
}
