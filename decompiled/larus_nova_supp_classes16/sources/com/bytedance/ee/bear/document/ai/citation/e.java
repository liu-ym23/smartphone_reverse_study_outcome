package com.bytedance.ee.bear.document.ai.citation;

import android.content.DialogInterface;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements DialogInterface.OnClickListener {
    public final /* synthetic */ DocAICitationFragment a;
    public final /* synthetic */ ShowCitationData b;

    public e(DocAICitationFragment r1, ShowCitationData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        Log.i("DocAICitationFragment", "clickDeleteSingle");
        DocAICitationFragment r5 = this.a;
        String r6 = DocAICitationClickType.DeleteCurrent.getType();
        String r0 = this.b.getId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        int r1 = DocAICitationFragment.r;
        r5.fa0(r6, r0);
    }
}
