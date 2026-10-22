package io.ktor.util.date;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/util/date/WeekDay;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final enum WeekDay extends Enum<WeekDay> {
    public static final a Companion = null;
    public static final WeekDay FRIDAY = null;
    public static final WeekDay MONDAY = null;
    public static final WeekDay SATURDAY = null;
    public static final WeekDay SUNDAY = null;
    public static final WeekDay THURSDAY = null;
    public static final WeekDay TUESDAY = null;
    public static final WeekDay WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WeekDay[] f491953a = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static WeekDay valueOf(String r100) {
        return (WeekDay) r27.a.a(WeekDay.class, r100);
    }

    public static WeekDay[] values() {
        return (WeekDay[]) f491953a.clone();
    }

    static {
        WeekDay r100 = new WeekDay("MONDAY", 0, "Mon");
        MONDAY = r100;
        WeekDay r101 = new WeekDay("TUESDAY", 1, "Tue");
        TUESDAY = r101;
        WeekDay r102 = new WeekDay("WEDNESDAY", 2, "Wed");
        WEDNESDAY = r102;
        WeekDay r103 = new WeekDay("THURSDAY", 3, "Thu");
        THURSDAY = r103;
        WeekDay r104 = new WeekDay("FRIDAY", 4, "Fri");
        FRIDAY = r104;
        WeekDay r105 = new WeekDay("SATURDAY", 5, "Sat");
        SATURDAY = r105;
        WeekDay r110 = new WeekDay("SUNDAY", 6, "Sun");
        SUNDAY = r110;
        f491953a = new WeekDay[]{r100, r101, r102, r103, r104, r105, r110};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public WeekDay(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
