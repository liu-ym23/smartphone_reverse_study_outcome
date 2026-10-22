package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends b {
    public final String getId() {
        return "mobile_sheet_redesign_listMode";
    }

    public t() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r4, OnBoardingData r5) {
        final FragmentActivity r6 = r4.getActivity();
        final View r0 = r4.h.findViewWithTag("list");
        if (r0 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        final String r1 = r6.getString(2131893005);
        r0.post(new s(r4, r6, r1, r0));
        return true;
    L10:
        return false;
    }
}
