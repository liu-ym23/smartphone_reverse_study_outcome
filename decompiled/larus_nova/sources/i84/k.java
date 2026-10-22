package i84;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class k extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f488622a;

    public k(l r100) {
        this.f488622a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        l.f488625d = NetworkUtils.getNetworkType(this.f488622a.f488627a);
        com.bytedance.bdinstall.t.a("NetworkStatusProvider init broadcast receive that network type is " + l.f488625d.name());
    }
}
