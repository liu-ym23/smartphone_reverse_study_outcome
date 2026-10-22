package com.bytedance.mira.oat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;
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

/* JADX INFO: loaded from: classes.dex */
public class Dex2OatImpl {
    private static final int CODE_SUCCESS = 0;
    private static final String COMPILE_FILTER_QUICKEN = "quicken";
    private static final String COMPILE_FILTER_SPEED = "speed";
    private static final int MAX_RETRY_COUNT = 3;
    private static final int SHELL_COMMAND_TRANSACTION = 1598246212;
    private static volatile Context sContext;
    private static volatile IBinder sPmBinder;
    private static volatile Object sPmObj;

    /* JADX INFO: loaded from: classes21.dex */
    public interface Callback {
        void onResult(boolean r100, Bundle r101);
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class ResultReceiverCallbackWrapper extends ResultReceiver {
        private Callback mCallback;

        public ResultReceiverCallbackWrapper(Callback r100) {
            super(null);
            this.mCallback = r100;
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int r100, Bundle r101) {
            super.onReceiveResult(r100, r101);
            Callback r102 = this.mCallback;
            if (r102 == null) goto L9;
            if (r100 != 0) goto L6;
            boolean r103 = true;
        L7:
            r102.onResult(r103, r101);
            return;
        L6:
            r103 = false;
            goto L7
        }
    }

    public Dex2OatImpl() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String[] buildArgs(String... r100) {
        return r100;
    }

    private static String[] buildReconcileSecondaryDexFilesArgs() {
        String[] r100 = new String[2];
        r100[0] = "reconcile-secondary-dex-files";
        if (sContext != null) goto L5;
        String r101 = "";
    L6:
        r100[1] = r101;
        return buildArgs(r100);
    L5:
        r101 = sContext.getPackageName();
        goto L6
    }

    private static void maybeInit() {
        if (sContext != null) goto L5;
        return;
    L5:
        if (sPmBinder != null) goto L19;
        PackageManager r100 = sContext.getPackageManager();
        Field r101 = safeGetField(r100, "mPM");
        if (r101 != null) goto L10;
        return;
    L10:
        sPmObj = safeGetValue(r101, r100);
        if ((sPmObj instanceof IInterface) == true) goto L13;
        return;
    L13:
        IBinder r102 = ((IInterface) sPmObj).asBinder();
        if (r102 == null) goto L18;
        sPmBinder = r102;
        return;
    L18:
        return;
    }

    public static void removeReporter() {
        Field r100 = safeGetField(BaseDexClassLoader.class, "reporter");
        if (r100 != null) goto L6;
        return;
    L6:
        if (safeGetValue(r100, null) != null) goto L8;
        return;
    L8:
        safeSetValue(r100, null, null);
    }

