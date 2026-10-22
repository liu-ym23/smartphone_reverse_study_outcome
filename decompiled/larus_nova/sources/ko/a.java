package ko;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f504336i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f504337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f504338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f504339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f504340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f504341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f504342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f504343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CharSequence f504344h;

    /* JADX INFO: renamed from: ko.a$a, reason: collision with other inner class name */
    public static final class C6579a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f504337a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f504342f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f504341e;
    }

    public a(Resources r100) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter("DynamicView", "text");
        this.f504344h = "DynamicView";
        TextPaint r101 = new TextPaint(1);
        r101.setColor(-1);
        r101.setTextAlign(Paint.Align.LEFT);
        r101.setTextSize(TypedValue.applyDimension(1, 11, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics())));
        Unit r102 = Unit.INSTANCE;
        this.f504337a = r101;
        Paint r103 = new Paint(1);
        r103.setColor(-1593857349);
        this.f504338b = r103;
        this.f504339c = 8;
        this.f504340d = 4;
        int r104 = ((int) (r101.measureText("DynamicView", 0, "DynamicView".length()) + 0.5f)) + 16;
        this.f504341e = r104;
        int r105 = (r101.getFontMetricsInt().bottom - r101.getFontMetricsInt().top) + 8;
        this.f504342f = r105;
        this.f504343g = new Rect(0, 0, r104, r105);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        r110.drawRect(this.f504343g, this.f504338b);
        CharSequence r100 = this.f504344h;
        r110.drawText(r100, 0, r100.length(), this.f504339c, (this.f504342f - this.f504337a.getFontMetricsInt().descent) - this.f504340d, this.f504337a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f504337a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f504337a.setColorFilter(r100);
    }
}
