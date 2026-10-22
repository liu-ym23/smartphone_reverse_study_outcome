package com.larus.home.impl.sdk;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.timonkit.api.ITimonKitService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes29.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f346188a = null;

    static {
        f346188a = new i1();
    }

    public i1() {
    }

    public static ClipData c(ClipboardManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    public final void b(Context r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = SystemClock.elapsedRealtime();
        if (AppHost.f326268a.isOversea() == false) goto L37;
        FLogger.f375446a.d("SdkClipboardImpl", "clearPrimaryClip (system) token:bpea-ug-luckydog-sdk-install-task-clipboard-write");
        Object r101 = r210.getSystemService(DataType.CLIPBOARD);
        if ((r101 instanceof ClipboardManager) == false) goto L7;
        ClipboardManager r102 = (ClipboardManager) r101;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L29;
        if (r102 == null) goto L31;
        ArrayList r103 = new ArrayList();
        Object[] r104 = new Object[0];
        f06.b r110 = new f06.b();
        g06.a r105 = ApiHookConfig.f245611b.get(101800);
        if (r105 == null) goto L14;
        f06.a[] r106 = r105.f479473i;
    L15:
        f06.a[] r111 = r106;
        int r112 = r111.length;
        int r113 = 0;
    L17:
        if (r113 >= r112) goto L24;
        f06.a r114 = r111[r113];
        int r211 = r113;
        int r212 = r112;
        f06.a[] r213 = r111;
        f06.d r107 = r114.preInvoke(101800, "android/content/ClipboardManager", "clearPrimaryClip", r102, r104, "void", r110);     // Catch: Exception -> L53
        if (r107.f474982a == true) goto L26;
        r103.add(r114);     // Catch: Exception -> L53
    L26:
        if (r107.f474982a == true) goto L31;
        r102.clearPrimaryClip();
    L23:
        r113 = r211 + 1;
        r112 = r212;
        r111 = r213;
        goto L17
    L24:
        r107 = new f06.d(false, null);
        goto L26
    L14:
        r106 = ApiHookConfig.f245613d;
    L31:
        long r108 = SystemClock.elapsedRealtime() - r100;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("SystemClipboard.clearPrimaryClip token= bpea-ug-luckydog-sdk-install-task-clipboard-write cost=");
        r115.append(r108);
        r115.append("ms clipboardNull=");
        if (r102 != null) goto L34;
        boolean r116 = true;
    L35:
        r115.append(r116);
        r109.i("SdkClipboardImpl", r115.toString());
        return;
    L34:
        r116 = false;
        goto L35
    L29:
        if (r102 == null) goto L31;
        a(r102, ClipData.newPlainText("", ""));
        goto L31
    L7:
        r102 = null;
        goto L9
    L37:
        ITimonKitService r117 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L47
        FLogger r119 = FLogger.f375446a;     // Catch: Throwable -> L47
        r119.d("SdkClipboardImpl", "clearPrimaryClip token:bpea-ug-luckydog-sdk-install-task-clipboard-write");     // Catch: Throwable -> L47
        if (r117 == null) goto L41;
        r117.h("bpea-ug-luckydog-sdk-install-task-clipboard-write");     // Catch: Throwable -> L47
    L41:
        long r120 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L47
        StringBuilder r121 = new StringBuilder("ITimonKitService.clearPrimaryClip token= bpea-ug-luckydog-sdk-install-task-clipboard-write cost=");     // Catch: Throwable -> L47
        r121.append(r120);     // Catch: Throwable -> L47
        r121.append("ms serviceNull=");     // Catch: Throwable -> L47
        if (r117 != null) goto L44;
        boolean r122 = true;
    L45:
        r121.append(r122);     // Catch: Throwable -> L47
        r119.i("SdkClipboardImpl", r121.toString());     // Catch: Throwable -> L47
        Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L61;
        long r125 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.clearPrimaryClip failed after " + r125 + "ms", r124);
        return;
    L61:
        return;
    L44:
        r122 = false;
    L47:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    }

    public final ClipDescription f(Context r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = false;
        Object r102 = null;
        ClipDescription r103 = null;
        if (AppHost.f326268a.isOversea() == false) goto L34;
        Object r104 = r210.getSystemService(DataType.CLIPBOARD);
        if ((r104 instanceof ClipboardManager) == false) goto L7;
        ClipboardManager r105 = (ClipboardManager) r104;
    L8:
        if (r105 == null) goto L28;
        ArrayList r106 = new ArrayList();
        Object[] r107 = new Object[0];
        f06.b r108 = new f06.b();
        g06.a r110 = ApiHookConfig.f245611b.get(101809);
        if (r110 == null) goto L12;
        f06.a[] r111 = r110.f479473i;
    L13:
        f06.a[] r112 = r111;
        int r113 = r112.length;
        int r114 = 0;
    L15:
        if (r114 >= r113) goto L22;
        f06.a r115 = r112[r114];
        int r211 = r114;
        int r212 = r113;
        f06.a[] r213 = r112;
        f06.d r116 = r115.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r105, r107, "android.content.ClipDescription", r108);     // Catch: Exception -> L55
        if (r116.f474982a == true) goto L24;
        r106.add(r115);     // Catch: Exception -> L55
    L24:
        if (r116.f474982a == false) goto L26;
        ClipDescription r109 = (ClipDescription) r116.f474983b;
    L27:
        r103 = r109;
        goto L28
    L26:
        r109 = r105.getPrimaryClipDescription();
    L21:
        r114 = r211 + 1;
        r113 = r212;
        r112 = r213;
        goto L15
    L22:
        r116 = new f06.d(false, null);
        goto L24
    L12:
        r111 = ApiHookConfig.f245613d;
    L28:
        long r117 = SystemClock.elapsedRealtime() - r100;
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("SystemClipboard.getPrimaryClipDescription scenario= bpea-input-long-press cost=");
        r119.append(r117);
        r119.append("ms clipboardNull=");
        if (r105 != null) goto L31;
        boolean r120 = true;
    L32:
        r119.append(r120);
        r118.i("SdkClipboardImpl", r119.toString());
        return r103;
    L31:
        r120 = false;
        goto L32
    L7:
        r105 = null;
        goto L8
    L34:
        ITimonKitService r121 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L44
        if (r121 == null) goto L38;
        ClipDescription r123 = r121.d("bpea-input-long-press");     // Catch: Throwable -> L44
    L39:
        long r124 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L44
        FLogger r125 = FLogger.f375446a;     // Catch: Throwable -> L44
        StringBuilder r126 = new StringBuilder("ITimonKitService.getPrimaryClipDescription scenario= bpea-input-long-press cost=");     // Catch: Throwable -> L44
        r126.append(r124);     // Catch: Throwable -> L44
        r126.append("ms serviceNull=");     // Catch: Throwable -> L44
        if (r121 != null) goto L42;
        r101 = true;
    L42:
        r126.append(r101);     // Catch: Throwable -> L44
        r125.i("SdkClipboardImpl", r126.toString());     // Catch: Throwable -> L44
        Object r127 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L44
    L46:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r127);
        if (r128 == null) goto L50;
        long r129 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.getPrimaryClipDescription failed after " + r129 + "ms", r128);
    L50:
        if (Result.m9455isFailureimpl(r127) == true) goto L54;
        r102 = r127;
    L54:
        return (ClipDescription) r102;
    L38:
        r123 = null;
    L44:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    }

    public final ClipData g(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = false;
        Object r102 = null;
        ClipData r103 = null;
        if (AppHost.f326268a.isOversea() == false) goto L15;
        FLogger r104 = FLogger.f375446a;
        r104.d("SdkClipboardImpl", "getPrimaryClipWithPattern (system) token:bpea-ug-luckydog-sdk-install-task-clipboard-read");
        Object r111 = r110.getSystemService(DataType.CLIPBOARD);
        if ((r111 instanceof ClipboardManager) == false) goto L7;
        ClipboardManager r112 = (ClipboardManager) r111;
    L8:
        if (r112 == null) goto L10;
        r103 = c(r112);
    L10:
        long r113 = SystemClock.elapsedRealtime() - r100;
        StringBuilder r105 = new StringBuilder("SystemClipboard.getPrimaryClipWithPattern token= bpea-ug-luckydog-sdk-install-task-clipboard-read cost=");
        r105.append(r113);
        r105.append("ms clipboardNull=");
        if (r112 != null) goto L13;
        r101 = true;
    L13:
        r105.append(r101);
        r105.append(" result=");
        r105.append(r103);
        r104.i("SdkClipboardImpl", r105.toString());
        return r103;
    L7:
        r112 = null;
        goto L8
    L15:
        ITimonKitService r114 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L25
        FLogger r107 = FLogger.f375446a;     // Catch: Throwable -> L25
        r107.d("SdkClipboardImpl", "getPrimaryClipWithPattern token:bpea-ug-luckydog-sdk-install-task-clipboard-read");     // Catch: Throwable -> L25
        if (r114 == null) goto L19;
        ClipData r108 = r114.c("bpea-ug-luckydog-sdk-install-task-clipboard-read");     // Catch: Throwable -> L25
    L20:
        long r115 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L25
        StringBuilder r116 = new StringBuilder("ITimonKitService.getPrimaryClipWithPattern token= bpea-ug-luckydog-sdk-install-task-clipboard-read cost=");     // Catch: Throwable -> L25
        r116.append(r115);     // Catch: Throwable -> L25
        r116.append("ms serviceNull=");     // Catch: Throwable -> L25
        if (r114 != null) goto L23;
        r101 = true;
    L23:
        r116.append(r101);     // Catch: Throwable -> L25
        r116.append(" result=");     // Catch: Throwable -> L25
        r116.append(r108);     // Catch: Throwable -> L25
        r107.i("SdkClipboardImpl", r116.toString());     // Catch: Throwable -> L25
        Object r117 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
    L27:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r117);
        if (r109 == null) goto L31;
        long r118 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.getPrimaryClipWithPattern failed after " + r118 + "ms", r109);
    L31:
        if (Result.m9455isFailureimpl(r117) == true) goto L35;
        r102 = r117;
    L35:
        return (ClipData) r102;
    L19:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void a(ClipboardManager r100, ClipData r101) {
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        d(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static void d(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final ClipData e(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = SystemClock.elapsedRealtime();
        boolean r101 = false;
        Object r102 = null;
        ClipData r103 = null;
        if (AppHost.f326268a.isOversea() == false) goto L15;
        Object r112 = r110.getSystemService(DataType.CLIPBOARD);
        if ((r112 instanceof ClipboardManager) == false) goto L7;
        ClipboardManager r113 = (ClipboardManager) r112;
    L8:
        if (r113 == null) goto L10;
        r103 = c(r113);
    L10:
        long r104 = SystemClock.elapsedRealtime() - r100;
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("SystemClipboard.getPrimaryClip scenario= ");
        r106.append(r111);
        r106.append(" cost=");
        r106.append(r104);
        r106.append("ms clipboardNull=");
        if (r113 != null) goto L13;
        r101 = true;
    L13:
        r106.append(r101);
        r105.i("SdkClipboardImpl", r106.toString());
        return r103;
    L7:
        r113 = null;
        goto L8
    L15:
        ITimonKitService r114 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
        if (r114 == null) goto L19;
        ClipData r108 = r114.f(r111);     // Catch: Throwable -> L25
    L20:
        long r109 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L25
        FLogger r115 = FLogger.f375446a;     // Catch: Throwable -> L25
        StringBuilder r116 = new StringBuilder("ITimonKitService.getPrimaryClip scenario= ");     // Catch: Throwable -> L25
        r116.append(r111);     // Catch: Throwable -> L25
        r116.append(" cost=");     // Catch: Throwable -> L25
        r116.append(r109);     // Catch: Throwable -> L25
        r116.append("ms serviceNull=");     // Catch: Throwable -> L25
        if (r114 != null) goto L23;
        r101 = true;
    L23:
        r116.append(r101);     // Catch: Throwable -> L25
        r115.i("SdkClipboardImpl", r116.toString());     // Catch: Throwable -> L25
        Object r117 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
    L27:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L31;
        long r119 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.getPrimaryClip failed after " + r119 + "ms", r118);
    L31:
        if (Result.m9455isFailureimpl(r117) == true) goto L35;
        r102 = r117;
    L35:
        return (ClipData) r102;
    L19:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public final boolean h(Context r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r100 = SystemClock.elapsedRealtime();
        Object r110 = null;
        if (AppHost.f326268a.isOversea() == false) goto L34;
        FLogger.f375446a.d("SdkClipboardImpl", "hasPrimaryClip (system) token:".concat(r211));
        Object r101 = r210.getSystemService(DataType.CLIPBOARD);
        if ((r101 instanceof ClipboardManager) == false) goto L7;
        ClipboardManager r102 = (ClipboardManager) r101;
    L8:
        if (r102 == null) goto L27;
        ArrayList r103 = new ArrayList();
        Object[] r104 = new Object[0];
        f06.b r105 = new f06.b();
        g06.a r111 = ApiHookConfig.f245611b.get(101805);
        if (r111 == null) goto L12;
        f06.a[] r112 = r111.f479473i;
    L13:
        f06.a[] r113 = r112;
        int r114 = r113.length;
        int r115 = 0;
    L15:
        if (r115 >= r114) goto L22;
        f06.a r106 = r113[r115];
        int r212 = r115;
        int r213 = r114;
        f06.a[] r214 = r113;
        f06.d r116 = r106.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r102, r104, "boolean", r105);     // Catch: Exception -> L58
        if (r116.f474982a == true) goto L24;
        r103.add(r106);     // Catch: Exception -> L58
    L24:
        if (r116.f474982a == false) goto L26;
        boolean r107 = ((Boolean) r116.f474983b).booleanValue();
    L28:
        long r108 = SystemClock.elapsedRealtime() - r100;
        FLogger r109 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("SystemClipboard.hasPrimaryClip token= ");
        r117.append(r211);
        r117.append(" cost=");
        r117.append(r108);
        r117.append("ms clipboardNull=");
        if (r102 != null) goto L31;
        boolean r118 = true;
    L32:
        r117.append(r118);
        r117.append(" result=");
        r117.append(r107);
        r109.i("SdkClipboardImpl", r117.toString());
        return r107;
    L31:
        r118 = false;
        goto L32
    L26:
        r107 = r102.hasPrimaryClip();
    L21:
        r115 = r212 + 1;
        r114 = r213;
        r113 = r214;
        goto L15
    L22:
        r116 = new f06.d(false, null);
        goto L24
    L12:
        r112 = ApiHookConfig.f245613d;
        goto L13
    L27:
        r107 = false;
        goto L28
    L7:
        r102 = null;
        goto L8
    L34:
        ITimonKitService r119 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L45
        FLogger r121 = FLogger.f375446a;     // Catch: Throwable -> L45
        r121.d("SdkClipboardImpl", "hasPrimaryClip token:".concat(r211));     // Catch: Throwable -> L45
        if (r119 == null) goto L38;
        boolean r122 = r119.b(r211);     // Catch: Throwable -> L45
    L39:
        long r123 = SystemClock.elapsedRealtime() - r100;     // Catch: Throwable -> L45
        StringBuilder r124 = new StringBuilder("ITimonKitService.hasPrimaryClip token= ");     // Catch: Throwable -> L45
        r124.append(r211);     // Catch: Throwable -> L45
        r124.append(" cost=");     // Catch: Throwable -> L45
        r124.append(r123);     // Catch: Throwable -> L45
        r124.append("ms serviceNull=");     // Catch: Throwable -> L45
        if (r119 != null) goto L42;
        boolean r125 = true;
    L43:
        r124.append(r125);     // Catch: Throwable -> L45
        r124.append(" result=");     // Catch: Throwable -> L45
        r124.append(r122);     // Catch: Throwable -> L45
        r121.i("SdkClipboardImpl", r124.toString());     // Catch: Throwable -> L45
        Object r126 = Result.m9449constructorimpl(Boolean.valueOf(r122));     // Catch: Throwable -> L45
    L47:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L51;
        long r128 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.hasPrimaryClip failed after " + r128 + "ms", r127);
    L51:
        if (Result.m9455isFailureimpl(r126) == true) goto L54;
        r110 = r126;
    L54:
        Boolean r129 = (Boolean) r110;
        if (r129 != null) goto L57;
        return false;
    L57:
        return r129.booleanValue();
    L42:
        r125 = false;
        goto L43
    L38:
        r122 = false;
    L45:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    }

    public final void i(Context r110, ClipData r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "clipData");
        long r100 = SystemClock.elapsedRealtime();
    L23:
        e = move-exception;
        long r113 = SystemClock.elapsedRealtime() - r100;
        FLogger.f375446a.e("SdkClipboardImpl", "ITimonKitService.setPrimaryClip failed after " + r113 + "ms", e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere("clip board error");
        return;
    L5:
        if (AppHost.f326268a.isOversea() == false) goto L18;
        FLogger r101 = FLogger.f375446a;     // Catch: Exception -> L23
        r101.d("SdkClipboardImpl", "setPrimaryClip (system) token:".concat(r112));     // Catch: Exception -> L23
        Object r114 = r110.getSystemService(DataType.CLIPBOARD);     // Catch: Exception -> L23
        if ((r114 instanceof ClipboardManager) == false) goto L9;
        ClipboardManager r115 = (ClipboardManager) r114;     // Catch: Exception -> L23
    L10:
        if (r115 == null) goto L12;
        a(r115, r111);     // Catch: Exception -> L23
    L12:
        long r116 = SystemClock.elapsedRealtime() - r100;     // Catch: Exception -> L23
        StringBuilder r117 = new StringBuilder("SystemClipboard.setPrimaryClip scenario= ");     // Catch: Exception -> L23
        r117.append(r112);     // Catch: Exception -> L23
        r117.append(" cost=");     // Catch: Exception -> L23
        r117.append(r116);     // Catch: Exception -> L23
        r117.append("ms clipboardNull=");     // Catch: Exception -> L23
        if (r115 != null) goto L15;
        boolean r118 = true;
    L16:
        r117.append(r118);     // Catch: Exception -> L23
        r101.i("SdkClipboardImpl", r117.toString());     // Catch: Exception -> L23
        return;
    L15:
        r118 = false;
        goto L16
    L9:
        r115 = null;
        goto L10
    L18:
        FLogger r119 = FLogger.f375446a;     // Catch: Exception -> L23
        r119.d("SdkClipboardImpl", "setPrimaryClip token:".concat(r112));     // Catch: Exception -> L23
        ITimonKitService r102 = (ITimonKitService) ServiceManager.get().getService(ITimonKitService.class);     // Catch: Exception -> L23
        if (r102 == null) goto L21;
        r102.e(r111, r112);     // Catch: Exception -> L23
    L21:
        r119.i("SdkClipboardImpl", "ITimonKitService.setPrimaryClip scenario= " + r112 + " cost=" + (SystemClock.elapsedRealtime() - r100) + "ms");     // Catch: Exception -> L23
    }
}
