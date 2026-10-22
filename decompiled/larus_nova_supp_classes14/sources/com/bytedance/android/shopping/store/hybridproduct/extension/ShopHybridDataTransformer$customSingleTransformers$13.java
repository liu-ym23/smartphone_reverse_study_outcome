package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.shopping.store.home.entity.Module;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/Module;", "p1", "", "p2", "Luj3/d;", "invoke", "(Lcom/bytedance/android/shopping/store/home/entity/Module;Ljava/lang/String;)Luj3/d;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ShopHybridDataTransformer$customSingleTransformers$13 extends FunctionReferenceImpl implements Function2<Module, String, uj3.d> {
    public ShopHybridDataTransformer$customSingleTransformers$13(uj3.d.a r8) {
        super(2, r8, uj3.d.a.class, "transFromShopMemberModule", "transFromShopMemberModule(Lcom/bytedance/android/shopping/store/home/entity/Module;Ljava/lang/String;)Lcom/bytedance/android/shopping/store/repository/vo/ShopMemberVO;", 0);
    }

    public final uj3.d invoke(Module r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "p1");
        ((uj3.d.a) ((CallableReference) this).receiver).getClass();
        return uj3.d.a.a(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Module) r1, (String) r2);
    }
}
