package l20;

import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.live.broadcastgame.xplay.XplayPublishEventService$initEvent$1;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements h10.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f507092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h10.b f507093b;

    public d(e r100, XplayPublishEventService$initEvent$1.a r101) {
        this.f507092a = r100;
        this.f507093b = r101;
    }

    @Override // h10.b
    public final void onSendResult(boolean r100, int r110, String r111, String r112) {
        XplayMonitorSession.f(this.f507092a.f507096c, "receive", Integer.valueOf(r110), r111, null, r112, 8);
        h10.b r101 = this.f507093b;
        if (r101 == null) goto L6;
        r101.onSendResult(r100, r110, r111, r112);
        return;
    }
}
