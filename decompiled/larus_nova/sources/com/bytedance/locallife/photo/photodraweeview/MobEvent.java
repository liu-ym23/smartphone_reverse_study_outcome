package com.bytedance.locallife.photo.photodraweeview;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/MobEvent;", "", "", "event", "Ljava/lang/String;", "getEvent", "()Ljava/lang/String;", "MOB_EVENT_SHOW", "MOB_EVENT_CLOSE", "MOB_EVENT_SLIDE", "MOB_EVENT_LYNX", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum MobEvent extends Enum<MobEvent> {
    public static final MobEvent MOB_EVENT_CLOSE = null;
    public static final MobEvent MOB_EVENT_LYNX = null;
    public static final MobEvent MOB_EVENT_SHOW = null;
    public static final MobEvent MOB_EVENT_SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MobEvent[] f262081a = null;
    private final String event;

    public static MobEvent valueOf(String r100) {
        return (MobEvent) r27.a.a(MobEvent.class, r100);
    }

    public static MobEvent[] values() {
        return (MobEvent[]) f262081a.clone();
    }

    static {
        MobEvent r100 = new MobEvent("MOB_EVENT_SHOW", 0, "show");
        MOB_EVENT_SHOW = r100;
        MobEvent r101 = new MobEvent("MOB_EVENT_CLOSE", 1, "close");
        MOB_EVENT_CLOSE = r101;
        MobEvent r102 = new MobEvent("MOB_EVENT_SLIDE", 2, "slide");
        MOB_EVENT_SLIDE = r102;
        MobEvent r103 = new MobEvent("MOB_EVENT_LYNX", 3, "lynx");
        MOB_EVENT_LYNX = r103;
        f262081a = new MobEvent[]{r100, r101, r102, r103};
    }

    public final String getEvent() {
        return this.event;
    }

    public MobEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.event = r102;
    }
}
