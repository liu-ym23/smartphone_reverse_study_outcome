package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends b {
    public final String getId() {
        return "mobile_sheet_redesign_cardModeEdit";
    }

    public r() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r5, OnBoardingData r6) {
        final FragmentActivity r7 = r5.getActivity();
        View r0 = r5.h.findViewById(2131365219);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        final String r1 = r7.getResources().getString(2131888257);
        final String r2 = r7.getResources().getString(2131888256);
        r0.post(new q(r5, r7, r1, r2));
        return true;
    L10:
        return false;
    }
}
