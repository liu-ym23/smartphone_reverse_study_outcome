package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class l extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_newbie_edit";
    }

    public l() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r110, final OnBoardingData r111) {
        final FragmentActivity r100 = r110.getActivity();
        View r101 = r110.f220706h;
        final String r102 = r100.getString(R.string.Sheet_Newbie_Edit);
        final String r103 = r100.getString(R.string.Sheet_Newbie_EditHint);
        final View r104 = r101.findViewWithTag(FabItemEnum.input.name());
        if (r104 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r104.post(new k(r104, r102, r111, r103, r110, r100));
        return true;
    L10:
        return false;
    }
}
