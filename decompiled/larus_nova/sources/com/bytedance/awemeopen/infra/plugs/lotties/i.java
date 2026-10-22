package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements com.bytedance.awemeopen.servicesapi.ui.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieTask<LottieComposition> f198872a;

    public i(LottieTask<LottieComposition> r100) {
        Intrinsics.checkNotNullParameter(r100, "lottieTask");
        this.f198872a = r100;
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i a(AoAnimationLottieView.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = r100.f199006a;
        if ((r101 instanceof LottieListener) == false) goto L7;
        this.f198872a.removeFailureListener((LottieListener) r101);
        return this;
    L7:
        throw new IllegalStateException("listener is not a LottieListener");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i b(AoAnimationLottieView.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r101 = r100.f199006a;
        if ((r101 instanceof LottieListener) == false) goto L7;
        this.f198872a.removeListener((LottieListener) r101);
        return this;
    L7:
        throw new IllegalStateException("listener is not a LottieListener");
    }

    @Override // com.bytedance.awemeopen.servicesapi.ui.c
    public final i c(final AoAnimationLottieView.e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        final Function1<LottieComposition, Unit> r101 = new LottieTaskWrapperImpl$addListener$callback$1(r100);
        this.f198872a.addListener(new g(r101));
        return this;
    }

    public final i d(final AoAnimationLottieView.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        final Function1<Throwable, Unit> r101 = new LottieTaskWrapperImpl$addFailureListener$callback$1(r100);
        r100.f199006a = r101;
        this.f198872a.addFailureListener(new h(r101));
        return this;
    }
}
