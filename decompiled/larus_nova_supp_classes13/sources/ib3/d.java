package ib3;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.cart_common.repo.CartCommonRepository;
import com.bytedance.keva.Keva;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.b {
    public d() {
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
        Object r9 = r8.get("value");
    L14:
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L24;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "key is empty", null, null, 57);
    L24:
        if (Intrinsics.areEqual(r3, "history_words") == false) goto L41;
        Keva r0 = CartCommonRepository.a;
        if ((r9 instanceof List) == true) goto L28;
        r9 = null;
    L28:
        List r11 = (List) r9;
        if (r11 == null) goto L31;
        List r12 = CollectionsKt.toList(r11);
    L32:
        Keva r1 = CartCommonRepository.a;
        if (r12 == null) goto L39;
        Object[] r13 = r12.toArray(new String[0]);
        if (r13 == null) goto L38;
        String[] r14 = (String[]) r13;
    L40:
        r1.storeStringArray("search_history", r14);
    L42:
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L39:
        r14 = new String[0];
        goto L40
    L31:
        r12 = null;
        goto L32
    L41:
        Keva r5 = CartCommonRepository.a;
        Intrinsics.checkNotNullParameter(r3, "key");
        CartCommonRepository.b.storeString(r3, u0.d(r9));
        goto L42
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
