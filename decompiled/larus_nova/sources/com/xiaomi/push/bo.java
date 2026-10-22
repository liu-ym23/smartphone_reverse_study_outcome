package com.xiaomi.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class bo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f463206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f279a;

    @Override // java.lang.Runnable
    public void run() {
        com_xiaomi_push_bo_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_xiaomi_push_bo__run$___twin___() {
        WeakReference<Context> r100 = this.f279a;
        if (r100 != null) goto L5;
        return;
    L5:
        Context r101 = r100.get();
        if (r101 != null) goto L9;
        return;
    L9:
        if (bz.a(this.f463206a) <= bn.f277a) goto L11;
        br r102 = br.a(this.f463206a);
        bq r103 = bq.a(this.f463206a);
        r102.a(r103);
        r103.a(bp.a(r101, this.f463206a, 1000));
        bv.a(r101).a(r102);
        return;
    L11:
        com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_xiaomi_push_bo_com_larus_apm_impl_protector_RunnableLancet_run(bo r100) {
        r100.com_xiaomi_push_bo__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public bo(String r100, WeakReference<Context> r101) {
        this.f463206a = r100;
        this.f279a = r101;
    }
}
