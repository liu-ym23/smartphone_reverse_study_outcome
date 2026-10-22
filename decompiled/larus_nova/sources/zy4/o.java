package zy4;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class o extends com.bytedance.ee.bear.document.onboarding.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f573940c;

    @Override // tk5.d
    public final String getBiz() {
        return "doc";
    }

    @Override // tk5.d
    public final String getId() {
        return "mobile_doc_translate_intro";
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b, tk5.d
    public final String getDependency() {
        if (this.f573940c == false) goto L6;
        return "mobile_wiki_newbie_pageTree";
    L6:
        return null;
    }

    public o(boolean r100) {
        this.f573940c = r100;
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(final com.bytedance.ee.bear.document.onboarding.c r100, OnBoardingData r101) {
        final FragmentActivity r102 = r100.getActivity();
        View r103 = r100.f220705g.findMenuView("MORE_OPERATE");
        if (r103 == null) goto L6;
        final uk5.e r104 = new uk5.e(r102.getString(R.string.Doc_Translate_Intro), r103);
        r103.post(new n(r100, r102, r104));
        return true;
    L6:
        return false;
    }
}
