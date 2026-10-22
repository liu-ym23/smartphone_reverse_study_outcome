package com.bytedance.ee.bear.doc.translate;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f218377a = 0;

    public static final class a {
        @JvmStatic
        public static void a(oj5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "docMoreInfo");
            com.bytedance.ee.bear.contract.d r101 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
            if (r101 == null) goto L6;
            r101.c("tranlste");
            r101.h("tranlste");
            r101.j("tranlste", "token", r100.f523532c);
            r101.j("tranlste", "type", String.valueOf(r100.getType()));
            r101.j("tranlste", "is_wiki", String.valueOf(r100 instanceof oj5.f));
            r101.j("tranlste", "is_at_vc", String.valueOf(r100.f523540k));
            return;
        }
    }

    static {
    }
}
