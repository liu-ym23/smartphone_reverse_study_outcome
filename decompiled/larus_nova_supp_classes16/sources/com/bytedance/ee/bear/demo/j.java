package com.bytedance.ee.bear.demo;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements ut5.a<DocPermission> {
    public final /* synthetic */ CCMFolderDemoActivity a;

    public j(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    public final void onResult(Object r4) {
        DocPermission r5 = (DocPermission) r4;
        if (r5 != null) goto L5;
        this.a.C1("fetchDocPermission success: result=null\n");
        return;
    L5:
        this.a.C1("fetchDocPermission success: userPerm=" + r5.a + ", publicPerm=" + r5.b + '\n');
    }

    public final void onError(int r4, Throwable r5) {
        CCMFolderDemoActivity r0 = this.a;
        StringBuilder r1 = new StringBuilder("fetchDocPermission error: code=");
        r1.append(r4);
        r1.append(", msg=");
        if (r5 == null) goto L5;
        String r6 = r5.getMessage();
    L6:
        r1.append(r6);
        r1.append('\n');
        r0.C1(r1.toString());
        Log.e("CCMFolderDemo", "fetchDocPermission error", r5);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
