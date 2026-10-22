package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends b {
    public final String getId() {
        return "mobile_sheet_toolbar_intro";
    }

    public x() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r8, OnBoardingData r9) {
        final FragmentActivity r2 = r8.getActivity();
        final View r10 = r8.h.findViewById(2131386162);
        final RecyclerView r4 = r8.h.findViewById(2131389075);
        if (r10 == null) goto L9;
        if (r4 != null) goto L6;
        return false;
    L6:
        if (d() == true) goto L12;
        r10.postDelayed(new v(this, r2, r10, r4, r8), 200);
        return true;
    L12:
        return false;
    L9:
        return false;
    }
}
