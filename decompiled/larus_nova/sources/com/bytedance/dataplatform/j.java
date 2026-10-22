package com.bytedance.dataplatform;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f204317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f204318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f204319c;

    public final void a() {
        q r100 = this.f204319c.f204312h;
        String r101 = this.f204317a;
        boolean r102 = this.f204318b;
        if (r100.f204366i.containsKey(r101) == false) goto L23;
        if (r102 == true) goto L6;
    L8:
        String r103 = r100.f204366i.get(r101);
        if (TextUtils.isEmpty(r103) == false) goto L11;
    L18:
        String r104 = r100.f204365h;
        if (hj4.d.f485429c == false) goto L25;
        w.a(new hj4.b(r103, r104));
        return;
    L25:
        return;
    L11:
        if (((ConcurrentSkipListSet) r100.f204360c).contains(r103) == true) goto L18;
        if (((ConcurrentSkipListSet) r100.f204362e).contains(r103) == true) goto L18;
        if (r102 == false) goto L16;
        ((ConcurrentSkipListSet) r100.f204362e).add(r103);
        w.a(new c(r100.f204358a, "SP_EXPERIMENT_EXPOSURE_CACHE_" + r100.f204364g, r100.f204362e));
    L17:
        r100.c();
        goto L18
    L16:
        ((ConcurrentSkipListSet) r100.f204360c).add(r103);
        w.a(new c(r100.f204358a, "SP_EXPERIMENT_EXPOSURE_CACHE", r100.f204360c));
        goto L17
    L6:
        if (TextUtils.isEmpty(r100.f204364g) == false) goto L8;
        return;
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

    public j(i r100, String r101) {
        this.f204319c = r100;
        this.f204317a = r101;
        this.f204318b = false;
    }
}
