package com.obric.audio.continuous_talk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.CallbackFlowBuilder;

/* JADX INFO: loaded from: classes33.dex */
public final class i implements hia.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Map<String, String>, Unit> f395174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wc9.e f395175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f395176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f395177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f395178e;

    @Override // hia.a.b
    public final void b() {
        this.f395178e.compareAndSet(false, true);
    }

    public i() {
        this.f395176c = new AtomicBoolean(false);
        this.f395177d = new HashMap();
        this.f395178e = new AtomicBoolean(false);
    }

    @Override // hia.a.b
    public final CallbackFlowBuilder a(long r100) {
        return kotlinx.coroutines.flow.e.e(new ObricContinuousLLMContextProvider$collectContext$1(this, r100, null));
    }
}
