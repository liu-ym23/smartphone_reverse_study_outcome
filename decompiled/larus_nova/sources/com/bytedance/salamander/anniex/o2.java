package com.bytedance.salamander.anniex;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f268265a = 0;

    public static final class a {
        public static void a(i4 r100, Function1 r101, Context r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            com.bytedance.salamander.bridge.common.a r103 = com.bytedance.salamander.bridge.common.b.a(r102);     // Catch: Exception -> L5
            Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L5
            com.bytedance.salamander.bridge.p r104 = new com.bytedance.salamander.bridge.p(r101);     // Catch: Exception -> L5
            com.bytedance.salamander.bridge.q r105 = new com.bytedance.salamander.bridge.q(r100);     // Catch: Exception -> L5
            new af7.t();     // Catch: Exception -> L5
            af7.t.a(r103, r105, r104);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            String r106 = e.getMessage();
            if (r106 == null) goto L12;
            Unit r107 = (Unit) r101.invoke(new j4(r106, 0));
            return;
        }
    }

    static {
    }
}
