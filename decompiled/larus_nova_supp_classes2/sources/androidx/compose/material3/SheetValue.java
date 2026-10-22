package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Hidden", "Expanded", "PartiallyExpanded", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SheetValue extends Enum<SheetValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SheetValue[] $VALUES = null;
    public static final SheetValue Expanded = null;
    public static final SheetValue Hidden = null;
    public static final SheetValue PartiallyExpanded = null;

    private static final /* synthetic */ SheetValue[] $values() {
        return new SheetValue[]{Hidden, Expanded, PartiallyExpanded};
    }

    public static EnumEntries<SheetValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Hidden = new SheetValue("Hidden", 0);
        Expanded = new SheetValue("Expanded", 1);
        PartiallyExpanded = new SheetValue("PartiallyExpanded", 2);
        SheetValue[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SheetValue[] values() {
        return (SheetValue[]) $VALUES.clone();
    }

    public static SheetValue valueOf(String r1) {
        return (SheetValue) r27.a.a(SheetValue.class, r1);
    }

    private SheetValue(String r1, int r2) {
        super(r1, r2);
    }
}
