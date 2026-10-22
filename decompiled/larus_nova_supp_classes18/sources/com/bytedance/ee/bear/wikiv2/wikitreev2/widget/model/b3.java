package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b3 implements Runnable {
    public final /* synthetic */ WikiDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a3 c;
    public final /* synthetic */ WikiHomePageV2 d;

    public b3(WikiDatabase r1, String r2, a3 r3, WikiHomePageV2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        yq5.f r0 = this.a.d();
        yq5.a r1 = r0.h(this.b);
        if (r1 != null) goto L5;
        return;
    L5:
        a3 r2 = this.c;
        WikiHomePageV2 r3 = this.d;
        r2.getClass();
        r1.v = r3.objToken;
        r1.w = r3.objType;
        r1.x = r3.wikiToken;
        r1.y = r3.url;
        r1.z = r3.title;
        r0.k(r1);
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
