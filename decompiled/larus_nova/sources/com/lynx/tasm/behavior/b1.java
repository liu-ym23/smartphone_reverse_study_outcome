package com.lynx.tasm.behavior;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.recording.LynxFrameRecorder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b1 {
    public long A;
    public LynxTouchEvent.a B;
    public LynxTouchEvent C;
    public EventTarget D;
    public String E;
    public LynxTouchEvent.a F;
    public UIGroup G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f381966J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxUIOwner f381967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f381968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EventTarget f381969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EventTarget f381970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EventTarget f381971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<Integer, b> f381972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Integer, v6a.a> f381973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<EventTarget> f381974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EventTarget f381975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedList<EventTarget> f381976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q7a.b f381977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EventTarget.EnableStatus f381978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f381979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PointF f381980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f381981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f381982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f381983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f381984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f381985s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f381986t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashSet<Integer> f381987u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashSet<Integer> f381988v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f381989w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f381990x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f381991y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f381992z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381993a = null;

        static {
            int[] r100 = new int[EventTarget.PanInterceptScope.values().length];
            f381993a = r100;
            r100[EventTarget.PanInterceptScope.Self.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f381993a[EventTarget.PanInterceptScope.Ancestors.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f381993a[EventTarget.PanInterceptScope.Descendants.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f381993a[EventTarget.PanInterceptScope.SelfAndAncestors.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f381993a[EventTarget.PanInterceptScope.SelfAndDescendants.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f381993a[EventTarget.PanInterceptScope.All.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EventTarget f381994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PointF f381995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PointF f381996c;

        public b(EventTarget r100, float r101, float r102) {
            this.f381994a = r100;
            this.f381995b = new PointF(r101, r102);
            this.f381996c = new PointF(r101, r102);
        }
    }

    public class c extends k.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b1 f381997a;

        public c(b1 r100) {
            this.f381997a = r100;
        }
    }

    public final void B() {
        EventTarget r100 = this.f381969c;
        if (r100 != null) goto L5;
    L13:
        Iterator<EventTarget> r101 = this.f381976j.iterator();
    L15:
        if (r101.hasNext() == false) goto L17;
        r101.next().offResponseChain();
        goto L15
    L17:
        this.f381974h.clear();
        this.f381976j.clear();
        this.f381987u.clear();
        this.f381988v.clear();
        this.f381982p = false;
        this.f381983q = false;
        this.f381984r = true;
        this.f381991y = false;
        this.f381972f.clear();
        this.f381973g.clear();
        this.G = null;
        this.H = false;
        this.D = this.f381969c;
        return;
    L5:
        if (r100.getChildrenLynxPageUI() == null) goto L13;
        UIBody r102 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r102 == null) goto L13;
        if (r102.getLynxContext() == null) goto L13;
        if (r102.getLynxContext().getTouchEventDispatcher() == null) goto L13;
        r102.getLynxContext().getTouchEventDispatcher().B();
        goto L13
    }

    public final EventEmitter l() {
        return this.f381967a.getContext().getEventEmitter();
    }

    public final void D() {
        int r100 = ViewConfiguration.getLongPressTimeout();
        if (this.f381967a.getContext().getLongPressDuration() < 0) goto L5;
        r100 = this.f381967a.getContext().getLongPressDuration();
    L5:
        this.f381968b.getClass();
        k.f382091n = r100;
    }

    public b1(LynxUIOwner r100) {
        this.f381978l = EventTarget.EnableStatus.Undefined;
        this.f381979m = false;
        this.A = 0;
        this.I = false;
        this.f381966J = false;
        this.f381967a = r100;
        c r101 = new c(this);
        this.f381968b = new k(r100.getContext(), r101, new Handler(Looper.getMainLooper()));
        this.f381974h = new LinkedList();
        this.f381976j = new LinkedList();
        this.f381980n = new PointF(Float.MIN_VALUE, Float.MIN_VALUE);
        this.F = new LynxTouchEvent.a();
        this.f381981o = com.lynx.tasm.utils.i.b(50.0f, 0.0f);
        this.f381984r = true;
        this.f381987u = new HashSet();
        this.f381988v = new HashSet();
        this.f381989w = false;
        this.f381991y = false;
        this.f381992z = false;
        this.f381972f = new HashMap();
        this.f381973g = new HashMap();
        this.f381977k = r100.getGestureArenaManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean A(boolean r100) {
        if (this.f381967a.getRootUI() != null) goto L5;
    L9:
        LLog.e("LynxTouchEventDispatcher", "requestNativeDisallowIntercept failed, root ui or root ui'parent is null.");
        return false;
    L5:
        if (((UIBody.UIBodyView) this.f381967a.getRootUI().getView()).getParent() == null) goto L9;
        ((UIBody.UIBodyView) this.f381967a.getRootUI().getView()).getParent().requestDisallowInterceptTouchEvent(r100);
        return r100;
    }

    public final int c(EventTarget r100) {
        return d(r100, this.f381987u);
    }

    public final boolean e(MotionEvent r100) {
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 != 0) goto L5;
        this.f381978l = EventTarget.EnableStatus.Undefined;
        this.f381979m = false;
        EventTarget r103 = this.f381969c;
        if (r103 == null) goto L42;
    L35:
        if (r103 == null) goto L42;
        if (r103.parent() == r103) goto L42;
        if (r103.hasConsumeSlideEventAngles() == false) goto L41;
        this.f381979m = true;
    L41:
        r103 = r103.parent();
    L42:
        boolean r104 = this.f381979m;
        if (r104 == false) goto L45;
        A(r104);
    L45:
        return false;
    L5:
        if (r101 != 2) goto L28;
        if (this.f381979m == true) goto L10;
        return false;
    L10:
        float r105 = r100.getX() - this.f381980n.x;
        float r106 = r100.getY() - this.f381980n.y;
        if (Math.abs(r105) > com.lynx.tasm.utils.i.b(10.0f, 0.0f)) goto L17;
        if (Math.abs(r106) > com.lynx.tasm.utils.i.b(10.0f, 0.0f)) goto L17;
        A(true);
        return false;
    L17:
        if (this.f381978l != EventTarget.EnableStatus.Undefined) goto L28;
        this.f381978l = EventTarget.EnableStatus.Disable;
        double r107 = (Math.atan2(r106, r105) * ((double) 180.0f)) / 3.141592653589793d;
        EventTarget r108 = this.f381969c;
    L20:
        if (r108 == null) goto L28;
        if (r108.parent() == r108) goto L28;
        if (r108.consumeSlideEvent((float) r107) == true) goto L25;
        r108 = r108.parent();
        goto L20
    L25:
        this.f381978l = EventTarget.EnableStatus.Enable;
    L28:
        if (this.f381978l == EventTarget.EnableStatus.Enable) goto L32;
        r102 = false;
    L32:
        return A(r102);
    }

    public final void g(int r100) {
        if (l() != null) goto L5;
        return;
    L5:
        Iterator<EventTarget> r101 = this.f381974h.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        EventTarget r102 = r101.next();
        if (this.f381989w == false) goto L11;
        l().onPseudoStatusChanged(r102.getSign(), r102.getPseudoStatus(), r102.getPseudoStatus() & (~r100));
    L11:
        r102.onPseudoStatusChanged(r102.getPseudoStatus(), r102.getPseudoStatus() & (~r100));
        goto L7
    }

    public final void h(MotionEvent r100) {
        EventTarget r101 = this.f381969c;
        if (r101 == null) goto L5;
        r101.dispatchTouch(r100);
    L5:
        EventTarget r102 = this.f381969c;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.getChildrenLynxPageUI() == null) goto L24;
        UIBody r103 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r103.getLynxContext().getTouchEventDispatcher() == null) goto L27;
        PointF r104 = w(r100);
        r103.getLynxContext().getTouchEventDispatcher().h(r100);     // Catch: Throwable -> L18
        r100.setLocation(r104.x, r104.y);
        return;
    L18:
        th = move-exception;
        r100.setLocation(r104.x, r104.y);
        throw th;
    L27:
        return;
    }

    public final void k(MotionEvent r210) {
        q7a.b r100 = this.f381977k;
        if (r100 == null) goto L71;
        LynxTouchEvent r110 = this.C;
        if (r100.d() == false) goto L71;
        t7a.d r111 = r100.f531996h;
        if (r111 == null) goto L71;
        LinkedList<p7a.a> r112 = r100.f531990b;
        LinkedList<p7a.a> r101 = r100.f531991c;
        int r102 = r210.getActionMasked();
        int r113 = 0;
        if (r102 == 0) goto L43;
        if (r102 != 1) goto L14;
    L25:
        r111.b(r111.f544929j, r210.getX(), r210.getY(), null, r112, r210);
        VelocityTracker r103 = r111.f544925f;
        if (r103 == null) goto L28;
        r103.computeCurrentVelocity(1000);
        r113 = com.lynx.tasm.behavior.ui.utils.h.h(r111.f544921b, r111.f544925f.getXVelocity());
        int r104 = com.lynx.tasm.behavior.ui.utils.h.h(r111.f544921b, r111.f544925f.getYVelocity());
    L30:
        if (r111.f544929j != null) goto L32;
    L41:
        r111.b(r111.f544929j, Float.MIN_VALUE, Float.MIN_VALUE, null, r112, null);
        goto L71
    L32:
        if (Math.abs(r113) <= 300) goto L34;
    L35:
        p7a.a r105 = r111.f544929j;
        if (r105 == null) goto L71;
        if (r111.f544925f == null) goto L71;
        r111.f544931l = r105;
        r111.f544920a.fling(r105.getMemberScrollX(), r111.f544931l.getMemberScrollY(), (int) (-r111.f544925f.getXVelocity()), (int) (-r111.f544925f.getYVelocity()), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        r111.f544931l.onInvalidate();
        r111.f544922c = r111.f544931l.getMemberScrollX();
        r111.f544923d = r111.f544931l.getMemberScrollY();
        goto L71
    L34:
        if (Math.abs(r104) <= 300) goto L41;
    L28:
        r104 = 0;
        goto L30
    L14:
        if (r102 != 2) goto L16;
        VelocityTracker r106 = r111.f544925f;
        if (r106 == null) goto L21;
        r106.addMovement(r210);
    L21:
        p7a.a r107 = r111.e(r112, r111.f544929j);
        r111.f544929j = r107;
        if (r107 != r111.f544930k) goto L24;
        r111.b(r107, r210.getX(), r210.getY(), r110, null, r210);
    L24:
        r111.c(r110, r112, r210.getX(), r210.getY(), r210);
        goto L71
    L16:
        if (r102 == 3) goto L25;
    L43:
        if (r112 == null) goto L50;
        Iterator<p7a.a> r108 = r112.iterator();
    L47:
        if (r108.hasNext() == false) goto L49;
        r111.g(r108.next());
        goto L47
    L49:
        r111.f544928i = null;
    L50:
        if (r101 == null) goto L66;
        Iterator<p7a.a> r109 = r101.iterator();
    L54:
        if (r109.hasNext() == false) goto L66;
        p7a.a r114 = r109.next();
        if (r111.f544929j == null) goto L60;
        if (r111.f544924e != r114.getGestureArenaMemberId()) goto L60;
    L61:
        r111.f544924e = 0;
        if (r111.f544920a.isFinished() == true) goto L66;
        r111.b(r111.f544929j, 0.0f, 0.0f, r110, r112, r210);
        r111.f544920a.abortAnimation();
        LynxContext r115 = r111.f544921b;
        if (r115 == null) goto L66;
        r115.onGestureRecognized();
    L60:
        if (r111.f544924e != 0) goto L54;
    L66:
        r111.b(r111.f544929j, r210.getX(), r210.getY(), r110, r112, r210);
        r111.c(r110, r112, r210.getX(), r210.getY(), r210);
        VelocityTracker r116 = r111.f544925f;
        if (r116 != null) goto L69;
        r111.f544925f = VelocityTracker.obtain();
    L70:
        r111.f544925f.addMovement(r210);
        goto L71
    L69:
        r116.clear();
    L71:
        EventTarget r117 = this.f381969c;
        if (r117 != null) goto L74;
        return;
    L74:
        if (r117.getChildrenLynxPageUI() == null) goto L95;
        UIBody r118 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r118 != null) goto L78;
        return;
    L78:
        if (r118.getLynxContext() != null) goto L80;
        return;
    L80:
        if (r118.getLynxContext().getTouchEventDispatcher() == null) goto L98;
        PointF r119 = w(r210);
        r118.getLynxContext().getTouchEventDispatcher().k(r210);     // Catch: Throwable -> L84
        r210.setLocation(r119.x, r119.y);
        return;
    L84:
        th = move-exception;
        r210.setLocation(r119.x, r119.y);
        throw th;
    L98:
        return;
    }

    public final void n(MotionEvent r100) {
        if (this.f381976j.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.f381976j.getLast() == null) goto L54;
        int r101 = c(this.f381976j.getLast());
        int r102 = d(this.f381976j.getLast(), this.f381988v);
        if (this.f381992z == false) goto L12;
        if (this.f381991y == false) goto L12;
        return;
    L12:
        if (this.f381986t == false) goto L14;
        return;
    L14:
        if (this.f381985s == false) goto L16;
        return;
    L16:
        if (this.f381976j.isEmpty() == false) goto L18;
        return;
    L18:
        if (this.f381976j.getLast() != null) goto L20;
        return;
    L20:
        if (r101 != (-1)) goto L46;
        if (r102 != (-1)) goto L47;
        i(this.f381976j.getLast(), "click", r100);
        EventTarget r103 = this.f381969c;
        if (r103 != null) goto L25;
        return;
    L25:
        if (r103.getChildrenLynxPageUI() == null) goto L49;
        UIBody r104 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r104 != null) goto L29;
        return;
    L29:
        if (r104.getLynxContext() != null) goto L31;
        return;
    L31:
        if (r104.getLynxContext().getTouchEventDispatcher() == null) goto L52;
        PointF r105 = w(r100);
        r104.getLynxContext().getTouchEventDispatcher().n(r100);     // Catch: Throwable -> L35
        r100.setLocation(r105.x, r105.y);
        return;
    L35:
        th = move-exception;
        r100.setLocation(r105.x, r105.y);
        throw th;
    L52:
        return;
    L49:
        return;
    L47:
        return;
    L46:
        return;
    }

    public final void o(MotionEvent r100) {
        LynxUIOwner r101 = this.f381967a;
        l r102 = null;
        if (r101 == null) goto L11;
        LynxContext r103 = r101.getContext();
        if (r103 == null) goto L11;
        if (r103.isFragmentLayerRenderOn() == false) goto L11;
        r102 = this.f381967a.getPaintingContext();
    L11:
        if (r102 == null) goto L14;
        r102.e();
        return;
    L14:
        int r104 = c(this.f381969c);
        int r105 = d(this.f381969c, this.f381988v);
        if (this.f381992z == true) goto L17;
    L18:
        EventTarget r106 = this.f381969c;
        if (r106 != null) goto L21;
        return;
    L21:
        if (r104 != (-1)) goto L43;
        if (r105 != (-1)) goto L44;
        i(r106, "longpress", r100);
        EventTarget r107 = this.f381969c;
        if (r107 != null) goto L26;
        return;
    L26:
        if (r107.getChildrenLynxPageUI() == null) goto L46;
        UIBody r108 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r108 != null) goto L30;
        return;
    L30:
        if (r108.getLynxContext() != null) goto L32;
        return;
    L32:
        if (r108.getLynxContext().getTouchEventDispatcher() == null) goto L49;
        PointF r109 = w(r100);
        r108.getLynxContext().getTouchEventDispatcher().o(r100);     // Catch: Throwable -> L36
        r100.setLocation(r109.x, r109.y);
        return;
    L36:
        th = move-exception;
        r100.setLocation(r109.x, r109.y);
        throw th;
    L49:
        return;
    L46:
        return;
    L44:
        return;
    L43:
        return;
    L17:
        if (this.f381991y == false) goto L18;
    }

    public final void p(MotionEvent r100) {
        int r101 = c(this.f381969c);
        int r102 = d(this.f381969c, this.f381988v);
        if (this.f381992z == false) goto L7;
        if (this.f381991y == false) goto L7;
    L33:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L35;
        C("LynxTouchEventDispatcher: tap failed due to [gesture] " + this.f381985s + ", [move] " + this.f381982p + ", [slide] " + r101 + ", [props] " + r102, LogBoxLogLevel.Warn.ordinal());
    L35:
        LLog.i("LynxTouchEventDispatcher", "tap failed:" + this.f381985s + " " + this.f381982p + " " + r101 + " " + r102);
        return;
    L7:
        if (this.f381985s == true) goto L33;
        if (this.f381982p == true) goto L33;
        if (r101 != (-1)) goto L33;
        if (r102 != (-1)) goto L33;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L16;
        C("LynxTouchEventDispatcher: fire tap for target " + this.f381969c.getSign(), LogBoxLogLevel.Info.ordinal());
    L16:
        i(this.f381969c, "tap", r100);
        EventTarget r103 = this.f381969c;
        if (r103 != null) goto L19;
        return;
    L19:
        if (r103.getChildrenLynxPageUI() == null) goto L40;
        UIBody r104 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r104 != null) goto L23;
        return;
    L23:
        if (r104.getLynxContext() != null) goto L25;
        return;
    L25:
        if (r104.getLynxContext().getTouchEventDispatcher() == null) goto L43;
        PointF r105 = w(r100);
        r104.getLynxContext().getTouchEventDispatcher().p(r100);     // Catch: Throwable -> L29
        r100.setLocation(r105.x, r105.y);
        return;
    L29:
        th = move-exception;
        r100.setLocation(r105.x, r105.y);
        throw th;
    L43:
        return;
    }

    public final void r(MotionEvent r100) {
        EventTarget r101 = this.f381969c;
        if (r101 == null) goto L36;
        if (r101.ignoreFocus() == true) goto L36;
        if (this.f381985s == true) goto L36;
        if (c(this.f381969c) != (-1)) goto L36;
        if (d(this.f381969c, this.f381988v) != (-1)) goto L36;
        EventTarget r102 = this.f381975i;
        EventTarget r103 = this.f381969c;
        this.f381975i = r103;
        if (r103 == r102) goto L36;
        boolean r104 = true;
        if (r103 != null) goto L17;
    L25:
        if (r102 == null) goto L36;
        if (r102.isFocusable() == false) goto L36;
        EventTarget r105 = this.f381969c;
        if (r105 != null) goto L31;
    L33:
        r104 = false;
    L34:
        r102.onFocusChanged(false, r104);
        goto L36
    L31:
        if (r105.isFocusable() == false) goto L33;
    L17:
        if (r103.isFocusable() == false) goto L25;
        EventTarget r106 = this.f381969c;
        if (r102 != null) goto L21;
    L23:
        boolean r107 = false;
    L24:
        r106.onFocusChanged(true, r107);
        goto L25
    L21:
        if (r102.isFocusable() == false) goto L23;
        r107 = true;
    L36:
        if (this.f381992z == false) goto L38;
        JavaOnlyMap r108 = new JavaOnlyMap();
        b(r108, r100, 0);
        j(LynxTouchEvent.EVENT_TOUCH_END, r100, r108);
    L39:
        g(-1);
        EventTarget r109 = this.f381969c;
        if (r109 != null) goto L42;
        return;
    L42:
        if (r109.getChildrenLynxPageUI() == null) goto L58;
        UIBody r110 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r110 != null) goto L46;
        return;
    L46:
        if (r110.getLynxContext() != null) goto L48;
        return;
    L48:
        if (r110.getLynxContext().getTouchEventDispatcher() == null) goto L61;
        PointF r111 = w(r100);
        r110.getLynxContext().getTouchEventDispatcher().r(r100);     // Catch: Throwable -> L52
        r100.setLocation(r111.x, r111.y);
        return;
    L52:
        th = move-exception;
        r100.setLocation(r111.x, r111.y);
        throw th;
    L61:
        return;
    L58:
        return;
    L38:
        i(this.f381969c, LynxTouchEvent.EVENT_TOUCH_END, r100);
        goto L39
    }

    public final void t(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (this.f381992z == true) goto L5;
    L8:
        this.f381972f.remove(Integer.valueOf(r100.getPointerId(r101)));
        EventTarget r102 = this.f381969c;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.getChildrenLynxPageUI() == null) goto L27;
        UIBody r103 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.getLynxContext() != null) goto L17;
        return;
    L17:
        if (r103.getLynxContext().getTouchEventDispatcher() == null) goto L30;
        PointF r104 = w(r100);
        r103.getLynxContext().getTouchEventDispatcher().t(r100);     // Catch: Throwable -> L21
        r100.setLocation(r104.x, r104.y);
        return;
    L21:
        th = move-exception;
        r100.setLocation(r104.x, r104.y);
        throw th;
    L30:
        return;
    L27:
        return;
    L5:
        if (r100.getPointerId(r101) != 0) goto L7;
        g(-1);
    L7:
        JavaOnlyMap r105 = new JavaOnlyMap();
        b(r105, r100, r101);
        j(LynxTouchEvent.EVENT_TOUCH_END, r100, r105);
        goto L8
    }

    public final void u(MotionEvent r100) {
        if (this.f381992z == false) goto L9;
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<b> r102 = this.f381972f.values().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        b r103 = r102.next();
        b(r101, r100, 0);
        goto L6
    L8:
        j(LynxTouchEvent.EVENT_TOUCH_CANCEL, r100, r101);
    L10:
        g(-1);
        EventTarget r104 = this.f381969c;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.getChildrenLynxPageUI() == null) goto L30;
        UIBody r105 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.getLynxContext() != null) goto L19;
        return;
    L19:
        if (r105.getLynxContext().getTouchEventDispatcher() == null) goto L33;
        PointF r106 = w(r100);
        r105.getLynxContext().getTouchEventDispatcher().u(r100);     // Catch: Throwable -> L23
        r100.setLocation(r106.x, r106.y);
        return;
    L23:
        th = move-exception;
        r100.setLocation(r106.x, r106.y);
        throw th;
    L33:
        return;
    L30:
        return;
    L9:
        i(this.f381969c, LynxTouchEvent.EVENT_TOUCH_CANCEL, r100);
        goto L10
    }

    public final void v(MotionEvent r100) {
        int r101 = 0;
        if (this.f381984r == false) goto L11;
        float r102 = r100.getX(0) - this.f381980n.x;
        float r103 = r100.getY(0) - this.f381980n.y;
        if (Math.abs(r102) <= 0.0f) goto L7;
    L10:
        this.f381984r = false;
        goto L11
    L7:
        if (Math.abs(r103) > 0.0f) goto L10;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L26;
        this.f381983q = true;
        if (this.f381992z == false) goto L24;
        JavaOnlyMap r105 = new JavaOnlyMap();
    L17:
        if (r101 >= r100.getPointerCount()) goto L22;
        if (y(r100, r101) == false) goto L21;
        b(r105, r100, r101);
    L21:
        r101 = r101 + 1;
        goto L17
    L22:
        j(LynxTouchEvent.EVENT_TOUCH_MOVE, r100, r105);
        goto L26
    L24:
        if (y(r100, 0) == false) goto L26;
        i(this.f381969c, LynxTouchEvent.EVENT_TOUCH_MOVE, r100);
    L26:
        EventTarget r106 = this.f381969c;
        if (r106 != null) goto L29;
        return;
    L29:
        if (r106.getChildrenLynxPageUI() == null) goto L48;
        UIBody r107 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r107 != null) goto L33;
        return;
    L33:
        if (r107.getLynxContext() != null) goto L35;
        return;
    L35:
        if (r107.getLynxContext().getTouchEventDispatcher() == null) goto L51;
        PointF r108 = w(r100);
        r107.getLynxContext().getTouchEventDispatcher().v(r100);     // Catch: Throwable -> L39
        r100.setLocation(r108.x, r108.y);
        return;
    L39:
        th = move-exception;
        r100.setLocation(r108.x, r108.y);
        throw th;
    L51:
        return;
    L48:
        return;
    L11:
        r104 = true;
        goto L12
    }

    public final PointF w(MotionEvent r100) {
        PointF r101 = new PointF(r100.getX(), r100.getY());
        r100.setLocation(this.C.getViewPoint().f383322a, this.C.getViewPoint().f383323b);
        return r101;
    }

    public static int d(EventTarget r100, HashSet r101) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r101 != null) goto L7;
    L16:
        return -1;
    L7:
        if (r101.isEmpty() == true) goto L16;
    L9:
        if (r100 == null) goto L16;
        if (r100.parent() == r100) goto L16;
        if (r101.contains(Integer.valueOf(r100.getSign())) == true) goto L21;
        r100 = r100.parent();
        goto L9
    L21:
        return r100.getSign();
    }

    public final void C(String r100, int r101) {
        if (this.f381967a.getRootUI() != null) goto L5;
        return;
    L5:
        if (this.f381967a.getRootUI().getBodyView() == null) goto L13;
        LynxBaseInspectorController r102 = ((LynxView) this.f381967a.getRootUI().getBodyView()).getBaseInspectorController();
        if (r102 != null) goto L10;
        return;
    L10:
        r102.showMessageOnConsole(r100, r101);
        return;
    }

    public final LynxTouchEvent.a f(EventTarget r100, LynxTouchEvent.a r101) {
        if ((r100 instanceof LynxBaseUI) == false) goto L10;
        LynxBaseUI r102 = (LynxBaseUI) r100;
        if (this.f381967a.getContext().getEnableTransformedTouchPosition() == false) goto L8;
        PointF r103 = com.lynx.tasm.behavior.ui.utils.h.a(this.f381967a.getRootUI(), r102, new PointF(r101.f383322a, r101.f383323b));
        return new LynxTouchEvent.a(r103.x, r103.y);
    L8:
        RectF r104 = com.lynx.tasm.behavior.ui.utils.h.e(r102, new RectF(0.0f, 0.0f, r102.getWidth(), r102.getHeight()));
        return new LynxTouchEvent.a(r101.f383322a - r104.left, r101.f383323b - r104.top);
    L10:
        return r101;
    }

    public final boolean q(MotionEvent r110, UIGroup r210) {
        LynxTouchEvent.a r100 = this.F;
        r100.f383322a = 0.0f;
        r100.f383323b = 0.0f;
        this.f381969c = m(r110, 0, r210);
        LynxTouchEvent.a r101 = new LynxTouchEvent.a(r110.getX(), r110.getY());
        this.F = r101;
        EventTarget r102 = this.f381969c;
        if ((r102 instanceof LynxBaseUI) == false) goto L5;
        this.F = f(r102, r101);
    L5:
        EventTarget r103 = this.f381969c;
        if (r103 == null) goto L10;
        LynxTouchEvent.a r104 = this.F;
        if (r103.eventThrough(r104.f383322a, r104.f383323b) == false) goto L10;
        return false;
    L10:
        this.f381982p = false;
        this.f381983q = false;
        this.f381984r = true;
        this.f381980n = new PointF(r110.getX(), r110.getY());
        this.f381985s = false;
        new PointF(r110.getX(), r110.getY());
        this.f381987u.clear();
        this.f381988v.clear();
        this.f381991y = false;
        this.f381972f.clear();
        this.f381973g.clear();
        this.f381976j.clear();
        EventTarget r105 = this.f381969c;
        if (r105 == null) goto L30;
    L13:
        if (r105 == null) goto L16;
        this.f381976j.push(r105);
        r105 = r105.parent();
    L16:
        if (this.f381976j.isEmpty() == true) goto L22;
        if (this.f381976j.getLast().getEvents() == null) goto L21;
        if (this.f381976j.getLast().getEvents().containsKey("click") == true) goto L22;
    L21:
        this.f381976j.removeLast();
    L22:
        Iterator<EventTarget> r106 = this.f381976j.iterator();
    L24:
        if (r106.hasNext() == false) goto L27;
        r106.next().onResponseChain();
        goto L24
    L27:
        if (this.f381976j.isEmpty() == false) goto L29;
        this.f381986t = true;
        goto L30
    L29:
        this.f381986t = false;
    L30:
        this.f381966J = false;
        EventTarget r107 = this.f381971e;
        if (r107 == null) goto L33;
        r107.setPanInterceptSelf(false);
        this.f381971e.setPanInterceptAncestors(false);
        this.f381971e.setPanInterceptDescendants(false);
    L33:
        List r108 = null;
        this.f381971e = null;
        this.f381970d = null;
        EventTarget r109 = this.f381969c;
        if (r109 == null) goto L45;
    L35:
        if (r109 == null) goto L42;
        if (r109.parent() == r109) goto L42;
        if (r109.panInterceptDirection() != EventTarget.PanInterceptDirection.None) goto L40;
        r109 = r109.parent();
        goto L35
    L40:
        this.f381970d = r109;
    L42:
        EventTarget r111 = this.f381970d;
        if (r111 == null) goto L45;
        r111.setPanInterceptAncestors(true);
    L45:
        this.f381972f.put(Integer.valueOf(r110.getPointerId(0)), new b(this.f381969c, r110.getX(0), r110.getY(0)));
        this.f381973g.put(Integer.valueOf(this.f381969c.getSign()), this.f381969c);
        q7a.b r112 = this.f381977k;
        if (r112 == null) goto L189;
        EventTarget r113 = this.f381969c;
        if (r112.d() == false) goto L189;
        r112.f531995g = null;
        LinkedList<p7a.a> r114 = r112.f531991c;
        if (r114 == null) goto L53;
        r114.clear();
    L53:
        LinkedList<p7a.a> r115 = r112.f531990b;
        if (r115 == null) goto L56;
        r115.clear();
    L56:
        Map<Integer, WeakReference<p7a.a>> r116 = r112.f531989a;
        if (r116 == null) goto L189;
        if (((HashMap) r116).isEmpty() == true) goto L189;
        if (r112.f531996h == null) goto L189;
    L63:
        if (r113 == null) goto L79;
        Iterator r117 = ((HashMap) r112.f531989a).values().iterator();
    L66:
        if (r117.hasNext() == false) goto L78;
        WeakReference r118 = (WeakReference) r117.next();
        if (r118 == null) goto L66;
        p7a.a r119 = (p7a.a) r118.get();
        if (r119 == null) goto L66;
        if (r119.getGestureArenaMemberId() <= 0) goto L66;
        if (r119.getGestureArenaMemberId() != r113.getGestureArenaMemberId()) goto L66;
        r112.f531991c.add(r119);
        goto L66
    L78:
        r113 = r113.parent();
        goto L63
    L79:
        s7a.b r120 = r112.f531993e;
        if (r120 == null) goto L180;
        LinkedList<p7a.a> r121 = r112.f531991c;
        LinkedList<p7a.a> r122 = new LinkedList();
        if (r121 != null) goto L84;
    L179:
        r112.f531990b = r122;
        goto L180
    L84:
        if (r121.isEmpty() == true) goto L179;
        int r123 = 0;
    L88:
        if (r123 >= r121.size()) goto L179;
        p7a.a r124 = r121.get(r123);
        Map<Integer, s7a.a> r125 = r124.getGestureDetectorMap();
        if (r125 != null) goto L92;
        r122.add(r124);
    L178:
        r123 = r123 + 1;
        r108 = null;
        goto L88
    L92:
        Iterator r126 = new TreeMap(r125).entrySet().iterator();
        List r127 = r108;
        List r128 = r127;
    L94:
        if (r126.hasNext() == false) goto L104;
        Map.Entry r129 = (Map.Entry) r126.next();
        List r130 = (List) ((HashMap) ((s7a.a) r129.getValue()).f540935d).get("waitFor");
        List r131 = (List) ((HashMap) ((s7a.a) r129.getValue()).f540935d).get("continueWith");
        if (r130 != null) goto L98;
    L99:
        if (r131 == null) goto L103;
        if (r131.isEmpty() == true) goto L103;
    L102:
        r128 = r131;
        r127 = r130;
    L103:
        r128 = r131;
        r127 = r130;
        goto L94
    L98:
        if (r130.isEmpty() == false) goto L102;
    L104:
        if (r128 != null) goto L106;
    L107:
        if (r127 != null) goto L109;
    L177:
        r122.add(r124);
        goto L178
    L109:
        if (r127.isEmpty() == true) goto L177;
    L111:
        if (r127 != null) goto L113;
    L149:
        r122.add(r124);
    L150:
        if (r128 == null) goto L178;
        if (r128.isEmpty() == true) goto L178;
        LinkedHashSet r132 = new LinkedHashSet();
        Iterator r133 = r128.iterator();
    L155:
        if (r133.hasNext() == false) goto L160;
        Integer r134 = (Integer) r133.next();
        if (((HashMap) r120.f540937a).get(r134) == null) goto L155;
        r132.addAll((Collection) ((HashMap) r120.f540937a).get(r134));
        goto L155
    L160:
        if (r120.f540937a != null) goto L162;
    L172:
        LinkedList r135 = null;
    L173:
        if (r135 == null) goto L179;
        if (r135.isEmpty() == true) goto L179;
        r122.addAll(r135);
        goto L179
    L162:
        if (r120.f540938b == null) goto L172;
        r135 = new LinkedList();
        Iterator r136 = r132.iterator();
    L166:
        if (r136.hasNext() == false) goto L173;
        Integer r137 = (Integer) r136.next();
        q7a.b r138 = r120.f540938b;
        int r139 = r137.intValue();
        Map<Integer, WeakReference<p7a.a>> r140 = r138.f531989a;
        HashMap r141 = (HashMap) r140;
        WeakReference r142 = (WeakReference) r141.get(Integer.valueOf(r139));
        if (r142 == null) goto L170;
        p7a.a r143 = (p7a.a) r142.get();
    L171:
        r135.add(r143);
        goto L166
    L170:
        r143 = null;
        goto L171
    L113:
        if (r127.isEmpty() == true) goto L149;
        LinkedHashSet r144 = new LinkedHashSet();
        Iterator r145 = r127.iterator();
    L116:
        if (r145.hasNext() == false) goto L120;
        Integer r146 = (Integer) r145.next();
        if (((HashMap) r120.f540937a).get(r146) == null) goto L116;
        r144.addAll((Collection) ((HashMap) r120.f540937a).get(r146));
        goto L116
    L120:
        int r147 = r121.lastIndexOf(r124);
        if (r147 >= 0) goto L123;
    L136:
        LinkedList r148 = null;
    L137:
        if (r148 != null) goto L139;
    L148:
        r122.add(r124);
        goto L178
    L139:
        if (r148.isEmpty() == true) goto L148;
        Iterator r149 = r148.iterator();
    L143:
        if (r149.hasNext() == false) goto L147;
        Integer r150 = (Integer) r149.next();
        if (r121.get(r150.intValue()) == null) goto L143;
        r122.add(r121.get(r150.intValue()));
        goto L143
    L147:
        r122.add(r124);
        r123 = r121.size();
        goto L150
    L123:
        if (r147 >= r121.size()) goto L136;
        r148 = new LinkedList();
        Iterator r151 = r144.iterator();
    L127:
        if (r151.hasNext() == false) goto L137;
        int r152 = ((Integer) r151.next()).intValue();
        int r153 = r147 + 1;
    L130:
        if (r153 >= r121.size()) goto L127;
        if (r152 != r121.get(r153).getGestureArenaMemberId()) goto L134;
        r148.add(Integer.valueOf(r153));
    L134:
        r153 = r153 + 1;
        goto L130
    L106:
        if (r128.isEmpty() == false) goto L111;
    L180:
        LinkedList<p7a.a> r154 = r112.f531990b;
        if (r154 != null) goto L183;
    L185:
        t7a.d r155 = r112.f531996h;
        p7a.a r156 = r112.f531995g;
        r155.f544929j = r156;
        if (r155.f544930k == r156) goto L188;
        r155.f544930k = r156;
    L188:
        r155.h(r156);
        r155.g(r155.f544929j);
        r155.f544933n = new r7a.a();
        goto L189
    L183:
        if (r154.isEmpty() == true) goto L185;
        r112.f531995g = r112.f531990b.getFirst();
    L189:
        D();
        if (this.f381992z == false) goto L192;
        JavaOnlyMap r157 = new JavaOnlyMap();
        b(r157, r110, 0);
        j(LynxTouchEvent.EVENT_TOUCH_START, r110, r157);
    L194:
        if (l() == null) goto L210;
        EventTarget r158 = this.f381969c;
    L197:
        if (r158 == null) goto L202;
        this.f381974h.push(r158);
        if (r158.enableTouchPseudoPropagation() == false) goto L202;
        r158 = r158.parent();
    L202:
        int r159 = 0;
    L204:
        if (r159 >= this.f381974h.size()) goto L210;
        EventTarget r160 = this.f381974h.get(r159);
        if (this.f381989w == false) goto L208;
        int r161 = 0;
        l().onPseudoStatusChanged(r160.getSign(), 0, 8);
    L209:
        r160.onPseudoStatusChanged(r161, 8);
        r159 = r159 + 1;
        goto L204
    L208:
        r161 = 0;
    L210:
        EventTarget r162 = this.f381969c;
        if (r162 != null) goto L213;
    L226:
        return true;
    L213:
        if (r162.getChildrenLynxPageUI() == null) goto L226;
        UIGroup r163 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r163 == null) goto L226;
        if (r163.getLynxContext() == null) goto L226;
        if (r163.getLynxContext().getTouchEventDispatcher() == null) goto L226;
        PointF r164 = w(r110);
        r163.getLynxContext().getTouchEventDispatcher().q(r110, r163);     // Catch: Throwable -> L223
        r110.setLocation(r164.x, r164.y);
    L223:
        th = move-exception;
        r110.setLocation(r164.x, r164.y);
        throw th;
    L192:
        i(this.f381969c, LynxTouchEvent.EVENT_TOUCH_START, r110);
        goto L194
    }

    public final void s(MotionEvent r100, UIGroup r101) {
        this.f381991y = true;
        int r102 = r100.getActionIndex();
        EventTarget r103 = m(r100, r102, r101);
        this.f381972f.put(Integer.valueOf(r100.getPointerId(r102)), new b(r103, r100.getX(r102), r100.getY(r102)));
        this.f381973g.put(Integer.valueOf(r103.getSign()), r103);
        if (this.f381992z == false) goto L5;
        JavaOnlyMap r104 = new JavaOnlyMap();
        b(r104, r100, r102);
        j(LynxTouchEvent.EVENT_TOUCH_START, r100, r104);
    L5:
        EventTarget r105 = this.f381969c;
        if (r105 != null) goto L8;
        return;
    L8:
        if (r105.getChildrenLynxPageUI() == null) goto L24;
        UIGroup r106 = (UIBody) this.f381969c.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.f381969c)));
        if (r106 != null) goto L12;
        return;
    L12:
        if (r106.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r106.getLynxContext().getTouchEventDispatcher() == null) goto L27;
        PointF r107 = w(r100);
        r106.getLynxContext().getTouchEventDispatcher().s(r100, r106);     // Catch: Throwable -> L18
        r100.setLocation(r107.x, r107.y);
        return;
    L18:
        th = move-exception;
        r100.setLocation(r107.x, r107.y);
        throw th;
    L27:
        return;
    }

    public final boolean x(MotionEvent r100, UIGroup r101) {
        LynxUIOwner r102 = this.f381967a;
        if (r102 != null) goto L5;
    L4:
        l r103 = null;
    L12:
        if (r103 == null) goto L30;
        if (r101 == null) goto L15;
        int r104 = r101.getSign();
    L20:
        if (r103.c(r100, r104) == true) goto L23;
        return false;
    L23:
        if (r100.getActionMasked() != 0) goto L26;
        D();
    L28:
        this.f381968b.b(r100);
        return true;
    L26:
        if (r100.getActionMasked() != 1) goto L28;
        r103.i();
        r103.f();
        goto L28
    L15:
        LynxUIOwner r105 = this.f381967a;
        if (r105 == null) goto L18;
        r104 = r105.getRootSign();
        goto L20
    L18:
        r104 = -1;
        goto L20
    L30:
        this.A = System.currentTimeMillis();
        if (r100.getActionMasked() != 0) goto L46;
        if (r101 == null) goto L34;
        UIGroup r106 = r101;
    L35:
        this.G = r106;
        if (r101 != null) goto L38;
    L40:
        boolean r107 = false;
    L41:
        this.H = r107;
        this.I = false;
        if (q(r100, this.G) == true) goto L74;
        this.G = null;
        this.H = false;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        return false;
    L74:
        boolean r108 = false;
    L75:
        EventTarget r109 = this.f381969c;
        if (r109 == null) goto L83;
        LynxTouchEvent.a r110 = this.F;
        if (r109.eventThrough(r110.f383322a, r110.f383323b) == false) goto L83;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        if (r108 == false) goto L82;
        B();
    L82:
        return false;
    L83:
        h(r100);
        this.f381968b.b(r100);
        k(r100);
        if (r108 == false) goto L86;
        B();
    L86:
        return true;
    L38:
        if (r101 == this.f381967a.getRootUI()) goto L40;
        r107 = true;
        goto L41
    L34:
        r106 = this.f381967a.getRootUI();
        goto L35
    L46:
        if (r100.getActionMasked() != 5) goto L53;
        UIGroup r111 = this.G;
        if (r111 != null) goto L51;
        r111 = this.f381967a.getRootUI();
    L51:
        s(r100, r111);
        goto L74
    L53:
        if (this.f381969c == null) goto L74;
        if (this.f381972f.isEmpty() == true) goto L74;
        EventTarget r112 = this.f381969c;
        LynxTouchEvent.a r113 = this.F;
        if (r112.eventThrough(r113.f383322a, r113.f383323b) == false) goto L60;
        LLog.i("LynxTouchEventDispatcher", "hit event through");
        return false;
    L60:
        int r114 = r100.getActionMasked();
        if (r114 != 1) goto L63;
        r(r100);
        n(r100);
        p(r100);
    L73:
        r108 = true;
        goto L75
    L63:
        if (r114 != 2) goto L65;
        v(r100);
        goto L74
    L65:
        if (r114 != 3) goto L67;
        u(r100);
        goto L73
    L67:
        if (r114 != 6) goto L74;
        t(r100);
        goto L74
    L5:
        LynxContext r115 = r102.getContext();
        if (r115 == null) goto L4;
        if (r115.isFragmentLayerRenderOn() == false) goto L4;
        r103 = this.f381967a.getPaintingContext();
        goto L12
    }

    public final boolean y(MotionEvent r110, int r111) {
        b r100 = this.f381972f.get(Integer.valueOf(r110.getPointerId(r111)));
        boolean r101 = true;
        if (r100 == null) goto L67;
        PointF r102 = r100.f381996c;
        PointF r103 = r100.f381995b;
        if (this.f381992z == true) goto L8;
        r103 = this.f381980n;
    L8:
        if (r102.x != r110.getX(r111)) goto L14;
        if (r102.y != r110.getY(r111)) goto L14;
        boolean r104 = false;
        boolean r105 = false;
    L66:
        r100.f381996c = r102;
    L68:
        if (r104 == false) goto L120;
        UIGroup r106 = this.G;
        if (r106 != null) goto L73;
        r106 = this.f381967a.getRootUI();
    L73:
        EventTarget r112 = m(r110, r111, r106);
        if (this.f381985s == false) goto L76;
    L106:
        this.f381986t = r101;
        if (this.f381974h.isEmpty() == true) goto L113;
        if (this.f381992z == true) goto L113;
        if (this.f381982p == false) goto L113;
    L119:
        g(8);
    L113:
        if (this.f381992z == false) goto L116;
        if (r105 == true) goto L119;
    L116:
        if (c(this.f381969c) != (-1)) goto L119;
        if (d(this.f381969c, this.f381988v) == (-1)) goto L120;
    L76:
        if (this.f381976j.isEmpty() == true) goto L80;
        if (c(this.f381976j.getLast()) != (-1)) goto L106;
    L80:
        if (this.f381986t == true) goto L106;
        LynxUIOwner r113 = this.f381967a;
        if (r113 != null) goto L84;
    L102:
        boolean r114 = true;
    L103:
        if (r114 == true) goto L106;
        r101 = false;
        goto L106
    L84:
        if (r113.getRootUI() == null) goto L102;
        LinkedList r115 = new LinkedList();
    L87:
        if (r112 == null) goto L90;
        r115.push(r112);
        r112 = r112.parent();
        goto L87
    L90:
        if (r115.size() < this.f381976j.size()) goto L102;
        int r116 = 0;
    L94:
        if (r116 >= this.f381976j.size()) goto L101;
        EventTarget r107 = this.f381976j.get(r116);
        if (r107 == null) goto L102;
        if (r107 != r115.get(r116)) goto L102;
        r116 = r116 + 1;
        goto L94
    L101:
        r114 = false;
    L120:
        return r104;
    L14:
        if (Math.abs(r103.x - r110.getX(r111)) <= this.f381981o) goto L16;
    L17:
        this.f381982p = true;
        if (r110.getPointerId(r111) != 0) goto L20;
        r105 = true;
    L22:
        if (r110.getPointerId(r111) != 0) goto L65;
        float r108 = Math.abs(r103.x - r110.getX(r111));
        float r109 = Math.abs(r103.y - r110.getY(r111));
        if (this.f381966J == true) goto L65;
        if (r108 <= 10.0f) goto L28;
    L29:
        this.f381966J = true;
        EventTarget.PanInterceptDirection r117 = EventTarget.PanInterceptDirection.Horizontal;
        if (r108 <= r109) goto L32;
        EventTarget.PanInterceptDirection r118 = EventTarget.PanInterceptDirection.Horizontal;
    L33:
        EventTarget r119 = this.f381970d;
        if (r119 == null) goto L37;
        r119.setPanInterceptAncestors(false);
    L37:
        if (r118 == EventTarget.PanInterceptDirection.None) goto L47;
        EventTarget r120 = this.f381969c;
    L40:
        if (r120 == null) goto L47;
        if (r120.parent() == r120) goto L47;
        if (r120.panInterceptDirection() == r118) goto L48;
        r120 = r120.parent();
    L48:
        this.f381971e = r120;
        if (r120 != null) goto L51;
        EventTarget.PanInterceptScope r121 = EventTarget.PanInterceptScope.None;
    L53:
        if (this.f381971e == null) goto L65;
        if (r121 == EventTarget.PanInterceptScope.None) goto L65;
        switch(a.f381993a[r121.ordinal()]) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            default: goto L65;
        };
    L59:
        this.f381971e.setPanInterceptSelf(true);
        this.f381971e.setPanInterceptAncestors(true);
        this.f381971e.setPanInterceptDescendants(true);
        goto L65
    L60:
        this.f381971e.setPanInterceptSelf(true);
        this.f381971e.setPanInterceptDescendants(true);
        goto L65
    L61:
        this.f381971e.setPanInterceptSelf(true);
        this.f381971e.setPanInterceptAncestors(true);
        goto L65
    L62:
        this.f381971e.setPanInterceptDescendants(true);
        goto L65
    L63:
        this.f381971e.setPanInterceptAncestors(true);
        goto L65
    L64:
        this.f381971e.setPanInterceptSelf(true);
        goto L65
    L51:
        r121 = r120.panInterceptScope();
    L47:
        r120 = null;
        goto L48
    L32:
        r118 = EventTarget.PanInterceptDirection.Vertical;
        goto L33
    L28:
        if (r109 > 10.0f) goto L29;
    L65:
        r102.x = r110.getX(r111);
        r102.y = r110.getY(r111);
        r104 = true;
    L20:
        r105 = false;
        goto L22
    L16:
        if (Math.abs(r103.y - r110.getY(r111)) <= this.f381981o) goto L20;
    L67:
        r104 = false;
        r105 = false;
        goto L68
    }

    public final void z(String r110, MotionEvent r111) {
        LynxUIOwner r100 = this.f381967a;
        if (r100 == null) goto L5;
        LynxContext r101 = r100.getContext();
    L6:
        if (r101 == null) goto L8;
        final int r102 = r101.getInstanceId();
    L10:
        if (LynxFrameRecorder.f383583k.k(r102) == true) goto L13;
        return;
    L13:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r110) == false) goto L16;
        final int r103 = 201;
    L24:
        ArrayList r112 = new ArrayList(r111.getPointerCount());
        int r104 = 0;
    L26:
        if (r104 >= r111.getPointerCount()) goto L35;
        b r105 = this.f381972f.get(Integer.valueOf(r111.getPointerId(r104)));
        if (r105 == null) goto L30;
        EventTarget r106 = r105.f381994a;
    L31:
        if (r106 == null) goto L33;
        Integer r107 = Integer.valueOf(r106.getSign());
    L34:
        r112.add(new LynxFrameRecorder.n(r111.getX(r104), r111.getY(r104), r111.getPointerId(r104), r107));
        r104 = r104 + 1;
        goto L26
    L33:
        r107 = null;
        goto L34
    L30:
        r106 = this.f381969c;
        goto L31
    L35:
        final LynxFrameRecorder r108 = LynxFrameRecorder.f383583k;
        final long r109 = r111.getEventTime();
        r108.getClass();
        final List r113 = Collections.unmodifiableList(new ArrayList(r112));
        final Integer r114 = r108.e(r102);
        if (r114 == null) goto L44;
        r108.f383584a.execute(new com.lynx.tasm.recording.e(r108, r102, r114, r103, r113, r109));
        return;
    L44:
        return;
    L16:
        if (LynxTouchEvent.EVENT_TOUCH_MOVE.equals(r110) == false) goto L19;
        r103 = 202;
        goto L24
    L19:
        if (LynxTouchEvent.EVENT_TOUCH_END.equals(r110) == false) goto L22;
        r103 = 203;
        goto L24
    L22:
        if (LynxTouchEvent.EVENT_TOUCH_CANCEL.equals(r110) == false) goto L43;
        r103 = 204;
        goto L24
    L43:
        return;
    L8:
        r102 = -1;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void b(JavaOnlyMap r110, MotionEvent r111, int r112) {
        b r100 = this.f381972f.get(Integer.valueOf(r111.getPointerId(r112)));
        if (r100 != null) goto L5;
        return;
    L5:
        EventTarget r101 = r100.f381994a;
        String r102 = String.valueOf(r101.getSign());
        ReadableArray r103 = r110.getArray(r102);
        JavaOnlyArray r104 = new JavaOnlyArray();
        LynxTouchEvent.a r105 = new LynxTouchEvent.a(r111.getX(r112), r111.getY(r112));
        if ((r101 instanceof LynxBaseUI) == false) goto L8;
        LynxTouchEvent.a r106 = f(r101, r105);
    L9:
        PointF r107 = com.lynx.tasm.behavior.ui.utils.h.c(this.f381967a.getRootUI(), new PointF(r105.f383322a, r105.f383323b));
        float r108 = r107.x;
        float r109 = r107.y;
        r104.add(Integer.valueOf(r111.getPointerId(r112)));
        r104.add(Float.valueOf(r108));
        r104.add(Float.valueOf(r109));
        r104.add(Float.valueOf(r105.f383322a));
        r104.add(Float.valueOf(r105.f383323b));
        r104.add(Float.valueOf(r106.f383322a));
        r104.add(Float.valueOf(r106.f383323b));
        if (r103 == null) goto L12;
        r103.asArrayList().add(r104);
        return;
    L12:
        JavaOnlyArray r113 = new JavaOnlyArray();
        r113.add(r104);
        r110.putArray(r102, r113);
        return;
    L8:
        r106 = r105;
        goto L9
    }

    public final void i(EventTarget r110, String r111, MotionEvent r112) {
        z(r111, r112);
        this.B = f(this.f381969c, new LynxTouchEvent.a(r112.getX(0), r112.getY(0)));
        LynxTouchEvent.a r100 = new LynxTouchEvent.a(r112.getX(0), r112.getY(0));
        PointF r101 = com.lynx.tasm.behavior.ui.utils.h.c(this.f381967a.getRootUI(), new PointF(r100.f383322a, r100.f383323b));
        LynxTouchEvent r102 = new LynxTouchEvent(r110.getSign(), r111, new LynxTouchEvent.a(r101.x, r101.y), r100, this.B);
        this.C = r102;
        r102.setMotionEvent(r112);
        this.C.setTarget(this.f381969c);
        this.C.setTimestamp(this.A);
        LynxTouchEvent r113 = this.C;
        if (this.H == false) goto L6;
        r113.setEventID(Long.MIN_VALUE);
    L6:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r111) == false) goto L32;
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L29;
        if (this.f381969c == null) goto L29;
        if (this.f381967a.getRootUI() == null) goto L29;
        if (this.f381967a.getRootUI().getBodyView() == null) goto L29;
        LynxBaseInspectorOwner r103 = ((LynxView) this.f381967a.getRootUI().getBodyView()).getBaseInspectorOwner();
        if (r103 == null) goto L29;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L27
        r104.put("id", 1);     // Catch: Exception -> L27
        r104.put(com.alipay.sdk.m.p.e.f25671s, "DOM.setAttributesAsText");     // Catch: Exception -> L27
        if (this.D != null) goto L23;
    L25:
        r104.put(com.alipay.sdk.m.p.e.f25671s, "CSS.getInlineStylesForNode");     // Catch: Exception -> L27
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L27
        r114.put("nodeId", this.f381969c.getSign());     // Catch: Exception -> L27
        r104.put("params", r114);     // Catch: Exception -> L27
        r103.invokeCDPFromSDK(r104.toString(), new z0(this, r104, r114, r103));     // Catch: Exception -> L27
        goto L29
    L23:
        if (this.E == null) goto L25;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L27
        r105.put("nodeId", this.D.getSign());     // Catch: Exception -> L27
        r105.put("text", String.format("style=\"%s\"", new Object[]{this.E}));     // Catch: Exception -> L27
        r105.put("name", "style");     // Catch: Exception -> L27
        r104.put("params", r105);     // Catch: Exception -> L27
        r103.invokeCDPFromSDK(r104.toString(), new y0());     // Catch: Exception -> L27
    L27:
        LLog.e("LynxTouchEventDispatcher", "inspectHitTarget json generate error");
    L29:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L32;
        C("LynxTouchEventDispatcher: hit the target with sign = " + r110.getSign(), LogBoxLogLevel.Info.ordinal());
    L32:
        if (l() != null) goto L35;
        LLog.i("LynxTouchEventDispatcher", "dispatchEvent failed since eventEmitter() null");
        return;
    L35:
        q7a.b r115 = this.f381977k;
        if (r115 == null) goto L38;
        r115.c(r111, this.C);
    L38:
        l().sendTouchEvent(this.C);
    }

    public final void j(String r100, MotionEvent r110, JavaOnlyMap r111) {
        z(r100, r110);
        EventTarget r101 = this.f381969c;
        LynxTouchEvent.a r102 = new LynxTouchEvent.a(r110.getX(), r110.getY());
        PointF r103 = com.lynx.tasm.behavior.ui.utils.h.c(this.f381967a.getRootUI(), new PointF(r102.f383322a, r102.f383323b));
        LynxTouchEvent.a r104 = new LynxTouchEvent.a(r103.x, r103.y);
        LynxTouchEvent r105 = new LynxTouchEvent(r101.getSign(), r100, r104, r102, this.B);
        this.C = r105;
        r105.setMotionEvent(r110);
        LynxTouchEvent r106 = new LynxTouchEvent(r100, r111);
        r106.setMotionEvent(r110);
        r106.setActiveTargetMap(this.f381973g);
        r106.setTarget(this.f381969c);
        r106.setTimestamp(this.A);
        if (this.H == false) goto L5;
        r106.setEventID(Long.MIN_VALUE);
    L5:
        q7a.b r112 = this.f381977k;
        if (r112 == null) goto L8;
        r112.c(r100, this.C);
    L8:
        l().sendMultiTouchEvent(r106);
    }

    public final EventTarget m(MotionEvent r100, int r101, UIGroup r102) {
        if (r102 != null) goto L5;
        r102 = this.f381967a.getRootUI();
    L5:
        return r102.hitTest(r100.getX(r101), r100.getY(r101));
    }

    public static void a(b1 r100, JSONObject r101, JSONObject r102, LynxBaseInspectorOwner r103, String r104) throws JSONException {
        r100.getClass();
        Matcher r105 = PatternProtector.compile("\"cssText\"\\s*:\\s*\"([^\"]*)\"").matcher(r104);
        if (r105.find() == false) goto L5;
        r100.E = r105.group(1);
    L5:
        String r106 = r100.E;
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        String r107 = r106.concat("background-color:#9CC4E6;border-width:2px;border-color:red;");
        r101.put(com.alipay.sdk.m.p.e.f25671s, "DOM.setAttributesAsText");
        r102.put("text", String.format("style=\"%s\"", new Object[]{r107}));
        r102.put("name", "style");
        r101.put("params", r102);
        r103.invokeCDPFromSDK(r101.toString(), new a1());
    }
}