    private static void reconcileSecondaryDexFiles() {
        execCmd(buildReconcileSecondaryDexFilesArgs(), null);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_oat_Dex2OatImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String[] buildDexOptArgs(String r100) {
        String[] r101 = new String[6];
        r101[0] = "compile";
        r101[1] = "-m";
        r101[2] = r100;
        r101[3] = "-f";
        r101[4] = "--secondary-dex";
        if (sContext != null) goto L5;
        String r102 = "";
    L6:
        r101[5] = r102;
        return buildArgs(r101);
    L5:
        r102 = sContext.getPackageName();
        goto L6
    }

    public static void init(Context r100) {
        sContext = r100.getApplicationContext();
    }

    public static Class safeClassForName(String r100) {
        return INVOKESTATIC_com_bytedance_mira_oat_Dex2OatImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        return null;
    }

    private static void safeDelFile(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L6
        if (r101.exists() == false) goto L9;
        r101.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static void dexOptQuicken(String r100, int r101) {
        maybeInit();
        registerDexModule(r100, r101);
        dexOpt(COMPILE_FILTER_QUICKEN, r100, r101);
        unregisterDexModule(r100, r101);
    }

    public static void dexOptSpeed(String r100, int r101) {
        maybeInit();
        registerDexModule(r100, r101);
        dexOpt("speed", r100, r101);
        unregisterDexModule(r100, r101);
    }

    private static void execCmd(String[] r100, Callback r101) {
        Parcel r102 = Parcel.obtain();
        Parcel r103 = Parcel.obtain();
        r102.writeFileDescriptor(FileDescriptor.in);
        r102.writeFileDescriptor(FileDescriptor.out);
        r102.writeFileDescriptor(FileDescriptor.err);
        r102.writeStringArray(r100);
        r102.writeStrongBinder(null);
        new ResultReceiverCallbackWrapper(r101).writeToParcel(r102, 0);
        INVOKEINTERFACE_com_bytedance_mira_oat_Dex2OatImpl_com_obric_assistant_interaction_impl_BinderLancet_transact(sPmBinder, SHELL_COMMAND_TRANSACTION, r102, r103, 0);     // Catch: Throwable -> L5 Exception -> L10
        r103.readException();     // Catch: Throwable -> L5 Exception -> L10
    L5:
        th = move-exception;
        r102.recycle();
        r103.recycle();
        throw th;
    L8:
        r102.recycle();
        r103.recycle();
    }

    private static void registerDexModule(String r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (sContext == null) goto L9;
        String r102 = PluginDirHelper.getSourceFile(r100, r101);
        String r103 = PluginDirHelper.getTempSourceFile(r100, r101);
        safeCopyFile(r102, r103);
        notifyDexLoad(sContext.getPackageName(), r103, Dex2OatHelper.getCurrentInstructionSet());
        return;
    }

    private static void safeCopyDir(String r100, String r101) {
        IOUtils.copyFolder(r100, r101);     // Catch: Exception -> L4
        return;
    }

    private static void safeCopyFile(String r100, String r101) {
        IOUtils.copyFile(r100, r101);     // Catch: Exception -> L4
        return;
    }

    public static Field safeGetField(Object r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return safeGetField(r100.getClass(), r101);
    }

    public static Object safeGetValue(Field r100, Object r101) {
    L7:
        return null;
    L3:
        if (r100.isAccessible() == true) goto L5;
        r100.setAccessible(true);     // Catch: Exception -> L7
    L5:
        Object r102 = r100.get(r101);     // Catch: Exception -> L7
        r100.setAccessible(false);     // Catch: Exception -> L7
        return r102;
    }

    private static void unregisterDexModule(String r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (sContext == null) goto L9;
        String r102 = PluginDirHelper.getSourceDir(r100, r101);
        safeCopyDir(PluginDirHelper.getTempSourceDir(r100, r101), r102);
        safeDelFile(PluginDirHelper.getTempSourceFile(r100, r101));
        reconcileSecondaryDexFiles();
        return;
    }

    public static Field safeGetField(Class<?> r100, String r101) {
        return FieldUtils.getField(r100, r101);
    }

    private static void dexOpt(String r100, String r101, int r102) {
        String r103 = PluginDirHelper.getTempSourceFile(r101, r102);
        PolarisFileWrapper r104 = new PolarisFileWrapper(PluginDirHelper.getTempDalvikCacheDir(r101, r102) + File.separator + Dex2OatHelper.getOatFileName(r103));
        int r105 = 1;
    L4:
        if (r105 > 3) goto L9;
        execCmd(buildDexOptArgs(r100), null);
        if (r104.exists() == true) goto L12;
        r105 = r105 + 1;
        goto L4
    L12:
        return;
    }

    private static void notifyDexLoad(String r100, String r101, String r102) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        realNotifyDexLoadForR(r100, r101, r102);
        return;
    L5:
        realNotifyDexLoad(r100, r101, r102);
    }

    private static void realNotifyDexLoad(String r100, String r101, String r102) {
        if (sPmObj == null) goto L10;
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r102 == null) goto L13;
        List r103 = Collections.singletonList("dalvik.system.DexClassLoader");
        List r104 = Collections.singletonList(r101);
        safeInvokeMethod(sPmObj, "notifyDexLoad", new Object[]{r100, r103, r104, r102}, new Class[]{String.class, List.class, List.class, String.class});
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    private static void realNotifyDexLoadForR(String r100, String r101, String r102) {
        if (sPmObj == null) goto L10;
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r102 == null) goto L13;
        Map r103 = Collections.singletonMap(r101, "PCL[]");
        safeInvokeMethod(sPmObj, "notifyDexLoad", new Object[]{r100, r103, r102}, new Class[]{String.class, Map.class, String.class});
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void safeSetValue(Field r100, Object r101, Object r102) {
        if (r100.isAccessible() == true) goto L5;
        r100.setAccessible(true);     // Catch: IllegalAccessException -> L7
    L5:
        r100.set(r101, r102);     // Catch: IllegalAccessException -> L7
        r100.setAccessible(false);     // Catch: IllegalAccessException -> L7
        return;
    }

    public static Object safeInvokeMethod(Object r100, String r101, Object[] r102, Class<?>[] r103) {
        return MethodUtils.invokeMethod(r100, r101, r102, r103);
    L4:
        return null;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_bytedance_mira_oat_Dex2OatImpl_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r110, int r111, Parcel r112, Parcel r113, int r114) throws RemoteException {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        long r100 = SystemClock.uptimeMillis();
        boolean r101 = r110.transact(r111, r112, r113, r114);     // Catch: Throwable -> L12
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L11;
        BinderPerformanceReporter.report(r102, r110.getClass().getName(), r111, r114, new Throwable("Slow main-thread Binder transaction"));
    L11:
        return r101;
    L12:
        th = move-exception;
        long r103 = SystemClock.uptimeMillis() - r100;
        if (r103 < 100) goto L22;
        if (r110 != null) goto L17;
        String r104 = "";
    L18:
        BinderPerformanceReporter.report(r103, r104, r111, r114, new Throwable("Slow main-thread Binder transaction"));
        throw th;
    L17:
        r104 = r110.getClass().getName();
        goto L18
    L22:
        throw th;
    L5:
        return r110.transact(r111, r112, r113, r114);
    }
}
