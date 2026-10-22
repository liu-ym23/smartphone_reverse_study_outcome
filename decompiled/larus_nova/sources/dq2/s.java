package dq2;

import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi0.a f469650a;

    public final LinkMicTeamFightInfo a() {
        return (LinkMicTeamFightInfo) this.f469650a.L1();
    }

    public final boolean b() {
        return this.f469650a.isFightShowing();
    }

    public s(xi0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f469650a = r100;
    }
}
