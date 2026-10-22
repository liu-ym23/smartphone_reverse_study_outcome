package com.bytedance.ee.bear.office.list;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.space.OfficeSpaceFragment;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final ConcurrentHashMap<a, WeakReference<p>> a = null;
    public static final ConcurrentHashMap<String, OfficeSpaceTab> b = null;
    public static final ConcurrentHashMap<String, OfficeSpaceTab> c = null;
    public static final ConcurrentHashMap<String, Boolean> d = null;
    public static final ConcurrentHashMap<String, Function1<OfficeSpaceTab, Boolean>> e = null;
    public static final ConcurrentHashMap<String, Function1<OfficeSpaceTab, Boolean>> f = null;
    public static final ConcurrentHashMap<a, CopyOnWriteArrayList<Function0<Unit>>> g = null;
    public static final ConcurrentHashMap<String, Function2<Boolean, Integer, Unit>> h = null;

    public static final class a {
        public final String a;
        public final OfficeSpaceTab b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Key(runtimeId=" + this.a + ", tab=" + this.b + ')';
        }

        public a(String r2, OfficeSpaceTab r3) {
            Intrinsics.checkNotNullParameter(r2, "runtimeId");
            Intrinsics.checkNotNullParameter(r3, "tab");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
    }

    public static void a(String r3) {
        String r4 = g(r3);
        Iterator<Map.Entry<a, WeakReference<p>>> r0 = a.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<a, WeakReference<p>> r1 = r0.next();
        a r2 = r1.getKey();
        WeakReference<p> r5 = r1.getValue();
        if (Intrinsics.areEqual(r2.a, r4) == false) goto L4;
        p r6 = r5.get();
        if (r6 == null) goto L4;
        r6.Su();
        goto L4
    }

    public static String d(View r2) {
        return "attached=" + r2.isAttachedToWindow() + ",size=" + r2.getWidth() + 'x' + r2.getHeight() + ",shown=" + r2.isShown() + ",windowFocus=" + r2.hasWindowFocus();
    }

    public static void f(String r5) {
        String r6 = g(r5);
        OfficeSpaceTab r0 = OfficeSpaceTab.RECENT;
        p r1 = c(r6, r0);
        if ((r1 instanceof OfficeListHostFragment) == false) goto L16;
        tt5.a.h("OfficeListHostRegistry", "mark recent refresh after create, runtime=" + l(r6));
        OfficeListHostFragment r2 = (OfficeListHostFragment) r1;
        r2.m = true;
        tt5.a.h("OfficeListHostFragment", "mark RECENT refresh after office document created");
        if (r2.isResumed() == true) goto L7;
        return;
    L7:
        if (r2.o == true) goto L9;
        return;
    L9:
        if (r2.W90() == r0) goto L11;
        return;
    L11:
        if (r2.m == false) goto L23;
        View r7 = r2.getView();
        if (r7 == null) goto L21;
        r7.post(new g(r2, "lateCreateResultAfterResume"));
        return;
    L21:
        return;
    L23:
        return;
    L16:
        tt5.a.h("OfficeListHostRegistry", "cache pending recent refresh after create, runtime=" + l(r6));
        d.put(r6, Boolean.TRUE);
    }

    public static String g(String r1) {
        if (r1 != null) goto L4;
    L8:
        return "__office_default_runtime__";
    L4:
        if ((!StringsKt.isBlank(r1)) == true) goto L7;
        r1 = null;
    L7:
        if (r1 == null) goto L8;
        return r1;
    }

    public static String l(String r2) {
        if (Intrinsics.areEqual(r2, "__office_default_runtime__") == false) goto L6;
        return "default";
    L6:
        return "hash=" + r2.hashCode();
    }

    public static void b(String r6, OfficeSpaceTab r7) {
        CopyOnWriteArrayList<Function0<Unit>> r0 = g.remove(new a(r6, r7));
        if (r0 != null) goto L6;
        r0 = CollectionsKt.emptyList();
    L6:
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        tt5.a.h("OfficeListHostRegistry", "consume tab host ready callbacks, runtime=" + l(r6) + ", tab=" + r7 + ", count=" + r0.size());
        Iterator r1 = r0.iterator();
    L10:
        if (r1.hasNext() == false) goto L19;
        Function0 r2 = (Function0) r1.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        r2.invoke();     // Catch: Throwable -> L14
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L10;
        tt5.a.l("OfficeListHostRegistry", "tab host ready callback failed, runtime=" + l(r6) + ", tab=" + r7, r5);
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static p c(String r1, OfficeSpaceTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        a r0 = new a(g(r1), r2);
        ConcurrentHashMap<a, WeakReference<p>> r3 = a;
        WeakReference<p> r4 = r3.get(r0);
        if (r4 == null) goto L5;
        p r5 = r4.get();
    L6:
        if (r5 != null) goto L8;
        r3.remove(r0);
    L8:
        return r5;
    L5:
        r5 = null;
        goto L6
    }

    public static boolean e(String r1, OfficeSpaceTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        if (c(r1, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void h(String r5, OfficeSpaceTab r6) {
        Intrinsics.checkNotNullParameter(r6, "tab");
        String r7 = g(r5);
        ConcurrentHashMap<String, OfficeSpaceTab> r0 = c;
        OfficeSpaceTab r1 = r0.get(r7);
        if (r1 == null) goto L12;
        if (r1 == r6) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        tt5.a.h("OfficeListHostRegistry", "drop stale pending tab reselected, runtime=" + l(r7) + ", staleTab=" + r1 + ", currentTab=" + r6);
        r0.remove(r7, r1);
        goto L12
    L6:
        r3 = false;
    L12:
        p r2 = c(r7, r6);
        if ((r2 instanceof OfficeListHostFragment) == false) goto L15;
        tt5.a.b("OfficeListHostRegistry", "dispatch page selected to host, runtime=" + l(r7) + ", tab=" + r6);
        ((OfficeListHostFragment) r2).gM();
        return;
    L15:
        tt5.a.h("OfficeListHostRegistry", "cache pending page selected, runtime=" + l(r7) + ", tab=" + r6);
        b.put(r7, r6);
    }

    public static boolean j(String r5, OfficeSpaceTab r6) {
        Intrinsics.checkNotNullParameter(r6, "tab");
        String r7 = g(r5);
        p r0 = c(r7, r6);
        if ((r0 instanceof OfficeListHostFragment) == false) goto L5;
        tt5.a.h("OfficeListHostRegistry", "refresh tab after create, runtime=" + l(r7) + ", tab=" + r6);
        OfficeListHostFragment r1 = (OfficeListHostFragment) r0;
        r1.getClass();
        tt5.a.h("OfficeListHostFragment", "refresh current list after office create, tab=" + r1.W90());
        return r1.Y90();
    L5:
        tt5.a.h("OfficeListHostRegistry", "cache pending tab refresh after create, runtime=" + l(r7) + ", tab=" + r6);
        c.put(r7, r6);
        return false;
    }

    public static void i(String r1, boolean r2, int r3) {
        Function2<Boolean, Integer, Unit> r4 = h.get(g(r1));
        if (r4 == null) goto L6;
        r4.invoke(Boolean.valueOf(r2), Integer.valueOf(r3));
        return;
    }

    public static void m(String r3, OfficeSpaceTab r4, p r5) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r5, "host");
        a r0 = new a(g(r3), r4);
        ConcurrentHashMap<a, WeakReference<p>> r6 = a;
        WeakReference<p> r1 = r6.get(r0);
        if (r1 == null) goto L5;
        p r2 = r1.get();
    L6:
        if (r2 == null) goto L8;
        if (r2 == r5) goto L8;
        return;
    L8:
        StringBuilder r7 = new StringBuilder("unregister host, runtime=");
        r7.append(l(r0.a));
        r7.append(", tab=");
        r7.append(r4);
        r7.append(", cachedExists=");
        if (r2 == null) goto L11;
        boolean r8 = true;
    L12:
        r7.append(r8);
        tt5.a.h("OfficeListHostRegistry", r7.toString());
        if (r2 == null) goto L15;
        r2.Su();
    L15:
        r6.remove(r0);
        return;
    L11:
        r8 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static boolean k(String r7, OfficeSpaceTab r8, View r9, OfficeSpaceFragment.c r10) {
        Intrinsics.checkNotNullParameter(r8, "tab");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        Intrinsics.checkNotNullParameter(r10, "dispatcher");
        String r11 = g(r7);
        p r0 = c(r11, r8);
        if (r0 == null) goto L5;
        tt5.a.h("OfficeListHostRegistry", "dispatch header more menu to host, runtime=" + l(r11) + ", tab=" + r8 + ", host=" + r0.getClass().getSimpleName() + ", anchor=" + d(r9));
        boolean r12 = r0.y50(r9, r10);
        tt5.a.h("OfficeListHostRegistry", "dispatch header more menu result, runtime=" + l(r11) + ", tab=" + r8 + ", host=" + r0.getClass().getSimpleName() + ", shown=" + r12);
        return r12;
    L5:
        tt5.a.h("OfficeListHostRegistry", "skip header more menu dispatch, host missing, runtime=" + l(r11) + ", tab=" + r8 + ", anchor=" + d(r9));
        return false;
    }
}
