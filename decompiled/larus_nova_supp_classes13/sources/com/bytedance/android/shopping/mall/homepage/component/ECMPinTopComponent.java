package com.bytedance.android.shopping.mall.homepage.component;

import android.os.Bundle;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMPinTopComponent extends b implements e93.a {
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Override // u93.b, u93.c
    public final void onDestroy() {
        ((List) this.b.getValue()).clear();
    }

    public ECMPinTopComponent() {
        this.b = LazyKt.lazy(ECMPinTopComponent$guideBenefitListeners$2.INSTANCE);
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r2) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r3 = MallAbilityManager.a;
        MallAbilityManager.a(e93.a.class, this, o());
    }
}
