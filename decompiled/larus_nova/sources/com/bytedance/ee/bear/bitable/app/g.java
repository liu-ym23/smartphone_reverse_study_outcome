package com.bytedance.ee.bear.bitable.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f206930h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f206931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f206932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f206933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f206934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f206935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f206936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f206937g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f206931a, r101.f206931a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206932b, r101.f206932b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f206933c, r101.f206933c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f206934d, r101.f206934d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f206935e, r101.f206935e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f206936f, r101.f206936f) == true) goto L27;
        return false;
    L27:
        if (this.f206937g == r101.f206937g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f206931a.hashCode() * 31;
        ViewGroup r101 = this.f206932b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        FrameLayout r105 = this.f206933c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        View r108 = this.f206934d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        View r111 = this.f206935e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        View r114 = this.f206936f;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (r113 + r102) * 31;
        if (this.f206937g == false) goto L25;
        int r116 = 1231;
    L27:
        return r115 + r116;
    L25:
        r116 = 1237;
        goto L27
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BitableAppDrawerViewPort(layoutView=" + this.f206931a + ", overlayContainer=" + this.f206932b + ", drawerContainer=" + this.f206933c + ", contentContainer=" + this.f206934d + ", contentInnerContainer=" + this.f206935e + ", appBar=" + this.f206936f + ", manageContentTopPadding=" + this.f206937g + ')';
    }

    public g(View r100, ViewGroup r101, FrameLayout r102, View r103, View r104, View r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "layoutView");
        this.f206931a = r100;
        this.f206932b = r101;
        this.f206933c = r102;
        this.f206934d = r103;
        this.f206935e = r104;
        this.f206936f = r105;
        this.f206937g = r106;
    }
}
