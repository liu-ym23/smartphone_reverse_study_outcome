package jaa;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f497959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Keva f497960b;

    static {
        f497959a = new a();
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static boolean c(Context r110) {
        Context r100 = r110.getApplicationContext();
        if (r100 == null) goto L7;
        r110 = r100;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L50;
        String r101 = Application.getProcessName();
    L46:
        String r111 = r110.getPackageName();
        boolean r102 = Intrinsics.areEqual(r101, r111);
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: Process detection: current=" + r101 + ", main=" + r111 + ", isHost=" + r102);
        return r102;
    L50:
        Object r103 = a().getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
        r101 = (String) r103;     // Catch: Exception -> L12
    L12:
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Exception -> L45
        r101 = r104.readLine();     // Catch: Throwable -> L40
        if (r101 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        if (r105 == true) goto L38;
        int r106 = r101.length() - 1;     // Catch: Throwable -> L40
        int r107 = 0;
        boolean r108 = false;
    L22:
        if (r107 > r106) goto L37;
        if (r108 == true) goto L25;
        int r109 = r107;
    L27:
        if (Intrinsics.compare(r101.charAt(r109), 32) > 0) goto L29;
        boolean r112 = true;
    L30:
        if (r108 == false) goto L31;
        if (r112 == false) goto L37;
        r106 = r106 - 1;     // Catch: Throwable -> L40
        goto L22
    L31:
        if (r112 == false) goto L32;
        r107 = r107 + 1;     // Catch: Throwable -> L40
        goto L22
    L32:
        r108 = true;
        goto L22
    L29:
        r112 = false;
        goto L30
    L25:
        r109 = r106;
    L37:
        r101 = r101.subSequence(r107, r106 + 1).toString();     // Catch: Throwable -> L40
    L38:
        CloseableKt.closeFinally(r104, null);     // Catch: Exception -> L45
        goto L46
    L16:
        if (r101.length() == 0) goto L19;
        r105 = false;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "SharedRepo: getCurrentProcessName: failed all methods, returning null", null, 4, null);
        r101 = null;
        goto L46
    }

    public static boolean d(Keva r110) {
        Class<?> r100 = r110.getClass();     // Catch: Exception -> L16
    L4:
        if (r100 == null) goto L8;
        Field r101 = r100.getDeclaredField("mHandle");     // Catch: NoSuchFieldException -> L7 Exception -> L16
    L9:
        if (r101 != null) goto L12;
        SharedStateLogger.INSTANCE.d(SharedStateLogger.TAG, "isRepoHealthy: mHandle not found on " + r110.getClass().getName() + ", assume healthy");     // Catch: Exception -> L16
        return true;
    L12:
        r101.setAccessible(true);     // Catch: Exception -> L16
        if (r101.getLong(r110) != 0) goto L24;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "isRepoHealthy: " + r110.getClass().getName() + " mHandle=0 (native load failed)", null, 4, null);     // Catch: Exception -> L16
        return false;
    L24:
        return true;
    L7:
        r100 = r100.getSuperclass();     // Catch: Exception -> L16
        goto L4
    L8:
        r101 = null;
    L16:
        e = move-exception;
        SharedStateLogger.INSTANCE.d(SharedStateLogger.TAG, "isRepoHealthy: probe failed, assume healthy: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        return true;
    }

    public final Keva b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Keva r101 = f497960b;
        if (r101 == null) goto L5;
        return r101;
    L5:
        monitor-enter(this);
        Keva r102 = f497960b;     // Catch: Throwable -> L31
        if (r102 == null) goto L10;
        monitor-exit(this);
        return r102;
    L10:
        Context r103 = r100.getApplicationContext();     // Catch: Throwable -> L31
        if (r103 == null) goto L15;
        r100 = r103;
    L15:
        if (c(r100) == false) goto L17;
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: getOrCreate[host]: filesDir=" + r100.getFilesDir());     // Catch: Throwable -> L31
        Keva r104 = Keva.getRepo("obric_shared_state", 1);     // Catch: Throwable -> L31
    L25:
        if (d(r104) == false) goto L29;
        f497960b = r104;     // Catch: Throwable -> L31
        monitor-exit(this);
        return r104;
    L29:
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "SharedRepo: repo is an empty shell (native handle=0, load failed)", null, 4, null);     // Catch: Throwable -> L31
        throw new IllegalStateException("SharedRepo: native handle=0, shared repo load failed");     // Catch: Throwable -> L31
    L17:
        File r105 = r100.getFilesDir().getParentFile();     // Catch: Throwable -> L31
        if (r105 != null) goto L20;
        r105 = r100.getFilesDir();     // Catch: Throwable -> L31
    L20:
        File r106 = r105.getCanonicalFile();     // Catch: Throwable -> L31
        File r107 = r100.getFilesDir().getParentFile();     // Catch: Throwable -> L31
        if (r107 != null) goto L23;
        r107 = r100.getFilesDir();     // Catch: Throwable -> L31
    L23:
        PolarisFileWrapper r108 = new PolarisFileWrapper(new PolarisFileWrapper(r107.getCanonicalFile(), "keva").getCanonicalFile(), "repo");     // Catch: Throwable -> L31
        String r109 = e(r106, r108);     // Catch: Throwable -> L31
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: getOrCreate[plugin]: base=" + r106 + ", targetRepoDir=" + r108 + ", relPath=\"" + r109 + Typography.quote);     // Catch: Throwable -> L31
        r104 = Keva.getRepoSyncWithPath("obric_shared_state", r109, 1);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static String e(File r110, PolarisFileWrapper r111) {
        List r100 = StringsKt.split$default(r110.getCanonicalPath(), new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L3:
        boolean r103 = false;
        boolean r104 = true;
        if (r102.hasNext() == false) goto L10;
        Object r105 = r102.next();
        if (((String) r105).length() <= 0) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L3;
        r101.add(r105);
        goto L3
    L10:
        List r112 = StringsKt.split$default(r111.getCanonicalPath(), new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r106 = new ArrayList();
        Iterator r113 = r112.iterator();
    L12:
        if (r113.hasNext() == false) goto L19;
        Object r107 = r113.next();
        if (((String) r107).length() <= 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L12;
        r106.add(r107);
        goto L12
    L16:
        r108 = false;
        goto L17
    L19:
        int r114 = 0;
    L21:
        if (r114 >= r101.size()) goto L27;
        if (r114 >= r106.size()) goto L27;
        if (Intrinsics.areEqual(ListProtector.get(r101, r114), ListProtector.get(r106, r114)) == false) goto L27;
        r114 = r114 + 1;
    L27:
        ArrayList r109 = new ArrayList();
        int r115 = r101.size();
        int r116 = r114;
    L28:
        if (r116 >= r115) goto L30;
        r109.add(DownloadConstants.VULNERABILITY_PATH);
        r116 = r116 + 1;
        goto L28
    L30:
        int r117 = r106.size();
    L31:
        if (r114 >= r117) goto L33;
        r109.add(ListProtector.get(r106, r114));
        r114 = r114 + 1;
        goto L31
    L33:
        String r118 = CollectionsKt.joinToString$default(r109, HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
        if ((!StringsKt.startsWith$default(r118, HTTP.URL_DEFAULT, false, 2, null)) == false) goto L45;
        if (r118.length() > 0) goto L39;
        r104 = false;
    L39:
        if (r104 == true) goto L41;
        return r118;
    L41:
        if (StringsKt.endsWith$default(r118, HTTP.URL_DEFAULT, false, 2, null) == false) goto L43;
        return r118;
    L43:
        return r118.concat(HTTP.URL_DEFAULT);
    L45:
        throw new IllegalArgumentException(("relPath must be relative: " + r118).toString());
    }
}
