package com.bytedance.flow_audio.impl.business.tts;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowTtsSession f244087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowAudioAsyncWaitGroup f244088b;

    public b(FlowTtsSession r100, FlowAudioAsyncWaitGroup r101) {
        this.f244087a = r100;
        this.f244088b = r101;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        FlowTtsSession r102 = this.f244087a;
        FlowAudioAsyncWaitGroup r103 = this.f244088b;
        r102.getClass();
        rw5.d r104 = ((e) r100).f244095b;
        if (r102.f244073m == true) goto L35;
        r102.f244073m = true;
        if (r102.f244067g == false) goto L16;
        Object r105 = r102.f244066f;
        monitor-enter(r105);
        ow5.b r106 = r102.f244065e;     // Catch: Throwable -> L13
        if (r106 == null) goto L11;
        r106.O0(r102);     // Catch: Throwable -> L13
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r105);
    L19:
        r102.f244063c.start();
        if (r102.f244067g == false) goto L31;
        Object r108 = r102.f244066f;
        monitor-enter(r108);
        ow5.b r109 = r102.f244065e;     // Catch: Throwable -> L28
        if (r109 == null) goto L26;
        r109.k3(r102);     // Catch: Throwable -> L28
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        monitor-exit(r108);
    L34:
        r102.n3("output: start sessionId=" + r102.f244064d);
    L28:
        th = move-exception;
        throw th;
    L31:
        ow5.b r111 = r102.f244065e;
        if (r111 == null) goto L34;
        r111.k3(r102);
    L13:
        th = move-exception;
        throw th;
    L16:
        ow5.b r112 = r102.f244065e;
        if (r112 == null) goto L19;
        r112.O0(r102);
    L35:
        r103.f244059a++;
        if (r102.f244067g == false) goto L47;
        Object r113 = r102.f244066f;
        monitor-enter(r113);
        ow5.b r114 = r102.f244065e;     // Catch: Throwable -> L44
        if (r114 == null) goto L42;
        r114.x1(r102, r104);     // Catch: Throwable -> L44
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        monitor-exit(r113);
    L50:
        r102.f244063c.L0(r104);
        return Unit.INSTANCE;
    L44:
        th = move-exception;
        throw th;
    L47:
        ow5.b r116 = r102.f244065e;
        if (r116 == null) goto L50;
        r116.x1(r102, r104);
        goto L50
    }
}
