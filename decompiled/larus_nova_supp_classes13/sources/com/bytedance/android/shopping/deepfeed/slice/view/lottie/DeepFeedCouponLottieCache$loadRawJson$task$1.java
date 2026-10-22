package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedCouponLottieCache$loadRawJson$task$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Function1 $onFailure;
    final /* synthetic */ Function1 $onSuccess;
    final /* synthetic */ String $url;

    public DeepFeedCouponLottieCache$loadRawJson$task$1(String r1, Function1 r2, Function1 r3) {
        this.$url = r1;
        this.$onSuccess = r2;
        this.$onFailure = r3;
        super(1);
    }

    public final void invoke(Throwable r4) {
        DeepFeedCouponLottieCache r5 = DeepFeedCouponLottieCache.a;
        final String r0 = this.$url;
        final Function1 r1 = this.$onSuccess;
        Function1 r2 = this.$onFailure;
        r5.getClass();
        int r6 = DeepFeedLottieUrlLoader.a;
        DeepFeedLottieUrlLoader.b(r0, new DeepFeedCouponLottieCache$loadFromRemote$1(r0, r1), r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
