package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0<T> implements Observer {
    public final /* synthetic */ ECWindowDialogStyleRootPresenter a;
    public final /* synthetic */ LifecycleOwner b;

    public h0(ECWindowDialogStyleRootPresenter r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        Unit r3 = (Unit) r2;
        View r4 = this.a.q;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        this.a.O().getHeaderSubTabsParam().e.d(this.b);
    }
}
