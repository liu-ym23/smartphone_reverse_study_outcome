package oh2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f523257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f523258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f523259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f523260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f523261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f523262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f523263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f523264h;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        RectF r101 = this.f523258b;
        float r102 = this.f523261e;
        r100.drawRoundRect(r101, r102, r102, this.f523257a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        float r100 = (this.f523262f / 2) - UtilityKotlinExtentionsKt.c(Double.valueOf(0.01d));
        this.f523258b.set(r110.left + r100, r110.top + r100, r110.right - r100, r110.bottom - r100);
        int[] r101 = this.f523263g;
        int r102 = r101.length;
        float[] r103 = this.f523264h;
        if (r102 == r103.length) goto L5;
    L11:
        Pair r104 = TuplesKt.to(this.f523259c, this.f523260d);
    L12:
        this.f523257a.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r110.height(), (int[]) r104.component1(), (float[]) r104.component2(), Shader.TileMode.CLAMP));
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r105 = true;
    L9:
        if ((!r105) == false) goto L11;
        r104 = TuplesKt.to(r101, r103);
        goto L12
    L7:
        r105 = false;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f523257a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f523257a.setColorFilter(r100);
    }

    public f(float r100, float r101, int[] r102, float[] r103) {
        Intrinsics.checkNotNullParameter(r102, "borderColors");
        Intrinsics.checkNotNullParameter(r103, "borderPositions");
        this.f523261e = r100;
        this.f523262f = r101;
        this.f523263g = r102;
        this.f523264h = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r101);
        Unit r105 = Unit.INSTANCE;
        this.f523257a = r104;
        this.f523258b = new RectF();
        this.f523259c = new int[]{ColorProtector.parseColor("#33FFFFFF"), ColorProtector.parseColor("#1AAD7E8B"), ColorProtector.parseColor("#4DF42D51")};
        this.f523260d = new float[]{0.0f, 0.52f, 1.0f};
    }
}
