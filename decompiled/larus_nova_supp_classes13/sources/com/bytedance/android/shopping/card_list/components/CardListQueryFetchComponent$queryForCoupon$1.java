package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import com.bytedance.android.shopping.card_list.dto.MarketingResourceSchemaResponse;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CardListQueryFetchComponent$queryForCoupon$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CardListQueryFetchComponent this$0;

    public static final class a implements Observer<ab3.a> {
        public final /* synthetic */ CardListQueryFetchComponent$queryForCoupon$1 a;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public a(CardListQueryFetchComponent$queryForCoupon$1 r1) {
            this.a = r1;
        }

        public final void onError(Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "e");
            CardListQueryFetchComponent r0 = this.a.this$0;
            int r1 = CardListQueryFetchComponent.x;
            CardListYataMonitorManager r2 = r0.j();
            if (r2 == null) goto L8;
            com.bytedance.android.shopping.card_list.monitor.error.a r3 = r2.e;
            if (r3 == null) goto L9;
            Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r4 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
            r3.b(CardListErrorMonitorType.QUERY_FOR_COUPON_RESPONSE_FAIL, "errorMsg: " + r5 + ".stackTraceToString", null);
            return;
        L9:
            return;
        }

        public final void onNext(Object r3) {
            final ab3.a r4 = (ab3.a) r3;
            Intrinsics.checkNotNullParameter(r4, "t");
            MarketingResourceSchemaResponse r0 = r4.a();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isShow() != true) goto L9;
            com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r1 = com.bytedance.android.shopping.card_list.utils.a.a;
            com.bytedance.android.shopping.card_list.utils.a.b(new CardListQueryFetchComponent$queryForCoupon$1$$special$$inlined$let$lambda$1$1(this, r4));
            return;
        }
    }

    public CardListQueryFetchComponent$queryForCoupon$1(CardListQueryFetchComponent r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m391invoke() {
        Object r0 = ((AndroidYaTaInstance) this.this$0.v.e.c.invoke()).i("growth_marketing_request");
        if (r0 == null) goto L6;
        CardListRepository.INSTANCE.queryForCoupon(this.this$0.w.b, "/cart/marketingResourceSchema", r0).subscribeOn(Schedulers.io()).subscribe(new a(this));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m391invoke();
        return Unit.INSTANCE;
    }
}
