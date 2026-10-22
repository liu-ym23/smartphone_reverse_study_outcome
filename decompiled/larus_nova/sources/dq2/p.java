package dq2;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qd0.b f469643a;

    public final boolean a() {
        return ((com.bytedance.android.live.liveinteract.service.f) this.f469643a).P();
    }

    public p(qd0.b r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f469643a = r100;
    }
}
