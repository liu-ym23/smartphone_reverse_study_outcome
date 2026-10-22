package f6c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f475736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f475737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f475738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f475739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f475740e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f475737b = null;
        this.f475739d = null;
        ValueAnimator r100 = this.f475738c;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f475738c = null;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator r100 = this.f475738c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isRunning() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (this.f475737b != null) goto L6;
        GradientDrawable r100 = new GradientDrawable();
        int r101 = UIUtils.getColor(this.f475736a, R.color.line_border_card);
        r100.setColors(new int[]{j08.b.b(r101, 0.3f), j08.b.b(r101, 0.6f), j08.b.b(r101, 0.3f)});
        r100.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        this.f475737b = r100;
        invalidateSelf();
    L6:
        ValueAnimator r102 = this.f475738c;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(1000);
        r103.setRepeatCount(-1);
        r103.addUpdateListener(new b(this, r103));
        r103.start();
        this.f475738c = r103;
        Paint r104 = new Paint();
        r104.setColor(j08.b.c(this.f475736a, R.color.line_border_card, 0.3f));
        this.f475739d = r104;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f475736a = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        int r100 = getBounds().width();
        float r101 = r100 * 2;
        float r102 = ((r100 * 3) * this.f475740e) - r101;
        float r103 = r102 + r101;
        Drawable r104 = this.f475737b;
        if (r104 == null) goto L5;
        r104.setBounds((int) r102, getBounds().top, (int) r103, getBounds().bottom);
    L5:
        Drawable r105 = this.f475737b;
        if (r105 == null) goto L9;
        r105.draw(r110);
    L9:
        if (r102 <= 0.0f) goto L14;
        Paint r106 = this.f475739d;
        if (r106 == null) goto L19;
        r110.drawRect(0.0f, 0.0f, r102, getBounds().bottom, r106);
        return;
    L19:
        return;
    L14:
        if (r103 >= r100) goto L21;
        Paint r111 = this.f475739d;
        if (r111 == null) goto L22;
        r110.drawRect(r103, 0.0f, getBounds().right, getBounds().bottom, r111);
        return;
    L22:
        return;
    }
}
