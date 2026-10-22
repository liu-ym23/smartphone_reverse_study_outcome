package xp2;

import com.bytedance.android.live.broadcastgame.api.model.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f564705a;

    @Override // xp2.b
    public final u a() {
        u r100 = this.f564705a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public g(u r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f564705a = r100;
    }
}
