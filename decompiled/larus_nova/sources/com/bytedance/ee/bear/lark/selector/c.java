package com.bytedance.ee.bear.lark.selector;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocSelectorViewData f227510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocsConfirmAdapter f227511b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f227511b.remove(this.f227510a);
        DocsConfirmAdapter r101 = this.f227511b;
        DocsConfirmAdapter.a r102 = r101.f227473b;
        if (r102 == null) goto L9;
        int r103 = r101.getItemCount();
        g r104 = (g) r102;
        r104.getClass();
        if (r103 >= 0) goto L7;
        r103 = 0;
    L7:
        r104.f227514a.mTitleBar.setTitle(UIHelper.mustacheFormat(R.string.Lark_Legacy_SelectedCountHint, "select_count", Integer.toString(r103)));
        return;
    }

    public c(DocsConfirmAdapter r100, DocSelectorViewData r101) {
        this.f227511b = r100;
        this.f227510a = r101;
    }
}
