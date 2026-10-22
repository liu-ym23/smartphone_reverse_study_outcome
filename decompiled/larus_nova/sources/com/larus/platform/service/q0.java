package com.larus.platform.service;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class q0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f365789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f365790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f365791c;

    public /* synthetic */ q0(CoroutineScope r100, AtomicBoolean r101, Function0 r102) {
        this.f365789a = r100;
        this.f365790b = r101;
        this.f365791c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        final CoroutineScope r100 = this.f365789a;
        AtomicBoolean r101 = this.f365790b;
        final Function0 r102 = this.f365791c;
        FlowDriveSdkService r103 = FlowDriveSdkService.f365704a;
        if (CoroutineScopeKt.isActive(r100) == false) goto L11;
        if (r101.compareAndSet(false, true) == false) goto L11;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        r102.invoke();
        goto L11
    L9:
        com.larus.utils.t0.f375468a.post(new r0(r100, r102));
    L11:
        return Unit.INSTANCE;
    }
}
