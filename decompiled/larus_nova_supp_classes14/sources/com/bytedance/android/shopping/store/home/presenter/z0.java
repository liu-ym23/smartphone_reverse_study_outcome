package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z0<T> implements Observer {
    public final /* synthetic */ View a;

    public z0(View r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((com.bytedance.android.shopping.store.home.entity.n) r3) == null) goto L6;
        View r4 = this.a;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 1;
        Unit r1 = Unit.INSTANCE;
        r4.setLayoutParams(r0);
        r4.setPadding(0, ExtensionsKt.a(40), 0, 0);
        return;
    }
}
