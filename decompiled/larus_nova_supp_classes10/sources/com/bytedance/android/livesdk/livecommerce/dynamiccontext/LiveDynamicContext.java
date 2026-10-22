package com.bytedance.android.livesdk.livecommerce.dynamiccontext;

import com.bytedance.android.livesdk.livecommerce.ability.b;
import com.bytedance.android.livesdk.livecommerce.ability.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveDynamicContext {
    public static final Lazy c = null;
    public c a;
    public final Lazy b;

    public static final class a {
        public static LiveDynamicContext a() {
            return (LiveDynamicContext) LiveDynamicContext.c.getValue();
        }
    }

    public final b a() {
        return (b) this.b.getValue();
    }

    static {
        c = LazyKt.lazy(LiveDynamicContext$Companion$INSTANCE$2.INSTANCE);
    }

    public LiveDynamicContext() {
        this.b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new LiveDynamicContext$abilityCenter$2(this));
    }
}
