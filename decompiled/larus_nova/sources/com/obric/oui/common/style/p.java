package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes33.dex */
public final class p extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f399586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f399587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f399588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f399589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DisplayMetrics f399590e;

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r100 = getDrawable();
        if ((r100 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r100).isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r100 = getDrawable();
        if ((r100 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r100).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r100 = getDrawable();
        if ((r100 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r100).stop();
        return;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = r100.saveLayer(this.f399588c, this.f399586a);
        super.draw(r100);
        Bitmap r102 = this.f399587b;
        if (r102 == null) goto L6;
        this.f399586a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r100.drawBitmap(r102, 0.0f, 0.0f, this.f399586a);
        this.f399586a.setXfermode(null);
    L6:
        r100.restoreToCount(r101);
    }

    public p(Drawable r100, DisplayMetrics r101) {
        Intrinsics.checkNotNullParameter(r100, "bg");
        Intrinsics.checkNotNullParameter(r101, "displayMetrics");
        Intrinsics.checkNotNullParameter(r100, "bg");
        super(r100);
        Paint r102 = new Paint(1);
        this.f399586a = r102;
        this.f399589d = 16.0f;
        r102.setStyle(Paint.Style.FILL);
        r102.setAntiAlias(true);
        this.f399590e = r101;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void inflate(Resources r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r103) {
        Intrinsics.checkNotNullParameter(r100, "r");
        Intrinsics.checkNotNullParameter(r101, "parser");
        Intrinsics.checkNotNullParameter(r102, "attrs");
        super.inflate(r100, r101, r102, r103);
        int r104 = r101.getDepth();
        this.f399590e = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        Drawable r105 = null;
    L3:
        int r106 = r101.next();
        if (r106 == 1) goto L19;
        if (r106 != 3) goto L10;
        if (r101.getDepth() <= r104) goto L19;
    L10:
        if (r106 != 2) goto L3;
        if (Intrinsics.areEqual(r101.getName(), "corners") == true) goto L13;
        r105 = DrawableWrapper.createFromXmlInner(r100, r101, r102, r103);
        goto L3
    L13:
        int[] r107 = {R.attr.radius};
        if (r103 != null) goto L16;
        TypedArray r108 = r100.obtainAttributes(r102, r107);
    L17:
        this.f399589d = r108.getDimensionPixelSize(0, (int) this.f399589d);
        goto L3
    L16:
        r108 = r103.obtainStyledAttributes(r102, r107, 0, 0);
    L19:
        if (r105 == null) goto L31;
        setDrawable(r105);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r100, int r101, int r102, int r103) {
        super.setBounds(r100, r101, r102, r103);
        RectF r104 = new RectF(r100, r101, r102, r103);
        if (Intrinsics.areEqual(r104, this.f399588c) == true) goto L10;
        Bitmap r105 = this.f399587b;
        if (r105 == null) goto L8;
        r105.recycle();
    L8:
        Bitmap r106 = Bitmap.createBitmap(this.f399590e, r102 - r100, r103 - r101, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        float r108 = this.f399589d;
        r107.drawRoundRect(r104, r108, r108, this.f399586a);
        this.f399588c = r104;
        this.f399587b = r106;
        return;
    }
}
