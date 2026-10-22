package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class p0 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qk4.i f332226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f332227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f332228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qk4.e f332229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f332230e;

    public p0(qk4.g r100, q0 r101, int r102, qk4.e r103, long r104) {
        this.f332226a = r100;
        this.f332227b = r101;
        this.f332228c = r102;
        this.f332229d = r103;
        this.f332230e = r104;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        s0.b(this.f332228c, this.f332229d, this.f332230e, true, "cancel");
        qk4.i r101 = this.f332226a;
        q0 r102 = this.f332227b;
        ((CopyOnWriteArraySet) ((qk4.g) r101).f533518e).remove(r102);
        return Unit.INSTANCE;
    }
}
