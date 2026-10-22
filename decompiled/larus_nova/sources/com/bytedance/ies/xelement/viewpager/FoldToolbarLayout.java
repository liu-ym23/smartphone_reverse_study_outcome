package com.bytedance.ies.xelement.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0019B\u000f\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0012\u001a\u00020\u0011H&J\r\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010\u001f\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00028\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010+R\"\u00103\u001a\u00020\u00178\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010:\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Lx6a/e;", "", "scrollEnable", "", "setScrollEnable", "Lx6a/i;", "renderer", "setRenderer", "getRenderer", "Landroid/view/View;", "getView", "compatContainerPopup", "setCompatContainerPopup", "", "getLayoutIntRes", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/appcompat/widget/Toolbar;", "getFoldToolBar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbarLayout", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMScrollEnable", "()Z", "setMScrollEnable", "(Z)V", "mScrollEnable", "b", "I", "getMInitScrollFlag", "()I", "setMInitScrollFlag", "(I)V", "mInitScrollFlag", "d", "Lcom/google/android/material/appbar/AppBarLayout;", "getMAppBarLayout", "setMAppBarLayout", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "mAppBarLayout", "e", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getMCollapsingToolbarLayout", "()Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "setMCollapsingToolbarLayout", "(Lcom/google/android/material/appbar/CollapsingToolbarLayout;)V", "mCollapsingToolbarLayout", "f", "Landroidx/appcompat/widget/Toolbar;", "getMFoldToolBar", "()Landroidx/appcompat/widget/Toolbar;", "setMFoldToolBar", "(Landroidx/appcompat/widget/Toolbar;)V", "mFoldToolBar", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public abstract class FoldToolbarLayout<T extends AppBarLayout> extends CoordinatorLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f250439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f250440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f250441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f250442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CollapsingToolbarLayout f250443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Toolbar f250444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f250445g;

    public static final class a {
    }

    static {
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        d.a(this, r100, r101);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r100) {
        d.b(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r100) {
        d.c(this, r100);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return d.d(this, r100);
    }

    public abstract int getLayoutIntRes();

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    public abstract void setScrollEnable(boolean r100);

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    public final T getAppBarLayout() {
        return this.f250442d;
    }

    public final CollapsingToolbarLayout getCollapsingToolbarLayout() {
        return this.f250443e;
    }

    public final Toolbar getFoldToolBar() {
        return this.f250444f;
    }

    public final T getMAppBarLayout() {
        return this.f250442d;
    }

    public final CollapsingToolbarLayout getMCollapsingToolbarLayout() {
        return this.f250443e;
    }

    public final Toolbar getMFoldToolBar() {
        return this.f250444f;
    }

    public final int getMInitScrollFlag() {
        return this.f250440b;
    }

    public final boolean getMScrollEnable() {
        return this.f250439a;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.f250445g;
    }

    public FoldToolbarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f250439a = true;
        if ((r100 instanceof LynxContext) == false) goto L5;
        LLog.i("FoldToolbarLayout", "context is: " + ((LynxContext) r100).getBaseContext());
    L5:
        View r101 = LayoutInflater.from(r100).inflate(getLayoutIntRes(), this, true);
        this.f250442d = (T) findViewById(R.id.app_bar_layout);
        this.f250443e = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        this.f250444f = (Toolbar) findViewById(R.id.x_fold_toolbar);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r102 = this.f250443e.getLayoutParams();
        if ((r102 instanceof AppBarLayout.LayoutParams) == false) goto L9;
        this.f250440b = ((AppBarLayout.LayoutParams) r102).getScrollFlags();
        return;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        ViewGroup.LayoutParams r101 = this.f250442d.getLayoutParams();
        if (r101 == null) goto L25;
        CoordinatorLayout.Behavior r102 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();
        if (this.f250441c == false) goto L23;
        if ((r102 instanceof AppBarLayout.Behavior) == false) goto L23;
        AppBarLayout.Behavior r103 = (AppBarLayout.Behavior) r102;
        if (r103.getTopAndBottomOffset() < 0) goto L20;
        if (r100 > 0) goto L13;
    L15:
        if (r100 >= 0) goto L27;
        if (r103.getTopAndBottomOffset() != 0) goto L27;
        return false;
    L27:
        return super.canScrollVertically(r100);
    L13:
        if (r103.getTopAndBottomOffset() != 0) goto L15;
    L20:
        return true;
    L23:
        return super.canScrollVertically(r100);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        i r101 = this.f250445g;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        i r101 = this.f250445g;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    public final void setCompatContainerPopup(boolean r100) {
        this.f250441c = r100;
    }

    public final void setMAppBarLayout(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f250442d = r100;
    }

    public final void setMCollapsingToolbarLayout(CollapsingToolbarLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f250443e = r100;
    }

    public final void setMFoldToolBar(Toolbar r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f250444f = r100;
    }

    public final void setMInitScrollFlag(int r100) {
        this.f250440b = r100;
    }

    public final void setMScrollEnable(boolean r100) {
        this.f250439a = r100;
    }

    @Override // x6a.e
    public void setRenderer(i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f250445g = r100;
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "platformRendererContext");
        return new i(r100, r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        i r103 = this.f250445g;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        if (this.f250445g == null) goto L8;
        r100.restore();
    L8:
        return r104;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.f250445g;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
