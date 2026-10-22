package com.bytedance.lighten.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;

/* JADX INFO: loaded from: classes20.dex */
public class SmartCircleImageView extends SmartImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f254694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f254695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f254696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Canvas f254697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f254698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f254699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f254700l;

    public final void p() {
        if (this.f254700l == true) goto L5;
        return;
    L5:
        Drawable r100 = getDrawable();
        this.f254696h = r100;
        if (r100 != null) goto L9;
        return;
    L9:
        if (getWidth() > 0) goto L11;
        return;
    L11:
        if (getHeight() > 0) goto L14;
        return;
    L14:
        if (this.f254696h.getOpacity() == (-1)) goto L16;
        Bitmap.Config r101 = Bitmap.Config.ARGB_8888;
    L17:
        int r102 = this.f254696h.getIntrinsicWidth();
        int r103 = this.f254696h.getIntrinsicHeight();
        if (r102 > 0) goto L20;
        r102 = getWidth();
    L20:
        if (r103 > 0) goto L22;
        r103 = getHeight();
    L22:
        Bitmap r104 = this.f254695g;
        if (r104 != null) goto L25;
    L36:
        this.f254699k = Math.min(r102, r103) / 2;
        this.f254695g = Bitmap.createBitmap(r102, r103, r101);
        Canvas r105 = new Canvas(this.f254695g);
        this.f254697i = r105;
        this.f254696h.setBounds(0, 0, r105.getWidth(), this.f254697i.getHeight());
        Bitmap r106 = this.f254695g;
        Shader.TileMode r107 = Shader.TileMode.CLAMP;
        BitmapShader r108 = new BitmapShader(r106, r107, r107);
        this.f254694f.setAntiAlias(true);
        this.f254694f.setShader(r108);
        return;
    L25:
        if (r102 != r104.getWidth()) goto L34;
        if (r103 != this.f254695g.getHeight()) goto L34;
        Canvas r109 = this.f254697i;
        if (r109 == null) goto L38;
        r109.drawColor(0, PorterDuff.Mode.CLEAR);
        return;
    L38:
        return;
    L34:
        if (this.f254695g.isRecycled() == true) goto L36;
        this.f254695g.recycle();
        goto L36
    L16:
        r101 = Bitmap.Config.RGB_565;
        goto L17
    }

    @Override // com.bytedance.lighten.loader.SmartImageView
    public final void j() {
        RoundingParams r100 = getHierarchy().getRoundingParams();
        if (r100 != null) goto L5;
        r100 = new RoundingParams();
    L5:
        r100.setRoundAsCircle(true);
        getHierarchy().setRoundingParams(r100);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        p();
    }

    public SmartCircleImageView(Context r100) {
        super(r100);
        this.f254694f = new Paint();
        this.f254698j = true;
    }

    @Override // com.bytedance.lighten.loader.SmartImageView
    public final void f(df6.t r100) {
        df6.s r101 = df6.s.f468248a;
        if (df6.q.a().f468235e == false) goto L5;
        r100.getClass();
    L7:
        if (df6.q.a().f468235e == false) goto L13;
        hf6.f r102 = r100.B;
        if (r102 != null) goto L11;
        r100.B = new z(this);
    L18:
        super.f(r100);
        return;
    L11:
        r100.B = new a0(this, r102);
        goto L18
    L13:
        if (this.f254700l == false) goto L18;
        hf6.f r103 = r100.B;
        if (r103 != null) goto L17;
        r100.B = new b0(this);
        goto L18
    L17:
        r100.B = new c0(this, r103);
        goto L18
    L5:
        r100.getClass();
        this.f254700l = false;
        goto L7
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        df6.s r101 = df6.s.f468248a;
        if (df6.q.a().f468235e == false) goto L6;
        super.onDraw(r100);
        return;
    L6:
        if (this.f254700l == true) goto L8;
        super.onDraw(r100);
        return;
    L8:
        if (this.f254698j == false) goto L10;
        p();
        this.f254698j = false;
    L10:
        Drawable r102 = this.f254696h;
        if (r102 == null) goto L15;
        Canvas r103 = this.f254697i;
        if (r103 == null) goto L15;
        r102.draw(r103);
    L15:
        r100.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f254699k, this.f254694f);
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(DraweeController r100) {
        if (this.f254700l == false) goto L5;
        this.f254698j = true;
        setImageDrawable(null);
    L5:
        super.setController(r100);
    }

    public SmartCircleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f254694f = new Paint();
        this.f254698j = true;
    }

    public SmartCircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f254694f = new Paint();
        this.f254698j = true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        p();
    }
}
