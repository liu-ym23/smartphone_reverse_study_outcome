package la5;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnLayoutChangeListener {
    public final /* synthetic */ i a;

    public g(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        i r10 = this.a;
        if (r10.p == false) goto L15;
        ValueAnimator r11 = r10.c;
        if (r11 != null) goto L7;
    L9:
        int r12 = r5 - r3;
        if ((r9 - r7) != r12) goto L12;
        return;
    L12:
        if (r12 < this.a.d.getResources().getDimensionPixelSize(2131165837)) goto L17;
        com.bytedance.ee.bear.browser.plugin.d r13 = this.a.q;
        r13.b = n.E(r12);
        return;
    L17:
        return;
    L7:
        if (r11.isRunning() == false) goto L9;
        return;
    }
}
