package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/layout/LayoutOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "Horizontal", "Vertical", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LayoutOrientation extends Enum<LayoutOrientation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LayoutOrientation[] $VALUES = null;
    public static final LayoutOrientation Horizontal = null;
    public static final LayoutOrientation Vertical = null;

    private static final /* synthetic */ LayoutOrientation[] $values() {
        return new LayoutOrientation[]{Horizontal, Vertical};
    }

    public static EnumEntries<LayoutOrientation> getEntries() {
        return $ENTRIES;
    }

    static {
        Horizontal = new LayoutOrientation("Horizontal", 0);
        Vertical = new LayoutOrientation("Vertical", 1);
        LayoutOrientation[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static LayoutOrientation[] values() {
        return (LayoutOrientation[]) $VALUES.clone();
    }

    public static LayoutOrientation valueOf(String r1) {
        return (LayoutOrientation) r27.a.a(LayoutOrientation.class, r1);
    }

    private LayoutOrientation(String r1, int r2) {
        super(r1, r2);
    }
}
