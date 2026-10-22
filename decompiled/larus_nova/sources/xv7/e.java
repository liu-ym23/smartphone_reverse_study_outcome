package xv7;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes23.dex */
public abstract class e extends BaseItemAnimationManager<b> {
    public e(BaseItemAnimator r100) {
        super(r100);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final void n(d r100) {
        b r101 = (b) r100;
        RecyclerView.ViewHolder r102 = r101.f565177b;
        if (r102 == null) goto L7;
        View r103 = r102.itemView;
        if (r103 == null) goto L7;
        RefactoredDefaultItemAnimator.b r104 = (RefactoredDefaultItemAnimator.b) this;
        ViewPropertyAnimatorCompat r105 = ViewCompat.animate(r103);
        r105.setDuration(r104.f276023a.getChangeDuration());
        r105.translationX(r101.f565180e - r101.f565178c);
        r105.translationY(r101.f565181f - r101.f565179d);
        r105.alpha(0.0f);
        r104.q(r101, r101.f565177b, r105);
    L7:
        RecyclerView.ViewHolder r106 = r101.f565176a;
        if (r106 == null) goto L13;
        View r107 = r106.itemView;
        if (r107 == null) goto L14;
        RefactoredDefaultItemAnimator.b r108 = (RefactoredDefaultItemAnimator.b) this;
        ViewPropertyAnimatorCompat r109 = ViewCompat.animate(r107);
        r109.translationX(0.0f);
        r109.translationY(0.0f);
        r109.setDuration(r108.f276023a.getChangeDuration());
        r109.alpha(1.0f);
        r108.q(r101, r101.f565176a, r109);
        return;
    L14:
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final /* bridge */ /* synthetic */ void c(d r100, RecyclerView.ViewHolder r101) {
        r((b) r100, r101);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final void d(d r100, RecyclerView.ViewHolder r101) {
        b();
        BaseItemAnimator r102 = this.f276023a;
        if (r101 != ((b) r100).f565177b) goto L5;
        boolean r103 = true;
    L6:
        r102.dispatchChangeStarting(r101, r103);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
    public final boolean f(d r100, RecyclerView.ViewHolder r101) {
        b r102 = (b) r100;
        RecyclerView.ViewHolder r103 = r102.f565177b;
        if (r103 == null) goto L7;
        if (r101 == null) goto L6;
        if (r103 != r101) goto L7;
    L6:
        l(r102, r103);
        r(r102, r102.f565177b);
        r102.a(r102.f565177b);
    L7:
        RecyclerView.ViewHolder r104 = r102.f565176a;
        if (r104 == null) goto L13;
        if (r101 == null) goto L11;
        if (r104 != r101) goto L13;
    L11:
        l(r102, r104);
        r(r102, r102.f565176a);
        r102.a(r102.f565176a);
    L13:
        if (r102.f565177b == null) goto L15;
    L17:
        return false;
    L15:
        if (r102.f565176a != null) goto L17;
        return true;
    }

    public final void r(b r100, RecyclerView.ViewHolder r101) {
        if (b() == false) goto L5;
        Objects.toString(r101);
    L5:
        BaseItemAnimator r102 = this.f276023a;
        if (r101 != r100.f565177b) goto L8;
        boolean r103 = true;
    L9:
        r102.dispatchChangeFinished(r101, r103);
        return;
    L8:
        r103 = false;
        goto L9
    }
}
