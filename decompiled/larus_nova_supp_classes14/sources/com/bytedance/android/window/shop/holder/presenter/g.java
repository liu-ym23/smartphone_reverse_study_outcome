package com.bytedance.android.window.shop.holder.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.repository.dto.z;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ z a;
    public final /* synthetic */ WindowHeaderAuthorInfoItemPresenter b;

    public g(z r1, WindowHeaderAuthorInfoItemPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        com.bytedance.android.ec.sdk.helper.p r5 = com.bytedance.android.ec.sdk.helper.p.a;
        WindowHeaderAuthorInfoItemPresenter r0 = this.b;
        int r1 = WindowHeaderAuthorInfoItemPresenter.q;
        QContext r2 = r0.Y();
        Context r3 = l0.c(r2.c());
        if ((r3 instanceof FragmentActivity) == true) goto L5;
        r3 = null;
    L5:
        if (r3 != null) goto L7;
        r3 = r2.a();
    L7:
        r5.openSchema(r3, this.a.c());
    }
}
