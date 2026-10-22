package l19;

import com.larus.common_ui.photoviewer.transition.TransitionPhotoDraweeView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransitionPhotoDraweeView f507034a;

    public g(TransitionPhotoDraweeView r100) {
        this.f507034a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        Iterator<T> r101 = this.f507034a.f327759m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).onTransitionBegin(r100);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        Iterator<T> r101 = this.f507034a.f327759m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((f) r101.next()).onTransitionEnd(r100);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
        Iterator<T> r102 = this.f507034a.f327759m.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        ((f) r102.next()).onTransitionChanged(r100, r101);
        goto L4
    L7:
        if (r100 == 2) goto L9;
        return;
    L9:
        if (this.f507034a.getDismissAnimationType() != 1) goto L14;
        this.f507034a.setAlpha(1 - r101);
        return;
    }
}
