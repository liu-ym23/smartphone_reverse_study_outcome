package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.widget.ECRoundedLinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends m0 {
    public final /* synthetic */ BaseFollowStorePresenter a;

    public j(BaseFollowStorePresenter r1) {
        this.a = r1;
    }

    public final ECLynxCardHolder a(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "context");
        ECRoundedLinearLayout r2 = new ECRoundedLinearLayout(r14, null, 6, 0);
        r2.setOrientation(1);
        r2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ECLynxCardHolder r15 = new ECLynxCardHolder(r2, this.a.d0().getSceneId(), null, null, null, null, "xtab_follow_page", null, true, false, 1404);
        r15.q = this.a.d0().buildInitialData();
        return r15;
    }
}
