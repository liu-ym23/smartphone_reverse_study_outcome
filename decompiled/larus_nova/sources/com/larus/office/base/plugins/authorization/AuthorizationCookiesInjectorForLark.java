package com.larus.office.base.plugins.authorization;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.account.base.model.AuthorizationPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutSceneKey;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes29.dex */
public final class AuthorizationCookiesInjectorForLark {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthorizationCookiesInjectorForLark f360724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f360725b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f360726c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Channel<Integer> f360727d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f360728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedHashMap<String, Integer> f360729f = null;

    public AuthorizationCookiesInjectorForLark() {
    }

    static {
        f360724a = new AuthorizationCookiesInjectorForLark();
        f360725b = CollectionsKt.listOf(new String[]{"feishu.cn", "feishu.net", "larksuite.com", "larkoffice.com", "larkenterprise.com"});
        f360726c = CollectionsKt.listOf(new String[]{"access_token", LogoutSceneKey.DPOP});
        f360727d = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        f360729f = new LinkedHashMap();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AuthorizationCookiesInjectorForLark$startBackgroundTask$1(null), 2, null);
    }

    public static void e() {
        ArrayList r100 = new ArrayList();
        z2 r101 = z2.f365865a;
        boolean r102 = true;
        if ((!r101.larkAuthInjectHostList().isEmpty()) == false) goto L5;
        r100.addAll(r101.larkAuthInjectHostList());
    L6:
        String r103 = (String) CollectionsKt.firstOrNull(r100);
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        boolean r104 = false;
        if (r103.length() != 0) goto L12;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L17;
        FLogger.f375446a.w("AuthorizationCookiesInjectorForLark", "updateCookies..., docsDomain empty and no active host");
        return;
    L17:
        FLogger r106 = FLogger.f375446a;
        r106.i("AuthorizationCookiesInjectorForLark", "updateCookies..., docsDomain is " + r103 + ", activeHosts=" + r100);
        IThirdPartyPlatformAuthorizationProvider r107 = (IThirdPartyPlatformAuthorizationProvider) ServiceManager.get().getService(IThirdPartyPlatformAuthorizationProvider.class);
        if (r107 != null) goto L20;
        return;
    L20:
        if (r107.c() != AuthorizationPlatform.LARK) goto L58;
        Map<String, String> r108 = r107.b("https://".concat(r103));
        r106.i("AuthorizationCookiesInjectorForLark", "The host from server: " + r100);
        String r109 = r108.get("Authorization");
        if (r109 == null) goto L40;
        List r110 = StringsKt.split$default(r109, new String[]{" "}, false, 0, 6, null);
        if (r110.size() <= 1) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == true) goto L30;
        r110 = null;
    L30:
        if (r110 == null) goto L40;
        if (((CharSequence) ListProtector.get(r110, 1)).length() <= 0) goto L34;
        boolean r112 = true;
    L35:
        if (r112 == false) goto L41;
        String r113 = (String) ListProtector.get(r110, 1);
        Iterator r114 = r100.iterator();
    L38:
        if (r114.hasNext() == false) goto L41;
        d("access_token", r113, (String) r114.next());
    L41:
        String r115 = r108.get("DPoP");
        if (r115 != null) goto L44;
    L53:
        CookieManager.getInstance().flush();
        FLogger.f375446a.i("AuthorizationCookiesInjectorForLark", "updateCookies..., authorizationKeySuccess is " + r112 + ", dpopKeySuccess is " + r104);
        return;
    L44:
        if (r115.length() > 0) goto L47;
        r102 = false;
    L47:
        if (r102 == false) goto L52;
        Iterator r116 = r100.iterator();
    L50:
        if (r116.hasNext() == false) goto L52;
        d(LogoutSceneKey.DPOP, r115, (String) r116.next());
    L52:
        r104 = r102;
        goto L53
    L34:
        r112 = false;
        goto L35
    L26:
        r111 = false;
    L40:
        r112 = false;
        goto L41
    L58:
        return;
    L12:
        r105 = false;
        goto L14
    L5:
        r100.addAll(f360725b);
        goto L6
    }

    public static String c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L33;
        return null;
    L33:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L25
        String r104 = StringsKt.trim(r100).toString();     // Catch: Throwable -> L25
        String r105 = UriProtector.parse(r104).getHost();     // Catch: Throwable -> L25
        if (r105 == null) goto L15;
    L23:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r106) == true) goto L32;
        r102 = r106;
    L32:
        return (String) r102;
    L15:
        if (TextUtils.isEmpty(r104) == false) goto L17;
    L21:
        r104 = null;
    L22:
        r105 = r104;
        goto L23
    L17:
        if (StringsKt.contains$default(r104, HTTP.URL_DEFAULT, false, 2, null) == true) goto L21;
        if (StringsKt.contains$default(r104, ".", false, 2, null) == false) goto L21;
    L25:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final synchronized void a(String r100) {
        monitor-enter(this);
        String r101 = StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L11
        LinkedHashMap<String, Integer> r102 = f360729f;     // Catch: Throwable -> L11
        Integer r103 = r102.get(r101);     // Catch: Throwable -> L11
        if (r103 == null) goto L7;
        int r104 = r103.intValue();     // Catch: Throwable -> L11
    L8:
        int r105 = r104 + 1;     // Catch: Throwable -> L11
        r102.put(r101, Integer.valueOf(r105));     // Catch: Throwable -> L11
        f360728e = CollectionsKt.sumOfInt(r102.values());     // Catch: Throwable -> L11
        FLogger.f375446a.i("AuthorizationCookiesInjectorForLark", "attach..., host=" + r101 + ", hostCount=" + r105 + ", totalCount=" + f360728e);     // Catch: Throwable -> L11
        f360727d.mo10962trySendJP2dKIU(Integer.valueOf(f360728e));     // Catch: Throwable -> L11
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AuthorizationCookiesInjectorForLark$attachInternal$1(null), 2, null);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r104 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        String r101 = StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT);     // Catch: Throwable -> L15
        LinkedHashMap<String, Integer> r102 = f360729f;     // Catch: Throwable -> L15
        Integer r103 = r102.get(r101);     // Catch: Throwable -> L15
        if (r103 == null) goto L7;
        int r104 = r103.intValue();     // Catch: Throwable -> L15
    L9:
        if (r104 > 1) goto L11;
        r102.remove(r101);     // Catch: Throwable -> L15
    L12:
        f360728e = CollectionsKt.sumOfInt(r102.values());     // Catch: Throwable -> L15
        FLogger.f375446a.i("AuthorizationCookiesInjectorForLark", "detach..., host=" + r101 + ", totalCount=" + f360728e);     // Catch: Throwable -> L15
        f360727d.mo10962trySendJP2dKIU(Integer.valueOf(f360728e));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        r102.put(r101, Integer.valueOf(r104 - 1));     // Catch: Throwable -> L15
        goto L12
    L7:
        r104 = 0;
    L15:
        th = move-exception;
        throw th;
    }

    public static void d(String r100, String r101, String r102) {
        String r103 = r100 + com.alipay.sdk.m.n.a.f25612h + r101 + "; Path=/; Domain=." + r102 + "; Secure; SameSite=None";
        CookieManager.getInstance().setCookie("https://" + r102, r103);
    }
}
