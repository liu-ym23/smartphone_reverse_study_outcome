package com.bytedance.lark.lynxlib.widget.udtabs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.lynxlib.widget.udtabs.childitem.LynxViewpagerItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class Pager extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Adapter f253305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f253306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager f253307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<LynxViewpagerItem> f253308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f253309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDTabLayout f253310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDTabLayoutCoordinator f253311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDTabLayout.b f253312h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/lark/lynxlib/widget/udtabs/Pager$Adapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ud-tabs_release"}, k = 1, mv = {1, 5, 1})
    public final class Adapter extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pager f253313a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return ((ArrayList) this.f253313a.f253308d).size();
        }

        public Adapter(Pager r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            this.f253313a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "object");
            int r101 = CollectionsKt.indexOf(this.f253313a.f253308d, r100);
            if (r101 != (-1)) goto L6;
            return -2;
        L6:
            return r101;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if ((r100 + 1) <= this.f253313a.getMTabLayoutTitles().size()) goto L7;
            return null;
        L7:
            return (CharSequence) ListProtector.get(this.f253313a.getMTabLayoutTitles(), r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            LynxViewpagerItem r102 = (LynxViewpagerItem) ListProtector.get(this.f253313a.f253308d, r101);
            r100.addView(r102.getView());
            r102.M(true, r101);
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
            r103.M(false, r101);
            return;
        }
    }

    public interface a {
    }

    public interface b {
        void a(boolean r100);
    }

    public final void setSelectedIndex(int r100) {
    }

    public final void setTabClickListenerListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "tabClickListener");
    }

    public final int getCurrentSelectIndex() {
        return this.f253307c.getCurrentItem();
    }

    public final b getInterceptTouchEventListener() {
        return this.f253306b;
    }

    public final UDTabLayout getMTabLayout() {
        return this.f253310f;
    }

    public final UDTabLayoutCoordinator getMTabLayoutCoordinator() {
        return this.f253311g;
    }

    public final List<String> getMTabLayoutTitles() {
        return this.f253309e;
    }

    public final ViewPager getMViewPager() {
        return this.f253307c;
    }

    public Pager(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        Adapter r101 = new Adapter(this);
        this.f253305a = r101;
        this.f253307c = new Pager$mViewPager$1(this, r100);
        this.f253308d = new ArrayList();
        this.f253309e = new ArrayList();
        setOrientation(1);
        this.f253307c.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f253307c.setAdapter(r101);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(this.f253307c, 0);
    }

    public final void a(UDTabLayout r100) {
        if (r100 == null) goto L4;
        removeView(this.f253310f);
        UDTabLayoutCoordinator r101 = this.f253311g;
        if (r101 == null) goto L17;
        r101.detach();
    L17:
        this.f253310f = r100;
        ((ArrayList) this.f253309e).clear();
    L18:
        UDTabLayout r102 = this.f253310f;
        if (r102 == null) goto L25;
        setMTabLayoutCoordinator(new UDTabLayoutCoordinator(r102, getMViewPager()));
        UDTabLayoutCoordinator r103 = getMTabLayoutCoordinator();
        if (r103 == null) goto L25;
        r103.attach();
    L25:
        addView(this.f253310f, 0);
        return;
    L4:
        if (this.f253310f == null) goto L6;
        return;
    L6:
        int r104 = LynxTabBarView.f253290g;
        Context r105 = getContext();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDTabLayout r106 = new UDTabLayout(r105);
        r106.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r106.setTabMode(2);
        this.f253310f = r106;
        UDTabLayout.b r107 = this.f253312h;
        if (r107 == null) goto L18;
        UDTabLayout r108 = getMTabLayout();
        if (r108 == null) goto L18;
        r108.addOnTabSelectedListener(r107);
        goto L18
    }

    public final void setCurrentSelectIndex(int r100) {
        this.f253307c.setCurrentItem(r100);
    }

    public final void setInterceptTouchEventListener(b r100) {
        this.f253306b = r100;
    }

    public final void setLynxDirection(int r100) {
        UDTabLayout r101 = this.f253310f;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 == 2) goto L10;
        if (r100 == 2) goto L10;
        Intrinsics.checkNotNull(r101);
        ViewCompat.setLayoutDirection(r101, 0);
        return;
    L10:
        Intrinsics.checkNotNull(r101);
        ViewCompat.setLayoutDirection(r101, 1);
    }

    public final void setMTabLayout(UDTabLayout r100) {
        this.f253310f = r100;
    }

    public final void setMTabLayoutCoordinator(UDTabLayoutCoordinator r100) {
        this.f253311g = r100;
    }

    public final void setMViewPager(ViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f253307c = r100;
    }

    public final void setTabLayout(LynxTabBarView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxTabBarView");
        UDTabLayout r101 = r100.f253293c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r101 = null;
    L5:
        a(r101);
    }

    public final void setTabSelectedListener$ud_tabs_release(UDTabLayout.b r100) {
        Intrinsics.checkNotNullParameter(r100, "mOnTabSelectedListener");
        this.f253312h = r100;
    }
}
