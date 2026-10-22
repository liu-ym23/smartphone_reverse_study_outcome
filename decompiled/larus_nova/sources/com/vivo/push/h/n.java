package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f462366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f462367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f462368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f462369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f462370e;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_n_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_n__run$___twin___() {
        l r100 = this.f462370e;
        r100.f462339b.onDelAlias(l.b(r100), this.f462366a, this.f462367b, this.f462368c, this.f462369d);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_n_com_larus_apm_impl_protector_RunnableLancet_run(n r100) {
        r100.com_vivo_push_h_n__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(l r100, int r101, List r102, List r103, String r104) {
        this.f462370e = r100;
        this.f462366a = r101;
        this.f462367b = r102;
        this.f462368c = r103;
        this.f462369d = r104;
    }
}
