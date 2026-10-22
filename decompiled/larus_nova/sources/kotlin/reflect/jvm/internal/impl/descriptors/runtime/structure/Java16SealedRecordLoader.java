package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = null;
    private static Cache _cache;

    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method isSealed() {
            return this.isSealed;
        }

        public Cache(Method r100, Method r101, Method r102, Method r103) {
            this.isSealed = r100;
            this.getPermittedSubclasses = r101;
            this.isRecord = r102;
            this.getRecordComponents = r103;
        }
    }

    static {
        INSTANCE = new Java16SealedRecordLoader();
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        return new Cache(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
    L6:
        return new Cache(null, null, null, null);
    }

    private final Cache initCache() {
        Cache r100 = _cache;
        if (r100 != null) goto L6;
        Cache r101 = buildCache();
        _cache = r101;
        return r101;
    L6:
        return r100;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Method r101 = initCache().getGetPermittedSubclasses();
        if (r101 != null) goto L6;
        return null;
    L6:
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) r102;
    }

    public final Object[] loadGetRecordComponents(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Method r101 = initCache().getGetRecordComponents();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (Object[]) r101.invoke(r100, new Object[0]);
    }

    public final Boolean loadIsRecord(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Method r101 = initCache().isRecord();
        if (r101 != null) goto L6;
        return null;
    L6:
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r102;
    }

    public final Boolean loadIsSealed(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Method r101 = initCache().isSealed();
        if (r101 != null) goto L6;
        return null;
    L6:
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r102;
    }
}
