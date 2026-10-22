package com.bytedance.android.livesdk.livecommerce.actionrecord.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/event/EventType;", "", "RATE_START", "RATE_SUCCESS", "RATE_FAILURE", "RATE_SINGLE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EventType extends Enum<EventType> {
    public static final EventType RATE_FAILURE = null;
    public static final EventType RATE_SINGLE = null;
    public static final EventType RATE_START = null;
    public static final EventType RATE_SUCCESS = null;
    public static final /* synthetic */ EventType[] a = null;

    static {
        EventType r1 = new EventType("RATE_START", 0);
        RATE_START = r1;
        EventType r2 = new EventType("RATE_SUCCESS", 1);
        RATE_SUCCESS = r2;
        EventType r3 = new EventType("RATE_FAILURE", 2);
        RATE_FAILURE = r3;
        EventType r4 = new EventType("RATE_SINGLE", 3);
        RATE_SINGLE = r4;
        a = new EventType[]{r1, r2, r3, r4};
    }

    public static EventType valueOf(String r1) {
        return (EventType) a.a(EventType.class, r1);
    }

    public static EventType[] values() {
        return (EventType[]) a.clone();
    }

    public EventType(String r1, int r2) {
        super(r1, r2);
    }
}
