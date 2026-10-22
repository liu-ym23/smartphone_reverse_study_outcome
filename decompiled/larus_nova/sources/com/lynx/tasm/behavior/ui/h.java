package com.lynx.tasm.behavior.ui;

import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends e0 {
    public boolean A;
    public e B;
    public final c C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap<String, f> f382534v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HashSet<f> f382535w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashSet<f> f382536x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f382537y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f382538z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f382539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LynxBaseUI f382540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f382541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JavaOnlyMap f382542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JavaOnlyMap f382543e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ h f382544f;

        public final void a() {
            h r100 = this.f382544f;
            if (r100.f382538z == false) goto L5;
        L7:
            this.f382544f.f382534v.put(this.f382539a, new f(this.f382540b, this.f382541c, this.f382542d, this.f382543e));
            return;
        L5:
            if (r100.f382534v.isEmpty() == false) goto L7;
            this.f382544f.b();
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r100, String r101, LynxBaseUI r102, String r103, JavaOnlyMap r104, JavaOnlyMap r105) {
            this.f382544f = r100;
            this.f382539a = r101;
            this.f382540b = r102;
            this.f382541c = r103;
            this.f382542d = r104;
            this.f382543e = r105;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f382545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f382546b;

        public final void a() {
            if (this.f382546b.f382534v.get(this.f382545a) != null) goto L6;
            return;
        L6:
            if (this.f382546b.f382534v.get(this.f382545a).f382549a.get() == null) goto L9;
            this.f382546b.f382534v.remove(this.f382545a);
        L9:
            if (this.f382546b.f382534v.isEmpty() == false) goto L12;
            h r100 = this.f382546b;
            r100.getClass();
            UIThreadUtils.runOnUiThreadImmediately(new i(r100));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r100, String r101) {
            this.f382546b = r100;
            this.f382545a = r101;
        }
    }

    public static class c implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<h> f382547a;

        public c(h r100) {
            this.f382547a = new WeakReference(r100);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            h r101 = this.f382547a.get();
            if (r101 == null) goto L6;
            r101.i();
            return;
        }
    }

    public static class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LynxContext> f382548a;

        public d(WeakReference<LynxContext> r100) {
            this.f382548a = r100;
        }
    }

    public interface e {
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LynxBaseUI> f382549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f382550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f382551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f382552d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ReadableMap f382553e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f382554f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final JavaOnlyMap f382555g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final JavaOnlyMap f382556h;

        public final HashMap<String, Object> a() {
            HashMap<String, Object> r100 = new HashMap();
            r100.put("exposure-id", this.f382550b);
            r100.put("exposure-scene", this.f382551c);
            r100.put("dataset", this.f382553e);
            r100.put("unique-id", this.f382554f);
            r100.put("extra-data", this.f382555g);
            return r100;
        }

        public final int hashCode() {
            LynxBaseUI r100 = this.f382549a.get();
            if (r100 != null) goto L5;
            return 0;
        L5:
            return r100.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L21:
            return false;
        L8:
            if (f.class != r100.getClass()) goto L21;
            f r101 = (f) r100;
            if (this.f382552d == r101.f382552d) goto L13;
        L19:
            return false;
        L13:
            if (this.f382551c.equals(r101.f382551c) == false) goto L19;
            if (this.f382550b.equals(r101.f382550b) == false) goto L19;
            if (this.f382554f.equals(r101.f382554f) == false) goto L19;
            return true;
        }

        public f(LynxBaseUI r100, String r101, JavaOnlyMap r102, JavaOnlyMap r103) {
            this.f382549a = new WeakReference(r100);
            if (r100.getExposureID() != null) goto L5;
            this.f382550b = "";
        L7:
            if (r100.getExposureScene() != null) goto L9;
            this.f382551c = "";
        L10:
            this.f382552d = r100.getSign();
            this.f382553e = r100.getDataset();
            if (r101 != null) goto L14;
            r101 = "";
        L14:
            this.f382554f = r101;
            if (r102 == null) goto L17;
            JavaOnlyMap r104 = JavaOnlyMap.from(r102);
        L18:
            this.f382555g = r104;
            this.f382556h = r103;
            return;
        L17:
            r104 = new JavaOnlyMap();
            goto L18
        L9:
            this.f382551c = r100.getExposureScene();
            goto L10
        L5:
            this.f382550b = r100.getExposureID();
            goto L7
        }
    }

    public h() {
        super("Lynx.UIExposure");
        this.f382537y = null;
        this.B = null;
        this.f382534v = new HashMap();
        this.f382536x = new HashSet();
        this.f382535w = new HashSet();
        this.f382006a = new WeakReference(null);
        this.C = new c(this);
        this.A = true;
    }

    @Override // com.lynx.tasm.behavior.e0
    public final void i() {
        if (this.f382538z == false) goto L7;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since lynx.stopExposure() is called");
        this.f382020o = false;
        return;
    L7:
        if (this.f382011f == true) goto L10;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView not draw");
        this.f382020o = false;
        return;
    L10:
        UIBody.UIBodyView r100 = f();
        if (r100 != null) goto L15;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView is null");
        this.f382020o = false;
        return;
    L15:
        if (r100.isShown() == true) goto L22;
        if (this.f382022q == false) goto L19;
        q(new HashSet(this.f382536x), "disexposure");
        this.f382536x.clear();
    L19:
        this.f382020o = false;
        return;
    L22:
        if (this.f382023r == false) goto L24;
    L27:
        this.f382537y = g(this.f382006a.get().getLynxContext());
        Iterator<f> r101 = this.f382534v.values().iterator();
    L29:
        if (r101.hasNext() == false) goto L136;
        f r102 = r101.next();
        LynxBaseUI r103 = r102.f382549a.get();
        if (r103 == null) goto L29;
        if (r103.getHeight() != 0) goto L35;
    L132:
        boolean r104 = false;
    L133:
        if (r104 == false) goto L29;
        this.f382535w.add(r102);
        goto L29
    L35:
        if (r103.getWidth() == 0) goto L132;
        ArrayList r105 = new ArrayList();
        LynxBaseUI r106 = r103;
    L38:
        if (r106 == null) goto L57;
        if (r106 == this.f382006a.get()) goto L57;
        if ((r106 instanceof LynxUI) == false) goto L47;
        if (((LynxUI) r106).isVisible() == false) goto L132;
    L47:
        if (r106.getEnableExposureUIClip() != EventTarget.EnableStatus.Enable) goto L49;
    L52:
        r105.add(r106);
    L54:
        if (r106.isOverlay() == true) goto L55;
        r106 = (LynxBaseUI) r106.getParent();
        goto L38
    L55:
        boolean r107 = true;
    L58:
        RectF r108 = d(r103);
        if (r103.getEnableExposureUIMargin() == false) goto L67;
        float r110 = r108.width();
        float r111 = r108.height();
        DisplayMetrics r112 = r103.getLynxContext().getScreenMetrics();
        float r113 = n.e(r103.getExposureUIMarginLeft(), r110, r112);
        float r114 = n.e(r103.getExposureUIMarginRight(), r110, r112);
        float r109 = n.e(r103.getExposureUIMarginTop(), r111, r112);
        float r115 = n.e(r103.getExposureUIMarginBottom(), r111, r112);
        if (((r110 + r113) + r114) > 0.0f) goto L63;
    L66:
        r108 = new RectF();
    L84:
        float r116 = n.a(r103.getExposureArea(), 0.0f);
        Iterator r117 = r105.iterator();
    L86:
        if (r117.hasNext() == false) goto L90;
        if (n(r108, d((LynxBaseUI) r117.next()), r116) == true) goto L86;
    L90:
        RectF r118 = d(this.f382006a.get());
        if (this.f382537y != null) goto L93;
        this.f382537y = g(r103.getLynxContext());
    L93:
        if (r107 == true) goto L95;
        r104 = n(r108, r118, r116);
    L97:
        if (this.f382537y == null) goto L133;
        if (r103.getEnableExposureUIMargin() == true) goto L101;
        float r119 = this.f382537y.left;
        if (r103.getExposureScreenMarginLeft() >= 0.0f) goto L113;
        float r120 = r103.getExposureScreenMarginLeft();
    L114:
        float r121 = r119 - ((int) r120);
        float r122 = this.f382537y.top;
        if (r103.getExposureScreenMarginTop() >= 0.0f) goto L117;
        float r123 = r103.getExposureScreenMarginTop();
    L118:
        float r124 = r122 - ((int) r123);
        float r125 = this.f382537y.right;
        if (r103.getExposureScreenMarginRight() >= 0.0f) goto L121;
        float r126 = r103.getExposureScreenMarginRight();
    L122:
        float r127 = r125 + ((int) r126);
        float r128 = this.f382537y.bottom;
        if (r103.getExposureScreenMarginBottom() >= 0.0f) goto L125;
        float r129 = r103.getExposureScreenMarginBottom();
    L126:
        RectF r130 = new RectF(r121, r124, r127, r128 + ((int) r129));
    L127:
        boolean r131 = n(r108, r130, r116);
        boolean r132 = n(r118, r130, 0.0f);
        if (r104 == false) goto L132;
        if (r131 == false) goto L132;
        if (r132 == false) goto L132;
        r104 = true;
        goto L133
    L125:
        r129 = 0.0f;
        goto L126
    L121:
        r126 = 0.0f;
        goto L122
    L117:
        r123 = 0.0f;
        goto L118
    L113:
        r120 = 0.0f;
        goto L114
    L101:
        if (this.f382537y != null) goto L103;
        this.f382537y = g(r103.getLynxContext());
    L103:
        r130 = new RectF(this.f382537y);
        if (((r130.width() + r103.getExposureScreenMarginLeft()) + r103.getExposureScreenMarginRight()) > 0.0f) goto L106;
    L109:
        r130 = new RectF();
        goto L127
    L106:
        if (((r130.height() + r103.getExposureScreenMarginTop()) + r103.getExposureScreenMarginBottom()) <= 0.0f) goto L109;
        r130.left -= r103.getExposureScreenMarginLeft();
        r130.top -= r103.getExposureScreenMarginTop();
        r130.right += r103.getExposureScreenMarginRight();
        r130.bottom += r103.getExposureScreenMarginBottom();
        goto L127
    L95:
        r104 = true;
        goto L97
    L63:
        if (((r111 + r109) + r115) <= 0.0f) goto L66;
        r108.left -= r113;
        r108.top -= r109;
        r108.right += r114;
        r108.bottom += r115;
        goto L84
    L67:
        float r133 = r108.left;
        if (r103.getExposureScreenMarginRight() <= 0.0f) goto L70;
        float r134 = r103.getExposureScreenMarginRight();
    L71:
        r108.left = r133 - r134;
        float r135 = r108.right;
        if (r103.getExposureScreenMarginLeft() <= 0.0f) goto L74;
        float r136 = r103.getExposureScreenMarginLeft();
    L75:
        r108.right = r135 + r136;
        float r137 = r108.top;
        if (r103.getExposureScreenMarginBottom() <= 0.0f) goto L78;
        float r138 = r103.getExposureScreenMarginBottom();
    L79:
        r108.top = r137 - r138;
        float r139 = r108.bottom;
        if (r103.getExposureScreenMarginTop() <= 0.0f) goto L82;
        float r140 = r103.getExposureScreenMarginTop();
    L83:
        r108.bottom = r139 + r140;
        goto L84
    L82:
        r140 = 0.0f;
        goto L83
    L78:
        r138 = 0.0f;
        goto L79
    L74:
        r136 = 0.0f;
        goto L75
    L70:
        r134 = 0.0f;
        goto L71
    L49:
        if (r106.getEnableExposureUIClip() != EventTarget.EnableStatus.Undefined) goto L54;
        if (r106.isScrollContainer() == false) goto L54;
    L57:
        r107 = false;
        goto L58
    L136:
        HashSet<f> r141 = new HashSet();
        r141.addAll(this.f382536x);
        r141.removeAll(this.f382535w);
        HashSet<f> r142 = new HashSet();
        r142.addAll(this.f382535w);
        r142.removeAll(this.f382536x);
        this.f382536x = this.f382535w;
        this.f382535w = new HashSet();
        q(r141, "disexposure");
        q(r142, "exposure");
        this.f382020o = false;
        return;
    L24:
        if (r100.isLayoutRequested() == false) goto L27;
        c r143 = this.C;
        this.f382020o = true;
        Choreographer.getInstance().postFrameCallbackDelayed(r143, this.f382012g);
    }

    public final void p() {
        if (this.A == true) goto L6;
        return;
    L6:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L8;
        r("Lynx.UIExposure: resumeExposure", LogBoxLogLevel.Info.ordinal());
    L8:
        LLog.i("Lynx.UIExposure", "resumeExposure");
        this.f382538z = false;
        b();
    }

    public final void s(HashMap<String, Object> r100) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L8;
        r("Lynx.UIExposure: stopExposure", LogBoxLogLevel.Info.ordinal());
    L8:
        LLog.i("Lynx.UIExposure", "stopExposure");
        this.f382538z = true;
        c();
        if (r100 != null) goto L11;
    L14:
        q(this.f382536x, "disexposure");
        this.f382536x.clear();
        return;
    L11:
        if (r100.containsKey("sendEvent") == true) goto L13;
        return;
    L13:
        if (((Boolean) r100.get("sendEvent")).booleanValue() == true) goto L14;
    }

    public final void o(LynxBaseUI r100, String r101) {
        if (this.A == true) goto L5;
        return;
    L5:
        if (r101 != null) goto L9;
        if (r100.getExposureID() != null) goto L9;
        return;
    L9:
        if (r101 == null) goto L11;
        String r102 = r101 + "_" + r100.getExposureScene() + "_" + r100.getExposureID();
    L12:
        UIThreadUtils.runOnUiThreadImmediately(new b(this, r102));
        return;
    L11:
        r102 = r100.getExposureScene() + "_" + r100.getExposureID() + "_" + r100.getSign();
        goto L12
    }

    public final void q(HashSet<f> r110, String r111) {
        if (f() != null) goto L6;
        return;
    L6:
        if (r110.isEmpty() == true) goto L118;
        e r100 = this.B;
        if (r100 != null) goto L10;
        LLog.e("Lynx.UIExposure", "canSendGlobalEvent check failed since mCallback is null.");
    L22:
        boolean r101 = true;
    L23:
        if (r101 == false) goto L98;
        JavaOnlyArray r102 = new JavaOnlyArray();
        HashMap r103 = new HashMap();
        Iterator<f> r104 = r110.iterator();
    L26:
        if (r104.hasNext() == false) goto L69;
        f r105 = r104.next();
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L30;
        r("Lynx.UIExposure: sendEvent [" + r111 + "] [" + r105.f382551c + "] [" + r105.f382550b + "] [" + r105.f382554f + "] [" + r105.f382552d + "]", LogBoxLogLevel.Info.ordinal());
    L30:
        JavaOnlyMap r112 = r105.f382556h;
        if (r112 == null) goto L67;
        if (r112.containsKey("sendCustom") == false) goto L67;
        if (r105.f382556h.getBoolean("sendCustom") == false) goto L67;
        if (r105.f382556h.containsKey("specifyTarget") == false) goto L57;
        if (r105.f382556h.getBoolean("specifyTarget") == false) goto L57;
        LynxBaseUI r113 = r105.f382549a.get();
        if (r113 == null) goto L26;
        LynxBaseUI r114 = r113.getExposeReceiveTarget();
        String r115 = r105.f382556h.getString("bindEventName");
        if (r114 == null) goto L26;
        if (r114.getEvents() == null) goto L26;
        if (r115 == null) goto L26;
        if (r114.getEvents().containsKey(r115) == false) goto L26;
        if (r103.containsKey(r114) == true) goto L52;
        HashMap r116 = new HashMap();
        ArrayList r117 = new ArrayList();
        r117.add(r105);
        r116.put(r115, r117);
        r103.put(r114, r116);
        goto L26
    L52:
        HashMap r118 = (HashMap) r103.get(r114);
        if (r118.containsKey(r115) == true) goto L54;
        r118.put(r115, new ArrayList());
        ((ArrayList) r118.get(r115)).add(r105);
        goto L26
    L54:
        ((ArrayList) r118.get(r115)).add(r105);
    L57:
        LynxBaseUI r119 = r105.f382549a.get();
        if (r111 != "exposure") goto L60;
        String r120 = "uiappear";
    L61:
        if (r119 == null) goto L26;
        if (r119.getEvents() == null) goto L26;
        if (r119.getEvents().containsKey(r120) == false) goto L26;
        r119.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r119.getSign(), r120, r105.a()));
        goto L26
    L60:
        r120 = "uidisappear";
    L67:
        JavaOnlyMap r121 = new JavaOnlyMap();
        r121.put("exposure-id", r105.f382550b);
        r121.put("exposureID", r105.f382550b);
        r121.put("exposure-scene", r105.f382551c);
        r121.put("exposureScene", r105.f382551c);
        r121.put("sign", String.valueOf(r105.f382552d));
        r121.put("dataSet", r105.f382553e);
        r121.put("dataset", r105.f382553e);
        r121.put("unique-id", r105.f382554f);
        r121.put("extra-data", r105.f382555g);
        r102.pushMap(r121);
        goto L26
    L69:
        if (r103.isEmpty() == true) goto L87;
        Iterator r106 = r103.entrySet().iterator();
    L73:
        if (r106.hasNext() == false) goto L87;
        Map.Entry r107 = (Map.Entry) r106.next();
        LynxBaseUI r108 = (LynxBaseUI) r107.getKey();
        Iterator r109 = ((HashMap) r107.getValue()).entrySet().iterator();
    L76:
        if (r109.hasNext() == false) goto L73;
        Map.Entry r122 = (Map.Entry) r109.next();
        String r123 = (String) r122.getKey();
        JavaOnlyArray r124 = new JavaOnlyArray();
        Iterator r125 = ((ArrayList) r122.getValue()).iterator();
    L79:
        if (r125.hasNext() == false) goto L81;
        f r126 = (f) r125.next();
        JavaOnlyMap r127 = new JavaOnlyMap();
        r127.put("extra-data", r126.f382555g);
        r124.pushMap(r127);
        goto L79
    L81:
        JavaOnlyMap r128 = new JavaOnlyMap();
        if (r111 != "exposure") goto L84;
        boolean r129 = true;
    L85:
        r128.put("isExposure", Boolean.valueOf(r129));
        r128.put("childrenInfo", r124);
        r108.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r108.getSign(), r123, r128));
        goto L76
    L84:
        r129 = false;
    L87:
        if (r102.size() <= 0) goto L167;
        JavaOnlyArray r130 = new JavaOnlyArray();
        r130.add(r102);
        e r131 = this.B;
        if (r131 != null) goto L91;
        LLog.e("Lynx.UIExposure", "sendEvent failed since mCallback is null.");
        return;
    L91:
        LynxContext r132 = ((d) r131).f382548a.get();
        if (r132 != null) goto L94;
        LLog.e("UIExposure", "sendGlobalEvent failed since can not get LynxContext.");
        return;
    L94:
        UIBody.UIBodyView r133 = r132.getBodyView();
        if (r133 != null) goto L97;
        LLog.e("UIExposure", "sendGlobalEvent failed since can not get UIBodyView.");
        return;
    L97:
        r133.sendGlobalEvent(r111, r130);
        return;
    L167:
        return;
    L98:
        Iterator<f> r134 = r110.iterator();
    L100:
        if (r134.hasNext() == false) goto L172;
        f r135 = r134.next();
        int r136 = r135.f382552d;
        e r137 = this.B;
        if (r137 != null) goto L104;
        LLog.e("Lynx.UIExposure", "findNode failed since mCallback is null.");
    L110:
        LynxBaseUI r138 = null;
    L112:
        if (r138 == null) goto L100;
        if (r138.getEvents() == null) goto L100;
        if (r138.getEvents().containsKey(r111) == false) goto L100;
        r138.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r138.getSign(), r111, r135.a()));
        goto L100
    L104:
        LynxContext r139 = ((d) r137).f382548a.get();
        if (r139 != null) goto L108;
        LLog.e("UIExposure", "findNode failed since can not get LynxContext.");
        goto L110
    L108:
        if (r139.getLynxUIOwner() != null) goto L111;
        LLog.e("UIExposure", "findNode failed since can not get LynxUIOwner.");
        goto L110
    L111:
        r138 = r139.getLynxUIOwner().getNode(r136);
        goto L112
    L172:
        return;
    L10:
        LynxContext r140 = ((d) r100).f382548a.get();
        if (r140 != null) goto L13;
        LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxContext.");
        goto L22
    L13:
        LynxView r141 = r140.getLynxView();
        if (r141 != null) goto L17;
        LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxView.");
        goto L22
    L17:
        if (r141.enableJSRuntime() == true) goto L22;
        if (r141.enableAirStrictMode() == true) goto L22;
        r101 = false;
        goto L23
    }

    public final void r(String r100, int r101) {
        LynxView r102 = (LynxView) f();
        if (r102 != null) goto L5;
        return;
    L5:
        LynxBaseInspectorController r103 = r102.getBaseInspectorController();
        if (r103 != null) goto L8;
        return;
    L8:
        r103.showMessageOnConsole(r100, r101);
    }

    public static boolean n(RectF r100, RectF r101, float r102) {
        float r103 = 0.0f;
        if (r102 == 0.0f) goto L13;
        RectF r104 = new RectF();
        if (r104.setIntersect(r100, r101) == false) goto L8;
        float r105 = r100.height() * r100.width();
        r103 = (r104.height() * r104.width()) / r105;
    L8:
        if (r103 < r102) goto L10;
        return true;
    L10:
        return false;
    L13:
        return RectF.intersects(r100, r101);
    }

    public final void m(LynxBaseUI r100, String r110, JavaOnlyMap r111, JavaOnlyMap r112) {
        if (this.A == true) goto L5;
        return;
    L5:
        if (r110 != null) goto L9;
        if (r100.getExposureID() != null) goto L9;
        return;
    L9:
        if (r110 == null) goto L11;
        String r101 = r110 + "_" + r100.getExposureScene() + "_" + r100.getExposureID();
    L12:
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r101, r100, r110, r111, r112));
        return;
    L11:
        r101 = r100.getExposureScene() + "_" + r100.getExposureID() + "_" + r100.getSign();
        goto L12
    }
}
