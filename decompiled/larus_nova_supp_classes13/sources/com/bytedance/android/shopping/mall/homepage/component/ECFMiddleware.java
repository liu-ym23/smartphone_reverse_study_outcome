package com.bytedance.android.shopping.mall.homepage.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.api.mall.model.SkinConfigPage;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.android.shopping.mall.homepage.MallUtil;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.bytedance.android.shopping.mall.homepage.tools.q;
import com.bytedance.android.shopping.mall.utils.ECMallSkinManager;
import com.bytedance.android.shopping.mall.widget.ECDetectableFrameLayout;
import com.bytedance.android.shopping.mall.widget.ECTouchEventDetector;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECFMiddleware extends u93.d {
    public final bf3.a a;
    public ECMallFeed b;
    public ECHybridListEngine c;
    public final Lazy d;
    public Long e;
    public final Lazy f;
    public final jf3.c g;
    public final ik.a h;
    public final Handler i;
    public final MutableLiveData<Integer> j;
    public final Lazy k;
    public boolean l;
    public String m;
    public ViewGroup n;
    public ViewGroup o;
    public String p;
    public final ECMallSkinManager q;
    public af3.e r;
    public final Lazy s;
    public String t;
    public final com.bytedance.android.shopping.mall.homepage.pagecard.d u;
    public final Lazy v;
    public final Lazy w;
    public volatile ck.a x;
    public final a y;
    public final ECMallFragment z;

    public static final class a extends ECTouchEventDetector {
        public final /* synthetic */ ECFMiddleware h;

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void a() {
            d(false);
        }

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void b() {
            d(true);
        }

        public a(ECFMiddleware r1) {
            this.h = r1;
        }

        public final void d(boolean r11) {
            ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mallFeedDidClick", System.currentTimeMillis(), (String) this.h.k.getValue(), false, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_long_click", Boolean.valueOf(r11))}), false, 40));
        }

        @Override // com.bytedance.android.shopping.mall.widget.ECTouchEventDetector
        public final void c(int r2, int r3, int r4, int r5) {
            ECMallFeed r0 = this.h.b;
            if (r0 == null) goto L6;
            r0.Q(r2, r3, r4, r5);
            return;
        }
    }

    public final IECNativeHomeArgument f() {
        return (IECNativeHomeArgument) this.d.getValue();
    }

    public final String a() {
        if (this.q.a() == false) goto L5;
        return "dark";
    L5:
        return "light";
    }

    public final String b() {
        SkinConfig r0 = (SkinConfig) new Gson().fromJson(this.q.b, SkinConfig.class);     // Catch: Exception -> L4
    L13:
        if (k() == false) goto L20;
        if (r0 == null) goto L26;
        SkinConfigStyle r1 = r0.getDark();
        if (r1 == null) goto L26;
        SkinConfigPage r2 = r1.getPageStyle();
        if (r2 == null) goto L26;
    L30:
        return r2.getBgUrl();
    L26:
        return null;
    L20:
        if (r0 == null) goto L26;
        SkinConfigStyle r3 = r0.getLight();
        if (r3 == null) goto L26;
        r2 = r3.getPageStyle();
        if (r2 == null) goto L26;
    L4:
        e = move-exception;
        SkinConfig r7 = new SkinConfig(null, null, null, 7, null);
        IHybridHostService r4 = com.bytedance.android.ec.hybrid.a.h();
        if (r4 == null) goto L11;
        String r5 = e.getMessage();
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r4.ensureNotReachHere(r5);
    L11:
        r0 = r7;
        goto L13
    }

    public final String c() {
        if (this.p.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Object r1 = null;
        boolean r2 = r1 instanceof String;
        String r3 = (String) null;
        this.p = "";
    L9:
        return this.p;
    L5:
        r0 = false;
        goto L6
    }

    public final String e() {
        if (this.m.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        Object r1 = null;
        boolean r2 = r1 instanceof String;
        String r3 = (String) null;
        this.m = "homepage";
    L9:
        return this.m;
    L5:
        r0 = false;
        goto L6
    }

    public final ck.a g() {
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L8;
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.e.b, "popupUseNewComponent = true, use popupLayerAbility");
        bf3.a r1 = this.a;
        if (r1.a != null) goto L10;
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r2 = MallAbilityManager.a;
        r1.a = (e93.b) MallAbilityManager.b(e93.b.class, r1.b);
    L10:
        return r1.a;
    L8:
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.e.b, "popupUseNewComponent = false, use popupManager");
        return this.x;
    }

    public final ViewGroup h() {
        if (this.o != null) goto L10;
        View r0 = this.z.getView();
        if (r0 == null) goto L7;
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131370789);
    L8:
        this.o = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.o;
    }

    public final ViewGroup i() {
        if (this.n != null) goto L16;
        View r0 = this.z.getView();
        ViewGroup r1 = null;
        if (r0 == null) goto L7;
        ViewGroup r2 = (ViewGroup) r0.findViewById(2131389246);
    L8:
        this.n = r2;
        if ((r2 instanceof ECDetectableFrameLayout) == false) goto L12;
        r1 = r2;
    L12:
        ECDetectableFrameLayout r3 = (ECDetectableFrameLayout) r1;
        if (r3 == null) goto L16;
        r3.setTouchEventDetector(this.y);
        goto L16
    L7:
        r2 = null;
    L16:
        return this.n;
    }

    public final String j() {
        if (this.t.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        Object r1 = MapsKt.emptyMap().get("tab_id");
        if (r1 == null) goto L11;
        String r2 = r1.toString();
        if (r2 == null) goto L11;
    L12:
        this.t = r2;
    L11:
        r2 = "0";
    L14:
        return this.t;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean k() {
        return this.q.a();
    }

    public final Map<String, String> l() {
        Lazy r0 = MallUtil.a;
        Long r1 = this.e;
        String r2 = e();
        String r3 = c();
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        if (r1 == null) goto L6;
        String r4 = String.valueOf(r1.longValue());
        if (r4 == null) goto L6;
    L8:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("na_offline_version", r4), TuplesKt.to("na_page_name", r2), TuplesKt.to(SimilarProductParam.ENTER_FROM, r3), TuplesKt.to("mall_hybrid_monitor_vid", (String) MallUtil.a.getValue())});
    L6:
        r4 = "-1";
        goto L8
    }

    public final com.bytedance.android.shopping.mall.homepage.pagecard.c m() {
        return this.u.a();
    }

    public final Map<String, Object> d() {
        String r0 = a();
        Lazy r1 = HybridAppInfoService.a;
        if (HybridAppInfoService.h() == true) goto L7;
        return null;
    L7:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appTheme", r0)});
    }

    public ECFMiddleware(ECMallFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.z = r2;
        this.a = new bf3.a(r2);
        this.d = LazyKt.lazy(new ECFMiddleware$parentArguments$2(this));
        this.f = LazyKt.lazy(new ECFMiddleware$preloadTaskManager$2(this));
        this.g = new jf3.c();
        this.h = new ik.a();
        this.i = new Handler(Looper.getMainLooper());
        this.j = new MutableLiveData();
        this.k = LazyKt.lazy(new ECFMiddleware$sceneID$2(this));
        this.m = "";
        this.p = "";
        this.q = new ECMallSkinManager(this);
        this.s = LazyKt.lazy(new ECFMiddleware$favoriteSectionHelper$2(this));
        this.t = "";
        this.u = new com.bytedance.android.shopping.mall.homepage.pagecard.d();
        this.v = LazyKt.lazy(ECFMiddleware$popupUseNewComponent$2.INSTANCE);
        this.w = LazyKt.lazy(ECFMiddleware$enableSkinCMS$2.INSTANCE);
        this.y = new a(this);
    }

    public final void n(y93.d r25) {
        Intrinsics.checkNotNullParameter(r25, "monitorBean");
        if (r25.a == false) goto L5;
        return;
    L5:
        JSONObject r15 = new JSONObject();
        r15.put("type", "LYNX_RENDER_LOG");
        r15.put("res_version", this.e);
        int r2 = f93.a.a;
        f93.a.c(r15, this.z.fa0("c0.d0", false, null));
        r15.put(PdpOpenThirdParam.KEY_PAGE_NAME, e());
        r15.putOpt(SimilarProductParam.ENTER_FROM, c());
        r15.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        String r3 = ((ECMallFavoriteSectionHelper) this.s.getValue()).v;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r15.put("log_id", r3);
        r15.put("lynx_schema", r25.f());
        r15.put("error_msg", r25.b());
        r15.put("perf_dict", r25.e());
        r15.put("detail", new JSONObject(GsonProtectorUtils.toJson(new Gson(), y93.d.a(r25, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388078))));
        l r1 = l.a;
        IECNativeHomeArgument r4 = f();
        if (r4 == null) goto L11;
        Integer r13 = r4.getReportSlardar();
    L12:
        l.b(r1, r15, r13, false, 12);
        return;
    L11:
        r13 = null;
        goto L12
    }

    public final void o(String r8, boolean r9) {
        ECMallSkinManager r0 = this.q;
        r0.b = r8;
        String r1 = null;
        Boolean r10 = com.bytedance.android.shopping.mall.background.a.a(r8, null).isDarkMode();
        Boolean r2 = Boolean.TRUE;
        boolean r11 = Intrinsics.areEqual(r10, r2);
        boolean r4 = true;
        if ((!Intrinsics.areEqual((Boolean) r0.b().getValue(), Boolean.valueOf(r11))) == false) goto L5;
        r0.b().setValue(Boolean.valueOf(r11));
    L5:
        Context r12 = r0.e.z.getContext();
        if (r9 == true) goto L34;
        if (r12 == null) goto L35;
        String r13 = r0.b;
        ECFMiddleware r3 = r0.e;
        if (Intrinsics.areEqual(r3.e(), MallPageName.X_TAB_MALL) == true) goto L14;
        IECNativeHomeArgument r5 = r3.f();
        if (r5 == null) goto L14;
        r1 = r5.getDataEngineTag();
    L14:
        Intrinsics.checkNotNullParameter(r12, "context");
        StringBuilder r6 = new StringBuilder();
        if (r1 != null) goto L17;
    L20:
        if (r4 == false) goto L22;
        r1 = "default";
    L22:
        r6.append(r1);
        r6.append("_douyin_skin");
        String r7 = r6.toString();
        if (r13 == null) goto L25;
        q.f(r12, r7, r13);
    L29:
        if (((Boolean) r0.d.getValue()).booleanValue() == false) goto L36;
        IHybridHostService r14 = com.bytedance.android.ec.hybrid.a.h();
        if (r14 == null) goto L37;
        r14.updateThemeStorage(r12, r0.e.e(), Intrinsics.areEqual((Boolean) r0.b().getValue(), r2));
        return;
    L37:
        return;
    L36:
        return;
    L25:
        if (q.c(r12, "ec_mall_cache_storage").contains(r7) == false) goto L29;
        q.c(r12, "ec_mall_cache_storage").edit().remove(r7).apply();
        goto L29
    L17:
        if (r1.length() == 0) goto L20;
        r4 = false;
        goto L20
    L35:
        return;
    }
}
