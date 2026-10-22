package com.facebook.drawee.components;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class DraweeEventTracker {
    private static final int MAX_EVENTS_TO_TRACK = 20;
    private static boolean sEnabled;
    private static final DraweeEventTracker sInstance = null;
    private final Queue<Event> mEventQueue;

    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event ON_ACTIVITY_START = null;
        public static final Event ON_ACTIVITY_STOP = null;
        public static final Event ON_ATTACH_CONTROLLER = null;
        public static final Event ON_CLEAR_CONTROLLER = null;
        public static final Event ON_CLEAR_HIERARCHY = null;
        public static final Event ON_CLEAR_OLD_CONTROLLER = null;
        public static final Event ON_DATASOURCE_FAILURE = null;
        public static final Event ON_DATASOURCE_FAILURE_INT = null;
        public static final Event ON_DATASOURCE_RESULT = null;
        public static final Event ON_DATASOURCE_RESULT_INT = null;
        public static final Event ON_DATASOURCE_SUBMIT = null;
        public static final Event ON_DETACH_CONTROLLER = null;
        public static final Event ON_DRAWABLE_HIDE = null;
        public static final Event ON_DRAWABLE_SHOW = null;
        public static final Event ON_HOLDER_ATTACH = null;
        public static final Event ON_HOLDER_DETACH = null;
        public static final Event ON_INIT_CONTROLLER = null;
        public static final Event ON_RELEASE_CONTROLLER = null;
        public static final Event ON_RUN_CLEAR_CONTROLLER = null;
        public static final Event ON_SAME_CONTROLLER_SKIPPED = null;
        public static final Event ON_SCHEDULE_CLEAR_CONTROLLER = null;
        public static final Event ON_SET_CONTROLLER = null;
        public static final Event ON_SET_HIERARCHY = null;
        public static final Event ON_SUBMIT_CACHE_HIT = null;

        static {
            Event r100 = new Event("ON_SET_HIERARCHY", 0);
            ON_SET_HIERARCHY = r100;
            Event r101 = new Event("ON_CLEAR_HIERARCHY", 1);
            ON_CLEAR_HIERARCHY = r101;
            Event r102 = new Event("ON_SET_CONTROLLER", 2);
            ON_SET_CONTROLLER = r102;
            Event r103 = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
            ON_CLEAR_OLD_CONTROLLER = r103;
            Event r104 = new Event("ON_CLEAR_CONTROLLER", 4);
            ON_CLEAR_CONTROLLER = r104;
            Event r105 = new Event("ON_INIT_CONTROLLER", 5);
            ON_INIT_CONTROLLER = r105;
            Event r110 = new Event("ON_ATTACH_CONTROLLER", 6);
            ON_ATTACH_CONTROLLER = r110;
            Event r111 = new Event("ON_DETACH_CONTROLLER", 7);
            ON_DETACH_CONTROLLER = r111;
            Event r112 = new Event("ON_RELEASE_CONTROLLER", 8);
            ON_RELEASE_CONTROLLER = r112;
            Event r113 = new Event("ON_DATASOURCE_SUBMIT", 9);
            ON_DATASOURCE_SUBMIT = r113;
            Event r114 = new Event("ON_DATASOURCE_RESULT", 10);
            ON_DATASOURCE_RESULT = r114;
            Event r115 = new Event("ON_DATASOURCE_RESULT_INT", 11);
            ON_DATASOURCE_RESULT_INT = r115;
            Event r106 = new Event("ON_DATASOURCE_FAILURE", 12);
            ON_DATASOURCE_FAILURE = r106;
            Event r107 = new Event("ON_DATASOURCE_FAILURE_INT", 13);
            ON_DATASOURCE_FAILURE_INT = r107;
            Event r108 = new Event("ON_HOLDER_ATTACH", 14);
            ON_HOLDER_ATTACH = r108;
            Event r109 = new Event("ON_HOLDER_DETACH", 15);
            ON_HOLDER_DETACH = r109;
            Event r116 = new Event("ON_DRAWABLE_SHOW", 16);
            ON_DRAWABLE_SHOW = r116;
            Event r117 = new Event("ON_DRAWABLE_HIDE", 17);
            ON_DRAWABLE_HIDE = r117;
            Event r118 = new Event("ON_ACTIVITY_START", 18);
            ON_ACTIVITY_START = r118;
            Event r119 = new Event("ON_ACTIVITY_STOP", 19);
            ON_ACTIVITY_STOP = r119;
            Event r120 = new Event("ON_RUN_CLEAR_CONTROLLER", 20);
            ON_RUN_CLEAR_CONTROLLER = r120;
            Event r121 = new Event("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
            ON_SCHEDULE_CLEAR_CONTROLLER = r121;
            Event r122 = new Event("ON_SAME_CONTROLLER_SKIPPED", 22);
            ON_SAME_CONTROLLER_SKIPPED = r122;
            Event r123 = new Event("ON_SUBMIT_CACHE_HIT", 23);
            ON_SUBMIT_CACHE_HIT = r123;
            $VALUES = new Event[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public static Event valueOf(String r100) {
            return (Event) Enum.valueOf(Event.class, r100);
        }

        private Event(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static void disable() {
        sEnabled = false;
    }

    static {
        sInstance = new DraweeEventTracker();
        sEnabled = true;
    }

    public static DraweeEventTracker newInstance() {
        if (sEnabled == false) goto L6;
        return new DraweeEventTracker();
    L6:
        return sInstance;
    }

    public String toString() {
        return this.mEventQueue.toString();
    }

    private DraweeEventTracker() {
        this.mEventQueue = new ArrayBlockingQueue(20);
    }

    public void recordEvent(Event r100) {
        if (sEnabled == true) goto L6;
        return;
    L6:
        if ((this.mEventQueue.size() + 1) <= 20) goto L8;
        this.mEventQueue.poll();
    L8:
        this.mEventQueue.add(r100);
    }
}
