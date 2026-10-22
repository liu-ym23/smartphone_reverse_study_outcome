package com.bytedance.common.wschannel.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.TTProcessUtils;
import el9.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    private static String sCurProcessName;

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r100 = INVOKESTATIC_com_bytedance_common_wschannel_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r101 instanceof String) == false) goto L12;
        return (String) r101;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L14
        if (r102 <= 0) goto L9;
        r101.append((char) r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r101.toString());     // Catch: Throwable -> L14
    L11:
        String r103 = r101.toString();     // Catch: Throwable -> L14
        r100.close();     // Catch: Exception -> L19
    L13:
        return r103;
    L16:
        if (r100 != null) goto L27;
    L18:
        return null;
    L27:
        r100.close();     // Catch: Exception -> L20
    L15:
        r100 = null;
        goto L16
    }

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String byte2HexStr(byte[] r100) {
        return byte2HexStr(r100, " ");
    }

    public static String getCurProcessName(Context r100) {
        String r101 = sCurProcessName;
        if (StringUtils.isEmpty(r101) == true) goto L5;
        return r101;
    L5:
        String r102 = getCurrentProcessNameFromApplication();
        sCurProcessName = r102;
        if (StringUtils.isEmpty(r102) == false) goto L8;
        String r103 = getCurrentProcessNameFromActivityThread();
        sCurProcessName = r103;
        if (StringUtils.isEmpty(r103) == false) goto L12;
        String r104 = getCurProcessNameFromProc();
        sCurProcessName = r104;
        if (StringUtils.isEmpty(r104) == false) goto L16;
        String r105 = getCurProcessNameFromActivityManager(r100);
        sCurProcessName = r105;
        return r105;
    L16:
        return sCurProcessName;
    L12:
        return sCurProcessName;
    L8:
        return sCurProcessName;
    }

    private static String getCurProcessNameFromActivityManager(Context r100) {
        String r101 = null;
        if (r100 != null) goto L18;
        return null;
    L18:
        int r102 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r103.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L15
        if (r104.pid != r102) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r104.processName);     // Catch: Exception -> L15
    L13:
        r101 = r104.processName;     // Catch: Exception -> L15
    L17:
        return r101;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String getTimeFormat(long r100) {
        return DateFormat.getDateTimeInstance().format(new Date(r100));
    }

    public static boolean isMainProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isMessageProcess(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L6;
        return true;
    }

    public static Map<String, String> jsonToMap(JSONObject r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L7;
        Object r104 = r100.opt(r103);
        if (r104 != null) goto L14;
        String r105 = null;
    L15:
        r101.put(r103, r105);
        goto L7
    L14:
        r105 = r104.toString();
        goto L15
    L16:
        return r101;
    }

    public static JSONObject mapToJson(Map<String, String> r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
    L17:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, String> r103 = r102.next();
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L9;
        r101.put(r103.getKey(), r103.getValue());     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static String md5(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return "";
    L16:
        byte[] r101 = MessageDigest.getInstance("MD5").digest(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r102 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r103 = r101.length;     // Catch: NoSuchAlgorithmException -> L13
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        String r105 = Integer.toHexString(r101[r104] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L13
        if (r105.length() != 1) goto L10;
        r105 = "0" + r105;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r102.append(r105);     // Catch: NoSuchAlgorithmException -> L13
        r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r102.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String outputThrowableStackTrace(Throwable r100) {
        String r101 = null;
        if (r100 != null) goto L29;
        return null;
    L29:
        StringWriter r102 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r103 = new PrintWriter(r102);     // Catch: Throwable -> L15
        r100.printStackTrace(r103);     // Catch: Throwable -> L13
        Throwable r104 = r100.getCause();     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        r104.printStackTrace(r103);     // Catch: Throwable -> L13
        Throwable r105 = r104.getCause();     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r105.printStackTrace(r103);     // Catch: Throwable -> L13
    L11:
        r101 = r102.toString();     // Catch: Throwable -> L13
    L12:
        r103.close();
    L20:
        return r101;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r103 == null) goto L20;
    L21:
        th = move-exception;
        if (r103 == null) goto L24;
        r103.close();
    L24:
        throw th;
    L15:
        th = th;
        r103 = null;
        goto L25
    }

    public static String byte2HexStr(byte[] r100, String r101) {
        StringBuilder r102 = new StringBuilder("");
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L10;
        String r104 = Integer.toHexString(r100[r103] & UByte.MAX_VALUE);
        if (r104.length() != 1) goto L8;
        r104 = "0".concat(r104);
    L8:
        r102.append(r104);
        r102.append(r101);
        r103 = r103 + 1;
        goto L4
    L10:
        return r102.toString().toUpperCase().trim();
    }

    public static boolean isMainProcess(Context r100, String r101) {
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isServiceRunning(Context r100, Class<? extends Service> r101) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L20;
        Iterator<ActivityManager.RunningServiceInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();     // Catch: Exception -> L18
    L8:
        if (r102.hasNext() == false) goto L20;
        ActivityManager.RunningServiceInfo r103 = r102.next();     // Catch: Exception -> L18
        if (r103 == null) goto L8;
        if (r103.service == null) goto L8;
        if (TextUtils.equals(r101.getName(), r103.service.getClassName()) == false) goto L8;
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_wschannel_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
