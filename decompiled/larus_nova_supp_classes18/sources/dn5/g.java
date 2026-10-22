package dn5;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends b {
    public final String getId() {
        return "mobile_sheet_cardMode_toolbarEntry";
    }

    public g() {
    }

    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r6, OnBoardingData r7) {
        final FragmentActivity r8 = r6.getActivity();
        final View r0 = r6.h.findViewById(2131386162);
        RecyclerView r1 = r6.h.findViewById(2131389075);
        if (r1 != null) goto L5;
        return false;
    L5:
        final View r3 = r1.findViewWithTag(ToolbarItemEnum.editRowInCard.name());
        if (r0 == null) goto L12;
        if (r3 == null) goto L12;
        if (d() == true) goto L12;
        r1.postDelayed(new e(r0, r3, r8, r6), 200);
        return true;
    L12:
        return false;
    }
}
