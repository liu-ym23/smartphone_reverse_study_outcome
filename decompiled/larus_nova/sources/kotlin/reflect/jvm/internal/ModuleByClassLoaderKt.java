package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "clearModuleByClassLoaderCache", "", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModuleByClassLoaderKt {
    private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = null;

    static {
        moduleByClassLoader = new ConcurrentHashMap();
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }

    public static final RuntimeModuleData getOrCreateModule(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ClassLoader r101 = ReflectClassUtilKt.getSafeClassLoader(r100);
        WeakClassLoaderBox r102 = new WeakClassLoaderBox(r101);
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r103 = moduleByClassLoader;
        WeakReference<RuntimeModuleData> r104 = r103.get(r102);
        if (r104 == null) goto L8;
        RuntimeModuleData r105 = r104.get();
        if (r105 == null) goto L7;
        return r105;
    L7:
        r103.remove(r102, r104);
    L8:
        RuntimeModuleData r106 = RuntimeModuleData.Companion.create(r101);
    L23:
        ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> r107 = moduleByClassLoader;     // Catch: Throwable -> L20
        WeakReference<RuntimeModuleData> r108 = r107.putIfAbsent(r102, new WeakReference(r106));     // Catch: Throwable -> L20
        if (r108 == null) goto L12;
        RuntimeModuleData r109 = r108.get();     // Catch: Throwable -> L20
        if (r109 != null) goto L16;
        r107.remove(r102, r108);     // Catch: Throwable -> L20
        goto L23
    L16:
        r102.setTemporaryStrongRef(null);
        return r109;
    L12:
        r102.setTemporaryStrongRef(null);
        return r106;
    L20:
        th = move-exception;
        r102.setTemporaryStrongRef(null);
        throw th;
    }
}
