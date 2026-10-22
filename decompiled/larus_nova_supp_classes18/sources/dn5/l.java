package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends b {
    public final String getId() {
        return "mobile_sheet_newbie_edit";
    }

    public l() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r10, final OnBoardingData r11) {
        final FragmentActivity r6 = r10.getActivity();
        View r0 = r10.h;
        final String r2 = r6.getString(2131892999);
        final String r4 = r6.getString(2131893000);
        final View r7 = r0.findViewWithTag(FabItemEnum.input.name());
        if (r7 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r7.post(new k(r7, r2, r11, r4, r10, r6));
        return true;
    L10:
        return false;
    }
}
