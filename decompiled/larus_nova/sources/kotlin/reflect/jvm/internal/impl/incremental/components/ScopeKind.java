package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ScopeKind extends Enum<ScopeKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScopeKind[] $VALUES = null;
    public static final ScopeKind CLASSIFIER = null;
    public static final ScopeKind PACKAGE = null;

    private static final /* synthetic */ ScopeKind[] $values() {
        return new ScopeKind[]{PACKAGE, CLASSIFIER};
    }

    static {
        PACKAGE = new ScopeKind("PACKAGE", 0);
        CLASSIFIER = new ScopeKind("CLASSIFIER", 1);
        ScopeKind[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ScopeKind[] values() {
        return (ScopeKind[]) $VALUES.clone();
    }

    public static ScopeKind valueOf(String r100) {
        return (ScopeKind) a.a(ScopeKind.class, r100);
    }

    private ScopeKind(String r100, int r101) {
        super(r100, r101);
    }
}
