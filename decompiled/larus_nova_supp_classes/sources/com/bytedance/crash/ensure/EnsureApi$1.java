package com.bytedance.crash.ensure;

import com.bytedance.crash.d;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.util.p;
import com.bytedance.services.apm.api.IEnsure;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fh4.f;
import fh4.g;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class EnsureApi$1 implements IEnsure {
    public EnsureApi$1() {
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere() {
        f r0 = j.c();
        if (r0.d("core_exception_monitor", null) == true) goto L7;
        Thread r1 = ThreadMethodProxy.currentThread();
        r0.f(new g(null, r1.getStackTrace(), 5, null, null, r1.getName(), "core_exception_monitor"));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r1) {
        int r2 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotEmpty(Collection r1) {
        int r2 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r1) {
        int r2 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r3) {
        j.c().e(r3, 5);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r1) {
        int r2 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r1) {
        ensureNotReachHere(r1);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r1) {
        d.c(r1);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r1, String r2) {
        int r3 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r1, String r2) {
        int r3 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r11, Map<String, String> r12) {
        f r0 = j.c();
        if (r0.d("core_exception_monitor", r11) == false) goto L5;
        p.e("reportMessage：isDrop:" + r11);
        return;
    L5:
        Thread r1 = ThreadMethodProxy.currentThread();
        r0.f(new g(null, r1.getStackTrace(), 5, r11, r12, r1.getName(), "core_exception_monitor"));
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r1, String r2) {
        int r3 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r1, String r2) {
        ensureNotReachHere(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r1, String r2) {
        d.d(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r1, String r2, Map<String, String> r3) {
        int r4 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r1, String r2, Map<String, String> r3) {
        d.e(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r1, String r2, Map<String, String> r3) {
        int r4 = d.a;
        return false;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(int r1, Throwable r2, String r3) {
        ensureNotReachHere(r2, r3);
    }
}
