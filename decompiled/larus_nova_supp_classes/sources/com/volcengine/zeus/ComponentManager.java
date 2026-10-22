package com.volcengine.zeus;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.activity.IntentUtils;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.PluginManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.util.MethodUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqc.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ComponentManager {
    public static HashMap<String, List<String>> stubActivity2TargetActivities;
    public static HashMap<String, String> targetString2PluginPkgName;
    public static HashMap<String, String> targetString2StubActivity;

    public ComponentManager() {
    }

    static {
        stubActivity2TargetActivities = new HashMap();
        targetString2StubActivity = new HashMap();
        targetString2PluginPkgName = new HashMap();
    }

    public static String getTargetStubActivityString(String r1) {
        return targetString2StubActivity.get(r1);
    }

    private static boolean isSupportLibIso(String r1) {
        return PluginManager.getInstance().getPlugin(r1).mIsSupportLibIso;
    L4:
        return false;
    }

    public static void unregisterReceiver(Context r1, PluginBroadcastReceiver r2) {
        if (r2 == null) goto L5;
        iqc.b.c().unregisterReceiver(r1, r2);
        return;
    }

    public static void registerActivity(String r9, String r10, String... r11) {
        if (r11 == null) goto L16;
        int r0 = r11.length;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L21;
        String r3 = r11[r2];
        String r4 = targetString2PluginPkgName.get(r3);
        if (r4 != null) goto L8;
    L12:
        List<String> r5 = stubActivity2TargetActivities.get(r10);
        if (r5 != null) goto L15;
        r5 = new ArrayList();
        stubActivity2TargetActivities.put(r10, r5);
    L15:
        r5.add(r3);
        targetString2StubActivity.put(r3, r10);
        targetString2PluginPkgName.put(r3, r9);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, String.format("registerActivity %s -> %s, package=%s, thread=%s", new Object[]{r3, r10, r9, ThreadMethodProxy.currentThread().getName()}));
        r2 = r2 + 1;
        goto L4
    L8:
        if (TextUtils.equals(r4, r9) == false) goto L12;
        throw new RuntimeException(String.format("%s is repeated in %s and %s", new Object[]{r3, r9, r4}));
    L21:
        return;
    }

    public static void startActivity(Context r1, Intent r2, String r3) {
        realStartActivity(null, r1, r2, null, r3);
    }

    public static Intent registerReceiver(Context r1, PluginBroadcastReceiver r2, IntentFilter r3, String r4) {
        return iqc.b.c().registerReceiver(r1, r2, r3, r4);
    }

    public static void startActivity(Object r3, Intent r4, Bundle r5, String r6) {
        if ((r3 instanceof Context) == false) goto L6;
        realStartActivity(null, (Context) r3, r4, r5, r6);
        return;
    L6:
        if (isSupportLibIso(r6) == true) goto L11;
        if ((r3 instanceof Fragment) == false) goto L11;
        realStartActivity(r3, ((Fragment) r3).getActivity(), r4, r5, r6);
        return;
    L11:
        if ((r3 instanceof android.app.Fragment) == false) goto L18;
        realStartActivity(r3, ((android.app.Fragment) r3).getActivity(), r4, r5, r6);
        return;
    L18:
        MethodUtils.invokeMethod(r3, "startActivity", new Object[]{r4, r5}, new Class[]{Intent.class, Bundle.class});     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public static void startActivity(Context r1, Intent r2, Bundle r3, String r4) {
        realStartActivity(null, r1, r2, r3, r4);
    }

    public static void realStartActivity(Object r3, Context r4, Intent r5, Bundle r6, String r7) {
        ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, String.format("startActivity %s, package=%s, thread=%s", new Object[]{r5.getComponent(), r7, ThreadMethodProxy.currentThread().getName()}));
        if ((r4 instanceof PluginContext) == false) goto L6;
        r4 = ((PluginContext) r4).mOriginContext;
    L6:
        if (r5.getComponent() == null) goto L23;
        String r0 = r5.getComponent().getClassName();
        Zeus.loadPlugin(r7);
        String r1 = getTargetStubActivityString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L23;
        IntentUtils.a(r5, r7);
        r5.setComponent(new ComponentName(r4, r1));
        r5.putExtra("targetPlugin", r0);
        r5.putExtra("targetPlugin_signature", j.f.a(r0));
    L23:
    L20:
        th = move-exception;
        throw new RuntimeException("component = " + r5.getComponent(), th);
    L11:
        if (isSupportLibIso(r7) == true) goto L16;
        if ((r3 instanceof Fragment) == false) goto L16;
        ((Fragment) r3).startActivity(r5, r6);     // Catch: Throwable -> L20
        return;
    L16:
        if ((r3 instanceof android.app.Fragment) == false) goto L18;
        ((android.app.Fragment) r3).startActivity(r5, r6);     // Catch: Throwable -> L20
        return;
    L18:
        r4.startActivity(r5, r6);     // Catch: Throwable -> L20
    }

    public static Intent registerReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, int r9, String r10) {
        return iqc.b.c().registerReceiver(r6, r7, r8, r9, r10);
    }

    public static void startActivityForResult(Object r7, Intent r8, int r9, Bundle r10, String r11) {
        if ((r7 instanceof Activity) == false) goto L6;
        realStartActivityForResult(null, (Activity) r7, r8, r9, null, r11);
        return;
    L6:
        if (isSupportLibIso(r11) == true) goto L11;
        if ((r7 instanceof Fragment) == false) goto L11;
        realStartActivityForResult(r7, ((Fragment) r7).getActivity(), r8, r9, null, r11);
        return;
    L11:
        if ((r7 instanceof android.app.Fragment) == false) goto L18;
        realStartActivityForResult(r7, ((android.app.Fragment) r7).getActivity(), r8, r9, null, r11);
        return;
    L18:
        MethodUtils.invokeMethod(r7, "startActivityForResult", new Object[]{r8, Integer.valueOf(r9), r10}, new Class[]{Intent.class, Integer.TYPE, Bundle.class});     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public static void startActivityForResult(Activity r6, Intent r7, int r8, Bundle r9, String r10) {
        realStartActivityForResult(null, r6, r7, r8, r9, r10);
    }

    private static void realStartActivityForResult(Object r3, Activity r4, Intent r5, int r6, Bundle r7, String r8) {
        if (r5.getComponent() == null) goto L20;
        String r0 = r5.getComponent().getClassName();
        Zeus.loadPlugin(r8);
        String r1 = getTargetStubActivityString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L20;
        IntentUtils.a(r5, r8);
        r5.setComponent(new ComponentName(r4, r1));
        r5.putExtra("targetPlugin", r0);
        r5.putExtra("targetPlugin_signature", j.f.a(r0));
    L20:
    L17:
        th = move-exception;
        throw new RuntimeException("component =  " + r5.getComponent(), th);
    L8:
        if (isSupportLibIso(r8) == true) goto L13;
        if ((r3 instanceof Fragment) == false) goto L13;
        ((Fragment) r3).startActivityForResult(r5, r6, r7);     // Catch: Throwable -> L17
        return;
    L13:
        if ((r3 instanceof android.app.Fragment) == false) goto L15;
        ((android.app.Fragment) r3).startActivityForResult(r5, r6, r7);     // Catch: Throwable -> L17
        return;
    L15:
        r4.startActivityForResult(r5, r6, r7);     // Catch: Throwable -> L17
    }

    public static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, String r12) {
        return iqc.b.c().registerReceiver(r7, r8, r9, r10, r11, r12);
    }

    public static Intent registerReceiver(Context r8, PluginBroadcastReceiver r9, IntentFilter r10, String r11, Handler r12, int r13, String r14) {
        return iqc.b.c().registerReceiver(r8, r9, r10, r11, r12, r13, r14);
    }
}
