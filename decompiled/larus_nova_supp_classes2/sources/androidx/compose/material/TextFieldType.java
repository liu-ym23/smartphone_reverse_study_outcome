package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/TextFieldType;", "", "<init>", "(Ljava/lang/String;I)V", "Filled", "Outlined", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextFieldType extends Enum<TextFieldType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextFieldType[] $VALUES = null;
    public static final TextFieldType Filled = null;
    public static final TextFieldType Outlined = null;

    private static final /* synthetic */ TextFieldType[] $values() {
        return new TextFieldType[]{Filled, Outlined};
    }

    public static EnumEntries<TextFieldType> getEntries() {
        return $ENTRIES;
    }

    static {
        Filled = new TextFieldType("Filled", 0);
        Outlined = new TextFieldType("Outlined", 1);
        TextFieldType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static TextFieldType[] values() {
        return (TextFieldType[]) $VALUES.clone();
    }

    public static TextFieldType valueOf(String r1) {
        return (TextFieldType) r27.a.a(TextFieldType.class, r1);
    }

    private TextFieldType(String r1, int r2) {
        super(r1, r2);
    }
}
