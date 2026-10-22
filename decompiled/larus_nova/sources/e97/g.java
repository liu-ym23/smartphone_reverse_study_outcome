package e97;

import android.os.Build;
import com.bytedance.reparo.core.k;
import com.bytedance.reparo.core.n;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method[] f471520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f97.c f471521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field[] f471522c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f97.b f471523d;

    static {
        f471520a = new Method[0];
        f471522c = new Field[0];
    }

    public static Field[] d(Class r100) {
        Field[] r101 = f471522c;
    L28:
        return r100.getDeclaredFields();
    L6:
        Field[] r102 = e(r100);     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        ArrayList r103 = new ArrayList(r102.length);     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        int r104 = r102.length;     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        Field r106 = r102[r105];     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        r106.getType();     // Catch: Throwable -> L11
        r103.add(r106);     // Catch: Throwable -> L11
    L12:
        r105 = r105 + 1;     // Catch: Throwable -> L15 NoSuchMethodException -> L19
    L11:
        Objects.toString(r100);     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        k.f267379a.b();     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        goto L12
    L13:
        r101 = new Field[r103.size()];     // Catch: Throwable -> L15 NoSuchMethodException -> L19
        return (Field[]) r103.toArray(r101);
    L5:
        return r101;
    L15:
        th = move-exception;
        b97.a.c("Err when getDeclaredFields for cls " + r100, th);
    L18:
        return r101;
    }

    public static Field[] e(Class r100) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (f471523d != null) goto L6;
        f471523d = new f97.b();
    L6:
        return f471523d.b(r100, new Object[0]);
    }

    public static x87.a<Method[], NoClassDefFoundError> f(Class r110) {
        Method[] r100 = f471520a;
        r100 = r110.getDeclaredMethods();     // Catch: Throwable -> L5 NoClassDefFoundError -> L7
    L28:
        return new x87.a(r100, null);
    L7:
        e = move-exception;
        Method[] r101 = g(r110);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        ArrayList r102 = new ArrayList(r101.length);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        int r103 = r101.length;     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L16;
        Method r105 = r101[r104];     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        r105.getReturnType();     // Catch: Throwable -> L13
        r105.getParameterTypes();     // Catch: Throwable -> L13
        r102.add(r105);     // Catch: Throwable -> L13
    L15:
        r104 = r104 + 1;     // Catch: Throwable -> L25 NoSuchMethodException -> L29
    L13:
        th = move-exception;
        Objects.toString(r110);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        k.f267379a.b();     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        e.addSuppressed(th);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        goto L15
    L16:
        Method[] r106 = new Method[r102.size()];     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        r102.toArray(r106);     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        int r107 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L25 NoSuchMethodException -> L29
        if (r107 == 26) goto L24;
        if (r107 == 27) goto L24;
        return new x87.a(r106, null);
    L24:
        return new x87.a(r106, e);
    L25:
        th = move-exception;
        b97.a.c("Err when getDeclaredMethods for cls " + r110, th);
    L5:
        th = move-exception;
        b97.a.c("Err when getDeclaredMethods for cls " + r110, th);
        goto L28
    }

    public static Method[] g(Class r100) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (f471521b != null) goto L6;
        f471521b = new f97.c();
    L6:
        return f471521b.b(r100, new Object[0]);
    }

    public static Field a(Class r100, String r101) throws NoSuchFieldException {
        Class r102 = r100;
    L3:
        if (r102 == null) goto L10;
        Field r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L8
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r103;
    L8:
        r102 = r102.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r101 + " not found in " + r100);
    }

    public static Method b(Object r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Class<?> r103 = r100.getClass();
        Class<?> r104 = r103;
    L3:
        if (r104 == null) goto L10;
        Method r105 = r104.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L8
        if (r105.isAccessible() == true) goto L7;
        r105.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r105;
    L8:
        r104 = r104.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method c(Class r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Class[] r103 = new Class[r102.length + 1];
        System.arraycopy(r102, 0, r103, 1, r102.length);
        Class r104 = r100;
    L3:
        if (r104 == null) goto L17;
        Class r105 = n.f267407a.get(r104.getName().concat("_PeerPatchClass"));
        if (r105 == 0) goto L19;
        k.c("Reparo", "findPeerPatchClass ".concat(r105.getName()));
        r103[0] = r104;     // Catch: NoSuchMethodException -> L18
        Method r106 = r105.getDeclaredMethod(n.f(r104.getName(), r101), r103);     // Catch: NoSuchMethodException -> L18
        if (r106.isAccessible() == true) goto L10;
        r106.setAccessible(true);     // Catch: NoSuchMethodException -> L18
    L10:
        return r106;
    L19:
        Method r107 = r104.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L15
        if (r107.isAccessible() == true) goto L14;
        r107.setAccessible(true);     // Catch: NoSuchMethodException -> L15
    L14:
        return r107;
    L15:
        r104 = r104.getSuperclass();
        goto L3
    L17:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r100);
    }
}
