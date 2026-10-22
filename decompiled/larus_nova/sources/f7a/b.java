package f7a;

import android.view.Choreographer;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f475801a;

    public b(c r100) {
        this.f475801a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        c r101 = this.f475801a;
        boolean r102 = r101.a(r101.f475803b);
        if (r102 == false) goto L8;
        c r103 = this.f475801a;
        int r104 = r103.f475803b;
        UIListContainer r105 = ((UIListContainer.f) r103).f382807f;
        if (r105.f382773a == false) goto L7;
        ((ListContainerView) r105.getView()).scrollBy(0, r104);
        goto L8
    L7:
        ((ListContainerView) r105.getView()).scrollBy(r104, 0);
    L8:
        c r106 = this.f475801a;
        boolean r107 = r106.f475802a;
        if (r107 == false) goto L16;
        if (r102 == true) goto L14;
        if (r106.f475804c == true) goto L16;
    L14:
        if (r106.f475805d == null) goto L21;
        Choreographer.getInstance().postFrameCallback(this.f475801a.f475805d);
        return;
    L21:
        return;
    L16:
        if (r107 == false) goto L18;
        if (r102 == false) goto L18;
    L19:
        this.f475801a.b();
        return;
    L18:
        UIListContainer.f r108 = (UIListContainer.f) r106;
        ((ListContainerView) UIListContainer.N(r108.f382807f)).f382764w = false;
        ((ListContainerView) UIListContainer.O(r108.f382807f)).setScrollState(1);
        goto L19
    }
}
