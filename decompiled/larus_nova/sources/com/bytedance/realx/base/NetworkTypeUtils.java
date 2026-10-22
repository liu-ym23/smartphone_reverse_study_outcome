package com.bytedance.realx.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public class NetworkTypeUtils {
    private static final boolean DEBUG_MOBILE = false;
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final String TAG = "NetworkTypeUtils";
    private static String debugInfo = "";
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;

    /* JADX INFO: renamed from: com.bytedance.realx.base.NetworkTypeUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE_5G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[NetworkType.MOBILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            $VALUES = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) a.a(CompressType.class, r100);
        }

        private CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
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
            NetworkType r111 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r111;
            $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public boolean isAvailable() {
            if (this == NONE) goto L5;
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

    public interface NetworkTypeInterceptor {
        NetworkType getNetworkType();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public NetworkTypeUtils() {
    }

    public static String getDebugInfo() {
        return debugInfo;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_realx_base_NetworkTypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static int getNetWorkTypeThroughBPEA(Context r100) {
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        Class r102 = INVOKESTATIC_com_bytedance_realx_base_NetworkTypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry");     // Catch: Exception -> L14
        Class<?> r103 = INVOKESTATIC_com_bytedance_realx_base_NetworkTypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.bpea.basics.Cert");     // Catch: Exception -> L14
        Class r104 = INVOKESTATIC_com_bytedance_realx_base_NetworkTypeUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.bpea.cert.token.TokenCert");     // Catch: Exception -> L14
        if (r102 == null) goto L13;
        if (r103 == null) goto L13;
        if (r104 == null) goto L13;
        Method r105 = r102.getDeclaredMethod(BpeaManager.getNetworkType, new Class[]{TelephonyManager.class, r103});     // Catch: Exception -> L14
        Method r106 = r104.getDeclaredMethod("with", new Class[]{String.class});     // Catch: Exception -> L14
        if (r105 == null) goto L13;
        if (r106 == null) goto L13;
        int r107 = ((Integer) r105.invoke(null, new Object[]{r101, r106.invoke(null, new Object[]{"bpea-rtc_generic_device_info"})})).intValue();     // Catch: Exception -> L14
        debugInfo += " getNetworkType through BPEA;";     // Catch: Exception -> L19
    L16:
        if (r107 != (-1)) goto L24;
        int r108 = Integer.valueOf(r101.getDataNetworkType()).intValue();
        debugInfo += " getNetworkType through system;";
        return r108;
    L24:
        return r107;
    L15:
        RXLogging.i(TAG, "BPEA not exist");
    L13:
        r107 = -1;
    L14:
        r107 = -1;
        goto L15
    }

    public static String getNetworkAccessType(NetworkType r100) {
        switch(AnonymousClass1.$SwitchMap$com$bytedance$realx$base$NetworkTypeUtils$NetworkType[r100.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L17;
        };     // Catch: Exception -> L14
    L6:
        String r101 = "mobile";
    L13:
        return r101;
    L7:
        r101 = CJPayBasicUtils.NETWORK_MOBILE;
        goto L13
    L8:
        r101 = CJPayBasicUtils.NETWORK_4G;
        goto L13
    L9:
        r101 = CJPayBasicUtils.NETWORK_3G;
        goto L13
    L10:
        r101 = CJPayBasicUtils.NETWORK_2G;
        goto L13
    L11:
        r101 = "wifi";
        goto L13
    L17:
        return "";
    L18:
        return "";
    }

    public static boolean is2G(Context r100) {
        NetworkType r101 = getNetworkType(r100, null);
        if (r101 != NetworkType.MOBILE) goto L5;
    L8:
        return true;
    L5:
        if (r101 == NetworkType.MOBILE_2G) goto L8;
        return false;
    }

    public static boolean isIpv4(String r100) {
        return Pattern.matches("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$", r100);
    }

    public static boolean isIpv6(String r100) {
        return Pattern.matches("^\\s*((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4}){1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4}){1,5})|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?\\s*$", r100);
    }

    public static boolean isNetworkAvailable(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean isWifi(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L24;
        NetworkTypeInterceptor r102 = sNetworkTypeInterceptor;     // Catch: Exception -> L20
        if (r102 == null) goto L17;
        if (r102.getNetworkType() == NetworkType.NONE) goto L17;
        if (sNetworkTypeInterceptor.getNetworkType() != NetworkType.WIFI) goto L22;
        return true;
    L22:
        return false;
    L17:
        if (1 != r101.getType()) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L26:
        return false;
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor r100) {
        sNetworkTypeInterceptor = r100;
    }

    public static String getNetworkAccessType(Context r100) {
        return getNetworkAccessType(getNetworkType(r100, null));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    private static String encode(String r100, String r101) {
        if (r101 != null) goto L10;
        r101 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r100, r101);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(List<Pair<String, String>> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator<Pair<String, String>> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Pair<String, String> r104 = r103.next();
        String r105 = encode((String) r104.first, r101);
        String r106 = (String) r104.second;
        if (r106 == null) goto L8;
        String r107 = encode(r106, r101);
    L10:
        if (r102.length() <= 0) goto L12;
        r102.append("&");
    L12:
        r102.append(r105);
        r102.append("=");
        r102.append(r107);
        goto L4
    L8:
        r107 = "";
        goto L10
    L14:
        return r102.toString();
    }

    public static NetworkType getNetworkType(Context r100, Intent r101) {
        NetworkTypeInterceptor r102 = sNetworkTypeInterceptor;
        if (r102 != null) goto L5;
    L47:
        NetworkInfo r103 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L44
        if (r103 != null) goto L11;
    L12:
        if (r103 != null) goto L20;
        if (r101 == null) goto L20;
        r103 = isNetWorkConnected(r100, r101);     // Catch: Throwable -> L44
        if (r103 != null) goto L17;
    L18:
        RXLogging.i(TAG, "-----------info is null");     // Catch: Throwable -> L44
        return NetworkType.NONE;
    L17:
        if (r103.isAvailable() == false) goto L18;
    L20:
        int r104 = r103.getType();     // Catch: Throwable -> L44
        debugInfo = "NetworkInfo type:" + r104;     // Catch: Throwable -> L44
        if (1 == r104) goto L23;
        if (r104 != 0) goto L43;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_PHONE_STATE") != 0) goto L28;
        debugInfo += " getNetworkType through TelephoneManager;";     // Catch: Throwable -> L44
        int r105 = getNetWorkTypeThroughBPEA(r100);     // Catch: Throwable -> L44
    L29:
        debugInfo += " TelephonyManager type:" + r105;     // Catch: Throwable -> L44
        switch(r105) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L37;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L39;
            case 12: goto L37;
            case 13: goto L35;
            case 14: goto L37;
            case 15: goto L37;
            case 16: goto L39;
            case 17: goto L37;
            case 18: goto L35;
            case 19: goto L48;
            case 20: goto L33;
            default: goto L48;
        };     // Catch: Throwable -> L44
    L48:
        return NetworkType.UNKNOWN;
    L33:
        return NetworkType.MOBILE_5G;
    L35:
        return NetworkType.MOBILE_4G;
    L37:
        return NetworkType.MOBILE_3G;
    L39:
        return NetworkType.MOBILE_2G;
    L41:
        return NetworkType.UNKNOWN;
    L28:
        r105 = r103.getSubtype();     // Catch: Throwable -> L44
        debugInfo += " getNetworkType through ConnectivityManager;";     // Catch: Throwable -> L44
        goto L29
    L43:
        return NetworkType.MOBILE;
    L23:
        return NetworkType.WIFI;
    L11:
        if (r103.isAvailable() == true) goto L20;
    L44:
        th = move-exception;
        debugInfo = th.toString();
        return NetworkType.UNKNOWN;
    L5:
        if (r102.getNetworkType() == NetworkType.NONE) goto L47;
        return sNetworkTypeInterceptor.getNetworkType();
    }

    public static NetworkInfo isNetWorkConnected(Context r100, Intent r101) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r101.getAction()) == false) goto L17;
        NetworkInfo r102 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
        if (r102 == null) goto L17;
        if (NetworkInfo.State.CONNECTED == r102.getState()) goto L9;
    L16:
        RXLogging.i(TAG, "------networkInfo is discconnected");
        goto L17
    L9:
        if (r102.isAvailable() == false) goto L16;
        if (r102.getType() != 1) goto L13;
    L14:
        RXLogging.i(TAG, "-------networkInfo wifi or mobile is connected");
    L15:
        return r102;
    L13:
        if (r102.getType() != 0) goto L15;
    L17:
        return null;
    }

    public static void registerReceiver(Context r100, BroadcastReceiver r101) {
        if (r101 == null) goto L11;
        if (r100 == null) goto L12;
        IntentFilter r102 = new IntentFilter();     // Catch: Exception -> L6
        r102.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L6
        r102.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Exception -> L6
        r102.addAction("android.net.wifi.STATE_CHANGE");     // Catch: Exception -> L6
        INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100.getApplicationContext(), r101, r102);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        RXLogging.i(TAG, "registerReceiver error: " + e.getMessage());
        return;
    L12:
        return;
    }

    public static void unregisterReceiver(Context r100, BroadcastReceiver r101) {
        if (r101 == null) goto L11;
        if (r100 == null) goto L12;
        INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r100.getApplicationContext(), r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        RXLogging.i(TAG, "unregisterReceiver error: " + e.getMessage());
        return;
    L12:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_realx_base_NetworkTypeUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
