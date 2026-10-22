package vy4;

import android.content.Context;
import com.bytedance.ee.bear.doc.resupdate.EChannel;
import com.bytedance.ee.bear.doc.resupdate.d0;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements CpuCallbackManager.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f557617a;

    public d(Context r100) {
        this.f557617a = r100;
    }

    @Override // com.ss.android.lark.monitor.callback.CpuCallbackManager.c
    public final void onIdle() {
        CountDownLatch r100 = a.f557611a;
        Context r101 = this.f557617a;
        tt5.a.h("ResCleanUtils", "cleanRedundantRes");
        Iterator<String> r102 = EChannel.getChannelList(!com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.full_pkg_included")).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        if (d0.m(r103) == false) goto L4;
        d0.e(r101, r103, true);
        goto L4
    }
}
