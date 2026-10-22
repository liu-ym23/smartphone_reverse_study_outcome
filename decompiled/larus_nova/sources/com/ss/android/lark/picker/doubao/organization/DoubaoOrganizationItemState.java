package com.ss.android.lark.picker.doubao.organization;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "", "isSelected", "", "isEnabled", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoOrganizationItemState {
    private final boolean isEnabled;
    private final boolean isSelected;

    public static /* synthetic */ DoubaoOrganizationItemState copy$default(DoubaoOrganizationItemState r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isSelected;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isEnabled;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isSelected;
    }

    public final boolean component2() {
        return this.isEnabled;
    }

    public final DoubaoOrganizationItemState copy(boolean r100, boolean r101) {
        return new DoubaoOrganizationItemState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoOrganizationItemState) == true) goto L8;
        return false;
    L8:
        DoubaoOrganizationItemState r101 = (DoubaoOrganizationItemState) r100;
        if (this.isSelected == r101.isSelected) goto L12;
        return false;
    L12:
        if (this.isEnabled == r101.isEnabled) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isSelected == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isEnabled == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DoubaoOrganizationItemState(isSelected=" + this.isSelected + ", isEnabled=" + this.isEnabled + ')';
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public DoubaoOrganizationItemState(boolean r100, boolean r101) {
        this.isSelected = r100;
        this.isEnabled = r101;
    }
}
