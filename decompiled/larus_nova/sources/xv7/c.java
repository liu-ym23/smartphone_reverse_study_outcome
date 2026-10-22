package xv7;

import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager;

/* JADX INFO: loaded from: classes23.dex */
public abstract class c extends BaseItemAnimationManager<a> {
    public c(BaseItemAnimator r100) {
        super(r100);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final void c(d r100, RecyclerView.ViewHolder r101) {
        a r102 = (a) r100;
        b();
        this.f276023a.dispatchAddFinished(r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final void d(d r100, RecyclerView.ViewHolder r101) {
        a r102 = (a) r100;
        b();
        this.f276023a.dispatchAddStarting(r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final boolean f(d r100, RecyclerView.ViewHolder r101) {
        a r102 = (a) r100;
        RecyclerView.ViewHolder r103 = r102.f565175a;
        if (r103 == null) goto L7;
        if (r101 == null) goto L6;
        if (r103 != r101) goto L7;
    L6:
        l(r102, r103);
        RecyclerView.ViewHolder r104 = r102.f565175a;
        b();
        this.f276023a.dispatchAddFinished(r104);
        r102.a(r102.f565175a);
        return true;
    L7:
        return false;
    }
}
