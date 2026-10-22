package com.bytedance.dora.camera;

/* JADX INFO: loaded from: classes15.dex */
public final class DoraCameraTrackEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventType f204385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f204386b;

    public static final enum EventType extends Enum<EventType> {
        public static final EventType FIRST_FRAME = null;
        public static final EventType LAST_FRAME = null;
        public static final EventType TAKE_IMAGE_START = null;
        public static final EventType TRANSMIT_END = null;
        public static final EventType TRANSMIT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f204387a = null;

        static {
            EventType r100 = new EventType("TAKE_IMAGE_START", 0);
            TAKE_IMAGE_START = r100;
            EventType r101 = new EventType("TRANSMIT_START", 1);
            TRANSMIT_START = r101;
            EventType r102 = new EventType("FIRST_FRAME", 2);
            FIRST_FRAME = r102;
            EventType r103 = new EventType("LAST_FRAME", 3);
            LAST_FRAME = r103;
            EventType r104 = new EventType("TRANSMIT_END", 4);
            TRANSMIT_END = r104;
            f204387a = new EventType[]{r100, r101, r102, r103, r104};
        }

        public static EventType[] values() {
            return (EventType[]) f204387a.clone();
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204388a = null;

        static {
            int[] r100 = new int[EventType.values().length];
            f204388a = r100;
            r100[EventType.TAKE_IMAGE_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f204388a[EventType.TRANSMIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f204388a[EventType.FIRST_FRAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f204388a[EventType.LAST_FRAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f204388a[EventType.TRANSMIT_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final String toString() {
        return "DoraCameraTrackEvent{type=" + this.f204385a + ", imageIndex=" + this.f204386b + '}';
    }

    public DoraCameraTrackEvent(EventType r100, int r101) {
        this.f204385a = r100;
        this.f204386b = r101;
    }
}
