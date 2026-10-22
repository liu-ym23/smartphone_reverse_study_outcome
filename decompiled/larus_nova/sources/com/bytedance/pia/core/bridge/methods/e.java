package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<d.C3722d> f266176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f266178c;

    public e(m47.h r100, String r101, m47.i r102) {
        this.f266176a = r100;
        this.f266177b = r101;
        this.f266178c = r102;
    }

    public final void a() {
    L22:
        e = move-exception;
        this.f266178c.accept(new PiaMethod.Error("[Cache] PIA Cache Get Content Failed, reason: (" + e.getMessage() + ')'));
        return;
    L3:
        String r100 = "";
        if (o47.f.f521979e.get() == true) goto L7;
        this.f266176a.accept(new d.C3722d(""));     // Catch: Exception -> L22
        return;
    L7:
        String r101 = null;
        o47.a.C7013a r102 = o47.f.l(this.f266177b, null);     // Catch: Exception -> L22
        if (r102 == null) goto L16;
        Number r103 = r102.a();     // Catch: Exception -> L22
        String r104 = r102.e();     // Catch: Exception -> L22
        if (r103 == null) goto L16;
        if (r103.longValue() <= System.currentTimeMillis()) goto L16;
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r101 = o47.f.k(this.f266177b);     // Catch: Exception -> L22
    L16:
        l47.a<d.C3722d> r105 = this.f266176a;     // Catch: Exception -> L22
        if (r101 == null) goto L20;
        r100 = r101;
    L20:
        r105.accept(new d.C3722d(r100));     // Catch: Exception -> L22
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
