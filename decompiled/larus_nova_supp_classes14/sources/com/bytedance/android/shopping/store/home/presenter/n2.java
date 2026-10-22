package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n2 extends PanelItem.OnClickListener {
    public final /* synthetic */ Function1 a;

    public n2(Function1 r1) {
        this.a = r1;
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.invoke(r2);
    }
}
