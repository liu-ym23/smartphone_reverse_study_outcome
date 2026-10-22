package yi5;

import android.view.View;
import com.bytedance.ee.bear.middleground.record.privacy.PrivacyFragment;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyFragment f567946a;

    public j(PrivacyFragment r100) {
        this.f567946a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ee.bear.middleground.record.a.b("more_information");
        PrivacyFragment r101 = this.f567946a;
        int r102 = PrivacyFragment.B;
        r101.getClass();
        s45.h r103 = s45.g.f540568a;
        String r104 = s45.g.a.a("privacy_setting_help_center", "669630434840", "360034747813", null);
        r101.A.u5(r104);
    }
}
