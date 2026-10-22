package com.ss.android.lark.picker.doubao.view.pickercommon;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JO\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/pickercommon/DoubaoPickerTagState;", "", "isResigned", "", "isFrozen", "isOnLeave", "isExternal", "isPublic", "isDepartment", "isAgent", "<init>", "(ZZZZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoPickerTagState {
    private final boolean isAgent;
    private final boolean isDepartment;
    private final boolean isExternal;
    private final boolean isFrozen;
    private final boolean isOnLeave;
    private final boolean isPublic;
    private final boolean isResigned;

    public DoubaoPickerTagState() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ DoubaoPickerTagState copy$default(DoubaoPickerTagState r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.isResigned;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.isFrozen;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.isOnLeave;
    L11:
        boolean r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isExternal;
    L14:
        boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isPublic;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isDepartment;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.isAgent;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.isResigned;
    }

    public final boolean component2() {
        return this.isFrozen;
    }

    public final boolean component3() {
        return this.isOnLeave;
    }

    public final boolean component4() {
        return this.isExternal;
    }

    public final boolean component5() {
        return this.isPublic;
    }

    public final boolean component6() {
        return this.isDepartment;
    }

    public final boolean component7() {
        return this.isAgent;
    }

    public final DoubaoPickerTagState copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116) {
        return new DoubaoPickerTagState(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoPickerTagState) == true) goto L8;
        return false;
    L8:
        DoubaoPickerTagState r101 = (DoubaoPickerTagState) r100;
        if (this.isResigned == r101.isResigned) goto L12;
        return false;
    L12:
        if (this.isFrozen == r101.isFrozen) goto L15;
        return false;
    L15:
        if (this.isOnLeave == r101.isOnLeave) goto L18;
        return false;
    L18:
        if (this.isExternal == r101.isExternal) goto L21;
        return false;
    L21:
        if (this.isPublic == r101.isPublic) goto L24;
        return false;
    L24:
        if (this.isDepartment == r101.isDepartment) goto L27;
        return false;
    L27:
        if (this.isAgent == r101.isAgent) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isResigned == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isFrozen == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.isOnLeave == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.isExternal == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.isPublic == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.isDepartment == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.isAgent == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DoubaoPickerTagState(isResigned=" + this.isResigned + ", isFrozen=" + this.isFrozen + ", isOnLeave=" + this.isOnLeave + ", isExternal=" + this.isExternal + ", isPublic=" + this.isPublic + ", isDepartment=" + this.isDepartment + ", isAgent=" + this.isAgent + ')';
    }

    public final boolean isAgent() {
        return this.isAgent;
    }

    public final boolean isDepartment() {
        return this.isDepartment;
    }

    public final boolean isExternal() {
        return this.isExternal;
    }

    public final boolean isFrozen() {
        return this.isFrozen;
    }

    public final boolean isOnLeave() {
        return this.isOnLeave;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean isResigned() {
        return this.isResigned;
    }

    public DoubaoPickerTagState(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.isResigned = r100;
        this.isFrozen = r101;
        this.isOnLeave = r102;
        this.isExternal = r103;
        this.isPublic = r104;
        this.isDepartment = r105;
        this.isAgent = r106;
    }

    public /* synthetic */ DoubaoPickerTagState(boolean r100, boolean r101, boolean r102, boolean r110, boolean r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        boolean r116 = false;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r114 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r117 = false;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
