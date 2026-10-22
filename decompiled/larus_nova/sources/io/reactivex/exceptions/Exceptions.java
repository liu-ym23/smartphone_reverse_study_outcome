package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable r100) {
        throw ExceptionHelper.d(r100);
    }

    public static void throwIfFatal(Throwable r100) {
        if ((r100 instanceof VirtualMachineError) == true) goto L14;
        if ((r100 instanceof ThreadDeath) == true) goto L12;
        if ((r100 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r100);
    L12:
        throw ((ThreadDeath) r100);
    L14:
        throw ((VirtualMachineError) r100);
    }
}
