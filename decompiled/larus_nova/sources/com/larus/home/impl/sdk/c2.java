package com.larus.home.impl.sdk;

import com.larus.platform.api.s4;
import com.larus.push.api.IPushService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f346149a = null;

    static {
        f346149a = new c2();
    }

    public c2() {
    }

    public final void a(s4 r100, Function1<? super Boolean, Unit> r101) {
        IPushService r102 = (IPushService) ServiceManager.get().getService(IPushService.class);
        if (r102 == null) goto L6;
        r102.l(r100, r101);
        return;
    }
}
