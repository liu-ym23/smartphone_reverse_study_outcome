package dq2;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodel.j f469652a;

    @Override // dq2.e
    public final int getScene() {
        return this.f469652a.f114798a;
    }

    public u(com.bytedance.android.livesdk.chatroom.viewmodel.j r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f469652a = r100;
    }
}
