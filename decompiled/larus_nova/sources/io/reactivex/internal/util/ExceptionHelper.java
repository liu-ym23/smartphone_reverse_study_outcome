package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ExceptionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Throwable f495041a = null;

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        public Termination() {
            super("No further exceptions");
        }
    }

    static {
        f495041a = new Termination();
    }

    public static <T> Throwable b(AtomicReference<Throwable> r100) {
        Throwable r101 = r100.get();
        Throwable r102 = f495041a;
        if (r101 != r102) goto L5;
        return r101;
    L5:
        return r100.getAndSet(r102);
    }

    public static RuntimeException d(Throwable r100) {
        if ((r100 instanceof Error) == true) goto L11;
        if ((r100 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r100;
    L9:
        return new RuntimeException(r100);
    L11:
        throw ((Error) r100);
    }

    public static <T> boolean a(AtomicReference<Throwable> r100, Throwable r101) {
    L2:
        Throwable r102 = r100.get();
        boolean r103 = false;
        if (r102 == f495041a) goto L4;
        if (r102 != null) goto L8;
        Throwable r104 = r101;
    L10:
        if (r100.compareAndSet(r102, r104) == true) goto L11;
        if (r100.get() == r102) goto L10;
    L14:
        if (r103 == false) goto L2;
        return true;
    L11:
        r103 = true;
        goto L14
    L8:
        r104 = new CompositeException(new Throwable[]{r102, r101});
        goto L10
    L4:
        return false;
    }

    public static String c(long r100, TimeUnit r101) {
        return "The source did not signal an event for " + r100 + " " + r101.toString().toLowerCase() + " and has been terminated.";
    }
}
