package zy4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class m extends com.bytedance.ee.bear.document.onboarding.b {
    @Override // tk5.d
    public final String getBiz() {
        return "doc";
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_doc_toolbarV2_insertTable";
    }

    public m() {
    }

    public static void d(com.bytedance.ee.bear.document.onboarding.c r100, View r101) {
        com.bytedance.ee.bear.document.onboarding.a.C3144a.f220702a.b(m.class);
        FragmentActivity r102 = r100.getActivity();
        uk5.e r103 = new uk5.e(r102.getString(R.string.CreationMobile_Docs_InsertTable_Onboarding_Toast), r101);
        r103.f550523i = 5000;
        r100.d(r102.getWindow(), r103, null);
        tt5.a.h("DocInsertTableMission", "DocInsertTableMission show done");
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        tt5.a.h("DocInsertTableMission", "show DocInsertTableMission");
        final HorizontalOverScrollView r102 = (HorizontalOverScrollView) r100.f220706h.findViewById(R.id.scroll_view);
        final View r103 = r100.f220706h.findViewWithTag(ToolbarPrimaryItemId.insertTable.name());
        if (r102 == null) goto L7;
        if (r103 == null) goto L7;
        r103.post(new k(this, r103, r102, r100));
        return true;
    L7:
        com.bytedance.ee.bear.document.onboarding.a.C3144a.f220702a.a(this);
        return false;
    }
}
