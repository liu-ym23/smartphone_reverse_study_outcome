package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_newbie_intro";
    }

    public j() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        final FragmentActivity r102 = r100.getActivity();
        View r103 = r100.f220706h;
        final String r104 = r102.getString(R.string.Sheet_Newbie_Intro);
        final String r105 = r102.getString(R.string.Sheet_Newbie_IntroHint);
        View r106 = r103.findViewWithTag(FabItemEnum.operation.name());
        if (r106 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r106.post(new i(r100, r102, r104, r105));
        return true;
    L10:
        return false;
    }
}
