package com.bytedance.locallife.biz.mob;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/biz/mob/EventType;", "", "", "type", "I", "getType", "()I", "PAGE", "CLICK", "VIEW", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum EventType extends Enum<EventType> {
    public static final EventType CLICK = null;
    public static final EventType PAGE = null;
    public static final EventType VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EventType[] f256702a = null;
    private final int type;

    public static EventType valueOf(String r100) {
        return (EventType) r27.a.a(EventType.class, r100);
    }

    public static EventType[] values() {
        return (EventType[]) f256702a.clone();
    }

    static {
        EventType r100 = new EventType("PAGE", 0, 2001);
        PAGE = r100;
        EventType r101 = new EventType("CLICK", 1, 3001);
        CLICK = r101;
        EventType r102 = new EventType("VIEW", 2, 2002);
        VIEW = r102;
        f256702a = new EventType[]{r100, r101, r102};
    }

    public final int getType() {
        return this.type;
    }

    public EventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
