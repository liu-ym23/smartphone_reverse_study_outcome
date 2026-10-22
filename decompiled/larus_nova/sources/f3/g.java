package f3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends AIBridgeMethod>, d> f475311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Class<? extends AIBridgeMethod>> f475312b = null;

    static {
        f475311a = new ConcurrentHashMap();
        f475312b = new ConcurrentHashMap();
    }

    public static e b(Class r110) {
        Method[] r100 = r110.getDeclaredMethods();
        Intrinsics.checkNotNull(r100);
        e r101 = new e(null);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Method r104 = r100[r103];
        AIBridgeParamField r105 = (AIBridgeParamField) r104.getAnnotation(AIBridgeParamField.class);
        if (r105 == null) goto L7;
        AIBridgeDefaultValue r106 = r105.defaultValue();
        n r107 = new n(r105.required(), r105.keyPath(), new j(r106.type(), r106.doubleValue(), r106.stringValue(), r106.intValue(), r106.boolValue(), r106.longValue()));
        r101.f475309a.put(r104, r107);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    public static Class a(Class r100, Class r101) {
        Class r102 = r100.getSuperclass();     // Catch: Throwable -> L30
        if (r102 == null) goto L20;
        Class<?>[] r103 = r102.getDeclaredClasses();     // Catch: Throwable -> L30
        if (r103 == null) goto L20;
        int r104 = r103.length;     // Catch: Throwable -> L30
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        Class<?> r106 = r103[r105];     // Catch: Throwable -> L30
        if (r106.getAnnotation(r101) == null) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L17;
        r105 = r105 + 1;     // Catch: Throwable -> L30
    L17:
        if (r106 == null) goto L20;
        return r106;
    L12:
        r107 = false;
        goto L13
    L16:
        r106 = null;
    L20:
        Class<?>[] r108 = r100.getDeclaredClasses();     // Catch: Throwable -> L30
        int r109 = r108.length;     // Catch: Throwable -> L30
        int r110 = 0;
    L21:
        if (r110 >= r109) goto L39;
        Class<?> r111 = r108[r110];     // Catch: Throwable -> L30
        if (r111.getAnnotation(r101) == null) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L37;
        r110 = r110 + 1;
        goto L21
    L37:
        return r111;
    L25:
        r112 = false;
        goto L26
    L39:
        return null;
    L38:
        return null;
    }
}
