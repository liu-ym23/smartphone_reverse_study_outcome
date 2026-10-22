package com.larus.common.venue.impl.venue.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import w1a.b;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/common/venue/impl/venue/viewmodel/TransparentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "hasShowMenu", "", "hasShowIme", "<init>", "(ZZ)V", "getHasShowMenu", "()Z", "getHasShowIme", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransparentState implements b {
    private final boolean hasShowIme;
    private final boolean hasShowMenu;

    public TransparentState() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ TransparentState copy$default(TransparentState r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.hasShowMenu;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hasShowIme;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.hasShowMenu;
    }

    public final boolean component2() {
        return this.hasShowIme;
    }

    public final TransparentState copy(boolean r100, boolean r101) {
        return new TransparentState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TransparentState) == true) goto L8;
        return false;
    L8:
        TransparentState r101 = (TransparentState) r100;
        if (this.hasShowMenu == r101.hasShowMenu) goto L12;
        return false;
    L12:
        if (this.hasShowIme == r101.hasShowIme) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.hasShowMenu == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.hasShowIme == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "TransparentState(hasShowMenu=" + this.hasShowMenu + ", hasShowIme=" + this.hasShowIme + ')';
    }

    public final boolean getHasShowIme() {
        return this.hasShowIme;
    }

    public final boolean getHasShowMenu() {
        return this.hasShowMenu;
    }

    public TransparentState(boolean r100, boolean r101) {
        this.hasShowMenu = r100;
        this.hasShowIme = r101;
    }

    public /* synthetic */ TransparentState(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
