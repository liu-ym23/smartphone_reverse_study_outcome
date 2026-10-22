package zy4;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends com.bytedance.ee.bear.document.onboarding.b {
    @Override // tk5.d
    public final String getBiz() {
        return "doc";
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_doc_toolbarV2_addNewBlock";
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        tt5.a.h("OnBoardingManager", "show DocAddNewBlockMission");
        final View r102 = r100.f220706h.findViewWithTag(ToolbarPrimaryItemId.addNewBlock.name());
        if (r102 == null) goto L6;
        r102.post(new b(this, r100, r102));
        return true;
    L6:
        com.bytedance.ee.bear.document.onboarding.a.C3144a.f220702a.a(this);
        return false;
    }
}
