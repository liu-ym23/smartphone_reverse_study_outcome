package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/MutatePriority;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "UserInput", "PreventUserInput", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MutatePriority extends Enum<MutatePriority> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MutatePriority[] $VALUES = null;
    public static final MutatePriority Default = null;
    public static final MutatePriority PreventUserInput = null;
    public static final MutatePriority UserInput = null;

    private static final /* synthetic */ MutatePriority[] $values() {
        return new MutatePriority[]{Default, UserInput, PreventUserInput};
    }

    public static EnumEntries<MutatePriority> getEntries() {
        return $ENTRIES;
    }

    static {
        Default = new MutatePriority("Default", 0);
        UserInput = new MutatePriority("UserInput", 1);
        PreventUserInput = new MutatePriority("PreventUserInput", 2);
        MutatePriority[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static MutatePriority[] values() {
        return (MutatePriority[]) $VALUES.clone();
    }

    public static MutatePriority valueOf(String r1) {
        return (MutatePriority) r27.a.a(MutatePriority.class, r1);
    }

    private MutatePriority(String r1, int r2) {
        super(r1, r2);
    }
}
