package com.ss.android.lark.picker.doubao.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/doubao/api/DoubaoLocalChatterTagState;", "", "isResigned", "", "isFrozen", "isOnLeave", "isExternal", "<init>", "(ZZZZ)V", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoLocalChatterTagState {
    private final boolean isExternal;
    private final boolean isFrozen;
    private final boolean isOnLeave;
    private final boolean isResigned;

    public DoubaoLocalChatterTagState() {
        this(false, false, false, false, 15, null);
    }

    public static /* synthetic */ DoubaoLocalChatterTagState copy$default(DoubaoLocalChatterTagState r100, boolean r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isResigned;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isFrozen;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isOnLeave;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isExternal;
    L15:
        return r100.copy(r101, r102, r103, r104);
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

    public final DoubaoLocalChatterTagState copy(boolean r100, boolean r101, boolean r102, boolean r103) {
        return new DoubaoLocalChatterTagState(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DoubaoLocalChatterTagState) == true) goto L8;
        return false;
    L8:
        DoubaoLocalChatterTagState r101 = (DoubaoLocalChatterTagState) r100;
        if (this.isResigned == r101.isResigned) goto L12;
        return false;
    L12:
        if (this.isFrozen == r101.isFrozen) goto L15;
        return false;
    L15:
        if (this.isOnLeave == r101.isOnLeave) goto L18;
        return false;
    L18:
        if (this.isExternal == r101.isExternal) goto L20;
        return false;
    L20:
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
        if (this.isExternal == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
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
        return "DoubaoLocalChatterTagState(isResigned=" + this.isResigned + ", isFrozen=" + this.isFrozen + ", isOnLeave=" + this.isOnLeave + ", isExternal=" + this.isExternal + ')';
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

    public final boolean isResigned() {
        return this.isResigned;
    }

    public DoubaoLocalChatterTagState(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.isResigned = r100;
        this.isFrozen = r101;
        this.isOnLeave = r102;
        this.isExternal = r103;
    }

    public /* synthetic */ DoubaoLocalChatterTagState(boolean r100, boolean r101, boolean r102, boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this(r100, r101, r102, r103);
    }
}
