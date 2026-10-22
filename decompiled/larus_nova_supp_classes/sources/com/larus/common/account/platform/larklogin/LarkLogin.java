package com.larus.common.account.platform.larklogin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.util.EventsUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.provider.ILarkLoginProvider;
import com.larus.common.account.platform.larkauth.h;
import com.larus.network.http.HttpExtKt;
import com.larus.office.base.host.k;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J4\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0014\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016J \u0010*\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020-H\u0016JH\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u001603H\u0016J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0005H\u0016J\u0012\u00107\u001a\u00020\u00162\b\u00108\u001a\u0004\u0018\u000109H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkLogin;", "Lcom/larus/account/base/provider/ILarkLoginProvider;", "<init>", "()V", "scope", XmlPullParser.NO_NAMESPACE, "supportAppLinkPackageNames", XmlPullParser.NO_NAMESPACE, "oauthScope", "Lkotlinx/coroutines/CoroutineScope;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "enableAccountFrequentCallOpt", XmlPullParser.NO_NAMESPACE, "enterpriseAccountCache", "Lkotlin/Pair;", "login", XmlPullParser.NO_NAMESPACE, "activity", "Landroidx/fragment/app/FragmentActivity;", "secUid", "callback", "Lcom/larus/account/base/api/ILarkLoginCallback;", "openAuthorization", "startResult", "Lcom/larus/common/account/platform/larklogin/LarkOAuthSessionCoordinator$StartResult;", "extraQueryParameters", XmlPullParser.NO_NAMESPACE, "supplement", "buildFeishuWebAppLink", "url", "buildNativeAuthorizeIntentByAppLink", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applink", "isLarkAppInstalled", "authorizeByWebView", "state", "updateAuthorizeInfo", "Lcom/larus/account/base/api/ILarkUpdateAuthorizeInfoCallback;", "authorize", "params", "osType", "terminalType", "completion", "Lkotlin/Function1;", "Lcom/larus/account/base/api/LarkSupplementAuthorizationResult;", "isEnterpriseAccount", "secUserId", "saveIsEnterpriseAccount", "response", "Lcom/bytedance/sdk/account/api/call/UserApiResponse;", "Companion", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class LarkLogin implements ILarkLoginProvider {
    public static final a g = null;
    public static final LarkOAuthSessionCoordinator h = null;
    public final String a;
    public final List<String> b;
    public final CoroutineScope c;
    public final Lazy d;
    public final boolean e;
    public volatile Pair<String, Boolean> f;

    public static final class a {
        public a() {
        }

        public static String a() {
            if (HttpExtKt.e().a == false) goto L5;
            return "212951";
        L5:
            return "22518";
        }
    }

    static {
        g = new a();
        h = new LarkOAuthSessionCoordinator(0);
    }

    public LarkLogin() {
        e10 r0 = e10.a;
        String r1 = e10.Z().getEnterpriseAuthScope();
        if (r1 != null) goto L5;
        r1 = XmlPullParser.NO_NAMESPACE;
    L5:
        this.a = r1;
        this.b = e10.Z().getSupportAppLinkPackageNames();
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.d = LazyKt.lazy(new com.larus.common.account.platform.larklogin.a());
        this.e = e10.g();
    }

    public static String f(String r2) {
        Uri.Builder r0 = new Uri.Builder().scheme("https").authority("applink.feishu.cn").appendPath("client").appendPath("web_url").appendPath("open");
        if (r2 == null) goto L6;
        r0.appendQueryParameter("url", r2);
    L6:
        return r0.build().toString();
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "secUserId");
        if (this.e == false) goto L13;
        Pair<String, Boolean> r0 = this.f;
        if (r0 == null) goto L13;
        if (Intrinsics.areEqual(r0.getFirst(), r4) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L13;
        return r0.getSecond().booleanValue();
    L13:
        boolean r1 = ((Keva) this.d.getValue()).getBoolean("is_enterprise_account_" + r4, false);
        this.f = TuplesKt.to(r4, Boolean.valueOf(r1));
        return r1;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final boolean e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (g(r2, f(null)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void d(FragmentActivity r5, h r6) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "callback");
        LarkOAuthSessionCoordinator r0 = h;
        d r1 = new d(r6, this);
        e r2 = new e(r6, r5);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "exchange");
        Intrinsics.checkNotNullParameter(r2, "completion");
        h(r5, r0.g(LarkOAuthSessionCoordinator.Kind.REFRESH, r1, r2, false), MapsKt.emptyMap(), false);
    }

    public final Intent g(Context r5, String r6) {
        List<String> r0 = this.b;
        if (r0 == null) goto L12;
        List r1 = CollectionsKt.filterNotNull(r0);
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) r2.next();
        Intent r4 = new Intent();
        r4.setAction("android.intent.action.VIEW");
        r4.setData(UriProtector.parse(r6));
        r4.setPackage(r3);
        if (r4.resolveActivity(r5.getPackageManager()) == null) goto L8;
        return r4;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void c(FragmentActivity r4, String r5, LoginServiceImpl.c r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r6, "callback");
        LarkOAuthSessionCoordinator r0 = h;
        b r1 = new b(r6, this, r5);
        c r7 = new c(r6, r4);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "exchange");
        Intrinsics.checkNotNullParameter(r7, "completion");
        h(r4, r0.g(LarkOAuthSessionCoordinator.Kind.LOGIN, r1, r7, true), MapsKt.emptyMap(), false);
    }

    public final void h(FragmentActivity r12, LarkOAuthSessionCoordinator.f r13, Map<String, String> r14, boolean r15) {
        if ((r13 instanceof LarkOAuthSessionCoordinator.f.b) == false) goto L5;
        LarkOAuthSessionCoordinator.f.b r16 = (LarkOAuthSessionCoordinator.f.b) r13;
    L6:
        if (r16 == null) goto L72;
        LarkOAuthSessionCoordinator.e r17 = r16.a;
        if (r17 == null) goto L73;
        Set r1 = m.a;
        g.getClass();
        if (HttpExtKt.e().a == false) goto L13;
        String r2 = "cli_a97729fc6478de12";
    L14:
        String r3 = this.a;
        String r4 = r17.b;
        p r5 = p.a;
        String r6 = r17.c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "codeVerifier");
        boolean r7 = true;
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == false) goto L64;
    L26:
        byte[] r9 = new byte[0];
    L27:
        if (r9 != null) goto L29;
    L35:
        String r10 = XmlPullParser.NO_NAMESPACE;
    L36:
        Intrinsics.checkNotNullParameter(r2, "clientId");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r10, "codeChallenge");
        Intrinsics.checkNotNullParameter("doubaolarkauth://flow/enterprise_auth_login", "redirectUri");
        Intrinsics.checkNotNullParameter(r14, "extraQueryParameters");
        Uri.Builder r11 = UriProtector.parse("https://accounts.feishu.cn/open-apis/authen/v1/authorize").buildUpon().appendQueryParameter("client_id", r2).appendQueryParameter("response_type", "code").appendQueryParameter("scope", r3).appendQueryParameter("state", r4).appendQueryParameter("prompt", "consent").appendQueryParameter("code_challenge", r10).appendQueryParameter("code_challenge_method", "S256").appendQueryParameter("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login");
        Iterator r18 = MapsKt.toSortedMap(r14).entrySet().iterator();
    L38:
        if (r18.hasNext() == false) goto L42;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        String r21 = (String) r19.getValue();
        if (m.a.contains(r20) == true) goto L38;
        r11.appendQueryParameter(r20, r21);
        goto L38
    L42:
        String r110 = r11.build().toString();
        r12.getLifecycle().addObserver(new openAuthorization.1(r17));
        String r22 = f(r110);     // Catch: Throwable -> L51
        Intent r23 = g(r12, r22);     // Catch: Throwable -> L51
        if (r23 == null) goto L47;
        FLogger.a.i("LarkLogin", "authorize by native");     // Catch: Throwable -> L46
        r12.startActivity(r23);     // Catch: Throwable -> L46
    L61:
        return;
    L47:
        if (r15 == false) goto L49;
        FLogger.a.i("LarkLogin", "supplement authorize without installed app");     // Catch: Throwable -> L46
        r12.startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r22)));     // Catch: Throwable -> L46
        h.c(r17.a, LarkOAuthSessionCoordinator.c.a.a);     // Catch: Throwable -> L46
        goto L61
    L49:
        FLogger.a.i("LarkLogin", "authorize by webview");     // Catch: Throwable -> L46
        String r111 = UriProtector.parse(r110).buildUpon().appendQueryParameter("hidden_login_authorize_button", "1").build().toString();     // Catch: Throwable -> L46
        String r24 = r17.b;     // Catch: Throwable -> L46
        Intent r25 = new Intent(r12, LarkWebAuthorizeActivity.class);     // Catch: Throwable -> L46
        r25.putExtra("url", r111);     // Catch: Throwable -> L46
        r25.putExtra("redirect_uri", "doubaolarkauth://flow/enterprise_auth_login");     // Catch: Throwable -> L46
        r25.putExtra("state", r24);     // Catch: Throwable -> L46
        r12.startActivity(r25);     // Catch: Throwable -> L46
    L52:
        FLogger.a.e("LarkLogin", "open authorize target failed");
        if (r15 == false) goto L56;
        if (r23 != null) goto L56;
        LarkOAuthSessionCoordinator.c.a r112 = LarkOAuthSessionCoordinator.c.a.a;
    L57:
        h.c(r17.a, r112);
        return;
    L56:
        r112 = new LarkOAuthSessionCoordinator.c.c("enterprise_oauth_failed", null, null, null);
    L51:
        r23 = null;
        goto L52
    L29:
        if (r9.length == 0) goto L32;
        r7 = false;
    L32:
        if (r7 == true) goto L35;
        r10 = Base64.encodeToString(r9, 11);
        goto L36
    L64:
        MessageDigest r26 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L24
        r26.update(r6.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L24
        r9 = r26.digest();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L26
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
        goto L21
    L13:
        r2 = "cli_a92bdaf158381bdf";
        goto L14
    L73:
        return;
    L72:
        return;
    L5:
        r16 = null;
        goto L6
    }

    @Override // com.larus.account.base.provider.ILarkLoginProvider
    public final void b(FragmentActivity r7, Map r8, String r9, String r10, k r11) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "osType");
        Intrinsics.checkNotNullParameter(r10, "terminalType");
        Intrinsics.checkNotNullParameter(r11, "completion");
        Map<String, String> r12 = MapsKt.toMap(r8);
        LarkOAuthSessionCoordinator.d r0 = new LarkOAuthSessionCoordinator.d(r12, r9, r10);
        LarkOAuthSessionCoordinator r1 = h;
        f r2 = new f(this, r9, r10);
        g r13 = new g(r11);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter(r2, "exchange");
        Intrinsics.checkNotNullParameter(r13, "completion");
        Object r14 = r1.e;
        monitor-enter(r14);
        LarkOAuthSessionCoordinator.a r15 = r1.a(LarkOAuthSessionCoordinator.Kind.SUPPLEMENT, new LarkOAuthSessionCoordinator.d(MapsKt.toMap(r0.a), r0.b, r0.c), r2, r13);     // Catch: Throwable -> L8
        r1.g.put(r15.a.a, r15);     // Catch: Throwable -> L8
        monitor-exit(r14);
        h(r7, new LarkOAuthSessionCoordinator.f.b(r15.a), r12, true);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
