package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.ec.hybrid.list.ability.x;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements x {
    public final a.C0081a a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.feed.ability.d$a$a, reason: collision with other inner class name */
        public static final class C0081a {
            public final String a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0081a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((C0081a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "MallEnginLynxCardHelpParams(pageName=" + this.a + ")";
            }

            public C0081a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "pageName");
                this.a = r2;
            }
        }
    }

    static {
    }

    public d(a.C0081a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = r2;
    }

    public final List<Object> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "cardSchema");
        Lazy r0 = MallBehaviorUtil.a;
        a.C0081a r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "schema");
        return MallBehaviorUtil.a(new MallBehaviorUtil.a(r1.a, r3));
    }
}
