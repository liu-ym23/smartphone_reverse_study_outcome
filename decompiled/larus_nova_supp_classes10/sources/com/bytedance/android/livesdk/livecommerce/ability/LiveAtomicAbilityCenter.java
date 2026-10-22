package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveAtomicAbilityCenter implements b {
    public final ConcurrentHashMap<String, d<?>> a;
    public volatile boolean b;
    public final LiveDynamicContext c;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void c() {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
        this.a.remove("show_promotion_card_guide");     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final h e() {
        Intrinsics.checkNotNullParameter("add_cart", "abilityName");
        return this.a.get("add_cart");
    }

    public LiveAtomicAbilityCenter(LiveDynamicContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <R extends d<?>> R get(String r4) {
        Intrinsics.checkNotNullParameter(r4, "abilityName");
        if (this.b == true) goto L21;
        c r0 = this.c.a;
        monitor-enter(this);
        if (r0 != null) goto L29;
        monitor-exit(this);
        goto L21
    L29:
    L18:
        th = move-exception;
        throw th;
    L10:
        if (this.b == true) goto L16;
        Iterator<Map.Entry<String, d<?>>> r1 = r0.getAbilities().entrySet().iterator();     // Catch: Throwable -> L18
    L13:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, d<?>> r2 = r1.next();     // Catch: Throwable -> L18
        b(r2.getKey(), r2.getValue());     // Catch: Throwable -> L18
        goto L13
    L15:
        this.b = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
    L21:
        Object r3 = null;
        if (this.b == false) goto L32;
        d<?> r5 = this.a.get(r4);
        if ((r5 instanceof d) == false) goto L28;
        r3 = r5;
    L28:
        return (R) r3;
    L32:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void b(String r2, d<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "abilityName");
        Intrinsics.checkNotNullParameter(r3, "ability");
        this.a.put(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void a(final Context r9, final f<T> r10, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "action");
        if (r11 == null) goto L5;
        r11.schedule(new LiveAtomicAbilityCenter$schedule$1(this, r9, r10));
        return;
    L5:
        b.a.a(this, r9, r10, null, null, null, 20);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void d(Context r8, f<T> r9, Object r10, il2.a r11, e r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "action");
        d r0 = get(r9.a);
        if ((r0 instanceof d) == true) goto L5;
        r0 = null;
    L5:
        d r1 = r0;
        if (r1 == null) goto L9;
        r1.a(r8, r9.b, r10, r11, r12);
        return;
    }
}
