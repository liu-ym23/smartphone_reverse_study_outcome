package com.bytedance.ee.bear.bitable.load;

import com.bytedance.ee.bear.document.fail.DocException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableLoadContext f214465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f214466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f214467c;

    public a(BitableLoadContext r100, DocException r101, Map r102) {
        this.f214465a = r100;
        this.f214466b = r101;
        this.f214467c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BitableLoadContext r100 = this.f214465a;     // Catch: Throwable -> L7
        Throwable r101 = this.f214466b;     // Catch: Throwable -> L7
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Throwable -> L7
        Map<String, String> r103 = this.f214467c;     // Catch: Throwable -> L7
        if (r103 == null) goto L5;
        r102.putAll(r103);     // Catch: Throwable -> L7
    L5:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r100.k(r101, r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
