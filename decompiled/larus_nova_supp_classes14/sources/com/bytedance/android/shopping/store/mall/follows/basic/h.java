package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ BaseFollowStorePresenter a;
    public final /* synthetic */ ECHybridListEngine b;

    public h(BaseFollowStorePresenter r1, ECHybridListEngine r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r11) {
        FollowStoreResponse r12 = (FollowStoreResponse) r11;
        if (r12.isFirstFrame() == false) goto L23;
        ViewExtensionsKt.d(this.b.b);
        HybridListDTO r0 = r12.getHybridList();
        if (r0 == null) goto L18;
        ECHybridListEngine r1 = this.b;
        HybridListDTO.Companion.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r2 = HybridListDTO.a.a(r0);
        if (r12.getInitFetch() == false) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r12.isCache() == false) goto L16;
        String r4 = "cache";
    L17:
        r1.o(r2, r3, r4);
        goto L18
    L16:
        r4 = CommentConstants$CmtLongPanelStrategy.DEFAULT;
        goto L17
    L9:
        if (r12.getRequestAfterCache() == true) goto L12;
        r3 = false;
    L18:
        String r6 = r12.getNoFollowFeedToast();
        if (r12.isCache() == false) goto L21;
        return;
    L21:
        if (com.bytedance.android.shopping.extensions.k.c(r6) == false) goto L28;
        ECToast.showToast$default(ECToast.INSTANCE, this.a.Y().c(), r6, null, 4, null);
        return;
    L28:
        return;
    L23:
        HybridListDTO r13 = r12.getHybridList();
        if (r13 == null) goto L30;
        ECHybridListEngine r5 = this.b;
        HybridListDTO.Companion.getClass();
        r5.c(HybridListDTO.a.a(r13));
        return;
    }
}
