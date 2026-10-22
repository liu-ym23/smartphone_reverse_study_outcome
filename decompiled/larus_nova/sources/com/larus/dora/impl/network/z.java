package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/network/QuickNoteConfig;", "", "leftLongPressAction", "", "rightLongPressAction", "leftDoubleClickAction", "rightDoubleClickAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeftLongPressAction", "()Ljava/lang/String;", "getRightLongPressAction", "getLeftDoubleClickAction", "getRightDoubleClickAction", "isEmpty", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    @SerializedName("left_double_click")
    private final String leftDoubleClickAction;

    @SerializedName("left_long_press")
    private final String leftLongPressAction;

    @SerializedName("right_double_click")
    private final String rightDoubleClickAction;

    @SerializedName("right_long_press")
    private final String rightLongPressAction;

    public z() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.leftLongPressAction, r101.leftLongPressAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightLongPressAction, r101.rightLongPressAction) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftDoubleClickAction, r101.leftDoubleClickAction) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rightDoubleClickAction, r101.rightDoubleClickAction) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.leftLongPressAction;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rightLongPressAction;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.leftDoubleClickAction;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.rightDoubleClickAction;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "QuickNoteConfig(leftLongPressAction=" + this.leftLongPressAction + ", rightLongPressAction=" + this.rightLongPressAction + ", leftDoubleClickAction=" + this.leftDoubleClickAction + ", rightDoubleClickAction=" + this.rightDoubleClickAction + ')';
    }

    public final boolean f() {
        String r100 = this.leftLongPressAction;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L36;
        String r102 = this.rightLongPressAction;
        if (r102 != null) goto L13;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L37;
        String r104 = this.leftDoubleClickAction;
        if (r104 != null) goto L21;
    L24:
        boolean r105 = true;
    L25:
        if (r105 == false) goto L38;
        String r106 = this.rightDoubleClickAction;
        if (r106 != null) goto L29;
    L32:
        boolean r107 = true;
    L33:
        if (r107 == false) goto L39;
        return true;
    L39:
        return false;
    L29:
        if (r106.length() == 0) goto L32;
        r107 = false;
        goto L33
    L38:
        return false;
    L21:
        if (r104.length() == 0) goto L24;
        r105 = false;
        goto L25
    L37:
        return false;
    L13:
        if (r102.length() == 0) goto L16;
        r103 = false;
        goto L17
    L36:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String b() {
        return this.leftDoubleClickAction;
    }

    public final String c() {
        return this.leftLongPressAction;
    }

    public final String d() {
        return this.rightDoubleClickAction;
    }

    public final String e() {
        return this.rightLongPressAction;
    }

    public z(String r100, String r101, String r102, String r103) {
        this.leftLongPressAction = r100;
        this.rightLongPressAction = r101;
        this.leftDoubleClickAction = r102;
        this.rightDoubleClickAction = r103;
    }

    public static z a(z r100, String r101, String r102, String r103, String r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.leftLongPressAction;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.rightLongPressAction;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.leftDoubleClickAction;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.rightDoubleClickAction;
    L15:
        return new z(r101, r102, r103, r104);
    }
}
