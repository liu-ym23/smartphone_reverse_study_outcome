package com.ss.android.bytedcert.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class ClipHoleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f407739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f407740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f407741c;

    public ClipHoleView(Context r100) {
        this(r100, null, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        getDrawingRect(this.f407739a);
        this.f407741c.setAntiAlias(true);
        this.f407741c.setStyle(Paint.Style.FILL);
        r100.drawRect(this.f407739a, this.f407741c);
        int r101 = this.f407739a.centerX();
        int r102 = this.f407739a.centerY();
        RectF r103 = i.c(getContext(), r101, r102, getWidth(), getHeight(), false);
        this.f407740b.setStyle(Paint.Style.FILL);
        this.f407740b.setAlpha(0);
        r100.drawRoundRect(r103, i.b(getContext(), 12.0f), i.b(getContext(), 12.0f), this.f407740b);
    }

    public ClipHoleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public ClipHoleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407739a = new Rect();
        Paint r103 = new Paint();
        this.f407740b = r103;
        Paint r104 = new Paint();
        this.f407741c = r104;
        r103.setAntiAlias(true);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r104.setAntiAlias(true);
        r104.setColor(getResources().getColor(R.color.byted_transparent));
    }
}
