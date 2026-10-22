package com.lynx.tasm.event;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxEventDetail {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxEvent f383319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v6a.a f383320b;

    public static final enum EVENT_TYPE extends Enum<EVENT_TYPE> {
        public static final EVENT_TYPE CUSTOM_EVENT = null;
        public static final EVENT_TYPE TOUCH_EVENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EVENT_TYPE[] f383321a = null;

        static {
            EVENT_TYPE r100 = new EVENT_TYPE("TOUCH_EVENT", 0);
            TOUCH_EVENT = r100;
            EVENT_TYPE r101 = new EVENT_TYPE("CUSTOM_EVENT", 1);
            CUSTOM_EVENT = r101;
            f383321a = new EVENT_TYPE[]{r100, r101};
        }

        public static EVENT_TYPE[] values() {
            return (EVENT_TYPE[]) f383321a.clone();
        }

        public static EVENT_TYPE valueOf(String r100) {
            return (EVENT_TYPE) r27.a.a(EVENT_TYPE.class, r100);
        }

        public EVENT_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final LynxTouchEvent.a a() {
        if (this.f383319a.getType() == LynxEvent.LynxEventType.kTouch) goto L6;
        LLog.w("LynxEventDetail", "getTargetPoint error, event type is not touch event. type is " + this.f383319a.getType());
        return new LynxTouchEvent.a(0.0f, 0.0f);
    L6:
        LynxTouchEvent.a r100 = ((LynxTouchEvent) this.f383319a).getViewPoint();
        if (r100 == null) goto L9;
        return r100;
    L9:
        return new LynxTouchEvent.a(0.0f, 0.0f);
    }

    public LynxEventDetail(LynxEvent r100, EventTarget r101) {
        this.f383319a = r100;
        this.f383320b = r101;
    }
}
