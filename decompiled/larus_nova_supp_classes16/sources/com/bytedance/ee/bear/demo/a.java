package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements nc5.a<DocumentListInfo> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public a(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.a.C1("children failure: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "children failure", r4);
    }

    public final void onSuccess(Object r4) {
        DocumentListInfo r5 = (DocumentListInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "documentListInfo");
        this.a.q = r5.isHasMore();
        this.a.p = r5.getLastLabel();
        this.a.C1("children success: documentListInfo:" + r5 + " size=" + r5.getDocumentList().size() + ", hasMore=" + this.a.q + ", lastLabel=" + this.a.p + '\n');
    }
}
