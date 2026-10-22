package com.obric.assistant.activation.presentation.runtime.gesture.scheduler;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/gesture/scheduler/ObricAiKeyGestureTimeout;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE_PRESS", "PRESS_START", "LONG_PRESS", "SECOND_PRESS", "GESTURE", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAiKeyGestureTimeout extends Enum<ObricAiKeyGestureTimeout> {
    public static final ObricAiKeyGestureTimeout GESTURE = null;
    public static final ObricAiKeyGestureTimeout LONG_PRESS = null;
    public static final ObricAiKeyGestureTimeout PRESS_START = null;
    public static final ObricAiKeyGestureTimeout SECOND_PRESS = null;
    public static final ObricAiKeyGestureTimeout SINGLE_PRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAiKeyGestureTimeout[] f385279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385280b = null;

    public static EnumEntries<ObricAiKeyGestureTimeout> getEntries() {
        return f385280b;
    }

    static {
        ObricAiKeyGestureTimeout r100 = new ObricAiKeyGestureTimeout("SINGLE_PRESS", 0);
        SINGLE_PRESS = r100;
        ObricAiKeyGestureTimeout r101 = new ObricAiKeyGestureTimeout("PRESS_START", 1);
        PRESS_START = r101;
        ObricAiKeyGestureTimeout r102 = new ObricAiKeyGestureTimeout("LONG_PRESS", 2);
        LONG_PRESS = r102;
        ObricAiKeyGestureTimeout r103 = new ObricAiKeyGestureTimeout("SECOND_PRESS", 3);
        SECOND_PRESS = r103;
        ObricAiKeyGestureTimeout r104 = new ObricAiKeyGestureTimeout("GESTURE", 4);
        GESTURE = r104;
        ObricAiKeyGestureTimeout[] r105 = {r100, r101, r102, r103, r104};
        f385279a = r105;
        f385280b = EnumEntriesKt.enumEntries(r105);
    }

    public static ObricAiKeyGestureTimeout[] values() {
        return (ObricAiKeyGestureTimeout[]) f385279a.clone();
    }

    public static ObricAiKeyGestureTimeout valueOf(String r100) {
        return (ObricAiKeyGestureTimeout) a.a(ObricAiKeyGestureTimeout.class, r100);
    }

    public ObricAiKeyGestureTimeout(String r100, int r101) {
        super(r100, r101);
    }
}
