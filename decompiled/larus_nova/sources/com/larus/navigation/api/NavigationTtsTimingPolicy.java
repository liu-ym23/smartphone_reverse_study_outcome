package com.larus.navigation.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class NavigationTtsTimingPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359632a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/navigation/api/NavigationTtsTimingPolicy$SpeakKind;", "", "<init>", "(Ljava/lang/String;I)V", "STRAIGHT", "TURN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SpeakKind extends Enum<SpeakKind> {
        public static final SpeakKind STRAIGHT = null;
        public static final SpeakKind TURN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SpeakKind[] f359633a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359634b = null;

        public static EnumEntries<SpeakKind> getEntries() {
            return f359634b;
        }

        static {
            SpeakKind r100 = new SpeakKind("STRAIGHT", 0);
            STRAIGHT = r100;
            SpeakKind r101 = new SpeakKind("TURN", 1);
            TURN = r101;
            SpeakKind[] r102 = {r100, r101};
            f359633a = r102;
            f359634b = EnumEntriesKt.enumEntries(r102);
        }

        public static SpeakKind[] values() {
            return (SpeakKind[]) f359633a.clone();
        }

        public static SpeakKind valueOf(String r100) {
            return (SpeakKind) r27.a.a(SpeakKind.class, r100);
        }

        public SpeakKind(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/navigation/api/NavigationTtsTimingPolicy$Timing;", "", "<init>", "(Ljava/lang/String;I)V", "ENTER", "MIDDLE", "AT_100M", "AT_50M", "AT_20M", "EXIT", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Timing extends Enum<Timing> {
        public static final Timing AT_100M = null;
        public static final Timing AT_20M = null;
        public static final Timing AT_50M = null;
        public static final Timing ENTER = null;
        public static final Timing EXIT = null;
        public static final Timing MIDDLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Timing[] f359635a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359636b = null;

        public static EnumEntries<Timing> getEntries() {
            return f359636b;
        }

        static {
            Timing r100 = new Timing("ENTER", 0);
            ENTER = r100;
            Timing r101 = new Timing("MIDDLE", 1);
            MIDDLE = r101;
            Timing r102 = new Timing("AT_100M", 2);
            AT_100M = r102;
            Timing r103 = new Timing("AT_50M", 3);
            AT_50M = r103;
            Timing r104 = new Timing("AT_20M", 4);
            AT_20M = r104;
            Timing r105 = new Timing("EXIT", 5);
            EXIT = r105;
            Timing[] r110 = {r100, r101, r102, r103, r104, r105};
            f359635a = r110;
            f359636b = EnumEntriesKt.enumEntries(r110);
        }

        public static Timing[] values() {
            return (Timing[]) f359635a.clone();
        }

        public static Timing valueOf(String r100) {
            return (Timing) r27.a.a(Timing.class, r100);
        }

        public Timing(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f359637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f359638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile int f359639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile int f359640d;

        public a(int r100) {
            this.f359637a = r100;
            this.f359639c = Integer.MAX_VALUE;
        }

        public final Timing a(Timing r100) {
            int r101 = 1 << r100.ordinal();
            if ((this.f359640d & r101) == 0) goto L6;
            return null;
        L6:
            this.f359640d = r101 | this.f359640d;
            return r100;
        }

        public final Timing update(int r100) {
            int r101 = 5;
            if (r100 > this.f359639c) goto L5;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == false) goto L12;
        L45:
            this.f359638b = r100;
            this.f359639c = r100;
            this.f359640d = 0;
            return a(Timing.ENTER);
        L12:
            if (this.f359638b == 0) goto L45;
            int r103 = this.f359639c;
            this.f359639c = r100;
            int r104 = this.f359638b / 2;
            if (this.f359638b < 300) goto L21;
            if (r103 <= r104) goto L21;
            if (r100 > r104) goto L21;
            return a(Timing.MIDDLE);
        L21:
            if (r103 <= 100) goto L26;
            if (r100 > 100) goto L26;
            return a(Timing.AT_100M);
        L26:
            if (r103 <= 50) goto L31;
            if (r100 > 50) goto L31;
            return a(Timing.AT_50M);
        L31:
            if (r103 <= 20) goto L35;
            if (r100 > 20) goto L35;
            return a(Timing.AT_20M);
        L35:
            int r105 = NavigationTtsTimingPolicy.f359632a;
            if (this.f359637a == 0) goto L39;
            r101 = 10;
        L39:
            if (r103 <= r101) goto L43;
            if (r100 <= r101) goto L42;
            return null;
        L42:
            return a(Timing.EXIT);
        L43:
            return null;
        L5:
            if (this.f359638b > 0) goto L7;
        L8:
            r102 = true;
            goto L10
        L7:
            if (r100 <= ((this.f359638b * 6) / 5)) goto L9;
            goto L8
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359641a = null;

        static {
            int[] r100 = new int[Timing.values().length];
            r100[Timing.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[Timing.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[Timing.AT_100M.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[Timing.AT_50M.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[Timing.AT_20M.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[Timing.EXIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f359641a = r100;
        }
    }

    static {
    }
}
