package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum JavaTypeFlexibility extends Enum<JavaTypeFlexibility> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES = null;
    public static final JavaTypeFlexibility FLEXIBLE_LOWER_BOUND = null;
    public static final JavaTypeFlexibility FLEXIBLE_UPPER_BOUND = null;
    public static final JavaTypeFlexibility INFLEXIBLE = null;

    private static final /* synthetic */ JavaTypeFlexibility[] $values() {
        return new JavaTypeFlexibility[]{INFLEXIBLE, FLEXIBLE_UPPER_BOUND, FLEXIBLE_LOWER_BOUND};
    }

    static {
        INFLEXIBLE = new JavaTypeFlexibility("INFLEXIBLE", 0);
        FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
        FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);
        JavaTypeFlexibility[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[]) $VALUES.clone();
    }

    public static JavaTypeFlexibility valueOf(String r100) {
        return (JavaTypeFlexibility) a.a(JavaTypeFlexibility.class, r100);
    }

    private JavaTypeFlexibility(String r100, int r101) {
        super(r100, r101);
    }
}
