package com.larksuite.component.card.component.checkbox;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "", "backgroundColor", "", "borderColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getBorderColor", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckBoxStyles {
    private final String backgroundColor;
    private final String borderColor;

    public static /* synthetic */ CheckBoxStyles copy$default(CheckBoxStyles r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.borderColor;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final String component2() {
        return this.borderColor;
    }

    public final CheckBoxStyles copy(String r100, String r101) {
        return new CheckBoxStyles(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckBoxStyles) == true) goto L8;
        return false;
    L8:
        CheckBoxStyles r101 = (CheckBoxStyles) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.borderColor;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckBoxStyles(backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public CheckBoxStyles(String r100, String r101) {
        this.backgroundColor = r100;
        this.borderColor = r101;
    }
}
