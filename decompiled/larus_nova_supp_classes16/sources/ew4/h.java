package ew4;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public h() {
        this(null, 255);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return "CommonAddressComponent(country=" + this.a + ", province=" + this.b + ", city=" + this.c + ", district=" + this.d + ", township=" + this.e + ", neighborhood=" + this.f + ", building=" + this.g + ", address=" + this.h + ')';
    }

    public /* synthetic */ h(String r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r10 = "";
    L31:
        if ((r14 & Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE) == 0) goto L33;
        String r11 = "";
    L34:
        this(r4, r5, r6, r7, r8, r9, r10, r11);
        return;
    L33:
        r11 = r13;
        goto L34
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public h(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "country");
        Intrinsics.checkNotNullParameter(r3, "province");
        Intrinsics.checkNotNullParameter(r4, "city");
        Intrinsics.checkNotNullParameter(r5, "district");
        Intrinsics.checkNotNullParameter(r6, "township");
        Intrinsics.checkNotNullParameter(r7, "neighborhood");
        Intrinsics.checkNotNullParameter(r8, "building");
        Intrinsics.checkNotNullParameter(r9, "address");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
