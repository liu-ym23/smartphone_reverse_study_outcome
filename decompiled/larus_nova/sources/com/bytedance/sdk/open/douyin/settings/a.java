package com.bytedance.sdk.open.douyin.settings;

/* JADX INFO: loaded from: classes22.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f269673a = "EntranceChecker";

    /* JADX INFO: renamed from: com.bytedance.sdk.open.douyin.settings.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C3769a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f269674a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f269675b = null;

        static {
            int[] r100 = new int[b.values().length];
            f269675b = r100;
            r100[b.f269676a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L16:
            f269675b[b.f269677b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L18:
            f269675b[b.f269678c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L7:
            int[] r101 = new int[c.values().length];
            f269674a = r101;
            r101[c.f269680a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            f269674a[c.f269681b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f269676a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f269677b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f269678c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ b[] f269679d = null;

        static {
            b r100 = new b("DOUYIN", 0);
            f269676a = r100;
            b r101 = new b("DOUYIN_LITE", 1);
            f269677b = r101;
            b r102 = new b("DOUYIN_HOTSOON", 2);
            f269678c = r102;
            f269679d = new b[]{r100, r101, r102};
        }

        private b(String r100, int r101) {
            super(r100, r101);
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        public static b[] values() {
            return (b[]) f269679d.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f269680a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f269681b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f269682c = null;

        static {
            c r100 = new c("AUTH", 0);
            f269680a = r100;
            c r101 = new c("SHARE", 1);
            f269681b = r101;
            f269682c = new c[]{r100, r101};
        }

        private c(String r100, int r101) {
            super(r100, r101);
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        public static c[] values() {
            return (c[]) f269682c.clone();
        }
    }

    public a() {
    }

    public static boolean a(c r100, b r101) {
        int r102 = C3769a.f269674a[r100.ordinal()];
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        return false;
    L6:
        int r103 = OpenSettingsManager.inst().getSDKConfig().shareEntrance;
    L8:
        int r104 = C3769a.f269675b[r101.ordinal()];
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L19;
        if (r104 == 3) goto L15;
        return false;
    L15:
        if ((r103 & 4) <= 0) goto L26;
        return true;
    L26:
        return false;
    L19:
        if ((r103 & 2) <= 0) goto L27;
        return true;
    L27:
        return false;
    L23:
        if ((r103 & 1) <= 0) goto L28;
        return true;
    L28:
        return false;
    L7:
        r103 = OpenSettingsManager.inst().getSDKConfig().authEntrance;
        goto L8
    }
}
