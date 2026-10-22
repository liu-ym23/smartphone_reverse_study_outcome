package com.bytedance.ee.bear.document.render.node;

import android.os.Bundle;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements x2.b {
    public final /* synthetic */ e a;

    @Override // com.bytedance.ee.bear.document.x2.b
    public final /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r1, Throwable r2) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadStart() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final /* synthetic */ void onSSRLoadSuccess() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
        tt5.a.h("OfflineCreateNode", "remove offline_create_markdown");
        Bundle r0 = this.a.getPluginHost().getFragment().getArguments();
        if (r0 == null) goto L6;
        r0.remove("offline_create_markdown");
        return;
    }

    public i(DocumentLoaderV3 r1) {
        this.a = r1;
    }
}
