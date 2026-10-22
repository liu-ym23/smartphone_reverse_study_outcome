package com.larksuite.component.card.component.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.base.TraceEvent;
import idb.f;

/* JADX INFO: loaded from: classes24.dex */
public class UniversalCardRoundedImageView extends LKUIRoundedImageView2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f283404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f283405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f283406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Rect f283407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f283408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f283409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f283410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f283411h;

    public interface a {
        void I(int r100, int r101);
    }

    public UniversalCardRoundedImageView(Context r100) {
        super(r100);
        this.f283404a = new Rect();
        this.f283410g = 0;
    }

    @Override // com.larksuite.component.ui.imageview.LKUIRoundedImageView2, android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        TraceEvent.beginSection("UniversalCardRoundedImageView.onDraw");
        super.onDraw(r100);
        if (this.f283407d == null) goto L5;
        r100.drawRect(this.f283404a, this.f283406c);
        String r101 = this.f283408e;
        float r102 = (getWidth() - this.f283407d.width()) / 2.0f;
        Rect r103 = this.f283404a;
        r100.drawText(r101, r102, (r103.bottom - (r103.height() / 2.0f)) + this.f283409f, this.f283405b);
    L5:
        TraceEvent.endSection("UniversalCardRoundedImageView.onDraw");
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        if ((!f.a().isCurrentEnable("universal_card.gif_scale_fix_disable")) == false) goto L13;
        Matrix r101 = new Matrix();
        if ((r100 instanceof GifDrawable) == true) goto L7;
    L11:
        setImageMatrix(r101);
        return;
    L7:
        if (this.f283410g == 0) goto L11;
        int r102 = r100.getIntrinsicWidth();
        int r103 = this.f283410g;
        if (r102 == r103) goto L11;
        float r104 = r103 / r100.getIntrinsicWidth();
        r101.setScale(r104, r104);
        goto L11
    }

    public void setOnSizeChangedListener(a r100) {
        this.f283411h = r100;
    }

    public final void j(int r100, int r101) {
        if (this.f283407d == null) goto L6;
        Rect r102 = this.f283404a;
        r102.left = 0;
        r102.top = r101 - UIUtils.dp2px(getContext(), 16.0f);
        Rect r103 = this.f283404a;
        r103.right = r100;
        r103.bottom = r101;
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        j(r100, r101);
        a r104 = this.f283411h;
        if (r104 == null) goto L6;
        r104.I(r100, r101);
        return;
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        TraceEvent.beginSection("UniversalCardRoundedImageView.onLayout");
        super.onLayout(r100, r101, r102, r103, r104);
        TraceEvent.endSection("UniversalCardRoundedImageView.onLayout");
    }
}
