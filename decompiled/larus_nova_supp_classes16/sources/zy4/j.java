package zy4;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends com.bytedance.ee.bear.document.onboarding.b {
    public final String getBiz() {
        return "doc";
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final String getDependency() {
        return null;
    }

    public final String getId() {
        return "mobile_doc_comment_intro";
    }

    public j() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r7, OnBoardingData r8) {
        if (r8.position != null) goto L5;
        return false;
    L5:
        tt5.a.h("DocCommentMission", r8.position.x + " : " + r8.position.y);
        FragmentActivity r0 = r7.getActivity();
        String r2 = r0.getString(2131887621);
        OnBoardingData.Position r9 = r8.position;
        r7.d(r0.getWindow(), new uk5.e(r2, new int[]{(int) r9.x, (int) r9.y}), null);
        return true;
    }
}
