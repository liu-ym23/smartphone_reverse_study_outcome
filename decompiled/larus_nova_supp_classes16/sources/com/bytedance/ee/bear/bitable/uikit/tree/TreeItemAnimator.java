package com.bytedance.ee.bear.bitable.uikit.tree;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "onMoveAnimationEndListener", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator$OnMoveAnimationEndListener;", "setOnMoveAnimationEndListener", "", "listener", "animateMove", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromX", "", "fromY", "toX", "toY", "MoveAnimationRunnable", "OnMoveAnimationEndListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TreeItemAnimator extends DefaultItemAnimator {
    public b a;

    public final class a implements Runnable {
        public final RecyclerView.ViewHolder a;
        public final /* synthetic */ TreeItemAnimator b;

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.b.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.w(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(TreeItemAnimator r2, RecyclerView.ViewHolder r3) {
            Intrinsics.checkNotNullParameter(r3, "holder");
            this.b = r2;
            this.a = r3;
        }
    }

    public interface b {
        void w(RecyclerView.ViewHolder r1);
    }

    public TreeItemAnimator() {
    }

    public final boolean animateMove(RecyclerView.ViewHolder r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        boolean r7 = super.animateMove(r2, r3, r4, r5, r6);
        if (r7 == true) goto L5;
    L7:
        return r7;
    L5:
        if (this.a == null) goto L7;
        r2.itemView.post(new a(this, r2));
        goto L7
    }
}
