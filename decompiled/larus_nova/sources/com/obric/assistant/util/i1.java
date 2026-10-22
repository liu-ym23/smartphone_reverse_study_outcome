package com.obric.assistant.util;

import android.os.SystemClock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class i1 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeepScreenOnDelegate f393721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeepScreenOnDelegate.KeepScreenOnReason f393722b;

    public /* synthetic */ i1(KeepScreenOnDelegate r100, KeepScreenOnDelegate.KeepScreenOnReason r101) {
        this.f393721a = r100;
        this.f393722b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        KeepScreenOnDelegate r100 = this.f393721a;
        KeepScreenOnDelegate.KeepScreenOnReason r101 = this.f393722b;
        r100.f393578f.put(r101, Long.valueOf(SystemClock.uptimeMillis() + 30000));
        r100.j();
        return Unit.INSTANCE;
    }
}
