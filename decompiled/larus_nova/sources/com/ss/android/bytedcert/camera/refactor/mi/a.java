package com.ss.android.bytedcert.camera.refactor.mi;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.utils.CertLog;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiSecCamService f407310a;

    /* JADX INFO: renamed from: com.ss.android.bytedcert.camera.refactor.mi.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC4708a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f407311a;

        public ServiceConnectionC4708a(a r100) {
            this.f407311a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            CertLog.e("MiSecCameraService", "onServiceDisconnected:" + r100);
            MiSecCamService r101 = this.f407311a.f407310a;
            r101.f407304b = null;
            r101.f407306d = MiSecCamService.Status.DISCONNECTED;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            CertLog.i("MiSecCameraService", "onServiceConnected:" + r101);
            this.f407311a.f407310a.f407304b = IMiSecCamService.Stub.asInterface(r101);
            this.f407311a.f407310a.f407306d = MiSecCamService.Status.CONNECTED;
        }
    }

    public final void a() {
        Intent r100 = new Intent();     // Catch: Throwable -> L4
        r100.setAction("com.xiaomi.trustservice.secmedia.MiSecCamService");     // Catch: Throwable -> L4
        r100.setPackage("com.xiaomi.trustservice");     // Catch: Throwable -> L4
        MiSecCamService r101 = this.f407310a;     // Catch: Throwable -> L4
        ServiceConnectionC4708a r102 = new ServiceConnectionC4708a(this);     // Catch: Throwable -> L4
        r101.f407305c = r102;     // Catch: Throwable -> L4
        r101.f407303a.bindService(r100, r102, 1);     // Catch: Throwable -> L4
        return;
    L4:
        MiSecCamService r103 = this.f407310a;
        r103.f407306d = MiSecCamService.Status.DISCONNECTED;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(MiSecCamService r100) {
        this.f407310a = r100;
    }
}
