package zy4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o extends com.bytedance.ee.bear.document.onboarding.b {
    public final boolean c;

    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "mobile_doc_translate_intro";
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final String getDependency() {
        if (this.c == false) goto L6;
        return "mobile_wiki_newbie_pageTree";
    L6:
        return null;
    }

    public o(boolean r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r4, OnBoardingData r5) {
        final FragmentActivity r6 = r4.getActivity();
        View r0 = r4.g.findMenuView("MORE_OPERATE");
        if (r0 == null) goto L6;
        final uk5.e r2 = new uk5.e(r6.getString(2131888274), r0);
        r0.post(new n(r4, r6, r2));
        return true;
    L6:
        return false;
    }
}
