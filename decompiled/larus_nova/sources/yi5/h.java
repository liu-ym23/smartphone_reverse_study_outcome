package yi5;

import android.widget.CompoundButton;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyFragment f567944a;

    public /* synthetic */ h(PrivacyFragment r100) {
        this.f567944a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        PrivacyFragment r102 = this.f567944a;
        int r103 = PrivacyFragment.B;
        r102.getClass();
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L5;
        Toast.showFailureText(r102.getContext(), R.string.Doc_Facade_NetworkInterrutedRetry);
        return;
    L5:
        r102.f234317n.pushPrivacy(r101);
    }
}
