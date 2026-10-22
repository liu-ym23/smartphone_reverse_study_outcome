package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f462361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f462362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f462363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f462364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f462365e;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_m_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_m__run$___twin___() {
        l r100 = this.f462365e;
        r100.f462339b.onDelTags(l.a(r100), this.f462361a, this.f462362b, this.f462363c, this.f462364d);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_m_com_larus_apm_impl_protector_RunnableLancet_run(m r100) {
        r100.com_vivo_push_h_m__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public m(l r100, int r101, List r102, List r103, String r104) {
        this.f462365e = r100;
        this.f462361a = r101;
        this.f462362b = r102;
        this.f462363c = r103;
        this.f462364d = r104;
    }
}
