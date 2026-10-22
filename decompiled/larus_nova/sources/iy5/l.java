package iy5;

import com.bytedance.common.utility.reflect.ReflectException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final iy5.a f496563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f496564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Class<?>, HashMap<String, b>> f496565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Class<?>, HashMap<String, a>> f496566d;

    public static class a extends c<Field> {
        public a(Field r100, boolean r101) {
            super(r100);
        }
    }

    public static class b extends c<Method> {
        public b(Method r100, boolean r101) {
            super(r100);
        }
    }

    public static abstract class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f496567a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object r100) {
            this.f496567a = r100;
        }
    }

    public l(iy5.a r100, boolean r101) {
        this.f496565c = new HashMap();
        this.f496566d = new HashMap();
        this.f496563a = r100;
        this.f496564b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Field a(Class<?> r100, String r101, Class<?> r102) {
        HashMap<String, a> r103 = this.f496566d.get(r100);
        if (r103 != null) goto L5;
        r103 = new HashMap();
        this.f496566d.put(r100, r103);
    L5:
        a r104 = r103.get(r101);
        if (r104 == null) goto L12;
        Field r105 = (Field) r104.f496567a;
        if (r105 == null) goto L10;
    L11:
        return r105;
    L10:
        if (this.f496564b == false) goto L11;
    L13:
        boolean r106 = false;
        r105 = new k(r100).d(r101, new Class[0]);     // Catch: ReflectException -> L16
    L17:
        if (r105 != null) goto L20;
        r105 = this.f496563a.b(r100, r101, r102);
    L20:
        if (r105 == null) goto L22;
        r105.setAccessible(true);
    L24:
        if (r105 != null) goto L26;
        r106 = true;
    L26:
        r103.put(r101, new a(r105, r106));
        return r105;
    L22:
        Objects.toString(r100);
        goto L24
    L12:
        r105 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method b(Class<?> r100, String r101, Class<?>... r102) {
        HashMap<String, b> r103 = this.f496565c.get(r100);
        if (r103 != null) goto L5;
        r103 = new HashMap();
        this.f496565c.put(r100, r103);
    L5:
        b r104 = r103.get(r101);
        if (r104 == null) goto L12;
        Method r105 = (Method) r104.f496567a;
        if (r105 == null) goto L10;
    L11:
        return r105;
    L10:
        if (this.f496564b == false) goto L11;
    L28:
        r105 = new k(r100).f(r101, r102);     // Catch: ReflectException -> L15
    L16:
        if (r105 != null) goto L18;
        r105 = this.f496563a.c(r100, r101, r102);
    L18:
        boolean r106 = true;
        if (r105 == null) goto L21;
        r105.setAccessible(true);
    L23:
        if (r105 == null) goto L26;
        r106 = false;
    L26:
        r103.put(r101, new b(r105, r106));
        return r105;
    L21:
        Objects.toString(r100);
        goto L23
    L12:
        r105 = null;
        goto L28
    }
}
