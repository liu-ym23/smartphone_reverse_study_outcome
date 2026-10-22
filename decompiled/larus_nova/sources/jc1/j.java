package jc1;

import androidx.camera.video.AudioStats;
import com.bytedance.common.utility.reflect.Reflect;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap<Object, Map<Class, Object>> f498079a;

    public static class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f498080a;

        public a(Object r100) {
            this.f498080a = r100;
        }

        public static Object a(Class r100) {
            if (r100 != Boolean.class) goto L7;
            return Boolean.FALSE;
        L7:
            if (r100 == Integer.class) goto L32;
            if (r100 == Short.class) goto L32;
            if (r100 == Byte.class) goto L32;
            if (r100 != Double.class) goto L18;
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        L18:
            if (r100 != Character.class) goto L22;
            return "";
        L22:
            if (r100 != Long.class) goto L26;
            return 0L;
        L26:
            if (r100 == Float.class) goto L28;
            return null;
        L28:
            return Float.valueOf(0.0f);
        L32:
            return 0;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            Object r103 = this.f498080a;
            if (r103 != null) goto L7;
            return a(Reflect.wrapper(r101.getReturnType()));
        L7:
            if (Proxy.isProxyClass(r103.getClass()) == true) goto L9;
            return Reflect.on(this.f498080a).call(r101.getName(), r101.getParameterTypes(), r102).get();
        L13:
            return a(Reflect.wrapper(r101.getReturnType()));
        L9:
            return Proxy.getInvocationHandler(this.f498080a).invoke(this.f498080a, r101, r102);
        }
    }

    public static <T> T a(Object r100, Class<T> r101) {
        if (f498079a != null) goto L5;
        f498079a = new WeakHashMap();
    L5:
        Map<Class, Object> r102 = f498079a.get(r100);
        if (r102 != null) goto L9;
        r102 = new HashMap();
        f498079a.put(r100, r102);
    L9:
        if (r102.get(r101) != null) goto L15;
        if (r100 != null) goto L12;
        Object r103 = null;
    L13:
        r102.put(r101, r103);
        goto L15
    L12:
        r103 = Proxy.newProxyInstance(r100.getClass().getClassLoader(), new Class[]{r101}, new a(r100));
    L15:
        return (T) r102.get(r101);
    }
}
