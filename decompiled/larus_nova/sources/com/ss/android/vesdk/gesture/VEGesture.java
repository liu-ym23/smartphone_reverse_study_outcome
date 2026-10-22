package com.ss.android.vesdk.gesture;

/* JADX INFO: loaded from: classes40.dex */
public final class VEGesture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f455839a;

    public static final enum EventType extends Enum<EventType> {
        public static final EventType CANCELLED = null;
        public static final EventType DB_CLICK = null;
        public static final EventType PAN = null;
        public static final EventType ROTATE = null;
        public static final EventType SCALE = null;
        public static final EventType TOUCH = null;
        public static final EventType TOUCH_DOWN = null;
        public static final EventType TOUCH_LONG = null;
        public static final EventType TOUCH_UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f455840a = null;

        static {
            EventType r100 = new EventType("TOUCH", 0);
            TOUCH = r100;
            EventType r101 = new EventType("TOUCH_DOWN", 1);
            TOUCH_DOWN = r101;
            EventType r102 = new EventType("TOUCH_UP", 2);
            TOUCH_UP = r102;
            EventType r103 = new EventType("TOUCH_LONG", 3);
            TOUCH_LONG = r103;
            EventType r104 = new EventType("PAN", 4);
            PAN = r104;
            EventType r105 = new EventType("SCALE", 5);
            SCALE = r105;
            EventType r110 = new EventType("ROTATE", 6);
            ROTATE = r110;
            EventType r111 = new EventType("DB_CLICK", 7);
            DB_CLICK = r111;
            EventType r112 = new EventType("CANCELLED", 8);
            CANCELLED = r112;
            f455840a = new EventType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static EventType[] values() {
            return (EventType[]) f455840a.clone();
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum GestureType extends Enum<GestureType> {
        public static final GestureType LONG_PRESS = null;
        public static final GestureType PAN = null;
        public static final GestureType ROTATE = null;
        public static final GestureType SCALE = null;
        public static final GestureType TAP = null;
        public static final GestureType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GestureType[] f455841a = null;

        static {
            GestureType r100 = new GestureType("UNKNOWN", 0);
            UNKNOWN = r100;
            GestureType r101 = new GestureType("TAP", 1);
            TAP = r101;
            GestureType r102 = new GestureType("PAN", 2);
            PAN = r102;
            GestureType r103 = new GestureType("ROTATE", 3);
            ROTATE = r103;
            GestureType r104 = new GestureType("SCALE", 4);
            SCALE = r104;
            GestureType r105 = new GestureType("LONG_PRESS", 5);
            LONG_PRESS = r105;
            f455841a = new GestureType[]{r100, r101, r102, r103, r104, r105};
        }

        public static GestureType[] values() {
            return (GestureType[]) f455841a.clone();
        }

        public static GestureType valueOf(String r100) {
            return (GestureType) r27.a.a(GestureType.class, r100);
        }

        public GestureType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EventType f455842a;

        public a(EventType r100) {
            this.f455842a = r100;
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f455843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f455844e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f455845f;

        public b(float r100, float r101, float r102, float r103, float r104) {
            super(EventType.PAN, r100, r101);
            this.f455843d = r102;
            this.f455844e = r103;
            this.f455845f = r104;
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f455846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f455847c;

        public c(float r100, float r101) {
            super(EventType.ROTATE);
            this.f455846b = r100;
            this.f455847c = r101;
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f455848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f455849c;

        public d(float r100, float r101) {
            super(EventType.SCALE);
            this.f455848b = r100;
            this.f455849c = r101;
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f455850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f455851c;

        public e(float r100, float r101) {
            super(EventType.TOUCH);
            this.f455850b = r100;
            this.f455851c = r101;
        }

        public e(EventType r100, float r101, float r102) {
            super(r100);
            this.f455850b = r101;
            this.f455851c = r102;
        }
    }

    public static class f extends e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final GestureType f455852d;

        public f(EventType r100, GestureType r101, float r102, float r103) {
            super(r100, r102, r103);
            this.f455852d = r101;
        }
    }

    public VEGesture() {
    }
}
