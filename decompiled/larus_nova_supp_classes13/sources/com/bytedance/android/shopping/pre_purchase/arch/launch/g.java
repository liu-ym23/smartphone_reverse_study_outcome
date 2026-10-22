package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.shopping.pre_purchase.arch.launch.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class g<I extends j, O extends j> implements i<I> {
    public static final /* synthetic */ int e = 0;
    public final CopyOnWriteArrayList<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> a;
    public h b;
    public Function1<? super I, ? extends Map<String, String>> c;
    public g<?, ?> d;

    public static final class a {
        public static void a(e r1, g r2, j r3) {
            Intrinsics.checkNotNullParameter(r1, "launchContext");
            Intrinsics.checkNotNullParameter(r3, "input");
            if (r2 != null) goto L5;
            return;
        L5:
            r2.a(r1, r3);
        }
    }

    static {
    }

    public g() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void b(com.bytedance.android.shopping.pre_purchase.arch.launch.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a.add(r2);
    }

    public final void c(e r5, I r6) {
        Intrinsics.checkNotNullParameter(r5, "launchContext");
        Intrinsics.checkNotNullParameter(r6, "input");
        Function1<? super I, ? extends Map<String, String>> r0 = this.c;
        if (r0 == null) goto L5;
        Map<String, String> r1 = (Map) r0.invoke(r6);
    L6:
        h r2 = this.b;
        if (r2 == null) goto L9;
        r2.e(getName(), r1);
    L9:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r3 = this.a.iterator();
    L11:
        if (r3.hasNext() == false) goto L18;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r4 = r3.next();
        List<String> r7 = r5.d;
        if (r7 == null) goto L17;
        if (r7.contains(r4.getName().getValue()) == true) goto L11;
    L17:
        r4.b(r5, r6);
        goto L11
    L18:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void d(e r7, f<? extends O> r8) {
        Intrinsics.checkNotNullParameter(r7, "launchContext");
        Intrinsics.checkNotNullParameter(r8, "result");
        if ((r8 instanceof f.b) == false) goto L18;
        f.b r9 = (f.b) r8;
        T r0 = r9.a;
        h r2 = this.b;
        if (r2 == null) goto L7;
        r2.d();
    L7:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r3 = this.a.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r4 = r3.next();
        List<String> r5 = r7.d;
        if (r5 == null) goto L15;
        if (r5.contains(r4.getName().getValue()) == true) goto L9;
    L15:
        r4.a(r7, r0);
        goto L9
    L16:
        a.a(r7, this.d, r9.a);
        return;
    L18:
        if ((r8 instanceof f.a) == false) goto L44;
        Throwable r10 = ((f.a) r8).a;
        h r1 = this.b;
        if (r1 == null) goto L22;
        r1.h(r10);
    L22:
        Iterator<com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O>> r11 = this.a.iterator();
    L24:
        if (r11.hasNext() == false) goto L45;
        com.bytedance.android.shopping.pre_purchase.arch.launch.a<I, O> r6 = r11.next();
        List<String> r12 = r7.d;
        if (r12 == null) goto L30;
        if (r12.contains(r6.getName().getValue()) == true) goto L24;
    L30:
        r6.c(r7);
        goto L24
    L45:
        return;
    }
}
