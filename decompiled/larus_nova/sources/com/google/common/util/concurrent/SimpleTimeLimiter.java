package com.google.common.util.concurrent;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1, reason: invalid class name */
    public class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ SimpleTimeLimiter this$0;
        final /* synthetic */ Set val$interruptibleMethods;
        final /* synthetic */ Object val$target;
        final /* synthetic */ long val$timeoutDuration;
        final /* synthetic */ TimeUnit val$timeoutUnit;

        public static /* synthetic */ Object a(Method r100, Object r101, Object[] r102) {
            return lambda$invoke$0(r100, r101, r102);
        }

        private static /* synthetic */ Object lambda$invoke$0(Method r100, Object r101, Object[] r102) throws Exception {
            return r100.invoke(r101, r102);
        L4:
            e = move-exception;
            throw SimpleTimeLimiter.access$100(e, false);
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object r100, final Method r101, @CheckForNull final Object[] r102) throws Throwable {
            final Object r103 = this.val$target;
            Callable r104 = new x(r101, r103, r102);
            return SimpleTimeLimiter.access$000(this.this$0, r104, this.val$timeoutDuration, this.val$timeoutUnit, this.val$interruptibleMethods.contains(r101));
        }

        public AnonymousClass1(SimpleTimeLimiter r100, Object r101, long r102, TimeUnit r103, Set r104) {
            this.this$0 = r100;
            this.val$target = r101;
            this.val$timeoutDuration = r102;
            this.val$timeoutUnit = r103;
            this.val$interruptibleMethods = r104;
        }
    }

    private SimpleTimeLimiter(ExecutorService r100) {
        r100.getClass();
        this.executor = r100;
    }

    private static void checkPositiveTimeout(long r100) {
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.f(r101, "timeout must be positive: %s", r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static SimpleTimeLimiter create(ExecutorService r100) {
        return new SimpleTimeLimiter(r100);
    }

    private static boolean declaresInterruptedEx(Method r100) {
        Class<?>[] r101 = r100.getExceptionTypes();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103] == InterruptedException.class) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> r100) {
        HashSet r101 = new HashSet();
        Method[] r102 = r100.getMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Method r105 = r102[r104];
        if (declaresInterruptedEx(r105) == false) goto L7;
        r101.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable r100) throws ExecutionException {
        if ((r100 instanceof Error) == true) goto L11;
        if ((r100 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r100);
    L9:
        throw new ExecutionException(r100);
    L11:
        throw new ExecutionError((Error) r100);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable r100) {
        if ((r100 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r100);
    L7:
        throw new UncheckedExecutionException(r100);
    }

    public static /* synthetic */ Exception access$100(Exception r100, boolean r101) throws Exception {
        return throwCause(r100, r101);
    }

    private static <T> T newProxy(Class<T> r100, InvocationHandler r101) {
        return r100.cast(Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r101));
    }

    private static Exception throwCause(Exception r100, boolean r101) throws Exception {
        Throwable r102 = r100.getCause();
        if (r102 == null) goto L15;
        if (r101 == false) goto L7;
        StackTraceElement[] r103 = r102.getStackTrace();
        StackTraceElement[] r104 = r100.getStackTrace();
        Object[] r105 = (Object[]) Array.newInstance(StackTraceElement.class, r103.length + r104.length);
        System.arraycopy(r103, 0, r105, 0, r103.length);
        System.arraycopy(r104, 0, r105, r103.length, r104.length);
        r102.setStackTrace((StackTraceElement[]) r105);
    L7:
        if ((r102 instanceof Exception) == true) goto L14;
        if ((r102 instanceof Error) == true) goto L11;
        throw r100;
    L11:
        throw ((Error) r102);
    L14:
        throw ((Exception) r102);
    L15:
        throw r100;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws TimeoutException, ExecutionException {
        r100.getClass();
        r102.getClass();
        checkPositiveTimeout(r101);
        Future<T> r103 = this.executor.submit(r100);
        return (T) Uninterruptibles.getUninterruptibly(r103, r101, r102);
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r103.cancel(true);
        throw e;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> r100, long r101, TimeUnit r102) throws TimeoutException, InterruptedException, ExecutionException {
        r100.getClass();
        r102.getClass();
        checkPositiveTimeout(r101);
        Future<T> r103 = this.executor.submit(r100);
        return r103.get(r101, r102);
    L10:
        e = e;
    L11:
        r103.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = e;
        goto L11
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r100, long r101, TimeUnit r102) throws TimeoutException {
        r100.getClass();
        r102.getClass();
        checkPositiveTimeout(r101);
        Future<?> r103 = this.executor.submit(r100);
        Uninterruptibles.getUninterruptibly(r103, r101, r102);     // Catch: ExecutionException -> L5 TimeoutException -> L8
        return;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r103.cancel(true);
        throw e;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r100, long r101, TimeUnit r102) throws TimeoutException, InterruptedException {
        r100.getClass();
        r102.getClass();
        checkPositiveTimeout(r101);
        Future<?> r103 = this.executor.submit(r100);
        r103.get(r101, r102);     // Catch: ExecutionException -> L5 TimeoutException -> L8 InterruptedException -> L10
        return;
    L10:
        e = e;
    L11:
        r103.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = e;
        goto L11
    }

    @ParametricNullness
    private <T> T callWithTimeout(Callable<T> r100, long r101, TimeUnit r102, boolean r103) throws Exception {
        r100.getClass();
        r102.getClass();
        checkPositiveTimeout(r101);
        Future<T> r104 = this.executor.submit(r100);
        if (r103 == false) goto L10;
        return r104.get(r101, r102);
    L6:
        e = move-exception;
        r104.cancel(true);     // Catch: TimeoutException -> L11 ExecutionException -> L14
        throw e;     // Catch: TimeoutException -> L11 ExecutionException -> L14
    L10:
        return (T) Uninterruptibles.getUninterruptibly(r104, r101, r102);
    L14:
        e = move-exception;
        throw throwCause(e, true);
    L11:
        e = move-exception;
        r104.cancel(true);
        throw new UncheckedTimeoutException(e);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T r110, Class<T> r111, long r112, TimeUnit r113) {
        r110.getClass();
        r111.getClass();
        r113.getClass();
        checkPositiveTimeout(r112);
        com.google.common.base.m.c(r111.isInterface(), "interfaceType must be an interface type");
        return (T) newProxy(r111, new AnonymousClass1(this, r110, r112, r113, findInterruptibleMethods(r111)));
    }

    public static /* synthetic */ Object access$000(SimpleTimeLimiter r100, Callable r101, long r102, TimeUnit r103, boolean r104) throws Exception {
        return r100.callWithTimeout(r101, r102, r103, r104);
    }
}
