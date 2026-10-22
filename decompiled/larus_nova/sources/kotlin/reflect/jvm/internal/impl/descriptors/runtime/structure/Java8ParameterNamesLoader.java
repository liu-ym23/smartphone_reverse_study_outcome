package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = null;
    private static Cache cache;

    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }

        public Cache(Method r100, Method r101) {
            this.getParameters = r100;
            this.getName = r101;
        }
    }

    static {
        INSTANCE = new Java8ParameterNamesLoader();
    }

    private Java8ParameterNamesLoader() {
    }

    public final Cache buildCache(Member r100) {
        Intrinsics.checkNotNullParameter(r100, "member");
        Class<?> r101 = r100.getClass();
        Method r102 = r101.getMethod("getParameters", new Class[0]);     // Catch: NoSuchMethodException -> L6
        return new Cache(r102, INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_descriptors_runtime_structure_Java8ParameterNamesLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ReflectClassUtilKt.getSafeClassLoader(r101), "java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
    L7:
        return new Cache(null, null);
    }

    public final List<String> loadParameterNames(Member r100) {
        Intrinsics.checkNotNullParameter(r100, "member");
        Cache r101 = cache;
        if (r101 != null) goto L13;
        monitor-enter(this);
        r101 = cache;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        r101 = INSTANCE.buildCache(r100);     // Catch: Throwable -> L10
        cache = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L10:
        th = move-exception;
        throw th;
    L13:
        Method r102 = r101.getGetParameters();
        if (r102 != null) goto L16;
        return null;
    L16:
        Method r103 = r101.getGetName();
        if (r103 != null) goto L19;
        return null;
    L19:
        Object r104 = r102.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r105 = (Object[]) r104;
        ArrayList r106 = new ArrayList(r105.length);
        int r107 = r105.length;
        int r108 = 0;
    L20:
        if (r108 >= r107) goto L22;
        Object r109 = r103.invoke(r105[r108], new Object[0]);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.String");
        r106.add((String) r109);
        r108 = r108 + 1;
        goto L20
    L22:
        return r106;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_kotlin_reflect_jvm_internal_impl_descriptors_runtime_structure_Java8ParameterNamesLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
