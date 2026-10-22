package com.bytedance.ee.bear.block.jira;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ JiraActionAdapter a;
    public final /* synthetic */ String b;

    public a(JiraActionAdapter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        JiraActionAdapter.b r3 = this.a.d;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r3.a(this.b);
        return;
    }
}
