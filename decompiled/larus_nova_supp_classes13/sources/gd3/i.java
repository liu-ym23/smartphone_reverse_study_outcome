package gd3;

import com.bytedance.android.shopping.buynow.di.BuyNowModule_ProvideFactory;
import com.bytedance.android.shopping.card_list.router.CardKitService_ProvideFactory;
import com.bytedance.android.shopping.cart_common.CartModule_ProvideFactory;
import com.bytedance.android.shopping.collect.service.CollectModule_ProvideFactory;
import com.bytedance.android.shopping.di.AnchorModule_ProvideAnchorV3StoreServiceFactory;
import com.bytedance.android.shopping.di.AnchorModule_ProvideBridgeProviderInnerServiceFactory;
import com.bytedance.android.shopping.di.AnchorModule_ProvideFactory;
import com.bytedance.android.shopping.di.BoughtModuleFallback_ProvideFactory;
import com.bytedance.android.shopping.di.MallModule_ProvideFactory;
import com.bytedance.android.shopping.di.VisualModuleFallback_ProvideFactory;
import com.bytedance.android.shopping.orderlist.common.di.OrderListModule_ProvideFactory;
import com.bytedance.android.shopping.sku.inner.service.SkuYataModule_ProvideFactory;
import com.bytedance.android.shopping.yata.di.ECYataModule_ProvideFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public Provider<g33.e> a;
    public Provider<p83.d> b;
    public Provider<p83.e> c;
    public Provider<n83.i> d;
    public Provider<n83.g> e;
    public Provider<sc3.c> f;
    public Provider<sc3.e> g;
    public Provider<sc3.d> h;
    public Provider<sc3.g> i;
    public Provider<sc3.h> j;
    public Provider<sc3.i> k;
    public Provider<sc3.j> l;
    public Provider<n83.h> m;

    public static final class a {
        public gd3.a a;
        public p b;
        public d c;
        public oa3.a d;
        public com.bytedance.android.shopping.cart_common.a e;
        public com.bytedance.android.shopping.card_list.router.a f;
        public rb3.a g;
        public fg3.a h;
        public qh3.b i;
        public ml3.a j;
        public j k;

        public a() {
        }
    }

    public i(a r2) {
        this.a = DoubleCheck.provider(AnchorModule_ProvideBridgeProviderInnerServiceFactory.create(r2.a));
        this.b = DoubleCheck.provider(AnchorModule_ProvideFactory.create(r2.a));
        this.c = DoubleCheck.provider(AnchorModule_ProvideAnchorV3StoreServiceFactory.create(r2.a));
        this.d = DoubleCheck.provider(VisualModuleFallback_ProvideFactory.create(r2.b));
        this.e = DoubleCheck.provider(BoughtModuleFallback_ProvideFactory.create(r2.c));
        this.f = DoubleCheck.provider(BuyNowModule_ProvideFactory.create(r2.d));
        this.g = DoubleCheck.provider(CartModule_ProvideFactory.create(r2.e));
        this.h = DoubleCheck.provider(CardKitService_ProvideFactory.create(r2.f));
        this.i = DoubleCheck.provider(CollectModule_ProvideFactory.create(r2.g));
        this.j = DoubleCheck.provider(OrderListModule_ProvideFactory.create(r2.h));
        this.k = DoubleCheck.provider(SkuYataModule_ProvideFactory.create(r2.i));
        this.l = DoubleCheck.provider(ECYataModule_ProvideFactory.create(r2.j));
        this.m = DoubleCheck.provider(MallModule_ProvideFactory.create(r2.k));
    }
}
