package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikItemDirView extends WikItemLeafView {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f242215w = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f242216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f242217u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f242218v;

    public class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WikItemDirView f242219c;

        public a(WikItemDirView r100) {
            this.f242219c = r100;
            super(400);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            WikItemDirView r101 = this.f242219c;
            b r102 = r101.f242216t;
            if (r102 == null) goto L6;
            r102.a(!r101.f242217u);
            return;
        }
    }

    public interface b {
        void a(boolean r100);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public final void d() {
        super.d();
        setLoading(false);
        setExpandClickListener(null);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void e() {
        super.e();
        setExpand(false);
        this.f242223b.setOnClickListener(new a(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void f() {
        super.f();
        setExpand(false);
        setLoading(false);
        setExpandClickListener(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r100 = this.f242218v;
        if (r100 == null) goto L6;
        removeCallbacks(r100);
        return;
    }

    public WikItemDirView(Context r100) {
        super(r100);
        this.f242217u = false;
    }

    public void setExpand(boolean r100) {
        this.f242217u = r100;
        if (r100 == false) goto L5;
        int r101 = R.drawable.ud_icon_expand_down_filled;
    L6:
        this.f242225d.setImageResource(r101);
        com.bytedance.ee.util.ui.l.c(this.f242225d, R.color.icon_n2);
        return;
    L5:
        r101 = R.drawable.ud_icon_expand_right_filled;
        goto L6
    }

    public void setExpandClickListener(b r100) {
        this.f242216t = r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r100) {
        super.setFocus(r100);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.h] */
    public void setLoading(boolean r100) {
        h r101 = this.f242218v;
        if (r101 == null) goto L5;
        removeCallbacks(r101);
    L5:
        if (r100 == true) goto L7;
        this.f242223b.setClickable(true);
        this.f242225d.setVisibility(0);
        this.f242224c.setVisibility(8);
        return;
    L7:
        if (this.f242218v != null) goto L9;
        this.f242218v = new h(this);
    L9:
        postDelayed(this.f242218v, 300);
    }

    public WikItemDirView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f242217u = false;
    }

    public WikItemDirView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f242217u = false;
    }

    public WikItemDirView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f242217u = false;
    }
}
