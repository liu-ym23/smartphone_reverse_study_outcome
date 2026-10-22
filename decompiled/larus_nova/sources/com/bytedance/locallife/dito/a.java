package com.bytedance.locallife.dito;

import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final void a(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        rq6.a r102 = rq6.a.f538927a;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100);
        r103.append(" method cost:");
        long r104 = System.currentTimeMillis();
        r101.invoke();
        Unit r105 = Unit.INSTANCE;
        r103.append(System.currentTimeMillis() - r104);
        r102.c(DitoLynxNativeModule.NAME, r103.toString());
    }
}
