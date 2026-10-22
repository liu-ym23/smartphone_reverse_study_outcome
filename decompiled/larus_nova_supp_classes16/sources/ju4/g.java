package ju4;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ BitableApplyProFragment a;

    public g(BitableApplyProFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        BitableApplyProFragment r3 = this.a;
        int r0 = BitableApplyProFragment.u;
        r3.X90().clearFocus();
        rcb.c.c(r3.getContext());
    }
}
