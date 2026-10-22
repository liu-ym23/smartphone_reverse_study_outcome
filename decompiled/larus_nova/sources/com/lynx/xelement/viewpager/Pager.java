package com.lynx.xelement.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.lynx.xelement.viewpager.viewpager.BaseCustomViewPager;
import com.lynx.xelement.viewpager.viewpager.CustomViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;
import x6a.e;
import x6a.i;

/* JADX INFO: loaded from: classes32.dex */
public abstract class Pager<T extends BaseCustomViewPager> extends LinearLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f384326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LynxViewpagerItem> f384327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<LynxViewpagerItem> f384328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f384329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f384330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pager<T>.Adapter f384331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f384332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f384333h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/lynx/xelement/viewpager/Pager$Adapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
    public final class Adapter extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pager<T> f384334a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return ((ArrayList) this.f384334a.f384327b).size();
        }

        public Adapter(Pager r100) {
            this.f384334a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "object");
            int r101 = CollectionsKt.indexOf(this.f384334a.f384327b, r100);
            if (r101 != (-1)) goto L6;
            return -2;
        L6:
            return r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View] */
        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            LynxViewpagerItem r102 = (LynxViewpagerItem) ListProtector.get(this.f384334a.f384327b, r101);
            ViewGroup r103 = (ViewGroup) ((r8a.a) r102.getView()).getParent();
            if (r103 == 0) goto L5;
            r103.removeView(r102.getView());
        L5:
            r100.addView(r102.getView());
            r102.sendIsAttachedEvent(true, r101);
            return r102;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            if ((r101 instanceof LynxViewpagerItem) == true) goto L5;
            return false;
        L5:
            if (r100 != ((LynxViewpagerItem) r101).getView()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "object");
            if ((r102 instanceof LynxViewpagerItem) == false) goto L6;
            LynxViewpagerItem r103 = (LynxViewpagerItem) r102;
            r100.removeView(r103.getView());
            r103.sendIsAttachedEvent(false, r101);
            return;
        }
    }

    public static final class a {
    }

    public interface b {
        void a();
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

    @Override // x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    public final boolean getMChanged() {
        return this.f384333h;
    }

    public final List<LynxViewpagerItem> getMPendingChildren() {
        return this.f384328c;
    }

    public final T getMViewPager() {
        return this.f384326a;
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.f384329d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
        i r101 = this.f384329d;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        i r101 = this.f384329d;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    L6:
        super.onDraw(r100);
    }

    public final void setAllowHorizontalGesture(boolean r100) {
        this.f384326a.setMAllowHorizontalGesture(r100);
    }

    public final void setCurrentSelectIndex(int r100) {
        this.f384326a.setCurrentItem(r100);
    }

    public final void setKeepItemView(boolean r100) {
        if (r100 == false) goto L4;
        this.f384326a.setOffscreenPageLimit(Integer.MAX_VALUE);
        return;
    L4:
        this.f384326a.setOffscreenPageLimit(1);
    }

    public final void setLynxDirection(int r100) {
        if (r100 == 2) goto L7;
        if (r100 == 2) goto L7;
        boolean r101 = false;
    L9:
        if (r101 == this.f384332g) goto L15;
        ReversingAdapter r102 = this.f384326a.getReversingAdapter();
        int r103 = this.f384326a.getCurrentItem();
        this.f384332g = r101;
        this.f384326a.setRTL(r101);
        if (r102 == null) goto L13;
        r102.f384336b = r101;
        r102.notifyDataSetChanged();
    L13:
        this.f384326a.setCurrentItem(r103);
        return;
    L15:
        return;
    L7:
        r101 = true;
        goto L9
    }

    public final void setMChanged(boolean r100) {
        this.f384333h = r100;
    }

    public final void setMViewPager(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f384326a = r100;
    }

    public final void setRTLMode(boolean r100) {
        this.f384332g = r100;
    }

    @Override // x6a.e
    public void setRenderer(i r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f384329d = r100;
    }

    public final void setSelectedIndex(int r100) {
        this.f384330e = r100;
    }

    public Pager(CustomViewPager r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewPager");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r101);
        this.f384326a = r100;
        this.f384327b = new ArrayList();
        this.f384328c = new ArrayList();
        Pager<T>.Adapter r102 = new Adapter(this);
        this.f384331f = r102;
        this.f384333h = true;
        setOrientation(1);
        this.f384326a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f384326a.setAdapter(r102);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.f384326a, 0);
    }

    @Override // x6a.e
    public final i createRenderer(PlatformRendererContext r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "platformRendererContext");
        return new i(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        i r103 = this.f384329d;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = super.drawChild(r100, r101, r102);
        if (this.f384329d == null) goto L8;
        r100.restore();
    L8:
        return r104;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        i r105 = this.f384329d;
        if (r105 == null) goto L7;
        LynxBaseUI r106 = r105.f562747h;
        if (r106 == null) goto L7;
        r106.measure();
    L7:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
