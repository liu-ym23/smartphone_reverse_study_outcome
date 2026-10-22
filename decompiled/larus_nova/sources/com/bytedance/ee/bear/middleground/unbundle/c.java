package com.bytedance.ee.bear.middleground.unbundle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f234405a;

    public c(b r100) {
        this.f234405a = r100;
    }

    public final void a() {
        tt5.a.h("Benefit_FetchResBenefitExecutor", "clear...");
        List r100 = CollectionsKt.toList(((LinkedHashMap) this.f234405a.f234391e).keySet());     // Catch: Exception -> L18
        b r101 = this.f234405a;     // Catch: Exception -> L18
        Iterator r102 = r100.iterator();     // Catch: Exception -> L18
    L5:
        if (r102.hasNext() == false) goto L16;
        String r103 = (String) r102.next();     // Catch: Exception -> L18
        int r104 = StringsKt.lastIndexOf$default(r103, '#', 0, false, 6, null);     // Catch: Exception -> L18
        if (r104 < 0) goto L9;
        String r105 = r103.substring(0, r104);     // Catch: Exception -> L18
    L10:
        if (r104 >= 0) goto L12;
    L14:
        boolean r106 = false;
    L15:
        b.a(r101, r105, r106);     // Catch: Exception -> L18
        goto L5
    L12:
        if (Boolean.parseBoolean(r103.substring(r104 + 1)) == false) goto L14;
        r106 = true;
        goto L15
    L9:
        r105 = r103;
        goto L10
    L16:
        this.f234405a.f234392f.clear();     // Catch: Exception -> L18
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
