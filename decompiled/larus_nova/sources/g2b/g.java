package g2b;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f479767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f479769c;

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (this.f479769c != 255) goto L6;
        return -1;
    L6:
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Drawable r101 = this.f479767a;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        int r102 = Color.argb(this.f479769c, Color.red(this.f479768b), Color.green(this.f479768b), Color.blue(this.f479768b));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.message.message_background_and_padding") == false) goto L8;
        r100.drawColor(r102);
        return;
    L8:
        Rect r103 = getBounds();
        Paint r104 = new Paint();
        r104.setColor(r102);
        Unit r105 = Unit.INSTANCE;
        r100.drawRect(r103, r104);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f479769c = r100;
        invalidateSelf();
    }

    public g(int r100, Drawable r101) {
        this.f479767a = r101;
        int r102 = Color.alpha(r100);
        float r103 = r102 / 255.0f;
        this.f479768b = Color.rgb((int) (Color.red(r100) * r103), (int) (Color.green(r100) * r103), (int) (Color.blue(r100) * r103));
        this.f479769c = 255;
    }
}
