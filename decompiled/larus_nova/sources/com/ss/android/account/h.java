package com.ss.android.account;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile h f406315b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f406316a;

    public class a extends com.bytedance.sdk.account.utils.i<Object> {
        @Override // com.bytedance.sdk.account.utils.i
        public final Object b() {
            go2.g r100 = k.d().c();
            if (r100 == null) goto L7;
            k.d().getApplicationContext();
            int r101 = com.larus.account.saas.core.internal.init.a.f286244e;
            return r100;
        L7:
            throw new RuntimeException("please provide IAccountSec implementation");
        }

        public a() {
        }
    }

    public static h a() {
        if (f406315b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f406315b != null) goto L9;
        f406315b = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f406315b;
    }

    public h() {
        this.f406316a = new a();
    }
}
