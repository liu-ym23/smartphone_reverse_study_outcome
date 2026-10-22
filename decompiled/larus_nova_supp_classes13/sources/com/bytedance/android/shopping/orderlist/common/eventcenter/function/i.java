package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.content.Context;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.kmp.ec.yata.event.common.b {
    public final int a;
    public final int b;
    public final int c;
    public Function0<Unit> d;
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a e;
    public final Context f;
    public final AndroidYaTaInstance g;

    public static final class a {
        public final Map<String, Object> a;
        public final String b;
        public final String c;
        public final int d;
        public final int e;

        public a(Map<String, ? extends Object> r2, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "fields");
            Intrinsics.checkNotNullParameter(r3, "name");
            Intrinsics.checkNotNullParameter(r4, "eventName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r8) {
        Intrinsics.checkNotNullParameter(r8, "input");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new Pair(Boolean.TRUE, null);
        OrderCommonErrorMonitorKt.c(this.e.E0(), "OrderCommonOrderShowMoreMenuFunction-doExecuteSync", new OrderCommonOrderShowMoreMenuFunction$onExecuteSync$1(this, r8, r0));
        if (((Boolean) ((Pair) r0.element).getFirst()).booleanValue() == false) goto L5;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, (String) ((Pair) r0.element).getSecond(), null, null, 57);
    }

    public i(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r2, Context r3, AndroidYaTaInstance r4) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = com.bytedance.android.shopping.extensions.b.b(104);
        this.b = com.bytedance.android.shopping.extensions.b.b(44);
        this.c = 2;
    }
}
