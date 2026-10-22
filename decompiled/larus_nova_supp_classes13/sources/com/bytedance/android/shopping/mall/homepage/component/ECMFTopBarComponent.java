package com.bytedance.android.shopping.mall.homepage.component;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.v;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.list.util.r;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.MallPreloadName;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.m;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SearchSuggestWord;
import com.bytedance.android.shopping.api.mall.model.SearchSuggestWordExtra;
import com.bytedance.android.shopping.api.mall.model.SearchSuggestWordItem;
import com.bytedance.android.shopping.api.mall.model.SearchSuggestWordParams;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.android.shopping.mall.homepage.MallUtil;
import com.bytedance.android.shopping.mall.homepage.preload.o;
import com.bytedance.android.shopping.mall.homepage.tools.q;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMFTopBarComponent extends com.bytedance.android.shopping.mall.homepage.component.b implements e93.c {
    public ECLynxCard b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public final List<o> h;
    public int i;
    public int j;
    public y93.d k;
    public long l;
    public long m;
    public final com.bytedance.android.ec.hybrid.list.util.d.a.a n;
    public View.OnLayoutChangeListener o;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECMFTopBarComponent a;
        public final /* synthetic */ ViewGroup b;

        public b(ECMFTopBarComponent r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p().j.setValue(Integer.valueOf(this.b.getHeight()));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECMFTopBarComponent a;
        public final /* synthetic */ String b;

        public c(ECMFTopBarComponent r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxCard r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            int r1 = com.bytedance.android.ec.hybrid.card.api.d.e;     // Catch: Throwable -> L6
            r0.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(this.b), true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements o {
        public final /* synthetic */ ECMFTopBarComponent a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        @Override // com.bytedance.android.shopping.mall.homepage.preload.o
        public final void onSuccess() {
            ECMFTopBarComponent r0 = this.a;
            String r1 = this.b;
            Map r2 = this.c;
            ECLynxCard r3 = r0.b;
            if (r3 == null) goto L6;
            int r4 = com.bytedance.android.ec.hybrid.card.api.d.e;
            r3.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r1, r2), true);
            return;
        }

        public d(ECMFTopBarComponent r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // u93.b, u93.c
    public final void onFirstScreen() {
        this.c = true;
        Logger.d("ECMFTopBarComponent", "onFirstScreen, renderFinished=" + this.d + ", visible=" + this.f + " ,firstScreened=true");
        u(true);
    }

    @Override // u93.b, u93.c
    public final void onStop() {
        r(false);
    }

    public ECMFTopBarComponent() {
        this.e = true;
        this.h = new ArrayList();
        this.i = 2;
        this.j = 1;
        this.k = new y93.d(51004, "topbar", 8388349);
        this.n = new com.bytedance.android.ec.hybrid.list.util.d.a.a(0);
    }

    @Override // u93.b, u93.c
    public final void g(boolean r3) {
        this.f = r3;
        Logger.d("ECMFTopBarComponent", "onVisibilityChange, renderFinished=" + this.d + ", visible=" + r3 + " ,firstScreened=" + this.c + ", isTopTabChange=false, isBottomTabChange=false");
        u(false);
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r2) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r3 = MallAbilityManager.a;
        MallAbilityManager.a(e93.c.class, this, o());
        ECFMiddleware r4 = p();
    }

    public final void r(boolean r6) {
        ViewGroup r0 = p().i();
        if (r0 != null) goto L5;
        return;
    L5:
        IECNativeHomeArgument r1 = q();
        if (r1 == null) goto L10;
        Map<String, String> r2 = r1.getLandingInfo();
        if (r2 == null) goto L10;
        String r3 = r2.get("schema");
    L11:
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        IHybridHostService r5 = com.bytedance.android.ec.hybrid.a.h();
        int r7 = -2;
        if (r5 != null) goto L14;
    L19:
        if (r4 == null) goto L21;
        r4.height = -2;
    L21:
        r0.setLayoutParams(r4);
        r0.post(new b(this, r0));
        return;
    L14:
        if (r5.isSearchNewAbSchema(r3) != true) goto L19;
        if (r4 == null) goto L21;
        if (r6 == false) goto L18;
        r7 = (int) UIUtils.dip2Px(r0.getContext(), 48.0f);
    L18:
        r4.height = r7;
    L10:
        r3 = null;
        goto L11
    }

    public final void s(String r5) {
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "handle search world success");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        SearchSuggestWord r3 = (SearchSuggestWord) new Gson().fromJson(r5, SearchSuggestWord.class);     // Catch: Throwable -> L14
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L17:
        if (r3 == null) goto L36;
        List<SearchSuggestWordItem> r4 = r3.getData();
        if (r4 == null) goto L36;
        SearchSuggestWordItem r6 = (SearchSuggestWordItem) CollectionsKt.getOrNull(r4, 0);
        if (r6 == null) goto L36;
        SearchSuggestWordParams r7 = r6.getParams();
        if (r7 == null) goto L36;
        SearchSuggestWordExtra r8 = r7.getExtra();
        if (r8 == null) goto L36;
        String r9 = r8.getLoadMore();
        if (r9 == null) goto L31;
        Integer r10 = StringsKt.toIntOrNull(r9);
        if (r10 == null) goto L31;
        this.i = r10.intValue();
    L31:
        String r11 = r8.getRefresh();
        if (r11 == null) goto L36;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L36;
        this.j = r12.intValue();
    L36:
        p().i.postDelayed(new c(this, r5), 500);
        return;
    L12:
        Throwable th = th;
    L16:
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        th = th;
        r3 = null;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    public final void u(boolean r14) {
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.b, "topBarVisibility: renderFinished=" + this.d + ", visible=" + this.f + " ,firstScreened=" + this.c + ", topBarFirstShow=" + this.e + ' ');
        ECHybridListEngine r1 = p().c;
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.c == false) goto L35;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.f == true) goto L10;
        boolean r2 = false;
    L11:
        v r3 = (v) r1.getAbility(v.class);
        if (r3 == null) goto L14;
        int r10 = r3.An();
    L15:
        v r4 = (v) r1.getAbility(v.class);
        ECMallFeed.f r12 = null;
        if (r4 == null) goto L18;
        String r5 = r4.r60();
    L19:
        boolean r9 = Intrinsics.areEqual(r5, "cache");
        ECLynxCard r6 = this.b;
        if (r6 == null) goto L22;
        boolean r7 = this.f;
        IVerseService r8 = ECLynxCard.f;
        ECLynxCard.m(r6, r7, "page", ECLynxCard.a.a(r14, false), r2, false, r9, r10, 144);
    L22:
        ECMallFeed.f r15 = o();
        if ((r15 instanceof ECMallFeed.f) == false) goto L26;
        r12 = r15;
    L26:
        ECMallFeed.f r13 = r12;
        if (r13 == null) goto L31;
        mf3.a r16 = r13.DE();
        if (r16 == null) goto L31;
        r16.a(this.f, r2);
    L31:
        if (r2 == false) goto L37;
        this.e = false;
        return;
    L37:
        return;
    L18:
        r5 = null;
        goto L19
    L14:
        r10 = 0;
        goto L15
    L10:
        r2 = this.e;
        goto L11
    }

    public final void w(String r5) {
        ECLynxCard r0 = this.b;     // Catch: Exception -> L16
        if (r0 == null) goto L20;
        int r1 = com.bytedance.android.ec.hybrid.card.api.d.e;     // Catch: Exception -> L16
        if (r5 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L16
    L14:
        r0.e(com.bytedance.android.ec.hybrid.card.api.d.a.a(MapsKt.mapOf(TuplesKt.to("skin", r6))), true);     // Catch: Exception -> L16
        return;
    L13:
        r6 = new JSONObject(r5);     // Catch: Exception -> L16
        goto L14
    L7:
        if (r5.length() == 0) goto L10;
        r3 = false;
        goto L11
    L20:
        return;
    L16:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.b(com.bytedance.android.ec.hybrid.log.mall.e.d.b, " handleDouyinSkinForLynx topbar update error ");
    }

    public final void x(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ECLynxCard r2 = this.b;
        if (r2 == null) goto L15;
        int r3 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r2.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r4), true);
        return;
    L15:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // u93.b, u93.c
    public final void c(List r3, int r4) {
        Intrinsics.checkNotNullParameter(GYLFetchType.LOAD_MORE, "fetchType");
        Intrinsics.checkNotNullParameter(r3, "apiKeyList");
        if (Intrinsics.areEqual(GYLFetchType.LOAD_MORE, GYLFetchType.LOAD_MORE) == false) goto L12;
        IECNativeHomeArgument r0 = q();
        if (r0 == null) goto L9;
        if (r0.getMallUpdateSuggestWorldByLynxCard() != true) goto L9;
        return;
    L9:
        if ((r4 % this.i) != 0) goto L14;
        ((ArrayList) r3).add("suggest_words");
        return;
    L14:
        return;
    }

    @Override // u93.b, u93.c
    public final void k(HomePageDTO r9, k r10) {
        Intrinsics.checkNotNullParameter(r9, "homePage");
        if (o().isAdded() == true) goto L5;
        return;
    L5:
        HomePageBffDTO r11 = r9.getBff();
        if (r11 == null) goto L12;
        SingleCardData r12 = r11.getTopBar();
        if (r12 == null) goto L12;
        if (r12.getSkipCache() != true) goto L12;
        return;
    L12:
        HomePageBffDTO r13 = r9.getBff();
        if (r13 == null) goto L17;
        SingleCardData r14 = r13.getTopBar();
        if (r14 == null) goto L17;
        String r15 = r14.getLynxSchema();
    L18:
        HomePageBffDTO r16 = r9.getBff();
        if (r16 == null) goto L23;
        SingleCardData r17 = r16.getTopBar();
        if (r17 == null) goto L23;
        String r18 = r17.getLynxData();
    L24:
        Context r2 = o().getContext();
        String r3 = p().e();
        if (r15 != null) goto L27;
    L30:
        boolean r5 = true;
    L31:
        if (r5 == true) goto L58;
        int r6 = s93.c.a;
        Object r4 = 0;
        IHybridHostService r7 = com.bytedance.android.ec.hybrid.a.h();
        if (r7 == null) goto L40;
        g r8 = r7.getHostAB();
        if (r8 == null) goto L40;
        Object r19 = r8.a("mall_search_straight_out_sync", r4);
        if (r19 == null) goto L40;
        r4 = r19;
    L40:
        Lazy r20 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_search_straight_out_sync, Value: " + r4);
        if (((Number) r4).intValue() != 1) goto L50;
        if (r2 == null) goto L50;
        m r0 = (m) p().f.getValue();
        if (r0 == null) goto L47;
        String r1 = (String) r0.d(MallPreloadName.LOAD_SEARCH_CACHE, MapsKt.mapOf(TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, r3)));
        if (r1 == null) goto L47;
    L48:
        if (r1 != null) goto L51;
        r1 = r18;
    L51:
        if (r1 == null) goto L54;
        r18 = r1;
    L54:
        if (r18 != null) goto L56;
        r18 = "";
    L56:
        t(r15, r18, null);
        return;
    L47:
        String r21 = r3 + "_lynx_search_cache";
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r21, "key");
        r1 = q.g(r2, q.c(r2, "ec_mall_lynx_cache"), r21, r21);
    L50:
        r1 = null;
        goto L51
    L58:
        return;
    L27:
        if (r15.length() == 0) goto L30;
        r5 = false;
    L23:
        r18 = null;
    L17:
        r15 = null;
        goto L18
    }

    @Override // u93.b, u93.c
    public final void m(Configuration r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        ECLynxCard r5 = this.b;
        if (r5 == null) goto L6;
        r5.c(r3, r4);
        return;
    }

    public final void t(String r10, String r11, Map<String, ? extends Object> r12) {
        final long r0 = System.currentTimeMillis();
        if (r10 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        ViewGroup r4 = p().i();
        if (r4 != null) goto L14;
        return;
    L14:
        IECNativeHomeArgument r5 = q();
        if (r5 != null) goto L17;
    L20:
        IECNativeHomeArgument r6 = q();
        String r7 = null;
        if (r6 == null) goto L23;
        Integer r8 = Integer.valueOf(r6.getRenderThreadStrategy());
    L24:
        String r13 = ToolsKt.n(r10, r8);
        b0.n(r4);
        IECNativeHomeArgument r9 = q();
        if (r9 == null) goto L29;
        Map<String, String> r14 = r9.getLandingInfo();
        if (r14 == null) goto L29;
        String r15 = r14.get("schema");
    L30:
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();
        if (r16 != null) goto L33;
    L40:
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "start init top_bar, state is " + this.g);
        if (this.b == null) goto L78;
        String r18 = "";
        if (r13 == null) goto L47;
        String r19 = UriProtector.getQueryParameter(UriProtector.parse(r13), "surl");
        if (r19 != null) goto L48;
        r19 = r13;
    L48:
        ECLynxCard r20 = this.b;
        if (r20 == null) goto L53;
        r7 = r20.a.k;
        if (r7 != null) goto L53;
        r7 = "";
    L53:
        if (r7 == null) goto L59;
        String r21 = UriProtector.getQueryParameter(UriProtector.parse(r7), "surl");
        if (r21 != null) goto L57;
        r18 = r7;
        goto L59
    L57:
        r18 = r21;
    L59:
        if ((!Intrinsics.areEqual(r19, r18)) == true) goto L78;
        ECLynxCard r22 = this.b;
        if (r22 != null) goto L64;
    L68:
        int r23 = this.g;
        if (r23 == 3) goto L76;
        if (r23 == 0) goto L76;
        if (r23 != 1) goto L74;
        ((ArrayList) this.h).add(new d(this, r11, r12));
    L74:
        final long r110 = System.currentTimeMillis();
        ThreadPoolHelper.d().execute(new ECMFTopBarComponent$recordMallTopBarInitDuration$1(r0, r110));
        return;
    L76:
        v(r4, r13, r11, r12);
        return;
    L64:
        if (this.g != 2) goto L68;
        if (r22 == null) goto L80;
        int r111 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r22.e(com.bytedance.android.ec.hybrid.card.api.d.a.c(r11, r12), true);
        return;
    L80:
        return;
    L47:
        r19 = "";
    L78:
        v(r4, r13, r11, r12);
        return;
    L33:
        if (r16.isSearchNewAbSchema(r15) != true) goto L40;
        Fragment r24 = o();
        if ((r24 instanceof ECMallFragment) == true) goto L37;
        r24 = null;
    L37:
        ECMallFragment r25 = (ECMallFragment) r24;
        if (r25 == null) goto L40;
        r25.xa0();
    L29:
        r15 = null;
        goto L30
    L23:
        r8 = null;
        goto L24
    L17:
        if (r5.getEnableTopBar() == true) goto L20;
        Lazy r112 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "disable init top bar");
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void v(ViewGroup r31, String r32, String r33, Map<String, ? extends Object> r34) {
        IECNativeHomeArgument r4 = q();
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getRenderThreadStrategy());
    L6:
        String r6 = ToolsKt.n(r32, r5);
        long r27 = System.currentTimeMillis();
        String r7 = p().e();
        Lazy r8 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "start preload topbar : schema: ".concat(r32));
        r31.removeAllViews();
        ECLynxCard r2 = new ECLynxCard();
        this.b = r2;
        this.k = y93.d.a(this.k, r6, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8388606);
        String r9 = (String) p().k.getValue();
        Pair[] r10 = new Pair[3];
        int r11 = s93.c.a;
        Object r12 = Boolean.FALSE;
        IHybridHostService r13 = com.bytedance.android.ec.hybrid.a.h();
        if (r13 == null) goto L12;
        g r14 = r13.getHostAB();
        if (r14 == null) goto L12;
        Object r15 = r14.a("ec_mall_search_box_enhance_legou", r12);
        if (r15 == null) goto L12;
    L13:
        com.bytedance.android.ec.hybrid.log.mall.c.a r16 = com.bytedance.android.ec.hybrid.log.mall.c.a.b;
        ECMallLogUtil.c(r16, "Key : ec_mall_search_box_enhance_legou, Value: " + r15);
        r10[0] = TuplesKt.to("ecMallSearchBoxEnhancdAB", r15);
        IHybridHostService r17 = com.bytedance.android.ec.hybrid.a.h();
        if (r17 == null) goto L19;
        g r18 = r17.getHostAB();
        if (r18 == null) goto L19;
        Object r19 = r18.a("ec_mall_search_box_animate_legou", r12);
        if (r19 == null) goto L19;
    L20:
        ECMallLogUtil.c(r16, "Key : ec_mall_search_box_animate_legou, Value: " + r19);
        r10[1] = TuplesKt.to("ecMallSearchBoxAnimateAB", r19);
        IHybridHostService r20 = com.bytedance.android.ec.hybrid.a.h();
        if (r20 == null) goto L28;
        g r21 = r20.getHostAB();
        if (r21 == null) goto L28;
        Object r22 = r21.a("ec_mall_first_screen_render_optimize", r12);
        if (r22 == null) goto L28;
        r12 = r22;
    L28:
        ECMallLogUtil.c(r16, "Key : ec_mall_first_screen_render_optimize, Value: " + r12);
        r10[2] = TuplesKt.to("ecFirstScreenRenderOptimizeAB", r12);
        Map r23 = MapsKt.mutableMapOf(r10);
        if (r34 == null) goto L31;
        r23.putAll(r34);
    L31:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(MallUtil.a(r2, null));
        ECLynxLoadParam.a r24 = new ECLynxLoadParam.a(r31.getContext(), o().getLifecycle(), r31, ECMallGeckoResourceHelper.a(r6));
        r24.j = r33;
        Intrinsics.checkNotNullParameter(r23, "appendData");
        r24.m = r23;
        r24.g(r7);
        r24.j(10000);
        ECFMiddleware r25 = p();
        r24.e(MapsKt.emptyMap());
        r24.a(CommonUtilKt.a(r6));
        r24.q = p().d();
        r24.t = b0.f();
        r24.b(p().l());
        ViewGroup.LayoutParams r26 = new ViewGroup.LayoutParams(-1, -2);
        Intrinsics.checkNotNullParameter(r26, "ecLayoutParams");
        r24.u = r26;
        ECMFTopBarComponent$preloadTopBar$builder$1 r28 = new ECMFTopBarComponent$preloadTopBar$builder$1(this, r31, this.b);
        com.bytedance.android.ec.hybrid.list.util.d.a.a r1 = this.n;
        Intrinsics.checkNotNullParameter(r1, "record");
        ((rj.a) r28).a = r1;
        Unit r29 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r28, "lifecycle");
        r24.o = r28;
        r24.D = p().h;
        r24.i(r.a(r9, 51004, 4));
        Intrinsics.checkNotNullParameter(r3, "ecBridgeMap");
        r24.r = r3;
        r24.h(r9);
        r24.y = 51004;
        ECLynxBuildUtilKt.a(r24, new uj.a(r7, r9));
        this.g = 1;
        ECLynxCard r30 = this.b;
        if (r30 == null) goto L34;
        r30.j(new ECLynxLoadParam(r24));
    L34:
        this.m = System.currentTimeMillis() - r27;
        return;
    L19:
        r19 = r12;
    L12:
        r15 = r12;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    @Override // u93.b, u93.c
    public final void e(String r3, ECHybridNetworkVO r4, String r5, boolean r6, HomePageDTO r7) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r5, "result");
        if (o().isAdded() == false) goto L38;
        HomePageBffDTO r8 = r7.getBff();
        Map<String, ? extends Object> r9 = null;
        if (r8 == null) goto L9;
        SingleCardData r10 = r8.getTopBar();
        if (r10 == null) goto L9;
        String r11 = r10.getLynxSchema();
    L10:
        HomePageBffDTO r12 = r7.getBff();
        if (r12 == null) goto L16;
        SingleCardData r13 = r12.getTopBar();
        if (r13 == null) goto L16;
        String r14 = r13.getLynxData();
        if (r14 == null) goto L16;
    L17:
        View r15 = o().getView();
        boolean r16 = false;
        if (r11 != null) goto L20;
    L23:
        boolean r1 = true;
    L24:
        if (r1 == true) goto L39;
        if (r15 == null) goto L40;
        Lazy r17 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.a.b, "initOrRefreshSucc, start handle topBar");
        String r18 = p().q.b;
        Lazy r2 = HybridAppInfoService.a;
        if (HybridAppInfoService.h() == false) goto L36;
        if (r18 != null) goto L30;
    L31:
        r16 = true;
    L32:
        if (r16 == false) goto L34;
        JSONObject r19 = new JSONObject();
    L35:
        r9 = MapsKt.mapOf(TuplesKt.to("skin", r19));
        goto L36
    L34:
        r19 = new JSONObject(r18);
        goto L35
    L30:
        if (r18.length() != 0) goto L32;
    L36:
        t(r11, r14, r9);
        return;
    L40:
        return;
    L39:
        return;
    L20:
        if (r11.length() == 0) goto L23;
        r1 = false;
    L16:
        r14 = "";
    L9:
        r11 = null;
        goto L10
    }
}
