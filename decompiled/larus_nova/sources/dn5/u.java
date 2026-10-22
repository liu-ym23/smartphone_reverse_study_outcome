package dn5;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class u extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_redesign_viewImage";
    }

    public u() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        FragmentActivity r102 = r100.getActivity();
        if (d() == false) goto L5;
        return false;
    L5:
        if (r101.position == null) goto L10;
        String r103 = r102.getString(R.string.Sheet_Redesign_ViewImage);
        RectF r104 = new RectF();
        OnBoardingData.Position r105 = r101.position;
        float r106 = r105.f220697x;
        r104.left = r106;
        float r107 = r105.f220698y;
        r104.top = r107;
        r104.right = r106 + r105.width;
        r104.bottom = r107 + r105.height;
        r100.d(r102.getWindow(), new uk5.e(r103, r104), null);
        return true;
    L10:
        return false;
    }
}
