package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class p extends b {
    @Override // tk5.d
    public final String getId() {
        return "mobile_sheet_oppanel_operate";
    }

    public p() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        final FragmentActivity r102 = r100.getActivity();
        final View r103 = r100.f220706h.findViewById(R.id.fab_dragview);
        if (r103 != null) goto L5;
        return false;
    L5:
        if (d() == true) goto L10;
        r103.post(new o(r103, r102, r100));
        return true;
    L10:
        return false;
    }
}
