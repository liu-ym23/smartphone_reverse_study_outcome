package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes23.dex */
public final class l extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274548g;

    @Override // com.google.android.gms.common.internal.c
    public final boolean f() {
        BaseGmsClient.a r100 = this.f274548g.zzc;
        BaseGmsClient.b r101 = (BaseGmsClient.b) r100;
        r101.a(ConnectionResult.RESULT_SUCCESS);
        return true;
    }

    @Override // com.google.android.gms.common.internal.c
    public final void e(ConnectionResult r100) {
        if (this.f274548g.enableLocalFallback() == true) goto L5;
    L8:
        ((BaseGmsClient.b) this.f274548g.zzc).a(r100);
        this.f274548g.onConnectionFailed(r100);
        return;
    L5:
        if (BaseGmsClient.zzo(this.f274548g) == false) goto L8;
        BaseGmsClient.zzk(this.f274548g, 16);
    }

    public l(BaseGmsClient r100, int r101) {
        this.f274548g = r100;
        super(r100, r101, null);
    }
}
