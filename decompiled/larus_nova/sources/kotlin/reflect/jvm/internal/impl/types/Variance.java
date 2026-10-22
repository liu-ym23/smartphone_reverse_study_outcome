package kotlin.reflect.jvm.internal.impl.types;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum Variance extends Enum<Variance> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Variance[] $VALUES = null;
    public static final Variance INVARIANT = null;
    public static final Variance IN_VARIANCE = null;
    public static final Variance OUT_VARIANCE = null;
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    private static final /* synthetic */ Variance[] $values() {
        return new Variance[]{INVARIANT, IN_VARIANCE, OUT_VARIANCE};
    }

    static {
        INVARIANT = new Variance("INVARIANT", 0, "", true, true, 0);
        IN_VARIANCE = new Variance("IN_VARIANCE", 1, "in", true, false, -1);
        OUT_VARIANCE = new Variance("OUT_VARIANCE", 2, Argument.OUT, false, true, 1);
        Variance[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Variance[] values() {
        return (Variance[]) $VALUES.clone();
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }

    public static Variance valueOf(String r100) {
        return (Variance) a.a(Variance.class, r100);
    }

    private Variance(String r100, int r101, String r102, boolean r103, boolean r104, int r105) {
        super(r100, r101);
        this.label = r102;
        this.allowsInPosition = r103;
        this.allowsOutPosition = r104;
        this.superpositionFactor = r105;
    }
}
