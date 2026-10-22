package com.obric.assistant.provider.hybrid;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class m implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f391198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f391199b;

    public /* synthetic */ m(AtomicBoolean r100, CountDownLatch r101) {
        this.f391198a = r100;
        this.f391199b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        AtomicBoolean r101 = this.f391198a;
        CountDownLatch r102 = this.f391199b;
        r101.set(((Boolean) r100).booleanValue());
        r102.countDown();
        return Unit.INSTANCE;
    }
}
