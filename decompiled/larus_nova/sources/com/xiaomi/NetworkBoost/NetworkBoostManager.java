package com.xiaomi.NetworkBoost;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class NetworkBoostManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAIDLMiuiNetworkBoost f463001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f463002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f463003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f463004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ServiceCallback f463005e;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkBoostManager f463006a;

        public a(NetworkBoostManager r100) {
            this.f463006a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Object r102 = this.f463006a.f463004d;
            monitor-enter(r102);
            NetworkBoostManager r103 = this.f463006a;     // Catch: Throwable -> L13
            r103.f463001a = IAIDLMiuiNetworkBoost.Stub.asInterface(r101);     // Catch: Throwable -> L13
            Version.setServiceVersion(this.f463006a.f463001a.getServiceVersion());     // Catch: RemoteException -> L7 Throwable -> L13
        L9:
            this.f463006a.f463004d.notifyAll();     // Catch: Throwable -> L13
            monitor-exit(r102);     // Catch: Throwable -> L13
            this.f463006a.f463005e.onServiceConnected();
            return;
        L7:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Object r101 = this.f463006a.f463004d;
            monitor-enter(r101);
            NetworkBoostManager r102 = this.f463006a;     // Catch: Throwable -> L8
            r102.f463001a = null;     // Catch: Throwable -> L8
            r102.f463004d.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            this.f463006a.f463005e.onServiceDisconnected();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public NetworkBoostManager(Context r100, ServiceCallback r101) {
        this.f463004d = new Object();
        this.f463003c = r100;
        this.f463005e = r101;
        this.f463002b = new a(this);
    }

    public static int a(FileDescriptor r100) {
    L12:
        e = move-exception;
        throw new IOException("unable to access handle/fd fields in FileDescriptor", e);
    L9:
        e = move-exception;
        throw new IOException("FileDescriptor in this JVM lacks handle/fd fields", e);
    L3:
        if (r100.valid() == false) goto L7;
        Field r101 = FileDescriptor.class.getDeclaredField("fd");     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        r101.setAccessible(true);     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        long r102 = r101.getInt(r100);     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
        r101.setAccessible(false);     // Catch: NoSuchFieldException -> L9 IllegalAccessException -> L12
    L6:
        return (int) r102;
    L7:
        return -1;
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int getSDKVersion() {
        return 6;
    }

    public static int getServiceVersion() {
        return Version.getServiceVersion();
    }

    public boolean abortScan() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.abortScan();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean activeScan(int[] r100) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.activeScan(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean bindService() {
        this.f463001a = IAIDLMiuiNetworkBoost.Stub.asInterface((IBinder) INVOKESTATIC_com_xiaomi_NetworkBoost_NetworkBoostManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"xiaomi.NetworkBoostServiceManager"}));     // Catch: Exception -> L5
    L7:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L18;
        Intent r101 = new Intent(IAIDLMiuiNetworkBoost.class.getName());
        r101.setClassName("com.xiaomi.NetworkBoost", "com.xiaomi.NetworkBoost.NetworkBoostService");
        this.f463003c.bindService(r101, this.f463002b, 1);
    L15:
        if (this.f463001a == null) goto L22;
        return true;
    L22:
        return false;
    L18:
        Version.setServiceVersion(r100.getServiceVersion());     // Catch: RemoteException -> L11
        this.f463005e.onServiceConnected();     // Catch: RemoteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        this.f463005e.onServiceDisconnected();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public boolean connectSlaveWifi(int r100) {
        if (Version.isSupport(Integer.MAX_VALUE) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.connectSlaveWifi(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean disableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.disableWifiSelectionOpt(r100);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean disableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.disableWifiSelectionOptByUid(r100, r101);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean disconnectSlaveWifi() {
        if (Version.isSupport(Integer.MAX_VALUE) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.disconnectSlaveWifi();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean enableWifiSelectionOpt(IAIDLMiuiNetSelectCallback r100, int r101) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.enableWifiSelectionOpt(r100, r101);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean enableWifiSelectionOptByUid(IAIDLMiuiNetSelectCallback r100, int r101, int r102) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r103 = this.f463001a;
        if (r103 != null) goto L12;
    L11:
        return false;
    L12:
        return r103.enableWifiSelectionOptByUid(r100, r101, r102);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public Map<String, String> getAvailableIfaces() {
        if (Version.isSupport(3) == false) goto L5;
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 == null) goto L13;
        return r100.getAvailableIfaces();
    L10:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L13:
        return new HashMap();
    L5:
        return new HashMap();
    }

    public Map<String, String> getQoEByAvailableIfaceName(String r100) {
        if (Version.isSupport(Integer.MAX_VALUE) == false) goto L5;
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 == null) goto L13;
        return r101.getQoEByAvailableIfaceName(r100);
    L10:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L13:
        return new HashMap();
    L5:
        return new HashMap();
    }

    public NetLinkLayerQoE getQoEByAvailableIfaceNameV1(String r100) {
        if (Version.isSupport(4) == false) goto L5;
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 == null) goto L13;
        return r101.getQoEByAvailableIfaceNameV1(r100);
    L10:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L13:
        return new NetLinkLayerQoE();
    L5:
        return new NetLinkLayerQoE();
    }

    public boolean isCelluarDSDAState() {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.isCelluarDSDAState();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public int isSlaveWifiEnabledAndOthersOpt(int r100) {
        if (Version.isSupport(5) == true) goto L5;
        return -1;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return -1;
    L12:
        return r101.isSlaveWifiEnabledAndOthersOpt(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public int isSlaveWifiEnabledAndOthersOptByUid(int r100, int r101) {
        if (Version.isSupport(6) == true) goto L5;
        return -1;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return -1;
    L12:
        return r102.isSlaveWifiEnabledAndOthersOptByUid(r100, r101);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean isSupportDualCelluarData() {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.isSupportDualCelluarData();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean isSupportDualWifi() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.isSupportDualWifi();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean isSupportMediaPlayerPolicy() {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.isSupportMediaPlayerPolicy();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean registerCallback(IAIDLMiuiNetworkCallback r100) {
        if (Version.isSupport(1) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.registerCallback(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean registerNetLinkCallback(IAIDLMiuiNetQoECallback r100, int r101) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.registerNetLinkCallback(r100, r101);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean registerNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101, int r102) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r103 = this.f463001a;
        if (r103 != null) goto L12;
    L11:
        return false;
    L12:
        return r103.registerNetLinkCallbackByUid(r100, r101, r102);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean registerWifiLinkCallback(IAIDLMiuiWlanQoECallback r100) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.registerWifiLinkCallback(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public void reportBssidScore(Map<String, String> r100) {
        if (Version.isSupport(4) == true) goto L5;
        return;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 == null) goto L14;
        r101.reportBssidScore(r100);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        return;
    }

    public Map<String, String> requestAppTrafficStatistics(int r100, long r101, long r110) {
        if (Version.isSupport(3) == false) goto L5;
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 == null) goto L14;
        return r102.requestAppTrafficStatistics(r100, r101, r110);
    L11:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L14:
        return new HashMap();
    L5:
        return new HashMap();
    }

    public Map<String, String> requestAppTrafficStatisticsByUid(int r100, long r101, long r110, int r111) {
        if (Version.isSupport(4) == false) goto L5;
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 == null) goto L14;
        return r102.requestAppTrafficStatisticsByUid(r100, r101, r110, r111);
    L11:
        e = move-exception;
        e.toString();
        e.printStackTrace();
    L14:
        return new HashMap();
    L5:
        return new HashMap();
    }

    public boolean resumeBackgroundScan() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.resumeBackgroundScan();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean resumeWifiPowerSave() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.resumeWifiPowerSave();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public void sendMediaPlayerPolicyEvent(int r100, int r101, String r102) {
        if (Version.isSupport(6) == true) goto L5;
        return;
    L5:
        IAIDLMiuiNetworkBoost r103 = this.f463001a;
        if (r103 == null) goto L14;
        r103.sendMediaPlayerPolicyEvent(r100, r101, r102);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        b.a.a(e);
        return;
    }

    public boolean setDualCelluarDataEnable(boolean r100) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.setDualCelluarDataEnable(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean setSlaveWifiEnable(boolean r100) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.setSlaveWifiEnable(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean setSockPrio(int r100, int r101) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.setSockPrio(r100, r101);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean setSockPrio(FileDescriptor r100, int r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setSockPrio(a(r100), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean setSockPrio(Socket r100, int r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setSockPrio(a(ParcelFileDescriptor.fromSocket(r100).getFileDescriptor()), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean setTCPCongestion(int r100, String r101) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.setTCPCongestion(r100, r101);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean setTCPCongestion(FileDescriptor r100, String r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setTCPCongestion(a(r100), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean setTCPCongestion(Socket r100, String r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setTCPCongestion(a(ParcelFileDescriptor.fromSocket(r100).getFileDescriptor()), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean setTrafficTransInterface(int r100, String r101) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.setTrafficTransInterface(r100, r101);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean setTrafficTransInterface(FileDescriptor r100, String r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setTrafficTransInterface(a(r100), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean setTrafficTransInterface(Socket r100, String r101) {
        if (Version.isSupport(3) == true) goto L10;
        return false;
    L10:
        return setTrafficTransInterface(a(ParcelFileDescriptor.fromSocket(r100).getFileDescriptor()), r101);
    L7:
        e = move-exception;
        e.toString();
        return false;
    }

    public boolean suspendBackgroundScan() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.suspendBackgroundScan();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean suspendWifiPowerSave() {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 != null) goto L12;
    L11:
        return false;
    L12:
        return r100.suspendWifiPowerSave();
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public void triggerWifiSelection() {
        if (Version.isSupport(4) == true) goto L5;
        return;
    L5:
        IAIDLMiuiNetworkBoost r100 = this.f463001a;
        if (r100 == null) goto L14;
        r100.triggerWifiSelection();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        return;
    }

    public void unbindService() {
        Context r100 = this.f463003c;
        if (r100 != null) goto L17;
    L5:
        Object r101 = this.f463004d;
        monitor-enter(r101);
        this.f463001a = null;     // Catch: Throwable -> L11
        this.f463004d.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L17:
        r100.unbindService(this.f463002b);     // Catch: IllegalArgumentException -> L14
        goto L5
    }

    public boolean unregisterCallback(IAIDLMiuiNetworkCallback r100) {
        if (Version.isSupport(1) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.unregisterCallback(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    public boolean unregisterNetLinkCallback(IAIDLMiuiNetQoECallback r100) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.unregisterNetLinkCallback(r100);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean unregisterNetLinkCallbackByUid(IAIDLMiuiNetQoECallback r100, int r101) {
        if (Version.isSupport(4) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r102 = this.f463001a;
        if (r102 != null) goto L12;
    L11:
        return false;
    L12:
        return r102.unregisterNetLinkCallbackByUid(r100, r101);
    L9:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        goto L11
    }

    public boolean unregisterWifiLinkCallback(IAIDLMiuiWlanQoECallback r100) {
        if (Version.isSupport(3) == true) goto L5;
        return false;
    L5:
        IAIDLMiuiNetworkBoost r101 = this.f463001a;
        if (r101 != null) goto L12;
    L11:
        return false;
    L12:
        return r101.unregisterWifiLinkCallback(r100);
    L9:
        e = move-exception;
        b.a.a(e);
        goto L11
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_NetworkBoost_NetworkBoostManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
