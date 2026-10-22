package com.bytedance.android.livesdk.livecommerce.hybrid;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveCommerceBridgeProvider implements i {
    public static final LiveCommerceBridgeProvider a = null;

    public LiveCommerceBridgeProvider() {
    }

    static {
        a = new LiveCommerceBridgeProvider();
    }

    public final Function0<List<ECBaseBridgeMethod>> b() {
        return LiveCommerceBridgeProvider$getHostBridgeProvider$1.INSTANCE;
    }

    public final Function0<List<ECBaseBridgeMethod>> c() {
        return LiveCommerceBridgeProvider$getLiveBridgeProvider$1.INSTANCE;
    }
}
