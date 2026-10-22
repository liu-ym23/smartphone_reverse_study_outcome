package vy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements CpuCallbackManager.d {
    public final /* synthetic */ Context a;

    public d(Context r1) {
        this.a = r1;
    }

    public final void onIdle() {
        CountDownLatch r0 = a.a;
        Context r1 = this.a;
        tt5.a.h("ResCleanUtils", "cleanRedundantRes");
        Iterator<String> r2 = EChannel.getChannelList(!com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.full_pkg_included")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = r2.next();
        if (d0.m(r3) == false) goto L4;
        d0.e(r1, r3, true);
        goto L4
    }
}
