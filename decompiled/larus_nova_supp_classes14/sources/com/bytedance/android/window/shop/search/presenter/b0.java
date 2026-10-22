package com.bytedance.android.window.shop.search.presenter;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.l0;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ WindowSearchTitlePresenter a;

    public b0(WindowSearchTitlePresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        WindowSearchTitlePresenter.E(this.a).setToNewPage(false);
        QContext r4 = this.a.u();
        FragmentActivity r0 = l0.c(r4.c());
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        if (r0 != null) goto L7;
        r0 = r4.a();
    L7:
        r0.finish();
    }
}
