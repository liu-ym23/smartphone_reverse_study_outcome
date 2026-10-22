package com.bytedance.locallife.photo.photopage.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/adapter/AlbumBlankDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class AlbumBlankDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f262145a;

    public AlbumBlankDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f262145a = (int) UIUtils.dip2Px(r100, 70.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        int r104 = r103.getItemCount();
        if (r104 > 0) goto L5;
        return;
    L5:
        if (r102.getChildLayoutPosition(r101) != (r104 - 1)) goto L9;
        r100.set(0, 0, 0, this.f262145a);
        return;
    }
}
