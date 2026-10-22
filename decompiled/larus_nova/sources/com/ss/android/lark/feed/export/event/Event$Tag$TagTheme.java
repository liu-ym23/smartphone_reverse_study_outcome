package com.ss.android.lark.feed.export.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/feed/export/event/Event$Tag$TagTheme;", "", "<init>", "(Ljava/lang/String;I)V", "GRAY", "BLUE", "INDIGO", "WATHET", "RAD", "GREEN", "ORANGE", "VIOLET", "PURPLE", "THROUGH", "LIME", "YELLOW", "CARMINE", "DARK_BLUE", "DARK_CARMINE", "DARK_RAD", "DARK_GRAY", "LIGHT_GRAY", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Event$Tag$TagTheme extends Enum<Event$Tag$TagTheme> {
    public static final Event$Tag$TagTheme BLUE = null;
    public static final Event$Tag$TagTheme CARMINE = null;
    public static final Event$Tag$TagTheme DARK_BLUE = null;
    public static final Event$Tag$TagTheme DARK_CARMINE = null;
    public static final Event$Tag$TagTheme DARK_GRAY = null;
    public static final Event$Tag$TagTheme DARK_RAD = null;
    public static final Event$Tag$TagTheme GRAY = null;
    public static final Event$Tag$TagTheme GREEN = null;
    public static final Event$Tag$TagTheme INDIGO = null;
    public static final Event$Tag$TagTheme LIGHT_GRAY = null;
    public static final Event$Tag$TagTheme LIME = null;
    public static final Event$Tag$TagTheme ORANGE = null;
    public static final Event$Tag$TagTheme PURPLE = null;
    public static final Event$Tag$TagTheme RAD = null;
    public static final Event$Tag$TagTheme THROUGH = null;
    public static final Event$Tag$TagTheme VIOLET = null;
    public static final Event$Tag$TagTheme WATHET = null;
    public static final Event$Tag$TagTheme YELLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Event$Tag$TagTheme[] f420992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420993b = null;

    public static EnumEntries<Event$Tag$TagTheme> getEntries() {
        return f420993b;
    }

    static {
        Event$Tag$TagTheme r100 = new Event$Tag$TagTheme("GRAY", 0);
        GRAY = r100;
        Event$Tag$TagTheme r101 = new Event$Tag$TagTheme("BLUE", 1);
        BLUE = r101;
        Event$Tag$TagTheme r102 = new Event$Tag$TagTheme("INDIGO", 2);
        INDIGO = r102;
        Event$Tag$TagTheme r103 = new Event$Tag$TagTheme("WATHET", 3);
        WATHET = r103;
        Event$Tag$TagTheme r104 = new Event$Tag$TagTheme("RAD", 4);
        RAD = r104;
        Event$Tag$TagTheme r105 = new Event$Tag$TagTheme("GREEN", 5);
        GREEN = r105;
        Event$Tag$TagTheme r110 = new Event$Tag$TagTheme("ORANGE", 6);
        ORANGE = r110;
        Event$Tag$TagTheme r111 = new Event$Tag$TagTheme("VIOLET", 7);
        VIOLET = r111;
        Event$Tag$TagTheme r112 = new Event$Tag$TagTheme("PURPLE", 8);
        PURPLE = r112;
        Event$Tag$TagTheme r113 = new Event$Tag$TagTheme("THROUGH", 9);
        THROUGH = r113;
        Event$Tag$TagTheme r114 = new Event$Tag$TagTheme("LIME", 10);
        LIME = r114;
        Event$Tag$TagTheme r115 = new Event$Tag$TagTheme("YELLOW", 11);
        YELLOW = r115;
        Event$Tag$TagTheme r106 = new Event$Tag$TagTheme("CARMINE", 12);
        CARMINE = r106;
        Event$Tag$TagTheme r107 = new Event$Tag$TagTheme("DARK_BLUE", 13);
        DARK_BLUE = r107;
        Event$Tag$TagTheme r108 = new Event$Tag$TagTheme("DARK_CARMINE", 14);
        DARK_CARMINE = r108;
        Event$Tag$TagTheme r109 = new Event$Tag$TagTheme("DARK_RAD", 15);
        DARK_RAD = r109;
        Event$Tag$TagTheme r116 = new Event$Tag$TagTheme("DARK_GRAY", 16);
        DARK_GRAY = r116;
        Event$Tag$TagTheme r117 = new Event$Tag$TagTheme("LIGHT_GRAY", 17);
        LIGHT_GRAY = r117;
        Event$Tag$TagTheme[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f420992a = r118;
        f420993b = EnumEntriesKt.enumEntries(r118);
    }

    public static Event$Tag$TagTheme[] values() {
        return (Event$Tag$TagTheme[]) f420992a.clone();
    }

    public static Event$Tag$TagTheme valueOf(String r100) {
        return (Event$Tag$TagTheme) a.a(Event$Tag$TagTheme.class, r100);
    }

    public Event$Tag$TagTheme(String r100, int r101) {
        super(r100, r101);
    }
}
