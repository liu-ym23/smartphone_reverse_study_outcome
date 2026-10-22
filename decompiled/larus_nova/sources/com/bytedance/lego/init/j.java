package com.bytedance.lego.init;

import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final void a(Function0<Unit> r100) {
        InitSchedulerExecutors.f254494c.getClass();
        Lazy r101 = InitSchedulerExecutors.f254493b;
        KProperty r102 = InitSchedulerExecutors.f254492a[0];
        ((ThreadPoolExecutor) r101.getValue()).execute(new i(r100));
    }
}
