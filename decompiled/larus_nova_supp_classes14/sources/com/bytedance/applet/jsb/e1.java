package com.bytedance.applet.jsb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e1 implements a88.d {
    public final String a;
    public final boolean b;
    public final boolean c;

    public final boolean b() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public final void a(String r2) {
        int r3 = f.a;
        f.a(this.a, 2);
        c0 r4 = c0.a;
        c0.c(this.a, 2);
    }

    public final void c(String r2) {
        int r3 = f.a;
        f.a(this.a, 1);
        c0 r4 = c0.a;
        c0.c(this.a, 1);
    }

    public e1(String r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "musicId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
