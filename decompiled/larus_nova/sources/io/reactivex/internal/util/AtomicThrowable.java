package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean isTerminated() {
        if (get() != ExceptionHelper.f495041a) goto L5;
        return true;
    L5:
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.b(this);
    }

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r100) {
        return ExceptionHelper.a(this, r100);
    }
}
