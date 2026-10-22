package com.hihonor.push.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.hihonor.push.sdk.common.data.DownMsgType;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.lang.ref.WeakReference;
import ww7.c;
import ww7.c0;
import ww7.e;
import ww7.f;
import ww7.f0;
import ww7.i0;
import ww7.m0;
import ww7.n;
import ww7.z0;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HonorMessageService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f276679b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Messenger f276680a;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<HonorMessageService> f276681a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            HonorMessageService r101 = this.f276681a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            Bundle r102 = r100.getData();
            if (r102 == null) goto L9;
            Intent r103 = new Intent();
            r103.putExtras(r102);
            int r104 = HonorMessageService.f276679b;
            r101.a(r103);
            return;
        }

        public a(Looper r100, HonorMessageService r101) {
            super(r100);
            this.f276681a = new WeakReference(r101);
        }
    }

    public void b(c r100) {
    }

    public void c(String r100) {
    }

    public HonorMessageService() {
        this.f276680a = new Messenger(new a(Looper.getMainLooper(), this));
    }

    public final void a(Intent r100) {
    L15:
        e = move-exception;
        e.getMessage();
        return;
    L3:
        if (TextUtils.equals(r100.getStringExtra("event_type"), DownMsgType.RECEIVE_TOKEN) == false) goto L8;
        String r101 = r100.getStringExtra("push_token");     // Catch: Exception -> L15
        Context r102 = c0.f561643e.a();     // Catch: Exception -> L15
        n r103 = n.f561683b;     // Catch: Exception -> L15
        if (TextUtils.equals(r101, r103.b(r102)) == true) goto L7;
        r103.a(r102, r101);     // Catch: Exception -> L15
    L7:
        c(r101);     // Catch: Exception -> L15
        return;
    L8:
        i0 r104 = new i0(r100);     // Catch: Exception -> L15
        PThreadPoolExecutor r105 = ww7.h0.f561662c.f561664b;     // Catch: Exception -> L15
        f0 r106 = new f0();     // Catch: Exception -> L15
        r105.execute(new z0(r106, r104));     // Catch: Exception -> L11
    L13:
        e r107 = r106.f561656a;     // Catch: Exception -> L15
        f r108 = new f(this);     // Catch: Exception -> L15
        r107.getClass();     // Catch: Exception -> L15
        r107.b(new m0(ww7.h0.f561662c.f561663a, r108));     // Catch: Exception -> L15
        return;
    L11:
        e = move-exception;
        r106.a(e);     // Catch: Exception -> L15
        goto L13
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return this.f276680a.getBinder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        super.onStartCommand(r100, r101, r102);
        a(r100);
        return 2;
    }
}
