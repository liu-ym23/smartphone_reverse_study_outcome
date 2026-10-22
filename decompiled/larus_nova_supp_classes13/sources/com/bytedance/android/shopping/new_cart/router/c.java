package com.bytedance.android.shopping.new_cart.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements w {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Uri b;

    public final k r() {
        r r0 = new r();
        r0.b = true;
        return r0.f;
    }

    public final void run() {
        int r0 = ECSdk.a;
        o r1 = (o) ECSdk.a(o.class);
        if (r1 == null) goto L6;
        o.a.a(r1, this.a, "cart_page", this.b.toString(), VmSdkSetting.a().b());
        return;
    }

    public c(Context r1, Uri r2) {
        this.a = r1;
        this.b = r2;
    }
}
