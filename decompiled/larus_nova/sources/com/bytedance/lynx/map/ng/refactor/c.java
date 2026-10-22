package com.bytedance.lynx.map.ng.refactor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.map.api.model.IMarker;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends LynxAbstractMapView.a<IMarker> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxUIMapMarker f264745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a<IMarker> f264746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IMarker f264747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f264748d;

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.bytedance.lynx.map.ng.refactor.a.InterfaceC3711a
    public final void a() {
        LynxUIMapMarker r100 = this.f264745a;
        if (r100 == null) goto L6;
        LynxUIMapMarker.sendEvent$default(r100, "clickmarker", null, 2, null);
        return;
    }

    public final Bitmap c() {
        LynxUIMapMarker r100 = this.f264745a;
        int r101 = 1;
        if (r100 == null) goto L5;
        int r102 = RangesKt.coerceAtLeast(r100.getWidth(), 1);
    L6:
        LynxUIMapMarker r103 = this.f264745a;
        if (r103 == null) goto L9;
        r101 = RangesKt.coerceAtLeast(r103.getHeight(), 1);
    L9:
        Bitmap r104 = Bitmap.createBitmap(r102, r101, Bitmap.Config.ARGB_8888);
        super.dispatchDraw(new Canvas(r104));
        return r104;
    L5:
        r102 = 1;
        goto L6
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.bytedance.lynx.map.ng.refactor.a.InterfaceC3711a
    public /* bridge */ /* synthetic */ Object getMarkerObject() {
        return getMarkerObject();
    }

    @Override // com.bytedance.lynx.map.ng.refactor.LynxAbstractMapView.a, com.bytedance.lynx.map.ng.refactor.a.InterfaceC3711a
    public IMarker getMarkerObject() {
        return this.f264747c;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        setLayerType(1, null);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        IMarker r101 = this.f264747c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L12;
        a<IMarker> r102 = this.f264746b;
        if (r102 == null) goto L11;
        String r103 = this.f264748d;
        Intrinsics.checkNotNull(r103);
        r102.b(r103, null, c());
        return;
    L11:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r100, int r101) {
        LynxUIMapMarker r102 = this.f264745a;
        int r103 = 1;
        if (r102 == null) goto L5;
        int r104 = RangesKt.coerceAtLeast(r102.getWidth(), 1);
    L6:
        LynxUIMapMarker r105 = this.f264745a;
        if (r105 == null) goto L9;
        r103 = RangesKt.coerceAtLeast(r105.getHeight(), 1);
    L9:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r104, 1073741824), View.MeasureSpec.makeMeasureSpec(r103, 1073741824));
        return;
    L5:
        r104 = 1;
        goto L6
    }
}
