package org.lsposed.hiddenapibypass;

import com.amap.api.col.s.ce;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes42.dex */
public final class HiddenApiBypass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f526163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f526164b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f526165c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f526166d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f526167e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f526168f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f526169g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f526170h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f526171i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f526172j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f526173k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f526174l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f526175m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Set f526176n = null;

    static {
        f526176n = new HashSet();
        Unsafe r100 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);     // Catch: ReflectiveOperationException -> L5
        f526163a = r100;     // Catch: ReflectiveOperationException -> L5
        f526164b = r100.objectFieldOffset(Helper$Executable.class.getDeclaredField("artMethod"));     // Catch: ReflectiveOperationException -> L5
        f526165c = r100.objectFieldOffset(Helper$Executable.class.getDeclaredField("declaringClass"));     // Catch: ReflectiveOperationException -> L5
        long r101 = r100.objectFieldOffset(Helper$MethodHandle.class.getDeclaredField("artFieldOrMethod"));     // Catch: ReflectiveOperationException -> L5
        f526166d = r101;     // Catch: ReflectiveOperationException -> L5
        f526167e = r100.objectFieldOffset(Helper$MethodHandleImpl.class.getDeclaredField("info"));     // Catch: ReflectiveOperationException -> L5
        long r102 = r100.objectFieldOffset(Helper$Class.class.getDeclaredField("methods"));     // Catch: ReflectiveOperationException -> L5
        f526168f = r102;     // Catch: ReflectiveOperationException -> L5
        long r103 = r100.objectFieldOffset(Helper$Class.class.getDeclaredField("iFields"));     // Catch: ReflectiveOperationException -> L5
        f526169g = r103;     // Catch: ReflectiveOperationException -> L5
        f526170h = r100.objectFieldOffset(Helper$Class.class.getDeclaredField("sFields"));     // Catch: ReflectiveOperationException -> L5
        f526171i = r100.objectFieldOffset(Helper$HandleInfo.class.getDeclaredField("member"));     // Catch: ReflectiveOperationException -> L5
        Method r104 = Helper$NeverCall.class.getDeclaredMethod(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, new Class[0]);     // Catch: ReflectiveOperationException -> L5
        Method r105 = Helper$NeverCall.class.getDeclaredMethod("b", new Class[0]);     // Catch: ReflectiveOperationException -> L5
        r104.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r105.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r106 = MethodHandles.lookup().unreflect(r104);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r107 = MethodHandles.lookup().unreflect(r105);     // Catch: ReflectiveOperationException -> L5
        long r110 = r100.getLong(r106, r101);     // Catch: ReflectiveOperationException -> L5
        long r108 = r100.getLong(r107, r101);     // Catch: ReflectiveOperationException -> L5
        long r109 = r100.getLong(Helper$NeverCall.class, r102);     // Catch: ReflectiveOperationException -> L5
        long r111 = r108 - r110;     // Catch: ReflectiveOperationException -> L5
        f526172j = r111;     // Catch: ReflectiveOperationException -> L5
        f526173k = (r110 - r109) - r111;     // Catch: ReflectiveOperationException -> L5
        Field r112 = Helper$NeverCall.class.getDeclaredField(RXScreenCaptureService.KEY_INDEX);     // Catch: ReflectiveOperationException -> L5
        Field r113 = Helper$NeverCall.class.getDeclaredField(ce.f26395j);     // Catch: ReflectiveOperationException -> L5
        r112.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r113.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r114 = MethodHandles.lookup().unreflectGetter(r112);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r115 = MethodHandles.lookup().unreflectGetter(r113);     // Catch: ReflectiveOperationException -> L5
        long r116 = r100.getLong(r114, r101);     // Catch: ReflectiveOperationException -> L5
        long r117 = r100.getLong(r115, r101);     // Catch: ReflectiveOperationException -> L5
        long r118 = r100.getLong(Helper$NeverCall.class, r103);     // Catch: ReflectiveOperationException -> L5
        f526174l = r117 - r116;     // Catch: ReflectiveOperationException -> L5
        f526175m = r116 - r118;     // Catch: ReflectiveOperationException -> L5
        return;
    L5:
        e = move-exception;
        throw new ExceptionInInitializerError(e);
    }

    public HiddenApiBypass() {
    }

    public static boolean a(Class[] r100, Object[] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L56;
        if (r100[r102].isPrimitive() == false) goto L50;
        Class r103 = r100[r102];
        if (r103 != Integer.TYPE) goto L16;
        if ((r101[r102] instanceof Integer) == true) goto L16;
        return false;
    L16:
        if (r103 != Byte.TYPE) goto L21;
        if ((r101[r102] instanceof Byte) == true) goto L21;
        return false;
    L21:
        if (r103 != Character.TYPE) goto L26;
        if ((r101[r102] instanceof Character) == true) goto L26;
        return false;
    L26:
        if (r103 != Boolean.TYPE) goto L31;
        if ((r101[r102] instanceof Boolean) == true) goto L31;
        return false;
    L31:
        if (r103 != Double.TYPE) goto L36;
        if ((r101[r102] instanceof Double) == true) goto L36;
        return false;
    L36:
        if (r103 != Float.TYPE) goto L41;
        if ((r101[r102] instanceof Float) == true) goto L41;
        return false;
    L41:
        if (r103 != Long.TYPE) goto L46;
        if ((r101[r102] instanceof Long) == true) goto L46;
        return false;
    L46:
        if (r103 != Short.TYPE) goto L55;
        if ((r101[r102] instanceof Short) == true) goto L55;
        return false;
    L55:
        r102 = r102 + 1;
        goto L7
    L50:
        Object r104 = r101[r102];
        if (r104 == null) goto L55;
        if (r100[r102].isInstance(r104) == true) goto L55;
        return false;
    L56:
        return true;
    }

    public static boolean addHiddenApiExemptions(String... r100) {
        Set r101 = f526176n;
        r101.addAll(Arrays.asList(r100));
        String[] r102 = new String[((HashSet) r101).size()];
        r101.toArray(r102);
        return setHiddenApiExemptions(r102);
    }

    public static boolean clearHiddenApiExemptions() {
        ((HashSet) f526176n).clear();
        return setHiddenApiExemptions(new String[0]);
    }

    public static Constructor getDeclaredConstructor(Class r100, Class... r101) {
        Iterator r102 = getDeclaredMethods(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L21;
        Executable r103 = (Executable) r102.next();
        if ((r103 instanceof Constructor) == false) goto L4;
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104.length != r101.length) goto L4;
        int r105 = 0;
    L13:
        if (r105 >= r101.length) goto L19;
        if (r101[r105] != r104[r105]) goto L4;
        r105 = r105 + 1;
        goto L13
    L19:
        return (Constructor) r103;
    L21:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class r100, String r101, Class... r102) {
        Iterator r103 = getDeclaredMethods(r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L24;
        Executable r104 = (Executable) r103.next();
        if (r104.getName().equals(r101) == false) goto L4;
        if ((r104 instanceof Method) == false) goto L4;
        Class<?>[] r105 = r104.getParameterTypes();
        if (r105.length != r102.length) goto L4;
        int r106 = 0;
    L16:
        if (r106 >= r102.length) goto L22;
        if (r102[r106] != r105[r106]) goto L4;
        r106 = r106 + 1;
        goto L16
    L22:
        return (Method) r104;
    L24:
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static List getDeclaredMethods(Class r110) {
        ArrayList r100 = new ArrayList();
        if (r110.isPrimitive() == false) goto L5;
    L16:
        return r100;
    L5:
        if (r110.isArray() == true) goto L16;
        int r101 = 0;
        Method r102 = Helper$NeverCall.class.getDeclaredMethod(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, new Class[0]);     // Catch: Throwable -> L18
        r102.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r103 = MethodHandles.lookup().unreflect(r102);     // Catch: Throwable -> L18
        Unsafe r104 = f526163a;
        long r111 = r104.getLong(r110, f526168f);
        if (r111 != 0) goto L11;
        return r100;
    L11:
        int r112 = r104.getInt(r111);
    L12:
        if (r101 >= r112) goto L16;
        long r105 = ((((long) r101) * f526172j) + r111) + f526173k;
        Unsafe r106 = f526163a;
        r106.putLong(r103, f526166d, r105);
        r106.putObject(r103, f526167e, null);
        MethodHandles.lookup().revealDirect(r103);     // Catch: Throwable -> L17
    L15:
        Unsafe r107 = f526163a;
        r100.add((Executable) r107.getObject((MethodHandleInfo) r107.getObject(r103, f526167e), f526171i));
        r101 = r101 + 1;
        goto L12
    }

    public static List getInstanceFields(Class r110) {
        ArrayList r100 = new ArrayList();
        if (r110.isPrimitive() == false) goto L5;
    L16:
        return r100;
    L5:
        if (r110.isArray() == true) goto L16;
        Field r101 = Helper$NeverCall.class.getDeclaredField(RXScreenCaptureService.KEY_INDEX);     // Catch: Throwable -> L18
        r101.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r102 = MethodHandles.lookup().unreflectGetter(r101);     // Catch: Throwable -> L18
        Unsafe r103 = f526163a;
        long r104 = r103.getLong(r110, f526169g);
        if (r104 != 0) goto L11;
        return r100;
    L11:
        int r111 = r103.getInt(r104);
        int r105 = 0;
    L12:
        if (r105 >= r111) goto L16;
        long r106 = ((((long) r105) * f526174l) + r104) + f526175m;
        Unsafe r112 = f526163a;
        r112.putLong(r102, f526166d, r106);
        r112.putObject(r102, f526167e, null);
        MethodHandles.lookup().revealDirect(r102);     // Catch: Throwable -> L17
    L15:
        Unsafe r107 = f526163a;
        r100.add((Field) r107.getObject((MethodHandleInfo) r107.getObject(r102, f526167e), f526171i));
        r105 = r105 + 1;
        goto L12
    }

    public static List getStaticFields(Class r110) {
        ArrayList r100 = new ArrayList();
        if (r110.isPrimitive() == false) goto L5;
    L16:
        return r100;
    L5:
        if (r110.isArray() == true) goto L16;
        Field r101 = Helper$NeverCall.class.getDeclaredField("s");     // Catch: Throwable -> L18
        r101.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r102 = MethodHandles.lookup().unreflectGetter(r101);     // Catch: Throwable -> L18
        Unsafe r103 = f526163a;
        long r104 = r103.getLong(r110, f526170h);
        if (r104 != 0) goto L11;
        return r100;
    L11:
        int r111 = r103.getInt(r104);
        int r105 = 0;
    L12:
        if (r105 >= r111) goto L16;
        long r106 = ((((long) r105) * f526174l) + r104) + f526175m;
        Unsafe r112 = f526163a;
        r112.putLong(r102, f526166d, r106);
        r112.putObject(r102, f526167e, null);
        MethodHandles.lookup().revealDirect(r102);     // Catch: Throwable -> L17
    L15:
        Unsafe r107 = f526163a;
        r100.add((Field) r107.getObject((MethodHandleInfo) r107.getObject(r102, f526167e), f526171i));
        r105 = r105 + 1;
        goto L12
    }

    public static Object invoke(Class r110, Object r111, String r112, Object... r113) {
        if (r111 != null) goto L5;
    L9:
        int r100 = 0;
        Method r101 = Helper$InvokeStub.class.getDeclaredMethod(AbsMethodDelegate.TAG_INVOKE, new Class[]{Object[].class});
        r101.setAccessible(true);
        Unsafe r102 = f526163a;
        long r114 = r102.getLong(r110, f526168f);
        if (r114 == 0) goto L23;
        int r103 = r102.getInt(r114);
    L12:
        if (r100 >= r103) goto L21;
        f526163a.putLong(r101, f526164b, ((((long) r100) * f526172j) + r114) + f526173k);
        if (r112.equals(r101.getName()) == false) goto L19;
        if (a(r101.getParameterTypes(), r113) == false) goto L19;
        return r101.invoke(r111, r113);
    L19:
        r100 = r100 + 1;
        goto L12
    L21:
        throw new NoSuchMethodException("Cannot find matching method");
    L23:
        throw new NoSuchMethodException("Cannot find matching method");
    L5:
        if (r110.isInstance(r111) == true) goto L9;
        throw new IllegalArgumentException("this object is not an instance of the given class");
    }

    public static Object newInstance(Class r210, Object... r211) {
        int r100 = 0;
        Method r101 = Helper$InvokeStub.class.getDeclaredMethod(AbsMethodDelegate.TAG_INVOKE, new Class[]{Object[].class});
        Constructor r102 = Helper$InvokeStub.class.getDeclaredConstructor(new Class[]{Object[].class});
        r102.setAccessible(true);
        Unsafe r103 = f526163a;
        long r110 = r103.getLong(r210, f526168f);
        if (r110 == 0) goto L16;
        int r104 = r103.getInt(r110);
    L5:
        if (r100 >= r104) goto L14;
        long r111 = ((((long) r100) * f526172j) + r110) + f526173k;
        Unsafe r105 = f526163a;
        long r112 = f526164b;
        r105.putLong(r101, r112, r111);
        if ("<init>".equals(r101.getName()) == false) goto L12;
        r105.putLong(r102, r112, r111);
        r105.putObject(r102, f526165c, r210);
        if (a(r102.getParameterTypes(), r211) == false) goto L12;
        return r102.newInstance(r211);
    L12:
        r100 = r100 + 1;
        goto L5
    L14:
        throw new NoSuchMethodException("Cannot find matching constructor");
    L16:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(String... r100) {
        invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", new Object[]{r100});     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
