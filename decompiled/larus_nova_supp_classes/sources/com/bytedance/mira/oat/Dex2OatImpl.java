package com.bytedance.mira.oat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.IOUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import dalvik.system.BaseDexClassLoader;
import el9.a;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Dex2OatImpl {
    private static final int CODE_SUCCESS = 0;
    private static final String COMPILE_FILTER_QUICKEN = "quicken";
    private static final String COMPILE_FILTER_SPEED = "speed";
    private static final int MAX_RETRY_COUNT = 3;
    private static final int SHELL_COMMAND_TRANSACTION = 1598246212;
    private static volatile Context sContext;
    private static volatile IBinder sPmBinder;
    private static volatile Object sPmObj;

    public Dex2OatImpl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static String[] buildArgs(String... r0) {
        return r0;
    }

    private static String[] buildReconcileSecondaryDexFilesArgs() {
        String[] r0 = new String[2];
        r0[0] = "reconcile-secondary-dex-files";
        if (sContext != null) goto L5;
        String r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        r0[1] = r1;
        return buildArgs(r0);
    L5:
        r1 = sContext.getPackageName();
        goto L6
    }

    private static void maybeInit() {
        if (sContext != null) goto L5;
        return;
    L5:
        if (sPmBinder != null) goto L19;
        PackageManager r0 = sContext.getPackageManager();
        Field r1 = safeGetField(r0, "mPM");
        if (r1 != null) goto L10;
        return;
    L10:
        sPmObj = safeGetValue(r1, r0);
        if ((sPmObj instanceof IInterface) == true) goto L13;
        return;
    L13:
        IBinder r2 = ((IInterface) sPmObj).asBinder();
        if (r2 == null) goto L18;
        sPmBinder = r2;
        return;
    L18:
        return;
    }

    public static void removeReporter() {
        Field r0 = safeGetField(BaseDexClassLoader.class, "reporter");
        if (r0 != null) goto L6;
        return;
    L6:
        if (safeGetValue(r0, null) != null) goto L8;
        return;
    L8:
        safeSetValue(r0, null, null);
    }

    private static void reconcileSecondaryDexFiles() {
        execCmd(buildReconcileSecondaryDexFilesArgs(), null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_oat_Dex2OatImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private static String[] buildDexOptArgs(String r3) {
        String[] r0 = new String[6];
        r0[0] = "compile";
        r0[1] = "-m";
        r0[2] = r3;
        r0[3] = "-f";
        r0[4] = "--secondary-dex";
        if (sContext != null) goto L5;
        String r4 = XmlPullParser.NO_NAMESPACE;
    L6:
        r0[5] = r4;
        return buildArgs(r0);
    L5:
        r4 = sContext.getPackageName();
        goto L6
    }

    public static void init(Context r0) {
        sContext = r0.getApplicationContext();
    }

    public static Class safeClassForName(String r0) {
        return INVOKESTATIC_com_bytedance_mira_oat_Dex2OatImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r0);
    L4:
        return null;
    }

    private static void safeDelFile(String r1) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r1);     // Catch: Exception -> L6
        if (r0.exists() == false) goto L9;
        r0.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static void dexOptQuicken(String r1, int r2) {
        maybeInit();
        registerDexModule(r1, r2);
        dexOpt(COMPILE_FILTER_QUICKEN, r1, r2);
        unregisterDexModule(r1, r2);
    }

    public static void dexOptSpeed(String r1, int r2) {
        maybeInit();
        registerDexModule(r1, r2);
        dexOpt(COMPILE_FILTER_SPEED, r1, r2);
        unregisterDexModule(r1, r2);
    }

    private static void execCmd(String[] r3, Callback r4) {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeFileDescriptor(FileDescriptor.in);
        r0.writeFileDescriptor(FileDescriptor.out);
        r0.writeFileDescriptor(FileDescriptor.err);
        r0.writeStringArray(r3);
        r0.writeStrongBinder(null);
        new ResultReceiverCallbackWrapper(r4).writeToParcel(r0, 0);
        INVOKEINTERFACE_com_bytedance_mira_oat_Dex2OatImpl_com_obric_assistant_interaction_impl_BinderLancet_transact(sPmBinder, SHELL_COMMAND_TRANSACTION, r0, r1, 0);     // Catch: Throwable -> L5 Exception -> L10
        r1.readException();     // Catch: Throwable -> L5 Exception -> L10
    L5:
        th = move-exception;
        r0.recycle();
        r1.recycle();
        throw th;
    L8:
        r0.recycle();
        r1.recycle();
    }

    private static void registerDexModule(String r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (sContext == null) goto L9;
        String r0 = PluginDirHelper.getSourceFile(r1, r2);
        String r3 = PluginDirHelper.getTempSourceFile(r1, r2);
        safeCopyFile(r0, r3);
        notifyDexLoad(sContext.getPackageName(), r3, Dex2OatHelper.getCurrentInstructionSet());
        return;
    }

    private static void safeCopyDir(String r0, String r1) {
        IOUtils.copyFolder(r0, r1);     // Catch: Exception -> L4
        return;
    }

    private static void safeCopyFile(String r0, String r1) {
        IOUtils.copyFile(r0, r1);     // Catch: Exception -> L4
        return;
    }

    public static Field safeGetField(Object r0, String r1) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return safeGetField(r0.getClass(), r1);
    }

    public static Object safeGetValue(Field r1, Object r2) {
    L7:
        return null;
    L3:
        if (r1.isAccessible() == true) goto L5;
        r1.setAccessible(true);     // Catch: Exception -> L7
    L5:
        Object r3 = r1.get(r2);     // Catch: Exception -> L7
        r1.setAccessible(false);     // Catch: Exception -> L7
        return r3;
    }

    private static void unregisterDexModule(String r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (sContext == null) goto L9;
        String r0 = PluginDirHelper.getSourceDir(r2, r3);
        safeCopyDir(PluginDirHelper.getTempSourceDir(r2, r3), r0);
        safeDelFile(PluginDirHelper.getTempSourceFile(r2, r3));
        reconcileSecondaryDexFiles();
        return;
    }

    public static Field safeGetField(Class<?> r0, String r1) {
        return FieldUtils.getField(r0, r1);
    }

    private static void dexOpt(String r2, String r3, int r4) {
        String r0 = PluginDirHelper.getTempSourceFile(r3, r4);
        PolarisFileWrapper r5 = new PolarisFileWrapper(PluginDirHelper.getTempDalvikCacheDir(r3, r4) + File.separator + Dex2OatHelper.getOatFileName(r0));
        int r6 = 1;
    L4:
        if (r6 > 3) goto L9;
        execCmd(buildDexOptArgs(r2), null);
        if (r5.exists() == true) goto L12;
        r6 = r6 + 1;
        goto L4
    L12:
        return;
    }

    private static void notifyDexLoad(String r2, String r3, String r4) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        realNotifyDexLoadForR(r2, r3, r4);
        return;
    L5:
        realNotifyDexLoad(r2, r3, r4);
    }

    private static void realNotifyDexLoad(String r5, String r6, String r7) {
        if (sPmObj == null) goto L10;
        if (r5 == null) goto L11;
        if (r6 == null) goto L12;
        if (r7 == null) goto L13;
        List r0 = Collections.singletonList("dalvik.system.DexClassLoader");
        List r8 = Collections.singletonList(r6);
        safeInvokeMethod(sPmObj, "notifyDexLoad", new Object[]{r5, r0, r8, r7}, new Class[]{String.class, List.class, List.class, String.class});
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    private static void realNotifyDexLoadForR(String r4, String r5, String r6) {
        if (sPmObj == null) goto L10;
        if (r4 == null) goto L11;
        if (r5 == null) goto L12;
        if (r6 == null) goto L13;
        Map r7 = Collections.singletonMap(r5, "PCL[]");
        safeInvokeMethod(sPmObj, "notifyDexLoad", new Object[]{r4, r7, r6}, new Class[]{String.class, Map.class, String.class});
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void safeSetValue(Field r1, Object r2, Object r3) {
        if (r1.isAccessible() == true) goto L5;
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L7
    L5:
        r1.set(r2, r3);     // Catch: IllegalAccessException -> L7
        r1.setAccessible(false);     // Catch: IllegalAccessException -> L7
        return;
    }

    public static Object safeInvokeMethod(Object r0, String r1, Object[] r2, Class<?>[] r3) {
        return MethodUtils.invokeMethod(r0, r1, r2, r3);
    L4:
        return null;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_mira_oat_Dex2OatImpl_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r2 = SystemClock.uptimeMillis();
        boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
        long r8 = SystemClock.uptimeMillis() - r2;
        if (r8 < 100) goto L11;
        BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r0;
    L12:
        th = move-exception;
        long r9 = SystemClock.uptimeMillis() - r2;
        if (r9 < 100) goto L22;
        if (r15 != null) goto L17;
        String r1 = XmlPullParser.NO_NAMESPACE;
    L18:
        BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r1 = r15.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r15.transact(r16, r17, r18, r19);
    }
}
