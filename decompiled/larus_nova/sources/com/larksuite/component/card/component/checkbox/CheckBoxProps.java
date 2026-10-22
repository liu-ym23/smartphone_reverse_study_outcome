package com.larksuite.component.card.component.checkbox;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/CheckBoxProps;", "", "multiSelect", "", "actionEnable", "squareShape", "size", "", "styles", "Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;)V", "getMultiSelect", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionEnable", "getSquareShape", "getSize", "()Ljava/lang/String;", "getStyles", "()Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larksuite/component/card/component/checkbox/CheckBoxStyles;)Lcom/larksuite/component/card/component/checkbox/CheckBoxProps;", "equals", "other", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckBoxProps {
    private final Boolean actionEnable;
    private final Boolean multiSelect;
    private final String size;
    private final Boolean squareShape;
    private final CheckBoxStyles styles;

    public static /* synthetic */ CheckBoxProps copy$default(CheckBoxProps r100, Boolean r101, Boolean r102, Boolean r103, String r104, CheckBoxStyles r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.multiSelect;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.actionEnable;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.squareShape;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.size;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.styles;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.multiSelect;
    }

    public final Boolean component2() {
        return this.actionEnable;
    }

    public final Boolean component3() {
        return this.squareShape;
    }

    public final String component4() {
        return this.size;
    }

    public final CheckBoxStyles component5() {
        return this.styles;
    }

    public final CheckBoxProps copy(Boolean r100, Boolean r101, Boolean r110, String r111, CheckBoxStyles r112) {
        return new CheckBoxProps(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckBoxProps) == true) goto L8;
        return false;
    L8:
        CheckBoxProps r101 = (CheckBoxProps) r100;
        if (Intrinsics.areEqual(this.multiSelect, r101.multiSelect) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionEnable, r101.actionEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.squareShape, r101.squareShape) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.styles, r101.styles) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.multiSelect;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.actionEnable;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.squareShape;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.size;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        CheckBoxStyles r113 = this.styles;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckBoxProps(multiSelect=" + this.multiSelect + ", actionEnable=" + this.actionEnable + ", squareShape=" + this.squareShape + ", size=" + this.size + ", styles=" + this.styles + ')';
    }

    public final Boolean getActionEnable() {
        return this.actionEnable;
    }

    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final String getSize() {
        return this.size;
    }

    public final Boolean getSquareShape() {
        return this.squareShape;
    }

    public final CheckBoxStyles getStyles() {
        return this.styles;
    }

    public CheckBoxProps(Boolean r100, Boolean r101, Boolean r102, String r103, CheckBoxStyles r104) {
        this.multiSelect = r100;
        this.actionEnable = r101;
        this.squareShape = r102;
        this.size = r103;
        this.styles = r104;
    }
}
