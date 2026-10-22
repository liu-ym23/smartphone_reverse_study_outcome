package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements w {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ String b;

    public final com.bytedance.android.ec.opt.asynctask.k r() {
        r r0 = new r();
        r0.c = true;
        return r0.g.b();
    }

    public final void run() {
        this.a.run();
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.a("Django: Task: event async: " + this.b);
    }

    public k(Runnable r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
