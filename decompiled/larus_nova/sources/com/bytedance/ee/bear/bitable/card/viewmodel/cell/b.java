package com.bytedance.ee.bear.bitable.card.viewmodel.cell;

import com.bytedance.ee.bear.bitable.card.model.stmodel.field.ButtonColor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f209011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f209013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f209014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f209015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f209016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ButtonColor f209017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f209018h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f209011a, r101.f209011a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f209012b, r101.f209012b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f209013c, r101.f209013c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f209014d, r101.f209014d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f209015e, r101.f209015e) == true) goto L24;
        return false;
    L24:
        if (this.f209016f == r101.f209016f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f209017g, r101.f209017g) == true) goto L30;
        return false;
    L30:
        if (this.f209018h == r101.f209018h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f209011a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f209012b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f209013c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f209014d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f209015e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.f209016f == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        ButtonColor r119 = this.f209017g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        int r120 = (r118 + r101) * 31;
        if (this.f209018h == true) goto L35;
        r116 = 1237;
    L35:
        return r120 + r116;
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public final String toString() {
        return "CellInfo(title=" + this.f209011a + ", baseId=" + this.f209012b + ", tableId=" + this.f209013c + ", recordId=" + this.f209014d + ", fieldId=" + this.f209015e + ", triggerAble=" + this.f209016f + ", color=" + this.f209017g + ", isBindTrigger=" + this.f209018h + ')';
    }

    public final String a() {
        return this.f209013c + '_' + this.f209014d + '_' + this.f209015e;
    }

    public b(String r100, String r101, String r102, String r103, String r104, boolean r105, ButtonColor r106, boolean r107) {
        this.f209011a = r100;
        this.f209012b = r101;
        this.f209013c = r102;
        this.f209014d = r103;
        this.f209015e = r104;
        this.f209016f = r105;
        this.f209017g = r106;
        this.f209018h = r107;
    }
}
