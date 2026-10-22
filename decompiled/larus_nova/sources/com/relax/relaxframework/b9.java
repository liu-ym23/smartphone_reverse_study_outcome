package com.relax.relaxframework;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b9 implements y1, e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s7 f405025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WatcherState f405026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<o7> f405027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f405028d;

    @Override // com.relax.relaxframework.y1
    public final s7 f() {
        return this.f405025a;
    }

    public b9(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f405025a = new s7();
        this.f405026b = WatcherState.Watching;
        this.f405027c = com.bytedance.rts.foundation.j.k(new o7[0]);
        this.f405028d = r100;
    }

    @Override // com.relax.relaxframework.e2
    public final void a(EffectComputed r100) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.LAUNCH_FROM_SIGNAL);
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = r100.c().f405284a.indexOf(this);
        com.bytedance.rts.foundation.k.c(r101, r102);
        if (r102 == (-1)) goto L6;
        r100.b(r102);
        return;
    }

    public final void b(EffectComputed r100) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.LAUNCH_FROM_SIGNAL);
        this.f405025a.a(r100, this, true);
    }

    @Override // com.relax.relaxframework.y1
    public final void d(z1 r100, boolean r101, ArrayList<e2> r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r102, "pendingWatchers");
        if (this.f405026b != WatcherState.Watching) goto L5;
        this.f405026b = WatcherState.Pending;
        com.bytedance.rts.foundation.j.j(r102, this);
    L5:
        com.bytedance.rts.foundation.j.j(this.f405027c, (o7) r100);
    }
}
