package com.bytedance.sysoptimizer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes22.dex */
public class FindCatchBlockOpt {
    private static final String TAG = "FindCatchBlockOpt";
    private static volatile ICallback sCallback;
    private static volatile boolean sInit;

    public static class CatchException {
        public String declaringClass;
        public String detailMessage;
        public CatchStackTrace[] stackTrace;

        public CatchException() {
        }

        public String toString() {
            return "CatchException{declaringClass='" + this.declaringClass + "', detailMessage='" + this.detailMessage + "', stackTrace=" + Arrays.toString(this.stackTrace) + '}';
        }
    }

    public static class CatchStackTrace {
        public String declaringClass;
        public boolean isStatic;
        public String methodName;
        public String methodSig;

        public CatchStackTrace() {
        }

        public String toString() {
            return "CatchStackTrace{declaringClass='" + this.declaringClass + "', methodName='" + this.methodName + "', methodSig='" + this.methodSig + "', isStatic=" + this.isStatic + '}';
        }
    }

    public static final class ForReadInstrumentation {
        private ForReadInstrumentation() {
        }

        static {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation <clinit>");
        }

        private static void A() {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation A");
        }

        private static void gc() {
            FindCatchBlockOpt.access$000().e(FindCatchBlockOpt.TAG, "called ForReadInstrumentation gc");
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
        }
    }

    public interface ICallback {
        int d(String r100, String r101);

        int e(String r100, String r101);

        int e(String r100, String r101, Throwable r102);
    }

    public static class Tester {
        private static final String TAG = "Tester";
        private static long sMethodB4Called;

        public static class UninitializedPropertyAccessException extends RuntimeException {
            public UninitializedPropertyAccessException(String r100) {
                super(r100);
            }
        }

        public static Object getO() {
            return null;
        }

        public static void methodB3() {
        }

        public static ConnectivityManager.NetworkCallback methodB1() {
            return new ConnectivityManager.NetworkCallback();
        }

        public static void methodB4() {
            sMethodB4Called++;
            Object r100 = getO();
            if (r100 != null) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            r100.hashCode();
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }

        static {
            FindCatchBlockOpt.access$000().e(TAG, " <clinit> called.");
        }

        public static void methodB5() {
            Object r100 = getO();
            if (r100 != null) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L10;
            r100.hashCode();
            return;
        L10:
            throw new UninitializedPropertyAccessException("lateinit property description has not been initialized");
        L5:
            r101 = false;
            goto L6
        }

        public Tester() {
        }

        public static /* synthetic */ long access$100() {
            return sMethodB4Called;
        }

        public Tester(int r100) {
        }

        public static void methodA(Context r100) {
            methodB5();
            methodB4();
            methodB2(methodB0(r100), methodB1());
            methodB3();
        }

        public static ConnectivityManager methodB0(Context r100) {
            return (ConnectivityManager) r100.getSystemService("connectivity");
        }

        public Tester(long r100) {
        }

        public static void methodB2(ConnectivityManager r100, ConnectivityManager.NetworkCallback r101) {
            int r102 = 0;
        L4:
            if (r102 >= 100) goto L6;
            methodC0(r100, r101);
            r102 = r102 + 1;
            goto L4
        }

        public static void methodC0(ConnectivityManager r100, ConnectivityManager.NetworkCallback r101) {
            r100.unregisterNetworkCallback(r101);
        }

