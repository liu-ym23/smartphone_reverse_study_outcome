package com.bytedance.android.shopping.store.hybridproduct.extension;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ldj3/g;", "p1", "", "p2", "Lej3/f;", "invoke", "(Ldj3/g;Ljava/lang/String;)Lej3/f;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$1 extends FunctionReferenceImpl implements Function2<dj3.g, String, ej3.f> {
    public ShopHybridDataTransformer$customSingleTransformers$1(ej3.f.a r8) {
        super(2, r8, ej3.f.a.class, "transFromDTO", "transFromDTO(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopSortAndDiscountDTO;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/hybridproduct/vo/ECShopSortAndDiscountVO;", 0);
    }

    public final ej3.f invoke(dj3.g r1, String r2) {
        ((ej3.f.a) ((CallableReference) this).receiver).getClass();
        return ej3.f.a.a(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((dj3.g) r1, (String) r2);
    }
}
