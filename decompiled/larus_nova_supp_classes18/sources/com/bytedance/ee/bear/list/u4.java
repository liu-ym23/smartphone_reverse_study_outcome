package com.bytedance.ee.bear.list;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u4 {
    public static final u4 a = null;

    static {
        a = new u4();
    }

    public u4() {
    }

    public static String a(Context r1, int r2) {
        if (r1 != null) goto L6;
        tt5.a.h("SpaceCoreUtil", "context is null");
        return "";
    L6:
        if (sbb.g.b(r2) == false) goto L10;
        return r1.getString(2131888912);
    L10:
        if (r2 != sbb.e.f.b) goto L13;
        String r3 = r1.getString(2131888004);
        Intrinsics.checkNotNull(r3);
        return r3;
    L13:
        if (r2 != sbb.e.q.b) goto L16;
        String r4 = r1.getString(2131887343);
        Intrinsics.checkNotNull(r4);
        return r4;
    L16:
        if (r2 != sbb.e.l.b) goto L19;
        String r5 = r1.getString(2131887779);
        Intrinsics.checkNotNull(r5);
        return r5;
    L19:
        if (r2 != sbb.e.v.b) goto L21;
        String r6 = r1.getString(2131888863);
        Intrinsics.checkNotNull(r6);
        return r6;
    L21:
        String r7 = r1.getString(2131888003);
        Intrinsics.checkNotNull(r7);
        return r7;
    }
}
