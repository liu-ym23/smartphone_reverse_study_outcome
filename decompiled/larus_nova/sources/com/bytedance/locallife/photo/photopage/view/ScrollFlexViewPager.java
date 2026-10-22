package com.bytedance.locallife.photo.photopage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/ScrollFlexViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "isLookMode", "", "setLookMode", "disableScroll", "setDisableScroll", "canScroll", "setCanScrollHorizontally", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class ScrollFlexViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f262323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f262324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f262325c;

    public ScrollFlexViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f262323a = true;
        this.f262325c = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f262325c == true) goto L7;
        return false;
    L7:
        return super.canScrollHorizontally(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f262324b == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f262323a == false) goto L9;
        if (super.onInterceptTouchEvent(r100) == false) goto L9;
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f262324b == false) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r100) == false) goto L7;
        return true;
    }

    public final void setCanScrollHorizontally(boolean r100) {
        this.f262325c = r100;
    }

    public final void setDisableScroll(boolean r100) {
        this.f262324b = r100;
    }

    public final void setLookMode(boolean r100) {
        this.f262323a = r100;
    }

    public ScrollFlexViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f262323a = true;
        this.f262325c = true;
    }
}
