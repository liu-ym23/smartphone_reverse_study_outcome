package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BackdropValue;", "", "<init>", "(Ljava/lang/String;I)V", "Concealed", "Revealed", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BackdropValue extends Enum<BackdropValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BackdropValue[] $VALUES = null;
    public static final BackdropValue Concealed = null;
    public static final BackdropValue Revealed = null;

    private static final /* synthetic */ BackdropValue[] $values() {
        return new BackdropValue[]{Concealed, Revealed};
    }

    public static EnumEntries<BackdropValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Concealed = new BackdropValue("Concealed", 0);
        Revealed = new BackdropValue("Revealed", 1);
        BackdropValue[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static BackdropValue[] values() {
        return (BackdropValue[]) $VALUES.clone();
    }

    public static BackdropValue valueOf(String r1) {
        return (BackdropValue) r27.a.a(BackdropValue.class, r1);
    }

    private BackdropValue(String r1, int r2) {
        super(r1, r2);
    }
}
