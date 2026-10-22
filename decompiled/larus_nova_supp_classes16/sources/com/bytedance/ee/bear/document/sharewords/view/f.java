package com.bytedance.ee.bear.document.sharewords.view;

import android.view.View;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailRequest;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ CCMShareWordsEnhancedView a;

    public f(CCMShareWordsEnhancedView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ShareWordsThumbnailRequest r0 = this.a.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L10;
        Toast.showText(r4.getContext(), 2131889074);
        return;
    L10:
        return;
    L5:
        if (r0.d != true) goto L7;
        r1 = true;
        goto L7
    }
}
