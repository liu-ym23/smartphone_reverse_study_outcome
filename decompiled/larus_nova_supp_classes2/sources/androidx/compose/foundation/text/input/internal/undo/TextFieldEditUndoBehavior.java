package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "MergeIfPossible", "ClearHistory", "NeverMerge", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextFieldEditUndoBehavior extends Enum<TextFieldEditUndoBehavior> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextFieldEditUndoBehavior[] $VALUES = null;
    public static final TextFieldEditUndoBehavior ClearHistory = null;
    public static final TextFieldEditUndoBehavior MergeIfPossible = null;
    public static final TextFieldEditUndoBehavior NeverMerge = null;

    private static final /* synthetic */ TextFieldEditUndoBehavior[] $values() {
        return new TextFieldEditUndoBehavior[]{MergeIfPossible, ClearHistory, NeverMerge};
    }

    public static EnumEntries<TextFieldEditUndoBehavior> getEntries() {
        return $ENTRIES;
    }

    static {
        MergeIfPossible = new TextFieldEditUndoBehavior("MergeIfPossible", 0);
        ClearHistory = new TextFieldEditUndoBehavior("ClearHistory", 1);
        NeverMerge = new TextFieldEditUndoBehavior("NeverMerge", 2);
        TextFieldEditUndoBehavior[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static TextFieldEditUndoBehavior[] values() {
        return (TextFieldEditUndoBehavior[]) $VALUES.clone();
    }

    public static TextFieldEditUndoBehavior valueOf(String r1) {
        return (TextFieldEditUndoBehavior) a.a(TextFieldEditUndoBehavior.class, r1);
    }

    private TextFieldEditUndoBehavior(String r1, int r2) {
        super(r1, r2);
    }
}
