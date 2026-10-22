package fg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements s00.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d f476796a;

    @Override // s00.c
    public final void run() {
        this.f476796a.i().b(this.f476796a.f105448e);
        this.f476796a.i().start("ShellTask");
    }

    @Override // s00.c
    public final r00.a getName() {
        return k.h.f476804a;
    }

    public j(com.bytedance.android.livesdk.chatroom.broadcast.v2.scene.d r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f476796a = r100;
    }
}
