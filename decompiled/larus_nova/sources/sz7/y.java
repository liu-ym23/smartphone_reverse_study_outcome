package sz7;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import com.larksuite.component.ui.avatar.BorderProperty;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class y extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f544040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BorderProperty f544041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f544042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f544043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f544044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f544045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f544046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f544047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f544048i;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getBitmap().isRecycled() == true) goto L36;
        this.f544042c.set(getBounds());
        float r101 = (this.f544047h * 1.0f) / 2;
        this.f544044e.set(this.f544042c);
        this.f544044e.inset(r101, r101);
        this.f544043d.set(this.f544042c);
        RectF r102 = this.f544043d;
        float r103 = this.f544047h;
        r102.inset(r103, r103);
        BitmapDrawable r104 = this.f544040a;
        if ((r104 instanceof BitmapDrawable) == false) goto L34;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r105 = r104.getBitmap();
        if (r105 != null) goto L10;
    L33:
        Log.i("RounderCornersBitmapDrawable", "bitmap recycled");
        goto L34
    L10:
        if (r105.isRecycled() == true) goto L33;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        Object r106 = com.ss.android.lark.image.utils.e.a(this.f544040a, "mBlendModeFilter");
        if (r106 != null) goto L17;
    L29:
        boolean r107 = false;
    L30:
        this.f544046g.setAntiAlias(true);
        int r108 = r100.getSaveCount();
        r100.save();
        this.f544045f.reset();
        Path r109 = this.f544045f;
        RectF r110 = this.f544043d;
        float r111 = this.f544048i;
        r109.addRoundRect(r110, r111, r111, Path.Direction.CW);
        r100.clipPath(this.f544045f);
        r100.drawBitmap(r105, null, this.f544042c, this.f544040a.getPaint());
        r100.restoreToCount(r108);
        if (r107 == false) goto L34;
        getPaint().setColorFilter(null);
        goto L34
    L17:
        if ((r106 instanceof BlendModeColorFilter) == false) goto L29;
        if (this.f544040a.getPaint().getColorFilter() != null) goto L29;
        this.f544040a.getPaint().setColorFilter((ColorFilter) r106);
    L28:
        r107 = true;
        goto L30
    L21:
        Object r112 = com.ss.android.lark.image.utils.e.a(this.f544040a, "mTintFilter");
        if (r112 == null) goto L29;
        if ((r112 instanceof PorterDuffColorFilter) == false) goto L29;
        if (this.f544040a.getPaint().getColorFilter() != null) goto L29;
        this.f544040a.getPaint().setColorFilter((ColorFilter) r112);
    L34:
        this.f544046g.setAntiAlias(true);
        this.f544046g.setStyle(Paint.Style.STROKE);
        this.f544046g.setColor(this.f544041b.getBorderColor());
        this.f544046g.setStrokeWidth(this.f544041b.getBorderWidthPx());
        this.f544045f.reset();
        Path r113 = this.f544045f;
        RectF r114 = this.f544044e;
        float r115 = this.f544048i;
        r113.addRoundRect(r114, r115, r115, Path.Direction.CW);
        r100.drawPath(this.f544045f, this.f544046g);
        return;
    }

    public y(Resources r100, BitmapDrawable r101, BorderProperty r102) {
        Intrinsics.checkNotNullParameter(r100, "res");
        Intrinsics.checkNotNullParameter(r101, "srcDrawable");
        Intrinsics.checkNotNullParameter(r102, "borderProperty");
        super(r100, r101.getBitmap());
        this.f544040a = r101;
        this.f544041b = r102;
        this.f544042c = new RectF();
        this.f544043d = new RectF();
        this.f544044e = new RectF();
        this.f544045f = new Path();
        this.f544046g = new Paint();
        this.f544047h = r102.getBorderWidthPx();
        this.f544048i = r102.getBorderRadiusPx();
    }
}
