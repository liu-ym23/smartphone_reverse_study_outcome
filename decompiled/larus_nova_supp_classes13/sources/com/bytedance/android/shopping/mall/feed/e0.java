package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.prebind.ECHybridRecyclerViewPreBindHelper;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 implements yj.b {
    public final /* synthetic */ ECMallFeed a;

    public static final class a implements Runnable {
        public final /* synthetic */ e0 a;

        public a(e0 r1) {
            this.a = r1;
        }

        public final void a() {
            ECMallFeed r0 = this.a.a;
            int r1 = ECMallFeed.I1;
            r0.getClass();
            com.bytedance.android.shopping.mall.opt.h r2 = com.bytedance.android.shopping.mall.opt.h.a;
            if (r2.a(r0.B1.c) == false) goto L38;
            ECHybridListEngine r3 = r0.J;
            if (r3 == null) goto L38;
            ECHybridRecyclerView r4 = r3.b;
            if (r4 == null) goto L38;
            r0.L0 = new com.bytedance.android.ec.hybrid.list.prebind.a(r4);
        L38:
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L30
            Map<String, Integer> r6 = r2.c();     // Catch: Throwable -> L30
            if (r6 == null) goto L27;
            Set<String> r7 = r6.keySet();     // Catch: Throwable -> L30
            if (r7 == null) goto L27;
            Iterator<T> r8 = r7.iterator();     // Catch: Throwable -> L30
        L15:
            if (r8.hasNext() == false) goto L26;
            String r9 = (String) r8.next();     // Catch: Throwable -> L30
            Integer r10 = r2.c().get(r9);     // Catch: Throwable -> L30
            if (r9 == null) goto L15;
            if (r10 == null) goto L15;
            int r11 = r10.intValue();     // Catch: Throwable -> L30
            com.bytedance.android.ec.hybrid.list.prebind.a r12 = r0.L0;     // Catch: Throwable -> L30
            if (r12 == null) goto L15;
            int r13 = CastIntegerProtector.parseInt(r9);     // Catch: Throwable -> L30
            Long r14 = r2.b();     // Catch: Throwable -> L30
            if (r14 == null) goto L24;
            long r15 = r14.longValue();     // Catch: Throwable -> L30
        L25:
            r12.a(r13, r11, r15);     // Catch: Throwable -> L30
            goto L15
        L24:
            r15 = 0;
            goto L25
        L26:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L30
        L28:
            Result.constructor-impl(r16);     // Catch: Throwable -> L30
        L32:
            Iterator<T> r17 = this.a.a.k1.iterator();
        L34:
            if (r17.hasNext() == false) goto L36;
            ((e93.e) r17.next()).onFirstScreen();
            goto L34
        L36:
            ECMallFeed.c(this.a.a);
            return;
        L27:
            r16 = null;
        L30:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L32
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        yj.b r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public e0(ECMallFeed r1) {
        this.a = r1;
    }

    public final void a(long r8, long r10, com.bytedance.android.ec.hybrid.list.util.d r12) {
        Intrinsics.checkNotNullParameter(r12, "lynxLoadResult");
        yj.b r1 = this.a.d;
        if (r1 == null) goto L6;
        r1.a(r8, r10, r12);
    L6:
        if (Intrinsics.areEqual(r12.k, "cache") == false) goto L9;
        this.a.c0("fmp", null);
        return;
    L9:
        ECMallFeed r9 = this.a;
        r9.p0 = true;
        int r11 = s93.c.a;
        boolean r13 = false;
        Object r14 = 0;
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 == null) goto L17;
        yj.g r2 = r0.getHostAB();
        if (r2 == null) goto L17;
        Object r3 = r2.a("mall_tab_opt_async_or_disperse", r14);
        if (r3 == null) goto L17;
        r14 = r3;
    L17:
        Lazy r4 = ECMallLogUtil.a;
        com.bytedance.android.ec.hybrid.log.mall.c.a r5 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r5, "Key : mall_tab_opt_async_or_disperse, Value: " + r14);
        if (((Number) r14).intValue() != 1) goto L20;
        boolean r15 = true;
    L21:
        ECMallFeed.g0(r9, new ECMallFeed$reportPendingEvent$1(r9, r15));
        ECMallFeed r16 = this.a;
        if (r16.B1.o == false) goto L24;
        r16.j();
    L24:
        ECMallFeed.e(this.a);
        if (this.a.A() == 0) goto L40;
        ECHybridRecyclerViewPreBindHelper r17 = this.a.K0;
        if (r17 == null) goto L40;
        Object r18 = 0;
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L36;
        yj.g r7 = r6.getHostAB();
        if (r7 == null) goto L36;
        Object r19 = r7.a("mall_tab_opt_async_or_disperse", r18);
        if (r19 == null) goto L36;
        r18 = r19;
    L36:
        ECMallLogUtil.c(r5, "Key : mall_tab_opt_async_or_disperse, Value: " + r18);
        if (((Number) r18).intValue() != 1) goto L39;
        r13 = true;
    L39:
        ECHybridRecyclerViewPreBindHelper.d(r17, true, null, Boolean.valueOf(r13), 26);
    L40:
        this.a.i.post(new a(this));
        Function0<Unit> r20 = this.a.i1;
        if (r20 == null) goto L43;
        Unit r21 = (Unit) r20.invoke();
    L43:
        ECMallFeed r22 = this.a;
        r22.i1 = null;
        com.bytedance.android.shopping.mall.feed.help.d r23 = (com.bytedance.android.shopping.mall.feed.help.d) r22.t0.getValue();
        if (r23 == null) goto L46;
        r23.b(true);
    L46:
        ECMallFeed r24 = this.a;
        if (Intrinsics.areEqual(r24.B1.c, MallPageName.X_TAB_MALL) == false) goto L49;
    L50:
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getHybridECSdkService().g();
    L51:
        this.a.c0("tti", null);
        ECHybridListEngine r25 = this.a.J;
        if (r25 == null) goto L61;
        ECHybridListAdapter r26 = r25.a;
        if (r26 == null) goto L61;
        HashSet r27 = r26.d;
        if (r27 == null) goto L61;
        Iterator r28 = r27.iterator();
    L59:
        if (r28.hasNext() == false) goto L61;
        ((BaseViewHolder) r28.next()).c4();
    L61:
        ECHybridListEngine r29 = this.a.J;
        if (r29 == null) goto L68;
        com.bytedance.android.ec.hybrid.list.ability.n r30 = (com.bytedance.android.ec.hybrid.list.ability.n) r29.getAbility(com.bytedance.android.ec.hybrid.list.ability.n.class);
        if (r30 == null) goto L69;
        r30.kr("ec.firstScreenEnd", Collections.emptyMap());
        return;
    L69:
        return;
    L68:
        return;
    L49:
        if (Intrinsics.areEqual(r24.B1.c, "order_homepage") == false) goto L51;
    L20:
        r15 = false;
        goto L21
    }
}
