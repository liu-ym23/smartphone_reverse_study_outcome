package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.ec.common.api.UpdateLocalViewType;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.w;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.c0;
import com.bytedance.android.livesdk.livecommerce.utils.l;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mj2.j;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends ProductRefreshMessageHandler {
    public final tj2.c c;
    public final c d;
    public final tj2.b e;
    public final tj2.e f;
    public final Function0<List<mj2.c>> g;
    public final Function0<List<j>> h;
    public final Function3<List<String>, Boolean, UpdateLocalViewType, Unit> i;
    public final com.bytedance.android.ec.core.async.b j;
    public final List<rj2.b> k;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;
        public final /* synthetic */ List b;

        public a(d r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            vj2.a r11 = (vj2.a) r10;
            if (r11 != null) goto L5;
            return;
        L5:
            if (((com.bytedance.android.ec.model.g) r11).statusCode != 0) goto L155;
            Map<String, ECPromotion> r0 = r11.c();
            if (r0 == null) goto L12;
            Collection<ECPromotion> r1 = r0.values();
            if (r1 == null) goto L12;
            if ((!r1.isEmpty()) != true) goto L12;
        L18:
            ArrayList r2 = new ArrayList();
            Map<String, w> r3 = r11.d();
            if (r3 == null) goto L28;
            Collection<w> r4 = r3.values();
            if (r4 == null) goto L28;
            ArrayList r5 = new ArrayList();
            Iterator<T> r6 = r4.iterator();
        L24:
            if (r6.hasNext() == false) goto L29;
            ECUIPromotionV2 r7 = c0.a((w) r6.next(), r11.a());
            if (r7 == null) goto L24;
            r5.add(r7);
        L29:
            if (r5 == null) goto L34;
            Iterator<T> r8 = this.a.k.iterator();
        L32:
            if (r8.hasNext() == false) goto L34;
            ((rj2.b) r8.next()).c(r5);
        L34:
            if (r5 == null) goto L63;
            Iterator<T> r9 = r5.iterator();
        L37:
            if (r9.hasNext() == false) goto L63;
            ql.a r12 = (ql.a) r9.next();
            String r13 = r11.a();
            if (r13 == null) goto L41;
            r12.setLogid(r13);
        L41:
            r2.add(r12);
            ql.a r14 = this.a.e.g();
            if (r14 == null) goto L44;
            String r15 = r14.getPromotionId();
        L46:
            if (Intrinsics.areEqual(r12.getPromotionId(), r15) == false) goto L37;
            r12.setExplainType(1);
            Map<String, w> r16 = r11.e();
            if (r16 == null) goto L37;
            Collection<w> r17 = r16.values();
            if (r17 == null) goto L37;
            Iterator<T> r18 = r17.iterator();
        L53:
            if (r18.hasNext() == false) goto L57;
            T r19 = r18.next();
            if (Intrinsics.areEqual(((w) r19).j(), r15) == false) goto L53;
        L58:
            w r20 = (w) r19;
            if (r20 == null) goto L37;
            ECUIPromotionV2 r21 = c0.a(r20, r11.a());
            if (r21 == null) goto L37;
            r21.setExplainType(2);
            r2.add(r21);
            goto L37
        L57:
            r19 = null;
            goto L58
        L44:
            r15 = null;
        L63:
            this.a.c.d(r2);
            List r110 = (List) this.a.g.invoke();
            if (r110 == null) goto L88;
            Iterator<T> r111 = r110.iterator();
        L67:
            if (r111.hasNext() == false) goto L88;
            mj2.c r22 = (mj2.c) r111.next();
            Iterator r23 = r2.iterator();
        L70:
            if (r23.hasNext() == false) goto L74;
            Object r24 = r23.next();
            if (Intrinsics.areEqual(((ql.a) r24).getUniTag(), r22.a.getUniTag()) == false) goto L70;
        L75:
            ql.a r25 = (ql.a) r24;
            if (r25 == null) goto L67;
            rl.a r26 = r22.a.getDynamicSlot();
            if (r22.a.isRelatedInfo() == false) goto L82;
            ql.a r27 = l.a(r25);
            if (r27 == null) goto L86;
            d.g(this.a, r22.a, r27);
            r27.setIronIndex(r22.a.getIronIndex());
            r27.setRealIndex(r22.a.getRealIndex());
            r27.setDynamicRecommendIndex(r22.a.getDynamicRecommendIndex());
            r27.setRelatedInfo(r22.a.isRelatedInfo());
            r27.copyIconDataFromPromotion(r22.a);
            r27.setDynamicSlot(r22.a.getDynamicSlot());
            Intrinsics.checkNotNullParameter(r27, "<set-?>");
            r22.a = r27;
        L86:
            r22.a.setDynamicSlot(r26);
            goto L67
        L82:
            d.g(this.a, r22.a, r25);
            if (r22.a.isRelatedInfo() == false) goto L85;
            r25.setRelatedInfo(r22.a.isRelatedInfo());
            r25.setDynamicRecommendIndex(r22.a.getDynamicRecommendIndex());
        L85:
            Intrinsics.checkNotNullParameter(r25, "<set-?>");
            r22.a = r25;
            goto L86
        L74:
            r24 = null;
        L88:
            if (ECLiveABUtils.INSTANCE.getECOM_LIVE_FIX_PROMOTION_LIST_UPDATE() == false) goto L112;
            List r112 = (List) this.a.h.invoke();
            if (r112 == null) goto L112;
            Iterator<T> r113 = r112.iterator();
        L93:
            if (r113.hasNext() == false) goto L112;
            j r28 = (j) r113.next();
            Iterator r29 = r2.iterator();
        L96:
            if (r29.hasNext() == false) goto L105;
            Object r30 = r29.next();
            if (Intrinsics.areEqual(((ql.a) r30).getUniTag(), r28.b.getUniTag()) == true) goto L100;
        L102:
            boolean r31 = false;
        L103:
            if (r31 == false) goto L96;
        L106:
            ql.a r32 = (ql.a) r30;
            if (r32 == null) goto L109;
            ql.a r33 = l.a(r32);
        L110:
            if (r33 == null) goto L93;
            r33.setIronIndex(r28.b.getIronIndex());
            r33.setRealIndex(r28.b.getRealIndex());
            r33.setRelatedInfo(r28.b.isRelatedInfo());
            r33.setDynamicRecommendIndex(r28.b.getDynamicRecommendIndex());
            r33.copyIconDataFromPromotion(r28.b);
            r33.setDynamicSlot(r28.b.getDynamicSlot());
            Intrinsics.checkNotNullParameter(r33, "<set-?>");
            r28.b = r33;
            goto L93
        L109:
            r33 = null;
            goto L110
        L100:
            if (r28.b.isOnTopExplaining() == true) goto L102;
            r31 = true;
            goto L103
        L105:
            r30 = null;
        L112:
            this.a.i.invoke(this.b, Boolean.FALSE, UpdateLocalViewType.UPDATE_ALL);
            return;
        L28:
            r5 = null;
        L12:
            Map<String, w> r34 = r11.d();
            if (r34 == null) goto L156;
            Collection<w> r35 = r34.values();
            if (r35 != null) goto L17;
            return;
        L17:
            if ((!r35.isEmpty()) == true) goto L18;
            return;
        L156:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final int a() {
        return 1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final int b() {
        return 1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final void d(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "promotionId");
        if (r5 == 3) goto L5;
        List r6 = CollectionsKt.listOf(r4);
        UpdateLocalViewType r7 = UpdateLocalViewType.UPDATE_ALL;
        this.i.invoke(r6, Boolean.FALSE, r7);
        return;
    L5:
        v r8 = new v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        r8.c("promotion_id", r4);
        r8.c("use_new_message", "1");
        r8.c("scene", "promotion_list");
        r8.c("handled", "1");
        r8.i(null);
        List r9 = CollectionsKt.listOf(r4);
        UpdateLocalViewType r10 = UpdateLocalViewType.HOT_ATMOSPHERE;
        this.i.invoke(r9, Boolean.FALSE, r10);
    }

    public static final void g(d r1, ql.a r2, ql.a r3) {
        r1.e.s(CollectionsKt.listOf(r3));
        ql.b r4 = r3.getClientData();
        r4.b = r2.getClientData().b;
        r3.setLocalNum(r2.getLocalNum());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.handler.ProductRefreshMessageHandler
    public final void f(String r5, Map<String, String> r6, List<String> r7, Function1<? super ql.a, Unit> r8, RoomContextController r9) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(r7, "promotionIds");
        if (this.d != null) goto L5;
        return;
    L5:
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r7.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add(new vj2.d(null, (String) r11.next(), null, 5));
        goto L7
    L9:
        com.bytedance.android.ec.core.async.a.a(this.f.c(r5, this.d, r10, r6).subscribe(new a(this, r7), b.a), this.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(c r2, tj2.b r3, tj2.e r4, Function0<? extends List<mj2.c>> r5, Function0<? extends List<j>> r6, Function3<? super List<String>, ? super Boolean, ? super UpdateLocalViewType, Unit> r7, com.bytedance.android.ec.core.async.b r8, List<? extends rj2.b> r9) {
        Intrinsics.checkNotNullParameter(r3, "localDataSource");
        Intrinsics.checkNotNullParameter(r4, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r5, "getCurrentTabData");
        Intrinsics.checkNotNullParameter(r6, "getCurrentRemovedTabData");
        Intrinsics.checkNotNullParameter(r7, "notifyDataChangedCallback");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        Intrinsics.checkNotNullParameter(r9, "refreshDataHandler");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.c = r3.k();
    }
}
