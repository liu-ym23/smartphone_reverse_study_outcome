package kotlin;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum DeprecationLevel extends Enum<DeprecationLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DeprecationLevel[] $VALUES = null;
    public static final DeprecationLevel ERROR = null;
    public static final DeprecationLevel HIDDEN = null;
    public static final DeprecationLevel WARNING = null;

    private static final /* synthetic */ DeprecationLevel[] $values() {
        return new DeprecationLevel[]{WARNING, ERROR, HIDDEN};
    }

    public static EnumEntries<DeprecationLevel> getEntries() {
        return $ENTRIES;
    }

    public static DeprecationLevel valueOf(String r100) {
        return (DeprecationLevel) a.a(DeprecationLevel.class, r100);
    }

    public static DeprecationLevel[] values() {
        return (DeprecationLevel[]) $VALUES.clone();
    }

    static {
        WARNING = new DeprecationLevel("WARNING", 0);
        ERROR = new DeprecationLevel("ERROR", 1);
        HIDDEN = new DeprecationLevel("HIDDEN", 2);
        DeprecationLevel[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    private DeprecationLevel(String r100, int r101) {
        super(r100, r101);
    }
}
