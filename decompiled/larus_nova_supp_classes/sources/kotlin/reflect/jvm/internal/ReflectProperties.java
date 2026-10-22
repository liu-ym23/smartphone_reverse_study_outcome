package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ReflectProperties {

    public static class LazySoftVal<T> extends Val<T> implements Function0<T> {
        private final Function0<T> initializer;
        private volatile SoftReference<Object> value;

        private static /* synthetic */ void $$$reportNull$$$0(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"}));
        }

        @Override // kotlin.reflect.jvm.internal.ReflectProperties.Val, kotlin.jvm.functions.Function0
        public T invoke() {
            SoftReference<Object> r0 = this.value;
            if (r0 == null) goto L8;
            Object r1 = r0.get();
            if (r1 == null) goto L8;
            return unescape(r1);
        L8:
            T r2 = this.initializer.invoke();
            this.value = new SoftReference(escape(r2));
            return r2;
        }

        public LazySoftVal(T r2, Function0<T> r3) {
            if (r3 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.value = null;
            this.initializer = r3;
            if (r2 == null) goto L8;
            this.value = new SoftReference(escape(r2));
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

        public Object escape(T r1) {
            if (r1 == null) goto L4;
            return r1;
        L4:
            return NULL_VALUE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T unescape(Object r2) {
            if (r2 != NULL_VALUE) goto L6;
            return null;
        L6:
            return r2;
        }

        public final T getValue(Object r1, Object r2) {
            return invoke();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r2) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"}));
    }

    public static <T> LazySoftVal<T> lazySoft(Function0<T> r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return lazySoft(null, r1);
    }

    public static <T> LazySoftVal<T> lazySoft(T r1, Function0<T> r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new LazySoftVal(r1, r2);
    }
}
