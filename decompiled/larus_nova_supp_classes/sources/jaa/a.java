package jaa;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.aiagent.sharedstate.log.SharedStateLogger;
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
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final a a = null;
    public static volatile Keva b;

    static {
        a = new a();
    }

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static boolean c(Context r10) {
        Context r0 = r10.getApplicationContext();
        if (r0 == null) goto L7;
        r10 = r0;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L50;
        String r1 = Application.getProcessName();
    L46:
        String r11 = r10.getPackageName();
        boolean r2 = Intrinsics.areEqual(r1, r11);
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: Process detection: current=" + r1 + ", main=" + r11 + ", isHost=" + r2);
        return r2;
    L50:
        Object r3 = a().getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L12
        r1 = (String) r3;     // Catch: Exception -> L12
    L12:
        BufferedReader r4 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + Process.myPid() + "/cmdline"));     // Catch: Exception -> L45
        r1 = r4.readLine();     // Catch: Throwable -> L40
        if (r1 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L38;
        int r6 = r1.length() - 1;     // Catch: Throwable -> L40
        int r7 = 0;
        boolean r8 = false;
    L22:
        if (r7 > r6) goto L37;
        if (r8 == true) goto L25;
        int r9 = r7;
    L27:
        if (Intrinsics.compare(r1.charAt(r9), 32) > 0) goto L29;
        boolean r12 = true;
    L30:
        if (r8 == false) goto L31;
        if (r12 == false) goto L37;
        r6 = r6 - 1;     // Catch: Throwable -> L40
        goto L22
    L31:
        if (r12 == false) goto L32;
        r7 = r7 + 1;     // Catch: Throwable -> L40
        goto L22
    L32:
        r8 = true;
        goto L22
    L29:
        r12 = false;
        goto L30
    L25:
        r9 = r6;
    L37:
        r1 = r1.subSequence(r7, r6 + 1).toString();     // Catch: Throwable -> L40
    L38:
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L45
        goto L46
    L16:
        if (r1.length() == 0) goto L19;
        r5 = false;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "SharedRepo: getCurrentProcessName: failed all methods, returning null", null, 4, null);
        r1 = null;
        goto L46
    }

    public static boolean d(Keva r13) {
        Class<?> r2 = r13.getClass();     // Catch: Exception -> L16
    L4:
        if (r2 == null) goto L8;
        Field r3 = r2.getDeclaredField("mHandle");     // Catch: NoSuchFieldException -> L7 Exception -> L16
    L9:
        if (r3 != null) goto L12;
        SharedStateLogger.INSTANCE.d(SharedStateLogger.TAG, "isRepoHealthy: mHandle not found on " + r13.getClass().getName() + ", assume healthy");     // Catch: Exception -> L16
        return true;
    L12:
        r3.setAccessible(true);     // Catch: Exception -> L16
        if (r3.getLong(r13) != 0) goto L24;
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "isRepoHealthy: " + r13.getClass().getName() + " mHandle=0 (native load failed)", null, 4, null);     // Catch: Exception -> L16
        return false;
    L24:
        return true;
    L7:
        r2 = r2.getSuperclass();     // Catch: Exception -> L16
        goto L4
    L8:
        r3 = null;
    L16:
        e = move-exception;
        SharedStateLogger.INSTANCE.d(SharedStateLogger.TAG, "isRepoHealthy: probe failed, assume healthy: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        return true;
    }

    public final Keva b(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Keva r2 = b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        monitor-enter(this);
        Keva r3 = b;     // Catch: Throwable -> L31
        if (r3 == null) goto L10;
        monitor-exit(this);
        return r3;
    L10:
        Context r4 = r8.getApplicationContext();     // Catch: Throwable -> L31
        if (r4 == null) goto L15;
        r8 = r4;
    L15:
        if (c(r8) == false) goto L17;
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: getOrCreate[host]: filesDir=" + r8.getFilesDir());     // Catch: Throwable -> L31
        Keva r9 = Keva.getRepo("obric_shared_state", 1);     // Catch: Throwable -> L31
    L25:
        if (d(r9) == false) goto L29;
        b = r9;     // Catch: Throwable -> L31
        monitor-exit(this);
        return r9;
    L29:
        SharedStateLogger.w$default(SharedStateLogger.INSTANCE, SharedStateLogger.TAG, "SharedRepo: repo is an empty shell (native handle=0, load failed)", null, 4, null);     // Catch: Throwable -> L31
        throw new IllegalStateException("SharedRepo: native handle=0, shared repo load failed");     // Catch: Throwable -> L31
    L17:
        File r1 = r8.getFilesDir().getParentFile();     // Catch: Throwable -> L31
        if (r1 != null) goto L20;
        r1 = r8.getFilesDir();     // Catch: Throwable -> L31
    L20:
        File r5 = r1.getCanonicalFile();     // Catch: Throwable -> L31
        File r6 = r8.getFilesDir().getParentFile();     // Catch: Throwable -> L31
        if (r6 != null) goto L23;
        r6 = r8.getFilesDir();     // Catch: Throwable -> L31
    L23:
        PolarisFileWrapper r7 = new PolarisFileWrapper(new PolarisFileWrapper(r6.getCanonicalFile(), "keva").getCanonicalFile(), "repo");     // Catch: Throwable -> L31
        String r10 = e(r5, r7);     // Catch: Throwable -> L31
        SharedStateLogger.INSTANCE.i(SharedStateLogger.TAG, "SharedRepo: getOrCreate[plugin]: base=" + r5 + ", targetRepoDir=" + r7 + ", relPath=\"" + r10 + '\"');     // Catch: Throwable -> L31
        r9 = Keva.getRepoSyncWithPath("obric_shared_state", r10, 1);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public static String e(File r14, PolarisFileWrapper r15) {
        List r0 = StringsKt.split$default(r14.getCanonicalPath(), new String[]{"/"}, false, 0, 6, null);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L3:
        boolean r3 = false;
        boolean r4 = true;
        if (r2.hasNext() == false) goto L10;
        Object r5 = r2.next();
        if (((String) r5).length() <= 0) goto L8;
        r3 = true;
    L8:
        if (r3 == false) goto L3;
        r1.add(r5);
        goto L3
    L10:
        List r16 = StringsKt.split$default(r15.getCanonicalPath(), new String[]{"/"}, false, 0, 6, null);
        ArrayList r6 = new ArrayList();
        Iterator r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L19;
        Object r7 = r17.next();
        if (((String) r7).length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L12;
        r6.add(r7);
        goto L12
    L16:
        r8 = false;
        goto L17
    L19:
        int r18 = 0;
    L21:
        if (r18 >= r1.size()) goto L27;
        if (r18 >= r6.size()) goto L27;
        if (Intrinsics.areEqual(ListProtector.get(r1, r18), ListProtector.get(r6, r18)) == false) goto L27;
        r18 = r18 + 1;
    L27:
        ArrayList r9 = new ArrayList();
        int r10 = r1.size();
        int r11 = r18;
    L28:
        if (r11 >= r10) goto L30;
        r9.add("..");
        r11 = r11 + 1;
        goto L28
    L30:
        int r12 = r6.size();
    L31:
        if (r18 >= r12) goto L33;
        r9.add(ListProtector.get(r6, r18));
        r18 = r18 + 1;
        goto L31
    L33:
        String r19 = CollectionsKt.joinToString$default(r9, "/", null, null, 0, null, null, 62, null);
        if ((!StringsKt.startsWith$default(r19, "/", false, 2, null)) == false) goto L45;
        if (r19.length() > 0) goto L39;
        r4 = false;
    L39:
        if (r4 == true) goto L41;
        return r19;
    L41:
        if (StringsKt.endsWith$default(r19, "/", false, 2, null) == false) goto L43;
        return r19;
    L43:
        return r19.concat("/");
    L45:
        throw new IllegalArgumentException(("relPath must be relative: " + r19).toString());
    }
}
