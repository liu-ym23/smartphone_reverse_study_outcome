package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/animation/core/RepeatMode;", "", "<init>", "(Ljava/lang/String;I)V", "Restart", "Reverse", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RepeatMode extends Enum<RepeatMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RepeatMode[] $VALUES = null;
    public static final RepeatMode Restart = null;
    public static final RepeatMode Reverse = null;

    private static final /* synthetic */ RepeatMode[] $values() {
        return new RepeatMode[]{Restart, Reverse};
    }

    public static EnumEntries<RepeatMode> getEntries() {
        return $ENTRIES;
    }

    static {
        Restart = new RepeatMode("Restart", 0);
        Reverse = new RepeatMode("Reverse", 1);
        RepeatMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) $VALUES.clone();
    }

    public static RepeatMode valueOf(String r1) {
        return (RepeatMode) r27.a.a(RepeatMode.class, r1);
    }

    private RepeatMode(String r1, int r2) {
        super(r1, r2);
    }
}
