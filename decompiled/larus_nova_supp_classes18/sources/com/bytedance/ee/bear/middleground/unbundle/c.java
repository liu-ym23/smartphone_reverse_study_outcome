package com.bytedance.ee.bear.middleground.unbundle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void a() {
        tt5.a.h("Benefit_FetchResBenefitExecutor", "clear...");
        List r2 = CollectionsKt.toList(((LinkedHashMap) this.a.e).keySet());     // Catch: Exception -> L18
        b r3 = this.a;     // Catch: Exception -> L18
        Iterator r4 = r2.iterator();     // Catch: Exception -> L18
    L5:
        if (r4.hasNext() == false) goto L16;
        String r5 = (String) r4.next();     // Catch: Exception -> L18
        int r6 = StringsKt.lastIndexOf$default(r5, '#', 0, false, 6, null);     // Catch: Exception -> L18
        if (r6 < 0) goto L9;
        String r7 = r5.substring(0, r6);     // Catch: Exception -> L18
    L10:
        if (r6 >= 0) goto L12;
    L14:
        boolean r8 = false;
    L15:
        b.a(r3, r7, r8);     // Catch: Exception -> L18
        goto L5
    L12:
        if (Boolean.parseBoolean(r5.substring(r6 + 1)) == false) goto L14;
        r8 = true;
        goto L15
    L9:
        r7 = r5;
        goto L10
    L16:
        this.a.f.clear();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        tt5.a.e("Benefit_FetchResBenefitExecutor", "clear... error: ", e, false);
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
