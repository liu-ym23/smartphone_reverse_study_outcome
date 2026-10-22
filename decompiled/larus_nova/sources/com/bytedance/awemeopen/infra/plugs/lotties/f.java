package com.bytedance.awemeopen.infra.plugs.lotties;

import com.airbnb.lottie.LottieComposition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements com.bytedance.awemeopen.servicesapi.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieComposition f198869a;

    @Override // com.bytedance.awemeopen.servicesapi.ui.a
    public final LottieComposition getComposition() {
        return this.f198869a;
    }

    public f(LottieComposition r100) {
        Intrinsics.checkNotNullParameter(r100, "composition");
        this.f198869a = r100;
    }
}
