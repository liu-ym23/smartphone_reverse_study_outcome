package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.larus.nova.R;
import wqc.a;
import wqc.b;

/* JADX INFO: loaded from: classes41.dex */
public class UCropView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureCropImageView f464516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OverlayView f464517b;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public GestureCropImageView getCropImageView() {
        return this.f464516a;
    }

    public OverlayView getOverlayView() {
        return this.f464517b;
    }

    public UCropView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public UCropView(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        LayoutInflater.from(r100).inflate(R.layout.ucrop_view, this, true);
        GestureCropImageView r112 = (GestureCropImageView) findViewById(R.id.image_view_crop);
        this.f464516a = r112;
        OverlayView r101 = (OverlayView) findViewById(R.id.view_overlay);
        this.f464517b = r101;
        TypedArray r102 = r100.obtainStyledAttributes(r110, new int[]{R.attr.ucrop_aspect_ratio_x, R.attr.ucrop_aspect_ratio_y, R.attr.ucrop_circle_dimmed_layer, R.attr.ucrop_dimmed_color, R.attr.ucrop_frame_color, R.attr.ucrop_frame_stroke_size, R.attr.ucrop_grid_color, R.attr.ucrop_grid_column_count, R.attr.ucrop_grid_row_count, R.attr.ucrop_grid_stroke_size, R.attr.ucrop_show_frame, R.attr.ucrop_show_grid, R.attr.ucrop_show_oval_crop_frame});
        r101.getClass();
        r101.f464485l = r102.getBoolean(2, false);
        int r103 = r102.getColor(3, r101.getResources().getColor(R.color.ucrop_color_default_dimmed));
        r101.f464486m = r103;
        r101.f464488o.setColor(r103);
        r101.f464488o.setStyle(Paint.Style.STROKE);
        r101.f464488o.setStrokeWidth(1.0f);
        int r104 = r102.getDimensionPixelSize(5, r101.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int r105 = r102.getColor(4, r101.getResources().getColor(R.color.ucrop_color_default_crop_frame));
        r101.f464490q.setStrokeWidth(r104);
        r101.f464490q.setColor(r105);
        r101.f464490q.setStyle(Paint.Style.STROKE);
        r101.f464491r.setStrokeWidth(r104 * 3);
        r101.f464491r.setColor(r105);
        r101.f464491r.setStyle(Paint.Style.STROKE);
        r101.f464483j = r102.getBoolean(10, true);
        int r106 = r102.getDimensionPixelSize(9, r101.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int r107 = r102.getColor(6, r101.getResources().getColor(R.color.ucrop_color_default_crop_grid));
        r101.f464489p.setStrokeWidth(r106);
        r101.f464489p.setColor(r107);
        r101.f464479f = r102.getInt(8, 2);
        r101.f464480g = r102.getInt(7, 2);
        r101.f464484k = r102.getBoolean(11, true);
        r112.getClass();
        float r108 = Math.abs(r102.getFloat(0, 0.0f));
        float r109 = Math.abs(r102.getFloat(1, 0.0f));
        if (r108 != 0.0f) goto L5;
    L8:
        r112.f464444r = 0.0f;
    L9:
        r102.recycle();
        r112.setCropBoundsChangeListener(new a(this));
        r101.setOverlayViewChangeListener(new b(this));
        return;
    L5:
        if (r109 == 0.0f) goto L8;
        r112.f464444r = r108 / r109;
        goto L9
    }
}
