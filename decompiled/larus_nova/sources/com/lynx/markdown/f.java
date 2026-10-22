package com.lynx.markdown;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.JavaCanvasHelper;
import com.lynx.textra.TTText;
import com.lynx.textra.TTTextUtils;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends JavaCanvasHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f381429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<PointF> f381430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f381431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f381432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f381433e;

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void restore() {
        super.restore();
        ArrayList<PointF> r100 = this.f381430b;
        PointF r101 = (PointF) ListProtector.get(r100, r100.size() - 1);
        this.f381431c = r101.x;
        this.f381432d = r101.y;
        ArrayList<PointF> r102 = this.f381430b;
        ListProtector.remove(r102, r102.size() - 1);
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void save() {
        super.save();
        this.f381430b.add(new PointF(this.f381431c, this.f381432d));
    }

    public static Shader c(BBufferInputStream r110) throws IOException {
        float r100 = TTTextUtils.Dp2Px(r110.readFloat());
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        float r103 = TTTextUtils.Dp2Px(r110.readFloat());
        int r104 = r110.readInt();
        int[] r105 = new int[r104];
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r107 >= r104) goto L5;
        r105[r107] = r110.readInt();
        r107 = r107 + 1;
        goto L3
    L5:
        int r108 = r110.readInt();
        if (r108 != r104) goto L8;
        float[] r109 = new float[r108];
    L9:
        if (r106 >= r108) goto L15;
        float r111 = r110.readFloat();
        if (r109 == null) goto L13;
        r109[r106] = r111;
    L13:
        r106 = r106 + 1;
        goto L9
    L15:
        if (r104 >= 2) goto L18;
        return null;
    L18:
        return new LinearGradient(r100, r101, r102, r103, r105, r109, Shader.TileMode.CLAMP);
    L8:
        r109 = null;
        goto L9
    }

    public final void b(BBufferInputStream r110) throws IOException {
        byte r100 = r110.readByte();
        if (r100 != 0) goto L6;
        Path r111 = e(r110);
        this.canvas_.clipPath(r111);
        return;
    L6:
        if (r100 != 1) goto L20;
        Path r101 = e(r110);
        Paint r102 = this.paint_;
        d(r110, r102);
        int r112 = this.color_;
        if (r112 != 0) goto L10;
    L12:
        if (r112 == 0) goto L14;
        r102.setColor(r112);
        r102.setStyle(Paint.Style.FILL);
    L18:
        this.canvas_.drawPath(r101, r102);
        return;
    L14:
        int r113 = this.stroke_color_;
        if (r113 == 0) goto L17;
        r102.setColor(r113);
        r102.setStyle(Paint.Style.STROKE);
        goto L18
    L17:
        r102.setStyle(Paint.Style.FILL);
        goto L18
    L10:
        if (this.stroke_color_ != r112) goto L12;
        r102.setColor(r112);
        r102.setStyle(Paint.Style.FILL_AND_STROKE);
        goto L18
    L20:
        if (r100 != 2) goto L32;
        int r103 = r110.readInt();
        Path r104 = e(r110);
        Paint r105 = this.paint_;
        d(r110, r105);
        r105.setColor(this.color_);
        int r114 = this.color_;
        if (r114 != 0) goto L24;
    L26:
        if (r114 == 0) goto L29;
        r105.setStyle(Paint.Style.FILL);
        Canvas r115 = this.canvas_;
        Drawable r106 = this.f381429a.a(r103);
        r115.clipPath(r104);
        r106.draw(r115);
    L29:
        if (this.stroke_color_ == 0) goto L47;
        r105.setStyle(Paint.Style.STROKE);
        r105.setColor(this.stroke_color_);
        Canvas r116 = this.canvas_;
        Drawable r107 = this.f381429a.a(r103);
        r116.clipPath(r104);
        r107.draw(r116);
        return;
    L47:
        return;
    L24:
        if (this.stroke_color_ != r114) goto L26;
        r105.setStyle(Paint.Style.FILL_AND_STROKE);
        Canvas r117 = this.canvas_;
        Drawable r108 = this.f381429a.a(r103);
        r117.clipPath(r104);
        r108.draw(r117);
        return;
    L32:
        if (r100 != 3) goto L38;
        Shader r109 = c(r110);
        float r118 = TTTextUtils.Dp2Px(r110.readFloat());
        float r119 = TTTextUtils.Dp2Px(r110.readFloat());
        float r120 = TTTextUtils.Dp2Px(r110.readFloat());
        float r121 = TTTextUtils.Dp2Px(r110.readFloat());
        Paint r122 = this.paint_;
        d(r110, r122);
        a(r122, r109);
        if (r109 == null) goto L51;
        this.canvas_.drawRect(r118, r119, r120, r121, r122);
        r122.setShader(null);
        return;
    L51:
        return;
    L38:
        if (r100 != 4) goto L50;
        Shader r123 = c(r110);
        Path r124 = e(r110);
        r110.readFloat();
        r110.readFloat();
        r110.readFloat();
        r110.readFloat();
        Paint r125 = this.paint_;
        d(r110, r125);
        a(r125, r123);
        if (r123 == null) goto L52;
        this.canvas_.drawPath(r124, r125);
        r125.setShader(null);
        return;
    L52:
        return;
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void drawRunDelegate(BBufferInputStream r110) {
        int r100 = r110.readInt();
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r111 = TTTextUtils.Dp2Px(r110.readFloat());
        float r112 = TTTextUtils.Dp2Px(r110.readFloat());
        float r113 = TTTextUtils.Dp2Px(r110.readFloat());
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        if (r102 <= 0.0f) goto L5;
        this.canvas_.save();
        Path r114 = new Path();
        r114.addRoundRect(r101, r111, r112, r113, r102, r102, Path.Direction.CW);
        this.canvas_.clipPath(r114);
    L5:
        Canvas r103 = this.canvas_;
        Drawable r104 = this.f381429a.a(r100);
        r104.setBounds(new Rect((int) r101, (int) r111, (int) r112, (int) r113));
        r104.draw(r103);
        if (r102 <= 0.0f) goto L9;
        this.canvas_.restore();
        return;
    }

    public final Path e(BBufferInputStream r110) throws IOException {
        Path r100 = this.f381433e;
        if (r100 != null) goto L5;
        this.f381433e = new Path();
    L6:
        Path r101 = this.f381433e;
        int r102 = r110.readInt();
        int r111 = 0;
    L7:
        if (r111 >= r102) goto L33;
        byte r103 = r110.readByte();
        if (r103 != 0) goto L12;
        float r104 = TTTextUtils.Dp2Px(r110.readFloat());
        float r105 = TTTextUtils.Dp2Px(r110.readFloat());
        float r106 = TTTextUtils.Dp2Px(r110.readFloat());
        float r107 = r110.readFloat();
        r101.addArc(r104 - r106, r105 - r106, r104 + r106, r105 + r106, r107, r110.readFloat() - r107);
    L32:
        r111 = r111 + 1;
        goto L7
    L12:
        if (r103 != 1) goto L15;
        r101.addOval(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), Path.Direction.CW);
        goto L32
    L15:
        if (r103 != 2) goto L18;
        r101.addRect(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), Path.Direction.CW);
        goto L32
    L18:
        if (r103 != 3) goto L21;
        r101.addRoundRect(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), Path.Direction.CW);
        goto L32
    L21:
        if (r103 != 4) goto L24;
        r101.moveTo(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()));
        goto L32
    L24:
        if (r103 != 5) goto L27;
        r101.lineTo(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()));
        goto L32
    L27:
        if (r103 != 6) goto L30;
        r101.cubicTo(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()));
        goto L32
    L30:
        if (r103 != 7) goto L32;
        r101.quadTo(TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()), TTTextUtils.Dp2Px(r110.readFloat()));
        goto L32
    L33:
        return r101;
    L5:
        r100.rewind();
        goto L6
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void translate(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        this.canvas_.translate(r101, r102);
        this.f381431c += r101;
        this.f381432d += r102;
    }

    public f(Canvas r100, h r101) {
        super(TTText.mFontManager);
        this.f381430b = new ArrayList();
        this.canvas_ = r100;
        this.f381429a = r101;
    }

    public final void a(Paint r100, Shader r101) {
        r100.setShader(r101);
        r100.setColor(-1);
        boolean r102 = false;
        if (this.color_ == 0) goto L5;
        boolean r103 = true;
    L7:
        if (this.stroke_color_ == 0) goto L9;
        r102 = true;
    L9:
        if (r103 == false) goto L12;
        if (r102 == false) goto L12;
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        return;
    L12:
        if (r102 == false) goto L14;
        r100.setStyle(Paint.Style.STROKE);
        return;
    L14:
        r100.setStyle(Paint.Style.FILL);
        return;
    L5:
        r103 = false;
        goto L7
    }

    public final void d(BBufferInputStream r100, Paint r101) throws IOException {
        boolean r102 = true;
        r101.setAntiAlias(true);
        r101.setShader(null);
        r101.setStrokeWidth(TTTextUtils.Dp2Px(r100.readFloat()));
        this.color_ = r100.readInt();
        this.stroke_color_ = r100.readInt();
        float r103 = TTTextUtils.Dp2Px(r100.readFloat());
        this.text_size_ = r103;
        r101.setTextSize(r103);
        byte r104 = r100.readByte();
        if ((r104 & 4) <= 0) goto L5;
        boolean r105 = true;
    L6:
        this.is_bold_ = r105;
        if ((r104 & 8) <= 0) goto L9;
        boolean r106 = true;
    L10:
        this.is_italic_ = r106;
        if ((r104 & 16) > 0) goto L14;
        r102 = false;
    L14:
        this.is_underline_ = r102;
        return;
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
