package com.larksuite.common_selection;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes24.dex */
public final class x implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Point f282934a;

    @Override // com.larksuite.common_selection.s
    public final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return 1;
    }

    @Override // com.larksuite.common_selection.s
    public final boolean h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return true;
    }

    @Override // com.larksuite.common_selection.s
    public final boolean i(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return true;
    }

    public x() {
        this.f282934a = new Point();
    }

    @Override // com.larksuite.common_selection.s
    public final float j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        return 0.0f;
    }

    @Override // com.larksuite.common_selection.s
    public final Point d(o r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "point");
        View r102 = r100.f282908a;
        if (r102 == null) goto L5;
        int r103 = r102.getLeft();
        int r104 = r102.getTop();
        int r105 = 0;
        if (r100.f282909b <= 0) goto L9;
        boolean r106 = true;
    L10:
        Point r107 = this.f282934a;
        if (r106 == false) goto L13;
        r105 = r102.getWidth();
    L13:
        r107.x = r103 + r105;
        Point r108 = this.f282934a;
        r108.y = r104 + r102.getHeight();
        return this.f282934a;
    L9:
        r106 = false;
        goto L10
    L5:
        return new Point();
    }

    @Override // com.larksuite.common_selection.s
    public final p b(View r100, o r101, SelectionGranularity r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "point");
        Intrinsics.checkNotNullParameter(r102, "granularity");
        return new p(new o(r100, 0), new o(r100, 1));
    }

    @Override // com.larksuite.common_selection.s
    public final e c(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r103 = w.f282933a;
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r104 = r100.getTag(R.id.tag_selection_data);
        if ((r104 instanceof e) == false) goto L5;
        e r105 = (e) r104;
    L6:
        if (r105 == null) goto L9;
        return r105;
    L9:
        if ((r100 instanceof ImageView) == true) goto L11;
        return null;
    L11:
        return new e(((ImageView) r100).getContext().getString(R.string.Lark_Legacy_ImageSummarize));
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.larksuite.common_selection.s
    public final o g(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 >= (r100.getWidth() / 2)) goto L5;
        int r103 = 0;
    L7:
        return new o(r100, r103);
    L5:
        r103 = 1;
        goto L7
    }

    @Override // com.larksuite.common_selection.s
    public final void e(View r100, int r101, int r102, Path r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "outPath");
        RectF r104 = new RectF(0.0f, 0.0f, r100.getWidth(), r100.getHeight());
        r103.reset();
        r103.addRect(r104, Path.Direction.CW);
    }

    @Override // com.larksuite.common_selection.s
    public final float f(View r100, float r101, float r110, o r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r111, "point");
        float r102 = RangesKt.coerceAtLeast(r100.getWidth(), 1.0f);
        float r103 = RangesKt.coerceAtLeast(r100.getHeight(), 1.0f);
        float r104 = RangesKt.coerceIn(r101, 0.0f, r102);
        double r105 = 2;
        float r106 = ((float) Math.pow(r101 - r104, r105)) + ((float) Math.pow(r110 - RangesKt.coerceIn(r110, 0.0f, r103), r105));
        if (r111.f282909b <= 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == true) goto L10;
        r102 = 0.0f;
    L10:
        return r106 + (((float) Math.pow(r104 - r102, r105)) * 0.5f);
    L5:
        r107 = false;
        goto L6
    }
}
