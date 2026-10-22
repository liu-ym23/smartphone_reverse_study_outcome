package p05;

import android.view.View;
import com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomHeaderFragment f527293a;

    public f(OfficeCustomHeaderFragment r100) {
        this.f527293a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r107 - r105) == (r103 - r101)) goto L8;
        OfficeCustomHeaderFragment r109 = this.f527293a;
        int r110 = OfficeCustomHeaderFragment.f219447y;
        r109.X90();
        View r111 = this.f527293a.getView();
        if (r111 == null) goto L9;
        r111.requestLayout();
        return;
    L9:
        return;
    }
}
