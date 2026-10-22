package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ ShopSearchTitlePresenter a;

    public d0(ShopSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Fragment r2 = this.a.u().d().i();
        ECStoreFoldPhoneHelper.f(r2);
        ECStoreFoldPhoneHelper.c(r2);
    }
}
