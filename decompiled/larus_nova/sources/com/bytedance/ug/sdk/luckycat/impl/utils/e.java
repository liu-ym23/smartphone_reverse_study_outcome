package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
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

    public static ClipDescription d(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r110, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (ClipDescription) r106.f474983b;
    L21:
        return r110.getPrimaryClipDescription();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static boolean e(ClipboardManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(101805);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r110, r111, "boolean", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return ((Boolean) r106.f474983b).booleanValue();
    L21:
        return r110.hasPrimaryClip();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String g(Context r100) {
        com.bytedance.ug.sdk.luckycat.impl.manager.m r101 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        ClipboardManager r102 = (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);
        if (r102 != null) goto L22;
        return "";
    L22:
    L19:
        th = move-exception;
        th.toString();
    L21:
        return "";
    L6:
        if (e(r102) == false) goto L21;
        if (d(r102).hasMimeType("text/plain") == false) goto L10;
    L11:
        ClipData.Item r103 = c(r102).getItemAt(0);     // Catch: Throwable -> L19
        if (r103.getText() != null) goto L14;
        return "";
    L14:
        CharSequence r104 = r103.getText();     // Catch: Throwable -> L19
        if (r104 != null) goto L17;
        return "";
    L17:
        return r104.toString();
    L10:
        if (d(r102).hasMimeType("text/html") == false) goto L21;
        goto L11
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void a(ClipboardManager r100, ClipData r101) {
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        f(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static void b(Context r100, CharSequence r101) {
        com.bytedance.ug.sdk.luckycat.impl.manager.m r102 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L4
        ClipboardManager r103 = (ClipboardManager) r100.getSystemService(DataType.CLIPBOARD);     // Catch: Throwable -> L4
        ClipData r104 = c(r103);     // Catch: Throwable -> L4
        r104.addItem(new ClipData.Item(r101));     // Catch: Throwable -> L4
        a(r103, r104);     // Catch: Throwable -> L4
        return;
    }

    public static void f(ClipboardManager r110, ClipData r111) {
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
}
