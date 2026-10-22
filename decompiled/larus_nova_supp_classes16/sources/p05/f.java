package p05;

import android.view.View;
import com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnLayoutChangeListener {
    public final /* synthetic */ OfficeCustomHeaderFragment a;

    public f(OfficeCustomHeaderFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r8 - r6) == (r4 - r2)) goto L8;
        OfficeCustomHeaderFragment r10 = this.a;
        int r11 = OfficeCustomHeaderFragment.y;
        r10.X90();
        View r12 = this.a.getView();
        if (r12 == null) goto L9;
        r12.requestLayout();
        return;
    L9:
        return;
    }
}
