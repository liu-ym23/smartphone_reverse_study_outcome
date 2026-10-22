package com.bytedance.lark.policy.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/policy/event/Event;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT_LOGIN", "EVENT_LOGOUT", "EVENT_APP_STATE_ON_FRONT", "EVENT_APP_STATE_ON_BACKGROUND", "EVENT_IP_CHANGE", "EVENT_DECISION_CONTEXT_CHANGE", "EVENT_NETWORK_CHANGE", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Event extends Enum<Event> {
    public static final Event EVENT_APP_STATE_ON_BACKGROUND = null;
    public static final Event EVENT_APP_STATE_ON_FRONT = null;
    public static final Event EVENT_DECISION_CONTEXT_CHANGE = null;
    public static final Event EVENT_IP_CHANGE = null;
    public static final Event EVENT_LOGIN = null;
    public static final Event EVENT_LOGOUT = null;
    public static final Event EVENT_NETWORK_CHANGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Event[] f253799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253800b = null;

    public static EnumEntries<Event> getEntries() {
        return f253800b;
    }

    static {
        Event r100 = new Event("EVENT_LOGIN", 0);
        EVENT_LOGIN = r100;
        Event r101 = new Event("EVENT_LOGOUT", 1);
        EVENT_LOGOUT = r101;
        Event r102 = new Event("EVENT_APP_STATE_ON_FRONT", 2);
        EVENT_APP_STATE_ON_FRONT = r102;
        Event r103 = new Event("EVENT_APP_STATE_ON_BACKGROUND", 3);
        EVENT_APP_STATE_ON_BACKGROUND = r103;
        Event r104 = new Event("EVENT_IP_CHANGE", 4);
        EVENT_IP_CHANGE = r104;
        Event r105 = new Event("EVENT_DECISION_CONTEXT_CHANGE", 5);
        EVENT_DECISION_CONTEXT_CHANGE = r105;
        Event r110 = new Event("EVENT_NETWORK_CHANGE", 6);
        EVENT_NETWORK_CHANGE = r110;
        Event[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f253799a = r111;
        f253800b = EnumEntriesKt.enumEntries(r111);
    }

    public static Event[] values() {
        return (Event[]) f253799a.clone();
    }

    public static Event valueOf(String r100) {
        return (Event) r27.a.a(Event.class, r100);
    }

    public Event(String r100, int r101) {
        super(r100, r101);
    }
}
