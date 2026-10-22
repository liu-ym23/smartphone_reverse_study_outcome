package kotlin.coroutines.jvm.internal;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ModuleNameRetriever {
    public static final ModuleNameRetriever INSTANCE = null;
    private static Cache cache;
    private static final Cache notOnJava9 = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method r100, Method r101, Method r102) {
            this.getModuleMethod = r100;
            this.getDescriptorMethod = r101;
            this.nameMethod = r102;
        }
    }

    private ModuleNameRetriever() {
    }

    static {
        INSTANCE = new ModuleNameRetriever();
        notOnJava9 = new Cache(null, null, null);
    }

    private final Cache buildCache(BaseContinuationImpl r100) {
        Cache r101 = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), INVOKEVIRTUAL_kotlin_coroutines_jvm_internal_ModuleNameRetriever_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClass().getClassLoader(), "java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), INVOKEVIRTUAL_kotlin_coroutines_jvm_internal_ModuleNameRetriever_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClass().getClassLoader(), "java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));     // Catch: Exception -> L4
        cache = r101;     // Catch: Exception -> L4
        return r101;
    L4:
        Cache r102 = notOnJava9;
        cache = r102;
        return r102;
    }

    public final String getModuleName(BaseContinuationImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "continuation");
        Cache r101 = cache;
        if (r101 != null) goto L6;
        r101 = buildCache(r100);
    L6:
        if (r101 != notOnJava9) goto L8;
        return null;
    L8:
        Method r102 = r101.getModuleMethod;
        if (r102 == null) goto L11;
        Object r103 = r102.invoke(r100.getClass(), new Object[0]);
    L12:
        if (r103 != null) goto L14;
        return null;
    L14:
        Method r104 = r101.getDescriptorMethod;
        if (r104 == null) goto L17;
        Object r105 = r104.invoke(r103, new Object[0]);
    L18:
        if (r105 != null) goto L20;
        return null;
    L20:
        Method r106 = r101.nameMethod;
        if (r106 == null) goto L23;
        Object r107 = r106.invoke(r105, new Object[0]);
    L25:
        if ((r107 instanceof String) == true) goto L27;
        return null;
    L27:
        return (String) r107;
    L23:
        r107 = null;
        goto L25
    L17:
        r105 = null;
        goto L18
    L11:
        r103 = null;
        goto L12
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_kotlin_coroutines_jvm_internal_ModuleNameRetriever_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
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
