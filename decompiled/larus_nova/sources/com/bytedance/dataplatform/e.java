package com.bytedance.dataplatform;

import android.content.Context;
import android.content.SharedPreferences;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f204297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f204298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f204299c;

    public final void a() {
        SharedPreferences.Editor r100 = g.c(this.f204297a, this.f204298b).edit();
        r100.clear().apply();
        Iterator r101 = this.f204299c.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        r100.putString(r102, (String) this.f204299c.get(r102));
        goto L4
    L6:
        r100.apply();
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

    public e(Context r100, Map r101) {
        this.f204297a = r100;
        this.f204298b = "SP_EXPERIMENT_EXPOSURE_CACHE";
        this.f204299c = r101;
    }
}
