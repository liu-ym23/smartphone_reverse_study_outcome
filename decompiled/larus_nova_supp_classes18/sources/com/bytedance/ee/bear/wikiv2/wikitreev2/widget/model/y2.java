package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y2 implements Runnable {
    public final /* synthetic */ WikiDatabase a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ a3 d;
    public final /* synthetic */ Ref.BooleanRef e;

    public y2(WikiDatabase r1, String r2, String r3, a3 r4, Ref.BooleanRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        yq5.f r0 = this.a.d();
        yq5.a r1 = r0.h(this.b);
        if (r1 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r1.x, this.c) == true) goto L8;
        return;
    L8:
        this.d.getClass();
        r1.v = "";
        r1.w = 0;
        r1.x = "";
        r1.y = "";
        r1.z = "";
        r0.k(r1);
        this.e.element = true;
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
