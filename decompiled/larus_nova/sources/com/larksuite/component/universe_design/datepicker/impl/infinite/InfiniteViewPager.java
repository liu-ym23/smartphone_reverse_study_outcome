package com.larksuite.component.universe_design.datepicker.impl.infinite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o08.a;
import o08.b;
import o08.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\nH\u0016J\u0012\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;", "Landroidx/viewpager/widget/ViewPager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mSelectedPosition", "", "mIsNeedNotifyRotateListener", "", "mListeners", "", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/OnViewPagerChange;", "isPageEnabled", "()Z", "setPageEnabled", "(Z)V", "mIsSmoothScroll", "mOnSmoothScrollFinishListener", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/OnSmoothScrollFinishListener;", "value", "scrollState", "getScrollState", "()I", "init", "", "addListener", "listener", "smoothScrollToPage", "pageIndex", "needNotifyRotateListener", "setOnSmoothScrollFinishListener", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "canScrollHorizontally", "direction", "canScrollVertically", "setAdapter", "adapter", "Landroidx/viewpager/widget/PagerAdapter;", "OnPageChange", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class InfiniteViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f284815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<c> f284816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f284817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f284818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f284819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284820g;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager$OnPageChange;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "<init>", "(Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;)V", "isNeedNotifyRotatedListener", "", "()Z", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "notifySmoothScrollIfNeed", "notifyWillMoveToCenterPageIfNeed", "notifyWillMoveToFollowingPageIfNeed", "adapter", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", "notifyWillMoveToPreviousPageIfNeed", "onPageScrollStateChanged", "state", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OnPageChange implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InfiniteViewPager f284821a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        public final boolean a() {
            InfiniteViewPager r100 = this.f284821a;
            if (r100.f284816c != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.f284815b == false) goto L7;
            return true;
        }

        public OnPageChange(InfiniteViewPager r100) {
            this.f284821a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r110) {
            InfiniteViewPager r100 = this.f284821a;
            r100.f284820g = r110;
            if (r110 == 0) goto L5;
            return;
        L5:
            int r111 = r100.f284814a;
            if (r111 == 0) goto L12;
            if (r111 == 1) goto L11;
            if (r111 != 2) goto L11;
            int r112 = 0;
        L14:
            if (a() == false) goto L21;
            List<c> r101 = this.f284821a.f284816c;
            if (r101 == null) goto L21;
            Iterator r102 = ((ArrayList) r101).iterator();
        L19:
            if (r102.hasNext() == false) goto L21;
            ((c) r102.next()).c();
        L21:
            InfinitePagerAdapter r103 = (InfinitePagerAdapter) this.f284821a.getAdapter();
            a[] r104 = null;
            if (r112 == 0) goto L55;
            if (r112 != 1) goto L86;
            if (r103 == null) goto L86;
            a[] r105 = r103.f284813b;
            if (r105 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r105 = null;
        L29:
            r105[2].b();
            a[] r106 = r103.f284813b;
            if (r106 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r106 = null;
        L32:
            View r107 = r106[2].f521644b;
            a[] r108 = r103.f284813b;
            if (r108 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r108 = null;
        L35:
            r108[1].b();
            a[] r109 = r103.f284813b;
            if (r109 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r109 = null;
        L38:
            a r113 = r109[2];
            a[] r114 = r103.f284813b;
            if (r114 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r114 = null;
        L41:
            r113.a(r114[1].f521644b);
            a[] r115 = r103.f284813b;
            if (r115 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r115 = null;
        L44:
            r115[0].b();
            a[] r116 = r103.f284813b;
            if (r116 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r116 = null;
        L47:
            a r117 = r116[1];
            a[] r118 = r103.f284813b;
            if (r118 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r118 = null;
        L50:
            r117.a(r118[0].f521644b);
            a[] r119 = r103.f284813b;
            if (r119 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        L54:
            r104[0].a(r107);
            goto L86
        L53:
            r104 = r119;
        L86:
            if (a() == false) goto L93;
            List<c> r120 = this.f284821a.f284816c;
            if (r120 == null) goto L93;
            Iterator r121 = ((ArrayList) r120).iterator();
        L91:
            if (r121.hasNext() == false) goto L93;
            ((c) r121.next()).b(r112);
        L93:
            this.f284821a.setCurrentItem(1, false);
            return;
        L55:
            if (r103 == null) goto L86;
            a[] r122 = r103.f284813b;
            if (r122 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r122 = null;
        L59:
            r122[0].b();
            a[] r123 = r103.f284813b;
            if (r123 != null) goto L62;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r123 = null;
        L62:
            View r124 = r123[0].f521644b;
            a[] r125 = r103.f284813b;
            if (r125 != null) goto L65;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r125 = null;
        L65:
            r125[1].b();
            a[] r126 = r103.f284813b;
            if (r126 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r126 = null;
        L68:
            a r127 = r126[0];
            a[] r128 = r103.f284813b;
            if (r128 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r128 = null;
        L71:
            r127.a(r128[1].f521644b);
            a[] r129 = r103.f284813b;
            if (r129 != null) goto L74;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r129 = null;
        L74:
            r129[2].b();
            a[] r130 = r103.f284813b;
            if (r130 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r130 = null;
        L77:
            a r131 = r130[1];
            a[] r132 = r103.f284813b;
            if (r132 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r132 = null;
        L80:
            r131.a(r132[2].f521644b);
            a[] r133 = r103.f284813b;
            if (r133 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        L84:
            r104[2].a(r124);
            goto L86
        L83:
            r104 = r133;
        L11:
            r112 = -999;
            goto L14
        L12:
            r112 = 1;
            goto L14
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            InfiniteViewPager r101 = this.f284821a;
            r101.f284814a = r100;
            PagerAdapter r102 = r101.getAdapter();
            if ((r102 instanceof InfinitePagerAdapter) == false) goto L5;
            InfinitePagerAdapter r103 = (InfinitePagerAdapter) r102;
        L6:
            if (r103 != null) goto L8;
            return;
        L8:
            int r104 = this.f284821a.f284814a;
            if (r104 == 0) goto L43;
            if (r104 == 2) goto L28;
            if (a() == false) goto L21;
            List<c> r105 = this.f284821a.f284816c;
            if (r105 == null) goto L21;
            Iterator r106 = ((ArrayList) r105).iterator();
        L19:
            if (r106.hasNext() == false) goto L21;
            ((c) r106.next()).a();
        L21:
            InfiniteViewPager r107 = this.f284821a;
            if (r107.f284818e == false) goto L26;
            b r108 = r107.f284819f;
            if (r108 == null) goto L26;
            r108.a();
            this.f284821a.f284818e = false;
        L26:
            this.f284821a.f284815b = true;
            return;
        L28:
            if (a() == false) goto L63;
            View r109 = r103.g(1);
            if (r109 == null) goto L64;
            View r110 = r103.g(2);
            if (r110 == null) goto L65;
            List<c> r111 = this.f284821a.f284816c;
            if (r111 == null) goto L61;
            Iterator r112 = ((ArrayList) r111).iterator();
        L40:
            if (r112.hasNext() == false) goto L69;
            ((c) r112.next()).e(r109, r110);
            goto L40
        L69:
            return;
        L61:
            return;
        L65:
            return;
        L64:
            return;
        L63:
            return;
        L43:
            if (a() == false) goto L66;
            View r113 = r103.g(1);
            if (r113 == null) goto L67;
            View r114 = r103.g(0);
            if (r114 == null) goto L68;
            List<c> r115 = this.f284821a.f284816c;
            if (r115 == null) goto L62;
            Iterator r116 = ((ArrayList) r115).iterator();
        L55:
            if (r116.hasNext() == false) goto L70;
            ((c) r116.next()).d(r113, r114);
            goto L55
        L70:
            return;
        L62:
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public final int getScrollState() {
        return this.f284820g;
    }

    public InfiniteViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284815b = true;
        addOnPageChangeListener(new OnPageChange(this));
        this.f284817d = true;
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f284817d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f284817d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f284817d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f284817d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r100) {
        super.setAdapter(r100);
        setCurrentItem(1, false);
    }

    public final void setOnSmoothScrollFinishListener(b r100) {
        this.f284819f = r100;
    }

    public final void setPageEnabled(boolean r100) {
        this.f284817d = r100;
    }

    public InfiniteViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f284815b = true;
        addOnPageChangeListener(new OnPageChange(this));
        this.f284817d = true;
        setOverScrollMode(2);
    }
}
