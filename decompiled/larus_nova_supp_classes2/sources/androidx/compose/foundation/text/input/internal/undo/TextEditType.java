package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "", "<init>", "(Ljava/lang/String;I)V", "Insert", "Delete", "Replace", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextEditType extends Enum<TextEditType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextEditType[] $VALUES = null;
    public static final TextEditType Delete = null;
    public static final TextEditType Insert = null;
    public static final TextEditType Replace = null;

    private static final /* synthetic */ TextEditType[] $values() {
        return new TextEditType[]{Insert, Delete, Replace};
    }

    public static EnumEntries<TextEditType> getEntries() {
        return $ENTRIES;
    }

    static {
        Insert = new TextEditType("Insert", 0);
        Delete = new TextEditType("Delete", 1);
        Replace = new TextEditType("Replace", 2);
        TextEditType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static TextEditType[] values() {
        return (TextEditType[]) $VALUES.clone();
    }

    public static TextEditType valueOf(String r1) {
        return (TextEditType) a.a(TextEditType.class, r1);
    }

    private TextEditType(String r1, int r2) {
        super(r1, r2);
    }
}
