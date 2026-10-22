package com.bytedance.ee.bear.lark.selector;

import android.content.Intent;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends IActionTitlebar$TextAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocsConfirmView f227513a;

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        DocsConfirmView r101 = this.f227513a;
        com.bytedance.ee.bear.lark.selector.base.b r102 = r101.f227475a;
        List<DocSelectorViewData> r103 = r101.f227477c.getItems();
        DocConfirmActivity.a r104 = (DocConfirmActivity.a) r102;
        r104.getClass();
        Intent r105 = new Intent();
        r105.putExtra("result_confirm_data", new ArrayList(r103));
        r104.f227454a.setResult(-1, r105);
        r104.f227454a.finish();
    }

    public f(DocsConfirmView r100, String r101) {
        this.f227513a = r100;
        super(r101, R.color.lkui_B500);
    }
}
