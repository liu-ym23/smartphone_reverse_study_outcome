package com.bytedance.helios.consumer;

import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import hz5.k;
import hz5.l;
import java.util.concurrent.ConcurrentLinkedQueue;
import jz5.h;
import jz5.i;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f245423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f245424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f245425c;

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f245426a;

        public a(e r100) {
            this.f245426a = r100;
        }

        @Override // jz5.i
        public final void a(boolean r100, String r101, String r102) {
            if (r100 == false) goto L12;
            Lazy r103 = LogUploader.f245402a;
            LogUploader.f245403b = this.f245426a.f245425c;
            h r104 = LogUploader.c();
            if (r104 == null) goto L6;
            r104.putLong("alog_last_upload_time", LogUploader.f245403b);
        L6:
            h r105 = LogUploader.c();
            if (r105 == null) goto L9;
            r105.remove("alog_last_request_start_time");
        L9:
            h r106 = LogUploader.c();
            if (r106 == null) goto L14;
            r106.remove("alog_last_request_end_time");
            return;
        L14:
            return;
        L12:
            Lazy r107 = LogUploader.f245402a;
            l.b(LogUploader.b(r101, r102));
        }
    }

    public final void a() {
        ConcurrentLinkedQueue<c.a> r100 = c.f245413a;
        if (c.b() == true) goto L15;
        k.d("ALogUploader", "tryAgain:-103");
        int r101 = this.f245423a + 1;
        this.f245423a = r101;
        if (r101 > 6) goto L13;
        com.bytedance.helios.common.utils.g.e().postDelayed(this, 10000);
        return;
    L13:
        Lazy r102 = LogUploader.f245402a;
        l.b(LogUploader.b("-103", "isFirstStart=" + HeliosEnvImpl.get().f245462e));
        return;
    L15:
        long r103 = this.f245424b;     // Catch: Exception -> L8
        long r104 = this.f245425c;     // Catch: Exception -> L8
        a r105 = new a(this);     // Catch: Exception -> L8
        jz5.e r106 = c.f245415c;     // Catch: Exception -> L8
        if (r106 == null) goto L17;
        r106.c(r103, r104, r105);     // Catch: Exception -> L8
        return;
    L17:
        return;
    L8:
        e = move-exception;
        Lazy r107 = LogUploader.f245402a;
        l.b(LogUploader.b("-101", e.getMessage()));
        l.b(new iz5.b(null, e, "label_upload_alog", null, 25));
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

    public e(long r100, long r101) {
        this.f245424b = r100;
        this.f245425c = r101;
    }
}
