package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum ReportLevel extends Enum<ReportLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ReportLevel[] $VALUES = null;
    public static final Companion Companion = null;
    public static final ReportLevel IGNORE = null;
    public static final ReportLevel STRICT = null;
    public static final ReportLevel WARN = null;
    private final String description;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    private static final /* synthetic */ ReportLevel[] $values() {
        return new ReportLevel[]{IGNORE, WARN, STRICT};
    }

    static {
        IGNORE = new ReportLevel("IGNORE", 0, "ignore");
        WARN = new ReportLevel("WARN", 1, "warn");
        STRICT = new ReportLevel("STRICT", 2, "strict");
        ReportLevel[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public static ReportLevel[] values() {
        return (ReportLevel[]) $VALUES.clone();
    }

    public final boolean isIgnore() {
        if (this != IGNORE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isWarning() {
        if (this != WARN) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public static ReportLevel valueOf(String r100) {
        return (ReportLevel) a.a(ReportLevel.class, r100);
    }

    private ReportLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
