package ju4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ BitableApplyProFragment a;

    public d(BitableApplyProFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        int r2 = com.bytedance.ee.bear.bitable.c.a;
        int r3 = n.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.apply_pro_back_press_fix_enable") == false) goto L7;
        FragmentActivity r4 = this.a.getActivity();
        if (r4 == null) goto L11;
        r4.onBackPressed();
        return;
    L11:
        return;
    L7:
        FragmentActivity r5 = this.a.getActivity();
        if (r5 == null) goto L13;
        r5.finish();
        return;
    }
}
