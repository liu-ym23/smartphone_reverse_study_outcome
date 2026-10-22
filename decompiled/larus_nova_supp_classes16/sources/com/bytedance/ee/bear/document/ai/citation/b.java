package com.bytedance.ee.bear.document.ai.citation;

import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ DocAICitationFragment a;

    public b(DocAICitationFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        DocAICitationFragment r3 = this.a;
        if (r3.q != null) goto L6;
        Log.i("DocAICitationFragment", "clickDeleteCitation: data is null");
        return;
    L6:
        DocAICitationViewModel r4 = r3.k;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L9:
        r4.onDeleteClick();
    }
}
