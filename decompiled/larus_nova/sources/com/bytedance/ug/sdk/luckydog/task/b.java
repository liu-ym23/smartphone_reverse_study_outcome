package com.bytedance.ug.sdk.luckydog.task;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f271845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f271846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f271847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f271848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f271849e;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "onServiceDisconnected onCall");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, android.os.Messenger] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        il7.m r102 = AppActivateHelper.f271819a;     // Catch: Throwable -> L8
        AppActivateHelper.g("bind_success", this.f271845a, this.f271846b);     // Catch: Throwable -> L8
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "onServiceConnected onCall");     // Catch: Throwable -> L8
        this.f271847c.element = new Messenger(r101);     // Catch: Throwable -> L8
        AppActivateHelper.f271828j.put(this.f271846b, this);     // Catch: Throwable -> L8
        Bundle r103 = new Bundle();     // Catch: Throwable -> L8
        r103.putString("token", this.f271848d);     // Catch: Throwable -> L8
        r103.putString("exporter_aid", this.f271845a);     // Catch: Throwable -> L8
        Message r104 = Message.obtain(new Handler(Looper.getMainLooper()), 36865, r103);     // Catch: Throwable -> L8
        r104.replyTo = (Messenger) this.f271849e.element;     // Catch: Throwable -> L8
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateHelper", "[" + this.f271845a + "] send token:[" + this.f271848d + "] to [" + this.f271846b + ']');     // Catch: Throwable -> L8
        Messenger r105 = (Messenger) this.f271847c.element;     // Catch: Throwable -> L8
        if (r105 != null) goto L6;
        Intrinsics.throwNpe();     // Catch: Throwable -> L8
    L6:
        r105.send(r104);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        AppActivateHelper.i("onServiceConnected", th);
    }

    public b(String r100, String r101, Ref.ObjectRef r102, String r103, Ref.ObjectRef r104) {
        this.f271845a = r100;
        this.f271846b = r101;
        this.f271847c = r102;
        this.f271848d = r103;
        this.f271849e = r104;
    }
}
