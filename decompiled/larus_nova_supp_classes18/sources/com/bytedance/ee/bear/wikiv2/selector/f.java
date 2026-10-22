package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends BaseTitleBar.c {
    public final /* synthetic */ e k;

    @Override // com.bytedance.ee.bear.widgets.BaseTitleBar.b, com.bytedance.ee.bear.widgets.BaseTitleBar.a
    public final void performAction(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        tt5.a.h("FolderSelectView", "on create click.");
        m.a r3 = (m.a) ((com.larksuite.framework.mvp.a) this.k).a;
        if (r3 == null) goto L6;
        r3.M7();
        return;
    }

    public f(e r1, int r2) {
        this.k = r1;
        super(r2);
    }
}
