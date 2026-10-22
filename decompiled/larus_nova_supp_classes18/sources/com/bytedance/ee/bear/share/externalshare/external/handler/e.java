package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        String r6 = this.a.b.getToken();
        int r0 = this.a.b.getType();
        String r1 = this.a.b.getSubType();
        boolean r2 = this.a.b.isWiki();
        String r3 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r1, "subType");
        com.bytedance.ee.bear.share.d.d(r6, r0, r1, r2, DocFeed$Value$Result.CANCEL);
    }
}
