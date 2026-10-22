package com.bytedance.ee.bear.document.sharewords.view;

import android.view.View;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMShareWordsEnhancedView f221835a;

    public f(CCMShareWordsEnhancedView r100) {
        this.f221835a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ShareWordsThumbnailRequest r101 = this.f221835a.f221804a;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == true) goto L10;
        Toast.showText(r100.getContext(), R.string.LarkCCM_Docs_FwdSectionAndCmt_NoCmtPerm_Toast);
        return;
    L10:
        return;
    L5:
        if (r101.f221790d != true) goto L7;
        r102 = true;
        goto L7
    }
}
