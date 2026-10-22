package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements nc5.a<DocumentListInfo> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public c(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        this.a.C1("createObject failure: " + r4.getLocalizedMessage() + '\n');
        Log.e("CCMFolderDemo", "createObject failure", r4);
    }

    public final void onSuccess(Object r4) {
        DocumentListInfo r5 = (DocumentListInfo) r4;
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        CCMFolderDemoActivity r0 = this.a;
        StringBuilder r1 = new StringBuilder("createObject success: code=");
        r1.append(r5.code);
        r1.append(", msg=");
        r1.append(r5.msg);
        r1.append(", size=");
        ArrayList r2 = r5.getDocumentList();
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r1.append(", hasMore=");
        r1.append(r5.isHasMore());
        r1.append(", lastLabel=");
        r1.append(r5.getLastLabel());
        r1.append('\n');
        r0.C1(r1.toString());
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
