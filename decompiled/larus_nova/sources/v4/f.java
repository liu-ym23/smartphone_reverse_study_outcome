package v4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Deprecated;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends Drawable implements com.bytedance.ai.debug.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f553008h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f553009i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f553010j = 0.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f553011k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f553012l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f553013m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f553014n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f553015o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f553016p = 0.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f553017q = 0.0f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f553018r = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAISDKDebugService.Gravity f553019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f553020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f553021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f553022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f553023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f553024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Float f553025g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f553026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f553027b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f553026a, r101.f553026a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f553027b, r101.f553027b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f553026a) * 31) + Float.floatToIntBits(this.f553027b);
        }

        public final String toString() {
            return "BadgeSize(width=" + this.f553026a + ", height=" + this.f553027b + ')';
        }

        public a(float r100, float r101) {
            this.f553026a = r100;
            this.f553027b = r101;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f553028a = null;

        static {
            int[] r100 = new int[IAISDKDebugService.Gravity.values().length];
            r100[IAISDKDebugService.Gravity.TOP_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[IAISDKDebugService.Gravity.TOP_RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[IAISDKDebugService.Gravity.BOTTOM_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[IAISDKDebugService.Gravity.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[IAISDKDebugService.Gravity.BOTTOM_CENTER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f553028a = r100;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    static {
        f553008h = ColorProtector.parseColor("#CC53493D");
        f553009i = -1;
        Float r100 = Float.valueOf(12.0f);
        f553010j = n2.a.a(r100);
        f553011k = n2.a.a(Float.valueOf(7.0f));
        Float r101 = Float.valueOf(10.0f);
        f553012l = n2.a.a(r101);
        f553013m = n2.a.a(r100);
        f553014n = n2.a.a(r100);
        f553015o = n2.a.a(r100);
        f553016p = n2.a.a(r100);
        f553017q = n2.a.a(r100);
        f553018r = n2.a.a(r101);
    }

    public f() {
        this(IAISDKDebugService.Gravity.BOTTOM_LEFT);
    }

    public final a d() {
        float r100 = this.f553020b.measureText(this.f553023e);
        Paint.FontMetrics r101 = this.f553020b.getFontMetrics();
        float r102 = r101.bottom - r101.top;
        return new a((f553010j * 2.0f) + r100, r102 + (f553011k * 2.0f));
    }

    public f(IAISDKDebugService.Gravity r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f553019a = r100;
        TextPaint r101 = new TextPaint(1);
        r101.setColor(f553009i);
        r101.setTextSize(n2.a.a(Float.valueOf(14.0f)));
        r101.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.f553020b = r101;
        Paint r102 = new Paint(1);
        r102.setColor(f553008h);
        r102.setStyle(Paint.Style.FILL);
        this.f553021c = r102;
        this.f553022d = new RectF();
        this.f553023e = "";
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (StringsKt.isBlank(this.f553023e) == false) goto L5;
        return;
    L5:
        RectF r101 = c(getBounds().width(), getBounds().height());
        if (r101.width() > 0.0f) goto L8;
        return;
    L8:
        if (r101.height() <= 0.0f) goto L13;
        float r102 = f553012l;
        r100.drawRoundRect(r101, r102, r102, this.f553021c);
        r100.drawText(this.f553023e, r101.left + f553010j, r101.centerY() - ((this.f553020b.descent() + this.f553020b.ascent()) / 2.0f), this.f553020b);
        return;
    }

    @Override // com.bytedance.ai.debug.e
    public final RectF a(int r100, int r101) {
        return new RectF(c(r100, r101));
    }

    public final RectF c(float r110, float r111) {
        if (r110 > 0.0f) goto L5;
    L39:
        this.f553022d.setEmpty();
        return this.f553022d;
    L5:
        if (r111 <= 0.0f) goto L39;
        if (StringsKt.isBlank(this.f553023e) == true) goto L39;
        a r100 = d();
        float r101 = RangesKt.coerceAtLeast(r110 - r100.f553026a, 0.0f);
        float r102 = RangesKt.coerceAtLeast(r111 - r100.f553027b, 0.0f);
        IAISDKDebugService.Gravity r103 = this.f553019a;
        int[] r104 = c.f553028a;
        int r105 = r104[r103.ordinal()];
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L18;
        if (r105 == 4) goto L18;
        if (r105 == 5) goto L18;
        throw new NoWhenBranchMatchedException();
    L18:
        float r106 = RangesKt.coerceAtLeast((r110 - f553014n) - r100.f553026a, 0.0f);
    L20:
        int r107 = r104[this.f553019a.ordinal()];
        if (r107 == 1) goto L30;
        if (r107 == 2) goto L30;
        if (r107 == 3) goto L29;
        if (r107 == 4) goto L29;
        if (r107 == 5) goto L29;
        throw new NoWhenBranchMatchedException();
    L29:
        float r108 = RangesKt.coerceAtLeast((r111 - f553016p) - r100.f553027b, 0.0f);
    L31:
        Float r109 = this.f553024f;
        if (r109 == null) goto L34;
        r106 = r109.floatValue();
    L34:
        float r112 = RangesKt.coerceIn(r106, 0.0f, r101);
        Float r113 = this.f553025g;
        if (r113 == null) goto L37;
        r108 = r113.floatValue();
    L37:
        float r114 = RangesKt.coerceIn(r108, 0.0f, r102);
        this.f553022d.set(r112, r114, RangesKt.coerceAtMost(r100.f553026a + r112, r110), RangesKt.coerceAtMost(r100.f553027b + r114, r111));
        return this.f553022d;
    L30:
        r108 = RangesKt.coerceAtLeast(f553015o, 0.0f);
        goto L31
    L19:
        r106 = RangesKt.coerceAtLeast(f553013m, 0.0f);
        goto L20
    }

    @Override // com.bytedance.ai.debug.e
    public final void b(int r100, int r101, float r102, float r103) {
        if (r100 <= 0) goto L9;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(this.f553023e) == true) goto L11;
        a r104 = d();
        float r105 = RangesKt.coerceAtLeast(r100 - r104.f553026a, 0.0f);
        float r106 = RangesKt.coerceAtLeast(r101 - r104.f553027b, 0.0f);
        this.f553024f = Float.valueOf(RangesKt.coerceIn(r102, 0.0f, r105));
        this.f553025g = Float.valueOf(RangesKt.coerceIn(r103, 0.0f, r106));
        invalidateSelf();
        return;
    L11:
        return;
    }
}
