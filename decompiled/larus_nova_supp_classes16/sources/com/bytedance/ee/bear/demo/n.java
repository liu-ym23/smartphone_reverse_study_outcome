package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements nd5.b {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public n(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void a(nd5.c r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        this.a.C1("hasModifiedLinkShare=" + r5.hasModifiedLinkShare() + ' ');
        this.a.C1("isLinkShareClose=" + r5.isLinkShareClose() + ' ');
        this.a.C1("isLinkShareAnyoneRead=" + r5.isLinkShareAnyoneRead() + '\n');
    }

    public final void onError(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        this.a.C1("query permission error: " + r4.getMessage() + '\n');
    }
}
