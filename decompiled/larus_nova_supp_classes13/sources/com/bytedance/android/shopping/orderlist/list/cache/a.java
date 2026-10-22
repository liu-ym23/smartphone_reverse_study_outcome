package com.bytedance.android.shopping.orderlist.list.cache;

import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.kmp.ec.yata.common.protocol.utils.a {
    public final /* synthetic */ OrderCacheManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.IntRef c;

    public final p a(String r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "nodeKey");
        if (Intrinsics.areEqual(this.b, this.a.b) == false) goto L8;
        if (r3 == null) goto L7;
        r3.i();
        return r3;
    L7:
        return null;
    L8:
        return null;
    }

    public a(OrderCacheManager r1, String r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final com.bytedance.kmp.ec.yata.common.protocol.utils.a.a b(String r4, String r5, p r6) {
        Intrinsics.checkNotNullParameter(r4, "nodeKey");
        boolean r0 = false;
        if (Intrinsics.areEqual(this.b, this.a.b) == false) goto L25;
        boolean r7 = CollectionsKt.contains(this.a.a.getNodeBlackList(), r5);
        Object r8 = null;
        if (r6 == null) goto L12;
        Object r9 = q.b(r6, Reflection.getOrCreateKotlinClass(Boolean.class), "y_card_tail");
        if ((r9 instanceof Boolean) == false) goto L10;
        r8 = r9;
    L10:
        r8 = (Boolean) r8;
    L12:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L15;
        this.c.element++;
    L15:
        if (this.c.element < this.a.a.getCacheOrderCount()) goto L17;
        boolean r10 = true;
    L19:
        if (r7 == true) goto L23;
        if (r10 == true) goto L23;
        r0 = true;
    L23:
        return new com.bytedance.kmp.ec.yata.common.protocol.utils.a.a(r0, r10);
    L17:
        r10 = false;
        goto L19
    L25:
        return new com.bytedance.kmp.ec.yata.common.protocol.utils.a.a(false, false);
    }
}
