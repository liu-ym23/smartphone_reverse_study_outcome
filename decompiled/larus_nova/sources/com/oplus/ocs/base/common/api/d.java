package com.oplus.ocs.base.common.api;

import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.ConnectionResult;

/* JADX INFO: loaded from: classes34.dex */
class d extends com.oplus.ocs.base.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OnConnectionSucceedListener f404203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    OnConnectionFailedListener f404204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f404205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f404206d;

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        int r101 = r100.what;
        com.oplus.ocs.base.utils.a.a(this.f404205c, "business handler what ".concat(String.valueOf(r101)));
        if (r101 != 100) goto L5;
        OnConnectionSucceedListener r102 = this.f404203a;
        if (r102 == null) goto L16;
        r102.onConnectionSucceed();
    L16:
        Message r103 = Message.obtain();
        r103.what = 5;
        this.f404206d.sendMessage(r103);
        return;
    L5:
        if (r101 != 101) goto L18;
        int r104 = r100.arg1;
        OnConnectionFailedListener r105 = this.f404204b;
        if (r105 == null) goto L11;
        r105.onConnectionFailed(new ConnectionResult(r104));
        return;
    L11:
        Message r106 = Message.obtain();
        r106.what = 5;
        this.f404206d.sendMessage(r106);
        return;
    }

    public d(Looper r100, c r101) {
        super(r100);
        this.f404205c = "d";
        this.f404206d = r101;
    }
}
