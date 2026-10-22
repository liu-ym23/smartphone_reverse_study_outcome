package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEGestureEvent extends Enum<VEGestureEvent> {
    public static final VEGestureEvent ANY_SUPPORTED = null;
    public static final VEGestureEvent DOUBLE_CLICK = null;
    public static final VEGestureEvent DRAG = null;
    public static final VEGestureEvent DROP = null;
    public static final VEGestureEvent LONG_TAP = null;
    public static final VEGestureEvent PINCH = null;
    public static final VEGestureEvent SWIPE = null;
    public static final VEGestureEvent TAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEGestureEvent[] f455625a = null;

    static {
        VEGestureEvent r100 = new VEGestureEvent("TAP", 0);
        TAP = r100;
        VEGestureEvent r101 = new VEGestureEvent("SWIPE", 1);
        SWIPE = r101;
        VEGestureEvent r102 = new VEGestureEvent("PINCH", 2);
        PINCH = r102;
        VEGestureEvent r103 = new VEGestureEvent("LONG_TAP", 3);
        LONG_TAP = r103;
        VEGestureEvent r104 = new VEGestureEvent("DRAG", 4);
        DRAG = r104;
        VEGestureEvent r105 = new VEGestureEvent("DROP", 5);
        DROP = r105;
        VEGestureEvent r110 = new VEGestureEvent("DOUBLE_CLICK", 6);
        DOUBLE_CLICK = r110;
        VEGestureEvent r111 = new VEGestureEvent("ANY_SUPPORTED", 7);
        ANY_SUPPORTED = r111;
        f455625a = new VEGestureEvent[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static VEGestureEvent[] values() {
        return (VEGestureEvent[]) f455625a.clone();
    }

    public static VEGestureEvent valueOf(String r100) {
        return (VEGestureEvent) r27.a.a(VEGestureEvent.class, r100);
    }

    public VEGestureEvent(String r100, int r101) {
        super(r100, r101);
    }
}
