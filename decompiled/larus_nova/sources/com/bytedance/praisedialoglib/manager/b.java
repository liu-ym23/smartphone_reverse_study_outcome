package com.bytedance.praisedialoglib.manager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f266646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f266647b;

    public final void a() {
        z57.b.f570113b = false;
        Intent r100 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r100.setData(UriProtector.parse(this.f266646a));
        r100.setFlags(268435456);
        a.C3729a.f266645a.startActivity(this.f266647b.f266649a, r100);     // Catch: ActivityNotFoundException -> L5
        b67.a.b(this.f266647b.f266650b.f266662c);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        this.f266647b.f266650b.f(true);
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

    public b(d r100, String r101) {
        this.f266647b = r100;
        this.f266646a = r101;
    }
}
