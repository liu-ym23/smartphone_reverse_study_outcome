package com.obric.assistant.onelogin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.f0;
import com.larus.utils.logger.FLogger;
import com.obric.matrix.platform.sdk.ones.account.IAccountService;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StateFlowImpl f390924a = null;

    public static final boolean d() {
        OAccount.f396900a.getClass();     // Catch: Exception -> L16
        OAccount.c(false);     // Catch: Exception -> L16
        com.obric.matrix.platform.sdk.ones.account.g r100 = OAccount.f396903d;     // Catch: Exception -> L16
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mAccountManager");     // Catch: Exception -> L16
        r100 = null;
    L6:
        monitor-enter(r100);     // Catch: Exception -> L16
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L8:
        if (com.obric.matrix.platform.sdk.ones.account.g.f396942d != null) goto L10;
        r100.f();     // Catch: Throwable -> L13
    L10:
        com.obric.matrix.platform.sdk.ones.account.a r101 = com.obric.matrix.platform.sdk.ones.account.g.f396942d;     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Exception -> L16
        return r101.f396908a;
    L16:
        e = move-exception;
        FLogger.f375446a.e("ObricOneLoginUtils", "getOAccountLoginImmediate failed: " + e, e);
        return false;
    }

    static {
        f390924a = j1.a(Boolean.FALSE);
    }

    public static final boolean e() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L10;
        q38.a r101 = r100.getAccountInfo();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.f531528a != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static void f() {
        if (d() == true) goto L5;
        FLogger.f375446a.i("ObricOneLoginUtils", "oAccountLogout skip, O account is not login");
        return;
    L5:
        StateFlowImpl r100 = f390924a;
    L6:
        Object r101 = r100.getValue();
        ((Boolean) r101).booleanValue();
        if (r100.compareAndSet(r101, Boolean.TRUE) == false) goto L6;
        g(new Ref.IntRef(), 5);
    }

    public static final Activity c(WeakReference<Activity> r100) {
        if (r100 == null) goto L5;
        Activity r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if (r101.isFinishing() == false) goto L11;
        return null;
    L11:
        if (r101.isDestroyed() == false) goto L14;
        return null;
    L14:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public static final String j(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = com.larus.utils.gson.b.a(r100);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Exception -> L5
        g2a.e r102 = g2a.e.f479755a;     // Catch: Exception -> L5
        return g2a.f.a(r101, false, true);
    L5:
        e = move-exception;
        return "FGson.toJson error: " + e;
    }

    public static final void g(final Ref.IntRef r100, final int r101) {
        OAccount r102 = OAccount.f396900a;     // Catch: Exception -> L7
        Function0 r103 = new s();     // Catch: Exception -> L7
        Function2 r104 = new t(r100, r101);     // Catch: Exception -> L7
        r102.getClass();     // Catch: Exception -> L7
        OAccount.c(true);     // Catch: Exception -> L7
        IAccountService r105 = OAccount.f396905f;     // Catch: Exception -> L7
        if (r105 != null) goto L5;
        dka.a.b("AccountSDK_OAccount", "AccountService is null.");     // Catch: Exception -> L7
        r104.invoke(1002, "");     // Catch: Exception -> L7
        OAccount.d();     // Catch: Exception -> L7
    L12:
        return;
    L5:
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L7
        r105.logout(new OAccount.AsyncResultCallback("logout", r103, r104, null, 8, null));     // Catch: Exception -> L7
    L7:
        e = move-exception;
        FLogger.f375446a.w("ObricOneLoginUtils", "system logout failed, " + e);
        StateFlowImpl r106 = f390924a;
    L9:
        Object r107 = r106.getValue();
        ((Boolean) r107).booleanValue();
        if (r106.compareAndSet(r107, Boolean.FALSE) == false) goto L9;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.onelogin.w] */
    public static final void b(final boolean r100, String r101, final Function0 r102) {
        Intrinsics.checkNotNullParameter(r101, "businessScene");
        Intrinsics.checkNotNullParameter(r102, "onLogout");
        FLogger r103 = FLogger.f375446a;
        r103.i("ObricOneLoginUtils", "doubaoLogout, finishAll: " + r100);
        ?? r104 = new w(r100, r102);
        if (e() == true) goto L6;
        r103.i("ObricOneLoginUtils", "doubaoLogout skip, assistant account is not login");
        r104.invoke();
        return;
    L6:
        ILoginService r105 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r105 == null) goto L10;
        r105.x(true, new z(r104), r101);
        return;
    }

    public static final void h(String r100, String r101, String r102, boolean r103, int r104, String r105, String r110, ua7.h r111, String r112) {
        IApplog.Companion r106 = IApplog.f287053a;     // Catch: Exception -> L11
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L11
        r107.put("login_id", r100);     // Catch: Exception -> L11
        r107.put("login_source", r101);     // Catch: Exception -> L11
        r107.put("success", r104);     // Catch: Exception -> L11
        r107.put("type", r102);     // Catch: Exception -> L11
        r107.put("login_method", r105);     // Catch: Exception -> L11
        r107.put("result_stage", r110);     // Catch: Exception -> L11
        r107.put("enable_safe_one_login", r103);     // Catch: Exception -> L11
        if (r104 == 0) goto L5;
    L9:
        Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L11
        r106.reportEvent("obric_login_result", r107);     // Catch: Exception -> L11
        return;
    L5:
        if (r111 == null) goto L7;
        Object r109 = Integer.valueOf(r111.f549254h).toString();     // Catch: Exception -> L11
    L8:
        r107.put("err_code", r109);     // Catch: Exception -> L11
        r107.put("err_tips", r112);     // Catch: Exception -> L11
        int r113 = f0.f375390a;     // Catch: Exception -> L11
        r107.put("login_network", String.valueOf(f0.a(AppHost.f326268a.getApplication()) ? 1 : 0));     // Catch: Exception -> L11
        goto L9
    L7:
        r109 = null;
    L11:
        e = move-exception;
        FLogger.f375446a.e("ObricOneLoginUtils", "readSecDataOneLogin result report error: " + e);
    }

    public static final void a(WeakReference r110, String r111, String r112, String r210, boolean r211, Function0 r212, Function4 r213, Function0 r214, Function3 r215, String r216) {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = zqa.c.b(zqa.c.a(r100.getApplication(), r216));
        Activity r102 = c(r110);
        if (r102 == null) goto L40;
        FLogger.f375446a.i("ObricOneLoginUtils", "before AccountGroupAuthService.startAuth, loginId=" + r111 + ", source=" + r112 + ", type=" + r210 + ", enableSafeOneLogin=" + r211 + ", scene=share_login, serverPkg=" + r216 + ", activity=" + r102);
        r212.invoke();
        int r103 = com.ss.android.account.group_onekey.c.f406291a;
        String r104 = String.valueOf(r100.getAppId());
        String r105 = UUID.randomUUID().toString();
        Intrinsics.checkNotNull(r101);
        b0 r106 = new b0(r111, r112, r214, r213, r215, r102.getApplicationContext(), String.valueOf(r100.getAppId()));
        long r107 = System.currentTimeMillis();
        yqa.a r108 = new yqa.a();
        com.bytedance.sdk.account.settings.common.a.a();
        boolean r113 = com.bytedance.sdk.account.settings.common.a.f269400x;
        com.ss.android.account.group_onekey.b r114 = new com.ss.android.account.group_onekey.b(r106, r107, r113, r108);
        r102.getPackageManager().getActivityInfo(new ComponentName(r216, r216 + ".auth.AccountGroupAuthActivity"), 128);     // Catch: PackageManager.NameNotFoundException -> L7
        boolean r109 = true;
    L9:
        if (r109 == true) goto L12;
        r114.onError(new AuthorizeErrorResponse(-6, "auth app version is not support"));
        return;
    L12:
        if (TextUtils.equals(zqa.c.b(zqa.c.a(r102, r216)), r101) == true) goto L15;
        r114.onError(new AuthorizeErrorResponse(-7, "auth client app signature invalid"));
        return;
    L15:
        if (r102.isFinishing() == false) goto L17;
    L39:
        r114.onError(new AuthorizeErrorResponse(-9, "activity not available"));
        return;
    L17:
        if (r102.isDestroyed() == true) goto L39;
        String r115 = r102.getPackageName();
        Intent r116 = new Intent();
        if (r105 != null) goto L22;
    L33:
        String r117 = null;
    L34:
        int r118 = com.ss.android.account.group_onekey.c.f406291a + 1;
        com.ss.android.account.group_onekey.c.f406291a = r118;
        com.ss.android.account.group_onekey.c.f406292b.put(r117, Integer.valueOf(r118));
        com.ss.android.account.group_onekey.c.f406293c.put(r117, r105);
        com.ss.android.account.group_onekey.c.f406294d.put(r117, new SoftReference(r114));
        r116.setComponent(new ComponentName(r216, r216 + ".auth.AccountGroupAuthActivity"));
        r116.putExtra("client_aid", r104);
        r116.putExtra("login_scene", "share_login");
        r116.putExtra("client_challenge", r117);
        r116.putExtra("client_challenge_method", "sha256");
        r116.putExtra("client_package", r115);
        r116.putExtra("client_callback_activity", r115 + ".auth.AccountGroupAuthCallbackActivity");
        r116.putExtra("client_auth_version", 3);
        r116.putExtra("is_enable_pre_get_token", r113);
        r108.f568877a = System.currentTimeMillis();
        com.ss.android.account.group_onekey.c.f406296f.put(r117, r108);
        ab7.a.startActivityForResult("bpea-account_sdk_group_onekey_login", r102, r116, r118);     // Catch: Exception -> L37
        com.ss.android.account.group_onekey.c.f406295e.postDelayed(new com.ss.android.account.group_onekey.a(r117), 30000);
        return;
    L37:
        e = move-exception;
        e.printStackTrace();
        AuthorizeErrorResponse r119 = new AuthorizeErrorResponse(-6, "auth app version is not support");
        r119.platformErrorDetail = e.getMessage();
        r114.onError(r119);
        com.ss.android.account.group_onekey.c.f406293c.remove(r117);
        com.ss.android.account.group_onekey.c.f406294d.remove(r117);
        com.ss.android.account.group_onekey.c.f406292b.remove(r117);
        com.ss.android.account.group_onekey.c.f406296f.remove(r117);
        return;
    L22:
        if (r105.length() <= 0) goto L33;
        MessageDigest r120 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L31
        r120.update(r105.getBytes());     // Catch: NoSuchAlgorithmException -> L31
        byte[] r121 = r120.digest();     // Catch: NoSuchAlgorithmException -> L31
        StringBuilder r122 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L31
        int r123 = r121.length;     // Catch: NoSuchAlgorithmException -> L31
        int r124 = 0;
    L24:
        if (r124 >= r123) goto L29;
        String r125 = Integer.toHexString(r121[r124] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L31
        byte[] r126 = r121;
        int r217 = r123;
        if (r125.length() != 1) goto L28;
        r122.append('0');     // Catch: NoSuchAlgorithmException -> L31
    L28:
        r122.append(r125);     // Catch: NoSuchAlgorithmException -> L31
        r124 = r124 + 1;     // Catch: NoSuchAlgorithmException -> L31
        r121 = r126;
        r123 = r217;
        goto L24
    L29:
        r117 = r122.toString();     // Catch: NoSuchAlgorithmException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L7:
        r109 = false;
        goto L9
    L40:
        r213.invoke(null, "activity is null", "start_auth", "no_activity");
    }

    public static /* synthetic */ void i(String r110, String r111, String r112, boolean r113, int r114, String r115, String r116, ua7.h r117, String r210, int r211) {
        if ((r211 & 128) == 0) goto L5;
        ua7.h r118 = null;
    L7:
        if ((r211 & 256) == 0) goto L9;
        String r119 = null;
    L10:
        h(r110, r111, r112, r113, r114, r115, r116, r118, r119);
        return;
    L9:
        r119 = r210;
        goto L10
    L5:
        r118 = r117;
        goto L7
    }
}
