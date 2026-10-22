package com.bytedance.kmp.livesdk.gift.platform.effect;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/f;", "p1", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/gift/platform/core/model/f;Lcom/bytedance/android/livesdk/gift/platform/core/model/f;)I", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class GiftEffectQueue$otherGiftMessages$1 extends FunctionReferenceImpl implements Function2<com.bytedance.android.livesdk.gift.platform.core.model.f, com.bytedance.android.livesdk.gift.platform.core.model.f, Integer> {
    public GiftEffectQueue$otherGiftMessages$1(GiftEffectQueue r100) {
        super(2, r100, GiftEffectQueue.class, "compare", "compare(Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftEffectMessage;Lcom/bytedance/android/livesdk/gift/platform/core/model/GiftEffectMessage;)I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(com.bytedance.android.livesdk.gift.platform.core.model.f r100, com.bytedance.android.livesdk.gift.platform.core.model.f r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        return GiftEffectQueue.a((GiftEffectQueue) this.receiver, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(com.bytedance.android.livesdk.gift.platform.core.model.f r100, com.bytedance.android.livesdk.gift.platform.core.model.f r101) {
        return Integer.valueOf(invoke2(r100, r101));
    }
}
