package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.extensions.HostInjector;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class o {
    public static final void a(com.bytedance.tiktok.proxy.a r100, Function0<Unit> r101) {
        if ((r100 instanceof ReusedUIAssem) == true) goto L5;
        r100 = null;
    L5:
        ReusedUIAssem r102 = (ReusedUIAssem) r100;
        if (r102 != null) goto L8;
        r101.invoke();
        Unit r103 = Unit.INSTANCE;
        return;
    L8:
        if (r102.f192987k == false) goto L10;
        r101.invoke();
        return;
    L10:
        Lazy r104 = HostInjector.f192919a;
    }
}
