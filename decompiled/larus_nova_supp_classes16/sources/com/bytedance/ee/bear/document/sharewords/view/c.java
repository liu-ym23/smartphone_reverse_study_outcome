package com.bytedance.ee.bear.document.sharewords.view;

import android.app.Activity;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.document.sharewords.g.b {
    public final /* synthetic */ CCMShareWordsEnhancedView a;
    public final /* synthetic */ Activity b;

    public c(CCMShareWordsEnhancedView r1, Activity r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.document.sharewords.g.b
    public final void a(ShareWordsThumbnailResponse r7, long r8) {
        if (r7 != null) goto L5;
        CCMShareWordsEnhancedView r9 = this.a;
        CCMShareWordsEnhancedView.a r10 = CCMShareWordsEnhancedView.CREATOR;
        r9.b();
        return;
    L5:
        long r4 = System.currentTimeMillis();
        this.a.p.b("IMAGE_URL_SUCCESS", r8, r4);
        this.a.d();
        this.a.c(this.b, r7, r8);
    }
}
