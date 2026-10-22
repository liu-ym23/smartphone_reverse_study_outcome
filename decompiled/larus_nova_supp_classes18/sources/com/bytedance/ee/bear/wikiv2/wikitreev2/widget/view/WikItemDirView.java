package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikItemDirView extends WikItemLeafView {
    public static final /* synthetic */ int w = 0;
    public b t;
    public boolean u;
    public h v;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ WikItemDirView c;

        public a(WikItemDirView r3) {
            this.c = r3;
            super(400);
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            WikItemDirView r3 = this.c;
            b r0 = r3.t;
            if (r0 == null) goto L6;
            r0.a(!r3.u);
            return;
        }
    }

    public interface b {
        void a(boolean r1);
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
        this.b.setOnClickListener(new a(this));
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
        h r0 = this.v;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
        return;
    }

    public WikItemDirView(Context r1) {
        super(r1);
        this.u = false;
    }

    public void setExpand(boolean r2) {
        this.u = r2;
        if (r2 == false) goto L5;
        int r3 = 2131254326;
    L6:
        this.d.setImageResource(r3);
        com.bytedance.ee.util.ui.l.c(this.d, 2131102419);
        return;
    L5:
        r3 = 2131254331;
        goto L6
    }

    public void setExpandClickListener(b r1) {
        this.t = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView
    public void setFocus(boolean r1) {
        super.setFocus(r1);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.h] */
    public void setLoading(boolean r3) {
        h r0 = this.v;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        if (r3 == true) goto L7;
        this.b.setClickable(true);
        this.d.setVisibility(0);
        this.c.setVisibility(8);
        return;
    L7:
        if (this.v != null) goto L9;
        this.v = new h(this);
    L9:
        postDelayed(this.v, 300);
    }

    public WikItemDirView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.u = false;
    }

    public WikItemDirView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.u = false;
    }

    public WikItemDirView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.u = false;
    }
}
