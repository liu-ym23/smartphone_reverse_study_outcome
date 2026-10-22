package iva;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile C6360a f496134a;

    /* JADX INFO: renamed from: iva.a$a, reason: collision with other inner class name */
    public static class C6360a {
        public C6360a() {
        }
    }

    public a() {
    }

    public static C6360a a() {
        if (f496134a != null) goto L18;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f496134a != null) goto L11;
        f496134a = new C6360a();     // Catch: Throwable -> L9
        boolean r100 = true;
    L12:
        monitor-exit(a.class);     // Catch: Throwable -> L9
        if (r100 == false) goto L18;
        Log.i("AppIdProvider", "AppIdProvider init finished");
        goto L18
    L11:
        r100 = false;
    L18:
        return f496134a;
    }
}
