package ib3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.cart_common.repo.CartCommonRepository;
import com.bytedance.keva.Keva;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.b {
    public c() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r8 = r7.q();
        if (r8 == null) goto L5;
        Object r2 = r8.get("key");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r8 == null) goto L12;
        Object r9 = r8.get("default_value");
    L14:
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L24;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "key is empty", null, null, 57);
    L24:
        if (Intrinsics.areEqual(r3, "history_words") == false) goto L30;
        String[] r11 = CartCommonRepository.a.getStringArray("search_history", new String[0]);
        if (r11 == null) goto L29;
        r9 = ArraysKt.toList(r11);
        if (r9 == null) goto L29;
    L39:
        int r0 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("value", r9)), null, 5);
    L29:
        r9 = CollectionsKt.emptyList();
        goto L39
    L30:
        Keva r5 = CartCommonRepository.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        r9 = u0.b(CartCommonRepository.b.getString(r3, u0.d(r9)), Object.class);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        bg3.a r6 = com.bytedance.android.shopping.new_cart.utils.a.a;
        StringBuilder r12 = new StringBuilder();
        r12.append(th.getMessage());
        r12.append('-');
        Throwable r13 = th.getCause();
        if (r13 == null) goto L37;
        String r14 = r13.getMessage();
    L38:
        r12.append(r14);
        com.bytedance.android.shopping.new_cart.utils.a.j("selfGetStorage", r12.toString(), null, 12);
        ECExceptionMonitor.e(th);
        goto L39
    L37:
        r14 = null;
        goto L38
    L16:
        if (r3.length() == 0) goto L19;
        r4 = false;
        goto L20
    L12:
        r9 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
