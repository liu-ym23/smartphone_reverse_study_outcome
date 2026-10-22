package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.constant.SchemaConstants;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.browser.BrowserWhiteModel;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class WebViewRouteInterceptor implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f346059a = null;

    public static final class a {
    }

    static {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        String r100 = "7241547611541340167";
    L6:
        f346059a = r100;
        return;
    L5:
        r100 = "7234781073513644036";
        goto L6
    }

    public WebViewRouteInterceptor() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("Router matchInterceptRules -> ");
        String r102 = null;
        if (r110 == null) goto L7;
        Uri r103 = r110.f267530d;
        if (r103 == null) goto L7;
        String r104 = r103.getAuthority();
    L8:
        r101.append(r104);
        r100.d("WebViewRouteInterceptor", r101.toString());
        if (r110 == null) goto L13;
        Uri r105 = r110.f267530d;
        if (r105 == null) goto L13;
        String r106 = r105.toString();
    L14:
        String r107 = u0.a(r106);
        if (Intrinsics.areEqual(r107, SchemaConstants.SCHEMA_WEBVIEW) == false) goto L31;
        if (r110 == null) goto L22;
        Intent r108 = r110.f267528b;
        if (r108 == null) goto L22;
        Bundle r109 = r108.getExtras();
        if (r109 == null) goto L22;
        String r111 = r109.toString();
    L23:
        JSONObject r112 = new JSONObject();
        if (r106 != null) goto L26;
        r106 = "";
    L26:
        r112.put("flow_web_route_uri", r106);
        if (r111 != null) goto L29;
        r111 = "";
    L29:
        r112.put("flow_web_route_extra", r111);
        TrackParams r113 = new TrackParams().merge(r112);
        by7.a r114 = new by7.a("flow_web_route");
        r114.f21463a.merge(r113);
        r114.b();
    L22:
        r111 = null;
    L31:
        if (Intrinsics.areEqual(r107, "//flow/webview") == false) goto L33;
        return true;
    L33:
        if (Intrinsics.areEqual(r107, SchemaConstants.SCHEMA_WEBVIEW) == false) goto L35;
        return true;
    L35:
        if (Intrinsics.areEqual(r107, "//webview_popup") == true) goto L62;
        List r115 = CollectionsKt.listOf(new String[]{"flow/webview", "webview", AppConstants.HOST_WEBVIEW_DIALOG});
        if (r110 == null) goto L51;
        Uri r116 = r110.f267530d;
        if (r116 == null) goto L51;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        List r117 = CollectionsKt.listOfNotNull(r116.getHost());
        List<String> r118 = r116.getPathSegments();
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L42:
        if (r120.hasNext() == false) goto L49;
        Object r121 = r120.next();
        String r122 = (String) r121;
        Intrinsics.checkNotNull(r122);
        if (r122.length() <= 0) goto L46;
        boolean r123 = true;
    L47:
        if (r123 == false) goto L42;
        r119.add(r121);
        goto L42
    L46:
        r123 = false;
        goto L47
    L49:
        r102 = CollectionsKt.joinToString$default(CollectionsKt.plus(r117, r119), HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
    L51:
        if (CollectionsKt.contains(r115, r102) == true) goto L63;
        return false;
    L63:
        return true;
    L62:
        return true;
    L13:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r110, com.bytedance.router.c r111) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("Router onInterceptRoute -> ");
        String r102 = null;
        if (r111 == null) goto L5;
        Uri r103 = r111.f267530d;
    L6:
        r101.append(r103);
        r100.d("WebViewRouteInterceptor", r101.toString());
        if (r111 == null) goto L11;
        Uri r104 = r111.f267530d;
        if (r104 == null) goto L11;
        String r105 = UriProtector.getQueryParameter(r104, "browser_type");
    L12:
        if (r111 == null) goto L16;
        Uri r106 = r111.f267530d;
        if (r106 == null) goto L16;
        String r107 = UriProtector.getQueryParameter(r106, "url");
    L17:
        e10 r108 = e10.f368561a;
        if (e10.o() == true) goto L88;
    L38:
        if (r111 == null) goto L42;
        Uri r109 = r111.f267530d;
        if (r109 == null) goto L42;
        String r112 = UriProtector.getQueryParameter(r109, "use_bullet");
    L44:
        if (Intrinsics.areEqual(r112, "1") == false) goto L47;
        Keva r113 = qg9.a.f532880a;
        qg9.a.d(r110, r111.f267530d);
        return true;
    L47:
        if (r111 == null) goto L51;
        Uri r114 = r111.f267530d;
        if (r114 == null) goto L51;
        String r115 = UriProtector.getQueryParameter(r114, CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX);
    L53:
        if (Intrinsics.areEqual(r115, "1") == true) goto L86;
        if (r111 == null) goto L58;
        Uri r116 = r111.f267530d;
        if (r116 == null) goto L58;
        String r117 = UriProtector.getQueryParameter(r116, CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE);
    L60:
        if (Intrinsics.areEqual(r117, "anniex") == true) goto L86;
        FlowRuntime.a().isOversea();
        if (TextUtils.isEmpty(r107) == true) goto L80;
        if (r111 == null) goto L74;
        Uri r118 = r111.f267530d;
        if (r118 == null) goto L72;
        Uri.Builder r119 = r118.buildUpon();
        if (r119 == null) goto L72;
        Uri.Builder r120 = r119.appendQueryParameter("link_url", r107);
        if (r120 == null) goto L72;
        Uri r121 = r120.build();
    L73:
        r111.b(String.valueOf(r121));
    L72:
        r121 = null;
    L74:
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("Router onInterceptRoute final url -> ");
        if (r111 == null) goto L77;
        r102 = r111.f267529c;
    L77:
        r123.append(r102);
        r122.d("WebViewRouteInterceptor", r123.toString());
        return false;
    L80:
        if (Intrinsics.areEqual(r105, "1") == true) goto L82;
    L85:
        return false;
    L82:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L85;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new WebViewRouteInterceptor$onInterceptRoute$2(this, r111, null), 3, null);
        return true;
    L58:
        r117 = null;
    L86:
        Keva r124 = qg9.a.f532880a;
        qg9.a.b(r110, r111.f267530d);
        return true;
    L51:
        r115 = null;
    L42:
        r112 = null;
        goto L44
    L88:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L36
        if (r111 == null) goto L26;
        Uri r126 = r111.f267530d;     // Catch: Throwable -> L36
        if (r126 == null) goto L26;
        String r127 = UriProtector.getQueryParameter(r126, "preload_bot_ids");     // Catch: Throwable -> L36
        if (r127 == null) goto L26;
        List r128 = StringsKt.split$default(r127, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L36
    L27:
        if (r128 == null) goto L33;
        Iterator r129 = r128.iterator();     // Catch: Throwable -> L36
    L30:
        if (r129.hasNext() == false) goto L32;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebViewRouteInterceptor$findOrCreateLocalConversationByBot$1((String) r129.next(), this, null), 3, null);     // Catch: Throwable -> L36
        goto L30
    L32:
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L34:
        Result.m9449constructorimpl(r130);     // Catch: Throwable -> L36
        goto L38
    L33:
        r130 = null;
    L26:
        r128 = null;
    L36:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        r107 = null;
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object c(WebViewRouteInterceptor r110, com.bytedance.router.c r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof WebViewRouteInterceptor$handleVipAuthorUrl$1) == false) goto L7;
        WebViewRouteInterceptor$handleVipAuthorUrl$1 r100 = (WebViewRouteInterceptor$handleVipAuthorUrl$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        boolean r103 = true;
        Uri r104 = null;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        String r115 = (String) r100.L$2;
        String r116 = (String) r100.L$1;
        com.bytedance.router.c r105 = (com.bytedance.router.c) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L28:
        com.larus.network.http.a r117 = (com.larus.network.http.a) r113;
        boolean r106 = false;
        if ((r117 instanceof com.larus.network.http.y) == false) goto L55;
        if (r116 != null) goto L62;
    L37:
        if (r106 == false) goto L39;
        r116 = r116.substring(1);     // Catch: Exception -> L35
    L39:
        Uri.Builder r118 = UriProtector.parse(kb9.c.f502282d).buildUpon().appendEncodedPath(r116).appendQueryParameter("share_code", r115);     // Catch: Exception -> L35
        BrowserWhiteModel r119 = (BrowserWhiteModel) ((com.larus.network.http.y) r117).f360135b;     // Catch: Exception -> L35
        if (r119 == null) goto L44;
        Boolean r120 = r119.a();     // Catch: Exception -> L35
        if (r120 == null) goto L44;
        r103 = r120.booleanValue();     // Catch: Exception -> L35
    L44:
        Uri r121 = r118.appendQueryParameter("need_verify_code", String.valueOf(r103)).build();     // Catch: Exception -> L35
        FLogger.f375446a.d("WebViewRouteInterceptor", "finalUrl: " + r121);     // Catch: Exception -> L35
        Uri r122 = r105.f267530d;     // Catch: Exception -> L35
        if (r122 == null) goto L51;
        Uri.Builder r123 = r122.buildUpon();     // Catch: Exception -> L35
        if (r123 == null) goto L51;
        Uri.Builder r124 = r123.appendQueryParameter("link_url", r121.toString());     // Catch: Exception -> L35
        if (r124 == null) goto L51;
        r104 = r124.build();     // Catch: Exception -> L35
    L51:
        r105.b(String.valueOf(r104));     // Catch: Exception -> L35
    L61:
        return Unit.INSTANCE;
    L35:
        e = move-exception;
        FLogger.f375446a.e("WebViewRouteInterceptor", ExceptionsKt.stackTraceToString(e));
        goto L61
    L62:
        if (StringsKt.startsWith$default(r116, HTTP.URL_DEFAULT, false, 2, null) != true) goto L37;
        r106 = true;
        goto L37
    L55:
        if ((r117 instanceof com.larus.network.http.f) == false) goto L61;
        com.larus.network.http.f r125 = (com.larus.network.http.f) r117;
        if (TextUtils.isEmpty(r125.f360157d.getMessage()) == false) goto L59;
        t19.s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_advanced_url_timeout, false);
        goto L61
    L59:
        t19.s.j(t19.s.f544207a, AppHost.f326268a.getApplication(), String.valueOf(r125.f360157d.getMessage()), null, false, 28);
        goto L61
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r111 == null) goto L61;
        Uri r126 = r111.f267530d;
        if (r126 == null) goto L19;
        String r127 = UriProtector.getQueryParameter(r126, "browser_white_id");
    L20:
        Uri r107 = r111.f267530d;
        if (r107 == null) goto L23;
        String r108 = UriProtector.getQueryParameter(r107, "browser_white_url");
    L24:
        CoroutineDispatcher r109 = Dispatchers.getIO();
        WebViewRouteInterceptor$handleVipAuthorUrl$2$resp$1 r128 = new WebViewRouteInterceptor$handleVipAuthorUrl$2$resp$1(r127, null);
        r100.L$0 = r111;
        r100.L$1 = r108;
        r100.L$2 = r127;
        r100.label = 1;
        Object r129 = BuildersKt.withContext(r109, r128, r100);
        if (r129 == r114) goto L64;
        r116 = r108;
        r115 = r127;
        r113 = r129;
        r105 = r111;
        goto L28
    L64:
        return r114;
    L23:
        r108 = null;
        goto L24
    L19:
        r127 = null;
    L7:
        r100 = new WebViewRouteInterceptor$handleVipAuthorUrl$1(r110, r112);
        goto L8
    }
}
