package com.vivo.push.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.t;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends ab {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f462513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462514d;

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f462513c != null) goto L7;
        f462513c = new a();     // Catch: Throwable -> L10
    L7:
        a r100 = f462513c;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r100;
    }

    private a() {
        this.f462514d = "";
    }

    public final String b() {
        return this.f462514d;
    }

    public final void a(Intent r100) {
        if (r100 != null) goto L4;
    L8:
        t.d("CommandWorker", " sendMessage error: intent : " + r100 + ", mContext: " + this.f462212a);
        return;
    L4:
        if (this.f462212a == null) goto L8;
        Message r101 = Message.obtain();
        r101.obj = r100;
        a(r101);
    }

    @Override // com.vivo.push.ab
    public final void b(Message r100) {
        Intent r101 = (Intent) r100.obj;
        if (r101 != null) goto L5;
    L14:
        t.d("CommandWorker", " handleMessage error: intent : " + r101 + ", mContext: " + this.f462212a);
        return;
    L5:
        if (this.f462212a == null) goto L14;
        com.vivo.push.restructure.a.b r102 = new com.vivo.push.restructure.a.b(r101);
        t.d("CommandWorker", "received msg : ".concat(String.valueOf(r102.a())));     // Catch: Exception -> L11
        g.a().execute(new b(this, r102));
        return;
    L11:
        e = move-exception;
        t.a("CommandWorker", "handle message err : " + e.getMessage());
    }

    public static /* synthetic */ Context a(a r100) {
        return r100.f462212a;
    }

    public static /* synthetic */ Context b(a r100) {
        return r100.f462212a;
    }

    public final void a(String r100) {
        this.f462514d = r100;
    }
}
