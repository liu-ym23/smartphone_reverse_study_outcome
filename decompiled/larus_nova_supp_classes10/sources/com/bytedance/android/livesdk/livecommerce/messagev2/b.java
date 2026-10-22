package com.bytedance.android.livesdk.livecommerce.messagev2;

import com.bytedance.android.ec.model.live.r;
import com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements j {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.j
    public final List<r> a(String r8) {
        List<r> r0 = this.a.g;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L25;
        Object r3 = r2.next();
        r r4 = (r) r3;
        boolean r5 = false;
        if (r8 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == true) goto L22;
        if (r8 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
    L23:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L21:
        if (Intrinsics.areEqual(r8, r4.f()) == false) goto L23;
    L15:
        if (r8.length() == 0) goto L18;
        r7 = false;
    L22:
        r5 = true;
        goto L23
    L8:
        if (r8.length() == 0) goto L11;
        r6 = false;
        goto L12
    L25:
        return r1;
    }
}
