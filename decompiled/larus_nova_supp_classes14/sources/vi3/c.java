package vi3;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final c f = null;
    public static final int g = 0;
    public int a;
    public int b;
    public final int c;
    public final int d;
    public final Rect e;

    public static final class a {
    }

    public final String toString() {
        return "ShopContainerConfig(width=" + this.c + ", height=" + this.d + ", margins=" + this.e + ")";
    }

    static {
        f = new c(-1, -2, new Rect());
        g = -1;
    }

    public final int a() {
        int r0 = this.d;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return this.a;
    }

    public final int hashCode() {
        return (((((((this.c * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.a) * 31) + this.b;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L30;
        c r6 = (c) r5;
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.e, r6.e)) == false) goto L23;
        return false;
    L23:
        if (this.a == r6.a) goto L26;
        return false;
    L26:
        if (this.b == r6.b) goto L28;
        return false;
    L28:
        return true;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.home.frame.container.ShopContainerConfig");
    L8:
        r2 = null;
        goto L10
    }

    public /* synthetic */ c(int r2, int r3) {
        this(r2, r3, new Rect());
    }

    public c(int r2, int r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r4, "margins");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        int r5 = g;
        this.a = r5;
        this.b = r5;
    }
}
