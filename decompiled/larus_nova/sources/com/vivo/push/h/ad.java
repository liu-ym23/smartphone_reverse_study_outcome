package com.vivo.push.h;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class ad implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f462341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f462342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f462343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f462344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ac f462345e;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_ad_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_ad__run$___twin___() {
        ac r100 = this.f462345e;
        r100.f462339b.onSetTags(ac.a(r100), this.f462341a, this.f462342b, this.f462343c, this.f462344d);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_ad_com_larus_apm_impl_protector_RunnableLancet_run(ad r100) {
        r100.com_vivo_push_h_ad__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ad(ac r100, int r101, List r102, List r103, String r104) {
        this.f462345e = r100;
        this.f462341a = r101;
        this.f462342b = r102;
        this.f462343c = r103;
        this.f462344d = r104;
    }
}
