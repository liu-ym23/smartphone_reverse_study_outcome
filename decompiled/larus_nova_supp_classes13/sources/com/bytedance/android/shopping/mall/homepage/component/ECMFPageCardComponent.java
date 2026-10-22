package com.bytedance.android.shopping.mall.homepage.component;

import aa3.i;
import af3.f;
import af3.g;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECNativeHomeArgument;
import com.bytedance.android.shopping.api.mall.ability.MallAbilityManager;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.api.mall.model.SingleCardData;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment;
import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.android.shopping.mall.homepage.tools.PageCardTimer;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMFPageCardComponent extends com.bytedance.android.shopping.mall.homepage.component.b implements bf3.b {
    public final PageCardTimer b;
    public FrameLayout c;
    public boolean d;
    public boolean e;
    public final jf3.d f;

    public static final class a implements af3.c {
        public final /* synthetic */ ECMFPageCardComponent a;

        @Override // af3.c
        public final boolean a() {
            return this.a.p().l;
        }

        @Override // af3.c
        public final void b() {
            ECFMiddleware r0 = this.a.p();
        }

        @Override // af3.c
        public Context getContext() {
            return this.a.o().getContext();
        }

        public a(ECMFPageCardComponent r1) {
            this.a = r1;
        }
    }

    public static final class b extends rj.a {
        public b() {
            super(null, 3);
        }
    }

    public ECMFPageCardComponent() {
        this.b = new PageCardTimer();
        this.f = new jf3.d(new ECMFPageCardComponent$pageCardLifeCycle$1(this), new ECMFPageCardComponent$pageCardLifeCycle$2(this));
    }

    @Override // u93.b, u93.c
    public final void onDestroy() {
        com.bytedance.android.shopping.mall.homepage.pagecard.c r0 = p().m();
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public final com.bytedance.android.shopping.mall.homepage.pagecard.d r() {
        return p().u;
    }

    @Override // u93.b, u93.c
    public final void f(HomePageDTO r3) {
        HomePageBffDTO r4 = r3.getBff();
        if (r4 == null) goto L7;
        SingleCardData r5 = r4.getPopup();
        if (r5 == null) goto L7;
        String r6 = r5.getLynxData();
    L9:
        if (r6 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        return;
    L17:
        if (this.e == true) goto L23;
        this.e = true;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r0 = r().a();
        if (r0 == null) goto L24;
        r0.f(r6);
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if (r6.length() == 0) goto L14;
        r1 = false;
    L7:
        r6 = null;
        goto L9
    }

    @Override // u93.b, u93.c
    public final void g(boolean r3) {
        IECNativeHomeArgument r0 = q();
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = p().m();
        if (r1 == null) goto L11;
        r1.a(r3, false);
        return;
    L11:
        return;
    L5:
        if (r0.getEnableTopBar() != true) goto L7;
    }

    @Override // u93.b, u93.c
    public final void j(HomePageDTO r4) {
        com.bytedance.android.shopping.mall.homepage.pagecard.c r0 = r().a();
        if (r0 != null) goto L5;
    L17:
        p().g.h(this.f);
        this.e = true;
        HomePageBffDTO r5 = r4.getBff();
        if (r5 == null) goto L23;
        SingleCardData r6 = r5.getPopup();
        if (r6 == null) goto L23;
        String r7 = r6.getLynxData();
        if (r7 == null) goto L23;
    L24:
        s(r7);
        return;
    L23:
        r7 = "";
        goto L24
    L5:
        if (r0.b != true) goto L17;
        if (this.e == true) goto L26;
        this.e = true;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r1 = r().a();
        if (r1 == null) goto L27;
        HomePageBffDTO r8 = r4.getBff();
        if (r8 == null) goto L15;
        SingleCardData r9 = r8.getPopup();
        if (r9 == null) goto L15;
        String r10 = r9.getLynxData();
    L16:
        r1.f(r10);
        return;
    L15:
        r10 = null;
        goto L16
    L27:
        return;
    }

    @Override // u93.b, u93.c
    public final void l(String r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        if (this.d == false) goto L5;
        return;
    L5:
        final long r1 = System.currentTimeMillis();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L52
        af3.a r4 = new af3.a(r12);     // Catch: Throwable -> L52
        int r5 = 0;
        int r6 = JSONObjectProtectorUtils.getInt(r4.c, "native_open_ab");     // Catch: Exception -> L10 Throwable -> L52
    L12:
        if (r6 != 1) goto L62;
        a r7 = new a(this);     // Catch: Throwable -> L52
        ck.a r8 = p().g();     // Catch: Throwable -> L52
        ECFMiddleware r10 = p();     // Catch: Throwable -> L52
        af3.e r9 = new af3.e(r7, r4, r8, new g(MapsKt.emptyMap()));     // Catch: Throwable -> L52
        r9.a();     // Catch: Throwable -> L52
        p().r = r9;     // Catch: Throwable -> L52
    L62:
        boolean r11 = JSONObjectProtectorUtils.getBoolean(r4.c, "popup_data_is_valid");     // Catch: Exception -> L17 Throwable -> L52
    L18:
        if (r11 == true) goto L68;
        return;
    L68:
        int r13 = JSONObjectProtectorUtils.getInt(r4.c, "popup_optimize_ab");     // Catch: Exception -> L22 Throwable -> L52
    L23:
        if (r13 != 1) goto L72;
        this.d = true;     // Catch: Throwable -> L52
        com.bytedance.android.shopping.mall.homepage.pagecard.c r14 = r().a();     // Catch: Throwable -> L52
        f r15 = null;
        if (r14 != null) goto L28;
    L41:
        p().g.h(this.f);     // Catch: Throwable -> L52
        r5 = JSONObjectProtectorUtils.getInt(r4.c, "native_open_ab");     // Catch: Exception -> L59 Throwable -> L52
    L43:
        if (r5 != 1) goto L48;
        af3.e r16 = p().r;     // Catch: Throwable -> L52
        if (r16 == null) goto L47;
        r15 = r16.d;     // Catch: Throwable -> L52
    L47:
        s(r4.c(r15));     // Catch: Throwable -> L52
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L52
    L49:
        Result.constructor-impl(r15);     // Catch: Throwable -> L52
    L54:
        ECMallFragment r17 = p().z;
        Function1<y93.a, y93.a> r0 = new ECMFPageCardComponent$apiMarketingResourceGet$2(r1);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r0, "operator");
        DataEngineWrapper r18 = r17.L0;
        if (r18 == null) goto L73;
        r18.L(r0);
        return;
    L73:
        return;
    L48:
        s(r12);     // Catch: Throwable -> L52
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L28:
        if (r14.b != true) goto L41;
        r5 = JSONObjectProtectorUtils.getInt(r4.c, "native_open_ab");     // Catch: Exception -> L58 Throwable -> L52
    L31:
        if (r5 != 1) goto L38;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r19 = r().a();     // Catch: Throwable -> L52
        if (r19 == null) goto L49;
        af3.e r2 = p().r;     // Catch: Throwable -> L52
        if (r2 == null) goto L37;
        r15 = r2.d;     // Catch: Throwable -> L52
    L37:
        r19.f(r4.c(r15));     // Catch: Throwable -> L52
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L38:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r20 = r().a();     // Catch: Throwable -> L52
        if (r20 == null) goto L49;
        r20.f(r12);     // Catch: Throwable -> L52
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L52
        goto L49
    L72:
        return;
    L22:
        r13 = 0;
    L17:
        r11 = false;
    L10:
        r6 = 0;
    L52:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    }

    @Override // u93.b, u93.c
    public final void onCreate(Bundle r4) {
        ConcurrentHashMap<Class<? extends e93.d>, Map<String, MallAbilityManager.a<? extends e93.d>>> r5 = MallAbilityManager.a;
        MallAbilityManager.a(bf3.b.class, this, o());
        com.bytedance.android.shopping.mall.homepage.pagecard.d r6 = r();
        IECNativeHomeArgument r0 = q();
        Long r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getPageCardSchema();
    L6:
        IECNativeHomeArgument r3 = q();
        if (r3 == null) goto L9;
        r1 = Long.valueOf(r3.getPageCardDynamicParamTimeout());
    L9:
        r6.b(r2, r1);
        com.bytedance.android.shopping.mall.homepage.pagecard.c r7 = p().m();
        if (r7 == null) goto L15;
        r7.c((String) p().k.getValue());
        PageCard r8 = r7.a;
        if (r8 == null) goto L16;
        b r9 = new b();
        Intrinsics.checkNotNullParameter(r9, "lifecycle");
        ((ArrayList) r8.l).add(r9);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void s(String r14) {
        FragmentActivity r0 = o().getActivity();
        Context r3 = o().getContext();
        if (this.c != null) goto L9;
        View r1 = o().getView();
        if (r1 == null) goto L7;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131381795);
    L8:
        this.c = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        FrameLayout r5 = this.c;
        if (r3 == null) goto L23;
        if (r0 != null) goto L13;
    L14:
        if (r5 == null) goto L26;
        ECFMiddleware r4 = p();
        Map r6 = MapsKt.toMutableMap(MapsKt.emptyMap());
        r6.put("page_card_load_start_time", Long.valueOf(System.currentTimeMillis()));
        if (HybridAppInfoService.p.isLocalTest() == false) goto L19;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(200, 200);
        r7.gravity = 8388691;
        Unit r8 = Unit.INSTANCE;
        r5.setLayoutParams(r7);
    L19:
        com.bytedance.android.shopping.mall.homepage.pagecard.c r9 = p().m();
        if (r9 == null) goto L25;
        mf3.b.a.a(r9, r3, o().getLifecycle(), r5, r6, b0.f(), p().l(), p().d(), r14, false, 256);
        return;
    L25:
        return;
    L26:
        return;
    L13:
        if (r0.isFinishing() != true) goto L14;
        return;
    }

    @Override // u93.b, u93.c
    public final void b(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        IECNativeHomeArgument r9 = q();
        if (r9 == null) goto L27;
        boolean r0 = true;
        if (r9.getPageCardDelayInit() != 1) goto L27;
        PageCardTimer r10 = this.b;
        IECNativeHomeArgument r1 = q();
        if (r1 == null) goto L11;
        Map<String, String> r2 = r1.getLandingInfo();
        if (r2 == null) goto L11;
        String r3 = r2.get("schema");
    L13:
        if (r3 != null) goto L15;
        r10.getClass();
    L23:
        r0 = false;
    L24:
        if (r0 == false) goto L26;
        s("");
        return;
    L26:
        jf3.c r11 = p().g;
        jf3.d r12 = this.f;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "lifeCycle");
        r11.a.add(r12);
        return;
    L15:
        List<String> r13 = ((i) r10.a.getValue()).a();
        if (r13 == null) goto L23;
        Iterator<T> r14 = r13.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        if (StringsKt.contains$default(r3, (String) r14.next(), false, 2, null) == false) goto L19;
    L11:
        r3 = null;
    L27:
        s("");
    }
}
