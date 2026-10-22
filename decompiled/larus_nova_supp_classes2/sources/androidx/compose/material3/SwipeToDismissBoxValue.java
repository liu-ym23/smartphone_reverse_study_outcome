package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxValue;", "", "<init>", "(Ljava/lang/String;I)V", "StartToEnd", "EndToStart", "Settled", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SwipeToDismissBoxValue extends Enum<SwipeToDismissBoxValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SwipeToDismissBoxValue[] $VALUES = null;
    public static final SwipeToDismissBoxValue EndToStart = null;
    public static final SwipeToDismissBoxValue Settled = null;
    public static final SwipeToDismissBoxValue StartToEnd = null;

    private static final /* synthetic */ SwipeToDismissBoxValue[] $values() {
        return new SwipeToDismissBoxValue[]{StartToEnd, EndToStart, Settled};
    }

    public static EnumEntries<SwipeToDismissBoxValue> getEntries() {
        return $ENTRIES;
    }

    static {
        StartToEnd = new SwipeToDismissBoxValue("StartToEnd", 0);
        EndToStart = new SwipeToDismissBoxValue("EndToStart", 1);
        Settled = new SwipeToDismissBoxValue("Settled", 2);
        SwipeToDismissBoxValue[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SwipeToDismissBoxValue[] values() {
        return (SwipeToDismissBoxValue[]) $VALUES.clone();
    }

    public static SwipeToDismissBoxValue valueOf(String r1) {
        return (SwipeToDismissBoxValue) r27.a.a(SwipeToDismissBoxValue.class, r1);
    }

    private SwipeToDismissBoxValue(String r1, int r2) {
        super(r1, r2);
    }
}
