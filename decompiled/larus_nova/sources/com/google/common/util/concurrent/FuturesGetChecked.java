package com.google.common.util.concurrent;

import com.google.common.collect.Ordering;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = null;

    public interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> r100);
    }

    public static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = null;

        public static final enum WeakSetValidator extends Enum<WeakSetValidator> implements GetCheckedTypeValidator {
            private static final /* synthetic */ WeakSetValidator[] $VALUES = null;
            public static final WeakSetValidator INSTANCE = null;
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            private static /* synthetic */ WeakSetValidator[] $values() {
                return new WeakSetValidator[]{INSTANCE};
            }

            static {
                INSTANCE = new WeakSetValidator("INSTANCE", 0);
                $VALUES = $values();
                validClasses = new CopyOnWriteArraySet();
            }

            public static WeakSetValidator[] values() {
                return (WeakSetValidator[]) $VALUES.clone();
            }

            public static WeakSetValidator valueOf(String r100) {
                return (WeakSetValidator) r27.a.a(WeakSetValidator.class, r100);
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> r100) {
                Iterator<WeakReference<Class<? extends Exception>>> r101 = validClasses.iterator();
            L4:
                if (r101.hasNext() == false) goto L8;
                if (r100.equals(r101.next().get()) == false) goto L4;
                return;
            L8:
                FuturesGetChecked.checkExceptionClassValidity(r100);
                Set<WeakReference<Class<? extends Exception>>> r102 = validClasses;
                if (r102.size() <= 1000) goto L11;
                r102.clear();
            L11:
                r102.add(new WeakReference(r100));
            }

            private WeakSetValidator(String r100, int r101) {
                super(r100, r101);
            }
        }

        public GetCheckedTypeValidatorHolder() {
        }

        static {
            BEST_VALIDATOR = getBestValidator();
        }

        public static GetCheckedTypeValidator getBestValidator() {
            return FuturesGetChecked.weakSetValidator();
        }
    }

    private FuturesGetChecked() {
    }

    public static /* synthetic */ Boolean a(Constructor r100) {
        return lambda$static$0(r100);
    }

    static {
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new v()).reverse();
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    public static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    public static void checkExceptionClassValidity(Class<? extends Exception> r100) {
        com.google.common.base.m.h(isCheckedException(r100), "Futures.getChecked exception type (%s) must not be a RuntimeException", r100);
        com.google.common.base.m.h(hasConstructorUsableByGetChecked(r100), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", r100);
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> r100) {
        newWithCause(r100, new Exception());     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean isCheckedException(Class<? extends Exception> r100) {
        return !RuntimeException.class.isAssignableFrom(r100);
    }

    private static /* synthetic */ Boolean lambda$static$0(Constructor r100) {
        return Boolean.valueOf(Arrays.asList(r100.getParameterTypes()).contains(String.class));
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> r100) {
        return (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(r100);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r100, Class<X> r101) throws Exception {
        return (V) getChecked(bestGetCheckedTypeValidator(), r100, r101);
    }

    @CheckForNull
    private static <X> X newFromConstructor(Constructor<X> r100, Throwable r101) {
        Class<?>[] r102 = r100.getParameterTypes();
        Object[] r103 = new Object[r102.length];
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L16;
        Class<?> r105 = r102[r104];
        if (r105.equals(String.class) == false) goto L9;
        r103[r104] = r101.toString();
    L11:
        r104 = r104 + 1;
        goto L4
    L9:
        if (r105.equals(Throwable.class) == false) goto L12;
        r103[r104] = r101;
        goto L11
    L12:
        return null;
    L16:
        return r100.newInstance(r103);
    L15:
        return null;
    }

    private static <X extends Exception> X newWithCause(Class<X> r100, Throwable r101) {
        Iterator r102 = preferringStrings(Arrays.asList(r100.getConstructors())).iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        X r103 = (X) newFromConstructor((Constructor) r102.next(), r101);
        if (r103 == null) goto L4;
        if (r103.getCause() != null) goto L10;
        r103.initCause(r101);
    L10:
        return r103;
    L12:
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + r100 + " in response to chained exception", r101);
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable r100, Class<X> r101) throws Exception {
        if ((r100 instanceof Error) == true) goto L11;
        if ((r100 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r100);
    L9:
        throw newWithCause(r101, r100);
    L11:
        throw new ExecutionError((Error) r100);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(GetCheckedTypeValidator r100, Future<V> r101, Class<X> r102) throws Exception {
        r100.validateClass(r102);
        return r101.get();
    L8:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        throw newWithCause(r102, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r102);
        throw new AssertionError();
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> r100, Class<X> r101, long r102, TimeUnit r103) throws Exception {
        bestGetCheckedTypeValidator().validateClass(r101);
        return r100.get(r102, r103);
    L11:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        throw newWithCause(r101, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r101);
        throw new AssertionError();
    L8:
        e = move-exception;
        throw newWithCause(r101, e);
    }
}
