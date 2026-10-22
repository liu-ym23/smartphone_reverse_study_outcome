package ct1;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements LiveNetworkBroadcastReceiver.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f465311a;

    public d(b r100) {
        this.f465311a = r100;
    }

    @Override // com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver.a
    public final void a(NetworkUtils.NetworkType r100) {
        if (r100 != NetworkUtils.NetworkType.NONE) goto L8;
        b.CountDownTimerC5582b r101 = this.f465311a.f465300c;
        if (r101 == null) goto L7;
        r101.cancel();
    L7:
        this.f465311a.f465301d = 2;
        return;
    L8:
        b r102 = this.f465311a;
        r102.a(r102.f465299b);
    }
}
