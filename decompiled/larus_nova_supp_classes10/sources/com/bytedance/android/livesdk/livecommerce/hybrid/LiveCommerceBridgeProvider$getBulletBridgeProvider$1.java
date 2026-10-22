package com.bytedance.android.livesdk.livecommerce.hybrid;

import com.bytedance.android.livesdk.livecommerce.hybrid.bridges.PurchasingIntentionActionMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/PurchasingIntentionActionMethod;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveCommerceBridgeProvider$getBulletBridgeProvider$1 extends Lambda implements Function0<List<? extends PurchasingIntentionActionMethod>> {
    public static final LiveCommerceBridgeProvider$getBulletBridgeProvider$1 INSTANCE = null;

    static {
        INSTANCE = new LiveCommerceBridgeProvider$getBulletBridgeProvider$1();
    }

    public LiveCommerceBridgeProvider$getBulletBridgeProvider$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<PurchasingIntentionActionMethod> m682invoke() {
        return CollectionsKt.listOf(new PurchasingIntentionActionMethod());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m682invoke();
    }
}
