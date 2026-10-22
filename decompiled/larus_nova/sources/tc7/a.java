package tc7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.BridgeMethodInfo;
import com.bytedance.sdk.bridge.Logger;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.d;
import com.bytedance.sdk.bridge.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, i> f545409a = null;

    static {
        f545409a = new ConcurrentHashMap();
    }

    public static i a(Class<?> r210) {
        Logger r100 = Logger.f269563c;
        "getInfoByReflect - ".concat(r210.getSimpleName());
        r100.getClass();
        Logger.a();
        i r101 = new i();
        LinkedList r102 = new LinkedList();
        r102.add(r210);
    L4:
        if (r102.isEmpty() == true) goto L99;
        Class r103 = (Class) r102.remove();
        Class<?>[] r104 = r103.getInterfaces();
        int r105 = 0;
    L6:
        if (r104 == null) goto L15;
        if (r105 >= r104.length) goto L15;
        if (b.class.isAssignableFrom(r104[r105]) == false) goto L14;
        Class<?> r106 = r104[r105];
        if (r106 == b.class) goto L14;
        r102.add(r106);
    L14:
        r105 = r105 + 1;
    L15:
        Class r107 = r103.getSuperclass();
        boolean r108 = true;
        if (r107 == null) goto L28;
        String r109 = r107.getName();
        if (r109.startsWith("java.") == false) goto L20;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == true) goto L28;
        r102.add(r107);
        goto L28
    L20:
        if (r109.startsWith("javax.") == true) goto L25;
        if (r109.startsWith("android.") == true) goto L25;
        r110 = false;
    L28:
        i r111 = (i) ((ConcurrentHashMap) f545409a).get(r103);
        if (r111 == null) goto L42;
        monitor-enter(r111);
        Iterator<BridgeMethodInfo> r112 = r111.a().iterator();     // Catch: Throwable -> L39
    L33:
        if (r112.hasNext() == false) goto L37;
        BridgeMethodInfo r113 = r112.next();     // Catch: Throwable -> L39
        if (((ConcurrentHashMap) r101.f269594a).containsKey(r113.getBridgeMethodName()) == true) goto L33;
        r101.b(r113.getBridgeMethodName(), r113);     // Catch: Throwable -> L39
        goto L33
    L37:
        monitor-exit(r111);     // Catch: Throwable -> L39
        LinkedList r114 = r102;
    L98:
        r102 = r114;
    L39:
        th = move-exception;
        throw th;
    L42:
        i r115 = new i();
        Method[] r116 = r103.getDeclaredMethods();
        int r117 = r116.length;
        int r118 = 0;
    L43:
        if (r118 >= r117) goto L95;
        Method r119 = r116[r118];
        BridgeMethod r120 = (BridgeMethod) r119.getAnnotation(BridgeMethod.class);
        if (r120 == null) goto L93;
        String r121 = r120.value();
        if (TextUtils.isEmpty(r121) == true) goto L93;
        if (((ConcurrentHashMap) r101.f269594a).containsKey(r121) == true) goto L93;
        r119.setAccessible(r108);
        String r122 = r120.privilege();
        String r123 = r120.sync();
        Annotation[][] r124 = r119.getParameterAnnotations();
        Class<?>[] r125 = r119.getParameterTypes();
        d[] r126 = new d[r124.length];
        int r127 = 0;
    L53:
        if (r127 >= r124.length) goto L92;
        LinkedList r128 = r102;
        int r129 = 0;
    L55:
        Annotation[] r130 = r124[r127];
        Method[] r131 = r116;
        if (r129 >= r130.length) goto L86;
        Annotation r132 = r130[r129];
        if ((r132 instanceof BridgeParam) == true) goto L59;
        int r133 = r117;
        Annotation[][] r134 = r124;
        if ((r132 instanceof BridgeContext) == true) goto L84;
        r129 = r129 + 1;
        r116 = r131;
        r117 = r133;
        r124 = r134;
        goto L55
    L84:
        r126[r127] = new d();
    L88:
        if (r126[r127] == null) goto L91;
        r127 = r127 + 1;
        r102 = r128;
        r116 = r131;
        r117 = r133;
        r124 = r134;
        goto L53
    L91:
        throw new IllegalArgumentException("Bridge param must be Annotated! Please check the bridge method [" + r121 + "]");
    L59:
        BridgeParam r135 = (BridgeParam) r132;
        Class<?> r136 = r125[r127];
        String r137 = r135.value();
        r133 = r117;
        if (r136 != Integer.TYPE) goto L62;
    L80:
        Object r138 = Integer.valueOf(r135.defaultInt());
    L81:
        r134 = r124;
        r126[r127] = new d(r136, r137, r138, r135.required());
        goto L88
    L62:
        if (r136 == Integer.class) goto L80;
        if (r136 != Long.TYPE) goto L68;
        r138 = Long.valueOf(r135.defaultLong());
        goto L81
    L68:
        if (r136 != Boolean.TYPE) goto L71;
        r138 = Boolean.valueOf(r135.defaultBoolean());
        goto L81
    L71:
        if (r136 != Double.TYPE) goto L74;
        r138 = Double.valueOf(r135.defaultDouble());
        goto L81
    L74:
        if (r136 != Float.TYPE) goto L77;
        r138 = Float.valueOf(r135.defaultFloat());
        goto L81
    L77:
        if (r136 != String.class) goto L79;
        r138 = r135.defaultString();
        goto L81
    L79:
        r138 = null;
        goto L81
    L86:
        r133 = r117;
        r134 = r124;
        goto L88
    L92:
        LinkedList r139 = r102;
        Method[] r140 = r116;
        int r141 = r117;
        BridgeMethodInfo r142 = new BridgeMethodInfo(r119, r121, r122, r123, r126);
        r101.b(r121, r142);
        r115.b(r121, r142);
    L94:
        r118 = r118 + 1;
        r102 = r139;
        r116 = r140;
        r117 = r141;
        r108 = true;
    L93:
        r139 = r102;
        r140 = r116;
        r141 = r117;
        goto L94
    L95:
        r114 = r102;
        if (r115.a().isEmpty() == true) goto L98;
        ((ConcurrentHashMap) f545409a).put(r103, r115);
        goto L98
    L99:
        return r101;
    }

    public static i b(Class<?> r100) {
        return a(r100);
    L4:
        e = move-exception;
        Logger r101 = Logger.f269563c;
        e.getMessage();
        r101.getClass();
        Logger.b();
        return null;
    }
}
