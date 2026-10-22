package kotlin.reflect.jvm.internal.impl.utils;

import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: classes5.dex */
public class WrappedValues {
    private static final Object NULL_VALUE = null;
    public static volatile boolean throwWrappedProcessCanceledException;

    public static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 1) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r100 == 1) goto L9;
            int r102 = 3;
        L10:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L13;
            r103[0] = LynxError.LYNX_THROWABLE;
        L14:
            if (r100 == 1) goto L16;
            r103[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        L17:
            if (r100 == 1) goto L19;
            r103[2] = "<init>";
        L19:
            String r104 = String.format(r101, r103);
            if (r100 == 1) goto L23;
            throw new IllegalArgumentException(r104);
        L23:
            throw new IllegalStateException(r104);
        L16:
            r103[1] = "getThrowable";
            goto L17
        L13:
            r103[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            goto L14
        L9:
            r102 = 2;
            goto L10
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        public Throwable getThrowable() {
            Throwable r100 = this.throwable;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r100;
        }

        public String toString() {
            return this.throwable.toString();
        }

        private ThrowableWrapper(Throwable r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.throwable = r100;
        }

        public /* synthetic */ ThrowableWrapper(Throwable r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable r100) {
            super("Rethrow stored exception", r100);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 1) goto L6;
        if (r100 == 2) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        r103[0] = "value";
    L19:
        if (r100 == 1) goto L22;
        if (r100 == 2) goto L22;
        r103[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L23:
        if (r100 == 1) goto L31;
        if (r100 == 2) goto L31;
        if (r100 != 3) goto L27;
        r103[2] = "escapeThrowable";
        goto L31
    L27:
        if (r100 == 4) goto L29;
        r103[2] = "unescapeNull";
        goto L31
    L29:
        r103[2] = "unescapeExceptionOrNull";
    L31:
        String r104 = String.format(r101, r103);
        if (r100 == 1) goto L36;
        if (r100 == 2) goto L36;
        throw new IllegalArgumentException(r104);
    L36:
        throw new IllegalStateException(r104);
    L22:
        r103[1] = "escapeNull";
        goto L23
    L17:
        r103[0] = LynxError.LYNX_THROWABLE;
    L18:
        r103[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        NULL_VALUE = new AnonymousClass1();
        throwWrappedProcessCanceledException = false;
    }

    public static <V> Object escapeNull(V r100) {
        if (r100 != null) goto L6;
        r100 = (V) NULL_VALUE;
        if (r100 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        return r100;
    }

    public static Object escapeThrowable(Throwable r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(3);
    L5:
        return new ThrowableWrapper(r100, null);
    }

    public static <V> V unescapeExceptionOrNull(Object r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return (V) unescapeNull(unescapeThrowable(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object r100) {
        if (r100 != 0) goto L5;
        $$$reportNull$$$0(0);
    L5:
        if (r100 != NULL_VALUE) goto L8;
        return null;
    L8:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object r100) {
        if ((r100 instanceof ThrowableWrapper) == false) goto L12;
        Throwable r101 = ((ThrowableWrapper) r100).getThrowable();
        if (throwWrappedProcessCanceledException == false) goto L11;
        if (ExceptionUtilsKt.isProcessCanceledException(r101) == false) goto L11;
        throw new WrappedProcessCanceledException(r101);
    L11:
        throw ExceptionUtilsKt.rethrow(r101);
    L12:
        return r100;
    }
}
