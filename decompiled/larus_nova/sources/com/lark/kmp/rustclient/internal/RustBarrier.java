package com.lark.kmp.rustclient.internal;

import com.lark.kmp.logger.LarkLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes24.dex */
public final class RustBarrier implements com.lark.kmp.rustclient.barrier.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f282508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.a f282509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f282510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Function1<Continuation<? super Unit>, Object>> f282511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutexImpl f282512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<WeakReference<com.lark.kmp.rustclient.barrier.b>> f282513f;

    public static final class a {
    }

    static {
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean b() {
        return e(false);
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean d() {
        return e(true);
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final boolean c() {
        return this.f282509b.c();
    }

    public RustBarrier() {
        this.f282508a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f282509b = buc.b.a(true);
        this.f282510c = kotlinx.coroutines.sync.b.a();
        this.f282511d = new ArrayList();
        this.f282512e = kotlinx.coroutines.sync.b.a();
        this.f282513f = new LinkedHashSet();
    }

    @Override // com.lark.kmp.rustclient.barrier.a
    public final void a(v.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        BuildersKt.launch$default(this.f282508a, null, null, new RustBarrier$addBarrierObserver$1(this, r100, null), 3, null);
    }

    public final boolean e(boolean r110) {
        LarkLogger r100 = LarkLogger.f278603a;
        LarkLogger.c("RustBarrier", "updateBarrierState enableBarrier = " + r110 + ", current = " + this.f282509b.c());
        ArrayList r101 = new ArrayList();
        boolean r102 = this.f282509b.a(r110 ^ true, r110);
        if (r102 == false) goto L6;
        if (r110 == true) goto L6;
        BuildersKt.launch$default(this.f282508a, null, null, new RustBarrier$updateBarrierState$1(this, r101, null), 3, null);
    L6:
        if (r102 == false) goto L8;
        boolean r111 = this.f282509b.c();
        LarkLogger.c("RustBarrier", "notifyBarrierObservers, barrier = " + r111);
        BuildersKt.launch$default(this.f282508a, null, null, new RustBarrier$notifyBarrierObservers$1(this, r111, null), 3, null);
    L9:
        return r102;
    L8:
        LarkLogger.b("RustBarrier", "updateBarrierState compareAndSet failed");
        goto L9
    }
}
