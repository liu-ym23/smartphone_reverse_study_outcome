package com.bytedance.android.shopping.prepurchase.arch.exposure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public long a;
    public final d b;
    public final f c;

    public static final class a {
    }

    static {
    }

    public final void update(d r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        if ((!Intrinsics.areEqual(r4.a, this.b.a)) == false) goto L5;
        return;
    L5:
        d r0 = this.b;
        List<l> r1 = r4.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.c = r1;
        d r2 = this.b;
        g r3 = r4.d;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.d = r3;
        this.b.b = r4.b;
    }

    public e(d r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.b = r2;
        this.c = r3;
    }

    public final void a(h r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "provider");
        long r0 = System.currentTimeMillis();
        boolean r3 = false;
        if (r12 == true) goto L29;
        List<l> r13 = this.b.c;
        if ((r13 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L29;
        l r4 = (l) r14.next();
        c r5 = r11.a(r4);
        if (r5 == null) goto L22;
        int r7 = r5.a;
        if (r7 <= 0) goto L22;
        if (((r5.b * 1.0f) / r7) < this.b.b) goto L22;
        boolean r6 = true;
    L23:
        f r8 = this.c;
        if (r8 == null) goto L26;
        r8.d("ExposureTask", "schedule#" + r4.a + '_' + r4.b + " shown: " + r6);
    L26:
        if (r6 == false) goto L12;
        r3 = true;
    L22:
        r6 = false;
        goto L23
    L8:
        if (r13.isEmpty() == false) goto L10;
    L29:
        if (r3 == true) goto L31;
    L35:
        if (r3 == false) goto L37;
        return;
    L37:
        if (this.a <= 0) goto L52;
        long r1 = System.currentTimeMillis() - this.a;
        this.a = 0;
        f r9 = this.c;
        if (r9 == null) goto L42;
        r9.i("ExposureTask", "report: " + this.b.a + ", " + r1 + "ms");
    L42:
        if (r1 <= 0) goto L53;
        this.b.d.a(r1);
        return;
    L53:
        return;
    L52:
        return;
    L31:
        if (this.a > 0) goto L35;
        this.a = r0;
        f r2 = this.c;
        if (r2 == null) goto L35;
        r2.i("ExposureTask", "taskId: " + this.b.a + ", isShown: " + r3 + ", ts:" + this.a);
        goto L35
    }
}
