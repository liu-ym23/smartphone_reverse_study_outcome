package com.ss.android.socialbase.appdownloader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.depend.IPrivacyPolicyCallback;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import el9.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class SecurityUtils {
    private static final String TAG = "SecurityUtils";
    private static Boolean isSecure;

    public SecurityUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static int getRoSecureProp() {
        String r100 = null;
        Object r101 = INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_SecurityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{decode("726f2e736563757265")});     // Catch: Exception -> L7
        if (r101 == null) goto L8;
        r100 = (String) r101;     // Catch: Exception -> L7
    L8:
        if (r100 != null) goto L11;
    L9:
        return 1;
    L11:
        if ("0".equals(r100) == false) goto L9;
        return 0;
    }

    private static boolean isSUExist() {
        String[] r100 = {decode("2f7362696e2f7375"), decode("2f73797374656d2f62696e2f7375"), decode("2f73797374656d2f7862696e2f7375"), decode("2f646174612f6c6f63616c2f7862696e2f7375"), decode("2f646174612f6c6f63616c2f62696e2f7375"), decode("2f73797374656d2f73642f7862696e2f7375"), decode("2f73797374656d2f62696e2f6661696c736166652f7375"), decode("2f646174612f6c6f63616c2f7375")};     // Catch: Exception -> L10
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L9;
        if (new PolarisFileWrapper(r100[r101]).exists() == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return true;
    L9:
        return false;
    }

    private static boolean findHookAppFile() {
        HashSet r100 = new HashSet();     // Catch: Exception -> L25
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/maps"));     // Catch: Exception -> L25
    L4:
        String r102 = r101.readLine();     // Catch: Exception -> L25
        if (r102 == null) goto L11;
        if (r102.endsWith(".so") == true) goto L10;
        if (r102.endsWith(".jar") == false) goto L4;
    L10:
        r100.add(r102.substring(r102.lastIndexOf(" ") + 1));     // Catch: Exception -> L25
        goto L4
    L11:
        r101.close();     // Catch: Exception -> L25
        Iterator r103 = r100.iterator();     // Catch: Exception -> L25
    L12:
        if (r103.hasNext() == false) goto L39;
        String r104 = (String) r103.next();     // Catch: Exception -> L25
        if (r104.contains(decode("636f6d2e73617572696b2e737562737472617465")) == true) goto L16;
        if (r104.contains(decode("58706f7365644272696467652e6a6172")) == true) goto L19;
        if (r104.contains(decode("6c696273616e64686f6f6b2e656478702e736f")) == false) goto L12;
        return true;
    L19:
        return true;
    L16:
        return true;
    L39:
        return false;
    L23:
        return false;
    }

    public static boolean isFridaExist() {
        InetAddress.getByName(decode("3132372e302e302e31"));     // Catch: IOException -> L6
        new Socket("3132372e302e302e31", CastIntegerProtector.parseInt(decode("3237303432")));     // Catch: IOException -> L6
        return true;
    L6:
        return false;
    }

    public static boolean isSecure() {
        Boolean r100 = isSecure;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.booleanValue() == true) goto L8;
        return false;
    }

    public static boolean isRoot() {
        if (getRoSecureProp() != 0) goto L7;
        return true;
    L7:
        return isSUExist();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_appdownloader_util_SecurityUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    private static String decode(String r100) {
        return DownloadUtils.hexToString(r100);
    }

    private static boolean findHookAppName(Context r100) {
        List r101 = Arrays.asList(new String[]{decode("64652e726f62762e616e64726f69642e78706f736564"), decode("636f6d2e746f706a6f686e77752e6d616769736b"), decode("696f2e76612e6578706f736564"), decode("636f6d2e77696e642e636f74746572"), decode("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), decode("6d652e7765697368752e657870"), decode("636f6d2e73617572696b2e737562737472617465")});
        PackageManager r102 = r100.getPackageManager();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        if (r102.getPackageInfo((String) r103.next(), 0) == null) goto L4;
        return true;
    L10:
        return false;
    }

    public static boolean hasSimCard(Context r100) {
        int r101 = ((TelephonyManager) r100.getSystemService("phone")).getSimState();     // Catch: Throwable -> L9
        if (r101 == 1) goto L12;
        if (r101 == 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static synchronized void init(Context r100) {
        monitor-enter(SecurityUtils.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (isSecure == null) goto L37;
    L31:
        monitor-exit(SecurityUtils.class);
        return;
    L37:
        IPrivacyPolicyCallback r101 = AppDownloader.getInstance().getPrivacyPolicyCallback();     // Catch: Exception -> L29 Throwable -> L33
        if (r101 == null) goto L14;
        if (r101.isUserAgreePrivacyPolicy() == true) goto L14;
        isSecure = Boolean.FALSE;     // Catch: Exception -> L29 Throwable -> L33
        Logger.globalError(TAG, "init", "Before UserAgreePrivacyPolicy");     // Catch: Exception -> L29 Throwable -> L33
        monitor-exit(SecurityUtils.class);
        return;
    L14:
        if (isRoot() == false) goto L16;
    L26:
        boolean r102 = false;
    L27:
        isSecure = Boolean.valueOf(r102);     // Catch: Exception -> L29 Throwable -> L33
        goto L31
    L16:
        if (isDebug(r100) == true) goto L26;
        if (isUsbCharging(r100) == true) goto L26;
        if (hasSimCard(r100) == false) goto L26;
        if (isFridaExist() == true) goto L26;
        if (isXposedExist(r100) == true) goto L26;
        r102 = true;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        goto L31
    }

    public static boolean isDebug(Context r100) {
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static boolean isUsbCharging(Context r100) {
        if (RomUtils.isEmui() == true) goto L5;
    L7:
        Intent r101 = INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_util_SecurityUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.getIntExtra("plugged", -1) != 2) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (Build.VERSION.SDK_INT > 23) goto L7;
        return false;
    }

    public static boolean isXposedExist(Context r100) {
        if (findHookAppFile() == false) goto L5;
        return true;
    L5:
        if (findHookAppName(r100) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_util_SecurityUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
