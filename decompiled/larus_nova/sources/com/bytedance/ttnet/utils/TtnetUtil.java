package com.bytedance.ttnet.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.util.c;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TtnetUtil {
    private static final String LOG_TAG = "TtnetUtil";
    private static final int RECEIVER_NOT_EXPORTED = 4;
    private static volatile boolean mDisableOkHttpDispatch;

    private TtnetUtil() {
    }

    public static boolean getDisableOkHttpDispatch() {
        return mDisableOkHttpDispatch;
    }

    public static void enableOkhttpBoeProxy(boolean r100) {
        c.f244774c = r100;
    }

    public static String outputThrowableStackTrace(Throwable r100) {
        String r101 = null;
        if (r100 != null) goto L29;
        return null;
    L29:
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r103 = new PrintWriter(r102);     // Catch: Throwable -> L15
        r100.printStackTrace(r103);     // Catch: Throwable -> L13
        Throwable r104 = r100.getCause();     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        r104.printStackTrace(r103);     // Catch: Throwable -> L13
        Throwable r105 = r104.getCause();     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r105.printStackTrace(r103);     // Catch: Throwable -> L13
    L11:
        r101 = r102.toString();     // Catch: Throwable -> L13
    L12:
        r103.close();
    L20:
        return r101;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r103 == null) goto L20;
    L21:
        th = move-exception;
        if (r103 == null) goto L24;
        r103.close();
    L24:
        throw th;
    L15:
        th = th;
        r103 = null;
        goto L25
    }

    public static void setDisableOkHttpDispatch(boolean r100) {
        mDisableOkHttpDispatch = r100;
    }

    public static void setOkhttpBypassBoeJson(String r100) {
        String r101 = c.f244772a;
        if (StringUtils.isEmpty(r100) == true) goto L46;
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L31
        JSONArray r103 = r102.optJSONArray("bypass_boe_host_list");     // Catch: JSONException -> L31
        int r104 = 0;
        if (r103 == null) goto L14;
        int r105 = 0;
    L9:
        if (r105 >= r103.length()) goto L14;
        String r106 = r103.optString(r105);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r106) == true) goto L13;
        ((ArrayList) c.f244776e).add(r106);     // Catch: JSONException -> L31
    L13:
        r105 = r105 + 1;     // Catch: JSONException -> L31
    L14:
        JSONArray r107 = r102.optJSONArray("bypass_boe_path_list");     // Catch: JSONException -> L31
        if (r107 == null) goto L23;
        int r108 = 0;
    L18:
        if (r108 >= r107.length()) goto L23;
        String r109 = r107.optString(r108);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r109) == true) goto L22;
        ((ArrayList) c.f244777f).add(r109);     // Catch: JSONException -> L31
    L22:
        r108 = r108 + 1;     // Catch: JSONException -> L31
    L23:
        JSONArray r110 = r102.optJSONArray("bypass_boe_url_list");     // Catch: JSONException -> L31
        if (r110 == null) goto L45;
    L25:
        if (r104 >= r110.length()) goto L47;
        String r111 = r110.optString(r104);     // Catch: JSONException -> L31
        if (StringUtils.isEmpty(r111) == true) goto L30;
        List<Pattern> r112 = c.f244779h;     // Catch: JSONException -> L31
        ArrayList r113 = (ArrayList) r112;     // Catch: JSONException -> L31
        r113.add(PatternProtector.compile(r111, 2));     // Catch: JSONException -> L31
    L30:
        r104 = r104 + 1;
        goto L25
    L47:
        return;
    L45:
        return;
    L31:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static boolean inCookieHostList(String r100, List<String> r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
    L17:
        return false;
    L5:
        if (Lists.isEmpty(r101) == true) goto L17;
        Iterator<String> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        if (StringUtils.isEmpty(r103) == true) goto L9;
        if (isMatchAllowHost(r100, r103) == false) goto L9;
        return true;
    }

    public static boolean isMatchAllowHost(String r100, String r101) {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        if (r100.equalsIgnoreCase(r101) == false) goto L11;
        return true;
    L11:
        String r102 = r100.toLowerCase();
        if (r101.startsWith(".") == false) goto L16;
        return r102.endsWith(r101.toLowerCase());
    L16:
        return r102.endsWith("." + r101.toLowerCase());
    }

    public static void parseShareCookieHostList(String r100, List<String> r101) {
        if (StringUtils.isEmpty(r100) == true) goto L14;
        if (r101 == null) goto L19;
        String[] r102 = r100.split(",");
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L20;
        String r105 = r102[r104];
        if (StringUtils.isEmpty(r105) == true) goto L13;
        if (inCookieHostList(r105, r101) == true) goto L13;
        r101.add(r105.trim());
    L13:
        r104 = r104 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    public static void safeAddInterceptorInRetrofitCache(g<String, Retrofit> r100, Interceptor r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f() <= 0) goto L30;
        Map<String, Retrofit> r102 = r100.c();
        Collection<Retrofit> r103 = r102.values();
        monitor-enter(r102);
        Iterator<Retrofit> r104 = r103.iterator();     // Catch: Throwable -> L17
    L9:
        if (r104.hasNext() == false) goto L15;
        List<Interceptor> r105 = r104.next().interceptors();     // Catch: Throwable -> L17
        if (r105 == null) goto L9;
        if (r105.contains(r101) == true) goto L9;
        r105.add(r101);     // Catch: Throwable -> L17
        goto L9
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static void safeRemoveInterceptorInRetrofitCache(g<String, Retrofit> r100, Interceptor r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.f() <= 0) goto L26;
        Map<String, Retrofit> r102 = r100.c();
        Collection<Retrofit> r103 = r102.values();
        monitor-enter(r102);
        Iterator<Retrofit> r104 = r103.iterator();     // Catch: Throwable -> L15
    L9:
        if (r104.hasNext() == false) goto L13;
        List<Interceptor> r105 = r104.next().interceptors();     // Catch: Throwable -> L15
        if (r105 == null) goto L9;
        r105.remove(r101);     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102) {
        return registerBroadcastReceiver(r100, r101, r102, null, null, 4);
    }

    public static void setBroadcastReceiverEnabled(Context r100, Class<? extends BroadcastReceiver> r101, boolean r102) {
        if (r102 == false) goto L5;
        int r103 = 1;
    L18:
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (Logger.debug() == false) goto L13;
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L15
        if (r102 == false) goto L11;
        String r105 = "enabling";
    L12:
        r104.append(r105);     // Catch: Throwable -> L15
        r104.append(" connectivity receiver");     // Catch: Throwable -> L15
        Logger.d(LOG_TAG, r104.toString());     // Catch: Throwable -> L15
        goto L13
    L11:
        r105 = "disabling";
    L13:
        r100.getPackageManager().setComponentEnabledSetting(new ComponentName(r100, r101), r103, 1);     // Catch: Throwable -> L15
        return;
    L5:
        r103 = 2;
        goto L18
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, Handler r103) {
        return registerBroadcastReceiver(r100, r101, r102, null, r103, 4);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, int r113) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112, r113);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r113, r111, r112, 5, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112, r113);
    }

    private static Intent registerBroadcastReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r104, int r105) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104, r105);
    L7:
        return INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104);
    }
}
