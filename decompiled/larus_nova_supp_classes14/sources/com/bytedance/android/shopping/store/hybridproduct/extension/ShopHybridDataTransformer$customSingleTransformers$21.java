package com.bytedance.android.shopping.store.hybridproduct.extension;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "p1", "p2", "Lcom/bytedance/android/ec/store/repository/vo/h;", "invoke", "(Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/store/repository/vo/h;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$21 extends FunctionReferenceImpl implements Function2<String, String, com.bytedance.android.ec.store.repository.vo.h> {
    public ShopHybridDataTransformer$customSingleTransformers$21(com.bytedance.android.ec.store.repository.vo.h.a r8) {
        super(2, r8, com.bytedance.android.ec.store.repository.vo.h.a.class, "transFromRawData", "transFromRawData(Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/store/repository/vo/ECShopMiddleCouponVO;", 0);
    }

    public final com.bytedance.android.ec.store.repository.vo.h invoke(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((com.bytedance.android.ec.store.repository.vo.h.a) ((CallableReference) this).receiver).getClass();
        return com.bytedance.android.ec.store.repository.vo.h.a.a(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (String) r2);
    }
}
