package com.yalantis.ucrop.view.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.Locale;
import v19.c;

/* JADX INFO: loaded from: classes41.dex */
public class AspectRatioTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f464518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f464519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f464520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f464521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f464522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f464523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f464524g;

    public final void y() {
        if (TextUtils.isEmpty(this.f464522e) == true) goto L5;
        setText(this.f464522e);
        return;
    L5:
        setText(String.format(Locale.US, "%d:%d", new Object[]{Integer.valueOf((int) this.f464523f), Integer.valueOf((int) this.f464524g)}));
    }

    public AspectRatioTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (isSelected() == false) goto L6;
        r100.getClipBounds(this.f464518a);
        Rect r101 = this.f464518a;
        float r102 = (r101.right - r101.left) / 2.0f;
        float r103 = r101.bottom - (r101.top / 2.0f);
        int r104 = this.f464520c;
        r100.drawCircle(r102, r103 - (r104 * 1.5f), r104 / 2.0f, this.f464519b);
        return;
    }

    public void setActiveColor(int r100) {
        x(r100);
        invalidate();
    }

    public void setAspectRatio(AspectRatio r100) {
        this.f464522e = r100.f464422a;
        float r101 = r100.f464423b;
        this.f464523f = r101;
        float r102 = r100.f464424c;
        this.f464524g = r102;
        if (r101 != 0.0f) goto L5;
    L8:
        this.f464521d = 0.0f;
    L9:
        y();
        return;
    L5:
        if (r102 == 0.0f) goto L8;
        this.f464521d = r101 / r102;
        goto L9
    }

    public final void x(int r100) {
        Paint r101 = this.f464519b;
        if (r101 == null) goto L5;
        r101.setColor(r100);
    L5:
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{r100, ContextCompat.getColor(getContext(), c.b(com.larus.nova.R.attr.larus_neutral_100, getContext(), com.larus.nova.R.color.larus_neutral_100))}));
    }

    public AspectRatioTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AspectRatioTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f464518a = new Rect();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.ucrop_artv_ratio_title, com.larus.nova.R.attr.ucrop_artv_ratio_x, com.larus.nova.R.attr.ucrop_artv_ratio_y});
        setGravity(1);
        this.f464522e = r103.getString(0);
        this.f464523f = r103.getFloat(1, 0.0f);
        float r104 = r103.getFloat(2, 0.0f);
        this.f464524g = r104;
        float r105 = this.f464523f;
        if (r105 != 0.0f) goto L5;
    L8:
        this.f464521d = 0.0f;
    L9:
        this.f464520c = getContext().getResources().getDimensionPixelSize(com.larus.nova.R.dimen.ucrop_size_dot_scale_text_view);
        Paint r106 = new Paint(1);
        this.f464519b = r106;
        r106.setStyle(Paint.Style.FILL);
        y();
        x(getResources().getColor(com.larus.nova.R.color.ucrop_color_widget_active));
        r103.recycle();
        return;
    L5:
        if (r104 == 0.0f) goto L8;
        this.f464521d = r105 / r104;
        goto L9
    }
}
