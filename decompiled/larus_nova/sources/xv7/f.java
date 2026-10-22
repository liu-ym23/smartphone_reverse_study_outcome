package xv7;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager;

/* JADX INFO: loaded from: classes23.dex */
public abstract class f extends BaseItemAnimationManager<h> {
    public abstract boolean r(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104);

    public f(BaseItemAnimator r100) {
        super(r100);
    }

    public final void s(RecyclerView.ViewHolder r100) {
        b();
        this.f276023a.dispatchMoveFinished(r100);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final /* bridge */ /* synthetic */ void c(d r100, RecyclerView.ViewHolder r101) {
        h r102 = (h) r100;
        s(r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final void d(d r100, RecyclerView.ViewHolder r101) {
        h r102 = (h) r100;
        b();
        this.f276023a.dispatchMoveStarting(r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final boolean f(d r100, RecyclerView.ViewHolder r101) {
        h r102 = (h) r100;
        RecyclerView.ViewHolder r103 = r102.f565186e;
        if (r103 == null) goto L7;
        if (r101 == null) goto L6;
        if (r103 != r101) goto L7;
    L6:
        l(r102, r103);
        s(r102.f565186e);
        r102.a(r102.f565186e);
        return true;
    L7:
        return false;
    }
}
