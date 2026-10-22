package com.larus.livetutor.impl.view;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/impl/view/TutorStarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "starView", "Lcom/larus/livetutor/impl/view/TutorStarView;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/livetutor/impl/view/TutorStarItem;", "", "<init>", "(Lcom/larus/livetutor/impl/view/TutorStarView;Lkotlin/jvm/functions/Function1;)V", "bind", MapController.ITEM_LAYER_TAG, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TutorStarViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f356805c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TutorStarView f356806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<m2, Unit> f356807b;

    /* JADX WARN: Multi-variable type inference failed */
    public TutorStarViewHolder(TutorStarView r100, Function1<? super m2, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "starView");
        Intrinsics.checkNotNullParameter(r101, "onItemClick");
        super(r100);
        this.f356806a = r100;
        this.f356807b = r101;
    }
}
