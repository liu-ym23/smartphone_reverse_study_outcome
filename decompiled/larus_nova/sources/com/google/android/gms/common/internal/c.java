package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes23.dex */
public abstract class c extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f274533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f274534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient f274535f;

    @Override // com.google.android.gms.common.internal.i
    public final void b() {
    }

    public abstract void e(ConnectionResult r100);

    public abstract boolean f();

    @Override // com.google.android.gms.common.internal.i
    public final /* bridge */ /* synthetic */ void a() {
        PendingIntent r100 = null;
        if (this.f274533d == 0) goto L5;
        BaseGmsClient.zzi(this.f274535f, 1, null);
        Bundle r101 = this.f274534e;
        if (r101 == null) goto L11;
        r100 = (PendingIntent) r101.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
    L11:
        e(new ConnectionResult(this.f274533d, r100));
        return;
    L5:
        if (f() == true) goto L13;
        BaseGmsClient.zzi(this.f274535f, 1, null);
        e(new ConnectionResult(8, null));
        return;
    }

    public c(BaseGmsClient r100, int r101, Bundle r102) {
        this.f274535f = r100;
        super(r100, Boolean.TRUE);
        this.f274533d = r101;
        this.f274534e = r102;
    }
}
