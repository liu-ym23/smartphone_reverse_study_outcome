package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.f0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ int b;

    public j(k r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        k r0 = this.a;
        r0.a.f = null;
        List<c0> r1 = r0.b.c;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        int r4 = f0.a;
        if (f0.b(this.b, (c0) r3) == false) goto L6;
    L11:
        c0 r5 = (c0) r3;
        if (r5 == null) goto L14;
        int r6 = f0.a;
        h.a(this.a.a, f0.a(r5.a(this.b)));
        h r7 = this.a.a;
        r7.c.setVisibility(0);
        r7.c.setAlpha(0.0f);
        r7.c.animate().alpha(1.0f).setDuration(300).setListener(null).start();
        Lazy r8 = UIUtils.a;
        UIUtils.c().removeCallbacks(r7.e);
        UIUtils.c().postDelayed(r7.e, 3000);
        goto L14
    L10:
        r3 = null;
    L14:
        this.a.a.b.add(Integer.valueOf(this.b));
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
