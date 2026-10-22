package com.bytedance.bdp.serviceapi.defaults.ui.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class OvalImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f201586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f201587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f201588c;

    public OvalImageView(Context r100) {
        super(r100);
        this.f201586a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f201587b = new Path();
        this.f201588c = new RectF();
    }

    public final void j(AttributeSet r110) {
        TypedArray r111 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.bdp_leftbottom_x_radius, R.attr.bdp_leftbottom_y_radius, R.attr.bdp_lefttop_x_radius, R.attr.bdp_lefttop_y_radius, R.attr.bdp_rightbottom_x_radius, R.attr.bdp_rightbottom_y_radius, R.attr.bdp_righttop_x_radius, R.attr.bdp_righttop_y_radius}, 0, 0);
        int r100 = r111.getIndexCount();     // Catch: Throwable -> L30
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L28;
        int r102 = r111.getIndex(r101);     // Catch: Throwable -> L30
        if (r102 != 2) goto L9;
        this.f201586a[0] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
    L27:
        r101 = r101 + 1;
        goto L4
    L9:
        if (r102 != 3) goto L12;
        this.f201586a[1] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L12:
        if (r102 != 6) goto L15;
        this.f201586a[2] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L15:
        if (r102 != 7) goto L18;
        this.f201586a[3] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L18:
        if (r102 != 0) goto L21;
        this.f201586a[4] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L21:
        if (r102 != 1) goto L23;
        this.f201586a[5] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L23:
        if (r102 != 4) goto L25;
        this.f201586a[6] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L25:
        if (r102 != 5) goto L27;
        this.f201586a[7] = r111.getDimensionPixelOffset(r102, 0);     // Catch: Throwable -> L30
        goto L27
    L28:
        r111.recycle();
        return;
    L30:
        th = move-exception;
        r111.recycle();
        throw th;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        this.f201587b.reset();
        this.f201588c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f201587b.addRoundRect(this.f201588c, this.f201586a, Path.Direction.CW);
        r100.clipPath(this.f201587b);
        super.onDraw(r100);
    }

    public OvalImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f201586a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f201587b = new Path();
        this.f201588c = new RectF();
        j(r101);
    }

    public OvalImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f201586a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.f201587b = new Path();
        this.f201588c = new RectF();
        j(r101);
    }
}
