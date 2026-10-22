package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECHostDistributeCouponStatusLayout extends FrameLayout {
    public b a;
    public TextView b;
    public final int c;
    public int d;
    public int e;
    public final int f;
    public boolean g;

    public class a implements View.OnClickListener {
        public final /* synthetic */ ECHostDistributeCouponStatusLayout a;

        public a(ECHostDistributeCouponStatusLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ECHostDistributeCouponStatusLayout r3 = this.a;
            if (r3.g == false) goto L8;
            b r4 = r3.a;
            if (r4 == null) goto L9;
            r4.onClick();
            return;
        L9:
            return;
        }
    }

    public interface b {
        void onClick();
    }

    public ECHostDistributeCouponStatusLayout(Context r2) {
        super(r2);
        this.c = -2146035677;
        this.d = -1;
        this.e = 2131234484;
        this.f = 2131234301;
        this.g = false;
        a(r2);
    }

    public final void a(Context r3) {
        this.d = r3.getResources().getColor(2131101672);
        this.e = 2131234484;
        TextView r0 = new TextView(r3);
        this.b = r0;
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.b.setTextSize(1, 13.0f);
        this.b.setGravity(17);
        addView(this.b);
        this.b.setOnClickListener(new a(this));
    }

    public void setDistributeClickListener(b r1) {
        this.a = r1;
    }

    public void setDistributeCouponButtonAlpha(float r2) {
        this.b.setAlpha(r2);
    }

    public ECHostDistributeCouponStatusLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = -2146035677;
        this.d = -1;
        this.e = 2131234484;
        this.f = 2131234301;
        this.g = false;
        a(r1);
    }

    public final void b(String r4, boolean r5) {
        this.g = true;
        this.b.setTextColor(getContext().getResources().getColor(2131101703));
        if (r5 == false) goto L5;
        this.b.setBackgroundResource(this.e);
    L6:
        this.b.setText(r4);
        return;
    L5:
        this.b.setBackgroundResource(this.f);
        goto L6
    }

    public ECHostDistributeCouponStatusLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = -2146035677;
        this.d = -1;
        this.e = 2131234484;
        this.f = 2131234301;
        this.g = false;
        a(r1);
    }
}
