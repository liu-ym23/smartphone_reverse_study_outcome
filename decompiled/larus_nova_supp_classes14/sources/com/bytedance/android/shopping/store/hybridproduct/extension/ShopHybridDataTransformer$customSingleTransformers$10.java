package com.bytedance.android.shopping.store.hybridproduct.extension;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ldj3/f;", "p1", "", "p2", "Lej3/e;", "invoke", "(Ldj3/f;Ljava/lang/String;)Lej3/e;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$10 extends FunctionReferenceImpl implements Function2<dj3.f, String, ej3.e> {
    public ShopHybridDataTransformer$customSingleTransformers$10(ej3.e.a r8) {
        super(2, r8, ej3.e.a.class, "transFromDTO", "transFromDTO(Lcom/bytedance/android/shopping/store/hybridproduct/dto/ECShopRecommendWindowEntranceDTO;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/hybridproduct/vo/ECShopRecommendWindowEntranceVO;", 0);
    }

    public final ej3.e invoke(dj3.f r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "p1");
        ((ej3.e.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r1, "dto");
        ej3.e r3 = new ej3.e();
        r3.a = r1.a();
        return r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((dj3.f) r1, (String) r2);
    }
}
