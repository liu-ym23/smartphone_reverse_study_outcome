package com.lynx.clay.embedding.engine.plugins.platformview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import c5a.c;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.util.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n5a.h;
import n5a.i;
import n5a.j;
import n5a.k;
import n5a.l;
import n5a.m;
import n5a.n;
import n5a.o;
import n5a.p;
import o5a.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class PlatformViewPlugin implements j {
    private static final String PLATFORM_VIEW_TOUCH_RESULT_EVENT = "__clay_platform_view_touch_dispatch_result__";
    private static final Set<String> SYSTEM_TOUCH_DISPATCH_WHITELIST = null;
    private static final String TAG = "PlatformViewPlugin";
    private static Class[] VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY;
    private final ClayPluginContext context;
    private boolean enableSystemTouchDispatch;
    private boolean isInternalView;
    private i platformViewContext;
    private k platformViewHolder;
    private String tag;
    private int viewId;
    private final long viewPtr;

    public class a implements v5a.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlatformViewPlugin f380852a;

        public a(PlatformViewPlugin r100) {
            this.f380852a = r100;
        }
    }

    public class b implements PlatformMethodCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f380853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PlatformViewPlugin f380854b;

        public b(PlatformViewPlugin r100, long r101) {
            this.f380854b = r100;
            this.f380853a = r101;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallback
        public final void invoke(int r100, Object r101, PlatformViewDataProtocol r102) {
            this.f380854b.nativeOnPlatformMethodCallback(this.f380853a, r100, r101, r102.ordinal());
        }
    }

    public static /* synthetic */ boolean a(PlatformViewPlugin r100, MotionEvent r101, int r102, int r103) {
        return r100.lambda$onCreateView$1(r101, r102, r103);
    }

    public static /* synthetic */ void b(PlatformViewPlugin r100, MotionEvent r101, boolean r102) {
        r100.lambda$onCreateView$0(r101, r102);
    }

    public native void nativeMarkAsEditing(long r100);

    public native void nativeMarkLayoutDirty(long r100);

    public native void nativeOnPlatformMethodCallback(long r100, int r101, Object r102, int r103);

    public native void nativeOnPlatformViewSendEvent(long r100, String r101, String r102);

    public native void nativeRequestSubtreeRasterSnapshot(long r100, float r101, SubtreeRasterSnapshotCallback r102);

    private FlutterView getFlutterView() {
        ClayPluginContext r100 = this.context;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.f380756a;
    }

    private void onDestroyView() {
        k r100 = this.platformViewHolder;
        if (r100 == null) goto L5;
        r100.release();
        this.platformViewHolder = null;
    L5:
        i r101 = this.platformViewContext;
        if (r101 == null) goto L11;
        int r102 = this.viewId;
        n5a.b r103 = (n5a.b) r101;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r104 = r103.f518057c;
        HashMap r105 = (HashMap) r104;
        com.lynx.clay.embedding.engine.plugins.platformview.a r106 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r105.get(Integer.valueOf(r102));
        if (r106 == null) goto L10;
        r106.h();
    L10:
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r107 = r103.f518057c;
        HashMap r108 = (HashMap) r107;
        r108.remove(Integer.valueOf(r102));
    L11:
        this.platformViewContext = null;
    }

    private void onViewDetached() {
        k r100 = this.platformViewHolder;
        if (r100 != null) goto L5;
        c.d(5, TAG, "onViewDetached invoked with null platformViewHolder, viewId=" + this.viewId);
    L6:
        i r101 = this.platformViewContext;
        if (r101 == null) goto L12;
        int r102 = this.viewId;
        com.lynx.clay.embedding.engine.plugins.platformview.a r103 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r101).f518057c).get(Integer.valueOf(r102));
        if (r103 == null) goto L13;
        r103.l();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r100.onViewDetached();
        goto L6
    }

    @Override // n5a.j
    public void markAsEditing() {
        nativeMarkAsEditing(this.viewPtr);
    }

    @Override // n5a.j
    public void markLayoutDirty() {
        nativeMarkLayoutDirty(this.viewPtr);
    }

    static {
        SYSTEM_TOUCH_DISPATCH_WHITELIST = Collections.singleton("x-comment-inputview-card");
        VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY = new Class[]{SurfaceView.class};
    }

    private boolean ensureFlutterViewAttached() {
        if (getFlutterView() != null) goto L5;
        return false;
    L5:
        if (this.platformViewContext == null) goto L11;
        return true;
    L11:
        return false;
    }

    private void onInvalidate() {
        if (ensureFlutterViewAttached() == false) goto L8;
        k r100 = this.platformViewHolder;
        if (r100 == null) goto L9;
        r100.b();
        return;
    L9:
        return;
    }

    private void onNodeReady() {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r100 = this.platformViewContext;
        int r101 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r102 = ((n5a.b) r100).f518057c;
        HashMap r103 = (HashMap) r102;
        com.lynx.clay.embedding.engine.plugins.platformview.a r104 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L9;
        r104.j();
        return;
    L9:
        return;
    }

    private void onViewAttached() {
        if (ensureFlutterViewAttached() == false) goto L12;
        k r100 = this.platformViewHolder;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.platformViewContext == null) goto L14;
        r100.a(this.context.f380756a);
        i r101 = this.platformViewContext;
        int r102 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r103 = ((n5a.b) r101).f518057c;
        HashMap r104 = (HashMap) r103;
        com.lynx.clay.embedding.engine.plugins.platformview.a r105 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r104.get(Integer.valueOf(r102));
        if (r105 == null) goto L15;
        r105.k();
        return;
    L15:
        return;
    L14:
        return;
    }

    private void resignFirstResponder() {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r100 = this.platformViewContext;
        int r101 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r102 = ((n5a.b) r100).f518057c;
        HashMap r103 = (HashMap) r102;
        com.lynx.clay.embedding.engine.plugins.platformview.a r104 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L9;
        r104.m();
        return;
    L9:
        return;
    }

    private boolean usesSystemTouchDispatch() {
        return this.enableSystemTouchDispatch;
    }

    private MotionEvent parseMotionEvent(byte[] r210) {
        ByteBuffer r100 = ByteBuffer.wrap(r210);
        r100.order(ByteOrder.nativeOrder());
        long r101 = r100.getLong();
        long r102 = r100.getLong();
        float r110 = r100.getFloat();
        float r111 = r100.getFloat();
        int r103 = r100.getInt();
        int r104 = r100.getInt();
        int r112 = r100.getInt();
        int r113 = r100.getInt();
        int r114 = r100.getInt();
        int r115 = r100.getInt();
        int r116 = r100.getInt();
        int r117 = r100.getInt();
        r100.getInt();
        MotionEvent.PointerProperties[] r105 = new MotionEvent.PointerProperties[r104];
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        MotionEvent.PointerProperties r107 = new MotionEvent.PointerProperties();
        int r118 = r115;
        r107.id = r100.getInt();
        r107.toolType = r100.getInt();
        r105[r106] = r107;
        r106 = r106 + 1;
        r115 = r118;
        goto L3
    L5:
        int r119 = r115;
        MotionEvent.PointerCoords[] r108 = new MotionEvent.PointerCoords[r104];
        int r109 = 0;
    L6:
        if (r109 >= r104) goto L9;
        MotionEvent.PointerCoords r120 = new MotionEvent.PointerCoords();
        int r211 = r114;
        r120.x = r100.getFloat();
        r120.y = r100.getFloat();
        r120.pressure = r100.getFloat();
        r120.size = r100.getFloat();
        r120.orientation = r100.getFloat();
        r108[r109] = r120;
        r109 = r109 + 1;
        r114 = r211;
        goto L6
    L9:
        return MotionEvent.obtain(r101, r102, r103, r104, r105, r108, r112, r113, r110, r111, r114, r119, r116, r117);
    }

    public void onPlatformViewTouchEvent(byte[] r100) {
        if (r100 != null) goto L6;
        c.d(5, TAG, "onPlatformViewTouchEvent invoked with null event data");
        return;
    L6:
        if (ensureFlutterViewAttached() == true) goto L8;
        return;
    L8:
        if (usesSystemTouchDispatch() == false) goto L10;
        return;
    L10:
        i r101 = this.platformViewContext;
        int r102 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r103 = ((n5a.b) r101).f518057c;
        HashMap r104 = (HashMap) r103;
        com.lynx.clay.embedding.engine.plugins.platformview.a r105 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r104.get(Integer.valueOf(r102));
        if (r105 == null) goto L13;
        View r106 = r105.b();
    L14:
        if (r106 == null) goto L18;
        r106.dispatchTouchEvent(parseMotionEvent(r100));
        return;
    L18:
        return;
    L13:
        r106 = null;
        goto L14
    }

    private PlatformViewPlugin(ClayPluginContext r100, long r101) {
        this.context = r100;
        this.viewPtr = r101;
    }

    public static PlatformViewPlugin Create(ClayPluginContext r100, long r101) {
        return new PlatformViewPlugin(r100, r101);
    }

    private /* synthetic */ void lambda$onCreateView$0(MotionEvent r100, boolean r101) {
        syncPlatformViewTouchDispatchResult(r100, r101);
    }

    private void onInsertNode(int r100, int r101) {
        if (ensureFlutterViewAttached() == false) goto L13;
        i r102 = this.platformViewContext;
        if (r102 == null) goto L14;
        int r103 = this.viewId;
        n5a.b r104 = (n5a.b) r102;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r105 = r104.f518057c;
        HashMap r106 = (HashMap) r105;
        com.lynx.clay.embedding.engine.plugins.platformview.a r107 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r106.get(Integer.valueOf(r103));
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r108 = r104.f518057c;
        HashMap r109 = (HashMap) r108;
        com.lynx.clay.embedding.engine.plugins.platformview.a r110 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r109.get(Integer.valueOf(r100));
        if ((r110 instanceof f) == true) goto L9;
        return;
    L9:
        if ((r107 instanceof f) == false) goto L16;
        f r111 = (f) r107;
        ((f) r110).getClass();
        return;
    L16:
        return;
    L14:
        return;
    }

    private void onPlatformViewAttributesUpdate(byte[] r100, byte[] r101) {
    L18:
        e = move-exception;
        c.b(TAG, "onPlatformViewAttributesUpdate exception:", e);
        return;
    L3:
        if (ensureFlutterViewAttached() == false) goto L25;
        JSONObject r102 = new JSONObject(new String(r100, StandardCharsets.UTF_8));     // Catch: Exception -> L18
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L18
        if (r101 == null) goto L10;
        JSONArray r104 = new JSONArray(new String(r101, StandardCharsets.UTF_8));     // Catch: Exception -> L18
        int r105 = 0;
    L8:
        if (r105 >= r104.length()) goto L10;
        r103.add(r104.optString(r105));     // Catch: Exception -> L18
        r105 = r105 + 1;     // Catch: Exception -> L18
    L10:
        i r106 = this.platformViewContext;     // Catch: Exception -> L18
        int r107 = this.viewId;     // Catch: Exception -> L18
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r108 = ((n5a.b) r106).f518057c;     // Catch: Exception -> L18
        HashMap r109 = (HashMap) r108;     // Catch: Exception -> L18
        com.lynx.clay.embedding.engine.plugins.platformview.a r110 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r109.get(Integer.valueOf(r107));     // Catch: Exception -> L18
        if (r110 == null) goto L26;
        Iterator<String> r111 = r102.keys();     // Catch: Exception -> L18
    L14:
        if (r111.hasNext() == false) goto L16;
        String r112 = r111.next();     // Catch: Exception -> L18
        r110.n(r112, r102.opt(r112));     // Catch: Exception -> L18
        goto L14
    L16:
        r110.p(r103);     // Catch: Exception -> L18
        r110.g();     // Catch: Exception -> L18
        return;
    L26:
        return;
    }

    private boolean shouldDispatchSystemTouchEventToPlatformView(int r100, int r101) {
        FlutterView r102 = getFlutterView();
        if (r102 != null) goto L5;
        return true;
    L5:
        FlutterEngine r103 = r102.getAttachedFlutterEngine();
        if (r103 != null) goto L8;
        return true;
    L8:
        int r104 = this.viewId;
        FlutterJNI r105 = r103.f380694a;
        if (r105 != null) goto L13;
        return false;
    L13:
        return r105.isHitTestingTargetNativeView(r104, r100, r101);
    }

    private void syncPlatformViewTouchDispatchResult(MotionEvent r100, boolean r101) {
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L5;
    L18:
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L15
        r103.put("handled", r101);     // Catch: Exception -> L15
        r103.put("action", r102);     // Catch: Exception -> L15
        nativeOnPlatformViewSendEvent(this.viewPtr, PLATFORM_VIEW_TOUCH_RESULT_EVENT, r103.toString());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        c.b(TAG, "syncPlatformViewTouchDispatchResult exception:", e);
        return;
    L5:
        if (r102 == 5) goto L18;
        if (r102 == 1) goto L18;
        if (r102 == 6) goto L18;
        if (r102 == 3) goto L18;
    }

    public void requestSubtreeRasterSnapshot(float r100, SubtreeRasterSnapshotCallback r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 > 0.0f) goto L7;
    L11:
        r101.onError();
        return;
    L7:
        if (r100 > 1.0f) goto L11;
        nativeRequestSubtreeRasterSnapshot(this.viewPtr, r100, r101);
    }

    public void sendEvent(String r100, List<Object> r101) {
        if (r101 != null) goto L4;
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L7
    L5:
        nativeOnPlatformViewSendEvent(this.viewPtr, r100, r102.toString());     // Catch: Exception -> L7
        return;
    L4:
        r102 = new JSONArray(r101);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        c.b(TAG, "PlatformView sendEvent exception:", e);
    }

    @Override // n5a.j
    public void sendEvent(String r100, Map<String, Object> r101) {
        if (r101 != null) goto L4;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L7
    L5:
        nativeOnPlatformViewSendEvent(this.viewPtr, r100, r102.toString());     // Catch: Exception -> L7
        return;
    L4:
        r102 = new JSONObject(r101);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        c.b(TAG, "PlatformView sendEvent exception:", e);
    }

    public static /* synthetic */ void access$000(PlatformViewPlugin r100, MotionEvent r101, boolean r102) {
        r100.syncPlatformViewTouchDispatchResult(r101, r102);
    }

    private void invokePlatformMethod(String r100, long r101, byte[] r102) {
    L10:
        e = move-exception;
        c.b(TAG, "invokePlatformMethod exception:", e);
        return;
    L3:
        if (ensureFlutterViewAttached() == true) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L7;
        JSONObject r103 = new JSONObject(new String(r102, StandardCharsets.UTF_8));     // Catch: Exception -> L10
    L8:
        i r104 = this.platformViewContext;     // Catch: Exception -> L10
        n5a.b r105 = (n5a.b) r104;     // Catch: Exception -> L10
        r105.b(this.viewId, r100, r103, new b(this, r101));     // Catch: Exception -> L10
        return;
    L7:
        r103 = new JSONObject();     // Catch: Exception -> L10
        goto L8
    }

    private /* synthetic */ boolean lambda$onCreateView$1(MotionEvent r100, int r101, int r102) {
        return shouldDispatchSystemTouchEventToPlatformView(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [n5a.m] */
    private boolean onCreateView(int r110, String r111, SurfaceTexture r112) {
        FlutterView r100 = getFlutterView();
        if (r100 != null) goto L6;
        c.d(5, TAG, "onCreateView invoked without an attached FlutterView");
        return false;
    L6:
        if (r111 != null) goto L9;
        c.d(5, TAG, "onCreateView invoked with a null tag");
        return false;
    L9:
        this.viewId = r110;
        this.tag = r111;
        this.enableSystemTouchDispatch = false;
        InternalPlatformViewRegistry r101 = InternalPlatformViewRegistry.f380842e;
        monitor-enter(r101);
        r101.a();     // Catch: Throwable -> L79
        if (r101.f380843a.containsKey(r111) == true) goto L17;
        if (r101.f380844b.containsKey(r111) == true) goto L17;
        boolean r102 = false;
    L18:
        monitor-exit(r101);
        if (r102 == false) goto L21;
        this.isInternalView = true;
        this.platformViewContext = r100.getInternalPlatformViewContext();
    L23:
        if (ensureFlutterViewAttached() == true) goto L82;
        c.d(5, TAG, "onCreateView invoked before PlatformViewContext is ready, tag=".concat(r111));
        return false;
    L82:
        ((n5a.b) this.platformViewContext).a(r110, r111, this);     // Catch: Exception -> L29
        com.lynx.clay.embedding.engine.plugins.platformview.a r103 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) this.platformViewContext).f518057c).get(Integer.valueOf(r110));     // Catch: Exception -> L29
        if (r103 == null) goto L31;
        View r104 = r103.b();     // Catch: Exception -> L29
    L32:
        if (r104 == null) goto L76;
        if (r104.getParent() != null) goto L74;
        InternalPlatformViewRegistry.ViewDrawType r105 = InternalPlatformViewRegistry.ViewDrawType.DRAWABLE;     // Catch: Exception -> L29
        com.lynx.clay.embedding.engine.plugins.platformview.a r106 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) this.platformViewContext).f518057c).get(Integer.valueOf(r110));     // Catch: Exception -> L29
        LynxUIClayUIBridge$CompositionPreference r107 = LynxUIClayUIBridge$CompositionPreference.AUTO;     // Catch: Exception -> L29
        if (r106 == null) goto L39;
        r105 = r106.f380860f;     // Catch: Exception -> L29
        r107 = r106.f380861g;     // Catch: Exception -> L29
    L39:
        if (r105 == InternalPlatformViewRegistry.ViewDrawType.LOGICAL_ONLY) goto L41;
        boolean r113 = true;
    L42:
        boolean r114 = SYSTEM_TOUCH_DISPATCH_WHITELIST.contains(r111);     // Catch: Exception -> L29
        if (r112 != null) goto L48;
        l r108 = new l(r100, r110, r104, r113);     // Catch: Exception -> L29
        this.platformViewHolder = r108;     // Catch: Exception -> L29
        if (r114 == false) goto L72;
        this.enableSystemTouchDispatch = true;     // Catch: Exception -> L29
        r108.d(new m(this));     // Catch: Exception -> L29
    L72:
        return true;
    L48:
        if (Build.VERSION.SDK_INT < 23) goto L52;
        final Class[] r109 = VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY;     // Catch: Exception -> L29
        if (d.b(r104, new com.lynx.clay.util.c(r109)) == true) goto L52;
        boolean r115 = true;
    L54:
        if (r107 != LynxUIClayUIBridge$CompositionPreference.OFFSCREEN_SURFACE) goto L56;
        boolean r116 = true;
    L57:
        if (r116 == true) goto L83;
        if (r115 == false) goto L83;
    L63:
        if (this.platformViewHolder != null) goto L72;
        Context r117 = r100.getContext();     // Catch: Exception -> L29
        if (r114 == false) goto L67;
        n r118 = new n(this);     // Catch: Exception -> L29
    L68:
        if (r114 == false) goto L70;
        a r119 = new a(this);     // Catch: Exception -> L29
    L71:
        this.platformViewHolder = new p(r117, r112, r104, r113, r114, r118, r119);     // Catch: Exception -> L29
        this.enableSystemTouchDispatch = r114;     // Catch: Exception -> L29
        goto L72
    L70:
        r119 = null;
        goto L71
    L67:
        r118 = null;
    L83:
        this.platformViewHolder = new o(r100.getContext(), r112, r110, r104);     // Catch: Exception -> L61
    L61:
        this.platformViewHolder = null;     // Catch: Exception -> L29
        goto L63
    L56:
        r116 = false;
    L52:
        r115 = false;
        goto L54
    L41:
        r113 = false;
        goto L42
    L74:
        throw new IllegalStateException("PlatformView with id: " + r110 + " already added to parent view");     // Catch: Exception -> L29
    L76:
        throw new IllegalStateException("PlatformView with id: " + r110 + " not created");     // Catch: Exception -> L29
    L31:
        r104 = null;
    L29:
        e = move-exception;
        c.b(TAG, "onCreateView exception:", e);
        return false;
    L21:
        this.isInternalView = false;
        this.platformViewContext = r100.getExternalPlatformViewContext();
    L17:
        r102 = true;
    L79:
        th = move-exception;
        throw th;
    }

    private long onLayout(int r100, int r101, int r102, int r103) {
        if (ensureFlutterViewAttached() == false) goto L16;
        k r104 = this.platformViewHolder;
        if (r104 == null) goto L16;
        Size r105 = r104.c(r100, r101, r102, r103);
        if (r105 != null) goto L10;
        r105 = new Size(0, 0);
    L10:
        i r106 = this.platformViewContext;
        int r107 = this.viewId;
        com.lynx.clay.embedding.engine.plugins.platformview.a r108 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r106).f518057c).get(Integer.valueOf(r107));
        if (r108 == null) goto L15;
        r108.i(r100, r101, r102, r103);
    L15:
        return ((long) r105.getWidth()) | (((long) r105.getHeight()) << 32);
    L16:
        c.d(5, TAG, "onLayout invoked before platform view is ready, viewId=" + this.viewId);
        return 0;
    }

    private float[] onMeasure(int r100, int r101, int r102, int r103) {
        if (ensureFlutterViewAttached() == false) goto L11;
        i r104 = this.platformViewContext;
        int r105 = this.viewId;
        MeasureMode r106 = MeasureMode.fromInt(r100);
        MeasureMode r107 = MeasureMode.fromInt(r102);
        com.lynx.clay.embedding.engine.plugins.platformview.a r108 = (com.lynx.clay.embedding.engine.plugins.platformview.a) ((HashMap) ((n5a.b) r104).f518057c).get(Integer.valueOf(r105));
        if (r108 == null) goto L7;
        h r109 = r108.f(r106, r101, r107, r103);
    L8:
        float[] r110 = r109.f518059a;
        return new float[]{r110[0], r110[1], r110[2]};
    L7:
        r109 = new h(0.0f, 0.0f);
        goto L8
    L11:
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private void updatePaddings(float r100, float r101, float r102, float r103) {
        if (ensureFlutterViewAttached() == false) goto L8;
        i r104 = this.platformViewContext;
        int r105 = this.viewId;
        Map<Integer, com.lynx.clay.embedding.engine.plugins.platformview.a> r106 = ((n5a.b) r104).f518057c;
        HashMap r107 = (HashMap) r106;
        com.lynx.clay.embedding.engine.plugins.platformview.a r108 = (com.lynx.clay.embedding.engine.plugins.platformview.a) r107.get(Integer.valueOf(r105));
        if (r108 == null) goto L9;
        r108.r(r100, r101, r102, r103);
        return;
    L9:
        return;
    }
}
