package com.lynx.animax.ability;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum Event extends Enum<Event> {
    public static final Event CANCEL = null;
    public static final Event COMPLETION = null;
    public static final Event COMPOSITION_READY = null;
    public static final Event ERROR = null;
    public static final Event FIRST_FRAME = null;
    public static final Event FPS = null;
    public static final Event READY = null;
    public static final Event REPEAT = null;
    public static final Event START = null;
    public static final Event TAP_LAYERS = null;
    public static final Event UPDATE = null;
    public static final Event WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Event[] f380245a = null;

    static {
        Event r100 = new Event("COMPLETION", 0);
        COMPLETION = r100;
        Event r101 = new Event(GXAnimation.STATE_START, 1);
        START = r101;
        Event r102 = new Event("REPEAT", 2);
        REPEAT = r102;
        Event r103 = new Event("CANCEL", 3);
        CANCEL = r103;
        Event r104 = new Event("READY", 4);
        READY = r104;
        Event r105 = new Event("UPDATE", 5);
        UPDATE = r105;
        Event r110 = new Event("ERROR", 6);
        ERROR = r110;
        Event r111 = new Event("FPS", 7);
        FPS = r111;
        Event r112 = new Event("COMPOSITION_READY", 8);
        COMPOSITION_READY = r112;
        Event r113 = new Event("TAP_LAYERS", 9);
        TAP_LAYERS = r113;
        Event r114 = new Event("FIRST_FRAME", 10);
        FIRST_FRAME = r114;
        Event r115 = new Event("WARNING", 11);
        WARNING = r115;
        f380245a = new Event[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static Event[] values() {
        return (Event[]) f380245a.clone();
    }

    public static Event valueOf(String r100) {
        return (Event) a.a(Event.class, r100);
    }

    public Event(String r100, int r101) {
        super(r100, r101);
    }
}
