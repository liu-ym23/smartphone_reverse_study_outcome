package io.ktor.utils.io.internal;

import io.ktor.utils.io.ClosedWriteChannelException;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f492071b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f492072a;

    public static final class a {
    }

    static {
        f492071b = new c(null);
    }

    public final Throwable a() {
        Throwable r100 = this.f492072a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ClosedWriteChannelException("The channel was closed");
    }

    public final String toString() {
        return "Closed[" + a() + ']';
    }

    public c(Throwable r100) {
        this.f492072a = r100;
    }
}
