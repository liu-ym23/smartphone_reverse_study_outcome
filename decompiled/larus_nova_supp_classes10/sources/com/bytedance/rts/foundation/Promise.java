package com.bytedance.rts.foundation;

import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class Promise<T> {
    public static final /* synthetic */ int e = 0;
    public PromiseStates a;
    public T b;
    public Object c;
    public final ArrayList<Function3<PromiseStates, T, Object, Unit>> d;

    public static final class a {
        public static Promise a(final ArrayList r5) {
            Intrinsics.checkNotNullParameter(r5, "values");
            Intrinsics.checkNotNullParameter(r5, "values");
            final Ref.ObjectRef r0 = new Ref.ObjectRef();
            final ArrayList r1 = new ArrayList(j.d(r5));
            int r2 = j.d(r5);
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L5;
            r1.add(null);
            r3 = r3 + 1;
            goto L3
        L5:
            final Ref.IntRef r4 = new Ref.IntRef();
            r4.element = j.d(r5);
            return new Promise(new Promise$Companion$rts_all$2(r5, r1, r4, r0));
        }
    }

    static {
    }

    public final void b() {
        if (this.a != PromiseStates.PENDING) goto L5;
        return;
    L5:
        n r0 = t.a.get();
        if (r0 == null) goto L9;
        Function0<Unit> r1 = new Promise$runThenCallbacks$1(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        s r2 = new s(r1, r0);
        ((LinkedList) r0.c).add(r2);
        r0.b.postAtFrontOfQueue(new o(r2));
        return;
    }

    public Promise(Function2<? super Function1<? super T, Unit>, ? super Function1<Object, Unit>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "executor");
        this.a = PromiseStates.PENDING;
        this.b = null;
        this.c = null;
        this.d = new ArrayList();
        r3.invoke(new AnonymousClass1(this), new AnonymousClass2(this));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (this.a != PromiseStates.PENDING) goto L14;
        Intrinsics.checkNotNull(th);
        this.c = th;
        this.a = PromiseStates.REJECTED;
        b();
        return;
    }

    public final void a(final Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "onrejected");
        Intrinsics.checkNotNullParameter(r4, "onrejected");
        final Function1 r2 = null;
        new Promise(new Promise$catchInside$1(this, r4, r2));
    }

    public final <R> Promise<R> c(final Function1<? super T, ? extends R> r9, final Function1<Object, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r9, "onfulfilled");
        Intrinsics.checkNotNullParameter(r9, "onfulfilled");
        final Function1 r4 = null;
        final Function1 r6 = null;
        return new Promise(new Promise$thenInside$1(this, r9, r4, r10, r6));
    }
}
