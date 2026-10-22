package com.bytedance.android.livesdk.ktvimpl.feed;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Function2 d;

    public g(View r1, Function0 r2, View r3, Function2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        a1.p(this.a, s1.y());
        a1.k(this.a, (int) (s1.y() * 1.7777778f));
        Function0 r0 = this.b;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
    L6:
        if (this.c.getWidth() <= this.c.getHeight()) goto L8;
        float r2 = this.c.getWidth();
        int r3 = s1.w();
    L9:
        float r4 = r2 / r3;
        this.a.setPivotX(0.0f);
        this.a.setPivotY(0.0f);
        this.a.setScaleX(r4);
        this.a.setScaleY(r4);
        if (this.c.getWidth() <= this.c.getHeight()) goto L12;
        this.a.setPivotX(this.c.getWidth() / 2.0f);
    L12:
        Function2 r5 = this.d;
        if (r5 == null) goto L16;
        Unit r6 = (Unit) r5.invoke(Float.valueOf(r4), Float.valueOf(r4));
        return;
    L16:
        return;
    L8:
        r2 = this.c.getWidth();
        r3 = s1.y();
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
