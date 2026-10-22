package com.bytedance.locallife.dito.animate;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/dito/animate/OnceItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class OnceItemAnimator extends DefaultItemAnimator {

    public static final class a implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnceItemAnimator f257289a;

        public a(OnceItemAnimator r100) {
            this.f257289a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public final void onAnimationsFinished() {
            this.f257289a.getClass();
            this.f257289a.getClass();
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        super.runPendingAnimations();
        isRunning(new a(this));
    }
}
