package xp2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.openplatform.c f564706a;

    public h(com.bytedance.android.live.broadcastgame.api.openplatform.c r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f564706a = r100;
    }

    @Override // xp2.c
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) this.f564706a.getService(r100);
    }
}
