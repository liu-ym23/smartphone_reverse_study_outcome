package la5;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f508180a;

    public g(i r100) {
        this.f508180a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        i r109 = this.f508180a;
        if (r109.f508197p == false) goto L15;
        ValueAnimator r110 = r109.f508184c;
        if (r110 != null) goto L7;
    L9:
        int r111 = r104 - r102;
        if ((r108 - r106) != r111) goto L12;
        return;
    L12:
        if (r111 < this.f508180a.f508185d.getResources().getDimensionPixelSize(R.dimen.doc_titlebar_height)) goto L17;
        com.bytedance.ee.bear.browser.plugin.d r112 = this.f508180a.f508198q;
        r112.f216619b = n.E(r111);
        return;
    L17:
        return;
    L7:
        if (r110.isRunning() == false) goto L9;
        return;
    }
}
