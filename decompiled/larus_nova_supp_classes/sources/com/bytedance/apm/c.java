package com.bytedance.apm;

import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.internal.ApmDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public c() {
    }

    public static void a(ApmStartConfig r1) {
        ApmDelegate.g.a.f(r1);
        if (d.c == false) goto L6;
        bt3.c.a().b(new a());
        return;
    }
}
