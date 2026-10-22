package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.LivePromotionListBaseSubRepo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.LivePromotionListRepositoryMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c;
import com.bytedance.android.livesdk.livecommerce.room.utils.g;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import mj2.j;
import si2.d0;
import tj2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListRefreshRepository extends LivePromotionListBaseSubRepo implements b {
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a c;
    public final com.bytedance.android.ec.core.async.b d;
    public final tj2.b e;
    public final e f;
    public final g g;
    public final Function0<tj2.a> h;
    public final Function0<qj2.a> i;
    public final List<rj2.b> j;

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.b
    public final void c(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        int r0 = sj2.a.a;
        sj2.a.a("[repo] recv list refresh message, enableHandle=" + this.c.g());
        if (this.c.g() == true) goto L5;
        return;
    L5:
        int r1 = pj2.b.a;
        sg2.b r2 = r10.getCommon();
        if (r2 == null) goto L8;
        String r3 = r2.a;
    L9:
        int r4 = LivePromotionListRepositoryMonitor.c;
        Intrinsics.checkNotNullParameter(r10, "$this$serverTimeGap");
        long r5 = System.currentTimeMillis();
        sg2.b r6 = r10.getCommon();
        if (r6 == null) goto L14;
        TraceTimeMetricV2 r7 = r6.d;
        if (r7 == null) goto L14;
        long r8 = r7.getOpTimestamp();
    L15:
        k(new pj2.a.c("list_refresh_msg", r3, MapsKt.mapOf(TuplesKt.to("server_to_local", String.valueOf(r5 - r8)))));
        LivePromotionListRefreshRepository$onRecvListRefreshMesaage$1 r9 = new LivePromotionListRefreshRepository$onRecvListRefreshMesaage$1(this, r10);
        q r11 = q.a;
        if (r10.updateTimeStamp < r11.getLong("ec_product_list_refresh_timestamp", 0)) goto L19;
        r9.invoke();
        r11.e("ec_product_list_refresh_timestamp", r10.updateTimeStamp);
        return;
    L19:
        return;
    L14:
        r8 = 0;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    public final void m(final int r10, final Function0<Unit> r11) {
        c r0 = this.c.h();
        if (r0 == null) goto L6;
        final c r2 = c.a(r0);
        r2.b = "";
        r2.a = 1;
        this.f.d(r2, r0.u, 2, true, this.d, new LivePromotionListRefreshRepository$updateCompleteDate$$inlined$also$lambda$1(r2, this, r10, r11), new LivePromotionListRefreshRepository$updateCompleteDate$$inlined$also$lambda$2(this, r10, r11));
        return;
    }

    public LivePromotionListRefreshRepository(com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a r2, com.bytedance.android.ec.core.async.b r3, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r4, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.b r5, g r6, Function0 r7, Function0 r8, List r9) {
        Intrinsics.checkNotNullParameter(r2, "repoContext");
        Intrinsics.checkNotNullParameter(r3, "disposableScope");
        Intrinsics.checkNotNullParameter(r4, "localDataSource");
        Intrinsics.checkNotNullParameter(r5, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r6, "scatterManager");
        Intrinsics.checkNotNullParameter(r7, "fragmentCallback");
        Intrinsics.checkNotNullParameter(r8, "listStateProvider");
        Intrinsics.checkNotNullParameter(r9, "refreshDataHandlers");
        super(r2);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }

    public static final void l(LivePromotionListRefreshRepository r12, boolean r13, int r14, c r15, mj2.e r16, String r17, int r18, int r19, boolean r20, boolean r21) {
        Pair<List<ql.a>, List<j>> r3 = r12.e.q(r17, r15.h, r16, r18);
        List<? extends ql.a> r5 = (List) r3.component1();
        List<j> r9 = (List) r3.component2();
        Iterator<T> r4 = r12.j.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((rj2.b) r4.next()).d(r5, r9);
        goto L4
    L6:
        r12.e.j(r17, r5, r18, (r18 + r19) - 1, r16.i, r9);
        if (r13 == false) goto L9;
        r15.d = r20;
        r12.i(r14, Integer.valueOf(r18));
    L9:
        tj2.a r6 = (tj2.a) r12.h.invoke();
        if (r6 == null) goto L12;
        r6.notifyTotalChanged(r16.h);
    L12:
        PromotionCategory.Companion.getClass();
        if (PromotionCategory.a.b(r17) == true) goto L16;
        if (r21 == true) goto L16;
        return;
    L16:
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == true) goto L24;
        tj2.a r7 = (tj2.a) r12.h.invoke();
        if (r7 == null) goto L24;
        ECPromotionListTopData r8 = r16.l;
        if (r8 == null) goto L22;
        List r10 = r8.getInteractionData();
    L23:
        tj2.a.C0175a.a(r7, r10, true, false, 12);
        goto L24
    L22:
        r10 = null;
    L24:
        if (r18 == 0) goto L26;
        if (r21 == true) goto L26;
        return;
    L26:
        LivePromotionListCacheCenter r0 = r12.h().F;
        if (r0 == null) goto L33;
        Handler r11 = k.a;
        r0.i(r15, r16, SystemClock.elapsedRealtime());
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.b
    public final void b(final int r22, final Integer r23, final String r24, boolean r25, final int r26, final boolean r27, boolean r28, final boolean r29, final d0 r30, final Function0<Unit> r31) {
        String r11 = r24;
        this.c.f().l(r11, r28);
        PromotionCategory.Companion.getClass();
        boolean r12 = true;
        if (PromotionCategory.a.b(r24) == false) goto L8;
        if (r22 != 1) goto L8;
        LivePromotionListCacheCenter r0 = h().F;
        if (r0 == null) goto L8;
        r0.e();
    L8:
        PromotionCategory r1 = this.e.b();
        String r2 = null;
        if (r1 == null) goto L11;
        String r3 = r1.getUniqueIndex();
    L13:
        if (r3 != null) goto L15;
        final String r8 = "";
    L16:
        final c r10 = this.c.h();
        if (r10 != null) goto L19;
        return;
    L19:
        final Ref.IntRef r7 = new Ref.IntRef();
        r7.element = r10.u;
        if (r25 == true) goto L27;
        tj2.b r4 = this.e;
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        r4.j(r11, CollectionsKt.emptyList(), 0, r7.element, -1, CollectionsKt.emptyList());
        i(1, null);
        return;
    L27:
        if (Intrinsics.areEqual(r8, r11) == false) goto L53;
        final c r5 = c.a(r10);
        r5.b = r11;
        r5.a = r22;
        int r6 = r7.element;
        if (r6 == 0) goto L31;
        int r9 = (r26 / r6) * r6;
    L32:
        final int r13 = RangesKt.coerceAtLeast(r9, 0);
        int r14 = r7.element;
        if ((((r13 + r14) - 1) - r26) >= 10) goto L35;
        r7.element = r14 + 10;
    L35:
        if (r29 == false) goto L37;
    L41:
        boolean r15 = true;
    L42:
        int r16 = pj2.b.a;
        int r17 = pj2.c.a;
        if (r30 == null) goto L47;
        sg2.b r18 = r30.getCommon();
        if (r18 == null) goto L47;
        r2 = r18.a;
    L47:
        k(new pj2.a.b("page_req", r2, MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_tab_index", r8), TuplesKt.to("all_panel_data", String.valueOf(r15))})));
        g r19 = this.g;
        String r20 = "update_product_list_" + r11;
        if (r22 != 10) goto L51;
        r12 = false;
    L51:
        final boolean r21 = r15;
        r19.c(r20, 0, r12, new LivePromotionListRefreshRepository$refreshCategoryProductList$1(this, r5, r13, r7, r23, r21, r30, r8, r22, r10, r24, r27, r29, r31, r26));
        return;
    L37:
        if (PromotionCategory.a.b(r5.b) == false) goto L40;
        if (r13 == 0) goto L41;
    L40:
        r15 = false;
        goto L42
    L31:
        r9 = 0;
        goto L32
    L53:
        if (PromotionCategory.a.b(r24) == false) goto L57;
        final String r32 = r8;
        Function0<Unit> r33 = new LivePromotionListRefreshRepository$refreshCategoryProductList$2(this, r10, r24, r22, r30, r32, r7, r27, r29, r31, r23);
        int r34 = g.c;
        this.g.c("update_product_list_" + r11, 0, true, r33);
        return;
    L57:
        return;
    L15:
        r8 = r3;
        goto L16
    L11:
        r3 = null;
        goto L13
    }
}
