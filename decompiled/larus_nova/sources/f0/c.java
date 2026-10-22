package f0;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public final class c extends View {
    public int A;
    public boolean B;
    public String C;
    public String D;
    public String E;
    public int F;
    public int G;
    public boolean H;
    public boolean H0;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f474916J;
    public int K;
    public boolean L;
    public boolean L0;
    public boolean M;
    public boolean N;
    public Drawable O;
    public Bitmap P;
    public boolean P0;
    public float Q;
    public float R;
    public Bitmap S;
    public Bitmap T;
    public Bitmap U;
    public Bitmap V;
    public QRCodeView V0;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f474917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f474918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Rect f474919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f474920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f474921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f474922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f474923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f474924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f474925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f474926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f474927k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public StaticLayout f474928k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f474929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f474930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f474931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f474932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f474933p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f474934p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f474935q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f474936r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f474937s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f474938t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bitmap f474939u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f474940v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f474941w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f474942x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f474943y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f474944z;

    public final void b() {
        if (this.O != null) goto L16;
        if (this.N == true) goto L16;
        if (this.f474938t != null) goto L12;
        if (this.f474937s == true) goto L12;
    L20:
        if (this.B == false) goto L22;
        this.E = this.D;
        this.f474930m = this.f474931n;
        this.f474918b = (int) (((this.f474942x * 1.0f) * this.f474917a) / this.f474929l);
    L24:
        if (TextUtils.isEmpty(this.E) == true) goto L30;
        if (this.f474916J == false) goto L28;
        this.f474928k0 = new StaticLayout(this.E, this.f474923g, a.e(getContext()).x, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        goto L30
    L28:
        this.f474928k0 = new StaticLayout(this.E, this.f474923g, this.f474929l - (this.f474934p0 * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
    L30:
        if (this.f474943y == (-1.0f)) goto L41;
        int r100 = a.e(getContext()).y;
        Context r101 = getContext();
        int r102 = 0;
        TypedArray r103 = r101.getTheme().obtainStyledAttributes(new int[]{R.attr.windowFullscreen});
        boolean r104 = r103.getBoolean(0, false);
        r103.recycle();
        if (r104 == true) goto L37;
        int r105 = r101.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r105 <= 0) goto L37;
        r102 = r101.getResources().getDimensionPixelSize(r105);
    L37:
        int r106 = r100 - r102;
        int r107 = this.A;
        if (r107 != 0) goto L40;
        this.f474932o = (int) ((r106 * this.f474943y) - (this.f474930m / 2));
        goto L41
    L40:
        this.f474932o = r107 + ((int) (((r106 - r107) * this.f474943y) - (this.f474930m / 2)));
    L41:
        a();
        postInvalidate();
        return;
    L22:
        this.E = this.C;
        int r108 = this.f474929l;
        this.f474930m = r108;
        this.f474918b = (int) (((this.f474942x * 1.0f) * this.f474917a) / r108);
    L12:
        if (this.B == false) goto L14;
        this.f474939u = this.T;
        goto L20
    L14:
        this.f474939u = this.S;
    L16:
        if (this.B == false) goto L18;
        this.P = this.V;
        goto L20
    L18:
        this.P = this.U;
        goto L20
    }

    public final void a() {
        int r100 = (getWidth() - this.f474929l) / 2;
        int r101 = this.f474932o;
        Rect r102 = new Rect(r100, r101, this.f474929l + r100, this.f474930m + r101);
        this.f474919c = r102;
        if (this.B == false) goto L5;
        float r103 = (r102.left + this.W) + 0.5f;
        this.f474921e = r103;
        this.R = r103;
    L6:
        QRCodeView r104 = this.V0;
        if (r104 != null) goto L9;
        return;
    L9:
        if (this.H0 == false) goto L23;
        Rect r105 = new Rect(this.f474919c);
        cn.bingoogolapple.qrcode.core.a r106 = r104.f24313a;
        if (r106.f24319a != null) goto L13;
        return;
    L13:
        if (r105.left > 0) goto L15;
        return;
    L15:
        if (r105.top <= 0) goto L26;
        int r107 = r105.centerX();
        int r108 = r105.centerY();
        int r109 = r105.width() / 2;
        int r110 = r105.height() / 2;
        a.h(r105);
        if (a.f(r106.getContext()) == false) goto L20;
        r108 = r107;
        r107 = r108;
        r110 = r109;
        r109 = r110;
    L20:
        Rect r111 = new Rect(r107 - r109, r108 - r110, r107 + r109, r108 + r110);
        a.h(r111);
        r106.a(r111.centerX(), r111.centerY(), r111.width(), r111.height());
        return;
    L26:
        return;
    L23:
        return;
    L5:
        float r112 = (r102.top + this.W) + 0.5f;
        this.f474920d = r112;
        this.Q = r112;
        goto L6
    }

    public int getAnimTime() {
        return this.f474942x;
    }

    public String getBarCodeTipText() {
        return this.D;
    }

    public int getBarcodeRectHeight() {
        return this.f474931n;
    }

    public int getBorderColor() {
        return this.f474941w;
    }

    public int getBorderSize() {
        return this.f474940v;
    }

    public int getCornerColor() {
        return this.f474925i;
    }

    public int getCornerLength() {
        return this.f474926j;
    }

    public int getCornerSize() {
        return this.f474927k;
    }

    public Drawable getCustomScanLineDrawable() {
        return this.f474938t;
    }

    public float getHalfCornerSize() {
        return this.W;
    }

    public boolean getIsBarcode() {
        return this.B;
    }

    public int getMaskColor() {
        return this.f474924h;
    }

    public String getQRCodeTipText() {
        return this.C;
    }

    public int getRectHeight() {
        return this.f474930m;
    }

    public int getRectWidth() {
        return this.f474929l;
    }

    public Bitmap getScanLineBitmap() {
        return this.f474939u;
    }

    public int getScanLineColor() {
        return this.f474935q;
    }

    public int getScanLineMargin() {
        return this.f474936r;
    }

    public int getScanLineSize() {
        return this.f474933p;
    }

    public int getTipBackgroundColor() {
        return this.K;
    }

    public int getTipBackgroundRadius() {
        return this.f474934p0;
    }

    public String getTipText() {
        return this.E;
    }

    public int getTipTextColor() {
        return this.G;
    }

    public int getTipTextMargin() {
        return this.I;
    }

    public int getTipTextSize() {
        return this.F;
    }

    public StaticLayout getTipTextSl() {
        return this.f474928k0;
    }

    public int getToolbarHeight() {
        return this.A;
    }

    public int getTopOffset() {
        return this.f474932o;
    }

    public float getVerticalBias() {
        return this.f474943y;
    }

    public c(Context r100) {
        super(r100);
        Paint r101 = new Paint();
        this.f474922f = r101;
        r101.setAntiAlias(true);
        this.f474924h = ColorProtector.parseColor("#33FFFFFF");
        this.f474925i = -1;
        this.f474926j = a.d(r100, 20.0f);
        this.f474927k = a.d(r100, 3.0f);
        this.f474933p = a.d(r100, 1.0f);
        this.f474935q = -1;
        this.f474932o = a.d(r100, 90.0f);
        this.f474929l = a.d(r100, 200.0f);
        this.f474931n = a.d(r100, 140.0f);
        this.f474936r = 0;
        this.f474937s = false;
        this.f474938t = null;
        this.f474939u = null;
        this.f474940v = a.d(r100, 1.0f);
        this.f474941w = -1;
        this.f474942x = 1000;
        this.f474943y = -1.0f;
        this.f474944z = 1;
        this.A = 0;
        this.B = false;
        this.f474917a = a.d(r100, 2.0f);
        this.E = null;
        Resources r102 = r100.getResources();
        this.F = (int) TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        this.G = -1;
        this.H = false;
        this.I = a.d(r100, 20.0f);
        this.f474916J = false;
        this.K = ColorProtector.parseColor("#22000000");
        this.L = false;
        this.M = false;
        this.N = false;
        TextPaint r103 = new TextPaint();
        this.f474923g = r103;
        r103.setAntiAlias(true);
        this.f474934p0 = a.d(r100, 4.0f);
        this.H0 = false;
        this.L0 = false;
        this.P0 = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f474919c != null) goto L5;
        return;
    L5:
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (this.f474924h == 0) goto L9;
        this.f474922f.setStyle(Paint.Style.FILL);
        this.f474922f.setColor(this.f474924h);
        float r102 = r100;
        r110.drawRect(0.0f, 0.0f, r102, this.f474919c.top, this.f474922f);
        Rect r103 = this.f474919c;
        r110.drawRect(0.0f, r103.top, r103.left, r103.bottom + 1, this.f474922f);
        Rect r104 = this.f474919c;
        r110.drawRect(r104.right + 1, r104.top, r102, r104.bottom + 1, this.f474922f);
        r110.drawRect(0.0f, this.f474919c.bottom + 1, r102, r101, this.f474922f);
    L9:
        if (this.f474940v <= 0) goto L12;
        this.f474922f.setStyle(Paint.Style.STROKE);
        this.f474922f.setColor(this.f474941w);
        this.f474922f.setStrokeWidth(this.f474940v);
        r110.drawRect(this.f474919c, this.f474922f);
    L12:
        if (this.W <= 0.0f) goto L19;
        this.f474922f.setStyle(Paint.Style.STROKE);
        this.f474922f.setColor(this.f474925i);
        this.f474922f.setStrokeWidth(this.f474927k);
        int r105 = this.f474944z;
        if (r105 != 1) goto L16;
        Rect r106 = this.f474919c;
        float r107 = r106.left - this.W;
        float r108 = r106.top;
        r110.drawLine(r107, r108, r107 + this.f474926j, r108, this.f474922f);
        Rect r109 = this.f474919c;
        float r111 = r109.left;
        float r112 = r109.top - this.W;
        r110.drawLine(r111, r112, r111, r112 + this.f474926j, this.f474922f);
        Rect r113 = this.f474919c;
        float r114 = r113.right + this.W;
        float r115 = r113.top;
        r110.drawLine(r114, r115, r114 - this.f474926j, r115, this.f474922f);
        Rect r116 = this.f474919c;
        float r117 = r116.right;
        float r118 = r116.top - this.W;
        r110.drawLine(r117, r118, r117, r118 + this.f474926j, this.f474922f);
        Rect r119 = this.f474919c;
        float r120 = r119.left - this.W;
        float r121 = r119.bottom;
        r110.drawLine(r120, r121, r120 + this.f474926j, r121, this.f474922f);
        Rect r122 = this.f474919c;
        float r123 = r122.left;
        float r124 = r122.bottom + this.W;
        r110.drawLine(r123, r124, r123, r124 - this.f474926j, this.f474922f);
        Rect r125 = this.f474919c;
        float r126 = r125.right + this.W;
        float r127 = r125.bottom;
        r110.drawLine(r126, r127, r126 - this.f474926j, r127, this.f474922f);
        Rect r128 = this.f474919c;
        float r129 = r128.right;
        float r130 = r128.bottom + this.W;
        r110.drawLine(r129, r130, r129, r130 - this.f474926j, this.f474922f);
        goto L19
    L16:
        if (r105 != 2) goto L19;
        Rect r131 = this.f474919c;
        int r132 = r131.left;
        float r133 = r131.top + this.W;
        r110.drawLine(r132, r133, r132 + this.f474926j, r133, this.f474922f);
        Rect r134 = this.f474919c;
        float r135 = r134.left + this.W;
        int r136 = r134.top;
        r110.drawLine(r135, r136, r135, r136 + this.f474926j, this.f474922f);
        Rect r137 = this.f474919c;
        int r138 = r137.right;
        float r139 = r137.top + this.W;
        r110.drawLine(r138, r139, r138 - this.f474926j, r139, this.f474922f);
        Rect r140 = this.f474919c;
        float r141 = r140.right - this.W;
        int r142 = r140.top;
        r110.drawLine(r141, r142, r141, r142 + this.f474926j, this.f474922f);
        Rect r143 = this.f474919c;
        int r144 = r143.left;
        float r145 = r143.bottom - this.W;
        r110.drawLine(r144, r145, r144 + this.f474926j, r145, this.f474922f);
        Rect r146 = this.f474919c;
        float r147 = r146.left + this.W;
        int r148 = r146.bottom;
        r110.drawLine(r147, r148, r147, r148 - this.f474926j, this.f474922f);
        Rect r149 = this.f474919c;
        int r150 = r149.right;
        float r151 = r149.bottom - this.W;
        r110.drawLine(r150, r151, r150 - this.f474926j, r151, this.f474922f);
        Rect r152 = this.f474919c;
        float r153 = r152.right - this.W;
        int r154 = r152.bottom;
        r110.drawLine(r153, r154, r153, r154 - this.f474926j, this.f474922f);
    L19:
        if (this.B == false) goto L31;
        if (this.P == null) goto L27;
        Rect r155 = this.f474919c;
        float r156 = r155.left;
        float r157 = this.W;
        float r158 = r155.top + r157;
        float r159 = this.f474936r;
        RectF r160 = new RectF((r156 + r157) + 0.5f, r158 + r159, this.R, (r155.bottom - r157) - r159);
        Rect r161 = new Rect((int) (this.P.getWidth() - r160.width()), 0, this.P.getWidth(), this.P.getHeight());
        if (r161.left >= 0) goto L25;
        r161.left = 0;
        r160.left = r160.right - r161.width();
    L25:
        r110.drawBitmap(this.P, r161, r160, this.f474922f);
    L41:
        if (TextUtils.isEmpty(this.E) == true) goto L70;
        if (this.f474928k0 == null) goto L70;
        if (this.H == false) goto L59;
        if (this.L == false) goto L53;
        this.f474922f.setColor(this.K);
        this.f474922f.setStyle(Paint.Style.FILL);
        if (this.f474916J == false) goto L52;
        Rect r162 = new Rect();
        TextPaint r163 = this.f474923g;
        String r164 = this.E;
        r163.getTextBounds(r164, 0, r164.length(), r162);
        float r165 = ((r110.getWidth() - r162.width()) / 2) - this.f474934p0;
        RectF r166 = new RectF(r165, (this.f474919c.bottom + this.I) - this.f474934p0, (r162.width() + r165) + (this.f474934p0 * 2), ((this.f474919c.bottom + this.I) + this.f474928k0.getHeight()) + this.f474934p0);
        float r167 = this.f474934p0;
        r110.drawRoundRect(r166, r167, r167, this.f474922f);
        goto L53
    L52:
        Rect r168 = this.f474919c;
        float r169 = r168.left;
        int r170 = r168.bottom + this.I;
        RectF r171 = new RectF(r169, r170 - this.f474934p0, r168.right, (r170 + this.f474928k0.getHeight()) + this.f474934p0);
        float r172 = this.f474934p0;
        r110.drawRoundRect(r171, r172, r172, this.f474922f);
    L53:
        r110.save();
        if (this.f474916J == false) goto L56;
        r110.translate(0.0f, this.f474919c.bottom + this.I);
    L57:
        this.f474928k0.draw(r110);
        r110.restore();
        goto L70
    L56:
        Rect r173 = this.f474919c;
        r110.translate(r173.left + this.f474934p0, r173.bottom + this.I);
        goto L57
    L59:
        if (this.L == false) goto L64;
        this.f474922f.setColor(this.K);
        this.f474922f.setStyle(Paint.Style.FILL);
        if (this.f474916J == false) goto L63;
        Rect r174 = new Rect();
        TextPaint r175 = this.f474923g;
        String r176 = this.E;
        r175.getTextBounds(r176, 0, r176.length(), r174);
        float r177 = ((r110.getWidth() - r174.width()) / 2) - this.f474934p0;
        float r178 = ((this.f474919c.top - this.I) - this.f474928k0.getHeight()) - this.f474934p0;
        float r179 = r174.width() + r177;
        int r180 = this.f474934p0;
        RectF r181 = new RectF(r177, r178, r179 + (r180 * 2), (this.f474919c.top - this.I) + r180);
        float r182 = this.f474934p0;
        r110.drawRoundRect(r181, r182, r182, this.f474922f);
        goto L64
    L63:
        Rect r183 = this.f474919c;
        float r184 = r183.left;
        int r185 = (r183.top - this.I) - this.f474928k0.getHeight();
        int r186 = this.f474934p0;
        Rect r187 = this.f474919c;
        RectF r188 = new RectF(r184, r185 - r186, r187.right, (r187.top - this.I) + r186);
        float r189 = this.f474934p0;
        r110.drawRoundRect(r188, r189, r189, this.f474922f);
    L64:
        r110.save();
        if (this.f474916J == false) goto L67;
        r110.translate(0.0f, (this.f474919c.top - this.I) - this.f474928k0.getHeight());
    L68:
        this.f474928k0.draw(r110);
        r110.restore();
        goto L70
    L67:
        Rect r190 = this.f474919c;
        r110.translate(r190.left + this.f474934p0, (r190.top - this.I) - this.f474928k0.getHeight());
    L70:
        if (this.B == false) goto L90;
        if (this.P != null) goto L86;
        this.f474921e += this.f474917a;
        int r191 = this.f474933p;
        Bitmap r192 = this.f474939u;
        if (r192 == null) goto L77;
        r191 = r192.getWidth();
    L77:
        if (this.M == false) goto L83;
        float r193 = this.f474921e;
        float r194 = r191 + r193;
        Rect r195 = this.f474919c;
        float r196 = r195.right;
        float r197 = this.W;
        if (r194 <= (r196 - r197)) goto L81;
    L82:
        this.f474917a = -this.f474917a;
    L107:
        long r198 = this.f474918b;
        Rect r199 = this.f474919c;
        postInvalidateDelayed(r198, r199.left, r199.top, r199.right, r199.bottom);
        return;
    L81:
        if (r193 >= (r195.left + r197)) goto L107;
    L83:
        float r200 = this.f474921e + r191;
        Rect r201 = this.f474919c;
        float r202 = r201.right;
        float r203 = this.W;
        if (r200 <= (r202 - r203)) goto L107;
        this.f474921e = (r201.left + r203) + 0.5f;
        goto L107
    L86:
        float r204 = this.R + this.f474917a;
        this.R = r204;
        Rect r205 = this.f474919c;
        float r206 = r205.right;
        float r207 = this.W;
        if (r204 <= (r206 - r207)) goto L107;
        this.R = (r205.left + r207) + 0.5f;
        goto L107
    L90:
        if (this.P != null) goto L104;
        this.f474920d += this.f474917a;
        int r208 = this.f474933p;
        Bitmap r209 = this.f474939u;
        if (r209 == null) goto L95;
        r208 = r209.getHeight();
    L95:
        if (this.M == false) goto L101;
        float r210 = this.f474920d;
        float r211 = r208 + r210;
        Rect r212 = this.f474919c;
        float r213 = r212.bottom;
        float r214 = this.W;
        if (r211 <= (r213 - r214)) goto L99;
    L100:
        this.f474917a = -this.f474917a;
        goto L107
    L99:
        if (r210 >= (r212.top + r214)) goto L107;
    L101:
        float r215 = this.f474920d + r208;
        Rect r216 = this.f474919c;
        float r217 = r216.bottom;
        float r218 = this.W;
        if (r215 <= (r217 - r218)) goto L107;
        this.f474920d = (r216.top + r218) + 0.5f;
        goto L107
    L104:
        float r219 = this.Q + this.f474917a;
        this.Q = r219;
        Rect r220 = this.f474919c;
        float r221 = r220.bottom;
        float r222 = this.W;
        if (r219 <= (r221 - r222)) goto L107;
        this.Q = (r220.top + r222) + 0.5f;
        goto L107
    L27:
        if (this.f474939u == null) goto L29;
        float r223 = this.f474921e;
        r110.drawBitmap(this.f474939u, null, new RectF(r223, (this.f474919c.top + this.W) + this.f474936r, this.f474939u.getWidth() + r223, (this.f474919c.bottom - this.W) - this.f474936r), this.f474922f);
        goto L41
    L29:
        this.f474922f.setStyle(Paint.Style.FILL);
        this.f474922f.setColor(this.f474935q);
        float r224 = this.f474921e;
        Rect r225 = this.f474919c;
        float r226 = r225.top;
        float r227 = this.W;
        float r228 = this.f474936r;
        r110.drawRect(r224, (r226 + r227) + r228, this.f474933p + r224, (r225.bottom - r227) - r228, this.f474922f);
        goto L41
    L31:
        if (this.P == null) goto L37;
        Rect r229 = this.f474919c;
        float r230 = r229.left;
        float r231 = this.W;
        float r232 = this.f474936r;
        RectF r233 = new RectF((r230 + r231) + r232, (r229.top + r231) + 0.5f, (r229.right - r231) - r232, this.Q);
        Rect r234 = new Rect(0, (int) (this.P.getHeight() - r233.height()), this.P.getWidth(), this.P.getHeight());
        if (r234.top >= 0) goto L35;
        r234.top = 0;
        r233.top = r233.bottom - r234.height();
    L35:
        r110.drawBitmap(this.P, r234, r233, this.f474922f);
        goto L41
    L37:
        if (this.f474939u == null) goto L39;
        Rect r235 = this.f474919c;
        float r236 = r235.left;
        float r237 = this.W;
        float r238 = this.f474936r;
        float r1100 = this.f474920d;
        r110.drawBitmap(this.f474939u, null, new RectF((r236 + r237) + r238, r1100, (r235.right - r237) - r238, this.f474939u.getHeight() + r1100), this.f474922f);
        goto L41
    L39:
        this.f474922f.setStyle(Paint.Style.FILL);
        this.f474922f.setColor(this.f474935q);
        Rect r239 = this.f474919c;
        float r240 = r239.left;
        float r241 = this.W;
        float r242 = this.f474936r;
        float r243 = this.f474920d;
        r110.drawRect((r240 + r241) + r242, r243, (r239.right - r241) - r242, r243 + this.f474933p, this.f474922f);
        goto L41
    }

    public void setAnimTime(int r100) {
        this.f474942x = r100;
        b();
    }

    public void setAutoZoom(boolean r100) {
        this.P0 = r100;
    }

    public void setBarCodeTipText(String r100) {
        this.D = r100;
        b();
    }

    public void setBarcodeRectHeight(int r100) {
        this.f474931n = r100;
        b();
    }

    public void setBorderColor(int r100) {
        this.f474941w = r100;
        b();
    }

    public void setBorderSize(int r100) {
        this.f474940v = r100;
        b();
    }

    public void setCornerColor(int r100) {
        this.f474925i = r100;
        b();
    }

    public void setCornerLength(int r100) {
        this.f474926j = r100;
        b();
    }

    public void setCornerSize(int r100) {
        this.f474927k = r100;
        b();
    }

    public void setCustomScanLineDrawable(Drawable r100) {
        this.f474938t = r100;
        b();
    }

    public void setHalfCornerSize(float r100) {
        this.W = r100;
        b();
    }

    public void setIsBarcode(boolean r100) {
        this.B = r100;
        b();
    }

    public void setMaskColor(int r100) {
        this.f474924h = r100;
        b();
    }

    public void setOnlyDecodeScanBoxArea(boolean r100) {
        this.H0 = r100;
        a();
    }

    public void setQRCodeTipText(String r100) {
        this.C = r100;
        b();
    }

    public void setRectHeight(int r100) {
        this.f474930m = r100;
        b();
    }

    public void setRectWidth(int r100) {
        this.f474929l = r100;
        b();
    }

    public void setScanLineBitmap(Bitmap r100) {
        this.f474939u = r100;
        b();
    }

    public void setScanLineColor(int r100) {
        this.f474935q = r100;
        b();
    }

    public void setScanLineMargin(int r100) {
        this.f474936r = r100;
        b();
    }

    public void setScanLineReverse(boolean r100) {
        this.M = r100;
        b();
    }

    public void setScanLineSize(int r100) {
        this.f474933p = r100;
        b();
    }

    public void setShowDefaultGridScanLineDrawable(boolean r100) {
        this.N = r100;
        b();
    }

    public void setShowDefaultScanLineDrawable(boolean r100) {
        this.f474937s = r100;
        b();
    }

    public void setShowLocationPoint(boolean r100) {
        this.L0 = r100;
    }

    public void setShowTipBackground(boolean r100) {
        this.L = r100;
        b();
    }

    public void setShowTipTextAsSingleLine(boolean r100) {
        this.f474916J = r100;
        b();
    }

    public void setTipBackgroundColor(int r100) {
        this.K = r100;
        b();
    }

    public void setTipBackgroundRadius(int r100) {
        this.f474934p0 = r100;
        b();
    }

    public void setTipText(String r100) {
        if (this.B == false) goto L5;
        this.D = r100;
    L6:
        b();
        return;
    L5:
        this.C = r100;
        goto L6
    }

    public void setTipTextBelowRect(boolean r100) {
        this.H = r100;
        b();
    }

    public void setTipTextColor(int r100) {
        this.G = r100;
        this.f474923g.setColor(r100);
        b();
    }

    public void setTipTextMargin(int r100) {
        this.I = r100;
        b();
    }

    public void setTipTextSize(int r100) {
        this.F = r100;
        this.f474923g.setTextSize(r100);
        b();
    }

    public void setTipTextSl(StaticLayout r100) {
        this.f474928k0 = r100;
        b();
    }

    public void setToolbarHeight(int r100) {
        this.A = r100;
        b();
    }

    public void setTopOffset(int r100) {
        this.f474932o = r100;
        b();
    }

    public void setVerticalBias(float r100) {
        this.f474943y = r100;
        b();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
