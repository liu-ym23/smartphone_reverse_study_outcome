package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Document a;
    public final /* synthetic */ FolderSelectAdapter b;

    public b(Document r1, FolderSelectAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        SelectorConfig.CREATOR.getClass();
        WeakReference<td5.a> r4 = SelectorConfig.k;
        if (r4 == null) goto L8;
        td5.a r5 = r4.get();
        if (r5 == null) goto L9;
        r5.b(this.a, this.b.getContext());
        return;
    L9:
        return;
    }
}
