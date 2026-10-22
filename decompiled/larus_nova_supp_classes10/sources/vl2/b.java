package vl2;

import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends vl2.a {
    public static final String j = null;
    public static final String k = null;
    public static String l;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public static final class a {
    }

    static {
        SparseArray<c.a> r0 = c.a;
        c.a r1 = null;
        if (r0 == null) goto L5;
        c.a r2 = r0.get(5);
    L6:
        String r3 = r2.a;
        j = r3;
        if (r0 == null) goto L9;
        r1 = r0.get(6);
    L9:
        k = r1.a;
        l = File.separator + r3;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public b(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "root");
        super(r7, l);
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        StringBuilder r0 = new StringBuilder();
        r0.append(File.separator);
        if (r8 != 6) goto L5;
        String r9 = k;
    L6:
        r0.append(r9);
        l = r0.toString();
        this.a = r7 + l + ".zip";
        String r10 = r7 + l + "/coupon";
        String r1 = r7 + l + "/couponhide";
        this.d = r1;
        String r2 = r7 + l + "/happy";
        this.e = r2;
        String r3 = r7 + l + "/ttlive_bottom_front_coupon_view.png";
        this.f = r3;
        String r4 = r7 + l + "/ttlive_bottom_behind_coupon_view.png";
        this.g = r4;
        this.h = r7 + l + "/ttlive_yellow_double_coupon_view.png";
        String r11 = r7 + l + "/ttlive_yellow_coupon_bg.png";
        this.i = r11;
        ((ArrayList) this.c).add(r3);
        ((ArrayList) this.c).add(r4);
        ((ArrayList) this.c).add(r11);
        ((ArrayList) this.c).add(r10);
        ((ArrayList) this.c).add(r1);
        ((ArrayList) this.c).add(r2);
        return;
    L5:
        r9 = j;
        goto L6
    }
}
