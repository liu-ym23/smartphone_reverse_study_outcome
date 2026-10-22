package com.bytedance.locallife.pdp.headimage.view.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import jx6.i;
import jx6.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/viewholder/BaseItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseItemViewHolder extends RecyclerView.ViewHolder {
    public abstract void T3(p r100, i r101);

    public void U3() {
    }

    public void V3(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
    }

    public void onViewAttachedToWindow() {
    }

    public BaseItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }
}
