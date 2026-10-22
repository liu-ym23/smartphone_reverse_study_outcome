package xp2;

import com.bytedance.android.live.broadcastgame.api.model.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f564704a;

    @Override // xp2.a
    public final long getGameId() {
        return this.f564704a.p();
    }

    @Override // xp2.a
    public final String getGameName() {
        return this.f564704a.q();
    }

    public f(r r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f564704a = r100;
    }
}
