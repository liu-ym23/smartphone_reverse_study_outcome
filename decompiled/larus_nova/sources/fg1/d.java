package fg1;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements s00.c {
    @Override // s00.c
    public final void run() {
        ALogger.i("NormalStartLiveTask", "start normal");
    }

    @Override // s00.c
    public final r00.a getName() {
        return k.d.f476800a;
    }

    public d(com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }
}
