package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectedTextType;", "", "<init>", "(Ljava/lang/String;I)V", "EditableText", "StaticText", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SelectedTextType extends Enum<SelectedTextType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SelectedTextType[] $VALUES = null;
    public static final SelectedTextType EditableText = null;
    public static final SelectedTextType StaticText = null;

    private static final /* synthetic */ SelectedTextType[] $values() {
        return new SelectedTextType[]{EditableText, StaticText};
    }

    public static EnumEntries<SelectedTextType> getEntries() {
        return $ENTRIES;
    }

    static {
        EditableText = new SelectedTextType("EditableText", 0);
        StaticText = new SelectedTextType("StaticText", 1);
        SelectedTextType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SelectedTextType[] values() {
        return (SelectedTextType[]) $VALUES.clone();
    }

    public static SelectedTextType valueOf(String r1) {
        return (SelectedTextType) r27.a.a(SelectedTextType.class, r1);
    }

    private SelectedTextType(String r1, int r2) {
        super(r1, r2);
    }
}
