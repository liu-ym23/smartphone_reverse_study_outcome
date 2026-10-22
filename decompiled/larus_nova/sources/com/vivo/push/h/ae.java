package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class ae implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f462346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f462347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f462348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f462349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ac f462350e;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_ae_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_ae__run$___twin___() {
        ac r100 = this.f462350e;
        r100.f462339b.onSetAlias(ac.b(r100), this.f462346a, this.f462347b, this.f462348c, this.f462349d);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_ae_com_larus_apm_impl_protector_RunnableLancet_run(ae r100) {
        r100.com_vivo_push_h_ae__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ae(ac r100, int r101, List r102, List r103, String r104) {
        this.f462350e = r100;
        this.f462346a = r101;
        this.f462347b = r102;
        this.f462348c = r103;
        this.f462349d = r104;
    }
}
