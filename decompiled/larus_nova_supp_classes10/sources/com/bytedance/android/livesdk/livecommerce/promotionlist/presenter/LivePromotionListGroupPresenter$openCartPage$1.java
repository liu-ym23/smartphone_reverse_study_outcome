package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LivePromotionListGroupPresenter$openCartPage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef $btmId;
    final /* synthetic */ ECPromotionEntry $entry;
    final /* synthetic */ LivePromotionListGroupPresenter this$0;

    public LivePromotionListGroupPresenter$openCartPage$1(LivePromotionListGroupPresenter r1, ECPromotionEntry r2, Ref.ObjectRef r3) {
        this.this$0 = r1;
        this.$entry = r2;
        this.$btmId = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m997invoke() {
        LivePromotionListGroupPresenter r0 = this.this$0;
        final ECPromotionEntry r1 = this.$entry;
        final Function1<ECPromotionEntry, Unit> r2 = new AnonymousClass1(this);
        int r3 = LivePromotionListGroupPresenter.D;
        r0.getClass();
        if (Intrinsics.areEqual(r1.getShowDisclaimer(), Boolean.TRUE) == false) goto L5;
        hh2.f.b().b(r0.Y().c(), new LivePromotionListGroupPresenter$checkLawHintAndClick$1(r2, r1));
        return;
    L5:
        r2.invoke(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m997invoke();
        return Unit.INSTANCE;
    }
}
