package com.bytedance.lark.view_flow_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.lark.view_flow_wrapper.internal.MutableStateFlowInternal;
import java.lang.AutoCloseable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes20.dex */
public abstract class MoltenFlowBase<VF extends AutoCloseable> implements AutoCloseable, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f254392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a, d1<Object>> f254393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<a, u> f254394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final buc.a f254395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f254396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SuspendLazyImpl f254397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f254398g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f254399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KClass<? extends u> f254400b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f254399a, r101.f254399a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f254400b, r101.f254400b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Object r100 = this.f254399a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f254400b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "SubscriptionCacheKey(key=" + this.f254399a + ", kind=" + this.f254400b + ')';
        }

        public a(Object r100, KClass<? extends u> r101) {
            Intrinsics.checkNotNullParameter(r101, "kind");
            this.f254399a = r100;
            this.f254400b = r101;
        }
    }

    public abstract Object b(Continuation<? super VF> r100);

    public void c() {
        Object r100 = null;
        CoroutineScopeKt.cancel$default((CoroutineScope) this.f254396e.getValue(), null, 1, null);
        Object r101 = this.f254397f.f254406b.c();
        if (r101 == w.f254470a) goto L7;
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        AutoCloseable r102 = (AutoCloseable) r100;
        if (r102 == null) goto L10;
        r102.close();
    L10:
        y r103 = ViewFlowPlugin.f254409a;
        if (r103 == null) goto L14;
        r103.a(new a0((String) this.f254398g.getValue()));
        return;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f254395d.a(false, true) == true) goto L5;
        return;
    L5:
        c();
    }

    public MoltenFlowBase(v r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f254392a = r100;
        this.f254393b = new LinkedHashMap();
        this.f254394c = new LinkedHashMap();
        this.f254395d = buc.b.a(false);
        this.f254396e = LazyKt.lazy(MoltenFlowBase$coroutineScope$2.INSTANCE);
        MoltenFlowBase$viewFlowLazy$1 r101 = new MoltenFlowBase$viewFlowLazy$1(this, null);
        Intrinsics.checkNotNullParameter(r101, "initializer");
        this.f254397f = new SuspendLazyImpl(r101);
        this.f254398g = LazyKt.lazy(new MoltenFlowBase$identity$2(this));
    }

    public static final String a(MoltenFlowBase r100) {
        return (String) r100.f254398g.getValue();
    }

    public final <R> Object f(Function2<? super VF, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super Result<? extends R>> r101) {
        if ((r101 instanceof MoltenFlowBase$withViewFlow$1) == false) goto L7;
        MoltenFlowBase$withViewFlow$1 r102 = (MoltenFlowBase$withViewFlow$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        JobKt.ensureActive(r102.getContext());
        x r109 = new x((String) this.f254398g.getValue(), r108);
        y r110 = ViewFlowPlugin.f254409a;
        if (r110 == null) goto L28;
        r110.a(r109);
    L28:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L21
        SuspendLazyImpl r112 = this.f254397f;     // Catch: Throwable -> L21
        MoltenFlowBase$withViewFlow$2$1 r113 = new MoltenFlowBase$withViewFlow$2$1(r100, null);     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = r112.a(r113, r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new MoltenFlowBase$withViewFlow$1(this, r101);
        goto L8
    }

    public final <ActionKey, T> Object d(ActionKey r100, Function2<? super VF, ? super Function1<? super d<? extends T>, Unit>, Unit> r101, Continuation<? super d<? extends T>> r102) {
        if ((r102 instanceof MoltenFlowBase$withAction$1) == false) goto L7;
        MoltenFlowBase$withAction$1 r103 = (MoltenFlowBase$withAction$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L17:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L22;
        int r110 = d.f254422b;
        return new d.b(r109, true);
    L22:
        return ((d) r108).f254423a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MoltenFlowBase$withAction$2 r111 = new MoltenFlowBase$withAction$2(r100, r101, this, null);
        r103.label = 1;
        r108 = f(r111, r103);
        if (r108 != r106) goto L17;
        return r106;
    L7:
        r103 = new MoltenFlowBase$withAction$1(this, r102);
        goto L8
    }

    public final <SubKey, Inner> d1<Inner> e(q<SubKey, Inner> r210, u r211, Function2<? super VF, ? super Function1<? super Inner, Unit>, Unit> r212) {
        Intrinsics.checkNotNullParameter(r210, "voType");
        Intrinsics.checkNotNullParameter(r211, "subscriptionType");
        Intrinsics.checkNotNullParameter(r212, "block");
        SubKey r100 = r210.f254453a;
        a r110 = new a(r100, Reflection.getOrCreateKotlinClass(r211.getClass()));
        u r101 = (u) ((LinkedHashMap) this.f254394c).get(r110);
        if (r101 != null) goto L5;
        this.f254394c.put(r110, r211);
    L10:
        LinkedHashMap r111 = (LinkedHashMap) this.f254393b;
        Object r102 = r111.get(r110);
        if (r102 != null) goto L53;
        b1 r112 = null;
        if ((r211 instanceof u.a) == false) goto L15;
        u.a r103 = (u.a) r211;
    L16:
        if (r103 == null) goto L18;
        g r104 = r103.f254464a;
    L19:
        if (r104 != null) goto L21;
        MutableSharedFlow r113 = null;
    L36:
        Inner r105 = r210.f254454b;
        if (r104 != null) goto L42;
        if (r105 != null) goto L40;
        z0 r106 = new MutableStateFlowInternal(j1.a(null));
    L41:
        z0 r114 = r106;
    L43:
        BuildersKt.launch$default((CoroutineScope) this.f254396e.getValue(), null, null, new MoltenFlowBase$withSubscription$3$1(this, r100, r212, r211, r104, new Ref.ObjectRef(), r113, r114, null), 3, null);
        if (r113 == null) goto L46;
        r102 = r113;
    L50:
        r111.put(r110, r102);
        goto L53
    L46:
        if (r114 == null) goto L48;
        r112 = kotlinx.coroutines.flow.e.b(r114);
    L48:
        if (r112 == null) goto L52;
        r102 = r112;
        goto L50
    L52:
        throw new IllegalStateException("won't reach here".toString());
    L40:
        r106 = j1.a(r105);
        goto L41
    L42:
        r114 = null;
        goto L43
    L21:
        if (Intrinsics.areEqual(r104, g.d.f254432a) == false) goto L24;
        MutableSharedFlow r107 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    L34:
        r113 = r107;
        goto L36
    L24:
        if (Intrinsics.areEqual(r104, g.c.f254431a) == false) goto L26;
    L33:
        r107 = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        goto L34
    L26:
        if (Intrinsics.areEqual(r104, g.a.f254429a) == true) goto L33;
        if (Intrinsics.areEqual(r104, g.b.f254430a) == false) goto L32;
        r107 = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_LATEST, 1, null);
        goto L34
    L32:
        throw new NoWhenBranchMatchedException();
    L18:
        r104 = null;
        goto L19
    L15:
        r103 = null;
    L53:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlow<Inner of com.bytedance.lark.view_flow_wrapper.MoltenFlowBase.withSubscription?>");
        return (d1) r102;
    L5:
        if (Intrinsics.areEqual(r101, r211) == true) goto L10;
        throw new IllegalArgumentException(("subscription already exists with different type, key:" + r100 + ", existing:" + r101 + ", new:" + r211).toString());
    }
}
