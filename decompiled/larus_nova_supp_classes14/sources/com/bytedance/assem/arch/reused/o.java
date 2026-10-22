package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.extensions.HostInjector;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static final void a(com.bytedance.tiktok.proxy.a r1, Function0<Unit> r2) {
        if ((r1 instanceof ReusedUIAssem) == true) goto L5;
        r1 = null;
    L5:
        ReusedUIAssem r3 = (ReusedUIAssem) r1;
        if (r3 != null) goto L8;
        r2.invoke();
        Unit r4 = Unit.INSTANCE;
        return;
    L8:
        if (r3.k == false) goto L10;
        r2.invoke();
        return;
    L10:
        Lazy r5 = HostInjector.a;
    }
}
