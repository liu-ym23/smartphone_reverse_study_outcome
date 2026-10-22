package com.douyin.janna.platform;

import com.oplus.ocs.base.common.ConnectionResult;
import com.oplus.ocs.base.common.api.OnConnectionFailedListener;

/* JADX INFO: loaded from: classes22.dex */
public final class h implements OnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f273621a;

    public h(i r100) {
        this.f273621a = r100;
    }

    @Override // com.oplus.ocs.base.common.api.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult r100) {
        i r101 = this.f273621a;
        r101.f273624o = r100.getErrorCode();
        this.f273621a.f273600c = false;
        int r102 = this.f273621a.f273624o;
        boolean r103 = hq7.a.f486512a;
    }
}
