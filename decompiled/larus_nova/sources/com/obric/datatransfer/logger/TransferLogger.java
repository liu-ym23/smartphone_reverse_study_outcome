package com.obric.datatransfer.logger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class TransferLogger {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.obric.datatransfer.logger.a f396682b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f396683a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/datatransfer/logger/TransferLogger$Level;", "", "", "levelValue", "I", "getLevelValue", "()I", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "datatransfer_release"}, k = 1, mv = {1, 8, 0})
    public static final enum Level extends Enum<Level> {
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level VERBOSE = null;
        public static final Level WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f396684a = null;
        private final int levelValue;

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public static Level[] values() {
            return (Level[]) f396684a.clone();
        }

        static {
            Level r100 = new Level("VERBOSE", 0, 2);
            VERBOSE = r100;
            Level r101 = new Level("DEBUG", 1, 3);
            DEBUG = r101;
            Level r102 = new Level("INFO", 2, 4);
            INFO = r102;
            Level r103 = new Level("WARN", 3, 5);
            WARN = r103;
            Level r104 = new Level("ERROR", 4, 6);
            ERROR = r104;
            f396684a = new Level[]{r100, r101, r102, r103, r104};
        }

        public final int getLevelValue() {
            return this.levelValue;
        }

        public Level(String r100, int r101, int r102) {
            super(r100, r101);
            this.levelValue = r102;
        }
    }

    public static final class a {
        public static TransferLogger a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            return new TransferLogger(r100);
        }
    }

    static {
        f396682b = new b();
    }

    public TransferLogger(String r100) {
        this.f396683a = r100;
    }

    public static void a(TransferLogger r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "message");
        f396682b.log(Level.DEBUG, r100.f396683a, r101, null);
    }

    public static void c(TransferLogger r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "message");
        f396682b.log(Level.INFO, r100.f396683a, r101, null);
    }

    public final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f396682b.log(Level.ERROR, this.f396683a, r100, r101);
    }

    public final void d(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        f396682b.log(Level.WARN, this.f396683a, r100, r101);
    }
}
