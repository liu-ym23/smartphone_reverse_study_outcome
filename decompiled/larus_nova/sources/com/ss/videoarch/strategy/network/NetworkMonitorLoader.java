package com.ss.videoarch.strategy.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class NetworkMonitorLoader {
    private static String TAG = "NetworkMonitorLoader";
    static HashMap<String, ArrayList<String>> mFlavorReflection;

    public static class NetworkMonitorInstance {
        private static final NetworkMonitorLoader instance = null;
        private static final INetworkMonitor monitor = null;

        private NetworkMonitorInstance() {
        }

        static {
            instance = new NetworkMonitorLoader();
            monitor = (INetworkMonitor) NetworkMonitorLoader.access$000("full", "NetworkMonitor");
        }

        public static /* synthetic */ NetworkMonitorLoader access$100() {
            return instance;
        }

        public static /* synthetic */ INetworkMonitor access$200() {
            return monitor;
        }
    }

    public NetworkMonitorLoader() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mFlavorReflection = new HashMap();
        ArrayList<String> r100 = new ArrayList();
        ArrayList<String> r101 = new ArrayList();
        r100.add("com.ss.videoarch.strategy.base.NetworkMonitor");
        r101.add("com.ss.videoarch.strategy.network.NetworkMonitor");
        mFlavorReflection.put("tob", r100);
        mFlavorReflection.put("full", r101);
    }

    public static NetworkMonitorLoader inst() {
        return NetworkMonitorInstance.access$100();
    }

    public static INetworkMonitor monitorInst() {
        return NetworkMonitorInstance.access$200();
    }

    public int getNetworkType() {
        if (NetworkMonitorInstance.access$200() != null) goto L7;
        return -1;
    L7:
        return NetworkMonitorInstance.access$200().getNetworkType();
    }

    public String getStringNetworkType() {
        int r100 = getNetworkType();
        if (r100 != 1) goto L5;
        String r101 = "mobile";
    L19:
        return r101.toUpperCase();
    L5:
        if (r100 != 2) goto L7;
        r101 = CJPayBasicUtils.NETWORK_2G;
        goto L19
    L7:
        if (r100 != 3) goto L9;
        r101 = CJPayBasicUtils.NETWORK_3G;
        goto L19
    L9:
        if (r100 != 4) goto L11;
        r101 = "wifi";
        goto L19
    L11:
        if (r100 == 5) goto L13;
        r101 = UserProfileEvent.POSITION_NONE;
        goto L19
    L13:
        r101 = CJPayBasicUtils.NETWORK_4G;
        goto L19
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_videoarch_strategy_network_NetworkMonitorLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static int getNativeNetworkType(Context r100) {
        NetworkInfo r101 = getNetworkInfo(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L16;
        int r102 = !r101.isAvailable() ? 1 : 0;     // Catch: Throwable -> L12
        int r103 = r101.getType();     // Catch: Throwable -> L12
        if (1 != r103) goto L8;
        return 2;
    L8:
        if (r103 != 0) goto L11;
        return 3;
    L11:
        return r102;
    L16:
        return 1;
    L12:
        return 0;
    }

    public static NetworkInfo getNetworkInfo(Context r100) {
        return ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_ss_videoarch_strategy_network_NetworkMonitorLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    private static Object LoadClass(String r100, String r101) {
        ArrayList<String> r102 = mFlavorReflection.get(r100);     // Catch: Exception -> L18
        Objects.requireNonNull(r102);     // Catch: Exception -> L18
        Iterator<String> r103 = r102.iterator();     // Catch: Exception -> L18
    L5:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();     // Catch: Exception -> L18
        if (r104.contains(r101) == false) goto L5;
        Class r105 = INVOKESTATIC_com_ss_videoarch_strategy_network_NetworkMonitorLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r104);     // Catch: ClassNotFoundException -> L15 Exception -> L18
    L10:
        ClassLoader r106 = r105.getClassLoader();     // Catch: Exception -> L18
        if (r106 != null) goto L13;
        return null;
    L13:
        INVOKEVIRTUAL_com_ss_videoarch_strategy_network_NetworkMonitorLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r106, r105.getName());     // Catch: Exception -> L18
        return r105.newInstance();
    L15:
        e = move-exception;
        e.getMessage();     // Catch: Exception -> L18
    L20:
        return null;
    L18:
        e = move-exception;
        e.getMessage();
        goto L20
    }

    public static /* synthetic */ Object access$000(String r100, String r101) {
        return LoadClass(r100, r101);
    }
}
