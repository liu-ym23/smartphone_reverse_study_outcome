package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements FolderSelectAdapter.a {
    public final /* synthetic */ e a;

    public j(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.FolderSelectAdapter.a
    public final void a(View r2, int r3, Document r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        tt5.a.h("FolderSelectView", "on item click, position = " + r3);
        m.a r5 = (m.a) ((com.larksuite.framework.mvp.a) this.a).a;
        if (r5 == null) goto L6;
        r5.f3(r3, r4);
        return;
    }
}
