package com.bytedance.reparo.core;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class WandTrick {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile WandTrick f267315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static File f267316i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f267317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f267318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f267319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f267320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f267321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f267322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f267323g;

    /* JADX INFO: loaded from: classes21.dex */
    public class DummyInnerClass {
        final /* synthetic */ WandTrick this$0;

        private void first() {
        }

        private void second() {
        }

        public DummyInnerClass(WandTrick r100) {
            this.this$0 = r100;
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C3739a f267324b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f267325a;

        /* JADX INFO: renamed from: com.bytedance.reparo.core.WandTrick$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes21.dex */
        public class C3739a extends a {
            @Override // com.bytedance.reparo.core.WandTrick.a
            public final int a() {
                return 0;
            }

            @Override // com.bytedance.reparo.core.WandTrick.a
            public final boolean b(int r100) {
                return true;
            }

            public C3739a() {
            }
        }

        public a() {
        }

        public abstract int a() throws Exception;

        public abstract boolean b(int r100);

        static {
            f267324b = new C3739a();
        }

        public final boolean c() throws Exception {
            int r100 = a();
            this.f267325a = r100;
            return b(r100);
        }
    }

    public static native Object allocObject(Class r100);

    public static native Object callMethodDirect(Class r100, Object r101, Object r102, Object[] r103, Object[] r104, String r105, Class r106);

    public static native Object createInstance(Class r100, Constructor r101, Object[] r102, Object[] r103);

    private native int deoptimizeNative(Object[] r100, int[] r101, boolean r102, String[] r103, String[] r104, long[] r105);

    private native int initNative(boolean r100, String r101, boolean r102, String[] r103);

    public static native void removeClassesFromClassLinker(String[] r100, Object r101);

    public native boolean RuntimeGetStartupCompleted();

    public abstract a b(Application r100, boolean r101, Map<Class, h> r102, List<String> r103, List<String> r104, List<Object> r105, d97.b r106, d97.d r107) throws Exception;

    public native void changeClinitToPreverified(Class r100);

    public native void changeConstructorToPublic(Constructor r100);

    public native void changeFieldToPublic(Field r100);

    public native void changeMethodProtectedToPublic(Method r100);

    public native void changeMethodToPreverified(Object r100);

    public native void clearPointerArrayMemory(long r100, int r101);

    public native Constructor getClinitMethod(Class r100);

    public native boolean isSoLoaded(String r100);

    public native void markImageGenerateFinished();

    public native int nativeGetCheckRuntimeStartUp();

    public native int nativeGetHookRuntimeImageGenerateStatus();

    public native boolean nativeHasAnyAppImage();

    public native boolean nativeHasAppImageFor(String r100);

    public native int redefineClassesNative(Class[] r100, byte[][] r101, Object[] r102, int[] r103, Object[] r104, String[] r105, String[] r106, long[] r107);

    public native int replaceMethodNative(Object[] r100, Object[] r101, int[] r102, String[] r103, String[] r104, long[] r105);

    public static WandTrick f() {
        if (f267315h != null) goto L18;
        monitor-enter(WandTrick.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f267315h == null) goto L9;
    L12:
        monitor-exit(WandTrick.class);     // Catch: Throwable -> L14
        goto L18
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L11;
        f267315h = new b();     // Catch: Throwable -> L14
        goto L12
    L11:
        f267315h = new f();     // Catch: Throwable -> L14
    L18:
        return f267315h;
    }

    public WandTrick() {
        this.f267320d = Integer.MIN_VALUE;
        int r100 = 0;
        this.f267321e = false;
        this.f267322f = -1;
        this.f267323g = new Object();
        if (f267316i == null) goto L13;
        String[] r101 = com.bytedance.reparo.core.a.f267326a;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r100 >= r102) goto L12;
        String r104 = r101[r100];
        PolarisFileWrapper r105 = new PolarisFileWrapper(f267316i, r104);
        if (r105.exists() == false) goto L11;
        System.load(r105.getAbsolutePath());
        if (r104.equals("libreparo.so") == false) goto L11;
        r103 = 1;
    L11:
        r100 = r100 + 1;
        goto L5
    L12:
        r100 = r103;
    L13:
        if (r100 != 0) goto L27;
        a("reparo");
    L27:
        a("jato");     // Catch: Throwable -> L17
    L23:
        this.f267317a = true;
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        a("jatolite");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    }

    public static WandTrick e() throws Exception {
        f();
        if (f267315h.f267320d != Integer.MIN_VALUE) goto L15;
        WandTrick r100 = f267315h;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267315h.f267320d != Integer.MIN_VALUE) goto L9;
        f267315h.h(o.c().f267415e);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        if (f267315h.f267320d == 0) goto L17;
        int r101 = f267315h.f267320d;
        throw new PatchException("Failed to initialize wand trick, load skipped, initialize ret = " + r101, r101);
    L17:
        return f267315h;
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
    }

    public static ArrayList d(Class r100) {
        ArrayList r101 = new ArrayList();
        Method[] r102 = e97.g.f(r100).f562915b;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Method r105 = r102[r104];
        if (r105.getDeclaringClass() != r100) goto L7;
        r101.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public static int[] g(Object[] r100) {
        int r101 = r100.length;
        int[] r102 = new int[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L12;
        Object r104 = r100[r103];
        if ((r104 instanceof Method) == false) goto L8;
        r102[r103] = ((Method) r104).getModifiers();
    L11:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof Constructor) == false) goto L10;
        r102[r103] = ((Constructor) r104).getModifiers();
        goto L11
    L10:
        r102[r103] = 0;
        goto L11
    L12:
        return r102;
    }

    public static boolean i(String r100) {
        String[] r101 = com.bytedance.reparo.core.a.f267326a;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103].equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final void h(i r100) {
        monitor-enter(this);
    L54:
        th = move-exception;
        throw th;
    L47:
        th = th;
        e97.i r101 = null;
    L50:
        if (this.f267320d == (-13)) goto L53;
        if (r101 == null) goto L53;
        r101.b();     // Catch: Throwable -> L54
    L53:
        throw th;     // Catch: Throwable -> L54
    L6:
        if (this.f267320d == Integer.MIN_VALUE) goto L9;
        monitor-exit(this);
        return;
    L9:
        r101 = new e97.i(r100.b(), e97.f.b(this.f267319c));     // Catch: Throwable -> L47
    L16:
        th = th;
        goto L50
    L11:
        if (e97.i.f471528e == false) goto L13;
        r101.a();     // Catch: Throwable -> L16
    L13:
        boolean r102 = true;
        this.f267318b = true;     // Catch: Throwable -> L16
        Application r103 = r100.f267371a;     // Catch: Throwable -> L16
        this.f267319c = r103;     // Catch: Throwable -> L16
        if (r100.f267376f != null) goto L18;
        r100.f267376f = new PolarisFileWrapper(r103.getFilesDir(), e97.f.b(r103) + "_init.info");     // Catch: Throwable -> L16
    L18:
        String r104 = r100.f267376f.getAbsolutePath();     // Catch: Throwable -> L16
        int r105 = 0;
        if ((this.f267319c.getApplicationInfo().flags & 2) != 0) goto L22;
        r102 = false;
    L22:
        if (r102 == false) goto L30;
        if (r100.f267377g == true) goto L30;
        b97.a.b("Hotfix disabled under debuggable mode.");     // Catch: Throwable -> L16
        Toast.makeText(this.f267319c, "Hotfix disabled under debuggable mode.", 0).show();     // Catch: Throwable -> L16
        this.f267320d = -1;     // Catch: Throwable -> L16
        r101.b();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L30:
        if (this.f267317a == false) goto L40;
        String[] r106 = new String[10];     // Catch: Throwable -> L16
        int r107 = initNative(this.f267318b, r104, r100.f267378h, r106);     // Catch: Throwable -> L16
        this.f267320d = r107;     // Catch: Throwable -> L16
        if (r107 != Integer.MIN_VALUE) goto L34;
        e97.c.b().execute(new q(this));     // Catch: Throwable -> L16
    L34:
        k.b r108 = k.f267379a;     // Catch: Throwable -> L16
    L35:
        if (r105 >= 10) goto L41;
        String r109 = r106[r105];     // Catch: Throwable -> L16
        if (r109 == null) goto L41;
        k.f267379a.d(r109);     // Catch: Throwable -> L16
        r105 = r105 + 1;     // Catch: Throwable -> L16
    L41:
        k.c("WandTrick", "initialize wand trick complete, ret = " + this.f267320d);     // Catch: Throwable -> L16
        if (this.f267320d == (-13)) goto L45;
        r101.b();     // Catch: Throwable -> L54
    L45:
        monitor-exit(this);
        return;
    L40:
        this.f267320d = -2;     // Catch: Throwable -> L16
        goto L41
    }

    public final int c(Map r110, List r111, List r112, List r113, d97.b r114) throws Exception {
        if (r110 == null) goto L61;
        if (r110.isEmpty() == true) goto L61;
        r114.b("prepare_for_deopt");
        Context r100 = this.f267319c;
        HashMap<String, Class> r101 = n.f267407a;
        ArrayList r102 = new ArrayList();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.getFilesDir(), "hotfix_opt");     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        if (r103.exists() == true) goto L10;
        r103.mkdirs();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L13:
        Iterator r104 = r111.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L15:
        if (r104.hasNext() == false) goto L29;
        String r105 = (String) r104.next();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        PolarisFileWrapper r107 = new PolarisFileWrapper(r103, r106.getName());     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        r106.setReadOnly();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        DexFile r108 = DexFile.loadDex(r105, r107.getAbsolutePath(), 0);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        n.f267408b.add(r108);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        if (r111.size() > 1) goto L25;
        if (r112 == null) goto L25;
        if (r112.isEmpty() == true) goto L25;
        Iterator r109 = r112.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L23:
        if (r109.hasNext() == false) goto L15;
        r102.add(n.i((String) r109.next(), r108));     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L25:
        Enumeration<String> r115 = r108.entries();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L27:
        if (r115.hasMoreElements() == false) goto L15;
        r102.add(n.i(r115.nextElement(), r108));     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        goto L27
    L29:
        Iterator r116 = r102.iterator();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L30:
        if (r116.hasNext() == false) goto L40;
        ClassModifier.c((Class) r116.next(), false);     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L40:
        if (r111 != null) goto L42;
    L48:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r102.iterator();
    L50:
        if (r118.hasNext() == false) goto L58;
        Class<?> r119 = (Class) r118.next();
        r117.addAll(d(r119));
        ArrayList r120 = new ArrayList();
        Constructor<?>[] r121 = r119.getDeclaredConstructors();
        int r122 = r121.length;
        int r123 = 0;
    L52:
        if (r123 >= r122) goto L57;
        Constructor<?> r124 = r121[r123];
        if (r124.getDeclaringClass() != r119) goto L56;
        r120.add(r124);
    L56:
        r123 = r123 + 1;
        goto L52
    L57:
        r117.addAll(r120);
        goto L50
    L58:
        r117.addAll(r113);
        r114.a("prepare_for_deopt");
        Object[] r125 = r117.toArray();
        String[] r126 = new String[10];
        int[] r127 = g(r125);
        r114.b("deoptimizeNative");
        String[] r128 = new String[100];
        r114.f467627e.add(r128);
        long[] r129 = new long[100];
        r114.f467628f.add(r129);
        int r130 = deoptimizeNative(r125, r127, true, r126, r128, r129);
        r114.a("deoptimizeNative");
        k.d("deopt", r126);
        return r130;
    L42:
        if (r111.isEmpty() == true) goto L48;
        if (r102.isEmpty() == false) goto L48;
        throw new Exception("Invalid additional class.");
    L10:
        if (r103.isDirectory() == true) goto L13;
        r103.delete();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
        r103.mkdirs();     // Catch: Exception -> L34 ClassNotFoundException -> L36 IOException -> L38
    L38:
        e = e;
    L39:
        b97.a.c("load additional class failed.", e);
    L36:
        e = e;
    L34:
        e = move-exception;
        b97.a.c("load additional class failed.", e);
    L61:
        throw new Exception("Invalid patch info.");
    }
}
