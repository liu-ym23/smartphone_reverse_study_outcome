package ej4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import dj4.g;
import dj4.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final Matrix a(Rect r100, int r101, int r102, Rect r103, bj4.d r110) {
        Intrinsics.checkNotNullParameter(r100, "fromRect");
        Intrinsics.checkNotNullParameter(r110, "listItemScaleType");
        boolean r104 = false;
        if (r103 == null) goto L5;
        int r105 = r103.width();
    L6:
        if (r103 == null) goto L8;
        int r106 = r103.height();
    L9:
        boolean r107 = true;
        if (r101 == 0) goto L14;
        if (r102 == 0) goto L14;
        boolean r108 = false;
    L15:
        if (r105 == 0) goto L19;
        if (r106 == 0) goto L19;
        boolean r109 = false;
    L20:
        if (r108 == true) goto L27;
        if (r109 == true) goto L27;
        if ((r106 / r105) < (r102 / r101)) goto L26;
        r104 = true;
    L26:
        r107 = r104;
    L27:
        if (r107 == false) goto L29;
        float r111 = r102;
        float r112 = r106;
    L30:
        float r113 = r111 / r112;
        RectF r114 = new RectF(0.0f, 0.0f, r105, r106);
        Matrix r115 = new Matrix();
        r115.setScale(r113, r113, r105 / 2, r106 / 2);
        r115.postTranslate((r101 - r105) / 2, (r102 - r106) / 2);
        r115.mapRect(r114, r114);
        return r110.a(r114, r100);
    L29:
        r111 = r101;
        r112 = r105;
    L19:
        r109 = true;
    L14:
        r108 = true;
        goto L15
    L8:
        r106 = 0;
        goto L9
    L5:
        r105 = 0;
        goto L6
    }

    public static final AnimatorSet b(Matrix r100, Matrix r101, Rect r110, cj4.a r111, Function1<? super Matrix, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "startMatrix");
        Intrinsics.checkNotNullParameter(r101, "endMatrix");
        Intrinsics.checkNotNullParameter(r111, "animationConfiguration");
        Intrinsics.checkNotNullParameter(r112, "callback");
        float[] r102 = new float[9];
        r100.getValues(r102);
        float[] r103 = new float[9];
        r101.getValues(r103);
        h r104 = new h(r110, r102, r112);
        ObjectAnimator r113 = ObjectAnimator.ofPropertyValuesHolder(r104, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(g.f468916a, new bj4.c(new float[9]), new float[][]{r102, r103})});
        r113.setDuration(r111.f23966f);
        r113.setInterpolator(r111.f23962b);
        cj4.a.C0451a r105 = r111.f23969i;
        if (r110 == null) goto L5;
        RectF r106 = new RectF(r110);
    L6:
        RectF r107 = new RectF(r106);
        RectF r114 = new RectF();
        RectF r108 = new RectF();
        r100.mapRect(r114, r107);
        r101.mapRect(r108, r107);
        float r109 = r114.centerX();
        float r115 = r114.centerY();
        float r116 = r108.centerX();
        float r117 = r108.centerY();
        r105.getClass();
        Path r118 = new Path();
        r118.moveTo(r109, r115);
        r118.lineTo(r116, r117);
        int r119 = d.f472873a;
        ObjectAnimator r120 = ObjectAnimator.ofPropertyValuesHolder(r104, new PropertyValuesHolder[]{PropertyValuesHolder.ofObject(g.f468917b, null, r118)});
        r120.setDuration(r111.f23965e);
        r120.setInterpolator(r111.f23961a);
        AnimatorSet r121 = new AnimatorSet();
        r121.playTogether(new Animator[]{r113, r120});
        return r121;
    L5:
        r106 = null;
        goto L6
    }
}
