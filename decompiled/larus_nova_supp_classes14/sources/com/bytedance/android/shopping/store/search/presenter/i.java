package com.bytedance.android.shopping.store.search.presenter;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.widget.flow.FlowLayout;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ FlowLayout a;
    public final /* synthetic */ ShopSearchHotViewPresenter b;
    public final /* synthetic */ FrameLayout c;

    public i(FlowLayout r1, ShopSearchHotViewPresenter r2, FrameLayout r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r7) {
        this.a.removeAllViews();
        Iterator<T> r8 = ((List) r7).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        final SearchSuggestWord r0 = (SearchSuggestWord) r8.next();
        FlowLayout r1 = this.a;
        ShopSearchHotViewPresenter r2 = this.b;
        int r3 = ShopSearchHotViewPresenter.l;
        r2.getClass();
        final int r4 = (((k1.l() - (ExtensionsKt.a(16) * 2)) - ExtensionsKt.a(16)) / 2) - (ExtensionsKt.a(10) * 2);
        r1.addView(r2.G(r0, new ShopSearchHotViewPresenter$adjustItemViewUIForFlowLayout$1(r0, r4)));
        goto L4
    L6:
        FlowLayout r9 = this.a;
        Function1<View, Unit> r5 = new ShopSearchHotViewPresenter$initHotWordsContainerFlowLayout$$inlined$let$lambda$1$1(this);
        Intrinsics.checkNotNullParameter(r9, "$this$doNextLayout");
        Intrinsics.checkNotNullParameter(r5, "action");
        r9.addOnLayoutChangeListener(new com.bytedance.android.ec.store.common.uiext.d(r9, r5));
    }
}
