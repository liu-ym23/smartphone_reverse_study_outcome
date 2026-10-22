package com.bytedance.ee.bear.more.pageview2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PageviewItemView extends FrameLayout {
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ PageviewItemView b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.b.d.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.b.d.getLineCount() <= 1) goto L5;
            PageviewItemView r0 = this.b;
            r0.d.setText(xo5.a.c(r0.getContext(), 2131887400, "new_daily", ""));
            this.b.e.setText(this.a);
            this.b.e.setVisibility(0);
        L5:
            return false;
        }

        public a(PageviewItemView r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void a() {
        tt5.a.b("PageviewItemView", "initViews: ");
        View r0 = LayoutInflater.from(getContext()).inflate(2131564164, this, true);
        this.a = r0;
        this.b = (TextView) r0.findViewById(2131388772);
        this.c = (TextView) this.a.findViewById(2131392192);
        this.d = (TextView) this.a.findViewById(2131388961);
        this.e = (TextView) this.a.findViewById(2131388962);
        this.f = (ImageView) this.a.findViewById(2131375090);
        this.d.setText("N/A");
        this.f.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(8);
    }

    public PageviewItemView(Context r1) {
        super(r1);
        a();
    }

    public void setTitle(String r2) {
        this.b.setText(r2);
    }

    public void setTodayValue(String r5) {
        if (r5.equals("0") == true) goto L5;
        this.d.getViewTreeObserver().addOnPreDrawListener(new a(this, r5));
        this.f.setVisibility(0);
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setText(xo5.a.c(getContext(), 2131887400, "new_daily", r5));
        return;
    L5:
        this.f.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(8);
    }

    public void setValue(String r2) {
        this.c.setText(r2);
    }

    public PageviewItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public PageviewItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
