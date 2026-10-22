package com.bytedance.applet.aibridge.ecommerce.impl;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsOpenECommerceMethodIDL;
import com.bytedance.applet.aibridge.ecommerce.api.OpenECommerceSource;
import com.bytedance.applet.impl.u0;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.SdkOauthTokenTriggerScene;
import com.larus.platform.api.f2;
import com.larus.platform.api.g5;
import com.larus.platform.api.h5;
import com.larus.platform.api.l2;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i0;
import com.larus.platform.service.i3;
import com.larus.platform.service.l0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e3.d;
import f3.h;
import java.util.Map;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lv3.f;
import lv3.n;
import lv3.o;
import lv3.p;
import lv3.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J0\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J0\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J0\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J:\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J.\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001c2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/OpenECommerceMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsOpenECommerceMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsOpenECommerceMethodIDL$OpenECommerceMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsOpenECommerceMethodIDL$OpenECommerceMethodResultModel;", "openECommerceSaas", "activity", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "openFallbackH5AndSwitchToNativeIfAuthorized", "currentActivity", "openECommerceSaasInternal", "openECSchema", "service", "Lcom/larus/platform/api/ISdkECommerce;", "defaultOpenECommerce", "context", "Landroid/content/Context;", "defaultPageReason", "", "enterEComPageDetect", "toPage", "isToSearchSaas", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenECommerceMethod extends AbsOpenECommerceMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public static final class b implements h5 {
        public final /* synthetic */ OpenECommerceMethod a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ Fragment c;
        public final /* synthetic */ AbsOpenECommerceMethodIDL.a d;
        public final /* synthetic */ h<AbsOpenECommerceMethodIDL.b> e;

        public final void a(g5 r6) {
            Intrinsics.checkNotNullParameter(r6, "token");
            OpenECommerceMethod r7 = this.a;
            FragmentActivity r0 = this.b;
            Fragment r1 = this.c;
            AbsOpenECommerceMethodIDL.a r2 = this.d;
            h<AbsOpenECommerceMethodIDL.b> r3 = this.e;
            int r4 = OpenECommerceMethod.b;
            r7.g(r0, r1, r2, r3);
        }

        public final void onFailure(int r6) {
            if (f2.a.q() == false) goto L5;
            OpenECommerceMethod r7 = this.a;
            FragmentActivity r0 = this.b;
            Fragment r1 = this.c;
            AbsOpenECommerceMethodIDL.a r2 = this.d;
            h<AbsOpenECommerceMethodIDL.b> r3 = this.e;
            int r4 = OpenECommerceMethod.b;
            r7.getClass();
            OpenECommerceMethod.b(r0, r2, r3, "hit_open_h5_when_not_auth");
            r r5 = new r(r2, r7, r1, r3);
            AppHost.a.a().e(r5);
            return;
        L5:
            OpenECommerceMethod r8 = this.a;
            FragmentActivity r9 = this.b;
            Fragment r10 = this.c;
            AbsOpenECommerceMethodIDL.a r11 = this.d;
            h<AbsOpenECommerceMethodIDL.b> r12 = this.e;
            int r13 = OpenECommerceMethod.b;
            r8.g(r9, r10, r11, r12);
        }

        public b(OpenECommerceMethod r1, FragmentActivity r2, Fragment r3, AbsOpenECommerceMethodIDL.a r4, h<AbsOpenECommerceMethodIDL.b> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public OpenECommerceMethod() {
    }

    public static boolean d(AbsOpenECommerceMethodIDL.a r2) {
        if (Intrinsics.areEqual(r2.getSource(), OpenECommerceSource.CLICK_EC_CARD_TO_SEARCH_SRP) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getSource(), OpenECommerceSource.CLICK_REPLY_COUPON_CARD_TO_SEARCH_SRP) == true) goto L8;
        return false;
    }

    public static void c(AbsOpenECommerceMethodIDL.a r8, String r9, String r10) {
        JSONObject r0 = r8.getBcm();
        String r1 = null;
        if (r0 == null) goto L5;
        String r4 = r0.optString("doubao_message_id");
    L6:
        JSONObject r2 = r8.getBcm();
        if (r2 == null) goto L9;
        String r3 = r2.optString("fpa_bcm_id");
    L10:
        JSONObject r5 = r8.getBcm();
        if (r5 == null) goto L13;
        r1 = r5.optString("product_id");
    L13:
        n r6 = n.a;
        String r7 = r8.getCurrentPage();
        r6.getClass();
        n.b(r3, r1, r4, r7, r9, r10);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void handle(d r10, ParamModel r11, final h r12) {
        final AbsOpenECommerceMethodIDL.a r4 = (AbsOpenECommerceMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        i3 r0 = i3.a;
        if (r0.f() == true) goto L5;
    L7:
        Context r1 = r10.getOwnerActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L10;
        Context r6 = (FragmentActivity) r1;
    L12:
        if (r6 != null) goto L57;
        h.a.a(r12, "Failed to get fragment activity", null, null, 14);
        return;
    L57:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(mv3.a.a(r10));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r3) == false) goto L21;
        r3 = null;
    L21:
        final Fragment r5 = (Fragment) r3;
        if (r5 == null) goto L24;
    L43:
        l2 r13 = l0.a();
        if (o0.d(r4.getECommerceSchema()) == false) goto L53;
        if (r13 == null) goto L53;
        if (r13.i() == false) goto L50;
        f(r6, r5, r4, r12);
        return;
    L50:
        if (f2.a.m() == false) goto L52;
        n r7 = n.a;
        final Context r8 = r6;
        Function1 r9 = new o(this, r8, r5, r4, r12);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r13, "service");
        Intrinsics.checkNotNullParameter(r9, "callback");
        t0.e(new f(r6, r13, r9));
        return;
    L52:
        r13.f("OpenECommerceMethod-loadInNotWait", new uq9.a());
        b(r6, r4, r12, "not_install_sdk");
        return;
    L53:
        b(r6, r4, r12, "not_install_sdk");
        return;
    L24:
        if (f2.a.c() == false) goto L43;
        View r14 = r10.getEngineView();
        FLogger.a.i("OpenECommerceMethod-ViewDebug", "===== View-Fragment Chain Start =====");
    L26:
        if (r14 == null) goto L42;
        FLogger.a.i("OpenECommerceMethod-ViewDebug", "view: " + r14.getClass().getName() + ", id=" + r14.getId() + ", obj=" + r14);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L30
        Object r16 = Result.constructor-impl(e1.k(r14));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r16) == false) goto L35;
        r16 = null;
    L35:
        Fragment r17 = (Fragment) r16;
        if (r17 == null) goto L38;
        FLogger.a.i("OpenECommerceMethod-ViewDebug", "fragment: " + r17.getClass().getName() + ", id=" + r17.getId() + ", obj=" + r17);
    L38:
        Object r18 = r14.getParent();
        if ((r18 instanceof View) == true) goto L40;
        r14 = null;
        goto L26
    L40:
        r14 = (View) r18;
    L30:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L42:
        FLogger.a.i("OpenECommerceMethod-ViewDebug", "===== View-Fragment Chain End =====");
        h.a.a(r12, "Failed to get fragment", null, null, 14);
        return;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L10:
        r6 = null;
        goto L12
    L5:
        if (d(r4) == true) goto L7;
        r0.g(TriggerLoginScene.TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL);
        Intrinsics.checkNotNullParameter(AbsOpenECommerceMethodIDL.b.class, "<this>");
        r12.b(c.a(AbsOpenECommerceMethodIDL.b.class), "");
    }

    public static void b(Context r6, AbsOpenECommerceMethodIDL.a r7, h r8, String r9) {
        c(r7, "douyinH5", r9);
        String r10 = r7.getDefaultSchema();
        if (r10 != null) goto L7;
        FLogger.a.e("OpenECommerceMethod", "defaultOpenECommerce abort: defaultSchema is null");
        h.a.a(r8, "defaultSchema is null. defaultSchema: " + r10, null, null, 14);
        return;
    L7:
        if (r10.length() != 0) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        FLogger.a.w("OpenECommerceMethod", "defaultOpenECommerce skip open: defaultSchema is empty");
        Intrinsics.checkNotNullParameter(AbsOpenECommerceMethodIDL.b.class, "<this>");
        r8.b(c.a(AbsOpenECommerceMethodIDL.b.class), "");
        return;
    L14:
        Boolean r1 = Boolean.FALSE;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        Map r4 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L21
        hx7.f r5 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L21
        if (r5 == null) goto L18;
        r1 = Boolean.valueOf(r5.openSchema(r10, MapsKt.emptyMap(), r6));     // Catch: Throwable -> L21
    L19:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        if (Result.exceptionOrNull-impl(r11) == null) goto L26;
        r1 = Boolean.FALSE;
    L26:
        Boolean r12 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r12) == true) goto L30;
        int r13 = u0.a;
        Uri r14 = UriProtector.parse(r10);
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r14, "uri");
        r1 = Boolean.valueOf(BulletSdk.h(r6, r14, null, 12));
    L30:
        if (Intrinsics.areEqual(r1, r12) == false) goto L32;
        Intrinsics.checkNotNullParameter(AbsOpenECommerceMethodIDL.b.class, "<this>");
        r8.b(c.a(AbsOpenECommerceMethodIDL.b.class), "");
        return;
    L32:
        h.a.a(r8, "Failed to open schema: ".concat(r10), null, null, 14);
        return;
    L18:
        r1 = null;
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L9:
        r2 = false;
        goto L11
    }

    public final void f(FragmentActivity r10, Fragment r11, AbsOpenECommerceMethodIDL.a r12, h<AbsOpenECommerceMethodIDL.b> r13) {
        if (Intrinsics.areEqual(r12.getSource(), OpenECommerceSource.CLICK_REPLY_ECOM_CARD) == false) goto L7;
        ISdkDouyinAuth r0 = i0.a();
        if (r0 == null) goto L9;
        r0.a(false, SdkOauthTokenTriggerScene.Request, new b(this, r10, r11, r12, r13));
        return;
    L9:
        return;
    L7:
        g(r10, r11, r12, r13);
    }

    public final void g(final FragmentActivity r15, final Fragment r16, final AbsOpenECommerceMethodIDL.a r17, final h<AbsOpenECommerceMethodIDL.b> r18) {
        final l2 r11 = l0.a();
        if (d(r17) == false) goto L7;
        e(r15, r16, r17, r11, r18);
        return;
    L7:
        if (r11 == null) goto L17;
        String r0 = r17.getCurrentPage();
        if (r0 != null) goto L11;
        String r2 = "";
    L12:
        String r1 = r17.getSource();
        if (r1 != null) goto L15;
        String r3 = "";
    L16:
        r11.e(new uq9.d(r15, r2, r3, !f2.a.u(), false, true, 16), null, new p(this, r15, r16, r17, r11, r18));
        return;
    L15:
        r3 = r1;
        goto L16
    L11:
        r2 = r0;
        goto L12
    L17:
        b(r15, r17, r18, "not_bind_douyin");
    }

    public static void e(FragmentActivity r6, Fragment r7, AbsOpenECommerceMethodIDL.a r8, l2 r9, h r10) {
        IBTMService r0 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r0 == null) goto L8;
        String r3 = r8.getECommerceSchema();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        Uri r11 = r0.j(r3, r8.getBtm(), r8.getBcm(), r7);
    L9:
        FLogger.a.d("OpenECommerceMethod", "openECSchema with source btm token, uri: " + r11);
        if (r9 == null) goto L12;
        Boolean r12 = Boolean.valueOf(r9.c(r6, r11));
    L14:
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsOpenECommerceMethodIDL.b.class, "<this>");
        r10.b(c.a(AbsOpenECommerceMethodIDL.b.class), "");
    L18:
        if (d(r8) == false) goto L20;
        String r13 = "ecom_search_saas";
    L21:
        c(r8, r13, null);
        return;
    L20:
        r13 = "ecom_saas";
        goto L21
    L16:
        h.a.a(r10, "Failed to open schema: " + r8 + ".schema", null, null, 14);
        goto L18
    L12:
        r12 = null;
        goto L14
    L8:
        r11 = null;
        goto L9
    }
}
