package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public e0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.E().setToNewPage(false);
        if (com.bytedance.android.shopping.extensions.k.c((String) this.a.E().getSearchContent().a()) == false) goto L6;
        this.a.E().getSearchContent().g("");
        return;
    L6:
        if (this.a.E().getSearchParam().isSplitMode() == false) goto L8;
        Fragment r4 = this.a.u().d().i();
        ECStoreFoldPhoneHelper.f(r4);
        ECStoreFoldPhoneHelper.a(r4);
        return;
    L8:
        QContext r5 = this.a.u();
        FragmentActivity r0 = com.bytedance.android.ec.core.utils.l0.c(r5.c());
        if ((r0 instanceof FragmentActivity) == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L13;
        r0 = r5.a();
    L13:
        r0.finish();
    }
}
