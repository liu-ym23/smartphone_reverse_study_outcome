package com.bytedance.ee.bear.onboarding.synchronization;

import com.larksuite.framework.callback.CancelableGetDataCallback;
import com.ss.android.lark.pb.guide.GuideScene;
import com.ss.android.lark.pb.guide.PostUserConsumingGuideRequest;
import com.ss.android.lark.pb.guide.PullProductGuideRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OnBoardingRustSynchronizer implements com.bytedance.ee.bear.onboarding.synchronization.a {
    public CancelableGetDataCallback<?> a;

    public static final class a {
    }

    static {
    }

    public OnBoardingRustSynchronizer() {
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void dispose() {
        CancelableGetDataCallback<?> r0 = this.a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void a(final Function1<? super Map<String, Boolean>, Unit> r3, final Function1<? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onResult");
        Intrinsics.checkNotNullParameter(r4, "onError");
        CancelableGetDataCallback<?> r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        final Function2<Integer, String, Unit> r1 = new OnBoardingRustSynchronizer$fetchOnBoardings$onServerError$1(r4);
        CancelableGetDataCallback<?> r5 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$fetchOnBoardings$callback$1(r3, r1));
        this.a = r5;
        PullProductGuideRequest.Builder r6 = new PullProductGuideRequest.Builder().scene(GuideScene.GUIDE_SCENE_CCM);
        SdkSender.sendPassThroughRequest(Command.PULL_PRODUCT_GUIDE, r6, r5, new d(this));
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void b(String r3, final Function1<? super Boolean, Unit> r4, final Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "onResult");
        Intrinsics.checkNotNullParameter(r5, "onError");
        CancelableGetDataCallback<?> r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        final Function2<Integer, String, Unit> r1 = new OnBoardingRustSynchronizer$syncUpdateToRemote$onServerError$1(r5);
        CancelableGetDataCallback<?> r6 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$syncUpdateToRemote$callback$1(r4, r1));
        this.a = r6;
        PostUserConsumingGuideRequest.Builder r7 = new PostUserConsumingGuideRequest.Builder().keys(CollectionsKt.listOf(r3));
        SdkSender.sendPassThroughRequest(Command.POST_USER_CONSUMING_GUIDE_REQUEST, r7, r6, e.a);
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void c(String r3, final Function1<? super Boolean, Unit> r4, final Function1<? super Throwable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "onResult");
        Intrinsics.checkNotNullParameter(r5, "onError");
        CancelableGetDataCallback<?> r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        final Function2<Integer, String, Unit> r1 = new OnBoardingRustSynchronizer$syncDoneToRemote$onServerError$1(r5);
        CancelableGetDataCallback<?> r6 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$syncDoneToRemote$callback$1(r4, r1));
        this.a = r6;
        PostUserConsumingGuideRequest.Builder r7 = new PostUserConsumingGuideRequest.Builder().keys_done(CollectionsKt.listOf(r3));
        SdkSender.sendPassThroughRequest(Command.POST_USER_CONSUMING_GUIDE_REQUEST, r7, r6, c.a);
    }
}
