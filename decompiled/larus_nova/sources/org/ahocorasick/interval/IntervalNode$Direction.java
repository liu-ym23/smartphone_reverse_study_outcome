package org.ahocorasick.interval;

/* JADX INFO: loaded from: classes42.dex */
final enum IntervalNode$Direction extends Enum<IntervalNode$Direction> {
    public static final IntervalNode$Direction LEFT = null;
    public static final IntervalNode$Direction RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntervalNode$Direction[] f525005a = null;

    static {
        IntervalNode$Direction r100 = new IntervalNode$Direction("LEFT", 0);
        LEFT = r100;
        IntervalNode$Direction r101 = new IntervalNode$Direction("RIGHT", 1);
        RIGHT = r101;
        f525005a = new IntervalNode$Direction[]{r100, r101};
    }

    public static IntervalNode$Direction[] values() {
        return (IntervalNode$Direction[]) f525005a.clone();
    }

    public static IntervalNode$Direction valueOf(String r100) {
        return (IntervalNode$Direction) r27.a.a(IntervalNode$Direction.class, r100);
    }

    public IntervalNode$Direction(String r100, int r101) {
        super(r100, r101);
    }
}
