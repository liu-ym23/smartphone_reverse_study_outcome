package um2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f550657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f550658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f550659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f550661e;

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        Paint r101 = new Paint();
        r101.setColor(-1);
        r101.setShadowLayer(13.0f, 0.0f, 6.0f, ColorProtector.parseColor("#40000000"));
        Unit r102 = Unit.INSTANCE;
        this.f550657a = r101;
        Paint r103 = new Paint();
        r103.setColor(ColorProtector.parseColor("#10000000"));
        Resources r104 = Resources.getSystem();
        r103.setStrokeWidth(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.3d, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()))));
        r103.setShadowLayer(13.0f, 1.0f, -1.0f, ColorProtector.parseColor("#40000000"));
        this.f550658b = r103;
        Paint r105 = new Paint();
        r105.setColor(-1);
        this.f550659c = r105;
        this.f550660d = s1.f(10.0f);
        this.f550661e = new RectF();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        this.f550661e.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        int r100 = getWidth() - getPaddingRight();
        int r101 = this.f550660d;
        float r102 = r100 - (r101 * 3);
        float r103 = r101;
        float r104 = (getWidth() - getPaddingRight()) - (this.f550660d * 2);
        int r105 = getWidth() - getPaddingRight();
        int r106 = this.f550660d;
        float r107 = r105 - r106;
        float r108 = r106;
        Path r109 = new Path();
        r109.setFillType(Path.FillType.EVEN_ODD);
        r109.moveTo(r102, r103);
        r109.lineTo(r104, 0.0f);
        r109.lineTo(r107, r108);
        r109.close();
        r110.drawRoundRect(this.f550661e, 16.0f, 16.0f, this.f550657a);
        r110.drawPath(r109, this.f550659c);
        r110.drawLine(r102, r103, r104, 0.0f, this.f550658b);
        r110.drawLine(r104, 0.0f, r107, r108, this.f550658b);
        r110.clipRect(new Rect(0, this.f550660d, getWidth(), getHeight()));
        super.dispatchDraw(r110);
    }
}
