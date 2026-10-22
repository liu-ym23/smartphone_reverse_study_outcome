package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void a(Context r1, f<T> r2, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void b(String r2, d<?> r3) {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
        Intrinsics.checkNotNullParameter(r3, "ability");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void c() {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final h e() {
        Intrinsics.checkNotNullParameter("add_cart", "abilityName");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T extends d<?>> T get(String r2) {
        Intrinsics.checkNotNullParameter("tab_resort", "abilityName");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void d(Context r1, f<T> r2, Object r3, il2.a r4, e r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "action");
        if (r5 == null) goto L6;
        e.a.a(r5, 0, null, 3);
        return;
    }
}
