package kotlinx.datetime.format;

import com.vivo.libra.CallBack;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/format/AmPmMarker;", "", "<init>", "(Ljava/lang/String;I)V", "AM", CallBack.EVENT_POWER_MODE, "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AmPmMarker extends Enum<AmPmMarker> {
    public static final AmPmMarker AM = null;
    public static final AmPmMarker PM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AmPmMarker[] f505167a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505168b = null;

    public static EnumEntries<AmPmMarker> getEntries() {
        return f505168b;
    }

    static {
        AmPmMarker r100 = new AmPmMarker("AM", 0);
        AM = r100;
        AmPmMarker r101 = new AmPmMarker(CallBack.EVENT_POWER_MODE, 1);
        PM = r101;
        AmPmMarker[] r102 = {r100, r101};
        f505167a = r102;
        f505168b = EnumEntriesKt.enumEntries(r102);
    }

    public static AmPmMarker[] values() {
        return (AmPmMarker[]) f505167a.clone();
    }

    public static AmPmMarker valueOf(String r100) {
        return (AmPmMarker) r27.a.a(AmPmMarker.class, r100);
    }

    public AmPmMarker(String r100, int r101) {
        super(r100, r101);
    }
}
