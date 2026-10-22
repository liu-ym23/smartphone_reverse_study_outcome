package dn5;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends b {
    public final String getId() {
        return "mobile_sheet_cardMode_share";
    }

    public d() {
    }

    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r8, OnBoardingData r9) {
        FragmentActivity r0 = r8.getActivity();
        String r1 = r0.getResources().getString(2131887397);
        String r2 = r0.getResources().getString(2131887396);
        if (r9.position != null) goto L6;
        return false;
    L6:
        if (d() == true) goto L9;
        RectF r3 = new RectF();
        OnBoardingData.Position r10 = r9.position;
        float r4 = r10.x;
        r3.left = r4;
        float r5 = r10.y;
        r3.top = r5;
        r3.right = r4 + r10.width;
        r3.bottom = r5 + r10.height;
        uk5.c r11 = new uk5.c(r1, true, r3);
        r11.c = r2;
        r11.i = FlowStyleHollowShape.None;
        r11.n = true;
        r11.m = r0.getResources().getString(2131887759);
        r8.c(r0.getWindow(), r11, null);
        return true;
    L9:
        return false;
    }
}
