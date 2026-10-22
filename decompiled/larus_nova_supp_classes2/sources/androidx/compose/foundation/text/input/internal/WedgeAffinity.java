package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WedgeAffinity extends Enum<WedgeAffinity> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WedgeAffinity[] $VALUES = null;
    public static final WedgeAffinity End = null;
    public static final WedgeAffinity Start = null;

    private static final /* synthetic */ WedgeAffinity[] $values() {
        return new WedgeAffinity[]{Start, End};
    }

    public static EnumEntries<WedgeAffinity> getEntries() {
        return $ENTRIES;
    }

    static {
        Start = new WedgeAffinity("Start", 0);
        End = new WedgeAffinity("End", 1);
        WedgeAffinity[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static WedgeAffinity[] values() {
        return (WedgeAffinity[]) $VALUES.clone();
    }

    public static WedgeAffinity valueOf(String r1) {
        return (WedgeAffinity) r27.a.a(WedgeAffinity.class, r1);
    }

    private WedgeAffinity(String r1, int r2) {
        super(r1, r2);
    }
}
