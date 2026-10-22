package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum BufferOverflow extends Enum<BufferOverflow> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BufferOverflow[] $VALUES = null;
    public static final BufferOverflow DROP_LATEST = null;
    public static final BufferOverflow DROP_OLDEST = null;
    public static final BufferOverflow SUSPEND = null;

    private static final /* synthetic */ BufferOverflow[] $values() {
        return new BufferOverflow[]{SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    public static EnumEntries<BufferOverflow> getEntries() {
        return $ENTRIES;
    }

    public static BufferOverflow valueOf(String r100) {
        return (BufferOverflow) r27.a.a(BufferOverflow.class, r100);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) $VALUES.clone();
    }

    static {
        SUSPEND = new BufferOverflow("SUSPEND", 0);
        DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
        DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);
        BufferOverflow[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    private BufferOverflow(String r100, int r101) {
        super(r100, r101);
    }
}
