package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePromotionListRepository$getPromotionsByIds$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $promotionIds;
    final /* synthetic */ int $requestScene;
    final /* synthetic */ LivePromotionListRepository this$0;

    public LivePromotionListRepository$getPromotionsByIds$1(LivePromotionListRepository r1, int r2, List r3) {
        this.this$0 = r1;
        this.$requestScene = r2;
        this.$promotionIds = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1036invoke() {
        this.this$0.L(this.$requestScene, this.$promotionIds);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1036invoke();
        return Unit.INSTANCE;
    }
}
