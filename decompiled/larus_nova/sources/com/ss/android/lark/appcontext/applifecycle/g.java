package com.ss.android.lark.appcontext.applifecycle;

import android.app.Application;
import android.database.ContentObserver;
import android.os.Handler;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class g extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f408838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppLifecycle f408839b;

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        y.a r101 = this.f408839b.d(this.f408838a);
        Log.i("AppLifecycle", "receive process front change, topProc:" + r101.f408858a + "，appFront:" + r101.f408860c);
        AppLifecycle r102 = this.f408839b;
        r102.i(r102.f408787j, r101);
    }

    public g(AppLifecycle r100, Handler r101, Application r102) {
        this.f408839b = r100;
        this.f408838a = r102;
        super(r101);
    }
}
