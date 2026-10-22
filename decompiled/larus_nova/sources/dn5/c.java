package dn5;

import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_cardMode_dragEntry";
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        FragmentActivity r102 = r100.getActivity();
        if (r101.position != null) goto L6;
        return false;
    L6:
        if (d() == true) goto L9;
        RectF r103 = new RectF();
        OnBoardingData.Position r104 = r101.position;
        float r105 = r104.f220697x;
        r103.left = r105;
        float r106 = r104.f220698y;
        r103.top = r106;
        r103.right = r105 + r104.width;
        r103.bottom = r106 + r104.height;
        uk5.e r107 = new uk5.e(r102.getString(R.string.CreationMobile_Sheets_FullCard), r103);
        r107.f550521g = Direction.UP;
        r100.d(r102.getWindow(), r107, null);
        return true;
    L9:
        return false;
    }
}
