package com.bytedance.applet.aibridge.health;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nv3.c;
import nv3.e;
import nv3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a a = null;
    public static final Handler b = null;
    public static C0050a c;
    public static h d;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.health.a$a, reason: collision with other inner class name */
    public static final class C0050a {
        public final String a;
        public final Function1<String, Unit> b;
        public final Function2<f3.a, String, Unit> c;
        public final long d;

        public C0050a(String r2, e r3, c r4) {
            Intrinsics.checkNotNullParameter(r2, "operationId");
            Intrinsics.checkNotNullParameter(r3, "onSuccess");
            Intrinsics.checkNotNullParameter(r4, "onFailure");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = SystemClock.elapsedRealtime();
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new Handler(Looper.getMainLooper());
    }

    public static C0050a c(String r3) {
        C0050a r0 = c;
        if (r0 != null) goto L5;
    L15:
        return null;
    L5:
        if (Intrinsics.areEqual(r0.a, r3) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L15;
        c = null;
        h r4 = d;
        if (r4 == null) goto L13;
        b.removeCallbacks(r4);
    L13:
        d = null;
        return r0;
    }

    public static void a(String r1, String r2) {
        C0050a r3 = c(r1);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        r3.c.invoke(f3.a.m, "Honor health authorization returned no code");
        return;
    L13:
        r3.b.invoke(r2);
        return;
    L7:
        if (StringsKt.isBlank(r2) == true) goto L10;
        r0 = false;
        goto L11
    }

    public static void b(String r0, f3.a r1, String r2) {
        C0050a r3 = c(r0);
        if (r3 == null) goto L8;
        Function2<f3.a, String, Unit> r4 = r3.c;
        if (r4 == null) goto L9;
        r4.invoke(r1, r2);
        return;
    L9:
        return;
    }
}
