package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
final class Java16RecordComponentsLoader {
    public static final Java16RecordComponentsLoader INSTANCE = null;
    private static Cache _cache;

    public static final class Cache {
        private final Method getAccessor;
        private final Method getType;

        public final Method getGetAccessor() {
            return this.getAccessor;
        }

        public final Method getGetType() {
            return this.getType;
        }

        public Cache(Method r100, Method r101) {
            this.getType = r100;
            this.getAccessor = r101;
        }
    }

    static {
        INSTANCE = new Java16RecordComponentsLoader();
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object r100) {
        Class<?> r101 = r100.getClass();
        return new Cache(r101.getMethod("getType", new Class[0]), r101.getMethod("getAccessor", new Class[0]));
    L6:
        return new Cache(null, null);
    }

    private final Cache initCache(Object r100) {
        Cache r101 = _cache;
        if (r101 != null) goto L6;
        Cache r102 = buildCache(r100);
        _cache = r102;
        return r102;
    L6:
        return r101;
    }

    public final Method loadGetAccessor(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "recordComponent");
        Method r101 = initCache(r100).getGetAccessor();
        if (r101 != null) goto L6;
        return null;
    L6:
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) r102;
    }

    public final Class<?> loadGetType(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "recordComponent");
        Method r101 = initCache(r100).getGetType();
        if (r101 != null) goto L6;
        return null;
    L6:
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) r102;
    }
}
