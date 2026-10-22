package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes37.dex */
public abstract class MviRepository<Entity, OPT extends c<Entity>, event extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f433817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f433818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutinesSafe f433819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f433820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f433821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f433822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f433823i;

    public abstract Entity a();

    public final CoroutineScope d() {
        return (CoroutineScope) this.f433817c.getValue();
    }

    public final d1<event> e() {
        return (d1) this.f433821g.getValue();
    }

    public final CoroutineScope f() {
        return (CoroutineScope) this.f433816b.getValue();
    }

    public final i1<Entity> g() {
        return (i1) this.f433823i.getValue();
    }

    public final Entity h() {
        return (Entity) ((z0) this.f433822h.getValue()).getValue();
    }

    public MviRepository() {
        this.f433815a = getClass().getSimpleName() + '_' + hashCode();
        this.f433816b = LazyKt.lazy(MviRepository$repoIOScope$2.INSTANCE);
        this.f433817c = LazyKt.lazy(new MviRepository$mainUIScope$2(this));
        Lazy r100 = LazyKt.lazy(MviRepository$repoCpuScope$2.INSTANCE);
        this.f433818d = r100;
        this.f433819e = new CoroutinesSafe((CoroutineScope) r100.getValue());
        this.f433820f = LazyKt.lazy(MviRepository$repoEventMutableFlow$2.INSTANCE);
        this.f433821g = LazyKt.lazy(new MviRepository$repoEventFlow$2(this));
        this.f433822h = LazyKt.lazy(new MviRepository$stateMutableFlow$2(this));
        this.f433823i = LazyKt.lazy(new MviRepository$stateFlow$2(this));
    }

    public final void i() {
        CoroutineScopeKt.cancel$default(f(), null, 1, null);
        CoroutineScopeKt.cancel$default(d(), null, 1, null);
        CoroutineScopeKt.cancel$default((CoroutineScope) this.f433818d.getValue(), null, 1, null);
        kotlinx.coroutines.channels.a r100 = this.f433819e.f433807b;
        if (r100 == null) goto L6;
        SendChannel.a.a(r100);
        return;
    }

    public String c() {
        return this.f433815a;
    }

    public final void j(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f433819e.c(r100);
    }

    public final Object b(Entity r100, Continuation<? super Unit> r101) {
        Object r102 = ((z0) this.f433822h.getValue()).emit(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object k(event r100, Continuation<? super Unit> r101) {
        Object r102 = ((MutableSharedFlow) this.f433820f.getValue()).emit(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
