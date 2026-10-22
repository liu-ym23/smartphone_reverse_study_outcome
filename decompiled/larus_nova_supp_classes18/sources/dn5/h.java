package dn5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends b {
    public final String getId() {
        return "mobile_sheet_landscape_intro";
    }

    public h() {
    }

    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r6, OnBoardingData r7) {
        if (d() == false) goto L6;
        return false;
    L6:
        FragmentActivity r8 = r6.getActivity();
        String r0 = r8.getString(2131892997);
        String r1 = r8.getString(2131892998);
        String r2 = r8.getString(2131892964);
        uk5.b r3 = new uk5.b(r0, 2131232567);
        r3.c = r1;
        r3.e = r2;
        r6.b(r8.getWindow(), r3, null);
        return true;
    }
}
