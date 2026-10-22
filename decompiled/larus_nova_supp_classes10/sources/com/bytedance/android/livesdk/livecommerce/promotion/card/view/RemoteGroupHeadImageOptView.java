package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RemoteGroupHeadImageOptView extends SimpleDraweeView {
    public static final Float d = null;
    public static final Float e = null;
    public Paint a;
    public RectF b;
    public boolean c;

    static {
        d = Float.valueOf(7.0f);
        e = Float.valueOf(2.8f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteGroupHeadImageOptView(Context r1) {
        super(r1);
        this.c = false;
        setBackgroundColor(0);
        setClip(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r12) {
        super/*android.widget.ImageView*/.onDraw(r12);
        if (this.c == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L11;
        float r0 = -getHeight();
        Float r1 = d;
        float r2 = r0 / r1.floatValue();
        float r3 = -getWidth();
        float r4 = getWidth() / e.floatValue();
        float r5 = getWidth() + (getWidth() / r1.floatValue());
        RectF r6 = this.b;
        if (r6 == null) goto L12;
        r6.set(r3, r2, r4, r5);
        r12.drawArc(this.b, -90.0f, 180.0f, false, this.a);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setClip(boolean r3) {
        this.c = r3;
        if (r3 == false) goto L6;
        setLayerType(2, null);
        Paint r4 = new Paint();
        this.a = r4;
        r4.setAntiAlias(true);
        this.a.setColor(getResources().getColor(2131101523));
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b = new RectF();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteGroupHeadImageOptView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = false;
        setBackgroundColor(0);
        setClip(true);
    }
}
