package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TypeComponentPosition extends Enum<TypeComponentPosition> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TypeComponentPosition[] $VALUES = null;
    public static final TypeComponentPosition FLEXIBLE_LOWER = null;
    public static final TypeComponentPosition FLEXIBLE_UPPER = null;
    public static final TypeComponentPosition INFLEXIBLE = null;

    private static final /* synthetic */ TypeComponentPosition[] $values() {
        return new TypeComponentPosition[]{FLEXIBLE_LOWER, FLEXIBLE_UPPER, INFLEXIBLE};
    }

    static {
        FLEXIBLE_LOWER = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
        FLEXIBLE_UPPER = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
        INFLEXIBLE = new TypeComponentPosition("INFLEXIBLE", 2);
        TypeComponentPosition[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[]) $VALUES.clone();
    }

    public static TypeComponentPosition valueOf(String r100) {
        return (TypeComponentPosition) a.a(TypeComponentPosition.class, r100);
    }

    private TypeComponentPosition(String r100, int r101) {
        super(r100, r101);
    }
}
