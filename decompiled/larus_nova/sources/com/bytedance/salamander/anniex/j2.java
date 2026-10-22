package com.bytedance.salamander.anniex;

import android.app.Activity;
import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f268152a = 0;

    public static final class a {
        public static void a(t3 r100, Function1 r101, Context r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
        L11:
            e = move-exception;
            String r103 = e.getMessage();
            if (r103 == null) goto L18;
            Unit r104 = (Unit) r101.invoke(new u3(0, r103, null));
            return;
        L18:
            return;
        L4:
            if ((r102 instanceof Activity) == false) goto L6;
            Activity r105 = (Activity) r102;     // Catch: Exception -> L11
        L7:
            if (r105 != null) goto L9;
            r105 = new Activity();     // Catch: Exception -> L11
        L9:
            com.bytedance.salamander.bridge.common.a r106 = com.bytedance.salamander.bridge.common.b.a(r105);     // Catch: Exception -> L11
            Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Exception -> L11
            com.bytedance.salamander.bridge.f r107 = new com.bytedance.salamander.bridge.f(r101);     // Catch: Exception -> L11
            com.bytedance.salamander.bridge.g r108 = new com.bytedance.salamander.bridge.g(r100);     // Catch: Exception -> L11
            new jd7.f();     // Catch: Exception -> L11
            jd7.f.a(r106, r108, r107);     // Catch: Exception -> L11
            return;
        L6:
            r105 = null;
            goto L7
        }
    }

    static {
    }
}
