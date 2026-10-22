package zy4;

import android.view.View;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends com.bytedance.ee.bear.document.onboarding.b {
    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "mobile_doc_toolbarV2_blockTransform";
    }

    public i() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r2, OnBoardingData r3) {
        tt5.a.h("OnBoardingManager", "show DocBlockTransformMission");
        final View r4 = r2.h.findViewWithTag(ToolbarPrimaryItemId.blockTransform.name());
        if (r4 == null) goto L6;
        r4.post(new h(this, r2, r4));
        return true;
    L6:
        com.bytedance.ee.bear.document.onboarding.a.C0088a.a.a(this);
        return false;
    }
}
