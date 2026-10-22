package zy4;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.Direction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class f extends com.bytedance.ee.bear.document.onboarding.b {
    public String getBiz() {
        return "doc";
    }

    public String getId() {
        return "mobile_doc_blockmenu_intro";
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r11, OnBoardingData r12) {
        if (r12.position != null) goto L5;
        return false;
    L5:
        tt5.a.h("DocBlockMenuMission", "DocBlockMenuMission " + r12.toString());
        tt5.a.h("DocBlockMenuMission", "screen width " + com.bytedance.ee.util.ui.n.v() + " screen height " + com.bytedance.ee.util.ui.n.t());
        FragmentActivity r0 = r11.getActivity();
        String r3 = com.bytedance.ee.util.ui.n.x(r0, 2131887589);
        float r4 = r12.position.height / ((float) com.bytedance.ee.util.ui.n.t());
        float r5 = r12.position.y / ((float) com.bytedance.ee.util.ui.n.t());
        RectF r6 = new RectF();
        OnBoardingData.Position r13 = r12.position;
        float r7 = r13.x;
        r6.left = r7;
        float r8 = r13.y;
        r6.top = r8;
        r6.right = r7 + r13.width;
        r6.bottom = r8 + r13.height;
        tt5.a.h("DocBlockMenuMission", "heightP: " + r4 + "; topP: " + r5);
        if (r4 >= 0.6666667f) goto L8;
    L10:
        uk5.e r1 = new uk5.e(r3, r6);
        r1.g = Direction.UP;
        r11.d(r0.getWindow(), r1, null);
    L11:
        return true;
    L8:
        if (r5 > 0.33333334f) goto L10;
        uk5.e r2 = new uk5.e(r3, new int[]{(int) r6.centerX(), (int) r6.centerY()});
        r2.g = Direction.UP;
        r11.d(r0.getWindow(), r2, null);
        goto L11
    }
}
