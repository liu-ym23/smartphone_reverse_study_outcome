package com.obric.assistant.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f390252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f390253b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<t> f390254c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<v> f390255d = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements n38.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f390256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<q38.b> f390257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f390258c;

        @Override // n38.k
        public final void a(n38.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            FLogger.f375446a.e("ObricLoginStrategyCenter", "remove account before O account logout failed, code=" + r100.f516990d + ", msg=" + r100.f516991e);
            f0.b(this.f390257b, this.f390258c, this.f390256a + 1);
        }

        @Override // n38.k
        public final void b(n38.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            f0.b(this.f390257b, this.f390258c, this.f390256a + 1);
        }

        public a(int r100, List<q38.b> r101, Function0<Unit> r102) {
            this.f390256a = r100;
            this.f390257b = r101;
            this.f390258c = r102;
        }
    }

    public f0() {
    }

    static {
        f390252a = new f0();
        f390253b = new m();
        f390254c = CollectionsKt.listOf(new t[]{new k(), new b(), new e()});
        f390255d = CollectionsKt.listOf(new v[]{new i(), new c(), new f()});
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessScene");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        u.f390269d.getClass();     // Catch: Throwable -> L19
        u r102 = u.f390270e;     // Catch: Throwable -> L19
        g r103 = u.a.b();     // Catch: Throwable -> L19
        Iterator<T> r104 = f390254c.iterator();     // Catch: Throwable -> L19
    L4:
        Unit r105 = null;
        if (r104.hasNext() == false) goto L9;
        Object r106 = r104.next();     // Catch: Throwable -> L19
        if (((t) r106).a(r102.f390273c) == false) goto L4;
    L10:
        t r107 = (t) r106;     // Catch: Throwable -> L19
        FLogger r108 = FLogger.f375446a;     // Catch: Throwable -> L19
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L19
        r109.append("checkAccountConsistencyOrLogout, loginType: ");     // Catch: Throwable -> L19
        r109.append(r102.f390273c);     // Catch: Throwable -> L19
        r109.append(", cachedOSecUid: ");     // Catch: Throwable -> L19
        r109.append(r102.f390271a.f390260b);     // Catch: Throwable -> L19
        r109.append(", currentOSecUid: ");     // Catch: Throwable -> L19
        r109.append(r103.f390260b);     // Catch: Throwable -> L19
        r109.append(", strategy: ");     // Catch: Throwable -> L19
        if (r107 == null) goto L13;
        String r110 = r107.getClass().getSimpleName();     // Catch: Throwable -> L19
    L14:
        r109.append(r110);     // Catch: Throwable -> L19
        r108.i("ObricLoginStrategyCenter", r109.toString());     // Catch: Throwable -> L19
        if (r107 == null) goto L17;
        r107.b(r100);     // Catch: Throwable -> L19
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r111 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L19
    L21:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L30;
        FLogger.f375446a.e("ObricLoginStrategyCenter", "checkAccountConsistencyOrLogout failed: " + r112, r112);
        return;
    L30:
        return;
    L13:
        r110 = null;
        goto L14
    L9:
        r106 = null;
    L19:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static String c(u r100) {
        return "oLogin=" + r100.f390271a.f390259a + ", oSecUid=" + r100.f390271a.f390260b + ", assistantLogin=" + r100.f390272b.f390248a + ", assistantSecUid=" + r100.f390272b.f390249b + ", loginType=" + r100.f390273c;
    }

    public static final void b(List<q38.b> r100, Function0<Unit> r101, int r102) {
        q38.b r103 = (q38.b) CollectionsKt.getOrNull(r100, r102);
        if (r103 != null) goto L6;
        r101.invoke();
        return;
    L6:
        IMultiAccountService.f286100a.a(r103, new a(r102, r100, r101));
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [com.obric.assistant.onelogin.y] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.obric.assistant.onelogin.x] */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.assistant.login.l, java.lang.Object] */
    public static void d(f0 r210, String r211, Activity r212, com.obric.assistant.onelogin.d r213, com.obric.assistant.onelogin.e r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r215 & 2) == 0) goto L9;
        Activity r101 = null;
    L11:
        if ((r215 & 4) == 0) goto L13;
        Function1 r102 = new z();
    L15:
        if ((r215 & 8) == 0) goto L17;
        Function2 r103 = new a0();
    L19:
        if ((r215 & 16) == 0) goto L21;
        Function0 r104 = new b0();
    L23:
        if ((r215 & 32) == 0) goto L25;
        Function0 r105 = new c0();
    L26:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r104, "authLoginStart");
        Intrinsics.checkNotNullParameter(r105, "authLoginFinish");
        FLogger.f375446a.i("ObricLoginStrategyCenter", "startOSystemOneLogin, strategy: ".concat(f390253b.getClass().getSimpleName()));
        final x r110 = new x(r100, r101, r102, r103, r104, r105);
        Intrinsics.checkNotNullParameter(r110, "request");
        String r106 = r110.f390275a;
        if (r106 != null) goto L29;
        r106 = "unknown";
    L29:
        Activity r107 = r110.getActivity();
        final Function2<ua7.h, String, Unit> r108 = r110.f390278d;
        Function0<Unit> r109 = r110.f390279e;
        Function0<Unit> r111 = r110.f390280f;
        final ?? r112 = new l(r110);
        StateFlowImpl r113 = com.obric.assistant.onelogin.c0.f390924a;
        Intrinsics.checkNotNullParameter(r106, "loginSource");
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        Intrinsics.checkNotNullParameter(r108, LynxVideoManagerLite.EVENT_ON_ERROR);
        Intrinsics.checkNotNullParameter(r109, "authLoginStart");
        Intrinsics.checkNotNullParameter(r111, "authLoginFinish");
        oc7.a.f522708a = "login";
        oc7.a.f522709b = "login_" + UUID.randomUUID().toString().replace("-", "");
        final String r114 = StringsKt.take(UUID.randomUUID().toString(), 8);
        if (r107 == null) goto L32;
        WeakReference r115 = new WeakReference(r107);
    L33:
        if (r115 != null) goto L35;
        String r116 = "onelogin_background";
    L36:
        final String r117 = r116;
        final boolean r118 = t1.f393353a.getObricOneLoginConfig().getEnableSafeOneLogin();
        IApplog.Companion r119 = IApplog.f287053a;     // Catch: Exception -> L39
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L39
        r120.put("login_id", r114);     // Catch: Exception -> L39
        r120.put("login_source", r106);     // Catch: Exception -> L39
        r120.put("type", r117);     // Catch: Exception -> L39
        r120.put("result_stage", "start");     // Catch: Exception -> L39
        r120.put("enable_safe_one_login", r118);     // Catch: Exception -> L39
        Unit r121 = Unit.INSTANCE;     // Catch: Exception -> L39
        r119.reportEvent("obric_login_start", r120);     // Catch: Exception -> L39
    L42:
        if (com.obric.assistant.onelogin.c0.d() == true) goto L45;
        FLogger.f375446a.i("ObricOneLoginUtils", "readSecDataOneLogin continue, loginId=" + r114 + ", source=" + r106 + ", type=" + r117 + ", O account is not login");
        com.obric.assistant.onelogin.c0.i(r114, r106, r117, r118, 0, "none", "o_account_not_login", null, "O account is not login", 128);
    L45:
        int r122 = com.larus.utils.f0.f375390a;
        AppHost.Companion r123 = AppHost.f326268a;
        if (com.larus.utils.f0.a(r123.getApplication()) == true) goto L52;
        FLogger.f375446a.i("ObricOneLoginUtils", "readSecDataOneLogin skip, loginId=" + r114 + ", source=" + r106 + ", type=" + r117 + ", network unavailable or invalid");
        if (TextUtils.equals(oc7.a.f522708a, "login") == false) goto L51;
        oc7.a.f522708a = null;
        oc7.a.f522709b = null;
    L51:
        com.obric.assistant.onelogin.c0.i(r114, r106, r117, r118, 0, "none", "network_unavailable", null, "network unavailable or invalid", 128);
        r108.invoke(null, "network unavailable or invalid");
        return;
    L52:
        final String r216 = r106;
        ?? r217 = new com.obric.assistant.onelogin.x(r114, r216, r117, r112, r118);
        ?? r124 = new com.obric.assistant.onelogin.y(r114, r216, r117, r118, r108);
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("readSecDataOneLogin, loginId=");
        r126.append(r114);
        r126.append(r15);
        r126.append(r106);
        r126.append(", type=");
        r126.append(r117);
        r126.append(", enableSafeOneLogin=");
        r126.append(r118);
        r126.append(", isEnableTokenGuard: ");
        com.bytedance.sdk.account.ticketguard.f.a();
        r126.append(com.bytedance.sdk.account.ticketguard.f.f269461i);
        r125.i("ObricOneLoginUtils", r126.toString());
        Context r127 = fra.f.f478636a;
        Application r128 = r123.getApplication();
        fra.a r129 = new fra.a();
        r129.f478619a = "com.obric.matrix";
        r129.f478624f = "com.obric.matrix";
        r129.f478621c = true;
        r129.f478622d = true;
        r129.f478623e = true;
        Unit r130 = Unit.INSTANCE;
        List r131 = CollectionsKt.listOf(r129);
        com.obric.assistant.onelogin.a0 r132 = new com.obric.assistant.onelogin.a0(r114, r106, r124, r118, r115, r117, r109, r111, r217);
        fra.f.f478636a = r128.getApplicationContext();
        if (fra.f.f478640e == false) goto L55;
        r132.b(new fra.c("", false, "isReading now", 8, 0));
        return;
    L55:
        fra.f.f478640e = true;
        fra.f.f478641f = false;
        fra.f.f478639d = false;
        fra.f.f478637b = r132;
        Handler r133 = fra.f.f478638c;
        fra.f.a r134 = fra.f.f478642g;
        r133.removeCallbacks(r134);
        r133.postDelayed(r134, 3000);
        ThreadPlus.submitRunnable(new fra.d(r131, r128));
        return;
    L39:
        e = move-exception;
        FLogger.f375446a.e("ObricOneLoginUtils", "readSecDataOneLogin report error: " + e);
        goto L42
    L35:
        r116 = "onelogin_foreground";
        goto L36
    L32:
        r115 = null;
        goto L33
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
