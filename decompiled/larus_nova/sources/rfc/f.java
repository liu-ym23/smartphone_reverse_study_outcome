package rfc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.graffiti.GraffitiView;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements pfc.g.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f537660a;

    public f(GraffitiView r100) {
        this.f537660a = r100;
    }

    @Override // pfc.g.e
    public final void a(MotionEvent r100) {
        sfc.a.f541747a.getClass();
        boolean r101 = true;
        sfc.a.f541748b = true;
        com.ss.android.photoeditor.graffiti.b r102 = this.f537660a.f449209j;
        r102.getClass();
        int r103 = r100.getAction();
        if (r103 == 0) goto L41;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L11;
        if (r103 == 3) goto L24;
        return;
    L11:
        if (r102.f449234q == false) goto L13;
    L14:
        r102.f449234q = true;
        r102.f449218a = true;
        if (r102.f449222e == 0.0f) goto L17;
    L19:
        float r104 = r100.getX();
        float r105 = r100.getY();
        r102.f449223f.lineTo(r104, r105);
        Canvas r106 = r102.f449228k;
        if (r106 == null) goto L22;
        r106.drawColor(0, PorterDuff.Mode.CLEAR);
        r102.f449228k.drawPath(r102.f449223f, r102.f449230m);
    L22:
        r102.a();
        com.ss.android.photoeditor.graffiti.b.c r107 = r102.f449219b;
        com.ss.android.photoeditor.graffiti.d r108 = (com.ss.android.photoeditor.graffiti.d) r107;
        r108.a(r102.f449226i);
        return;
    L17:
        if (r102.f449221d != 0.0f) goto L19;
        r102.f449221d = r100.getX();
        r102.f449222e = r100.getY();
        Path r109 = new Path();
        r102.f449223f = r109;
        r109.moveTo(r102.f449221d, r102.f449222e);
        goto L19
    L13:
        if (pfc.a.a(r102.f449233p, r102.f449221d, r102.f449222e, r100.getX(), r100.getY()) == true) goto L14;
        return;
    L24:
        if (r102.f449218a == false) goto L40;
        Log.i("GraffitiDrawHelper", "record()");
        com.ss.android.photoeditor.graffiti.b.a r110 = new com.ss.android.photoeditor.graffiti.b.a(r102.f449223f, r102.f449230m, new com.ss.android.photoeditor.graffiti.a(r102));
        pfc.f.i().a(r110);
        Bitmap r111 = r102.f449224g;
        if (r111 != null) goto L28;
    L30:
        r101 = false;
    L31:
        if (r101 == true) goto L33;
        Log.e("GraffitiDrawHelper", "drawTouchBmpToResultBmp, bitmap is invalid");
    L39:
        com.ss.android.photoeditor.graffiti.b.c r112 = r102.f449219b;
        com.ss.android.photoeditor.graffiti.d r113 = (com.ss.android.photoeditor.graffiti.d) r112;
        r113.a(r102.f449225h);
        goto L40
    L33:
        RectF r114 = r102.b();
        RectF r115 = ((com.ss.android.photoeditor.graffiti.e) r102.f449220c).f449244a.getLocation();
        RectF r116 = r102.c();
        Matrix r117 = new Matrix();
        float r118 = r114.width() / r115.width();
        float r119 = r116.left - (r115.left * r118);
        float r120 = r116.top - (r115.top * r118);
        r117.postScale(r118, r118);
        r117.postTranslate(r119, r120);
        Canvas r121 = r102.f449227j;
        if (r121 == null) goto L36;
        r121.drawBitmap(r102.f449224g, r117, null);
    L36:
        Canvas r122 = r102.f449228k;
        if (r122 == null) goto L39;
        r122.drawColor(0, PorterDuff.Mode.CLEAR);
        goto L39
    L28:
        if (r111.isRecycled() == true) goto L30;
    L40:
        r102.f449218a = false;
        return;
    L41:
        r102.f449218a = false;
        r102.f449234q = false;
        r102.f449221d = r100.getX();
        r102.f449222e = r100.getY();
        Path r123 = new Path();
        r102.f449223f = r123;
        r123.moveTo(r102.f449221d, r102.f449222e);
    }
}
