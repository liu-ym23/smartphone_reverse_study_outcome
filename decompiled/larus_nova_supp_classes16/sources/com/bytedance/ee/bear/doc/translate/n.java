package com.bytedance.ee.bear.doc.translate;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(oj5.a r4) {
            Intrinsics.checkNotNullParameter(r4, "docMoreInfo");
            com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            if (r0 == null) goto L6;
            r0.c("tranlste");
            r0.h("tranlste");
            r0.j("tranlste", "token", r4.c);
            r0.j("tranlste", "type", String.valueOf(r4.getType()));
            r0.j("tranlste", "is_wiki", String.valueOf(r4 instanceof oj5.f));
            r0.j("tranlste", "is_at_vc", String.valueOf(r4.k));
            return;
        }
    }

    static {
    }
}
