package dn5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_landscape_intro";
    }

    public h() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        if (d() == false) goto L6;
        return false;
    L6:
        FragmentActivity r102 = r100.getActivity();
        String r103 = r102.getString(R.string.Sheet_Landscape_Intro);
        String r104 = r102.getString(R.string.Sheet_Landscape_IntroHint);
        String r105 = r102.getString(R.string.Onboarding_Got_It);
        uk5.b r106 = new uk5.b(r103, Integer.valueOf(R.drawable.ccm_onboarding_horizontal_mobile));
        r106.f550497c = r104;
        r106.f550499e = r105;
        r100.b(r102.getWindow(), r106, null);
        return true;
    }
}
