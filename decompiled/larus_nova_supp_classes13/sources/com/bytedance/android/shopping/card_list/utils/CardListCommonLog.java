package com.bytedance.android.shopping.card_list.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListCommonLog {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(CardListCommonLog$isDebugOrLocalTest$2.INSTANCE);
    }

    public static void a(String r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L15;
        dm.a.b r1 = dm.a.a;     // Catch: Exception -> L10
        dm.a.b r4 = dm.a.a("card_list_log_".concat(r2));     // Catch: Exception -> L10
        String r5 = (String) r3.invoke();     // Catch: Exception -> L10
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r4.a(r5);     // Catch: Exception -> L10
        return;
    }
}
