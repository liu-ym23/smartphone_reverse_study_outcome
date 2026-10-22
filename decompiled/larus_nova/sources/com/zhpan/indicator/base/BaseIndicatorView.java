package com.zhpan.indicator.base;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import crc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u0010/\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016R\"\u0010(\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/zhpan/indicator/base/BaseIndicatorView;", "Landroid/view/View;", "Lcom/zhpan/indicator/base/IIndicator;", "", "getNormalSlideWidth", "normalSliderWidth", "", "setNormalSlideWidth", "getCheckedSlideWidth", "checkedSliderWidth", "setCheckedSlideWidth", "", "currentPosition", "setCurrentPosition", "getCurrentPosition", "indicatorGap", "setIndicatorGap", "normalColor", "setCheckedColor", "getCheckedColor", "setNormalColor", "getSlideProgress", "slideProgress", "setSlideProgress", "getPageSize", "getSlideMode", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setupWithViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcrc/a;", "options", "setIndicatorOptions", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcrc/a;", "getMIndicatorOptions", "()Lcrc/a;", "setMIndicatorOptions", "(Lcrc/a;)V", "mIndicatorOptions", "getCheckedSliderWidth", "()F", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "indicator_release"}, k = 1, mv = {1, 4, 0})
public class BaseIndicatorView extends View implements IIndicator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f464578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f464579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPager2 f464580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseIndicatorView$mOnPageChangeCallback$1 f464581d;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    public final int getCheckedColor() {
        return this.f464578a.f465144f;
    }

    public final float getCheckedSlideWidth() {
        return this.f464578a.f465148j;
    }

    public final float getCheckedSliderWidth() {
        return this.f464578a.f465148j;
    }

    public final int getCurrentPosition() {
        return this.f464578a.f465149k;
    }

    public final float getNormalSlideWidth() {
        return this.f464578a.f465147i;
    }

    public final int getPageSize() {
        return this.f464578a.f465142d;
    }

    public final int getSlideMode() {
        return this.f464578a.f465141c;
    }

    public final float getSlideProgress() {
        return this.f464578a.f465150l;
    }

    public void jg() {
        ViewPager r100 = this.f464579b;
        if (r100 == null) goto L18;
        r100.removeOnPageChangeListener(this);
        ViewPager r101 = this.f464579b;
        if (r101 == null) goto L7;
        r101.addOnPageChangeListener(this);
    L7:
        ViewPager r102 = this.f464579b;
        if (r102 == null) goto L18;
        if (r102.getAdapter() == null) goto L18;
        ViewPager r103 = this.f464579b;
        if (r103 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        PagerAdapter r104 = r103.getAdapter();
        if (r104 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        this.f464578a.f465142d = r104.getCount();
    L18:
        ViewPager2 r105 = this.f464580c;
        if (r105 == null) goto L34;
        r105.unregisterOnPageChangeCallback(this.f464581d);
        ViewPager2 r106 = this.f464580c;
        if (r106 == null) goto L23;
        r106.registerOnPageChangeCallback(this.f464581d);
    L23:
        ViewPager2 r107 = this.f464580c;
        if (r107 == null) goto L34;
        if (r107.getAdapter() == null) goto L34;
        ViewPager2 r108 = this.f464580c;
        if (r108 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        RecyclerView.Adapter r109 = r108.getAdapter();
        if (r109 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        this.f464578a.f465142d = r109.getItemCount();
    L34:
        requestLayout();
        invalidate();
    }

    public final a getMIndicatorOptions() {
        return this.f464578a;
    }

    public void a(Canvas r100) {
        int r101 = this.f464578a.f465139a;
        if (r101 != 1) goto L6;
        r100.rotate(90.0f, getWidth() / 2.0f, getWidth() / 2.0f);
        return;
    L6:
        if (r101 != 3) goto L10;
        r100.rotate(180.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        a(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        if (getSlideMode() != 0) goto L6;
        setCurrentPosition(r100);
        setSlideProgress(0.0f);
        invalidate();
        return;
    }

    public final void setCheckedColor(int r100) {
        this.f464578a.f465144f = r100;
    }

    public final void setCheckedSlideWidth(float r100) {
        this.f464578a.f465148j = r100;
    }

    public final void setCurrentPosition(int r100) {
        this.f464578a.f465149k = r100;
    }

    public final void setIndicatorGap(float r100) {
        this.f464578a.f465145g = r100;
    }

    public void setIndicatorOptions(a r100) {
        this.f464578a = r100;
    }

    public final void setMIndicatorOptions(a r100) {
        this.f464578a = r100;
    }

    public final void setNormalColor(int r100) {
        this.f464578a.f465143e = r100;
    }

    public final void setNormalSlideWidth(float r100) {
        this.f464578a.f465147i = r100;
    }

    public final void setSlideProgress(float r100) {
        this.f464578a.f465150l = r100;
    }

    public final void setupWithViewPager(ViewPager r100) {
        this.f464579b = r100;
        jg();
    }

    public final void setupWithViewPager(ViewPager2 r100) {
        this.f464580c = r100;
        jg();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.zhpan.indicator.base.BaseIndicatorView$mOnPageChangeCallback$1] */
    public BaseIndicatorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464581d = new BaseIndicatorView$mOnPageChangeCallback$1(this);
        this.f464578a = new a();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        if (getSlideMode() != 0) goto L5;
        return;
    L5:
        if (getPageSize() <= 1) goto L22;
        int r103 = this.f464578a.f465141c;
        if (r103 != 4) goto L9;
    L18:
        setCurrentPosition(r100);
        setSlideProgress(r101);
    L19:
        invalidate();
        return;
    L9:
        if (r103 == 5) goto L18;
        if ((r100 % getPageSize()) == (getPageSize() - 1)) goto L14;
        setCurrentPosition(r100);
        setSlideProgress(r101);
        goto L19
    L14:
        if (r101 >= 0.5d) goto L16;
        setCurrentPosition(r100);
        setSlideProgress(0.0f);
        goto L19
    L16:
        setCurrentPosition(0);
        setSlideProgress(0.0f);
        goto L19
    }
}
