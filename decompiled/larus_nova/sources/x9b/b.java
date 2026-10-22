package x9b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.MetricAffectingSpan;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.CodeBlockThemeData;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends MetricAffectingSpan implements LeadingMarginSpan, LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f562996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f562998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f562999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f563000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f563001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextPaint f563002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f563003h;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r107, "text");
        Intrinsics.checkNotNullParameter(r112, "layout");
    }

    public final void a(TextPaint r100) {
        CodeBlockThemeData r101 = k.f419543b.d(this.f562998c);
        Context r102 = this.f562996a;
        com.ss.android.lark.coremd.ext.c r103 = r101.f419556e;
        KProperty<Object>[] r104 = CodeBlockThemeData.f419554j;
        int r105 = UIUtils.getColor(r102, ((Number) r103.getValue(r101, r104[1])).intValue());
        if (r105 == 0) goto L5;
        r100.setColor(r105);
        this.f563002g.setColor(r105);
    L6:
        int r106 = ((Number) r101.f419559h.getValue(r101, r104[4])).intValue();
        if (r106 <= 0) goto L9;
        float r107 = UIUtils.dp2px(this.f562996a, r106);
        r100.setTextSize(r107);
        this.f563002g.setTextSize(r107);
        return;
    L9:
        this.f563002g.setTextSize(r100.getTextSize());
        return;
    L5:
        this.f563002g.setColor(r100.getColor());
        goto L6
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return UIUtils.dp2px(this.f562996a, 8.0f);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        a(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        a(r100);
    }

    public b(Context r100, String r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "language");
        Intrinsics.checkNotNullParameter(r102, "theme");
        this.f562996a = r100;
        this.f562997b = r101;
        this.f562998c = r102;
        this.f562999d = com.ss.android.lark.coremd.utils.e.f419971b;
        this.f563000e = com.ss.android.lark.coremd.utils.e.f419972c;
        this.f563001f = com.ss.android.lark.coremd.utils.e.f419974e;
        this.f563002g = com.ss.android.lark.coremd.utils.e.f419973d;
        this.f563003h = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r110, CharSequence r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "p");
        Intrinsics.checkNotNullParameter(r111, "text");
        CodeBlockThemeData r106 = k.f419543b.d(this.f562998c);
        float r107 = UIUtils.dp2px(this.f562996a, ((Number) r106.f419560i.getValue(r106, CodeBlockThemeData.f419554j[5])).floatValue());
        this.f563000e.setStyle(Paint.Style.FILL);
        boolean r115 = r111 instanceof Spanned;
        boolean r108 = true;
        if (r115 == true) goto L5;
    L7:
        boolean r116 = false;
    L8:
        if (r115 == true) goto L10;
    L12:
        r108 = false;
    L13:
        int r117 = 0;
    L15:
        if (r117 >= 8) goto L17;
        this.f563003h[r117] = 0.0f;
        r117 = r117 + 1;
        goto L15
    L17:
        float[] r118 = this.f563003h;
        if (r116 == false) goto L22;
        int r119 = 0;
    L20:
        if (r119 >= 4) goto L22;
        r118[r119] = r107;
        r119 = r119 + 1;
    L22:
        if (r108 == false) goto L26;
        int r120 = 0;
    L24:
        if (r120 >= 4) goto L26;
        r118[r120 + 4] = r107;
        r120 = r120 + 1;
    L26:
        float r109 = r102;
        float r121 = r104;
        this.f562999d.set(r109, r121, r103, r110);
        Path r122 = this.f563001f;
        r122.reset();
        r122.addRoundRect(this.f562999d, r118, Path.Direction.CW);
        if (r116 == false) goto L31;
        com.ss.android.lark.coremd.ext.c r123 = r106.f419557f;
        KProperty<Object>[] r124 = CodeBlockThemeData.f419554j;
        if (((Number) r123.getValue(r106, r124[2])).intValue() == 0) goto L35;
        this.f563000e.setColor(UIUtils.getColor(this.f562996a, ((Number) r106.f419557f.getValue(r106, r124[2])).intValue()));
    L35:
        if (r116 == true) goto L39;
        if (r108 == true) goto L39;
        r100.drawRect(this.f562999d, this.f563000e);
    L40:
        if (r116 == false) goto L46;
        r100.drawText(this.f562997b, r109 + getLeadingMargin(false), r121 + Math.abs(this.f563002g.getFontMetrics().top), this.f563002g);
        return;
    L46:
        return;
    L39:
        r100.drawPath(this.f563001f, this.f563000e);
        goto L40
    L31:
        int r125 = UIUtils.getColor(this.f562996a, ((Number) r106.f419558g.getValue(r106, CodeBlockThemeData.f419554j[3])).intValue());
        if (r125 != 0) goto L34;
        r125 = ColorUtils.setAlphaComponent(r125, 25);
    L34:
        this.f563000e.setColor(r125);
        goto L35
    L10:
        if (((Spanned) r111).getSpanEnd(this) > r113) goto L12;
    L5:
        if (((Spanned) r111).getSpanStart(this) < r112) goto L7;
        r116 = true;
        goto L8
    }
}
