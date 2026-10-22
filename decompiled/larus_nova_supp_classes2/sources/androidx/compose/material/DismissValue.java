package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material/DismissValue;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "DismissedToEnd", "DismissedToStart", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DismissValue extends Enum<DismissValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DismissValue[] $VALUES = null;
    public static final DismissValue Default = null;
    public static final DismissValue DismissedToEnd = null;
    public static final DismissValue DismissedToStart = null;

    private static final /* synthetic */ DismissValue[] $values() {
        return new DismissValue[]{Default, DismissedToEnd, DismissedToStart};
    }

    public static EnumEntries<DismissValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Default = new DismissValue("Default", 0);
        DismissedToEnd = new DismissValue("DismissedToEnd", 1);
        DismissedToStart = new DismissValue("DismissedToStart", 2);
        DismissValue[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DismissValue[] values() {
        return (DismissValue[]) $VALUES.clone();
    }

    public static DismissValue valueOf(String r1) {
        return (DismissValue) r27.a.a(DismissValue.class, r1);
    }

    private DismissValue(String r1, int r2) {
        super(r1, r2);
    }
}
