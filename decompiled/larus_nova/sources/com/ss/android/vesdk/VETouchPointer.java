package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VETouchPointer {
    private TouchEvent event;
    private float force;
    private float majorRadius;
    private int pointerId;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f455717x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f455718y;

    public static final enum TouchEvent extends Enum<TouchEvent> {
        private static final /* synthetic */ TouchEvent[] $VALUES = null;
        public static final TouchEvent BEGAN = null;
        public static final TouchEvent CANCELED = null;
        public static final TouchEvent ENDED = null;
        public static final TouchEvent MOVED = null;
        public static final TouchEvent STATIONARY = null;

        private static /* synthetic */ TouchEvent[] $values() {
            return new TouchEvent[]{BEGAN, MOVED, STATIONARY, ENDED, CANCELED};
        }

        static {
            BEGAN = new TouchEvent("BEGAN", 0);
            MOVED = new TouchEvent("MOVED", 1);
            STATIONARY = new TouchEvent("STATIONARY", 2);
            ENDED = new TouchEvent("ENDED", 3);
            CANCELED = new TouchEvent("CANCELED", 4);
            $VALUES = $values();
        }

        public static TouchEvent[] values() {
            return (TouchEvent[]) $VALUES.clone();
        }

        public static TouchEvent valueOf(String r100) {
            return (TouchEvent) r27.a.a(TouchEvent.class, r100);
        }

        private TouchEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "pointerId: " + this.pointerId + ", TouchEvent: " + this.event + ", x: " + this.f455717x + ", y: " + this.f455718y + ", force: " + this.force + ", majorRadius: " + this.majorRadius;
    }

    public VETouchPointer() {
    }

    public TouchEvent getEvent() {
        return this.event;
    }

    public float getForce() {
        return this.force;
    }

    public float getMajorRadius() {
        return this.majorRadius;
    }

    public int getPointerId() {
        return this.pointerId;
    }

    public float getX() {
        return this.f455717x;
    }

    public float getY() {
        return this.f455718y;
    }

    public void setEvent(TouchEvent r100) {
        this.event = r100;
    }

    public void setForce(float r100) {
        this.force = r100;
    }

    public void setMajorRadius(float r100) {
        this.majorRadius = r100;
    }

    public void setPointerId(int r100) {
        this.pointerId = r100;
    }

    public void setX(float r100) {
        this.f455717x = r100;
    }

    public void setY(float r100) {
        this.f455718y = r100;
    }

    public VETouchPointer(int r100, TouchEvent r101, float r102, float r103, float r104, float r105) {
        this.pointerId = r100;
        this.event = r101;
        this.f455717x = r102;
        this.f455718y = r103;
        this.force = r104;
        this.majorRadius = r105;
    }
}
