package com.larus.common_ui.photoviewer.transition;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import l19.j;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "transitionLayout", "Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "getTransitionLayout", "()Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "onTransitionBegin", "", "state", "", "onTransitionChanged", "factor", "", "onTransitionEnd", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TransitionViewHolder extends RecyclerView.ViewHolder implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f327760a;

    @Override // l19.f
    public void onTransitionBegin(int r100) {
    }

    @Override // l19.f
    public void onTransitionChanged(int r100, float r101) {
    }

    @Override // l19.f
    public void onTransitionEnd(int r100) {
    }

    public final TransitionLayout T3() {
        View r100 = this.itemView;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.common_ui.photoviewer.transition.TransitionLayout");
        return (TransitionLayout) r100;
    }

    public TransitionViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        TransitionLayout r101 = new TransitionLayout(r100.getContext(), null, 6, 0);
        r101.addView(r100, -1, -1);
        TransitionPhotoDraweeView r102 = j.a(r100);
        if (r102 == null) goto L5;
        r102.setHorizontalNestedScrollEnabled(true);
        r101.setDelegateDragTransitionView(r102);
    L5:
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        super(r101);
        this.f327760a = r100;
        T3().c(this);
    }
}
