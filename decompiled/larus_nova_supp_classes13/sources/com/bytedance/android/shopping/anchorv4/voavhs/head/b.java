package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final String a;
    public final String b;
    public final List<c> c;
    public final boolean d;
    public final String e;

    public b() {
        this(null, null, null, false, null, 31);
    }

    public final String a() {
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        StringBuilder r0 = new StringBuilder(r1);
        Iterator<T> r2 = this.c.iterator();
    L7:
        if (r2.hasNext() == false) goto L25;
        c r3 = (c) r2.next();
        ECUrlModel r4 = r3.b;
        String r5 = null;
        if (r4 == null) goto L11;
        String r6 = r4.getUri();
    L12:
        r0.append(r6);
        ECUrlModel r7 = r3.c;
        if (r7 == null) goto L15;
        String r8 = r7.getUri();
    L16:
        r0.append(r8);
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r9 = r3.i;
        if (r9 == null) goto L19;
        String r10 = r9.j();
    L20:
        r0.append(r10);
        ECUrlModel r11 = r3.h;
        if (r11 == null) goto L23;
        r5 = r11.getUri();
    L23:
        r0.append(r5);
        goto L7
    L19:
        r10 = null;
        goto L20
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L25:
        return r0.toString();
    }

    public b(String r2, String r3, List<c> r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "nodeList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ b(String r6, String r7, List r8, boolean r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r11 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r11 & 4) == 0) goto L13;
        r8 = CollectionsKt.emptyList();
    L13:
        List r3 = r8;
        if ((r11 & 8) == 0) goto L16;
        boolean r4 = false;
    L18:
        if ((r11 & 16) == 0) goto L20;
        String r12 = null;
    L21:
        this(r0, r2, r3, r4, r12);
        return;
    L20:
        r12 = r10;
        goto L21
    L16:
        r4 = r9;
        goto L18
    L9:
        r2 = r7;
        goto L11
    L5:
        r0 = r6;
        goto L7
    }
}
