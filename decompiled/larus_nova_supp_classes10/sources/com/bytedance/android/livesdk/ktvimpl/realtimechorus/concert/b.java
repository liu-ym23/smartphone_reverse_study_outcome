package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.view.ViewGroup;
import fd2.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements g {
    public ViewGroup a;
    public c b;
    public final String c;

    public final void a() {
    }

    public final void b() {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public final void onSelect() {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public final void unload() {
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        this.c = r2;
    }

    public final void c(fd2.b r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        this.a = r5.i;
        this.b = new c();
        c r0 = this.b;
        if (r0 == null) goto L5;
        r0.a(r5);
    L5:
        c r1 = this.b;
        if (r1 == null) goto L9;
        r1.c(r5.b, r5.c, true, this.c);
        return;
    }
}
