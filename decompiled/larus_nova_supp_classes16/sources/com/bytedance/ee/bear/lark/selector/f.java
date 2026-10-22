package com.bytedance.ee.bear.lark.selector;

import android.content.Intent;
import android.view.View;
import com.ss.android.lark.ui.IActionTitlebar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends IActionTitlebar.TextAction {
    public final /* synthetic */ DocsConfirmView a;

    public final void performAction(View r4) {
        DocsConfirmView r5 = this.a;
        com.bytedance.ee.bear.lark.selector.base.b r0 = r5.a;
        List r6 = r5.c.getItems();
        DocConfirmActivity.a r1 = (DocConfirmActivity.a) r0;
        r1.getClass();
        Intent r2 = new Intent();
        r2.putExtra("result_confirm_data", new ArrayList(r6));
        r1.a.setResult(-1, r2);
        r1.a.finish();
    }

    public f(DocsConfirmView r1, String r2) {
        this.a = r1;
        super(r2, 2131103404);
    }
}
