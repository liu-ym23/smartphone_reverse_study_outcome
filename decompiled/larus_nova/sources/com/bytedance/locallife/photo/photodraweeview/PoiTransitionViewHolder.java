package com.bytedance.locallife.photo.photodraweeview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/PoiTransitionViewHolder;", "Lcom/bytedance/locallife/photo/internal/photodraweeview/transition/TransitionViewHolder;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public class PoiTransitionViewHolder extends TransitionViewHolder {
    public PoiTransitionViewHolder(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        if (r101 != 2) goto L6;
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        return;
    }
}
