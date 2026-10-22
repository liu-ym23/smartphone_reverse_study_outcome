package com.bytedance.android.shopping.yata.business.function;

import com.bytedance.android.shopping.yata.business.function.common.RegexCheck;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public e(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r11) {
        Intrinsics.checkNotNullParameter(r11, "input");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        Map r1 = this.a.c().a(r11);
        if (r1 == null) goto L5;
        Object r2 = r1.get("filter_key");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        r0.element = (String) r2;
        if (this.a.d().b((String) r0.element) == false) goto L12;
        r0.element = "__validate_conf__";
    L12:
        List r3 = CollectionsKt.sortedWith(this.a.c().d(new SelfMultiRegexCheckFunction$onExecuteSync$matchedNodes$1(r0)), new f(this, r0));
        if (r3 == null) goto L21;
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L21;
        com.bytedance.kmp.ec.yata.store.node.c r5 = (com.bytedance.kmp.ec.yata.store.node.c) r4.next();
        String r9 = r5.getKey();
        this.a.c().getClass();
        Intrinsics.checkNotNullParameter(r5, "renderObject");
        Map<String, ? extends Object> r7 = r5.e();
        List r6 = (List) this.a.d().a(r7, ((String) r0.element) + ".validate_rules", CollectionsKt.emptyList());
        int r8 = RegexCheck.a;
        if (this.a.d().b(Boolean.valueOf(RegexCheck.a("selfMultiRegexCheck", this.a, r6, r7, r11, r9))) == false) goto L16;
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "no match", null, null, 57);
    L21:
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r2 = null;
        goto L7
    }
}
