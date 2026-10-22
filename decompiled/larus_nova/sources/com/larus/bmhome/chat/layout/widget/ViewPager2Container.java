package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.music.widget.MusicPlayerSlidingInfoView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\rJ \u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ViewPager2Container;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "disallowParentInterceptDownEvent", "", "startX", "startY", "childIntercept", "onFinishInflate", "", "initViewPager2", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onHorizontalActionMove", "endX", "disX", "disY", "requestDisallowInterceptTouchEvent", "disallowIntercept", "requestDisallowIntercept", "onVerticalActionMove", "endY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewPager2Container extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f304937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f304938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f304939c;

    public ViewPager2Container(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ViewPager2Container(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = 0;
        View r101 = getChildAt(0);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r101;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        View r105 = r102.getChildAt(r104);
        if ((r105 instanceof MusicPlayerSlidingInfoView) == true) goto L9;
        r104 = r104 + 1;
    L9:
        ViewGroup r106 = (ViewGroup) r105;
        if (r106 == null) goto L17;
        int r107 = r106.getChildCount();
    L12:
        if (r100 >= r107) goto L23;
        View r108 = r106.getChildAt(r100);
        if ((r108 instanceof ViewPager2) == true) goto L15;
        r100 = r100 + 1;
        goto L12
    L15:
        this.f304937a = (ViewPager2) r108;
        return;
    L23:
        return;
    L17:
        return;
    L8:
        r105 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f304937a != null) goto L6;
        a();
    L6:
        if (this.f304937a == null) goto L8;
        int r100 = r110.getAction();
        boolean r101 = true;
        if (r100 != 0) goto L12;
        this.f304938b = (int) r110.getX();
        this.f304939c = (int) r110.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L132:
        return super.onInterceptTouchEvent(r110);
    L12:
        if (r100 != 1) goto L14;
    L129:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L14:
        if (r100 != 2) goto L16;
        ViewPager2 r102 = this.f304937a;
        if (r102 != null) goto L21;
    L23:
        boolean r103 = false;
    L24:
        Integer r104 = null;
        RecyclerView.Adapter r105 = null;
        if (r103 == true) goto L40;
        ViewPager2 r106 = this.f304937a;
        if (r106 == null) goto L29;
        RecyclerView.Adapter r107 = r106.getAdapter();
    L30:
        if (r107 == null) goto L39;
        ViewPager2 r108 = this.f304937a;
        if (r108 == null) goto L36;
        RecyclerView.Adapter r109 = r108.getAdapter();
        if (r109 == null) goto L36;
        int r111 = r109.getItemCount();
    L37:
        if (r111 > 1) goto L39;
    L36:
        r111 = 0;
    L39:
        boolean r112 = false;
    L41:
        if (r112 == false) goto L43;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L43:
        int r113 = (int) r110.getX();
        int r114 = (int) r110.getY();
        int r115 = Math.abs(r113 - this.f304938b);
        int r116 = Math.abs(r114 - this.f304939c);
        ViewPager2 r117 = this.f304937a;
        if (r117 != null) goto L46;
    L48:
        boolean r118 = false;
    L49:
        if (r118 == false) goto L84;
        ViewPager2 r119 = this.f304937a;
        if (r119 == null) goto L53;
        RecyclerView.Adapter r120 = r119.getAdapter();
    L54:
        if (r120 == null) goto L132;
        ViewPager2 r121 = this.f304937a;
        if (r121 == null) goto L59;
        Integer r122 = Integer.valueOf(r121.getCurrentItem());
    L60:
        ViewPager2 r123 = this.f304937a;
        if (r123 == null) goto L63;
        r105 = r123.getAdapter();
    L63:
        Intrinsics.checkNotNull(r105);
        int r124 = r105.getItemCount();
        if (r116 <= r115) goto L82;
        if (r122 != null) goto L68;
    L72:
        ViewParent r125 = getParent();
        int r126 = r124 - 1;
        if (r122 != null) goto L76;
    L81:
        r125.requestDisallowInterceptTouchEvent(r101);
        goto L132
    L76:
        if (r122.intValue() != r126) goto L81;
        if ((r114 - this.f304939c) >= 0) goto L81;
        r101 = false;
        goto L81
    L68:
        if (r122.intValue() != 0) goto L72;
        if ((r114 - this.f304939c) >= 0) goto L72;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L82:
        if (r115 <= r116) goto L132;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L59:
        r122 = null;
        goto L60
    L53:
        r120 = null;
        goto L54
    L84:
        ViewPager2 r127 = this.f304937a;
        if (r127 != null) goto L87;
    L89:
        boolean r128 = false;
    L90:
        if (r128 == false) goto L132;
        ViewPager2 r129 = this.f304937a;
        if (r129 == null) goto L94;
        RecyclerView.Adapter r130 = r129.getAdapter();
    L95:
        if (r130 == null) goto L132;
        if ((r115 * 2) <= r116) goto L128;
        ViewPager2 r131 = this.f304937a;
        if (r131 == null) goto L102;
        r104 = Integer.valueOf(r131.getCurrentItem());
    L102:
        ViewPager2 r132 = this.f304937a;
        if (r132 == null) goto L107;
        RecyclerView.Adapter r133 = r132.getAdapter();
        if (r133 == null) goto L107;
        int r134 = r133.getItemCount();
    L108:
        if (r104 != null) goto L111;
    L115:
        int r135 = r134 - 1;
        if (r104 != null) goto L119;
    L124:
        boolean r136 = true;
    L125:
        if (r136 == false) goto L127;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L132
    L127:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L119:
        if (r104.intValue() != r135) goto L124;
        if ((r113 - this.f304938b) >= 0) goto L124;
        r136 = false;
        goto L125
    L111:
        if (r104.intValue() != 0) goto L115;
        if ((r113 - this.f304938b) <= 0) goto L115;
        getParent().requestDisallowInterceptTouchEvent(false);
    L107:
        r134 = 0;
        goto L108
    L128:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L132
    L94:
        r130 = null;
        goto L95
    L87:
        if (r127.getOrientation() != 0) goto L89;
        r128 = true;
        goto L90
    L46:
        if (r117.getOrientation() != 1) goto L48;
        r118 = true;
        goto L49
    L29:
        r107 = null;
    L40:
        r112 = true;
        goto L41
    L21:
        if (r102.isUserInputEnabled() == true) goto L23;
        r103 = true;
        goto L24
    L16:
        if (r100 == 3) goto L129;
    L8:
        return super.onInterceptTouchEvent(r110);
    }

    public ViewPager2Container(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ViewPager2Container(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
