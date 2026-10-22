package com.larus.common.account.platform.larklogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.provider.ILarkLoginProvider;
import com.larus.network.http.HttpExtKt;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0014\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016J \u0010*\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020-H\u0016JH\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001603H\u0016J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0005H\u0016J\u0012\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u000109H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkLogin;", "Lcom/larus/account/base/provider/ILarkLoginProvider;", "<init>", "()V", "scope", "", "supportAppLinkPackageNames", "", "oauthScope", "Lkotlinx/coroutines/CoroutineScope;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "enableAccountFrequentCallOpt", "", "enterpriseAccountCache", "Lkotlin/Pair;", "login", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "secUid", "callback", "Lcom/larus/account/base/api/ILarkLoginCallback;", "openAuthorization", "startResult", "Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$StartResult;", "extraQueryParameters", "", "supplement", "buildFeishuWebAppLink", "url", "buildNativeAuthorizeIntentByAppLink", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "applink", "isLarkAppInstalled", "authorizeByWebView", "state", "updateAuthorizeInfo", "Lcom/larus/account/base/api/ILarkUpdateAuthorizeInfoCallback;", "authorize", "params", "osType", "terminalType", "completion", "Lkotlin/Function1;", "Lcom/larus/account/base/api/LarkSupplementAuthorizationResult;", "isEnterpriseAccount", "secUserId", "saveIsEnterpriseAccount", "response", "Lcom/bytedance/sdk/account/api/call/UserApiResponse;", "Companion", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkLogin implements ILarkLoginProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f326155g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LarkOAuthSessionCoordinator f326156h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f326157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f326158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f326159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f326160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f326161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Pair<String, Boolean> f326162f;

    public static final class a {
        public a() {
        }

        public static String a() {
            if (HttpExtKt.e().f360166a == false) goto L5;
            return "212951";
        L5:
            return "22518";
        }
    }

    static {
        f326155g = new a();
        f326156h = new LarkOAuthSessionCoordinator(0);
    }

    public LarkLogin() {
        e10 r100 = e10.f368561a;
        String r101 = e10.Z().getEnterpriseAuthScope();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f326157a = r101;
        this.f326158b = e10.Z().getSupportAppLinkPackageNames();
        this.f326159c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f326160d = LazyKt.lazy(new com.larus.common.account.platform.larklogin.a());
        this.f326161e = e10.g();
    }

    public static String f(String r100) {
        Uri.Builder r101 = new Uri.Builder().scheme("https").authority("applink.feishu.cn").appendPath("client").appendPath("web_url").appendPath("open");
        if (r100 == null) goto L6;
        r101.appendQueryParameter("url", r100);
    L6:
        return r101.build().toString();
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "secUserId");
        if (this.f326161e == false) goto L13;
        Pair<String, Boolean> r101 = this.f326162f;
        if (r101 == null) goto L13;
        if (Intrinsics.areEqual(r101.getFirst(), r100) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L13;
        return r101.getSecond().booleanValue();
    L13:
        boolean r102 = ((Keva) this.f326160d.getValue()).getBoolean("is_enterprise_account_" + r100, false);
        this.f326162f = TuplesKt.to(r100, Boolean.valueOf(r102));
        return r102;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final boolean e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (g(r100, f(null)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void d(final FragmentActivity r100, final com.larus.common.account.platform.larkauth.h r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        LarkOAuthSessionCoordinator r102 = f326156h;
        Function3 r103 = new d(r101, this);
        Function1 r104 = new e(r101, r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "exchange");
        Intrinsics.checkNotNullParameter(r104, "completion");
        h(r100, r102.g(LarkOAuthSessionCoordinator.Kind.REFRESH, r103, r104, false), MapsKt.emptyMap(), false);
    }

    public final Intent g(Context r100, String r101) {
        List<String> r102 = this.f326158b;
        if (r102 == null) goto L12;
        List r103 = CollectionsKt.filterNotNull(r102);
        if (r103 == null) goto L17;
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        String r105 = (String) r104.next();
        Intent r106 = new Intent();
        r106.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r106.setData(UriProtector.parse(r101));
        r106.setPackage(r105);
        if (r106.resolveActivity(r100.getPackageManager()) == null) goto L8;
        return r106;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void c(final FragmentActivity r100, final String r101, final LoginServiceImpl.c r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, "callback");
        LarkOAuthSessionCoordinator r103 = f326156h;
        Function3 r104 = new b(r102, this, r101);
        Function1 r105 = new c(r102, r100);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "exchange");
        Intrinsics.checkNotNullParameter(r105, "completion");
        h(r100, r103.g(LarkOAuthSessionCoordinator.Kind.LOGIN, r104, r105, true), MapsKt.emptyMap(), false);
    }

    public final void h(FragmentActivity r110, LarkOAuthSessionCoordinator.f r111, Map<String, String> r112, boolean r113) {
        if ((r111 instanceof LarkOAuthSessionCoordinator.f.b) == false) goto L5;
        LarkOAuthSessionCoordinator.f.b r114 = (LarkOAuthSessionCoordinator.f.b) r111;
    L6:
        if (r114 == null) goto L72;
        final LarkOAuthSessionCoordinator.e r115 = r114.f326198a;
        if (r115 == null) goto L73;
        Set<String> r100 = m.f326229a;
        f326155g.getClass();
        if (HttpExtKt.e().f360166a == false) goto L13;
        String r101 = "cli_a97729fc6478de12";
    L14:
        String r102 = this.f326157a;
        String r103 = r115.f326195b;
        p r104 = p.f326232a;
        String r105 = r115.f326196c;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "codeVerifier");
        boolean r106 = true;
        if (r105 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L64;
    L26:
        byte[] r108 = new byte[0];
    L27:
        if (r108 != null) goto L29;
    L35:
        String r109 = "";
    L36:
        Intrinsics.checkNotNullParameter(r101, "clientId");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r109, "codeChallenge");
        Intrinsics.checkNotNullParameter("doubaolarkauth://flow/enterprise_auth_login", "redirectUri");
        Intrinsics.checkNotNullParameter(r112, "extraQueryParameters");
        Uri.Builder r116 = UriProtector.parse("https://accounts.feishu.cn/open-apis/authen/v1/authorize").buildUpon().appendQueryParameter("client_id", r101).appendQueryParameter("response_type", "code").appendQueryParameter("scope", r102).appendQueryParameter("state", r103).appendQueryParameter(EventConstant.Key.RETAIN_PROMPT, "consent").appendQueryParameter("code_challenge", r109).appendQueryParameter("code_challenge_method", "S256").appendQueryParameter("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login");
        Iterator r117 = MapsKt.toSortedMap(r112).entrySet().iterator();
    L38:
        if (r117.hasNext() == false) goto L42;
        Map.Entry r118 = (Map.Entry) r117.next();
        String r119 = (String) r118.getKey();
        String r120 = (String) r118.getValue();
        if (m.f326229a.contains(r119) == true) goto L38;
        r116.appendQueryParameter(r119, r120);
        goto L38
    L42:
        String r121 = r116.build().toString();
        r110.getLifecycle().addObserver(new LarkLogin$openAuthorization$1(r115));
        String r122 = f(r121);     // Catch: Throwable -> L51
        Intent r123 = g(r110, r122);     // Catch: Throwable -> L51
        if (r123 == null) goto L47;
        FLogger.f375446a.i("LarkLogin", "authorize by native");     // Catch: Throwable -> L46
        r110.startActivity(r123);     // Catch: Throwable -> L46
    L61:
        return;
    L47:
        if (r113 == false) goto L49;
        FLogger.f375446a.i("LarkLogin", "supplement authorize without installed app");     // Catch: Throwable -> L46
        r110.startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r122)));     // Catch: Throwable -> L46
        f326156h.c(r115.f326194a, LarkOAuthSessionCoordinator.c.a.f326184a);     // Catch: Throwable -> L46
        goto L61
    L49:
        FLogger.f375446a.i("LarkLogin", "authorize by webview");     // Catch: Throwable -> L46
        String r124 = UriProtector.parse(r121).buildUpon().appendQueryParameter("hidden_login_authorize_button", "1").build().toString();     // Catch: Throwable -> L46
        String r125 = r115.f326195b;     // Catch: Throwable -> L46
        Intent r126 = new Intent(r110, LarkWebAuthorizeActivity.class);     // Catch: Throwable -> L46
        r126.putExtra("url", r124);     // Catch: Throwable -> L46
        r126.putExtra("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login");     // Catch: Throwable -> L46
        r126.putExtra("state", r125);     // Catch: Throwable -> L46
        r110.startActivity(r126);     // Catch: Throwable -> L46
    L52:
        FLogger.f375446a.e("LarkLogin", "open authorize target failed");
        if (r113 == false) goto L56;
        if (r123 != null) goto L56;
        LarkOAuthSessionCoordinator.c r127 = LarkOAuthSessionCoordinator.c.a.f326184a;
    L57:
        f326156h.c(r115.f326194a, r127);
        return;
    L56:
        r127 = new LarkOAuthSessionCoordinator.c.C4181c("enterprise_oauth_failed", null, null, null);
    L51:
        r123 = null;
        goto L52
    L29:
        if (r108.length == 0) goto L32;
        r106 = false;
    L32:
        if (r106 == true) goto L35;
        r109 = Base64.encodeToString(r108, 11);
        goto L36
    L64:
        MessageDigest r128 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L24
        r128.update(r105.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L24
        r108 = r128.digest();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L26
    L17:
        if (r105.length() == 0) goto L20;
        r107 = false;
        goto L21
    L13:
        r101 = "cli_a92bdaf158381bdf";
        goto L14
    L73:
        return;
    L72:
        return;
    L5:
        r114 = null;
        goto L6
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void b(FragmentActivity r100, Map r101, final String r102, final String r110, final com.larus.office.base.host.k r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "osType");
        Intrinsics.checkNotNullParameter(r110, "terminalType");
        Intrinsics.checkNotNullParameter(r111, "completion");
        Map<String, String> r103 = MapsKt.toMap(r101);
        LarkOAuthSessionCoordinator.d r104 = new LarkOAuthSessionCoordinator.d(r103, r102, r110);
        LarkOAuthSessionCoordinator r105 = f326156h;
        Function3<? super String, ? super String, ? super String, Unit> r106 = new f(this, r102, r110);
        Function1<? super LarkOAuthSessionCoordinator.c, Unit> r107 = new g(r111);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r106, "exchange");
        Intrinsics.checkNotNullParameter(r107, "completion");
        Object r112 = r105.f326168e;
        monitor-enter(r112);
        LarkOAuthSessionCoordinator.a r108 = r105.a(LarkOAuthSessionCoordinator.Kind.SUPPLEMENT, new LarkOAuthSessionCoordinator.d(MapsKt.toMap(r104.f326191a), r104.f326192b, r104.f326193c), r106, r107);     // Catch: Throwable -> L8
        r105.f326170g.put(r108.f326176a.f326194a, r108);     // Catch: Throwable -> L8
        monitor-exit(r112);
        h(r100, new LarkOAuthSessionCoordinator.f.b(r108.f326176a), r103, true);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
