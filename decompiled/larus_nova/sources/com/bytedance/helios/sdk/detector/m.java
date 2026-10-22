package com.bytedance.helios.sdk.detector;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f245534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f245535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PrivacyEvent f245536c;

    public m(l r100, List r101, PrivacyEvent r102, ApiConfig r103) {
        this.f245534a = r100;
        this.f245535b = r101;
        this.f245536c = r102;
    }

    public final void a() {
        Iterator r100 = this.f245535b.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        ((Number) r100.next()).intValue();
        Object r101 = this.f245536c.f245389z.getThisOrClass();
        if (r101 == null) goto L8;
        int r102 = r101.hashCode();
    L9:
        PrivacyEvent r103 = this.f245536c;
        r103.f245369f = null;
        r103.f245370g = "";
        this.f245534a.m(r102, this.f245535b, r103);
        goto L4
    L8:
        r102 = 0;
        goto L9
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
