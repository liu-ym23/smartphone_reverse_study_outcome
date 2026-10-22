package o7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.base.HybridDomainUtils;
import com.bytedance.android.annie.param.n;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.util.JellyBeanMR1V17Compat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.config.AppConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522252a = 0;

    static {
    }

    @JvmStatic
    public static final String b(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "customUABuilder");
        StringBuilder r101 = new StringBuilder(" ");
        com.bytedance.android.annie.ng.g.b().getClass();
        o8.a r102 = com.bytedance.android.annie.ng.e.f39661a;
        r101.append(r102.f522306b);
        r101.append('_');
        com.bytedance.android.annie.ng.g.b().getClass();
        r101.append(r102.f522307c);
        r100.append(r101.toString());
        StringBuilder r103 = new StringBuilder(" AppVersion/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r103.append(r102.f522307c);
        r100.append(r103.toString());
        r100.append(" JsSdk/2.0");
        r100.append(" NetType/" + ((IAnnieNetworkService) Annie.getService$default(IAnnieNetworkService.class, null, 2, null)).getNetworkAccessType().toUpperCase(Locale.ROOT));
        StringBuilder r104 = new StringBuilder(" Channel/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r104.append(r102.f522309e);
        r100.append(r104.toString());
        r100.append(" ByteLocale/" + Locale.CHINA.getLanguage());
        r100.append(" Region/" + Locale.CHINA.getCountry());
        StringBuilder r105 = new StringBuilder(" App/");
        com.bytedance.android.annie.ng.g.b().getClass();
        r105.append(r102.f522306b);
        r100.append(r105.toString());
        r100.append(" Webcast_ByteLocale/" + Locale.CHINA.getLanguage());
        String r106 = ((i9.d) Annie.getService$default(i9.d.class, null, 2, null)).k0();
        if (r106 == null) goto L6;
        r100.append(" WebcastSDK/".concat(r106));
    L6:
        if (com.bytedance.android.annie.ng.g.b().f39659c.f522324a == false) goto L11;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (r102.f522315k == false) goto L10;
        r100.append(" AppTheme/light");
        goto L11
    L10:
        r100.append(" AppTheme/dark");
    L11:
        String r107 = ((n) Annie.getService$default(n.class, null, 2, null)).N0();
        if (r107 == null) goto L15;
        r100.append(r107);
    L15:
        return r100.toString();
    }

    @JvmStatic
    public static final boolean f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r100, "http://", false, 2, null) == false) goto L8;
    L9:
        return true;
    L8:
        if (StringsKt.startsWith$default(r100, "https://", false, 2, null) == true) goto L9;
        return false;
    }

    @JvmStatic
    public static final boolean g(String r100) {
        if (e.a() == false) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L30;
        return false;
    L30:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        Object r103 = Result.m9449constructorimpl(new URI(r100).getHost());     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r103) == false) goto L21;
        r103 = null;
    L21:
        String r104 = (String) r103;
        if (r104 == null) goto L29;
        Iterator r105 = ((List) HybridDomainUtils.f39133a.getValue()).iterator();
    L25:
        if (r105.hasNext() == false) goto L29;
        if (h(r104, (String) r105.next()) == false) goto L25;
        return true;
    L29:
        return false;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L8:
        if (StringsKt.isBlank(r100) == true) goto L11;
        r101 = false;
        goto L12
    }

    @JvmStatic
    public static final String e(Context r100, WebView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "webView");
        String r102 = r101.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(r102) == true) goto L5;
        return r102;
    L5:
        String r103 = JellyBeanMR1V17Compat.getWebViewDefaultUserAgent(r100);
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103;
    }

    public static boolean h(String r100, String r101) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L27;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L27;
        if (r100.length() < r101.length()) goto L27;
        if (StringsKt.endsWith$default(r100, r101, false, 2, null) == false) goto L27;
        if (Intrinsics.areEqual(r101, r100) == false) goto L23;
        return true;
    L23:
        if (StringsKt.endsWith$default(r100, ".".concat(r101), false, 2, null) == true) goto L29;
        return false;
    L29:
        return true;
    L9:
        if (StringsKt.isBlank(r101) == true) goto L12;
        r103 = false;
    L27:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public static void a(Map r100, Set r101, Uri.Builder r102) {
        Iterator r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        Map.Entry r104 = (Map.Entry) r103.next();
        CharSequence r105 = (CharSequence) r104.getValue();
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L4;
        if (r101.contains(r104.getKey()) == true) goto L4;
        r102.appendQueryParameter((String) r104.getKey(), (String) r104.getValue());
        goto L4
    L8:
        if (StringsKt.isBlank(r105) == true) goto L11;
        r106 = false;
        goto L12
    }

    @JvmStatic
    public static final String c(String r100, WebView r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "loaderName");
        if (g(r100) == true) goto L5;
        return r100;
    L5:
        Uri r103 = UriProtector.parse(r100);
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);
        Uri.Builder r105 = r103.buildUpon();
        Map<String, String> r106 = ((com.bytedance.android.annie.service.network.i) Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null)).s1();
        x8.a.d("WebViewUtil", "===WebViewUtil 拼接公共参数===", false);
        if (r106 == null) goto L8;
        x8.a.d("WebViewUtil", r106.toString(), false);
    L8:
        a(r106, r104, r105);
        Iterator r107 = ((CopyOnWriteArrayList) p9.a.f528281b).iterator();
    L10:
        if (r107.hasNext() == false) goto L13;
        a(((p9.h) r107.next()).a(r100, IHybridComponent.HybridType.H5, r102), r104, r105);
        goto L10
    L13:
        return r105.build().toString();
    }

    @JvmStatic
    public static final String d(String r110, WebView r111, Map<String, String> r112, String r113, String r210) {
        String r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r111, "webview");
        Intrinsics.checkNotNullParameter(r112, "headers");
        String r101 = null;
        if (StringsKt.isBlank(r110) == false) goto L5;
        return null;
    L5:
        ((aa.b) Annie.getService$default(aa.b.class, null, 2, null)).y1(r111);
        boolean r102 = f(r110);
        if (TextUtils.equals(UriProtector.getQueryParameter(UriProtector.parse(r110), "keep_origin_url"), "1") == false) goto L10;
        boolean r103 = false;
    L12:
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522323b == false) goto L53;
        URI r104 = URI.create(r110);
        String r114 = r104.getHost();
        if (r114 != null) goto L16;
    L18:
        boolean r115 = false;
    L19:
        if (r115 == false) goto L53;
        List<String> r105 = AnnieConfigSettingKeys.LIVE_WEBVIEW_DEBUG_BOE_ALLOW_LIST.a();
        if (r105 == null) goto L35;
        Iterator<String> r106 = r105.iterator();
    L24:
        if (r106.hasNext() == false) goto L35;
        String r116 = r106.next();
        if (r114 != null) goto L28;
    L30:
        boolean r117 = false;
    L31:
        if (r117 == false) goto L24;
        if (r114 == null) goto L34;
        r101 = StringsKt.replace$default(r114, CJPayConstant.BOE_SUFFIX, "", false, 4, null);
    L34:
        r114 = r101;
        goto L35
    L28:
        if (StringsKt.startsWith$default(r114, r116, false, 2, null) != true) goto L30;
        r117 = true;
    L35:
        String r107 = r104.getScheme();
        int r108 = r104.getPort();
        String r109 = r104.getRawPath();
        String r118 = r104.getRawQuery();
        String r119 = r104.getRawFragment();
        StringBuilder r120 = new StringBuilder();
        if (r114 == null) goto L42;
        if (r107 == null) goto L39;
        r120.append(r107);
        r120.append("://");
    L39:
        r120.append(r114);
        if (r108 <= 0) goto L42;
        r120.append(':');
        r120.append(r108);
    L42:
        if (r109 != null) goto L44;
    L45:
        r120.append('/');
    L46:
        if (r109 == null) goto L48;
        r120.append(r109);
    L48:
        if (r118 == null) goto L50;
        r120.append('?');
        r120.append(r118);
    L50:
        if (r119 == null) goto L52;
        r120.append('#');
        r120.append(r119);
    L52:
        r100 = new URI(r120.toString()).toString();
        goto L53
    L44:
        if (r109.startsWith(HTTP.URL_DEFAULT) == true) goto L46;
    L16:
        if (StringsKt.endsWith$default(r114, CJPayConstant.BOE_SUFFIX, false, 2, null) != true) goto L18;
        r115 = true;
    L53:
        Context r121 = r111.getContext();
        if (r121 == null) goto L58;
        if (r103 == false) goto L58;
        if (r102 == false) goto L58;
        r100 = AppConfig.getInstance(r121).filterUrlOnUIThread(r100);
    L58:
        if (r113 != null) goto L60;
        String r122 = "https://nativeapp.toutiao.com";
    L61:
        r112.put(AppConstants.HTTP_H_REFERER, r122);
        if (r210 != null) goto L64;
        String r123 = "";
    L66:
        return c(r100, r111, r123);
    L64:
        r123 = r210;
        goto L66
    L60:
        r122 = r113;
    L10:
        r103 = true;
        goto L12
    }
}
