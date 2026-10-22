package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RemoteGroupHeadImageView extends SimpleDraweeView {
    public static final Float f = null;
    public static final Float g = null;
    public Paint a;
    public RectF b;
    public boolean c;
    public float d;
    public float e;

    static {
        f = Float.valueOf(9.0f);
        g = Float.valueOf(4.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteGroupHeadImageView(Context r3) {
        super(r3);
        this.c = false;
        this.d = 1.0f / f.floatValue();
        this.e = 1.0f / g.floatValue();
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
        float r0 = (-getHeight()) * this.d;
        float r1 = getWidth() * this.e;
        float r2 = getWidth() + (getWidth() * this.d);
        float r3 = r1 - (r2 - r0);
        RectF r4 = this.b;
        if (r4 == null) goto L12;
        r4.set(r3, r0, r1, r2);
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

    public void setRightOffsetPercent(float r1) {
        this.e = r1;
    }

    public void setTopOffsetPercent(float r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteGroupHeadImageView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.c = false;
        this.d = 1.0f / f.floatValue();
        this.e = 1.0f / g.floatValue();
        setBackgroundColor(0);
        setClip(true);
    }
}
