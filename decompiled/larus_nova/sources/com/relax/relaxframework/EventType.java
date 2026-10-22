package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/EventType;", "", "", "value", "I", "getValue", "()I", "TouchEvent", "KeyboardEvent", "WheelEvent", "PointerEvent", "UIEvent", "MouseEvent", "MessageEvent", "CustomEvent", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum EventType extends Enum<EventType> {
    public static final EventType CustomEvent = null;
    public static final EventType KeyboardEvent = null;
    public static final EventType MessageEvent = null;
    public static final EventType MouseEvent = null;
    public static final EventType PointerEvent = null;
    public static final EventType TouchEvent = null;
    public static final EventType UIEvent = null;
    public static final EventType WheelEvent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f404717a = null;
    private final int value;

    public static EventType valueOf(String r100) {
        return (EventType) r27.a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) f404717a.clone();
    }

    static {
        EventType r100 = new EventType("TouchEvent", 0, 0);
        TouchEvent = r100;
        EventType r101 = new EventType("KeyboardEvent", 1, 1);
        KeyboardEvent = r101;
        EventType r102 = new EventType("WheelEvent", 2, 2);
        WheelEvent = r102;
        EventType r103 = new EventType("PointerEvent", 3, 3);
        PointerEvent = r103;
        EventType r104 = new EventType("UIEvent", 4, 4);
        UIEvent = r104;
        EventType r105 = new EventType("MouseEvent", 5, 5);
        MouseEvent = r105;
        EventType r110 = new EventType("MessageEvent", 6, 6);
        MessageEvent = r110;
        EventType r111 = new EventType("CustomEvent", 7, 7);
        CustomEvent = r111;
        f404717a = new EventType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public EventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
