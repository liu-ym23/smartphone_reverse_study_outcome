package ew4;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f474569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j0 f474572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f474573e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f474569a, r101.f474569a) == true) goto L12;
        return false;
    L12:
        if (this.f474570b == r101.f474570b) goto L15;
        return false;
    L15:
        if (this.f474571c == r101.f474571c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474572d, r101.f474572d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474573e, r101.f474573e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f474569a.hashCode() * 31) + this.f474570b) * 31) + this.f474571c) * 31;
        j0 r101 = this.f474572d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Runnable r105 = this.f474573e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SheetSelectImageRequest(args=" + this.f474569a + ", height=" + this.f474570b + ", panelHeight=" + this.f474571c + ", heightChangeListener=" + this.f474572d + ", onSelectImagePanelCloseCallback=" + this.f474573e + ')';
    }

    public k0(Bundle r100, int r101, int r102, j0 r103, com.bytedance.ee.bear.sheet.panel.oppanel.r r104) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.f474569a = r100;
        this.f474570b = r101;
        this.f474571c = r102;
        this.f474572d = r103;
        this.f474573e = r104;
    }
}
