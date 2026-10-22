package com.huawei.hms.opendevice;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f277547a;

    @Override // java.lang.Runnable
    public void run() {
        com_huawei_hms_opendevice_o_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_huawei_hms_opendevice_o__run$___twin___() {
        Runnable r100 = this.f277547a;
        if (r100 == null) goto L9;
        r100.run();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public o(Runnable r100) {
        this.f277547a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_huawei_hms_opendevice_o_com_larus_apm_impl_protector_RunnableLancet_run(o r100) {
        r100.com_huawei_hms_opendevice_o__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
