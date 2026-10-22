package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.view.View;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    public d(b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        this.a.a(false, this.b);
        String r6 = this.a.b.getToken();
        int r0 = this.a.b.getType();
        String r1 = this.a.b.getSubType();
        boolean r2 = this.a.b.isWiki();
        String r3 = com.bytedance.ee.bear.share.d.a;
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r1, "subType");
        com.bytedance.ee.bear.share.d.d(r6, r0, r1, r2, "copy_link");
    }
}
