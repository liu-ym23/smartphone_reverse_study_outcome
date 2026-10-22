package com.bytedance.android.shopping.orderlist.list.network;

import android.content.Context;
import android.os.Looper;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonRepository;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.cache.OrderCacheManager;
import com.bytedance.android.shopping.orderlist.list.cache.SingleOrderListCache;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.utils.OrderListRxJavaSchedulers;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListRequestViewModel implements c53.d {
    public static final Map<String, OrderListRequestViewModel> z = null;
    public AndroidYaTaInstance a;
    public boolean b;
    public boolean c;
    public OrderListViewModel d;
    public OrderCacheManager e;
    public com.bytedance.android.btm.api.model.d f;
    public ig3.a g;
    public OrderListParams h;
    public com.bytedance.android.shopping.orderlist.list.tab.a i;
    public boolean j;
    public com.bytedance.android.shopping.orderlist.list.starter.a k;
    public com.bytedance.android.shopping.orderlist.list.network.b l;
    public Function2<? super com.bytedance.android.shopping.orderlist.list.starter.a, ? super com.bytedance.android.shopping.orderlist.list.network.b, Unit> m;
    public com.bytedance.android.shopping.orderlist.list.network.a n;
    public final b<com.bytedance.android.shopping.orderlist.list.starter.a> o;
    public Function1<? super com.bytedance.android.shopping.orderlist.list.network.a, Unit> p;
    public boolean q;
    public Function1<? super com.bytedance.android.shopping.orderlist.list.network.a, Unit> r;
    public Function2<? super Boolean, ? super com.bytedance.kmp.ec.yata.common.biz.callback.a, Unit> s;
    public Function4<? super Boolean, ? super Boolean, ? super gg3.c, ? super com.bytedance.kmp.ec.yata.common.biz.callback.a, Unit> t;
    public Function2<? super com.bytedance.android.shopping.orderlist.list.starter.a, ? super OrderListRequestType, Unit> u;
    public Function1<? super OrderListRequestType, Unit> v;
    public Function1<? super SingleOrderListCache, Unit> w;
    public final String x;
    public final /* synthetic */ c53.b y;

    public static final class a {
    }

    public static final class b<T> {
        public final ArrayDeque<T> a;
        public final Function1<? super T, Unit> b;

        public b(ArrayDeque<T> r2, Function1<? super T, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "queue");
            Intrinsics.checkNotNullParameter(r3, "removeCb");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ OrderListRequestViewModel a;

        public c(OrderListRequestViewModel r1) {
            this.a = r1;
        }

        public final void run() {
            OrderCacheManager r0 = this.a.e;
            if (r0 != null) goto L5;
            return;
        L5:
            if (com.bytedance.android.ec.core.opt.ab.c.g() == true) goto L7;
            return;
        L7:
            if (r0.f.get() == true) goto L29;
            Context r1 = r0.h;
            Object r2 = null;
            if (r1 == null) goto L12;
            String r3 = ka3.b.a(r1, "IESECOrderListCacheKey");
        L13:
            Object r4 = GsonProtectorUtils.fromJson(u0.c(), r3, r0.e);
            if (TypeIntrinsics.isMutableList(r4) == false) goto L17;
            r2 = r4;
        L17:
            List<SingleOrderListCache> r5 = (List) r2;
            if (r5 != null) goto L20;
            r5 = new ArrayList();
        L20:
            r0.c = r5;
            List<SingleOrderListCache> r6 = r5;
            LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
            Iterator<T> r8 = r6.iterator();
        L22:
            if (r8.hasNext() == false) goto L24;
            Object r9 = r8.next();
            r7.put(((SingleOrderListCache) r9).getCacheKey(), r9);
            goto L22
        L24:
            r0.d = r7;
            r0.f.compareAndSet(false, true);
            return;
        L12:
            r3 = null;
            goto L13
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Lazy r4 = OrderCommonLog.a;
            OrderCommonLog.a("OrderListRequestViewModel", OrderListRequestViewModel$initWhenFragmentCreated$14$1.INSTANCE);
        }
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.y.add(r2);
        return r2;
    }

    public final void doClear() {
        this.y.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.y.remove(r2);
    }

    static {
        z = new LinkedHashMap();
    }

    public final com.bytedance.android.shopping.orderlist.list.tab.a d() {
        OrderListViewModel r0 = this.d;
        String r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r2 = r0.getStaticState();
        if (r2 == null) goto L9;
        if (r2.i == false) goto L9;
    L10:
        if (r2 == null) goto L12;
        Integer r3 = r2.k;
    L16:
        if (r2 == null) goto L19;
        Integer r4 = r2.l;
        if (r4 == null) goto L19;
    L23:
        if (r4 != null) goto L28;
        OrderListParams r5 = this.h;
        if (r5 == null) goto L27;
        r4 = Integer.valueOf(r5.getTabId());
        goto L28
    L27:
        r4 = null;
    L28:
        if (r4 == null) goto L30;
        int r6 = r4.intValue();
    L32:
        if (r2 == null) goto L37;
        String r7 = r2.j;
        if (r7 == null) goto L37;
        r1 = r7;
    L41:
        return new com.bytedance.android.shopping.orderlist.list.tab.a(r3, r6, r1);
    L37:
        com.bytedance.android.shopping.orderlist.list.tab.a r8 = this.i;
        if (r8 == null) goto L41;
        r1 = r8.c;
        goto L41
    L30:
        r6 = 0;
    L19:
        com.bytedance.android.shopping.orderlist.list.tab.a r9 = this.i;
        if (r9 == null) goto L22;
        r4 = Integer.valueOf(r9.b);
        goto L23
    L22:
        r4 = null;
        goto L23
    L12:
        com.bytedance.android.shopping.orderlist.list.tab.a r10 = this.i;
        if (r10 == null) goto L15;
        r3 = r10.a;
        goto L16
    L15:
        r3 = null;
    L9:
        r2 = null;
        goto L10
    }

    public final void g() {
        OrderCacheManager r0 = this.e;
        if (r0 == null) goto L12;
        AndroidYaTaInstance r3 = this.a;
        if (r3 == null) goto L9;
        aa6.b r4 = r3.h(1);
        if (r4 == null) goto L9;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r5 = com.bytedance.kmp.ec.yata.common.protocol.data.d.c(r4);
    L10:
        r0.c(new gg3.c(new com.bytedance.kmp.ec.yata.common.protocol.data.e(r5), 0, 6));
        return;
    L9:
        r5 = null;
        goto L10
    }

    public OrderListRequestViewModel(String r11) {
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        this.y = new c53.b();
        this.x = r11;
        this.b = true;
        this.l = new com.bytedance.android.shopping.orderlist.list.network.b(OrderListRequestType.FIRST_REQUEST, 0, false, false, false, false, null, null, 1022);
        this.o = new b(new ArrayDeque(), new OrderListRequestViewModel$orderChunkResponseQueue$1(this));
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.y.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    public static final void a(OrderListRequestViewModel r1, com.bytedance.android.shopping.orderlist.list.starter.a r2) {
        r1.k = r2;
        if (r2 == null) goto L8;
        Function2<? super com.bytedance.android.shopping.orderlist.list.starter.a, ? super com.bytedance.android.shopping.orderlist.list.network.b, Unit> r0 = r1.m;
        if (r0 == null) goto L9;
        Unit r3 = (Unit) r0.invoke(r2, r1.l);
        return;
    L9:
        return;
    }

    public final void b(final com.bytedance.android.shopping.orderlist.list.network.b r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "config");
        if (r13 == false) goto L9;
        Lazy r14 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$doChunkRequest$1.INSTANCE);
        long r3 = System.currentTimeMillis();
        com.bytedance.android.shopping.orderlist.list.tab.a r15 = d();
        OrderCommonYataRequest r0 = c(r12.g, r12.d, r12.e, r12.f, r15);
        this.l = r12;
        int r1 = OrderCommonRepository.a;
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r2 = r12.j;
        Intrinsics.checkNotNullParameter(r0, "req");
        OrderCommonApi.Companion.getClass();
        Observable r4 = ((OrderCommonApi) n.a.create(OrderCommonApi.API_HOST, OrderCommonApi.class)).getQueryForChunk(r0).doOnError(new com.bytedance.android.shopping.orderlist.common.repo.a(r2)).subscribeOn(Schedulers.io());
        if (r4 == null) goto L202;
        Disposable r16 = r4.subscribe(new com.bytedance.android.shopping.orderlist.list.network.d(this, r3, r15, r12), new f(this, r12));
        if (r16 == null) goto L203;
        c53.c.a(r16, this);
        return;
    L203:
        return;
    L202:
        return;
    L9:
        Lazy r17 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$doNormalRequest$1.INSTANCE);
        this.l = r12;
        OrderCommonYataRequest r18 = c(r12.g, r12.d, r12.e, r12.f, null);
        final Ref.LongRef r5 = new Ref.LongRef();
        r5.element = 0;
        Scheduler r6 = Schedulers.io();
        Scheduler r7 = AndroidSchedulers.mainThread();
        if (r12.c == false) goto L189;
        int r8 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r9 = com.bytedance.android.ec.base.settings.a.a;
        Object r10 = 0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L169
        Object r19 = null;
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_list_request_thread_opt");     // Catch: Throwable -> L63
        if (r20 != null) goto L18;
    L60:
        Object r21 = null;
    L61:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L63
    L65:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L169
        if (r23 == null) goto L69;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L169
    L69:
        if (Result.isFailure-impl(r22) == false) goto L72;
        r22 = null;
    L72:
        if ((r22 instanceof Integer) == true) goto L74;
        r22 = null;
    L74:
        Object r24 = (Integer) r22;     // Catch: Throwable -> L169
        if (r24 != null) goto L81;
        Object r25 = com.bytedance.android.ec.base.settings.d.a.get("ec_order_list_request_thread_opt");     // Catch: Throwable -> L169
        if ((r25 instanceof Integer) == true) goto L80;
        r25 = null;
    L80:
        r24 = (Integer) r25;     // Catch: Throwable -> L169
    L81:
        if (r24 != null) goto L178;
        int r26 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L169
        Object r27 = com.bytedance.android.ec.base.settings.d.c.get("ec_order_list_request_thread_opt");     // Catch: Throwable -> L133
        if (r27 != null) goto L88;
    L130:
        Object r28 = null;
    L131:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L133
    L135:
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L159
        if (r30 == null) goto L139;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L159
    L139:
        if (Result.isFailure-impl(r29) == false) goto L142;
        r29 = null;
    L142:
        if ((r29 instanceof Integer) == true) goto L144;
        r29 = null;
    L144:
        r24 = (Integer) r29;     // Catch: Throwable -> L159
        if (r24 != null) goto L167;
        IHybridHostService r31 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L159
        if (r31 == null) goto L150;
        Object r32 = r31.getHostABValue("ec_order_list_request_thread_opt", r10);     // Catch: Throwable -> L159
    L151:
        if (r32 != null) goto L153;
    L158:
        r24 = r10;
        goto L167
    L153:
        if ((r32 instanceof Integer) == false) goto L156;
        r19 = r32;
    L156:
        Object r33 = (Integer) r19;     // Catch: Throwable -> L159
        if (r33 == null) goto L158;
    L166:
        r24 = r33;
        goto L167
    L150:
        r32 = null;
    L167:
        com.bytedance.android.ec.base.settings.d.d("ec_order_list_request_thread_opt", r24);     // Catch: Throwable -> L169
        goto L178
    L88:
        if ((r27 instanceof Integer) == true) goto L90;
        Object r34 = null;
    L91:
        r28 = (Integer) r34;     // Catch: Throwable -> L133
        if (r28 != null) goto L131;
        if ((r27 instanceof Number) == false) goto L118;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L103;
        Float r35 = Float.valueOf(((Number) r27).floatValue());     // Catch: Throwable -> L133
        if ((r35 instanceof Integer) == true) goto L101;
        r35 = null;
    L101:
        r28 = (Integer) r35;     // Catch: Throwable -> L133
        goto L131
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L109;
        Double r36 = Double.valueOf(((Number) r27).doubleValue());     // Catch: Throwable -> L133
        if ((r36 instanceof Integer) == true) goto L107;
        r36 = null;
    L107:
        r28 = (Integer) r36;     // Catch: Throwable -> L133
        goto L131
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L112;
        r28 = Integer.valueOf(((Number) r27).intValue());     // Catch: Throwable -> L133
        goto L131
    L112:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L118;
        Long r37 = Long.valueOf(((Number) r27).longValue());     // Catch: Throwable -> L133
        if ((r37 instanceof Integer) == true) goto L116;
        r37 = null;
    L116:
        r28 = (Integer) r37;     // Catch: Throwable -> L133
    L118:
        if ((r27 instanceof JSONObject) == false) goto L120;
    L200:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L126
        Object r38 = SDKSettingsCacheManager.a().fromJson(r27.toString(), Integer.class);     // Catch: Throwable -> L126
        if ((r38 instanceof Integer) == true) goto L124;
        r38 = null;
    L124:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L126
    L128:
        r28 = r39;
        if (Result.isFailure-impl(r28) == false) goto L131;
    L126:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L133
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L133
        goto L128
    L120:
        if ((r27 instanceof JSONArray) == false) goto L130;
    L90:
        r34 = r27;
    L159:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L169
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
        Throwable r42 = Result.exceptionOrNull-impl(r33);     // Catch: Throwable -> L169
        if (r42 == null) goto L164;
        EnsureManager.ensureNotReachHere(r42);     // Catch: Throwable -> L169
    L164:
        if (Result.isFailure-impl(r33) == false) goto L166;
        r33 = r10;
    L133:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L159
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L159
    L178:
        int r44 = ((Number) r24).intValue();
        if (r44 == 1) goto L182;
        if (r44 == 2) goto L182;
        Scheduler r45 = Schedulers.io();
    L183:
        if (r44 == 1) goto L187;
        if (r44 == 2) goto L186;
        Scheduler r46 = AndroidSchedulers.mainThread();
    L188:
        r7 = r46;
        r6 = r45;
        goto L189
    L186:
        Lazy r47 = OrderListRxJavaSchedulers.a;
        r46 = Schedulers.from(new com.bytedance.android.shopping.orderlist.list.utils.b());
        goto L188
    L187:
        Lazy r48 = OrderListRxJavaSchedulers.a;
        r46 = AndroidSchedulers.from(Looper.getMainLooper(), true);
    L182:
        r45 = Schedulers.from((com.bytedance.android.ec.hybrid.data.utils.c) OrderListRxJavaSchedulers.a.getValue());
        goto L183
    L18:
        if ((r20 instanceof Integer) == true) goto L20;
        Object r49 = null;
    L21:
        r21 = (Integer) r49;     // Catch: Throwable -> L63
        if (r21 != null) goto L61;
        if ((r20 instanceof Number) == false) goto L48;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L33;
        Float r50 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L63
        if ((r50 instanceof Integer) == true) goto L31;
        r50 = null;
    L31:
        r21 = (Integer) r50;     // Catch: Throwable -> L63
        goto L61
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L39;
        Double r51 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L63
        if ((r51 instanceof Integer) == true) goto L37;
        r51 = null;
    L37:
        r21 = (Integer) r51;     // Catch: Throwable -> L63
        goto L61
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L42;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L63
        goto L61
    L42:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L48;
        Long r52 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L63
        if ((r52 instanceof Integer) == true) goto L46;
        r52 = null;
    L46:
        r21 = (Integer) r52;     // Catch: Throwable -> L63
    L48:
        if ((r20 instanceof JSONObject) == false) goto L50;
    L198:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L56
        Object r53 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L56
        if ((r53 instanceof Integer) == true) goto L54;
        r53 = null;
    L54:
        Object r54 = Result.constructor-impl((Integer) r53);     // Catch: Throwable -> L56
    L58:
        r21 = r54;
        if (Result.isFailure-impl(r21) == false) goto L61;
    L56:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L63
        r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L63
        goto L58
    L50:
        if ((r20 instanceof JSONArray) == false) goto L60;
    L20:
        r49 = r20;
    L63:
        th = move-exception;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L169
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Object r58 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r59 = Result.exceptionOrNull-impl(r58);
        if (r59 == null) goto L174;
        EnsureManager.ensureNotReachHere(r59);
    L174:
        if (Result.isFailure-impl(r58) == true) goto L177;
        r10 = r58;
    L177:
        r24 = r10;
    L189:
        int r60 = OrderCommonRepository.a;
        c53.c.a(OrderCommonRepository.b(OrderCommonRepository.a(r12.j, r18).subscribeOn(r6), r12.j, new OrderListRequestViewModel$doNormalRequest$2(this, r12, r5), new OrderListRequestViewModel$doNormalRequest$3(this, r12, r5)).observeOn(r7).subscribe(new g(this, r12), new h(this, r12)), this);
    }

    public final void e(final OrderListFragment r8, com.bytedance.android.shopping.orderlist.list.network.b r9) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "config");
        int r0 = com.bytedance.android.ec.core.opt.ab.c.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.n.a;
        boolean r2 = false;
        Object r3 = 0;
        int r4 = com.bytedance.android.ec.base.settings.a.a;
        OrderListTracker r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L157
        Object r7 = com.bytedance.android.ec.base.settings.d.c.get("order_list_cache_context_opt");     // Catch: Throwable -> L53
        if (r7 != null) goto L8;
    L50:
        Object r10 = null;
    L51:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L53
    L55:
        Throwable r12 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L157
        if (r12 == null) goto L59;
        EnsureManager.ensureNotReachHere(r12);     // Catch: Throwable -> L157
    L59:
        if (Result.isFailure-impl(r11) == false) goto L62;
        r11 = null;
    L62:
        if ((r11 instanceof Integer) == true) goto L64;
        r11 = null;
    L64:
        Object r13 = (Integer) r11;     // Catch: Throwable -> L157
        if (r13 != null) goto L71;
        Object r14 = com.bytedance.android.ec.base.settings.d.a.get("order_list_cache_context_opt");     // Catch: Throwable -> L157
        if ((r14 instanceof Integer) == true) goto L70;
        r14 = null;
    L70:
        r13 = (Integer) r14;     // Catch: Throwable -> L157
    L71:
        if (r13 != null) goto L167;
        int r15 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L157
        Object r16 = com.bytedance.android.ec.base.settings.d.c.get("order_list_cache_context_opt");     // Catch: Throwable -> L123
        if (r16 != null) goto L78;
    L120:
        Object r17 = null;
    L121:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L123
    L125:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L148
        if (r19 == null) goto L129;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L148
    L129:
        if (Result.isFailure-impl(r18) == false) goto L132;
        r18 = null;
    L132:
        if ((r18 instanceof Integer) == true) goto L134;
        r18 = null;
    L134:
        r13 = (Integer) r18;     // Catch: Throwable -> L148
        if (r13 != null) goto L155;
        IHybridHostService r20 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L148
        if (r20 == null) goto L140;
        Object r21 = r20.getHostABValue("order_list_cache_context_opt", r3);     // Catch: Throwable -> L148
    L141:
        if (r21 != null) goto L143;
    L154:
        r13 = r3;
        goto L155
    L143:
        if ((r21 instanceof Integer) == true) goto L145;
        r21 = null;
    L145:
        r13 = (Integer) r21;     // Catch: Throwable -> L148
        if (r13 != null) goto L155;
    L148:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L157
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
        Throwable r23 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L157
        if (r23 == null) goto L153;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L157
    L153:
        if (Result.isFailure-impl(r13) == false) goto L155;
    L140:
        r21 = null;
    L155:
        com.bytedance.android.ec.base.settings.d.d("order_list_cache_context_opt", r13);     // Catch: Throwable -> L157
        goto L167
    L78:
        if ((r16 instanceof Integer) == true) goto L80;
        Object r24 = null;
    L81:
        r17 = (Integer) r24;     // Catch: Throwable -> L123
        if (r17 != null) goto L121;
        if ((r16 instanceof Number) == false) goto L108;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L93;
        Float r25 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L123
        if ((r25 instanceof Integer) == true) goto L91;
        r25 = null;
    L91:
        r17 = (Integer) r25;     // Catch: Throwable -> L123
        goto L121
    L93:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L99;
        Double r26 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L123
        if ((r26 instanceof Integer) == true) goto L97;
        r26 = null;
    L97:
        r17 = (Integer) r26;     // Catch: Throwable -> L123
        goto L121
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L102;
        r17 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L123
        goto L121
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L108;
        Long r27 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L123
        if ((r27 instanceof Integer) == true) goto L106;
        r27 = null;
    L106:
        r17 = (Integer) r27;     // Catch: Throwable -> L123
    L108:
        if ((r16 instanceof JSONObject) == false) goto L110;
    L207:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L116
        Object r28 = SDKSettingsCacheManager.a().fromJson(r16.toString(), Integer.class);     // Catch: Throwable -> L116
        if ((r28 instanceof Integer) == true) goto L114;
        r28 = null;
    L114:
        Object r29 = Result.constructor-impl((Integer) r28);     // Catch: Throwable -> L116
    L118:
        r17 = r29;
        if (Result.isFailure-impl(r17) == false) goto L121;
    L116:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L123
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L123
        goto L118
    L110:
        if ((r16 instanceof JSONArray) == false) goto L120;
    L80:
        r24 = r16;
    L123:
        th = move-exception;
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L148
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L148
    L167:
        if (((Number) r13).intValue() != 1) goto L170;
        r2 = true;
    L170:
        if (r2 == false) goto L176;
        Lazy r32 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$initWhenFragmentCreated$1.INSTANCE);
        Context r33 = r8.getContext();
        if (r33 == null) goto L174;
        Context r34 = r33.getApplicationContext();
    L175:
        this.e = new OrderCacheManager(r34, this.h);
    L177:
        this.a = r8.k;
        this.d = r8.Y90();
        com.bytedance.android.btm.api.model.d r35 = new com.bytedance.android.btm.api.model.d();
        r35.a = "a1.b6871.c36711.d543737";
        r35.b = PageFinder.via(r8);
        r35.c = new BcmParams();
        Unit r36 = Unit.INSTANCE;
        this.f = r35;
        this.c = true;
        this.l = r9;
        this.s = new OrderListRequestViewModel$initWhenFragmentCreated$3(r8);
        this.t = new OrderListRequestViewModel$initWhenFragmentCreated$4(r8);
        this.r = new OrderListRequestViewModel$initWhenFragmentCreated$5(r8);
        this.u = new OrderListRequestViewModel$initWhenFragmentCreated$6(r8);
        this.v = new OrderListRequestViewModel$initWhenFragmentCreated$7(r8);
        this.w = new OrderListRequestViewModel$initWhenFragmentCreated$8(r8);
        Function2<? super Boolean, ? super com.bytedance.kmp.ec.yata.common.biz.callback.a, Unit> r37 = this.s;
        if (r37 == null) goto L180;
        Unit r38 = (Unit) r37.invoke(Boolean.FALSE, null);
    L180:
        String r39 = com.bytedance.android.shopping.orderlist.common.controller.n.a;
        Lazy r40 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListRequestViewModel$initWhenFragmentCreated$9.INSTANCE);
        if (com.bytedance.android.ec.core.opt.ab.c.g() == false) goto L183;
        c53.c.a(Completable.fromAction(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new OrderListRequestViewModel$initWhenFragmentCreated$13(this), d.a), this);
    L183:
        this.m = new OrderListRequestViewModel$initWhenFragmentCreated$15(this);
        this.p = new OrderListRequestViewModel$initWhenFragmentCreated$16(this);
        com.bytedance.android.shopping.orderlist.list.starter.a r41 = this.k;
        if (r41 == null) goto L190;
        OrderListViewModel r42 = this.d;
        if (r42 == null) goto L188;
        r5 = r42.getTracker();
    L188:
        OrderCommonErrorMonitorKt.c(r5, "OrderListFragment-onOrderListQuerySuccess", new OrderListRequestViewModel$onOrderListQuerySuccess$1(this, r9, r41));
    L190:
        if (this.o.a.size() <= 0) goto L195;
        b<com.bytedance.android.shopping.orderlist.list.starter.a> r43 = this.o;
    L193:
        if (r43.a.size() <= 0) goto L195;
        r43.b.invoke(r43.a.removeFirst());
    L195:
        com.bytedance.android.shopping.orderlist.list.network.a r44 = this.n;
        if (r44 == null) goto L214;
        Function1<? super com.bytedance.android.shopping.orderlist.list.network.a, Unit> r45 = this.r;
        if (r45 == null) goto L215;
        Unit r46 = (Unit) r45.invoke(r44);
        return;
    L215:
        return;
    L214:
        return;
    L174:
        r34 = null;
        goto L175
    L176:
        this.e = new OrderCacheManager(r8.getContext(), this.h);
        goto L177
    L8:
        if ((r7 instanceof Integer) == true) goto L10;
        Object r47 = null;
    L11:
        r10 = (Integer) r47;     // Catch: Throwable -> L53
        if (r10 != null) goto L51;
        if ((r7 instanceof Number) == false) goto L38;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r48 = Float.valueOf(((Number) r7).floatValue());     // Catch: Throwable -> L53
        if ((r48 instanceof Integer) == true) goto L21;
        r48 = null;
    L21:
        r10 = (Integer) r48;     // Catch: Throwable -> L53
        goto L51
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r49 = Double.valueOf(((Number) r7).doubleValue());     // Catch: Throwable -> L53
        if ((r49 instanceof Integer) == true) goto L27;
        r49 = null;
    L27:
        r10 = (Integer) r49;     // Catch: Throwable -> L53
        goto L51
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L32;
        r10 = Integer.valueOf(((Number) r7).intValue());     // Catch: Throwable -> L53
        goto L51
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L38;
        Long r50 = Long.valueOf(((Number) r7).longValue());     // Catch: Throwable -> L53
        if ((r50 instanceof Integer) == true) goto L36;
        r50 = null;
    L36:
        r10 = (Integer) r50;     // Catch: Throwable -> L53
    L38:
        if ((r7 instanceof JSONObject) == false) goto L40;
    L205:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L46
        Object r51 = SDKSettingsCacheManager.a().fromJson(r7.toString(), Integer.class);     // Catch: Throwable -> L46
        if ((r51 instanceof Integer) == true) goto L44;
        r51 = null;
    L44:
        Object r52 = Result.constructor-impl((Integer) r51);     // Catch: Throwable -> L46
    L48:
        r10 = r52;
        if (Result.isFailure-impl(r10) == false) goto L51;
    L46:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L53
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
        goto L48
    L40:
        if ((r7 instanceof JSONArray) == false) goto L50;
    L10:
        r47 = r7;
    L53:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L157
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r57 = Result.exceptionOrNull-impl(r56);
        if (r57 == null) goto L162;
        EnsureManager.ensureNotReachHere(r57);
    L162:
        if (Result.isFailure-impl(r56) == true) goto L165;
        r3 = r56;
    L165:
        r13 = r3;
        goto L167
    }

    public final void f(OrderListParams r2, boolean r3, com.bytedance.android.shopping.orderlist.list.tab.a r4) {
        Map<String, ig3.a> r0 = ig3.a.h;
        this.g = ig3.a.C0206a.a(this.x);
        this.h = r2;
        this.j = r3;
        if (r4 != null) goto L5;
        r4 = new com.bytedance.android.shopping.orderlist.list.tab.a();
    L5:
        this.i = r4;
        String r5 = com.bytedance.android.shopping.orderlist.common.controller.n.a;
        Lazy r6 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", new OrderListRequestViewModel$initWhenStart$1(this));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest, still in use, count: 2, list:
          (r15v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) from 0x0299: MOVE (r35v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) = (r15v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) (LINE:83886745)
          (r15v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) from 0x0122: MOVE (r35v2 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) = (r15v0 com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest) (LINE:83886370)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest c(final com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene r37, boolean r38, boolean r39, boolean r40, com.bytedance.android.shopping.orderlist.list.tab.a r41) {
        if (r38 == false) goto L100;
        if (r41 != null) goto L6;
        com.bytedance.android.shopping.orderlist.list.tab.a r3 = d();
    L7:
        final java.lang.String r10 = "a1.b6871.c0.d0";
        final com.bytedance.android.shopping.orderlist.list.starter.OrderListParams r8 = r36.h;
        boolean r4 = r36.j;
        final java.lang.Boolean r19 = java.lang.Boolean.valueOf(r4);
        com.bytedance.android.btm.api.model.d r4 = r36.f;
        if (r4 == null) goto L10;
        org.json.JSONObject r5 = new org.json.JSONObject();
        org.json.JSONObject r4 = com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker.e(r4, r5);
        org.json.JSONObject r20 = r4;
    L11:
        final java.lang.String r6 = r36.x;
        com.bytedance.android.btm.api.model.d r4 = r36.f;
        if (r4 == null) goto L14;
        java.lang.String r4 = com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker.g(r4);
        java.lang.String r5 = r4;
    L15:
        boolean r4 = r36.b;
        final java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4);
        final java.lang.Integer r9 = r3.a;
        final int r9 = r3.b;
        final java.lang.String r3 = r3.c;
        com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel r14 = r36.d;
        if (r14 == null) goto L18;
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r14 = r14.getCustomDynamicParams();
        java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r21 = r14;
    L19:
        com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel r14 = r36.d;
        if (r14 == null) goto L24;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r14 = r14.getStaticState();
        if (r14 == null) goto L24;
        java.lang.Boolean r14 = r14.c;
    L25:
        com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel r3 = r36.d;
        if (r3 == null) goto L30;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r3.getStaticState();
        if (r3 == null) goto L30;
        java.lang.Boolean r3 = r3.d;
        java.lang.Boolean r22 = r3;
    L31:
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter("a1.b6871.c0.d0", "btm");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r37, "appletPageScene");
        java.util.LinkedHashMap r2 = new java.util.LinkedHashMap();
        if (r8 == null) goto L36;
        java.util.Map<java.lang.String, java.lang.String> r3 = r8.getSchemaParamsMap();
        if (r3 == null) goto L36;
        r2.putAll(r3);
    L36:
        int r3 = com.bytedance.android.ec.sdk.ECSdk.a;
        java.lang.Object r3 = com.bytedance.android.ec.sdk.ECSdk.a(com.bytedance.android.ec.host.api.service.IECHostService.class);
        com.bytedance.android.ec.host.api.service.IECHostService r3 = (com.bytedance.android.ec.host.api.service.IECHostService) r3;
        if (r14 == null) goto L41;
        if (r22 == null) goto L41;
        com.bytedance.android.shopping.orderlist.common.utils.b r2 = null;
    L42:
        if (r14 != null) goto L46;
        if (r2 == null) goto L45;
        java.lang.Boolean r4 = r2.a;
    L47:
        if (r22 != null) goto L51;
        if (r2 == null) goto L50;
        boolean r2 = r2.b;
        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2);
    L52:
        if (r2 == null) goto L54;
        boolean r1 = r2.booleanValue();
    L55:
        final boolean r23 = r1;
        kotlin.Lazy r1 = com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog.a;
        final int r2 = 1;
        final java.lang.Boolean r2 = r4;
        java.lang.Boolean r30 = r4;
        final java.lang.String r40 = r5;
        final java.lang.Boolean r5 = r14;
        final java.lang.Boolean r6 = r22;
        com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest r35 = r15;
        final org.json.JSONObject r15 = r20;
        final java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r18 = r21;
        kotlin.jvm.functions.Function0<java.lang.String> r3 = new com.bytedance.android.shopping.orderlist.list.network.OrderListRequestConfigKt$createOrderListQueryExParams$$inlined$let$lambda$1(r2, r23, r8, r5, r6, r37, r6, r2, r19, r9, r9, r3, r4, r15, r40, r10, r18);
        com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog.c("OrderListRequestConfig", r3);
        boolean r1 = com.bytedance.android.shopping.extensions.k.i(r19);
        if (r1 == false) goto L58;
        java.lang.String r1 = "1";
    L59:
        r2.put("is_split", r1);
        r2.put("is_in_applet", r30);
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r23);
        r2.put("is_in_first_applet_page", r1);
        r2.put("page_type", "YATA_Android");
        r2.put("query_type", 1);
        java.util.LinkedHashMap r2 = new java.util.LinkedHashMap();
        if (r9 == null) goto L62;
        int r4 = r9.intValue();
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4);
        r2.put("biz_tab", r4);
    L62:
        java.lang.Integer r5 = java.lang.Integer.valueOf(r9);
        r2.put("tab", r5);
        if (r3 == null) goto L70;
        boolean r4 = kotlin.text.StringsKt.isBlank(r3);
        boolean r1 = true ^ r4;
        if (r1 == false) goto L67;
        java.lang.String r14 = r3;
    L68:
        if (r14 == null) goto L70;
        r2.put("tab_mode", r14);
        goto L70
    L67:
        r14 = null;
    L70:
        if (r8 == null) goto L74;
        java.lang.String r1 = r8.isNewEntryFromMall();
        if (r1 == null) goto L74;
        r2.put("is_new_entry_from_mall", r1);
    L74:
        r2.put("is_first_enter", r4);
        kotlin.Unit r1 = kotlin.Unit.INSTANCE;
        r2.put("order_list_params", r2);
        com.bytedance.android.ec.sdk.helper.ECAppInfoService r1 = com.bytedance.android.ec.sdk.helper.ECAppInfoService.e;
        android.content.Context r2 = r1.getApplicationContext();
        if (r2 == null) goto L84;
        int r2 = eh.b.b(r2);
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2);
        kotlin.Lazy r4 = com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig.a;
        boolean r4 = com.bytedance.android.shopping.extensions.k.i(r19);
        com.bytedance.android.ecom.arch.slice.render.context.b r4 = com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig.b(r4);
        float r2 = com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt.d(r2, r4);
        java.lang.Float r14 = java.lang.Float.valueOf(r2);
        boolean r2 = r14 instanceof java.lang.Number;
        if (r2 == true) goto L79;
        r14 = null;
    L79:
        if (r14 == null) goto L81;
        int r2 = r14.intValue();
        java.lang.Integer r14 = java.lang.Integer.valueOf(r2);
    L82:
        if (r14 == null) goto L84;
        int r2 = r14.intValue();
    L85:
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2);
        r2.put("status_bar_height", r2);
        if (r8 == null) goto L88;
        boolean r2 = r8.isHideGul();
        java.lang.Boolean r14 = java.lang.Boolean.valueOf(r2);
    L89:
        boolean r2 = com.bytedance.android.shopping.extensions.k.i(r14);
        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2);
        r2.put("hide_guess_you_like", r2);
        if (r20 == null) goto L92;
        java.lang.String r14 = r20.toString();
    L93:
        r2.put("cart_track", r14);
        r2.put("safe_area_bottom_height", 0);
        r2.put("bcm_chain", r40);
        r2.put("yata_session_id", r6);
        r2.put("btm", "a1.b6871.c0.d0");
        java.lang.Float r1 = r1.getCurrentFontScale();
        float r1 = com.bytedance.android.shopping.extensions.k.e(r1, 1.0f);
        java.lang.Float r1 = java.lang.Float.valueOf(r1);
        r2.put("system_font_scale", r1);
        r2.put("from_source", null);
        java.util.LinkedHashMap r1 = new java.util.LinkedHashMap();
        if (r21 == null) goto L99;
        java.util.Set<java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r2 = r21.entrySet();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>>> r2 = r2.iterator();
    L96:
        boolean r4 = r2.hasNext();
        if (r4 == false) goto L99;
        java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r4 = r2.next();
        java.util.Map.Entry<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> r4 = r4;
        java.lang.String r5 = r4.getKey();
        java.lang.String r5 = r5;
        java.util.Map<java.lang.String, java.lang.Object> r4 = r4.getValue();
        java.util.Map<java.lang.String, java.lang.Object> r4 = r4;
        com.google.gson.Gson r6 = new com.google.gson.Gson();
        java.lang.String r4 = com.bytedance.mt.protector.impl.GsonProtectorUtils.toJson(r6, r4);
        r1.put(r5, r4);
    L99:
        kotlin.Unit r2 = kotlin.Unit.INSTANCE;
        r2.put("custom_dynamic_params", r1);
        java.util.LinkedHashMap r14 = r2;
    L135:
        if (r39 == false) goto L139;
        com.bytedance.kmp.ec.yata.AndroidYaTaInstance r1 = r36.a;
        if (r1 == null) goto L139;
        java.lang.String r1 = r1.m();
    L140:
        com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig r2 = com.bytedance.kmp.ec.yata.common.init.b.a;
        com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest r3 = new com.bytedance.android.shopping.orderlist.common.repo.OrderCommonYataRequest(r14, r1, "1.23.7");
        return r3;
    L139:
        r1 = null;
        goto L140
    L92:
        r14 = null;
        goto L93
    L88:
        r14 = null;
        goto L89
    L81:
        r14 = null;
    L84:
        r2 = 60;
        goto L85
    L58:
        r1 = "0";
        goto L59
    L54:
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r37, "scene");
        com.bytedance.android.shopping.orderlist.common.utils.b r1 = com.bytedance.android.shopping.orderlist.common.utils.e.a(r3, r37);
        r1 = r1.b;
        goto L55
    L50:
        r2 = null;
        goto L52
    L51:
        r2 = r22;
        goto L52
    L45:
        r4 = null;
        goto L47
    L46:
        r4 = r14;
    L41:
        com.bytedance.android.shopping.orderlist.common.utils.b r23 = com.bytedance.android.shopping.orderlist.common.utils.e.a(r3, r37);
        r2 = r23;
    L30:
        r22 = null;
    L24:
        r14 = null;
        goto L25
    L18:
        r21 = null;
        goto L19
    L14:
        r5 = null;
        goto L15
    L10:
        r20 = null;
        goto L11
    L6:
        r3 = r41;
        goto L7
    L100:
        r35 = r15;
        if (r40 == false) goto L134;
        final java.lang.String r12 = r36.x;
        com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel r3 = r36.d;
        if (r3 == null) goto L107;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r3.getStaticState();
        if (r3 == null) goto L107;
        java.lang.Boolean r3 = r3.c;
        final java.lang.Boolean r4 = r3;
    L108:
        com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel r3 = r36.d;
        if (r3 == null) goto L113;
        com.bytedance.android.shopping.orderlist.list.viewmodel.a r3 = r3.getStaticState();
        if (r3 == null) goto L113;
        java.lang.Boolean r3 = r3.d;
        final java.lang.Boolean r5 = r3;
    L114:
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r37, "appletPageScene");
        r14 = new java.util.LinkedHashMap();
        int r2 = com.bytedance.android.ec.sdk.ECSdk.a;
        java.lang.Object r2 = com.bytedance.android.ec.sdk.ECSdk.a(com.bytedance.android.ec.host.api.service.IECHostService.class);
        com.bytedance.android.ec.host.api.service.IECHostService r2 = (com.bytedance.android.ec.host.api.service.IECHostService) r2;
        if (r4 == null) goto L119;
        if (r5 == null) goto L119;
        com.bytedance.android.shopping.orderlist.common.utils.b r3 = null;
    L120:
        if (r4 != null) goto L124;
        if (r3 == null) goto L123;
        java.lang.Boolean r6 = r3.a;
        java.lang.Boolean r13 = r6;
    L125:
        if (r5 != null) goto L129;
        if (r3 == null) goto L128;
        boolean r3 = r3.b;
        java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3);
    L130:
        if (r3 == null) goto L132;
        boolean r1 = r3.booleanValue();
    L133:
        final boolean r15 = r1;
        kotlin.Lazy r1 = com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog.a;
        final java.lang.Boolean r2 = r13;
        kotlin.jvm.functions.Function0<java.lang.String> r6 = new com.bytedance.android.shopping.orderlist.list.network.OrderListRequestConfigKt$createOrderListAppletExParams$$inlined$let$lambda$1(r2, r15, r4, r5, r37, r12);
        com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog.c("OrderListRequestConfig", r6);
        r14.put("is_in_applet", r13);
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r15);
        r14.put("is_in_first_applet_page", r1);
        goto L135
    L132:
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r37, "scene");
        com.bytedance.android.shopping.orderlist.common.utils.b r1 = com.bytedance.android.shopping.orderlist.common.utils.e.a(r2, r37);
        r1 = r1.b;
        goto L133
    L128:
        r3 = null;
        goto L130
    L129:
        r3 = r5;
        goto L130
    L123:
        r13 = null;
        goto L125
    L124:
        r13 = r4;
    L119:
        r3 = com.bytedance.android.shopping.orderlist.common.utils.e.a(r2, r37);
    L113:
        r5 = null;
    L107:
        r4 = null;
        goto L108
    L134:
        r14 = null;
        goto L135
    }
}
