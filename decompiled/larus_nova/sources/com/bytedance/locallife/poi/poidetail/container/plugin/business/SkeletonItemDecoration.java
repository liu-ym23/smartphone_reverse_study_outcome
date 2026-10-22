package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/SkeletonItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/bytedance/locallife/poi/fragment/b;", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SkeletonItemDecoration extends RecyclerView.ItemDecoration implements com.bytedance.locallife.poi.fragment.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sp6.d f264049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f264050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f264051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f264052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f264053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f264054f;

    public SkeletonItemDecoration() {
        this.f264051c = 1.0f;
        Paint r100 = new Paint();
        r100.setColor(-1);
        this.f264053e = r100;
    }

    @Override // com.bytedance.locallife.poi.fragment.b
    public final void b(float r100) {
        this.f264051c = r100;
        RecyclerView r101 = this.f264054f;
        if (r101 == null) goto L6;
        r101.invalidateItemDecorations();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDrawOver(r110, r111, r112);
        if (this.f264050b == true) goto L5;
        return;
    L5:
        if (this.f264051c <= 0.0f) goto L16;
        sp6.d r113 = this.f264049a;
        if (r113 != null) goto L10;
        return;
    L10:
        int r114 = RangesKt.coerceIn(this.f264052d, 0, r111.getHeight());
        int r115 = r111.getHeight() - r114;
        if (r115 > 0) goto L13;
        return;
    L13:
        float r116 = 255;
        this.f264053e.setAlpha((int) (this.f264051c * r116));
        float r117 = r114;
        r110.drawRect(0.0f, r117, r111.getWidth(), r111.getHeight(), this.f264053e);
        r113.f(r111.getWidth(), r115);
        int r100 = r110.save();
        r110.clipRect(0, r114, r111.getWidth(), r111.getHeight());
        r110.translate(0.0f, r117);
        int r101 = r110.saveLayerAlpha(0.0f, 0.0f, r111.getWidth(), r115, (int) (r116 * this.f264051c));
        r113.e(r110);
        r110.restoreToCount(r101);
        r110.restoreToCount(r100);
        return;
    }
}
