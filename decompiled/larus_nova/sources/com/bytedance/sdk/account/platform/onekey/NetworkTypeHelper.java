package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sdk.account.platform.onekey.carrier.IServiceContainer;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkTypeHelper {
    public static final String CARRIER_UNKNOWN = "carrier unknown";
    private static final String GET_CARRIER_INNER_EVENT = "one_click_get_carrier_inner_event";
    public static final int INVALID_SUBSCRIPTION_ID = -1;
    public static final String SIM_CARD_NOT_READY = "sim card not ready";
    private static final String TAG = "NetworkTypeHelper";
    static volatile String carrierType = "";
    private static boolean hadReportGetSubIdFail = false;
    private static Set<Integer> hadReportSimStateList = null;
    private static IOnekeyMonitor sMonitor = null;
    public static volatile int subscriptionId = -1;

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            NetworkType r101 = new NetworkType(UserProfileEvent.POSITION_NONE, 1, 0);
            NONE = r101;
            NetworkType r102 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r102;
            NetworkType r103 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r103;
            NetworkType r104 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r104;
            NetworkType r105 = new NetworkType("WIFI", 5, 4);
            WIFI = r105;
            NetworkType r110 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r110;
            $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public boolean is2G() {
            if (this != MOBILE) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_2G) goto L8;
            return false;
        }

        public boolean isAvailable() {
            if (this != UNKNOWN) goto L5;
        L7:
            return false;
        L5:
            if (this == NONE) goto L7;
            return true;
        }

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
            return false;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        private NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    private NetworkTypeHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isMobileEnabled(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    static {
        hadReportSimStateList = new CopyOnWriteArraySet();
    }

    public static int getDefaultDataSubscriptionIdDirect() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 24) goto L5;
        int r101 = SubscriptionManager.getDefaultDataSubscriptionId();
        tb7.a.a(TAG, "getDefaultDataSubscriptionId, way 1, value=" + r101);
    L27:
        IServiceContainer r102 = (IServiceContainer) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (hadReportGetSubIdFail == true) goto L32;
        if (r101 > 0) goto L32;
        if (r102 == null) goto L32;
        hadReportGetSubIdFail = true;
        r102.onEvent(OnekeyDataHelper.GET_SUBSCRIPTION_ID_FAIL_EVENT, new JSONObject());
    L32:
        return r101;
    L5:
        int r103 = -1;
        if (r100 >= 22) goto L41;
        Class r104 = INVOKESTATIC_com_bytedance_sdk_account_platform_onekey_NetworkTypeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.telephony.SubscriptionManager");     // Catch: Exception -> L25
        Method r105 = r104.getDeclaredMethod("getDefaultDataSubId", new Class[0]);     // Catch: NoSuchMethodException -> L18 Exception -> L25
    L19:
        int r106 = (int) ((Long) r105.invoke(null, new Object[0])).longValue();
        tb7.a.a(TAG, "getDefaultDataSubscriptionId, way 3, value=" + r106);     // Catch: Exception -> L23
        r101 = r106;
    L23:
        e = e;
        r103 = r106;
    L26:
        e.printStackTrace();
        r101 = r103;
        goto L27
    L18:
        tb7.a.a(TAG, "getDefaultDataSubscriptionId, way 3, catch NoSuchMethodException");     // Catch: Exception -> L25
        r105 = r104.getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);     // Catch: Exception -> L25
    L25:
        e = e;
        goto L26
    L41:
        r101 = ((Integer) SubscriptionManager.class.getDeclaredMethod("getDefaultDataSubId", new Class[0]).invoke(null, new Object[0])).intValue();     // Catch: Exception -> L12
        tb7.a.a(TAG, "getDefaultDataSubscriptionId, way 2, value=" + r101);     // Catch: Exception -> L10
    L10:
        e = e;
    L14:
        e.printStackTrace();
    L12:
        e = e;
        r101 = -1;
        goto L14
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sdk_account_platform_onekey_NetworkTypeHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static String getCarrierLog(Context r100) {
        String r101 = (String) BpeaManager.invokeDeviceInfoApi(r100, "phone", BpeaManager.getNetworkOperatorName, new Object[0]);     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return "";
    L13:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static String getCarrierType(Context r100) {
        if (OnekeySettingManager.instance().isEnableGetCarrierTypeOpt() == false) goto L14;
        String r101 = carrierType;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        r101 = getCarrierTypeInner(r100);
        carrierType = r101;
    L8:
        if (TextUtils.equals(r101, carrierType) == true) goto L18;
        tb7.a.d(TAG, "carrierType changed by other thread, tempCarrierType=" + r101 + ", carrierType=" + carrierType);
        monitorEnsureNotReachHere("carrierType changed by other thread", r101 + "," + carrierType);
        if (TextUtils.isEmpty(carrierType) == false) goto L12;
        return r101;
    L12:
        return carrierType;
    L18:
        return r101;
    L14:
        if (TextUtils.isEmpty(carrierType) == false) goto L17;
        carrierType = getCarrierTypeInner(r100);
    L17:
        return carrierType;
    }

    public static String getCarrierTypeInner(Context r100) {
        String r101 = "others";
        String r102 = "";
        tb7.a.a(TAG, "call getCarrierTypeInner");     // Catch: Throwable -> L28
        boolean r103 = OnekeySettingManager.instance().isEnableGetCarrierTypeOpt();     // Catch: Throwable -> L28
        if (r103 == false) goto L6;
        boolean r104 = CommonUtils.isSimCardReady(r100, true);     // Catch: Throwable -> L28
    L7:
        if (r104 == true) goto L10;
        return "sim card not ready";
    L10:
        if (r103 == false) goto L12;
        String r105 = CommonUtils.getCarrierOperatorInner(r100);     // Catch: Throwable -> L28
    L32:
        String r106 = CommonUtils.getCarrierType(r105);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r106) == false) goto L17;
        r101 = CARRIER_UNKNOWN;
    L30:
        onGetCarrierEvent(r100, r105, r101, r102);
        return r101;
    L17:
        if ("1".equals(r106) == false) goto L20;
        r101 = "mobile";
        goto L30
    L20:
        if ("3".equals(r106) == false) goto L22;
        r101 = OnekeyLoginConstants.TELECOM;
        goto L30
    L22:
        if ("2".equals(r106) == false) goto L30;
        r101 = OnekeyLoginConstants.UNICOM;
    L26:
        th = move-exception;
        String r107 = r105;
        th = th;
        r102 = r107;
    L29:
        r105 = r102;
        r102 = th.getMessage() + " ==== " + Log.getStackTraceString(th);
        goto L30
    L12:
        r105 = CommonUtils.getCarrierOperator(r100);     // Catch: Throwable -> L28
        goto L32
    L6:
        r104 = CommonUtils.isSimCardReady(r100);     // Catch: Throwable -> L28
    L28:
        th = th;
        goto L29
    }

    public static int getDefaultDataSubscriptionId(Context r100) {
        if (subscriptionId != (-1)) goto L6;
        subscriptionId = innerGetDefaultDataSubscriptionId(r100);
    L6:
        return subscriptionId;
    }

    public static String getNetTypeLog(Context r100) {
        return getNetworkAccessType(r100);
    }

    public static String getNetworkAccessType(NetworkType r100) {
        if (r100 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r100 != NetworkType.MOBILE_2G) goto L9;
        return CJPayBasicUtils.NETWORK_2G;
    L9:
        if (r100 != NetworkType.MOBILE_3G) goto L12;
        return CJPayBasicUtils.NETWORK_3G;
    L12:
        if (r100 != NetworkType.MOBILE_4G) goto L15;
        return CJPayBasicUtils.NETWORK_4G;
    L15:
        if (r100 != NetworkType.MOBILE) goto L17;
        return "mobile";
    L17:
        return "";
    }

    public static int getNetworkStatus(Context r100) {
        if (r100 != null) goto L39;
        return -1;
    L39:
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L36
        if (r101 != null) goto L9;
        return -1;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Network r102 = r101.getActiveNetwork();     // Catch: Exception -> L36
        if (r102 == null) goto L22;
        NetworkCapabilities r103 = r101.getNetworkCapabilities(r102);     // Catch: Exception -> L36
        if (r103 == null) goto L22;
        boolean r104 = r103.hasTransport(0);     // Catch: Exception -> L36
        boolean r105 = r103.hasTransport(1);     // Catch: Exception -> L36
        if (isDataMobileEnabled(r100, r101) == false) goto L18;
        if (r105 == false) goto L18;
        return 3;
    L18:
        if (r105 == false) goto L20;
        return 2;
    L20:
        if (r104 == false) goto L22;
        return 1;
    L22:
        NetworkInfo r106 = r101.getActiveNetworkInfo();     // Catch: Exception -> L36
        if (r106 != null) goto L25;
    L35:
        return 0;
    L25:
        if (r106.isAvailable() == false) goto L35;
        int r107 = r106.getType();     // Catch: Exception -> L36
        if (r107 != 1) goto L33;
        if (isDataMobileEnabled(r100, r101) == false) goto L32;
        return 3;
    L32:
        return 2;
    L33:
        if (r107 != 0) goto L35;
        return 1;
    L36:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static NetworkType getNetworkType(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L27
        if (r101 == null) goto L26;
        if (r101.isAvailable() == false) goto L26;
        int r102 = r101.getType();     // Catch: Throwable -> L27
        if (1 == r102) goto L10;
        if (r102 != 0) goto L24;
        int r103 = 0;
        r103 = ((Integer) BpeaManager.invokeDeviceInfoApi(r100, "phone", BpeaManager.getNetworkType, new Object[0])).intValue();     // Catch: Exception -> L15 Throwable -> L27
    L17:
        switch(r103) {
            case 3: goto L22;
            case 4: goto L32;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L32;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L22;
            case 11: goto L32;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L22;
            case 15: goto L22;
            default: goto L32;
        };     // Catch: Throwable -> L27
    L32:
        return NetworkType.MOBILE;
    L20:
        return NetworkType.MOBILE_4G;
    L22:
        return NetworkType.MOBILE_3G;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        goto L17
    L24:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L26:
        return NetworkType.NONE;
    L28:
        return NetworkType.MOBILE;
    }

    private static int innerGetDefaultDataSubscriptionId(Context r100) {
        if (r100 == null) goto L8;
        if (CommonUtils.isSimCardReady(r100) == true) goto L8;
        return -1;
    L8:
        return getDefaultDataSubscriptionIdDirect();
    }

    public static void registerReceiver(Context r100) {
        SimStateReceive.register(r100);
        DefaultDataSubscriptionReceiver.register(r100);
    }

    public static void setMonitor(IOnekeyMonitor r100) {
        sMonitor = r100;
    }

    public static void unregisterReceiver(Context r100) {
        SimStateReceive.unregister(r100);
        DefaultDataSubscriptionReceiver.unregister(r100);
    }

    public static String getNetworkAccessType(Context r100) {
        return getNetworkAccessType(getNetworkType(r100));
    }

    private static boolean isDataMobileEnabled(Context r100, ConnectivityManager r101) {
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return false;
    L4:
        if (CommonUtils.isSimCardReady(r100) == true) goto L6;
        return false;
    L6:
        Method r102 = r101.getClass().getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        r102.setAccessible(true);     // Catch: Exception -> L10
        return ((Boolean) r102.invoke(r101, new Object[0])).booleanValue();
    }

    public static void monitorEnsureNotReachHere(String r100, String r101) {
        if (sMonitor != null) goto L13;
        return;
    L13:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L10
        r102.put("msg", r100);     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r102.put("extra", r101);     // Catch: Exception -> L10
    L8:
        r102.put("params_for_special", "uc_login");     // Catch: Exception -> L10
        sMonitor.onEvent(OnekeyDataHelper.ENSURE_NOT_REACH_HERE_EVENT, r102);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        tb7.a.e(TAG, "monitorEnsureNotReachHere error, " + e);
    }

    public static void monitorSimStateResult(Context r100, int r101) {
        if (sMonitor != null) goto L6;
        return;
    L6:
        if (hadReportSimStateList.contains(Integer.valueOf(r101)) == false) goto L8;
        return;
    L8:
        hadReportSimStateList.add(Integer.valueOf(r101));
        int r102 = getDefaultDataSubscriptionIdDirect();
        if (r102 > 0) goto L11;
    L17:
        int r103 = -1;
    L18:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L24
        r104.put("sim_state", r101);     // Catch: Exception -> L24
        if (r102 <= 0) goto L21;
        int r105 = 1;
    L22:
        r104.put("has_sub_id", r105);     // Catch: Exception -> L24
        r104.put("sim_state_v2", r103);     // Catch: Exception -> L24
        r104.put("params_for_special", "uc_login");     // Catch: Exception -> L24
        sMonitor.onEvent(OnekeyDataHelper.SIM_STATE_RESULT_EVENT, r104);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        r105 = 0;
        goto L22
    L11:
        if (r101 == 5) goto L17;
        if (Build.VERSION.SDK_INT < 24) goto L17;
        TelephonyManager r106 = CommonUtils.getTelephonyManager(r100);     // Catch: Exception -> L24
        if (r106 == null) goto L17;
        r103 = r106.createForSubscriptionId(r102).getSimState();     // Catch: Exception -> L24
        goto L18
    }

    private static void onGetCarrierEvent(Context r100, String r101, String r102, String r103) {
        if (sMonitor == null) goto L11;
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L6
        r104.put("mccmnc", r101);     // Catch: JSONException -> L6
        r104.put(Constants.OperatorKey.KEY_CARRIER, r102);     // Catch: JSONException -> L6
        r104.put("carrier_log", getCarrierLog(r100));     // Catch: JSONException -> L6
        r104.put("error_msg", r103);     // Catch: JSONException -> L6
        r104.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 60592);     // Catch: JSONException -> L6
        r104.put("params_for_special", "uc_login");     // Catch: JSONException -> L6
        sMonitor.onEvent(GET_CARRIER_INNER_EVENT, r104);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
