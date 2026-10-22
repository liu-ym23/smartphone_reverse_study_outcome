package com.larus.home.impl.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.api.AppletService;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoubaoAppsRouterInterceptor implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f346048a = null;

    public static final class a {
    }

    public DoubaoAppsRouterInterceptor() {
    }

    static {
        f346048a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L6;
        Uri r101 = r100.f267530d;
        if (r101 == null) goto L6;
        String r102 = r101.getAuthority();
    L7:
        boolean r103 = Intrinsics.areEqual("doubao_apps", r102);
        if (r103 == false) goto L10;
        FLogger.f375446a.i("DoubaoAppsRouterInterceptor", "Router matchInterceptRules -> host: " + r102 + ", intercepting.");
    L10:
        return r103;
    L6:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.String] */
    @Override // q97.a
    public final boolean a(Context r210, com.bytedance.router.c r211) {
        boolean r100 = false;
        if (r211 == null) goto L55;
        Uri r101 = r211.f267530d;
        if (r101 == null) goto L55;
        Intent r102 = r211.f267528b;
        if (r102 == null) goto L16;
        Bundle r103 = r102.getExtras();
        if (r103 == null) goto L16;
        String r104 = r103.getString("argConversationId");
        if (r104 == null) goto L16;
        if ((!StringsKt.isBlank(r104)) == false) goto L16;
    L17:
        String r110 = r104;
        FLogger r105 = FLogger.f375446a;
        r105.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: conversationId = " + r110 + ", uri: " + r101);
        String r106 = UriProtector.getQueryParameter(r101, "app_id");
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L28;
        r105.e("DoubaoAppsRouterInterceptor", "onInterceptRoute: ERROR, app_id missing. Uri: " + r101);
        return true;
    L28:
        if (com.bytedance.ai.settings.b.f37584k.a().b().contains(r106) == true) goto L30;
    L33:
        ?? r108 = UriProtector.getQueryParameter(r101, "path");
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = r108;
        if (r108 == 0) goto L38;
        String r109 = UriProtector.getQueryParameter(r101, "query");
        if (r109 == null) goto L38;
        r111.element = ((String) r111.element) + '?' + r109;
    L38:
        String r112 = UriProtector.getQueryParameter(r101, "anniex_url");
        if (r112 != null) goto L41;
    L42:
        r100 = true;
    L43:
        if (r100 == true) goto L45;
        r105.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: anniexUrl = " + r112);
        r111.element = new Uri.Builder().path(HTTP.URL_DEFAULT).appendQueryParameter("anniex_url", r112).build().toString();
    L45:
        String r113 = UriProtector.getQueryParameter(r101, MusicAppletPage.ROUTE_MODE);
        r105.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: appId: " + r106 + ", pageUrl: " + ((String) r111.element) + ", mode: " + r113);
        AppletService r114 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r114 != null) goto L50;
        r105.e("DoubaoAppsRouterInterceptor", "onInterceptRoute: ERROR, AppletService unavailable");
        return true;
    L50:
        if (r114.isInitialized() == false) goto L53;
        c(r210, r106, (String) r111.element, r113, r110);
        return true;
    L53:
        BuildersKt.launch$default(f346048a, null, CoroutineStart.UNDISPATCHED, new DoubaoAppsRouterInterceptor$onInterceptRoute$2(r114, this, r210, r106, r111, r113, r110, null), 1, null);
        return true;
    L41:
        if (r112.length() != 0) goto L43;
    L30:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L33;
        r105.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: appId requires login, open half login page");
        i3.f365750a.d(TriggerLoginScene.TRIGGER_LOGIN_CLICK_OTHERS, r211.f267529c);
        return true;
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
    L16:
        r104 = null;
    L55:
        return false;
    }

    public static void c(Context r100, String r101, String r102, String r103, String r104) {
        if (IAICreationAppletHostService.f370273a.u(r100, r101, r102, r103) == false) goto L6;
        FLogger.f375446a.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: handled by AI creation applet business");
        return;
    L6:
        AppletRuntimeManager r105 = AppletRuntimeManager.INSTANCE;
        Iterator<ApplicationRouter.Mode> r106 = ApplicationRouter.Mode.getEntries().iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        ApplicationRouter.Mode r107 = r106.next();
        if (Intrinsics.areEqual(r107.getValue(), r103) == false) goto L8;
    L13:
        ApplicationRouter.Mode r108 = r107;
        if (r108 != null) goto L16;
        r108 = ApplicationRouter.Mode.NAVIGATE;
    L16:
        r105.getClass();
        AppletRuntimeManager.l(r101, r102, r108, r104);
        return;
    L12:
        r107 = null;
        goto L13
    }
}
