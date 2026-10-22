package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class JSModuleWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSModule f272490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<MethodDescriptor> f272491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<AttributeDescriptor> f272492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f272493d;

    public final void a() {
        HashSet r100 = new HashSet();
        Field[] r101 = this.f272490a.getClass().getDeclaredFields();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        Field r104 = r101[r103];
        if (((JSAttribute) r104.getAnnotation(JSAttribute.class)) == null) goto L16;
        String r105 = r104.getName();
        if (r100.contains(r105) == true) goto L15;
        r100.add(r105);
        AttributeDescriptor r106 = new AttributeDescriptor();
        r106.f272485a = r105;
        JavaOnlyArray r107 = new JavaOnlyArray();
        r106.f272486b = r107;
        r107.add(r104.get(this.f272490a));     // Catch: IllegalAccessException -> L11
    L13:
        this.f272492c.add(r106);
    L11:
        e = move-exception;
        e.toString();
        goto L13
    L15:
        throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + r105);
    L16:
        r103 = r103 + 1;
        goto L3
    }

    public final void b() {
        HashSet r100 = new HashSet();
        Method[] r101 = this.f272490a.getClass().getDeclaredMethods();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L68;
        Method r104 = r101[r103];
        if (((JSMethod) r104.getAnnotation(JSMethod.class)) == null) goto L67;
        String r105 = r104.getName();
        if (r100.contains(r105) == true) goto L66;
        r100.add(r105);
        MethodDescriptor r106 = new MethodDescriptor();
        r104.setAccessible(true);
        Class<?>[] r110 = r104.getParameterTypes();
        r106.f272496c = r105;
        StringBuilder r107 = new StringBuilder(r110.length + 2);
        Class<?> r111 = r104.getReturnType();
        char r112 = a.a(r111);
        if (r112 == 0) goto L12;
    L22:
        r107.append(r112);
        r107.append('.');
        int r113 = 0;
    L24:
        if (r113 >= r110.length) goto L58;
        Class<?> r114 = r110[r113];
        if (r114 == Promise.class) goto L28;
    L35:
        char r115 = a.a(r114);
        if (r115 != 0) goto L55;
        if (r114 != Callback.class) goto L42;
        r115 = 'X';
        goto L55
    L42:
        if (r114 != Promise.class) goto L45;
        r115 = 'P';
        goto L55
    L45:
        if (r114 != ReadableMap.class) goto L48;
        r115 = 'M';
        goto L55
    L48:
        if (r114 != ReadableArray.class) goto L51;
        r115 = 'A';
        goto L55
    L51:
        if (r114 != sp7.a.class) goto L53;
        r115 = 'Y';
        goto L55
    L53:
        if (r114 != byte[].class) goto L57;
        r115 = 'a';
        goto L55
    L57:
        throw new RuntimeException("Got unknown param class: ".concat(r114.getSimpleName()));
    L55:
        r107.append(r115);
        r113 = r113 + 1;
        goto L24
    L28:
        if (r113 != (r110.length - 1)) goto L30;
        boolean r116 = true;
    L31:
        if (r116 == true) goto L35;
        throw new AssertionError("Promise must be used as last parameter only");
    L30:
        r116 = false;
        goto L31
    L58:
        String r108 = r107.toString();
        if (r108 == null) goto L62;
        r106.f272495b = r108;
        r106.f272494a = r104;
        this.f272491b.add(r106);
        goto L67
    L62:
        throw new AssertionError();
    L12:
        if (r111 != Void.TYPE) goto L15;
        r112 = 'v';
        goto L22
    L15:
        if (r111 != WritableMap.class) goto L18;
        r112 = 'M';
        goto L22
    L18:
        if (r111 != WritableArray.class) goto L20;
        r112 = 'A';
        goto L22
    L20:
        if (r111 != byte[].class) goto L64;
        r112 = 'a';
        goto L22
    L64:
        throw new RuntimeException("Got unknown return class: ".concat(r111.getSimpleName()));
    L66:
        throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + r105);
    L67:
        r103 = r103 + 1;
        goto L3
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        if (this.f272492c.isEmpty() == false) goto L9;
        a();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        e.toString();
    L9:
        return this.f272492c;
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        if (this.f272491b.isEmpty() == false) goto L9;
        b();     // Catch: RuntimeException -> L6
    L6:
        e = move-exception;
        e.toString();
    L9:
        return this.f272491b;
    }

    public JSModule getModule() {
        return this.f272490a;
    }

    public String getName() {
        return this.f272493d;
    }

    public JSModuleWrapper(String r100, JSModule r101) {
        this.f272493d = r100;
        this.f272490a = r101;
        this.f272491b = new ArrayList();
        this.f272492c = new ArrayList();
    }
}
