package kotlin.reflect.jvm.internal.impl.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TypeUsage extends Enum<TypeUsage> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TypeUsage[] $VALUES = null;
    public static final TypeUsage COMMON = null;
    public static final TypeUsage SUPERTYPE = null;

    private static final /* synthetic */ TypeUsage[] $values() {
        return new TypeUsage[]{SUPERTYPE, COMMON};
    }

    static {
        SUPERTYPE = new TypeUsage("SUPERTYPE", 0);
        COMMON = new TypeUsage("COMMON", 1);
        TypeUsage[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) $VALUES.clone();
    }

    public static TypeUsage valueOf(String r100) {
        return (TypeUsage) a.a(TypeUsage.class, r100);
    }

    private TypeUsage(String r100, int r101) {
        super(r100, r101);
    }
}
