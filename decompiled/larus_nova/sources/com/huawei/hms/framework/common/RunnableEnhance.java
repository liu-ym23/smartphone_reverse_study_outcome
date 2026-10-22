package com.huawei.hms.framework.common;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " ->";
    private String parentName;
    private Runnable proxy;

    @Override // java.lang.Runnable
    public void run() {
        com_huawei_hms_framework_common_RunnableEnhance_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_huawei_hms_framework_common_RunnableEnhance__run$___twin___() {
        this.proxy.run();
    }

    public String getParentName() {
        return this.parentName;
    }

    public RunnableEnhance(Runnable r100) {
        this.parentName = Thread.currentThread().getName();
        this.proxy = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_huawei_hms_framework_common_RunnableEnhance_com_larus_apm_impl_protector_RunnableLancet_run(RunnableEnhance r100) {
        r100.com_huawei_hms_framework_common_RunnableEnhance__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
