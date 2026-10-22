package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "biz_change_store", description = "切换门店", service = {"LiveList"})
public final class j extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.e> {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(final Context r6, sl.e r7, Object r8, il2.a r9, final com.bytedance.android.livesdk.livecommerce.ability.e r10) {
        final sl.e r11 = r7;
        if (r6 == null) goto L11;
        if (r11 == null) goto L11;
        Function0<Unit> r12 = new LiveChangeStoreBizAbility$execute$1(this, r6, r11, r10);
        int r13 = RoomContextController.h;
        RoomContextController r14 = RoomContextController.a.a();
        FilterNullArrayList r15 = new FilterNullArrayList();
        r15.add(new si2.k("store_id", r11.b()));
        String r16 = si2.g.Y;
        String r0 = r14.B();
        String r1 = r14.y();
        String r17 = r14.z();
        g r3 = new g();
        String r4 = vi2.h.a;
        r15.add(si2.k.a.a("room_id", r0));
        Lazy r2 = ECAppInfoService.a;
        if (we.a.a == false) goto L9;
        r15.add(si2.k.a.a("author_open_id", r1));
    L10:
        r15.add(si2.k.a.a("sec_author_id", r17));
        nl2.b.b(vi2.h.e(null, null, r16, new vi2.c(r15, r16, r3, xi2.q.class)).subscribeOn(Schedulers.io()).subscribe(new h(r12), i.a));
        return;
    L9:
        r15.add(si2.k.a.a("author_id", r1));
    L11:
        if (r10 == null) goto L15;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r10, 0, null, 3);
        return;
    }
}
