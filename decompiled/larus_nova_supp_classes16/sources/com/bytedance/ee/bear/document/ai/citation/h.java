package com.bytedance.ee.bear.document.ai.citation;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements DialogInterface.OnDismissListener {
    public final /* synthetic */ DocAICitationFragment a;
    public final /* synthetic */ ShowCitationData b;

    public h(DocAICitationFragment r1, ShowCitationData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r4) {
        Log.i("DocAICitationFragment", "showDeleteDialog -- onDismiss");
        DocAICitationFragment r5 = this.a;
        String r0 = DocAICitationClickType.Close.getType();
        String r1 = this.b.getId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        int r2 = DocAICitationFragment.r;
        r5.fa0(r0, r1);
    }
}
