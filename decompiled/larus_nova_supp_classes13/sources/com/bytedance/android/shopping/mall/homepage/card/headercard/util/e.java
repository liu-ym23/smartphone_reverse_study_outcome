package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static /* synthetic */ void b(com.bytedance.android.shopping.mall.homepage.card.headercard.a r6, String r7, String r8, Map r9, Map r10) {
        a(r6, r7, r8, r9, r10, null);
    }

    public static final void a(final com.bytedance.android.shopping.mall.homepage.card.headercard.a r8, final String r9, final String r10, final Map r11, final Map r12, final Map r13) {
        Intrinsics.checkNotNullParameter(r8, "$this$reportEvent");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "btm");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "globalProps");
        kk.d.c(new ReporterKt$reportEvent$1(r8, r9, r10, r11, r12, r13));
    }
}
