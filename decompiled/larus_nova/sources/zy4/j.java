package zy4;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends com.bytedance.ee.bear.document.onboarding.b {
    @Override // tk5.d
    public final String getBiz() {
        return "doc";
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b, tk5.d
    public final String getDependency() {
        return null;
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_doc_comment_intro";
    }

    public j() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        if (r101.position != null) goto L5;
        return false;
    L5:
        tt5.a.h("DocCommentMission", r101.position.f220697x + " : " + r101.position.f220698y);
        FragmentActivity r102 = r100.getActivity();
        String r103 = r102.getString(R.string.Doc_Comment_Intro);
        OnBoardingData.Position r104 = r101.position;
        r100.d(r102.getWindow(), new uk5.e(r103, new int[]{(int) r104.f220697x, (int) r104.f220698y}), null);
        return true;
    }
}
