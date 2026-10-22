package com.bytedance.ug.sdk.luckydog.task;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AppActivateHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final il7.m f271819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f271820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f271821c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f271822d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f271823e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f271824f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicInteger f271825g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f271826h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f271827i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ServiceConnection> f271828j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f271829k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicBoolean f271830l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f271831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f271832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f271833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f271834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AppActivateHelper$waitImportAppOpenReceiver$1 f271835q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AppActivateHelper$clearTokenReceiver$1 f271836r = null;

    /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.ug.sdk.luckydog.task.AppActivateHelper$waitImportAppOpenReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.ug.sdk.luckydog.task.AppActivateHelper$clearTokenReceiver$1] */
    static {
        il7.m r100 = il7.m.b("luckydog_app_activate_helper_config");
        f271819a = r100;
        Boolean r101 = Boolean.FALSE;
        f271820b = new AtomicBoolean(r100.f("luckydog_cross_has_try_broadcast_path", r101));
        f271821c = new AtomicBoolean(r100.f("luckydog_cross_has_try_clipboard_path", r101));
        f271822d = new AtomicBoolean(false);
        f271823e = new AtomicBoolean(false);
        f271824f = new AtomicBoolean(false);
        f271825g = new AtomicInteger(0);
        f271826h = new AtomicInteger(0);
        f271827i = new ConcurrentHashMap();
        f271828j = new ConcurrentHashMap();
        f271829k = new AtomicBoolean(false);
        f271830l = new AtomicBoolean(false);
        f271835q = new AppActivateHelper$waitImportAppOpenReceiver$1();
        f271836r = new AppActivateHelper$clearTokenReceiver$1();
    }

    public static void e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L36
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "doWhenFirstLaunch onCall");     // Catch: Throwable -> L36
        if (f271822d.get() == true) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "隐私未同意 不发送广播或读剪切板");     // Catch: Throwable -> L36
        f271823e.set(true);     // Catch: Throwable -> L36
        return;
    L7:
        AtomicInteger r101 = f271826h;     // Catch: Throwable -> L36
        if (r101.get() == 0) goto L10;
    L13:
        rk7.m r102 = rk7.m.f538361o;     // Catch: Throwable -> L36
        rk7.m.n();     // Catch: Throwable -> L36
        if (r101.get() <= 0) goto L29;
        AtomicBoolean r103 = f271820b;     // Catch: Throwable -> L36
        if (r103.get() == true) goto L27;
        Context r104 = r102.e();     // Catch: Throwable -> L36
        if (r104 == null) goto L26;
        String r105 = String.valueOf(rk7.m.f());     // Catch: Throwable -> L36
        Intent r106 = new Intent();     // Catch: Throwable -> L36
        r106.setAction("com.bytedance.luckydog.crossover.launch");     // Catch: Throwable -> L36
        r106.putExtra("importer_aid", r105);     // Catch: Throwable -> L36
        Context r107 = r102.e();     // Catch: Throwable -> L36
        if (r107 == null) goto L24;
        String r108 = r107.getPackageName();     // Catch: Throwable -> L36
        if (r108 == null) goto L24;
    L25:
        r106.putExtra("importer_pkg_name", r108);     // Catch: Throwable -> L36
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + r105 + "] send LAUNCH broadcast");     // Catch: Throwable -> L36
        j("case_cross_broadcast_opt", true);     // Catch: Throwable -> L36
        r104.sendBroadcast(r106);     // Catch: Throwable -> L36
        f271819a.l("luckydog_cross_has_try_broadcast_path", true);     // Catch: Throwable -> L36
        r103.set(true);     // Catch: Throwable -> L36
    L24:
        r108 = "";
        goto L25
    L26:
        return;
    L27:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "has try broadcast path, not send");     // Catch: Throwable -> L36
    L29:
        if (f271825g.get() <= 0) goto L34;
        AtomicBoolean r109 = f271821c;     // Catch: Throwable -> L36
        if (r109.get() == true) goto L33;
        c.e.f271882a.b();     // Catch: Throwable -> L36
        f271819a.l("luckydog_cross_has_try_clipboard_path", true);     // Catch: Throwable -> L36
        r109.set(true);     // Catch: Throwable -> L36
        goto L34
    L33:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "has try clipboard path, not read");     // Catch: Throwable -> L36
    L34:
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L43;
        i("doWhenFirstLaunch", r111);
        return;
    L43:
        return;
    L10:
        if (f271825g.get() != 0) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "settings未返回 不发送广播或读剪切板");     // Catch: Throwable -> L36
        f271824f.set(true);     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    }

    public static void d(String r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "点击去打开, aid:" + r100);
        rk7.m r101 = rk7.m.f538361o;
        String r102 = String.valueOf(rk7.m.f());
        Context r103 = r101.e();
        if (r103 == null) goto L15;
        ConcurrentHashMap<String, ServiceConnection> r104 = f271828j;
        if (r104.keySet().contains(r100) == false) goto L10;
        ServiceConnection r105 = r104.get(r100);
        if (r105 == null) goto L9;
        r103.unbindService(r105);
    L9:
        r104.remove(r100);
    L10:
        ConcurrentHashMap<String, String> r106 = f271827i;
        if (r106.keySet().contains(r100) == false) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "remove map, key: [" + r100 + ']');
        r106.remove(r100);
    L13:
        Intent r107 = new Intent();
        r107.setAction("com.bytedance.luckydog.crossover.clear");
        r107.putExtra("exporter_aid", r102);
        r107.putExtra("importer_aid", r100);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + r102 + "] send CLEAR broadcast");
        r103.sendBroadcast(r107);
        return;
    }

    public static void f(Bundle r100) {
        Application r101 = rk7.m.f538347a;
        String r102 = String.valueOf(rk7.m.f());
        String r103 = r100.getString("token");
        String r104 = r100.getString("exporter_aid");
        if (r104 == null) goto L5;
        String r105 = r104;
    L6:
        g("receive_token", r105, r102);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + r102 + "] receiver tokenInfo from [" + r104 + "], obj: " + r100 + ", token: [" + r103 + "], ready to request re_ack install");
        if (TextUtils.isEmpty(r103) == true) goto L28;
        j("case_cross_broadcast_opt", false);
        c r106 = c.e.f271882a;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", String.format("tryReportAppActivateFromLaunchOpt() on call; mIsReportedReackInstall = %b, crossToken = %s mIsPrivacyOk = %b, isReTry = %b, currentThread = %s", new Object[]{Boolean.valueOf(r106.f271851b), r103, Boolean.valueOf(r106.f271854e), Boolean.FALSE, ThreadMethodProxy.currentThread().getName()}));
        if (TextUtils.isEmpty(r103) == false) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", "crossToken is empty, not request reack install");
    L12:
        if (r106.f271851b == false) goto L15;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", "mIsReportedReackInstall is true, not request reack install");
        rk7.n r107 = rk7.n.f538362b;
        bl7.c.a();
        r107.getClass();
        rk7.n.a();
        return;
    L15:
        if (r106.f271852c == false) goto L18;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", "reack install has requested by other path, not request reack install");
        return;
    L18:
        if (r106.c() == false) goto L21;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", "handleDIdEmpty return true, not request reack install");
        return;
    L21:
        if (r106.f271858i == false) goto L23;
    L26:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateManager", "other path is requesting reack install, not request reack install");
        return;
    L23:
        if (r106.f271860k != null) goto L26;
        r106.e(r103, "", false, "case_cross_broadcast_opt");
        return;
    L28:
        return;
    L5:
        r105 = "";
        goto L6
    }

    public static void h(String r100) {
        int r101 = r100.hashCode();
        if (r101 == (-1986360516)) goto L15;
        if (r101 == 1122044135) goto L8;
    L21:
        long r102 = 0;
        long r103 = 0;
        long r104 = 0;
    L23:
        if (r104 > 0) goto L30;
        return;
    L30:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "report time elapse event, path: " + r100 + ", startTime: " + r102 + ", endTime: " + r103 + ", elapse: " + r104 + "ms");     // Catch: Throwable -> L27
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L27
        r105.put("path_name", r100);     // Catch: Throwable -> L27
        r105.put("path_start", String.valueOf(r102));     // Catch: Throwable -> L27
        r105.put("path_end", String.valueOf(r103));     // Catch: Throwable -> L27
        r105.put("path_elapse", String.valueOf(r104));     // Catch: Throwable -> L27
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_crossover_opt_time_elapse", r105);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        th.getLocalizedMessage();
        return;
    L8:
        if (r100.equals("case_cross_broadcast_opt") == false) goto L21;
        r102 = f271833o;
        if (r102 == 0) goto L21;
        r103 = f271834p;
        if (r103 == 0) goto L21;
    L20:
        r104 = r103 - r102;
        goto L23
    L15:
        if (r100.equals("case_cross_clipboard_opt") == false) goto L21;
        r102 = f271831m;
        if (r102 == 0) goto L21;
        r103 = f271832n;
        if (r103 == 0) goto L21;
        goto L20
    }

    public static void c(String r110, String r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "点击去下载, aid: " + r110);
        Context r100 = rk7.m.f538361o.e();
        if (r100 == null) goto L23;
        String r101 = String.valueOf(rk7.m.f());
        if ((!Intrinsics.areEqual(r110, r101)) == false) goto L7;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "save map: [" + r110 + "] --> [" + r111 + ']');
        f271827i.put(r110, r111);
    L7:
        AtomicBoolean r112 = f271829k;
        if (r112.get() == true) goto L14;
        IntentFilter r102 = new IntentFilter();
        r102.addAction("com.bytedance.luckydog.crossover.launch");
        if (Build.VERSION.SDK_INT < 34) goto L12;
        a(r100, f271835q, r102);
    L13:
        r112.set(true);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + r101 + "] register LAUNCH receiver complete");
        goto L14
    L12:
        b(r100, f271835q, r102);
    L14:
        AtomicBoolean r113 = f271830l;
        if (r113.get() == true) goto L21;
        IntentFilter r103 = new IntentFilter();
        r103.addAction("com.bytedance.luckydog.crossover.clear");
        if (Build.VERSION.SDK_INT < 34) goto L19;
        a(r100, f271836r, r103);
    L20:
        r113.set(true);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + r101 + "] register CLEAR receiver complete");
        goto L21
    L19:
        b(r100, f271836r, r103);
    L21:
        Intent r114 = new Intent();
        r114.setAction("com.bytedance.luckydog.crossover.clear");
        r114.putExtra("exporter_aid", r101);
        r114.putExtra("importer_aid", r110);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "exporter: [" + r101 + "] send CLEAR broadcast, importer aid: [" + r110 + ']');
        r100.sendBroadcast(r114);
        return;
    }

    public static void i(String r100, Throwable r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.ug.sdk.luckydog.api.log.d.c("AppActivateHelper", "methodName: " + r100 + ", message: " + r101.getLocalizedMessage(), r101);     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L5
        r103.put("method_name", r100);     // Catch: Throwable -> L5
        r103.put("local_message", r101.getLocalizedMessage());     // Catch: Throwable -> L5
        r103.put("message", r101.getMessage());     // Catch: Throwable -> L5
        com.bytedance.ug.sdk.luckydog.api.log.e.a("luckydog_cross_over_exception", r103, null);     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Result.m9452exceptionOrNullimpl(r104);
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void j(String r100, boolean r101) {
        long r102 = SystemClock.elapsedRealtime();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "tagOptPathMillstone onCall, path: " + r100 + ", isStart: " + r101 + ", time: " + r102);
        int r103 = r100.hashCode();
        if (r103 == (-1986360516)) goto L13;
        if (r103 == 1122044135) goto L8;
        return;
    L8:
        if (r100.equals("case_cross_broadcast_opt") == false) goto L18;
        if (r101 == false) goto L11;
        f271833o = r102;
        return;
    L11:
        f271834p = r102;
        h("case_cross_broadcast_opt");
        return;
    L18:
        return;
    L13:
        if (r100.equals("case_cross_clipboard_opt") == false) goto L21;
        if (r101 == false) goto L16;
        f271831m = r102;
        return;
    L16:
        f271832n = r102;
        h("case_cross_clipboard_opt");
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, BroadcastReceiver r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 2);
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 2, null, null, 3, r100).result;     // Catch: Exception -> L33
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r101 == 3) goto L40;
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L19:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public static void g(String r100, String r101, String r102) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "report broadcast path stage, stage: " + r100 + ", exporterAid: " + r101 + ", importerAid: " + r102);     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L5
        r103.put("stage", r100);     // Catch: Throwable -> L5
        r103.put("exporter_aid", r101);     // Catch: Throwable -> L5
        r103.put("importer_aid", r102);     // Catch: Throwable -> L5
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_activation_broadcast", r103);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.getLocalizedMessage();
    }
}
