package kotlin.reflect.jvm.internal.impl.name;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum State extends Enum<State> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State AFTER_DOT = null;
    public static final State BEGINNING = null;
    public static final State MIDDLE = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{BEGINNING, MIDDLE, AFTER_DOT};
    }

    static {
        BEGINNING = new State("BEGINNING", 0);
        MIDDLE = new State("MIDDLE", 1);
        AFTER_DOT = new State("AFTER_DOT", 2);
        State[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }

    public static State valueOf(String r100) {
        return (State) a.a(State.class, r100);
    }

    private State(String r100, int r101) {
        super(r100, r101);
    }
}
