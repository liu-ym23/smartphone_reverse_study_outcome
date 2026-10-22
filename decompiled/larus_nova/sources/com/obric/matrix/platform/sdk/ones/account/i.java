package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i implements cka.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f396952b;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f396953a;

        public a(i r100) {
            this.f396953a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, final Intent r101) {
            this.f396953a.d(new h(this, r101));
        }
    }

    public abstract void d(Runnable r100);

    @Override // cka.a
    public void a() {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountLogin");
    }

    @Override // cka.a
    public void b() {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountInfoUpdate");
    }

    public i() {
        this.f396952b = new a(this);
        this.f396951a = AppGlobals.a();
    }

    @Override // cka.a
    public void c(int r100) {
        dka.a.a("AccountSDK_SecureAccountStatusListener", "onAccountLogout logoutScene = " + r100);
    }
}
