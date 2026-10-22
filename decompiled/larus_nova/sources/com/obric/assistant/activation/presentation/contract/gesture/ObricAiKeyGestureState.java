package com.obric.assistant.activation.presentation.contract.gesture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "FIRST_DOWN", "FIRST_UP", "SECOND_DOWN", "PRESS_START", "LONG_PRESS", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureState extends Enum<ObricAiKeyGestureState> {
    public static final ObricAiKeyGestureState FIRST_DOWN = null;
    public static final ObricAiKeyGestureState FIRST_UP = null;
    public static final ObricAiKeyGestureState IDLE = null;
    public static final ObricAiKeyGestureState LONG_PRESS = null;
    public static final ObricAiKeyGestureState PRESS_START = null;
    public static final ObricAiKeyGestureState SECOND_DOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAiKeyGestureState[] f385277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385278b = null;

    public static EnumEntries<ObricAiKeyGestureState> getEntries() {
        return f385278b;
    }

    static {
        ObricAiKeyGestureState r100 = new ObricAiKeyGestureState("IDLE", 0);
        IDLE = r100;
        ObricAiKeyGestureState r101 = new ObricAiKeyGestureState("FIRST_DOWN", 1);
        FIRST_DOWN = r101;
        ObricAiKeyGestureState r102 = new ObricAiKeyGestureState("FIRST_UP", 2);
        FIRST_UP = r102;
        ObricAiKeyGestureState r103 = new ObricAiKeyGestureState("SECOND_DOWN", 3);
        SECOND_DOWN = r103;
        ObricAiKeyGestureState r104 = new ObricAiKeyGestureState("PRESS_START", 4);
        PRESS_START = r104;
        ObricAiKeyGestureState r105 = new ObricAiKeyGestureState("LONG_PRESS", 5);
        LONG_PRESS = r105;
        ObricAiKeyGestureState[] r110 = {r100, r101, r102, r103, r104, r105};
        f385277a = r110;
        f385278b = EnumEntriesKt.enumEntries(r110);
    }

    public static ObricAiKeyGestureState[] values() {
        return (ObricAiKeyGestureState[]) f385277a.clone();
    }

    public static ObricAiKeyGestureState valueOf(String r100) {
        return (ObricAiKeyGestureState) a.a(ObricAiKeyGestureState.class, r100);
    }

    public ObricAiKeyGestureState(String r100, int r101) {
        super(r100, r101);
    }
}
