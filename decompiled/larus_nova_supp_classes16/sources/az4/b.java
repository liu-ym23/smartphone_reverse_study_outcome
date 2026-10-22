package az4;

import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.onboarding.c;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.document.onboarding.b {
    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "mobile_doc_todocenter_intro";
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final c r3, OnBoardingData r4) {
        tt5.a.h("OnBoardingManager", "show DocTodoCenterMission");
        if (r3.h.findViewWithTag(ToolbarPrimaryItemId.mention.name()) == null) goto L6;
        j.d(new a(this, r3), 200);
        return true;
    L6:
        com.bytedance.ee.bear.document.onboarding.a.C0088a.a.a(this);
        return false;
    }
}
