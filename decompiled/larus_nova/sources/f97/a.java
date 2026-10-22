package f97;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T>.AbstractC5872a f475975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f475976b;

    /* JADX INFO: renamed from: f97.a$a, reason: collision with other inner class name */
    public abstract class AbstractC5872a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f475977a;

        public abstract Method a() throws NoSuchMethodException;

        public AbstractC5872a() {
        }

        public T b(Object r100, Object... r101) throws InvocationTargetException, IllegalAccessException, ClassCastException {
            return (T) this.f475977a.invoke(r100, r101);
        }
    }

    public abstract List<? extends a<T>.AbstractC5872a> a();

    public a() {
        this.f475975a = null;
        this.f475976b = false;
    }

    public final T b(Object r100, Object... r101) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (this.f475976b == false) goto L5;
        a<T>.AbstractC5872a r102 = this.f475975a;
    L21:
        if (r102 == null) goto L25;
        return r102.b(r100, r101);
    L25:
        throw new NoSuchMethodException("NotFound method with " + getClass());
    L5:
        this.f475976b = true;
        List<? extends a<T>.AbstractC5872a> r103 = a();
        if (r103 != null) goto L8;
    L19:
        r102 = null;
    L20:
        this.f475975a = r102;
        goto L21
    L8:
        if (r103.isEmpty() == true) goto L19;
        Iterator<? extends a<T>.AbstractC5872a> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        a<T>.AbstractC5872a r105 = r104.next();
        Method r106 = r105.a();     // Catch: Throwable -> L16 NoSuchMethodException -> L18
        r105.f475977a = r106;     // Catch: Throwable -> L16 NoSuchMethodException -> L18
        r106.setAccessible(true);     // Catch: Throwable -> L16 NoSuchMethodException -> L18
        goto L12
    L15:
        r102 = r105;
    L16:
        th = move-exception;
        b97.a.c("Error when getMethod in " + getClass(), th);
        goto L12
    }
}
