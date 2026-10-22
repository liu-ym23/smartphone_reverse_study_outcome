package com.huawei.hms.push;

/* JADX INFO: loaded from: classes23.dex */
public final enum AttributionEvent extends Enum<AttributionEvent> {
    public static final AttributionEvent AGREED_PRIVACY = null;
    public static final AttributionEvent APP_START_COMPLETE = null;
    public static final AttributionEvent OPEN_LANDING_PAGE = null;
    public static final AttributionEvent OPEN_PRIVACY_PAGE = null;
    public static final AttributionEvent PERMISSION_DENIED = null;
    public static final AttributionEvent PERMISSION_GRANTED = null;
    public static final AttributionEvent REJECT_PRIVACY = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AttributionEvent[] f277548b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f277549a;

    static {
        AttributionEvent r100 = new AttributionEvent("APP_START_COMPLETE", 0, 1);
        APP_START_COMPLETE = r100;
        AttributionEvent r101 = new AttributionEvent("OPEN_PRIVACY_PAGE", 1, 2);
        OPEN_PRIVACY_PAGE = r101;
        AttributionEvent r102 = new AttributionEvent("REJECT_PRIVACY", 2, 3);
        REJECT_PRIVACY = r102;
        AttributionEvent r103 = new AttributionEvent("AGREED_PRIVACY", 3, 4);
        AGREED_PRIVACY = r103;
        AttributionEvent r104 = new AttributionEvent("PERMISSION_GRANTED", 4, 5);
        PERMISSION_GRANTED = r104;
        AttributionEvent r110 = new AttributionEvent("PERMISSION_DENIED", 5, 6);
        PERMISSION_DENIED = r110;
        AttributionEvent r111 = new AttributionEvent("OPEN_LANDING_PAGE", 6, 7);
        OPEN_LANDING_PAGE = r111;
        f277548b = new AttributionEvent[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static AttributionEvent[] values() {
        return (AttributionEvent[]) f277548b.clone();
    }

    public int getEventId() {
        return this.f277549a;
    }

    public static AttributionEvent valueOf(String r100) {
        return (AttributionEvent) r27.a.a(AttributionEvent.class, r100);
    }

    private AttributionEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.f277549a = r102;
    }
}
