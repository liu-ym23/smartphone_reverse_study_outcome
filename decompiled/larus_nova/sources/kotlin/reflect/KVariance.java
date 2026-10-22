package kotlin.reflect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum KVariance extends Enum<KVariance> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KVariance[] $VALUES = null;
    public static final KVariance IN = null;
    public static final KVariance INVARIANT = null;
    public static final KVariance OUT = null;

    private static final /* synthetic */ KVariance[] $values() {
        return new KVariance[]{INVARIANT, IN, OUT};
    }

    public static EnumEntries<KVariance> getEntries() {
        return $ENTRIES;
    }

    public static KVariance valueOf(String r100) {
        return (KVariance) a.a(KVariance.class, r100);
    }

    public static KVariance[] values() {
        return (KVariance[]) $VALUES.clone();
    }

    static {
        INVARIANT = new KVariance("INVARIANT", 0);
        IN = new KVariance("IN", 1);
        OUT = new KVariance("OUT", 2);
        KVariance[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    private KVariance(String r100, int r101) {
        super(r100, r101);
    }
}
