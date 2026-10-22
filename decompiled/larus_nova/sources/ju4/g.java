package ju4;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableApplyProFragment f500489a;

    public g(BitableApplyProFragment r100) {
        this.f500489a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableApplyProFragment r101 = this.f500489a;
        int r102 = BitableApplyProFragment.f215126u;
        r101.X90().clearFocus();
        rcb.c.c(r101.getContext());
    }
}
