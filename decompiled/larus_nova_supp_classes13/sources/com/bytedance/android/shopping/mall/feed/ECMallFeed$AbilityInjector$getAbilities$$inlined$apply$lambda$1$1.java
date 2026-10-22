package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/ec/hybrid/list/entity/ECHybridListItemVO;", "invoke", "com/bytedance/android/shopping/mall/feed/ECMallFeed$AbilityInjector$getAbilities$12$mitaCardEngineClassToInstance$1$getItemData$1"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$AbilityInjector$getAbilities$$inlined$apply$lambda$1$1 extends Lambda implements Function1<ECHybridListItemVO, Boolean> {
    final /* synthetic */ qj.c $cardInfo;

    public ECMallFeed$AbilityInjector$getAbilities$$inlined$apply$lambda$1$1(qj.c r1) {
        this.$cardInfo = r1;
        super(1);
    }

    public final boolean invoke(ECHybridListItemVO r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.f(), this.$cardInfo.b);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((ECHybridListItemVO) r1));
    }
}
