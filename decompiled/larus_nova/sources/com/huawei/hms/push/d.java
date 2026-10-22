package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f277612a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f277613b = -1;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f277612a = new Object();
    }

    private static boolean a() {
        Class r100 = INVOKESTATIC_com_huawei_hms_push_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("huawei.cust.HwCfgFilePolicy");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L10 IllegalArgumentException -> L11 NoSuchMethodException -> L12 NoSuchFieldException -> L13 SecurityException -> L14 ClassNotFoundException -> L15
        int r101 = ((Integer) r100.getDeclaredField("CUST_TYPE_CONFIG").get(r100)).intValue();     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L10 IllegalArgumentException -> L11 NoSuchMethodException -> L12 NoSuchFieldException -> L13 SecurityException -> L14 ClassNotFoundException -> L15
        File r102 = (File) r100.getDeclaredMethod("getCfgFile", new Class[]{String.class, Integer.TYPE}).invoke(r100, new Object[]{"jars/hwpush.jar", Integer.valueOf(r101)});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L10 IllegalArgumentException -> L11 NoSuchMethodException -> L12 NoSuchFieldException -> L13 SecurityException -> L14 ClassNotFoundException -> L15
        if (r102 != null) goto L6;
    L16:
        return false;
    L6:
        if (r102.exists() == false) goto L16;
        HMSLog.d("CommFun", "get push cust File path success.");     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L10 IllegalArgumentException -> L11 NoSuchMethodException -> L12 NoSuchFieldException -> L13 SecurityException -> L14 ClassNotFoundException -> L15
        return true;
    L15:
        HMSLog.e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
    L10:
        HMSLog.e("CommFun", "check cust exist push IllegalAccessException.");
    L11:
        HMSLog.e("CommFun", "check cust exist push IllegalArgumentException.");
    L13:
        HMSLog.e("CommFun", "check cust exist push NoSuchFieldException.");
    L12:
        HMSLog.e("CommFun", "check cust exist push NoSuchMethodException.");
    L14:
        HMSLog.e("CommFun", "check cust exist push SecurityException.");
    L9:
        HMSLog.e("CommFun", "check cust exist push InvocationTargetException.");
        goto L16
    }

    public static boolean b() {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean c() {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 19) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_push_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static boolean a(Context r100) {
        HMSLog.d("CommFun", "existFrameworkPush:" + f277613b);
        PolarisFileWrapper r101 = new PolarisFileWrapper("/system/framework/hwpush.jar");     // Catch: Exception -> L12
        if (a() == false) goto L8;
        HMSLog.d("CommFun", "push jarFile is exist");     // Catch: Exception -> L12
    L10:
        return true;
    L8:
        if (r101.isFile() == false) goto L16;
        HMSLog.d("CommFun", "push jarFile is exist");     // Catch: Exception -> L12
        goto L10
    L16:
        return false;
    L12:
        e = move-exception;
        HMSLog.e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
        return false;
    }

    public static long b(Context r100) {
        return r100.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
    L4:
        HMSLog.e("CommFun", "get nc versionCode error");
        return -1;
    }

    public static String c(Context r100) {
        return AGConnectServicesConfig.fromContext(r100).getString("client/project_id");
    }

    public static boolean d(Context r100) {
        HMSLog.d("CommFun", "existFrameworkPush:" + f277613b);
        Object r101 = f277612a;
        monitor-enter(r101);
        int r102 = f277613b;     // Catch: Throwable -> L19
        boolean r103 = false;
        if ((-1) == r102) goto L11;
        if (1 != r102) goto L8;
        r103 = true;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L19
        return r103;
    L11:
        if (a(r100) == false) goto L13;
        f277613b = 1;     // Catch: Throwable -> L19
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L19
        if (1 != f277613b) goto L23;
        return true;
    L23:
        return false;
    L13:
        f277613b = 0;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static boolean a(JSONObject r100, JSONObject r101, String r102) {
        if (r100 != null) goto L4;
    L8:
        return true;
    L4:
        if (TextUtils.isEmpty(r102) == false) goto L7;
        if (r101 == null) goto L8;
    L7:
        return false;
    }
}
