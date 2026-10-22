package com.bytedance.android.shopping.mall.homepage.pagecard;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.list.util.r;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.mall.homepage.pagecard.bridge.LynxSubscribeEventListBridge;
import com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.DynamicParamsController;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.forest.utils.h;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PageCard {
    public static final /* synthetic */ int p = 0;
    public ECLynxCard a;
    public String b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public ConcurrentHashMap<String, Map<String, Object>> g;
    public Function0<Unit> h;
    public final ArrayList<com.bytedance.android.ec.hybrid.card.event.b> i;
    public final ArrayList<Pair<String, Map<String, Object>>> j;
    public Disposable k;
    public final List<IECLynxCardLifeCycle> l;
    public final nf3.a m;
    public boolean n;
    public volatile boolean o;

    public static final class a {
    }

    public static final class b extends rj.a {
        public final /* synthetic */ PageCard d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ ViewGroup g;
        public final /* synthetic */ Lifecycle h;
        public final /* synthetic */ Ref.ObjectRef i;
        public final /* synthetic */ Map j;
        public final /* synthetic */ String k;
        public final /* synthetic */ Map l;
        public final /* synthetic */ Map m;
        public final /* synthetic */ boolean n;

        public final void onFirstScreen() {
            super.onFirstScreen();
            if (this.d.a == null) goto L8;
            IVerseService r0 = ECLynxCard.f;
            if (r0 == null) goto L9;
            r0.getMallDebugService();
            return;
        L9:
            return;
        }

        public final void onLoadSuccess() {
            super.onLoadSuccess();
            this.d.getClass();
            nf3.a r0 = this.d.m;
            r0.a.setTLoadFinish(Long.valueOf(System.currentTimeMillis()));
            r0.a.setStatus(1);
            Iterator r1 = ((ArrayList) this.d.l).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((IECLynxCardLifeCycle) r1.next()).onLoadSuccess();
            goto L4
        L6:
            Lazy r2 = ECMallLogUtil.a;
            ECMallLogUtil.c(k.b.b, "pageCard onLoadSuccess");
        }

        public final void onRuntimeReady() {
            super.onRuntimeReady();
            Lazy r0 = ECMallLogUtil.a;
            ECMallLogUtil.c(k.b.b, "pageCard onRuntimeReady");
            this.d.getClass();
        }

        public final void onReceivedError(com.bytedance.lynx.service.model.b r4) {
            super.onReceivedError(r4);
            Lazy r0 = ECMallLogUtil.a;
            ECMallLogUtil.c(k.b.b, "pageCard onReceivedError , type = " + r4);
        }

        public final void onLoadFailed(ECLynxCardErrorType r18, Integer r19, String r20) {
            Intrinsics.checkNotNullParameter(r18, "type");
            super.onLoadFailed(r18, r19, r20);
            if (this.e == true) goto L5;
            this.d.b(this.f, this.g, this.h, (String) this.i.element, true, this.j, this.k, this.l, this.m, "", this.n);
            Lazy r4 = ECMallLogUtil.a;
            ECMallLogUtil.c(k.b.b, "pageCard onLoadFailed , retry");
        L5:
            nf3.a r5 = this.d.m;
            r5.a.setStatus(2);
            r5.a.setErrorCode(r19);
            r5.a.setErrorMsg(r20);
            r5.b();
            Iterator r6 = ((ArrayList) this.d.l).iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            ((IECLynxCardLifeCycle) r6.next()).onLoadFailed(r18, r19, r20);
            goto L7
        L9:
            Lazy r7 = ECMallLogUtil.a;
            ECMallLogUtil.c(k.b.b, "pageCard onLoadFailed , type = " + r18 + " , errorCode =" + r19 + " , errorMsg = " + r20);
        }

        public b(PageCard r1, boolean r2, Context r3, ViewGroup r4, Lifecycle r5, Ref.ObjectRef r6, Map r7, String r8, Map r9, Map r10, boolean r11, ECLynxCard r12) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            this.j = r7;
            this.k = r8;
            this.l = r9;
            this.m = r10;
            this.n = r11;
            super(r12, "page_card");
        }
    }

    static {
    }

    public final boolean a() {
        if (((Number) this.e.getValue()).intValue() == 1) goto L5;
    L9:
        return false;
    L5:
        if (((com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) this.f.getValue()).g == false) goto L9;
        if (this.c == false) goto L9;
        return true;
    }

    public final boolean c() {
        DynamicParamsController r0 = (DynamicParamsController) this.d.getValue();
        if (r0.c.isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.a.isEmpty() == false) goto L9;
        if (r0.b.isEmpty() == false) goto L9;
        return true;
    }

    public PageCard() {
        this.d = LazyKt.lazy(PageCard$dynamicParamsController$2.INSTANCE);
        this.e = LazyKt.lazy(PageCard$useWhiteBoardDynamicParams$2.INSTANCE);
        this.f = LazyKt.lazy(PageCard$whiteBoardDynamicParamsController$2.INSTANCE);
        this.g = new ConcurrentHashMap();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.l = new ArrayList();
        this.m = new nf3.a();
    }

    public final void d(final String r12, final Map<String, ? extends Object> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.d(k.b.b, new PageCard$sendGlobalEvent$1(r12, r13));
        long r4 = System.currentTimeMillis();
        String r1 = this.b;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        com.bytedance.android.ec.hybrid.card.event.b r2 = new com.bytedance.android.ec.hybrid.card.event.b(r12, r4, r1, false, r13, false, 32);
        if (this.n == true) goto L9;
        if (r14 == false) goto L9;
        this.i.add(r2);
        return;
    L9:
        ECEventCenter.c(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(PageCard r0, String r1, Map r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.d(r1, r2, false);
    }

    public final void b(Context r22, ViewGroup r23, Lifecycle r24, String r25, boolean r26, Map<String, ? extends Object> r27, String r28, Map<String, String> r29, Map<String, ? extends Object> r30, String r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "container");
        Intrinsics.checkNotNullParameter(r24, "lifecycle");
        Intrinsics.checkNotNullParameter(r27, "globalProps");
        Intrinsics.checkNotNullParameter(r28, "bid");
        Intrinsics.checkNotNullParameter(r29, "consumerMonitor");
        Intrinsics.checkNotNullParameter(r31, "initData");
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        int r0 = d.c;
        r6.element = d.a.a();
        if (h.a(r25) == false) goto L6;
        r6.element = r25;
        nf3.a r1 = this.m;
        r1.getClass();
        Intrinsics.checkNotNullParameter("settings", "type");
        r1.a.setSchemaType("settings");
    L8:
        Lazy r2 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.b.b, "pageCard load,schema = " + ((String) r6.element));
        nf3.a r3 = this.m;
        boolean r4 = r26 ^ true;
        r3.a.setTLoadStart(Long.valueOf(System.currentTimeMillis()));
        boolean r16 = true;
        if (r4 == false) goto L11;
        r3.a.setFirstLoad(1);
    L12:
        Lazy r5 = ECMallGeckoResourceHelper.a;
        String r7 = (String) r6.element;
        Intrinsics.checkNotNull(r7);
        ECLynxLoadParam.a r11 = new ECLynxLoadParam.a(r22, r24, r23, ECMallGeckoResourceHelper.a(r7));
        Object r8 = r27.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        Object r17 = null;
        if ((r8 instanceof String) == true) goto L15;
        r8 = null;
    L15:
        r11.g((String) r8);
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r9, "ecLayoutParams");
        r11.u = r9;
        Pair[] r10 = new Pair[5];
        r10[0] = TuplesKt.to("ec.mallDynamicParamsChanged", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$1(this), "ec.mallDynamicParamsChanged"));
        r10[1] = TuplesKt.to("ec.mallFlushDynamicParam", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$2(this), "ec.mallFlushDynamicParam"));
        r10[2] = TuplesKt.to("ec.mallSyncDynamicParams", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$3(this), "ec.mallSyncDynamicParams"));
        com.bytedance.android.shopping.mall.homepage.pagecard.b r12 = new com.bytedance.android.shopping.mall.homepage.pagecard.b(this);
        String r13 = this.b;
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        r10[3] = TuplesKt.to("ec.subscribeEventList", new LynxSubscribeEventListBridge(r12, r13, String.valueOf(hashCode()), new PageCard$makeJsBridgeMap$5(this)));
        String r14 = this.b;
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        r10[4] = TuplesKt.to("ec.unsubscribeEventList", new com.bytedance.android.shopping.mall.homepage.pagecard.bridge.a(r14, String.valueOf(hashCode())));
        r11.d(MapsKt.mutableMapOf(r10));
        r11.t = r28;
        Intrinsics.checkNotNullParameter(r29, "map");
        r11.s = r29;
        String r15 = this.b;
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        Intrinsics.checkNotNullParameter(r15, "sceneID");
        r11.z = r15;
        Object r18 = r27.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if ((r18 instanceof String) == false) goto L28;
        r17 = r18;
    L28:
        String r19 = (String) r17;
        String r20 = this.b;
        if (r20 != null) goto L31;
        r20 = "";
    L31:
        ECLynxBuildUtilKt.a(r11, new uj.a(r19, r20));
        Intrinsics.checkNotNullParameter(r27, "ecGlobalProps");
        r11.p = r27;
        r11.H = r32;
        Map r21 = r.a;
        String r33 = this.b;
        if (r33 != null) goto L34;
        r33 = "no scene";
    L34:
        r11.i(r.a(r33, 0, 6));
        b r34 = new b(this, r26, r22, r23, r24, r6, r27, r28, r29, r30, r32, this.a);
        Intrinsics.checkNotNullParameter(r34, "lifecycle");
        r11.o = r34;
        if (r31.length() > 0) goto L38;
        r16 = false;
    L38:
        if (r16 == false) goto L41;
        r11.j = r31;
    L41:
        if (r30 == null) goto L43;
        r11.q = r30;
    L43:
        ECLynxCard r35 = this.a;
        if (r35 == null) goto L46;
        r35.j(new ECLynxLoadParam(r11));
    L46:
        this.m.a.setTNativeLoadFinish(Long.valueOf(System.currentTimeMillis()));
        return;
    L11:
        r3.a.setFirstLoad(2);
        goto L12
    L6:
        if (h.a((String) r6.element) == false) goto L49;
        nf3.a r36 = this.m;
        r36.getClass();
        Intrinsics.checkNotNullParameter("default", "type");
        r36.a.setSchemaType("default");
        goto L8
    }
}
