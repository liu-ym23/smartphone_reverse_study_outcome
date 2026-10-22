package com.ss.android.lark.guide.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class ArrowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f425799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f425800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Drawable f425801c;

    public ArrowView(Context r100) {
        super(r100);
        this.f425799a = getContext().getResources().getColor(R.color.primary_fill_hover);
        this.f425800b = 48;
        Drawable r101 = AppCompatResources.getDrawable(getContext(), R.drawable.ic_guide_arrow);
        this.f425801c = r101;
        r101.setTint(this.f425799a);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = getWidth();
        int r102 = getHeight();
        r100.save();
        int r103 = this.f425800b;
        if (r103 != 3) goto L5;
    L18:
        r100.translate(0.0f, r102);
        r100.rotate(-90.0f, 0.0f, 0.0f);
        this.f425801c.setBounds(0, 0, r102, r101);
    L19:
        this.f425801c.draw(r100);
        r100.restore();
        return;
    L5:
        if (r103 != 5) goto L7;
    L17:
        r100.translate(r101, 0.0f);
        r100.rotate(90.0f, 0.0f, 0.0f);
        this.f425801c.setBounds(0, 0, r102, r101);
        goto L19
    L7:
        if (r103 != 48) goto L9;
        this.f425801c.setBounds(0, 0, r101, r102);
        goto L19
    L9:
        if (r103 != 80) goto L11;
        this.f425801c.setBounds(0, 0, r101, r102);
        r100.rotate(180.0f, (r101 * 1.0f) / 2.0f, (r102 * 1.0f) / 2.0f);
        goto L19
    L11:
        if (r103 == 8388611) goto L18;
        if (r103 == 8388613) goto L17;
        goto L17
    }

    public void setAnchorGravity(int r100) {
        this.f425800b = r100;
    }

    public void setFillColor(int r100) {
        this.f425799a = r100;
        this.f425801c.setTint(r100);
    }

    public ArrowView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f425799a = getContext().getResources().getColor(R.color.primary_fill_hover);
        this.f425800b = 48;
        Drawable r102 = AppCompatResources.getDrawable(getContext(), R.drawable.ic_guide_arrow);
        this.f425801c = r102;
        r102.setTint(this.f425799a);
    }

    public ArrowView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f425799a = getContext().getResources().getColor(R.color.primary_fill_hover);
        this.f425800b = 48;
        Drawable r103 = AppCompatResources.getDrawable(getContext(), R.drawable.ic_guide_arrow);
        this.f425801c = r103;
        r103.setTint(this.f425799a);
    }
}
