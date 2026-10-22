package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements com.bytedance.android.livesdk.livecommerce.ability.e {
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.ability.f a;
    public final /* synthetic */ il2.a b;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onSuccess() {
        il2.a r0 = this.b;
        if (r0 == null) goto L8;
        il2.a r1 = il2.a.C0145a.a(r0, "execute_atomic_ability", MapsKt.mapOf(TuplesKt.to("action_name", this.a.a)), false, null, null, null, 60);
        if (r1 == null) goto L9;
        ((LiveActionTracker) r1).e(false);
        return;
    L9:
        return;
    }

    public p(com.bytedance.android.livesdk.livecommerce.ability.f r1, il2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onFail(int r9, String r10) {
        il2.a r0 = this.b;
        if (r0 == null) goto L8;
        il2.a r11 = il2.a.C0145a.a(r0, "execute_atomic_ability", MapsKt.mapOf(TuplesKt.to("action_name", this.a.a)), false, r10, null, null, 48);
        if (r11 == null) goto L9;
        ((LiveActionTracker) r11).e(false);
        return;
    L9:
        return;
    }
}
