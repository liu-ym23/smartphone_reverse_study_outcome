package l02;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f506850a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r100) {
    }

    public a(b r100) {
        this.f506850a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f506850a.f506851a.remove(Long.valueOf(r100));
    }
}
