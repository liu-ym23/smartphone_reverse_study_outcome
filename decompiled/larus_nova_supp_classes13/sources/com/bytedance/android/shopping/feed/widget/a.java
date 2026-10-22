package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseCardDetailView a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.a$a, reason: collision with other inner class name */
    public static final class C0069a implements ri.a {
        public C0069a() {
        }
    }

    public a(BaseCardDetailView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Activity r5 = ECAppInfoService.e.getCurrentActivity();
        if (r5 == null) goto L13;
        this.a.e();
        com.bytedance.android.ec.sdk.helper.h r0 = com.bytedance.android.ec.sdk.helper.h.a;
        BaseCardHeaderView r1 = this.a.getCardHeaderView();
        if (r1 == null) goto L10;
        VideoProductFeedBanner r2 = r1.getVideoProductFeedBanner();
        if (r2 == null) goto L10;
        String r3 = r2.getCurImageUrl();
        if (r3 == null) goto L10;
    L11:
        r0.a(r5, r3, new C0069a());
        return;
    L10:
        r3 = "";
        goto L11
    }
}
