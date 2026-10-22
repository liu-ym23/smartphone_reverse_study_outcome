package com.bytedance.locallife.live.goodsshelves.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeLoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeLoadMoreViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f260367a;

    public LiveLocalLifeLoadMoreViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        Lazy r101 = LazyKt.lazy(LiveLocalLifeLoadMoreViewHolder$loadingView$2.INSTANCE);
        this.f260367a = r101;
        if ((r100 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r100;
    L6:
        if (r102 == null) goto L9;
        View r103 = (View) r101.getValue();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r102.addView(r103, r104);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
