package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ DocSelectorViewData a;
    public final /* synthetic */ DocsConfirmAdapter b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.b.remove(this.a);
        DocsConfirmAdapter r5 = this.b;
        DocsConfirmAdapter.a r0 = r5.b;
        if (r0 == null) goto L9;
        int r6 = r5.getItemCount();
        g r1 = (g) r0;
        r1.getClass();
        if (r6 >= 0) goto L7;
        r6 = 0;
    L7:
        r1.a.mTitleBar.setTitle(UIHelper.mustacheFormat(2131892192, "select_count", Integer.toString(r6)));
        return;
    }

    public c(DocsConfirmAdapter r1, DocSelectorViewData r2) {
        this.b = r1;
        this.a = r2;
    }
}
