package yi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ PrivacyFragment a;

    public j(PrivacyFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.ee.bear.middleground.record.a.b("more_information");
        PrivacyFragment r6 = this.a;
        int r0 = PrivacyFragment.B;
        r6.getClass();
        s45.h r1 = s45.g.a;
        String r2 = s45.g.a.a("privacy_setting_help_center", "669630434840", "360034747813", null);
        r6.A.u5(r2);
    }
}
