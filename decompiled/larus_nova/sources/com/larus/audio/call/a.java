package com.larus.audio.call;

import com.larus.audio.call.mgr.AVKitCoreStates$Invalid;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f288924r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super String, Unit> f288925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f288926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f288927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MajorState f288928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f288929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f288930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super String, Unit> f288931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super r58.d, Unit> f288932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super byte[], Unit> f288933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f288934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableSharedFlow f288935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableSharedFlow<Pair<MajorState, Integer>> f288936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableSharedFlow f288937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final StateFlowImpl f288938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final StateFlowImpl f288939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Long, Unit> f288940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<Unit> f288941q;

    /* JADX INFO: renamed from: com.larus.audio.call.a$a, reason: collision with other inner class name */
    public static final class C3960a {
    }

    static {
    }

    public void a(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public void b() {
    }

    public void c() {
    }

    public void d(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public void e(RealtimeCallParam r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    public abstract void g(String r100);

    public a() {
        this.f288927c = -1;
        MutableSharedFlow<Integer> r100 = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.f288934j = r100;
        this.f288935k = r100;
        MutableSharedFlow<Pair<MajorState, Integer>> r101 = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.f288936l = r101;
        this.f288937m = r101;
        StateFlowImpl r102 = j1.a(TuplesKt.to(new AVKitDuplexState(new AVKitCoreStates$Invalid(), new AVKitCoreStates$Invalid()), -1));
        this.f288938n = r102;
        this.f288939o = r102;
    }

    public final void f(MajorState r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "majorState");
        com.larus.audio.call.util.e r102 = com.larus.audio.call.util.e.f289645a;
        r102.i("AbsRealtimeCallService", "onUIStateChanged, Major from:" + this.f288928d + " to:" + r100);
        this.f288936l.tryEmit(TuplesKt.to(r100, Integer.valueOf(r101)));
        r102.i("AbsRealtimeCallService", "onUIStateChanged, from:" + this.f288927c + " to:" + r101);
        this.f288934j.tryEmit(Integer.valueOf(r101));
        this.f288928d = r100;
        this.f288927c = r101;
    }
}
