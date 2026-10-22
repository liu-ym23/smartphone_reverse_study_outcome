package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.account.internal.ui.activity.AccountSignInHubActivity;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AccountAuthResult;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.api.entity.account.AccountSignInRequest;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.utils.Util;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class f {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void a() {
        g.a().c();
    }

    public static AuthAccount b() {
        return g.a().b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_hwid_f_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_huawei_hms_hwid_f_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = Thread.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void a(Window r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L7;
        as.b("[AccountSDK]AccountAuthUtil", "android version is Higher than 9.0", true);
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.layoutInDisplayCutoutMode = 1;
        r100.setAttributes(r101);
        INVOKEVIRTUAL_com_huawei_hms_hwid_f_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(5894);
        return;
    L7:
        as.b("[AccountSDK]AccountAuthUtil", "android version is Below 9.0", true);
        WindowManager.LayoutParams r102 = r100.getAttributes();
        Class r103 = INVOKESTATIC_com_huawei_hms_hwid_f_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.LayoutParamsEx");     // Catch: Exception -> L10 RuntimeException -> L12
        Object r104 = r103.getConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{r102});     // Catch: Exception -> L10 RuntimeException -> L12
        r103.getMethod("addHwFlags", new Class[]{Integer.TYPE}).invoke(r104, new Object[]{4096});     // Catch: Exception -> L10 RuntimeException -> L12
    L19:
        return;
    L12:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "Adapt to the digging screen occur RuntimeException".concat(e.getClass().getSimpleName()), true);
        return;
    L10:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "Adapt to the digging screen occur exception".concat(e.getClass().getSimpleName()), true);
    }

    public static void a(Activity r100) {
        int r101 = INVOKEVIRTUAL_com_huawei_hms_hwid_f_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getSystemUiVisibility();     // Catch: Exception -> L6
        r100.getWindow().addFlags(Integer.MIN_VALUE);     // Catch: Exception -> L6
        INVOKEVIRTUAL_com_huawei_hms_hwid_f_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setSystemUiVisibility(r101 | 1024);     // Catch: Exception -> L6
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L6
        r100.getWindow().setStatusBarColor(0);     // Catch: Exception -> L6
        r100.getWindow().setNavigationBarColor(0);     // Catch: Exception -> L6
        if (r102 < 29) goto L11;
        r100.getWindow().setNavigationBarContrastEnforced(false);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "exception occured:".concat(e.getClass().getSimpleName()), true);
    }

    public static AccountAuthResult a(Intent r100) {
        as.b("[AccountSDK]AccountAuthUtil", "getSignInResultFromIntent", true);
        if (r100 != null) goto L5;
    L12:
        as.d("[AccountSDK]AccountAuthUtil", "data or signInResult is null", true);
        return null;
    L5:
        if (r100.hasExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID) == false) goto L12;
        String r101 = r100.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID);
        return new AccountAuthResult().fromJson(r101);
    L10:
        as.d("[AccountSDK]AccountAuthUtil", "JSONException", true);
        return null;
    }

    public static AccountAuthParams a(List<Scope> r100) {
        AccountAuthParamsHelper r101 = new AccountAuthParamsHelper();
        if (ap.b(r100).booleanValue() == false) goto L6;
        r101.setScopeList(r100);
    L6:
        return r101.createParams();
    }

    public static Intent a(Context r100, AccountAuthParams r101, String r102) {
        as.b("[AccountSDK]AccountAuthUtil", "getSignInIntent", true);
        return a(r100, r101, r102, 0, "");
    }

    public static Intent a(Context r100, AccountAuthParams r101, String r102, String r103) {
        as.b("[AccountSDK]AccountAuthUtil", "getIndependentSignInIntent", true);
        return a(r100, r101, r102, 1, r103);
    }

    private static Intent a(Context r100, AccountAuthParams r101, String r110, int r111, String r112) {
        if (r111 != 1) goto L5;
        String r102 = "com.huawei.hms.account.picker.signIn";
    L6:
        Intent r103 = new Intent(r102);
        r103.setPackage(r100.getPackageName());     // Catch: Exception -> L25
        r103.setClass(r100, AccountSignInHubActivity.class);     // Catch: Exception -> L25
        if (r111 != 1) goto L19;
        r103.putExtra("ACCESS_TOKEN", r112);     // Catch: Exception -> L25
        r103.putExtra("INDEPENDENT_SIGN_IN_FLAG", r111);     // Catch: Exception -> L25
        String r104 = r101.getSignInParams();     // Catch: JSONException -> L17 Exception -> L25
        if (TextUtils.isEmpty(r104) == false) goto L14;
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L17 Exception -> L25
    L15:
        r105.put("ACCESS_TOKEN", r112);     // Catch: JSONException -> L17 Exception -> L25
        r105.put("INDEPENDENT_SIGN_IN_FLAG", r111);     // Catch: JSONException -> L17 Exception -> L25
        r101.setSignInParams(r105.toString());     // Catch: JSONException -> L17 Exception -> L25
    L14:
        r105 = new JSONObject(r104);     // Catch: JSONException -> L17 Exception -> L25
    L17:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "JSONException:".concat(e.getClass().getSimpleName()), true);     // Catch: Exception -> L25
    L19:
        String r113 = Util.getAppId(r100);     // Catch: Exception -> L25
        String r106 = r100.getPackageName();     // Catch: Exception -> L25
        b r114 = new b();     // Catch: Exception -> L25
        r114.b(r113);     // Catch: Exception -> L25
        r114.c(r106);     // Catch: Exception -> L25
        r114.a(61100301);     // Catch: Exception -> L25
        r114.d(r110);     // Catch: Exception -> L25
        AccountSignInRequest r107 = new AccountSignInRequest();     // Catch: Exception -> L25
        r107.setAccountAuthParams(r101);     // Catch: Exception -> L25
        r103.putExtra("HUAWEIID_CP_CLIENTINFO", r114.d());     // Catch: JSONException -> L22 Exception -> L25
        r103.putExtra("HUAWEIID_SIGNIN_REQUEST", r107.toJson());     // Catch: JSONException -> L22 Exception -> L25
    L27:
        return r103;
    L22:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "JSONException:".concat(e.getClass().getSimpleName()), true);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        as.d("[AccountSDK]AccountAuthUtil", "Exception:".concat(e.getClass().getSimpleName()), true);
        goto L27
    L5:
        r102 = "com.huawei.hms.account.signIn";
        goto L6
    }
}
