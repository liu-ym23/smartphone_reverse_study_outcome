package yx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vx0.a f569375a;

    public a() {
        this.f569375a = new vx0.a();
    }

    @Override // yx0.d
    public final tx0.a a(rx0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        sx0.a r101 = r100.a();
        if ((r101 instanceof sx0.a.e) == true) goto L6;
        return null;
    L6:
        RectF r102 = ((sx0.a.e) r101).f543790a;
        vx0.a r103 = this.f569375a;
        RectF r104 = r100.b();
        int r105 = r100.getContainerWidth();
        int r106 = r100.l();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "playerArea");
        Intrinsics.checkNotNullParameter(r104, GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        float r107 = r102.width() * r104.left;
        float r108 = r102.height() * r104.top;
        float r109 = r102.width() * r104.width();
        float r110 = r102.height() * r104.height();
        float r111 = r102.left + r107;
        float r112 = r102.top + r108;
        float r113 = r109 + r111;
        float r114 = RangesKt.coerceAtLeast(r111, 0.0f);
        float r115 = RangesKt.coerceAtMost(r113, r105);
        RectF r116 = new RectF(r114, RangesKt.coerceAtLeast(r112, 0.0f), r115, RangesKt.coerceAtMost(r110 + r112, r106));
        RectF r117 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        Matrix r118 = new Matrix();
        r118.postTranslate(r102.left - r117.left, r102.top - r117.top);
        r118.postScale(r102.width() / r117.width(), r102.height() / r117.height(), r102.left, r102.top);
        return new tx0.a(r116, r102, r118);
    }
}
