package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/EventBindType;", "", "", "value", "I", "getValue", "()I", "Bind", "Catch", "CaptureBind", "CaptureCatch", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum EventBindType extends Enum<EventBindType> {
    public static final EventBindType Bind = null;
    public static final EventBindType CaptureBind = null;
    public static final EventBindType CaptureCatch = null;
    public static final EventBindType Catch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventBindType[] f404714a = null;
    private final int value;

    public static EventBindType valueOf(String r100) {
        return (EventBindType) r27.a.a(EventBindType.class, r100);
    }

    public static EventBindType[] values() {
        return (EventBindType[]) f404714a.clone();
    }

    static {
        EventBindType r100 = new EventBindType("Bind", 0, 0);
        Bind = r100;
        EventBindType r101 = new EventBindType("Catch", 1, 1);
        Catch = r101;
        EventBindType r102 = new EventBindType("CaptureBind", 2, 2);
        CaptureBind = r102;
        EventBindType r103 = new EventBindType("CaptureCatch", 3, 3);
        CaptureCatch = r103;
        f404714a = new EventBindType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public EventBindType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
