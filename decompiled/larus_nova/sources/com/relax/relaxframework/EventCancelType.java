package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/EventCancelType;", "", "", "value", "I", "getValue", "()I", "NotCanceled", "CanceledByEventHandler", "CanceledByDefaultEventHandler", "CanceledBeforeDispatch", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum EventCancelType extends Enum<EventCancelType> {
    public static final EventCancelType CanceledBeforeDispatch = null;
    public static final EventCancelType CanceledByDefaultEventHandler = null;
    public static final EventCancelType CanceledByEventHandler = null;
    public static final EventCancelType NotCanceled = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventCancelType[] f404715a = null;
    private final int value;

    public static EventCancelType valueOf(String r100) {
        return (EventCancelType) r27.a.a(EventCancelType.class, r100);
    }

    public static EventCancelType[] values() {
        return (EventCancelType[]) f404715a.clone();
    }

    static {
        EventCancelType r100 = new EventCancelType("NotCanceled", 0, 0);
        NotCanceled = r100;
        EventCancelType r101 = new EventCancelType("CanceledByEventHandler", 1, 1);
        CanceledByEventHandler = r101;
        EventCancelType r102 = new EventCancelType("CanceledByDefaultEventHandler", 2, 2);
        CanceledByDefaultEventHandler = r102;
        EventCancelType r103 = new EventCancelType("CanceledBeforeDispatch", 3, 3);
        CanceledBeforeDispatch = r103;
        f404715a = new EventCancelType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public EventCancelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
