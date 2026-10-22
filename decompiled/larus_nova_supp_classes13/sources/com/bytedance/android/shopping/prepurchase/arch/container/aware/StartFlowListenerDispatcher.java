package com.bytedance.android.shopping.prepurchase.arch.container.aware;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class StartFlowListenerDispatcher implements c {
    public int a;
    public final Map<Integer, a> b;
    public final List<c> c;

    public static final class a {
        public final Function1<c, Unit> a;
        public final boolean b;
        public final Stage c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            Function1<c, Unit> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r3 + r5) * 31;
            Stage r7 = this.c;
            if (r7 == null) goto L13;
            r1 = r7.hashCode();
        L13:
            return r6 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Holder(callback=" + this.a + ", isFinish=" + this.b + ", stage=" + this.c + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Unit> r2, boolean r3, Stage r4) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            Intrinsics.checkNotNullParameter(r4, "stage");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void a() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onPageCreateFinish$1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.b
    public final void b() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onPageCreateStart$1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onFirstScreen() {
        ECHybridExtensionsKt.f(new AnonymousClass1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.e
    public final void onRenderStart() {
        ECHybridExtensionsKt.f(new C03181(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void t() {
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQueryStart$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StartFlowListenerDispatcher(List<? extends c> r2) {
        Intrinsics.checkNotNullParameter(r2, "listeners");
        this.c = r2;
        this.b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void u(final k.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQueryFailed$1(this, r2));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.aware.a
    public final void v(final k.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        ECHybridExtensionsKt.f(new StartFlowListenerDispatcher$onQuerySuccess$1(this, r2));
    }

    public final void c(Stage r7, boolean r8, Function1<? super c, Unit> r9) {
        int r0 = (int) Math.ceil(((double) this.a) / 2.0d);
        int r1 = r7.getValue() * 2;
        boolean r2 = false;
        if (r8 == false) goto L5;
        int r3 = 0;
    L6:
        int r4 = r1 + r3;
        int r5 = this.a;
        if ((r5 % 2) != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r4 != r5) goto L13;
        return;
    L13:
        if (r0 != (r7.getValue() - 1)) goto L17;
        if (r6 == false) goto L17;
        if (r8 == true) goto L17;
    L24:
        r2 = true;
    L25:
        if (r2 == false) goto L33;
        Iterator<T> r10 = this.c.iterator();
    L28:
        if (r10.hasNext() == false) goto L30;
        r9.invoke((c) r10.next());
        goto L28
    L30:
        this.a = r4;
        a r11 = this.b.remove(Integer.valueOf(r4 + 1));
        if (r11 == null) goto L36;
        c(r11.c, r11.b, r11.a);
        return;
    L36:
        return;
    L33:
        this.b.put(Integer.valueOf(r4), new a(r9, r8, r7));
        return;
    L17:
        if (r0 != r7.getValue()) goto L21;
        if (r6 == true) goto L21;
        if (r8 == true) goto L24;
    L21:
        if (r0 != r7.getValue()) goto L25;
        if (r6 == false) goto L25;
        if (r8 == true) goto L25;
    L9:
        r6 = false;
        goto L10
    L5:
        r3 = -1;
        goto L6
    }
}
