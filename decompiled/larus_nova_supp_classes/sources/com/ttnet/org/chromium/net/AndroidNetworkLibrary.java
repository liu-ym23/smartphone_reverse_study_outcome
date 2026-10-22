package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.net.TransportInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    public AndroidNetworkLibrary() {
    }

    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    public static String getWifiSSID() {
        return XmlPullParser.NO_NAMESPACE;
    }

    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r1 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L17
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.hasMoreElements() == false) goto L15;
        NetworkInterface r2 = r1.nextElement();
        if (r2.isUp() == false) goto L7;
        if (r2.isLoopback() == true) goto L7;
        return false;
    L15:
        return true;
    L17:
        e = move-exception;
        e.toString();
        return false;
    }

    private static boolean getIsCaptivePortal() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L8;
        return false;
    L8:
        Network r1 = ApiHelperForM.getActiveNetwork(r0);
        if (r1 != null) goto L11;
        return false;
    L11:
        NetworkCapabilities r2 = r0.getNetworkCapabilities(r1);
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.hasCapability(17) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return r1.getNetworkOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return TTAppSecurityManager.getInstance().getNetworkOperator();
    }

    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r1 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        return XmlPullParser.NO_NAMESPACE;
    L9:
        return com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_telephony_TelephonyManager_getSimOperator(r1);
    L11:
        th = move-exception;
        th.printStackTrace();
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return TTAppSecurityManager.getInstance().getSimOperator();
    }

    private static boolean haveAccessLocationState() {
        if (sHaveAccessLocationState != null) goto L16;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        sHaveAccessLocationState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION"));
        goto L16
    L8:
        if (hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        sHaveAccessLocationState = Boolean.valueOf(r0);
        goto L16
    L10:
        if (hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == true) goto L13;
        r0 = false;
    L16:
        return sHaveAccessLocationState.booleanValue();
    }

    private static boolean haveAccessNetworkState() {
        if (sHaveAccessNetworkState != null) goto L6;
        sHaveAccessNetworkState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE"));
    L6:
        return sHaveAccessNetworkState.booleanValue();
    }

    private static boolean haveAccessWifiState() {
        if (sHaveAccessWifiState != null) goto L6;
        sHaveAccessWifiState = Boolean.valueOf(hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_WIFI_STATE"));
    L6:
        return sHaveAccessWifiState.booleanValue();
    }

    private static boolean reportBadDefaultNetwork() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L8;
        return false;
    L8:
        ApiHelperForM.reportNetworkConnectivity(r0, null, false);
        return true;
    }

    private static void alwaysUpCellularOnThreadPool() {
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L6;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
        return;
    L6:
        NetworkRequest r2 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r0.requestNetwork(r2, new 1(r0));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
    }

    private static boolean checkIsVpnOn() {
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L5;
        return false;
    L5:
        Network[] r2 = r0.getAllNetworks();
        int r3 = 0;
    L7:
        if (r3 >= r2.length) goto L15;
        if (r0.getNetworkInfo(r2[r3]).isConnected() == false) goto L14;
        if (r0.getNetworkCapabilities(r2[r3]).hasTransport(4) == false) goto L14;
        return true;
    L14:
        r3 = r3 + 1;
        goto L7
    L15:
        return false;
    }

    public static int[] getAllAccessPointChannels() {
        if (haveAccessLocationState() == false) goto L25;
        if (haveAccessWifiState() == false) goto L25;
        WifiManager r0 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
        if (r0 == null) goto L10;
        List r1 = com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getScanResults(r0);
        if (r1 == null) goto L23;
        if (r1.isEmpty() == true) goto L23;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L18:
        if (r3.hasNext() == false) goto L21;
        r2.add(Integer.valueOf(frequencyToChannel(((ScanResult) r3.next()).frequency)));
        goto L18
    L21:
        return CollectionUtil.integerListToIntArray(r2);
    L23:
        return new int[0];
    L10:
        return new int[0];
    L25:
        return new int[0];
    }

    public static String[][] getAllRouteInfo() {
        if (haveAccessNetworkState() == true) goto L30;
        return null;
    L30:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L27
        if (r0 != null) goto L8;
        return null;
    L8:
        Network[] r2 = r0.getAllNetworks();     // Catch: Throwable -> L27
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L27
        int r4 = r2.length;     // Catch: Throwable -> L27
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L25;
        LinkProperties r9 = r0.getLinkProperties(r2[r6]);     // Catch: Throwable -> L27
        if (r9 == null) goto L24;
        Iterator<RouteInfo> r10 = r9.getRoutes().iterator();     // Catch: Throwable -> L27
    L16:
        if (r10.hasNext() == false) goto L24;
        RouteInfo r11 = r10.next();     // Catch: Throwable -> L27
        String[] r12 = new String[4];     // Catch: Throwable -> L27
        if (r11.getDestination() == null) goto L21;
        r12[0] = r11.getDestination().getAddress().getHostAddress();     // Catch: Throwable -> L27
        r12[1] = Integer.toString(r11.getDestination().getPrefixLength());     // Catch: Throwable -> L27
    L21:
        if (r11.getGateway() == null) goto L23;
        r12[2] = r11.getGateway().getHostAddress();     // Catch: Throwable -> L27
    L23:
        r12[3] = r11.getInterface();     // Catch: Throwable -> L27
        r3.add(r12);     // Catch: Throwable -> L27
    L24:
        r6 = r6 + 1;     // Catch: Throwable -> L27
        goto L10
    L25:
        return (String[][]) r3.toArray((String[][]) Array.newInstance(String.class, new int[]{0, 0}));
    L27:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        WifiInfo r0 = getWifiInfo();
        if (r0 != null) goto L11;
        return -1;
    L11:
        return frequencyToChannel(r0.getFrequency());
    L5:
        return frequencyToChannel(TTAppSecurityManager.getInstance().getWifiFrequency());
    }

    public static int[] getDhcpInfo() {
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == true) goto L5;
        WifiManager r0 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L12
        if (r0 == null) goto L15;
        DhcpInfo r1 = r0.getDhcpInfo();     // Catch: Throwable -> L12
        if (r1 == null) goto L15;
        return new int[]{r1.ipAddress, r1.gateway};
    L15:
        return new int[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        return new int[0];
    }

    private static WifiInfo getWifiInfo() {
        if (haveAccessWifiState() == true) goto L5;
        Intent r0 = INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (r0 != null) goto L25;
        return null;
    L25:
        return (WifiInfo) r0.getParcelableExtra("wifiInfo");
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L21;
        ConnectivityManager r1 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        Network[] r2 = r1.getAllNetworks();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L19;
        NetworkCapabilities r5 = r1.getNetworkCapabilities(r2[r4]);
        if (r5 == null) goto L18;
        if (r5.hasTransport(1) == false) goto L18;
        TransportInfo r6 = ApiHelperForQ.getTransportInfo(r5);
        if (r6 == null) goto L18;
        if ((r6 instanceof WifiInfo) == false) goto L18;
        return (WifiInfo) r6;
    L18:
        r4 = r4 + 1;
        goto L7
    L19:
        return null;
    L21:
        return com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getConnectionInfo((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi"));
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    public static void addTestRootCertificate(byte[] r0) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(r0);
    }

    private static WifiInfo com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(102301);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (WifiInfo) r4.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static List com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getScanResults(WifiManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, "java.util.List", r10);
        if (r11.a == false) goto L6;
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, null, r10, false);
        return (List) r11.b;
    L6:
        List<ScanResult> r12 = r13.getScanResults();
        r8.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r9, r12, r10, true);
        return r12;
    }

    private static String com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r13) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        d r11 = r8.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getSimOperator();
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, r12, r10, true);
        return r12;
    }

    private static int frequencyToChannel(int r1) {
        if (r1 != 2484) goto L6;
        return 14;
    L6:
        if (r1 >= 2484) goto L10;
        return (r1 - 2407) / 5;
    L10:
        if (r1 < 4910) goto L16;
        if (r1 > 4980) goto L16;
        return (r1 - 4000) / 5;
    L16:
        if (r1 >= 5925) goto L20;
        return (r1 - 5000) / 5;
    L20:
        if (r1 != 5935) goto L24;
        return 2;
    L24:
        if (r1 > 45000) goto L28;
        return (r1 - 5950) / 5;
    L28:
        if (r1 >= 58320) goto L30;
        return -1;
    L30:
        if (r1 <= 70200) goto L32;
        return -1;
    L32:
        return (r1 - 56160) / 2160;
    }

    public static DnsStatus getDnsStatus(Network r4) {
        if (haveAccessNetworkState() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r0 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L10;
        r4 = ApiHelperForM.getActiveNetwork(r0);
    L10:
        if (r4 != null) goto L22;
        return null;
    L22:
        LinkProperties r5 = r0.getLinkProperties(r4);     // Catch: RuntimeException -> L21
        if (r5 != null) goto L15;
        return null;
    L15:
        List<InetAddress> r1 = r5.getDnsServers();
        String r2 = r5.getDomains();
        if (Build.VERSION.SDK_INT < 28) goto L20;
        return new DnsStatus(r1, ApiHelperForP.isPrivateDnsActive(r5), ApiHelperForP.getPrivateDnsServerName(r5), r2);
    L20:
        return new DnsStatus(r1, false, XmlPullParser.NO_NAMESPACE, r2);
    L21:
        return null;
    }

    public static DnsStatus getDnsStatusForNetwork(long r0) {
        return getDnsStatus(Network.fromNetworkHandle(r0));
    L4:
        return null;
    }

    public static String getMimeTypeFromExtension(String r2) {
        return URLConnection.guessContentTypeFromName("foo." + r2);
    }

    public static int getWifiSignalLevel(int r5) {
        if (ContextUtils.getApplicationContext() != null) goto L6;
        return -1;
    L6:
        if (ContextUtils.getApplicationContext().getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L12;
        int r0 = TTAppSecurityManager.getInstance().getWifiRssi();
    L21:
        if (r0 != Integer.MIN_VALUE) goto L23;
        return -1;
    L23:
        int r1 = WifiManager.calculateSignalLevel(r0, r5);
        if (r1 < 0) goto L28;
        if (r1 >= r5) goto L28;
        return r1;
    L28:
        return -1;
    L12:
        if (haveAccessWifiState() == false) goto L30;
        WifiInfo r2 = getWifiInfo();
        if (r2 != null) goto L16;
        return -1;
    L16:
        r0 = r2.getRssi();
        goto L21
    L30:
        Intent r3 = INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L29
        if (r3 != null) goto L20;
        return -1;
    L20:
        r0 = r3.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L21
    }

    private static boolean isCleartextPermitted(String r1) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r1);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    public static void setWifiEnabled(boolean r2) {
        ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).setWifiEnabled(r2);
    }

    private static boolean hasPermission(Context r2, String r3) {
        if (ApiCompatibilityUtils.checkPermission(r2, r3, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    private static void tagSocket(int r4, int r5, int r6) throws IOException {
        int r0 = TrafficStats.getThreadStatsTag();
        if (r6 == r0) goto L6;
        TrafficStats.setThreadStatsTag(r6);
    L6:
        if (r5 == (-1)) goto L9;
        ThreadStatsUid.set(r5);
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        FileDescriptor r7 = SetFileDescriptor.createWithFd(r4);
        ParcelFileDescriptor r2 = null;
    L12:
        SocketFd r3 = new SocketFd(r7);
        TrafficStats.tagSocket(r3);
        r3.close();
        if (r2 == null) goto L15;
        r2.detachFd();
    L15:
        if (r6 == r0) goto L17;
        TrafficStats.setThreadStatsTag(r0);
    L17:
        if (r5 == (-1)) goto L20;
        ThreadStatsUid.clear();
        return;
    L20:
        return;
    L11:
        r2 = ParcelFileDescriptor.adoptFd(r4);
        r7 = r2.getFileDescriptor();
        goto L12
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r1, String r2, String r3) {
        return X509Util.verifyServerCertificates(r1, r2, r3);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
