package zy4;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class f extends com.bytedance.ee.bear.document.onboarding.b {
    @Override // tk5.d
    public String getBiz() {
        return "doc";
    }

    @Override // tk5.d
    public String getId() {
        return "mobile_doc_blockmenu_intro";
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r110, OnBoardingData r111) {
        if (r111.position != null) goto L5;
        return false;
    L5:
        tt5.a.h("DocBlockMenuMission", "DocBlockMenuMission " + r111.toString());
        tt5.a.h("DocBlockMenuMission", "screen width " + com.bytedance.ee.util.ui.n.v() + " screen height " + com.bytedance.ee.util.ui.n.t());
        FragmentActivity r100 = r110.getActivity();
        String r101 = com.bytedance.ee.util.ui.n.x(r100, R.string.Doc_BlockMenu_Intro);
        float r102 = r111.position.height / ((float) com.bytedance.ee.util.ui.n.t());
        float r103 = r111.position.f220698y / ((float) com.bytedance.ee.util.ui.n.t());
        RectF r104 = new RectF();
        OnBoardingData.Position r112 = r111.position;
        float r105 = r112.f220697x;
        r104.left = r105;
        float r106 = r112.f220698y;
        r104.top = r106;
        r104.right = r105 + r112.width;
        r104.bottom = r106 + r112.height;
        tt5.a.h("DocBlockMenuMission", "heightP: " + r102 + "; topP: " + r103);
        if (r102 >= 0.6666667f) goto L8;
    L10:
        uk5.e r107 = new uk5.e(r101, r104);
        r107.f550521g = Direction.UP;
        r110.d(r100.getWindow(), r107, null);
    L11:
        return true;
    L8:
        if (r103 > 0.33333334f) goto L10;
        uk5.e r108 = new uk5.e(r101, new int[]{(int) r104.centerX(), (int) r104.centerY()});
        r108.f550521g = Direction.UP;
        r110.d(r100.getWindow(), r108, null);
        goto L11
    }
}
