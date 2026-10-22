package com.larksuite.component.card.component.checkbox;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ2\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/CheckBoxState;", "", "isSelected", "", "showRequired", "isEnabled", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowRequired", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larksuite/component/card/component/checkbox/CheckBoxState;", "equals", "other", "hashCode", "", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckBoxState {
    private final Boolean isEnabled;
    private final Boolean isSelected;
    private final Boolean showRequired;

    public static /* synthetic */ CheckBoxState copy$default(CheckBoxState r100, Boolean r101, Boolean r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isSelected;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.showRequired;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.isEnabled;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.isSelected;
    }

    public final Boolean component2() {
        return this.showRequired;
    }

    public final Boolean component3() {
        return this.isEnabled;
    }

    public final CheckBoxState copy(Boolean r100, Boolean r101, Boolean r102) {
        return new CheckBoxState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckBoxState) == true) goto L8;
        return false;
    L8:
        CheckBoxState r101 = (CheckBoxState) r100;
        if (Intrinsics.areEqual(this.isSelected, r101.isSelected) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showRequired, r101.showRequired) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isEnabled, r101.isEnabled) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.isSelected;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showRequired;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isEnabled;
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
        return "CheckBoxState(isSelected=" + this.isSelected + ", showRequired=" + this.showRequired + ", isEnabled=" + this.isEnabled + ')';
    }

    public final Boolean getShowRequired() {
        return this.showRequired;
    }

    public final Boolean isEnabled() {
        return this.isEnabled;
    }

    public final Boolean isSelected() {
        return this.isSelected;
    }

    public CheckBoxState(Boolean r100, Boolean r101, Boolean r102) {
        this.isSelected = r100;
        this.showRequired = r101;
        this.isEnabled = r102;
    }
}
