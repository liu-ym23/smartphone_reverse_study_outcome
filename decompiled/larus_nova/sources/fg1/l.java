package fg1;

import com.bytedance.android.live.broadcast.api.scope.RequireService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@RequireService({j00.a.class})
public final class l implements s00.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d f476816a;

    @Override // s00.c
    public final void run() {
        com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100 = this.f476816a;
        if (r100 != null) goto L5;
        com.bytedance.android.live.broadcast.api.scope.service.e r101 = null;
    L6:
        j00.a r102 = (j00.a) r101;
        if (r102 == null) goto L10;
        r102.showInteractionFragment();
        return;
    L10:
        return;
    L5:
        r101 = r100.a(this, j00.a.class);
        goto L6
    }

    @Override // s00.c
    public final r00.a getName() {
        return k.C5896k.f476807a;
    }

    public l(com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f476816a = r100;
    }
}
