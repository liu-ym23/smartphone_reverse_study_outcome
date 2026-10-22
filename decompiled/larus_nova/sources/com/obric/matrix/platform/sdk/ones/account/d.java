package com.obric.matrix.platform.sdk.ones.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d implements cka.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f396930b;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f396931a;

        public a(d r100) {
            this.f396931a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, final Intent r101) {
            d r102 = this.f396931a;
            Runnable r103 = new c(this, r101);
            ((g) r102).getClass();
            Intrinsics.checkNotNullParameter(r103, "runnable");
            g.f396948j.post(r103);
        }
    }

    @Override // cka.a
    public abstract void a();

    @Override // cka.a
    public abstract void b();

    @Override // cka.a
    public abstract void c(int r100);

    public d() {
        this.f396930b = new a(this);
        this.f396929a = AppGlobals.a();
    }
}
