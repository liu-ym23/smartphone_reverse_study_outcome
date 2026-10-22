package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "onMoveAnimationEndListener", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator$OnMoveAnimationEndListener;", "setOnMoveAnimationEndListener", "", "listener", "animateMove", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "MoveAnimationRunnable", "OnMoveAnimationEndListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TreeItemAnimator extends DefaultItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f216253a;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f216254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TreeItemAnimator f216255b;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f216255b.f216253a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.w(this.f216254a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(TreeItemAnimator r100, RecyclerView.ViewHolder r101) {
            Intrinsics.checkNotNullParameter(r101, "holder");
            this.f216255b = r100;
            this.f216254a = r101;
        }
    }

    public interface b {
        void w(RecyclerView.ViewHolder r100);
    }

    public TreeItemAnimator() {
    }

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r105 = super.animateMove(r100, r101, r102, r103, r104);
        if (r105 == true) goto L5;
    L7:
        return r105;
    L5:
        if (this.f216253a == null) goto L7;
        r100.itemView.post(new a(this, r100));
        goto L7
    }
}
