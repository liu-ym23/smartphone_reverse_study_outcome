package com.cmic.ida.sdk;

import android.content.Context;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes22.dex */
public class k extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f273138b;

    @Override // com.cmic.ida.sdk.z
    public String a() {
        String r100 = "";
        b.a r101 = b.a(this.f273137a);     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r100 = r101.f273076a;     // Catch: Exception -> L7
        u.a("HonorOaid", "getAdvertisingIdInfo id=" + r101.f273076a + ", isLimitAdTrackingEnabled=" + r101.f273077b);     // Catch: Exception -> L7
        return r100;
    L12:
        return "";
    L7:
        e = move-exception;
        u.b("HonorOaid", "getAdvertisingIdInfo Exception: " + e);
        return r100;
    }

    public k(Context r100) {
        this.f273138b = new LinkedBlockingQueue(1);
        this.f273137a = r100;
    }
}
