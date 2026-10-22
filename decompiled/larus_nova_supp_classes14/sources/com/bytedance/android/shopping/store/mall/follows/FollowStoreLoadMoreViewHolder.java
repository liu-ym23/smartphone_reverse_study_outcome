package com.bytedance.android.shopping.store.mall.follows;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import hj3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreLoadMoreViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowStoreLoadMoreViewHolder extends ECLoadMoreViewHolder {
    public static final /* synthetic */ int q = 0;
    public final QUIManager o;
    public final View p;

    public static final class a {
    }

    static {
    }

    public FollowStoreLoadMoreViewHolder(QUIManager r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.o = r2;
        this.p = r3;
    }

    public final void b4(Object r1, String r2, k.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        this.o.c(b.class, null);
    }
}
