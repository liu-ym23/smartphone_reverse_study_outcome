package com.ss.android.lark.search.baseview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larus.nova.R;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;

/* JADX INFO: loaded from: classes38.dex */
public class SearchPtrFooter extends FrameLayout implements com.ss.android.lark.widget.ptr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f439916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RotateAnimation f439917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RotateAnimation f439918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f439919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f439920e;

    public final void f() {
        RotateAnimation r100 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f439917b = r100;
        r100.setInterpolator(new LinearInterpolator());
        this.f439917b.setDuration(this.f439916a);
        this.f439917b.setFillAfter(true);
        RotateAnimation r101 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f439918c = r101;
        r101.setInterpolator(new LinearInterpolator());
        this.f439918c.setDuration(this.f439916a);
        this.f439918c.setFillAfter(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public SearchPtrFooter(Context r100) {
        super(r100);
        this.f439916a = 150;
        g(null);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void b(LKUIPtrFrameLayout r100) {
        this.f439919d.clearAnimation();
        this.f439919d.setVisibility(4);
        this.f439920e.setVisibility(4);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void d(LKUIPtrFrameLayout r100) {
        this.f439920e.setVisibility(4);
        this.f439919d.setVisibility(0);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void e(LKUIPtrFrameLayout r100) {
        this.f439919d.clearAnimation();
        this.f439919d.setVisibility(4);
        this.f439920e.setVisibility(0);
    }

    public final void g(AttributeSet r100) {
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.lkui_ptr_rotate_ani_time}, 0, 0);
        if (r101 == null) goto L5;
        this.f439916a = r101.getInt(0, this.f439916a);
        r101.recycle();
    L5:
        f();
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.search_ptr_footer, this);
        this.f439919d = r102.findViewById(R.id.ptr_classic_header_rotate_view);
        this.f439920e = r102.findViewById(R.id.ptr_classic_header_rotate_view_progressbar);
        this.f439919d.clearAnimation();
        this.f439919d.setVisibility(4);
        this.f439920e.setVisibility(4);
    }

    public void setLastUpdateTimeKey(String r100) {
        TextUtils.isEmpty(r100);
    }

    public void setLastUpdateTimeRelateObject(Object r100) {
        setLastUpdateTimeKey(r100.getClass().getName().concat(ContainerPosition.FOOTER));
    }

    public void setRotateAniTime(int r100) {
        if (r100 == this.f439916a) goto L8;
        if (r100 == 0) goto L9;
        this.f439916a = r100;
        f();
        return;
    L9:
        return;
    }

    public SearchPtrFooter(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f439916a = 150;
        g(r101);
    }

    @Override // com.ss.android.lark.widget.ptr.a
    public final void a(LKUIPtrFrameLayout r100, boolean r101) {
        if (r101 == false) goto L4;
        return;
    L4:
        this.f439919d.clearAnimation();
        this.f439919d.setVisibility(4);
        this.f439920e.setVisibility(4);
    }

    public SearchPtrFooter(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f439916a = 150;
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
        View r107 = this.f439919d;
        if (r107 == null) goto L20;
        r107.clearAnimation();
        this.f439919d.startAnimation(this.f439918c);
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
        View r108 = this.f439919d;
        if (r108 == null) goto L26;
        r108.clearAnimation();
        this.f439919d.startAnimation(this.f439917b);
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
