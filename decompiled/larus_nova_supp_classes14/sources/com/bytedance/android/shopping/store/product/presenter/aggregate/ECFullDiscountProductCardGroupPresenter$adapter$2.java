package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/shopping/store/product/presenter/aggregate/ECFullDiscountProductCardGroupPresenter$adapter$2$1", "invoke", "()Lcom/bytedance/android/shopping/store/product/presenter/aggregate/ECFullDiscountProductCardGroupPresenter$adapter$2$1;"}, k = 3, mv = {1, 4, 3})
public final class ECFullDiscountProductCardGroupPresenter$adapter$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ ECFullDiscountProductCardGroupPresenter this$0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.product.presenter.aggregate.ECFullDiscountProductCardGroupPresenter$adapter$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BaseAggregateDoubleCardViewModelAdapter {
        public final /* synthetic */ ECFullDiscountProductCardGroupPresenter$adapter$2 d;

        @Override // com.bytedance.android.shopping.store.product.presenter.aggregate.d
        public final Function3<String, String, Long, Unit> b() {
            return new ECFullDiscountProductCardGroupPresenter$adapter$2$1$cartListener$1(this);
        }

        @Override // com.bytedance.android.shopping.store.product.presenter.aggregate.d
        public final Function1<Integer, Unit> e() {
            return new ECFullDiscountProductCardGroupPresenter$adapter$2$1$addCartListener$1(this);
        }

        public AnonymousClass1(ECFullDiscountProductCardGroupPresenter$adapter$2 r1, ShopAggregatePageProductViewModel r2) {
            this.d = r1;
            super(r2);
        }
    }

    public ECFullDiscountProductCardGroupPresenter$adapter$2(ECFullDiscountProductCardGroupPresenter r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this, ECFullDiscountProductCardGroupPresenter.k0(this.this$0));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m299invoke() {
        return invoke();
    }
}
