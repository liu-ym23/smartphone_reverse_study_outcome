package com.bytedance.android.shopping.hybrid;

import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import g33.e;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class EShoppingBridgeProvider implements i, e {
    public static final EShoppingBridgeProvider a = null;

    public EShoppingBridgeProvider() {
    }

    static {
        a = new EShoppingBridgeProvider();
    }

    public final void a() {
        Lazy r0 = ECBridgeProviderInjector.b;
        ((CopyOnWriteArrayList) ECBridgeProviderInjector.a.a().a).add(this);
    }

    public final Function0<List<ECBaseBridgeMethod>> b() {
        return EShoppingBridgeProvider$getHostBridgeProvider$1.INSTANCE;
    }

    public final Function0<List<ECBaseBridgeMethod>> c() {
        return EShoppingBridgeProvider$getLiveBridgeProvider$1.INSTANCE;
    }
}
