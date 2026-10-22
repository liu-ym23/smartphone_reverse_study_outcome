package com.bytedance.android.shopping.mall.feed;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/c;", "jobResult", "", "headerCardTop", "Lorg/json/JSONObject;", "eventParams", "", "invoke", "(Lcom/bytedance/android/shopping/api/mall/c;ILorg/json/JSONObject;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ECMallFeed$FeedLifecycleObserver$onCreate$3 extends Lambda implements Function3<com.bytedance.android.shopping.api.mall.c, Integer, JSONObject, Unit> {
    final /* synthetic */ ECMallFeed.FeedLifecycleObserver this$0;

    public ECMallFeed$FeedLifecycleObserver$onCreate$3(ECMallFeed.FeedLifecycleObserver r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(final com.bytedance.android.shopping.api.mall.c r3, final int r4, final JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "jobResult");
        Intrinsics.checkNotNullParameter(r5, "eventParams");
        ECMallFeed.g0(this.this$0.b, new AnonymousClass1(this, r4, r3, r5));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((com.bytedance.android.shopping.api.mall.c) r1, ((Number) r2).intValue(), (JSONObject) r3);
        return Unit.INSTANCE;
    }
}
