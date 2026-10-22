package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class n extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_newbie_search";
    }

    public n() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r110, final OnBoardingData r111) {
        final FragmentActivity r100 = r110.getActivity();
        final String r101 = r100.getString(R.string.Sheet_Newbie_Search);
        final String r102 = r100.getString(R.string.Sheet_Newbie_SearchHint);
        final View r103 = r110.f220705g.findMenuView("SEARCH");
        if (r103 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r103.post(new m(r103, r101, r111, r102, r110, r100));
        return true;
    L10:
        return false;
    }
}
