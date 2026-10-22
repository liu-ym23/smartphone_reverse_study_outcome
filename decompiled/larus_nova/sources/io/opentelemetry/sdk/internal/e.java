package io.opentelemetry.sdk.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f492717a = null;

    public e() {
    }

    static {
        Logger r100 = Logger.getLogger(e.class.getName());
        f492717a = new e();
        if (e.class == e.class) goto L6;
        r100.log(Level.FINE, "Using the APIs optimized for: {0}", "Java 8");
        return;
    }
}
