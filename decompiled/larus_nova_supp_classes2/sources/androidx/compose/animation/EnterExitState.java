package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/EnterExitState;", "", "<init>", "(Ljava/lang/String;I)V", "PreEnter", "Visible", "PostExit", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum EnterExitState extends Enum<EnterExitState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EnterExitState[] $VALUES = null;
    public static final EnterExitState PostExit = null;
    public static final EnterExitState PreEnter = null;
    public static final EnterExitState Visible = null;

    private static final /* synthetic */ EnterExitState[] $values() {
        return new EnterExitState[]{PreEnter, Visible, PostExit};
    }

    public static EnumEntries<EnterExitState> getEntries() {
        return $ENTRIES;
    }

    static {
        PreEnter = new EnterExitState("PreEnter", 0);
        Visible = new EnterExitState("Visible", 1);
        PostExit = new EnterExitState("PostExit", 2);
        EnterExitState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static EnterExitState[] values() {
        return (EnterExitState[]) $VALUES.clone();
    }

    public static EnterExitState valueOf(String r1) {
        return (EnterExitState) r27.a.a(EnterExitState.class, r1);
    }

    private EnterExitState(String r1, int r2) {
        super(r1, r2);
    }
}
