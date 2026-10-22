package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ FolderSelectAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Document c;

    public c(FolderSelectAdapter r1, int r2, Document r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        FolderSelectAdapter.a r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.a(r4, this.b, this.c);
        return;
    }
}
