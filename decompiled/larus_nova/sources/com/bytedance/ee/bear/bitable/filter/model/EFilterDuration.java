package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0006\u0010\u001b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/EFilterDuration;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ExactDate", "Today", "Tomorrow", "Yesterday", "ExactDateRange", "TodayRange", "TomorrowRange", "YesterdayRange", "TheLastWeek", "TheNextWeek", "TheLastMonth", "TheNextMonth", "CurrentYear", "CurrentWeek", "CurrentQuarter", "LastWeek", "CurrentMonth", "LastMonth", "toString", "getReportText", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterDuration extends Enum<EFilterDuration> {
    public static final a Companion = null;
    public static final EFilterDuration CurrentMonth = null;
    public static final EFilterDuration CurrentQuarter = null;
    public static final EFilterDuration CurrentWeek = null;
    public static final EFilterDuration CurrentYear = null;
    public static final EFilterDuration ExactDate = null;
    public static final EFilterDuration ExactDateRange = null;
    public static final EFilterDuration LastMonth = null;
    public static final EFilterDuration LastWeek = null;
    public static final EFilterDuration TheLastMonth = null;
    public static final EFilterDuration TheLastWeek = null;
    public static final EFilterDuration TheNextMonth = null;
    public static final EFilterDuration TheNextWeek = null;
    public static final EFilterDuration Today = null;
    public static final EFilterDuration TodayRange = null;
    public static final EFilterDuration Tomorrow = null;
    public static final EFilterDuration TomorrowRange = null;
    public static final EFilterDuration Yesterday = null;
    public static final EFilterDuration YesterdayRange = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterDuration[] f211876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211877b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EFilterDuration a(String r100) {
            EFilterDuration[] r101 = EFilterDuration.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            EFilterDuration r104 = r101[r103];
            if (TextUtils.equals(r104.getValue(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211878a = null;

        static {
            int[] r100 = new int[EFilterDuration.values().length];
            r100[EFilterDuration.ExactDate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r100[EFilterDuration.Today.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r100[EFilterDuration.Tomorrow.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[EFilterDuration.Yesterday.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[EFilterDuration.ExactDateRange.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r100[EFilterDuration.TodayRange.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r100[EFilterDuration.TomorrowRange.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r100[EFilterDuration.YesterdayRange.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r100[EFilterDuration.TheLastWeek.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r100[EFilterDuration.TheNextWeek.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r100[EFilterDuration.TheLastMonth.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r100[EFilterDuration.TheNextMonth.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r100[EFilterDuration.CurrentYear.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r100[EFilterDuration.CurrentWeek.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r100[EFilterDuration.CurrentQuarter.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r100[EFilterDuration.LastWeek.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r100[EFilterDuration.CurrentMonth.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[EFilterDuration.LastMonth.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            f211878a = r100;
        }
    }

    public static EnumEntries<EFilterDuration> getEntries() {
        return f211877b;
    }

    @JvmStatic
    public static final EFilterDuration lookup(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        EFilterDuration r100 = new EFilterDuration("ExactDate", 0, "ExactDate");
        ExactDate = r100;
        EFilterDuration r101 = new EFilterDuration("Today", 1, "Today");
        Today = r101;
        EFilterDuration r102 = new EFilterDuration("Tomorrow", 2, "Tomorrow");
        Tomorrow = r102;
        EFilterDuration r103 = new EFilterDuration("Yesterday", 3, "Yesterday");
        Yesterday = r103;
        EFilterDuration r104 = new EFilterDuration("ExactDateRange", 4, "ExactDateRange");
        ExactDateRange = r104;
        EFilterDuration r105 = new EFilterDuration("TodayRange", 5, "TodayRange");
        TodayRange = r105;
        EFilterDuration r110 = new EFilterDuration("TomorrowRange", 6, "TomorrowRange");
        TomorrowRange = r110;
        EFilterDuration r111 = new EFilterDuration("YesterdayRange", 7, "YesterdayRange");
        YesterdayRange = r111;
        EFilterDuration r112 = new EFilterDuration("TheLastWeek", 8, "TheLastWeek");
        TheLastWeek = r112;
        EFilterDuration r113 = new EFilterDuration("TheNextWeek", 9, "TheNextWeek");
        TheNextWeek = r113;
        EFilterDuration r114 = new EFilterDuration("TheLastMonth", 10, "TheLastMonth");
        TheLastMonth = r114;
        EFilterDuration r115 = new EFilterDuration("TheNextMonth", 11, "TheNextMonth");
        TheNextMonth = r115;
        EFilterDuration r106 = new EFilterDuration("CurrentYear", 12, "CurrentYear");
        CurrentYear = r106;
        EFilterDuration r107 = new EFilterDuration("CurrentWeek", 13, "CurrentWeek");
        CurrentWeek = r107;
        EFilterDuration r108 = new EFilterDuration("CurrentQuarter", 14, "CurrentQuarter");
        CurrentQuarter = r108;
        EFilterDuration r109 = new EFilterDuration("LastWeek", 15, "LastWeek");
        LastWeek = r109;
        EFilterDuration r116 = new EFilterDuration("CurrentMonth", 16, "CurrentMonth");
        CurrentMonth = r116;
        EFilterDuration r117 = new EFilterDuration("LastMonth", 17, "LastMonth");
        LastMonth = r117;
        EFilterDuration[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f211876a = r118;
        f211877b = EnumEntriesKt.enumEntries(r118);
        Companion = new a();
    }

    public static EFilterDuration[] values() {
        return (EFilterDuration[]) f211876a.clone();
    }

    public final String getReportText() {
        switch(b.f211878a[ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L6;
            default: goto L5;
        };
    L6:
        return "last_month";
    L7:
        return "this_month";
    L8:
        return "last_week";
    L9:
        return "this_quarter";
    L10:
        return "this_week";
    L11:
        return "this_year";
    L12:
        return "next_30_days";
    L13:
        return "last_30_days";
    L14:
        return "next_7_days";
    L15:
        return "last_7_days";
    L16:
        return "yesterday_range";
    L17:
        return "tomorrow_range";
    L18:
        return "today_range";
    L19:
        return "exact_date_range";
    L20:
        return "yesterday";
    L21:
        return "tomorrow";
    L22:
        return "today";
    L23:
        return "exact_date";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EFilterDuration valueOf(String r100) {
        return (EFilterDuration) r27.a.a(EFilterDuration.class, r100);
    }

    public EFilterDuration(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
