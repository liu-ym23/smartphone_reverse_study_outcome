package com.larus.e_commerce.api;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.api.IShareService;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.share.service.ShareShortUrlCreateHelper;
import com.larus.share.service.j;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.SocialConstants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes4.dex */
public final class ECommerceRouterInterceptor implements q97.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f342332c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f342333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f342334b;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.router.c f342335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECommerceRouterInterceptor f342336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f342337c;

        @Override // com.larus.e_commerce.api.h
        public final void a() {
            Intrinsics.checkNotNullParameter("ecommerce plugin init failed", "reason");
        }

        @Override // com.larus.e_commerce.api.h
        public final void onInitSuccess() {
            Uri r100 = this.f342335a.f267530d;
            if (Intrinsics.areEqual(r100.getAuthority(), "webcast_webview") == false) goto L11;
            IECommerceService r101 = this.f342336b.f();
            boolean r102 = false;
            if (r101 == null) goto L9;
            Context r103 = this.f342337c;
            Intrinsics.checkNotNull(r100);
            if (r101.n(r103, r100) != true) goto L9;
            r102 = true;
        L9:
            if (r102 == false) goto L11;
            return;
        L11:
            IECommerceService r104 = this.f342336b.f();
            if (r104 == null) goto L15;
            r104.c(this.f342337c, this.f342335a.f267530d);
            return;
        }

        public b(com.bytedance.router.c r100, ECommerceRouterInterceptor r101, Context r102) {
            this.f342335a = r100;
            this.f342336b = r101;
            this.f342337c = r102;
        }
    }

    static {
    }

    public final IECommerceService f() {
        return (IECommerceService) this.f342334b.getValue();
    }

    public ECommerceRouterInterceptor() {
        this.f342333a = CollectionsKt.listOf(new String[]{"webcast_webview", "webcast_lynxview"});
        this.f342334b = LazyKt.lazy(new e());
    }

    public static JSONObject e(Uri r110) {
        JSONObject r100 = new JSONObject();
        Set r101 = SetsKt.setOf(new String[]{"scene", "official_url", "url", "zlink_url", "title", "description", SocialConstants.PARAM_APP_DESC, "imageUrl", "image_url", "contentId", com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, "product_id", "poiId", "poi_id", "room_id", MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID});
        Set<String> r102 = UriProtector.getQueryParameterNames(r110);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (r101.contains((String) r105) == true) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        String r107 = (String) r106.next();
        String r108 = UriProtector.getQueryParameter(r110, r107);
        if (r108 == null) goto L10;
        r100.put(r107, r108);
        goto L10
    L14:
        return r100;
    }

    public static boolean g(Uri r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r102 = r100.getScheme();
        String r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.toLowerCase(Locale.ROOT);
    L9:
        String r105 = r100.getPath();
        if (r105 == null) goto L13;
        r103 = StringsKt.removeSuffix(r105, HTTP.URL_DEFAULT);
    L13:
        if (Intrinsics.areEqual(r104, "doubao") == true) goto L17;
        if (Intrinsics.areEqual(r104, AppConstants.SCHEME_SS_LOCAL) == true) goto L17;
    L22:
        if (Intrinsics.areEqual(r100.getAuthority(), BytedCertConstant.CertKey.FLOW) == false) goto L24;
    L27:
        k(r100);
        r100.getAuthority();
    L28:
        return r101;
    L24:
        if (Intrinsics.areEqual(r105, "/show_share_panel") == true) goto L27;
        if (Intrinsics.areEqual(r103, "/show_share_panel") == false) goto L28;
    L17:
        if (Intrinsics.areEqual(r100.getAuthority(), BytedCertConstant.CertKey.FLOW) == false) goto L22;
        if (Intrinsics.areEqual(r103, "/show_share_panel") == false) goto L22;
        r101 = true;
        goto L22
    L8:
        r104 = null;
        goto L9
    }

    public static void h(String r100) {
        Object r101 = "invalid";
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        String r103 = "";
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        if (r102.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L36;
        return;
    L36:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L28
        URI r106 = new URI(r102);     // Catch: Throwable -> L28
        String r107 = r106.getScheme();     // Catch: Throwable -> L28
        if (r107 == null) goto L20;
        String r108 = r106.getHost();     // Catch: Throwable -> L28
        if (r108 == null) goto L20;
        String r109 = r106.getPath();     // Catch: Throwable -> L28
        if (r109 == null) goto L25;
        r103 = r109;
    L25:
        String r110 = r107 + "://" + r108 + r103;     // Catch: Throwable -> L28
    L26:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r111) == true) goto L34;
        r101 = r111;
    L34:
        String r112 = (String) r101;
        return;
    L20:
        r110 = "invalid";
    L28:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L12:
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public static String i(String r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L6:
        if (r102 != null) goto L8;
    L21:
        if (r100 == null) goto L23;
        r101 = StringsKt.trim(r100).toString();
    L23:
        if (r101 != null) goto L26;
        return "";
    L26:
        return r101;
    L8:
        switch(r102.hashCode()) {
            case -2042959376: goto L20;
            case 3107580: goto L17;
            case 614474412: goto L14;
            case 1528280640: goto L11;
            default: goto L21;
        };
    L11:
        if (r102.equals("ecommerce") == false) goto L21;
        return "ecommerce_product";
    L14:
        if (r102.equals("ecom_product") == false) goto L21;
        return "ecommerce_product";
    L17:
        if (r102.equals("ecom") == false) goto L21;
        return "ecommerce_product";
    L20:
        if (r102.equals("ecommerce_product") == false) goto L21;
        return "ecommerce_product";
    L5:
        r102 = null;
        goto L6
    }

    public static void k(Uri r110) {
        if (r110 != null) goto L13;
        return;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L6
        Object r101 = Result.m9449constructorimpl(CollectionsKt.joinToString$default(UriProtector.getQueryParameterNames(r110), ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r101) == false) goto L11;
        r101 = "?";
    L11:
        String r102 = (String) r101;
        r110.getScheme();
        r110.getAuthority();
        r110.getPath();
        return;
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (g(r100.f267530d) == false) goto L9;
        k(r100.f267530d);
        return true;
    L9:
        String r101 = r100.f267530d.getAuthority();
        if (r101 != null) goto L12;
        return false;
    L12:
        boolean r102 = this.f342333a.contains(r101);
        IECommerceService r103 = f();
        if (r103 == null) goto L15;
        boolean r104 = r103.w(r100.f267530d);
    L16:
        if (r102 == true) goto L18;
        if (r104 == true) goto L18;
        return false;
    L18:
        return true;
    L15:
        r104 = false;
        goto L16
    }

    public static String d(String r100, String r101) {
        IBTMService r102 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r102 == null) goto L14;
        JSONObject r103 = new JSONObject();
        r103.put("doubao_share_id", r101);
        Unit r104 = Unit.INSTANCE;
        Activity r105 = AppHost.f326268a.a().getCurrentActivity();
        if ((r105 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r106 = (FragmentActivity) r105;
    L8:
        Uri r107 = r102.p(r100, "a35794.b116695.c116696.d116698", r103, r106);
        if (r107 == null) goto L15;
        String r108 = r107.toString();
        if (r108 != null) goto L13;
        return r100;
    L13:
        return r108;
    L15:
        return r100;
    L7:
        r106 = null;
        goto L8
    L14:
        return r100;
    }

    public static void l(ECommerceRouterInterceptor r100, String r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        String r102 = StringsKt.trim(r101).toString();
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (r102.length() != 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        return;
    L15:
        if (r102.length() <= 80) goto L20;
        StringsKt.take(r102, 80);
        return;
    L20:
        return;
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        if (r110 == null) goto L46;
        if (r111 != null) goto L7;
        return false;
    L7:
        if (g(r111.f267530d) == false) goto L21;
        k(r111.f267530d);
        Uri r112 = r111.f267530d;
        if ((r110 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r100 = (FragmentActivity) r110;
    L12:
        if (r100 != null) goto L17;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if ((r101 instanceof FragmentActivity) == false) goto L16;
        r100 = (FragmentActivity) r101;
        goto L17
    L16:
        r100 = null;
    L17:
        if (r100 == null) goto L20;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new ECommerceRouterInterceptor$handleSaasSharePanel$1(this, r110, r112, null), 3, null);
    L20:
        return true;
    L11:
        r100 = null;
        goto L12
    L21:
        IECommerceService r102 = f();
        if (r102 != null) goto L24;
    L26:
        boolean r103 = false;
    L27:
        if (r103 == false) goto L32;
        IECommerceService r104 = f();
        if (r104 == null) goto L31;
        r104.x("ECommerceRouterInterceptor-interceptor", new b(r111, this, r110));
    L31:
        return true;
    L32:
        Uri r105 = r111.f267530d;
        if (Intrinsics.areEqual(r105.getAuthority(), "webcast_webview") == false) goto L42;
        IECommerceService r106 = f();
        if (r106 == null) goto L39;
        Intrinsics.checkNotNull(r105);
        if (r106.n(r110, r105) != true) goto L39;
        boolean r107 = true;
    L40:
        if (r107 == false) goto L42;
        return true;
    L39:
        r107 = false;
    L42:
        IECommerceService r108 = f();
        if (r108 != null) goto L45;
        return false;
    L45:
        return r108.c(r110, r111.f267530d);
    L24:
        if (r102.i() == true) goto L26;
        r103 = true;
        goto L27
    L46:
        return false;
    }

    public static final Object c(final ECommerceRouterInterceptor r210, Context r211, Uri r212, Continuation r213) {
        r210.getClass();
        if ((r213 instanceof ECommerceRouterInterceptor$handleSaasSharePanelAsync$1) == false) goto L7;
        ECommerceRouterInterceptor$handleSaasSharePanelAsync$1 r100 = (ECommerceRouterInterceptor$handleSaasSharePanelAsync$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        JSONObject r105 = (JSONObject) r100.L$9;
        String r106 = (String) r100.L$8;
        String r107 = (String) r100.L$7;
        String r108 = (String) r100.L$6;
        String r109 = (String) r100.L$5;
        String r110 = (String) r100.L$4;
        String r111 = (String) r100.L$3;
        String r112 = (String) r100.L$2;
        Uri r113 = (Uri) r100.L$1;
        Context r114 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L91 CancellationException -> L89
        JSONObject r214 = r105;
        String r215 = r106;
        String r216 = r107;
        String r115 = r108;
        String r116 = r109;
    L14:
        String r117 = r111;
        String r118 = r112;
        j r119 = (j) r102;     // Catch: Throwable -> L91 CancellationException -> L89
        if ((r119 instanceof j.b) == false) goto L78;
        String r120 = ((j.b) r119).f368937a;     // Catch: Throwable -> L91 CancellationException -> L89
        com.larus.share.service.h r121 = com.larus.share.service.h.f368920a;     // Catch: Throwable -> L91 CancellationException -> L89
        com.larus.share.service.f r122 = new com.larus.share.service.f(r118, r120, r117, r110, z2.f365865a.getSaasShareConfig().b(), r116, r115, r216, r215, r214);     // Catch: Throwable -> L91 CancellationException -> L89
        r121.getClass();     // Catch: Throwable -> L91 CancellationException -> L89
        com.larus.share.service.g r123 = com.larus.share.service.h.c(r122);     // Catch: Throwable -> L91 CancellationException -> L89
        final com.larus.share.service.e r124 = r123.getContext();     // Catch: Throwable -> L91 CancellationException -> L89
        if (r123.f368917a == false) goto L76;
        if (r124 == null) goto L76;
        FragmentActivity r125 = null;
        if ((r114 instanceof FragmentActivity) == false) goto L60;
        FragmentActivity r126 = (FragmentActivity) r114;     // Catch: Throwable -> L91 CancellationException -> L89
    L61:
        Activity r127 = AppHost.f326268a.a().getCurrentActivity();     // Catch: Throwable -> L91 CancellationException -> L89
        if ((r127 instanceof FragmentActivity) == false) goto L64;
        r125 = (FragmentActivity) r127;     // Catch: Throwable -> L91 CancellationException -> L89
    L64:
        if (r126 != null) goto L66;
        FragmentActivity r128 = r125;
    L67:
        if (r128 != null) goto L69;
        r114.getClass();     // Catch: Throwable -> L91 CancellationException -> L89
        return Unit.INSTANCE;
    L69:
        final IShareService r129 = (IShareService) ServiceManager.get().getService(IShareService.class);     // Catch: Throwable -> L91 CancellationException -> L89
        if (r129 == null) goto L98;
        final g r130 = new g(r124, r110, r129, r128);     // Catch: Throwable -> L91 CancellationException -> L89
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L75;
        final FragmentActivity r131 = r128;
        final Uri r132 = r113;
        r128.runOnUiThread(new f(r210, r129, r131, r124, r130, r132));     // Catch: Throwable -> L91 CancellationException -> L89
        return Unit.INSTANCE;
    L75:
        IShareService.a.g(r129, r128, r124.f368904a, r124.f368905b, r124.f368906c, r130, null, false, 224);     // Catch: Throwable -> L91 CancellationException -> L89
    L88:
        return Unit.INSTANCE;
    L98:
        return Unit.INSTANCE;
    L66:
        r128 = r126;
        goto L67
    L60:
        r126 = null;
    L76:
        k(r113);     // Catch: Throwable -> L91 CancellationException -> L89
        return Unit.INSTANCE;
    L78:
        if ((r119 instanceof j.c) == false) goto L81;
        long r133 = ((j.c) r119).f368938a;     // Catch: Throwable -> L91 CancellationException -> L89
        s.f544207a.getClass();     // Catch: Throwable -> L91 CancellationException -> L89
        s.b(r114, R.string.larus_share_failed, false);     // Catch: Throwable -> L91 CancellationException -> L89
        return Unit.INSTANCE;
    L81:
        if ((r119 instanceof j.a) == false) goto L84;
        Long r134 = ((j.a) r119).f368934a;     // Catch: Throwable -> L91 CancellationException -> L89
        String r135 = ((j.a) r119).f368935b;     // Catch: Throwable -> L91 CancellationException -> L89
        s.f544207a.getClass();     // Catch: Throwable -> L91 CancellationException -> L89
        s.b(r114, R.string.larus_share_failed, false);     // Catch: Throwable -> L91 CancellationException -> L89
        return Unit.INSTANCE;
    L84:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L91 CancellationException -> L89
    L86:
        k(r113);
        goto L88
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r102);
        String r136 = UriProtector.getQueryParameter(r212, "scene");     // Catch: Throwable -> L85 CancellationException -> L89
        r112 = i(r136);     // Catch: Throwable -> L85 CancellationException -> L89
        String r137 = UriProtector.getQueryParameter(r212, "official_url");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r137 != null) goto L21;
        r137 = UriProtector.getQueryParameter(r212, "url");     // Catch: Throwable -> L85 CancellationException -> L89
    L21:
        r111 = UriProtector.getQueryParameter(r212, "zlink_url");     // Catch: Throwable -> L85 CancellationException -> L89
        r110 = UriProtector.getQueryParameter(r212, "title");     // Catch: Throwable -> L85 CancellationException -> L89
        String r138 = UriProtector.getQueryParameter(r212, "description");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r138 != null) goto L24;
        r138 = UriProtector.getQueryParameter(r212, SocialConstants.PARAM_APP_DESC);     // Catch: Throwable -> L85 CancellationException -> L89
    L24:
        String r139 = UriProtector.getQueryParameter(r212, "imageUrl");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r139 != null) goto L27;
        r139 = UriProtector.getQueryParameter(r212, "image_url");     // Catch: Throwable -> L85 CancellationException -> L89
    L27:
        String r140 = UriProtector.getQueryParameter(r212, "contentId");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r140 != null) goto L32;
        r140 = UriProtector.getQueryParameter(r212, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);     // Catch: Throwable -> L85 CancellationException -> L89
        if (r140 != null) goto L32;
        r140 = UriProtector.getQueryParameter(r212, "product_id");     // Catch: Throwable -> L85 CancellationException -> L89
    L32:
        String r141 = UriProtector.getQueryParameter(r212, "poiId");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r141 != null) goto L35;
        r141 = UriProtector.getQueryParameter(r212, "poi_id");     // Catch: Throwable -> L85 CancellationException -> L89
    L35:
        String r142 = UriProtector.getQueryParameter(r212, "room_id");     // Catch: Throwable -> L85 CancellationException -> L89
        if (r142 != null) goto L38;
        r142 = UriProtector.getQueryParameter(r212, MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);     // Catch: Throwable -> L85 CancellationException -> L89
    L38:
        JSONObject r143 = e(r212);     // Catch: Throwable -> L85 CancellationException -> L89
        String r144 = com.larus.share.service.d.d(r143, r137);     // Catch: Throwable -> L85 CancellationException -> L89
        r143.put(BdpAppEventConstant.SHARE_ID, r144);     // Catch: Throwable -> L85 CancellationException -> L89
        l(r210, r112);     // Catch: Throwable -> L85 CancellationException -> L89
        l(r210, r136);     // Catch: Throwable -> L85 CancellationException -> L89
        h(r137);     // Catch: Throwable -> L85 CancellationException -> L89
        h(r111);     // Catch: Throwable -> L85 CancellationException -> L89
        l(r210, r110);     // Catch: Throwable -> L85 CancellationException -> L89
        l(r210, r138);     // Catch: Throwable -> L85 CancellationException -> L89
        h(r139);     // Catch: Throwable -> L85 CancellationException -> L89
        r143.length();     // Catch: Throwable -> L85 CancellationException -> L89
        String r145 = "";
        if (r137 != null) goto L43;
        r137 = "";
    L43:
        if (r140 == null) goto L46;
        r145 = r140;
    L46:
        r100.L$0 = r211;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$1 = r212;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$2 = r112;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$3 = r111;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$4 = r110;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$5 = r139;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$6 = r140;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$7 = r141;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$8 = r142;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.L$9 = r143;     // Catch: Throwable -> L85 CancellationException -> L89
        r100.label = 1;     // Catch: Throwable -> L85 CancellationException -> L89
        r102 = r210.j(r137, r145, r144, r100);     // Catch: Throwable -> L85 CancellationException -> L89
        if (r102 == r103) goto L96;
        r114 = r211;
        r116 = r139;
        r115 = r140;
        r216 = r141;
        r215 = r142;
        r214 = r143;
        r113 = r212;
        goto L14
    L96:
        return r103;
    L85:
        r113 = r212;
    L89:
        e = move-exception;
        throw e;
    L7:
        r100 = new ECommerceRouterInterceptor$handleSaasSharePanelAsync$1(r210, r213);
        goto L8
    }

    public final Object j(String r100, String r101, String r102, Continuation<? super j> r103) {
        if ((r103 instanceof ECommerceRouterInterceptor$packUrl$1) == false) goto L7;
        ECommerceRouterInterceptor$packUrl$1 r104 = (ECommerceRouterInterceptor$packUrl$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        String r109 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L21:
        j r110 = (j) r106;
        h(r109);
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (StringsKt.isBlank(r101) == true) goto L17;
        r109 = com.larus.share.service.d.b("https://activity-ecom.doubao.com/trade_share/ecom_product_detail", MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(BdpAppEventConstant.SHARE_ID, r102), TuplesKt.to("share_from", "doubao_share"), TuplesKt.to("promotion_id", r101), TuplesKt.to("schema", d("doubao://ec_goods_detail/?promotion_id=" + r101 + "&enter_from_merge=doubao&enter_method=doubao_share&share_id=" + r102, r102))}));
        ShareShortUrlCreateHelper r111 = ShareShortUrlCreateHelper.f368890a;
        String r112 = d(r109, r102);
        r104.L$0 = r109;
        r104.label = 1;
        r106 = ShareShortUrlCreateHelper.b(r112, r104);
        if (r106 != r107) goto L21;
        return r107;
    L17:
        return new j.b(com.larus.share.service.d.a(r100, r102));
    L7:
        r104 = new ECommerceRouterInterceptor$packUrl$1(this, r103);
        goto L8
    }
}
