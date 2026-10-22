package com.bytedance.android.shopping.store.home.presenter;

import android.widget.LinearLayout;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public h3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Pair r6 = (Pair) r5;
        ECStoreTabAreaVO r0 = (ECStoreTabAreaVO) this.a.T().getTabArea().getValue();
        if (r0 == null) goto L38;
        List<uj3.j> r1 = r0.b;
        if (r1 == null) goto L39;
        uj3.j r7 = (uj3.j) CollectionsKt.getOrNull(r1, ((Number) r6.getFirst()).intValue());
        if (r7 == null) goto L41;
        ECShopTopBarSearchPresenterV2 r2 = this.a;
        r2.getClass();
        if (r7.f() == true) goto L12;
    L20:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L30;
        ECStoreCollapsibleTextView r4 = r2.u;
        if (r4 == null) goto L26;
        r4.setVisibility(8);
    L26:
        LinearLayout r8 = r2.v;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
    L29:
        r8.setVisibility(0);
        return;
    L30:
        ECStoreCollapsibleTextView r9 = r2.u;
        if (r9 == null) goto L33;
        r9.setVisibility(0);
    L33:
        LinearLayout r10 = r2.v;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("searchSmallAreaView");
    L36:
        r10.setVisibility(8);
        return;
    L12:
        if (r2.T().isMiddleTabFramework() == true) goto L20;
        List<uj3.j> r11 = r7.b;
        if (r11 == null) goto L16;
        int r12 = r11.size();
    L17:
        r3 = true;
        if (r12 <= 1) goto L20;
    L16:
        r12 = 0;
        goto L17
    L41:
        return;
    L39:
        return;
    }
}
