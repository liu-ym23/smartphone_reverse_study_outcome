package com.ss.ttvideoengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.KryptonCamera;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class TTNetWorkListener extends BroadcastReceiver {
    public static final int ACCESS_STRENGTH_EXCELLENT = 4;
    public static final int ACCESS_STRENGTH_GOOD = 3;
    public static final int ACCESS_STRENGTH_MEDIUM = 2;
    public static final int ACCESS_STRENGTH_UNKNOWN = 10;
    public static final int ACCESS_STRENGTH_WEAK = 1;
    public static final int ACCESS_TYPE_2G = 2;
    public static final int ACCESS_TYPE_3G = 3;
    public static final int ACCESS_TYPE_4G = 1;
    public static final int ACCESS_TYPE_5G = 4;
    public static final int ACCESS_TYPE_DISCONNECT = -1;
    public static final int ACCESS_TYPE_MOBILE = 6;
    public static final int ACCESS_TYPE_UNKNOWN = 1000;
    public static final int ACCESS_TYPE_WIFI = 0;
    public static final int CALLBACK_NETWORK_TYPE = 0;
    public static final int CALLBACK_SIGNAL_STRENGTH = 1;
    public static final int NETWORK_LISTENER_KEY_LEVEL_CODE_MAP = 5;
    public static final int NETWORK_LISTENER_KEY_NET_LEVEL_MAX_COUNT = 1;
    public static final int NETWORK_LISTENER_KEY_RTT_CODE_MAP = 3;
    public static final int NETWORK_LISTENER_KEY_SIG_CODE_MAP = 4;
    public static final int NETWORK_LISTENER_KEY_TIMER_TASK_INTERVAL = 2;
    private static final String TAG = "TTNetWorkListener";
    private static TTNetWorkListener mInst;
    private int mCurrentAccessStrength;
    private int mCurrentAccessType;
    private int mInited;
    private boolean mIsWifiSensitiveMode;
    private CopyOnWriteArrayList<WeakReference<TTNetworkStateCallback>> mListeners;
    private Lock mLock;
    private TTPhoneStateListener mPhoneStateListener;
    private Thread mThread;

    public static class MyThread extends PthreadThreadV2 {
        private WeakReference<Context> mContextRef;
        private WeakReference<TTNetWorkListener> mTTNetworkListener;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_TTNetWorkListener$MyThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_TTNetWorkListener$MyThread__run$___twin___() {
            if (Looper.myLooper() != null) goto L5;
            Looper.prepare();
        L5:
            int r100 = TTVideoEngineUtils.getSensitiveScene();
            if (r100 != 1) goto L8;
        L12:
            TTNetWorkListener.access$302(TTNetWorkListener.getInstance(), true);
            TTVideoEngineLog.i(TTNetWorkListener.TAG, "is wifi sensitive mode:" + r100);
        L13:
            TTNetWorkListener.getInstance().registerListener(this.mContextRef.get());
            Looper.loop();
            TTNetWorkListener r101 = this.mTTNetworkListener.get();
            if (r101 == null) goto L17;
            r101.unregisterListener(this.mContextRef.get());
            return;
        L17:
            return;
        L8:
            if (r100 == 2) goto L12;
            if (r100 == 3) goto L12;
            goto L12
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_TTNetWorkListener$MyThread_com_larus_apm_impl_protector_RunnableLancet_run(MyThread r100) {
            r100.com_ss_ttvideoengine_TTNetWorkListener$MyThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public MyThread(Context r100, TTNetWorkListener r101) {
            super("TTNetWorkListener$MyThread");
            this.mContextRef = new WeakReference(r100.getApplicationContext());
            this.mTTNetworkListener = new WeakReference(r101);
        }
    }

    public static class TTPhoneStateListener extends PhoneStateListener {
        private WeakReference<TTNetWorkListener> mHandler;
        private TelephonyManager mTelephonyManager;

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r100) {
            super.onSignalStrengthsChanged(r100);
            if (r100 != null) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 23) goto L26;
            WeakReference<TTNetWorkListener> r101 = this.mHandler;
            if (r101 == null) goto L10;
            TTNetWorkListener r102 = r101.get();
        L11:
            if (r102 != null) goto L13;
        L22:
            int r103 = r100.getLevel();     // Catch: Exception -> L18
            if (r103 != 0) goto L19;
            r103 = 1;
        L19:
            if (r102 == null) goto L25;
            TTNetWorkListener.access$200(r102, r103);
            return;
        L25:
            return;
        L18:
            TTVideoEngineLog.e(TTNetWorkListener.TAG, "failed to get signalStrength");
            r103 = -1;
            goto L19
        L13:
            if (TTNetWorkListener.access$000(r102) != 0) goto L22;
            return;
        L10:
            r102 = null;
            goto L11
        }

        public void register(Context r100) {
            if (this.mTelephonyManager != null) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT >= 23) goto L11;
        L9:
            listenCompact(r100, this, 64);
            return;
        L11:
            TTVideoEngineLog.d(TTNetWorkListener.TAG, "start listen signal strength");     // Catch: Exception -> L8
            listenCompact(r100, this, 256);     // Catch: Exception -> L8
        L8:
            TTVideoEngineLog.e(TTNetWorkListener.TAG, "listen signal strength failed");
            goto L9
        }

        public void unregister(Context r100) {
            if (this.mTelephonyManager == null) goto L6;
            listenCompact(r100, this, 0);
            return;
        }

        public TTPhoneStateListener(Context r100, TTNetWorkListener r101) {
            this.mTelephonyManager = null;
            this.mHandler = null;
            if (r101 == null) goto L12;
            this.mHandler = new WeakReference(r101);
        L12:
            TelephonyManager r102 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Exception -> L10
            if (r102 != null) goto L8;
            return;
        L8:
            this.mTelephonyManager = r102;     // Catch: Exception -> L10
            return;
        L10:
            TTVideoEngineLog.e(TTNetWorkListener.TAG, "create telephonyManager failed");
            this.mTelephonyManager = null;
        }

        private static int com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission(Context r110, String r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b("auto_cert_com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission");
            g06.a r102 = ApiHookConfig.f245611b.get(102608);
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
            f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Integer) r107.f474983b).intValue();
        L21:
            return r110.checkSelfPermission(r111);
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

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int r100, int r101) {
            super.onDataConnectionStateChanged(r100, r101);
            TTVideoEngineLog.d(TTNetWorkListener.TAG, "data connection state changed, state: " + r100 + ", networkType: " + r101);
            if (r100 != 2) goto L12;
            WeakReference<TTNetWorkListener> r102 = this.mHandler;
            if (r102 == null) goto L13;
            TTNetWorkListener r103 = r102.get();
            if (r103 != null) goto L9;
            return;
        L9:
            if (TTNetWorkListener.access$000(r103) == 0) goto L15;
            TTNetWorkListener.access$100(r103, r101);
            return;
        L15:
            return;
        L13:
            return;
        }

        private void listenCompact(Context r100, PhoneStateListener r101, int r102) {
            TelephonyManager r103 = this.mTelephonyManager;
            if (r103 == null) goto L13;
            if (r100 != null) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT >= 31) goto L9;
            r103.listen(r101, r102);
            return;
        L9:
            if (com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") != 0) goto L14;
            this.mTelephonyManager.listen(r101, r102);
            return;
        L14:
            return;
        }
    }

    private static int convertNetworkType(int r100) {
        if (r100 == 20) goto L13;
        switch(r100) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L9;
            case 10: goto L9;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L5;
        };
    L5:
        return 6;
    L7:
        return 1;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 4;
    }

    public static synchronized TTNetWorkListener getInstance() {
        monitor-enter(TTNetWorkListener.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInst != null) goto L7;
        mInst = new TTNetWorkListener();     // Catch: Throwable -> L10
    L7:
        TTNetWorkListener r100 = mInst;     // Catch: Throwable -> L10
        monitor-exit(TTNetWorkListener.class);
        return r100;
    }

    public String getSignalStrength() {
        if (this.mCurrentAccessType != 1000) goto L5;
        return "unknown";
    L5:
        int r100 = this.mCurrentAccessStrength;
        if (r100 != 1) goto L8;
        return "weak";
    L8:
        if (r100 != 2) goto L10;
        return KryptonCamera.Config.RESOLUTION_MEDIUM;
    L10:
        if (r100 != 3) goto L12;
        return "good";
    L12:
        if (r100 == 4) goto L14;
        return "unknown";
    L14:
        return "excellent";
    }

    private TTNetWorkListener() {
        this.mCurrentAccessType = 1000;
        this.mCurrentAccessStrength = 10;
        this.mLock = new ReentrantLock();
        this.mListeners = new CopyOnWriteArrayList();
        this.mInited = 0;
        this.mPhoneStateListener = null;
        this.mIsWifiSensitiveMode = false;
    }

    public int getCurrentAccessStrength() {
        return this.mCurrentAccessStrength;
    }

    public int getCurrentAccessType() {
        return this.mCurrentAccessType;
    }

    private void _handleNetworkChange(int r100) {
        int r101 = convertNetworkType(r100);
        TTVideoEngineLog.d(TAG, "network change to: " + r101);
        updateAccessType(r101);
    }

    private void _handleSigStrengthChange(int r100) {
        if (r100 == this.mCurrentAccessStrength) goto L22;
        this.mLock.lock();
        int r101 = this.mCurrentAccessStrength;
        this.mCurrentAccessStrength = r100;
        TTVideoEngineLog.i(TAG, "strength changed, from: " + r101 + " to: " + this.mCurrentAccessStrength + " callback list size: " + this.mListeners.size());
        ArrayList r102 = new ArrayList();
        Iterator<WeakReference<TTNetworkStateCallback>> r103 = this.mListeners.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        WeakReference<TTNetworkStateCallback> r104 = r103.next();
        TTNetworkStateCallback r105 = r104.get();
        if (r105 == null) goto L9;
        r105.onAccessChanged(1, r101, this.mCurrentAccessStrength);
        goto L6
    L9:
        r102.add(r104);
        goto L6
    L12:
        if (r102.size() <= 0) goto L14;
        this.mListeners.removeAll(r102);
    L14:
        this.mLock.unlock();
        return;
    }

    public static /* synthetic */ int access$000(TTNetWorkListener r100) {
        return r100.mCurrentAccessType;
    }

    private static WifiInfo com_ss_ttvideoengine_TTNetWorkListener_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
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
        f06.d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
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

    private int getNetworkType(Context r100) {
        if (r100 != null) goto L5;
        return 1000;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L40;
        TTVideoEngineLog.d(TAG, "disconnect");
        return -1;
    L40:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L37
        if (r102 != null) goto L12;
    L35:
        TTVideoEngineLog.d(TAG, "disconnect 1");     // Catch: Exception -> L37
        return -1;
    L12:
        if (r102.isAvailable() == false) goto L35;
        NetworkInfo r103 = r101.getNetworkInfo(1);     // Catch: Exception -> L37
        if (r103 == null) goto L24;
        NetworkInfo.State r104 = r103.getState();     // Catch: Exception -> L37
        if (r104 == null) goto L24;
        if (r104 != NetworkInfo.State.CONNECTED) goto L21;
    L22:
        TTVideoEngineLog.d(TAG, "wifi");     // Catch: Exception -> L37
        return 0;
    L21:
        if (r104 == NetworkInfo.State.CONNECTING) goto L22;
    L24:
        NetworkInfo r105 = r101.getNetworkInfo(0);     // Catch: Exception -> L37
        if (r105 == null) goto L34;
        NetworkInfo.State r106 = r105.getState();     // Catch: Exception -> L37
        int r107 = r102.getSubtype();     // Catch: Exception -> L37
        TTVideoEngineLog.d(TAG, "state: " + r106 + ", subtype: " + r107);     // Catch: Exception -> L37
        if (r106 == null) goto L34;
        if (r106 == NetworkInfo.State.CONNECTED) goto L33;
        if (r106 != NetworkInfo.State.CONNECTING) goto L34;
    L33:
        return convertNetworkType(r107);
    L34:
        return 1000;
    L37:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.toString());
        return 1000;
    }

    private void updateAccessType(int r100) {
        if (r100 == this.mCurrentAccessType) goto L22;
        this.mLock.lock();
        int r101 = this.mCurrentAccessType;
        this.mCurrentAccessType = r100;
        TTVideoEngineLog.d(TAG, "access changed, from: " + r101 + " to: " + this.mCurrentAccessType + " callback list size: " + this.mListeners.size());
        ArrayList r102 = new ArrayList();
        Iterator<WeakReference<TTNetworkStateCallback>> r103 = this.mListeners.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        WeakReference<TTNetworkStateCallback> r104 = r103.next();
        TTNetworkStateCallback r105 = r104.get();
        if (r105 == null) goto L9;
        r105.onAccessChanged(0, r101, this.mCurrentAccessType);
        goto L6
    L9:
        r102.add(r104);
        goto L6
    L12:
        if (r102.size() <= 0) goto L14;
        this.mListeners.removeAll(r102);
    L14:
        this.mLock.unlock();
        return;
    }

    public synchronized void init(Context r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mInited == 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mInited = 1;     // Catch: Throwable -> L11
        MyThread r101 = new MyThread(r100, this);     // Catch: Throwable -> L11
        this.mThread = r101;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void registerListener(Context r100) {
        TTVideoEngineLog.d(TAG, "enter start listen");     // Catch: Exception -> L11
        IntentFilter r101 = new IntentFilter();     // Catch: Exception -> L11
        r101.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L11
        r101.addAction("android.net.wifi.RSSI_CHANGED");     // Catch: Exception -> L11
        INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, this, r101);     // Catch: Exception -> L11
        updateAccessType(getNetworkType(r100));     // Catch: Exception -> L11
        if (this.mCurrentAccessType != 0) goto L6;
        this.mCurrentAccessStrength = getWIFISignalStrength(r100, null);     // Catch: Exception -> L11
    L6:
        TTPhoneStateListener r102 = new TTPhoneStateListener(r100, this);     // Catch: Exception -> L11
        this.mPhoneStateListener = r102;     // Catch: Exception -> L11
        if (this.mIsWifiSensitiveMode == true) goto L9;
        r102.register(r100);     // Catch: Exception -> L11
    L9:
        this.mInited = 1;     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        TTVideoEngineLog.d(e);
        TTVideoEngineLog.d(TAG, "start listen network state failed");
    }

    public void startListen(WeakReference<TTNetworkStateCallback> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mLock.lock();
        this.mListeners.add(r100);
        this.mLock.unlock();
    }

    public void stopListen(WeakReference<TTNetworkStateCallback> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mLock.lock();
        this.mListeners.remove(r100);
        this.mLock.unlock();
    }

    public void unregisterListener(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.mPhoneStateListener == null) goto L13;
        INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100, this);     // Catch: Exception -> L8
        this.mPhoneStateListener.unregister(r100);     // Catch: Exception -> L8
        return;
    L8:
        TTVideoEngineLog.e(TAG, "Receiver has been unregistered!");
        return;
    }

    private void _handleNetworkChange(Context r100) {
        updateAccessType(getNetworkType(r100));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$100(TTNetWorkListener r100, int r101) {
        r100._handleNetworkChange(r101);
    }

    public static /* synthetic */ void access$200(TTNetWorkListener r100, int r101) {
        r100._handleSigStrengthChange(r101);
    }

    public static /* synthetic */ boolean access$302(TTNetWorkListener r100, boolean r101) {
        r100.mIsWifiSensitiveMode = r101;
        return r101;
    }

    private int getRssi(Context r100, ConnectivityManager r101) {
        NetworkInfo r102 = r101.getNetworkInfo(1);
        WifiInfo r103 = null;
        if (r102 != null) goto L5;
    L16:
        if (r103 != null) goto L18;
        return -1;
    L18:
        return r103.getRssi();
    L5:
        if (r102.isConnected() == false) goto L16;
        if (r100.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", r100.getPackageName()) != 0) goto L16;
        WifiManager r104 = (WifiManager) r100.getApplicationContext().getSystemService("wifi");
        if (Build.VERSION.SDK_INT < 29) goto L13;
        NetworkCapabilities r105 = r101.getNetworkCapabilities(r101.getActiveNetwork());
        if (r105 == null) goto L13;
        r103 = (WifiInfo) r105.getTransportInfo();
    L13:
        if (r103 != null) goto L16;
        if (r104 == null) goto L16;
        r103 = com_ss_ttvideoengine_TTNetWorkListener_android_net_wifi_WifiManager_getConnectionInfo(r104);
        goto L16
    }

    private int getWIFISignalStrength(Context r100, Intent r101) {
        if (r100 != null) goto L19;
        return 10;
    L19:
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L16
        if (r102 != null) goto L8;
        return 10;
    L8:
        if (r101 == null) goto L11;
        int r103 = r101.getIntExtra("newRssi", -70);     // Catch: Exception -> L16
    L14:
        int r104 = WifiManager.calculateSignalLevel(r103, 4);     // Catch: Exception -> L16
        TTVideoEngineLog.d(TAG, "wifi dbm:" + r103 + ", level:" + r104);     // Catch: Exception -> L16
        return r104 + 1;
    L11:
        if (this.mIsWifiSensitiveMode == true) goto L13;
        r103 = getRssi(r100, r102);     // Catch: Exception -> L16
        goto L14
    L13:
        r103 = -1;
    L16:
        e = move-exception;
        TTVideoEngineLog.e(TAG, e.toString());
        return 10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (isInitialStickyBroadcast() == true) goto L20;
        if (r101 != null) goto L7;
        return;
    L7:
        if ("android.net.wifi.RSSI_CHANGED".equals(r101.getAction()) == false) goto L15;
        if (this.mCurrentAccessType != 0) goto L15;
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 32) == true) goto L19;
        _handleSigStrengthChange(getWIFISignalStrength(r100, r101));
        return;
    L19:
        return;
    L15:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == true) goto L17;
        return;
    L17:
        TTVideoEngineLog.d(TAG, "network broadcast:" + r101.getAction());
        _handleNetworkChange(r100);
        return;
    }

    public void setIntValue(int r100, int r101) {
        if (r100 == 1) goto L7;
        if (r100 != 2) goto L10;
        PortraitNetworkScore.getInstance().setIntOption(3, r101);
        return;
    L10:
        return;
    L7:
        PortraitNetworkScore.getInstance().setIntOption(2, r101);
    }

    public void setStringValue(int r100, String r101) {
        if (r100 != 3) goto L5;
    L9:
        PortraitNetworkScore.getInstance().setStringOption(r100, r101);
        return;
    L5:
        if (r100 == 4) goto L9;
        if (r100 == 5) goto L9;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
