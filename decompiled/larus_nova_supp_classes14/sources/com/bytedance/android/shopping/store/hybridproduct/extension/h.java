package com.bytedance.android.shopping.store.hybridproduct.extension;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.shopping.store.home.ECShopPlayAbilityPlugin;
import com.bytedance.android.shopping.store.home.r;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public h(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        PlayControlStrategy r7 = (PlayControlStrategy) r6;
        ECShopPlayAbilityPlugin r0 = this.a.B;
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullParameter(r7, "playControlStrategy");
        r r1 = r0.a;
        if (r1 == null) goto L7;
        PlayControlStrategy r3 = r1.h;
    L8:
        if (r7 == r3) goto L18;
        if (r1 == null) goto L15;
        r1.e.c();
        RecyclerView r4 = r1.a;
        if (r4 == null) goto L14;
        r4.removeOnScrollListener(r1.d);
    L14:
        r1.a = null;
    L15:
        r r2 = new r(new nn.e(), new on.b(r0.b), r0.d, r7);
        RecyclerView r8 = r0.b;
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        r2.a = r8;
        r8.addOnScrollListener(r2.d);
        Unit r9 = Unit.INSTANCE;
        r0.a = r2;
        return;
    L18:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
