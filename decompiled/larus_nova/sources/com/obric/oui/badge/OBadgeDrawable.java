package com.obric.oui.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import pla.d;

/* JADX INFO: loaded from: classes27.dex */
public final class OBadgeDrawable extends Drawable {
    public static final /* synthetic */ int G = 0;
    public BadgeGravity A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f398790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f398791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f398792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f398793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f398794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f398795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f398796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f398797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f398798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f398799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f398800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextPaint f398801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f398802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f398803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f398804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f398805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f398806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f398807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f398808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f398809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Rect f398810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f398811v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f398812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f398813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f398814y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f398815z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/badge/OBadgeDrawable$BadgeGravity;", "", "TOP_START", "TOP_END", "CENTER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum BadgeGravity extends Enum<BadgeGravity> {
        public static final BadgeGravity CENTER = null;
        public static final BadgeGravity TOP_END = null;
        public static final BadgeGravity TOP_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BadgeGravity[] f398816a = null;

        public static BadgeGravity valueOf(String r100) {
            return (BadgeGravity) r27.a.a(BadgeGravity.class, r100);
        }

        public static BadgeGravity[] values() {
            return (BadgeGravity[]) f398816a.clone();
        }

        static {
            BadgeGravity r100 = new BadgeGravity("TOP_START", 0);
            TOP_START = r100;
            BadgeGravity r101 = new BadgeGravity("TOP_END", 1);
            TOP_END = r101;
            BadgeGravity r102 = new BadgeGravity("CENTER", 2);
            CENTER = r102;
            f398816a = new BadgeGravity[]{r100, r101, r102};
        }

        public BadgeGravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f398817a = null;

        static {
            int[] r100 = new int[BadgeGravity.values().length];
            r100[BadgeGravity.TOP_START.ordinal()] = 1;
            r100[BadgeGravity.TOP_END.ordinal()] = 2;
            r100[BadgeGravity.CENTER.ordinal()] = 3;
            f398817a = r100;
        }
    }

    static {
    }

