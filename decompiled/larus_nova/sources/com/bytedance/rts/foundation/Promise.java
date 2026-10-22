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

/* JADX INFO: loaded from: classes10.dex */
public final class Promise<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f267559e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PromiseStates f267560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f267561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f267562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function3<PromiseStates, T, Object, Unit>> f267563d;

    public static final class a {
        public static Promise a(final ArrayList r100) {
            Intrinsics.checkNotNullParameter(r100, "values");
            Intrinsics.checkNotNullParameter(r100, "values");
            final Ref.ObjectRef r101 = new Ref.ObjectRef();
            final ArrayList r102 = new ArrayList(j.d(r100));
            int r103 = j.d(r100);
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            r102.add(null);
            r104 = r104 + 1;
            goto L3
        L5:
            final Ref.IntRef r105 = new Ref.IntRef();
            r105.element = j.d(r100);
            return new Promise(new Promise$Companion$rts_all$2(r100, r102, r105, r101));
        }
    }

    static {
    }

    public final void b() {
        if (this.f267560a != PromiseStates.PENDING) goto L5;
        return;
    L5:
        n r100 = t.f267593a.get();
        if (r100 == null) goto L9;
        Function0<Unit> r101 = new Promise$runThenCallbacks$1(this);
        Intrinsics.checkNotNullParameter(r101, "action");
        s r102 = new s(r101, r100);
        ((LinkedList) r100.f267584c).add(r102);
        r100.f267583b.postAtFrontOfQueue(new o(r102));
        return;
    }

    public Promise(Function2<? super Function1<? super T, Unit>, ? super Function1<Object, Unit>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "executor");
        this.f267560a = PromiseStates.PENDING;
        this.f267561b = null;
        this.f267562c = null;
        this.f267563d = new ArrayList();
        r100.invoke(new AnonymousClass1(this), new AnonymousClass2(this));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (this.f267560a != PromiseStates.PENDING) goto L14;
        Intrinsics.checkNotNull(th);
        this.f267562c = th;
        this.f267560a = PromiseStates.REJECTED;
        b();
        return;
    }

    public final void a(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "onrejected");
        Intrinsics.checkNotNullParameter(r100, "onrejected");
        final Function1 r101 = null;
        new Promise(new Promise$catchInside$1(this, r100, r101));
    }

    public final <R> Promise<R> c(final Function1<? super T, ? extends R> r100, final Function1<Object, ? extends R> r110) {
        Intrinsics.checkNotNullParameter(r100, "onfulfilled");
        Intrinsics.checkNotNullParameter(r100, "onfulfilled");
        final Function1 r101 = null;
        final Function1 r102 = null;
        return new Promise(new Promise$thenInside$1(this, r100, r101, r110, r102));
    }
}
