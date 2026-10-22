package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.graphics.Rect;
import android.view.View;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class VisibleLogManager {
    public final Lazy a;
    public final List<com.bytedance.android.shopping.anchorv4.log.e> b;
    public final Lazy c;
    public int d;
    public CompositeDisposable e;
    public boolean f;

    public VisibleLogManager() {
        this.a = LazyKt.lazy(VisibleLogManager$theHandler$2.INSTANCE);
        this.b = new ArrayList();
        this.c = LazyKt.lazy(VisibleLogManager$rect$2.INSTANCE);
        this.d = -1;
    }

    public static final void a(VisibleLogManager r6) {
        ArrayList r0 = (ArrayList) r6.b;
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.log.e) r1.next()).a.onScan();
        goto L4
    L6:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (((com.bytedance.android.shopping.anchorv4.log.e) r4).c == true) goto L8;
        r2.add(r4);
        goto L8
    L12:
        Iterator r5 = r2.iterator();
    L14:
        if (r5.hasNext() == false) goto L31;
        com.bytedance.android.shopping.anchorv4.log.e r7 = (com.bytedance.android.shopping.anchorv4.log.e) r5.next();
        View r8 = r7.a.t();
        if (r8 == null) goto L14;
        int r9 = r7.d;
        int r10 = r7.a.M0();
        r7.getIdentifier();
        r8.getGlobalVisibleRect((Rect) r6.c.getValue());
        if (r9 == 0) goto L22;
        if (r9 != 1) goto L22;
        int r11 = ((Rect) r6.c.getValue()).bottom;
    L23:
        int r12 = r6.d - r10;
        if (1 > r11) goto L28;
        if (r12 <= r11) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L14;
        r7.c = true;
        r7.a.onVisible();
    L28:
        r13 = false;
    L22:
        r11 = ((Rect) r6.c.getValue()).top;
        goto L23
    }
}
