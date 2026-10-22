package l39;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.platform.exp.i;
import com.larus.settings.model.FeishuDocLinkConfig;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import java.net.URLEncoder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f507264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f507265b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.f507264a = LazyKt.lazy(new b());
        this.f507265b = LazyKt.lazy(new c(this));
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (((FeishuDocLinkConfig) this.f507264a.getValue()).getEnable() == true) goto L7;
        FLogger.f375446a.d("FeishuDocLinkInterceptor", "matchInterceptRules: feature disabled, skip");
        return false;
    L7:
        if (i.f365385a.a() == false) goto L10;
        FLogger.f375446a.d("FeishuDocLinkInterceptor", "matchInterceptRules: lark drive list enabled, skip feishu doc link deeplink");
        return false;
    L10:
        FLogger r101 = FLogger.f375446a;
        r101.i("FeishuDocLinkInterceptor", "matchInterceptRules: feishu doc link deeplink feature enabled, start intercepting");
        int r102 = k0.f375428a;
        String r103 = null;
        if (r100 == null) goto L15;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L15;
        String r105 = r104.toString();
    L17:
        if (Intrinsics.areEqual(k0.a(r105), "//flow/webview") == true) goto L20;
        r101.d("FeishuDocLinkInterceptor", "matchInterceptRules: not webview route, skip");
        return false;
    L20:
        if (r100 == null) goto L24;
        Intent r106 = r100.f267528b;
        if (r106 == null) goto L24;
        r103 = r106.getStringExtra("link_url");
    L24:
        if (r103 != null) goto L27;
        r101.e("FeishuDocLinkInterceptor", "matchInterceptRules: linkUrl is null, skip");
        return false;
    L27:
        boolean r107 = ((sm9.b) this.f507265b.getValue()).a(r103);
        r101.i("FeishuDocLinkInterceptor", "matchInterceptRules: matched=" + r107 + ", url=" + r103);
        return r107;
    L15:
        r105 = null;
        goto L17
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r110) {
        boolean r101 = true;
        if (r100 == null) goto L22;
        if (r110 == null) goto L22;
        Intent r111 = r110.f267528b;
        if (r111 == null) goto L9;
        String r112 = r111.getStringExtra("link_url");
    L10:
        if (r112 != null) goto L13;
        FLogger.f375446a.w("FeishuDocLinkInterceptor", "onInterceptRoute: linkUrl is null");
        return false;
    L13:
        FLogger r102 = FLogger.f375446a;
        r102.i("FeishuDocLinkInterceptor", "onInterceptRoute: start handling url=".concat(r112));
        int r103 = sm9.a.f542586a;
        Intrinsics.checkNotNullParameter(r112, "httpsUrl");
        String r104 = "lark://applink.larksuite.com/client/web_url/open?url=" + URLEncoder.encode(r112, "UTF-8");
        r102.i("FeishuDocDeeplinkConverter", "toDeeplink: original=" + r112 + ", deeplink=" + r104);
        StringBuilder r105 = new StringBuilder("onInterceptRoute: converted deeplink=");
        r105.append(r104);
        r102.i("FeishuDocLinkInterceptor", r105.toString());
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104));     // Catch: Exception -> L19
        r106.putExtra("start_only_for_android", true);     // Catch: Exception -> L19
        if ((r100 instanceof Activity) == true) goto L17;
        r106.addFlags(268435456);     // Catch: Exception -> L19
    L17:
        r100.startActivity(r106);     // Catch: Exception -> L19
        r102.i("FeishuDocLinkInterceptor", "onInterceptRoute: launched feishu app for url=".concat(r112));     // Catch: Exception -> L19
        return true;
    L19:
        e = move-exception;
        FLogger.f375446a.e("FeishuDocLinkInterceptor", "onInterceptRoute: failed to launch feishu app, fallback to WebView", e);
        return false;
    L9:
        r112 = null;
    L22:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("onInterceptRoute: invalid args, contextNull=");
        if (r100 != null) goto L25;
        boolean r109 = true;
    L26:
        r108.append(r109);
        r108.append(", routeNull=");
        if (r110 == null) goto L30;
        r101 = false;
    L30:
        r108.append(r101);
        r107.w("FeishuDocLinkInterceptor", r108.toString());
        return false;
    L25:
        r109 = false;
        goto L26
    }
}
