package com.ss.android.token;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.EventsUtils;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardManager;
import com.bytedance.android.sdk.bdticketguard.a0;
import com.bytedance.android.sdk.bdticketguard.b0;
import com.bytedance.android.sdk.bdticketguard.c0;
import com.bytedance.android.sdk.bdticketguard.c1;
import com.bytedance.android.sdk.bdticketguard.d0;
import com.bytedance.android.sdk.bdticketguard.e0;
import com.bytedance.android.sdk.bdticketguard.f0;
import com.bytedance.android.sdk.bdticketguard.g0;
import com.bytedance.android.sdk.bdticketguard.i;
import com.bytedance.android.sdk.bdticketguard.j1;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.android.sdk.bdticketguard.u0;
import com.bytedance.android.sdk.bdticketguard.w0;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.devicetransfer.AccountDeviceTransferManager;
import com.bytedance.sdk.account.identitytoken.IdentityTokenManager;
import com.bytedance.sdk.account.impl.g;
import com.bytedance.sdk.account.impl.i0;
import com.bytedance.sdk.account.impl.j;
import com.bytedance.sdk.account.settings.AccountHostSettingsManager;
import com.bytedance.sdk.account.settings.common.ShareTokenConfigParser;
import com.bytedance.sdk.account.settings.common.TokenShareMatcher;
import com.bytedance.sdk.account.settings.common.e;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.ticketguard.f;
import com.bytedance.sdk.account.ticketguard.h;
import com.bytedance.sdk.account.time.RealTimeManager;
import com.bytedance.sdk.account.utils.n;
import com.bytedance.sdk.account.utils.o;
import com.bytedance.sdk.account.utils.r;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.account.k;
import java.net.URI;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import qb7.b;
import rb7.l;
import ta7.d;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class TokenFactory implements WeakHandler.IHandler {
    public static volatile TokenFactory C;
    public static final List<c> D = null;
    public static volatile boolean E;
    public static volatile boolean F;
    public long A;
    public final s B;
    public volatile boolean a;
    public volatile boolean b;
    public volatile boolean c;
    public final r d;
    public volatile boolean e;
    public volatile boolean f;
    public final Object g;
    public volatile n h;
    public volatile Context i;
    public volatile WeakHandler j;
    public final AtomicBoolean k;
    public final AtomicBoolean l;
    public volatile boolean m;
    public volatile boolean n;
    public final a o;
    public volatile boolean p;
    public volatile boolean q;
    public volatile boolean r;
    public volatile boolean s;
    public volatile JSONObject t;
    public volatile AuthTokenMultiProcessSharedProvider.b u;
    public volatile PassportExtraHeaderManager v;
    public volatile boolean w;
    public final Object x;
    public final Set<String> y;
    public final AtomicBoolean z;

    public final void B() {
        this.m = true;
        if (this.m == false) goto L5;
        return;
    L5:
        if (F == true) goto L7;
        return;
    L7:
        if (E == false) goto L14;
        this.d.getClass();
        String r0 = r.d();
        g();
        if (TextUtils.isEmpty(r0) == true) goto L15;
        TTTokenMonitor.b("token_disabled", r0);
        return;
    L15:
        return;
    }

    public final e0 o() {
        t(true, "getTokenObject");
        this.d.getClass();
        return r.e();
    }

    static {
        D = new CopyOnWriteArrayList();
        E = false;
    }

    public static TokenFactory j() {
        if (C != null) goto L15;
        monitor-enter(TokenFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (C != null) goto L9;
        C = new TokenFactory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TokenFactory.class);     // Catch: Throwable -> L11
    L15:
        return C;
    }

    public final void e() {
        if (AccountHostSettingsManager.d.a() <= 0) goto L6;
        return;
    L6:
        if (AccountDeviceTransferManager.g() == false) goto L9;
        return;
    L9:
        if (this.k.compareAndSet(false, true) == false) goto L37;
        a.d("TokenFactory", "TokenFactory.afterInit, sIsMainProcess: " + F);
        this.j.post(new y());
        if (F == false) goto L38;
        ta7.c r1 = c0.c;
        Context r5 = this.i;
        a.d("TokenGuardLoginListener", "registerListeners");
        j r6 = j.m(r5);
        r6.d(r1);
        c0.a = r6.isLogin();
        f.a();
        boolean r2 = f.u;
        if (r2 == false) goto L26;
        AtomicBoolean r7 = new AtomicBoolean(false);
        CountDownLatch r8 = new CountDownLatch(1);
        AccountTicketGuardManager.c(this.i, new t(this, r8, r7));
        boolean r9 = r8.await(1, TimeUnit.SECONDS);     // Catch: InterruptedException -> L22
        if (r9 == false) goto L18;
    L20:
        a.d("TokenFactory", "afterInit, createInitialAttestSign isFinished: " + r9);     // Catch: InterruptedException -> L22
    L27:
        if (r2 == false) goto L39;
        AttestSignCompensateTask.d.b(this.i);
        ta7.c r0 = SecTimeUpdater.k;
        Context r3 = this.i;
        r0.getClass();
        j.m(r3).d(r0);
        if (((ta7.f) this.o.a()).isLogin() == false) goto L31;
        AttestSignCompensateTask.a("boot_login");
        a.d("TokenFactory", "afterInit login, checkAndCompensate");
        return;
    L31:
        if (((Boolean) f.a0.a()).booleanValue() == true) goto L40;
        SecTimeUpdater.c(false);
        a.d("TokenFactory", "afterInit not login, startUpdateSecTime");
        return;
    L40:
        return;
    L39:
        return;
    L18:
        if (r7.compareAndSet(false, true) == false) goto L20;
        f();     // Catch: InterruptedException -> L22
    L22:
        e = move-exception;
        a.b("TokenFactory", "afterInit, createInitialAttestSign InterruptedException: " + e.getMessage());
        if (r7.compareAndSet(false, true) == false) goto L27;
        f();
        goto L27
    L26:
        f();
        goto L27
    L38:
        return;
    }

    public final void g() {
        a.a("TokenFactory", "clearToken");
        e0 r0 = new e0();
        r0.h = 0;
        C("clear_token", r0, null);
    }

    public final void h() {
        if (this.l.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        String r0 = d.a("/passport/account/info/v2/") + "cache";
        boolean r3 = ((ta7.f) this.o.a()).isLogin();
        a.a("TokenFactory", "isLogin = " + r3);
        String r6 = null;
        if (r3 == false) goto L10;
        f.a();
        if (f.k == false) goto L34;
        a.a("TokenFactory", "do account/info request, login");
        g.a().b("boot", null);
    L34:
        boolean r1 = D(true);
        this.j.sendEmptyMessageDelayed(2000, 60000);
        if (r1 == false) goto L37;
        return;
    L37:
        if (((ta7.f) this.o.a()).isLogin() == true) goto L39;
        return;
    L39:
        if (F == false) goto L52;
        a.e("TokenFactory", "TokenFactory.afterInit, token beat not sent");
        IdentityTokenManager.h.getClass();
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.B == true) goto L43;
        a.d("IdentityTokenManager", "refreshIdentityTokenOnBoot, disabled");
        return;
    L43:
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.E == false) goto L54;
        a.d("IdentityTokenManager", "refreshIdentityTokenOnBoot, enabled");
        IdentityTokenManager.g("boot", "account_sdk_boot");
        return;
    L54:
        return;
    L52:
        return;
    L10:
        com.bytedance.sdk.account.utils.f r4 = com.bytedance.sdk.account.utils.f.a();
        r4.getClass();
        if (TextUtils.isEmpty(r0) == false) goto L14;
    L31:
        a.a("TokenFactory", "cache = " + r6);
        if (TextUtils.isEmpty(r6) == false) goto L34;
        a.a("TokenFactory", "do account/info request, un-login");
        g.a().b("normal", new x(r0));
        goto L34
    L14:
        if (r4.a != null) goto L18;
        Context r7 = k.c();
        if (r7 == null) goto L18;
        r4.a = r7.getSharedPreferences("com_bytedance_sdk_account_utils_common_request_cache_helper", 0);
    L18:
        SharedPreferences r2 = r4.a;
        if (r2 == null) goto L31;
        String r5 = com.bytedance.sdk.account.utils.f.b(r0);
        String r8 = r2.getString(r5, XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r8) == true) goto L31;
        JSONObject r9 = new JSONObject(r8);     // Catch: Exception -> L29
        if (System.currentTimeMillis() >= r9.optLong("expire_timing")) goto L27;
        r6 = r9.optString("cache_value", XmlPullParser.NO_NAMESPACE);     // Catch: Exception -> L29
    L47:
        goto L31
    L27:
        r2.edit().putString(r5, XmlPullParser.NO_NAMESPACE).apply();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public final AuthTokenMultiProcessSharedProvider.b m() {
        if (this.u != null) goto L19;
        this.h.getClass();
        String r0 = null;
        if (TextUtils.isEmpty(null) == false) goto L7;
        r0 = "token_shared_preference";
    L7:
        Context r1 = this.i;
        boolean r2 = F;
        String r3 = AuthTokenMultiProcessSharedProvider.e;
        monitor-enter(AuthTokenMultiProcessSharedProvider.class);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (AuthTokenMultiProcessSharedProvider.h != null) goto L12;
        AuthTokenMultiProcessSharedProvider.h = new AuthTokenMultiProcessSharedProvider.b(r1, r0, r2);     // Catch: Throwable -> L15
    L12:
        AuthTokenMultiProcessSharedProvider.b r4 = AuthTokenMultiProcessSharedProvider.h;     // Catch: Throwable -> L15
        monitor-exit(AuthTokenMultiProcessSharedProvider.class);
        this.u = r4;
    L19:
        return this.u;
    }

    public final void u() {
        if (E == false) goto L5;
        return;
    L5:
        Object r0 = this.x;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (E == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        this.d.getClass();     // Catch: Throwable -> L14
        r.f();     // Catch: Throwable -> L14
        E = true;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public TokenFactory() {
        this.a = false;
        this.b = true;
        this.c = false;
        this.d = r.o;
        this.e = false;
        this.f = false;
        this.g = new Object();
        this.k = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.m = true;
        this.n = false;
        this.o = new a(this);
        this.q = true;
        this.w = false;
        this.x = new Object();
        this.y = new 9(this);
        this.z = new AtomicBoolean(false);
        this.A = 0;
        this.B = new s();
    }

    public final void f() {
        if (AccountDeviceTransferManager.g() == true) goto L5;
        h();
        return;
    L5:
        if (((b) AccountDeviceTransferManager.h).b == false) goto L9;
        AccountTicketGuardManager.j.getClass();
        if (AccountTicketGuardManager.i == false) goto L9;
    L10:
        h();
        return;
    L9:
        if (((b) qb7.d.f).b == true) goto L10;
    }

    public final String k() {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.r == true) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        t(true, "getLastSameUserToken");
        this.d.getClass();
        if (r.b == true) goto L14;
        f0 r0 = r.d;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L13:
        return r0.b();
    L14:
        return r.g;
    }

    public static void b(c r1) {
        if (E == false) goto L6;
        r1.onInitFinish();
        return;
    L6:
        ((CopyOnWriteArrayList) D).add(r1);
    }

    public static String i(String r3) {
        int r1 = r3.indexOf("://") + 3;     // Catch: Throwable -> L12
        if (r1 > 3) goto L6;
        return null;
    L6:
        int r2 = r3.indexOf(47, r1);     // Catch: Throwable -> L12
        if (r2 <= 0) goto L11;
        return r3.substring(r1, r2).toLowerCase();
    L11:
        return r3.substring(r1).toLowerCase();
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String l(Object r3) {
        if (r3 != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        String r4 = r3.toString();
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        if (r4.length() > 10) goto L11;
        return r4;
    L11:
        return r4.substring(0, 9) + "***" + r4.substring(r4.length() - 5);
    }

    public static String p(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return null;
    L10:
        return UriProtector.parse(r2).getPath();
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static String v(String r7) {
        if (r7 != null) goto L6;
        return "null";
    L6:
        if (r7.isEmpty() == false) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.indexOf("\"ts_sign\"", 0);
        int r3 = -1;
        if (r1 < 0) goto L12;
        int r2 = r1 + 9;
    L14:
        if (r2 < 0) goto L16;
        int r5 = Math.min(r2 + 24, r7.length());
        r0.append("[ts_sign]");
        r0.append(r7, r2, r5);
        r0.append("…");
    L17:
        int r4 = r7.indexOf("\"ts_sign_ree\"", 0);
        if (r4 < 0) goto L20;
        r3 = r4 + 13;
    L20:
        if (r3 < 0) goto L22;
        int r6 = Math.min(r3 + 24, r7.length());
        r0.append("[ts_sign_ree]");
        r0.append(r7, r3, r6);
        r0.append("…");
    L23:
        if (r2 < 0) goto L25;
        if (r3 < 0) goto L25;
    L27:
        return r0.toString();
    L25:
        r0.append("[masked]: ");
        r0.append(l(r7));
        goto L27
    L22:
        r0.append("[ts_sign_ree not found]");
        goto L23
    L16:
        r0.append("[ts_sign not found]");
        goto L17
    L12:
        r2 = -1;
        goto L14
    }

    public final boolean D(boolean r6) {
        a.d("TokenFactory", "TokenFactory tryUpdateToken, isBoot=" + r6 + ", isWap=false, scene=null, fromHost=null, fromPath=null, fromLogid=null, isMainProcess=" + F + ", isBeating=" + this.b + ", isUpdateLoading=" + this.a);
        if (F == true) goto L6;
        return false;
    L6:
        if (this.b == true) goto L9;
        return false;
    L9:
        if (this.a == false) goto L12;
        return false;
    L12:
        if (r6 == true) goto L17;
        if (p.b == true) goto L17;
        a.d("TokenFactory", "TokenFactory tryUpdateToken, not init");
        this.j.sendEmptyMessageDelayed(EventsUtils.FEAT_TYPE_SHUT_DOWN, 5000);
        return false;
    L17:
        if (((ta7.f) this.o.a()).isLogin() == true) goto L19;
        a.d("TokenFactory", "TokenFactory tryUpdateToken, not login");
        this.j.sendEmptyMessageDelayed(EventsUtils.FEAT_TYPE_SHUT_DOWN, this.h.g);
        return false;
    L19:
        this.a = true;
        this.p = true;
        SecTimeUpdater.k.getClass();     // Catch: Throwable -> L22
        SecTimeUpdater.d();     // Catch: Throwable -> L22
    L24:
        String r7 = n(r6, null);
        if (TextUtils.isEmpty(r7) == false) goto L27;
        a.e("TokenFactory", "TokenFactory tryUpdateToken, tokenUrl is empty");
        this.a = false;
        return false;
    L27:
        l.p(this.i, r7, new v(this, r7)).m();
        return true;
    L22:
        th = move-exception;
        a.c("TokenFactory", "tryUpdateToken, stopUpdateSecTime error", th);
        goto L24
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r5) {
        int r0 = r5.what;
        if (r0 != 1000) goto L11;
        Object r6 = r5.obj;
        if ((r6 instanceof Integer) == true) goto L7;
    L9:
        this.j.removeMessages(EventsUtils.FEAT_TYPE_SHUT_DOWN);
        D(false);
        return;
    L7:
        if (((Integer) r6).intValue() != 1) goto L9;
        a.a("TokenFactory", "handleMsg, obj=reveal");
        goto L9
    L11:
        if (r0 != 2000) goto L44;
        if (F == false) goto L65;
        StringBuilder r7 = new StringBuilder();
        k.d().isLocalTest();
        if (this.o.a() == null) goto L23;
        if (((ta7.f) this.o.a()).isLogin() == false) goto L23;
        if (this.p == true) goto L23;
        String r1 = this.i.getString(2131897370);
        TTTokenMonitor.c("token_beat_not_poll", r1, null);
        r7.append(r1);
    L23:
        if (this.q == true) goto L26;
        String r2 = this.i.getString(2131895996);
        TTTokenMonitor.c("token_beat_not_config", r2, this.t);
        r7.append(r2);
    L26:
        if (NetworkUtils.isNetworkAvailable(this.i) == false) goto L33;
        if (this.r == true) goto L30;
    L31:
        String r3 = this.i.getString(2131913651);
        TTTokenMonitor.c("sdk-version-not-add", r3, null);
        r7.append(r3);
        goto L33
    L30:
        if (this.s == false) goto L31;
    L33:
        if (this.h.e == true) goto L36;
        TTTokenMonitor.t("tt_token_not_call_add_host_list", null);
        r7.append(this.i.getString(2131914329));
    L36:
        if (F == false) goto L62;
        this.d.getClass();
        long r4 = r.j;
        HashSet r8 = TTTokenMonitor.b;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.n == false) goto L66;
        JSONObject r9 = new JSONObject();
        r9.put("read_cache_duration", r4);     // Catch: Exception -> L56
    L42:
        com.bytedance.sdk.account.monitor.c.d("token_init_finish", r9.toString());
        return;
    L66:
        return;
    L62:
        return;
    L65:
        return;
    L44:
        if (r0 != 3000) goto L64;
        a.a("TokenFactory", "handleMsg: MSG_ACCOUNT_INFO");
        if (this.o.a() == null) goto L48;
        long r10 = ((ta7.f) this.o.a()).getUserId();
    L49:
        String r11 = o().a;
        HashSet r12 = TTTokenMonitor.b;
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L52
        r13.put("uid", String.valueOf(r10));     // Catch: JSONException -> L52
        r13.put("token", r.c(r11));     // Catch: JSONException -> L52
        TTTokenMonitor.r("passport_user_mixed_uid_reveal", r13);     // Catch: JSONException -> L52
    L54:
        g.a().b("reveal", new w());
        return;
    L52:
        e = move-exception;
        a.c("AccountSDK", "monitorUserMixedUidReveal error", e);
        goto L54
    L48:
        r10 = 0;
        goto L49
    }

    public final void z(AuthTokenMultiProcessSharedProvider.a r5) {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.r == true) goto L5;
        return;
    L5:
        boolean r1 = true;
        t(true, "saveLastToken");
        this.d.getClass();
        a.a("TokenFactory", "save last token");
        if (r.b == false) goto L28;
        Object r0 = r.l;
        monitor-enter(r0);
        r.g = r.e.a;     // Catch: Throwable -> L25
        if (r5 == null) goto L13;
        r1 = false;
    L13:
        if (r5 != null) goto L19;
        AuthTokenMultiProcessSharedProvider.b r6 = r.a;     // Catch: Throwable -> L25
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");     // Catch: Throwable -> L25
    L18:
        r5 = r6.b();     // Catch: Throwable -> L25
    L19:
        r5.c("x-tt-token-last", r.e.a);     // Catch: Throwable -> L25
        if (r1 == false) goto L22;
        r5.a();     // Catch: Throwable -> L25
    L22:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r0);
        return;
    L25:
        th = move-exception;
        throw th;
    L28:
        f0 r8 = r.d;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L31:
        r8.e();
    }

    public static void A(Context r5, n r6) {
        TokenFactory r0 = j();
        if (r0.w == true) goto L25;
        a.d("TokenFactory", "TokenFactory.tryInitInstance start");
        monitor-enter(TokenFactory.class);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (r0.w == false) goto L11;
        monitor-exit(TokenFactory.class);     // Catch: Throwable -> L20
        return;
    L11:
        r0.h = r6;     // Catch: Throwable -> L20
        r0.i = r5.getApplicationContext();     // Catch: Throwable -> L20
        Application r7 = (Application) r0.i;     // Catch: Throwable -> L20
        if (r7 == null) goto L14;
        com.bytedance.sdk.account.utils.d.c(r7);     // Catch: Throwable -> L20
    L14:
        F = h0.d(r0.i);     // Catch: Throwable -> L20
        r0.j = new WeakHandler(Looper.getMainLooper(), r0);     // Catch: Throwable -> L20
        r0.m();     // Catch: Throwable -> L20
        r0.v = PassportExtraHeaderManager.c(r0.i, r0.m(), F);     // Catch: Throwable -> L20
        r r8 = r0.d;     // Catch: Throwable -> L20
        AuthTokenMultiProcessSharedProvider.b r9 = r0.u;     // Catch: Throwable -> L20
        boolean r3 = F;     // Catch: Throwable -> L20
        Context r4 = r0.i;     // Catch: Throwable -> L20
        r8.getClass();     // Catch: Throwable -> L20
        r.a = r9;     // Catch: Throwable -> L20
        r.b = r3;     // Catch: Throwable -> L20
        r.c = r4;     // Catch: Throwable -> L20
        if (r3 == true) goto L17;
        r.d = new f0(r4);     // Catch: Throwable -> L20
    L17:
        r0.w = true;     // Catch: Throwable -> L20
        j r10 = i.a;     // Catch: Throwable -> L20
        i.a(r0.B);     // Catch: Throwable -> L20
        a.d("TokenFactory", "TokenFactory.tryInitInstance finish. isMainProcess: " + F);     // Catch: Throwable -> L20
        monitor-exit(TokenFactory.class);     // Catch: Throwable -> L20
        return;
    }

    public static void r(Context r5, n r6) {
        a.d("TokenFactory", "TokenFactory.initialize start");
        int r1 = AccountHostSettingsManager.d.a();
        if (r1 != 0) goto L5;
        A(r5, r6);
        j().t(false, "TokenFactory.initialize");
    L5:
        TokenFactory r7 = j();
        if (r7.m == false) goto L8;
    L12:
        boolean r2 = AccountDeviceTransferManager.g();
        if (r1 > 0) goto L15;
        if (r2 == true) goto L15;
    L23:
        if (F == true) goto L25;
    L30:
        a.d("TokenFactory", "TokenFactory.initialize finish");
        return;
    L25:
        if (((Boolean) f.a0.a()).booleanValue() == false) goto L30;
        a.d("TokenFactory", "initialize, pre request sec_ts");
        if (((ta7.f) r7.o.a()).isLogin() == true) goto L29;
        SecTimeUpdater.k.getClass();
        SecTimeUpdater.c(true);
        goto L30
    L29:
        SecTimeUpdater.k.getClass();
        SecTimeUpdater.b(r5, "TokenInit", true);
    L15:
        AccountTicketGuardManager.f(r5, "initialize", new b(r5, r7));
        if (r2 == false) goto L19;
        a.d("TokenFactory", "initialize(), isEnableDeviceTransferLogoutForInit=true");
        AccountDeviceTransferManager.h.e(new c(r7));
        qb7.d.f.e(new d(r7));
    L19:
        if (F == false) goto L21;
        r7.j.postDelayed(new e(r7), 8000);
    L21:
        r7.j.post(new y());
        goto L23
    L8:
        if (F == false) goto L12;
        r7.d.getClass();
        String r3 = r.d();
        r7.g();
        if (TextUtils.isEmpty(r3) == true) goto L12;
        TTTokenMonitor.b("token_disabled", r3);
        goto L12
    }

    public final String n(boolean r4, String r5) {
        fc7.c r1 = new fc7.c(this.h.a + "/passport/token/beat/v2/");
        if (r4 == false) goto L5;
        String r6 = "boot";
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        r5 = r6;
    L10:
        r1.a("scene", r5);
        r1.b("first_beat", "false");
        return r1.toString();
    L5:
        r6 = "polling";
        goto L7
    }

    public final boolean s(String r22, String r23) {
        if (TextUtils.isEmpty(r23) == false) goto L5;
        return false;
    L5:
        String r2 = p(r22);
        if (TextUtils.isEmpty(r23) == false) goto L8;
    L27:
        boolean r4 = false;
    L28:
        com.bytedance.sdk.account.settings.common.c.a r6 = com.bytedance.sdk.account.settings.common.c.a();
        String r7 = null;
        if (r6 != null) goto L31;
        TokenShareMatcher r8 = null;
        String r10 = null;
        int r9 = 0;
        int r11 = 0;
    L45:
        if (r8 == null) goto L81;
        if (r9 != 0) goto L48;
        if (r11 == 0) goto L81;
    L48:
        long r13 = System.nanoTime();
        if (TextUtils.isEmpty(r23) == true) goto L79;
        String r15 = r23.toLowerCase(Locale.US);
        if (r2 != null) goto L54;
        String r3 = XmlPullParser.NO_NAMESPACE;
    L56:
        if (r8.a.isEmpty() == true) goto L67;
        Set r5 = r8.a;
        if (TextUtils.isEmpty(r15) == true) goto L64;
        if (r5 == null) goto L64;
        if (r5.isEmpty() == true) goto L64;
        boolean r12 = h0.c(r15, r5);
    L65:
        if (r12 == false) goto L67;
        boolean r14 = true;
    L68:
        if (r14 == false) goto L74;
        TokenShareMatcher.d r16 = r8.b;
        if (r16 != null) goto L72;
    L78:
        boolean r17 = true;
    L80:
        long r18 = (System.nanoTime() - r13) / 1000;
        boolean r19 = true;
    L82:
        if (r9 == 0) goto L91;
        if (r8 == null) goto L91;
        if (r17 == true) goto L86;
    L90:
        boolean r20 = r17;
    L92:
        if (r11 == 0) goto L146;
        if (r19 == false) goto L146;
        if (r4 == false) goto L146;
        if (r17 == true) goto L146;
        com.bytedance.sdk.account.settings.common.c.a r21 = com.bytedance.sdk.account.settings.common.c.a();
        if (r21 == null) goto L100;
        List r24 = r21.e;
    L102:
        if (TextUtils.isEmpty(r2) == true) goto L117;
        if (r24 == null) goto L117;
        if (r24.isEmpty() == true) goto L117;
        Iterator r25 = r24.iterator();
    L109:
        if (r25.hasNext() == false) goto L117;
        String r110 = (String) r25.next();
        if (TextUtils.isEmpty(r110) == true) goto L109;
        if (r2.contains(r110) == false) goto L109;
        r7 = r110;
    L117:
        if (TextUtils.isEmpty(r7) == true) goto L120;
        a.d("TokenFactory", "skip token share shadow monitor by monitor_exclude_path, path=" + r2 + ", matched=" + r7);
        goto L146
    L120:
        if (F == false) goto L122;
        String r26 = "main";
    L123:
        HashSet r28 = TTTokenMonitor.b;
        long r111 = System.currentTimeMillis();
        long r112 = TTTokenMonitor.a;
        if (r112 > 0) goto L126;
    L128:
        TTTokenMonitor.a = r111;
        boolean r29 = true;
    L129:
        if (r29 == true) goto L147;
        a.d("TTTokenMonitor", "skip token share shadow monitor by frequency control, path=" + r2);
        goto L146
    L147:
        JSONObject r30 = new JSONObject();     // Catch: Exception -> L144
        r30.put("host", r23);     // Catch: Exception -> L144
        r30.put("path", r2);     // Catch: Exception -> L144
        if (r4 == false) goto L134;
        int r31 = 1;
    L135:
        r30.put("legacy_match", r31);     // Catch: Exception -> L144
        if (r17 == false) goto L138;
        int r32 = 1;
    L139:
        r30.put("new_match", r32);     // Catch: Exception -> L144
        r30.put("config_enable", r9);     // Catch: Exception -> L144
        r30.put("shadow_enable", r11);     // Catch: Exception -> L144
        r30.put("config_version", r10);     // Catch: Exception -> L144
        if (TextUtils.isEmpty(r26) == true) goto L142;
        r30.put("process", r26);     // Catch: Exception -> L144
    L142:
        r30.put("match_duration", r18);     // Catch: Exception -> L144
        TTTokenMonitor.r("passport_token_share_check", r30);     // Catch: Exception -> L144
        goto L146
    L138:
        r32 = 0;
        goto L139
    L134:
        r31 = 0;
    L144:
        e = move-exception;
        TTTokenMonitor.d(e);
        goto L146
    L126:
        if ((r111 - r112) >= 5000) goto L128;
        r29 = false;
        goto L129
    L122:
        r26 = "sub";
        goto L123
    L100:
        r24 = ShareTokenConfigParser.a;
    L146:
        return r20;
    L86:
        if (this.h == null) goto L90;
        if (r22 == null) goto L90;
        this.h.getClass();
    L91:
        r20 = r4;
        goto L92
    L72:
        if (r16.b(r15, r3) == false) goto L78;
    L74:
        TokenShareMatcher.d r33 = r8.c;
        if (r33 == null) goto L79;
        if (r33.b(r15, r3) == false) goto L79;
    L64:
        r12 = false;
    L67:
        r14 = false;
        goto L68
    L54:
        r3 = r2;
    L79:
        r17 = false;
    L81:
        r18 = 0;
        r17 = false;
        r19 = false;
        goto L82
    L31:
        if (r6.a == true) goto L33;
    L35:
        r9 = 0;
    L37:
        if (r6.b == true) goto L39;
    L41:
        r11 = 0;
    L42:
        r10 = r6.c;
        r8 = r6.d;
        goto L45
    L39:
        if (r6.d == null) goto L41;
        r11 = 1;
        goto L42
    L33:
        if (r6.d == null) goto L35;
        r9 = 1;
        goto L37
    L8:
        if (this.h == null) goto L27;
        if (this.m == false) goto L21;
        Set r34 = this.h.c();
        if (TextUtils.isEmpty(r23) == true) goto L18;
        if (r34 == null) goto L18;
        if (((CopyOnWriteArraySet) r34).isEmpty() == true) goto L18;
        boolean r35 = h0.c(r23, r34);
    L19:
        if (r35 == false) goto L21;
        r4 = true;
    L23:
        if (this.h == null) goto L28;
        if (r22 == null) goto L28;
        this.h.getClass();
    L18:
        r35 = false;
    L21:
        r4 = false;
        goto L23
    }

    public final void t(boolean r6, String r7) {
        AccountHostSettingsManager r1 = AccountHostSettingsManager.d;
        if (r1.a() <= 0) goto L6;
        return;
    L6:
        if (AccountDeviceTransferManager.g() == false) goto L10;
        u();
        return;
    L10:
        if (E == false) goto L14;
        if (r6 == true) goto L42;
        e();
        return;
    L42:
        return;
    L14:
        a.d("TokenFactory", "TokenFactory.loadData start, isLazyLoad = " + r6 + " callFrom: " + r7);
        Object r2 = this.x;
        monitor-enter(r2);
    L27:
        th = move-exception;
        throw th;
    L17:
        if (E == false) goto L23;
        if (r6 == true) goto L20;
        e();     // Catch: Throwable -> L27
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L27
        return;
    L23:
        if (F == false) goto L32;
        if (TextUtils.isEmpty(this.h.a) == true) goto L30;
        this.d.getClass();     // Catch: Throwable -> L27
        r.f();     // Catch: Throwable -> L27
        this.d.getClass();     // Catch: Throwable -> L27
        r.b();     // Catch: Throwable -> L27
        ThreadPlus.submitRunnable(new u(this));     // Catch: Throwable -> L27
        goto L32
    L30:
        throw new IllegalStateException("not set beat host");     // Catch: Throwable -> L27
    L32:
        if (r1.a() != 0) goto L34;
        z r3 = new z(this);     // Catch: Throwable -> L27
    L35:
        AccountTicketGuardManager.f(this.i, "init", r3);     // Catch: Throwable -> L27
        E = true;     // Catch: Throwable -> L27
        this.j.post(new y());     // Catch: Throwable -> L27
        a.d("TokenFactory", "TokenFactory.loadData finish, isLazyLoad = " + r6 + " callFrom: " + r7);     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        E = true;
        return;
    L34:
        r3 = null;
        goto L35
    }

    public static void d(Map r7, com.bytedance.android.sdk.bdticketguard.j r8, com.bytedance.android.sdk.bdticketguard.g r9) {
        String r0 = ((g0) r8).b;
        String r1 = ((i) r8).f;
        j1 r2 = w0.a;
        if (w0.a != null) goto L7;
        a.e("TokenFactory", "addUseTicketGuardParams, ticket guard service is null");
        TTTokenMonitor.n(((g0) r8).b, r1, "-1", "ticket guard service is null");
        return;
    L7:
        if (r9 != null) goto L9;
    L16:
        boolean r4 = TextUtils.isEmpty(((i) r8).e);
        f.a();
        boolean r5 = !f.p;
        boolean r3 = r0.startsWith("/passport");
        boolean r10 = TextUtils.isEmpty(r8.n);
        if (r4 == true) goto L35;
        if (r5 == false) goto L21;
        if (r10 == true) goto L35;
    L21:
        if (r10 == false) goto L24;
        if (r3 == false) goto L24;
        a.e("TokenFactory", "addUseTicketGuardParams, tsSign is empty, continue sign");
        TTTokenMonitor.n(r0, r1, "-2", "tsSign is empty, continue sign");
    L24:
        if (r9 == null) goto L32;
        List r11 = ((d0) r9).b;
        if (r11 == null) goto L32;
        if (r11.isEmpty() == true) goto L32;
        r7.putAll(o.a(((d0) r9).b));
        return;
    L32:
        if (r3 == false) goto L42;
        TTTokenMonitor.n(r0, r1, "-3", "TicketGuardHeader is null or empty");
        return;
    L42:
        return;
    L35:
        if (r4 == false) goto L37;
        String r12 = "target is empty";
    L38:
        a.e("TokenFactory", "addUseTicketGuardParams, ".concat(r12));
        if (r3 == false) goto L43;
        TTTokenMonitor.n(r0, r1, "-2", r12);
        return;
    L43:
        return;
    L37:
        r12 = "tsSign is empty";
        goto L38
    L9:
        if (r9.i.isEmpty() == true) goto L16;
        f.a();
        if (f.b0 == false) goto L16;
        if (r0.startsWith("/passport") == false) goto L15;
        a.d("TokenFactory", "addTeeStaticSignHeader path=".concat(r0));
    L15:
        r7.putAll(o.a(r9.i));
        goto L16
    }

    public final void C(String r18, e0 r19, AuthTokenMultiProcessSharedProvider.a r20) {
        boolean r4 = true;
        t(true, "setTokenObject");
        this.d.getClass();
        a.d("TokenFactory", "updateTokenObject begin, scene: " + r18 + ", " + r19.a() + ", isMainProcess: " + r.b);
        if (r.b == false) goto L38;
        Object r3 = r.l;
        monitor-enter(r3);
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L35
        boolean r5 = com.bytedance.sdk.account.settings.common.a.U;     // Catch: Throwable -> L35
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L35
        boolean r6 = com.bytedance.sdk.account.settings.common.a.V;     // Catch: Throwable -> L35
        if (r5 == false) goto L18;
        AuthTokenMultiProcessSharedProvider.b r8 = r.a;     // Catch: Throwable -> L35
        r.c(r19);     // Catch: Throwable -> L35
        if (r6 == false) goto L18;
        String r9 = r19.f;     // Catch: Throwable -> L35
        if (r9 == null) goto L18;
        if (r9.length() <= 0) goto L15;
        boolean r10 = true;
    L16:
        if (r10 != true) goto L18;
        boolean r11 = true;
    L19:
        if (r11 == false) goto L21;
        e0 r15 = new e0(XmlPullParser.NO_NAMESPACE, r19.b, r19.c, r19.d, r19.g, r19.h);     // Catch: Throwable -> L35
        r15.f = r19.f;     // Catch: Throwable -> L35
        e0 r16 = r15;
    L22:
        boolean r7 = !Intrinsics.areEqual(r.e.a, r19.a);     // Catch: Throwable -> L35
        r.e = r19;     // Catch: Throwable -> L35
        AuthTokenMultiProcessSharedProvider.b r12 = r.a;     // Catch: Throwable -> L35
        r.g(r18, r16, r7, r20);     // Catch: Throwable -> L35
        e0 r13 = r.e;     // Catch: Throwable -> L35
        String r14 = r13.a;     // Catch: Throwable -> L35
        if (TextUtils.isEmpty(r14) == false) goto L25;
        String r17 = XmlPullParser.NO_NAMESPACE;
    L26:
        r13.e = r17;     // Catch: Throwable -> L35
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r3);
        String r22 = r.e.a;
        if ((!Intrinsics.areEqual("change.token", r22)) == true) goto L31;
    L33:
        r4 = false;
    L34:
        r.k = r4;
        a.d("TokenFactory", "updateTokenObject end, scene: " + r18 + r.e.a() + " isTokenValid: " + r.k + "logTagEnableEncrypt: " + r5 + ", logTagClosePlainText: " + r6 + ", logTagCleanPlainText: " + r11);
    L42:
        TicketGuardEventHelper.g.n(r19.a, r19.b);
        return;
    L31:
        if (TextUtils.isEmpty(r22) == true) goto L33;
    L25:
        int r110 = bc7.a.a;     // Catch: Throwable -> L35
        r17 = String.valueOf(bc7.a.a(r14.getBytes(), 0));     // Catch: Throwable -> L35
        goto L26
    L21:
        r16 = r19;
        goto L22
    L15:
        r10 = false;
    L18:
        r11 = false;
    L35:
        th = move-exception;
        throw th;
    L38:
        f0 r0 = r.d;
        if (r0 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tokenObjectProviderHelper");
    L41:
        r0.f(r19);
        goto L42
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v56, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25, types: [int] */
    /* JADX WARN: Type inference failed for: r6v77 */
    public final f c(String r54, String r55, List<o> r56, boolean r57) {
        if (TextUtils.isEmpty(r54) == false) goto L5;
        return null;
    L5:
        String r15 = i(r54);
        if (s(r54, r15) == true) goto L19;
        a.a("TokenFactory", "not in domain list, host: " + r15 + " url: " + r54);
        Set r0 = this.h.c();
        HashSet r4 = TTTokenMonitor.b;
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L15
        URI r6 = new URI(r54);     // Catch: Exception -> L15
        String r2 = r6.getHost();     // Catch: Exception -> L15
        if (r6.getPath().startsWith("/passport/") == false) goto L17;
        HashSet r7 = TTTokenMonitor.b;     // Catch: Exception -> L15
        if (r7.contains(r2) == true) goto L17;
        r7.add(r2);     // Catch: Exception -> L15
        r5.put("host", r2);     // Catch: Exception -> L15
        r5.put("tt_account_share_token_domains", r0.toString());     // Catch: Exception -> L15
        TTTokenMonitor.t("passport_request_without_x_tt_token", r5);     // Catch: Exception -> L15
    L17:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L19:
        if (r54.startsWith("http://") == false) goto L26;
        e.a();
        if (e.b == false) goto L23;
        return null;
    L23:
        e.a();
        if (e.c == false) goto L26;
        boolean r8 = true;
    L27:
        if (r56 == null) goto L36;
        Iterator r1 = ((ArrayList) r56).iterator();
    L30:
        if (r1.hasNext() == false) goto L36;
        o r9 = (o) r1.next();
        if (r9 == null) goto L30;
        if ("x-uc-bypass-token".equalsIgnoreCase(r9.a) == false) goto L30;
        String r3 = r9.b;
    L38:
        if ("1".equals(r3) == false) goto L41;
        a.a("TokenFactory", "should bypass token, url: ".concat(r54));
        return null;
    L41:
        t(true, "addRequestHeader");
        String r12 = p(r54);
        if (TextUtils.isEmpty(r12) == false) goto L44;
    L46:
        boolean r22 = false;
    L47:
        if (r22 == true) goto L49;
    L55:
        if (r22 == false) goto L57;
        a.d("TokenFactory", "addRequestHeader for passport request. path: " + r12 + " url: " + r54);
    L57:
        HashMap r11 = new HashMap();
        e0 r10 = o();
        String r13 = r10.a;
        if (TextUtils.isEmpty(r13) == true) goto L60;
        r11.put("X-Tt-Token", r13);
    L61:
        this.d.getClass();
        if (r.b == false) goto L64;
        String r14 = r.f;
    L69:
        if (TextUtils.isEmpty(r14) == true) goto L71;
        r11.put("x-tt-passport-mfa-token", r14);
    L71:
        r11.put("sdk-version", "2");
        r11.put("passport-sdk-version", String.valueOf(60592));
        if (r22 == false) goto L79;
        String r16 = ((ta7.f) this.o.a()).b();
        if (TextUtils.isEmpty(r16) == true) goto L76;
        r11.put("x-tt-passport-verify-portrait", r16);
    L76:
        String r17 = ((ta7.f) this.o.a()).c();
        if (TextUtils.isEmpty(r17) == true) goto L79;
        r11.put("x-tt-passport-verify-portrait-outer", r17);
    L79:
        if (r22 == false) goto L84;
        String r18 = oc7.a.b;
        if (TextUtils.isEmpty(r18) == true) goto L84;
        r11.put("x-tt-passport-trace-id", r18);
    L84:
        if ("/passport/token/beat/v2/".equals(r12) == false) goto L90;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.p == true) goto L89;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.q == false) goto L90;
    L89:
        r11.put("x-uc-sec-uid", com.ss.android.account.b.z0().getSecUid());
    L90:
        f r19 = new f();
        r19.a = r11;
        r19.d = r8;
        StringBuilder r20 = new StringBuilder();
        if (r57 == true) goto L93;
    L406:
        StringBuilder r37 = r20;
        f r21 = r19;
        e0 r52 = r10;
        HashMap r41 = r11;
    L216:
        ?? r23 = 1;
    L407:
        PassportExtraHeaderManager r24 = this.v;
        r24.getClass();
        com.bytedance.sdk.account.settings.common.b.a();
        if (com.bytedance.sdk.account.settings.common.b.b == true) goto L411;
        HashMap r25 = r41;
    L410:
        e0 r26 = r52;
        if (TextUtils.isEmpty(r26.g) == true) goto L429;
        r25.put("token-tlb-tag", r26.g);
    L429:
        AccountDeviceTransferManager.h.getClass();
        com.bytedance.sdk.account.settings.common.a.a();
        StringBuilder r28 = r37;
        r28.append("device_transfer_s_" + com.bytedance.sdk.account.settings.common.a.K);
        r28.append(",device_transfer_ab_0,");
        AccountHostSettingsManager.d.getClass();
        AccountHostSettingsManager.b.getClass();
        if (r28.length() <= 0) goto L433;
        r28.deleteCharAt(r28.length() - r23);
        r25.put("passport-sdk-settings", r28.toString());
    L433:
        if (F == false) goto L452;
        if (((ta7.f) this.o.a()).isLogin() == false) goto L452;
        this.d.getClass();
        if (r.k == true) goto L443;
        a.e("TokenFactory", "Token lost: ".concat(r54));
    L443:
        if (this.c == true) goto L452;
        this.d.getClass();
        if (r.k == true) goto L452;
        this.c = r23;
        HashSet r29 = TTTokenMonitor.b;
        JSONObject r30 = new JSONObject();     // Catch: Exception -> L449
        r30.put("urlpath", TTTokenMonitor.a(r54));     // Catch: Exception -> L449
        TTTokenMonitor.t("x_tt_token_lost", r30);     // Catch: Exception -> L449
    L449:
        e = move-exception;
        e.printStackTrace();
    L452:
        if (this.r == true) goto L454;
    L455:
        if (r22 == false) goto L458;
        this.r = r23;
    L461:
        return r21;
    L458:
        if (((ta7.f) this.o.a()).isLogin() == true) goto L460;
        this.r = r23;
    L460:
        this.s = r23;
        goto L461
    L454:
        if (this.s == true) goto L461;
    L411:
        r24.h();
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.M == false) goto L425;
        String r31 = (String) r24.a.get("x-tt-token-supplement");
        if (n.a(r31) == true) goto L416;
    L424:
        r25 = r41;
        r25.putAll(r24.a);
        goto L410
    L416:
        if (r24.d("x-tt-token-supplement", r31, "append") == false) goto L424;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.P == false) goto L424;
        String r32 = r24.b().getString("x-tt-token-supplement", null);
        if (r32 == null) goto L424;
        if (r24.d("x-tt-token-supplement", r32, "append-backup") == false) goto L424;
        r24.a.put("x-tt-token-supplement", r32);
        goto L424
    L425:
        r25 = r41;
        r25.putAll(r24.a);
        goto L410
    L93:
        if (TextUtils.isEmpty(r12) == true) goto L406;
        long r210 = System.currentTimeMillis();
        if ("/passport/account/info/v2/".equalsIgnoreCase(r12) == false) goto L98;
    L101:
        boolean r33 = true;
    L102:
        f.a();
        if (f.i == true) goto L106;
        if (r33 == false) goto L406;
        TTTokenMonitor.e(r15, r12, "experiment disable");
        goto L406
    L106:
        Map r34 = r19.a;
        k.b r35 = k.a;
        r19.e = true;
        StringBuilder r36 = new StringBuilder();
        f.a();
        if (f.z == false) goto L111;
        f.a();
        if (f.Q.c.contains(r12) == false) goto L111;
        e0 r38 = new e0();
        a.d("TokenFactory", "addTicketGuardHeader, tracking started for path: " + r12 + " uuid: " + r38.g);
        e0 r39 = r38;
    L112:
        if (r22 == false) goto L129;
        a.a("TokenGuardSettingManage", "isPathGetToken: domain=" + r15 + ", path=" + r12);
        f.a();
        if (f.E.c.contains(r15) == false) goto L117;
        a.a("TokenGuardSettingManage", "isPathGetToken: exclude domain");
    L125:
        boolean r40 = false;
    L127:
        if (r40 == false) goto L129;
        r20.append("x-tt-token,");
        r36.append("x-tt-token,");
        boolean r42 = true;
    L132:
        HashMap r110 = (HashMap) r34;
        if (r110.containsKey("X-Tt-Token") == false) goto L140;
        long r111 = System.currentTimeMillis();
        int r43 = f.b(r12);
        if (r43 != 0) goto L139;
        TokenGuardTemporarySettings.c.getClass();
        if (TokenGuardTemporarySettings.e(r12) == false) goto L139;
        a.d("TokenFactory", "addTicketGuardHeader, path in temporary settings, path: " + r12);
        r43 = 3;
    L139:
        int r44 = r43;
        long r211 = System.currentTimeMillis() - r111;
    L143:
        if (r44 != 0) goto L147;
        if (r22 == false) goto L147;
        a.d("TokenFactory", "addTicketGuardHeader, token guard type is none for passport request, path: " + r12);
    L147:
        com.bytedance.sdk.account.ticketguard.d.a();
        if (com.bytedance.sdk.account.ticketguard.d.b == false) goto L179;
        if (r22 == false) goto L175;
        r20.append("sec_user_id,");
        ta7.f r45 = (ta7.f) this.o.a();
        if (r45 != null) goto L153;
    L171:
        r20 = r20;
    L172:
        boolean r46 = true;
    L173:
        if (r46 == false) goto L176;
        r36.append("sec_user_id,");
    L176:
        com.bytedance.sdk.account.ticketguard.d.a();
        if (com.bytedance.sdk.account.ticketguard.d.c.c.contains(r12) == false) goto L180;
        boolean r47 = r46;
        boolean r48 = true;
    L181:
        f.a();
        boolean r112 = f.R;
        if (r112 == false) goto L186;
        f.a();
        HashMap r212 = r11;
        if (f.d(r12, f.W, f.X, f.Y, f.Z) == false) goto L187;
        boolean r49 = true;
    L189:
        if (r36.length() <= 0) goto L191;
        r36.deleteCharAt(r36.length() - 1);
        r110.put("passport-sdk-sign", r36.toString());
    L191:
        f.a();
        if (f.u == false) goto L198;
        f.a();
        boolean r50 = f.d(r12, f.b, f.c, f.d, f.e);
        String r51 = r10.c;
        if (r50 == false) goto L197;
        a.d("TokenFactory", "enableAttestSign, path=" + r12 + ", needAttestSign=" + r50 + ", path: " + r12 + ", attestTsSign: " + l(r51));
    L197:
        String r213 = r51;
        boolean r53 = r50;
    L199:
        f.a();
        if (f.b0 == true) goto L202;
        boolean r113 = false;
    L203:
        if (r22 == false) goto L205;
        a.d("TokenFactory", "enableTeeStaticSign status: " + r113 + ", path=" + r12);
    L205:
        if (r42 == true) goto L213;
        if (r47 == true) goto L213;
        if (r44 != 0) goto L213;
        if (r48 == true) goto L213;
        if (r53 == true) goto L213;
        if (r113 == true) goto L213;
        boolean r58 = false;
    L214:
        if (r58 == true) goto L217;
        r21 = r19;
        r37 = r20;
        r41 = r212;
        r52 = r10;
        goto L216
    L217:
        AccountTicketGuardManager.j.getClass();
        if (AccountTicketGuardManager.b.compareAndSet(false, true) == true) goto L471;
        boolean r214 = r113;
    L230:
        if (AccountTicketGuardManager.d == true) goto L249;
        f.a();
        if (f.l == false) goto L249;
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        a.a("AccountTicketGuardManag", String.format("%s start waiting for ticketInitLock", Arrays.copyOf(new Object[]{r12}, 1)));
        Object r59 = AccountTicketGuardManager.f;
        monitor-enter(r59);
    L244:
        th = move-exception;
        throw th;
    L236:
        if (AccountTicketGuardManager.d == false) goto L467;
    L241:
        Unit r60 = Unit.INSTANCE;     // Catch: Throwable -> L244
        monitor-exit(r59);
        StringCompanionObject r61 = StringCompanionObject.INSTANCE;
        a.a("AccountTicketGuardManag", String.format("%s request continue, isTicketInited=%s", Arrays.copyOf(new Object[]{r12, Boolean.valueOf(AccountTicketGuardManager.d)}, 2)));
        goto L249
    L467:
        f.a();     // Catch: InterruptedException -> L239 Throwable -> L244
        r59.wait(f.n);     // Catch: InterruptedException -> L239 Throwable -> L244
    L239:
        e = move-exception;
        a.a("AccountTicketGuardManag", "ticketInitLock wait failed, e=" + Log.getStackTraceString(e));     // Catch: Throwable -> L244
    L249:
        if (AccountTicketGuardManager.d == true) goto L251;
        a.e("AccountTicketGuardManag", "Wait for ticket init failed, path = " + r12);
    L251:
        if (r42 == true) goto L255;
        if (r47 == true) goto L255;
        a0 r62 = null;
    L271:
        Map r63 = RealTimeManager.j;
        com.bytedance.sdk.account.time.b r64 = RealTimeManager.a.a().b(this.i, true);
        long r115 = r64.a;
        if (r39 == null) goto L274;
        e0.g r65 = new e0.g();
        r65.a = r115;
        r65.c = r64.b;
        r65.b = r64.c;
        r65.d = r64.d;
        r65.e = MapsKt.mapOf((Pair[]) Arrays.copyOf(r64.e.b(), 6));
        r39.f = r65;
    L274:
        if (r22 == false) goto L278;
        a.d("TokenFactory", "Get timestamp for passport request, getTimeResult: " + r64 + " path: " + r12 + " System time: " + System.currentTimeMillis());
    L278:
        if (r44 != 3) goto L280;
    L283:
        boolean r310 = true;
    L285:
        if (r44 == 3) goto L289;
        if (r44 == 2) goto L289;
        boolean r215 = false;
    L290:
        if (r48 == true) goto L292;
        String r510 = r12;
        HashMap r410 = r110;
        String r511 = r15;
        r21 = r19;
        r37 = r20;
        r41 = r212;
        e0 r411 = r10;
        boolean r116 = r214;
        char r216 = 2;
        char r311 = 0;
        char r312 = 3;
        if (r44 != 0) goto L343;
        if (r53 != 0) goto L343;
        if (r116 == true) goto L343;
        r52 = r411;
        i r117 = null;
    L351:
        if (r117 == null) goto L378;
        j1 r66 = w0.a;
        j1 r67 = w0.a;
        if (r67 != null) goto L355;
        a.e("TokenFactory", "getUseTicketGuardParams, ticket guard service is null");
        com.bytedance.android.sdk.bdticketguard.g r68 = null;
    L356:
        d(r410, r117, r68);
        if ("x-tt-token".equals(r117.f) == false) goto L376;
        long r69 = System.currentTimeMillis() - r210;
        HashSet r70 = TTTokenMonitor.b;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.n == false) goto L376;
        StringBuilder r71 = new StringBuilder();
        if (r310 == false) goto L364;
        r71.append("tee");
    L364:
        if (r215 == true) goto L366;
    L369:
        JSONObject r72 = new JSONObject();
        r72.put("settings_duration", r211);     // Catch: Exception -> L374
        r72.put("total_duration", r69);     // Catch: Exception -> L374
        r72.put("host", r511);     // Catch: Exception -> L374
        String r73 = r510;
        r72.put("path", r73);     // Catch: Exception -> L462
        r72.put("sign_type", r71.toString());     // Catch: Exception -> L462
        r72.put("trigger_type", "inner");     // Catch: Exception -> L462
    L375:
        com.bytedance.sdk.account.monitor.c.d("x_tt_token_guard", r72.toString());
    L377:
        com.bytedance.android.sdk.bdticketguard.g r118 = r68;
    L379:
        r21.b = r62;
        r21.c = r118;
        if (r39 == null) goto L216;
        f.a();
        r23 = 1;
        r23 = 1;
        r23 = 1;
        boolean r74 = !f.x;
        KProperty[] r75 = TicketGuardEventHelper.a;
        TicketGuardManager r76 = c1.a;
        TicketGuardManager r77 = c1.a;
        if (r77 == null) goto L384;
        Boolean r78 = Boolean.valueOf(r77.a());
    L385:
        Pair r79 = r39.a();
        boolean r80 = ((Boolean) r79.component1()).booleanValue();
        String r81 = (String) r79.component2();
        if (r74 == true) goto L388;
    L391:
        int r82 = r0.a;
        r0.f("TicketGuardEventHelper", "monitorTrackingPath, Anomaly detected during request, path: " + r73 + ", uuid: " + r39.g + ", request, anomalyMsg: " + r81);
        Pair[] r83 = new Pair[5];     // Catch: JSONException -> L404
        r83[r311] = TuplesKt.to("path", r73);     // Catch: JSONException -> L404
        if (r78 == null) goto L395;
        TicketGuardEventHelper r84 = TicketGuardEventHelper.g;     // Catch: JSONException -> L404
        boolean r85 = r78.booleanValue();     // Catch: JSONException -> L404
        r84.getClass();     // Catch: JSONException -> L404
        ?? r86 = r85;
    L396:
        r83[1] = TuplesKt.to("is_main_process", Integer.valueOf(r86));     // Catch: JSONException -> L404
        if (r118 == null) goto L401;
        String r87 = r118.e;     // Catch: JSONException -> L404
        if (r87 == null) goto L401;
    L402:
        r83[r216] = TuplesKt.to("local_error", r87);     // Catch: JSONException -> L404
        r83[r312] = TuplesKt.to("anomalies", r81);     // Catch: JSONException -> L404
        r83[4] = TuplesKt.to("display_os_version", Build.DISPLAY);     // Catch: JSONException -> L404
        JSONObject r88 = z0.a(r83);     // Catch: JSONException -> L404
        f0.a(r88, r39);     // Catch: JSONException -> L404
        TicketGuardEventHelper.B("bd_ticket_guard_request_track", r88);     // Catch: JSONException -> L404
    L401:
        r87 = XmlPullParser.NO_NAMESPACE;
        goto L402
    L395:
        r86 = -1;
    L404:
        e = move-exception;
        r0.d(6, "TicketGuardEventHelper", "monitorTrackingPathRequest error", e);
        goto L407
    L388:
        if (Intrinsics.areEqual(r78, Boolean.FALSE) == true) goto L390;
        if (r80 == true) goto L391;
    L390:
        int r89 = r0.a;
        r0.c("TicketGuardEventHelper", "monitorTrackingPath, path: " + r73 + ", uuid: " + r39.g + ", request, nothing went wrong, no need to report, isMainProcess: " + r78);
        goto L407
    L384:
        r78 = null;
    L374:
        r73 = r510;
        goto L375
    L366:
        if (r71.length() <= 0) goto L368;
        r71.append(",");
    L368:
        r71.append("ree");
    L376:
        r73 = r510;
        goto L377
    L355:
        r68 = r67.h(r117);
        goto L356
    L378:
        r73 = r510;
        r118 = null;
    L343:
        com.bytedance.sdk.account.utils.j r90 = r411.d;
        if (r90 == null) goto L346;
        TicketTrackData r119 = (TicketTrackData) r90.getData();
    L347:
        if (r119 == null) goto L349;
        e0.f r217 = new e0.f(r119.c, r119.d, r119.a, r119.b, r119.e, r119.f, r119.g);
    L350:
        r52 = r411;
        r117 = new com.bytedance.android.sdk.bdticketguard.j(r411.b, r411.a, r511, r510, "x-tt-token", false, false, r310, r215, r115, r49, r53, r213, r116, r39, r217);
        goto L351
    L349:
        r217 = null;
        goto L350
    L346:
        r119 = null;
        goto L347
    L292:
        if (TextUtils.isEmpty(r55) == false) goto L295;
        ArrayList r91 = null;
    L307:
        if (r91 != null) goto L309;
    L318:
        String r92 = XmlPullParser.NO_NAMESPACE;
    L319:
        if (r92 != null) goto L321;
        r92 = XmlPullParser.NO_NAMESPACE;
    L321:
        String r93 = r92;
        if (TextUtils.isEmpty(r93) == false) goto L325;
        String r94 = null;
    L334:
        if (r94 != null) goto L336;
        r94 = XmlPullParser.NO_NAMESPACE;
    L336:
        r312 = 3;
        r37 = r20;
        r21 = r19;
        r41 = r212;
        boolean r120 = r214;
        r216 = 2;
        r510 = r12;
        r410 = r110;
        r311 = 0;
        r511 = r15;
        r117 = new com.bytedance.android.sdk.bdticketguard.j(r94, r93, r15, r12, "sec_user_id", false, true, true, r115, r49, r53, r213, r120);
        r52 = r10;
        goto L351
    L325:
        if (h.a != null) goto L330;
        Context r95 = k.c();
        if (r95 == null) goto L330;
        h.a = r95.getSharedPreferences("account_sdk_ts_sign_cache", 0);
    L330:
        SharedPreferences r96 = h.a;
        if (r96 == null) goto L333;
        r94 = r96.getString(r93, XmlPullParser.NO_NAMESPACE);
        goto L334
    L333:
        r94 = null;
        goto L334
    L309:
        if (r91.isEmpty() == true) goto L318;
        Iterator r97 = r91.iterator();
    L312:
        if (r97.hasNext() == false) goto L318;
        android.util.Pair r98 = (android.util.Pair) r97.next();
        if ("sec_user_id".equalsIgnoreCase((String) r98.first) == true) goto L317;
        if ("last_sec_user_id".equalsIgnoreCase((String) r98.first) == false) goto L312;
    L317:
        r92 = (String) r98.second;
        goto L319
    L295:
        r91 = new ArrayList();
        String[] r99 = r55.split("&");     // Catch: Throwable -> L304
        int r100 = r99.length;     // Catch: Throwable -> L304
        int r101 = 0;
    L297:
        if (r101 >= r100) goto L307;
        String[] r102 = r99[r101].split("=");     // Catch: Throwable -> L304
        String[] r512 = r99;
        r91.add(new android.util.Pair(URLDecoder.decode(r102[0], "UTF-8"), URLDecoder.decode(r102[1], "UTF-8")));     // Catch: Throwable -> L302
        r101 = r101 + 1;
        r99 = r512;
    L302:
        th = th;
    L306:
        th.printStackTrace();
    L304:
        th = th;
    L289:
        r215 = true;
        goto L290
    L280:
        if (r44 == 1) goto L283;
        r310 = false;
    L255:
        if (r47 == false) goto L257;
        String r103 = "sec_user_id";
    L258:
        j1 r104 = w0.a;
        j1 r105 = w0.a;
        if (r105 != null) goto L261;
        a.e("TokenFactory", "getObtainTicketGuardParams, ticket guard service is null, ticketName: ".concat(r103));
        a0 r121 = null;
    L262:
        if (r121 == null) goto L267;
        Map r106 = o.a(((d0) r121).b);
        if (r106 == null) goto L267;
        r110.putAll(r106);
    L267:
        if (r121 != null) goto L270;
        if (r33 == false) goto L270;
        TTTokenMonitor.e(r15, r12, "service null");
    L270:
        r62 = r121;
        goto L271
    L261:
        r121 = r105.l(new b0(r15, r12, r112, r39));
        goto L262
    L257:
        r103 = "x-tt-token";
        goto L258
    L471:
        r214 = r113;
        AccountTicketGuardManager.a().getDeclaredMethod("initTicketInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L223
    L223:
        e = e;
    L227:
        a.b("AccountTicketGuardManag", "tryInitTicketInstance: fail for exception:" + Log.getStackTraceString(e));
    L225:
        e = e;
        r214 = r113;
    L213:
        r58 = true;
        goto L214
    L202:
        k.b r107 = k.a;
        r113 = f.d(r12, f.e0, f.f0, f.g0, f.h0);
        goto L203
    L198:
        r10 = r10;
        r213 = XmlPullParser.NO_NAMESPACE;
        r53 = false;
    L187:
        r49 = false;
        goto L189
    L186:
        r212 = r11;
    L180:
        r47 = r46;
        r48 = false;
        goto L181
    L153:
        if (r45.isLogin() == false) goto L171;
        String r108 = r45.getSecUserId();
        if (TextUtils.isEmpty(r108) == false) goto L159;
        r20 = r20;
    L157:
        String r109 = null;
    L168:
        if (TextUtils.isEmpty(r109) == true) goto L172;
        if (r33 == false) goto L172;
        r46 = false;
        goto L173
    L159:
        if (h.a != null) goto L164;
        Context r122 = k.c();
        if (r122 == null) goto L164;
        h.a = r122.getSharedPreferences("account_sdk_ts_sign_cache", 0);
    L164:
        SharedPreferences r123 = h.a;
        if (r123 == null) goto L157;
        r109 = r123.getString(r108, XmlPullParser.NO_NAMESPACE);
        goto L168
    L175:
        r20 = r20;
        r46 = false;
        goto L176
    L179:
        r20 = r20;
        r46 = false;
        goto L180
    L140:
        if (r22 == false) goto L142;
        a.d("TokenFactory", "addTicketGuardHeader, token header does not exist for passport request, path: " + r12);
    L142:
        r211 = 0;
        r44 = 0;
        goto L143
    L117:
        if (f.F.c.contains(r12) == false) goto L119;
        a.a("TokenGuardSettingManage", "isPathGetToken: exclude paths");
        goto L125
    L119:
        Iterator r124 = f.G.c.iterator();
    L121:
        if (r124.hasNext() == false) goto L126;
        if (r12.startsWith((String) r124.next()) == false) goto L121;
        a.a("TokenGuardSettingManage", "isPathGetToken: exclude prefix");
        goto L125
    L126:
        r40 = true;
    L129:
        if (r33 == false) goto L131;
        TTTokenMonitor.e(r15, r12, "not match rules, rules=".concat(String.valueOf(f.a)));
    L131:
        r42 = false;
    L111:
        r39 = null;
        goto L112
    L98:
        if ("/passport/token/beat/v2/".equalsIgnoreCase(r12) == true) goto L101;
        r33 = false;
        goto L102
    L64:
        AuthTokenMultiProcessSharedProvider.b r125 = r.a;
        if (r125 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L67:
        r14 = r125.f("mfa_token");
        goto L69
    L60:
        a.d("TokenFactory", "addRequestHeader, token is empty. path: " + r12 + " url: " + r54);
        goto L61
    L49:
        if (r54.contains("is_from_ttaccountsdk=1") == true) goto L55;
        HashSet r126 = TTTokenMonitor.b;
        JSONObject r127 = new JSONObject();     // Catch: JSONException -> L53
        r127.put("path", r12);     // Catch: JSONException -> L53
        TTTokenMonitor.r("passport_request_not_use_account_sdk", r127);     // Catch: JSONException -> L53
    L53:
        e = move-exception;
        a.c("AccountSDK", "monitorUserMixed error", e);
        goto L55
    L44:
        if (r12.startsWith("/passport/") == false) goto L46;
        r22 = true;
    L36:
        r3 = null;
    L26:
        r8 = false;
        goto L27
    }

    public final void w(String r3, List r4, boolean r5, Object r6) {
        TTTokenMonitor.j(r3, r4, r5);
        if (F == true) goto L6;
        return;
    L6:
        if (this.o.a() != null) goto L8;
        return;
    L8:
        if (((ta7.f) this.o.a()).isLogin() == false) goto L15;
        this.d.getClass();
        String r7 = r.d();
        g();
        TTTokenMonitor.b("session_expired", r7);
        if (this.o.a() == null) goto L12;
        Long r8 = Long.valueOf(((ta7.f) this.o.a()).getUserId());
        ((ta7.f) this.o.a()).a(true);
        TTTokenMonitor.o(r8, 0L, TTTokenMonitor.a(r3), "session_expired");
    L12:
        g.a().c("sdk_expired_logout", r6, null, null);
        return;
    }

    public final void x(String r7, String r8, String r9, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return;
    L6:
        if (F == true) goto L9;
        return;
    L9:
        if (p.b == true) goto L12;
        return;
    L12:
        if (AccountDeviceTransferManager.f() == true) goto L15;
        return;
    L15:
        if (((ta7.f) this.o.a()).isLogin() == true) goto L18;
        return;
    L18:
        if (this.n == false) goto L20;
        return;
    L20:
        this.n = true;
        String r4 = new String(Base64.decode(r10, 2), Charsets.UTF_8);     // Catch: Throwable -> L26
        i0 r11 = i0.a(r4);     // Catch: Throwable -> L24
    L29:
        if (r11 != null) goto L31;
        return;
    L31:
        a.d("TokenFactory", "processDeviceTransfer, path:" + r8 + ", logId:" + r9 + ", decision:" + r4);
        HashSet r0 = TTTokenMonitor.b;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L34
        r1.put("path", r8);     // Catch: JSONException -> L34
        r1.put("logid", r9);     // Catch: JSONException -> L34
        com.bytedance.sdk.account.monitor.a.a("passport_device_transfer", r1);     // Catch: JSONException -> L34
    L36:
        this.d.getClass();
        String r12 = r.d();
        g();
        TTTokenMonitor.b("device_transfer", r12);
        ta7.f r13 = (ta7.f) this.o.a();
        Long r2 = Long.valueOf(r13.getUserId());
        r13.a(false);
        TTTokenMonitor.o(r2, 0L, TTTokenMonitor.a(r7), "device_transfer");
        r13.g();
        r13.f();
        ta7.b r14 = new ta7.b(2);
        r14.c = r11;
        HashMap r3 = new HashMap();
        r3.put("logout_type", "device_transfer");
        r3.put("scene", "device_transfer");
        r14.e = r3;
        r13.e(r14);
        d r15 = new d("device_transfer");
        r15.a = r11;
        g.a().c("device_transfer", null, r15, null);
        return;
    L34:
        e = move-exception;
        a.c("AccountSDK", "monitorDeviceTransfer error", e);
    L24:
        Throwable th = th;
    L28:
        a.d("TokenFactory", "processDeviceTransfer(), decision base64 decode fail; " + th.getMessage());
        r11 = null;
    L26:
        th = move-exception;
        r4 = r10;
        th = th;
        goto L28
    }

    public final void q(String r17, long r18, long r20, String r22, String r23) {
        SimpleDateFormat r2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        r2.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date r3 = r2.parse(r17);     // Catch: ParseException -> L12
        if (r3 == null) goto L8;
        long r13 = r3.getTime();     // Catch: ParseException -> L12
        Map r1 = RealTimeManager.j;     // Catch: ParseException -> L12
        RealTimeManager.a.a().a(this.i, r13, r18, r20);     // Catch: ParseException -> L10
        a.d("TokenFactory", "拦截请求返回时间戳完成，下发值 " + r17 + "，解析转换后 " + r13 + "，当前时间戳 " + r18 + "，时间差 " + (r13 - r18) + "，path " + r22 + "，logid " + r23);     // Catch: ParseException -> L10
    L16:
        return;
    L8:
        a.a("TokenFactory", "拦截请求返回时间戳异常，date 解析为空，date=" + r17);     // Catch: ParseException -> L10
    L10:
        e = e;
    L14:
        a.c("TokenFactory", "拦截请求返回时间戳异常", e);
        return;
    L12:
        e = e;
        goto L14
    }

    public final void y(String r46, f r47, List<o> r48, List<o> r49, String r50) {
        if (TextUtils.isEmpty(r46) == false) goto L5;
        return;
    L5:
        String r3 = i(r46);
        if (r48 == null) goto L23;
        Iterator<o> r0 = r48.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        o r6 = r0.next();
        if ("X-Tt-Token".equalsIgnoreCase(r6.a) == false) goto L9;
        boolean r1 = !TextUtils.isEmpty(r6.b);
    L14:
        String r7 = p(r46);
        HashSet r9 = TTTokenMonitor.b;
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L21
        r10.put("host", r3);     // Catch: Throwable -> L21
        r10.put("path", r7);     // Catch: Throwable -> L21
        if (r1 == false) goto L18;
        int r2 = 1;
    L19:
        r10.put("xtoken", r2);     // Catch: Throwable -> L21
        TTTokenMonitor.r("passport_http_with_xtoken", r10);     // Catch: Throwable -> L21
    L25:
        if (F == true) goto L28;
        return;
    L28:
        if (s(r46, r3) == true) goto L30;
        return;
    L30:
        if (r7 != null) goto L33;
        r7 = p(r46);
    L33:
        if (TextUtils.isEmpty(r3) == false) goto L35;
        return;
    L35:
        if (TextUtils.isEmpty(r7) == true) goto L589;
        t(true, "processResponseHeader");
        boolean r16 = r7.startsWith("/passport/");
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.Z == false) goto L40;
        AuthTokenMultiProcessSharedProvider.a r15 = m().b();
    L41:
        ArrayList r4 = new ArrayList();
        HashMap r14 = new HashMap();
        String r11 = XmlPullParser.NO_NAMESPACE;
        String r12 = XmlPullParser.NO_NAMESPACE;
        String r13 = XmlPullParser.NO_NAMESPACE;
        String r17 = XmlPullParser.NO_NAMESPACE;
        String r18 = XmlPullParser.NO_NAMESPACE;
        HashSet r5 = new HashSet();
        String r19 = XmlPullParser.NO_NAMESPACE;
        if (r49 == null) goto L183;
        ArrayList r110 = (ArrayList) r49;
        if (r110.isEmpty() == true) goto L183;
        Iterator r111 = r110.iterator();
        boolean r20 = false;
        String r21 = null;
    L47:
        if (r111.hasNext() == false) goto L109;
        o r8 = (o) r111.next();
        String r22 = r8.a;
        String r23 = r11;
        String r24 = r8.b;
        if (TextUtils.isEmpty(r22) == true) goto L101;
        String r25 = r22.toLowerCase();
        String r26 = r12;
        r4.add(new android.util.Pair(r25, r24));
        r14.put(r25, r24);
        r25.getClass();
        switch(r25.hashCode()) {
            case -1976085669: goto L83;
            case -1846329444: goto L79;
            case -1274280861: goto L75;
            case -1177502390: goto L71;
            case -272647289: goto L67;
            case -265255391: goto L63;
            case 1630751484: goto L59;
            case 1972804273: goto L55;
            default: goto L86;
        };
    L86:
        byte r28 = -1;
    L87:
        switch(r28) {
            case 0: goto L105;
            case 1: goto L104;
            case 2: goto L103;
            case 3: goto L102;
            case 4: goto L100;
            case 5: goto L99;
            case 6: goto L91;
            case 7: goto L89;
            default: goto L106;
        };
    L89:
        r17 = r8.b;
        goto L106
    L99:
        r11 = r8.b;
    L107:
        r12 = r26;
        goto L47
    L100:
        r12 = r8.b;
        goto L101
    L102:
        r19 = r8.b;
        goto L106
    L103:
        r18 = r8.b;
        goto L106
    L104:
        r21 = r8.b;
        goto L106
    L105:
        r13 = r8.b;
    L106:
        r11 = r23;
        goto L107
    L91:
        if (TextUtils.isEmpty(r24) == true) goto L98;
        String[] r29 = r24.split(",");
        int r30 = r29.length;
        int r31 = 0;
    L93:
        if (r31 >= r30) goto L98;
        String r112 = r29[r31];
        if (TextUtils.isEmpty(r112) == true) goto L97;
        r5.add(r112.trim());
    L97:
        r31 = r31 + 1;
    L98:
        r5.add(r7);
        r11 = r23;
        r12 = r26;
        r20 = true;
        goto L47
    L55:
        if (r25.equals("x-tt-passport-mfa-token") == false) goto L86;
        r28 = 7;
        goto L87
    L59:
        if (r25.equals("bd-ticket-guard-need-sign-path") == false) goto L86;
        r28 = 6;
        goto L87
    L63:
        if (r25.equals("x-tt-token") == false) goto L86;
        r28 = 5;
        goto L87
    L67:
        if (r25.equals("x-tt-logid") == false) goto L86;
        r28 = 4;
        goto L87
    L71:
        if (r25.equals("x-tt-passport-device-transfer-decision") == false) goto L86;
        r28 = 3;
        goto L87
    L75:
        if (r25.equals("token-tlb-tag") == false) goto L86;
        r28 = 2;
        goto L87
    L79:
        if (r25.equals("d-ticket-sec-uid") == false) goto L86;
        r28 = 1;
        goto L87
    L83:
        if (r25.equals("bd-ticket-guard-result") == false) goto L86;
        r28 = 0;
    L101:
        r11 = r23;
        goto L47
    L109:
        String r210 = r11;
        String r211 = r12;
        PassportExtraHeaderManager r32 = this.v;
        r32.getClass();
        com.bytedance.sdk.account.settings.common.b.a();
        if (com.bytedance.sdk.account.settings.common.b.b == true) goto L113;
    L181:
        r13 = r13;
        r17 = r17;
        String r212 = r18;
        HashMap r33 = r14;
        AuthTokenMultiProcessSharedProvider.a r213 = r15;
    L182:
        String r113 = r19;
        String r114 = r21;
        String r34 = r210;
        String r35 = r211;
        String r36 = r13;
        String r115 = r17;
        String r214 = r212;
    L184:
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.t == false) goto L187;
    L228:
        String r215 = r114;
        String r37 = r113;
        String r216 = r115;
        AuthTokenMultiProcessSharedProvider.a r38 = r213;
        HashMap r39 = r33;
    L230:
        if (TextUtils.isEmpty(r36) == false) goto L232;
    L234:
        boolean r40 = false;
    L236:
        if ("/passport/token/beat/v2/".equals(r7) == false) goto L238;
    L241:
        boolean r116 = true;
    L242:
        f.a();
        if (f.m == false) goto L263;
        if (r40 == false) goto L263;
        if (r20 == false) goto L263;
        TokenGuardTemporarySettings.c.getClass();
        boolean r117 = TokenGuardTemporarySettings.e(r7);
        if (r117 == false) goto L249;
    L252:
        boolean r118 = true;
    L253:
        a.e("TokenFactory", "TokenGuardTemporarySettings Token verify fail and require sign, remote error: " + r36 + " path: " + r7 + ", requireSignPaths: " + r5 + " isInTemporarySettings: " + r117 + " isPathInSettings: " + r118);
        if (r47 != null) goto L256;
    L258:
        boolean r119 = false;
    L259:
        if (r118 == true) goto L261;
        TokenGuardTemporarySettings.b(r5);
        TokenGuardTemporarySettings.f(r7, r36, r35, r119);
    L261:
        if (r117 == false) goto L263;
        a.b("TokenFactory", "TokenGuardTemporarySettings path in temp config but still failed!!  remote error: " + r36 + " path: " + r7 + ", requireSignPaths: " + r5);
        TokenGuardTemporarySettings.g(r7, r36, r35, r119);
        goto L263
    L256:
        if (r47.c == null) goto L258;
        r119 = true;
        goto L259
    L249:
        if (f.b(r7) != 0) goto L252;
        r118 = false;
    L263:
        String r41 = XmlPullParser.NO_NAMESPACE;
        String r120 = XmlPullParser.NO_NAMESPACE;
        f.a();
        boolean r121 = f.u;
        String r122 = XmlPullParser.NO_NAMESPACE;
        String r123 = XmlPullParser.NO_NAMESPACE;
        if (TextUtils.isEmpty(r7) == true) goto L332;
        f.a();
        if (f.i == false) goto L332;
        if (r47 == null) goto L274;
        com.bytedance.android.sdk.bdticketguard.g r124 = r47.c;
        if (r124 == null) goto L274;
        e0 r125 = ((d0) r124).c;
        if (r125 == null) goto L275;
        a.d("TokenFactory", "addTicketGuardHeader, tracking for path received response: " + r7 + " uuid: " + r125.g);
    L275:
        j1 r42 = w0.a;
        j1 r43 = w0.a;
        if (r43 == null) goto L331;
        if (r47 == null) goto L279;
        a0 r126 = r47.b;
        com.bytedance.android.sdk.bdticketguard.g r127 = r47.c;
    L280:
        if (r127 == null) goto L282;
        com.bytedance.android.sdk.bdticketguard.h r128 = r127.j;
        String r44 = r128.a;
        r123 = r128.b;
        r122 = r44;
    L282:
        if (r126 != null) goto L284;
    L289:
        if (r40 == true) goto L295;
        if (r16 == true) goto L295;
        if (r126 != null) goto L295;
        if (r127 != null) goto L295;
    L304:
        if (r16 == false) goto L322;
        if (r126 == null) goto L322;
        c0 r45 = r43.b(new com.bytedance.android.sdk.bdticketguard.p(r126, r4));
        List r129 = r45.e;
        if (TextUtils.isEmpty(r45.f) == true) goto L309;
        r120 = r45.f;
    L309:
        if (r129 == null) goto L322;
        if (r129.isEmpty() == true) goto L322;
        Iterator r51 = r129.iterator();
    L314:
        if (r51.hasNext() == false) goto L322;
        u0 r130 = (u0) r51.next();
        Iterator r217 = r51;
        a.a("TokenFactory", "save ts_sign: " + v(r130.b()));
        if (TextUtils.isEmpty(r34) == false) goto L318;
    L320:
        h.a(r130.a(), r130.b());
    L321:
        r51 = r217;
        goto L314
    L318:
        if (r34.equals(r130.a()) == false) goto L320;
        r41 = r130.b();
    L322:
        String r131 = r120;
        if (r127 == null) goto L327;
        if (r121 == false) goto L326;
        SecTimeUpdater r52 = SecTimeUpdater.k;
        Context r53 = this.i;
        r52.getClass();
        SecTimeUpdater.b(r53, "after_request", false);
    L326:
        com.bytedance.android.sdk.bdticketguard.k r54 = r43.g(new com.bytedance.android.sdk.bdticketguard.o(r127, r4));
    L330:
        com.bytedance.android.sdk.bdticketguard.k r132 = r54;
        r120 = r131;
        String r55 = r41;
        String r56 = r122;
        String r57 = r123;
        e0 r133 = r125;
    L334:
        if (r133 == null) goto L336;
        String r134 = v(r55);
        f.a();
        TicketGuardEventHelper.z(r7, r133, r132, r134, r120, !f.y);
    L336:
        this.d.getClass();
        e0 r135 = r.e();
        int r136 = r135.h;
        if (TextUtils.isEmpty(r7) == false) goto L340;
        String r218 = r56;
        String r219 = r57;
        int r58 = r136;
        e0 r410 = r135;
    L395:
        if (TextUtils.isEmpty(r34) == true) goto L461;
        if (m() == null) goto L461;
        JSONObject r59 = com.bytedance.sdk.account.settings.common.d.a;
        JSONObject r60 = com.bytedance.sdk.account.settings.common.a.b();
        if (r60 == null) goto L401;
        JSONObject r61 = r60.optJSONObject("xtoken_safe_save_config");
    L403:
        if (com.bytedance.sdk.account.settings.common.d.a == r61) goto L405;
        boolean r62 = true;
    L406:
        if (r62 == false) goto L413;
        com.bytedance.sdk.account.settings.common.d.a = r61;
        a.a("TokenSaveManager", "settings=" + com.bytedance.sdk.account.settings.common.d.a);
        JSONObject r63 = com.bytedance.sdk.account.settings.common.d.a;
        if (r63 == null) goto L410;
        com.bytedance.sdk.account.settings.common.d.b = r63.optBoolean("enable", true);
        com.bytedance.sdk.account.settings.common.d.c.c(com.bytedance.sdk.account.settings.common.d.a.optJSONArray("exclude_domain_suffix"));
        com.bytedance.sdk.account.settings.common.d.d.c(com.bytedance.sdk.account.settings.common.d.a.optJSONArray("path_prefix"));
        com.bytedance.sdk.account.settings.common.d.e.c(com.bytedance.sdk.account.settings.common.d.a.optJSONArray("exclude_path_prefix"));
    L411:
        a.a("TokenSaveManager", "excludeDomainSuffix=" + com.bytedance.sdk.account.settings.common.d.c);
        a.a("TokenSaveManager", "pathPrefix=" + com.bytedance.sdk.account.settings.common.d.d);
        a.a("TokenSaveManager", "excludePathPrefix=" + com.bytedance.sdk.account.settings.common.d.e);
        goto L413
    L410:
        com.bytedance.sdk.account.settings.common.d.b = true;
        com.bytedance.sdk.account.settings.common.d.c.c(null);
        com.bytedance.sdk.account.settings.common.d.d.c(null);
        com.bytedance.sdk.account.settings.common.d.e.c(null);
    L413:
        if (com.bytedance.sdk.account.settings.common.d.b == true) goto L416;
    L437:
        boolean r137 = true;
    L439:
        if (r137 == false) goto L459;
        a.d("TokenFactory", "TokenFactory.processResponseHeader: update x-tt-token by host: " + r3 + " , path: " + r7);
        this.d.getClass();
        if (TextUtils.equals(r34, r.d()) == true) goto L443;
    L444:
        if (r55 != null) goto L446;
        r55 = XmlPullParser.NO_NAMESPACE;
    L446:
        String r220 = r55;
        if (r120 != null) goto L449;
        String r64 = XmlPullParser.NO_NAMESPACE;
    L450:
        if (r116 == true) goto L452;
    L454:
        r38 = r38;
    L455:
        this.d.getClass();
        String r65 = r.d();
        this.d.getClass();
        r136 = r136;
        r410 = r410;
        TicketTrackData r138 = new TicketTrackData(r7, r35, r218, r219, !TextUtils.equals(r34, r.d()));
        if (TextUtils.isEmpty(r64) == true) goto L458;
        r138 = new TicketTrackData(r138, r7, r35);
    L458:
        e0 r139 = new e0(r34, r220, r64, new TicketTrackData.Unserialized(r138), r214, r58);
        C("response_header", r139, r38);
        TTTokenMonitor.p(r3, r7, r35, r47, r139, r65, r49);
        TTTokenMonitor.l(r34, r35);
        r120 = r64;
        boolean r140 = true;
    L462:
        if (r140 == true) goto L476;
        if (TextUtils.isEmpty(r120) == true) goto L472;
        e0 r66 = r410;
        com.bytedance.sdk.account.utils.j r67 = r66.d;
        if (r67 != null) goto L468;
    L470:
        a.d("TokenFactory", "TokenFactory.processResponseHeader: update attest ts sign only, NOT hasLastTrackData, path: ".concat(r7));
        TicketTrackData r68 = new TicketTrackData(new TicketTrackData(r7, r35, r218, r219, false), r7, r35);
    L471:
        e0 r69 = new e0(r66.a, r66.b, r120, new TicketTrackData.Unserialized(r68), r66.g, r58);
        r69.f = r66.f;
        C("update_attest_ts_sign", r69, r38);
        goto L476
    L468:
        if (r67.getData() == null) goto L470;
        a.d("TokenFactory", "TokenFactory.processResponseHeader: update attest ts sign only, hasLastTrackData, path: ".concat(r7));
        r68 = new TicketTrackData((TicketTrackData) r67.getData(), r7, r35);
        goto L471
    L472:
        e0 r70 = r410;
        if (r136 == r58) goto L476;
        e0 r71 = new e0(r70.a, r70.b, r70.c, r70.d, r70.g, r58);
        r71.f = r70.f;
        r71.e = r70.e;
        C("update_is_login", r71, r38);
    L476:
        if (TextUtils.isEmpty(r120) == true) goto L489;
        a.d("TokenFactory", "processResponseHeader, update attest ts sign: " + l(r120) + " path: " + r7 + " logId: " + r35);
        this.e = false;
        if (r38 != null) goto L480;
        boolean r72 = true;
    L481:
        if (r38 != null) goto L483;
        AuthTokenMultiProcessSharedProvider.a r141 = m().b();
    L484:
        r141.b.put("attest_ts_sign_dirty_flag", Boolean.FALSE);
        if (r72 == false) goto L489;
        r141.a();
        goto L489
    L483:
        r141 = r38;
        goto L484
    L480:
        r72 = false;
    L489:
        if (TextUtils.isEmpty(r216) == true) goto L517;
        this.d.getClass();
        if (r.b == false) goto L493;
        String r73 = r.f;
    L497:
        String r142 = r216;
        if (TextUtils.equals(r142, r73) == true) goto L517;
        this.d.getClass();
        r.f = r142;
        if (r38 != null) goto L502;
        boolean r74 = true;
    L503:
        if (r38 == null) goto L505;
        AuthTokenMultiProcessSharedProvider.a r143 = r38;
    L509:
        r143.c("mfa_token", r.f);
        if (r74 == false) goto L512;
        r143.a();
    L512:
        String r75 = l(r142);
        HashSet r76 = TTTokenMonitor.b;
        JSONObject r77 = new JSONObject();     // Catch: Exception -> L515
        r77.put("host", r3);     // Catch: Exception -> L515
        r77.put("path", r7);     // Catch: Exception -> L515
        r77.put("logid", r35);     // Catch: Exception -> L515
        r77.put("token", r75);     // Catch: Exception -> L515
        TTTokenMonitor.t("passport_mfa_token_update", r77);     // Catch: Exception -> L515
    L515:
        e = move-exception;
        e.printStackTrace();
        goto L517
    L505:
        AuthTokenMultiProcessSharedProvider.b r78 = r.a;
        if (r78 != null) goto L508;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L508:
        r143 = r78.b();
        goto L509
    L502:
        r74 = false;
        goto L503
    L493:
        AuthTokenMultiProcessSharedProvider.b r79 = r.a;
        if (r79 != null) goto L496;
        Intrinsics.throwUninitializedPropertyAccessException("multiProcessShared");
    L496:
        r73 = r79.f("mfa_token");
    L517:
        if (r16 == false) goto L520;
        com.bytedance.sdk.account.settings.common.b.a();
        HashMap r80 = r39;
        TTTokenMonitor.g(r3, r7, r35, r80, com.bytedance.sdk.account.settings.common.b.c.c);
        TTTokenMonitor.f(r46, r3, r7, r35, r47, r80);
    L520:
        if (r38 == 0) goto L522;
        r38.a();
    L522:
        x(r46, r7, r35, r37);
        if (r47 != 0) goto L525;
        return;
    L525:
        if (r47.e == false) goto L527;
        return;
    L527:
        if (f.c(r7) == false) goto L588;
        TicketGuardEventHelper.w(r7);     // Catch: Throwable -> L530
        return;
    L530:
        th = move-exception;
        a.c("TokenFactory", "monitorRequestBeforeFeedReady error", th);
        return;
    L588:
        return;
    L452:
        if (((ta7.f) this.o.a()).isLogin() == false) goto L454;
        r38 = r38;
        z(r38);
        goto L455
    L449:
        r64 = r120;
        goto L450
    L443:
        if (TextUtils.isEmpty(r55) == true) goto L461;
    L459:
        a.d("TokenFactory", "TokenFactory.processResponseHeader: TokenSaveManager forbids token saving from this host and path: " + r3 + " " + r7);
        goto L461
    L416:
        if (TextUtils.isEmpty(r3) == false) goto L418;
    L438:
        r137 = false;
        goto L439
    L418:
        if (TextUtils.isEmpty(r7) == true) goto L438;
        Iterator r81 = com.bytedance.sdk.account.settings.common.d.c.c.iterator();
    L422:
        if (r81.hasNext() == false) goto L426;
        if (r3.endsWith((String) r81.next()) == false) goto L422;
    L426:
        Iterator r82 = com.bytedance.sdk.account.settings.common.d.e.c.iterator();
    L428:
        if (r82.hasNext() == false) goto L432;
        if (r7.startsWith((String) r82.next()) == false) goto L428;
    L432:
        Iterator r83 = com.bytedance.sdk.account.settings.common.d.d.c.iterator();
    L434:
        if (r83.hasNext() == false) goto L438;
        if (r7.startsWith((String) r83.next()) == false) goto L434;
    L405:
        r62 = false;
        goto L406
    L401:
        r61 = null;
    L461:
        r140 = false;
        goto L462
    L340:
        if ("/passport/token/beat/v2/".equals(r7) == false) goto L359;
        if (TextUtils.isEmpty(r215) == true) goto L345;
    L363:
        int r84 = 1;
    L365:
        int r85 = r84;
        String r86 = null;
        int r144 = -1;
        Object r145 = null;
    L366:
        if (r136 == r144) goto L392;
        if (r136 == r85) goto L392;
        if (r7.contains("login") == true) goto L392;
        if (((HashSet) this.y).contains(r7) == true) goto L392;
        boolean r146 = ((ta7.f) this.o.a()).isLogin();
        boolean r147 = !TextUtils.isEmpty(r34);
        r410 = r135;
        int r148 = !TextUtils.isEmpty(r215) ? 1 : 0;
        HashSet r221 = TTTokenMonitor.b;
        r219 = r57;
        JSONObject r87 = new JSONObject();     // Catch: JSONException -> L389
        r218 = r56;
        r87.put("is_login", r136);     // Catch: JSONException -> L387
        r87.put("new_is_login", r85);     // Catch: JSONException -> L387
        r87.put("user_info_is_login", r146 ? 1 : 0);     // Catch: JSONException -> L387
        r87.put("host", r3);     // Catch: JSONException -> L387
        r87.put("path", r7);     // Catch: JSONException -> L387
        r87.put("logid", r35);     // Catch: JSONException -> L387
        if (r147 == false) goto L378;
        int r149 = 1;
    L379:
        r87.put("had_token", r149);     // Catch: JSONException -> L387
        r87.put("had_d_ticket_sec_uid", r148);     // Catch: JSONException -> L387
        if (r145 == null) goto L383;
        r87.put("error_code", r145);     // Catch: JSONException -> L387
    L383:
        if (TextUtils.isEmpty(r86) == true) goto L385;
        r87.put("error_msg", r86);     // Catch: JSONException -> L387
    L385:
        TTTokenMonitor.r("passport_login_status_change", r87);     // Catch: JSONException -> L387
    L393:
        r58 = r85;
        goto L395
    L378:
        r149 = 0;
    L387:
        e = e;
    L391:
        a.c("TTTokenMonitor", "monitorLoginStatusChange error", e);
    L389:
        e = e;
        r218 = r56;
    L392:
        r218 = r56;
        r219 = r57;
        r410 = r135;
        goto L393
    L345:
        if (TextUtils.isEmpty(r50) == false) goto L547;
    L364:
        r84 = r136;
        goto L365
    L547:
        JSONObject r88 = new JSONObject(r50).optJSONObject("data");     // Catch: Throwable -> L355
        String r150 = r88.optString("error_name", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L355
        Object r151 = Integer.valueOf(r88.optInt("error_code", 0));     // Catch: Throwable -> L355
        String r89 = r88.optString("description", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L353
        r145 = r151;
        r144 = -1;
        r85 = !"session_expired".equalsIgnoreCase(r150) ? 1 : 0;
        r86 = r89;
    L351:
        th = th;
        r145 = r151;
    L357:
        a.f("TokenFactory", "calculateIsLogin(), parse response body fail", th);
        r86 = r89;
        r85 = r136;
        r144 = -1;
    L353:
        th = th;
        r145 = r151;
        r89 = null;
    L355:
        th = th;
        r89 = null;
        r145 = null;
        goto L357
    L359:
        if (TextUtils.isEmpty(r34) == true) goto L364;
        if ("/passport/user/logout/".equals(r7) == false) goto L363;
        r84 = 0;
        goto L365
    L327:
        if (r40 == false) goto L329;
        TicketGuardEventHelper.r(r7, r35, r36);
    L329:
        r54 = null;
    L295:
        StringBuilder r152 = new StringBuilder("processResponseHeader, path: ");
        r152.append(r7);
        r152.append(", isVerifyFail: ");
        r152.append(r40);
        r152.append(", verifyResult: ");
        r152.append(r36);
        r152.append(", logid: ");
        r152.append(r35);
        r152.append(", hasProviderRequestContent: ");
        if (r126 == null) goto L298;
        boolean r153 = true;
    L299:
        r152.append(r153);
        r152.append(", hasConsumerRequestContent: ");
        if (r127 == null) goto L302;
        boolean r154 = true;
    L303:
        r152.append(r154);
        a.d("TokenFactory", r152.toString());
        goto L304
    L302:
        r154 = false;
        goto L303
    L298:
        r153 = false;
        goto L299
    L284:
        if (r122.isEmpty() == false) goto L287;
        r122 = r126.f;
    L287:
        if (r123.isEmpty() == false) goto L289;
        r123 = r126.g;
        goto L289
    L279:
        r126 = null;
        r127 = null;
        goto L280
    L331:
        a.e("TokenFactory", "processResponseHeader, TicketGuardService is null, path: " + r7 + ", isVerifyFail: " + r40 + ", verifyResult: " + r36 + ", logid: " + r35);
    L333:
        r57 = XmlPullParser.NO_NAMESPACE;
        r133 = r125;
        r55 = r41;
        r56 = r122;
        r132 = null;
    L274:
        r125 = null;
    L332:
        r41 = XmlPullParser.NO_NAMESPACE;
        r120 = XmlPullParser.NO_NAMESPACE;
        r122 = XmlPullParser.NO_NAMESPACE;
        r125 = null;
        goto L333
    L238:
        if ("/passport/account/info/v2/".equals(r7) == true) goto L241;
        r116 = false;
        goto L242
    L232:
        if (r36.equals(MiraMonitor.VALUE_DEFAULT) == true) goto L234;
        r40 = true;
        goto L236
    L187:
        if ("/passport/token/beat/v2/".equals(r7) == false) goto L228;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.q == false) goto L228;
        if (com.bytedance.sdk.account.settings.common.a.c(r7, com.bytedance.sdk.account.settings.common.a.i, com.bytedance.sdk.account.settings.common.a.j, com.bytedance.sdk.account.settings.common.a.k) == false) goto L228;
        if (r47 == null) goto L228;
        Map r90 = r47.a;
        if (r90 == null) goto L228;
        String r155 = (String) ((HashMap) r90).get("x-uc-sec-uid");
        String r91 = (String) ((HashMap) r47.a).get("X-Tt-Token");
        if (TextUtils.isEmpty(r155) == false) goto L205;
        if (TextUtils.isEmpty(r91) == true) goto L228;
    L205:
        if (TextUtils.isEmpty(r114) == false) goto L207;
    L209:
        boolean r156 = TextUtils.isEmpty(r155);
        boolean r157 = TextUtils.isEmpty(r114);
        if (r156 == true) goto L218;
        if (r157 == false) goto L218;
        if (this.o.a() == null) goto L218;
        if (TextUtils.isEmpty(((ta7.f) this.o.a()).getSecUserId()) == true) goto L228;
    L218:
        if (this.o.a() != null) goto L220;
    L222:
        boolean r158 = false;
    L223:
        a.b("TokenFactory", "account user uid mixed, logid=" + r35);
        r215 = r114;
        r37 = r113;
        r39 = r33;
        r216 = r115;
        r38 = r213;
        TTTokenMonitor.q(r7, r35, TextUtils.isEmpty(r91), r114, r155, r158, "old_path");
        if (r157 == true) goto L230;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.s == false) goto L230;
        this.j.removeMessages(3000);
        this.j.sendEmptyMessageDelayed(3000, 5000);
        goto L230
    L220:
        if (((ta7.f) this.o.a()).isLogin() == false) goto L222;
        r158 = true;
        goto L223
    L207:
        if (r114.equals(r155) == false) goto L209;
    L113:
        if (r32.j == false) goto L181;
        if (r14.isEmpty() == true) goto L181;
        r32.h();
        LinkedHashMap r92 = new LinkedHashMap();
        com.bytedance.sdk.account.settings.common.b.a();
        Iterator r93 = com.bytedance.sdk.account.settings.common.b.c.c.iterator();
        boolean r159 = false;
    L119:
        if (r93.hasNext() == false) goto L128;
        r93 = r93;
        String r94 = (String) r93.next();
        if (r14.containsKey(r94) == false) goto L119;
        String r160 = (String) r14.get(r94);
        if (r160 != null) goto L126;
        r160 = XmlPullParser.NO_NAMESPACE;
    L126:
        r92.put(r94, r160);
        r159 = true;
        goto L119
    L128:
        if (r159 == false) goto L181;
        Object r95 = r32.c;
        monitor-enter(r95);
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L178
        int r161 = com.bytedance.sdk.account.settings.common.b.f;     // Catch: Throwable -> L178
        if (r15 != null) goto L134;
        boolean r162 = true;
    L135:
        if (r15 == null) goto L137;
        AuthTokenMultiProcessSharedProvider.a r163 = r15;
    L138:
        if (r161 <= 0) goto L140;
        SharedPreferences.Editor r164 = r32.b().edit();     // Catch: Throwable -> L178
    L141:
        Iterator r222 = r92.keySet().iterator();     // Catch: Throwable -> L178
    L143:
        if (r222.hasNext() == false) goto L168;
        r18 = r18;
        String r165 = (String) r222.next();     // Catch: Throwable -> L178
        r14 = r14;
        String r166 = (String) r92.get(r165);     // Catch: Throwable -> L178
        if (r166 != null) goto L147;
    L150:
        boolean r223 = true;
    L151:
        if (r223 == true) goto L152;
        AuthTokenMultiProcessSharedProvider.a r224 = r15;
        r32.a.put(r165, r166);     // Catch: Throwable -> L178
        r163.c(r165, r166);     // Catch: Throwable -> L178
        r32.d(r165, r166, "save");     // Catch: Throwable -> L178
        if (r164 == null) goto L159;
        r164.putString(r165, r166);     // Catch: Throwable -> L178
    L159:
        if (r161 != 0) goto L167;
        com.bytedance.sdk.account.settings.common.a.a();     // Catch: Throwable -> L178
        if (com.bytedance.sdk.account.settings.common.a.P == false) goto L167;
        SharedPreferences.Editor r96 = r32.b().edit();     // Catch: Throwable -> L178
        if (r96 == null) goto L167;
        SharedPreferences.Editor r97 = r96.putString(r165, r166);     // Catch: Throwable -> L178
        if (r97 == null) goto L167;
        r97.apply();     // Catch: Throwable -> L178
    L167:
        StringBuilder r167 = new StringBuilder();     // Catch: Throwable -> L178
        r167.append("save header name=");     // Catch: Throwable -> L178
        r167.append(r165);     // Catch: Throwable -> L178
        r167.append(", value=");     // Catch: Throwable -> L178
        r167.append(r166);     // Catch: Throwable -> L178
        a.a("PassportExtraHeaderManager", r167.toString());     // Catch: Throwable -> L178
        r15 = r224;
        r161 = r161;
        goto L143
    L152:
        r32.a.remove(r165);     // Catch: Throwable -> L178
        r163.b.putNull(r165);     // Catch: Throwable -> L178
        if (r164 == null) goto L155;
        r164.remove(r165);     // Catch: Throwable -> L178
    L155:
        a.a("PassportExtraHeaderManager", "save header exist, response header null, remove key " + r165);     // Catch: Throwable -> L178
        r15 = r15;
        goto L143
    L147:
        if (r166.length() == 0) goto L150;
        r223 = false;
        goto L151
    L168:
        r212 = r18;
        r33 = r14;
        r213 = r15;
        r32.b++;     // Catch: Throwable -> L178
        int r98 = r32.b;     // Catch: Throwable -> L178
        r163.b.put("passport_extra_header_modify_flag", Integer.valueOf(r98));     // Catch: Throwable -> L178
        if (r162 == false) goto L171;
        r163.a();     // Catch: Throwable -> L178
    L171:
        if (r164 == null) goto L173;
        r164.putInt("passport_extra_header_modify_flag", r98);     // Catch: Throwable -> L178
    L173:
        if (r164 == null) goto L175;
        r164.apply();     // Catch: Throwable -> L178
    L175:
        r32.a("save", r98, r92);     // Catch: Throwable -> L178
        Unit r99 = Unit.INSTANCE;     // Catch: Throwable -> L178
        monitor-exit(r95);
        goto L182
    L140:
        r164 = null;
        goto L141
    L137:
        r163 = r32.i.b();     // Catch: Throwable -> L178
        goto L138
    L134:
        r162 = false;
    L178:
        th = move-exception;
        throw th;
    L183:
        r33 = r14;
        r213 = r15;
        r34 = XmlPullParser.NO_NAMESPACE;
        r35 = XmlPullParser.NO_NAMESPACE;
        r36 = XmlPullParser.NO_NAMESPACE;
        r115 = XmlPullParser.NO_NAMESPACE;
        r214 = XmlPullParser.NO_NAMESPACE;
        r113 = XmlPullParser.NO_NAMESPACE;
        r114 = null;
        r20 = false;
        goto L184
    L40:
        r15 = null;
        goto L41
    L589:
        return;
    L18:
        r2 = 0;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L25
    L13:
        r1 = false;
        goto L14
    L23:
        r7 = null;
        goto L25
    }

    public static void a(TokenFactory r1, String r2, String r3, String r4, String r5, TTTokenMonitor.SessionExpiredHandleResult r6) {
        r1.getClass();
        if (TextUtils.equals(r2, "frontier") == false) goto L12;
        HashSet r7 = TTTokenMonitor.b;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L7
        r8.put("scene", r2);     // Catch: Exception -> L7
        r8.put("from_host", r3);     // Catch: Exception -> L7
        r8.put("from_path", r4);     // Catch: Exception -> L7
        r8.put("from_logid", r5);     // Catch: Exception -> L7
        r8.put("handle", r6.name());     // Catch: Exception -> L7
        TTTokenMonitor.r("passport_session_expired_result", r8);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        TTTokenMonitor.d(e);
        return;
    }
}
