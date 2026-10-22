package com.bytedance.ee.bear.bitable.card.view.record;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u000fJ \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/record/FieldGroupDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "ranges", "", "Lkotlin/Pair;", "", "updateRanges", "", "newRanges", "", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldGroupDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f208640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<Integer, Integer>> f208641b;

    public FieldGroupDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Paint r101 = new Paint(1);
        r101.setColor(ContextCompat.getColor(r100, R.color.line_border_card));
        r101.setStrokeWidth(1.0f);
        this.f208640a = r101;
        this.f208641b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r210) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r210, "state");
        RecyclerView.LayoutManager r100 = r111.getLayoutManager();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r111.getPaddingLeft() + n.c(22.0f);
        int r112 = n.c(10.0f);
        int r113 = n.c(18.0f);
        int r114 = r111.getPaddingLeft() + n.c(16.0f);
        int r115 = (r111.getWidth() - r111.getPaddingRight()) - n.c(16.0f);
        Iterator<T> r116 = this.f208641b.iterator();
    L7:
        if (r116.hasNext() == false) goto L48;
        Pair r102 = (Pair) r116.next();
        int r103 = ((Number) r102.component1()).intValue();
        int r104 = ((Number) r102.component2()).intValue();
        View r105 = r100.findViewByPosition(r103);
        if (r105 != null) goto L18;
        int r106 = r103 + 1;
        if (r106 > r104) goto L18;
        if (r106 > r104) goto L18;
    L13:
        View r117 = r100.findViewByPosition(r106);
        if (r117 != null) goto L15;
        if (r106 == r104) goto L18;
        r106 = r106 + 1;
        goto L13
    L15:
        r105 = r117;
        boolean r107 = true;
    L19:
        View r118 = r100.findViewByPosition(r104);
        if (r118 != null) goto L29;
        int r108 = r104 - 1;
        if (r108 < r103) goto L29;
        if (r103 > r108) goto L29;
    L24:
        View r119 = r100.findViewByPosition(r108);
        if (r119 != null) goto L26;
        if (r108 == r103) goto L29;
        r108 = r108 - 1;
        goto L24
    L26:
        boolean r120 = true;
    L30:
        if (r105 == null) goto L7;
        if (r119 == null) goto L7;
        if (r107 == false) goto L35;
        int r109 = r105.getTop();
    L36:
        if (r120 == false) goto L38;
        int r121 = r119.getBottom();
    L39:
        if (r121 <= r109) goto L41;
        float r122 = r101;
        r110.drawLine(r122, r109, r122, r121, this.f208640a);
    L41:
        if (r115 <= r114) goto L7;
        if (r120 == true) goto L7;
        int r123 = r119.getBottom();
        if (r123 < r119.getTop()) goto L7;
        if (r123 > r119.getBottom()) goto L7;
        float r124 = r123;
        r110.drawLine(r114, r124, r115, r124, this.f208640a);
        goto L7
    L38:
        r121 = r119.getBottom() - r113;
        goto L39
    L35:
        r109 = r105.getBottom() - r112;
    L29:
        r119 = r118;
        r120 = false;
    L18:
        r107 = false;
        goto L19
    }
}
