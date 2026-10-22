package com.ttnet.org.chromium.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes6.dex */
    public static class AppStateReceiver extends BroadcastReceiver {
        public AppStateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            long r102 = System.currentTimeMillis();
            String r103 = r101.getAction();
            if (r103.equals(PowerMonitor.access$000()) == false) goto L6;
            PowerMonitorJni.get().onInstantResume();
            return;
        L6:
            if (r103.equals(PowerMonitor.access$100()) == false) goto L9;
            PowerMonitorJni.get().onInstantSuspend();
            return;
        L9:
            if (r103.equals(PowerMonitor.access$200()) == false) goto L11;
        L20:
            long r104 = r102 - PowerMonitor.access$400();
            PowerMonitor.access$402(r102);
            if (r104 <= 10000) goto L29;
            PowerMonitorJni.get().onResume();
            return;
        L29:
            return;
        L11:
            if (r103.equals(PowerMonitor.access$300()) == true) goto L20;
            if (r103.equals(PowerMonitor.access$500()) == false) goto L16;
        L17:
            long r105 = r102 - PowerMonitor.access$700();
            PowerMonitor.access$702(r102);
            if (r105 <= 10000) goto L27;
            PowerMonitorJni.get().onSuspend();
            return;
        L27:
            return;
        L16:
            if (r103.equals(PowerMonitor.access$600()) == true) goto L17;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        void onAppInBackgroundChanged(boolean r100);

        void onBatteryChargingChanged();

        void onInstantResume();

        void onInstantSuspend();

        void onResume();

        void onSuspend();

        void onThermalStatusChanged(int r100);
    }

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
        Context r100 = ContextUtils.getApplicationContext();
        sInstance = new PowerMonitor();
        Intent r101 = ContextUtils.registerNonExportedBroadcastReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r101 == null) goto L11;
        boolean r102 = false;
        if (r101.getIntExtra("plugged", 0) != 0) goto L10;
        r102 = true;
    L10:
        onBatteryChargingChanged(r102);
    L11:
        IntentFilter r103 = new IntentFilter();
        r103.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r103.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ContextUtils.registerNonExportedBroadcastReceiver(r100, new AnonymousClass1(), r103);
        sPackageName = r100.getPackageName();
        CRONET_ACTION_BACK = sPackageName + ".cronet.APP_BACKGROUND";
        CRONET_ACTION_FORE = sPackageName + ".cronet.APP_FOREGROUND";
        CRONET_ACTION_INSTANT_BACK = sPackageName + ".cronet.APP_INSTANT_BACKGROUND";
        CRONET_ACTION_INSTANT_FORE = sPackageName + ".cronet.APP_INSTANT_FOREGROUND";
        WSCHANNEL_ACTION_BACK = sPackageName + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = sPackageName + ".wschannel.APP_FOREGROUND";
        if (TTProcessUtils.isMainProcess(r100) == true) goto L18;
        if (mListenAppStateIndependently == true) goto L18;
        sReceiver = new AppStateReceiver();
        IntentFilter r104 = new IntentFilter();
        r104.addAction(CRONET_ACTION_BACK);
        r104.addAction(CRONET_ACTION_FORE);
        r104.addAction(CRONET_ACTION_INSTANT_BACK);
        r104.addAction(CRONET_ACTION_INSTANT_FORE);
        r104.addAction(WSCHANNEL_ACTION_BACK);
        r104.addAction(WSCHANNEL_ACTION_FORE);
        ContextUtils.registerNonExportedBroadcastReceiver(r100, sReceiver, r104);
        return;
    L18:
        if ((r100 instanceof Application) == false) goto L22;
        mLifeCycleMonitor.setAppStateChangedListener(sInstance);
        ((Application) r100).registerActivityLifecycleCallbacks(mLifeCycleMonitor);
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
        PowerManager r100 = (PowerManager) ContextUtils.getApplicationContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r100 != null) goto L12;
        return -1;
    L12:
        return ApiHelperForQ.getCurrentThermalStatus(r100);
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

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToBackground() {
        broadcastInstantAppStateInMainProcess(CRONET_ACTION_INSTANT_BACK);
        PowerMonitorJni.get().onInstantSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onInstantEnterToForeground() {
        broadcastInstantAppStateInMainProcess(CRONET_ACTION_INSTANT_FORE);
        PowerMonitorJni.get().onInstantResume();
    }

    private static int getRemainingBatteryCapacityImpl() {
        return ((BatteryManager) ContextUtils.getApplicationContext().getSystemService("batterymanager")).getIntProperty(1);
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
        Context r100 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r100) == false) goto L11;
        Intent r101 = new Intent();
        r101.setAction(CRONET_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r101.setPackage(sPackageName);
    L13:
        r100.sendBroadcast(r101);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        PowerMonitorJni.get().onSuspend();
    }

    @Override // com.ttnet.org.chromium.base.TTLifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        Context r100 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r100) == false) goto L11;
        Intent r101 = new Intent();
        r101.setAction(CRONET_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r101.setPackage(sPackageName);
    L13:
        r100.sendBroadcast(r101);     // Catch: Exception -> L9
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

    public static /* synthetic */ long access$402(long r100) {
        sReceiveForeAction = r100;
        return r100;
    }

    public static /* synthetic */ long access$702(long r100) {
        sReceiveBackAction = r100;
        return r100;
    }

    public static /* synthetic */ void access$800(boolean r100) {
        onBatteryChargingChanged(r100);
    }

    private static void broadcastInstantAppStateInMainProcess(String r100) {
        Context r101 = ContextUtils.getApplicationContext();
        if (TTProcessUtils.isMainProcess(r101) == true) goto L5;
        return;
    L5:
        Intent r102 = new Intent();
        r102.setAction(r100);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r102.setPackage(sPackageName);
    L13:
        r101.sendBroadcast(r102);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    private static void onBatteryChargingChanged(boolean r100) {
        sInstance.mIsBatteryPower = r100;
        PowerMonitorJni.get().onBatteryChargingChanged();
    }

    public static void setListenAppStateIndependently(boolean r100) {
        mListenAppStateIndependently = r100;
    }
}
