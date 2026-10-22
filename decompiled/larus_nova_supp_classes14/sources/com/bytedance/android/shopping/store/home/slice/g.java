package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends com.bytedance.android.shopping.store.slicecard.e {
    public final /* synthetic */ Function2 e;

    @Override // com.bytedance.android.shopping.store.slicecard.e
    public final void e(IAction r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        this.e.invoke(r2, r3);
    }

    public g(Function2 r1, ECStoreViewModel r2, QContext r3) {
        this.e = r1;
        super(r2, r3);
    }
}
