package com.bytedance.lynx.map.ng.refactor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.lynx.react.bridge.ReadableArray;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.result.recycler.ECSaasScrollViewController;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/lynx/map/ng/refactor/LynxAbstractMapView;", "M", "Landroid/widget/FrameLayout;", "Lcom/bytedance/lynx/map/ng/refactor/a;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getNativeInteractionEnabled", "()Z", "setNativeInteractionEnabled", "(Z)V", "nativeInteractionEnabled", "b", "getDragging", "setDragging", ECSaasScrollViewController.SEARCH_SCROLL_STATE_DRAGGING, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "x-element-map-ng_release"}, k = 1, mv = {1, 6, 0})
public abstract class LynxAbstractMapView<M> extends FrameLayout implements com.bytedance.lynx.map.ng.refactor.a<M> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f264659c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f264660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f264661b;

    public static abstract class a<M> extends com.lynx.tasm.behavior.ui.view.a implements com.bytedance.lynx.map.ng.refactor.a.InterfaceC3711a<M> {
        @Override // com.bytedance.lynx.map.ng.refactor.a.InterfaceC3711a
        public abstract /* synthetic */ M getMarkerObject();

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostHeight() {
            return x6a.d.e(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
            return x6a.d.f(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
            return x6a.d.g(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ int getRendererHostWidth() {
            return x6a.d.h(this);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
            x6a.d.k(this, r100);
        }

        @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
        public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
            x6a.d.l(this, r100);
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            new LinkedHashMap();
            super(r100);
        }
    }

    public LynxAbstractMapView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LynxAbstractMapView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public boolean f() {
        return false;
    }

    public abstract /* synthetic */ List<Pair<Double, Double>> getBound();

    public abstract /* synthetic */ Pair<Double, Double> getCenter();

    public abstract /* synthetic */ double getScale();

    public abstract /* synthetic */ void setArcs(ReadableArray r100);

    public abstract /* synthetic */ void setCircles(ReadableArray r100);

    public abstract /* synthetic */ void setEnableDrag(boolean r100);

    public abstract /* synthetic */ void setEnableRotate(boolean r100);

    public abstract /* synthetic */ void setEnableScale(boolean r100);

    public abstract /* synthetic */ void setEnableScaleControls(boolean r100);

    public abstract /* synthetic */ void setEnableTilt(boolean r100);

    public abstract /* synthetic */ void setLogoPosition(String r100);

    public abstract /* synthetic */ void setMapStyle(String r100);

    public abstract /* synthetic */ void setPolygons(ReadableArray r100);

    public abstract /* synthetic */ void setPolyline(ReadableArray r100);

    public abstract /* synthetic */ void setRotationDegree(double r100);

    public abstract /* synthetic */ void setRouteLabel(ReadableArray r100);

    public final boolean getDragging() {
        return this.f264661b;
    }

    public final boolean getNativeInteractionEnabled() {
        return this.f264660a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f264660a == true) goto L6;
        return true;
    L6:
        if (f() == false) goto L25;
        int r101 = r100.getAction();
        if (r101 == 0) goto L21;
        if (r101 != 1) goto L11;
    L18:
        ViewParent r102 = getParent();
        if (r102 == null) goto L25;
        r102.requestDisallowInterceptTouchEvent(false);
        goto L25
    L11:
        if (r101 != 2) goto L13;
        ViewParent r103 = getParent();
        if (r103 == null) goto L25;
        r103.requestDisallowInterceptTouchEvent(true);
        goto L25
    L13:
        if (r101 == 3) goto L18;
    L21:
        ViewParent r104 = getParent();
        if (r104 == null) goto L25;
        r104.requestDisallowInterceptTouchEvent(true);
    L25:
        return super.dispatchTouchEvent(r100);
    }

    public final void setDragging(boolean r100) {
        this.f264661b = r100;
    }

    public final void setNativeInteractionEnabled(boolean r100) {
        this.f264660a = r100;
    }

    public LynxAbstractMapView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f264660a = true;
        setOnTouchListener(new b(this));
    }

    public /* synthetic */ LynxAbstractMapView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
