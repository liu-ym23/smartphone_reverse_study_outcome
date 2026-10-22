package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ ECCustomizedElementView a;
    public final /* synthetic */ ArrayList b;

    public d(ECCustomizedElementView r1, ArrayList r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Iterator r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        Triple r2 = (Triple) r0.next();
        int r3 = ((Number) r2.getFirst()).intValue();
        boolean r4 = ((Boolean) r2.getSecond()).booleanValue();
        View r5 = (View) r2.getThird();
        int r6 = r3 - r1;
        if (r4 == true) goto L7;
        if (r5 == null) goto L4;
        if (r6 < this.a.getChildCount()) goto L4;
        this.a.addView(r5);
        goto L4
    L7:
        this.a.removeViewAt(r6);
        if (r5 != null) goto L9;
        r1 = r1 + 1;
        goto L4
    L9:
        this.a.addView(r5, r6);
        goto L4
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
