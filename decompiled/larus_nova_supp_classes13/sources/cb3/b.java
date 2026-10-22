package cb3;

import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.facebook.imagepipeline.common.Priority;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Pair r12) {
        if (r12 == null) goto L5;
        LauncherBizType r1 = (LauncherBizType) r12.getFirst();
    L7:
        if (r1 != LauncherBizType.CART) goto L40;
        e r13 = (e) r12.getSecond();
        if (r13 == null) goto L50;
        c r14 = r13.g();
        if (r14 == null) goto L51;
        Map r15 = r14.getData();
        if (r15 == null) goto L52;
        Collection r16 = r15.values();
        if (r16 == null) goto L53;
        Iterator r17 = r16.iterator();
        int r2 = 0;
    L18:
        if (r17.hasNext() == false) goto L54;
        p r3 = (p) r17.next();
        if (r2 >= 5) goto L18;
        if (Intrinsics.areEqual(q.c(r3), "product_card") == false) goto L18;
        Map r4 = r3.h();
        if (r4 == null) goto L26;
        Object r5 = r4.get("basic_info");
    L27:
        Map r6 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r5);
        if (r6 == null) goto L30;
        Object r7 = r6.get("spec_pic");
    L32:
        if ((r7 instanceof String) == true) goto L34;
        r7 = null;
    L34:
        String r8 = (String) r7;
        String r9 = a2.d("ec_cart_product_cover");
        if (r9 != null) goto L37;
        r9 = "unknown";
    L37:
        r r10 = new r("ec_cart", r9);
        r2 = r2 + 1;
        if (r8 == null) goto L18;
        ImageExtensionsKt.B(r8, r10, null, null, Priority.IMMEDIATE, null, null, false, 192);
        goto L18
    L30:
        r7 = null;
        goto L32
    L26:
        r5 = null;
        goto L27
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L40:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
