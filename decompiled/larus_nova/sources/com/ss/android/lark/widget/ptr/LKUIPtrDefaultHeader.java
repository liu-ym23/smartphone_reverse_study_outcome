package com.ss.android.lark.widget.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class LKUIPtrDefaultHeader extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateAnimation f448047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RotateAnimation f448048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f448049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f448050e;

    public final void f() {
        RotateAnimation r100 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f448047b = r100;
        r100.setInterpolator(new LinearInterpolator());
        this.f448047b.setDuration(this.f448046a);
        this.f448047b.setFillAfter(true);
        RotateAnimation r101 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f448048c = r101;
        r101.setInterpolator(new LinearInterpolator());
        this.f448048c.setDuration(this.f448046a);
        this.f448048c.setFillAfter(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public LKUIPtrDefaultHeader(Context r100) {
        super(r100);
        this.f448046a = 150;
        g(null);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        this.f448049d.clearAnimation();
        this.f448049d.setVisibility(4);
        this.f448050e.setVisibility(4);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
        this.f448050e.setVisibility(4);
        this.f448049d.setVisibility(0);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        this.f448049d.clearAnimation();
        this.f448049d.setVisibility(4);
        this.f448050e.setVisibility(0);
    }

    public final void g(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.lkui_ptr_rotate_ani_time}, 0, 0);
        if (r101 == null) goto L5;
        this.f448046a = r101.getInt(0, this.f448046a);
    L5:
        f();
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.lkui_ptr_classic_default_header, this);
        this.f448049d = r102.findViewById(R.id.ptr_classic_header_rotate_view);
        this.f448050e = r102.findViewById(R.id.ptr_classic_header_rotate_view_progressbar);
        this.f448049d.clearAnimation();
        this.f448049d.setVisibility(4);
        this.f448050e.setVisibility(4);
    }

    public void setLastUpdateTimeKey(String r100) {
        TextUtils.isEmpty(r100);
    }

    public void setLastUpdateTimeRelateObject(Object r100) {
        setLastUpdateTimeKey(r100.getClass().getName().concat("header"));
    }

    public void setRotateAniTime(int r100) {
        if (r100 == this.f448046a) goto L8;
        if (r100 == 0) goto L9;
        this.f448046a = r100;
        f();
        return;
    L9:
        return;
    }

    public LKUIPtrDefaultHeader(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f448046a = 150;
        g(r101);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        this.f448049d.clearAnimation();
        this.f448049d.setVisibility(4);
        this.f448050e.setVisibility(4);
    }

    public LKUIPtrDefaultHeader(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448046a = 150;
        g(r101);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void c(LKUIPtrFrameLayout r100, boolean r101, byte r102, wdc.a r103) {
        int r104 = r100.getOffsetToRefresh();
        int r105 = r103.f559318e;
        int r106 = r103.f559319f;
        if (r105 >= r104) goto L10;
        if (r106 < r104) goto L10;
        if (r101 == false) goto L18;
        if (r102 != 2) goto L19;
        View r107 = this.f448049d;
        if (r107 == null) goto L20;
        r107.clearAnimation();
        this.f448049d.startAnimation(this.f448048c);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (r105 <= r104) goto L22;
        if (r106 > r104) goto L23;
        if (r101 == false) goto L24;
        if (r102 != 2) goto L25;
        View r108 = this.f448049d;
        if (r108 == null) goto L26;
        r108.clearAnimation();
        this.f448049d.startAnimation(this.f448047b);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
