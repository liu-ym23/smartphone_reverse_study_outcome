package yi5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PrivacyFragment a;

    public /* synthetic */ h(PrivacyFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        PrivacyFragment r4 = this.a;
        int r0 = PrivacyFragment.B;
        r4.getClass();
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L5;
        Toast.showFailureText(r4.getContext(), 2131887782);
        return;
    L5:
        r4.n.pushPrivacy(r3);
    }
}
