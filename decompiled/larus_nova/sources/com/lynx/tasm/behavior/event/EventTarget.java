package com.lynx.tasm.behavior.event;

import android.graphics.Matrix;
import android.view.MotionEvent;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import v6a.a;

/* JADX INFO: loaded from: classes32.dex */
public interface EventTarget extends a {

    public static final enum EnableStatus extends Enum<EnableStatus> {
        public static final EnableStatus Disable = null;
        public static final EnableStatus Enable = null;
        public static final EnableStatus Undefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnableStatus[] f382033a = null;

        static {
            EnableStatus r100 = new EnableStatus("Enable", 0);
            Enable = r100;
            EnableStatus r101 = new EnableStatus("Disable", 1);
            Disable = r101;
            EnableStatus r102 = new EnableStatus("Undefined", 2);
            Undefined = r102;
            f382033a = new EnableStatus[]{r100, r101, r102};
        }

        public static EnableStatus[] values() {
            return (EnableStatus[]) f382033a.clone();
        }

        public static EnableStatus valueOf(String r100) {
            return (EnableStatus) r27.a.a(EnableStatus.class, r100);
        }

        public EnableStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PanInterceptDirection extends Enum<PanInterceptDirection> {
        public static final PanInterceptDirection Horizontal = null;
        public static final PanInterceptDirection None = null;
        public static final PanInterceptDirection Vertical = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanInterceptDirection[] f382034a = null;

        static {
            PanInterceptDirection r100 = new PanInterceptDirection("Horizontal", 0);
            Horizontal = r100;
            PanInterceptDirection r101 = new PanInterceptDirection("Vertical", 1);
            Vertical = r101;
            PanInterceptDirection r102 = new PanInterceptDirection("None", 2);
            None = r102;
            f382034a = new PanInterceptDirection[]{r100, r101, r102};
        }

        public static PanInterceptDirection[] values() {
            return (PanInterceptDirection[]) f382034a.clone();
        }

        public static PanInterceptDirection valueOf(String r100) {
            return (PanInterceptDirection) r27.a.a(PanInterceptDirection.class, r100);
        }

        public PanInterceptDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PanInterceptScope extends Enum<PanInterceptScope> {
        public static final PanInterceptScope All = null;
        public static final PanInterceptScope Ancestors = null;
        public static final PanInterceptScope Descendants = null;
        public static final PanInterceptScope None = null;
        public static final PanInterceptScope Self = null;
        public static final PanInterceptScope SelfAndAncestors = null;
        public static final PanInterceptScope SelfAndDescendants = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanInterceptScope[] f382035a = null;

        static {
            PanInterceptScope r100 = new PanInterceptScope("Self", 0);
            Self = r100;
            PanInterceptScope r101 = new PanInterceptScope("Ancestors", 1);
            Ancestors = r101;
            PanInterceptScope r102 = new PanInterceptScope("Descendants", 2);
            Descendants = r102;
            PanInterceptScope r103 = new PanInterceptScope("SelfAndAncestors", 3);
            SelfAndAncestors = r103;
            PanInterceptScope r104 = new PanInterceptScope("SelfAndDescendants", 4);
            SelfAndDescendants = r104;
            PanInterceptScope r105 = new PanInterceptScope(CancelRetainContactInfoFunctions.All, 5);
            All = r105;
            PanInterceptScope r110 = new PanInterceptScope("None", 6);
            None = r110;
            f382035a = new PanInterceptScope[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static PanInterceptScope[] values() {
            return (PanInterceptScope[]) f382035a.clone();
        }

        public static PanInterceptScope valueOf(String r100) {
            return (PanInterceptScope) r27.a.a(PanInterceptScope.class, r100);
        }

        public PanInterceptScope(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PointerEventsValue extends Enum<PointerEventsValue> {
        public static final PointerEventsValue Auto = null;
        public static final PointerEventsValue None = null;
        public static final PointerEventsValue Unset = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PointerEventsValue[] f382036a = null;

        static {
            PointerEventsValue r100 = new PointerEventsValue("Auto", 0);
            Auto = r100;
            PointerEventsValue r101 = new PointerEventsValue("None", 1);
            None = r101;
            PointerEventsValue r102 = new PointerEventsValue("Unset", 2);
            Unset = r102;
            f382036a = new PointerEventsValue[]{r100, r101, r102};
        }

        public static PointerEventsValue[] values() {
            return (PointerEventsValue[]) f382036a.clone();
        }

        public static PointerEventsValue valueOf(String r100) {
            return (PointerEventsValue) r27.a.a(PointerEventsValue.class, r100);
        }

        public PointerEventsValue(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean blockNativeEvent(MotionEvent r100);

    boolean consumeSlideEvent(float r100);

    boolean containsPoint(float r100, float r101);

    boolean containsPoint(float r100, float r101, boolean r102);

    boolean dispatchEvent(LynxEventDetail r100);

    boolean dispatchTouch(MotionEvent r100);

    boolean enableTouchPseudoPropagation();

    boolean eventThrough(float r100, float r101);

    HashMap<String, EventTarget> getChildrenLynxPageUI();

    /* synthetic */ ReadableMap getDataset();

    Map<String, EventsListener> getEvents();

    int getGestureArenaMemberId();

    Map<Integer, s7a.a> getGestureDetectorMap();

    EventTarget getParentLynxPageUI();

    int getPseudoStatus();

    EventTarget getRootLynxPageUI();

    int getSign();

    Matrix getTransformMatrix();

    boolean hasConsumeSlideEventAngles();

    EventTarget hitTest(float r100, float r101);

    EventTarget hitTest(float r100, float r101, boolean r102);

    boolean ignoreFocus();

    boolean isClickable();

    boolean isFocusable();

    boolean isLongClickable();

    boolean isOnResponseChain();

    boolean isScrollable();

    boolean isUserInteractionEnabled();

    void offResponseChain();

    void onEventBubble(boolean r100, long r101);

    void onEventCapture(boolean r100, long r101);

    void onEventFire(boolean r100, long r101);

    void onFocusChanged(boolean r100, boolean r101);

    void onPseudoStatusChanged(int r100, int r101);

    void onResponseChain();

    PanInterceptDirection panInterceptDirection();

    PanInterceptScope panInterceptScope();

    EventTarget parent();

    /* synthetic */ a parentResponder();

    PointerEventsValue pointerEvents();

    void setChildrenLynxPageUI(HashMap<String, EventTarget> r100);

    void setEventID(long r100);

    void setPanInterceptAncestors(boolean r100);

    void setPanInterceptDescendants(boolean r100);

    void setPanInterceptSelf(boolean r100);

    void setParentLynxPageUI(EventTarget r100);

    void startEventBubble(long r100);

    void startEventCapture(long r100);

    void startEventFire(boolean r100, long r101);
}
