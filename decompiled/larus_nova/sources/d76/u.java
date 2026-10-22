package d76;

import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u implements IMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxAlphaVideo f467287a;

    public u(LynxAlphaVideo r100) {
        this.f467287a = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void a(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f467287a.V("failed when init media player, and player is " + r100 + ", error msg is " + r101 + ' ', this.f467287a.f249709i, -8);
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void monitor(boolean r100, String r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "playerType");
        Intrinsics.checkNotNullParameter(r104, "errorInfo");
        if (r100 == true) goto L6;
        this.f467287a.V("failed when monitor: state = " + r100 + ", playerType = " + r101 + ", what = " + r102 + ", extra = " + r103 + ", errorInfo = " + r104, this.f467287a.f249709i, -9);
        return;
    }
}
