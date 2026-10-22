package com.bytedance.ee.bear.document.ai.citation;

import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ Citation a;
    public final /* synthetic */ DocAICitationFragment b;

    public a(Citation r1, DocAICitationFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("DocAICitationFragment", "onClick: click type: " + this.a.getUrlType());
        DocAICitationViewModel r3 = this.b.k;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        r3.onCitationClick(this.a);
    }
}
