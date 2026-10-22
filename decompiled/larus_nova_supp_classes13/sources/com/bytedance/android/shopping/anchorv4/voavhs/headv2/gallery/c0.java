package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c0 {
    public final int a;
    public int b;
    public final String c;
    public final String d;
    public final List<String> e;

    public final String a(int r3) {
        List<String> r0 = this.e;
        if (r0 == null) goto L15;
        String r4 = (String) CollectionsKt.getOrNull(r0, r3 - this.a);
        if (r4 == null) goto L15;
        if (r4.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        return r4;
    L9:
        r1 = false;
    L15:
        return this.c;
    }

    public c0(int r2, int r3, String r4, String r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r4, "label");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
