package dq2;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class x implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.viewmodel.e f469656a;

    @Override // dq2.g
    public final u t() {
        return new u(this.f469656a.t());
    }

    public x(com.bytedance.android.livesdk.chatroom.viewmodel.e r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f469656a = r100;
    }
}
