package zy4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m extends com.bytedance.ee.bear.document.onboarding.b {
    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "mobile_doc_toolbarV2_insertTable";
    }

    public m() {
    }

    public static void d(com.bytedance.ee.bear.document.onboarding.c r3, View r4) {
        com.bytedance.ee.bear.document.onboarding.a.C0088a.a.b(m.class);
        FragmentActivity r0 = r3.getActivity();
        uk5.e r1 = new uk5.e(r0.getString(2131887206), r4);
        r1.i = 5000;
        r3.d(r0.getWindow(), r1, null);
        tt5.a.h("DocInsertTableMission", "DocInsertTableMission show done");
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r3, OnBoardingData r4) {
        tt5.a.h("DocInsertTableMission", "show DocInsertTableMission");
        final HorizontalOverScrollView r5 = (HorizontalOverScrollView) r3.h.findViewById(2131385238);
        final View r0 = r3.h.findViewWithTag(ToolbarPrimaryItemId.insertTable.name());
        if (r5 == null) goto L7;
        if (r0 == null) goto L7;
        r0.post(new k(this, r0, r5, r3));
        return true;
    L7:
        com.bytedance.ee.bear.document.onboarding.a.C0088a.a.a(this);
        return false;
    }
}