    public final void a() {
        this.f398808s = true;
        invalidateSelf();
        View r100 = this.f398811v;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        f(r100, this.f398812w);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void g() {
        if (this.f398809t == true) goto L5;
        return;
    L5:
        String r100 = this.f398813x;
        Integer r101 = this.f398814y;
        if (r101 != null) goto L8;
    L10:
        if (r100 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        float r103 = this.f398792c;
        this.f398806q = r103;
        this.f398807r = r103;
    L22:
        float r104 = this.f398806q / 2.0f;
        float r105 = this.f398807r / 2.0f;
        int r106 = MathKt.roundToInt(this.f398804o - r104);
        int r107 = MathKt.roundToInt(this.f398805p - r105);
        int r108 = MathKt.roundToInt(this.f398804o + r104);
        int r109 = MathKt.roundToInt(this.f398805p + r105);
        Rect r110 = this.f398810u;
        if (r110 == null) goto L37;
        float r111 = this.f398793d;
        int r112 = b.f398817a[this.A.ordinal()];
        if (r112 == 1) goto L31;
        if (r112 != 2) goto L34;
        float r113 = r108 - r110.right;
        if (r113 <= r111) goto L34;
        int r114 = MathKt.roundToInt(r113 - r111);
        r106 = r106 - r114;
        r108 = r108 - r114;
    L34:
        float r115 = r110.top - r107;
        if (r115 <= r111) goto L37;
        int r116 = MathKt.roundToInt(r115 - r111);
        r107 = r107 + r116;
        r109 = r109 + r116;
        goto L37
    L31:
        float r117 = r110.left - r106;
        if (r117 <= r111) goto L34;
        int r118 = MathKt.roundToInt(r117 - r111);
        r106 = r106 + r118;
        r108 = r108 + r118;
    L37:
        setBounds(r106, r107, r108, r109);
        this.f398808s = false;
        return;
    L18:
        this.f398801l.getTextBounds(r100, 0, r100.length(), this.f398802m);
        float r119 = this.f398802m.width() + this.f398799j;
        float r120 = this.f398791b;
        float r121 = this.f398794e;
        float r122 = RangesKt.coerceAtLeast(r119 + (2 * r120), r121);
        if (r122 > r121) goto L21;
        float r123 = Math.max(r122, r121);
        this.f398806q = r123;
        this.f398807r = r123;
        goto L22
    L21:
        this.f398806q = r122;
        this.f398807r = r121;
        goto L22
    L12:
        if (r100.length() == 0) goto L15;
        r102 = false;
        goto L16
    L8:
        if (r101.intValue() == 0) goto L10;
        this.f398806q = this.f398797h;
        this.f398807r = this.f398798i;
        goto L22
    }

    public OBadgeDrawable(Context r100) {
        this.f398790a = r100;
        this.f398791b = d.d(r100, 4.0f);
        d.d(r100, 4.0f);
        this.f398792c = d.d(r100, 8.0f);
        this.f398793d = d.d(r100, 5.0f);
        this.f398794e = d.d(r100, 18.0f);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f398795f = d.d(r100, (float) 1.5d);
        this.f398796g = d.e(r100, 5);
        this.f398797h = d.d(r100, 23.0f);
        this.f398798i = d.d(r100, 18.0f);
        this.f398799j = d.d(r100, 1.0f);
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.FILL);
        r101.setColor(ContextCompat.getColor(r100, R.color.oui_red_6));
        this.f398800k = r101;
        TextPaint r102 = new TextPaint(1);
        r102.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r102.setTypeface(Typeface.create(r102.getTypeface(), 500, false));
    L6:
        r102.setColor(ContextCompat.getColor(r100, R.color.white));
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r102.setTextSize(TypedValue.applyDimension(2, 12.0f, d.a(r100.getResources())));
        this.f398801l = r102;
        this.f398802m = new Rect();
        this.f398803n = new RectF();
        this.f398808s = true;
        this.f398815z = 9999;
        this.A = BadgeGravity.TOP_END;
        this.C = ContextCompat.getColor(r100, R.color.oui_red_6);
        this.D = ContextCompat.getColor(r100, R.color.white);
        this.E = true;
        this.F = 12.0f;
        return;
    L5:
        r102.setFakeBoldText(true);
        goto L6
    }

    public final String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L15;
    L13:
        return r100;
    L15:
        Integer r101 = CastIntegerProtector.valueOf(String.valueOf(r100));     // Catch: Exception -> L11
        if (r101.intValue() <= this.f398815z) goto L8;
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L11
        r102.append(this.f398815z);     // Catch: Exception -> L11
        r102.append('+');     // Catch: Exception -> L11
        r100 = r102.toString();     // Catch: Exception -> L11
    L14:
    L8:
        if (r101.intValue() >= 0) goto L14;
        r100 = "";
    L12:
        throw new IllegalArgumentException(Intrinsics.stringPlus("Excepted a int but get ", this.f398813x));
    }

    public final void c(int r100) {
        if (this.C != r100) goto L5;
        return;
    L5:
        this.C = r100;
        this.f398800k.setColor(r100);
        invalidateSelf();
    }

