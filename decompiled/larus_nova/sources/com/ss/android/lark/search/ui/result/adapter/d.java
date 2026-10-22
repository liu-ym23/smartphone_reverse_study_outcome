package com.ss.android.lark.search.ui.result.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements b<Object, RecyclerView.ViewHolder> {
    public d() {
    }

    public final void f(RecyclerView.ViewHolder r100, SearchBaseInfo r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void c(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void e(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final RecyclerView.ViewHolder d(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        final View r102 = new View(r100);
        return new MultiTypeAdapter$mDefaultItemViewBinder$1$onCreateViewHolder$1(r102);
    }

    @Override // com.ss.android.lark.search.ui.result.adapter.b
    public final void a(RecyclerView.ViewHolder r100, SearchBaseInfo r101, int r102, List r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r103, "payloads");
        f(r100, r101, r102);
    }
}
