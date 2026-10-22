package com.vivo.push;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public abstract class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f462510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v f462512c;

    public abstract void a(v r100);

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_s_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_s__run$___twin___() {
        Context r100 = this.f462510a;
        if (r100 != null) goto L5;
    L7:
        a(this.f462512c);
        return;
    L5:
        if ((this.f462512c instanceof com.vivo.push.b.n) == true) goto L7;
        com.vivo.push.util.t.a(r100, "[执行指令]" + this.f462512c);
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getClass().getSimpleName());
        r100.append("{");
        v r101 = this.f462512c;
        if (r101 != null) goto L5;
        String r102 = "[null]";
    L6:
        r100.append(r102);
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    L5:
        r102 = r101.toString();
        goto L6
    }

    public final int a() {
        return this.f462511b;
    }

    public s(v r100) {
        this.f462511b = -1;
        this.f462512c = r100;
        int r101 = r100.b();
        this.f462511b = r101;
        if (r101 < 0) goto L7;
        this.f462510a = m.a().h();
        return;
    L7:
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_s_com_larus_apm_impl_protector_RunnableLancet_run(s r100) {
        r100.com_vivo_push_s__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
