package yt8;

import android.view.View;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.viewholder.LifeViewHolder;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifeViewHolder f569166a;

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
    }

    public e(LifeViewHolder r100) {
        this.f569166a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        View r101 = this.f569166a.f317574d;
        if (r101 == null) goto L6;
        e1.o(r101);
        return;
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        LifeViewHolder r101 = this.f569166a;
        t1 r102 = r101.f317575e;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.d() == false) goto L10;
        View r103 = r101.f317574d;
        if (r103 == null) goto L14;
        e1.x(r103);
        return;
    L14:
        return;
    L10:
        View r104 = r101.f317574d;
        if (r104 == null) goto L16;
        e1.o(r104);
        return;
    }
}
