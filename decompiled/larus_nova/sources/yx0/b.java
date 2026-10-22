package yx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wx0.b f569376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wx0.a f569377b;

    public b() {
        this.f569376a = new wx0.b();
        this.f569377b = new wx0.a();
    }

    @Override // yx0.d
    public final tx0.a a(rx0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "client");
        Object r100 = r110.a();
        if ((r100 instanceof sx0.b) == true) goto L5;
        return null;
    L5:
        sx0.b r101 = (sx0.b) r100;
        wx0.b r102 = this.f569376a;
        int r103 = r110.getContainerWidth();
        int r104 = r110.l();
        r102.f561755a = Float.valueOf(r103);
        r102.f561756b = Float.valueOf(r104);
        wx0.b r105 = this.f569376a;
        sx0.a r106 = r110.a();
        float r107 = c.a(r110, r101.a());
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, com.heytap.mcssdk.constant.b.f276366p);
        if ((r106 instanceof sx0.a.C7666a) == false) goto L9;
        sx0.a.C7666a r108 = (sx0.a.C7666a) r106;
        RectF r109 = r105.a(r108.f543784b, r108.f543785c, r107);
    L30:
        if (r109 != null) goto L32;
        return null;
    L32:
        wx0.a r111 = this.f569377b;
        sx0.a r112 = r110.a();
        Intrinsics.checkNotNullParameter(r110, "$this$containerRatioWH");
        float r113 = r110.getContainerWidth() / r110.l();
        float r114 = c.a(r110, r101.a());
        r101.a();
        RectF r115 = r110.b();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, com.heytap.mcssdk.constant.b.f276366p);
        Intrinsics.checkNotNullParameter(r115, GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        RectF r116 = r111.f561754a;
        if ((r112 instanceof sx0.a.C7666a) == false) goto L36;
        RectF r117 = wx0.a.a(((sx0.a.C7666a) r112).f543785c, r113, r114, r115);
    L48:
        r116.set(r117);
        wx0.a r118 = this.f569377b;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r109, "visibleArea");
        RectF r119 = r118.f561754a;
        float r120 = r109.width() / r119.width();
        float r121 = r109.height() / r119.height();
        float r122 = r119.left * r120;
        float r123 = r119.top * r121;
        float r124 = r109.left - r122;
        float r125 = r109.top - r123;
        RectF r126 = new RectF(r124, r125, r120 + r124, r121 + r125);
        RectF r127 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        Matrix r128 = new Matrix();
        r128.postTranslate(r126.left - r127.left, r126.top - r127.top);
        r128.postScale(r126.width() / r127.width(), r126.height() / r127.height(), r126.left, r126.top);
        return new tx0.a(r109, r126, r128);
    L36:
        if ((r112 instanceof sx0.a.b) == false) goto L39;
        r117 = new RectF(r115);
        goto L48
    L39:
        if ((r112 instanceof sx0.a.c) == false) goto L42;
        r117 = wx0.a.a(1.0f, r113, r114, r115);
        goto L48
    L42:
        if ((r112 instanceof sx0.a.d) == false) goto L45;
        r117 = wx0.a.b(r113, r114, r115);
        goto L48
    L45:
        if ((r112 instanceof sx0.a.f) == false) goto L47;
        r117 = wx0.a.b(r113, r114, r115);
        goto L48
    L47:
        r117 = new RectF();
        goto L48
    L9:
        if ((r106 instanceof sx0.a.b) == false) goto L14;
        int r129 = ((sx0.a.b) r106).f543787b;
        Float r130 = r105.f561755a;
        if (r130 == null) goto L29;
        float r131 = r130.floatValue() * 1.0f;
        float r132 = r129;
        r109 = new RectF(0.0f, r132, r131, (r131 / r107) + r132);
    L29:
        r109 = null;
        goto L30
    L14:
        if ((r106 instanceof sx0.a.c) == false) goto L17;
        r109 = r105.a(0, 1.0f, r107);
        goto L30
    L17:
        if ((r106 instanceof sx0.a.d) == false) goto L20;
        r109 = r105.b(r107);
        goto L30
    L20:
        if ((r106 instanceof sx0.a.f) == false) goto L29;
        Float r133 = r105.f561755a;
        if (r133 == null) goto L29;
        float r134 = r133.floatValue();
        Float r135 = r105.f561756b;
        if (r135 == null) goto L29;
        float r136 = r135.floatValue();
        float r137 = r134 * 1.0f;
        float r138 = r137 / r107;
        float r139 = (r136 - r138) / 2;
        if (r138 >= r136) goto L28;
        r109 = r105.b(r107);
        goto L30
    L28:
        r109 = new RectF(0.0f, r139, r137, r138 + r139);
        goto L30
    }
}
