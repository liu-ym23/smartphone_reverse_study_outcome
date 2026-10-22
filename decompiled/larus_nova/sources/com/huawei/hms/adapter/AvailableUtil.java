package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class AvailableUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f276872a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f276873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f276874c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f276875a;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_adapter_AvailableUtil$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_adapter_AvailableUtil$a__run$___twin___() {
            HMSLog.i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (AvailableUtil.isInstallerLibExist(this.f276875a) == true) goto L6;
            AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
            HMSLog.e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
            return;
        L6:
            UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f276875a});
            HMSLog.i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
        }

        public a(Context r100) {
            this.f276875a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_adapter_AvailableUtil$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_adapter_AvailableUtil$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AvailableUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f276872a = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_adapter_AvailableUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void asyncCheckHmsUpdateInfo(Context r100) {
        if (HmsCheckedState.UNCHECKED == AgHmsUpdateState.getInstance().getCheckedState()) goto L6;
        HMSLog.i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        return;
    L6:
        new Thread(new a(r100), "Thread-asyncCheckHmsV3UpdateInfo").start();
    }

    public static boolean isInstallerLibExist(Context r100) {
        if (f276873b == false) goto L6;
        HMSLog.i("AvailableUtil", "installerInit exist: " + f276874c);
        return f276874c;
    L6:
        Object r101 = f276872a;
        monitor-enter(r101);
    L35:
        th = move-exception;
        throw th;
    L9:
        if (f276873b == true) goto L32;
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L35
        if (r102 != null) goto L42;
        HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");     // Catch: Throwable -> L35
        INVOKESTATIC_com_huawei_hms_adapter_AvailableUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.hms.update.manager.UpdateManager");     // Catch: ClassNotFoundException -> L15 Throwable -> L35
    L14:
        boolean r103 = true;
    L31:
        f276874c = r103;     // Catch: Throwable -> L35
        f276873b = true;     // Catch: Throwable -> L35
        goto L32
    L15:
        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");     // Catch: Throwable -> L35
    L30:
        r103 = false;
        goto L31
    L42:
        ApplicationInfo r104 = r102.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L27 AndroidException -> L29 Throwable -> L35
        if (r104 == null) goto L30;
        Bundle r105 = r104.metaData;     // Catch: RuntimeException -> L27 AndroidException -> L29 Throwable -> L35
        if (r105 == null) goto L30;
        Object r106 = r105.get("availableHMSCoreInstaller");     // Catch: RuntimeException -> L27 AndroidException -> L29 Throwable -> L35
        if (r106 == null) goto L30;
        if (String.valueOf(r106).equalsIgnoreCase(BdpAppEventConstant.YES) == false) goto L30;
        HMSLog.i("AvailableUtil", "available exist: true");     // Catch: RuntimeException -> L27 AndroidException -> L29 Throwable -> L35
    L29:
        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");     // Catch: Throwable -> L35
    L27:
        e = move-exception;
        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e);     // Catch: Throwable -> L35
    L32:
        monitor-exit(r101);     // Catch: Throwable -> L35
        HMSLog.i("AvailableUtil", "available exist: " + f276874c);
        return f276874c;
    }
}
