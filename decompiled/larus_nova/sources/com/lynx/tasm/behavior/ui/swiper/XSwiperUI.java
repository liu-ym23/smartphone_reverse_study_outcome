package com.lynx.tasm.behavior.ui.swiper;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.i;
import com.lynx.tasm.utils.n;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
@LynxBehavior(isCreateAsync = true, tagName = {"swiper"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
public class XSwiperUI extends UISimpleView<SwiperView> {
    public static final int G = 0;
    public static final int H = 0;
    public final com.lynx.tasm.behavior.ui.swiper.b A;
    public final com.lynx.tasm.behavior.ui.swiper.a B;
    public final Handler C;
    public final List<View> D;
    public final a E;
    public b F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f383037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f383038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f383039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f383040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f383041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f383042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f383043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f383044h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f383045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f383046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f383047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f383048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f383049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f383050n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f383051o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f383052p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f383053q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f383054r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f383055s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f383056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f383057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f383058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f383059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f383060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f383061y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f383062z;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<XSwiperUI> f383063a;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            XSwiperUI r100 = this.f383063a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.f383057u == true) goto L7;
            return;
        L7:
            if (r100.f383050n == false) goto L20;
            ViewPager r101 = ((SwiperView) r100.getView()).f382994a;
            boolean r102 = true;
            int r103 = r101.getCurrentIndex() + 1;
            if (r103 == r101.getTotalCount()) goto L11;
        L15:
            r102 = false;
        L16:
            r100.Z(r101, r103, r100.f383052p, r102);
            r100.C.postDelayed(this, r100.f383053q);
            return;
        L11:
            if (r100.f383058v == false) goto L13;
        L14:
            r103 = 0;
            goto L16
        L13:
            if (r100.f383051o == false) goto L15;
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

        public a(XSwiperUI r100) {
            this.f383063a = new WeakReference(r100);
        }
    }

    public class b extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XSwiperUI f383064a;

        public final boolean canScroll() {
            XSwiperUI r100 = this.f383064a;
            if (r100.f383062z == true) goto L5;
        L11:
            return false;
        L5:
            if (((SwiperView) XSwiperUI.T(r100)).f382994a == null) goto L11;
            List<View> r101 = this.f383064a.D;
            if (r101 == null) goto L11;
            if (((ArrayList) r101).size() <= 1) goto L11;
            return true;
        }

        public b(XSwiperUI r100) {
            this.f383064a = r100;
        }

        public final boolean a(ViewPager r100, int r101) {
            if (this.f383064a.f383049m == false) goto L7;
            if (r100.canScrollVertically(r101) == false) goto L7;
        L10:
            return true;
        L7:
            if (this.f383064a.f383049m == false) goto L9;
        L11:
            return false;
        L9:
            if (r100.canScrollHorizontally(r101) == false) goto L11;
            goto L10
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            if (((SwiperView) XSwiperUI.O(this.f383064a)).f382994a == null) goto L10;
            r101.setClassName(ViewPager.class.getName());
            boolean r102 = canScroll();
            r101.setScrollable(r102);
            if (r102 == true) goto L7;
            return;
        L7:
            if (r101.getEventType() != 4096) goto L12;
            r101.setItemCount(((ArrayList) this.f383064a.D).size());
            return;
        L12:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            boolean r102 = canScroll();
            r101.setScrollable(r102);
            if (((SwiperView) XSwiperUI.R(this.f383064a)).f382994a == null) goto L12;
            List<View> r103 = this.f383064a.D;
            if (r103 == null) goto L12;
            if (((ArrayList) r103).isEmpty() == true) goto L12;
            XSwiperUI r104 = this.f383064a;
            if (r104.f383049m == false) goto L12;
            int r105 = ((ArrayList) r104.D).size();
        L14:
            if (((SwiperView) XSwiperUI.S(this.f383064a)).f382994a == null) goto L24;
            List<View> r106 = this.f383064a.D;
            if (r106 == null) goto L24;
            if (((ArrayList) r106).isEmpty() == true) goto L24;
            XSwiperUI r107 = this.f383064a;
            if (r107.f383049m == true) goto L24;
            int r108 = ((ArrayList) r107.D).size();
        L25:
            r101.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(r105, r108, false, 0));
            ViewPager r109 = ((SwiperView) XSwiperUI.P(this.f383064a)).f382994a;
            if (r102 == false) goto L43;
            if (r109 != null) goto L29;
            return;
        L29:
            if (this.f383064a.f383049m == false) goto L37;
            if (r109.canScrollVertically(1) == false) goto L34;
            r101.addAction(4096);
        L34:
            if (r109.canScrollVertically(-1) == false) goto L45;
            r101.addAction(8192);
            return;
        L45:
            return;
        L37:
            if (r109.canScrollHorizontally(1) == false) goto L40;
            r101.addAction(4096);
        L40:
            if (r109.canScrollHorizontally(-1) == false) goto L47;
            r101.addAction(8192);
            return;
        L47:
            return;
        L43:
            return;
        L24:
            r108 = 1;
        L12:
            r105 = 1;
            goto L14
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L5;
            return true;
        L5:
            ViewPager r103 = ((SwiperView) XSwiperUI.Q(this.f383064a)).f382994a;
            if (r103 != null) goto L8;
        L23:
            return false;
        L8:
            if (r103.getCurrentIndex() == (-1)) goto L23;
            int r104 = r103.getCurrentIndex();
            if (r101 == 4096) goto L20;
            if (r101 != 8192) goto L23;
            if (a(r103, -1) == false) goto L18;
            this.f383064a.setCurrentIndex(r104 - 1);
            return true;
        L18:
            return false;
        L20:
            if (a(r103, 1) == false) goto L23;
            this.f383064a.setCurrentIndex(r104 + 1);
            return true;
        }
    }

    public XSwiperUI() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellPrepareForReuse(String r100, LynxBaseUI r101) {
    }

    static {
        G = Color.argb(255, 255, 255, 255);
        H = Color.argb(89, 255, 255, 255);
    }

    public final void W() {
        com.lynx.tasm.behavior.ui.accessibility.d r100 = this.mContext.getLynxAccessibilityWrapper();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.e() == true) goto L9;
        if (r100.f() == true) goto L9;
        return;
    L9:
        if (this.F != null) goto L11;
        this.F = new b(this);
    L11:
        ViewPager r101 = ((SwiperView) this.mView).f382994a;
        if (r101 == null) goto L17;
        ViewCompat.setAccessibilityDelegate(r101, this.F);
        ViewCompat.setImportantForAccessibility(r101, 1);
        ViewCompat.setImportantForAccessibility(this.mView, 2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final View getAccessibilityHostView() {
        return ((SwiperView) this.mView).f382994a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        ((SwiperView) getView()).f382994a.setAdapter(new e(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        int r100 = getWidth();
        int r101 = getHeight();
        super.onLayoutUpdated();
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((SwiperView) this.mView).setPadding(this.mPaddingLeft + this.mBorderLeftWidth, r102, this.mPaddingRight + this.mBorderRightWidth, r103);
        ((ArrayList) this.D).clear();
        Iterator<LynxBaseUI> r104 = this.mChildren.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        LynxBaseUI r105 = r104.next();
        ((ArrayList) this.D).add(((LynxUI) r105).getView());
        goto L4
    L6:
        X();
        ((SwiperView) this.mView).c(isRtl());
        if (getOverflow() == 0) goto L9;
        ((SwiperView) this.mView).setClipChildren(false);
    L9:
        boolean r106 = true;
        if (this.f383044h == r100) goto L12;
        boolean r107 = true;
    L14:
        if (this.f383045i != r101) goto L17;
        r106 = false;
    L17:
        V(r107, r106, false);
        if (this.f383044h == r100) goto L20;
    L21:
        float r108 = r100;
        float r109 = r101;
        if (this.f383043g == true) goto L24;
    L28:
        this.f383044h = r100;
        this.f383045i = r101;
        return;
    L24:
        if (this.mContext.getScreenMetrics() == null) goto L28;
        m7a.a r110 = new m7a.a(getSign(), "contentsizechanged");
        r110.a("contentWidth", Float.valueOf(i.c(r108)));
        r110.a("contentHeight", Float.valueOf(i.c(r109)));
        if (getLynxContext() == null) goto L28;
        getLynxContext().getEventEmitter().sendCustomEvent(r110);
        goto L28
    L20:
        if (this.f383045i != r101) goto L21;
        return;
    L12:
        r107 = false;
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReload() {
        super.onNodeReload();
        Y(0, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.f383059w == false) goto L5;
        V(false, false, true);
        this.f383059w = false;
    L5:
        W();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isAccessibilityDirectionVertical() {
        return this.f383049m;
    }

    public static /* synthetic */ View M(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View N(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View O(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View P(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View Q(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View R(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View S(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View T(XSwiperUI r100) {
        return r100.mView;
    }

    public static /* synthetic */ View U(XSwiperUI r100) {
        return r100.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        SwiperView r101 = new SwiperView(r100, null);
        ViewPager r102 = r101.f382994a;
        c r103 = new c(this, r101);
        ((ArrayList) r102.U).add(r103);
        r101.addOnAttachStateChangeListener(new d(this));
        LLog.i("LynxSwiperUI", "create Android NewSwiperView");
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r100) {
        if ((r100 instanceof LynxUI) == false) goto L9;
        this.mChildren.remove(r100);
        List<View> r101 = this.D;
        ArrayList r102 = (ArrayList) r101;
        r102.remove(((LynxUI) r100).getView());
        X();
        SwiperView r103 = (SwiperView) getView();
        if (r103.f382995b.getChildCount() <= 0) goto L7;
        r103.f382995b.removeViewAt(0);
        r103.f382999f = r103.f382999f;
        r103.e();
    L7:
        V(false, false, true);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "autoplay")
    public void setAutoPlay(boolean r100) {
        this.f383050n = r100;
        this.C.removeCallbacks(this.E);
        if (this.f383050n == false) goto L6;
        this.C.postDelayed(this.E, this.f383053q);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-begin-threshold")
    public void setBounceBeginThreshold(float r100) {
        ((SwiperView) getView()).f382994a.setBounceBeginThreshold(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = 500, name = "bounce-duration")
    public void setBounceDuration(int r100) {
        ((SwiperView) getView()).f382994a.setBounceDuration(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-end-threshold")
    public void setBounceEndThreshold(float r100) {
        ((SwiperView) getView()).f382994a.setBounceEndThreshold(r100);
    }

    @LynxProp(defaultBoolean = false, name = "circular")
    public void setCircular(boolean r100) {
        this.f383051o = r100;
        ((SwiperView) this.mView).f382994a.setLoop(r100);
    }

    @LynxProp(defaultBoolean = true, name = "compatible")
    public void setCompatible(boolean r100) {
        this.f383060x = r100;
        this.f383059w = true;
    }

    @LynxProp(defaultInt = 0, name = "current")
    public void setCurrentIndex(int r100) {
        Y(r100, this.f383052p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = 500, name = "duration")
    public void setDuration(int r100) {
        this.f383054r = r100;
        if (this.f383052p == false) goto L5;
        ((SwiperView) getView()).f382994a.setAnimDuration(r100);
        return;
    L5:
        ((SwiperView) getView()).f382994a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "enable-bounce")
    public void setEnableBounce(boolean r100) {
        ((SwiperView) getView()).f382994a.setEnableBounce(r100);
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-child")
    public void setEnableNestedChild(boolean r100) {
        ViewPager r101 = ((SwiperView) this.mView).f382994a;
        if (r101 == null) goto L6;
        r101.setEnableNestedChild(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "enable-vice-loop")
    public void setEnableViceLoop(boolean r100) {
        ((SwiperView) getView()).f382994a.setEnableViceLoop(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L6;
        this.f383038b = r100.containsKey("change");
        this.f383039c = r100.containsKey("scrollstart");
        this.f383040d = r100.containsKey("scrollend");
        this.f383041e = r100.containsKey("transition");
        this.f383042f = r100.containsKey("scrolltobounce");
        this.f383043g = r100.containsKey("contentsizechanged");
        return;
    }

    @LynxProp(defaultBoolean = false, name = "finish-reset")
    public void setFinishReset(boolean r100) {
        this.f383058v = r100;
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean r100) {
        ((SwiperView) this.mView).f382994a.setForceCanScroll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "handle-gesture")
    public void setHandleGesture(boolean r100) {
        ((SwiperView) getView()).f382994a.setHandleGesture(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "ignore-layout-update")
    public void setIgnoreLayoutUpdate(boolean r100) {
        ((SwiperView) getView()).f382994a.setIgnoreLayoutUpdate(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "indicator-dots")
    public void setIndicator(boolean r100) {
        LinearLayout r101 = ((SwiperView) getView()).f382995b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-active-color")
    public void setIndicatorActiveColor(String r100) {
        int r101 = ColorUtils.b(r100);     // Catch: Exception -> L4
    L5:
        SwiperView r102 = (SwiperView) getView();
        r102.f382997d = r101;
        int r103 = r102.f382995b.getChildCount() - 1;
    L6:
        if (r103 <= (-1)) goto L16;
        if (r103 == r102.f382999f) goto L9;
        r103 = r103 - 1;
        goto L6
    L9:
        r102.f382995b.getChildAt(r103).setBackground(r102.b(r102.f382997d));
        return;
    L16:
        return;
    L4:
        r101 = G;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-color")
    public void setIndicatorColor(String r100) {
        int r101 = ColorUtils.b(r100);     // Catch: Exception -> L4
    L5:
        SwiperView r102 = (SwiperView) getView();
        r102.f382998e = r101;
        int r103 = r102.f382995b.getChildCount() - 1;
    L6:
        if (r103 <= (-1)) goto L12;
        if (r103 == r102.f382999f) goto L11;
        r102.f382995b.getChildAt(r103).setBackground(r102.b(r102.f382998e));
    L11:
        r103 = r103 - 1;
        goto L6
    L12:
        return;
    L4:
        r101 = H;
        goto L5
    }

    @LynxProp(defaultInt = 5000, name = VideoThumbInfo.KEY_INTERVAL)
    public void setInterval(int r100) {
        this.f383053q = r100;
    }

    @LynxProp(defaultBoolean = false, name = "keep-item-view")
    public void setKeepItemView(boolean r100) {
        ((SwiperView) this.mView).f382994a.setKeepItemView(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLynxDirection(int r100) {
        super.setLynxDirection(r100);
        if (r100 == 2) goto L7;
        if (r100 == 2) goto L7;
        ((SwiperView) getView()).c(false);
    L8:
        this.f383059w = true;
        return;
    L7:
        ((SwiperView) getView()).c(true);
        goto L8
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double r100) {
        float r101 = (float) r100;
        this.B.f383067c = r101;
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double r100) {
        float r101 = (float) r100;
        this.B.f383069e = r101;
    }

    @LynxProp(name = "min-x-scale")
    public void setMinXScale(double r100) {
        float r101 = (float) r100;
        this.B.f383066b = r101;
    }

    @LynxProp(name = "min-y-scale")
    public void setMinYScale(double r100) {
        float r101 = (float) r100;
        this.B.f383068d = r101;
    }

    @LynxProp(name = "mode")
    public void setMode(String r100) {
        this.f383037a = r100;
        this.f383059w = true;
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(f6a.a r110) {
        if (r110.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r100 = r110.asString();
        if (r100.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L8;
    L9:
        int r111 = (int) n.b(r100, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        if (r111 >= 0) goto L13;
        r111 = -1;
    L13:
        this.f383047k = r111;
        this.f383059w = true;
        return;
    L8:
        if (r100.endsWith("rpx") == true) goto L9;
    }

    @LynxProp(defaultFloat = 0.0f, name = "norm-translation-factor")
    public void setNormalTranslationFactor(double r100) {
        if (r100 <= 1.0d) goto L5;
        return;
    L5:
        if (r100 < (-1.0d)) goto L9;
        float r101 = (float) r100;
        this.B.f383065a = r101;
        this.f383059w = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "orientation")
    public void setOrientation(String r100) {
        if ("vertical".equals(r100) == false) goto L6;
        this.f383049m = true;
        ((SwiperView) getView()).d(1);
    L8:
        this.f383059w = true;
        return;
    L6:
        if ("horizontal".equals(r100) == false) goto L8;
        this.f383049m = false;
        ((SwiperView) getView()).d(0);
        goto L8
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(f6a.a r110) {
        if (r110.getType() != ReadableType.String) goto L14;
        String r100 = r110.asString();
        if (r100.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L7;
    L8:
        int r111 = (int) n.b(r100, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().getScreenMetrics());
        if (r111 > 0) goto L12;
        r111 = 0;
    L12:
        this.f383046j = r111;
        this.f383059w = true;
        return;
    L7:
        if (r100.endsWith("rpx") == true) goto L8;
        return;
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(f6a.a r110) {
        if (r110.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r100 = r110.asString();
        if (r100.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L8;
    L9:
        int r111 = (int) n.b(r100, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        if (r111 >= 0) goto L13;
        r111 = -1;
    L13:
        this.f383048l = r111;
        this.f383059w = true;
        return;
    L8:
        if (r100.endsWith("rpx") == true) goto L9;
    }

    @LynxProp(defaultBoolean = false, name = "scroll-before-detached")
    public void setScrollBeforeDetached(boolean r100) {
        this.f383061y = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "smooth-scroll")
    public void setSmoothScroll(boolean r100) {
        this.f383052p = r100;
        if (r100 == false) goto L5;
        ((SwiperView) getView()).f382994a.setAnimDuration(this.f383054r);
        return;
    L5:
        ((SwiperView) getView()).f382994a.setAnimDuration(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "touchable")
    public void setTouchable(boolean r100) {
        this.f383062z = r100;
        ((SwiperView) getView()).f382994a.setTouchable(r100);
    }

    @LynxProp(defaultInt = 0, name = "transition-throttle")
    public void setTransitionThrottle(int r100) {
        this.f383055s = r100;
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r100) {
        if (r100 == false) goto L5;
        ((SwiperView) this.mView).d(1);
    L6:
        this.f383049m = r100;
        this.f383059w = true;
        return;
    L5:
        ((SwiperView) this.mView).d(0);
        goto L6
    }

    public XSwiperUI(LynxContext r100, Object r101) {
        super(r100, r101);
        this.f383037a = "normal";
        this.f383038b = false;
        this.f383039c = false;
        this.f383040d = false;
        this.f383041e = false;
        this.f383042f = false;
        this.f383043g = false;
        this.f383044h = -1;
        this.f383045i = -1;
        this.f383046j = -1;
        this.f383047k = -1;
        this.f383048l = -1;
        this.f383049m = false;
        this.f383050n = false;
        this.f383051o = false;
        this.f383052p = true;
        this.f383053q = 5000;
        this.f383054r = 500;
        this.f383055s = 0;
        this.f383056t = 0;
        this.f383057u = false;
        this.f383058v = false;
        this.f383059w = false;
        this.f383060x = true;
        this.f383061y = false;
        this.f383062z = true;
        this.A = new com.lynx.tasm.behavior.ui.swiper.b();
        this.B = new com.lynx.tasm.behavior.ui.swiper.a();
        this.C = new Handler(Looper.getMainLooper());
        this.D = new ArrayList();
        this.E = new a(this);
        this.F = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(int r100, boolean r101) {
        ViewPager r102 = ((SwiperView) getView()).f382994a;
        if (r102.getChildCount() <= 0) goto L5;
        r102.f383013h = r100;
        r102.f383004a = r101;
        Z(r102, r100, r101, false);
        return;
    L5:
        r102.f383013h = r100;
        r102.f383004a = false;
    }

    public final boolean a0(ViewPager r100, int r101) {
        int r102 = this.f383048l;
        int r103 = this.f383047k;
        int r104 = (r101 - r102) - r103;
        int r105 = this.f383046j;
        int r106 = (r104 - r105) - r105;
        if (this.f383060x == false) goto L6;
        r104 = r106;
    L6:
        if (r102 < 0) goto L20;
        if (r103 < 0) goto L22;
        if (r104 <= 0) goto L23;
        r100.setPageSize(r104);
        int r107 = this.f383048l;
        int r108 = this.f383046j + r107;
        if (this.f383060x == false) goto L14;
        r107 = r108;
    L14:
        if (isRtl() == true) goto L16;
    L18:
        r100.u(r107, false);
    L19:
        return false;
    L16:
        if (this.f383049m == true) goto L18;
        r100.u(-r107, false);
        goto L19
    L23:
        return true;
    L22:
        return true;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r100, int r101) {
        if ((r100 instanceof LynxUI) == false) goto L6;
        ListProtector.add(this.mChildren, r101, r100);
        r100.setParent(this);
        ListProtector.add(this.D, r101, ((LynxUI) r100).getView());
        X();
        ((SwiperView) getView()).a();
        V(false, false, true);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void onListCellAppear(String r100, UIList r101) {
        super.onListCellPrepareForReuse(r100, r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String r102 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        if (((HashMap) r101.f382656y).containsKey(r102) == false) goto L8;
        int r103 = ((Integer) ((HashMap) r101.f382656y).get(r102)).intValue();
    L9:
        Y(r103, false);
        return;
    L8:
        r103 = -1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void scrollTo(ReadableMap r110, Callback r111) {
        ViewPager r100 = ((SwiperView) getView()).f382994a;
        if (r100 != null) goto L5;
    L23:
        r111.invoke(new Object[]{1, "Check failed when invoking scrollTo method: viewPager == null || adapter == null"});
        return;
    L5:
        if (r100.getAdapter() == null) goto L23;
        int r101 = r110.getInt("index", -1);
        boolean r102 = r110.getBoolean("smooth", this.f383052p);
        int r112 = !r110.getString("direction", "end").equals(GearStrategyConsts.EV_SELECT_BEGIN) ? 1 : 0;
        if (r100.getChildCount() != 0) goto L11;
        r111.invoke(new Object[]{1, "Check failed when invoking scrollTo method: no swiper item added to viewpager"});
        return;
    L11:
        if (r101 >= 0) goto L13;
    L21:
        r111.invoke(new Object[]{4, "Check failed when invoking scrollTo method: index < 0 or index >= data count"});
        return;
    L13:
        if (r101 >= r100.getTotalCount()) goto L21;
        int r103 = r100.getTotalCount();
        if (r101 < 0) goto L19;
        if (r101 >= r103) goto L19;
        r100.t(r101, r102, r112);
    L19:
        r111.invoke(new Object[]{0});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V(boolean r100, boolean r101, boolean r102) {
        ViewPager r103 = ((SwiperView) getView()).f382994a;
        if (this.f383049m == false) goto L5;
        int r104 = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - getBorderTopWidth();
        int r105 = getBorderBottomWidth();
    L6:
        int r106 = r104 - r105;
        if (r106 != 0) goto L9;
        return;
    L9:
        r103.setHLayoutUpdated(r100);
        r103.setVLayoutUpdated(r101);
        r103.setPropsUpdated(r102);
        r103.setPageMargin(this.f383046j);
        String r107 = this.f383037a;
        r107.getClass();
        byte r108 = -1;
        switch(r107.hashCode()) {
            case -1039745817: goto L29;
            case 2908512: goto L25;
            case 94431515: goto L21;
            case 1720139793: goto L17;
            case 1980277093: goto L13;
            default: goto L33;
        };
    L13:
        if (r107.equals("coverflow") == false) goto L33;
        r108 = 4;
        goto L33
    L17:
        if (r107.equals("flat-coverflow") == false) goto L33;
        r108 = 3;
        goto L33
    L21:
        if (r107.equals("carry") == false) goto L33;
        r108 = 2;
        goto L33
    L25:
        if (r107.equals("carousel") == false) goto L33;
        r108 = 1;
        goto L33
    L29:
        if (r107.equals("normal") == false) goto L33;
        r108 = 0;
    L33:
        switch(r108) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L51;
            case 3: goto L43;
            case 4: goto L35;
            default: goto L56;
        };
    L35:
        r103.setTransformer(this.A);
        if (a0(r103, r106) == false) goto L56;
        float r109 = r106;
        r103.setPageSize((int) Math.ceil(0.6f * r109));
        int r110 = (int) ((r109 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L40;
    L42:
        r103.u(r110, false);
        goto L56
    L40:
        if (this.f383049m == true) goto L42;
        r103.u(-r110, false);
        goto L56
    L43:
        r103.setTransformer(null);
        if (a0(r103, r106) == false) goto L56;
        float r111 = r106;
        r103.setPageSize((int) Math.ceil(0.6f * r111));
        int r112 = (int) ((r111 * 0.4f) / 2.0f);
        if (isRtl() == true) goto L48;
    L50:
        r103.u(r112, false);
        goto L56
    L48:
        if (this.f383049m == true) goto L50;
        r103.u(-r112, false);
        goto L56
    L51:
        r103.setTransformer(this.B);
        if (a0(r103, r106) == false) goto L56;
        r103.setPageSize(r106);
        r103.u(0, false);
        goto L56
    L54:
        r103.setPageSize((int) Math.ceil(r106 * 0.8f));
        r103.setTransformer(null);
        r103.u(0, false);
        goto L56
    L55:
        r103.setPageSize(r106);
        r103.setTransformer(null);
        r103.u(0, false);
    L56:
        r103.requestLayout();
        return;
    L5:
        r104 = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getBorderLeftWidth();
        r105 = getBorderRightWidth();
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r100, LynxBaseUI r101, boolean r102) {
        super.onListCellDisAppear(r100, r101, r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        String r103 = constructListStateCacheKey(getTagName(), r100, getIdSelector());
        if (r102 == false) goto L8;
        r101.storeKeyToNativeStorage(r103, Integer.valueOf(((SwiperView) this.mView).f382994a.getCurrentIndex()));
        return;
    L8:
        r101.removeKeyFromNativeStorage(r103);
    }

    public final void Z(ViewPager r100, int r101, boolean r110, boolean r111) {
        int r102 = r100.getTotalCount();
        int r103 = r100.getCurrentIndex();
        boolean r104 = this.f383051o;
        int r105 = 1;
        if (r104 == false) goto L15;
        if (r101 != 0) goto L15;
        if (r103 != (r102 - 1)) goto L15;
        if (r102 > 2) goto L11;
        if (r111 == true) goto L11;
        r105 = 0;
    L11:
        int r112 = r100.getTotalCount();
        if (r101 < 0) goto L32;
        if (r101 >= r112) goto L33;
        r100.t(r101, r110, r105);
        return;
    L33:
        return;
    L32:
        return;
    L15:
        if (r104 == true) goto L17;
    L25:
        if (r101 >= r103) goto L27;
        r105 = 0;
    L27:
        int r113 = r100.getTotalCount();
        if (r101 < 0) goto L38;
        if (r101 >= r113) goto L39;
        r100.t(r101, r110, r105);
        return;
    L39:
        return;
    L38:
        return;
    L17:
        if (r101 != (r102 - 1)) goto L25;
        if (r103 != 0) goto L25;
        if (r102 <= 2) goto L21;
        r105 = 0;
    L21:
        int r114 = r100.getTotalCount();
        if (r101 < 0) goto L35;
        if (r101 >= r114) goto L36;
        r100.t(r101, r110, r105);
        return;
    L36:
        return;
    }
}