        public static void start(final Context r100, final boolean r101, final int r102) {
            if (FindCatchBlockOpt.isEnable() == true) goto L5;
            return;
        L5:
            ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(r102, r100, r101), "FindCatchBlockOpt$Tester"));
        }
    }

    public static class Util {
        private static final String TAG = "Util";

        public Util() {
        }

        public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            return Class.forName(r100, r101, r102);
        }

        public static String getClassSignature(Class<?> r100) {
            StringBuilder r101 = new StringBuilder();
        L4:
            if (r100.isArray() == false) goto L7;
            r101.append('[');
            r100 = r100.getComponentType();
            goto L4
        L7:
            if (r100.isPrimitive() == true) goto L9;
            r101.append("L" + r100.getName().replace('.', '/') + ';');
        L39:
            return r101.toString();
        L9:
            if (r100 != Integer.TYPE) goto L12;
            r101.append('I');
            goto L39
        L12:
            if (r100 != Byte.TYPE) goto L15;
            r101.append('B');
            goto L39
        L15:
            if (r100 != Long.TYPE) goto L18;
            r101.append('J');
            goto L39
        L18:
            if (r100 != Float.TYPE) goto L21;
            r101.append('F');
            goto L39
        L21:
            if (r100 != Double.TYPE) goto L24;
            r101.append('D');
            goto L39
        L24:
            if (r100 != Short.TYPE) goto L27;
            r101.append('S');
            goto L39
        L27:
            if (r100 != Character.TYPE) goto L30;
            r101.append('C');
            goto L39
        L30:
            if (r100 != Boolean.TYPE) goto L33;
            r101.append(Matrix.MATRIX_TYPE_ZERO);
            goto L39
        L33:
            if (r100 != Void.TYPE) goto L36;
            r101.append('V');
            goto L39
        L36:
            throw new InternalError();
        }

        public static List<String> getMethodSig(String r100, String r101) {
            ArrayList r102 = new ArrayList();
            int r103 = 0;
            Class r104 = INVOKESTATIC_com_bytedance_sysoptimizer_FindCatchBlockOpt$Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, false, FindCatchBlockOpt.class.getClassLoader());     // Catch: Throwable -> L15
            Constructor<?>[] r105 = r104.getDeclaredConstructors();     // Catch: Throwable -> L15
            int r106 = r105.length;     // Catch: Throwable -> L15
            int r107 = 0;
        L4:
            if (r107 >= r106) goto L9;
            Constructor<?> r108 = r105[r107];     // Catch: Throwable -> L15
            String r109 = getMethodSignature(r108.getParameterTypes(), Void.TYPE);     // Catch: Throwable -> L15
            r108.toString();     // Catch: Throwable -> L15
            if (r108.getName().equals(r101) == false) goto L8;
            r102.add(r109);     // Catch: Throwable -> L15
        L8:
            r107 = r107 + 1;     // Catch: Throwable -> L15
            goto L4
        L9:
            Method[] r110 = r104.getDeclaredMethods();     // Catch: Throwable -> L15
            int r111 = r110.length;     // Catch: Throwable -> L15
        L10:
            if (r103 >= r111) goto L17;
            Method r112 = r110[r103];     // Catch: Throwable -> L15
            String r113 = getMethodSignature(r112.getParameterTypes(), r112.getReturnType());     // Catch: Throwable -> L15
            r112.toString();     // Catch: Throwable -> L15
            if (r112.getName().equals(r101) == false) goto L14;
            r102.add(r113);     // Catch: Throwable -> L15
        L14:
            r103 = r103 + 1;
        L17:
            return r102;
        L15:
            th = move-exception;
            th.printStackTrace();
            goto L17
        }

        public static String getMethodSignature(Class<?>[] r100, Class<?> r101) {
            StringBuilder r102 = new StringBuilder("(");
            int r103 = 0;
        L4:
            if (r103 >= r100.length) goto L6;
            r102.append(getClassSignature(r100[r103]));
            r103 = r103 + 1;
            goto L4
        L6:
            r102.append(')');
            r102.append(getClassSignature(r101));
            return r102.toString();
        }

        public static void printMethods(Class r100, Object r101) {
            Objects.toString(r100);
            Objects.toString(r101);
            Constructor<?>[] r102 = r100.getDeclaredConstructors();     // Catch: Throwable -> L20
            int r103 = r102.length;     // Catch: Throwable -> L20
            int r104 = 0;
            int r105 = 0;
        L4:
            if (r105 >= r103) goto L6;
            Constructor<?> r106 = r102[r105];     // Catch: Throwable -> L20
            Objects.toString(r106);     // Catch: Throwable -> L20
            getMethodSignature(r106.getParameterTypes(), Void.TYPE);     // Catch: Throwable -> L20
            r105 = r105 + 1;     // Catch: Throwable -> L20
            goto L4
        L6:
            Method[] r107 = r100.getDeclaredMethods();     // Catch: Throwable -> L20
            int r108 = r107.length;     // Catch: Throwable -> L20
            int r109 = 0;
        L7:
            if (r109 >= r108) goto L9;
            Method r110 = r107[r109];     // Catch: Throwable -> L20
            Objects.toString(r110);     // Catch: Throwable -> L20
            getMethodSignature(r110.getParameterTypes(), r110.getReturnType());     // Catch: Throwable -> L20
            r109 = r109 + 1;     // Catch: Throwable -> L20
            goto L7
        L9:
            Method[] r111 = r100.getMethods();     // Catch: Throwable -> L20
            int r112 = r111.length;     // Catch: Throwable -> L20
            int r113 = 0;
        L10:
            if (r113 >= r112) goto L12;
            Method r114 = r111[r113];     // Catch: Throwable -> L20
            Objects.toString(r114);     // Catch: Throwable -> L20
            getMethodSignature(r114.getParameterTypes(), r114.getReturnType());     // Catch: Throwable -> L20
            r113 = r113 + 1;     // Catch: Throwable -> L20
            goto L10
        L12:
            Field[] r115 = r100.getDeclaredFields();     // Catch: Throwable -> L20
            int r116 = r115.length;     // Catch: Throwable -> L20
        L13:
            if (r104 >= r116) goto L29;
            Field r117 = r115[r104];     // Catch: Throwable -> L20
            Object r118 = DoubleReflectUtils.readField(r117, "offset");     // Catch: Throwable -> L20
            if (r101 == null) goto L17;
            Object r119 = DoubleReflectUtils.readField(r101, r117.getName());     // Catch: Throwable -> L20
        L18:
            Objects.toString(r117);     // Catch: Throwable -> L20
            Objects.toString(r118);     // Catch: Throwable -> L20
            Objects.toString(r119);     // Catch: Throwable -> L20
            r104 = r104 + 1;
            goto L13
        L17:
            r119 = null;
            goto L18
        L29:
            return;
        L20:
            th = move-exception;
            th.printStackTrace();
        }

        public static void printMethods(String r100, Object r101) {
            Objects.toString(r101);
            printMethods(INVOKESTATIC_com_bytedance_sysoptimizer_FindCatchBlockOpt$Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, false, FindCatchBlockOpt.class.getClassLoader()), r101);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            th.printStackTrace();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_bytedance_sysoptimizer_FindCatchBlockOpt$Util_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
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

    public FindCatchBlockOpt() {
    }

    private static native int nStart(boolean r100, boolean r101, CatchException[] r102, String r103);

    private static native void reservedForJniOffset();

    private static ICallback getCallback() {
        monitor-enter(FindCatchBlockOpt.class);
        ICallback r100 = sCallback;     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        r100 = new AnonymousClass1();     // Catch: Throwable -> L9
        updateCallback(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(FindCatchBlockOpt.class);     // Catch: Throwable -> L9
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ ICallback access$000() {
        return getCallback();
    }

    public static boolean isEnable() {
        ICallback r100 = getCallback();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 27) goto L5;
    L23:
        r100.e(TAG, "NOT SUPPORT API LEVEL " + r101);
        return false;
    L5:
        if (r101 > 34) goto L23;
        if (Process.is64Bit() == true) goto L11;
        r100.e(TAG, "NOT SUPPORT 32Bit");
        return false;
    L11:
        String[] r102 = Build.SUPPORTED_ABIS;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L21;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L20;
        if (r105.startsWith("x86") == false) goto L20;
        r100.e(TAG, "ONLY SUPPORT arm64-v8a.But current are " + TextUtils.join(",", Build.SUPPORTED_ABIS));
        return false;
    L20:
        r104 = r104 + 1;
        goto L12
    L21:
        return true;
    }

    private static void replaceClassName(CatchException[] r110) {
        int r100 = r110.length;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        CatchException r102 = r110[r101];
        r102.declaringClass = r102.declaringClass.replace('.', '/');
        CatchStackTrace[] r103 = r102.stackTrace;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        CatchStackTrace r106 = r103[r105];
        r106.declaringClass = r106.declaringClass.replace('.', '/');
        r105 = r105 + 1;
        goto L5
    L7:
        getCallback().e(TAG, r102.toString());
        r101 = r101 + 1;
        goto L3
    }

    private static void updateCallback(ICallback r100) {
        monitor-enter(FindCatchBlockOpt.class);
        sCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(FindCatchBlockOpt.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int start(Context r100, boolean r101, boolean r102, boolean r103, CatchException[] r104, ICallback r105, String r106) {
        if (isEnable() == true) goto L6;
        return -1;
    L6:
        if (sInit == false) goto L10;
        r105.e(TAG, "Already sInit." + Log.getStackTraceString(new Throwable()));
        return 1;
    L10:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L12;
    L17:
        return -1;
    L12:
        if (sInit == true) goto L17;
        if (r102 == false) goto L15;
        Flipped.invokeHiddenApiRestrictions();
    L15:
        reservedForJniOffset();
        replaceClassName(r104);
        updateCallback(r105);
        int r107 = nStart(r101, r103, r104, r106);
        sInit = true;
        return r107;
    }
}
