package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            SoftReference<Object> r100 = this.value;
            if (r100 == null) goto L8;
            Object r101 = r100.get();
            if (r101 == null) goto L8;
            return unescape(r101);
        L8:
            T r102 = this.initializer.invoke();
            this.value = new SoftReference(escape(r102));
            return r102;
        }

        public LazySoftVal(T r100, Function0<T> r101) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r101;
            if (r100 == null) goto L8;
            this.value = new SoftReference(escape(r100));
            return;
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = null;

        public Val() {
        }

        public abstract T invoke();

        static {
            NULL_VALUE = new AnonymousClass1();
        }

        public Object escape(T r100) {
            if (r100 == null) goto L4;
            return r100;
        L4:
            return NULL_VALUE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T unescape(Object r100) {
            if (r100 != NULL_VALUE) goto L6;
            return null;
        L6:
            return r100;
        }

        public final T getValue(Object r100, Object r101) {
            return invoke();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"}));
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return lazySoft(null, r100);
    }

    public static <T> LazySoftVal<T> lazySoft(T r100, Function0<T> r101) {
        if (r101 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new LazySoftVal(r100, r101);
    }
}
