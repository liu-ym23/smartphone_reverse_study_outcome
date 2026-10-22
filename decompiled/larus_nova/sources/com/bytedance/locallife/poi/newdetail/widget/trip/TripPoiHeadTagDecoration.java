package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadTagDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadTagDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f263575a;

    public TripPoiHeadTagDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f263575a = (int) UIUtils.dip2Px(r100, 2.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        RecyclerView.Adapter r104 = r102.getAdapter();
        if ((r104 instanceof TripPoiHeadTagsAdapter) == false) goto L5;
        TripPoiHeadTagsAdapter r105 = (TripPoiHeadTagsAdapter) r104;
    L6:
        if (r105 == null) goto L8;
        int r106 = r105.f263583b;
    L10:
        if (r106 >= 0) goto L12;
    L14:
        r100.set(0, 0, 0, 0);
        return;
    L12:
        if (r106 != r102.getChildAdapterPosition(r101)) goto L14;
        int r107 = this.f263575a;
        r100.set(r107, 0, r107, 0);
        return;
    L8:
        r106 = -1;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
