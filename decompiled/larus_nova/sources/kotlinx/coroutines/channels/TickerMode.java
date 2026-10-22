package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TickerMode extends Enum<TickerMode> {
    public static final TickerMode FIXED_DELAY = null;
    public static final TickerMode FIXED_PERIOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TickerMode[] f504673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f504674b = null;

    public static EnumEntries<TickerMode> getEntries() {
        return f504674b;
    }

    public static TickerMode valueOf(String r100) {
        return (TickerMode) r27.a.a(TickerMode.class, r100);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) f504673a.clone();
    }

    static {
        TickerMode r100 = new TickerMode("FIXED_PERIOD", 0);
        FIXED_PERIOD = r100;
        TickerMode r101 = new TickerMode("FIXED_DELAY", 1);
        FIXED_DELAY = r101;
        TickerMode[] r102 = {r100, r101};
        f504673a = r102;
        f504674b = EnumEntriesKt.enumEntries(r102);
    }

    public TickerMode(String r100, int r101) {
        super(r100, r101);
    }
}
