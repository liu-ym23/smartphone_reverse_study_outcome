package nvc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f520929a = 0;

    /* JADX INFO: renamed from: nvc.a$a, reason: collision with other inner class name */
    public static class C6981a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f520930a;

        public C6981a(Object r100) {
            this.f520930a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            return a.b(r101, this.f520930a.getClass().getClassLoader()).invoke(this.f520930a, r102);
        L8:
            e = move-exception;
            throw e.getTargetException();
        L5:
            e = move-exception;
            throw new RuntimeException("Reflection failed for method " + r101, e);
        }
    }

    public a() {
    }

    static {
    }

    public static <T> T a(Class<T> r100, InvocationHandler r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return r100.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{r100}, r101));
    }

    public static Method b(Method r100, ClassLoader r101) throws ClassNotFoundException, NoSuchMethodException {
        String r102 = r100.getDeclaringClass().getName();
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L35;
        Class<?> r105 = Class.forName(r102, true, r101);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r102);     // Catch: Throwable -> L17
    L30:
        Class<?>[] r106 = r100.getParameterTypes();
        return r105.getDeclaredMethod(r100.getName(), r106);
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r102);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        r105 = MiraPluginFix.forName(r102);
        goto L30
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    L35:
        r105 = Class.forName(r102, true, r101);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.a(r102);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r102);
    L12:
        throw th;
    }
}
