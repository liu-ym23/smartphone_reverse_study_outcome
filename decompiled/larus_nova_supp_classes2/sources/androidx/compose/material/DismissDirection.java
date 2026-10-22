package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/DismissDirection;", "", "<init>", "(Ljava/lang/String;I)V", "StartToEnd", "EndToStart", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DismissDirection extends Enum<DismissDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DismissDirection[] $VALUES = null;
    public static final DismissDirection EndToStart = null;
    public static final DismissDirection StartToEnd = null;

    private static final /* synthetic */ DismissDirection[] $values() {
        return new DismissDirection[]{StartToEnd, EndToStart};
    }

    public static EnumEntries<DismissDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        StartToEnd = new DismissDirection("StartToEnd", 0);
        EndToStart = new DismissDirection("EndToStart", 1);
        DismissDirection[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DismissDirection[] values() {
        return (DismissDirection[]) $VALUES.clone();
    }

    public static DismissDirection valueOf(String r1) {
        return (DismissDirection) r27.a.a(DismissDirection.class, r1);
    }

    private DismissDirection(String r1, int r2) {
        super(r1, r2);
    }
}
