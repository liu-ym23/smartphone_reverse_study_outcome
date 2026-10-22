package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_redesign_cardModeEdit";
    }

    public r() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        final FragmentActivity r102 = r100.getActivity();
        View r103 = r100.f220706h.findViewById(R.id.card_title_bar);
        if (r103 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        final String r104 = r102.getResources().getString(R.string.Doc_Sheet_CardModeEditOnboardingTitle);
        final String r105 = r102.getResources().getString(R.string.Doc_Sheet_CardModeEditOnboardingHint);
        r103.post(new q(r100, r102, r104, r105));
        return true;
    L10:
        return false;
    }
}
