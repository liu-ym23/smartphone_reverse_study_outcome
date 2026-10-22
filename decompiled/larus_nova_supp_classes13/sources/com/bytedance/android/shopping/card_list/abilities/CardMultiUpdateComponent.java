package com.bytedance.android.shopping.card_list.abilities;

import com.bytedance.android.shopping.card_list.components.b;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.bytedance.android.shopping.card_list.utils.f;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.event.ability.uplink.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import v96.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardMultiUpdateComponent extends b implements c {
    public static final /* synthetic */ int g = 0;
    public final com.bytedance.android.shopping.card_list.yata.interceptor.a d;
    public final AtomicLong e;
    public final CardListObjectContainer f;

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        int r0 = f.a;
        AndroidYaTaInstance r1 = (AndroidYaTaInstance) this.f.e.c.invoke();
        Object r2 = null;
        if (r1 == null) goto L5;
        Object r3 = r1.i("hit_client_selected");
    L7:
        if ((r3 instanceof Boolean) == false) goto L10;
        r2 = r3;
    L10:
        Boolean r4 = (Boolean) r2;
        if (r4 == null) goto L13;
        final boolean r5 = r4.booleanValue();
    L14:
        Lazy r6 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$checkHitClientSelected$1(r5));
        return r5;
    L13:
        r5 = false;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public final long h() {
        final long r0 = this.e.addAndGet(1);
        Lazy r2 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$getNextVersion$1(r0));
        return r0;
    }

    public final void l() {
        Lazy r0 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", CardMultiUpdateComponent$rollBack$1.INSTANCE);
        com.bytedance.android.shopping.card_list.yata.interceptor.a r1 = this.d;
        r1.getClass();
        dm.a.a("RollBackImpl").i("rollBack: " + ((Number) r1.a.get().getFirst()).longValue());
        aa6.b r2 = r1.b.get();
        if (r2 == null) goto L5;
        ((AndroidYaTaInstance) r1.c.e.c.invoke()).x(r2, aa6.a.a.b, null, null);
    L5:
        Pair<Long, e> r3 = r1.a.get();
        if (r3 == null) goto L11;
        e r4 = (e) r3.getSecond();
        if (r4 == null) goto L12;
        ((AndroidYaTaInstance) r1.c.e.c.invoke()).x(r4.g(), aa6.a.b.b.b, null, com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r4));
        return;
    L12:
        return;
    }

    public CardMultiUpdateComponent(CardListObjectContainer r3) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        super(r3);
        this.f = r3;
        this.d = new com.bytedance.android.shopping.card_list.yata.interceptor.a(r3);
        this.e = new AtomicLong(0);
    }

    public final com.bytedance.kmp.ec.yata.event.ability.uplink.b d(com.bytedance.kmp.ec.yata.event.ability.uplink.a r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        j r1 = r10.b;
        e r2 = r10.c;
        final boolean r4 = true;
        if (g() == true) goto L6;
        Intrinsics.checkNotNullParameter(r10, "info");
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(true);
    L6:
        Map r11 = r1.b;
        if (r11 == null) goto L9;
        Object r12 = r11.get("uplink_version");
    L10:
        long r5 = com.bytedance.android.ecom.arch.slice.render.util.b.l(r12, Long.MIN_VALUE);
        if (r5 == this.e.get()) goto L15;
        r4 = false;
    L15:
        if ((r2 instanceof e) == true) goto L17;
        r2 = null;
    L17:
        m(r5, r2);
        Lazy r13 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$handleResponse$1(r4));
        return new com.bytedance.kmp.ec.yata.event.ability.uplink.b(r4);
    L9:
        r12 = null;
        goto L10
    }

    public final void j(final boolean r3) {
        Lazy r0 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$onQueryEnd$1(this, r3));
        if (g() == true) goto L5;
        return;
    L5:
        if (r3 == true) goto L8;
        l();
        return;
    }

    public final void k(final boolean r3) {
        Lazy r0 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$onUpdateEnd$1(this, r3));
        if (g() == true) goto L5;
        return;
    L5:
        if (r3 == true) goto L8;
        l();
        return;
    }

    public final boolean i(final long r6, e r8) {
        Lazy r0 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$handleQueryResponse$1(this, r6));
        final boolean r2 = true;
        if (g() == true) goto L6;
        return true;
    L6:
        if (r6 == this.e.get()) goto L9;
        r2 = false;
    L9:
        m(r6, r8);
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$handleQueryResponse$2(this, r2, r6));
        return r2;
    }

    public final void m(final long r7, final e r9) {
        Lazy r0 = CardListCommonLog.a;
        CardListCommonLog.a("card_List_multi_update_impl", new CardMultiUpdateComponent$storeResponseIfVersionNewer$1(r7, r9));
        if (r9 != null) goto L5;
        return;
    L5:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r9) != true) goto L15;
        com.bytedance.android.shopping.card_list.yata.interceptor.a r1 = this.d;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "resp");
        dm.a.a("RollBackImpl").i("onReceiveResponse: " + r7 + ", " + r1.a() + ", " + com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r9));
        if (r7 > r1.a()) goto L10;
        return;
    L10:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r9) == false) goto L17;
        r1.a.getAndSet(new Pair(Long.valueOf(r7), r9));
        return;
    L17:
        return;
    }
}
