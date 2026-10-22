package ks3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f505905b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final at3.a<JSONObject> f505906a;

    public static a a() {
        if (f505905b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f505905b != null) goto L9;
        f505905b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f505905b;
    }

    public a() {
        this.f505906a = new at3.a();
    }
}
