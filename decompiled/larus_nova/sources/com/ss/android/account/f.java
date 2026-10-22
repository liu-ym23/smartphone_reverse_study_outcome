package com.ss.android.account;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile f f406247b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f406248a;

    public class a extends com.bytedance.sdk.account.utils.i<xqa.b> {
        @Override // com.bytedance.sdk.account.utils.i
        public final xqa.b b() {
            return e.a();
        }

        public a() {
        }
    }

    public static f a() {
        if (f406247b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f406247b != null) goto L9;
        f406247b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f406247b;
    }

    public f() {
        this.f406248a = new a();
    }
}
