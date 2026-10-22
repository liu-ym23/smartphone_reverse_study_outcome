package io.ktor.util.date;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/util/date/Month;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final enum Month extends Enum<Month> {
    public static final Month APRIL = null;
    public static final Month AUGUST = null;
    public static final a Companion = null;
    public static final Month DECEMBER = null;
    public static final Month FEBRUARY = null;
    public static final Month JANUARY = null;
    public static final Month JULY = null;
    public static final Month JUNE = null;
    public static final Month MARCH = null;
    public static final Month MAY = null;
    public static final Month NOVEMBER = null;
    public static final Month OCTOBER = null;
    public static final Month SEPTEMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Month[] f491952a = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static Month valueOf(String r100) {
        return (Month) r27.a.a(Month.class, r100);
    }

    public static Month[] values() {
        return (Month[]) f491952a.clone();
    }

    static {
        Month r100 = new Month("JANUARY", 0, "Jan");
        JANUARY = r100;
        Month r101 = new Month("FEBRUARY", 1, "Feb");
        FEBRUARY = r101;
        Month r102 = new Month("MARCH", 2, "Mar");
        MARCH = r102;
        Month r103 = new Month("APRIL", 3, "Apr");
        APRIL = r103;
        Month r104 = new Month("MAY", 4, "May");
        MAY = r104;
        Month r105 = new Month("JUNE", 5, "Jun");
        JUNE = r105;
        Month r110 = new Month("JULY", 6, "Jul");
        JULY = r110;
        Month r111 = new Month("AUGUST", 7, "Aug");
        AUGUST = r111;
        Month r112 = new Month("SEPTEMBER", 8, "Sep");
        SEPTEMBER = r112;
        Month r113 = new Month("OCTOBER", 9, "Oct");
        OCTOBER = r113;
        Month r106 = new Month("NOVEMBER", 10, "Nov");
        NOVEMBER = r106;
        Month r107 = new Month("DECEMBER", 11, "Dec");
        DECEMBER = r107;
        f491952a = new Month[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public Month(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
