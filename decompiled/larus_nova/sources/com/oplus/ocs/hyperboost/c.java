package com.oplus.ocs.hyperboost;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.douyin.janna.platform.i;
import com.oplus.ocs.base.common.AuthResult;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f404318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.a.a.a.b f404319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f404320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<com.oplus.ocs.hyperboost.a> f404321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f404322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.a.a.a.a f404323f;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f404325a;

        public a(c r100) {
            this.f404325a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            this.f404325a.f404319b = null;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            c r102 = this.f404325a;
            r102.f404319b = com.a.a.a.b.a.b(r101);
        }
    }

    @Override // com.oplus.ocs.hyperboost.g
    public final boolean a() {
        com.a.a.a.b r100 = this.f404319b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.f404320c == false) goto L18;
        boolean r101 = r100.a();     // Catch: RemoteException -> L11
        boolean r102 = this.f404319b.a(this.f404323f.asBinder());     // Catch: RemoteException -> L11
        if (r101 == false) goto L19;
        if (r102 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L18:
        return false;
    }

    public c() {
        this.f404318a = null;
        this.f404319b = null;
        this.f404320c = false;
        this.f404322e = new a(this);
        this.f404323f = new AnonymousClass2(this);
    }

    @Override // com.oplus.ocs.hyperboost.g
    public final void a(Context r100) {
        this.f404318a = r100;
        Intent r101 = new Intent("com.coloros.gamespace.gamesdk.HyperBoostService");
        r101.setPackage("com.coloros.gamespace");
        Context r102 = this.f404318a;
        if (r102 == null) goto L6;
        "bindService. ret->".concat(String.valueOf(r102.bindService(r101, this.f404322e, 1)));
        return;
    }

    @Override // com.oplus.ocs.hyperboost.g
    public final boolean b(i.a r100) {
        this.f404321d = new WeakReference(r100);
        com.a.a.a.b r101 = this.f404319b;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (this.f404320c == false) goto L18;
        r101.c();     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return true;
    L18:
        return false;
    }

    @Override // com.oplus.ocs.hyperboost.g
    public final void a(AuthResult r100) {
        if (r100.getErrrorCode() != 1001) goto L5;
        boolean r101 = true;
    L6:
        this.f404320c = r101;
        if (r101 == true) goto L10;
        r100.getErrrorCode();
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
