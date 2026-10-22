package com.bytedance.ee.bear.appsetting;

import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T1, T2, R> f206263a = null;

    static {
        f206263a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        EmergencyFixConfig r102 = (EmergencyFixConfig) r100;
        Boolean r103 = (Boolean) r101;
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "relatedFG");
        tt5.a.h("EmergencyFixConfigHandler", "combineLatest, config: " + r102 + ", relatedFG: " + r103.booleanValue());
        if (r103.booleanValue() == false) goto L6;
        return r102;
    L6:
        return new EmergencyFixConfig();
    }
}
