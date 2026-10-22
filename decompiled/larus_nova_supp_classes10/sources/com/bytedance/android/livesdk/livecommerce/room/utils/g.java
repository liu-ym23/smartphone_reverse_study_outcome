package com.bytedance.android.livesdk.livecommerce.room.utils;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import si2.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public static final /* synthetic */ int c = 0;
    public final List<Runnable> a;
    public final Map<String, Runnable> b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;

        @Override // java.lang.Runnable
        public final void run() {
            this.b.invoke();     // Catch: Throwable -> L7
            if (this.c == false) goto L5;
            this.a.b.remove(this.d);     // Catch: Throwable -> L7
        L5:
            ((ArrayList) this.a.a).remove(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(g r1, Function0 r2, boolean r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void a() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Runnable r1 = (Runnable) r0.next();
        UtilityKotlinExtentionsKt.b.removeCallbacks(r1);
        goto L4
    L6:
        ((ArrayList) this.a).clear();
        ((LinkedHashMap) this.b).clear();
    }

    public g() {
        this.a = new ArrayList();
        this.b = new LinkedHashMap();
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Runnable r0 = (Runnable) ((LinkedHashMap) this.b).get(r3);
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
        this.b.remove(r3);
        ((ArrayList) this.a).remove(r0);
        return;
    }

    public static long b(long r4, long r6) {
        if (r6 != 0) goto L5;
    L13:
        return 0;
    L5:
        if (r6 < r4) goto L13;
        if (r6 < 0) goto L13;
        if (r4 < 0) goto L13;
        return (long) (r4 + ((r6 - r4) * Math.random()));
    }

    public final void c(String r10, int r11, boolean r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r13, "action");
        n r0 = EComABUtils.getScatterTimeSetting();
        if (r11 != 1) goto L5;
        int r1 = r0.b();
        int r2 = r0.a();
    L6:
        long r7 = 1000;
        e(r10, b(((long) r1) * r7, ((long) r2) * r7), r12, r13);
        return;
    L5:
        r1 = r0.d();
        r2 = r0.c();
        goto L6
    }

    public final void d(String r7, long r8, long r10, Function0 r12) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r12, "action");
        e(r7, b(r8, r10), true, r12);
    }

    public final void e(String r3, long r4, boolean r6, Function0<Unit> r7) {
        if (r6 == false) goto L6;
        Runnable r0 = (Runnable) ((LinkedHashMap) this.b).get(r3);
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
        this.b.remove(r3);
        ((ArrayList) this.a).remove(r0);
    L6:
        b r1 = new b(this, r7, r6, r3);
        ((ArrayList) this.a).add(r1);
        if (r6 == false) goto L9;
        this.b.put(r3, r1);
    L9:
        UtilityKotlinExtentionsKt.b.postDelayed(r1, r4);
    }
}
