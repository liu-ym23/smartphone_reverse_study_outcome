package com.ss.android.ugc.aweme.search.common.topsection.widget;

import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/topsection/widget/HeaderRoundHelper;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderRoundHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f452241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f452242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PaintFlagsDrawFilter f452243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f452244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f452245e;

    public final void a(Canvas r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f452245e.getChildCount() <= 0) goto L7;
        View r101 = this.f452245e.getChildAt(0);
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        this.f452242b.reset();
        this.f452241a.top = r101.getTop();
        this.f452241a.bottom = this.f452245e.getHeight();
        RectF r102 = this.f452241a;
        r102.left = 0.0f;
        r102.right = this.f452245e.getWidth();
        this.f452242b.addRoundRect(this.f452241a, this.f452244d, Path.Direction.CW);
        r100.setDrawFilter(this.f452243c);
        r100.clipPath(this.f452242b);
        return;
    L7:
        r101 = null;
        goto L8
    }

    public HeaderRoundHelper(ViewGroup r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        this.f452245e = r100;
        this.f452241a = new RectF();
        this.f452242b = new Path();
        this.f452243c = new PaintFlagsDrawFilter(0, 3);
        this.f452244d = new float[]{r101, r101, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f};
        r100.setWillNotDraw(false);
    }
}
