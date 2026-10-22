package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements fd2.q {
    public Long a;
    public Long b;
    public int c;
    public String d;

    public static final class a {
    }

    static {
    }

    public n() {
    }

    public final n a() {
        this.c = 1;
        return this;
    }

    public final MvServiceImpl b() {
        Long r0 = this.b;
        MvServiceImpl r1 = new MvServiceImpl(this.a, this.c);
        r1.i = r0;
        r1.a = this.d;
        return r1;
    }

    public final n c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dir");
        this.d = r2;
        return this;
    }
}
