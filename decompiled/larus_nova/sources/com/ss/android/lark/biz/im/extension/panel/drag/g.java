package com.ss.android.lark.biz.im.extension.panel.drag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f410542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f410543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f410544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f410545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f410546e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f410542a, r101.f410542a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410543b, r101.f410543b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f410542a.hashCode() * 31) + this.f410543b.hashCode();
    }

    public final String toString() {
        return "DragPanelConfig(panelStyle=" + this.f410542a + ", bgConfig=" + this.f410543b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(n r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, "panelStyle");
        Intrinsics.checkNotNullParameter(r101, "bgConfig");
        this.f410542a = r100;
        this.f410543b = r101;
        boolean r102 = r100 instanceof o;
        o r103 = null;
        if (r102 == false) goto L5;
        o r104 = (o) r100;
    L6:
        if (r104 == null) goto L9;
        a r105 = r104.f410557a;
        if (r105 == null) goto L9;
    L10:
        this.f410544c = r105;
        if (r102 == false) goto L13;
        r103 = (o) r100;
    L13:
        if (r103 == null) goto L15;
        float r106 = r103.f410560d;
    L16:
        this.f410545d = r106;
        this.f410546e = r100.f410556e;
        return;
    L15:
        r106 = r100.f410554c;
    L9:
        r105 = r100.f410552a;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
