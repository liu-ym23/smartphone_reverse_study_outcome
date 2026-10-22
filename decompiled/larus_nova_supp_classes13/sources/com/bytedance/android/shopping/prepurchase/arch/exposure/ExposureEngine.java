package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ExposureEngine {
    public Scheduler a;
    public final Map<String, e> b;
    public final Map<View, k> c;
    public final Map<String, k> d;
    public final b e;
    public final c f;
    public final com.bytedance.android.shopping.prepurchase.arch.exposure.a g;

    public static final class a {
    }

    public static final class b implements h {
        public final /* synthetic */ ExposureEngine a;

        public b(ExposureEngine r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
        public final com.bytedance.android.shopping.prepurchase.arch.exposure.c a(l r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Map<String, k> r0 = this.a.d;
            LinkedHashMap r1 = (LinkedHashMap) r0;
            k r2 = (k) r1.get(r3.a);
            if (r2 != null) goto L7;
            return null;
        L7:
            return r2.a(r3);
        }
    }

    public static final class c implements i {
        public final /* synthetic */ ExposureEngine a;

        public static final class a implements h {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
            public final com.bytedance.android.shopping.prepurchase.arch.exposure.c a(l r3) {
                Intrinsics.checkNotNullParameter(r3, "item");
                Map<String, k> r0 = this.a.a.d;
                LinkedHashMap r1 = (LinkedHashMap) r0;
                k r2 = (k) r1.get(r3.a);
                if (r2 != null) goto L7;
                return null;
            L7:
                return r2.a(r3);
            }
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.i
        public final void a() {
            f r0 = this.a.g.c;
            if (r0 == null) goto L5;
            r0.d("ExposureEngine", "forceReport once");
        L5:
            Iterator r1 = ((LinkedHashMap) this.a.d).values().iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            k r2 = (k) r1.next();
            if (r2.a.get() != null) goto L7;
            r2.b();
            goto L7
        L11:
            j r3 = new j(new a(this), this.a.g.c);
            Iterator r4 = ((LinkedHashMap) this.a.b).values().iterator();
        L13:
            if (r4.hasNext() == false) goto L15;
            e r5 = (e) r4.next();
            r5.getClass();
            Intrinsics.checkNotNullParameter(r3, "provider");
            r5.a(r3, true);
            goto L13
        L15:
            f r6 = this.a.g.c;
            if (r6 == null) goto L25;
            r6.d("ExposureEngine", "forceReport finish");
            return;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.i
        public final void b() {
            f r0 = this.a.g.c;
            if (r0 == null) goto L5;
            r0.d("ExposureEngine", "schedule once");
        L5:
            Iterator r1 = ((LinkedHashMap) this.a.d).values().iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            k r2 = (k) r1.next();
            if (r2.a.get() != null) goto L7;
            r2.b();
            goto L7
        L11:
            ExposureEngine r3 = this.a;
            j r4 = new j(r3.e, r3.g.c);
            Iterator r5 = ((LinkedHashMap) this.a.b).values().iterator();
        L13:
            if (r5.hasNext() == false) goto L15;
            ((e) r5.next()).a(r4, false);
            goto L13
        L15:
            f r6 = this.a.g.c;
            if (r6 == null) goto L25;
            r6.d("ExposureEngine", "schedule finish");
            return;
        }

        public c(ExposureEngine r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void b() {
        Scheduler r0 = this.a;
        if (r0 == null) goto L15;
        r0.e = true;
        CoroutineScope r2 = r0.a;
        if (r0.d == true) goto L7;
        return;
    L7:
        if (r0.c == false) goto L17;
        if (r2 == null) goto L18;
        Job r3 = r0.b;
        if (r3 != null) goto L12;
    L13:
        r0.b = BuildersKt.launch$default(r2, Dispatchers.getMain().getImmediate(), null, new Scheduler$startSchedule$1(r0, null), 2, null);
        return;
    L12:
        if (r3.isActive() != true) goto L13;
        return;
    L18:
        return;
    L17:
        return;
    }

    public ExposureEngine(com.bytedance.android.shopping.prepurchase.arch.exposure.a r2) {
        Intrinsics.checkNotNullParameter(r2, "configuration");
        this.g = r2;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new b(this);
        this.f = new c(this);
    }

    public final void c(final List<d> r2) {
        Intrinsics.checkNotNullParameter(r2, "candidates");
        ECHybridExtensionsKt.f(new ExposureEngine$updateTasks$1(this, r2));
    }

    public static void a(final ExposureEngine r7, final View r8, final String r9) {
        ExposureEngine$bindView$1 r0 = ExposureEngine$bindView$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r9, "viewId");
        Intrinsics.checkNotNullParameter(r0, "childViewFinder");
        k r3 = (k) ((LinkedHashMap) r7.c).get(r8);
        boolean r5 = false;
        if (Intrinsics.areEqual((k) ((LinkedHashMap) r7.d).get(r9), r3) == false) goto L14;
        if (r3 == null) goto L14;
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r9, "viewId");
        if (Intrinsics.areEqual(r9, r3.e) == true) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 != true) goto L14;
        r5 = true;
        goto L14
    L8:
        if (Intrinsics.areEqual(r3.a.get(), r8) == false) goto L10;
        r1 = true;
    L14:
        if (r5 == false) goto L18;
        f r10 = r7.g.c;
        if (r10 == null) goto L35;
        r10.d("ExposureEngine", "bindView but same: id = " + r9 + ", view = " + r8);
        return;
    L35:
        return;
    L18:
        f r4 = r7.g.c;
        if (r4 == null) goto L21;
        r4.d("ExposureEngine", "bindView: id = " + r9 + ", view = " + r8);
    L21:
        k r2 = new k(r8, r9, r0, r7.g.b);
        Function0<Unit> r6 = new ExposureEngine$bindView$$inlined$also$lambda$1(r7, r9, r8);
        Intrinsics.checkNotNullParameter(r6, "function");
        r2.c = r6;
        if (r3 == null) goto L26;
        k r11 = r7.d.remove(r3.e);
        if (r11 == null) goto L26;
        r11.b();
    L26:
        k r12 = (k) ((LinkedHashMap) r7.d).get(r9);
        if (r12 == null) goto L33;
        View r13 = r12.a.get();
        if (r13 == null) goto L33;
        k r14 = r7.c.remove(r13);
        if (r14 == null) goto L33;
        r14.b();
    L33:
        r7.d.put(r9, r2);
        r7.c.put(r8, r2);
    }
}
