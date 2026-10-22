package com.cmic.ida.sdk;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes22.dex */
public class j extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyguardManager f273134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f273135b;

    @Override // com.cmic.ida.sdk.z
    public String a() {
        Object r100 = this.f273134a.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f273134a, new Object[0]);     // Catch: Exception -> L6
        if (r100 == null) goto L8;
        return r100.toString();
    L8:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public j(Context r100) {
        this.f273135b = new LinkedBlockingQueue(1);
        this.f273134a = (KeyguardManager) r100.getSystemService("keyguard");
    }
}
