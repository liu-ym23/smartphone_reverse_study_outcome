package com.bytedance.android.window.shop.home.header;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ WindowHybridListOperationPlugin a;

    public b(WindowHybridListOperationPlugin r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        k r9 = (k) r8;
        WindowHybridListOperationPlugin r0 = this.a;
        r0.getClass();
        ArrayList r1 = r9.c;
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L18;
        i r3 = (i) r2.next();
        ArrayList r4 = r3.i;
        if (r4 == null) goto L6;
        Iterator<T> r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L6;
        String r6 = ((ECHybridListItemVO) r5.next()).d;
        if (r6 == null) goto L11;
        if (r0.d.e(r3.a, r6) == null) goto L11;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L33;
        this.a.d.r(r9);
        return;
    L33:
        return;
    L18:
        r7 = false;
        goto L19
    }
}
