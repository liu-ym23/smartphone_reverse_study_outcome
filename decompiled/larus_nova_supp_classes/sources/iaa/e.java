package iaa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    public static final Method a = null;

    static {
        Iterator r0 = ArrayIteratorKt.iterator(a().getMethods());     // Catch: ClassNotFoundException -> L19
    L4:
        if (r0.hasNext() == false) goto L38;
        Method r1 = (Method) r0.next();     // Catch: ClassNotFoundException -> L19
        String r2 = r1.getName();     // Catch: ClassNotFoundException -> L19
        if (r2 == null) goto L4;
        switch(r2.hashCode()) {
            case -1249359687: goto L16;
            case -75354382: goto L15;
            case 102230: goto L13;
            case 113762: goto L11;
            default: goto L4;
        };     // Catch: ClassNotFoundException -> L19
    L11:
        String r3 = "set";
    L17:
        r2.equals(r3);     // Catch: ClassNotFoundException -> L19
        goto L4
    L13:
        if (r2.equals("get") == false) goto L4;
        a = r1;     // Catch: ClassNotFoundException -> L19
        goto L4
    L15:
        r3 = "getLong";
        goto L17
    L16:
        r3 = "getInt";
        goto L17
    L38:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static String b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "default_value");
        Method r0 = a;
        if (r0 != null) goto L18;
        return r4;
    L18:
        Object r5 = r0.invoke(null, new Object[]{r3, r4});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.String");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        return (String) r5;
    L10:
        e = move-exception;
        e.printStackTrace();
    L17:
        return r4;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
