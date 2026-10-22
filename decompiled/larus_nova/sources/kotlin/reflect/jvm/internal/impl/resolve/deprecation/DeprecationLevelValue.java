package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum DeprecationLevelValue extends Enum<DeprecationLevelValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DeprecationLevelValue[] $VALUES = null;
    public static final DeprecationLevelValue ERROR = null;
    public static final DeprecationLevelValue HIDDEN = null;
    public static final DeprecationLevelValue WARNING = null;

    private static final /* synthetic */ DeprecationLevelValue[] $values() {
        return new DeprecationLevelValue[]{WARNING, ERROR, HIDDEN};
    }

    static {
        WARNING = new DeprecationLevelValue("WARNING", 0);
        ERROR = new DeprecationLevelValue("ERROR", 1);
        HIDDEN = new DeprecationLevelValue("HIDDEN", 2);
        DeprecationLevelValue[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[]) $VALUES.clone();
    }

    public static DeprecationLevelValue valueOf(String r100) {
        return (DeprecationLevelValue) a.a(DeprecationLevelValue.class, r100);
    }

    private DeprecationLevelValue(String r100, int r101) {
        super(r100, r101);
    }
}
