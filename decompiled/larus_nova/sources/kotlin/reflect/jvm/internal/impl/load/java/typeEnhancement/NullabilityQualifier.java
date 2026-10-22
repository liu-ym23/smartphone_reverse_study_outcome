package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum NullabilityQualifier extends Enum<NullabilityQualifier> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ NullabilityQualifier[] $VALUES = null;
    public static final NullabilityQualifier FORCE_FLEXIBILITY = null;
    public static final NullabilityQualifier NOT_NULL = null;
    public static final NullabilityQualifier NULLABLE = null;

    private static final /* synthetic */ NullabilityQualifier[] $values() {
        return new NullabilityQualifier[]{FORCE_FLEXIBILITY, NULLABLE, NOT_NULL};
    }

    static {
        FORCE_FLEXIBILITY = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
        NULLABLE = new NullabilityQualifier("NULLABLE", 1);
        NOT_NULL = new NullabilityQualifier("NOT_NULL", 2);
        NullabilityQualifier[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) $VALUES.clone();
    }

    public static NullabilityQualifier valueOf(String r100) {
        return (NullabilityQualifier) a.a(NullabilityQualifier.class, r100);
    }

    private NullabilityQualifier(String r100, int r101) {
        super(r100, r101);
    }
}
