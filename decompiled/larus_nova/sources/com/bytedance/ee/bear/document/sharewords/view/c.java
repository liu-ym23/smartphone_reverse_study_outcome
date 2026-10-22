package com.bytedance.ee.bear.document.sharewords.view;

import android.app.Activity;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.document.sharewords.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMShareWordsEnhancedView f221829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f221830b;

    public c(CCMShareWordsEnhancedView r100, Activity r101) {
        this.f221829a = r100;
        this.f221830b = r101;
    }

    @Override // com.bytedance.ee.bear.document.sharewords.g.b
    public final void a(ShareWordsThumbnailResponse r100, long r101) {
        if (r100 != null) goto L5;
        CCMShareWordsEnhancedView r102 = this.f221829a;
        CCMShareWordsEnhancedView.a r103 = CCMShareWordsEnhancedView.CREATOR;
        r102.b();
        return;
    L5:
        long r104 = System.currentTimeMillis();
        this.f221829a.f221819p.b("IMAGE_URL_SUCCESS", r101, r104);
        this.f221829a.d();
        this.f221829a.c(this.f221830b, r100, r101);
    }
}
