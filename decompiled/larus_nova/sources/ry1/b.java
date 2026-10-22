package ry1;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f539892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RegionId f539893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f539894c;

    @Override // ry1.c.a
    public final Rect a() {
        return this.f539892a;
    }

    public final Rect b(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        Rect r101 = new Rect(r100);
        Rect r102 = this.f539892a;
        int r103 = Math.max(0, r102.left - r101.left);
        int r104 = Math.min(0, r102.right - r101.right);
        r101.offset(r103 + r104, Math.max(0, r102.top - r101.top) + Math.min(0, r102.bottom - r101.bottom));
        return r101;
    }

    public final j80.d c(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "objectRect");
        float r101 = this.f539892a.width() - r100.width();
        float r102 = this.f539892a.height() - r100.height();
        float r103 = 0.0f;
        if (r101 != 0.0f) goto L5;
        float r104 = 0.0f;
    L7:
        if (r102 == 0.0f) goto L11;
        r103 = (r100.top - this.f539892a.top) / r102;
    L11:
        return new j80.d(r104, r103);
    L5:
        r104 = (r100.left - this.f539892a.left) / r101;
        goto L7
    }

    public b(RegionId r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f539893b = r100;
        this.f539894c = r101;
        this.f539892a = new Rect();
    }
}
