package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"resetListVisibility", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePromotionListGroupPresenter$initListOpenArea$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LivePromotionListGroupPresenter this$0;

    public LivePromotionListGroupPresenter$initListOpenArea$2(LivePromotionListGroupPresenter r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m996invoke() {
        com.bytedance.android.ec.core.arch.event.c.d(this.this$0.d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d("list_with_tab_banner", true, true));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m996invoke();
        return Unit.INSTANCE;
    }
}
