package dn5;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends b {
    public final String getId() {
        return "mobile_sheet_redesign_viewImage";
    }

    public u() {
    }

    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r7, OnBoardingData r8) {
        FragmentActivity r0 = r7.getActivity();
        if (d() == false) goto L5;
        return false;
    L5:
        if (r8.position == null) goto L10;
        String r1 = r0.getString(2131893006);
        RectF r2 = new RectF();
        OnBoardingData.Position r9 = r8.position;
        float r3 = r9.x;
        r2.left = r3;
        float r4 = r9.y;
        r2.top = r4;
        r2.right = r3 + r9.width;
        r2.bottom = r4 + r9.height;
        r7.d(r0.getWindow(), new uk5.e(r1, r2), null);
        return true;
    L10:
        return false;
    }
}
