package com.bytedance.salamander.anniex;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f268252a = 0;

    public static final class a {
        public a() {
        }

        public static void a(g4 r100, Function1 r101) {
            int r102 = n2.f268252a;
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            com.bytedance.salamander.bridge.common.a r103 = com.bytedance.salamander.bridge.common.b.a(null);     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L5
            com.bytedance.salamander.bridge.n r104 = new com.bytedance.salamander.bridge.n(r101);     // Catch: Exception -> L5
            com.bytedance.salamander.bridge.o r105 = new com.bytedance.salamander.bridge.o(r100);     // Catch: Exception -> L5
            new ve7.h().a(r103, r105, r104);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            String r106 = e.getMessage();
            if (r106 == null) goto L12;
            Unit r107 = (Unit) r101.invoke(new h4(r106, 0));
            return;
        }
    }

    static {
        new a();
    }
}
