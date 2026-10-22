package dq2;

import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.revenue.fight.b f469653a;

    public final LinkMicTeamFightInfo a() {
        return (LinkMicTeamFightInfo) this.f469653a.X2();
    }

    public final String b() {
        return this.f469653a.g3();
    }

    public final boolean d() {
        com.bytedance.android.live.liveinteract.revenue.fight.a r100 = this.f469653a.o3();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isFightOnGoing();
    }

    public final boolean e() {
        return this.f469653a.isTeamFightShowing();
    }

    public final boolean f() {
        return this.f469653a.z3();
    }

    public v(com.bytedance.android.live.liveinteract.revenue.fight.b r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f469653a = r100;
    }

    public final int c(long r100) {
        com.bytedance.android.live.liveinteract.revenue.fight.a r101 = this.f469653a.o3();
        if (r101 == null) goto L7;
        com.bytedance.android.live.liveinteract.multiscene.a r102 = r101.getCurrentFightInfo();
        if (r102 == null) goto L7;
        return com.bytedance.android.live.liveinteract.multiscene.b.c(r102, String.valueOf(r100));
    L7:
        return 0;
    }
}
