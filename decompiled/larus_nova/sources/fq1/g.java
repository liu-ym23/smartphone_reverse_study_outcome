package fq1;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d f478403a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final boolean a(LottieAnimationView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lottieView");
        Intrinsics.checkNotNullParameter(r101, "key");
        return this.f478403a.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final String c() {
        return this.f478403a.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void d(py.k r100, Function1<? super Bitmap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onNewResultImpl");
        this.f478403a.d(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void f(HSImageView r100, String r101) {
        this.f478403a.f(r100, r101);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public g(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d r100) {
        Intrinsics.checkNotNullParameter(r100, "replayImageService");
        this.f478403a = r100;
    }
}
