package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class WorkSourceUtil {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final int f274607zza = 0;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static final Method f274608zzb = null;
    private static final Method zzc = null;
    private static final Method zzd = null;
    private static final Method zze = null;
    private static final Method zzf = null;
    private static final Method zzg = null;
    private static final Method zzh = null;
    private static final Method zzi = null;
    private static Boolean zzj;

    private WorkSourceUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f274607zza = Process.myUid();
        Method r100 = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});     // Catch: Exception -> L5
    L6:
        f274608zzb = r100;
        if (PlatformVersion.isAtLeastJellyBeanMR2() == true) goto L58;
    L10:
        Method r101 = null;
    L11:
        zzc = r101;
        Method r102 = WorkSource.class.getMethod("size", new Class[0]);     // Catch: Exception -> L14
    L15:
        zzd = r102;
        Method r103 = WorkSource.class.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{Integer.TYPE});     // Catch: Exception -> L18
    L19:
        zze = r103;
        if (PlatformVersion.isAtLeastJellyBeanMR2() == true) goto L48;
    L24:
        Method r104 = null;
    L25:
        zzf = r104;
        if (PlatformVersion.isAtLeastP() == true) goto L62;
    L30:
        Method r105 = null;
    L31:
        zzg = r105;
        if (PlatformVersion.isAtLeastP() == true) goto L60;
    L36:
        Method r106 = null;
    L37:
        zzh = r106;
        if (PlatformVersion.isAtLeastP() == true) goto L52;
    L42:
        Method r107 = null;
    L43:
        zzi = r107;
        zzj = null;
        return;
    L52:
        r107 = WorkSource.class.getMethod("isEmpty", new Class[0]);     // Catch: Exception -> L46
        r107.setAccessible(true);     // Catch: Exception -> L45
        goto L43
    L60:
        r106 = INVOKESTATIC_com_google_android_gms_common_util_WorkSourceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});     // Catch: Exception -> L35
    L62:
        r105 = WorkSource.class.getMethod("createWorkChain", new Class[0]);     // Catch: Exception -> L29
    L48:
        r104 = WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});     // Catch: Exception -> L23
    L18:
        r103 = null;
    L14:
        r102 = null;
        goto L15
    L58:
        r101 = WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});     // Catch: Exception -> L47
    L5:
        r100 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_android_gms_common_util_WorkSourceUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static List<String> getNames(WorkSource r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        if (r100 != null) goto L5;
        int r103 = 0;
    L6:
        if (r103 == 0) goto L12;
    L7:
        if (r102 >= r103) goto L12;
        String r104 = getName(r100, r102);
        if (Strings.isEmptyOrWhitespace(r104) == true) goto L11;
        Preconditions.checkNotNull(r104);
        r101.add(r104);
    L11:
        r102 = r102 + 1;
    L12:
        return r101;
    L5:
        r103 = size(r100);
        goto L6
    }

    public static synchronized boolean hasWorkSourcePermission(Context r100) {
        monitor-enter(WorkSourceUtil.class);
        Boolean r101 = zzj;     // Catch: Throwable -> L19
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();     // Catch: Throwable -> L19
        monitor-exit(WorkSourceUtil.class);
        return r102;
    L9:
        boolean r103 = false;
        if (r100 != null) goto L14;
        monitor-exit(WorkSourceUtil.class);
        return false;
    L14:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.UPDATE_DEVICE_STATS") != 0) goto L16;
        r103 = true;
    L16:
        Boolean r104 = Boolean.valueOf(r103);     // Catch: Throwable -> L19
        zzj = r104;     // Catch: Throwable -> L19
        boolean r105 = r104.booleanValue();     // Catch: Throwable -> L19
        monitor-exit(WorkSourceUtil.class);
        return r105;
    L19:
        th = move-exception;
        throw th;
    }

    public static boolean isEmpty(WorkSource r100) {
        Method r101 = zzi;
        if (r101 == null) goto L8;
        Object r102 = r101.invoke(r100, new Object[0]);     // Catch: Exception -> L6
        Preconditions.checkNotNull(r102);     // Catch: Exception -> L6
        return ((Boolean) r102).booleanValue();
    L8:
        if (size(r100) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static int size(WorkSource r100) {
        Method r101 = zzd;
        if (r101 != null) goto L8;
    L6:
        return 0;
    L8:
        Object r102 = r101.invoke(r100, new Object[0]);     // Catch: Exception -> L7
        Preconditions.checkNotNull(r102);     // Catch: Exception -> L7
        return ((Integer) r102).intValue();
    }

    public static WorkSource fromPackage(Context r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (r100.getPackageManager() == null) goto L14;
        if (r101 == null) goto L14;
        ApplicationInfo r102 = Wrappers.packageManager(r100).getApplicationInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r102 != null) goto L11;
        "Could not get applicationInfo from package: ".concat(r101);
        return null;
    L11:
        int r103 = r102.uid;
        WorkSource r104 = new WorkSource();
        add(r104, r103, r101);
        return r104;
    L13:
        "Could not find package: ".concat(r101);
        goto L14
    }

    public static int get(WorkSource r100, int r101) {
        Method r102 = zze;
        if (r102 != null) goto L9;
    L7:
        return 0;
    L9:
        Object r103 = r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L8
        Preconditions.checkNotNull(r103);     // Catch: Exception -> L8
        return ((Integer) r103).intValue();
    }

    public static String getName(WorkSource r100, int r101) {
        Method r102 = zzf;
        if (r102 != null) goto L10;
        return null;
    L10:
        return (String) r102.invoke(r100, new Object[]{Integer.valueOf(r101)});
    L12:
        return null;
    }

    public static void add(WorkSource r100, int r101, String r102) {
        Method r103 = zzc;
        if (r103 == null) goto L9;
        if (r102 != null) goto L17;
        r102 = "";
    L17:
        r103.invoke(r100, new Object[]{Integer.valueOf(r101), r102});     // Catch: Exception -> L13
        return;
    L19:
        return;
    L9:
        Method r104 = f274608zzb;
        if (r104 == null) goto L20;
        r104.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L14
        return;
    L21:
        return;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context r100, String r101, String r110) {
        if (r100 != null) goto L5;
    L29:
        return null;
    L5:
        if (r100.getPackageManager() == null) goto L29;
        if (r110 == null) goto L29;
        if (r101 == null) goto L29;
        int r102 = -1;
        ApplicationInfo r103 = Wrappers.packageManager(r100).getApplicationInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r103 != null) goto L13;
        "Could not get applicationInfo from package: ".concat(r101);
    L15:
        if (r102 >= 0) goto L17;
        return null;
    L17:
        WorkSource r104 = new WorkSource();
        Method r105 = zzg;
        if (r105 == null) goto L27;
        Method r106 = zzh;
        if (r106 == null) goto L27;
        Object r107 = r105.invoke(r104, new Object[0]);     // Catch: Exception -> L30
        int r108 = f274607zza;     // Catch: Exception -> L30
        if (r102 == r108) goto L25;
        r106.invoke(r107, new Object[]{Integer.valueOf(r102), r101});     // Catch: Exception -> L30
    L25:
        r106.invoke(r107, new Object[]{Integer.valueOf(r108), r110});     // Catch: Exception -> L30
    L28:
        return r104;
    L27:
        add(r104, r102, r101);
        goto L28
    L13:
        r102 = r103.uid;
    L14:
        "Could not find package: ".concat(r101);
        goto L15
    }
}
