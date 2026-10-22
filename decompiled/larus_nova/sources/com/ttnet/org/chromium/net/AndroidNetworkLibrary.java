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
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ttnet.org.chromium.base.ApiCompatibilityUtils;
import com.ttnet.org.chromium.base.CollectionUtil;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForN;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.base.compat.ApiHelperForQ;
import f06.d;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@MainDex
class AndroidNetworkLibrary {
    private static final String TAG = "AndroidNetworkLibrary";
    private static Boolean sHaveAccessLocationState;
    private static Boolean sHaveAccessNetworkState;
    private static Boolean sHaveAccessWifiState;

    /* JADX INFO: loaded from: classes6.dex */
    public interface Natives {
        void onCellularAlwaysUp(boolean r100, int r101);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class NetworkSecurityPolicyProxy {
        private static NetworkSecurityPolicyProxy sInstance;

        public NetworkSecurityPolicyProxy() {
        }

        static {
            sInstance = new NetworkSecurityPolicyProxy();
        }

        public boolean isCleartextTrafficPermitted() {
            if (Build.VERSION.SDK_INT >= 23) goto L7;
            return true;
        L7:
            return ApiHelperForM.isCleartextTrafficPermitted();
        }

        public static NetworkSecurityPolicyProxy getInstance() {
            return sInstance;
        }

        public static void setInstanceForTesting(NetworkSecurityPolicyProxy r100) {
            sInstance = r100;
        }

        public boolean isCleartextTrafficPermitted(String r100) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return isCleartextTrafficPermitted();
        L7:
            return ApiHelperForN.isCleartextTrafficPermitted(r100);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class SetFileDescriptor {
        private static final Method sFileDescriptorSetInt = null;

        private SetFileDescriptor() {
        }

        static {
            sFileDescriptorSetInt = FileDescriptor.class.getMethod("setInt$", new Class[]{Integer.TYPE});     // Catch: Throwable -> L4 NoSuchMethodException -> L6
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to get FileDescriptor.setInt$", e);
        }

        public static FileDescriptor createWithFd(int r100) {
            FileDescriptor r101 = new FileDescriptor();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            sFileDescriptorSetInt.invoke(r101, new Object[]{Integer.valueOf(r100)});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L8
            return r101;
        L8:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        L5:
            e = move-exception;
            throw new RuntimeException("FileDescriptor.setInt$() failed", e);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class SocketFd extends Socket {

        /* JADX INFO: loaded from: classes41.dex */
        public static class SocketImplFd extends SocketImpl {
            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void create(boolean r100) {
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            public SocketImplFd(FileDescriptor r100) {
                ((SocketImpl) this).fd = r100;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl r100) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r100) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int r100) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int r100) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress r100, int r101) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(String r100, int r101) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r100, Object r101) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress r100, int r101) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress r100, int r101) {
                throw new RuntimeException("connect not implemented");
            }
        }

        public SocketFd(FileDescriptor r100) throws IOException {
            super(new SocketImplFd(r100));
        }
    }

    public AndroidNetworkLibrary() {
    }

    public static DnsStatus getCurrentDnsStatus() {
        return getDnsStatus(null);
    }

    public static String getWifiSSID() {
        return "";
    }

    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L17
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.hasMoreElements() == false) goto L15;
        NetworkInterface r101 = r100.nextElement();
        if (r101.isUp() == false) goto L7;
        if (r101.isLoopback() == true) goto L7;
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
        ConnectivityManager r100 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r100 != null) goto L8;
        return false;
    L8:
        Network r101 = ApiHelperForM.getActiveNetwork(r100);
        if (r101 != null) goto L11;
        return false;
    L11:
        NetworkCapabilities r102 = r100.getNetworkCapabilities(r101);
        if (r102 != null) goto L14;
        return false;
    L14:
        if (r102.hasCapability(17) == false) goto L18;
        return true;
    L18:
        return false;
    }

    private static String getNetworkOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r100 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100.getNetworkOperator();
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
    L5:
        return TTAppSecurityManager.getInstance().getNetworkOperator();
    }

    private static String getSimOperator() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        TelephonyManager r100 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        return "";
    L9:
        return com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_telephony_TelephonyManager_getSimOperator(r100);
    L11:
        th = move-exception;
        th.printStackTrace();
        return "";
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
        boolean r100 = true;
    L14:
        sHaveAccessLocationState = Boolean.valueOf(r100);
        goto L16
    L10:
        if (hasPermission(ContextUtils.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == true) goto L13;
        r100 = false;
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
        ConnectivityManager r100 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r100 != null) goto L8;
        return false;
    L8:
        ApiHelperForM.reportNetworkConnectivity(r100, null, false);
        return true;
    }

    private static void alwaysUpCellularOnThreadPool() {
        final ConnectivityManager r100 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r100 != null) goto L6;
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 7);
        return;
    L6:
        NetworkRequest r101 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r100.requestNetwork(r101, new AnonymousClass1(r100));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        AndroidNetworkLibraryJni.get().onCellularAlwaysUp(false, 9);
    }

    private static boolean checkIsVpnOn() {
        ConnectivityManager r100 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r100 != null) goto L5;
        return false;
    L5:
        Network[] r101 = r100.getAllNetworks();
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L15;
        if (r100.getNetworkInfo(r101[r102]).isConnected() == false) goto L14;
        if (r100.getNetworkCapabilities(r101[r102]).hasTransport(4) == false) goto L14;
        return true;
    L14:
        r102 = r102 + 1;
        goto L7
    L15:
        return false;
    }

    public static int[] getAllAccessPointChannels() {
        if (haveAccessLocationState() == false) goto L25;
        if (haveAccessWifiState() == false) goto L25;
        WifiManager r100 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");
        if (r100 == null) goto L10;
        List r101 = com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getScanResults(r100);
        if (r101 == null) goto L23;
        if (r101.isEmpty() == true) goto L23;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L18:
        if (r103.hasNext() == false) goto L21;
        r102.add(Integer.valueOf(frequencyToChannel(((ScanResult) r103.next()).frequency)));
        goto L18
    L21:
        return CollectionUtil.integerListToIntArray(r102);
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
        ConnectivityManager r100 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L27
        if (r100 != null) goto L8;
        return null;
    L8:
        Network[] r101 = r100.getAllNetworks();     // Catch: Throwable -> L27
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L27
        int r103 = r101.length;     // Catch: Throwable -> L27
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L25;
        LinkProperties r105 = r100.getLinkProperties(r101[r104]);     // Catch: Throwable -> L27
        if (r105 == null) goto L24;
        Iterator<RouteInfo> r106 = r105.getRoutes().iterator();     // Catch: Throwable -> L27
    L16:
        if (r106.hasNext() == false) goto L24;
        RouteInfo r110 = r106.next();     // Catch: Throwable -> L27
        String[] r111 = new String[4];     // Catch: Throwable -> L27
        if (r110.getDestination() == null) goto L21;
        r111[0] = r110.getDestination().getAddress().getHostAddress();     // Catch: Throwable -> L27
        r111[1] = Integer.toString(r110.getDestination().getPrefixLength());     // Catch: Throwable -> L27
    L21:
        if (r110.getGateway() == null) goto L23;
        r111[2] = r110.getGateway().getHostAddress();     // Catch: Throwable -> L27
    L23:
        r111[3] = r110.getInterface();     // Catch: Throwable -> L27
        r102.add(r111);     // Catch: Throwable -> L27
    L24:
        r104 = r104 + 1;     // Catch: Throwable -> L27
        goto L10
    L25:
        return (String[][]) r102.toArray((String[][]) Array.newInstance(String.class, new int[]{0, 0}));
    L27:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static int getCurrentAccessPointChannel() {
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == true) goto L5;
        WifiInfo r100 = getWifiInfo();
        if (r100 != null) goto L11;
        return -1;
    L11:
        return frequencyToChannel(r100.getFrequency());
    L5:
        return frequencyToChannel(TTAppSecurityManager.getInstance().getWifiFrequency());
    }

    public static int[] getDhcpInfo() {
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == true) goto L5;
        WifiManager r100 = (WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L12
        if (r100 == null) goto L15;
        DhcpInfo r101 = r100.getDhcpInfo();     // Catch: Throwable -> L12
        if (r101 == null) goto L15;
        return new int[]{r101.ipAddress, r101.gateway};
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
        Intent r100 = INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (r100 != null) goto L25;
        return null;
    L25:
        return (WifiInfo) r100.getParcelableExtra("wifiInfo");
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L21;
        ConnectivityManager r101 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        Network[] r102 = r101.getAllNetworks();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L19;
        NetworkCapabilities r105 = r101.getNetworkCapabilities(r102[r104]);
        if (r105 == null) goto L18;
        if (r105.hasTransport(1) == false) goto L18;
        TransportInfo r106 = ApiHelperForQ.getTransportInfo(r105);
        if (r106 == null) goto L18;
        if ((r106 instanceof WifiInfo) == false) goto L18;
        return (WifiInfo) r106;
    L18:
        r104 = r104 + 1;
        goto L7
    L19:
        return null;
    L21:
        return com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getConnectionInfo((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi"));
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    public static void addTestRootCertificate(byte[] r100) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(r100);
    }

    private static WifiInfo com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
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
        d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
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
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static List com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_net_wifi_WifiManager_getScanResults(WifiManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, "java.util.List", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, null, r111, false);
        return (List) r112.f474983b;
    L6:
        List<ScanResult> r113 = r110.getScanResults();
        r100.a(102300, "android/net/wifi/WifiManager", "getScanResults", r110, r101, r113, r111, true);
        return r113;
    }

    private static String com_ttnet_org_chromium_net_AndroidNetworkLibrary_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    private static int frequencyToChannel(int r100) {
        if (r100 != 2484) goto L6;
        return 14;
    L6:
        if (r100 >= 2484) goto L10;
        return (r100 - 2407) / 5;
    L10:
        if (r100 < 4910) goto L16;
        if (r100 > 4980) goto L16;
        return (r100 + AVMDLDataLoader.AVMDLErrorIsInvalidRequestInfo) / 5;
    L16:
        if (r100 >= 5925) goto L20;
        return (r100 - 5000) / 5;
    L20:
        if (r100 != 5935) goto L24;
        return 2;
    L24:
        if (r100 > 45000) goto L28;
        return (r100 - 5950) / 5;
    L28:
        if (r100 >= 58320) goto L30;
        return -1;
    L30:
        if (r100 <= 70200) goto L32;
        return -1;
    L32:
        return (r100 - 56160) / 2160;
    }

    public static DnsStatus getDnsStatus(Network r100) {
        if (haveAccessNetworkState() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r100 != null) goto L10;
        r100 = ApiHelperForM.getActiveNetwork(r101);
    L10:
        if (r100 != null) goto L22;
        return null;
    L22:
        LinkProperties r102 = r101.getLinkProperties(r100);     // Catch: RuntimeException -> L21
        if (r102 != null) goto L15;
        return null;
    L15:
        List<InetAddress> r103 = r102.getDnsServers();
        String r104 = r102.getDomains();
        if (Build.VERSION.SDK_INT < 28) goto L20;
        return new DnsStatus(r103, ApiHelperForP.isPrivateDnsActive(r102), ApiHelperForP.getPrivateDnsServerName(r102), r104);
    L20:
        return new DnsStatus(r103, false, "", r104);
    L21:
        return null;
    }

    public static DnsStatus getDnsStatusForNetwork(long r100) {
        return getDnsStatus(Network.fromNetworkHandle(r100));
    L4:
        return null;
    }

    public static String getMimeTypeFromExtension(String r100) {
        return URLConnection.guessContentTypeFromName("foo." + r100);
    }

    public static int getWifiSignalLevel(int r100) {
        if (ContextUtils.getApplicationContext() != null) goto L6;
        return -1;
    L6:
        if (ContextUtils.getApplicationContext().getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (TTAppSecurityManager.getInstance().isTTPRestrictionEnabled() == false) goto L12;
        int r101 = TTAppSecurityManager.getInstance().getWifiRssi();
    L21:
        if (r101 != Integer.MIN_VALUE) goto L23;
        return -1;
    L23:
        int r102 = WifiManager.calculateSignalLevel(r101, r100);
        if (r102 < 0) goto L28;
        if (r102 >= r100) goto L28;
        return r102;
    L28:
        return -1;
    L12:
        if (haveAccessWifiState() == false) goto L30;
        WifiInfo r103 = getWifiInfo();
        if (r103 != null) goto L16;
        return -1;
    L16:
        r101 = r103.getRssi();
        goto L21
    L30:
        Intent r104 = INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(ContextUtils.getApplicationContext(), null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L29
        if (r104 != null) goto L20;
        return -1;
    L20:
        r101 = r104.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L21
    }

    private static boolean isCleartextPermitted(String r100) {
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted(r100);
    L5:
        return NetworkSecurityPolicyProxy.getInstance().isCleartextTrafficPermitted();
    }

    public static void setWifiEnabled(boolean r100) {
        ((WifiManager) ContextUtils.getApplicationContext().getSystemService("wifi")).setWifiEnabled(r100);
    }

    private static boolean hasPermission(Context r100, String r101) {
        if (ApiCompatibilityUtils.checkPermission(r100, r101, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ttnet_org_chromium_net_AndroidNetworkLibrary_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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

    private static void tagSocket(int r100, int r101, int r102) throws IOException {
        int r103 = TrafficStats.getThreadStatsTag();
        if (r102 == r103) goto L6;
        TrafficStats.setThreadStatsTag(r102);
    L6:
        if (r101 == (-1)) goto L9;
        ThreadStatsUid.set(r101);
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        FileDescriptor r104 = SetFileDescriptor.createWithFd(r100);
        ParcelFileDescriptor r105 = null;
    L12:
        SocketFd r106 = new SocketFd(r104);
        TrafficStats.tagSocket(r106);
        r106.close();
        if (r105 == null) goto L15;
        r105.detachFd();
    L15:
        if (r102 == r103) goto L17;
        TrafficStats.setThreadStatsTag(r103);
    L17:
        if (r101 == (-1)) goto L20;
        ThreadStatsUid.clear();
        return;
    L20:
        return;
    L11:
        r105 = ParcelFileDescriptor.adoptFd(r100);
        r104 = r105.getFileDescriptor();
        goto L12
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r100, String r101, String r102) {
        return X509Util.verifyServerCertificates(r100, r101, r102);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
