package com.ss.android.account.group_onekey;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sdk.account.impl.d0;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.account.group_onekey.bean.GetTokenState;
import com.ss.android.account.k;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.token.TokenFactory;
import com.ss.android.token.p;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import ta7.j;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/account/group_onekey/BaseAccountGroupAuthActivity;", "Landroid/app/Activity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-sdk-group-onekey_release"}, k = 1, mv = {1, 4, 0})
public abstract class BaseAccountGroupAuthActivity extends Activity {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f406251s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f406252t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f406253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f406254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f406255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f406256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f406257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f406258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f406259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f406260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f406261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f406262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f406263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f406264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f406265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f406266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f406267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f406268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f406269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f406270r;

    public static final class a {
    }

    public static final class b extends com.ss.android.account.group_onekey.network.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAccountGroupAuthActivity f406271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406272b;

        public b(BaseAccountGroupAuthActivity r100, long r101) {
            this.f406271a = r100;
            this.f406272b = r101;
        }

        @Override // com.ss.android.account.group_onekey.network.d
        public final void a(yqa.c r100, boolean r101) {
            BaseAccountGroupAuthActivity r102 = this.f406271a;
            r102.f406266n = SystemClock.elapsedRealtime() - this.f406272b;
            this.f406271a.c();
            if (r101 == false) goto L6;
            this.f406271a.finish();
            return;
        L6:
            BaseAccountGroupAuthActivity r103 = this.f406271a;
            r103.f406263k = r100.f568882d;
            r103.f406269q = r100.f568883e;
            r103.f406270r = r100.f568884f;
            r103.f406264l = r100.f568885g;
            r103.a(r100.f568881c, r100.f568879a, r100.f568880b, "default");
        }
    }

    public static final class c implements com.ss.android.token.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAccountGroupAuthActivity f406273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f406275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f406276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f406277e;

        @Override // com.ss.android.token.b
        public final void onError(String r100) {
            BaseAccountGroupAuthActivity.b(this.f406273a, "", -1, r100, 8);
        }

        @Override // com.ss.android.token.b
        public final void onSuccess(Map<String, String> r100) {
            this.f406273a.f406263k = SystemClock.elapsedRealtime() - this.f406274b;
            this.f406273a.f406269q = System.currentTimeMillis();
            if (r100 == null) goto L5;
            r100.put("x-uc-bypass-token", "1");
        L5:
            j r101 = d0.c();
            Map<String, String> r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("local_account_sdk_skip_network_check", "1"), TuplesKt.to("token_challenge", this.f406273a.f406256d), TuplesKt.to("token_challenge_method", this.f406275c), TuplesKt.to("client_aid", this.f406276d), TuplesKt.to("client_package", this.f406273a.f406255c), TuplesKt.to("client_signature", this.f406277e), TuplesKt.to("login_scene", this.f406273a.f406257e), TuplesKt.to("response_format_type", "app")});
            BaseAccountGroupAuthActivity r103 = this.f406273a;
            r103.getClass();
            ((d0) r101).b("/passport/safe/get_token/", r100, r102, new com.ss.android.account.group_onekey.d(r103, SystemClock.elapsedRealtime()));
        }

        public c(BaseAccountGroupAuthActivity r100, long r101, String r102, String r103, String r104) {
            this.f406273a = r100;
            this.f406274b = r101;
            this.f406275c = r102;
            this.f406276d = r103;
            this.f406277e = r104;
        }
    }

    public static final class d implements com.ss.android.token.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAccountGroupAuthActivity f406278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f406279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f406280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f406281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f406282e;

        public d(BaseAccountGroupAuthActivity r100, long r101, String r102, String r103, String r104) {
            this.f406278a = r100;
            this.f406279b = r101;
            this.f406280c = r102;
            this.f406281d = r103;
            this.f406282e = r104;
        }

        @Override // com.ss.android.token.c
        public final void onInitFinish() {
            this.f406278a.f406263k = SystemClock.elapsedRealtime() - this.f406279b;
            this.f406278a.f406269q = System.currentTimeMillis();
            BaseAccountGroupAuthActivity r100 = this.f406278a;
            r100.getClass();
            if (com.bytedance.sdk.account.impl.j.m(r100).isLogin() == true) goto L6;
            BaseAccountGroupAuthActivity.b(this.f406278a, "", -2, "not login", 8);
            this.f406278a.c();
            return;
        L6:
            j r101 = d0.c();
            Map<String, String> r102 = MapsKt.mapOf(new Pair[]{TuplesKt.to("token_challenge", this.f406278a.f406256d), TuplesKt.to("token_challenge_method", this.f406280c), TuplesKt.to("client_aid", this.f406281d), TuplesKt.to("client_package", this.f406278a.f406255c), TuplesKt.to("client_signature", this.f406282e), TuplesKt.to("login_scene", this.f406278a.f406257e), TuplesKt.to("response_format_type", "app")});
            BaseAccountGroupAuthActivity r103 = this.f406278a;
            r103.getClass();
            ((d0) r101).b("/passport/safe/get_token/", null, r102, new com.ss.android.account.group_onekey.d(r103, SystemClock.elapsedRealtime()));
        }
    }

    static {
        f406251s = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(BaseAccountGroupAuthActivity.class), "isEnableGroupOneLoginOpt", "isEnableGroupOneLoginOpt()Z"))};
        f406252t = true;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public abstract void c();

    public final boolean d() {
        Lazy r100 = this.f406258f;
        KProperty r101 = f406251s[0];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public abstract void e();

    public BaseAccountGroupAuthActivity() {
        this.f406253a = "BaseAccountGroupAuthActivity";
        this.f406254b = 1;
        this.f406255c = "";
        this.f406256d = "";
        this.f406257e = "";
        this.f406258f = LazyKt.lazy(BaseAccountGroupAuthActivity$isEnableGroupOneLoginOpt$2.INSTANCE);
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0119 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L53;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r210) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r210);
        if (getIntent() != null) goto L14;
        finish();
        return;
    L14:
        this.f406260h = SystemClock.elapsedRealtime();
        this.f406261i = com.bytedance.sdk.account.utils.d.a();
        boolean r100 = true;
        if (com.bytedance.sdk.account.utils.d.a() < 15000) goto L17;
    L19:
        boolean r101 = false;
    L20:
        this.f406262j = r101;
        if (f406252t == true) goto L24;
        if (r101 == false) goto L24;
        this.f406262j = false;
        tb7.a.e(this.f406253a, "isColdStart=ture but isFirstStart=false");
        JSONObject r102 = new JSONObject();
        r102.put("message", "isColdStart=ture but isFirstStart=false");
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_ensure_not_reach_here", r102);
    L24:
        f406252t = false;
        this.f406254b = getIntent().getIntExtra("client_auth_version", 1);
        String r103 = getIntent().getStringExtra("client_package");
        String r104 = "";
        if (r103 != null) goto L28;
        r103 = "";
    L28:
        this.f406255c = r103;
        String r105 = getIntent().getStringExtra("client_challenge");
        if (r105 != null) goto L32;
        r105 = "";
    L32:
        this.f406256d = r105;
        String r106 = getIntent().getStringExtra("login_scene");
        if (r106 != null) goto L36;
        r106 = "";
    L36:
        this.f406257e = r106;
        this.f406259g = getIntent().getBooleanExtra("is_enable_pre_get_token", false);
        if (getIntent().getIntExtra("is_cold_boot_landing_page", 0) != 1) goto L39;
        boolean r107 = true;
    L40:
        this.f406267o = r107;
        tb7.a.d(this.f406253a, "onCreate(), isEnablePreGetToken=" + this.f406259g + ", isColdBootLandingPage=" + this.f406267o + ", isColdStart=" + this.f406262j + ", clientAuthVersion" + this.f406254b + ", clientPkg=" + this.f406255c);
        if (this.f406254b < 2) goto L53;
        String r108 = getCallingPackage();
        if (r108 != null) goto L45;
    L48:
        boolean r109 = true;
    L49:
        if (r109 == false) goto L51;
        tb7.a.b(this.f406253a, "callingPackage is null, downgrade to clientAuthVersion=1");
        JSONObject r110 = new JSONObject();
        r110.put("message", "callingPackage is null, downgrade to clientAuthVersion=1");
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_ensure_not_reach_here", r110);
        this.f406254b = 1;
        goto L53
    L51:
        this.f406255c = r108;
        goto L53
    L45:
        if (r108.length() == 0) goto L48;
        r109 = false;
    L53:
        if (this.f406254b != 1) goto L72;
        String r111 = this.f406255c;
        if (r111 != null) goto L57;
    L60:
        boolean r112 = true;
    L61:
        if (r112 == true) goto L70;
        String r113 = this.f406256d;
        if (r113 != null) goto L65;
    L68:
        boolean r114 = true;
    L69:
        if (r114 == false) goto L72;
    L65:
        if (r113.length() == 0) goto L68;
        r114 = false;
    L70:
        finish();
        return;
    L57:
        if (r111.length() == 0) goto L60;
        r112 = false;
    L72:
        if (Intrinsics.areEqual(this.f406255c, getPackageName()) == false) goto L74;
        tb7.a.b(this.f406253a, "clientPkg should not be same as packageName");
        finish();
        return;
    L74:
        String r115 = getIntent().getStringExtra("client_aid");
        if (r115 != null) goto L77;
    L80:
        boolean r116 = true;
    L82:
        if (r116 == false) goto L84;
        b(this, "", -8, "param invalid,aid is empty", 8);
        return;
    L84:
        String r117 = getIntent().getStringExtra("client_challenge_method");
        if (r117 != null) goto L87;
    L90:
        if (r100 == false) goto L93;
        b(this, "", -8, "param invalid,challenge method is empty", 8);
        return;
    L93:
        if (com.bytedance.sdk.account.impl.j.m(this).isLogin() == true) goto L95;
        b(this, "", -2, "not login", 8);
        return;
    L95:
        String r118 = zqa.c.b(zqa.c.a(this, this.f406255c));
        e();
        this.f406265m = p.f449778b;
        long r119 = SystemClock.elapsedRealtime();
        this.f406268p = System.currentTimeMillis();
        tb7.a.d(this.f406253a, "start get token");
        if (this.f406259g == false) goto L123;
        long r120 = SystemClock.elapsedRealtime();
        Map<String, yqa.b> r121 = com.ss.android.account.group_onekey.network.c.f406314a;
        String r122 = this.f406256d;
        String r123 = this.f406255c;
        String r124 = this.f406257e;
        b r125 = new b(this, r120);
        tb7.a.d("AccountGroupNetworkHelper", "getToken(), start, clientPkg=" + r123 + ", challenge=" + r122 + ", loginScene=" + r124);
        StringBuilder r126 = new StringBuilder();
        r126.append(r123);
        r126.append('_');
        r126.append(r122);
        String r127 = r126.toString();
        ConcurrentHashMap r128 = (ConcurrentHashMap) com.ss.android.account.group_onekey.network.c.f406314a;
        yqa.b r129 = (yqa.b) r128.get(r127);
        if (r129 == null) goto L109;
        tb7.a.d("AccountGroupNetworkHelper", "getToken(), had cache, state=null, isTokenValid=" + r129.a() + ", hadCallback=false");
        if (GetTokenState.REQUESTING != null) goto L103;
        return;
    L103:
        if (r129.a() == false) goto L109;
        yqa.c r130 = r129.f568878a;
        if (r130 != null) goto L107;
        Intrinsics.throwNpe();
    L107:
        r125.a(r130, false);
        tb7.a.d("AccountGroupAuthService", "GetTokenCache invalid");
        r129.f568878a = null;
        r128.remove(r127);
        return;
    L109:
        if (r124 == null) goto L111;
        String r131 = r124;
    L112:
        yqa.c r132 = new yqa.c(r131);
        wqa.f r133 = k.f406318b;
        if (r133 != null) goto L116;
        r132.f568879a = -11;
        r132.f568880b = "not set TTAccountConfig";
        r125.a(r132, false);
        return;
    L116:
        if (r123.equals(r133.getApplicationContext().getPackageName()) == false) goto L118;
        r132.f568879a = -8;
        r132.f568880b = "clientPkg illegal";
        r125.a(r132, false);
        return;
    L118:
        String r134 = zqa.c.b(zqa.c.a(r133.getApplicationContext(), r123));
        long r135 = SystemClock.elapsedRealtime();
        if (r124 == null) goto L121;
        r104 = r124;
    L121:
        p.c(new com.ss.android.account.group_onekey.network.b(new yqa.c(r104), r135, r122, r117, r115, r123, r134, r124, r125));
        return;
    L111:
        r131 = "";
        goto L112
    L123:
        if (d() == false) goto L125;
        p.c(new c(this, r119, r117, r115, r118));
        return;
    L125:
        TokenFactory.b(new d(this, r119, r117, r115, r118));
        return;
    L87:
        if (r117.length() == 0) goto L90;
        r100 = false;
        goto L90
    L77:
        if (r115.length() == 0) goto L80;
        r116 = false;
        goto L82
    L39:
        r107 = false;
        goto L40
    L17:
        if (com.bytedance.sdk.account.utils.d.f269538b.size() > 1) goto L19;
        r101 = true;
        goto L20
    }

    public final void a(String r110, int r111, String r112, String r113) {
        Intent r100 = new Intent();
        if (this.f406254b != 1) goto L5;
        r100.setComponent(new ComponentName(this.f406255c, this.f406255c + ".auth.AccountGroupAuthCallbackActivity"));
    L5:
        r100.putExtra("server_auth_version", 3);
        r100.putExtra("server_app_enable_group_one_login_opt", d() ? 1 : 0);
        r100.putExtra("server_app_auth_activity_on_create_time", this.f406260h);
        if (r110.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        r100.putExtra(ITwitterService.ResponseConstants.AUTH_TOKEN, r110);
    L11:
        r100.putExtra("code", r111);
        r100.putExtra("challenge", this.f406256d);
        if (r112 == null) goto L14;
        r100.putExtra("message", r112);
    L14:
        r100.putExtra("server_app_is_cold_launch", this.f406262j ? 1 : 0);
        r100.putExtra("server_app_start_request_get_token_time", this.f406269q);
        r100.putExtra("server_app_end_request_get_token_time", this.f406270r);
        r100.putExtra("server_app_auth_wait_sdk_init_time", this.f406268p);
        r100.putExtra("callback_result_scene", r113);
        r100.putExtra("duration_wait_get_token", this.f406266n);
        r100.putExtra("is_enable_pre_get_token", this.f406259g);
        r100.putExtra("is_cold_boot_landing_page", this.f406267o ? 1 : 0);
        JSONObject r102 = new JSONObject();
        r102.put("is_cold_start", this.f406262j ? 1 : 0);
        r102.put("duration", SystemClock.elapsedRealtime() - this.f406260h);
        r102.put("duration_from_app_start", this.f406261i);
        r102.put("duration_wait_sdk_init", this.f406263k);
        r102.put("duration_request_get_token", this.f406264l);
        r102.put("is_token_sdk_init", this.f406265m ? 1 : 0);
        r102.put("is_enable_group_one_login_opt", d() ? 1 : 0);
        r102.put("server_auth_version", 3);
        r102.put("client_auth_version", this.f406254b);
        r102.put("error", r111);
        if (r112 == null) goto L17;
        String r103 = r112;
    L18:
        r102.put("fail_info", r103);
        r102.put("callback_result_scene", r113);
        r102.put("duration_wait_get_token", this.f406266n);
        r102.put("is_enable_pre_get_token", this.f406259g ? 1 : 0);
        r102.put("is_cold_boot_landing_page", this.f406267o ? 1 : 0);
        com.bytedance.sdk.account.monitor.a.a("uc_share_login_server_app_auth_result", r102);
        if (this.f406254b != 1) goto L21;
        startActivity(r100);
    L22:
        finish();
        return;
    L21:
        setResult(-1, r100);
        goto L22
    L17:
        r103 = "";
        goto L18
    L8:
        r101 = false;
        goto L9
    }

    public static /* synthetic */ void b(BaseAccountGroupAuthActivity r100, String r101, int r102, String r103, int r104) {
        String r105 = null;
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r105 = "default";
    L8:
        r100.a(r101, r102, r103, r105);
    }
}
