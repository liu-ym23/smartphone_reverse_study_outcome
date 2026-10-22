package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = null;

    private Runnables() {
    }

    static {
        EMPTY_RUNNABLE = new AnonymousClass1();
    }

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }
}
