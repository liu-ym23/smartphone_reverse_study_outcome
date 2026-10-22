package com.bytedance.platform.godzilla.common;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Level f266614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f266615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.platform.godzilla.common.a f266616c;

    public static final enum Level extends Enum<Level> {
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level NONE = null;
        public static final Level WARNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f266617a = null;

        static {
            Level r100 = new Level("DEBUG", 0);
            DEBUG = r100;
            Level r101 = new Level("INFO", 1);
            INFO = r101;
            Level r102 = new Level("WARNING", 2);
            WARNING = r102;
            Level r103 = new Level("ERROR", 3);
            ERROR = r103;
            Level r104 = new Level(UserProfileEvent.POSITION_NONE, 4);
            NONE = r104;
            f266617a = new Level[]{r100, r101, r102, r103, r104};
        }

        public static Level[] values() {
            return (Level[]) f266617a.clone();
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements com.bytedance.platform.godzilla.common.a {
        public a() {
        }

        @Override // com.bytedance.platform.godzilla.common.a
        public final void a(String r100, String r101, Level r102) {
            int r103 = b.f266618a[r102.ordinal()];
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f266618a = null;

        static {
            int[] r100 = new int[Level.values().length];
            f266618a = r100;
            r100[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f266618a[Level.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f266618a[Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f266618a[Level.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f266614a = Level.INFO;
        f266615b = false;
        f266616c = new a();
    }

    public static void d(String r100) {
        c("BinderTranTooLargeExp", r100, Level.WARNING);
    }

    public static void a(String r100, String r101) {
        c(r100, r101, Level.ERROR);
    }

    public static void b(String r100, String r101) {
        c(r100, r101, Level.INFO);
    }

    public static void c(String r100, String r101, Level r102) {
        if (r102.ordinal() < f266614a.ordinal()) goto L6;
        f266616c.a(r100, r101, r102);
        return;
    }
}
