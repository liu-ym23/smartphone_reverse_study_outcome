package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("base::android")
public class PowerMonitor implements TTLifeCycleMonitor.AppStateListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String CRONET_ACTION_BACK = null;
    private static String CRONET_ACTION_FORE = null;
    private static String CRONET_ACTION_INSTANT_BACK = null;
    private static String CRONET_ACTION_INSTANT_FORE = null;
    private static final String TAG = null;
    private static final long TIME_TO_ENTER_SAME_STATE = 10000;
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static TTLifeCycleMonitor mLifeCycleMonitor;
    private static boolean mListenAppStateIndependently;
    private static PowerMonitor sInstance;
    private static String sPackageName;
    private static long sReceiveBackAction;
    private static long sReceiveForeAction;
    private static AppStateReceiver sReceiver;
    private boolean mIsBatteryPower;

    private PowerMonitor() {
    }

    static {
        TAG = "PowerMonitor";
        mLifeCycleMonitor = new TTLifeCycleMonitor();
    }

    public static void create() {
        if (sInstance == null) goto L5;
        return;
    L5:
        Context r0 = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent r1 = ContextUtils.registerNonExportedBroadcastReceiver(r0, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r1 == null) goto L11;
        boolean r3 = $assertionsDisabled;
        if (r1.getIntExtra("plugged", 0) != 0) goto L10;
        r3 = true;
    L10:
        onBatteryChargingChanged(r3);
    L11:
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r2.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ContextUtils.registerNonExportedBroadcastReceiver(r0, new AnonymousClass1(), r2);
        sPackageName = r0.getPackageName();
        CRONET_ACTION_BACK = sPackageName + ".cronet.APP_BACKGROUND";
        CRONET_ACTION_FORE = sPackageName + ".cronet.APP_FOREGROUND";
        CRONET_ACTION_INSTANT_BACK = sPackageName + ".cronet.APP_INSTANT_BACKGROUND";
        CRONET_ACTION_INSTANT_FORE = sPackageName + ".cronet.APP_INSTANT_FOREGROUND";
        WSCHANNEL_ACTION_BACK = sPackageName + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = sPackageName + ".wschannel.APP_FOREGROUND";
        if (TTProcessUtils.isMainProcess(r0) == true) goto L18;
        if (mListenAppStateIndependently == true) goto L18;
        sReceiver = new AppStateReceiver();
        IntentFilter r4 = new IntentFilter();
        r4.addAction(CRONET_ACTION_BACK);
        r4.addAction(CRONET_ACTION_FORE);
        r4.addAction(CRONET_ACTION_INSTANT_BACK);
        r4.addAction(CRONET_ACTION_INSTANT_FORE);
        r4.addAction(WSCHANNEL_ACTION_BACK);
        r4.addAction(WSCHANNEL_ACTION_FORE);
        ContextUtils.registerNonExportedBroadcastReceiver(r0, sReceiver, r4);
        return;
    L18:
        if ((r0 instanceof Application) == false) goto L22;
        mLifeCycleMonitor.setAppStateChangedListener(sInstance);
        ((Application) r0).registerActivityLifecycleCallbacks(mLifeCycleMonitor);
        PowerMonitorJni.get().onAppInBackgroundChanged(mLifeCycleMonitor.getInitialAppInBackground());
        return;
    }

    public static void createForTests() {
        sInstance = new PowerMonitor();
    }

    private static int getCurrentThermalStatus() {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        return -1;
    L6:
        if (sInstance != null) goto L8;
        create();
    L8:
        PowerManager r0 = (PowerManager) ContextUtils.getApplicationContext().getSystemService("power");
        if (r0 != null) goto L12;
        return -1;
    L12:
        return ApiHelperForQ.getCurrentThermalStatus(r0);
    }

    private static int getRemainingBatteryCapacity() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return getRemainingBatteryCapacityImpl();
    }

    private static boolean isBatteryPower() {
        if (sInstance != null) goto L6;
        create();
    L6:
        return sInstance.mIsBatteryPower;
    }

    public static void mockAppResumeForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onResume();
        return;
    }

    public static void mockAppSuspendForTesting() {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        PowerMonitorJni.get().onSuspend();
        return;
    }

    public void onInstantEnterToBackground() {
        broadcastInstantAppStateInMainProcess(CRONET_ACTION_INSTANT_BACK);
        PowerMonitorJni.get().onInstantSuspend();
    }

    public void onInstantEnterToForeground() {
        broadcastInstantAppStateInMainProcess(CRONET_ACTION_INSTANT_FORE);
        PowerMonitorJni.get().onInstantResume();
    }

    private static int getRemainingBatteryCapacityImpl() {
        return ((BatteryManager) ContextUtils.getApplicationContext().getSystemService("batterymanager")).getIntProperty(1);
    }

    public void onEnterToBackground() {
        Context r0 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r0) == false) goto L11;
        Intent r1 = new Intent();
        r1.setAction(CRONET_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r1.setPackage(sPackageName);
    L13:
        r0.sendBroadcast(r1);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onSuspend();
    }

    public void onEnterToForeground() {
        Context r0 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r0) == false) goto L11;
        Intent r1 = new Intent();
        r1.setAction(CRONET_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r1.setPackage(sPackageName);
    L13:
        r0.sendBroadcast(r1);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onResume();
    }

    public static /* synthetic */ String access$000() {
        return CRONET_ACTION_INSTANT_FORE;
    }

    public static /* synthetic */ String access$100() {
        return CRONET_ACTION_INSTANT_BACK;
    }

    public static /* synthetic */ String access$200() {
        return CRONET_ACTION_FORE;
    }

    public static /* synthetic */ String access$300() {
        return WSCHANNEL_ACTION_FORE;
    }

    public static /* synthetic */ long access$400() {
        return sReceiveForeAction;
    }

    public static /* synthetic */ String access$500() {
        return CRONET_ACTION_BACK;
    }

    public static /* synthetic */ String access$600() {
        return WSCHANNEL_ACTION_BACK;
    }

    public static /* synthetic */ long access$700() {
        return sReceiveBackAction;
    }

    public static /* synthetic */ long access$402(long r0) {
        sReceiveForeAction = r0;
        return r0;
    }

    public static /* synthetic */ long access$702(long r0) {
        sReceiveBackAction = r0;
        return r0;
    }

    public static /* synthetic */ void access$800(boolean r0) {
        onBatteryChargingChanged(r0);
    }

    private static void broadcastInstantAppStateInMainProcess(String r2) {
        Context r0 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r0) == true) goto L5;
        return;
    L5:
        Intent r1 = new Intent();
        r1.setAction(r2);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r1.setPackage(sPackageName);
    L13:
        r0.sendBroadcast(r1);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private static void onBatteryChargingChanged(boolean r1) {
        sInstance.mIsBatteryPower = r1;
        PowerMonitorJni.get().onBatteryChargingChanged();
    }

    public static void setListenAppStateIndependently(boolean r0) {
        mListenAppStateIndependently = r0;
    }
}
