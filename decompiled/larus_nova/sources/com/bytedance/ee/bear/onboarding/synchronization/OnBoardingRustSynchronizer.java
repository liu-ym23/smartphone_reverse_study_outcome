package com.bytedance.ee.bear.onboarding.synchronization;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
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

/* JADX INFO: loaded from: classes18.dex */
public final class OnBoardingRustSynchronizer implements com.bytedance.ee.bear.onboarding.synchronization.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CancelableGetDataCallback<?> f236172a;

    public static final class a {
    }

    static {
    }

    public OnBoardingRustSynchronizer() {
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void dispose() {
        CancelableGetDataCallback<?> r100 = this.f236172a;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void a(final Function1<? super Map<String, Boolean>, Unit> r100, final Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        CancelableGetDataCallback<?> r102 = this.f236172a;
        if (r102 == null) goto L5;
        r102.cancel();
    L5:
        final Function2<Integer, String, Unit> r103 = new OnBoardingRustSynchronizer$fetchOnBoardings$onServerError$1(r101);
        CancelableGetDataCallback<?> r104 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$fetchOnBoardings$callback$1(r100, r103));
        this.f236172a = r104;
        PullProductGuideRequest.Builder r105 = new PullProductGuideRequest.Builder().scene(GuideScene.GUIDE_SCENE_CCM);
        SdkSender.sendPassThroughRequest(Command.PULL_PRODUCT_GUIDE, r105, r104, new d(this));
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void b(String r100, final Function1<? super Boolean, Unit> r101, final Function1<? super Throwable, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "onResult");
        Intrinsics.checkNotNullParameter(r102, LynxVideoManagerLite.EVENT_ON_ERROR);
        CancelableGetDataCallback<?> r103 = this.f236172a;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        final Function2<Integer, String, Unit> r104 = new OnBoardingRustSynchronizer$syncUpdateToRemote$onServerError$1(r102);
        CancelableGetDataCallback<?> r105 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$syncUpdateToRemote$callback$1(r101, r104));
        this.f236172a = r105;
        PostUserConsumingGuideRequest.Builder r106 = new PostUserConsumingGuideRequest.Builder().keys(CollectionsKt.listOf(r100));
        SdkSender.sendPassThroughRequest(Command.POST_USER_CONSUMING_GUIDE_REQUEST, r106, r105, e.f236184a);
    }

    @Override // com.bytedance.ee.bear.onboarding.synchronization.a
    public final void c(String r100, final Function1<? super Boolean, Unit> r101, final Function1<? super Throwable, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "onResult");
        Intrinsics.checkNotNullParameter(r102, LynxVideoManagerLite.EVENT_ON_ERROR);
        CancelableGetDataCallback<?> r103 = this.f236172a;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        final Function2<Integer, String, Unit> r104 = new OnBoardingRustSynchronizer$syncDoneToRemote$onServerError$1(r102);
        CancelableGetDataCallback<?> r105 = new CancelableGetDataCallback(new OnBoardingRustSynchronizer$syncDoneToRemote$callback$1(r101, r104));
        this.f236172a = r105;
        PostUserConsumingGuideRequest.Builder r106 = new PostUserConsumingGuideRequest.Builder().keys_done(CollectionsKt.listOf(r100));
        SdkSender.sendPassThroughRequest(Command.POST_USER_CONSUMING_GUIDE_REQUEST, r106, r105, c.f236182a);
    }
}
