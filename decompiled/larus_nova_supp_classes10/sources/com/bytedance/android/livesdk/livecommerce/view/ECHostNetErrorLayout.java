package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class ECHostNetErrorLayout extends FrameLayout {
    public View a;
    public View.OnClickListener b;

    public class a implements View.OnClickListener {
        public final /* synthetic */ ECHostNetErrorLayout a;

        public a(ECHostNetErrorLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public abstract TextView a();

    public abstract int getGrayColor();

    public ECHostNetErrorLayout(Context r1) {
        super(r1);
        b(r1);
    }

    public final void b(Context r4) {
        LayoutInflater r5 = LayoutInflater.from(r4);
        this.a = r5.inflate(2131560766, (ECHostNetErrorLayoutImpl) this, true);
        TextView r6 = a();
        if (r6 == null) goto L6;
        r6.setOnClickListener(new a(this));
        return;
    }

    public void setBackgroundGray(boolean r1) {
        if (r1 == false) goto L4;
        setBackgroundColor(getGrayColor());
        return;
    L4:
        setBackgroundColor(-1);
    }

    public void setRetryClickListener(View.OnClickListener r1) {
        this.b = r1;
    }

    public ECHostNetErrorLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        b(r1);
    }

    public ECHostNetErrorLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b(r1);
    }
}
