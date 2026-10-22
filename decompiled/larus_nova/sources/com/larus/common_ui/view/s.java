package com.larus.common_ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s extends l19.l {
    public final Lazy S;
    public Function1<? super Matrix, Unit> T;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final boolean n() {
        k19.e r100 = this.f327668a;
        if (Math.abs(this.f327678k.left - this.f327676i.left) >= 0.001f) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L14;
        if (Math.abs(this.f327678k.right - this.f327676i.right) >= 0.001f) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L15:
        int r103 = r100.f501413l;
        if (r103 == 3) goto L24;
        if (r103 == 1) goto L24;
        if (r103 != (-1)) goto L26;
        if (r100.f501403b.f501392a <= 1) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L26;
    L22:
        r104 = false;
    L26:
        if (Math.abs(this.f327678k.top - this.f327676i.top) >= 0.001f) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == false) goto L36;
        if (Math.abs(this.f327678k.bottom - this.f327676i.bottom) >= 0.001f) goto L33;
        boolean r106 = true;
    L34:
        if (r106 == false) goto L36;
    L37:
        int r107 = r100.f501413l;
        if (r107 != 2) goto L40;
        return true;
    L40:
        if (r107 == 4) goto L51;
        if (r107 == (-1)) goto L43;
    L48:
        return false;
    L43:
        if (r100.f501403b.f501392a <= 1) goto L45;
        boolean r108 = true;
    L46:
        if (r108 == true) goto L48;
        return true;
    L45:
        r108 = false;
        goto L46
    L51:
        return true;
    L33:
        r106 = false;
    L36:
        if (m() == false) goto L48;
    L28:
        r105 = false;
    L24:
        return true;
    L11:
        r102 = false;
    L14:
        if (m() == false) goto L26;
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void x() {
        super.x();
        this.T.invoke(this.f327679l);
    }

    @Override // com.larus.common_ui.photoviewer.a
    public final void h(RectF r110) {
        Intrinsics.checkNotNullParameter(r110, "viewBounds");
        super.h(r110);
        if (((Boolean) this.S.getValue()).booleanValue() == false) goto L39;
        RectF r111 = this.f327677j;
        RectF r100 = this.f327676i;
        if (r111.width() > 0.0f) goto L8;
        return;
    L8:
        if (r111.height() > 0.0f) goto L10;
        return;
    L10:
        if (r100.width() > 0.0f) goto L12;
        return;
    L12:
        if (r100.height() <= 0.0f) goto L40;
        float r101 = r111.height() / r111.width();
        float r102 = r100.height() / r100.width();
        if (r101 <= r102) goto L17;
        float r103 = r100.width() / r111.width();
        FLogger.f375446a.i("CustomZoomableControllerImpl", "[" + hashCode() + "] apply scale: " + r103 + ", imageRatio: " + r101 + " > viewRatio: " + r102);
        g(3.0f * r103);
        if (r103 >= 1.0f) goto L29;
    L32:
        PointF r104 = a(new PointF(r111.centerX(), r111.centerY()));
        Matrix r105 = new Matrix();
        r105.setScale(r103, r103, r104.x, r104.y);
        RectF r106 = new RectF(r111);
        r105.mapRect(r106);
        r105.postTranslate(0.0f, r100.top - r106.top);
        p(r105);
        v(r105);
        return;
    L29:
        if (r103 > this.f327674g) goto L32;
        this.f327673f = r103;
        goto L32
    L17:
        if (this.f327673f != 1.0f) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == true) goto L37;
        FLogger.f375446a.i("CustomZoomableControllerImpl", "[" + hashCode() + "] reset scale");
        if (1.0f > this.f327674g) goto L25;
        this.f327673f = 1.0f;
    L25:
        g(3.0f);
        return;
    L37:
        return;
    L19:
        r112 = false;
        goto L20
    L40:
        return;
    }

    public s(k19.e r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.S = LazyKt.lazy(new q());
        this.T = new r();
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void y(float r100, PointF r101, Runnable r102, ValueAnimator.AnimatorUpdateListener r103) {
        super.y(r100, r101, null, null);
        if (this.f327671d == true) goto L5;
        return;
    L5:
        Matrix r104 = new Matrix();
        j(r104, r100, r101);
        this.T.invoke(r104);
    }
}
