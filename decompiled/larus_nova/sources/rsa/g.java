package rsa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f539157a = null;

    public interface a {
    }

    public static class b {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static Method b(Class<?> r100, String r101, Class<?>[] r110, Object... r111) {
            Method[] r102 = r100.getDeclaredMethods();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L68;
            Method r105 = r102[r104];
            if (r105.getName().equals(r101) == false) goto L67;
            if (r110 != null) goto L8;
            Class<?>[] r106 = r105.getParameterTypes();
            if (r106.length != r111.length) goto L62;
            int r107 = 0;
        L15:
            if (r107 >= r106.length) goto L64;
            if (r106[r107].isPrimitive() == false) goto L58;
            Class<?> r108 = r106[r107];
            if (r108 != Integer.TYPE) goto L24;
            if ((r111[r107] instanceof Integer) == false) goto L62;
        L24:
            if (r108 != Byte.TYPE) goto L29;
            if ((r111[r107] instanceof Byte) == false) goto L62;
        L29:
            if (r108 != Character.TYPE) goto L34;
            if ((r111[r107] instanceof Character) == false) goto L62;
        L34:
            if (r108 != Boolean.TYPE) goto L39;
            if ((r111[r107] instanceof Boolean) == false) goto L62;
        L39:
            if (r108 != Double.TYPE) goto L44;
            if ((r111[r107] instanceof Double) == false) goto L62;
        L44:
            if (r108 != Float.TYPE) goto L49;
            if ((r111[r107] instanceof Float) == false) goto L62;
        L49:
            if (r108 != Long.TYPE) goto L54;
            if ((r111[r107] instanceof Long) == false) goto L62;
        L54:
            if (r108 != Short.TYPE) goto L63;
            if ((r111[r107] instanceof Short) == false) goto L62;
        L63:
            r107 = r107 + 1;
            goto L15
        L58:
            Object r109 = r111[r107];
            if (r109 == null) goto L63;
            if (r106[r107].isInstance(r109) == true) goto L63;
        L64:
            boolean r112 = true;
        L65:
            if (r112 == false) goto L67;
            return r105;
        L62:
            r112 = false;
            goto L65
        L8:
            if (Arrays.equals(r105.getParameterTypes(), r110) == false) goto L67;
            return r105;
        L67:
            r104 = r104 + 1;
            goto L3
        L68:
            return null;
        }
    }

    static {
        f539157a = new Object();
    }
}
