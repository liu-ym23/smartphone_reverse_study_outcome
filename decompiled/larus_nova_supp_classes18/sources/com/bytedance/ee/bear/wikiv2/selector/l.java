package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ e c;

    public l(e r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        tt5.a.h("FolderSelectView", "on search click.");
        m.a r3 = (m.a) ((com.larksuite.framework.mvp.a) this.c).a;
        if (r3 == null) goto L6;
        r3.p();
        return;
    }
}