    public final void d(String r100) {
        if (Intrinsics.areEqual(this.f398813x, r100) == false) goto L5;
        return;
    L5:
        String r101 = b(r100);
        this.f398813x = r101;
        if (r101 == null) goto L13;
        Intrinsics.checkNotNull(r101);
        if (r101.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        this.f398814y = null;
        goto L13
    L10:
        r102 = false;
    L13:
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (isVisible() == true) goto L6;
        return;
    L6:
        if (this.f398809t == true) goto L9;
        return;
    L9:
        if (this.f398808s == false) goto L12;
        g();
    L12:
        if (this.f398806q > 0.0f) goto L14;
        return;
    L14:
        if (this.f398807r <= 0.0f) goto L36;
        this.f398803n.set(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom);
        float r101 = this.f398807r / 2.0f;
        r100.drawRoundRect(this.f398803n, r101, r101, this.f398800k);
        String r102 = this.f398813x;
        if (r102 != null) goto L19;
    L22:
        boolean r103 = true;
    L23:
        if (r103 == true) goto L25;
        r100.drawText(r102, this.f398803n.centerX(), this.f398803n.centerY() - ((this.f398801l.ascent() + this.f398801l.descent()) / 2.0f), this.f398801l);
    L25:
        Integer r104 = this.f398814y;
        if (r104 == null) goto L34;
        if (r104 != null) goto L30;
    L31:
        float r105 = this.f398803n.centerX();
        float r106 = this.f398803n.centerY();
        float r107 = this.f398795f;
        Paint r108 = new Paint();
        Integer r109 = this.f398814y;
        Intrinsics.checkNotNull(r109);
        r108.setColor(r109.intValue());
        r108.setAntiAlias(true);
        r100.drawCircle(r105, r106, r107, r108);
        r100.drawCircle(r105 - this.f398796g, r106, r107, r108);
        r100.drawCircle(r105 + this.f398796g, r106, r107, r108);
        return;
    L30:
        if (r104.intValue() != 0) goto L31;
        return;
    L34:
        return;
    L19:
        if (r102.length() == 0) goto L22;
        r103 = false;
        goto L23
    }

    public final void e(boolean r100) {
        if (this.E != r100) goto L5;
        return;
    L5:
        this.E = r100;
        Resources r101 = this.f398790a.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        TextPaint r103 = this.f398801l;
        if (this.E == false) goto L8;
        float r104 = TypedValue.applyDimension(2, this.F, r102);
    L9:
        r103.setTextSize(r104);
        a();
        return;
    L8:
        r104 = TypedValue.applyDimension(1, this.F, r102);
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f398800k.setAlpha(r100);
        this.f398801l.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f398800k.setColorFilter(r100);
        this.f398801l.setColorFilter(r100);
        invalidateSelf();
    }

    public final void f(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        this.f398811v = r100;
        this.f398812w = r101;
        Rect r102 = new Rect();
        if (r101 == null) goto L5;
        int[] r103 = new int[2];
        int[] r104 = new int[2];
        r100.getLocationInWindow(r103);
        r101.getLocationInWindow(r104);
        int r105 = r103[0] - r104[0];
        int r106 = r103[1] - r104[1];
        r102.set(r105, r106, r100.getWidth() + r105, r100.getHeight() + r106);
    L6:
        this.f398810u = new Rect(r102);
        if (ViewCompat.getLayoutDirection(r100) != 1) goto L9;
        boolean r107 = true;
    L10:
        BadgeGravity r108 = this.A;
        int[] r109 = b.f398817a;
        int r110 = r109[r108.ordinal()];
        if (r110 == 1) goto L20;
        if (r110 == 2) goto L17;
        if (r110 != 3) goto L16;
        int r111 = r102.right;
        int r112 = r111 - ((r111 - r102.left) / 2);
    L24:
        if (r109[this.A.ordinal()] != 3) goto L26;
        int r113 = r102.bottom;
        int r114 = r113 - ((r113 - r102.top) / 2);
    L27:
        this.f398804o = r112 + 0;
        this.f398805p = r114 + this.B;
        this.f398809t = true;
        this.f398808s = true;
        g();
        return;
    L26:
        r114 = r102.top;
        goto L27
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        if (r107 == false) goto L19;
        r112 = r102.left;
        goto L24
    L19:
        r112 = r102.right;
        goto L24
    L20:
        if (r107 == false) goto L22;
        r112 = r102.right;
        goto L24
    L22:
        r112 = r102.left;
        goto L24
    L9:
        r107 = false;
        goto L10
    L5:
        r100.getDrawingRect(r102);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        if (r102 == false) goto L5;
        invalidateSelf();
    L5:
        return r102;
    }
}
