package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.sheet.fab.FabItemEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends b {
    public final String getId() {
        return "mobile_sheet_newbie_intro";
    }

    public j() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r5, OnBoardingData r6) {
        final FragmentActivity r7 = r5.getActivity();
        View r0 = r5.h;
        final String r1 = r7.getString(2131893001);
        final String r2 = r7.getString(2131893002);
        View r3 = r0.findViewWithTag(FabItemEnum.operation.name());
        if (r3 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r3.post(new i(r5, r7, r1, r2));
        return true;
    L10:
        return false;
    }
}
