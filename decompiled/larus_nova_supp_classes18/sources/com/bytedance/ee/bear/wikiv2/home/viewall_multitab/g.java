package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ WikiSpaceListView a;

    public g(WikiSpaceListView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        WikiSpaceListView r0 = this.a;
        Intrinsics.checkNotNull((Throwable) r4);
        WikiSpaceListViewModel r5 = r0.f;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L6:
        if (r5.hasData() == false) goto L9;
    L12:
        this.a.getContentViewFromXml().s();
        return;
    L9:
        if (r0.getLoadingViewFromXml().getVisibility() != 0) goto L11;
        r0.getLoadingViewFromXml().setVisibility(8);
    L11:
        r0.getContentViewFromXml().setVisibility(8);
        r0.getEmptyViewFromXml().setImageRes(2131232542);
        r0.getEmptyViewFromXml().setDesc(r0.getContext().getString(2131888336));
        r0.getEmptyViewFromXml().setVisibility(0);
        goto L12
    }
}
