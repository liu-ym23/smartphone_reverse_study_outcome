package io.opentelemetry.api.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f492663a = null;

    public a() {
    }

    static {
        f492663a = Logger.getLogger(a.class.getName());
    }

    public static void a() {
        Level r100 = Level.FINEST;
        Logger r101 = f492663a;
        if (r101.isLoggable(r100) == false) goto L6;
        r101.log(r100, "context is null", new AssertionError());
        return;
    }
}
