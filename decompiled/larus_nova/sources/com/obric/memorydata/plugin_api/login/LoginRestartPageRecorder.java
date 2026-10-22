package com.obric.memorydata.plugin_api.login;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Parcel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class LoginRestartPageRecorder {
    private static final Object LOCK = null;
    private static final String MEMORYDATA_PROCESS_SUFFIX = ":memorydata";
    private static final String TAG = "LoginRestartRecorder";
    private static final Set<String> TRANSIENT_ACTIVITY_SIMPLE_NAMES = null;
    private static byte[] pendingIntentBytes;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        LOCK = new Object();
        TRANSIENT_ACTIVITY_SIMPLE_NAMES = new HashSet(Arrays.asList(new String[]{"AuthProxyActivity", "LoginRestartRelayActivity", "DataImportSuccessActivity", "DataMigrationActivity", "DataTransferActivity", "DataExportActivity", "MemoryExportActivity", "MemoryImportActivity", "MemoryBuildDataPackageActivity", "MemoryShareActivity", "ActiveMemoryConfirmDialogActivity", "PermissionActivity", "PermissionTestActivity", "SearchPermissionCheckDebugActivity", "PasswordVerifyTestActivity", "ScannerActivity"}));
    }

    public static void clear() {
        Object r100 = LOCK;
        monitor-enter(r100);
        pendingIntentBytes = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static byte[] consumeIntentBytes() {
        Object r100 = LOCK;
        monitor-enter(r100);
        byte[] r101 = pendingIntentBytes;     // Catch: Throwable -> L7
        pendingIntentBytes = null;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getCurrentProcessName() {
        if (Build.VERSION.SDK_INT < 28) goto L14;
        return Application.getProcessName();
    L14:
        Object r100 = INVOKESTATIC_com_obric_memorydata_plugin_api_login_LoginRestartPageRecorder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L12
        if ((r100 instanceof String) == false) goto L16;
        return (String) r100;
    L16:
        return null;
    L13:
        return null;
    }

    private LoginRestartPageRecorder() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_memorydata_plugin_api_login_LoginRestartPageRecorder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean capture(Activity r100) {
        if (isRecoverableActivity(r100) == true) goto L6;
        clear();
        return false;
    L6:
        Intent r101 = r100.getIntent();
        if (r101 != null) goto L10;
        clear();
        return false;
    L10:
        byte[] r102 = marshalIntent(r101);
        if (r102 != null) goto L13;
    L23:
        clear();
        return false;
    L13:
        if (r102.length <= 0) goto L23;
        Object r103 = LOCK;
        monitor-enter(r103);
        pendingIntentBytes = r102;     // Catch: Throwable -> L20
        monitor-exit(r103);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    private static boolean isRecoverableActivity(Activity r100) {
        if (r100.isFinishing() == false) goto L5;
    L13:
        return false;
    L5:
        if (r100.isDestroyed() == true) goto L13;
        ComponentName r101 = r100.getComponentName();
        if (r101 != null) goto L15;
        return false;
    L15:
        ActivityInfo r102 = r100.getPackageManager().getActivityInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        return isRecoverablePage(r100.getPackageName(), getCurrentProcessName(), r102.processName, r100.getClass().getName(), r101.getClassName());
    }

    private static boolean isTransientActivity(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.isEmpty() == true) goto L13;
        int r101 = r100.lastIndexOf(46);
        if (r101 < 0) goto L10;
        r100 = r100.substring(r101 + 1);
    L10:
        return TRANSIENT_ACTIVITY_SIMPLE_NAMES.contains(r100);
    L13:
        return false;
    }

    public static byte[] marshalIntent(Intent r100) {
        Parcel r101 = Parcel.obtain();
        r100.writeToParcel(r101, 0);     // Catch: Throwable -> L6 RuntimeException -> L9
        byte[] r102 = r101.marshall();     // Catch: Throwable -> L6 RuntimeException -> L9
        r101.recycle();
        return r102;
    L9:
        r101.recycle();
        return null;
    L6:
        th = move-exception;
        r101.recycle();
        throw th;
    }

    public static boolean isRecoverablePage(String r100, String r101, String r102, String r103, String r104) {
        String r105 = r100 + MEMORYDATA_PROCESS_SUFFIX;
        if (r105.equals(r101) == true) goto L5;
    L11:
        return false;
    L5:
        if (r105.equals(r102) == false) goto L11;
        if (isTransientActivity(r103) == true) goto L11;
        if (isTransientActivity(r104) == true) goto L11;
        return true;
    }
}
