package hp4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f486394a;

    public d(FrameLayout r100) {
        this.f486394a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        int r109 = r104 - r102;
        if (this.f486394a.getHeight() == r109) goto L6;
        ViewGroup.LayoutParams r110 = this.f486394a.getLayoutParams();
        r110.height = r109;
        this.f486394a.setLayoutParams(r110);
        return;
    }
}
