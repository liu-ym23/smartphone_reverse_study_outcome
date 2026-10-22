package com.bytedance.lark.policy.observer;

import com.bytedance.lark.policy.event.Event;
import com.bytedance.lark.policy.manager.FactorManager;
import com.bytedance.lark.policy.model.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements com.bytedance.lark.policy.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f253881a = null;

    static {
        f253881a = new c();
    }

    public c() {
    }

    @Override // com.bytedance.lark.policy.event.a
    public final void a(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100 != Event.EVENT_NETWORK_CHANGE) goto L9;
        List<String> r101 = FactorManager.f253806a;
        FactorManager.f253807b = new k(0);
        if (com.bytedance.lark.policy.utils.c.a() == false) goto L7;
        FactorManager.a(true);
        return;
    L7:
        FactorManager.c();
        return;
    }
}
