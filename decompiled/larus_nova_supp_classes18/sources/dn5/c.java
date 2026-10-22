package dn5;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.Direction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends b {
    public final String getId() {
        return "mobile_sheet_cardMode_dragEntry";
    }

    public c() {
    }

    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r6, OnBoardingData r7) {
        FragmentActivity r0 = r6.getActivity();
        if (r7.position != null) goto L6;
        return false;
    L6:
        if (d() == true) goto L9;
        RectF r1 = new RectF();
        OnBoardingData.Position r8 = r7.position;
        float r2 = r8.x;
        r1.left = r2;
        float r3 = r8.y;
        r1.top = r3;
        r1.right = r2 + r8.width;
        r1.bottom = r3 + r8.height;
        uk5.e r4 = new uk5.e(r0.getString(2131887393), r1);
        r4.g = Direction.UP;
        r6.d(r0.getWindow(), r4, null);
        return true;
    L9:
        return false;
    }
}
