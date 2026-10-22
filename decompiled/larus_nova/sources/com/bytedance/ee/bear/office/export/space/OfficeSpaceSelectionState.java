package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceSelectionState;", "Ljava/io/Serializable;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "selectedItems", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Ljava/util/List;)V", "isInSelectionMode", "", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Ljava/util/List;Z)V", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getSelectedItems", "()Ljava/util/List;", "value", "()Z", "withSelectionMode", "equals", "other", "", "hashCode", "", "toString", "", "component1", "component2", "copy", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceSelectionState implements Serializable {
    private boolean isInSelectionMode;
    private final List<OfficeSpaceItem> selectedItems;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    private final OfficeSpaceTab f235474tab;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceSelectionState copy$default(OfficeSpaceSelectionState r100, OfficeSpaceTab r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f235474tab;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.selectedItems;
    L9:
        return r100.copy(r101, r102);
    }

    public final OfficeSpaceTab component1() {
        return this.f235474tab;
    }

    public final List<OfficeSpaceItem> component2() {
        return this.selectedItems;
    }

    public final OfficeSpaceSelectionState copy(OfficeSpaceTab r100, List<OfficeSpaceItem> r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "selectedItems");
        return new OfficeSpaceSelectionState(r100, r101);
    }

    public int hashCode() {
        int r100 = ((this.f235474tab.hashCode() * 31) + this.selectedItems.hashCode()) * 31;
        if (this.isInSelectionMode == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "OfficeSpaceSelectionState(tab=" + this.f235474tab + ", selectedItems=" + this.selectedItems + ", isInSelectionMode=" + this.isInSelectionMode + ')';
    }

    public final List<OfficeSpaceItem> getSelectedItems() {
        return this.selectedItems;
    }

    public final OfficeSpaceTab getTab() {
        return this.f235474tab;
    }

    public final boolean isInSelectionMode() {
        return this.isInSelectionMode;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceSelectionState) == true) goto L8;
        return false;
    L8:
        OfficeSpaceSelectionState r101 = (OfficeSpaceSelectionState) r100;
        if (this.f235474tab == r101.f235474tab) goto L11;
    L15:
        return false;
    L11:
        if (Intrinsics.areEqual(this.selectedItems, r101.selectedItems) == false) goto L15;
        if (this.isInSelectionMode != r101.isInSelectionMode) goto L15;
        return true;
    }

    public final OfficeSpaceSelectionState withSelectionMode(boolean r100) {
        return new OfficeSpaceSelectionState(this.f235474tab, this.selectedItems, r100);
    }

    public OfficeSpaceSelectionState(OfficeSpaceTab r100, List<OfficeSpaceItem> r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "selectedItems");
        this.f235474tab = r100;
        this.selectedItems = r101;
    }

    public OfficeSpaceSelectionState(OfficeSpaceTab r100, List<OfficeSpaceItem> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "selectedItems");
        this(r100, r101);
        this.isInSelectionMode = r102;
    }
}
