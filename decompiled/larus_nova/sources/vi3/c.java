package vi3;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f555303f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f555304g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f555305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f555306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f555307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f555308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f555309e;

    public static final class a {
    }

    public final String toString() {
        return "ShopContainerConfig(width=" + this.f555307c + ", height=" + this.f555308d + ", margins=" + this.f555309e + ")";
    }

    static {
        f555303f = new c(-1, -2, new Rect());
        f555304g = -1;
    }

    public final int a() {
        int r100 = this.f555308d;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return this.f555305a;
    }

    public final int hashCode() {
        return (((((((this.f555307c * 31) + this.f555308d) * 31) + this.f555309e.hashCode()) * 31) + this.f555305a) * 31) + this.f555306b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L30;
        c r102 = (c) r100;
        if (this.f555307c == r102.f555307c) goto L17;
        return false;
    L17:
        if (this.f555308d == r102.f555308d) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f555309e, r102.f555309e)) == false) goto L23;
        return false;
    L23:
        if (this.f555305a == r102.f555305a) goto L26;
        return false;
    L26:
        if (this.f555306b == r102.f555306b) goto L28;
        return false;
    L28:
        return true;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.home.frame.container.ShopContainerConfig");
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ c(int r100, int r101) {
        this(r100, r101, new Rect());
    }

    public c(int r100, int r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r102, "margins");
        this.f555307c = r100;
        this.f555308d = r101;
        this.f555309e = r102;
        int r103 = f555304g;
        this.f555305a = r103;
        this.f555306b = r103;
    }
}
