package com.lynx.animax;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.android.SystemUtils;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter;
import com.lynx.animax.ui.AnimaXContext;
import com.lynx.animax.ui.AnimaXImageView;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.animax.util.LynxAnimaX;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public class UIAnimaX extends LynxUI<View> implements com.lynx.tasm.behavior.j {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final UIAnimaXPropsPrioritySetter.ExecutionPriority f380217p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final UIAnimaXPropsPrioritySetter.ExecutionPriority f380218q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f380219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o4a.b f380220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x4a.g f380221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimaXPlayer f380222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x4a.a f380223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UIAnimaXPropsPrioritySetter f380224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f380226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DisplayMode f380227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f380228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f380229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f380230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f380231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f380232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f380233o;

    public static final enum DisplayMode extends Enum<DisplayMode> {
        public static final DisplayMode AUTO = null;
        public static final DisplayMode IMAGE = null;
        public static final DisplayMode SURFACE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DisplayMode[] f380234a = null;
        private final String value;

        static {
            DisplayMode r100 = new DisplayMode("IMAGE", 0, "image");
            IMAGE = r100;
            DisplayMode r101 = new DisplayMode("SURFACE", 1, "surface");
            SURFACE = r101;
            DisplayMode r102 = new DisplayMode("AUTO", 2, "auto");
            AUTO = r102;
            f380234a = new DisplayMode[]{r100, r101, r102};
        }

        public static DisplayMode[] values() {
            return (DisplayMode[]) f380234a.clone();
        }

        public static /* synthetic */ String access$000(DisplayMode r100) {
            return r100.value;
        }

        public static DisplayMode fromString(String r100) {
            if (r100 == null) goto L4;
            DisplayMode[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L12;
            DisplayMode r104 = r101[r103];
            if (r104.value.equals(r100) == true) goto L9;
            r103 = r103 + 1;
            goto L6
        L9:
            return r104;
        L12:
            return SURFACE;
        L4:
            return SURFACE;
        }

        public static DisplayMode valueOf(String r100) {
            return (DisplayMode) r27.a.a(DisplayMode.class, r100);
        }

        public DisplayMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public UIAnimaX() {
        throw null;
    }

    static {
        f380217p = UIAnimaXPropsPrioritySetter.ExecutionPriority.LOW;
        f380218q = UIAnimaXPropsPrioritySetter.ExecutionPriority.HIGH;
    }

    @Override // com.lynx.tasm.behavior.j
    public final void B() {
        if (this.f380230l == false) goto L5;
        return;
    L5:
        AnimaXPlayer r100 = this.f380222d;
        if (r100 == null) goto L9;
        r100.z(false, VisibilityState.BACKGROUND);
        return;
    }

    public final void O() {
        this.mView.post(new n(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final long getMemoryUsageBytes() {
        AnimaXPlayer r100 = this.f380222d;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.q();
    }

    @Override // com.lynx.tasm.behavior.j
    public final void p() {
        if (this.f380230l == false) goto L5;
        return;
    L5:
        AnimaXPlayer r100 = this.f380222d;
        if (r100 == null) goto L9;
        r100.z(true, VisibilityState.BACKGROUND);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        AnimaXLog.b("UIAnimaX", "UIAnimaX destroy");
        x4a.g r100 = this.f380221c;
        if (r100 == null) goto L5;
        r100.release();
    L8:
        this.f380221c = null;
        this.f380222d = null;
        return;
    L5:
        AnimaXPlayer r101 = this.f380222d;
        if (r101 == null) goto L8;
        r101.s();
        goto L8
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (this.f380223e != null) goto L5;
        return;
    L5:
        if (this.f380221c == null) goto L9;
        int r100 = getBorderLeftWidth() + getPaddingLeft();
        int r101 = getBorderTopWidth() + getPaddingTop();
        int r102 = getBorderRightWidth() + getPaddingRight();
        int r103 = getBorderBottomWidth() + getPaddingBottom();
        this.f380223e.setPadding(r100, r101, r102, r103);
        this.f380221c.requestLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        AnimaXPlayer r100 = this.f380222d;
        if (r100 == null) goto L6;
        r100.t();
        return;
    }

    public UIAnimaX(LynxContext r100) {
        super(r100, null);
        this.f380224f = new UIAnimaXPropsPrioritySetter();
        this.f380225g = false;
        this.f380226h = false;
        this.f380227i = DisplayMode.SURFACE;
        this.f380229k = false;
        this.f380230l = false;
        this.f380231m = false;
        this.f380233o = false;
        this.f380219a = r100;
        if ((this.mView instanceof x4a.a) == true) goto L5;
        O();
    L5:
        this.f380223e = (x4a.a) this.mView;
    }

    public static int[] M(ReadableMap r100) {
        ReadableArray r101 = r100.getArray("frames");
        if (r101 != null) goto L6;
        return null;
    L6:
        int[] r102 = new int[r101.size()];
        int r103 = 0;
    L8:
        if (r103 >= r101.size()) goto L10;
        r102[r103] = r101.getInt(r103);
        r103 = r103 + 1;
        goto L8
    L10:
        return r102;
    }

    public static void N(Callback r100) {
        if (r100 == null) goto L5;
        r100.invoke(new Object[]{1, "animax view is not inited."});
        return;
    }

    public final void P(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L20;
        LynxContext r101 = this.f380219a;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.enableEventReporter() == true) goto L10;
        return;
    L10:
        if (this.f380233o == true) goto L23;
        ILynxTrailService r102 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if (r102 != null) goto L14;
        boolean r103 = false;
    L15:
        if (r103 == false) goto L24;
        this.f380233o = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", this.f380219a.getInstanceId(), new p(r100));
        return;
    L24:
        return;
    L14:
        r103 = "true".equals(r102.stringValueForTrailKey("enable_motion_ui_report"));
        goto L15
    L23:
        return;
    }

    public final void Q(String r100) {
        if (this.f380232n == null) goto L5;
        return;
    L5:
        if (this.f380219a != null) goto L7;
        return;
    L7:
        if (this.mView == 0) goto L16;
        if (r100 != null) goto L11;
        r100 = "unknown";
    L12:
        this.mView.setTag("url: " + v4a.a.a(this.f380219a.getTemplateUrl()) + ", src: " + r100);
        return;
    L11:
        this.f380232n = r100;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if ((r100 instanceof LynxContext) == true) goto L6;
        LLog.e("UIAnimaX", "context is not LynxContext, create AnimaXView fail");
        return new View(r100);
    L6:
        LynxAnimaX.inst().init();
        this.f380220b = new o4a.b(this, (LynxContext) r100);
        return new x4a.a(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean dispatchTouch(MotionEvent r100) {
        if (this.f380229k == false) goto L16;
        if (this.f380221c == null) goto L16;
        if (isUserInteractionEnabled() == false) goto L16;
        if (r100.getAction() != 0) goto L16;
        RectF r101 = com.lynx.tasm.behavior.ui.utils.h.f(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
        MotionEvent r102 = MotionEvent.obtain(r100);
        float r103 = r100.getRawX() - r101.left;
        float r104 = r100.getRawY() - r101.top;
        x4a.a r105 = this.f380223e;
        if (r105 != null) goto L13;
        r102.setLocation(r103, r104);
    L14:
        this.f380221c.d(r102);
        goto L16
    L13:
        r102.setLocation(r103 - r105.getPaddingLeft(), r104 - this.f380223e.getPaddingTop());
    L16:
        return super.dispatchTouch(r100);
    }

    @LynxProp(name = "anti-aliasing")
    public void setAntiAliasing(final String r100) {
        this.f380224f.a(new g(r100));
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public void setAutoPlay(final boolean r100) {
        this.f380224f.a(new l(r100));
    }

    @LynxProp(name = "display-mode")
    public void setDisplayMode(String r100) {
        this.f380227i = DisplayMode.fromString(r100);
    }

    @LynxProp(name = "dynamic-resource")
    public void setDynamicResource(final boolean r100) {
        this.f380224f.b(new i(r100), f380218q);
    }

    @LynxProp(defaultBoolean = false, name = "enable-audio")
    public void setEnableAudio(final boolean r100) {
        this.f380224f.b(new f(r100), f380218q);
    }

    @LynxProp(name = "android-enable-screenshot")
    public void setEnableScreenshot(boolean r100) {
        this.f380231m = r100;
    }

    @LynxProp(defaultInt = -1, name = "end-frame")
    public void setEndFrame(final int r100) {
        this.f380224f.a(new v(r100));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        this.f380229k = r101;
        return;
    L5:
        if (r100.containsKey("taplayers") == false) goto L7;
        r101 = true;
        goto L8
    }

    @LynxProp(name = "fps-event-interval")
    public void setFpsEventInterval(final int r100) {
        this.f380224f.a(new x(r100));
    }

    @LynxProp(defaultBoolean = false, name = "ignore-attach-status")
    public void setIgnoreAttachStatus(boolean r100) {
        x4a.g r101 = this.f380221c;
        if (r101 == null) goto L5;
        r101.setIgnoreAttachStatus(r100);
        return;
    L5:
        this.f380226h = r100;
    }

    @LynxProp(defaultBoolean = false, name = "ignore-lynx-lifecycle")
    public void setIgnoreLynxLifecycle(boolean r100) {
        this.f380230l = r100;
    }

    @LynxProp(name = "json")
    public void setJson(final String r100) {
        this.f380224f.b(new q(this, r100), f380217p);
    }

    @LynxProp(defaultBoolean = true, name = "keeplastframe")
    public void setKeepLastFrame(final boolean r100) {
        this.f380224f.a(new d(r100));
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public void setLoop(final boolean r100) {
        this.f380224f.a(new h(r100));
    }

    @LynxProp(defaultInt = 1, name = "loop-count")
    public void setLoopCount(final int r100) {
        this.f380224f.a(new k(r100));
    }

    @LynxProp(name = "max-frame-rate")
    public void setMaxFrameRate(final double r100) {
        this.f380224f.a(new a(r100));
    }

    @LynxProp(defaultBoolean = true, name = "multi-thread-accelerate")
    public void setMultiThreadAccelerate(boolean r100) {
        this.f380225g = r100;
    }

    @LynxProp(defaultBoolean = false, name = "muted")
    public void setMuted(final boolean r100) {
        this.f380224f.a(new b(r100));
    }

    @LynxProp(name = "objectfit")
    public void setObjectFit(final String r100) {
        this.f380224f.a(new j(r100));
    }

    @LynxProp(name = "object-position")
    public void setObjectPosition(final String r100) {
        this.f380224f.a(new c(r100));
    }

    @LynxProp(name = "progress")
    public void setProgress(final float r100) {
        this.f380224f.a(new w(r100));
    }

    @LynxProp(defaultBoolean = false, name = "auto-reverse")
    public void setReverseMode(final boolean r100) {
        this.f380224f.a(new t(r100));
    }

    @LynxProp(name = "speed")
    public void setSpeed(final float r100) {
        this.f380224f.a(new s(r100));
    }

    @LynxProp(name = "src")
    public void setSrc(final String r100) {
        this.f380224f.b(new u(this, r100), f380217p);
    }

    @LynxProp(name = "src-format")
    public void setSrcFormat(final String r100) {
        this.f380224f.b(new o(this, r100), f380217p);
    }

    @LynxProp(name = "src-polyfill")
    public void setSrcPolyfill(final ReadableMap r100) {
        if ((r100 instanceof JavaOnlyMap) == false) goto L5;
        this.f380224f.b(new e(this, r100), f380218q);
        return;
    L5:
        AnimaXLog.a("UIAnimaX", "setSrcPolyfill fail");
    }

    @LynxProp(defaultInt = 0, name = "start-frame")
    public void setStartFrame(final int r100) {
        this.f380224f.a(new y(r100));
    }

    @LynxProp(name = "tag")
    public void setTag(String r100) {
        this.f380228j = r100;
        ((ConcurrentHashMap) this.f380220b.f380241e.f553157d).put("tag", r100);
    }

    @LynxProp(name = "video-frame-timeout")
    public void setVideoFrameTimeout(int r100) {
        o4a.b r101 = this.f380220b;
        if (r101 == null) goto L6;
        r101.f380240d.f380369c = r100;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(x0 r100) {
        super.updatePropertiesInterval(r100);
        boolean r101 = true;
        if (this.f380222d != null) goto L15;
        o4a.b r102 = this.f380220b;
        if (r102 == null) goto L15;
        AnimaXContext.a r103 = new AnimaXContext.a(r102, this.f380219a.getContext());
        if (this.f380225g == false) goto L12;
        String r104 = y4a.a.f566160a;
        if (SystemUtils.PRODUCT_HUAWEI.equals(Build.MANUFACTURER) == true) goto L12;
        boolean r105 = true;
    L13:
        r103.f380438c = r105;
        AnimaXContext r106 = new AnimaXContext(r103);
        o4a.b r107 = this.f380220b;
        ((ConcurrentHashMap) r107.f380239c.f558279a).put(IAnimaXMonitorService.class, new v4a.b(this.f380219a));
        o4a.b r108 = this.f380220b;
        ((ConcurrentHashMap) r108.f380239c.f558279a).put(w4a.b.class, new m(this));
        this.f380222d = new AnimaXPlayer(r106);
        UIAnimaXPropsPrioritySetter r109 = this.f380224f;
        AnimaXPlayer r110 = this.f380222d;
        r109.getClass();
        r109.f380419b = new WeakReference(r110);
    L12:
        r105 = false;
    L15:
        if (this.f380221c != null) goto L50;
        o4a.b r111 = this.f380220b;
        if (r111 != null) goto L19;
    L49:
        LLog.e("UIAnimaX", "LynxAbility or LynxContext is not created");
        O();
        goto L50
    L19:
        if (this.f380219a == null) goto L49;
        if (this.f380223e != null) goto L25;
        LLog.e("UIAnimaX", "AnimaXContainerView is not created");
        O();
        goto L50
    L25:
        if (this.f380222d != null) goto L28;
        LLog.e("UIAnimaX", "AnimaXPlayer is not created");
        O();
        goto L50
    L28:
        if ((!y4a.a.d("ANIMAX_MODEL_BLOCK_LIST_ANDROID", r111)) == true) goto L30;
        LLog.e("UIAnimaX", "Device is not support, create AnimaXView fail");
        O();
        goto L50
    L30:
        DisplayMode r112 = this.f380227i;
        DisplayMode r113 = DisplayMode.IMAGE;
        if (r112 == r113) goto L45;
        if (r112 != DisplayMode.AUTO) goto L43;
        o4a.b r114 = this.f380220b;
        String r115 = this.f380228j;
        if (r115 != null) goto L37;
    L40:
        boolean r116 = false;
    L41:
        if (r116 == false) goto L43;
    L37:
        if (r115.isEmpty() == true) goto L40;
        r116 = y4a.a.e(y4a.a.b("ANIMAX_USE_IMAGE_VIEW_".concat(r115), r114));
    L43:
        r101 = false;
    L45:
        if (r101 == false) goto L47;
        AnimaXLog.b("UIAnimaX", "create AnimaXImageView");
        v4a.d r117 = this.f380220b.f380241e;
        ((ConcurrentHashMap) r117.f553157d).put("display_mode", DisplayMode.access$000(r113));
        AnimaXImageView r118 = new AnimaXImageView(this.f380222d);
        this.f380221c = r118;
        this.f380223e.a(r118, null);
    L48:
        this.f380221c.setEnableTapLayerEvent(false);
        this.f380221c.setIgnoreAttachStatus(this.f380226h);
        goto L50
    L47:
        AnimaXLog.b("UIAnimaX", "create AnimaXView");
        v4a.d r119 = this.f380220b.f380241e;
        ((ConcurrentHashMap) r119.f553157d).put("display_mode", DisplayMode.access$000(DisplayMode.SURFACE));
        AnimaXView r120 = new AnimaXView(this.f380222d);
        this.f380221c = r120;
        this.f380223e.a(r120, new a0(this));
    L50:
        UIAnimaXPropsPrioritySetter r121 = this.f380224f;
        AnimaXPlayer r122 = r121.f380419b.get();
        if (r122 != null) goto L54;
        return;
    L54:
        if (r121.f380418a.isEmpty() == true) goto L69;
        UIAnimaXPropsPrioritySetter.b r123 = r121.f380418a.poll();
        if (r123 == null) goto L54;
        r123.f380421a.a(r122);     // Catch: Exception -> L59
    L59:
        e = move-exception;
        AnimaXLog.a("UIAnimaXPropsPrioritySetter", "Failed to run pending tasks with exception: " + e.getMessage());
        goto L54
    }

    public void getCurrentFrame(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        if (r101 == null) goto L9;
        r101.invoke(new Object[]{0, Double.valueOf(this.f380222d.getCurrentFrame())});
        return;
    }

    public void getDuration(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        if (r101 == null) goto L9;
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putDouble("data", this.f380222d.getDurationMs());
        r101.invoke(new Object[]{0, r102});
        return;
    }

    public void isAnimating(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        if (r101 == null) goto L9;
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putBoolean("data", this.f380222d.isAnimating());
        r101.invoke(new Object[]{0, r102});
        return;
    }

    public void listenAnimationUpdate(ReadableMap r100, Callback r101) {
        o4a.b r102 = this.f380220b;
        if (r102 != null) goto L6;
        N(r101);
        return;
    L6:
        if (r100 == null) goto L8;
        r102.f522013h = r100.getBoolean("isListen");
    L8:
        if (r101 == null) goto L11;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putBoolean("data", this.f380220b.f522013h);
        r101.invoke(new Object[]{0, r103});
        return;
    }

    public void pause(ReadableMap r100, Callback r101) {
        AnimaXPlayer r102 = this.f380222d;
        if (r102 != null) goto L6;
        N(r101);
        return;
    L6:
        r102.pause();
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void play(ReadableMap r100, Callback r101) {
        AnimaXPlayer r102 = this.f380222d;
        if (r102 != null) goto L6;
        N(r101);
        return;
    L6:
        r102.play();
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void playSegment(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        int r102 = r100.getInt("startFrame");
        int r103 = r100.getInt("endFrame");
        if (r103 <= 0) goto L12;
        if (r102 <= r103) goto L12;
        if (r101 == null) goto L16;
        r101.invoke(new Object[]{1, "startFrame and endFrame are not valid!"});
        return;
    L16:
        return;
    L12:
        this.f380222d.r(r102, r103);
        if (r101 == null) goto L17;
        r101.invoke(new Object[]{0});
        return;
    }

    public void resume(ReadableMap r100, Callback r101) {
        AnimaXPlayer r102 = this.f380222d;
        if (r102 != null) goto L6;
        N(r101);
        return;
    L6:
        r102.resume();
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void seek(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        this.f380222d.a(r100.getInt("frame"));
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void stop(ReadableMap r100, Callback r101) {
        AnimaXPlayer r102 = this.f380222d;
        if (r102 != null) goto L6;
        N(r101);
        return;
    L6:
        r102.v();
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void subscribeUpdateEvent(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        this.f380222d.w(r100.getInt("frame"));
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void subscribeUpdateEvents(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        int[] r102 = M(r100);
        if (r102 != null) goto L10;
        N(r101);
        return;
    L10:
        this.f380222d.b(r102, true);
        if (r101 == null) goto L14;
        r101.invoke(new Object[]{0});
        return;
    }

    public void unsubscribeUpdateEvent(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        this.f380222d.x(r100.getInt("frame"));
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    }

    public void unsubscribeUpdateEvents(ReadableMap r100, Callback r101) {
        if (this.f380222d != null) goto L6;
        N(r101);
        return;
    L6:
        int[] r102 = M(r100);
        if (r102 != null) goto L10;
        N(r101);
        return;
    L10:
        this.f380222d.b(r102, false);
        if (r101 == null) goto L14;
        r101.invoke(new Object[]{0});
        return;
    }
}
