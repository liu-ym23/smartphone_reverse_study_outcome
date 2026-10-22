package com.huawei.agconnect.core.a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Service> f276764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, Object> f276765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<Class<?>, Service> f276766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<Class<?>, Object> f276767d;

    static {
        f276764a = new HashMap();
        f276765b = new HashMap();
    }

    public d(List<Service> r100, Context r101) {
        this.f276766c = new HashMap();
        this.f276767d = new HashMap();
        a(r100, r101);
    }

    private Object a(AGConnectInstance r100, Service r101) {
        if (r101.getInstance() != null) goto L5;
        Class<?> r102 = r101.getType();
        if (r102 != null) goto L27;
        return null;
    L27:
        Constructor r103 = a(r102, new Class[]{Context.class, AGConnectInstance.class});     // Catch: IllegalAccessException -> L20 InvocationTargetException -> L22 InstantiationException -> L24
        if (r103 != null) goto L13;
        Constructor r104 = a(r102, new Class[]{Context.class});     // Catch: IllegalAccessException -> L20 InvocationTargetException -> L22 InstantiationException -> L24
        if (r104 == null) goto L19;
        return r104.newInstance(new Object[]{r100.getContext()});
    L19:
        return r102.newInstance();
    L13:
        return r103.newInstance(new Object[]{r100.getContext(), r100});
    L20:
        e = move-exception;
        e.getLocalizedMessage();
    L26:
        return null;
    L24:
        e = move-exception;
        e.getLocalizedMessage();
    L22:
        e = move-exception;
        e.getLocalizedMessage();
        goto L26
    L5:
        return r101.getInstance();
    }

    private static Constructor a(Class r100, Class... r101) {
        Constructor<?>[] r102 = r100.getDeclaredConstructors();
        int r103 = r102.length;
        int r104 = 0;
        boolean r105 = false;
    L3:
        if (r104 >= r103) goto L17;
        Constructor<?> r106 = r102[r104];
        Class<?>[] r107 = r106.getParameterTypes();
        if (r107.length != r101.length) goto L16;
        int r108 = 0;
    L8:
        if (r108 >= r101.length) goto L14;
        if (r107[r108] != r101[r108]) goto L12;
        r105 = true;
    L13:
        r108 = r108 + 1;
        goto L8
    L12:
        r105 = false;
        goto L13
    L14:
        if (r105 == false) goto L16;
        return r106;
    L16:
        r104 = r104 + 1;
        goto L3
    L17:
        return null;
    }

    private void a(String r100, Exception r101) {
        r101.getLocalizedMessage();
        if (r101.getCause() == null) goto L6;
        r101.getCause().getMessage();
        return;
    }

    public <T> T a(AGConnectInstance r100, Class<?> r101) {
        Service r102 = this.f276766c.get(r101);
        if (r102 != null) goto L8;
        r102 = f276764a.get(r101);
        if (r102 == null) goto L8;
        return (T) f276765b.get(r101);
    L8:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.isSingleton() == false) goto L16;
        T r103 = (T) this.f276767d.get(r101);
        if (r103 == null) goto L16;
        return r103;
    L16:
        T r104 = (T) a(r100, r102);
        if (r104 != null) goto L19;
    L21:
        return r104;
    L19:
        if (r102.isSingleton() == false) goto L21;
        this.f276767d.put(r101, r104);
        goto L21
    }

    public void a(List<Service> r100, Context r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Service> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L33;
        Service r103 = r102.next();
        if (r103.isSharedInstance() == true) goto L10;
        Map<Class<?>, Service> r104 = this.f276766c;
    L13:
        r104.put(r103.getInterface(), r103);
    L15:
        if (r103.isAutoCreated() == false) goto L6;
        if (r103.getType() == null) goto L6;
        if (f276765b.containsKey(r103.getInterface()) == true) goto L6;
        Constructor r105 = a(r103.getType(), new Class[]{Context.class});     // Catch: InvocationTargetException -> L26 InstantiationException -> L28 IllegalAccessException -> L30
    L21:
        if (r105 == null) goto L23;
        Object r106 = r105.newInstance(new Object[]{r101});     // Catch: InvocationTargetException -> L26 InstantiationException -> L28 IllegalAccessException -> L30
    L24:
        f276765b.put(r103.getInterface(), r106);     // Catch: InvocationTargetException -> L26 InstantiationException -> L28 IllegalAccessException -> L30
        goto L6
    L23:
        r106 = r103.getType().newInstance();     // Catch: InvocationTargetException -> L26 InstantiationException -> L28 IllegalAccessException -> L30
    L30:
        e = e;
        String r107 = "AccessException";
    L32:
        a(r107, e);
    L28:
        e = e;
        r107 = "InstantiationException";
    L26:
        e = e;
        r107 = "TargetException";
        goto L32
    L10:
        if (f276764a.containsKey(r103.getInterface()) == true) goto L15;
        r104 = f276764a;
        goto L13
    }
}
