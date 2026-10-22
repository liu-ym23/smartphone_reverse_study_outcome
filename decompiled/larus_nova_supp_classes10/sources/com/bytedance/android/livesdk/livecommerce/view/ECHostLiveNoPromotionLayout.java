package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class ECHostLiveNoPromotionLayout extends FrameLayout implements View.OnClickListener {
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public View.OnClickListener e;

    public abstract TextView a(View r1);

    public abstract void b();

    public abstract TextView c(View r1);

    public ECHostLiveNoPromotionLayout(Context r1) {
        super(r1);
        d(r1);
    }

    public final void d(Context r3) {
        View r4 = View.inflate(r3, 2131560778, (ECHostLiveNoPromotionLayoutImpl) this);
        this.a = r4;
        this.b = c(r4);
        b();
        this.c = null;
        TextView r5 = a(this.a);
        this.d = r5;
        if (r5 == null) goto L6;
        r5.setOnClickListener(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 != this.d) goto L8;
        View.OnClickListener r0 = this.e;
        if (r0 == null) goto L9;
        r0.onClick(r2);
        return;
    L9:
        return;
    }

    public void setIronNoPromotion(String r3) {
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
        this.b.setText(r3);
        this.b.setTypeface(Typeface.DEFAULT_BOLD);
    L5:
        TextView r4 = this.c;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        TextView r5 = this.d;
        if (r5 == null) goto L12;
        r5.setVisibility(8);
        return;
    }

    public void setOnAddButtonClickListener(View.OnClickListener r1) {
        this.e = r1;
    }

    public ECHostLiveNoPromotionLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        d(r1);
    }

    public ECHostLiveNoPromotionLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        d(r1);
    }
}
