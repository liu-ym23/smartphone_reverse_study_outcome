package com.obric.assistant.activation.presentation.contract.gesture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureAction;", "", "<init>", "(Ljava/lang/String;I)V", "DOWN", "LONG_PRESS_FAILED", "SINGLE_PRESS", "DOUBLE_PRESS", "PRESS_START", "SHORT_PRESS", "LONG_PRESS_START", "LONG_PRESS_STOP", "CANCEL", "TIMEOUT", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureAction extends Enum<ObricAiKeyGestureAction> {
    public static final ObricAiKeyGestureAction CANCEL = null;
    public static final ObricAiKeyGestureAction DOUBLE_PRESS = null;
    public static final ObricAiKeyGestureAction DOWN = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_FAILED = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_START = null;
    public static final ObricAiKeyGestureAction LONG_PRESS_STOP = null;
    public static final ObricAiKeyGestureAction PRESS_START = null;
    public static final ObricAiKeyGestureAction SHORT_PRESS = null;
    public static final ObricAiKeyGestureAction SINGLE_PRESS = null;
    public static final ObricAiKeyGestureAction TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAiKeyGestureAction[] f385275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385276b = null;

    public static EnumEntries<ObricAiKeyGestureAction> getEntries() {
        return f385276b;
    }

    static {
        ObricAiKeyGestureAction r100 = new ObricAiKeyGestureAction("DOWN", 0);
        DOWN = r100;
        ObricAiKeyGestureAction r101 = new ObricAiKeyGestureAction("LONG_PRESS_FAILED", 1);
        LONG_PRESS_FAILED = r101;
        ObricAiKeyGestureAction r102 = new ObricAiKeyGestureAction("SINGLE_PRESS", 2);
        SINGLE_PRESS = r102;
        ObricAiKeyGestureAction r103 = new ObricAiKeyGestureAction("DOUBLE_PRESS", 3);
        DOUBLE_PRESS = r103;
        ObricAiKeyGestureAction r104 = new ObricAiKeyGestureAction("PRESS_START", 4);
        PRESS_START = r104;
        ObricAiKeyGestureAction r105 = new ObricAiKeyGestureAction("SHORT_PRESS", 5);
        SHORT_PRESS = r105;
        ObricAiKeyGestureAction r110 = new ObricAiKeyGestureAction("LONG_PRESS_START", 6);
        LONG_PRESS_START = r110;
        ObricAiKeyGestureAction r111 = new ObricAiKeyGestureAction("LONG_PRESS_STOP", 7);
        LONG_PRESS_STOP = r111;
        ObricAiKeyGestureAction r112 = new ObricAiKeyGestureAction("CANCEL", 8);
        CANCEL = r112;
        ObricAiKeyGestureAction r113 = new ObricAiKeyGestureAction("TIMEOUT", 9);
        TIMEOUT = r113;
        ObricAiKeyGestureAction[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f385275a = r114;
        f385276b = EnumEntriesKt.enumEntries(r114);
    }

    public static ObricAiKeyGestureAction[] values() {
        return (ObricAiKeyGestureAction[]) f385275a.clone();
    }

    public static ObricAiKeyGestureAction valueOf(String r100) {
        return (ObricAiKeyGestureAction) a.a(ObricAiKeyGestureAction.class, r100);
    }

    public ObricAiKeyGestureAction(String r100, int r101) {
        super(r100, r101);
    }
}
