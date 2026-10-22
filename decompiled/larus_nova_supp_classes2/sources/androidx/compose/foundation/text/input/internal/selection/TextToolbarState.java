package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Cursor", "Selection", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextToolbarState extends Enum<TextToolbarState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextToolbarState[] $VALUES = null;
    public static final TextToolbarState Cursor = null;
    public static final TextToolbarState None = null;
    public static final TextToolbarState Selection = null;

    private static final /* synthetic */ TextToolbarState[] $values() {
        return new TextToolbarState[]{None, Cursor, Selection};
    }

    public static EnumEntries<TextToolbarState> getEntries() {
        return $ENTRIES;
    }

    static {
        None = new TextToolbarState("None", 0);
        Cursor = new TextToolbarState("Cursor", 1);
        Selection = new TextToolbarState("Selection", 2);
        TextToolbarState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static TextToolbarState[] values() {
        return (TextToolbarState[]) $VALUES.clone();
    }

    public static TextToolbarState valueOf(String r1) {
        return (TextToolbarState) r27.a.a(TextToolbarState.class, r1);
    }

    private TextToolbarState(String r1, int r2) {
        super(r1, r2);
    }
}
