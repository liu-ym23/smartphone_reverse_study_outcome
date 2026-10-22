package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/animation/core/AnimationEndReason;", "", "<init>", "(Ljava/lang/String;I)V", "BoundReached", "Finished", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AnimationEndReason extends Enum<AnimationEndReason> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnimationEndReason[] $VALUES = null;
    public static final AnimationEndReason BoundReached = null;
    public static final AnimationEndReason Finished = null;

    private static final /* synthetic */ AnimationEndReason[] $values() {
        return new AnimationEndReason[]{BoundReached, Finished};
    }

    public static EnumEntries<AnimationEndReason> getEntries() {
        return $ENTRIES;
    }

    static {
        BoundReached = new AnimationEndReason("BoundReached", 0);
        Finished = new AnimationEndReason("Finished", 1);
        AnimationEndReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static AnimationEndReason[] values() {
        return (AnimationEndReason[]) $VALUES.clone();
    }

    public static AnimationEndReason valueOf(String r1) {
        return (AnimationEndReason) r27.a.a(AnimationEndReason.class, r1);
    }

    private AnimationEndReason(String r1, int r2) {
        super(r1, r2);
    }
}
