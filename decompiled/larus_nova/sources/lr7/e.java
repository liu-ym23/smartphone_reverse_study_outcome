package lr7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.textra.BBufferInputStream;
import com.lynx.textra.JavaCanvasHelper;
import com.lynx.textra.TTText;
import com.lynx.textra.TTTextDefinition;
import com.lynx.textra.TTTextUtils;
import java.io.IOException;
import java.util.ArrayList;
import kr7.m;
import kr7.q;
import kr7.r;
import kr7.t;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends JavaCanvasHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f510437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<PointF> f510438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f510439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f510440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f510441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f510442f;

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void restore() {
        super.restore();
        ArrayList<PointF> r100 = this.f510438b;
        PointF r101 = (PointF) ListProtector.get(r100, r100.size() - 1);
        this.f510439c = r101.x;
        this.f510440d = r101.y;
        ArrayList<PointF> r102 = this.f510438b;
        ListProtector.remove(r102, r102.size() - 1);
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void save() {
        super.save();
        this.f510438b.add(new PointF(this.f510439c, this.f510440d));
    }

    public final void a(byte[] r100) {
        BBufferInputStream r101 = new BBufferInputStream(r100);
    L13:
        if (r101.available() <= 0) goto L21;
        byte r102 = r101.readByte();     // Catch: IOException -> L10
        if (r102 == (-1)) goto L7;
        drawOp(TTTextDefinition.GetCanvasOp(r102), r101);     // Catch: IOException -> L10
        goto L13
    L7:
        b(r101);     // Catch: IOException -> L10
        goto L13
    L21:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b(BBufferInputStream r100) throws IOException {
        byte r101 = r100.readByte();
        if (r101 != 0) goto L6;
        Path r102 = e(r100);
        this.canvas_.clipPath(r102);
        return;
    L6:
        if (r101 != 1) goto L9;
        Path r103 = e(r100);
        Paint r104 = this.paint_;
        d(r100, r104);
        this.canvas_.drawPath(r103, r104);
        return;
    L9:
        if (r101 != 2) goto L26;
        int r105 = r100.readInt();
        Path r106 = e(r100);
        Paint r107 = this.paint_;
        d(r100, r107);
        if (this.f510441e == null) goto L29;
        r107.setColor(this.color_);
        int r108 = this.color_;
        if (r108 != 0) goto L16;
    L18:
        if (r108 == 0) goto L21;
        r107.setStyle(Paint.Style.FILL);
        c(this.canvas_, this.f510437a.b(r105), r106, r107);
    L21:
        if (this.stroke_color_ == 0) goto L28;
        r107.setStyle(Paint.Style.STROKE);
        r107.setColor(this.stroke_color_);
        c(this.canvas_, this.f510437a.b(r105), r106, r107);
        return;
    L28:
        return;
    L16:
        if (this.stroke_color_ != r108) goto L18;
        r107.setStyle(Paint.Style.FILL_AND_STROKE);
        c(this.canvas_, this.f510437a.b(r105), r106, r107);
        return;
    L29:
        return;
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void drawRunDelegate(BBufferInputStream r110) throws IOException {
        int r100 = r110.readInt();
        float r101 = TTTextUtils.Dp2Px(r110.readFloat());
        float r111 = TTTextUtils.Dp2Px(r110.readFloat());
        float r112 = TTTextUtils.Dp2Px(r110.readFloat());
        float r113 = TTTextUtils.Dp2Px(r110.readFloat());
        float r102 = TTTextUtils.Dp2Px(r110.readFloat());
        if (this.f510441e != null) goto L6;
        return;
    L6:
        if (r102 <= 0.0f) goto L8;
        this.canvas_.save();
        Path r114 = new Path();
        r114.addRoundRect(r101, r111, r112, r113, r102, r102, Path.Direction.CW);
        this.canvas_.clipPath(r114);
    L8:
        Canvas r103 = this.canvas_;
        c r104 = this.f510437a.b(r100);
        Rect r105 = new Rect((int) r101, (int) r111, (int) r112, (int) r113);
        t r106 = (t) r104;
        if ((r106 instanceof r) == false) goto L12;
        int r107 = r105.left;
        int r108 = (int) this.f510439c;
        r105.left = r107 + r108;
        r105.right += r108;
        int r109 = r105.top;
        int r115 = (int) this.f510440d;
        r105.top = r109 + r115;
        r105.bottom += r115;
        this.f510441e.b((r) r106, r105);
    L17:
        if (r102 <= 0.0f) goto L20;
        this.canvas_.restore();
        return;
    L20:
        return;
    L12:
        if ((r106 instanceof q) == false) goto L15;
        ((q) r106).d(r103, r105);
        goto L17
    L15:
        if ((r106 instanceof m) == false) goto L17;
        m r116 = (m) r106;
        r116.f505772c.setBounds(r105.left, r105.top, r105.right, r105.bottom);
        r116.f505772c.draw(r103);
        goto L17
    }

    public final Path e(BBufferInputStream r110) throws IOException {
        Path r100 = this.f510442f;
        if (r100 != null) goto L5;
        this.f510442f = new Path();
    L6:
        Path r101 = this.f510442f;
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

    public final void f(Canvas r100) {
        this.canvas_ = r100;
    }

    @Override // com.lynx.textra.JavaCanvasHelper
    public final void translate(BBufferInputStream r100) throws IOException {
        float r101 = TTTextUtils.Dp2Px(r100.readFloat());
        float r102 = TTTextUtils.Dp2Px(r100.readFloat());
        this.canvas_.translate(r101, r102);
        this.f510439c += r101;
        this.f510440d += r102;
    }

    public final void d(BBufferInputStream r100, Paint r101) throws IOException {
        boolean r102 = true;
        r101.setAntiAlias(true);
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

    public e(Canvas r100, d r101, b r102) {
        super(TTText.mFontManager);
        this.f510438b = new ArrayList();
        this.canvas_ = r100;
        this.f510437a = r101;
        this.f510441e = r102;
    }

    public static void c(Canvas r100, c r101, Path r102, Paint r103) {
        t r104 = (t) r101;
        RectF r105 = new RectF();
        r102.computeBounds(r105, false);
        if ((r104 instanceof q) == false) goto L6;
        r100.clipPath(r102);
        ((q) r104).d(r100, new Rect((int) r105.left, (int) r105.top, (int) r105.right, (int) r105.bottom));
        return;
    L6:
        if ((r104 instanceof m) == false) goto L10;
        m r106 = (m) r104;
        r106.f505772c.setBounds(new Rect((int) r105.left, (int) r105.top, (int) r105.right, (int) r105.bottom));
        r103.setShader(r106.f505772c.f2071b);
        r100.drawPath(r102, r103);
        r103.setShader(null);
        return;
    }
}
