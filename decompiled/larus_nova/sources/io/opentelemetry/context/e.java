package io.opentelemetry.context;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Function<? super c, ? extends c>> f492698a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f492699b = null;

    public e() {
    }

    static {
        Logger.getLogger(e.class.getName());
        f492698a = new ArrayList();
        f492699b = new Object();
    }

    public static void a() {
        Object r100 = f492699b;
        monitor-enter(r100);
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
