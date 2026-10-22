package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.ErrorType;
import com.bytedance.android.livesdk.livecommerce.base.paging.PageListLoadStatus;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.LivePromotionPageCategoryData;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import mj2.h;
import mj2.j;
import org.json.JSONArray;
import org.json.JSONObject;
import sg2.v;
import tj2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/repository/datasource/LivePromotionListPagingDataSource;", "Landroidx/paging/PositionalDataSource;", "Lmj2/c;", "Ltj2/d;", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListPagingDataSource extends PositionalDataSource<mj2.c> implements tj2.d {
    public static final /* synthetic */ int p = 0;
    public final DisposableScope a;
    public int b;
    public int c;
    public int d;
    public List<j> e;
    public Function0<Unit> f;
    public Function0<Unit> g;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c h;
    public final tj2.b i;
    public final tj2.e j;
    public final Function0<Integer> k;
    public final Function0<List<ql.a>> l;
    public final Function0<g> m;
    public final com.bytedance.android.ec.core.async.b n;
    public final RoomContextController o;

    public static final class a implements DataSource.InvalidatedCallback {
        public final /* synthetic */ LivePromotionListPagingDataSource a;

        public a(LivePromotionListPagingDataSource r1) {
            this.a = r1;
        }

        public final void onInvalidated() {
            LivePromotionListPagingDataSource r0 = this.a;
            r0.f = null;
            r0.g = null;
            r0.a.clearDisposable();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LivePromotionListPagingDataSource a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ PositionalDataSource.LoadInitialCallback e;

        public c(LivePromotionListPagingDataSource r1, int r2, int r3, int r4, PositionalDataSource.LoadInitialCallback r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r7) {
            LivePromotionListPagingDataSource r0 = this.a;
            LivePromotionListPagingDataSource.e(r0, (vj2.b) r7, this.b, this.c, this.d, this.e);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LivePromotionListPagingDataSource a;
        public final /* synthetic */ int b;

        public d(LivePromotionListPagingDataSource r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            CronetIOException r7 = (Throwable) r6;
            if (EComABUtils.isArsEnable() == true) goto L5;
        L12:
            LivePromotionListPagingDataSource r8 = this.a;
            int r0 = this.b;
            int r1 = LivePromotionListPagingDataSource.p;
            r8.j(r0);
            return;
        L5:
            if ((r7 instanceof CronetIOException) == true) goto L7;
            CronetIOException r2 = null;
        L8:
            CronetIOException r3 = r2;
            if (r3 == null) goto L11;
            int r4 = LivePromotionListPagingDataSource.p;
            this.a.n(r3.getTraceCode(), Integer.valueOf(r3.getStatusCode()), "RequestPageData CornetIOException, " + r7);
            goto L12
        L11:
            int r5 = LivePromotionListPagingDataSource.p;
            this.a.n(null, null, "RequestPageData Exception, " + r7);
            goto L12
        L7:
            r2 = r7;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LivePromotionListPagingDataSource a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Ref.IntRef e;
        public final /* synthetic */ PositionalDataSource.LoadRangeParams f;
        public final /* synthetic */ PositionalDataSource.LoadRangeCallback g;
        public final /* synthetic */ Ref.BooleanRef h;

        public e(LivePromotionListPagingDataSource r1, Ref.IntRef r2, boolean r3, int r4, Ref.IntRef r5, PositionalDataSource.LoadRangeParams r6, PositionalDataSource.LoadRangeCallback r7, Ref.BooleanRef r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r20) {
            vj2.b r1 = (vj2.b) r20;
            if (((com.bytedance.android.ec.model.g) r1).statusCode != 0) goto L57;
            int r2 = mj2.e.y;
            mj2.e r9 = mj2.e.a.a(r1);
            LivePromotionListPagingDataSource r3 = this.a;
            tj2.b r4 = r3.i;
            com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r5 = r3.h;
            Pair<List<ql.a>, List<j>> r6 = r4.q(r5.b, r5.h, r9, this.b.element);
            List r7 = (List) r6.getFirst();
            if (this.b.element != 0) goto L8;
            LivePromotionListPagingDataSource r8 = this.a;
            List<j> r10 = (List) r6.getSecond();
            r8.getClass();
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r8.e = r10;
        L8:
            if (EComABUtils.getAdaptProductBlockSwitch() == false) goto L28;
            if (this.c == false) goto L15;
            if (r9.i < 0) goto L16;
        L17:
            boolean r11 = false;
        L19:
            if (r7.isEmpty() == false) goto L51;
            if (r11 == true) goto L51;
            int r12 = this.d;
            if (r12 > 20) goto L51;
            if (this.c == false) goto L26;
            LivePromotionListPagingDataSource r13 = this.a;
            r13.c = (this.b.element + this.e.element) - 1;
            r13.d = r9.i;
            r13.l(this.f, this.g, r12 + 1);
            return;
        L26:
            LivePromotionListPagingDataSource r14 = this.a;
            r14.b = this.b.element;
            r14.l(this.f, this.g, r12 + 1);
            return;
        L51:
            LivePromotionListPagingDataSource r15 = this.a;
            tj2.b r16 = r15.i;
            boolean r17 = this.c;
            int r18 = RangesKt.coerceAtMost(this.b.element, r15.b);
            int r19 = this.b.element;
            LivePromotionListPagingDataSource r21 = this.a;
            String r22 = r21.h.b;
            r16.o(false, r17, r18, r19, false, r7, r21.l);
            LivePromotionListPagingDataSource r110 = this.a;
            LivePromotionListPagingDataSource.f(r110, this.c, true, r11, RangesKt.coerceAtMost(this.b.element, r110.b), RangesKt.coerceAtLeast(this.a.c, (this.b.element + this.e.element) - 1), r9.i);
            this.h.element = true;
            LivePromotionListPagingDataSource r23 = this.a;
            PositionalDataSource.LoadRangeCallback r24 = this.g;
            List r25 = r7;
            ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
            Iterator<T> r27 = r25.iterator();
        L53:
            if (r27.hasNext() == false) goto L55;
            r26.add(new mj2.c((ql.a) r27.next()));
            goto L53
        L55:
            r23.getClass();
            LivePromotionListPagingDataSource.m(r24, r26);
            LivePromotionListPagingDataSource r28 = this.a;
            com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r29 = r28.h;
            LivePromotionListPagingDataSource.g(r28, false, r29.b, null, r29.a, this.b.element, r9);
            int r30 = zg2.a.a;
            com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r31 = this.a.h;
            zg2.a.a(r31.h, r31.j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(1))}));
            return;
        L16:
            r11 = true;
            goto L19
        L15:
            if (this.b.element > 0) goto L17;
        L28:
            if (r7.isEmpty() == false) goto L30;
        L41:
            r11 = true;
        L43:
            if (r7.isEmpty() == false) goto L51;
            if (r11 == true) goto L51;
            int r32 = this.d;
            if (r32 > 5) goto L51;
            if (this.c == false) goto L50;
            LivePromotionListPagingDataSource r33 = this.a;
            r33.c = (this.b.element + this.e.element) - 1;
            r33.d = r9.i;
            r33.l(this.f, this.g, r32 + 1);
            return;
        L50:
            LivePromotionListPagingDataSource r34 = this.a;
            r34.b = this.b.element;
            r34.l(this.f, this.g, r32 + 1);
            return;
        L30:
            if (this.c == false) goto L35;
            if (r9.i < 0) goto L36;
        L37:
            boolean r35 = false;
        L38:
            if (r35 == true) goto L41;
            r11 = false;
        L36:
            r35 = true;
            goto L38
        L35:
            if (this.b.element > 0) goto L37;
        L57:
            if (this.c == false) goto L59;
            this.a.g = new LivePromotionListPagingDataSource$loadRange$1$2(this);
        L60:
            LivePromotionListPagingDataSource r36 = this.a;
            LivePromotionListPagingDataSource.f(r36, this.c, false, false, r36.b, r36.c, r36.d);
            return;
        L59:
            this.a.f = new LivePromotionListPagingDataSource$loadRange$1$3(this);
            goto L60
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LivePromotionListPagingDataSource a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ PositionalDataSource.LoadRangeParams d;
        public final /* synthetic */ PositionalDataSource.LoadRangeCallback e;

        public f(LivePromotionListPagingDataSource r1, Ref.BooleanRef r2, boolean r3, PositionalDataSource.LoadRangeParams r4, PositionalDataSource.LoadRangeCallback r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            if (this.b.element == false) goto L5;
        L8:
            LivePromotionListPagingDataSource r2 = this.a;
            LivePromotionListPagingDataSource.f(r2, this.c, false, false, r2.b, r2.c, r2.d);
            com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r0 = this.a.h;
            if (r0.l == false) goto L17;
            int r1 = RoomContextController.h;
            ECContext r3 = RoomContextController.a.b(r0.h, r0.j).r();
            if (r3 == null) goto L17;
            i<ECLivePerformanceMonitor> r4 = r3.getEcLivePerformanceMonitor();
            if (r4 == null) goto L17;
            ECLivePerformanceMonitor r5 = (ECLivePerformanceMonitor) r4.getValue();
            if (r5 == null) goto L17;
            ECLivePerformanceMonitor.A(r5, false, BDLocationException.ERROR_BEACON_ADVERTISING, null, 12);
        L17:
            dm.a.a("live_promotion_list_paging_data_source").b("error occur when loading range", r11);
            return;
        L5:
            if (this.c == false) goto L7;
            LivePromotionListPagingDataSource r6 = this.a;
            r6.g = new LivePromotionListPagingDataSource$loadRange$2$1(this);
            goto L8
        L7:
            LivePromotionListPagingDataSource r7 = this.a;
            r7.f = new LivePromotionListPagingDataSource$loadRange$2$2(this);
            goto L8
        }
    }

    static {
    }

    @Override // tj2.d
    public final void refresh() {
        this.g = null;
        this.f = null;
        invalidate();
    }

    public final PromotionListController h() {
        PromotionListController.a r0 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1 = this.h;
        String r2 = r1.h;
        String r3 = r1.j;
        r0.getClass();
        PromotionListController r4 = PromotionListController.a.c(r2, r3);
        if (r4.x() == false) goto L5;
        return r4;
    L5:
        return null;
    }

    @Override // tj2.d
    public final int b() {
        return this.c;
    }

    @Override // tj2.d
    public final int c() {
        return this.d;
    }

    @Override // tj2.d
    public final List<j> d() {
        return this.e;
    }

    @Override // tj2.d
    public final int getStartPosition() {
        return this.b;
    }

    @Override // tj2.d
    public final void a(boolean r2) {
        if (r2 == false) goto L8;
        Function0<Unit> r3 = this.g;
        if (r3 == null) goto L7;
        Unit r4 = (Unit) r3.invoke();
    L7:
        this.g = null;
        return;
    L8:
        Function0<Unit> r5 = this.f;
        if (r5 == null) goto L11;
        Unit r6 = (Unit) r5.invoke();
    L11:
        this.f = null;
    }

    public final void j(int r9) {
        o(r9, false, false, false, this.b, this.c, this.d);
    }

    public static void m(PositionalDataSource.LoadRangeCallback r4, List r5) {
        dm.a.a("live_promotion_list_paging_data_source").a("loadRangeOnResult promotions = " + r5.size());     // Catch: Throwable -> L5
        r4.onResult(r5);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ECExceptionMonitor.f(th, "LoadRangeCallback.onResult error occurs");
        dm.a.a("live_promotion_list_paging_data_source").b("LoadRangeCallback.onResult error occurs", th);
    }

    public final void loadInitial(PositionalDataSource.LoadInitialParams r19, final PositionalDataSource.LoadInitialCallback<mj2.c> r20) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        final int r7 = this.h.a;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1 = this.h;
        final int r8 = r1.c;
        r1.c = 0;
        if (r1.l == false) goto L9;
        int r2 = RoomContextController.h;
        ECContext r3 = RoomContextController.a.b(r1.h, r1.j).r();
        if (r3 == null) goto L9;
        i<ECLivePerformanceMonitor> r4 = r3.getEcLivePerformanceMonitor();
        if (r4 == null) goto L9;
        ECLivePerformanceMonitor r10 = (ECLivePerformanceMonitor) r4.getValue();
    L10:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r5 = this.h;
        final int r14 = r5.u;
        int r6 = xh2.c.a;
        if (r7 == 0) goto L19;
        if (r7 == 6) goto L19;
        if (r7 == 3) goto L19;
        if (r7 == 9) goto L19;
        boolean r9 = false;
    L20:
        if (r9 == true) goto L29;
        String r11 = r5.b;
        PromotionCategory.Companion.getClass();
        if (PromotionCategory.a.b(r11) == false) goto L25;
        if (r8 != 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == true) goto L29;
        boolean r16 = false;
    L30:
        if (r7 == 0) goto L32;
        if (r7 == 6) goto L32;
    L102:
        tj2.b r13 = this.i;
        String r15 = this.h.b;
        if (r15 != null) goto L105;
        r15 = "";
    L105:
        LivePromotionListTabPromotionData r17 = r13.n(r15);
        if (r17 != null) goto L108;
    L150:
        g r18 = (g) this.m.invoke();
        if (r18 == null) goto L153;
        r18.updateLoadMoreStatus(PageListLoadStatus.LoadMoreSuccess, true);
    L153:
        g r21 = (g) this.m.invoke();
        if (r21 == null) goto L156;
        r21.updateLoadMoreStatus(PageListLoadStatus.LoadMoreSuccess, false);
    L156:
        g r22 = (g) this.m.invoke();
        if (r22 == null) goto L160;
        r22.updateLoadInitialStatus(new h(r7, PageListLoadStatus.Initialize, false));
    L160:
        if (EComABUtils.listRequestTimeOpt() == false) goto L168;
        PromotionListController.a r23 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r24 = this.h;
        String r25 = r24.h;
        String r26 = r24.j;
        r23.getClass();
        if (PromotionListController.a.c(r25, r26).M == false) goto L168;
        if (r7 != 0) goto L168;
        PromotionCategory.a r27 = PromotionCategory.Companion;
        String r28 = this.h.b;
        r27.getClass();
        if (PromotionCategory.a.b(r28) == false) goto L168;
        if (r8 != 0) goto L168;
        return;
    L168:
        if (r7 != 0) goto L171;
        if (r10 == null) goto L171;
        ECLivePerformanceMonitor.b r29 = ECLivePerformanceMonitor.x;
        r10.n(false);
    L171:
        com.bytedance.android.ec.core.async.a.a(tj2.e.a.a(this.j, this.h, r8, r14, 1, r16).observeOn(Schedulers.io()).subscribe(new c(this, r8, r7, r14, r20), new d(this, r7)), this.a);
        return;
    L108:
        if (r17.b == 0) goto L112;
        if ((!r17.a.isEmpty()) == true) goto L112;
    L116:
        boolean r30 = false;
    L117:
        if (r30 == false) goto L119;
        LivePromotionListTabPromotionData r31 = r17;
    L120:
        if (r31 == null) goto L150;
        if (r31.b != 0) goto L124;
        List<j> r32 = r31.e;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        this.e = r32;
    L124:
        tj2.b r110 = this.i;
        int r33 = r31.b;
        String r34 = this.h.b;
        r110.o(true, false, r33, r8, false, r31.a, this.l);
        List<? extends ql.a> r35 = r31.a;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r37 = r35.iterator();
    L126:
        if (r37.hasNext() == false) goto L128;
        r36.add(new mj2.c((ql.a) r37.next()));
        goto L126
    L128:
        k(r20, r36, r31.b);
        boolean r0 = !r31.a.isEmpty();
        List<? extends ql.a> r38 = r31.a;
        if ((r38 instanceof Collection) == true) goto L131;
    L133:
        Iterator<T> r39 = r38.iterator();
    L135:
        if (r39.hasNext() == false) goto L139;
        if (((ql.a) r39.next()).isOnTopExplaining() == false) goto L135;
        boolean r40 = true;
    L140:
        LivePromotionListTabPromotionData r41 = r31;
        o(r7, true, r0, r40, r31.b, r31.c, r31.d);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_API_ERROR_REPORT() == true) goto L143;
        return;
    L143:
        if (r41.a.isEmpty() == false) goto L179;
        uj2.a r42 = (uj2.a) CollectionsKt.lastOrNull(uj2.b.a.snapshot().values());
        if (r42 == null) goto L147;
        r42.a.c("from_cache", "1");
    L147:
        if (r42 == null) goto L180;
        Intrinsics.checkNotNullParameter("no_goods", LocationMonitorConst.TYPE);
        r42.a.c("error_type", "no_goods");
        r42.a.i(null);
        return;
    L180:
        return;
    L179:
        return;
    L139:
        r40 = false;
        goto L140
    L131:
        if (r38.isEmpty() == false) goto L133;
    L119:
        r31 = null;
    L112:
        if (r17.b > r8) goto L116;
        if (r17.c < ((r8 + r14) - 1)) goto L116;
        r30 = true;
    L32:
        PromotionCategory.a r43 = PromotionCategory.Companion;
        String r44 = this.h.b;
        r43.getClass();
        if (PromotionCategory.a.b(r44) == false) goto L102;
        if (r8 != 0) goto L102;
        if (r7 != 0) goto L97;
        if (r10 == null) goto L40;
        r10.u("ec_perf_duration_promotion_list", "create_fragment_end", null);
        String r45 = r10.r;
        if (r45 == null) goto L40;
        Map r46 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r45, MetricNames.METRIC_CREATE_FRAGMENT_DURATION);
    L40:
        PromotionListController r47 = h();
        if (r47 == null) goto L62;
        LivePromotionListCacheCenter r48 = r47.F;
        if (r48 == null) goto L62;
        mj2.e r49 = r48.j(this.h);
        if (r49 == null) goto L62;
        List<? extends ql.a> r50 = r49.a;
        if (r50 != null) goto L49;
    L51:
        boolean r51 = false;
    L52:
        if (r51 == false) goto L54;
        mj2.e r52 = r49;
    L55:
        if (r52 == null) goto L62;
        PromotionListController.a r53 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r54 = this.h;
        String r55 = r54.h;
        String r56 = r54.j;
        r53.getClass();
        if (PromotionListController.a.c(r55, r56).j != 1) goto L59;
        int r57 = com.bytedance.android.livesdk.livecommerce.opt.d.a;
        com.bytedance.android.livesdk.livecommerce.opt.d.a("list_use_preload_data", this.h.h, null, this.o.l());
    L59:
        i(r52, r8, r7, r14, r20);
        return;
    L54:
        r52 = null;
        goto L55
    L49:
        if ((!r50.isEmpty()) != true) goto L51;
        r51 = true;
    L62:
        if (EComABUtils.listRequestTimeOpt() == false) goto L150;
        PromotionListController.a r58 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r59 = this.h;
        String r60 = r59.h;
        String r61 = r59.j;
        r58.getClass();
        if (PromotionListController.a.c(r60, r61).M == false) goto L150;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r62 = this.h;
        Object r111 = PromotionListController.a.c(r62.h, r62.j).N;
        monitor-enter(r111);
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r63 = this.h;     // Catch: Throwable -> L94
        if (PromotionListController.a.c(r63.h, r63.j).M == false) goto L70;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r64 = this.h;     // Catch: Throwable -> L94
        PromotionListController r112 = PromotionListController.a.c(r64.h, r64.j);     // Catch: Throwable -> L94
        Function1 r65 = new LivePromotionListPagingDataSource$loadInitial$$inlined$synchronized$lambda$1(this, r8, r7, r14, r20);     // Catch: Throwable -> L94
        r112.getClass();     // Catch: Throwable -> L94
        Intrinsics.checkNotNullParameter(r65, "<set-?>");     // Catch: Throwable -> L94
        r112.O = r65;     // Catch: Throwable -> L94
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r66 = this.h;     // Catch: Throwable -> L94
        PromotionListController r113 = PromotionListController.a.c(r66.h, r66.j);     // Catch: Throwable -> L94
        Function0<Unit> r114 = new LivePromotionListPagingDataSource$loadInitial$$inlined$synchronized$lambda$2(this, r8, r7, r14, r20);     // Catch: Throwable -> L94
        r113.getClass();     // Catch: Throwable -> L94
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Throwable -> L94
        r113.P = r114;     // Catch: Throwable -> L94
        Unit r67 = Unit.INSTANCE;     // Catch: Throwable -> L94
    L92:
        monitor-exit(r111);
        goto L150
    L70:
        PromotionListController r68 = h();     // Catch: Throwable -> L94
        if (r68 == null) goto L92;
        LivePromotionListCacheCenter r69 = r68.F;     // Catch: Throwable -> L94
        if (r69 == null) goto L92;
        mj2.e r70 = r69.j(this.h);     // Catch: Throwable -> L94
        if (r70 == null) goto L92;
        List<? extends ql.a> r71 = r70.a;     // Catch: Throwable -> L94
        if (r71 != null) goto L79;
    L81:
        boolean r72 = false;
    L82:
        if (r72 == false) goto L84;
        mj2.e r73 = r70;
    L85:
        if (r73 == null) goto L92;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r74 = this.h;     // Catch: Throwable -> L94
        if (PromotionListController.a.c(r74.h, r74.j).j != 1) goto L89;
        int r75 = com.bytedance.android.livesdk.livecommerce.opt.d.a;     // Catch: Throwable -> L94
        com.bytedance.android.livesdk.livecommerce.opt.d.a("list_use_preload_data", this.h.h, null, this.o.l());     // Catch: Throwable -> L94
    L89:
        i(r73, r8, r7, r14, r20);     // Catch: Throwable -> L94
        monitor-exit(r111);
        return;
    L84:
        r73 = null;
        goto L85
    L79:
        if ((!r71.isEmpty()) != true) goto L81;
        r72 = true;
    L94:
        th = move-exception;
        throw th;
    L97:
        if (r7 != 6) goto L150;
        mj2.e r76 = this.i.r();
        if (r76 == null) goto L150;
        i(r76, r8, r7, r14, r20);
        return;
    L25:
        r12 = false;
    L29:
        r16 = true;
    L19:
        r9 = true;
    L9:
        r10 = null;
        goto L10
    }

    public final void loadRange(PositionalDataSource.LoadRangeParams r2, PositionalDataSource.LoadRangeCallback<mj2.c> r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        l(r2, r3, 0);
    }

    public static void k(PositionalDataSource.LoadInitialCallback r4, List r5, int r6) {
        dm.a.a("live_promotion_list_paging_data_source").a("loadInitialOnResult promotions = " + ((ArrayList) r5).size() + " position = " + r6);     // Catch: Throwable -> L5
        r4.onResult(r5, r6);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ECExceptionMonitor.f(th, "LoadInitialCallback.onResult error occurs");
        dm.a.a("live_promotion_list_paging_data_source").b("LoadInitialCallback.onResult error occurs", th);
    }

    public final void l(PositionalDataSource.LoadRangeParams r21, PositionalDataSource.LoadRangeCallback<mj2.c> r22, int r23) {
        if (r21.startPosition < ((Number) this.k.invoke()).intValue()) goto L5;
        boolean r12 = true;
    L6:
        Ref.IntRef r4 = new Ref.IntRef();
        r4.element = 0;
        Ref.IntRef r5 = new Ref.IntRef();
        r5.element = 0;
        if (r12 == false) goto L17;
        if (this.d >= 0) goto L12;
        m(r22, CollectionsKt.emptyList());
        return;
    L12:
        g r0 = (g) this.m.invoke();
        if (r0 == null) goto L15;
        r0.updateLoadMoreStatus(PageListLoadStatus.LoadMoreIn, true);
    L15:
        r4.element = this.d;
        r5.element = r21.loadSize;
    L24:
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        r13.element = false;
        boolean r3 = r12;
        com.bytedance.android.ec.core.async.a.a(tj2.e.a.a(this.j, this.h, r4.element, r5.element, 1, false).observeOn(Schedulers.io()).subscribe(new e(this, r4, r3, r23, r5, r21, r22, r13), new f(this, r13, r3, r21, r22)), this.a);
        return;
    L17:
        if (this.b > 0) goto L20;
        m(r22, CollectionsKt.emptyList());
        return;
    L20:
        g r1 = (g) this.m.invoke();
        if (r1 == null) goto L23;
        r1.updateLoadMoreStatus(PageListLoadStatus.LoadMoreIn, false);
    L23:
        r4.element = RangesKt.coerceAtLeast(this.b - this.h.u, 0);
        r5.element = RangesKt.coerceAtMost(this.h.u, this.b);
        goto L24
    L5:
        r12 = false;
        goto L6
    }

    public final void n(String r6, Integer r7, String r8) {
        if (EComABUtils.isArsEnable() == true) goto L5;
        return;
    L5:
        int r0 = RoomContextController.h;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1 = this.h;
        ECContext r2 = RoomContextController.a.b(r1.h, r1.j).r();
        if (r2 == null) goto L12;
        i<yg2.a> r3 = r2.getEcLiveActionRecordService();
        if (r3 == null) goto L12;
        yg2.a r4 = (yg2.a) r3.getValue();
        if (r4 == null) goto L12;
        r4.d(new xg2.b(Action.SHOP_LIST_OPEN, MapsKt.mapOf(new Pair[]{TuplesKt.to("server_log_id", r6), TuplesKt.to("use_cache", BDLocationException.ERROR_TIMEOUT)})));
    L12:
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r9 = this.h;
        ECContext r10 = RoomContextController.a.b(r9.h, r9.j).r();
        if (r10 == null) goto L26;
        i<yg2.a> r11 = r10.getEcLiveActionRecordService();
        if (r11 == null) goto L27;
        yg2.a r12 = (yg2.a) r11.getValue();
        if (r12 == null) goto L28;
        Action r5 = Action.SHOP_LIST_OPEN;
        ErrorType r13 = ErrorType.NETWORK;
        if (r7 == null) goto L21;
        int r14 = r7.intValue();
    L22:
        if (r8 != null) goto L24;
        r8 = "ReportFailureInfoActionEvent onError";
    L24:
        r12.d(new xg2.a(r5, r13, r14, r8));
        return;
    L21:
        r14 = -1000;
        goto L22
    L28:
        return;
    L27:
        return;
    }

    public final void i(final mj2.e r19, final int r20, final int r21, int r22, PositionalDataSource.LoadInitialCallback<mj2.c> r23) {
        final LivePromotionListPagingDataSource$handleFirstPageData$1 r9 = new LivePromotionListPagingDataSource$handleFirstPageData$1(this, r19, r20, r21, r22, r23);
        if (r21 != 0) goto L20;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r1 = this.h;
        if (r1.l == false) goto L20;
        int r2 = RoomContextController.h;
        ECContext r3 = RoomContextController.a.b(r1.h, r1.j).r();
        if (r3 == null) goto L20;
        i<ECLivePerformanceMonitor> r4 = r3.getEcLivePerformanceMonitor();
        if (r4 == null) goto L20;
        ECLivePerformanceMonitor r5 = (ECLivePerformanceMonitor) r4.getValue();
        if (r5 == null) goto L20;
        if (r19.u == true) goto L17;
        r5.u("ec_perf_duration_promotion_list", "request_end", null);
        String r6 = r5.r;
        if (r6 == null) goto L17;
        Map r7 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r6, MetricNames.LIVE_PROMOTIONS_API_DURATION);
    L17:
        PromotionListController.a r8 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r10 = this.h;
        String r11 = r10.h;
        String r12 = r10.j;
        r8.getClass();
        PromotionListController.a.c(r11, r12).K.put("on_list_api_response", Long.valueOf(System.currentTimeMillis()));
        r5.u("ec_perf_duration_promotion_list", "render_start", null);
        r5.u = Long.valueOf(System.currentTimeMillis());
        String r13 = r5.r;
        if (r13 == null) goto L20;
        Map r14 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r13, MetricNames.RENDER_DURATION, null);
    L20:
        int r15 = com.bytedance.android.livesdk.livecommerce.room.controller.related.c.a();
        boolean r16 = true;
        if (r19.u == false) goto L23;
    L71:
        g r17 = (g) this.m.invoke();
        if (r17 == null) goto L78;
        String r18 = this.h.b;
        List<? extends ql.a> r24 = r19.a;
        if (r24 == null) goto L76;
        int r25 = r24.size();
    L77:
        r17.reportTabFirstPageLoadResult(r18, r25);
        goto L78
    L76:
        r25 = 0;
    L78:
        LivePromotionPageCategoryData r26 = r19.p;
        if (r26 == null) goto L81;
        List<PromotionCategory> r27 = r26.getCategories();
    L82:
        String r28 = this.h.w;
        if (r28 != null) goto L85;
    L114:
        r9.invoke(this.h.b, null, r19.i, r19.t);
        return;
    L85:
        if (r28.length() <= 0) goto L87;
        boolean r29 = true;
    L88:
        if (r29 == true) goto L91;
        r28 = null;
    L91:
        if (r28 == null) goto L114;
        if (r27 == null) goto L107;
        List<PromotionCategory> r30 = r27;
        if ((r30 instanceof Collection) == true) goto L96;
    L98:
        Iterator<T> r31 = r30.iterator();
    L100:
        if (r31.hasNext() == false) goto L104;
        if (Intrinsics.areEqual(((PromotionCategory) r31.next()).getUniqueIndex(), r28) == false) goto L100;
        boolean r32 = true;
    L105:
        if (r32 != true) goto L107;
    L108:
        if (r16 == false) goto L110;
        final String r33 = r28;
    L111:
        if (r33 == null) goto L114;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r0 = this.h;
        r0.b = r33;
        r0.a = 7;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r110 = this.h;
        r110.c = 0;
        this.j.d(r110, r110.u, 1, false, this.n, new LivePromotionListPagingDataSource$handleFirstPageData$$inlined$also$lambda$1(r33, this, r19, r9, r20, r21), new LivePromotionListPagingDataSource$handleFirstPageData$$inlined$also$lambda$2(this, r19, r9, r20, r21));
        return;
    L110:
        r33 = null;
    L104:
        r32 = false;
        goto L105
    L96:
        if (r30.isEmpty() == false) goto L98;
    L107:
        r16 = false;
        goto L108
    L87:
        r29 = false;
        goto L88
    L81:
        r27 = null;
        goto L82
    L23:
        if (xh2.c.a(r21) == false) goto L71;
        if (r15 <= 0) goto L71;
        r19.x = new mj2.g();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == true) goto L58;
        PromotionListController.a r34 = PromotionListController.T;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r35 = this.h;
        String r36 = r35.h;
        String r37 = r35.j;
        r34.getClass();
        JSONArray r38 = PromotionListController.a.c(r36, r37).L;
        if (r38 == null) goto L58;
        if (r38.length() <= 0) goto L32;
        boolean r39 = true;
    L33:
        if (r39 == true) goto L36;
        r38 = null;
    L36:
        if (r38 == null) goto L58;
        mj2.g r40 = r19.x;
        if (r40 == null) goto L40;
        Intrinsics.checkNotNullParameter("1", "<set-?>");
        r40.c = "1";
    L40:
        ql.a r41 = r19.d;
        if (r41 == null) goto L58;
        if (r41.containsIconTag("smart_product") == true) goto L46;
        r41 = null;
    L46:
        if (r41 == null) goto L58;
        mj2.g r111 = r19.x;
        if (r111 == null) goto L50;
        Intrinsics.checkNotNullParameter("1", "<set-?>");
        r111.a = "1";
    L50:
        int r42 = r38.length();
        int r112 = 0;
    L51:
        if (r112 >= r42) goto L58;
        JSONObject r113 = JSONArrayProtectorUtils.getJSONObject(r38, r112);
        if (Intrinsics.areEqual(r113.optString("product_id"), r41.getProductId()) == false) goto L57;
        mj2.g r114 = r19.x;
        if (r114 == null) goto L57;
        String r115 = String.valueOf(r113.optInt("grass_type", 0));
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r114.b = r115;
    L57:
        r112 = r112 + 1;
        goto L51
    L32:
        r39 = false;
    L58:
        v r43 = new v("livesdk_live_list_show_smart", com.bytedance.android.ec.common.api.jump.model.b.a);
        mj2.g r44 = r19.x;
        if (r44 == null) goto L61;
        String r45 = r44.a;
    L62:
        r43.c("smart_product_exist", r45);
        mj2.g r46 = r19.x;
        if (r46 == null) goto L65;
        String r47 = r46.c;
    L66:
        r43.c("have_smart_like_product", r47);
        mj2.g r48 = r19.x;
        if (r48 == null) goto L69;
        String r49 = r48.b;
    L70:
        r43.c("smart_grass_type", r49);
        r43.i(null);
        goto L71
    L69:
        r49 = null;
        goto L70
    L65:
        r47 = null;
        goto L66
    L61:
        r45 = null;
        goto L62
    }

    public static final void e(final LivePromotionListPagingDataSource r13, final vj2.b r14, final int r15, final int r16, int r17, final PositionalDataSource.LoadInitialCallback r18) {
        r13.getClass();
        if (r14 == null) goto L15;
        if (((com.bytedance.android.ec.model.g) r14).statusCode != 0) goto L15;
        if (EComABUtils.getAdaptProductBlockSwitch() == true) goto L9;
    L13:
        int r0 = mj2.e.y;
        r13.i(mj2.e.a.a(r14), r15, r16, r17, r18);
        int r1 = zg2.a.a;
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2 = r13.h;
        zg2.a.a(r2.h, r2.j, Action.SHOP_LIST_DATA_FROM, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_from", String.valueOf(1))}));
        return;
    L9:
        if (r14.v() == false) goto L13;
        if (r14.i() <= 0) goto L13;
        r13.j.e(r13.h, r14.i(), r17, 1, r13.a, new LivePromotionListPagingDataSource$onPageDataResponse$1(r13, r14, r15, r16, r18));
        return;
    L15:
        if (EComABUtils.isArsEnable() == false) goto L27;
        String r3 = null;
        if (r14 == null) goto L19;
        String r4 = r14.getLogId();
    L20:
        if (r14 == null) goto L22;
        Integer r5 = Integer.valueOf(((com.bytedance.android.ec.model.g) r14).statusCode);
    L23:
        StringBuilder r6 = new StringBuilder("RequestPageData status onError, ");
        if (r14 == null) goto L26;
        r3 = ((com.bytedance.android.ec.model.g) r14).statusMessage;
    L26:
        r6.append(r3);
        r13.n(r4, r5, r6.toString());
        goto L27
    L22:
        r5 = null;
        goto L23
    L19:
        r4 = null;
    L27:
        r13.j(r16);
    }

    public static final void f(LivePromotionListPagingDataSource r0, boolean r1, boolean r2, boolean r3, int r4, int r5, int r6) {
        if (r2 == false) goto L13;
        r0.b = r4;
        r0.c = r5;
        if (r1 == false) goto L6;
        r0.d = r6;
    L6:
        if (r3 == false) goto L10;
        g r7 = (g) r0.m.invoke();
        if (r7 == null) goto L17;
        r7.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, r1);
        return;
    L17:
        return;
    L10:
        g r8 = (g) r0.m.invoke();
        if (r8 == null) goto L19;
        r8.updateLoadMoreStatus(PageListLoadStatus.LoadMoreSuccess, r1);
        return;
    L19:
        return;
    L13:
        g r9 = (g) r0.m.invoke();
        if (r9 == null) goto L21;
        r9.updateLoadMoreStatus(PageListLoadStatus.LoadMoreError, r1);
        return;
    }

    public static final void g(LivePromotionListPagingDataSource r6, boolean r7, String r8, String r9, int r10, int r11, mj2.e r12) {
        r6.getClass();
        PromotionCategory.Companion.getClass();
        if (PromotionCategory.a.b(r8) == false) goto L37;
        if (r11 != 0) goto L37;
        if (xh2.c.a(r10) == false) goto L37;
        List<? extends ql.a> r13 = r12.a;
        if (r13 == null) goto L10;
        int r14 = r13.size();
    L12:
        if (r14 <= 0) goto L14;
    L21:
        boolean r15 = true;
    L22:
        r12.v = r15;
        if (r10 != 9) goto L25;
        boolean r4 = true;
    L26:
        g r0 = (g) r6.m.invoke();
        if (r0 == null) goto L30;
        r0.x(r6.h, r12, r10, r4, r9);
    L30:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == true) goto L48;
        PromotionListController r16 = r6.h();
        if (r16 == null) goto L49;
        LivePromotionListCacheCenter r17 = r16.F;
        if (r17 == null) goto L50;
        LivePromotionListCacheCenter.b(r17);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L25:
        r4 = false;
        goto L26
    L14:
        if (r12.c != null) goto L21;
        List<? extends ql.a> r18 = r12.b;
        if (r18 != null) goto L18;
    L20:
        r15 = false;
        goto L22
    L18:
        if ((!r18.isEmpty()) != true) goto L20;
    L10:
        r14 = 0;
    L37:
        if (PromotionCategory.a.b(r8) == true) goto L39;
        return;
    L39:
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == true) goto L53;
        g r19 = (g) r6.m.invoke();
        if (r19 == null) goto L54;
        ECPromotionListTopData r20 = r12.l;
        if (r20 == null) goto L45;
        List<ECPromotionInterationData> r21 = r20.getInteractionData();
    L46:
        r19.C(r21, r7);
        return;
    L45:
        r21 = null;
        goto L46
    L54:
        return;
    }

    public final void o(int r3, boolean r4, boolean r5, boolean r6, int r7, int r8, int r9) {
        if (r4 == false) goto L32;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        if (r5 == false) goto L23;
        g r10 = (g) this.m.invoke();
        if (r10 == null) goto L9;
        r10.updateLoadInitialStatus(new h(r3, PageListLoadStatus.InitializeSuccess, r6));
    L9:
        if (r9 <= 0) goto L13;
        g r11 = (g) this.m.invoke();
        if (r11 == null) goto L16;
        r11.updateLoadMoreStatus(PageListLoadStatus.LoadMoreSuccess, true);
    L16:
        if (r7 <= 0) goto L20;
        g r12 = (g) this.m.invoke();
        if (r12 == null) goto L42;
        r12.updateLoadMoreStatus(PageListLoadStatus.LoadMoreSuccess, false);
        return;
    L42:
        return;
    L20:
        g r13 = (g) this.m.invoke();
        if (r13 == null) goto L44;
        r13.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, false);
        return;
    L44:
        return;
    L13:
        g r14 = (g) this.m.invoke();
        if (r14 == null) goto L16;
        r14.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, true);
        goto L16
    L23:
        g r15 = (g) this.m.invoke();
        if (r15 == null) goto L26;
        r15.updateLoadInitialStatus(new h(r3, PageListLoadStatus.InitializeEmpty, false));
    L26:
        g r16 = (g) this.m.invoke();
        if (r16 == null) goto L29;
        r16.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, true);
    L29:
        g r17 = (g) this.m.invoke();
        if (r17 == null) goto L46;
        r17.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, false);
        return;
    L46:
        return;
    L32:
        g r18 = (g) this.m.invoke();
        if (r18 == null) goto L35;
        r18.updateLoadInitialStatus(new h(r3, PageListLoadStatus.InitializeError, false));
    L35:
        g r19 = (g) this.m.invoke();
        if (r19 == null) goto L38;
        r19.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, true);
    L38:
        g r20 = (g) this.m.invoke();
        if (r20 == null) goto L48;
        r20.updateLoadMoreStatus(PageListLoadStatus.LoadMoreEnd, false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePromotionListPagingDataSource(com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r2, tj2.b r3, tj2.e r4, Function0<Integer> r5, Function0<? extends List<? extends ql.a>> r6, Function0<? extends g> r7, com.bytedance.android.ec.core.async.b r8, RoomContextController r9) {
        Intrinsics.checkNotNullParameter(r2, "requestParams");
        Intrinsics.checkNotNullParameter(r3, "localDataSource");
        Intrinsics.checkNotNullParameter(r4, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r5, "getPositionOffset");
        Intrinsics.checkNotNullParameter(r6, "getCurrentPromotions");
        Intrinsics.checkNotNullParameter(r7, "repositoryCallback");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        Intrinsics.checkNotNullParameter(r9, "roomContextController");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        DisposableScope r10 = new DisposableScope();
        this.a = r10;
        this.e = CollectionsKt.emptyList();
        r8.add(r10.a());
        addInvalidatedCallback(new a(this));
    }
}
