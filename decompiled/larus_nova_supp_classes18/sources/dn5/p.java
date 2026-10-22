package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends b {
    public final String getId() {
        return "mobile_sheet_oppanel_operate";
    }

    public p() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r3, OnBoardingData r4) {
        final FragmentActivity r5 = r3.getActivity();
        final View r0 = r3.h.findViewById(2131372039);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r0.post(new o(r0, r5, r3));
        return true;
    L10:
        return false;
    }
}
