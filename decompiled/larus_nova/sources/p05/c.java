package p05;

import android.view.View;
import com.bytedance.ee.bear.document.customheader.CustomHeaderFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomHeaderFragment f527291a;

    public c(CustomHeaderFragment r100) {
        this.f527291a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if ((r107 - r105) == (r103 - r101)) goto L8;
        CustomHeaderFragment r109 = this.f527291a;
        int r110 = CustomHeaderFragment.f219406z;
        r109.Y90();
        View r111 = this.f527291a.getView();
        if (r111 == null) goto L9;
        r111.requestLayout();
        return;
    L9:
        return;
    }
}
