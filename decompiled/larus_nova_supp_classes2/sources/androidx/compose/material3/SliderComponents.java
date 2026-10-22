package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/SliderComponents;", "", "<init>", "(Ljava/lang/String;I)V", "THUMB", "TRACK", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum SliderComponents extends Enum<SliderComponents> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SliderComponents[] $VALUES = null;
    public static final SliderComponents THUMB = null;
    public static final SliderComponents TRACK = null;

    private static final /* synthetic */ SliderComponents[] $values() {
        return new SliderComponents[]{THUMB, TRACK};
    }

    public static EnumEntries<SliderComponents> getEntries() {
        return $ENTRIES;
    }

    static {
        THUMB = new SliderComponents("THUMB", 0);
        TRACK = new SliderComponents("TRACK", 1);
        SliderComponents[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SliderComponents[] values() {
        return (SliderComponents[]) $VALUES.clone();
    }

    public static SliderComponents valueOf(String r1) {
        return (SliderComponents) r27.a.a(SliderComponents.class, r1);
    }

    private SliderComponents(String r1, int r2) {
        super(r1, r2);
    }
}
