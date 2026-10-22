package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum MutabilityQualifier extends Enum<MutabilityQualifier> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MutabilityQualifier[] $VALUES = null;
    public static final MutabilityQualifier MUTABLE = null;
    public static final MutabilityQualifier READ_ONLY = null;

    private static final /* synthetic */ MutabilityQualifier[] $values() {
        return new MutabilityQualifier[]{READ_ONLY, MUTABLE};
    }

    static {
        READ_ONLY = new MutabilityQualifier("READ_ONLY", 0);
        MUTABLE = new MutabilityQualifier("MUTABLE", 1);
        MutabilityQualifier[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) $VALUES.clone();
    }

    public static MutabilityQualifier valueOf(String r100) {
        return (MutabilityQualifier) a.a(MutabilityQualifier.class, r100);
    }

    private MutabilityQualifier(String r100, int r101) {
        super(r100, r101);
    }
}
