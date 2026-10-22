package com.bytedance.android.shopping.api.mall.common.tools;

import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallBehaviorUtil {
    public static final Lazy a = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MallBehaviorInjectCheckParam(pageName=" + this.a + ", cardSchema=" + this.b + ")";
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "pageName");
            Intrinsics.checkNotNullParameter(r3, "cardSchema");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = LazyKt.lazy(MallBehaviorUtil$elementSetting$2.INSTANCE);
    }

    public static List a(a r12) {
        Intrinsics.checkNotNullParameter(r12, "param");
        ArrayList r0 = new ArrayList();
        String r1 = r12.b;
        Intrinsics.checkNotNullParameter(r1, "schema");
        ArrayList r2 = new ArrayList();
        r2.addAll(CommonUtilKt.a(r1));
        r2.add(new com.bytedance.android.ec.hybrid.list.util.b());
        r2.add(new com.bytedance.android.ec.hybrid.list.util.a());
        int r3 = jk.a.a;
        r0.addAll(r2);
        Intrinsics.checkNotNullParameter(r12, "params");
        ArrayList r4 = new ArrayList();
        Lazy r5 = a;
        com.bytedance.android.shopping.api.mall.opt.d r6 = (com.bytedance.android.shopping.api.mall.opt.d) r5.getValue();
        if (r6 == null) goto L11;
        List<String> r7 = r6.b();
        if (r7 == null) goto L11;
        if (r7.contains(r12.a) != true) goto L11;
        com.bytedance.android.ec.hybrid.card.util.h r8 = CommonUtilKt.b();
        if (r8 == null) goto L11;
        r4.add(r8);
    L11:
        com.bytedance.android.shopping.api.mall.opt.d r9 = (com.bytedance.android.shopping.api.mall.opt.d) r5.getValue();
        if (r9 == null) goto L18;
        List<String> r10 = r9.c();
        if (r10 == null) goto L18;
        if (r10.contains(r12.a) != true) goto L18;
        int r11 = bk.c.a;
    L18:
        r0.addAll(r4);
        Lazy r13 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.g.b, "inject xElement is " + CollectionsKt.joinToString$default(r0, "_", null, null, 0, null, null, 62, null) + ", pageName: " + r12.a + ", card is " + r12.b);
        return r0;
    }
}
