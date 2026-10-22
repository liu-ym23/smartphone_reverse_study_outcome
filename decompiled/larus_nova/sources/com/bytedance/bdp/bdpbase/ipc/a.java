package com.bytedance.bdp.bdpbase.ipc;

import com.bytedance.bdp.bdpbase.ipc.annotation.Callback;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Class<?>> f201132a;

    public a() {
        this.f201132a = new ConcurrentHashMap();
    }

    public final void a(Method r110, boolean r111) {
        Class<?>[] r100 = r110.getParameterTypes();
        Annotation[][] r101 = r110.getParameterAnnotations();
        if (r100.length != 0) goto L8;
        if (r101.length != 0) goto L8;
        return;
    L8:
        if (r100.length == r101.length) goto L18;
        g94.b.b("IPC_Invoker", new Object[]{"cacheCallbackClassOfMethod parameter error, method=" + r110.getName() + ", paramCls.length=" + r100.length + ", paramAnnotations.length=" + r101.length + ", from " + r110.getDeclaringClass()});
        String r112 = r110.getDeclaringClass().getName();
        String r113 = r110.getName();
        StringBuilder r102 = new StringBuilder("cache_callback_");
        r102.append(r100.length);
        r102.append("_");
        r102.append(r101.length);
        t.o("parse_parameter_error", r112, r113, r102.toString());
        StringBuilder r114 = new StringBuilder("parameterType: \n");
        int r115 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r115) goto L13;
        r114.append(r100[r103].getName());
        r114.append("\n");
        r103 = r103 + 1;
        goto L11
    L13:
        g94.b.b("IPC_Invoker", new Object[]{r114.toString()});
        StringBuilder r116 = new StringBuilder("parameterAnnotationsArray: \n");
        int r117 = r101.length;
        int r104 = 0;
    L14:
        if (r104 >= r117) goto L16;
        r116.append(Arrays.toString(r101[r104]));
        r116.append("\n");
        r104 = r104 + 1;
        goto L14
    L16:
        g94.b.b("IPC_Invoker", new Object[]{r116.toString()});
        return;
    L18:
        int r118 = 0;
    L20:
        if (r118 >= r100.length) goto L40;
        Class<?> r105 = r100[r118];
        Annotation[] r106 = r101[r118];
        boolean r107 = t.f201195a;
        if (r106 != null) goto L24;
    L32:
        boolean r108 = false;
    L33:
        if (r108 == false) goto L39;
        String r109 = r105.getSimpleName();
        if (r111 == false) goto L38;
        this.f201132a.putIfAbsent(r109, r105);
        goto L39
    L38:
        g94.b.d("IPC_Invoker", new Object[]{"handleCallbackClass unRegister: ".concat(r109)});
        g94.b.d("IPC_Invoker", new Object[]{"handleCallbackClass unRegister avoid Can't find callback class"});
    L39:
        r118 = r118 + 1;
        goto L20
    L24:
        if (r106.length <= 0) goto L32;
        int r119 = r106.length;
        int r120 = 0;
    L27:
        if (r120 >= r119) goto L32;
        if ((r106[r120] instanceof Callback) == true) goto L30;
        r120 = r120 + 1;
        goto L27
    L30:
        r108 = true;
        goto L33
    }
}
