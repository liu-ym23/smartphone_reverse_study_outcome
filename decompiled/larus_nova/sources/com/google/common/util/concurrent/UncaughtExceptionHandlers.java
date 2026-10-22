package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class UncaughtExceptionHandlers {

    public static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = null;
        private final Runtime runtime;

        static {
            logger = Logger.getLogger(Exiter.class.getName());
        }

        public Exiter(Runtime r100) {
            this.runtime = r100;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread r100, Throwable r101) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{r100}), r101);     // Catch: Throwable -> L5 Throwable -> L7 RuntimeException -> L9
        L11:
            this.runtime.exit(1);
            return;
        L5:
            th = move-exception;
            this.runtime.exit(1);
            throw th;
        L7:
            e = move-exception;
            System.err.println(r101.getMessage());     // Catch: Throwable -> L5
            System.err.println(e.getMessage());     // Catch: Throwable -> L5
            goto L11
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }
}
