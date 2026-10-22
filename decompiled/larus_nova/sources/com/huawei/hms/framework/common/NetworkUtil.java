package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.UserManager;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.HwTelephonyManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.hianalytics.InitReport;
import com.huawei.secure.android.common.webview.UriUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class NetworkUtil {
    private static final int INVALID_RSSI = -127;
    private static final String STR_NSA = "5G_NSA";
    private static final String STR_SA = "5G_SA";
    private static final String TAG = "NKUtil";
    private static final int TYPE_WIFI_P2P = 13;
    public static final int UNAVAILABLE = Integer.MAX_VALUE;
    public static volatile boolean isSupportIpv6Net = true;
    public static volatile int networkTypeByReceiver;

    public static final class NetType {
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_4G_NSA = 7;
        public static final int TYPE_5G = 5;
        public static final int TYPE_5G_SA = 8;
        public static final int TYPE_MOBILE = 6;
        public static final int TYPE_NO_NETWORK = -1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;

        public NetType() {
        }
    }

    public static final class SignalType {
        public static final String LTE_CQI = "lteCqi";
        public static final String LTE_DBM = "lteDbm";
        public static final String LTE_RSRP = "lteRsrp";
        public static final String LTE_RSRQ = "lteRsrq";
        public static final String LTE_RSSI = "lteRssi";
        public static final String LTE_RSSNR = "lteRssnr";
        public static final String NR_CSIRSRP = "nrCSIRsrp";
        public static final String NR_CSIRSRQ = "nrCSIRsrq";
        public static final String NR_CSISINR = "nrCSISinr";
        public static final String NR_DBM = "nrDbm";
        public static final String NR_SSRSRP = "nrSSRsrp";
        public static final String NR_SSRSRQ = "nrSSRsrq";
        public static final String NR_SSSINR = "nrSSSinr";

        public SignalType() {
        }
    }

    public NetworkUtil() {
    }

    private static int groupNetworkType(int r100) {
        if (r100 != (-1)) goto L5;
        return -1;
    L5:
        if (r100 != 1) goto L7;
        return 1;
    L7:
        if (r100 != 2) goto L9;
    L15:
        return 6;
    L9:
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L15;
        if (r100 == 5) goto L15;
        return 0;
    }

    public static String getNetWorkNSAorSA() {
        HwTelephonyManager r100 = HwTelephonyManager.getDefault();     // Catch: Throwable -> L8
        int r101 = r100.getDefault4GSlotId();     // Catch: Throwable -> L8
        Logger.v(TAG, "phoneId " + r101);     // Catch: Throwable -> L8
        boolean r102 = r100.isNsaState(r101);     // Catch: Throwable -> L8
        Logger.v(TAG, "isNsa " + r102);     // Catch: Throwable -> L8
        if (r102 == true) goto L12;
        return STR_SA;
    L12:
        return STR_NSA;
    L8:
        Logger.v(TAG, "isNsaState error");
        return null;
    }

    public static boolean isForeground() {
        return ActivityUtil.getInstance().isForeground();
    }

    public static void updateCurrentNetworkType() {
        networkTypeByReceiver = netWork(ContextHolder.getResourceContext());
        if (InitReport.isHasConnectNet() == false) goto L6;
        isSupportIpv6Net = isSupportIpv6Net(ContextHolder.getResourceContext(), networkTypeByReceiver);
        Logger.i(TAG, "update currentNetworkType: " + networkTypeByReceiver + ", isSupportIpv6Net:" + isSupportIpv6Net);
        return;
    }

    public static int getCurrentNetworkType() {
        return networkTypeByReceiver;
    }

    public static boolean isSupportIpv6Net() {
        return isSupportIpv6Net;
    }

    public static String getDnsServerIps(Context r100) {
        return Arrays.toString(getDnsServerIpsFromConnectionManager(r100));
    }

    private static String[] getDnsServerIpsFromConnectionManager(Context r110) {
        LinkedList r100 = new LinkedList();
        if (r110 == null) goto L30;
        ConnectivityManager r111 = (ConnectivityManager) ContextCompat.getSystemService(r110, "connectivity");
        if (r111 == null) goto L30;
        NetworkInfo r101 = r111.getActiveNetworkInfo();     // Catch: RuntimeException -> L25 SecurityException -> L27
        if (r101 == null) goto L30;
        Network[] r102 = r111.getAllNetworks();     // Catch: RuntimeException -> L25 SecurityException -> L27
        int r103 = r102.length;     // Catch: RuntimeException -> L25 SecurityException -> L27
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L30;
        Network r105 = r102[r104];     // Catch: RuntimeException -> L25 SecurityException -> L27
        if (r105 == null) goto L24;
        NetworkInfo r106 = r111.getNetworkInfo(r105);     // Catch: RuntimeException -> L25 SecurityException -> L27
        if (r106 == null) goto L24;
        if (r106.getType() != r101.getType()) goto L24;
        LinkProperties r107 = r111.getLinkProperties(r105);     // Catch: RuntimeException -> L25 SecurityException -> L27
        if (r107 == null) goto L24;
        Iterator<InetAddress> r108 = r107.getDnsServers().iterator();     // Catch: RuntimeException -> L25 SecurityException -> L27
    L21:
        if (r108.hasNext() == false) goto L24;
        r100.add(r108.next().getHostAddress());     // Catch: RuntimeException -> L25 SecurityException -> L27
    L24:
        r104 = r104 + 1;
    L27:
        e = move-exception;
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:".concat(e.getClass().getSimpleName()));
    L25:
        e = move-exception;
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:".concat(e.getClass().getSimpleName()));
    L30:
        if (r100.isEmpty() == false) goto L33;
        return new String[0];
    L33:
        return (String[]) r100.toArray(new String[r100.size()]);
    }

    public static String getHost(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return UriUtil.getHostByURI(r100);
    }

    public static int getLteCqi(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L16;
        return Integer.MAX_VALUE;
    L16:
    L13:
        th = move-exception;
        Logger.i(TAG, "getLteCqi: throwable:" + th.getClass());
    L15:
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L12;
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L13
        if (r102.size() <= 0) goto L15;
        return ((CellSignalStrengthLte) ListProtector.get(r102, 0)).getCqi();
    L12:
        return getInfoWithReflect(r101, "getLteCqi");
    }

    public static int getLteRsrp(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L16;
        return Integer.MAX_VALUE;
    L16:
    L13:
        th = move-exception;
        Logger.i(TAG, "getLteRsrp: throwable:" + th.getClass());
    L15:
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L12;
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L13
        if (r102.size() <= 0) goto L15;
        return ((CellSignalStrengthLte) ListProtector.get(r102, 0)).getRsrp();
    L12:
        return getInfoWithReflect(r101, "getLteRsrp");
    }

    public static int getLteRsrq(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L16;
        return Integer.MAX_VALUE;
    L16:
    L13:
        th = move-exception;
        Logger.i(TAG, "getLteRsrq: throwable:" + th.getClass());
    L15:
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L12;
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L13
        if (r102.size() <= 0) goto L15;
        return ((CellSignalStrengthLte) ListProtector.get(r102, 0)).getRsrq();
    L12:
        return getInfoWithReflect(r101, "getLteRsrq");
    }

    public static int getLteRssi(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
    L11:
        th = move-exception;
        Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
    L13:
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L13;
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L11
        if (r102.size() <= 0) goto L13;
        return ((CellSignalStrengthLte) ListProtector.get(r102, 0)).getRssi();
    }

    public static int getLteRssnr(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L16;
        return Integer.MAX_VALUE;
    L16:
    L13:
        th = move-exception;
        Logger.i(TAG, "getLteRssnr: throwable:" + th.getClass());
    L15:
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L12;
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L13
        if (r102.size() <= 0) goto L15;
        return ((CellSignalStrengthLte) ListProtector.get(r102, 0)).getRssnr();
    L12:
        return getInfoWithReflect(r101, "getLteRssnr");
    }

    public static Map<String, Integer> getLteSignalInfo(Context r100) {
        HashMap r101 = new HashMap();
        SignalStrength r102 = getSignalStrength(r100);
        if (r102 != null) goto L17;
        return r101;
    L17:
    L13:
        th = move-exception;
        Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
    L15:
        return r101;
    L7:
        if (Build.VERSION.SDK_INT <= 28) goto L11;
        List r103 = r102.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L13
        if (r103.size() <= 0) goto L16;
        r101.put(SignalType.LTE_DBM, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getDbm()));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSRP, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getRsrp()));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSRQ, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getRsrq()));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSSNR, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getRssnr()));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_CQI, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getCqi()));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSSI, Integer.valueOf(((CellSignalStrengthLte) ListProtector.get(r103, 0)).getRssi()));     // Catch: Throwable -> L13
    L16:
        goto L15
    L11:
        r101.put(SignalType.LTE_DBM, Integer.valueOf(getInfoWithReflect(r102, "getDbm")));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSRP, Integer.valueOf(getInfoWithReflect(r102, "getLteRsrp")));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSRQ, Integer.valueOf(getInfoWithReflect(r102, "getLteRsrq")));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_RSSNR, Integer.valueOf(getInfoWithReflect(r102, "getLteRssnr")));     // Catch: Throwable -> L13
        r101.put(SignalType.LTE_CQI, Integer.valueOf(getInfoWithReflect(r102, "getLteCqi")));     // Catch: Throwable -> L13
        goto L16
    }

    public static String getMNC(Context r100) {
        if (r100 != null) goto L6;
        return "unknown";
    L6:
        if (isSimReady(r100) == true) goto L8;
        return "unknown";
    L8:
        Object r101 = ContextCompat.getSystemService(r100, "phone");
        if ((r101 instanceof TelephonyManager) == false) goto L11;
        TelephonyManager r102 = (TelephonyManager) r101;
    L12:
        if (r102 != null) goto L15;
        Logger.e(TAG, "getSubscriptionOperatorType: other error!");
        return "unknown";
    L15:
        String r103 = r102.getNetworkOperator();
        if ("46001".equals(r103) == false) goto L18;
    L41:
        return Constants.NetworkOperator.UNICOM_OPERATOR;
    L18:
        if ("46006".equals(r103) == true) goto L41;
        if ("46009".equals(r103) == true) goto L41;
        if ("46000".equals(r103) == false) goto L25;
    L40:
        return Constants.NetworkOperator.MOBILE_OPERATOR;
    L25:
        if ("46002".equals(r103) == true) goto L40;
        if ("46004".equals(r103) == true) goto L40;
        if ("46007".equals(r103) == true) goto L40;
        if ("46003".equals(r103) == false) goto L34;
    L39:
        return Constants.NetworkOperator.TELECOM_OPERATOR;
    L34:
        if ("46005".equals(r103) == true) goto L39;
        if ("46011".equals(r103) == true) goto L39;
        return "other";
    L11:
        r102 = null;
        goto L12
    }

    public static int getMobileRsrp(Context r100) {
        SignalStrength r101 = getSignalStrength(r100);
        if (r101 != null) goto L14;
        return Integer.MAX_VALUE;
    L14:
    L11:
        th = move-exception;
        Logger.i(TAG, "getDbm: throwable:" + th.getClass());
        return Integer.MAX_VALUE;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L10;
        return getMobileSingalStrengthUpPPlatfrom(r100);
    L10:
        return getInfoWithReflect(r101, "getDbm");
    }

    private static int getMobileSingalStrengthUpPPlatfrom(Context r100) {
        int r101 = Integer.MAX_VALUE;
        if (Build.VERSION.SDK_INT > 28) goto L5;
        return Integer.MAX_VALUE;
    L5:
        SignalStrength r102 = getSignalStrength(r100);
        if (r102 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        int r103 = getNetworkType(r100);
        if (r103 != 3) goto L11;
        List r104 = r102.getCellSignalStrengths(CellSignalStrengthCdma.class);     // Catch: Throwable -> L32
        if (r104.size() <= 0) goto L25;
        int r105 = ((CellSignalStrengthCdma) ListProtector.get(r104, 0)).getDbm();     // Catch: Throwable -> L32
    L24:
        r101 = r105;
        return r101;
    L25:
        List r106 = r102.getCellSignalStrengths(CellSignalStrengthTdscdma.class);     // Catch: Throwable -> L32
        if (r106.size() <= 0) goto L28;
        r105 = ((CellSignalStrengthTdscdma) ListProtector.get(r106, 0)).getDbm();     // Catch: Throwable -> L32
        goto L24
    L28:
        List r107 = r102.getCellSignalStrengths(CellSignalStrengthWcdma.class);     // Catch: Throwable -> L32
        if (r107.size() <= 0) goto L40;
        r105 = ((CellSignalStrengthWcdma) ListProtector.get(r107, 0)).getDbm();     // Catch: Throwable -> L32
        goto L24
    L40:
        return Integer.MAX_VALUE;
    L11:
        if (r103 != 4) goto L13;
        List r108 = r102.getCellSignalStrengths(CellSignalStrengthLte.class);     // Catch: Throwable -> L32
        if (r108.size() <= 0) goto L38;
        r105 = ((CellSignalStrengthLte) ListProtector.get(r108, 0)).getDbm();     // Catch: Throwable -> L32
        goto L24
    L38:
        return Integer.MAX_VALUE;
    L13:
        if (r103 != 5) goto L41;
        List r109 = r102.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L32
        if (r109.size() <= 0) goto L37;
        r105 = ((CellSignalStrengthNr) ListProtector.get(r109, 0)).getDbm();     // Catch: Throwable -> L32
        goto L24
    L37:
        return Integer.MAX_VALUE;
    L41:
        return Integer.MAX_VALUE;
    L32:
        th = move-exception;
        Logger.i(TAG, "getMobileSingalStrength: throwable:" + th.getClass());
        return r101;
    }

    public static NetworkInfo getNetworkInfo(Context r100) {
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L13;
        ConnectivityManager r101 = (ConnectivityManager) ContextCompat.getSystemService(r100, "connectivity");
        if (r101 == null) goto L14;
        return r101.getActiveNetworkInfo();
    L8:
        e = move-exception;
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e.getClass().getSimpleName() + e.getMessage());
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public static NetworkInfo.DetailedState getNetworkStatus(Context r100) {
        NetworkInfo.DetailedState r101 = NetworkInfo.DetailedState.IDLE;
        if (r100 == null) goto L17;
        Object r102 = ContextCompat.getSystemService(r100, "connectivity");
        if ((r102 instanceof ConnectivityManager) == true) goto L19;
        Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
        goto L17
    L19:
    L14:
        e = move-exception;
        Logger.i(TAG, "getNetworkStatus exception" + e.getClass().getSimpleName() + e.getMessage());
        goto L17
    L7:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == true) goto L9;
        return r101;
    L9:
        NetworkInfo r103 = ((ConnectivityManager) r102).getActiveNetworkInfo();     // Catch: RuntimeException -> L14
        if (r103 == null) goto L12;
        r101 = r103.getDetailedState();     // Catch: RuntimeException -> L14
    L18:
        goto L17
    L12:
        Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");     // Catch: RuntimeException -> L14
    L17:
        return r101;
    }

    public static int getNetworkType(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return getNetworkType(getNetworkInfo(r100), r100);
    }

    public static int getNrCsiRsrp(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrCsiRsrp: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getCsiRsrp();
    }

    public static int getNrCsiRsrq(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrCsiRsrq: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getCsiRsrq();
    }

    public static int getNrCsiSinr(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrCsiSinr: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getCsiSinr();
    }

    public static Map<String, Integer> getNrSignalInfo(Context r100) {
        HashMap r101 = new HashMap();
        SignalStrength r102 = getSignalStrength(r100);
        if (r102 != null) goto L14;
        return r101;
    L14:
    L11:
        th = move-exception;
        Logger.i(TAG, "getLteRssi: throwable:" + th.getClass());
    L13:
        return r101;
    L6:
        if (Build.VERSION.SDK_INT <= 28) goto L13;
        List r103 = r102.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L11
        if (r103.size() <= 0) goto L13;
        r101.put(SignalType.NR_DBM, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getDbm()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_CSIRSRP, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getCsiRsrp()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_CSIRSRQ, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getCsiRsrq()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_CSISINR, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getCsiSinr()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_SSRSRP, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getSsRsrp()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_SSRSRQ, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getSsRsrq()));     // Catch: Throwable -> L11
        r101.put(SignalType.NR_SSSINR, Integer.valueOf(((CellSignalStrengthNr) ListProtector.get(r103, 0)).getSsSinr()));     // Catch: Throwable -> L11
        goto L13
    }

    public static int getNrSsRsrp(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrSsRsrp: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getSsRsrp();
    }

    public static int getNrSsRsrq(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrSsRsrq: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getSsRsrq();
    }

    public static int getNrSsSinr(Context r100) {
    L12:
        th = move-exception;
        Logger.i(TAG, "getNrSsSinr: throwable:" + th.getClass());
    L14:
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT <= 28) goto L14;
        SignalStrength r101 = getSignalStrength(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L8;
        return Integer.MAX_VALUE;
    L8:
        List r102 = r101.getCellSignalStrengths(CellSignalStrengthNr.class);     // Catch: Throwable -> L12
        if (r102.size() <= 0) goto L14;
        return ((CellSignalStrengthNr) ListProtector.get(r102, 0)).getSsSinr();
    }

    public static int getPrimaryNetworkType(Context r100) {
        return groupNetworkType(getNetworkType(getNetworkInfo(r100), r100));
    }

    private static SignalStrength getSignalStrength(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return null;
    L6:
        return getTrafficCardTelephonyManager(r100).getSignalStrength();
    }

    public static TelephonyManager getTrafficCardTelephonyManager(Context r100) {
        if (r100 == null) goto L9;
        Object r101 = ContextCompat.getSystemService(r100, "phone");
        if ((r101 instanceof TelephonyManager) == false) goto L12;
        TelephonyManager r102 = (TelephonyManager) r101;
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        return r102;
    L8:
        return r102.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId());
    L12:
        return null;
    L9:
        return null;
    }

    public static String getWifiGatewayIp(Context r100) {
        if (r100 == null) goto L16;
        Object r101 = ContextCompat.getSystemService(r100.getApplicationContext(), "wifi");
        if ((r101 instanceof WifiManager) == true) goto L14;
        return " ";
    L14:
        int r102 = ((WifiManager) r101).getDhcpInfo().gateway;     // Catch: UnknownHostException -> L9 Throwable -> L11
        return InetAddress.getByAddress(new byte[]{(byte) (r102 & 255), (byte) ((r102 >> 8) & 255), (byte) ((r102 >> 16) & 255), (byte) ((r102 >> 24) & 255)}).getHostAddress();
    L11:
        e = move-exception;
        Logger.i(TAG, "getWifiGatewayIp error!" + e.getClass().getSimpleName() + e.getMessage());
        return " ";
    L16:
        return " ";
    }

    public static int getWifiRssi(Context r100) {
        int r101 = -127;
        if (r100 != null) goto L5;
    L20:
        return r101;
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L20;
        ConnectivityManager r102 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: RuntimeException -> L18
        Network[] r103 = r102.getAllNetworks();     // Catch: RuntimeException -> L18
        int r104 = r103.length;     // Catch: RuntimeException -> L18
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L20;
        NetworkCapabilities r106 = r102.getNetworkCapabilities(r103[r105]);     // Catch: RuntimeException -> L18
        if (r106 == null) goto L17;
        if (r106.hasTransport(1) == false) goto L17;
        TransportInfo r107 = r106.getTransportInfo();     // Catch: RuntimeException -> L18
        if (r107 == null) goto L17;
        if ((r107 instanceof WifiInfo) == false) goto L17;
        r101 = ((WifiInfo) r107).getRssi();     // Catch: RuntimeException -> L18
    L17:
        r105 = r105 + 1;
    L18:
        e = move-exception;
        Logger.i(TAG, "getWifiRssiLevel did not has permission!" + e.getClass().getSimpleName() + e.getMessage());
        goto L20
    }

    public static int getWifiRssiLevel(Context r100) {
        return WifiManager.calculateSignalLevel(getWifiRssi(r100), 5);
    }

    public static boolean isForeground(Context r100) {
        return ActivityUtil.isForeground(r100);
    }

    public static boolean isNetworkAvailable(Context r100) {
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L11;
        NetworkInfo r101 = getNetworkInfo(r100);
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (r101.isConnected() == false) goto L9;
        return true;
    L11:
        return true;
    }

    public static boolean isSimReady(Context r100) {
        Object r101 = ContextCompat.getSystemService(r100, "phone");
        if ((r101 instanceof TelephonyManager) == false) goto L5;
        TelephonyManager r102 = (TelephonyManager) r101;
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.getSimState() != 5) goto L10;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean isUserUnlocked(Context r100) {
        if (Build.VERSION.SDK_INT < 24) goto L14;
        UserManager r101 = (UserManager) ContextCompat.getSystemService(r100, "user");
        if (r101 == null) goto L15;
        return r101.isUserUnlocked();
    L8:
        e = move-exception;
        Logger.e(TAG, "dealType rethrowFromSystemServer:", e);
        return true;
    L15:
        return true;
    L14:
        return true;
    }

    public static int netWork(Context r100) {
        int r101 = getNetworkType(r100);
        Logger.v(TAG, "networkType " + r101);
        if (r101 != 4) goto L9;
        if (TextUtils.equals(STR_NSA, getNetWorkNSAorSA()) == false) goto L14;
        return 7;
    L14:
        return r101;
    L9:
        if (r101 == 5) goto L11;
        return r101;
    L11:
        if (TextUtils.equals(STR_SA, getNetWorkNSAorSA()) == false) goto L16;
        return 8;
    L16:
        return r101;
    }

    public static NetworkInfo.DetailedState networkStatus(Context r100) {
        return getNetworkStatus(r100);
    }

    public static int readDataSaverMode(Context r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L18:
        return r101;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L18;
        Object r102 = ContextCompat.getSystemService(r100, "connectivity");
        if ((r102 instanceof ConnectivityManager) == false) goto L18;
        ConnectivityManager r103 = (ConnectivityManager) r102;
    L16:
        e = move-exception;
        Logger.e(TAG, "SystemServer error:", e);
        goto L18
    L12:
        if (r103.isActiveNetworkMetered() == false) goto L14;
        r101 = r103.getRestrictBackgroundStatus();     // Catch: RuntimeException -> L16
    L19:
        goto L18
    L14:
        Logger.v(TAG, "ConnectType is not Mobile Network!");     // Catch: RuntimeException -> L16
        goto L19
    }

    public static int getNetworkType(NetworkInfo r100) {
        return getNetworkType(r100, null);
    }

    public static int getPrimaryNetworkType(NetworkInfo r100) {
        return groupNetworkType(getNetworkType(r100));
    }

    public static int getInfoWithReflect(SignalStrength r100, String r101) {
    L10:
        Logger.i(TAG, r101 + " : cannot access");
        return Integer.MAX_VALUE;
    L11:
        Logger.i(TAG, r101 + " : function not found");
        return Integer.MAX_VALUE;
    L9:
        Logger.i(TAG, r101 + " : InvocationTargetException");
        return Integer.MAX_VALUE;
    L7:
        th = move-exception;
        Logger.i(TAG, r101 + " : throwable:" + th.getClass());
        return Integer.MAX_VALUE;
    L4:
        if (Build.VERSION.SDK_INT > 28) goto L16;
        final Method r102 = SignalStrength.class.getDeclaredMethod(r101, new Class[0]);     // Catch: Throwable -> L7 InvocationTargetException -> L9 IllegalAccessException -> L10 NoSuchMethodException -> L11
        AccessController.doPrivileged(new AnonymousClass1(r102));     // Catch: Throwable -> L7 InvocationTargetException -> L9 IllegalAccessException -> L10 NoSuchMethodException -> L11
        return ((Integer) r102.invoke(r100, new Object[0])).intValue();
    L16:
        return Integer.MAX_VALUE;
    }

    public static int getNetworkType(NetworkInfo r100, Context r101) {
        if (r100 != null) goto L4;
    L34:
        return -1;
    L4:
        if (r100.isConnected() == false) goto L34;
        int r102 = r100.getType();
        if (1 != r102) goto L8;
        return 1;
    L8:
        if (13 != r102) goto L11;
        return 1;
    L11:
        if (r102 != 0) goto L37;
        int r103 = r100.getSubtype();
        Logger.v(TAG, "getHwNetworkType return is: " + r103);
        if (r103 != 0) goto L16;
        r103 = r100.getSubtype();
    L16:
        if (r103 == 20) goto L22;
        switch(r103) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L20;
            case 15: goto L20;
            default: goto L18;
        };
    L18:
        int r104 = 0;
    L23:
        if (r104 != 0) goto L40;
        if (Build.VERSION.SDK_INT < 25) goto L40;
        if (r103 != 16) goto L29;
        return 2;
    L29:
        if (r103 != 17) goto L42;
        return 3;
    L42:
        return 0;
    L40:
        return r104;
    L19:
        r104 = 4;
        goto L23
    L20:
        r104 = 3;
        goto L23
    L21:
        r104 = 2;
        goto L23
    L22:
        r104 = 5;
        goto L23
    L37:
        return 0;
    }

    public static boolean isChangeToConnected(NetworkInfo r100, NetworkInfo r101) {
        if (r100 == null) goto L6;
        if (r100.isConnected() == false) goto L6;
        return false;
    L6:
        if (r101.isConnected() == false) goto L11;
        Logger.v(TAG, "Find network state changed to connected");
        return true;
    L11:
        return false;
    }

    public static boolean isConnectTypeChange(NetworkInfo r100, NetworkInfo r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isConnected() == true) goto L6;
        return false;
    L6:
        if (r101.isConnected() == true) goto L8;
        return false;
    L8:
        if (getPrimaryNetworkType(r100) == getPrimaryNetworkType(r101)) goto L15;
        Logger.v(TAG, "Find activity network changed");
        return true;
    L15:
        return false;
    }

    public static boolean isSupportIpv6Net(Context r100, int r101) {
        if (r101 <= 1) goto L5;
        boolean r102 = true;
    L6:
        if (r100 != null) goto L9;
        return r102;
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L38:
        Logger.v(TAG, "has no network state permission");
        return r102;
    L11:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_NETWORK_STATE") == false) goto L38;
        ConnectivityManager r103 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r103 != null) goto L16;
        Logger.e(TAG, "mConnectivityManager is null");
        return r102;
    L16:
        Network r104 = r103.getActiveNetwork();
        if (r104 != null) goto L20;
        Logger.e(TAG, "network is null");
        return r102;
    L20:
        LinkProperties r105 = r103.getLinkProperties(r104);
        if (r105 != null) goto L24;
        Logger.e(TAG, "ipInfo is null");
        return r102;
    L24:
        List<LinkAddress> r106 = r105.getLinkAddresses();
        int r107 = 0;
    L26:
        if (r107 >= r106.size()) goto L36;
        InetAddress r108 = ((LinkAddress) ListProtector.get(r106, r107)).getAddress();
        if ((r108 instanceof Inet6Address) == false) goto L35;
        if (r108.isLinkLocalAddress() == true) goto L35;
        if (r108.isLoopbackAddress() == true) goto L35;
        Logger.v(TAG, "has ipv6 interface");
        return true;
    L35:
        r107 = r107 + 1;
        goto L26
    L36:
        Logger.v(TAG, "has not ipv6 interface");
        return false;
    L5:
        r102 = false;
        goto L6
    }
}
