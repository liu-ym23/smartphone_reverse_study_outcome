package z6a;

import android.graphics.Matrix;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class h extends ClickableSpan implements EventTarget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f570575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<EventTarget> f570576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, EventsListener> f570577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EventTarget.EnableStatus f570578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EventTarget.EnableStatus f570579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EventTarget.PointerEventsValue f570580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReadableMap f570581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f570582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f570583j;

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean blockNativeEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean consumeSlideEvent(float r100) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r100, float r101) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean containsPoint(float r100, float r101, boolean r102) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchEvent(LynxEventDetail r100) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchTouch(MotionEvent r100) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final int getGestureArenaMemberId() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final Map<Integer, s7a.a> getGestureDetectorMap() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget getParentLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget getRootLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean hasConsumeSlideEventAngles() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r100, float r101) {
        return this;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget hitTest(float r100, float r101, boolean r102) {
        return this;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isFocusable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isOnResponseChain() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isUserInteractionEnabled() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void offResponseChain() {
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventBubble(boolean r100, long r101) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventCapture(boolean r100, long r101) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onEventFire(boolean r100, long r101) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onFocusChanged(boolean r100, boolean r101) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onResponseChain() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setChildrenLynxPageUI(HashMap<String, EventTarget> r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setEventID(long r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptAncestors(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptDescendants(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setPanInterceptSelf(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void setParentLynxPageUI(EventTarget r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventBubble(long r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventCapture(long r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void startEventFire(boolean r100, long r101) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final Matrix getTransformMatrix() {
        this.f570582i.reset();
        return this.f570582i;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean ignoreFocus() {
        EventTarget.EnableStatus r100 = this.f570578e;
        if (r100 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r100 != EventTarget.EnableStatus.Disable) goto L10;
        return false;
    L10:
        if (parent() != null) goto L12;
        return false;
    L12:
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isClickable() {
        Map<String, EventsListener> r100 = this.f570577d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (((HashMap) r100).containsKey("tap") == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean isLongClickable() {
        Map<String, EventsListener> r100 = this.f570577d;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (((HashMap) r100).containsKey("longpress") == false) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget parent() {
        return this.f570576c.get();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final v6a.a parentResponder() {
        WeakReference<EventTarget> r100 = this.f570576c;
        if ((r100 instanceof v6a.a) == true) goto L5;
        return null;
    L5:
        return r100.get();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PointerEventsValue pointerEvents() {
        EventTarget.PointerEventsValue r100 = this.f570580g;
        if (r100 == EventTarget.PointerEventsValue.Unset) goto L6;
        return r100;
    L6:
        if (parent() == null) goto L10;
        return parent().pointerEvents();
    L10:
        return EventTarget.PointerEventsValue.Auto;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean enableTouchPseudoPropagation() {
        return this.f570583j;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final ReadableMap getDataset() {
        return this.f570581h;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final Map<String, EventsListener> getEvents() {
        return this.f570577d;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final int getPseudoStatus() {
        return this.f570575b;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public final int getSign() {
        return this.f570574a;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PanInterceptDirection panInterceptDirection() {
        return EventTarget.PanInterceptDirection.None;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final EventTarget.PanInterceptScope panInterceptScope() {
        return EventTarget.PanInterceptScope.None;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final boolean eventThrough(float r100, float r101) {
        EventTarget.EnableStatus r102 = this.f570579f;
        if (r102 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r102 != EventTarget.EnableStatus.Disable) goto L9;
        return false;
    L9:
        EventTarget r103 = parent();
        if (r103 != null) goto L12;
        return false;
    L12:
        return r103.eventThrough(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public final void onPseudoStatusChanged(int r100, int r101) {
        this.f570575b = r101;
    }

    public h(int r100, Map<String, EventsListener> r101, EventTarget.EnableStatus r102, boolean r103, EventTarget.EnableStatus r104, EventTarget.PointerEventsValue r105, ReadableMap r106) {
        this.f570581h = new JavaOnlyMap();
        this.f570582i = new Matrix();
        this.f570574a = r100;
        this.f570576c = null;
        this.f570578e = r102;
        this.f570579f = r104;
        this.f570580g = r105;
        this.f570581h = r106;
        this.f570583j = r103;
        if (r101 == null) goto L5;
        HashMap r107 = new HashMap();
        this.f570577d = r107;
        r107.putAll(r101);
        return;
    L5:
        this.f570577d = null;
    }
}
