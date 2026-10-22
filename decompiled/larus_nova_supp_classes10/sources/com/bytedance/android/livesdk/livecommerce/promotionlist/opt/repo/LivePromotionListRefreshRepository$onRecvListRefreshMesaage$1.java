package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import si2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LivePromotionListRefreshRepository$onRecvListRefreshMesaage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ d0 $message;
    final /* synthetic */ LivePromotionListRefreshRepository this$0;

    public LivePromotionListRefreshRepository$onRecvListRefreshMesaage$1(LivePromotionListRefreshRepository r1, d0 r2) {
        this.this$0 = r1;
        this.$message = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m983invoke() {
        LivePromotionListRefreshRepository r0 = this.this$0;
        qj2.a r5 = (qj2.a) this.this$0.i.invoke();
        if (r5 == null) goto L5;
        int r6 = r5.a();
    L6:
        r0.b(1, 2, "", true, r6, false, false, false, this.$message, new AnonymousClass1(this));
        if (ECLiveABUtils.INSTANCE.getENABLE_REQUEST_INTERACTION() == false) goto L10;
        this.this$0.g.c("update_product_list_interaction", 1, true, new AnonymousClass2(this));
        return;
    L10:
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m983invoke();
        return Unit.INSTANCE;
    }
}
