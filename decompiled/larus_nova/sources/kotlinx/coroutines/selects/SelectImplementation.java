package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes42.dex */
public class SelectImplementation<R> implements kotlinx.coroutines.h, d<R>, m<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f505084f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f505085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<SelectImplementation<R>.a> f505086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f505087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f505088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f505089e;
    private volatile /* synthetic */ Object state$volatile;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f505090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function3<Object, l<?>, Object, Unit> f505091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function3<Object, Object, Object, Object> f505092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f505093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f505094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function3<l<?>, Object, Object, Function1<Throwable, Unit>> f505095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f505096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f505097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ SelectImplementation<R> f505098i;

        public final void a() {
            Object r100 = this.f505096g;
            SelectImplementation<R> r101 = this.f505098i;
            if ((r100 instanceof y) == false) goto L6;
            ((y) r100).h(this.f505097h, r101.getContext());
            return;
        L6:
            if ((r100 instanceof m0) == false) goto L8;
            m0 r102 = (m0) r100;
        L9:
            if (r102 == null) goto L13;
            r102.dispose();
            return;
        L13:
            return;
        L8:
            r102 = null;
            goto L9
        }

        public final Object b(Object r100, Continuation<? super R> r101) {
            Object r102 = this.f505094e;
            if (this.f505093d != SelectKt.f505104f) goto L6;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function1) r102).invoke(r101);
        L6:
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) r102).invoke(r100, r101);
        }

        public a(SelectImplementation r100, Object r101, Function3 r102, Function3 r103, b0 r104, SuspendLambda r105, Function3 r106) {
            this.f505098i = r100;
            this.f505090a = r101;
            this.f505091b = r102;
            this.f505092c = r103;
            this.f505093d = r104;
            this.f505094e = r105;
            this.f505095f = r106;
            this.f505097h = -1;
        }
    }

    static {
        f505084f = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    }

    @Override // kotlinx.coroutines.selects.m, kotlinx.coroutines.selects.l
    public CoroutineContext getContext() {
        return this.f505085a;
    }

    public SelectImplementation(CoroutineContext r100) {
        this.f505085a = r100;
        this.state$volatile = SelectKt.f505100b;
        this.f505086b = new ArrayList(2);
        this.f505088d = -1;
        this.f505089e = SelectKt.f505103e;
    }

    @Override // kotlinx.coroutines.h
    public final void a(Throwable r100) {
        AtomicReferenceFieldUpdater r101 = f505084f;
    L3:
        Object r102 = r101.get(this);
        if (r102 == SelectKt.f505101c) goto L5;
        b0 r103 = SelectKt.f505102d;
    L8:
        if (r101.compareAndSet(this, r102, r103) == true) goto L9;
        if (r101.get(this) == r102) goto L8;
        boolean r104 = false;
    L13:
        if (r104 == false) goto L3;
        List<SelectImplementation<R>.a> r105 = this.f505086b;
        if (r105 != null) goto L17;
        return;
    L17:
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L21;
        ((a) r106.next()).a();
        goto L19
    L21:
        this.f505089e = SelectKt.f505103e;
        this.f505086b = null;
        return;
    L9:
        r104 = true;
        goto L13
    }

    @Override // kotlinx.coroutines.selects.l
    public final void b(m0 r100) {
        this.f505087c = r100;
    }

    @Override // kotlinx.coroutines.selects.l
    public final void c(Object r100) {
        this.f505089e = r100;
    }

    public final Object g(Continuation<? super R> r100) {
        Object r101 = f505084f.get(this);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        a r102 = (a) r101;
        Object r103 = this.f505089e;
        List<SelectImplementation<R>.a> r104 = this.f505086b;
        if (r104 == null) goto L13;
        Iterator r105 = ((ArrayList) r104).iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        a r106 = (a) r105.next();
        if (r106 == r102) goto L7;
        r106.a();
        goto L7
    L11:
        f505084f.set(this, SelectKt.f505101c);
        this.f505089e = SelectKt.f505103e;
        this.f505086b = null;
    L13:
        return r102.b(r102.f505092c.invoke(r102.f505090a, r102.f505093d, r103), r100);
    }

    public Object h(Continuation<? super R> r100) {
        if ((f505084f.get(this) instanceof a) == false) goto L6;
        return g(r100);
    L6:
        return i(r100);
    }

    public final Object i(Continuation<? super R> r110) {
        if ((r110 instanceof SelectImplementation$doSelectSuspend$1) == false) goto L7;
        SelectImplementation$doSelectSuspend$1 r100 = (SelectImplementation$doSelectSuspend$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L60:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SelectImplementation r104 = (SelectImplementation) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L57:
        r100.L$0 = null;
        r100.label = 2;
        r111 = r104.g(r100);
        if (r111 != r102) goto L60;
        return r102;
    L16:
        ResultKt.throwOnFailure(r111);
        r100.L$0 = this;
        r100.label = 1;
        kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r112.C();
        AtomicReferenceFieldUpdater r105 = f505084f;
    L17:
        Object r106 = r105.get(this);
        b0 r107 = SelectKt.f505100b;
        boolean r108 = false;
        if (r106 == r107) goto L19;
        if ((r106 instanceof List) == false) goto L41;
        AtomicReferenceFieldUpdater r109 = f505084f;
    L31:
        if (r109.compareAndSet(this, r106, r107) == true) goto L32;
        if (r109.get(this) == r106) goto L31;
    L35:
        if (r108 == false) goto L17;
        List r113 = (List) r106;
        Iterator r114 = ((Iterable) r106).iterator();
    L38:
        if (r114.hasNext() == false) goto L17;
        SelectImplementation<R>.a r115 = j(r114.next());
        Intrinsics.checkNotNull(r115);
        r115.f505096g = null;
        r115.f505097h = -1;
        k(r115, true);
        goto L38
    L32:
        r108 = true;
        goto L35
    L41:
        if ((r106 instanceof a) == false) goto L62;
        Unit r116 = Unit.INSTANCE;
        a r117 = (a) r106;
        Object r118 = this.f505089e;
        Function3<l<?>, Object, Object, Function1<Throwable, Unit>> r119 = r117.f505095f;
        if (r119 == null) goto L45;
        Function1<Throwable, Unit> r120 = r119.invoke(this, r117.f505093d, r118);
    L46:
        r112.h(r116, r120);
    L47:
        Object r121 = r112.B();
        if (r121 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L51;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L51:
        if (r121 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        r121 = Unit.INSTANCE;
    L54:
        if (r121 != r102) goto L56;
        return r102;
    L56:
        r104 = this;
        goto L57
    L45:
        r120 = null;
        goto L46
    L62:
        throw new IllegalStateException(("unexpected state: " + r106).toString());
    L19:
        AtomicReferenceFieldUpdater r122 = f505084f;
    L21:
        if (r122.compareAndSet(this, r106, r112) == true) goto L22;
        if (r122.get(this) == r106) goto L21;
    L25:
        if (r108 == false) goto L17;
        kotlinx.coroutines.l.b(r112, this);
        goto L47
    L22:
        r108 = true;
    L7:
        r100 = new SelectImplementation$doSelectSuspend$1(this, r110);
        goto L8
    }

    public final SelectImplementation<R>.a j(Object r100) {
        List<SelectImplementation<R>.a> r101 = this.f505086b;
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator<T> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (((a) r104).f505090a != r100) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L7;
        r102 = r104;
        goto L14
    L11:
        r105 = false;
    L14:
        SelectImplementation<R>.a r106 = (a) r102;
        if (r106 == null) goto L18;
        return r106;
    L18:
        throw new IllegalStateException(("Clause with object " + r100 + " is not found").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.d
    public <Q> void d(g<? extends Q> r110, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r111) {
        SuspendLambda r100 = (SuspendLambda) r111;
        k(new a(this, r110.c(), r110.b(), r110.d(), null, r100, r110.a()), false);
    }

    @Override // kotlinx.coroutines.d2
    public final void e(y<?> r100, int r101) {
        this.f505087c = r100;
        this.f505088d = r101;
    }

    @Override // kotlinx.coroutines.selects.l
    public final boolean f(Object r100, Object r101) {
        if (m(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void k(SelectImplementation<R>.a r100, boolean r101) {
        if ((f505084f.get(this) instanceof a) == false) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r101 == true) goto L26;
        Object r103 = r100.f505090a;
        List<SelectImplementation<R>.a> r104 = this.f505086b;
        Intrinsics.checkNotNull(r104);
        if ((r104 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L21;
        if (((a) r105.next()).f505090a != r103) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L14;
        boolean r107 = false;
    L22:
        if (r107 == true) goto L26;
        throw new IllegalStateException(("Cannot use select clauses on the same object: " + r103).toString());
    L18:
        r106 = false;
    L21:
        r107 = true;
        goto L22
    L10:
        if (r104.isEmpty() == false) goto L12;
    L26:
        r100.f505091b.invoke(r100.f505090a, this, r100.f505093d);
        if (this.f505089e != SelectKt.f505103e) goto L29;
        r102 = true;
    L29:
        if (r102 == false) goto L33;
        if (r101 == true) goto L32;
        List<SelectImplementation<R>.a> r108 = this.f505086b;
        Intrinsics.checkNotNull(r108);
        r108.add(r100);
    L32:
        r100.f505096g = this.f505087c;
        r100.f505097h = this.f505088d;
        this.f505087c = null;
        this.f505088d = -1;
        return;
    L33:
        f505084f.set(this, r100);
    }

    public final TrySelectDetailedResult l(Object r100, Unit r101) {
        int r102 = m(r100, r101);
        Function3<Object, Object, Object, Object> r103 = SelectKt.f505099a;
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L18;
        if (r102 != 3) goto L12;
        return TrySelectDetailedResult.ALREADY_SELECTED;
    L12:
        throw new IllegalStateException(("Unexpected internal result: " + r102).toString());
    L18:
        return TrySelectDetailedResult.CANCELLED;
    L19:
        return TrySelectDetailedResult.REREGISTER;
    L16:
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public final int m(Object r100, Object r110) {
    L2:
        AtomicReferenceFieldUpdater r101 = f505084f;
        Object r102 = r101.get(this);
        boolean r103 = false;
        boolean r104 = true;
        if ((r102 instanceof kotlinx.coroutines.i) == true) goto L4;
        if (Intrinsics.areEqual(r102, SelectKt.f505101c) == false) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == true) goto L31;
        if (Intrinsics.areEqual(r102, SelectKt.f505102d) == true) goto L35;
        if (Intrinsics.areEqual(r102, SelectKt.f505100b) == true) goto L38;
        if ((r102 instanceof List) == false) goto L57;
        List r106 = CollectionsKt.plus((Collection) r102, r100);
    L50:
        if (r101.compareAndSet(this, r102, r106) == true) goto L51;
        if (r101.get(this) == r102) goto L50;
    L54:
        if (r103 == false) goto L2;
        return 1;
    L51:
        r103 = true;
        goto L54
    L57:
        throw new IllegalStateException(("Unexpected state: " + r102).toString());
    L38:
        List r107 = CollectionsKt.listOf(r100);
    L40:
        if (r101.compareAndSet(this, r102, r107) == true) goto L41;
        if (r101.get(this) == r102) goto L40;
    L44:
        if (r103 == false) goto L2;
        return 1;
    L41:
        r103 = true;
        goto L44
    L35:
        return 2;
    L31:
        return 3;
    L29:
        r105 = r102 instanceof a;
        goto L30
    L4:
        SelectImplementation<R>.a r108 = j(r100);
        if (r108 == null) goto L2;
        Function3<l<?>, Object, Object, Function1<Throwable, Unit>> r109 = r108.f505095f;
        if (r109 == null) goto L10;
        Function1<Throwable, Unit> r111 = r109.invoke(this, r108.f505093d, r110);
    L12:
        if (r101.compareAndSet(this, r102, r108) == true) goto L13;
        if (r101.get(this) == r102) goto L12;
        boolean r112 = false;
    L17:
        if (r112 == false) goto L2;
        kotlinx.coroutines.i r113 = (kotlinx.coroutines.i) r102;
        this.f505089e = r110;
        Function3<Object, Object, Object, Object> r114 = SelectKt.f505099a;
        b0 r115 = r113.b(Unit.INSTANCE, r111);
        if (r115 != null) goto L21;
        r104 = false;
    L22:
        if (r104 == false) goto L24;
        return 0;
    L24:
        this.f505089e = SelectKt.f505103e;
        return 2;
    L21:
        r113.d(r115);
        goto L22
    L13:
        r112 = true;
        goto L17
    L10:
        r111 = null;
        goto L12
    }
}
