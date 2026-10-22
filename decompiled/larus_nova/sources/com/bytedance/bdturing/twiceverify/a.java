package com.bytedance.bdturing.twiceverify;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f202110d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fc4.a f202111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f202112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jc4.a f202113c;

    /* JADX INFO: renamed from: com.bytedance.bdturing.twiceverify.a$a, reason: collision with other inner class name */
    public class C2914a {
        public C2914a() {
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public interface b {
    }

    public static a a() {
        if (f202110d != null) goto L13;
        monitor-enter(a.class);
        f202110d = new a();     // Catch: Throwable -> L9
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f202110d;
    }

    public a() {
        new C2914a();
    }
}
