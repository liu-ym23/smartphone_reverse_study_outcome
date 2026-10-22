package com.lynx.tasm.event;

import android.view.MotionEvent;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class LynxTouchEvent extends LynxEvent {
    public static final String EVENT_CLICK = "click";
    public static final String EVENT_LONG_PRESS = "longpress";
    public static final String EVENT_TAP = "tap";
    public static final String EVENT_TOUCH_CANCEL = "touchcancel";
    public static final String EVENT_TOUCH_END = "touchend";
    public static final String EVENT_TOUCH_MOVE = "touchmove";
    public static final String EVENT_TOUCH_START = "touchstart";
    public static final int kPseudoStateActive = 8;
    public static final int kPseudoStateActiveTransition = 16;
    public static final int kPseudoStateAll = -1;
    public static final int kPseudoStateFocus = 64;
    public static final int kPseudoStateFocusTransition = 128;
    public static final int kPseudoStateHover = 1;
    public static final int kPseudoStateHoverTransition = 2;
    public static final int kPseudoStateNone = 0;
    private HashMap<Integer, v6a.a> mActiveTargetMap;
    private a mClientPoint;
    private boolean mIsMultiTouch;
    private MotionEvent mMotionEvent;
    private a mPagePoint;
    private Map<Integer, a> mTouchMap;
    private JavaOnlyMap mUITouchMap;
    private a mViewPoint;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f383322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f383323b;

        public final int hashCode() {
            return Arrays.hashCode(new float[]{this.f383322a, this.f383323b});
        }

        public final String toString() {
            return "Point{x=" + this.f383322a + ", y=" + this.f383323b + '}';
        }

        public a() {
            this.f383322a = 0.0f;
            this.f383323b = 0.0f;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(r101.f383322a, this.f383322a) == 0) goto L11;
        L13:
            return false;
        L11:
            if (Float.compare(r101.f383323b, this.f383323b) != 0) goto L13;
            return true;
        }

        public a(float r100, float r101) {
            this.f383322a = r100;
            this.f383323b = r101;
        }
    }

    @Override // com.lynx.tasm.event.LynxEvent
    public ArrayList<Object> getEventParams() {
        ArrayList<Object> r100 = super.getEventParams();
        ArrayList r101 = new ArrayList();
        r101.add(Boolean.valueOf(this.mIsMultiTouch));
        if (this.mIsMultiTouch == false) goto L5;
        r101.add(this.mUITouchMap);
    L6:
        r100.add(r101);
        return r100;
    L5:
        r101.add(Float.valueOf(this.mClientPoint.f383322a));
        r101.add(Float.valueOf(this.mClientPoint.f383323b));
        r101.add(Float.valueOf(this.mPagePoint.f383322a));
        r101.add(Float.valueOf(this.mPagePoint.f383323b));
        r101.add(Float.valueOf(this.mViewPoint.f383322a));
        r101.add(Float.valueOf(this.mViewPoint.f383323b));
        goto L6
    }

    public HashMap<Integer, v6a.a> getActiveTargetMap() {
        return this.mActiveTargetMap;
    }

    public a getClientPoint() {
        return this.mClientPoint;
    }

    public boolean getIsMultiTouch() {
        return this.mIsMultiTouch;
    }

    public MotionEvent getMotionEvent() {
        return this.mMotionEvent;
    }

    public a getPagePoint() {
        return this.mPagePoint;
    }

    public Map<Integer, a> getTouchMap() {
        return this.mTouchMap;
    }

    public JavaOnlyMap getUITouchMap() {
        return this.mUITouchMap;
    }

    public a getViewPoint() {
        return this.mViewPoint;
    }

    public void setActiveTargetMap(HashMap<Integer, v6a.a> r100) {
        this.mActiveTargetMap = r100;
    }

    public void setMotionEvent(MotionEvent r100) {
        this.mMotionEvent = r100;
    }

    public LynxTouchEvent(String r100, JavaOnlyMap r101) {
        super(-1, r100, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mUITouchMap = r101;
    }

    public LynxTouchEvent(int r100, String r101) {
        super(r100, r101, LynxEvent.LynxEventType.kTouch);
    }

    public LynxTouchEvent(int r100, String r101, Map<Integer, a> r102) {
        super(r100, r101, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mTouchMap = r102;
    }

    public LynxTouchEvent(int r100, String r101, float r102, float r103) {
        super(r100, r101, LynxEvent.LynxEventType.kTouch);
        a r104 = new a(r102, r103);
        this.mClientPoint = r104;
        this.mPagePoint = r104;
        this.mViewPoint = r104;
    }

    public LynxTouchEvent(int r100, String r101, a r102, a r103, a r104) {
        super(r100, r101, LynxEvent.LynxEventType.kTouch);
        this.mClientPoint = r102;
        this.mPagePoint = r103;
        this.mViewPoint = r104;
    }
}
