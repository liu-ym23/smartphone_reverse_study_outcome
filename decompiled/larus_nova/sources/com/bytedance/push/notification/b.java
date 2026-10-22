package com.bytedance.push.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f266941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f266943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f266944d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f266945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f266946b;

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        L22:
            return;
        L17:
            if (this.f266945a == false) goto L7;
            b r100 = this.f266946b;     // Catch: Throwable -> L10
            s r101 = r100.f266943c;     // Catch: Throwable -> L10
            String r102 = r100.f266942b;     // Catch: Throwable -> L10
            j r103 = (j) r101;     // Catch: Throwable -> L10
            r103.f266964a.setSound(com.bytedance.push.utils.a.e(r103.f266965b, r102), Notification.AUDIO_ATTRIBUTES_DEFAULT);     // Catch: Throwable -> L10
            i.c r104 = r103.f266967d;     // Catch: Throwable -> L10
            NotificationManager r105 = r103.f266966c;     // Catch: Throwable -> L10
            NotificationChannel r106 = r103.f266964a;     // Catch: Throwable -> L10
            r104.getClass();     // Catch: Throwable -> L10
            r105.createNotificationChannel(r106);     // Catch: Throwable -> L15
        L16:
            return;
        L7:
            j r107 = (j) this.f266946b.f266943c;     // Catch: Throwable -> L10
            i.c r108 = r107.f266967d;     // Catch: Throwable -> L10
            NotificationManager r109 = r107.f266966c;     // Catch: Throwable -> L10
            NotificationChannel r110 = r107.f266964a;     // Catch: Throwable -> L10
            r108.getClass();     // Catch: Throwable -> L10
            r109.createNotificationChannel(r110);     // Catch: Throwable -> L15
        }

        public a(b r100, boolean r101) {
            this.f266946b = r100;
            this.f266945a = r101;
        }
    }

    public final void a() {
        e87.a r100 = this.f266944d.f266947a;
        String r101 = this.f266941a;
        String r102 = this.f266942b;
        ((e87.b) r100).getClass();
        Logger.i("UrlConnectionDownloader", "download url:" + r101 + " targetPath:" + r102);
        boolean r103 = e87.b.a(r101, r102);     // Catch: Throwable -> L5
    L7:
        if (this.f266943c != null) goto L9;
        return;
    L9:
        this.f266944d.f266948b.post(new a(this, r103));
        return;
    L5:
        r103 = false;
        goto L7
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

    public b(c r100, String r101, String r102, j r103) {
        this.f266944d = r100;
        this.f266941a = r101;
        this.f266942b = r102;
        this.f266943c = r103;
    }
}
