package com.facebook.common.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public final class Closeables {
    static final Logger logger = null;

    private Closeables() {
    }

    static {
        logger = Logger.getLogger(Closeables.class.getName());
    }

    public static void closeQuietly(@Nullable InputStream r100) {
        close(r100, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static void closeQuietly(@Nullable Reader r100) {
        close(r100, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static void close(@Nullable Closeable r100, boolean r101) throws IOException {
        if (r100 != null) goto L11;
        return;
    L11:
        r100.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        if (r101 == false) goto L10;
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
        return;
    L10:
        throw e;
    }
}
