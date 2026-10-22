package com.bytedance.commerce.base.richtext;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UpdateAppearance;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public final class SpanUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f202871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f202872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f202873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f202874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f202875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f202876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f202877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f202878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f202879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f202880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f202881k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f202882l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f202883m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f202884n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f202885o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f202886p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f202887q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f202888r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f202889s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SerializableSpannableStringBuilder f202890t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f202891u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f202892v;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Align {
    }

    public static class CustomTypefaceSpan extends TypefaceSpan {
        public CustomTypefaceSpan() {
            throw null;
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            a(r100, null);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            a(r100, null);
        }

        public static void a(Paint r100, Typeface r101) {
            Typeface r102 = r100.getTypeface();
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = r103 & (~r101.getStyle());
            if ((r104 & 1) == 0) goto L10;
            r100.setFakeBoldText(true);
        L10:
            if ((r104 & 2) == 0) goto L12;
            r100.setTextSkewX(-0.25f);
        L12:
            r100.getShader();
            r100.setTypeface(r101);
            return;
        L5:
            r103 = r102.getStyle();
            goto L6
        }
    }

    public static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }

        public /* synthetic */ SerializableSpannableStringBuilder(com.bytedance.commerce.base.richtext.c r100) {
            this();
        }
    }

    public static class a implements LeadingMarginSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Path f202894b;

        @Override // android.text.style.LeadingMarginSpan
        public final int getLeadingMargin(boolean r100) {
            return 0;
        }

        public a(int r100) {
            this.f202894b = null;
            this.f202893a = r100;
        }

        @Override // android.text.style.LeadingMarginSpan
        public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r110, int r111, int r112, boolean r113, Layout r114) {
            if (((Spanned) r110).getSpanStart(this) != r111) goto L13;
            Paint.Style r107 = r101.getStyle();
            int r115 = r101.getColor();
            r101.setColor(this.f202893a);
            r101.setStyle(Paint.Style.FILL);
            if (r100.isHardwareAccelerated() == true) goto L7;
            r100.drawCircle(r102 + (r103 * 0), (r104 + r106) / 2.0f, 0, r101);
        L11:
            r101.setColor(r115);
            r101.setStyle(r107);
            return;
        L7:
            if (this.f202894b != null) goto L9;
            Path r116 = new Path();
            this.f202894b = r116;
            r116.addCircle(0.0f, 0.0f, 0, Path.Direction.CW);
        L9:
            r100.save();
            r100.translate(r102 + (r103 * 0), (r104 + r106) / 2.0f);
            r100.drawPath(this.f202894b, r101);
            r100.restore();
            goto L11
        }
    }

    public static abstract class b extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<Drawable> f202896b;

        public final Drawable a() {
            WeakReference<Drawable> r100 = this.f202896b;
            Drawable r101 = null;
            if (r100 == null) goto L5;
            Drawable r102 = r100.get();
        L6:
            if (r102 != null) goto L15;
            c r103 = (c) this;
            Drawable r104 = r103.f202897c;
            if (r104 == null) goto L16;
            r102 = r104;
        L14:
            this.f202896b = new WeakReference(r102);
            goto L15
        L16:
            r101 = ContextCompat.getDrawable(uf4.a.a(), r103.f202898d);     // Catch: Exception -> L12
            r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());     // Catch: Exception -> L12
        L13:
            r102 = r101;
        L15:
            return r102;
        L5:
            r102 = null;
            goto L6
        }

        public b(int r100) {
            this.f202895a = r100;
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Rect r105 = a().getBounds();
            if (r104 == null) goto L15;
            int r106 = r104.bottom - r104.top;
            if (r106 >= r105.height()) goto L15;
            int r107 = this.f202895a;
            if (r107 != 3) goto L10;
            r104.top = r104.top;
            r104.bottom = r105.height() + r104.top;
        L13:
            r104.ascent = r104.top;
            r104.descent = r104.bottom;
            goto L15
        L10:
            if (r107 != 2) goto L12;
            int r108 = r106 / 4;
            r104.top = ((-r105.height()) / 2) - r108;
            r104.bottom = (r105.height() / 2) - r108;
            goto L13
        L12:
            int r109 = -r105.height();
            int r110 = r104.bottom;
            r104.top = r109 + r110;
            r104.bottom = r110;
        L15:
            return r105.right;
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            Drawable r109 = a();
            Rect r110 = r109.getBounds();
            r100.save();
            if (r110.height() >= (r107 - r105)) goto L16;
            int r111 = this.f202895a;
            if (r111 != 3) goto L8;
            float r112 = r105;
        L15:
            r100.translate(r104, r112);
        L17:
            r109.draw(r100);
            r100.restore();
            return;
        L8:
            if (r111 != 2) goto L12;
            int r113 = ((r107 + r105) - r110.height()) / 2;
        L10:
            r112 = r113;
            goto L15
        L12:
            if (r111 != 1) goto L14;
            r112 = r106 - r110.height();
            goto L15
        L14:
            r113 = r107 - r110.height();
            goto L10
        L16:
            r100.translate(r104, r105);
            goto L17
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Drawable f202897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f202898d;

        public c(Bitmap r100, int r101) {
            super(r101);
            BitmapDrawable r102 = new BitmapDrawable(uf4.a.a().getResources(), r100);
            this.f202897c = r102;
            r102.setBounds(0, 0, r102.getIntrinsicWidth(), r102.getIntrinsicHeight());
        }

        public c(int r100, int r101) {
            super(r101);
            this.f202898d = r100;
        }
    }

    public static class d implements LineHeightSpan {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Paint.FontMetricsInt f202899b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202900a;

        public d(int r100) {
            this.f202900a = r100;
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
            Paint.FontMetricsInt r106 = f202899b;
            if (r106 != null) goto L5;
            Paint.FontMetricsInt r107 = new Paint.FontMetricsInt();
            f202899b = r107;
            r107.top = r105.top;
            r107.ascent = r105.ascent;
            r107.descent = r105.descent;
            r107.bottom = r105.bottom;
            r107.leading = r105.leading;
        L6:
            int r108 = this.f202900a;
            int r109 = r105.descent + r104;
            int r110 = r105.ascent;
            int r111 = r108 - ((r109 - r110) - r103);
            if (r111 <= 0) goto L9;
            r105.ascent = r110 - r111;
        L9:
            int r112 = r104 + r105.bottom;
            int r113 = r105.top;
            int r114 = r108 - ((r112 - r113) - r103);
            if (r114 <= 0) goto L13;
            r105.top = r113 - r114;
        L13:
            if (r102 != ((Spanned) r100).getSpanEnd(this)) goto L16;
            f202899b = null;
            return;
        L16:
            return;
        L5:
            r105.top = r106.top;
            r105.ascent = r106.ascent;
            r105.descent = r106.descent;
            r105.bottom = r106.bottom;
            r105.leading = r106.leading;
            goto L6
        }
    }

    public static class e implements LeadingMarginSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202901a;

        @Override // android.text.style.LeadingMarginSpan
        public final int getLeadingMargin(boolean r100) {
            return 0;
        }

        public e(int r100) {
            this.f202901a = r100;
        }

        @Override // android.text.style.LeadingMarginSpan
        public final void drawLeadingMargin(Canvas r100, Paint r110, int r111, int r112, int r113, int r114, int r115, CharSequence r116, int r117, int r118, boolean r119, Layout r210) {
            Paint.Style r101 = r110.getStyle();
            int r102 = r110.getColor();
            r110.setStyle(Paint.Style.FILL);
            r110.setColor(this.f202901a);
            r100.drawRect(r111, r113, r111 + (0 * r112), r115, r110);
            r110.setStyle(r101);
            r110.setColor(r102);
        }
    }

    public static class f extends CharacterStyle implements UpdateAppearance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f202902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f202903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f202904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f202905d;

        public f(float r100) {
            this.f202902a = r100;
            this.f202903b = 0.0f;
            this.f202904c = 0.0f;
            this.f202905d = 0;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            r100.setShadowLayer(this.f202902a, this.f202903b, this.f202904c, this.f202905d);
        }
    }

    public static class g extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f202907b;

        public g(int r100) {
            Paint r101 = new Paint();
            this.f202907b = r101;
            this.f202906a = r100;
            r101.setColor(0);
            r101.setStyle(Paint.Style.FILL);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            return this.f202906a;
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
            r100.drawRect(r111, r112, r111 + this.f202906a, r114, this.f202907b);
        }
    }

    public static class h extends ReplacementSpan {
        public h() {
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            return (int) r100.measureText(r101.subSequence(r102, r103).toString());
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
            CharSequence r109 = r101.subSequence(r102, r103);
            Paint.FontMetricsInt r110 = r108.getFontMetricsInt();
            r100.drawText(r109.toString(), r104, r106 - (((((r110.descent + r106) + r106) + r110.ascent) / 2) - ((r107 + r105) / 2)), r108);
        }
    }

    static {
        System.getProperty("line.separator");
    }

    public final void b() {
        if (this.f202891u == false) goto L5;
        return;
    L5:
        int r100 = this.f202892v;
        if (r100 != 0) goto L9;
        e();
    L19:
        d();
        return;
    L9:
        if (r100 != 1) goto L17;
        int r101 = this.f202890t.length();
        this.f202872b = "<img>";
        e();
        int r102 = this.f202890t.length();
        if (this.f202886p == null) goto L14;
        this.f202890t.setSpan(new c(this.f202886p, this.f202888r), r101, r102, this.f202873c);
        goto L19
    L14:
        if (this.f202887q == (-1)) goto L19;
        this.f202890t.setSpan(new c(this.f202887q, this.f202888r), r101, r102, this.f202873c);
        goto L19
    L17:
        if (r100 != 2) goto L19;
        int r103 = this.f202890t.length();
        this.f202872b = "< >";
        e();
        int r104 = this.f202890t.length();
        this.f202890t.setSpan(new g(this.f202889s), r103, r104, this.f202873c);
        goto L19
    }

    public final void d() {
        this.f202873c = 33;
        this.f202874d = -16777217;
        this.f202875e = -16777217;
        this.f202876f = -1;
        this.f202877g = -16777217;
        this.f202878h = -1;
        this.f202879i = -16777217;
        this.f202880j = -1;
        this.f202881k = -1.0f;
        this.f202882l = -1.0f;
        this.f202883m = -1;
        this.f202884n = -1.0f;
        this.f202885o = -1.0f;
        this.f202886p = null;
        this.f202887q = -1;
        this.f202889s = -1;
    }

    public final void e() {
        if (this.f202872b.length() != 0) goto L5;
        return;
    L5:
        int r100 = this.f202890t.length();
        if (r100 == 0) goto L8;
    L10:
        this.f202890t.append(this.f202872b);
        int r101 = this.f202890t.length();
        if (this.f202883m == (-1)) goto L14;
        this.f202890t.setSpan(new h(), r100, r101, this.f202873c);
    L14:
        if (this.f202874d == (-16777217)) goto L17;
        this.f202890t.setSpan(new ForegroundColorSpan(this.f202874d), r100, r101, this.f202873c);
    L17:
        if (this.f202875e == (-16777217)) goto L20;
        this.f202890t.setSpan(new BackgroundColorSpan(this.f202875e), r100, r101, this.f202873c);
    L20:
        if (this.f202878h == (-1)) goto L22;
        this.f202890t.setSpan(new LeadingMarginSpan.Standard(this.f202878h, 0), r100, r101, this.f202873c);
    L22:
        int r102 = this.f202877g;
        if (r102 == (-16777217)) goto L25;
        this.f202890t.setSpan(new e(r102), r100, r101, this.f202873c);
    L25:
        int r103 = this.f202879i;
        if (r103 == (-16777217)) goto L29;
        this.f202890t.setSpan(new a(r103), r100, r101, this.f202873c);
    L29:
        if (this.f202880j == (-1)) goto L32;
        this.f202890t.setSpan(new AbsoluteSizeSpan(this.f202880j, false), r100, r101, this.f202873c);
    L32:
        if (this.f202881k == (-1.0f)) goto L35;
        this.f202890t.setSpan(new RelativeSizeSpan(this.f202881k), r100, r101, this.f202873c);
    L35:
        if (this.f202882l == (-1.0f)) goto L37;
        this.f202890t.setSpan(new ScaleXSpan(this.f202882l), r100, r101, this.f202873c);
    L37:
        int r104 = this.f202876f;
        if (r104 == (-1)) goto L41;
        this.f202890t.setSpan(new d(r104), r100, r101, this.f202873c);
    L41:
        if (this.f202884n == (-1.0f)) goto L44;
        this.f202890t.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.f202884n, null)), r100, r101, this.f202873c);
    L44:
        if (this.f202885o == (-1.0f)) goto L47;
        this.f202890t.setSpan(new f(this.f202885o), r100, r101, this.f202873c);
        return;
    L47:
        return;
    L8:
        if (this.f202876f == (-1)) goto L10;
        this.f202890t.append(Character.toString(2)).append("\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
        r100 = 2;
        goto L10
    }

    public final void c() {
        b();
        TextView r100 = this.f202871a;
        if (r100 == null) goto L5;
        r100.setText(this.f202890t);
    L5:
        this.f202891u = true;
    }

    public SpanUtils(TextView r100) {
        this.f202890t = new SerializableSpannableStringBuilder(null);
        this.f202872b = "";
        this.f202892v = -1;
        d();
        this.f202871a = r100;
    }

    public final void a(CharSequence r100) {
        b();
        this.f202892v = 0;
        this.f202872b = r100;
    }
}
