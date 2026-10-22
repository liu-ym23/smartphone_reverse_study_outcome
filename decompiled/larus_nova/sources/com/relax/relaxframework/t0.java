package com.relax.relaxframework;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t0 extends OwnerImpl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f405274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f405275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e2 f405276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EffectComputed f405277k;

    public final void d() {
        if (this.f405277k != null) goto L5;
        return;
    L5:
        OwnerImpl r100 = OwnerImpl.f404833g;
        RelaxInstance.a r101 = RelaxInstance.Companion;
        r101.getClass();
        RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
        OwnerImpl.f404833g = this;
        RelaxInstance r103 = this.f404835b;
        r101.getClass();
        RelaxInstance.access$setCurrentInstance$cp(r103);
        EffectComputed r104 = this.f405277k;
        Intrinsics.checkNotNull(r104);
        r104.h();
        OwnerImpl.f404833g = r100;
        r101.getClass();
        RelaxInstance.access$setCurrentInstance$cp(r102);
    }

    @Override // com.relax.relaxframework.OwnerImpl, com.relax.relaxframework.r0
    public final void dispose() {
        if (this.f405274h == true) goto L8;
        this.f405274h = true;
        this.f405275i = null;
        e2 r100 = this.f405276j;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        EffectComputed r101 = this.f405277k;
        Intrinsics.checkNotNull(r101);
        r100.a(r101);
        this.f405276j = null;
    L7:
        this.f405277k = null;
    L8:
        super.dispose();
    }

    public t0(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        super(OwnerImpl.f404833g, false);
        this.f405275i = r100;
    }

    public final void c(b9 r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        if (this.f405274h == true) goto L6;
        this.f405276j = r100;
        this.f405277k = new EffectComputed(this);
        d();
        EffectComputed r101 = this.f405277k;
        Intrinsics.checkNotNull(r101);
        r100.b(r101);
        return;
    }
}
