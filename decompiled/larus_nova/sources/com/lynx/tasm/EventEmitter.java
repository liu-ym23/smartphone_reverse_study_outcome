package com.lynx.tasm;

import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;

/* JADX INFO: loaded from: classes32.dex */
public abstract class EventEmitter {
    private static final String TAG = "EventEmitter";

    public static final enum LynxEventType extends Enum<LynxEventType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxEventType[] f381632a = null;
        public static final LynxEventType kLynxEventTypeCustomEvent = null;
        public static final LynxEventType kLynxEventTypeLayoutEvent = null;
        public static final LynxEventType kLynxEventTypeTouchEvent = null;

        static {
            LynxEventType r100 = new LynxEventType("kLynxEventTypeTouchEvent", 0);
            kLynxEventTypeTouchEvent = r100;
            LynxEventType r101 = new LynxEventType("kLynxEventTypeCustomEvent", 1);
            kLynxEventTypeCustomEvent = r101;
            LynxEventType r102 = new LynxEventType("kLynxEventTypeLayoutEvent", 2);
            kLynxEventTypeLayoutEvent = r102;
            f381632a = new LynxEventType[]{r100, r101, r102};
        }

        public static LynxEventType[] values() {
            return (LynxEventType[]) f381632a.clone();
        }

        public static LynxEventType valueOf(String r100) {
            return (LynxEventType) r27.a.a(LynxEventType.class, r100);
        }

        public LynxEventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
    }

    public interface b {
        void checkFallbackForLynxEvent(boolean r100);
    }

    public interface c {
        void a(LynxEventType r100, LynxEvent r101);
    }

    public interface d {
        boolean a(LynxEvent r100);
    }

    public EventEmitter() {
    }

    public abstract void addObserver(c r100);

    public void onInternalEvent(m7a.c r100) {
    }

    public abstract boolean onLynxEvent(LynxEvent r100);

    public abstract void onPseudoStatusChanged(int r100, int r101, int r102);

    public abstract void registerEventFallback(b r100);

    public abstract void registerEventReporter(d r100);

    public abstract void removeObserver(c r100);

    public abstract void sendCustomEvent(com.lynx.tasm.event.a r100);

    public abstract void sendGestureEvent(int r100, com.lynx.tasm.event.a r101);

    public void sendInternalEvent(m7a.c r100) {
    }

    public abstract void sendLayoutEvent();

    public abstract void sendMultiTouchEvent(LynxTouchEvent r100);

    public abstract void sendTouchEvent(LynxTouchEvent r100);

    public void setEventID(long r100) {
    }

    public abstract void setInPreLoad(boolean r100);

    public abstract void setTestTapTracker(a r100);

    public void startEventBubble(long r100) {
    }

    public void startEventCapture(long r100) {
    }

    public void startEventFire(boolean r100, long r101) {
    }

    public void startEventGenerate(LynxEvent r100) {
    }
}
