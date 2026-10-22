package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends b {
    public final String getId() {
        return "mobile_sheet_newbie_search";
    }

    public n() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r10, final OnBoardingData r11) {
        final FragmentActivity r6 = r10.getActivity();
        final String r2 = r6.getString(2131893003);
        final String r4 = r6.getString(2131893004);
        final View r7 = r10.g.findMenuView("SEARCH");
        if (r7 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r7.post(new m(r7, r2, r11, r4, r10, r6));
        return true;
    L10:
        return false;
    }
}
