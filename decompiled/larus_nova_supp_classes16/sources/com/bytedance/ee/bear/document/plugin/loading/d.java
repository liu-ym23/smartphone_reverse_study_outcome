package com.bytedance.ee.bear.document.plugin.loading;

import com.bytedance.ee.bear.document.editionmanager.data.TokenResult;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements c15.a {
    public final /* synthetic */ OfficeLoadingPlugin.b a;
    public final /* synthetic */ OfficeLoadingPlugin b;

    @Override // c15.a
    public final void a(TokenResult r3) {
        OfficeLoadingPlugin.b r0 = this.a;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        OfficeLoadingPlugin.access$setEditionTokenInPath$p(r0.a, r4);
        j.c(new e(r0.a));
        return;
    L5:
        if (r3.getReal_sub_type() != 4) goto L7;
        r4 = true;
        goto L8
    }

    @Override // c15.a
    public final void onFail(int r3) {
        tt5.a.d("LoaddingPlugin", "checkEditionToken failed, code=" + r3);
        OfficeLoadingPlugin.access$setEditionTokenInPath$p(this.b, false);
    }

    public d(OfficeLoadingPlugin.b r1, OfficeLoadingPlugin r2) {
        this.a = r1;
        this.b = r2;
    }
}
