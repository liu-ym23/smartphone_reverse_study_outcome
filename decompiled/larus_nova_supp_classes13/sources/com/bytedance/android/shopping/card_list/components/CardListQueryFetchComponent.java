package com.bytedance.android.shopping.card_list.components;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.common_params.QueryScene;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListQueryFetchComponent extends b {
    public static final /* synthetic */ int x = 0;
    public final MutableLiveData<p> d;
    public final MutableLiveData e;
    public final MutableLiveData<o> f;
    public final MutableLiveData g;
    public final long h;
    public final Lazy i;
    public final String j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final CardListObjectContainer v;
    public final com.bytedance.android.shopping.card_list.repo.a w;

    public static final class a {
    }

    static {
    }

    public final CardListYataMonitorManager j() {
        return (CardListYataMonitorManager) this.k.getValue();
    }

    public final String k() {
        return (String) this.m.getValue();
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onCreate() {
        super.onCreate();
        s0.c(this);
    }

    @Override // com.bytedance.android.shopping.card_list.components.b, com.bytedance.android.shopping.card_list.components.a
    public final void onDestroy() {
        super.onDestroy();
        s0.e(this);
    }

    public final void h(com.bytedance.android.shopping.card_list.router.d r10) {
        String r0 = com.bytedance.android.shopping.card_list.monitor.a.a;
        ConcurrentHashMap<String, String> r1 = com.bytedance.android.shopping.base.event.a.a;
        com.bytedance.android.shopping.base.event.a.d(com.bytedance.android.shopping.card_list.monitor.a.a, "render", "start", null, false, null, 56);
        boolean r3 = false;
        if ((!Intrinsics.areEqual(r10.a, k())) == true) goto L5;
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r2 = r10.b;
        com.bytedance.android.shopping.card_list.container.b r4 = this.v.e.h;
        r4.a = false;
        r4.c = true;
        CardListRunCatchExtKt.b(this.j, "onGetQuerySuccess", new CardListQueryFetchComponent$queryFirstPaint$1(this, r2), new CardListQueryFetchComponent$queryFirstPaint$2(this));
        CardMultiUpdateComponent r5 = (CardMultiUpdateComponent) this.i.getValue();
        if (r5 == null) goto L15;
        r5.m(0, r2);
    L15:
        Map<String, Map<String, Long>> r6 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(k(), "OnQueryEnd");
        boolean r7 = true;
    L16:
        if (r7 == true) goto L18;
        return;
    L18:
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r11 = r10.b;
        com.bytedance.android.shopping.card_list.container.b r8 = this.v.e.h;
        if (r8.e == true) goto L21;
    L27:
        Map<String, Map<String, Long>> r9 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(k(), "StartOnQueryEnd");
        CardListPageCallBackComponent r12 = (CardListPageCallBackComponent) this.o.getValue();
        if (r12 == null) goto L30;
        r12.o("first_enter", null);
    L30:
        com.bytedance.android.shopping.card_list.common_params.a r13 = this.v.e;
        r13.h.a = false;
        final boolean r14 = r13.j;
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r15 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListQueryFetchComponent$onFirstQueryEnd$1(this, r14, r11));
        CardMultiUpdateComponent r16 = (CardMultiUpdateComponent) this.i.getValue();
        if (r16 == null) goto L37;
        if (r11 != null) goto L34;
    L36:
        r16.j(r3);
        goto L37
    L34:
        if (com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r11) != true) goto L36;
        r3 = true;
    L37:
        this.v.e.h.d = true;
        return;
    L21:
        if (r8.d == true) goto L27;
        long r17 = System.currentTimeMillis() - this.h;
        CardListYataMonitorManager r18 = j();
        if (r18 == null) goto L27;
        com.bytedance.android.shopping.card_list.monitor.error.a r19 = r18.e;
        if (r19 == null) goto L27;
        CardListErrorMonitorType r20 = CardListErrorMonitorType.LONG_FIRST_QUERY;
        JSONObject r21 = new JSONObject();
        TuplesKt.to("page_time", Long.valueOf(r17));
        Unit r22 = Unit.INSTANCE;
        r19.b(r20, "BaseCardListContainer-long first query", r21);
        goto L27
    L5:
        if (this.v.e.h.d == true) goto L11;
        CardListYataMonitorManager r23 = j();
        if (r23 == null) goto L11;
        com.bytedance.android.shopping.card_list.monitor.error.a r24 = r23.e;
        if (r24 == null) goto L11;
        CardListErrorMonitorType r25 = CardListErrorMonitorType.CARD_LIST_SESSION_ID_MISMATCH;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r26 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r24.b(r25, "BaseCardListContainer-prefetch-mismatch", null);
    L11:
        r7 = false;
        goto L16
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onFirstQuerySuccess(final com.bytedance.android.shopping.card_list.router.d r2) {
        Intrinsics.checkNotNullParameter(r2, "cardListPrefetchResponse");
        if (this.v.e.h.a == false) goto L5;
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new AnonymousClass1(this, r2));
    L6:
        s0.d(r2.getClass());
        return;
    L5:
        h(r2);
        goto L6
    }

    public CardListQueryFetchComponent(CardListObjectContainer r3, com.bytedance.android.shopping.card_list.repo.a r4) {
        Intrinsics.checkNotNullParameter(r3, "objectContainer");
        Intrinsics.checkNotNullParameter(r4, "apiParams");
        super(r3);
        this.v = r3;
        this.w = r4;
        MutableLiveData<p> r5 = new MutableLiveData();
        this.d = r5;
        this.e = r5;
        MutableLiveData<o> r6 = new MutableLiveData();
        this.f = r6;
        this.g = r6;
        this.h = System.currentTimeMillis();
        this.i = LazyKt.lazy(new CardListQueryFetchComponent$cardMultiUpdateComponent$2(this));
        CardPassThroughData r7 = r3.e.a;
        if (r7 == null) goto L5;
        String r8 = r7.getMonitorId();
    L6:
        this.j = r8;
        this.k = LazyKt.lazy(new CardListQueryFetchComponent$monitorManager$2(this));
        this.l = LazyKt.lazy(new CardListQueryFetchComponent$sourceType$2(this));
        this.m = LazyKt.lazy(new CardListQueryFetchComponent$sessionId$2(this));
        this.n = LazyKt.lazy(new CardListQueryFetchComponent$_pageInfo$2(this));
        this.o = LazyKt.lazy(new CardListQueryFetchComponent$cardListPageCallBackComponent$2(this));
        this.p = LazyKt.lazy(new CardListQueryFetchComponent$trackerComponent$2(this));
        this.q = LazyKt.lazy(new CardListQueryFetchComponent$bodyComponent$2(this));
        this.r = LazyKt.lazy(new CardListQueryFetchComponent$errorComponent$2(this));
        this.s = LazyKt.lazy(new CardListQueryFetchComponent$loadMoreComponent$2(this));
        this.t = LazyKt.lazy(new CardListQueryFetchComponent$backToTopBtnManageComponent$2(this));
        this.u = LazyKt.lazy(new CardListQueryFetchComponent$yataPerfManager$2(this));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void i(final boolean r12, @QueryScene final String r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "queryScene");
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListQueryFetchComponent$doQuery$1(this, r13, r12));
        CardMultiUpdateComponent r15 = (CardMultiUpdateComponent) this.i.getValue();
        if (r15 == null) goto L23;
        long r1 = r15.h();
        CardListRepository r16 = CardListRepository.INSTANCE;
        String r2 = this.w.a;
        LinkedHashMap r3 = new LinkedHashMap();
        CardPassThroughData r4 = this.v.e.a;
        if (r4 == null) goto L9;
        HashMap<String, String> r5 = r4.getSchemaParamsOrCreate();
        if (r5 == null) goto L9;
        r3.putAll(r5);
    L9:
        r3.put("query_scene", r13);
        r3.put("version_code", Long.valueOf(r1));
        r3.putAll(this.w.c);
        Unit r6 = Unit.INSTANCE;
        Map r7 = MapsKt.toMap(r3);
        String r8 = ((AndroidYaTaInstance) this.v.e.c.invoke()).m();
        if (r8 != null) goto L12;
        String r9 = "";
    L13:
        PackYataSdkConfig r10 = com.bytedance.kmp.ec.yata.common.init.b.a;
        AndroidYaTaInstance r11 = (AndroidYaTaInstance) this.v.e.c.invoke();
        r11.getClass();
        String r17 = ea6.b.a(ea6.b.b(r11, null), r11, null, null);
        if (r17 != null) goto L16;
        String r18 = "";
    L17:
        YataPageInfo r19 = (YataPageInfo) this.n.getValue();
        if (r19 == null) goto L20;
        Map r20 = r19.addAndGetYataProtocolInfo();
    L21:
        r16.getQuery(r2, new ab3.b(r7, r9, r18, r20, "1.23.7"), this.w.b).subscribeOn(Schedulers.newThread()).subscribe(new CardListQueryFetchComponent$doQuery$$inlined$let$lambda$1(r1, this, r13, r14));
        return;
    L20:
        r20 = null;
        goto L21
    L16:
        r18 = r17;
        goto L17
    L12:
        r9 = r8;
        goto L13
    }

    public static final void g(final CardListQueryFetchComponent r6, Throwable r7, final String r8, long r9) {
        CardMultiUpdateComponent r0 = (CardMultiUpdateComponent) r6.i.getValue();
        if (r0 == null) goto L25;
        boolean r4 = true;
        if (r0.i(r9, null) != true) goto L25;
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r1 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListQueryFetchComponent$onGetQueryErr$1(r6, r8));
        String r2 = r7.getMessage();
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
    L14:
        if (r4 == false) goto L16;
        EnsureManager.ensureNotReachHere(r7);
        r2 = ExceptionsKt.stackTraceToString(r7);
    L16:
        StringBuilder r5 = new StringBuilder();
        r5.append(r2);
        r5.append("; cause: ");
        Throwable r10 = r7.getCause();
        if (r10 == null) goto L19;
        String r11 = r10.getMessage();
    L20:
        r5.append(r11);
        String r12 = r5.toString();
        CardListYataMonitorManager r13 = r6.j();
        if (r13 == null) goto L31;
        com.bytedance.android.shopping.card_list.monitor.error.a r14 = r13.e;
        if (r14 == null) goto L32;
        CardListErrorMonitorType r3 = CardListErrorMonitorType.GET_QUERY_RESPONSE_ERROR;
        String r15 = "queryScene: " + r8 + "; versionCode: " + r9 + "; errorMsg: " + r12;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r16 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r14.b(r3, r15, null);
        return;
    L32:
        return;
    L31:
        return;
    L19:
        r11 = null;
    L25:
        CardListYataMonitorManager r17 = r6.j();
        if (r17 == null) goto L34;
        com.bytedance.android.shopping.card_list.monitor.error.a r18 = r17.e;
        if (r18 == null) goto L35;
        CardListErrorMonitorType r19 = CardListErrorMonitorType.GET_QUERY_REJECT;
        String r20 = "queryScene: " + r8 + "; versionCode: " + r9;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r21 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r18.b(r19, r20, null);
        return;
    L35:
        return;
    }
}
