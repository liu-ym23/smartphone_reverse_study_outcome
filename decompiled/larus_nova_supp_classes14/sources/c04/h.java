package c04;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {

    public static class a<T> implements InvocationHandler {
        public final WeakReference<T> a;

        public a(T r2) {
            this.a = new WeakReference(r2);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r1, Method r2, Object[] r3) throws Throwable {
            T r4 = this.a.get();
            if (r4 != null) goto L7;
            return null;
        L7:
            return r2.invoke(r4, r3);
        }
    }

    public static <T> T a(T r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        Class<?> r0 = r3.getClass();     // Catch: Throwable -> L11
        Class<?>[] r1 = r0.getInterfaces();     // Catch: Throwable -> L11
        if (r1 != null) goto L8;
        return r3;
    L8:
        if (r1.length <= 0) goto L15;
        return (T) Proxy.newProxyInstance(r0.getClassLoader(), r1, new a(r3));
    L15:
        return r3;
    L16:
        return r3;
    }
}
