package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class JSModuleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f272487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, JSModuleWrapper> f272488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f272489c;

    public void destroy() {
        this.f272489c = null;
        ConcurrentHashMap<String, JSModuleWrapper> r100 = this.f272488b;
        if (r100 == null) goto L5;
        r100.clear();
        this.f272488b = null;
    L5:
        this.f272487a.clear();
    }

    public JSModuleManager(Context r100) {
        this.f272487a = new ConcurrentHashMap();
        this.f272489c = r100;
    }

    private JSModuleWrapper moduleWrapperForName(String r100) {
        return a(r100);
    }

    public final JSModuleWrapper a(String r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        if (this.f272488b != null) goto L9;
        this.f272488b = new ConcurrentHashMap();
    L9:
        if (this.f272488b.get(r110) != null) goto L11;
        b r100 = this.f272487a.get(r110);
        if (r100 != null) goto L15;
        return null;
    L15:
        Class<? extends JSModule> r101 = r100.f272499b;
    L42:
        e = move-exception;
        Objects.toString(e);
    L46:
        JSModule r102 = null;
    L47:
        if (r102 == null) goto L49;
        JSModuleWrapper r103 = new JSModuleWrapper(r110, r102);
        this.f272488b.put(r110, r103);
        return r103;
    L49:
        return null;
    L44:
        e = move-exception;
        Objects.toString(e);
    L40:
        e = move-exception;
        Objects.toString(e);
    L38:
        e = move-exception;
        Objects.toString(e);
    L36:
        e = move-exception;
        Objects.toString(e);
        goto L46
    L17:
        if (r100.f272500c != null) goto L33;
        Constructor<?>[] r104 = r101.getConstructors();     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        int r105 = r104.length;     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        int r106 = 0;
    L19:
        if (r106 >= r105) goto L46;
        Constructor<?> r107 = r104[r106];     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        Class<?>[] r108 = r107.getParameterTypes();     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        if (r108.length != 1) goto L26;
        if (Context.class.equals(r108[0]) == false) goto L26;
        r102 = (JSModule) r107.newInstance(new Object[]{this.f272489c});     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
    L26:
        if (r108.length != 2) goto L32;
        if (Context.class.equals(r108[0]) == false) goto L32;
        if (Object.class.equals(r108[1]) == false) goto L32;
        r102 = (JSModule) r107.newInstance(new Object[]{this.f272489c, null});     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
    L32:
        r106 = r106 + 1;     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        goto L19
    L33:
        if (r101 == null) goto L46;
        r102 = r101.getConstructor(new Class[]{Context.class, Object.class}).newInstance(new Object[]{this.f272489c, r100.f272500c});     // Catch: Exception -> L36 InvocationTargetException -> L38 NoSuchMethodException -> L40 IllegalAccessException -> L42 InstantiationException -> L44
        goto L47
    L11:
        return this.f272488b.get(r110);
    }

    public final void b(String r100, Class<? extends JSModule> r101, Object r102) {
        b r103 = new b();
        r103.f272498a = r100;
        r103.f272499b = r101;
        r103.f272500c = r102;
        b r104 = this.f272487a.get(r100);
        if (r104 == null) goto L5;
        r104.toString();
    L5:
        this.f272487a.put(r100, r103);
        Objects.toString(r101);
    }
}
